package com.example.bohdan.gurdianapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    Model model;
    String s;
    NetworkManager networkManager = new NetworkManager();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Model getModelNetworkManagerToFragment(String s) throws InterruptedException {
        networkManager.loadStringFromMain(s);
        return networkManager.model;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        android.support.v4.app.Fragment fragment = null;


        switch (position) {
            case 0:
                s = "football";

                try {
                    model = getModelNetworkManagerToFragment(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                  /*
                    Bundle argument = new Bundle();
                    argument.putSerializable("Model", model);
                    fragmentA.setArguments(argument);*/

                //fragment = FragmentA.newInstance(s);
                fragment = FragmentA.newInstanceModel(model);
                return fragment;


            case 1:
                s = "business";
                try {
                    model = getModelNetworkManagerToFragment(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //fragment = FragmentA.newInstance(s);
                fragment = FragmentA.newInstanceModel(model);

                return fragment;
            case 2:
                s = "film";
                try {
                    model = getModelNetworkManagerToFragment(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //fragment = FragmentA.newInstance(s);
                fragment = FragmentA.newInstanceModel(model);

                return fragment;

            default:
                return null;
        }
        /*if (position==0){

            fragment = new FragmentA();

            s = "football";
            try {

                model = getModelNetworkManagerToFragment(s);
                Bundle argument = new Bundle();
                argument.putSerializable("Model", model);

                fragmentA.setArguments(argument);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fragment = new FragmentA();


        }
        else if (position==1){
            fragment = new  FragmentB();
            s = "business";
            try {
                model = getModelNetworkManagerToFragment(s);
                Bundle argument = new Bundle();
                argument.putSerializable("Model", model);

                fragmentB.setArguments(argument);
                //fragment = new FragmentB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fragment = new FragmentB();

        }
        else if (position==2){
            //fragment = new FragmentC();
        }
        else if (position==3){
            //fragment = new FragmentE();
        }
        return fragment;*/


    }

    @Override
    public int getCount() {
        return 3;
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
            title = "film";
        }
        else if (position==3){
            title = "world news";
        }

        return title;
    }
}

