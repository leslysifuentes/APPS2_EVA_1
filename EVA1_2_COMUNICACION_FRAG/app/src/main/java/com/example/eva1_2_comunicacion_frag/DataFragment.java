package com.example.eva1_2_comunicacion_frag;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DataFragment extends Fragment {
    TextView tv_datos;
    MainActivity mainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.fragment_data, container, false);
        Button b_datos = linearLayout.findViewById(R.id.b_data);
        tv_datos = linearLayout.findViewById(R.id.tv_datos);
        b_datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onMessageFromFragToMain("Data", "Mensaje del frag de datos");
            }
        });
        return linearLayout;
    }


    //interfaz de comunicación
    public void onMessageFromMainToFrag(String param){
        tv_datos.setText(param);
    }
}