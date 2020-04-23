package com.example.android.myonehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static Handler handler = new Handler();
    private static int date;
    private static TextView showText;
    private Button start;
    private Button stop;


    public static void UpGUI( int a ){
        date = a;
        handler.post(reFreshLable);
    }
    private  static Runnable reFreshLable = new Runnable() {
        @Override
        public void run() {
            showText.setText(String.valueOf(date));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showText = (TextView)findViewById(R.id.show_text_view);
        start = (Button)findViewById(R.id.start_button_view);
        stop = (Button)findViewById(R.id.stop_button_view);

        final Intent service = new Intent(this,MyService.class);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(service);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(service);
            }
        });

    }
}
