package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] fruits = {"apple","mango","guava","peach","banana","melon","potato","tomato","ginger","jackfruit","eggplant"};

        ListAdapter myadapter = new customadapter(this,fruits);
        ListView mylistview =(ListView)findViewById(R.id.mylistview);
        mylistview.setAdapter(myadapter);

        mylistview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String fruit=String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this,fruit,Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
