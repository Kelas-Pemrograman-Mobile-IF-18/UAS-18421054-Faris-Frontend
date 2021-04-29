package com.farisalchaula.myapplication.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.farisalchaula.myapplication.R;

public class HomeAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        getSupportActionBar().hide();
    }
}
