package com.tujidan.android.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.tujidan.android.R;
import com.tujidan.android.layout.HomeFifthFragment;
import com.tujidan.android.layout.HomeFirstFragment;
import com.tujidan.android.layout.HomeFourthFragment;
import com.tujidan.android.layout.HomeSecondFragment;
import com.tujidan.android.layout.HomeThirdFragment;


public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private int mLastSelection;
    private HomeFirstFragment mHomeFirstFragment;
    private HomeSecondFragment mHomeSecondFragment;
    private HomeThirdFragment mHomeThirdFragment;
    private HomeFourthFragment mHomeFourthFragment;
    private HomeFifthFragment mHomeFifthFragment;
    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.title_toolbar);
        setSupportActionBar(toolbar);

        initUi();
        setDefaultFragment();


        //http://blog.csdn.net/alcoholdi/article/details/51594061
    }

    private void initUi() {
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.main_bottom_essence_press, "精华").setActiveColorResource(R.color.colorTitle).setInactiveIconResource(R.drawable.main_bottom_essence_normal_night))
        .addItem(new BottomNavigationItem(R.drawable.main_bottom_latest_press, "最新").setActiveColorResource(R.color.colorTitle).setInactiveIconResource(R.drawable.main_bottom_latest_normal_night))
        .addItem(new BottomNavigationItem(R.drawable.main_bottom_news_press, "心情").setActiveColorResource(R.color.colorTitle).setInactiveIconResource(R.drawable.main_bottom_news_normal_night))
        .addItem(new BottomNavigationItem(R.drawable.inform_icon_pressed, "夺宝").setActiveColorResource(R.color.colorTitle).setInactiveIconResource(R.drawable.inform_icon))
        .addItem(new BottomNavigationItem(R.drawable.main_bottom_my_press, "我的").setActiveColorResource(R.color.colorTitle).setInactiveIconResource(R.drawable.main_bottom_my_normal_night))
        .setFirstSelectedPosition(mLastSelection).initialise();
        bottomNavigationBar.setTabSelectedListener(this);

    }

    /**
     * 设置默认选中的fragment
     *
     *
     */
    private void setDefaultFragment( ) {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mHomeFirstFragment = HomeFirstFragment.newInstance("精华");
        transaction.add(R.id.home_frame_layout, mHomeFirstFragment);
        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    //菜单栏
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(this, "you click home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.title_shen:
                Toast.makeText(this, "you click shen", Toast.LENGTH_SHORT).show();
            default:
                break;
        }

        return true;
    }

    //OnTabSelectedListener回调方法
    @Override
    public void onTabSelected(int position) {
        mLastSelection = position;
        Toast.makeText(MainActivity.this, "523378|" + position, Toast.LENGTH_SHORT).show();

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case 0:
                if (mHomeFirstFragment == null) {
                    mHomeFirstFragment = HomeFirstFragment.newInstance("精华");
                    transaction.add(R.id.home_frame_layout, mHomeFirstFragment);
                } else {
                    transaction.show(mHomeFirstFragment);
                }
                break;
            case 1:
                if (mHomeSecondFragment == null) {
                    mHomeSecondFragment = HomeSecondFragment.newInstance("最新");
                    transaction.add(R.id.home_frame_layout, mHomeSecondFragment);
                } else {
                    transaction.show(mHomeSecondFragment);
                }
                break;
            case 2:
                if (mHomeThirdFragment == null) {
                    mHomeThirdFragment = HomeThirdFragment.newInstance("心情");
                    transaction.add(R.id.home_frame_layout, mHomeThirdFragment);
                } else {
                    transaction.show(mHomeThirdFragment);
                }
                break;
            case 3:
                if (mHomeFourthFragment == null) {
                    mHomeFourthFragment = HomeFourthFragment.newInstance("夺宝");
                    transaction.add(R.id.home_frame_layout, mHomeFourthFragment);
                } else {
                    transaction.show(mHomeFourthFragment);
                }
                break;
            case 4:
                if (mHomeFifthFragment == null) {
                    mHomeFifthFragment = HomeFifthFragment.newInstance("我的");
                    transaction.add(R.id.home_frame_layout, mHomeFifthFragment);
                } else {
                    transaction.show(mHomeFifthFragment);
                }
            default:
                break;
        }
        transaction.commit();

    }


    private void hideFragment(FragmentTransaction transaction) {
        if (mHomeFirstFragment != null) {
            transaction.hide(mHomeFirstFragment);
        }
        if (mHomeSecondFragment != null) {
            transaction.hide(mHomeSecondFragment);
        }
        if (mHomeThirdFragment != null) {
            transaction.hide(mHomeThirdFragment);
        }
        if (mHomeFourthFragment != null) {
            transaction.hide(mHomeFourthFragment);
        }
        if (mHomeFifthFragment != null) {
            transaction.hide(mHomeFifthFragment);
        }
    }

    @Override
    public void onTabUnselected(int position) {
    }

    @Override
    public void onTabReselected(int position) {

    }
}
