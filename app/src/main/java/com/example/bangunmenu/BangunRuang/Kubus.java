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

public class Kubus extends AppCompatActivity {

    EditText EtSisi;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kubus);

        EtSisi = findViewById(R.id.editTextSisiK);
        btnHitung = findViewById(R.id.buttonHitung);

        ImageView imageView = findViewById(R.id.imageView);
        String imageUrl = "https://i2.wp.com/www.mahirmatematika.com/wp-content/uploads/2018/08/kubus.jpg?fit=444%2C409&ssl=1";

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
                    Toast.makeText(Kubus.this, "Masukkan Sisi terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }
                double sisi = Double.parseDouble(inputsisi);
                double luas = 6* Math.pow(sisi,2);

                String hasil = "Luas : "+ luas;
                Toast.makeText(Kubus.this, hasil, Toast.LENGTH_SHORT).show();

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