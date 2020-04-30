package com.example.android.mytwolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.android.mytwolistview.R.id.findlist;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ListView listView;
    private String[] findlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.texe_textview);
        listView = findViewById(R.id.findlist);
        findlist = getResources().getStringArray(R.array.findlist);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(findlist[position]);
            }
        });

    }
}
