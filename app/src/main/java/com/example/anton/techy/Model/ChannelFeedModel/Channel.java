package com.example.anton.techy.Model.ChannelFeedModel;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anton on 12/12/17.
 */
@Root(name = "channel", strict = false)

public class Channel implements Serializable{

    @Element(name = "title")
    private String title;
    @ElementList(inline = true, name = "item")
    public List<Item> items;

    public Channel() {
    }

    public Channel(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ChannelArsTech{" +
                "items=" + items +
                '}';
    }
}
