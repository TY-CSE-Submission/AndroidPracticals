package com.example.practical18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView fact_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        fact_result=(TextView) findViewById(R.id.fact_result);
        int number = Integer.parseInt(getIntent().getStringExtra("number")) ;
        int i,fact=1;

        for(i=1;i<=number;i++){
            fact=fact*i;
        }
        fact_result.setText(Integer.toString(fact));

}
}