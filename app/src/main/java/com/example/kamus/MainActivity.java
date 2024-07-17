package com.example.kamus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btnDataUser, btnDataProduk, btnDataPesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDataPesanan = findViewById(R.id.btnDataPesanan);
        btnDataProduk = findViewById(R.id.btnDataProduk);
        btnDataUser = findViewById(R.id.btnDataUser);

        btnDataUser.setOnClickListener(v -> {
            Intent intent = new Intent(this, KamusDataActivity.class);
            startActivity(intent);
        });
//
//        btnDataProduk.setOnClickListener(v -> {
//            Intent intent = new Intent(this, ProdukDataActivity.class);
//            startActivity(intent);
//        });
//
//        btnDataPesanan.setOnClickListener(v -> {
//            Intent intent = new Intent(this, PesananDataActivity.class);
//            startActivity(intent);
//        });
    }
}