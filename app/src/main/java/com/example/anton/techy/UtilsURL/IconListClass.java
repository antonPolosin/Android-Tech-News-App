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
            add("drawable://" + R.drawable.aiml);
            add("drawable://" + R.drawable.android_images);
            add("drawable://" + R.drawable.apple_images);
            add("drawable://" + R.drawable.gaming_images);
            add("drawable://" + R.drawable.linux_images);
            add("drawable://" + R.drawable.microsoft_images);
            add("drawable://" + R.drawable.cryptocurrency_images);
            add("drawable://" + R.drawable.science);
    }};


    public static List<String> getLOGOS() {
        return LOGOS;
    }

    public static List<String> getIcons() {
        return ICONS;
    }

}
