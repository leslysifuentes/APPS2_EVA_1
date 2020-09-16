package com.example.eva1_3_frag_din;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b_rojo, b_azul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_azul = findViewById(R.id.b_azul);
        b_rojo = findViewById(R.id.b_rojo);

        b_azul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                BlueFragment blueFragment = new BlueFragment();
                fragmentTransaction.replace(R.id.fl_frag, blueFragment);
                fragmentTransaction.commit();
            }
        });

        b_rojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                RedFragment redFragment = new RedFragment();
                fragmentTransaction.replace(R.id.fl_frag, redFragment);
                fragmentTransaction.commit();

            }
        });


    }


}