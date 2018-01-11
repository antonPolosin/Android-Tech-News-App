package com.example.anton.techy.ChannelFeedProcessing;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by anton on 12/12/17.
 */

@Root(name = "rss", strict = false)

public class RssFeed implements Serializable{

    @Element(name = "channel")
    private Channel mChannel;
    private String iconImage;

    public RssFeed() {
    }

    public Channel getmChannel() {
        return mChannel;
    }

    public String getIconImage() {
        return iconImage;
    }

    public RssFeed(Channel mChannel) {
        this.mChannel = mChannel;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    @Override
    public String toString() {
        return "RssFeedArsTech{" +
                "mChannel=" + mChannel +
                '}';
    }
}
