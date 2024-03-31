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

public class PersegiPanjang extends AppCompatActivity {

    EditText etPanjang;
    EditText etLebar;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persegipanjang);

        etPanjang = findViewById(R.id.editTextP);
        etLebar = findViewById(R.id.editTextL);
        btnHitung = findViewById(R.id.buttonHitung);

        ImageView imageView = findViewById(R.id.imageView);
        String imageUrl = "https://3.bp.blogspot.com/-ctEiHRztroM/VeQkciOaokI/AAAAAAAAAzc/wkUiUGBK3Cc/s1600/Persegi-panjang-zonanesia-798021.jpg";

        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuasPersegiPanjang();
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
    private void hitungLuasPersegiPanjang() {
        String inputPanjang = etPanjang.getText().toString().trim();
        String inputLebar = etLebar.getText().toString().trim();

        if (inputPanjang.isEmpty() || inputLebar.isEmpty()) {
            Toast.makeText(this, "Masukkan panjang dan lebar terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        double panjang = Double.parseDouble(inputPanjang);
        double lebar = Double.parseDouble(inputLebar);
        double luas = panjang * lebar;

        String hasil = "Luas: " + luas;
        Toast.makeText(this, hasil, Toast.LENGTH_SHORT).show();

        TextView textViewHasil = findViewById(R.id.textViewHasil);
        textViewHasil.setText(hasil);
    }
}
