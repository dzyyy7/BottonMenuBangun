package com.example.bangunmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bangunmenu.fragment.DatarFragment;
import com.example.bangunmenu.fragment.ProfileFragment;
import com.example.bangunmenu.fragment.RuangFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new DatarFragment())
                .commit();
    }
    private BottomNavigationView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    if (item.getItemId() == R.id.BangunDatar) {
                        selectedFragment = new DatarFragment();
                    } else if (item.getItemId() == R.id.BangunRuang) {
                        selectedFragment = new RuangFragment();
                    } else if (item.getItemId() == R.id.Profile) {
                        selectedFragment = new ProfileFragment();
                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, selectedFragment)
                            .commit();

                    return true;
                }
            };
}