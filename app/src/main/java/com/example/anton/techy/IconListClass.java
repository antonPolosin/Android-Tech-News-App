package com.example.anton.techy;

import com.example.anton.techy.R;

/**
 * Created by anton on 12/01/18.
 */

//list of static paths to the icons in drawable folder

public class IconListClass {

    private static final String TECH_CRUNCH_ICON = "drawable://" + R.drawable.techcrunch_new;

    private static final String HACKER_NEWS_ICON = "drawable://" + R.drawable.hackernews;

    public static String getTechCrunchIcon() {
        return TECH_CRUNCH_ICON;
    }

    public static String getHackerNewsIcon() {
        return HACKER_NEWS_ICON;
    }
}
