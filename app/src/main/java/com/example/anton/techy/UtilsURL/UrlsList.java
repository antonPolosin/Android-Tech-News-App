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
    }};



    public static List<String> getBaseUrlsList() {
        return BASE_URLS_LIST;
    }

    public static List<String> getRssUrlsList() {
        return RSS_URLS_LIST;
    }
}
