package com.example.kamus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class SpesifikasiActivity extends AppCompatActivity {
    Button btnVertebrata, btnInvertebrata;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spesifikasi);

        btnVertebrata = findViewById(R.id.btnvertebrata);
        btnInvertebrata = findViewById(R.id.btninvertebrata);

        btnVertebrata.setOnClickListener(v -> {
            Intent intent = new Intent(this, KamusDataActivity.class);
            intent.putExtra("extraData", "vertebrata");
            startActivity(intent);
        });

        btnInvertebrata.setOnClickListener(v -> {
            Intent intent = new Intent(this, KamusDataActivity.class);
            intent.putExtra("extraData", "invertebrata");
            startActivity(intent);
        });
    }
}