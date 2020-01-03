package com.example.administrator.myapplication.activity;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class ThreadActivity extends AppCompatActivity {


    TextView tvVersionStatus;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        tvVersionStatus = (TextView) findViewById(R.id.tv_versionstatus);

        Drawable rightDrawable = getResources().getDrawable(R.drawable.selected);

//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示

        rightDrawable.setBounds(0, 0, 60, 60);  // left, top, right, bottom
        tvVersionStatus.setCompoundDrawables(null, rightDrawable, null, rightDrawable);  // left, top, right, bottom


        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioButton1 = (RadioButton) findViewById(R.id.radio_button1);
        radioButton2 = (RadioButton) findViewById(R.id.radio_button2);
        radioButton3 = (RadioButton) findViewById(R.id.radio_button3);
        radioButton4 = (RadioButton) findViewById(R.id.radio_button4);

        reSize(radioButton1);
        reSize(radioButton2);
        reSize(radioButton3);
        reSize(radioButton4);

        radioButton1.setText(radioButton1.isSelected() + "");
        radioButton2.setText(radioButton2.isSelected() + "");
        radioButton3.setText(radioButton3.isSelected() + "");
        radioButton4.setText(radioButton4.isSelected() + "");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                refreshPage(checkedId);
            }
        });

    }

    //    设置radiobutton drawableTop 大小
    public void reSize(RadioButton radioButton) {
        Rect rect = new Rect();//矩形类
        rect.set(0, 0, 60, 60);    //距离父窗体的距离，可以理解为左上和右下的坐标
        Drawable[] drawables = radioButton.getCompoundDrawables();  //返回 left  top  right  bottom
        drawables[1].setBounds(rect);  //取出上边的图片设置大小  //drawables[1]值 top
        radioButton.setCompoundDrawables(null, drawables[1], null, null);
    }


    //    radiobutton 点击事件  刷新按钮 页面
    public void refreshPage(int checkedId) {
        switch (checkedId) {
            case R.id.radio_button1:
                tvVersionStatus.setText("按钮1");
                break;
            case R.id.radio_button2:
                tvVersionStatus.setText("按钮2");
                break;
            case R.id.radio_button3:
                tvVersionStatus.setText("按钮3");
                break;
            case R.id.radio_button4:
                tvVersionStatus.setText("按钮4");
                break;
        }
    }


}
