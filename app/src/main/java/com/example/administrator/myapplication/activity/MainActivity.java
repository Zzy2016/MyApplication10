package com.example.administrator.myapplication.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Scroller;

import com.example.administrator.myapplication.R;

import java.util.Calendar;

public class MainActivity extends Activity {

    Button button;


    Scroller scroller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        console("onCreate");


//        Object object=new Object();
//
//        String str1="hello";
//        String str2="hello";
//
//        Log.e("string1",(str1==str2)+"  ");
//        Log.e("string2",(str1.equals(str2))+"  ");
//
//        String str3=new String("123");
//        String str4=new String("123");
//
//        Log.e("string3",(str3==str4)+"");
//        Log.e("string4",(str3.equals(str4))+"");
//
//        Log.e("string5",(str1==str3)+"");

//        button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,MainActivity.class);
////                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                startActivity(intent);
//                overridePendingTransition(R.anim.left_in,R.anim.right_out);
//                Log.e("Touch111", "onClick");
//            }
//        });


//        button.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        Log.e("Touch111", "ACTION_DOWN   "+event.getRawX()+"   " +event.getRawY());
//
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        Log.e("Touch111", "ACTION_MOVE  "+event.getRawX()+"   " +event.getRawY());
//                        Log.e("Touch112", "ACTION_MOVE  "+button.getLeft()+"   " +button.getWidth());
//
//                        button.setX(event.getRawX()-(button.getWidth()/2));
//                        button.setY(event.getRawY()-(button.getHeight()/2));
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        Log.e("Touch111", "ACTION_UP   "+event.getRawX()+"   " +event.getRawY());
//                        break;
//                }
//                return true;
//            }
//        });


//        View的显示必须经历Measure（测量）、Layout（布局）和Draw（绘制）过程。
//        而在Measure与Layout过程完成之后，View的width、height、top、left等属性才被正确赋值，
//        此时我们才能获取到正确的值，这几个过程都晚于onCreate执行
//        button.post(new Runnable() {
//            @Override
//            public void run() {
//                Log.e("button1", button.getLeft() + "  " + button.getRight() + "  " + button.getTop() + "  " + button.getBottom());
//                Log.e("button2", button.getWidth() + "  " + button.getHeight() + "   " + button.length());
//            }
//        });
//
//
//        scroller=new Scroller(MainActivity.this);


    }



    public String getTimeString(long createTime) {
        String result = "";
        //当前时间
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);
        //咨询开始时间
        int spandHours = (int) ((calendar.getTimeInMillis() - createTime) / (1000 * 60 * 60));//已经过去的小时数
        calendar.setTimeInMillis(createTime);
        int createDay = calendar.get(Calendar.DATE);
        int createHour = calendar.get(Calendar.HOUR_OF_DAY);
        int createMinute = calendar.get(Calendar.MINUTE);
        String showHours = createHour + "";
        if (createHour < 10) {
            showHours = "0" + createHour;
        }
        String showMinute = createMinute + "";
        if (createMinute < 10) {
            showMinute = "0" + createMinute;
        }
        int shortHours = 24 - createHour;  //距离第二天小时数
        if (spandHours < shortHours) {
            result = "该咨询将在后天" + showHours + ":" + showMinute + "自动结束,如需追问，请及时提问";
        } else if (spandHours < (shortHours + 24)) {
            result = "该咨询将在明天" + showHours + ":" + showMinute + "自动结束,如需追问，请及时提问";
        } else {
            result = "该咨询将在今天" + showHours + ":" + showMinute + "自动结束,如需追问，请及时提问";
        }

        return result;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        Log.e("button3", button.getLeft() + "  " + button.getRight() + "  " + button.getTop() + "  " + button.getBottom());
//        Log.e("button4", button.getWidth() + "  " + button.getHeight() + "   " + button.length());
    }

    @Override
    protected void onStart() {
        super.onStart();
        console("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        console("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        console("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        console("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        console("onDestroy");
    }

    public void console(String str) {
        Log.e("MainActivity", str);
    }
}
