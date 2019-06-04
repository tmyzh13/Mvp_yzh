package com.bm.mvpdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FixedFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] mFragments = null;
    private String[] mTitles = null;

    public FixedFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragmentList(Fragment... fragments){
        this.mFragments = fragments;
        notifyDataSetChanged();
    }

    public void setTitles(String... titles){
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null && mTitles.length == getCount()) {
            return mTitles[position];
        }

        Fragment fragment =mFragments[position];
        if (fragment instanceof PageTitle) {
            PageTitle pageTitle = (PageTitle) fragment;
            return pageTitle.getPageTitle();
        }
        return "";
    }

    public interface  PageTitle{
        CharSequence getPageTitle();
    }
}
