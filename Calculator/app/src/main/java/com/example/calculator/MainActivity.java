package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but = (Button)findViewById(R.id.button);


    }
    public void onclick(View view){
        EditText num1 = (EditText)findViewById(R.id.Number1);
        EditText num2 = (EditText)findViewById(R.id.Number2);
        TextView ans = (TextView) findViewById(R.id.Answer);
        int a=Integer.parseInt(num1.getText().toString());
        int b=Integer.parseInt(num2.getText().toString());
        int res =a+b;
        ans.setText(Integer.toString(res));

    }
}
