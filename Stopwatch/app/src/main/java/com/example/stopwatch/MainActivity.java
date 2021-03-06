package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int seconds=0;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            seconds=savedInstanceState.getInt("seconds");
            running =savedInstanceState.getBoolean("running");
        }
        runtimer();

    }
    public void onsaveinstancestate(Bundle savedInsanceState){
        savedInsanceState.putInt("seconds",seconds);
        savedInsanceState.putBoolean("running",running);
    }
    public void start(View view){
        running =true;

    }
    public void stop(View view){
        running = false;

    }
    public void reset(View view){
        running =false;
        seconds=0;

    }
    private void runtimer(){
        final TextView t=findViewById(R.id.textView);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=seconds%60;
                String time=String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,secs);
                t.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);

            }
        });



    }
}
