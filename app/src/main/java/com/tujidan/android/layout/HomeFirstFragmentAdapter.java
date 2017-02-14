package com.tujidan.android.layout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */

public class HomeFirstFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();

    public HomeFirstFragmentAdapter(FragmentManager fm) {
        super(fm);


    }
    public HomeFirstFragmentAdapter(FragmentManager fragmentManager,List<Fragment> list){
        super(fragmentManager);
        fragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
