package com.example.anton.techy.UtilsURL;

/**
 * Created by anton on 19/12/17.
 */

public class URLS {

    private String base_url;

    private String rss_url;

    public URLS(String base_url, String url_path) {
        this.base_url = base_url;
        this.rss_url = url_path;
    }

    public String getBase_url() {
        return base_url;
    }

    public String getRss_url() {
        return rss_url;
    }
}
