 package com.example.eva1_4_frag_parametros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class MainActivity extends AppCompatActivity {
    Button b_abrir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_abrir = findViewById(R.id.b_abrir);

        b_abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //para crear el fragment de manera dinámica:
                //transaccion
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                //crear fragment
                ParamFragment paramFragment = ParamFragment.newInstance("Valor 1","Valor 2");
                //remplazar layout con el fragment
                ft.replace(R.id.fl_frag, paramFragment);
                //commit
                ft.commit();
            }
        });

    }
}