package com.example.kamus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class SpesifikasiActivity extends AppCompatActivity {
    Button btnDataUser, btnDataProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spesifikasi);

        btnDataProduk = findViewById(R.id.btnDataProduk);
        btnDataUser = findViewById(R.id.btnDataUser);

        btnDataUser.setOnClickListener(v -> {
            Intent intent = new Intent(this, KamusDataActivity.class);
            intent.putExtra("extraData", "darat");
            startActivity(intent);
        });

        btnDataProduk.setOnClickListener(v -> {
            Intent intent = new Intent(this, KamusDataActivity.class);
            intent.putExtra("extraData", "laut");
            startActivity(intent);
        });
    }
}