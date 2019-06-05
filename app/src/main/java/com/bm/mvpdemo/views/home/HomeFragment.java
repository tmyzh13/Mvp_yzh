package com.bm.mvpdemo.views.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.bm.mvpdemo.R;
import com.bm.mvpdemo.base.BaseFragment;
import com.bm.mvpdemo.base.BasePresenter;
import com.kennyc.view.MultiStateView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.rl_title)
    RelativeLayout rl_title;
//    @BindView(R.id.msv)
//    MultiStateView msv;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;


    public static HomeFragment create(){
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }



    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
