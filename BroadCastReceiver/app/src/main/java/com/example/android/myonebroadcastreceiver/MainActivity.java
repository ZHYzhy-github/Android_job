package com.example.android.myonebroadcastreceiver;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView T1;
    private Button B1,B2,B3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        T1 = (TextView) findViewById(R.id.show_text_view);
        B1 = (Button) findViewById(R.id.start1_button_view);
        B2 = (Button) findViewById(R.id.start_button_view);
        B3 = (Button) findViewById(R.id.stop_button_view);

        class MyBroad extends BroadcastReceiver {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if(action.equals("com.example.dyname")){
                    String name = intent.getStringExtra("msg");
                    T1.setText(name);
                    Toast.makeText(context,"动态广播",Toast.LENGTH_LONG).show();
                }
            }
        }
        final MyBroad recevice;
        IntentFilter filter;
        filter= new IntentFilter();
        filter.addAction("com.example.dyname");
        recevice = new MyBroad();
        registerReceiver(recevice,filter);

//        class MyBroad extends BroadcastReceiver{
//            @Override
//            public void onReceive(Context context, Intent intent) {
//
//            }
//        };

        /**
         * 按下第一个按键注册广播
         * */
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.start");
                intent.putExtra("name","start Broad");
                sendBroadcast(intent);
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.dyname");
                intent.putExtra("msg","dyname Broad");
                sendBroadcast(intent);
            }

        });

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unregisterReceiver(recevice);
            }
        });
    }

}
