package com.example.anton.techy.ChannelFeedProcessing;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anton on 12/12/17.
 */
@Root(name = "channel", strict = false)

public class Channel implements Serializable{


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

    @Override
    public String toString() {
        return "ChannelArsTech{" +
                "items=" + items +
                '}';
    }
}
