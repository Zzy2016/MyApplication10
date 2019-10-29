package com.example.administrator.myapplication.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

public class MainActivity extends AppCompatActivity {

    ImageView  imageView;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView=(ImageView)findViewById(R.id.image);
        animationDrawable=(AnimationDrawable)imageView.getBackground();

        animationDrawable.start();

    }

}
