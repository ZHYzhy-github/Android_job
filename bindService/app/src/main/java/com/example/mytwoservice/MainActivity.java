package com.example.mytwoservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Service myservice;
    private boolean isboon = false;
    TextView mtextview;
    Button mbutton;
    Button mbutton2;
    Button mbutton3;

    private ServiceConnection mConnect = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
           MyService.LocalBinder binder = (MyService.LocalBinder)service;
           myservice = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myservice = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextview = (TextView) findViewById(R.id.textView);
        mbutton = (Button) findViewById(R.id.button);
        mbutton2 = (Button) findViewById(R.id.button2);
        mbutton3 = (Button) findViewById(R.id.button3);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !isboon ){
                    final Intent Service = new Intent(MainActivity.this,MyService.class);
                    bindService(Service,mConnect, Context.BIND_AUTO_CREATE);
                    isboon = true;
                }
            }
        });

        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( isboon ){
                    isboon = false;
                    unbindService(mConnect);
                    myservice = null;
                }
            }
        });

        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isboon){
                    long a = Math.round(Math.random() * 100 );
                    long b = Math.round(Math.random() * 100 );
                    long c = a + b;
                    String str = String.valueOf(a) + "+" + String.valueOf(b) + "=" + String.valueOf(c);
                    mtextview.setText(str);
                }else {
                    mtextview.setText("未绑定服务");
                }
            }
        });
    }
}
