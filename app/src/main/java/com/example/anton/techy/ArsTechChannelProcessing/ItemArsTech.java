package com.example.anton.techy.ArsTechChannelProcessing;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by anton on 12/12/17.
 */
@Root(name = "item", strict = false)

public class ItemArsTech implements Serializable{
    @Element(name = "title")
    private String title;
    @Element(name = "link")
    private String link;
    @Element(name = "pubDate")
    private String pubDate;
    @Element(name = "media:thumbnail")
    private String contentEncoded;

    public ItemArsTech(String title, String link, String pubDate, String contentEncoded) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.contentEncoded = contentEncoded;
    }

    public ItemArsTech() {
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getContent() {
        return contentEncoded;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public void setContent(String content) {
        this.contentEncoded = content;
    }



    @Override
    public String toString() {
        return "ItemArsTech{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", ContentEncoded='" + contentEncoded + '\'' +
                '}' + "\n" +
                "---------------------------------------------------------------------------------------------------------------";
    }
}
