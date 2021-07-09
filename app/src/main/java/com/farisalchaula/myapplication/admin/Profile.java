package com.farisalchaula.myapplication.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.farisalchaula.myapplication.R;
import com.farisalchaula.myapplication.session.PrefSetting;

public class Profile extends AppCompatActivity {

    TextView txtUserName, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Profile Admin");

        txtUserName = (TextView) findViewById(R.id.userName);
        txtEmail = (TextView) findViewById(R.id.email);

        txtUserName.setText(PrefSetting.username);
        txtEmail.setText(PrefSetting.email);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Profile.this, HomeAdminActivity.class);
        startActivity(i);
        finish();
    }
}
