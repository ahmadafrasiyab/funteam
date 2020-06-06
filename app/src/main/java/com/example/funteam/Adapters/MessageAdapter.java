package com.example.funteam.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funteam.Models.AllMethods;
import com.example.funteam.Models.Message;
import com.example.funteam.R;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageAdapterViewHolder>
{
    Context context;
    List<Message> messages;
    DatabaseReference messageDatabase;

    public MessageAdapter (Context context, List<Message> messages, DatabaseReference messageDatabase){
        this.context = context;
        this.messageDatabase = messageDatabase;
        this.messages = messages;
        }

    @NonNull
    @Override
    public MessageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message,parent,false);
        return new MessageAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapterViewHolder holder, int position) {
        Message message = messages.get(position);
        if(message.getName().equals(AllMethods.name)){
            holder.textViewTitle.setText("You " + message.getMessage());
            holder.textViewTitle.setGravity(Gravity.START);
            holder.linearLayout.setBackgroundColor(Color.parseColor("#EF9E73"));
        }
        else{
            holder.textViewTitle.setText(message.getName() + ":" + message.getMessage());
            holder.imageButtonDelete.setVisibility(View.GONE);

        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MessageAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageButton imageButtonDelete;
        LinearLayout linearLayout;


        public MessageAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            imageButtonDelete = (ImageButton) itemView.findViewById(R.id.imageButtonDelete);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.line1Message);




            imageButtonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    messageDatabase.child(messages.get(getAdapterPosition()).getKey()).removeValue();
                }
            });
        }
    }
}
