package com.example.android.myonehandler;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    private Thread workThread;

    @Override
    public void onCreate() {
        super.onCreate();
        workThread = new Thread(null,backGroundWork,"workThread");
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if( !workThread.isAlive() ){
            workThread.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        workThread.interrupt();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private Runnable backGroundWork = new Runnable() {
        @Override
        public void run() {
            try {
                while ( !Thread.interrupted() ){
                    int round = (int) (Math.random() * 100);
                    MainActivity.UpGUI(round);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

}
