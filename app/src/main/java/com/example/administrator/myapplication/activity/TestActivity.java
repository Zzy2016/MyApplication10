package com.example.administrator.myapplication.activity;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.BlankFragment;

public class TestActivity extends AppCompatActivity {

    LinearLayout llContent;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

//        llContent = (LinearLayout) findViewById(R.id.ll_content);
//        refreshContent();

    }

//    public void refreshContent() {
//        fragmentManager = getSupportFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.ll_content, new BlankFragment());
//        fragmentTransaction.commit();
//    }
//
//    @Override
//    public void onFragmentInteraction(Uri uri) {
//
//    }
}
