package com.example.mydataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText myinput;
    TextView mytext;
    mydatabasehandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myinput=(EditText)findViewById(R.id.myinput);
        mytext=(TextView)findViewById(R.id.mytext);
        dbhandler = new mydatabasehandler(this,null,null,1);
        printdatabase();
    }
    public void printdatabase(){
        String dbstring =dbhandler.databasetostring();
        mytext.setText(dbstring);
        myinput.setText("");
    }
    public void addbuttonclick(View view){
        Products products= new Products(myinput.getText().toString());
        dbhandler.addproduct(products);
        printdatabase();
    }
    public void deletebuttonclick(View view){
        String inputtext = myinput.getText().toString();
        dbhandler.deleteproduct(inputtext);
        printdatabase();
    }
}
