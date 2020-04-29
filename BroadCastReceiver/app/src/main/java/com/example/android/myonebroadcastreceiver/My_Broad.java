package com.example.android.myonebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class My_Broad extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if( action.equals("com.example.start")){
            String name = intent.getStringExtra("name");
            Log.i("state",name);
        }
    }
}
