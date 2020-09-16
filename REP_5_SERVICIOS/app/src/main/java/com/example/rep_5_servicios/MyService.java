package com.example.rep_5_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Intent intent2;

    Thread thread;
    public MyService(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("MiServicio","oncreate");
    }

    @Override
    public void onStart(final Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("MiServicio",intent.getStringExtra("dato"));
        thread = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){

                    try {
                        Thread.sleep(1000);
                  //      Log.wtf("MiServicio", "thread");
                        intent2 = new Intent("MiServicio");
                        intent2.putExtra("enviados","\nescuchando");
                        sendBroadcast(intent2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        thread.start();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("MiServicio","ondestroy");
        thread.interrupt();
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
