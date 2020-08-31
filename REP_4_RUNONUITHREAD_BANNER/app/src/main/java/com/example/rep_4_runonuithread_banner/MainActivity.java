package com.example.rep_4_runonuithread_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_datos;
    ImageView iv_banner;
    int[] imagenes = {
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3   };

    int i = 0;
    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            //se modifica la interfaz gráfica
            iv_banner.setImageResource(imagenes[i]);

            if(i==2){
                tv_datos.append("\n\nFin");
            }



        }
    };

    Thread thread = new Thread() {
        @Override
        public void run() {
            super.run();


            while (i < 2) {
                try {
                    Thread.sleep(1000);
                    runOnUiThread(runnable);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_datos = findViewById(R.id.tv_datos);
        iv_banner = findViewById(R.id.iv_banner);
        thread.start();
    }
}