package com.example.bohdan.gurdianapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable, CallbackClass.Callback {

    TabLayout tableLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    FragmentD fragmentD = new FragmentD();
    NetworkManager networkManager = new NetworkManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        tableLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tableLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
       /* switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
    }

    @Override
    public Model callingBack(String string) throws InterruptedException {
        networkManager.loadStringFromMain(string);

        return networkManager.model;
    }

    @Override
    public void callingBackSecondFr(String s) {

        Bundle argument = new Bundle();
        argument.putSerializable("ForCastDay", s);

        fragmentD.setArguments(argument);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.framefirst, fragmentD).addToBackStack(null).commit();

    }
    /* public void onBackPressed() {
         android.support.v4.app.FragmentManager fm =  getSupportFragmentManager();
         if (fm.getBackStackEntryCount() > 0)
             fm.popBackStack();
         else
             finish();
     }*/
    @Override
    public void callingBackButton() {
        FragmentManager fm = getFragmentManager();
        fm.popBackStack();
    }

   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }*/


}
