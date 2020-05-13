package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle firstdata = getIntent().getExtras();
        if(firstdata==null)
            return;
        String message =firstdata.getString("first");
        TextView secondtext=(TextView)findViewById(R.id.second_text);
        secondtext.setText(message);
    }
    public void onclick2(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
