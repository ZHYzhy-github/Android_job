package com.example.mytwoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.LocaleList;
import android.widget.Toast;

public class MyService extends Service {
    private final IBinder mbinder = new LocalBinder();
    public class LocalBinder extends Binder{
       MyService getService(){
           return MyService.this;
       }
    }

    @Override
    public void onCreate() {
        Toast.makeText(this,"调用onCreate",Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"调用onStartCommand",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this,"本地取消绑定myService",Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Toast.makeText(this,"本地绑定myService",Toast.LENGTH_LONG).show();
        return mbinder;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"调用onDestroy",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
