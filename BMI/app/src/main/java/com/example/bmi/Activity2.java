package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
    public void calculate(View view){
        double w=0;
        double h=0;
        double bm=0;
        EditText weight=(EditText)findViewById(R.id.editText3);
        EditText height=(EditText)findViewById(R.id.editText4);
        TextView bmi=findViewById(R.id.textView2);
        w=Double.parseDouble(weight.getText().toString());
        h=Double.parseDouble(height.getText().toString());
        bm=w/(h*h);
        bmi.setText(String.valueOf(bm));


    }
}
