package com.example.administrator.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FourtyActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    List<Button> list;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_fourty);
//        112321321
        String str = "12";

        list = new ArrayList<>();

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        tvContent=(TextView)findViewById(R.id.tv_content);

        list.add(button1);
        list.add(button2);
        list.add(button3);
        list.add(button4);
        list.add(button5);
        button1.setOnClickListener(buttonOnClick);
        button2.setOnClickListener(buttonOnClick);
        button3.setOnClickListener(buttonOnClick);
        button4.setOnClickListener(buttonOnClick);
        button5.setOnClickListener(buttonOnClick);


    }



    public void refreshButton(View v) {
        for (int i = 0; i < list.size(); i++) {
            if (v.getId() == list.get(i).getId()) {
                list.get(i).setVisibility(View.GONE);
                Log.e("当前选中",i+"  ");

                tvContent.setText(i+1+" ");

            } else {
                list.get(i).setVisibility(View.VISIBLE);
            }
        }
    }

    private View.OnClickListener buttonOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            refreshButton(v);
        }
    };
}
