package com.example.smsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ph, msg;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.button);
        ph = (EditText) findViewById(R.id.editTextPhone);
        msg = (EditText) findViewById(R.id.editTextTextMultiLine);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String phone = (String) ph.getText().toString();
                String message = (String) msg.getText().toString();

                try{
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phone, null, message, null, null);
                    Toast.makeText(MainActivity.this, "SMS sent", Toast.LENGTH_LONG).show();
                }
                catch(Exception e){
                    Toast.makeText(MainActivity.this, "Failed to send SMS: " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });
    }
}