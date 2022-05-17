package com.example.camellialead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import TeaBush.Fragment_TeaBush;
import TeaBush.Fragment_TeaBush2;

public class TreeBush_Shopping extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏系统标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tree_bush_shopping);
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | layoutParams.flags);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        //当toolbar不连接到系统状态栏时使用这个属性加载资源文件
        //toolbar.inflateMenu(R.menu.zhihu_toolbar_menu);
        //将toolbar连接到系统状态栏
        setSupportActionBar(toolbar);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.treebush_frame, new Fragment_TeaBush2()).commit();
    }
}