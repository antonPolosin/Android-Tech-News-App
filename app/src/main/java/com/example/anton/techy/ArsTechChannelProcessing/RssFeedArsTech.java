package com.example.anton.techy.ArsTechChannelProcessing;

import com.example.anton.techy.ChannelFeedProcessing.Channel;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by anton on 12/12/17.
 */

@Root(name = "rss", strict = false)

public class RssFeedArsTech implements Serializable{

    @Element(name = "channel")
    private ChannelArsTech mChannel;

    public ChannelArsTech getmChannel() {
        return mChannel;
    }

    public RssFeedArsTech(ChannelArsTech mChannel) {
        this.mChannel = mChannel;
    }

    @Override
    public String toString() {
        return "RssFeedArsTech{" +
                "mChannel=" + mChannel +
                '}';
    }
}
