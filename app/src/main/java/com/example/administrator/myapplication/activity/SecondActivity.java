package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.myapplication.R;

/*
 *  new  branches
 * */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Runtime.getRuntime().maxMemory();

        //Log.e()
    }
}
