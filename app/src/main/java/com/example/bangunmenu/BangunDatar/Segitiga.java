package com.example.bangunmenu.BangunDatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bangunmenu.R;

public class Segitiga extends AppCompatActivity {

    EditText etAlas;
    EditText etTinggi;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segitiga);

        etAlas = findViewById(R.id.editTextA);
        etTinggi = findViewById(R.id.editTextT);
        btnHitung = findViewById(R.id.buttonHitung);

        ImageView imageView = findViewById(R.id.imageView);
        String imageUrl = "https://www.broexcel.com/wp-content/uploads/2016/09/Gambar-Segitiga-460x409.jpg";

        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuasSegitiga();
            }
        });
        Button btnKembali = findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void hitungLuasSegitiga() {
        String inputAlas = etAlas.getText().toString().trim();
        String inputTinggi = etAlas.getText().toString().trim();

        if (inputAlas.isEmpty() || inputTinggi.isEmpty()) {
            Toast.makeText(this, "Masukkan panjang dan lebar terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        double Alas = Double.parseDouble(inputAlas);
        double Tinggi = Double.parseDouble(inputTinggi);
        double luas = 0.5 * Alas * Tinggi;

        String hasil = "Luas: " + luas;
        Toast.makeText(this, hasil, Toast.LENGTH_SHORT).show();

        TextView textViewHasil = findViewById(R.id.textViewHasil);
        textViewHasil.setText(hasil);
    }
}