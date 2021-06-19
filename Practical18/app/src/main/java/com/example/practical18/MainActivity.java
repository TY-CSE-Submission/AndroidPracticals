package com.example.practical18;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText website_text,fact_no;
    Button nav_button,open_dialer,factorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        website_text=(EditText) findViewById(R.id.website_text);
        fact_no=(EditText) findViewById(R.id.fact_no);

        nav_button=(Button) findViewById(R.id.nav_button);
        factorial=(Button) findViewById(R.id.factorial);

        open_dialer=(Button) findViewById(R.id.open_dialer);


        nav_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String website= String.valueOf(website_text.getText());
                Intent viewSearch=new Intent(Intent.ACTION_WEB_SEARCH);
                viewSearch.putExtra(SearchManager.QUERY,website);
                startActivity(viewSearch);
            }
        });
        open_dialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewDialer=new Intent(Intent.ACTION_DIAL);
                startActivity(viewDialer);
            }
        });
        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num= String.valueOf(fact_no.getText()+"");

                Intent fact=new Intent(MainActivity.this,Activity2.class);
                fact.putExtra("number",num);
                startActivity(fact);
            }
        });
    }
}