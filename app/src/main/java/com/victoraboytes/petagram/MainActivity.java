package com.victoraboytes.petagram;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.victoraboytes.petagram.adapter.PageAdapter;
import com.victoraboytes.petagram.fragment.HomeFragment;
import com.victoraboytes.petagram.fragment.ProfileFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Declaration of objects
    private Toolbar actionBar; //Action bar declared
    private TabLayout tabLayout; //Tablayout declared
    private ViewPager viewPager; //View pager declared

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The action bar is defined in the layout file
        this.actionBar  = (Toolbar) findViewById(R.id.actionBar); //Instantiate toolbar object
        this.tabLayout       = (TabLayout) findViewById(R.id.tabLayout); //Instantiate tabLayout object
        this.viewPager       = (ViewPager) findViewById(R.id.viewPager); //Instantiate view pager object
        setUpViewPager();

        if (actionBar != null){
            setSupportActionBar(this.actionBar);
        }
    }

    private ArrayList<Fragment> addFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ProfileFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAbout:
                Intent intentAbout = new Intent(this, ActivityAbout.class);
                startActivity(intentAbout);
                break;

            case R.id.menuContact:
                Intent intentSettings = new Intent(this, ActivityContact.class);
                startActivity(intentSettings);
                break;

            case R.id.menuActionView:
                Intent intentActionView = new Intent(this, SecondActivity.class);
                startActivity(intentActionView);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
