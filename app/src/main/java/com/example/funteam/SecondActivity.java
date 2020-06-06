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

        //private AppBarLayout appBarLayout;
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ////Adding Fragments
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());


        Bundle bundle = new Bundle();

        firstNameString = getIntent().getExtras().getString(getString(R.string.value1));
        lastNameString = getIntent().getExtras().getString(getString(R.string.value2));
        userNameString = getIntent().getExtras().getString(getString(R.string.value3));
        emailString = getIntent().getExtras().getString(getString(R.string.value4));

        bundle.putString(getString(R.string.data_1), firstNameString);
        bundle.putString(getString(R.string.data_1), lastNameString);
        bundle.putString(getString(R.string.data_1), userNameString);
        bundle.putString(getString(R.string.data_1), emailString);


        adapter.AddFragment(new GroupsFragment(), "GROUPS");
        adapter.AddFragment(new ProfileFragment(), "PROFILE");
        adapter.AddFragment(new SettingsFragment(), "SETTINGS");


        //Adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}