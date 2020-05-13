package com.example.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {
    private final IBinder mybinder=new MyLocalBinder();
    public MyService() {
    }

    public class MyLocalBinder extends Binder{
        MyService getservice(){
            return MyService.this;
        }
    }
    public String getcurrenttime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return df.format(new Date());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
    }
}
