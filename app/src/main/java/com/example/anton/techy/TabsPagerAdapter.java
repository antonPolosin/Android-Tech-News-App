package com.example.anton.techy;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.anton.techy.YCombinatorFirebase.HackerNews;

/**
 * Created by anton on 24/01/18.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter{

    String tabTitles[] = new String[]{"News", "Hacker News", "Topics"};
    Context mContext;



    public TabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }



    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                return new MainNews();
            case 1:
                return new HackerNews();
            case 2:
                return new MainActivity();
            }

        return null;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    public View getTabView(int position){
        View tab = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) tab.findViewById(R.id.custom_text);
        tv.setText(tabTitles[position]);
        return tab;
    }


}
