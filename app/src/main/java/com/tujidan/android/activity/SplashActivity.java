package com.tujidan.android.activity;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import com.tujidan.android.R;

public class SplashActivity extends AppCompatActivity {
    /**
     * 闪屏页
     */
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_splash);
        startAnim();

    }

    private void startAnim() {
        //渐变动画，从完全透明到不透明
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        //设置动画时间为2秒
        alphaAnimation.setDuration(2000);
        //动画结束后，保持动画2秒
        alphaAnimation.setFillAfter(true);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                jumpNextPage();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {


            }
        });

        relativeLayout.startAnimation(alphaAnimation);

    }

    /**
     * 跳转到下一个页面
     */
    private void jumpNextPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        finish();
    }

}
