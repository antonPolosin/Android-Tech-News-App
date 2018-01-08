package com.example.anton.techy.InterfaceAPI;

import com.example.anton.techy.ChannelFeedProcessing.RssFeed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by anton on 14/12/17.
 */

public interface FeedTechCrunchAPI {

    @GET("http://feeds.feedburner.com/TechCrunch/")
    Call<RssFeed> getTechCrunch();


}
