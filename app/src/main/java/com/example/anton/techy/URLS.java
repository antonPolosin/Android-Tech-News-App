package com.example.anton.techy;

/**
 * Created by anton on 19/12/17.
 */

public class URLS {

    private String base_url;

    private String url_path;

    public URLS(String base_url, String url_path) {
        this.base_url = base_url;
        this.url_path = url_path;
    }

    public String getBase_url() {
        return base_url;
    }

    public String getUrl_path() {
        return url_path;
    }
}
