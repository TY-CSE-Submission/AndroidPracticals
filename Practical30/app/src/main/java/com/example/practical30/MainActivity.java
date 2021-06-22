package com.example.practical30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button send;
    EditText email,sub,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText) findViewById(R.id.email);
        sub=(EditText) findViewById(R.id.sub);

        msg=(EditText) findViewById(R.id.msg);
        send=(Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,email.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT,sub.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,msg.getText().toString());
                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent,"Choose an Email client"));

            }
        });

    }
}