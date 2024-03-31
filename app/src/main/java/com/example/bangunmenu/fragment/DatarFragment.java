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
import com.example.bangunmenu.BangunDatar.Lingkaran;
import com.example.bangunmenu.Model;
import com.example.bangunmenu.BangunDatar.Persegi;
import com.example.bangunmenu.BangunDatar.PersegiPanjang;
import com.example.bangunmenu.R;
import com.example.bangunmenu.BangunDatar.Segitiga;

import java.util.ArrayList;
import java.util.List;

public class DatarFragment extends Fragment implements Adapter.ItemClickListener {

    RecyclerView BangunDatar;
    List<Model> listDataDatar;
    Adapter adapterListDatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_datar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BangunDatar = view.findViewById(R.id.RVbangunDatar);
        listDataDatar = new ArrayList<>();

        Model Persegi = new Model();
        Persegi.setNamaBangunn("Persegi");
        Persegi.setDeskBangun("Rumus : Sisi * Sisi");
        Persegi.setImageBangun("https://www.doyanblog.com/wp-content/uploads/2021/12/gambar-persegi.jpg");
        listDataDatar.add(Persegi);

        Model PersegiPanjang = new Model();
        PersegiPanjang.setNamaBangunn("Persegi Panjang");
        PersegiPanjang.setDeskBangun("Rumus : panjang * lebar");
        PersegiPanjang.setImageBangun("https://3.bp.blogspot.com/-ctEiHRztroM/VeQkciOaokI/AAAAAAAAAzc/wkUiUGBK3Cc/s1600/Persegi-panjang-zonanesia-798021.jpg");
        listDataDatar.add(PersegiPanjang);

        Model Lingkaran = new Model();
        Lingkaran.setNamaBangunn("Lingkaran");
        Lingkaran.setDeskBangun("Rumus : Pi * Jari-Jari^2");
        Lingkaran.setImageBangun("https://www.techknowtimes.com/wp-content/uploads/2016/09/Gambar-Lingkaran-460x460.jpg");
        listDataDatar.add(Lingkaran);

        Model Segitiga = new Model();
        Segitiga.setNamaBangunn("Segitiga");
        Segitiga.setDeskBangun("Rumus : 1/2 * a * t");
        Segitiga.setImageBangun("https://www.broexcel.com/wp-content/uploads/2016/09/Gambar-Segitiga-460x409.jpg");
        listDataDatar.add(Segitiga);

        BangunDatar.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterListDatar = new Adapter(listDataDatar, getContext());
        adapterListDatar.setClickListener(this);
        BangunDatar.setAdapter(adapterListDatar);
    }

    @Override
    public void onItemClick(View view, int position) {
        Model item = adapterListDatar.getItem(position);
        if (item.getNamaBangunn().equals("Persegi")) {
            Intent intent = new Intent(getActivity(), Persegi.class);
            startActivity(intent);
        } else if (item.getNamaBangunn().equals("Persegi Panjang")) {
            Intent intent = new Intent(getActivity(), PersegiPanjang.class);
            startActivity(intent);
        }else if (item.getNamaBangunn().equals("Lingkaran")) {
            Intent intent = new Intent(getActivity(), Lingkaran.class);
            startActivity(intent);
        }else if (item.getNamaBangunn().equals("Segitiga")) {
            Intent intent = new Intent(getActivity(), Segitiga.class);
            startActivity(intent);
        }
    }
}