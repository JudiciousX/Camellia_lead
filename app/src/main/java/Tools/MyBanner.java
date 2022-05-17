package Tools;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.nineoldandroids.view.ViewHelper;
import com.youth.banner.Banner;

public class MyBanner extends Banner {

    private int downX;
    private int downY;

    public MyBanner(Context context) {
        super(context);
    }

    public MyBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyBanner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //解决ViewPager和轮播图滑动冲突
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 让当前viewpager的父控件不去拦截touch事件
                getParent().requestDisallowInterceptTouchEvent(true);
                downX = (int) ev.getX();
                downY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) ev.getX();
                int moveY = (int) ev.getY();
                if (Math.abs(moveX - downX) >= Math.abs(moveY - downY)) {
                    // 滑动轮播图
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    // 刷新listview
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //获取手指当前坐标 使用RawX是获取当前点击事件在屏幕中的坐标而不是相对于View本身的坐标

        int mLastX = 0;
        int mLastY = 0;
        int x = (int) ev.getRawX();
        int y = (int) ev.getRawY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:{
                break;
            }
            case MotionEvent.ACTION_MOVE:
                //获取需要移动的位移
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                Log.d("viper", "move, deltaX:" + deltaX + "move, deltaY:" + deltaY);
                //移动的方法通过nineoldandroid中的ViewHelper类所提供的setTranslationX与setTranslationY
                int translationX = (int) ViewHelper.getTranslationX(this) + deltaX;
                int translationY = (int) ViewHelper.getTranslationY(this) + deltaY;
                //移动
                ViewHelper.setTranslationX(this, translationX);
                ViewHelper.setTranslationY(this, translationY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;

        }
        mLastX = x;
        mLastY = y;
        return true;
    }
}
