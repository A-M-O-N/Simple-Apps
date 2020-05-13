package com.example.boundservices;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.example.boundservices.MyService.MyLocalBinder;

public class MainActivity extends AppCompatActivity {

    MyService myservice;
    boolean isbound=false;

    public void showtime(View view){
        String currenttime = myservice.getcurrenttime();
        TextView mytext =(TextView)findViewById(R.id.mytext);
        mytext.setText(currenttime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this,MyService.class);
        bindService(i,myconnection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection myconnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder) service;
            myservice =binder.getservice();
            isbound=true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isbound=false;

        }
    };

}
