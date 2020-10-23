package com.example.tuan9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrCourse;
    ListView lv;
    EditText editText;
    int vitri = -1;
    Button btadd,btCapNhat,btdel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.Course);
        arrCourse = new ArrayList<>();
        arrCourse.add("Arsenal");
        arrCourse.add("Manchester City");
        arrCourse.add("Manchester United");
        arrCourse.add("Chelsea");
        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrCourse);
        lv.setAdapter(arrayAdapter);
        editText = (EditText) findViewById(R.id.plaintext);
        btadd = (Button) findViewById(R.id.btadd);
        btCapNhat = (Button) findViewById(R.id.btedit);
        btdel = (Button) findViewById(R.id.btdel);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clb = editText.getText().toString();
                arrCourse.add(clb);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(arrCourse.get(position));
                vitri = position;
            }
        });
        btCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrCourse.set(vitri,editText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });
        btdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrCourse.remove(vitri);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrCourse.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}