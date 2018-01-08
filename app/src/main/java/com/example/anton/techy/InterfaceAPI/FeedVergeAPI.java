package com.example.anton.techy.InterfaceAPI;

import com.example.anton.techy.FeedFeedProcessing.FeedFeed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by anton on 6/12/17.
 */

public interface FeedVergeAPI {

    String BASE_URL = "https://www.theverge.com/";

    @GET("rss/index.xml")
    Call<FeedFeed> getFeedVerge();

}
