package com.example.rep_7_mediaplayer_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b_iniciar, b_detener;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,MyMusicPlayer.class);

        b_iniciar = findViewById(R.id.b_iniciar);
        b_detener = findViewById(R.id.b_detener);
        b_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });

        b_detener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });



    }
}