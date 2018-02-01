package com.example.anton.techy.UtilsURL;

import com.example.anton.techy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 12/01/18.
 */

//list of static paths to the ICONS in drawable folder

public class IconListClass {

    private static final ArrayList<String> LOGOS = new ArrayList<String>(){{
            add("TechCrunch");
            add("The Verge");
            add("Hacker News");
            add("DeepMind");
            add("GitXiv");
            add("AppleInsider");
            add("Android Authority");
            add("TechManik");
            add("iPhone Hacks");
            add("LinuxTechLab");
            add("Topix");
            add("Y Combinator");
            add("CSS-Tricks");
            add("noupe");


    }};

    private static final ArrayList<String> ICONS = new ArrayList<String>(){{
            add("drawable://" + R.drawable.ai_images);
            add("drawable://" + R.drawable.android_images);
            add("drawable://" + R.drawable.apple_images);
            add("drawable://" + R.drawable.gaming_images);
            add("drawable://" + R.drawable.linux_images);
            add("drawable://" + R.drawable.microsoft_images);
            add("drawable://" + R.drawable.reddit_images);
            add("drawable://" + R.drawable.website_design_images);
    }};

    private static final List<String> ALL = new ArrayList<String>(){{
            addAll(LOGOS);
            addAll(ICONS);
    }};


    public static List<String> getLOGOS() {
        return LOGOS;
    }

    public static List<String> getIcons() {
        return ICONS;
    }

    public static List<String> getAll() {
        return ALL;
    }


}
