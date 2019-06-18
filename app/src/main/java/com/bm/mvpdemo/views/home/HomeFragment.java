package com.bm.mvpdemo.views.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.bm.mvpdemo.R;
import com.bm.mvpdemo.base.BaseFragment;
import com.bm.mvpdemo.base.BasePresenter;
import com.bm.mvpdemo.bean.BannerBean;
import com.bm.mvpdemo.presenter.HomePresenter;
import com.bm.mvpdemo.utils.SmartRefreshUtils;
import com.bm.mvpdemo.views.interfaces.HomeView;
import com.gyf.barlibrary.ImmersionBar;
import com.kennyc.view.MultiStateView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomeView,HomePresenter> implements HomeView {

    private static final int PAGE_START =0;

    @BindView(R.id.rl_title)
    RelativeLayout rl_title;
    @BindView(R.id.msv)
    MultiStateView msv;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    private SmartRefreshUtils smartRefreshUtils;
    private int currPage =PAGE_START;


    public static HomeFragment create(){
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }



    @Override
    protected void init(Bundle savedInstanceState) {
        ImmersionBar.setTitleBar(getActivity(),rl_title);
        showPurpleState();

        smartRefreshUtils =SmartRefreshUtils.with(srl);
        smartRefreshUtils.pureScrollMode();
        smartRefreshUtils.setRefreshListener(new SmartRefreshUtils.RefreshListener() {
            @Override
            public void onRefresh() {
              currPage=PAGE_START;
              presenter.getBanner();
              presenter.getTopAticle();
              presenter.getAticleList(currPage);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    private ImmersionBar immersionBar;
    /**
     * 设置状态栏
     */
    private void showPurpleState() {
        immersionBar = ImmersionBar.with(getActivity());
        immersionBar
//                .keyboardEnable(true)
                .navigationBarDarkIcon(true)
                .navigationBarWithKitkatEnable(false)
                .navigationBarColorTransform(R.color.colorWhite)
                .navigationBarAlpha(0.9f)
                .init();
    }

    @Override
    public void showBanner(List<BannerBean> data) {
        Log.e("yzh","size--"+data.size());
    }
}
