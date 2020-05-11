package com.example.android.myone_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.open:
                Toast.makeText(this,"打开蓝牙",Toast.LENGTH_SHORT).show();
                break;
            case R.id.scan:
                Toast.makeText(this,"扫描设备",Toast.LENGTH_SHORT).show();
                break;
            case R.id.disconnect:
                Toast.makeText(this,"断开连接",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
