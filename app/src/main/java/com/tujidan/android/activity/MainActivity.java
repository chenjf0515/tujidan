package com.tujidan.android.activity;

import android.support.v4.app.Fragment;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.title_toolbar);
        setSupportActionBar(toolbar);

        initUi();


        //http://blog.csdn.net/alcoholdi/article/details/51594061
    }

    private void initUi() {
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.main_bottom_essence_press, "精华").setActiveColorResource(R.color.colorTitle).setInactiveIconResource(R.drawable.main_bottom_essence_normal_night));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.main_bottom_latest_press, "最新").setActiveColorResource(R.color.colorTitle).setInactiveIconResource(R.drawable.main_bottom_latest_normal_night));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.main_bottom_news_press, "心情").setActiveColorResource(R.color.colorTitle).setInactiveIconResource(R.drawable.main_bottom_news_normal_night));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.inform_icon_pressed, "夺宝").setActiveColorResource(R.color.colorTitle).setInactiveIconResource(R.drawable.inform_icon));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.main_bottom_my_press, "我的").setActiveColorResource(R.color.colorTitle).setInactiveIconResource(R.drawable.main_bottom_my_normal_night));
        bottomNavigationBar.initialise();
        getFragments();
        setDefaultFragment(HomeFirstFragment.newInstance("精华"));
        bottomNavigationBar.setTabSelectedListener(this);


    }

    /**
     * 设置默认选中的fragment
     *
     * @param fragment
     */
    private void setDefaultFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.home_frame_layout, fragment);
        transaction.commit();
    }

    private void getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFirstFragment.newInstance("精华"));
        fragments.add(HomeSecondFragment.newInstance("最新"));
        fragments.add(HomeThirdFragment.newInstance("心情"));
        fragments.add(HomeFourthFragment.newInstance("夺宝"));
        fragments.add(HomeFifthFragment.newInstance("我的"));


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
        Toast.makeText(MainActivity.this,"   "+position,Toast.LENGTH_SHORT).show();
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    transaction.replace(R.id.home_frame_layout, fragment);
                } else {
                    transaction.add(R.id.home_frame_layout, fragment);
                }
                transaction.commitAllowingStateLoss();
            }
        }

    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                Fragment fragment = fragments.get(position);
                fragmentTransaction.remove(fragment);
                fragmentTransaction.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }
}
