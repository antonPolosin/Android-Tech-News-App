package com.example.anton.techy;

import com.example.anton.techy.R;

/**
 * Created by anton on 12/01/18.
 */

//list of static paths to the icons in drawable folder

public class IconListClass {

    private static final String TECH_CRUNCH_ICON = "drawable://" + R.drawable.techcrunch_new;

    private static final String HACKER_NEWS_ICON = "drawable://" + R.drawable.hackernews;

    private static final String AI_COVER = "drawable://" + R.drawable.ai_images;

    private static final String ANDROID_COVER = "drawable://" + R.drawable.android_images;

    private static final String APPLE_COVER = "drawable://" + R.drawable.apple_images;

    private static final String GAMING_COVER = "drawable://" + R.drawable.gaming_images;

    private static final String LINUX_COVER = "drawable://" + R.drawable.linux_images;

    private static final String MICROSOFT_COVER = "drawable://" + R.drawable.microsoft_images;

    private static final String REDDIT_COVER = "drawable://" + R.drawable.reddit_images;

    private static final String WEBSITE_DESIGN_COVER = "drawable://" + R.drawable.website_design_images;

//    private static final String CRYPTOCURRENCY_COVER = "drawable://" + R.drawable.cryptocurrency_images;

//    private static final String HACKER_NEWS_ICON = "drawable://" + R.drawable.hackernews;
//
//    private static final String HACKER_NEWS_ICON = "drawable://" + R.drawable.hackernews;
//
//    private static final String HACKER_NEWS_ICON = "drawable://" + R.drawable.hackernews;

    public static String getTechCrunchIcon() {
        return TECH_CRUNCH_ICON;
    }

    public static String getHackerNewsIcon() {
        return HACKER_NEWS_ICON;
    }

    public static String getAiCover() {
        return AI_COVER;
    }

    public static String getAndroidCover() {
        return ANDROID_COVER;
    }

    public static String getAppleCover() {
        return APPLE_COVER;
    }

    public static String getGamingCover() {
        return GAMING_COVER;
    }

    public static String getLinuxCover() {
        return LINUX_COVER;
    }

    public static String getMicrosoftCover() {
        return MICROSOFT_COVER;
    }

    public static String getRedditCover() {
        return REDDIT_COVER;
    }

    public static String getWebsiteDesignCover() {
        return WEBSITE_DESIGN_COVER;
    }
}
