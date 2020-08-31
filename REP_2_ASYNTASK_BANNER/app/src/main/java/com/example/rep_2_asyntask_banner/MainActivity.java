package com.example.rep_2_asyntask_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
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
   int  indice = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_datos = findViewById(R.id.tv_datos);
        iv_banner = findViewById(R.id.iv_banner);
        MiClaseAsincrona prueba = new MiClaseAsincrona();
        prueba.execute(0,3,1000);
    }

    //input,comunicación,output
    class MiClaseAsincrona extends AsyncTask<Integer,Integer,Double> {


        //2do plano
        @Override
        protected Double doInBackground(Integer... integers) {


            int i=integers[0]; //inicio. integers[0]= 0

            while(i<integers[1]){//fin  integers[1]= 3

                try {
                    Thread.sleep(integers[2]);  //integers[2] = 1000
                    publishProgress(imagenes[i]);



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
            tv_datos.append("\n\nFinal del hilo");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            iv_banner.setImageResource(values[0]);
        }
    }

}