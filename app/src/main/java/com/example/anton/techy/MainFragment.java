package com.example.anton.techy;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anton.techy.View.TabsPagerAdapter;


/**
 * Created by anton on 24/01/18.
 */

//activity holding 3 tabs fragment
public class MainFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main_activity);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabsPagerAdapter pagerAdapter = new TabsPagerAdapter(getSupportFragmentManager(), MainFragment.this);
        viewPager.setAdapter(pagerAdapter);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);


    }
}
