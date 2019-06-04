package com.bm.mvpdemo.views.home;

import android.os.Bundle;

import com.bm.mvpdemo.base.BaseFragment;
import com.bm.mvpdemo.base.BasePresenter;

public class HomeFragment extends BaseFragment {

    public static HomeFragment create(){
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
