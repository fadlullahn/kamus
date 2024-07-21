package com.example.kamus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btnKamus, btnPencarian, btnSpesifikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKamus = findViewById(R.id.btnKamus);
        btnPencarian = findViewById(R.id.btnPencarian);
        btnSpesifikasi = findViewById(R.id.btnSpesifikasi);

        btnKamus.setOnClickListener(v -> {
            Intent intent = new Intent(this, KamusDataActivity.class);
            startActivity(intent);
        });

        btnPencarian.setOnClickListener(v -> {
            Intent intent = new Intent(this, PencarianActivity.class);
            startActivity(intent);
        });

        btnSpesifikasi.setOnClickListener(v -> {
            Intent intent = new Intent(this, SpesifikasiActivity.class);
            startActivity(intent);
        });
    }
}