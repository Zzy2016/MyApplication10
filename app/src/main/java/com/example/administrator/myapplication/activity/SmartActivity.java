package com.example.administrator.myapplication.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.StatusBarColorUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.TRANSPARENT;

public class SmartActivity extends AppCompatActivity {

    SmartRefreshLayout smartRefreshLayout;
    RecyclerView recyclerView;

    int page = 1;
    List<String> allList, tempList;
    TestAdapter adapter;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(TRANSPARENT);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//设置字体黑色
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_smart);


        adapter = new TestAdapter(R.layout.item_list, allList);
        smartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.smartRefreshLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        allList = new ArrayList<>();
        tempList = new ArrayList<>();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        View view=LayoutInflater.from(this).inflate(R.layout.layout_head,null);
//        adapter.addHeaderView(view);

//        smartRefreshLayout.setEnableRefresh(false);//禁止刷新首页
//        smartRefreshLayout.setEnableLoadMore(false);//禁止加载更多


        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initList();
                Message message = new Message();
                message.what = 1;
                handler.sendMessageDelayed(message, 2000);

            }
        });

        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                initList();
                Message message = new Message();
                message.what = 2;
                handler.sendMessageDelayed(message, 2000);
            }
        });

        initList();
        adapter.getData().addAll(tempList);
        adapter.notifyDataSetChanged();

    }


    public void initList() {
        tempList.clear();
        for (int i = 0; i < 15; i++) {
            tempList.add("SmartRefreshLayout");
        }
    }

    public class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public TestAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(final BaseViewHolder helper, String item) {
            ((TextView) helper.getView(R.id.tv_show)).setText(item + "   " + helper.getAdapterPosition());

            TextView textView = helper.getView(R.id.tv_show);

            textView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("NewApi")
                @Override
                public void onClick(View v) {
                    int index = helper.getAdapterPosition() % 3;
                    switch (index) {
                        case 0:
                            StatusBarColorUtils.changeStatusBarColor(activity, R.color.colorAccent);
//                            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
                            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
                            break;
                        case 1:
                            StatusBarColorUtils.changeStatusBarColor(activity, R.color.colorPrimary);
//                            getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
                            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                            break;
                        case 2:
                            StatusBarColorUtils.changeStatusBarColor(activity, R.color.colortran);

//                            getWindow().setStatusBarColor(getResources().getColor(R.color.colortran));
                            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//设置字体黑色
                            break;
                    }
                }
            });
        }
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    adapter.getData().clear();
                    adapter.getData().addAll(tempList);
                    adapter.notifyDataSetChanged();
                    smartRefreshLayout.finishRefresh();
                    break;
                case 2:
                    int oldPosition = adapter.getData().size();
                    adapter.getData().addAll(tempList);
                    adapter.notifyDataSetChanged();
                    smartRefreshLayout.finishLoadMore();
//                    recyclerView.scrollToPosition(oldPosition);
                    break;
            }
        }
    };
}
