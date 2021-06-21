package com.example.practical26;



import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText data;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.btn);
        data=(EditText) findViewById(R.id.data);
        DBHelper db = new DBHelper(MainActivity.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt= String.valueOf(data.getText());
                Insert insert=new Insert(db,txt);
                Toast.makeText(MainActivity.this, "data_inserted", Toast.LENGTH_SHORT).show();

            }
        });

    }
}

