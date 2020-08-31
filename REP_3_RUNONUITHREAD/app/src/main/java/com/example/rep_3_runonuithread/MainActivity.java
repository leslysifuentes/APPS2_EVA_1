package com.example.rep_3_runonuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_datos;
    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            //se modifica la interfaz gráfica
            tv_datos.append("\nlesly :p");
        }
    };

    Thread thread = new Thread() {
        @Override
        public void run() {
            super.run();
            int i = 0;
            while (i < 10) {
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
        tv_datos =findViewById(R.id.tv_datos);
        thread.start();
    }
}