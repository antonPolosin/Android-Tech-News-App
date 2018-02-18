package com.example.anton.techy.Model;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by anton on 9/12/17.
 */

public class NewsClass{

    private String title;
    private String updated;
    private String newsImage;
    private String newsURL;
    private String source;

    public NewsClass() {

    }

    public NewsClass(String title, String updated, String newsURL) {
        this.title = title;
        this.updated = updated;
        this.newsURL = newsURL;
    }

    public NewsClass(String title, String updated, String newsImage, String newsURL) {
        this.title = title;
        this.updated = updated;
        this.newsImage = newsImage;
        this.newsURL = newsURL;
    }

    public NewsClass(String title, String updated, String newsURL, String newsImage, String iconImage) {
        this.title = title;
        this.updated = updated;
        this.newsImage = newsImage;
        this.newsURL = newsURL;
        this.source = iconImage;

    }

    public String formattedDate(String inputDate){
        PrettyTime p = new PrettyTime(Locale.getDefault());
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.getDefault());
        Date d = null;
        try {
            d = sdf.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return p.format(d);
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}

