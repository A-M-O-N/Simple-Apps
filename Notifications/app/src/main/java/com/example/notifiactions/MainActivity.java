package com.example.notifiactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.example.notifiactions.channel.CHANNEL_ID;

public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder notification;
    private static final int uniqueid=401;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification=new NotificationCompat.Builder(this,CHANNEL_ID);
        notification.setAutoCancel(true);
    }
    public void yo(View view){
        notification.setSmallIcon(R.mipmap.ic_launcher_round);
        notification.setTicker("This is a ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Yo bro");
        notification.setContentText("Whatsup bro");

        Intent i = new Intent(this,MainActivity.class);
        PendingIntent pending = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pending);

        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueid,notification.build());
    }
}
