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

public class Lingkaran extends AppCompatActivity {

    EditText EtJari;
    Button btnHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lingkaran);

        EtJari = findViewById(R.id.editTextJari);
        btnHasil = findViewById(R.id.buttonHitungL);

        ImageView imageView = findViewById(R.id.imageView);
        String imageUrl = "https://www.techknowtimes.com/wp-content/uploads/2016/09/Gambar-Lingkaran-460x460.jpg";

        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungluasL();
            }

            private void hitungluasL() {
                String jarijari = EtJari.getText().toString().trim();

                if (jarijari.isEmpty()){
                    Toast.makeText(Lingkaran.this, "Masukkan Jari-Jari terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }
                double Jari = Double.parseDouble(jarijari);
                double luas = Math.PI * Jari * Jari;

                String hasil = "Luas : "+ luas;
                Toast.makeText(Lingkaran.this, hasil, Toast.LENGTH_SHORT).show();

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