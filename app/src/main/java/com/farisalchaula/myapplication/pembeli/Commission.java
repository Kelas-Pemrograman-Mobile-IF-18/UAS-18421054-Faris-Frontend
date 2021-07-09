package com.farisalchaula.myapplication.pembeli;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.farisalchaula.myapplication.R;

public class Commission extends AppCompatActivity {

    CheckBox chkBg;
    Button btnSend;
    EditText edtBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commission);

        getSupportActionBar().hide();

        Spinner sprComType = findViewById(R.id.sprComType);
        Spinner sprPayment = findViewById(R.id.sprPayment);
        chkBg = (CheckBox) findViewById(R.id.chkBg);
        btnSend = (Button) findViewById(R.id.btnSend);
        edtBg = (EditText) findViewById(R.id.edtBg);

        ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this, R.array.types, android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprComType.setAdapter(adapterType);

        ArrayAdapter<CharSequence> adapterPay = ArrayAdapter.createFromResource(this, R.array.payment, android.R.layout.simple_spinner_item);
        adapterPay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprPayment.setAdapter(adapterPay);

        if (chkBg.isChecked()){
            edtBg.setVisibility(View.VISIBLE);
        }

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your request has been sent", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Commission.this, HomePembeli.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Commission.this);

        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to cancel your commission ? ");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                Intent i = new Intent(Commission.this, HomePembeli.class);
                startActivity(i);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }
}
