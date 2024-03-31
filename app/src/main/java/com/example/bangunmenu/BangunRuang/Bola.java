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

public class Bola extends AppCompatActivity {

    EditText EtJariJari;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bola);

        EtJariJari = findViewById(R.id.editTextJari);
        btnHitung = findViewById(R.id.buttonHitungB);

        ImageView imageView = findViewById(R.id.imageView);
        String imageUrl = "https://4.bp.blogspot.com/-NhfrTgVD8xg/VM0K2ezNTPI/AAAAAAAAARs/cnZf0XxCi38/s1600/bola.jpg";

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
                String inputJariJari = EtJariJari.getText().toString().trim();

                if (inputJariJari.isEmpty()) {
                    Toast.makeText(Bola.this, "Masukkan jari-jari terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }

                double jariJari = Double.parseDouble(inputJariJari);

                double luas = 4 * Math.PI * Math.pow(jariJari, 2);

                String hasil = "Luas : " + luas;
                Toast.makeText(Bola.this, hasil, Toast.LENGTH_SHORT).show();

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