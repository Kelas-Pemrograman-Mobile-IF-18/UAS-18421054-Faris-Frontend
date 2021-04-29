package com.farisalchaula.myapplication.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.farisalchaula.myapplication.R;
import com.farisalchaula.myapplication.admin.HomeAdminActivity;
import com.ornach.nobobutton.NoboButton;

public class LoginActivity extends AppCompatActivity {

    Button btnRegisterPage;
    NoboButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegisterPage = (Button) findViewById(R.id.btnRegisterPage);
        btnLogin = (NoboButton) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, HomeAdminActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnRegisterPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();

            }
        });

        getSupportActionBar().hide();
    }
}
