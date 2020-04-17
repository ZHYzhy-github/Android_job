package com.example.myoneservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MyService extends Service {
/**    public MyService() {
    }
*/
    private TextView mtextview;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"调用oncreate方法,初始化服务",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"调用onStartCommand方法,实现具体功能",Toast.LENGTH_LONG).show();
        double number = Math.random();
        String str = "产生一个随机数+" + Math.round( number * 100);
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"调用onDestroy方法,结束服务",Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
