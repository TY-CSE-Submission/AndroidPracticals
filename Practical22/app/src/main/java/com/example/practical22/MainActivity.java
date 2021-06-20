package com.example.practical22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    TextView view;
    private boolean isColor = false;
    private long lastUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(TextView) findViewById(R.id.textview);
//        view.setBackgroundColor(Color.GREEN);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        // Text View that shall display this list
        TextView tv =(TextView) findViewById(R.id.tv);

        // Converting List to String and displaying
        // every sensor and its information on a new line
        for (Object sensors : deviceSensors) {
            tv.append(sensors.toString() + "\n\n");
        }


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            getAccelerometer(event);
//            textview.setBackgroundColor(Color.RED);
        }
    }

    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

        long actualTime = System.currentTimeMillis();
        
        if (accelationSquareRoot >= 2) //it will be executed if you shuffle
        {

            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;//updating lastUpdate for next shuffle
            if (isColor) {
                view.setBackgroundColor(Color.GREEN);

            } else {
                view.setBackgroundColor(Color.RED);
            }
            isColor = !isColor;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the orientation and
        // accelerometer sensors
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }


}