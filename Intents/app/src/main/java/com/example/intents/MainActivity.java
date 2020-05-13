package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,MyService.class);
        startActivity(intent);
    }
    public void onclick(View view){
        Intent i = new Intent(this,Main2Activity.class);
        final EditText firstinput=(EditText)findViewById(R.id.edit_Text);
        String message = firstinput.getText().toString();
        i.putExtra("first",message);
        startActivity(i);
    }
}
