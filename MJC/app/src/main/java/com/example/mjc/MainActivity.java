package com.example.mjc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {


    private TextView tv_ID,tv_Password,tv_Name,tv_Address;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        tv_ID = findViewById(R.id.tv_ID);
        tv_Password = findViewById(R.id.tv_Password);
        tv_Name = findViewById(R.id.tv_Address);
        tv_Address = findViewById(R.id.tv_Name);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPassword = intent.getStringExtra("userPassword");
        String userName = intent.getStringExtra("userName");
        String userAddress = intent.getStringExtra("userAddress");

        tv_ID.setText(userID);
        tv_Address.setText(userAddress);
        tv_Name.setText(userName);
        tv_Password.setText(userPassword);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        setContentView(R.layout.activity_main);

      
    }

}