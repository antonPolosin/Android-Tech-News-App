package com.example.anton.techy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 12/01/18.
 */

//list of static paths to the ICONS in drawable folder

public class IconListClass {

    private static final List<String> LOGOS = new ArrayList<String>(){{
            add("drawable://" + R.drawable.techcrunch_new);
            add("drawable://" + R.drawable.hackernews);
            add("drawable://" + R.drawable.deepmind);
            add("drawable://" + R.drawable.gitxiv);

        }};

    private static final List<String> ICONS = new ArrayList<String>(){{
            add("drawable://" + R.drawable.ai_images);
            add("drawable://" + R.drawable.android_images);
            add("drawable://" + R.drawable.apple_images);
            add("drawable://" + R.drawable.gaming_images);
            add("drawable://" + R.drawable.linux_images);
            add("drawable://" + R.drawable.microsoft_images);
            add("drawable://" + R.drawable.reddit_images);
            add("drawable://" + R.drawable.reddit_images);
            add("drawable://" + R.drawable.website_design_images);
    }};

    private static final List<String> ALL = new ArrayList<String>(){{
            addAll(LOGOS);
            addAll(ICONS);
    }};

    public static List<String> getLogos() {
        return LOGOS;
    }

    public static List<String> getIcons() {
        return ICONS;
    }

    public static List<String> getAll() {
        return ALL;
    }


}
