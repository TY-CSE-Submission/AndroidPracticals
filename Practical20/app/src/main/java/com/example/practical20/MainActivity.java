package com.example.practical20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button wifi,service_on,service_off;
    Intent serviceeg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifi=(Button) findViewById(R.id.wifi);
        service_on=(Button) findViewById(R.id.service_on);

        service_off=(Button) findViewById(R.id.service_off);



        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wifion=new Intent(MainActivity.this,Wifion.class);
                startService(wifion);
            }
        });

        service_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceeg=new Intent(MainActivity.this,Serviceeg.class);
                startService(serviceeg);

            }
        });

        service_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(serviceeg);
            }
        });

    }
}