package com.example.bohdan.gurdianapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentA extends android.support.v4.app.Fragment {

    RecyclerView recyclerView;
    public Model model;
    public String newsCategory = "";

    static FragmentA newInstance(String newsCategory) {
        // Base fragment to reuse
        FragmentA fragment = new FragmentA();

        // Initialize bundle to store arguments
        Bundle bundle = new Bundle(1);

        // String url parameter to pass arguments when recreating {@link TopStoriesFragment}
        bundle.putString("tits", newsCategory);

        // Save arguments to the fragment instance to be called upon later
        fragment.setArguments(bundle);

        // Create and return {@link TopStoriesFragment} with the passed-in string parameter
        return fragment;

    } static FragmentA newInstanceModel(Model model) {
        // Base fragment to reuse
        FragmentA fragment = new FragmentA();

        // Initialize bundle to store arguments
        Bundle bundle = new Bundle(1);

        // String url parameter to pass arguments when recreating {@link TopStoriesFragment}
        bundle.putSerializable("tits", model);

        // Save arguments to the fragment instance to be called upon later
        fragment.setArguments(bundle);

        // Create and return {@link TopStoriesFragment} with the passed-in string parameter
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment, container, false);

        Bundle bundle = getArguments();
        if (bundle!=null){
            model = (Model) bundle.getSerializable("tits");
            System.out.println("hello");
        }

        /** string method */
        /*if (getArguments() != null) {
            newsCategory = getArguments().getString("tits");
        }*/


        recyclerView = rootView.findViewById(R.id.recycler_view);

       /* MainActivity activityHome = (MainActivity) container.getContext();
        CallbackClass callbacks = new CallbackClass();
        callbacks.registerCallBack(activityHome);
        try {
            model = callbacks.loadObject(newsCategory);
            System.out.println("sisku");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(model.getResponse().getResults());
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(container.getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MainActivity activityHome = (MainActivity) view.getContext();
                CallbackClass callbacks = new CallbackClass();
                callbacks.registerCallBack(activityHome);
                callbacks.loadObjectSecondFr(model.getResponse().getResults().get(position).getWebUrl());
            }
        }));

        return rootView;
    }
}
