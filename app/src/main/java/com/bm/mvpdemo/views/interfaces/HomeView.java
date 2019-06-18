package com.bm.mvpdemo.views.interfaces;

import com.bm.mvpdemo.base.BaseView;
import com.bm.mvpdemo.bean.BannerBean;

import java.util.List;

public interface HomeView extends BaseView {

    void showBanner(List<BannerBean> data);
}
