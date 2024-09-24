package com.jago.mcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * Website (https://mcsdeveloper.org/).
 * Developed by MCS Developer
 * 14/8/2021
 */

public class loginandregister extends AppCompatActivity {

    Button mButton1;
    Button mButton2;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String[] urls = new String[2];
    private PrefLogin prefLogin;
    private PrefDaftar prefDaftar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loginandregister);


        mButton1 = findViewById(R.id.Link1);
        mButton2 = findViewById(R.id.Link2);

        urls[0]="https://www.pasukan.id"; // button mendaftar
        urls[1]="https://www.pasukan.id"; // button login


        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen2();

            }
        });

        // mengecek lauch activity - sebelum memanggil setContentView()
        prefDaftar = new PrefDaftar(this);
        if (!prefDaftar.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }

        // mengecek lauch activity - sebelum memanggil setContentView()
        prefLogin = new PrefLogin(this);
        if (!prefLogin.isFirstTimeLaunch()) {
            launchHomeScreen2();
            finish();
        }
    }

    private void launchHomeScreen() {
        prefDaftar.setFirstTimeLaunch(false);
        startActivity(new Intent(loginandregister.this, webActivity.class));
        finish();
    }

    private void launchHomeScreen2() {
        prefLogin.setFirstTimeLaunch(false);
        startActivity(new Intent(loginandregister.this, MainActivity.class));
        finish();
    }

}