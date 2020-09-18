package com.example.eva1_5_cambio_orientacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout fl_detail;
    Intent in_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in_detail = new Intent(this, DetailActivity.class);
    }
    public void onMessageFromFragmentToMain(){
        fl_detail = findViewById(R.id.fl_detail);
        if(fl_detail != null){//landscape
            //fragmento detail dinámico
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            DetailFragment detailFragment = new DetailFragment();
            ft.replace(R.id.fl_detail, detailFragment);
            ft.commit();
        }
        else{//portrait
            startActivity(in_detail);
        }


    }
}