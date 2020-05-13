package com.example.videoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final VideoView myvideo=(VideoView)findViewById(R.id.myvideo);
        myvideo.setVideoPath("https://youtu.be/IzoFn3dfsPA");
        myvideo.start();
    }
}
