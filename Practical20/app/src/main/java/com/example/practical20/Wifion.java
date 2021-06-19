package com.example.practical20;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Wifion extends Service {

    @Nullable
    @Override
    @SuppressLint("ServiceCast")
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Starting Wifi on", Toast.LENGTH_SHORT).show();

        WifiManager wifi=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);

        return START_STICKY;
    }
    public IBinder onBind(Intent intent) {
        return null;
    }

}
