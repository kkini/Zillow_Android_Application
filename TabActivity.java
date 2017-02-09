package com.example.zillowapp;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


public class TabActivity extends FragmentActivity implements
ActionBar.TabListener {
	ViewPager Tab;
    TabPagerAdapter TabAdapter;
  ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
       
        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        Tab = (ViewPager)findViewById(R.id.pager);
        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                      actionBar = getActionBar();
                      actionBar.setSelectedNavigationItem(position);                    }
                });
        Tab.setAdapter(TabAdapter);
        actionBar = getActionBar();
        //Enable Tabs on Action Bar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
      //Add New Tab
      actionBar.addTab(actionBar.newTab().setText("BASIC INFO").setTabListener(this));
      actionBar.addTab(actionBar.newTab().setText("HISTORICAL ZESTIMATES").setTabListener(this));
    }
	@Override
	public void onTabReselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabSelected(android.app.ActionBar.Tab tab,
			FragmentTransaction arg1) {
		Tab.setCurrentItem(tab.getPosition());
		
	}
	@Override
	public void onTabUnselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}


