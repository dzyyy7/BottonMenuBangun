package com.example.bangunmenu.BangunRuang;

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

public class Balok extends AppCompatActivity {

    EditText EtPanjang, EtLebar, EtTinggi;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balok);

        EtPanjang = findViewById(R.id.editTextP);
        EtLebar = findViewById(R.id.editTextL);
        EtTinggi = findViewById(R.id.editTextT);
        btnHitung = findViewById(R.id.buttonHitung);

        ImageView imageView = findViewById(R.id.imageView);
        String imageUrl = "https://pulpent.com/wp-content/uploads/2021/07/Gambar-Balok-1.jpg";

        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungluasalah();
            }

            private void hitungluasalah() {
                String inputPanjang = EtPanjang.getText().toString().trim();
                String inputLebar = EtLebar.getText().toString().trim();
                String inputTinggi = EtTinggi.getText().toString().trim();

                if (inputPanjang.isEmpty() || inputLebar.isEmpty() || inputTinggi.isEmpty()) {
                    Toast.makeText(Balok.this, "Masukkan semua nilai terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }

                double panjang = Double.parseDouble(inputPanjang);
                double lebar = Double.parseDouble(inputLebar);
                double tinggi = Double.parseDouble(inputTinggi);

                double luas = 2 * (panjang * lebar + lebar * tinggi + panjang * tinggi);

                String hasil = "Luas : " + luas;
                Toast.makeText(Balok.this, hasil, Toast.LENGTH_SHORT).show();

                TextView textViewHasil = findViewById(R.id.textViewHasil);
                textViewHasil.setText(hasil);
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
}