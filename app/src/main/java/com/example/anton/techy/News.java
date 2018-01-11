package com.example.anton.techy;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by anton on 9/12/17.
 */

public class News {

    PrettyTime p = new PrettyTime(Locale.getDefault());


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());


    private String title;
    private String updated;
    private String newsImage;
    private String newsURL;
    private String iconImage;

    public News() {

    }

    public News(String title, String updated, String newsURL) {
        this.title = title;
        this.updated = updated;
        this.newsURL = newsURL;
    }

    public News(String title, String updated, String newsImage, String newsURL) {
        this.title = title;
        this.updated = updated;
        this.newsImage = newsImage;
        this.newsURL = newsURL;
    }

    public News(String title, String updated, String newsURL, String newsImage, String iconImage) {
        this.title = title;
        this.updated = updated;
        this.newsImage = newsImage;
        this.newsURL = newsURL;
        this.iconImage = iconImage;

    }


    public String getTitle() {
        return title;
    }

    public String getUpdated() {
        return updated;
    }

    public String getNewsURL() {
        return newsURL;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public void setNewsURL(String newsURL) {
        this.newsURL = newsURL;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getIconNews() {
        return iconImage;
    }

    public void setIconNews(String iconImage) {
        this.iconImage = iconImage;
    }
}
