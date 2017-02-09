package com.example.zillowapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

	  public TabPagerAdapter(FragmentManager fm) {
		    super(fm);
		    // TODO Auto-generated constructor stub
		  }
		  @Override
		  public Fragment getItem(int i) {
		    switch (i) {
		        case 0:return new BasicInfoFragment();
		        case 1:return new HistZestFragment();
		        }
		    return null;
		  }
		  @Override
		  public int getCount() {
		    // TODO Auto-generated method stub
		    return 2; //No of Tabs
		  }
}
