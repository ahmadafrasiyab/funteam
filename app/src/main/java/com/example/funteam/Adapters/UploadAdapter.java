package com.example.funteam.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funteam.Models.AllMethods;
import com.example.funteam.Models.Message;
import com.example.funteam.Models.Upload;
import com.example.funteam.R;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;


import java.util.List;


public class UploadAdapter extends RecyclerView.Adapter<UploadAdapter.UploadAdapterViewHolder>
{
    Context context;
    List<Upload> uploads;
    DatabaseReference uploadDatabase;

    public UploadAdapter (Context context, List<Upload> uploads, DatabaseReference uploadDatabase){
        this.context = context;
        this.uploadDatabase = uploadDatabase;
        this.uploads = uploads;
    }

    @NonNull
    @Override
    public UploadAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image,parent,false);
        return new UploadAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UploadAdapterViewHolder holder, int position) {
        //Upload upload = uploads.get(position);
        /*if(upload.getName().equals(AllMethods.name)){
            holder.textViewTitle.setText(context.getString(R.string.you) + upload.getImageUrl());
            holder.textViewTitle.setGravity(Gravity.START);
            holder.linearLayout.setBackgroundColor(Color.parseColor(context.getString(R.string.colorName)));
        }
        else{*/

            //Picasso.get().load(uploads.get(position).getImageUrl()).into(holder.imageView);
            //holder.imageView.setText(upload.getImageUrl());
            //holder.imageButtonDelete.setVisibility(View.GONE);

       // }

    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    public class UploadAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        //ImageButton imageButtonDelete;
        LinearLayout linearLayout;


        public UploadAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.chat_image_view);
           // imageButtonDelete = (ImageButton) itemView.findViewById(R.id.imageButtonDelete);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.imageLin);




            /*imageButtonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uploadDatabase.child(uploads.get(getAdapterPosition()).getName()).removeValue();
                }
            });*/
        }
    }
}
