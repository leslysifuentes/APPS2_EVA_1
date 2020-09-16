package com.example.rep_5_segunda_parte_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_datos = findViewById(R.id.tv_datos);
        BroadcastReceiver broadcastReceiver = new MiBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("MiServicio");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    class MiBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
           // Log.wtf("Mensaje", "thread");
            tv_datos.append(intent.getStringExtra("enviados"));
        }
    }

}