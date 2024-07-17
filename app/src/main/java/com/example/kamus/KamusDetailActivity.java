package com.example.kamus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kamus.Api.ApiClient;
import com.example.kamus.Api.ApiInterface;

public class KamusDetailActivity extends AppCompatActivity {

    TextView edtName, edtPrice;
    ImageView imgHolder;
    String ID;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamus_detail);


        // Identifikasi Komponen Form
        edtName = (TextView) findViewById(R.id.edt_name);
        edtPrice = (TextView) findViewById(R.id.edt_price);
        imgHolder = (ImageView) findViewById(R.id.imgHolder);

        // Identifikasi intent ke Komponen Form
        Intent mIntent = getIntent();
        ID = mIntent.getStringExtra("Id");
        edtName.setText(mIntent.getStringExtra("Name"));
        edtPrice.setText(mIntent.getStringExtra("Price"));

        // Masukan Gambar Ke Image View Gunakan Glide
        Glide.with(KamusDetailActivity.this)
                .load(Config.IMAGES_URL + mIntent.getStringExtra("Image"))
                .apply(new RequestOptions().override(550, 550))
                .into(imgHolder);

        // Definisi API
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

    }

}