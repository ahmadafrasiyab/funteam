package com.example.funteam;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {


    //////////////////////////////////////////////////////
    private TabLayout tabLayout;
    //private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    ////////////////////////////////////////////////////

    String firstNameString;
    String lastNameString;
    String userNameString;
    String emailString;
    ////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //////////////////////////////////////////////////////
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);

        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ////Adding Fragments
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());


        Bundle bundle = new Bundle();

        firstNameString = getIntent().getExtras().getString("value1");
        lastNameString = getIntent().getExtras().getString("value2");
        userNameString = getIntent().getExtras().getString("value3");
        emailString = getIntent().getExtras().getString("value4");

        bundle.putString("data1", firstNameString);
        bundle.putString("data2", lastNameString);
        bundle.putString("data3", userNameString);
        bundle.putString("data4", emailString);


        adapter.AddFragment(new GroupsFragment(), "GROUPS");
        adapter.AddFragment(new ProfileFragment(), "PROFILE");
        adapter.AddFragment(new SettingsFragment(), "SETTINGS");


        //Adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
