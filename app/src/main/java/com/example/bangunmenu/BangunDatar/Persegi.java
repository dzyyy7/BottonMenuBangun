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

public class Persegi extends AppCompatActivity {

    EditText EtSisi;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persegi);

        EtSisi = findViewById(R.id.editTextSisi);
        btnHitung = findViewById(R.id.buttonHitung);

        ImageView imageView = findViewById(R.id.imageView);
        String imageUrl = "https://www.doyanblog.com/wp-content/uploads/2021/12/gambar-persegi.jpg";

        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungluaskel();
            }

            private void hitungluaskel() {
                String inputsisi = EtSisi.getText().toString().trim();

                if (inputsisi.isEmpty()){
                    Toast.makeText(Persegi.this, "Masukkan Sisi terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }
                double sisi = Double.parseDouble(inputsisi);
                double luas = sisi * sisi;

                String hasil = "Luas : "+ luas;
                Toast.makeText(Persegi.this, hasil, Toast.LENGTH_SHORT).show();

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