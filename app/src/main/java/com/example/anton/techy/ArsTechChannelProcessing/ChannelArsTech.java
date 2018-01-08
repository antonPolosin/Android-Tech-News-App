package com.example.anton.techy.ArsTechChannelProcessing;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anton on 12/12/17.
 */
@Root(name = "channel", strict = false)

public class ChannelArsTech implements Serializable{


    @ElementList(inline = true, name = "item")
    public List<ItemArsTech> items;

    public ChannelArsTech() {
    }

    public ChannelArsTech(List<ItemArsTech> items) {
        this.items = items;
    }

    public List<ItemArsTech> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ChannelArsTech{" +
                "items=" + items +
                '}';
    }
}
