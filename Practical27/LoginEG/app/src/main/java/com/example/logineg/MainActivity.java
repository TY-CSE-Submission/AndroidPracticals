package com.example.logineg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText unm, pw;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button);
        unm = (EditText) findViewById(R.id.editTextTextPersonName);
        pw = (EditText) findViewById(R.id.editTextTextPassword);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user = (String) unm.getText().toString();
                String pass = (String) pw.getText().toString();
                Toast.makeText(MainActivity.this, user + " " + pass, Toast.LENGTH_LONG).show();

                if(user.equals("abcd") && pass.equals("abc123")){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Username and password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}