package com.tujidan.android.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tujidan.android.R;
import com.tujidan.android.db.TopTab;
import com.tujidan.android.db.TopTableDb;

import java.util.ArrayList;
import java.util.List;


public class HomeFirstFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private static final String ARG_PARAM1 = "param1";
    private View mView;
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private HorizontalScrollView mHorizontalScrollView;
    HomeFirstFragmentAdapter adapter;
    private List<Fragment> mFragmentList = new ArrayList<>();


    public HomeFirstFragment() {
    }

    public static HomeFirstFragment newInstance(String param1) {
        HomeFirstFragment fragment = new HomeFirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_home_first, container, false);
            mRadioGroup = (RadioGroup) mView.findViewById(R.id.radio_group);
            mViewPager = (ViewPager) mView.findViewById(R.id.first_view);
            mRadioGroup = (RadioGroup) mView.findViewById(R.id.radio_group);
            mHorizontalScrollView = (HorizontalScrollView) mView.findViewById(R.id.horizontal_scrollview);
            mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    mViewPager.setCurrentItem(checkedId);
                }
            });
            //初始化顶部导航栏
            initTable(inflater);
            //初始化view pager
            initView();

        }

           /*
            * 底部导航栏切换后 由于没有销毁顶部设置导致如果没有重新设置view
            * 导致底部切换后切回顶部页面数据会消失等bug
            * 以下设置每次重新创建view即可
            */
        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null) {
            parent.removeView(mView);
        }
        return mView;
    }

    /**
     * 初始化顶部导航栏
     *
     * @param inflater
     */

    private void initTable(LayoutInflater inflater) {
        List<TopTab> topTabList = TopTableDb.getSelected();
        for (int i = 0; i < topTabList.size(); i++) {
            RadioButton radioButton = (RadioButton) inflater.inflate(R.layout.top_table, null);
            radioButton.setId(i);
            radioButton.setText(topTabList.get(i).getName());
            LayoutParams params = new LayoutParams();
            mRadioGroup.addView(radioButton, params);

            mRadioGroup.check(0);

        }
        //默认点击
        mRadioGroup.check(0);
    }

    private void initView() {
        List<TopTab> topTabList = TopTableDb.getSelected();
        for (int i = 0; i < topTabList.size(); i++) {

            FirstFirstFragment first = FirstFirstFragment.newInstance(topTabList.get(i).getName());
            mFragmentList.add(first);
        }
        adapter = new HomeFirstFragmentAdapter(getActivity().getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(adapter);

        //两个view pager切换不重新加载
        mViewPager.setOffscreenPageLimit(2);
        //设置默认
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(this);

    }

    /**
     * 页面专挑切换头偏移
     *
     * @param id
     */
    private void setTab(int id) {
        RadioButton radioButton = (RadioButton) mRadioGroup.getChildAt(id);
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int offest = radioButton.getLeft() - screenWidth / 2 + (radioButton.getRight() - radioButton.getLeft()) * 2;
        mHorizontalScrollView.smoothScrollTo(offest,0);
    }

    /**
     * state滑动中的状态 有三种状态（0，1，2） 1：正在滑动 2：滑动完毕 0：什么都没做。
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset == 0){

        }
    }

    @Override
    public void onPageSelected(int position) {
        setTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
