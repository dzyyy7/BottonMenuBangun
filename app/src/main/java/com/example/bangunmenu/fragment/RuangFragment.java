package com.example.bangunmenu.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bangunmenu.Adapter;
import com.example.bangunmenu.BangunRuang.Balok;
import com.example.bangunmenu.BangunRuang.Bola;
import com.example.bangunmenu.BangunRuang.Kubus;
import com.example.bangunmenu.Model;
import com.example.bangunmenu.R;

import java.util.ArrayList;
import java.util.List;

public class RuangFragment extends Fragment implements Adapter.ItemClickListener {

    RecyclerView BangunRuang;
    List<Model> listDataRuang;
    Adapter adapterListRuang;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ruang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BangunRuang = view.findViewById(R.id.RVbangunruang);
        listDataRuang = new ArrayList<>();

        Model Kubus = new Model();
        Kubus.setNamaBangunn("Kubus");
        Kubus.setDeskBangun("Rumus : 6 * Sisi^2");
        Kubus.setImageBangun("https://i2.wp.com/www.mahirmatematika.com/wp-content/uploads/2018/08/kubus.jpg?fit=444%2C409&ssl=1");
        listDataRuang.add(Kubus);

        Model Balok = new Model();
        Balok.setNamaBangunn("Balok");
        Balok.setDeskBangun("Rumus : 2 * (Panjang * Lebar)+(Lebar * Tinggi)+(Panjang * Tingi)");
        Balok.setImageBangun("https://pulpent.com/wp-content/uploads/2021/07/Gambar-Balok-1.jpg");
        listDataRuang.add(Balok);

        Model Bola = new Model();
        Bola.setNamaBangunn("Bola");
        Bola.setDeskBangun("Rumus : 4 * Pi * Jari-Jari^2");
        Bola.setImageBangun("https://4.bp.blogspot.com/-NhfrTgVD8xg/VM0K2ezNTPI/AAAAAAAAARs/cnZf0XxCi38/s1600/bola.jpg");
        listDataRuang.add(Bola);

        BangunRuang.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterListRuang = new Adapter(listDataRuang, getContext());
        adapterListRuang.setClickListener(this);
        BangunRuang.setAdapter(adapterListRuang);
    }

    @Override
    public void onItemClick(View view, int position) {
        Model item = adapterListRuang.getItem(position);
        if (item.getNamaBangunn().equals("Kubus")) {
            Intent intent = new Intent(getActivity(), Kubus.class);
            startActivity(intent);
        } else if (item.getNamaBangunn().equals("Balok")) {
            Intent intent = new Intent(getActivity(), Balok.class);
            startActivity(intent);
        }else if (item.getNamaBangunn().equals("Bola")) {
            Intent intent = new Intent(getActivity(), Bola.class);
            startActivity(intent);
        }
    }
}