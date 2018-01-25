package com.example.anton.techy.UtilsURL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 25/01/18.
 */

public class UrlsList {

    private static final List<String> BASE_URLS_LIST = new ArrayList<String>(){{
       add("https://deepmind.com/");
       add("http://www.gitxiv.com/");

    }};

    private static final List<String> RSS_URLS_LIST = new ArrayList<String>(){{
       add("https://deepmind.com/blog/feed/basic/");
       add("http://www.gitxiv.com/feed.xml");
    }};

    public static List<String> getBaseUrlsList() {
        return BASE_URLS_LIST;
    }

    public static List<String> getRssUrlsList() {
        return RSS_URLS_LIST;
    }
}
