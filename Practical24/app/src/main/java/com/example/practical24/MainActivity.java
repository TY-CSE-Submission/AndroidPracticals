package com.example.practical24;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button On,Off,visible,devices;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        On=(Button) findViewById(R.id.On);
        Off=(Button) findViewById(R.id.Off);
        visible=(Button) findViewById(R.id.visible);
        devices=(Button) findViewById(R.id.devices);
        BA=BluetoothAdapter.getDefaultAdapter();
        lv=(ListView) findViewById(R.id.lv) ;


        On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!BA.isEnabled()){
                    Intent turnOn=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(turnOn);
                    Toast.makeText(MainActivity.this, "BW turned On", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Already on", Toast.LENGTH_LONG).show();
                }
            }
        });

        Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BA.isEnabled()){
                    BA.disable();
                    Toast.makeText(MainActivity.this, "BW turned Off", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Already off", Toast.LENGTH_LONG).show();
                }
            }
        });

        visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivity(getVisible);
            }
        });

        devices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pairedDevices=BA.getBondedDevices();
                ArrayList list=new ArrayList();
                for(BluetoothDevice bt : pairedDevices) list.add(bt.getName());
                Toast.makeText(getApplicationContext(), "Showing Paired Devices",Toast.LENGTH_SHORT).show();

                final ArrayAdapter adapter = new  ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1, list);
                lv.setAdapter(adapter);
            }
        });


    }
}