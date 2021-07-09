package com.farisalchaula.myapplication.pembeli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.farisalchaula.myapplication.R;
import com.farisalchaula.myapplication.server.BaseURL;
import com.squareup.picasso.Picasso;

public class DetailArtist extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    EditText edtArtistCode, edtArtistName, edtWorkDays, edtWorkProgress, edtEmail;
    ImageView imgGambarBuku;
    Button btnCommission;

    String strArtistCode, strArtistName, strWorkDays, strWorkProgress, strEmail, strImage, _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artist);

        getSupportActionBar().hide();

        edtArtistCode = (EditText) findViewById(R.id.edtArtistCode3);
        edtArtistName = (EditText) findViewById(R.id.edtArtistName3);
        edtWorkDays = (EditText) findViewById(R.id.edtWorkDays3);
        edtWorkProgress = (EditText) findViewById(R.id.edtWorkProgress3);
        edtEmail = (EditText) findViewById(R.id.edtEmail3);

        imgGambarBuku = (ImageView) findViewById(R.id.gambar);

        btnCommission = (Button) findViewById(R.id.btnCommission);

        Intent i = getIntent();
        strArtistCode = i.getStringExtra("artistCode");
        strArtistName = i.getStringExtra("artistName");
        strWorkDays = i.getStringExtra("workDays");
        strWorkProgress = i.getStringExtra("workProgress");
        strEmail = i.getStringExtra("email");
        strImage = i.getStringExtra("commissionSheet");
        _id = i.getStringExtra("_id");

        edtArtistCode.setText(strArtistCode);
        edtArtistName.setText(strArtistName);
        edtWorkDays.setText(strWorkDays);
        edtWorkProgress.setText(strWorkProgress);
        edtEmail.setText(strEmail);
        Picasso.get().load(BaseURL.baseUrl + "image/" + strImage)
                .into(imgGambarBuku);

        btnCommission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailArtist.this, Commission.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemWishlist:
                Toast.makeText(this, "Wishlisted", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemReport:
                Toast.makeText(this, "Reported", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}
