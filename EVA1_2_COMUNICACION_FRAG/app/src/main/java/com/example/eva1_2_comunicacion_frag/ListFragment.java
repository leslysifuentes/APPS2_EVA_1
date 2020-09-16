package com.example.eva1_2_comunicacion_frag;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class ListFragment extends Fragment {
    String[] datos = {
            "Ene", "Feb", "Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic",
            "Ene", "Feb", "Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"
    };

    MainActivity mainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FrameLayout frameLayout = (FrameLayout)inflater.inflate(R.layout.fragment_list, container, false);
        ListView lista_datos;
        lista_datos = frameLayout.findViewById(R.id.lista_datos);
        lista_datos.setAdapter(new ArrayAdapter<>(mainActivity, android.R.layout.simple_list_item_1,datos));
        lista_datos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainActivity.onMessageFromFragToMain("Lista", datos[position]);
            }
        });

        return frameLayout;
    }
}