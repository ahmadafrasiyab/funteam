package com.example.funteam;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
    }
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container,false);
        TextView t1 = (TextView) view.findViewById(R.id.userFirstName);
        TextView t2 = (TextView) view.findViewById(R.id.userLastName);
        TextView t3 = (TextView) view.findViewById(R.id.userUserName);
        TextView t4 = (TextView) view.findViewById(R.id.userEmail);

        Bundle arguments = getArguments();
        assert arguments != null;
        String data1Argument = arguments.getString(getString(R.string.data_1));
        String data2Argument = arguments.getString(getString(R.string.data_2));
        String data3Argument = arguments.getString(getString(R.string.data_3));
        String data4Argument = arguments.getString(getString(R.string.data_4));

        t1.setText(data1Argument);
        t2.setText(data2Argument);
        t3.setText(data3Argument);
        t4.setText(data4Argument);
        return view;
    }
}