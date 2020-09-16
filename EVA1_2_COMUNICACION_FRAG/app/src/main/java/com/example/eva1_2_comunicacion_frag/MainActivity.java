package com.example.eva1_2_comunicacion_frag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //1 recuperar los fragments
    ListFragment lista;
    DataFragment datos;
    /*2 acceder a los fragments
    se usa un metodo que se ejecuta cuando el fragment se vincula (onAttachFragment */

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass() == ListFragment.class){
            lista = (ListFragment)fragment;
        }
        else if (fragment.getClass() == DataFragment.class){
            datos = (DataFragment)fragment;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //funciona como interfaz de comunicación
    public void onMessageFromFragToMain(String sender, String param){
         if(sender.equals(("Lista"))){//recibe info
             //envia al fragment data
             datos.onMessageFromMainToFrag(param);
         }

         else if(sender.equals("Data")){
             //imprime mensaje
             Toast.makeText(this, param,Toast.LENGTH_LONG).show();

         }
    }
}