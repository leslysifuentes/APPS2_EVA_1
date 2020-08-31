package com.example.rep_1_asynm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_datos = findViewById(R.id.tv_datos);
        MiClaseAsincrona prueba = new MiClaseAsincrona();
        prueba.execute(1,10,1000);

    }
                                    //input,comunicación,output
    class MiClaseAsincrona extends AsyncTask<Integer,String,Double> {


        //2do plano
        @Override
        protected Double doInBackground(Integer... integers) {

            int i=integers[0]; //inicio
            while(i<=integers[1]){//fin

                try {
                    Thread.sleep(integers[2]);
                    publishProgress("\nLSM");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Double aDouble) {
            super.onPostExecute(aDouble);
            tv_datos.append("\nFinal del hilo");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            tv_datos.append(values[0]);


        }
             }
}