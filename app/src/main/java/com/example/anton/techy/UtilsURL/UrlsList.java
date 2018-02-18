package com.example.anton.techy.UtilsURL;

import com.example.anton.techy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 25/01/18.
 */

public class UrlsList {

    private static final List<String> BASE_URLS_LIST = new ArrayList<String>(){{
       add("https://deepmind.com/");
       add("http://www.gitxiv.com/");
       add("https://www.androidauthority.com/");
       add("http://www.techmanik.com/");
       add("http://appleinsider.com/");
       add("http://www.iphonehacks.com/");
       add("https://www.theverge.com/");
       add("https://techcrunch.com/");
       add("http://linuxtechlab.com/");
       add("http://www.topix.com/");
       add("https://news.ycombinator.com/news/");
       add("https://css-tricks.com/");
       add("https://www.noupe.com/");
       add("https://www.anandtech.com/");
       add("http://www.redmondpie.com/");
       add("https://thenextweb.com/au/");
    }};

    private static final List<String> RSS_URLS_LIST = new ArrayList<String>(){{
       add("https://deepmind.com/blog/feed/basic/");
       add("http://www.gitxiv.com/feed.xml");
       add("https://www.androidauthority.com/feed/");
       add("http://feeds.feedburner.com/Techmanik/");
       add("http://appleinsider.com/rss/topic/iphone");
       add("http://www.iphonehacks.com/feed");
       add("https://www.theverge.com/rss/index.xml");
       add("http://feeds.feedburner.com/TechCrunch/");
       add("http://feeds.feedburner.com/LnuxTech-lb");
       add("http://www.topix.com/rss/tech/linux");
       add("https://news.ycombinator.com/bigrss");
       add("https://css-tricks.com/feed/");
       add("https://www.noupe.com/feed");
       add("https://www.anandtech.com/rss/");
       add("http://feeds.feedburner.com/RedmondPie");
       add("http://feeds2.feedburner.com/thenextweb");

    }};
    private static final List<String> AI_NEWS = new ArrayList<String>(){{
        add("https://deepmind.com/");
        add("https://deepmind.com/blog/feed/basic/");
        add("http://www.gitxiv.com/");
        add("http://www.gitxiv.com/feed.xml");

    }};


    static private final List<String> GAMING_NEWS = new ArrayList<String>(){{
        add("http://nichegamer.com/");
        add("http://feeds.feedburner.com/nichegamer");
        add("https://www.gamewatcher.com/");
        add("https://www.gamewatcher.com/feeds/rss");
    }};

    static private final List<String> CRYPTOCURRENCY_NEWS = new ArrayList<String>(){{
        add("https://www.newsbtc.com/");
        add("https://www.newsbtc.com/feed/");
        add("https://cointelegraph.com/");
        add("https://cointelegraph.com/rss");
        add("https://coinjournal.net/");
        add("http://feeds.feedburner.com/coinjournal");
    }};

    static private final List<String> SCIENCE_NEWS = new ArrayList<String>(){{
        add("https://www.sciencedaily.com/");
        add("https://www.sciencedaily.com/rss/all.xml");
        add("http://discovermagazine.com/");
        add("http://feeds.feedburner.com/AllDiscovermagazinecomContent");
    }};

    static private final List<String> MICROSOFT_NEWS = new ArrayList<String>(){{
        add("https://www.windowscentral.com/");
        add("http://feeds.windowscentral.com/wmexperts");
    }};


    public static List<String> getMicrosoftNews() {
        return MICROSOFT_NEWS;
    }

    public static List<String> getAiNews() {
        return AI_NEWS;
    }

    public static List<String> getBaseUrlsList() {
        return BASE_URLS_LIST;
    }

    public static List<String> getRssUrlsList() {
        return RSS_URLS_LIST;
    }

    public static List<String> getGamingNews() {
        return GAMING_NEWS;
    }

    public static List<String> getCryptocurrencyNews() {
        return CRYPTOCURRENCY_NEWS;
    }

    public static List<String> getScienceNews() {
        return SCIENCE_NEWS;
    }
}
