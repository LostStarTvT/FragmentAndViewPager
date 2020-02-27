package com.proposeme.fragmentandviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gigamole.navigationtabstrip.NavigationTabStrip;

public class MainActivity extends AppCompatActivity {

    static final int NUM_ITEMS = 3;

    ViewPager mPager;
    SlidePagerAdapter mPagerAdapter;

    private NavigationTabStrip mCenterNavigationTabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到可以自动切换的承载器。
        mPager = (ViewPager) findViewById(R.id.pager);

        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mCenterNavigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts_center);
        //将导航栏与pager 绑定，并设置第几个界面，
        mCenterNavigationTabStrip.setViewPager(mPager, 0);

    }

    /* PagerAdapter class */
    public class SlidePagerAdapter extends FragmentPagerAdapter {
        SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            //进行选择1 2 3
            if (position == 0)
                return new FirstFragment();
            else if (position ==1)
                return new SecondFragment();
            else
                return new ThirdFragment();
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }
}
