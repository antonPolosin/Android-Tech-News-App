package com.example.anton.techy.InterfaceAPI;

import com.example.anton.techy.ChannelFeedProcessing.RssFeed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by anton on 14/12/17.
 */

public interface FeedArsTechnicaAPI {
    String BASE_URL = "https://arstechnica.com/";

    @GET("http://feeds.arstechnica.com/arstechnica/index")
    Call<RssFeed> getArsTechnica();


}
