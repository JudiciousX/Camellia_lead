package com.example.camellialead;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.MediaController;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import Home.Fragment_Home;
import TeaBush.Fragment_TeaBush;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private List<MediaController> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏系统标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        MediaController mediaController1 = new MediaController(this);
        MediaController mediaController2 = new MediaController(this);
        MediaController mediaController3 = new MediaController(this);
        list.add(mediaController1);
        list.add(mediaController2);
        list.add(mediaController3);

        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | layoutParams.flags);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //当toolbar不连接到系统状态栏时使用这个属性加载资源文件
        //toolbar.inflateMenu(R.menu.zhihu_toolbar_menu);
        //将toolbar连接到系统状态栏
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.main_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home_item);


    }

    /*
     * 将toolbar连接到系统状态栏必须调用的方法
     * 注：也可以不用链接系统状态栏就不需要调用这个方法 直接用tool的点击监听
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //在return之前加载出toolbar要加载的资源文件
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //这个方法是菜单的点击监听
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_brand:
                Toast.makeText(this, "Backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_help:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //点击替换碎片
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.shopping_item:
                break;
            case R.id.teabush_item:
                fragmentTransaction.replace(R.id.fragment_container, new Fragment_TeaBush(list)).commit();
                break;
            case R.id.home_item:
                fragmentTransaction.replace(R.id.fragment_container, new Fragment_Home()).commit();
                break;
            case R.id.shopping_cart_item:
                break;
            case R.id.personal_item:
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_MOVE) {
            for(MediaController mediaController : list) {
                mediaController.hide();
                Log.d("scout", "xxx");
            }
        }
        return super.onTouchEvent(event);
    }
}