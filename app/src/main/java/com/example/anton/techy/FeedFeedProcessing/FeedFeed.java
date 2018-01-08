package com.example.anton.techy.FeedFeedProcessing;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anton on 6/12/17.
 */
@Root(name = "feed", strict = false)

public class FeedFeed implements Serializable{


    @Element(name = "icon")
    private String icon;
    @Element(name = "title")
    private String title;
    @Element(name = "updated")
    private String updated;


    @ElementList(inline = true, name = "entry")
    private List<Entry> entries;

    public FeedFeed(){

    }

    public String getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdated() {
        return updated;
    }

    public List<Entry> getEntries() {
        return entries;
    }


    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "RssFeedArsTech: \n [Entries: \n" + entries + "]";
    }
}
