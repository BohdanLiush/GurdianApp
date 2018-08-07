package com.example.bohdan.gurdianapp;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        android.support.v4.app.Fragment fragment = null;

        if (position==0){
            fragment = new FragmentA();
        }

        else if (position==1){
            fragment = new  FragmentB();
        }
        else if (position==2){
            fragment = new FragmentC();
        }
        else if (position==3){
            fragment = new FragmentE();
        }


        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position==0){
            title = "football";
        }
        else if (position==1){
            title = "business";
        }
        else if (position==2){
            title = "world news";
        }
        else if (position==3){
            title = "film";
        }

        return title;
    }
}

