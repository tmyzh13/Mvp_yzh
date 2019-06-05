package com.bm.mvpdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.bm.mvpdemo.adapter.FixedFragmentPagerAdapter;
import com.bm.mvpdemo.base.BaseActivity;
import com.bm.mvpdemo.base.BasePresenter;
import com.bm.mvpdemo.views.home.HomeFragment;
import com.kennyc.view.MultiStateView;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.ll_home)
    LinearLayout ll_home;
    @BindView(R.id.ll_book)
    LinearLayout ll_book;
    @BindView(R.id.ll_wechat)
    LinearLayout ll_wechat;
    @BindView(R.id.ll_project)
    LinearLayout ll_project;
    @BindView(R.id.ll_mine)
    LinearLayout ll_mine;
    @BindView(R.id.vp)
    ViewPager vp;

    private FixedFragmentPagerAdapter mPagerAdapter;




    @Override
    protected void init(Bundle savedInstanceState) {
        ll_home.setSelected(true);

        vp.addOnPageChangeListener(this);
        vp.setOffscreenPageLimit(4);
        mPagerAdapter =new FixedFragmentPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mPagerAdapter);
        mPagerAdapter.setFragmentList(HomeFragment.create());

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter creatPresenter() {
        return null;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
