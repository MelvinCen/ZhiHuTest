package com.huazhu.zhihutest;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ListView listView;
    private TextView tvTitle;
    private LinearLayout llRemind;
    //左侧栏内容
    private RelativeLayout mRlLeftContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        listView = findViewById(R.id.lv_title_function);
        ImageButton ibSearch = findViewById(R.id.ib_search);
        ImageButton ibRemid = findViewById(R.id.ib_remind);
        ImageButton ibMore = findViewById(R.id.ib_more);
        tvTitle = findViewById(R.id.tv_title);
        llRemind = findViewById(R.id.ll_remind);
        mRlLeftContent = findViewById(R.id.rl_left_content);

        initTitle();
        initLeftFunction();

        ibSearch.setOnClickListener(this);
        ibRemid.setOnClickListener(this);
        ibMore.setOnClickListener(this);
    }

    private void initTitle() {
        // 设置toolbar支持actionbar,如需设置标题名要在这个之前
        setSupportActionBar(toolbar);
        //关闭原有的toolbar标题
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // 实现按钮开关的显示及打开关闭功能并同步动画
        initDrawLayout();
    }

    private void initDrawLayout() {
        // 参数：开启抽屉的activity、DrawerLayout的对象、toolbar按钮打开关闭的对象、描述open drawer、描述close drawer
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                tvTitle.setText("APP名称");
                llRemind.setVisibility(View.GONE);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                tvTitle.setText("首页");
                llRemind.setVisibility(View.VISIBLE);
            }
        };
        // 添加抽屉按钮，通过点击按钮实现打开和关闭功能; 如果不想要抽屉按钮，只允许在侧边边界拉出侧边栏，可以不写此行代码
        actionBarDrawerToggle.syncState();
        // 设置按钮的动画效果; 如果不想要打开关闭抽屉时的箭头动画效果，可以不写此行代码
        drawerLayout.addDrawerListener(actionBarDrawerToggle);


    }

    private void initLeftFunction() {
        LeftFuncAdapter leftFuncAdapter = new LeftFuncAdapter(getApplicationContext());
        listView.setAdapter(leftFuncAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawer(mRlLeftContent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_search:
                Toast.makeText(MainActivity.this,"搜索",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_remind:
                Toast.makeText(MainActivity.this,"提醒",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_more:
                Toast.makeText(MainActivity.this,"更多",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
