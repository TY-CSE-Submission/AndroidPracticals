package com.example.animationeg;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.Scale;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img;
    ScaleAnimation scale;
    RotateAnimation rotate;
    AlphaAnimation alpha;
    Button b1, b2, b3, b4, b5, b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView);

        b1 = (Button) findViewById(R.id.anticlockwise);
        b2 = (Button) findViewById(R.id.rclockwise);
        b3 = (Button) findViewById(R.id.fadein);
        b4 = (Button) findViewById(R.id.fadeout);
        b5 = (Button) findViewById(R.id.zoomin);
        b6 = (Button) findViewById(R.id.zoomout);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.anticlockwise:
                rotate = new RotateAnimation(360, 0);
                rotate.setDuration(1000);
                img.startAnimation(rotate);
                break;
            case R.id.rclockwise:
                rotate = new RotateAnimation(0, 360);
                rotate.setDuration(1000);
                img.startAnimation(rotate);
                break;
            case R.id.fadein:
                alpha = new AlphaAnimation(0,1000);
                alpha.setDuration(1000);
                img.startAnimation(alpha);
                break;
            case R.id.fadeout:
                alpha = new AlphaAnimation(1000,0);
                alpha.setDuration(1000);
                img.startAnimation(alpha);
                break;
            case R.id.zoomin:
                scale = new ScaleAnimation(0, 2, 0, 2);
                scale.setDuration(1000);
                img.startAnimation(scale);
                break;
            case R.id.zoomout:
                scale = new ScaleAnimation(2, 0, 2, 0);
                scale.setDuration(1000);
                img.startAnimation(scale);
                break;
        }
    }
}