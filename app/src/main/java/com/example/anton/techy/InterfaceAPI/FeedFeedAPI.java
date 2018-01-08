package com.example.anton.techy.InterfaceAPI;

import com.example.anton.techy.FeedFeedProcessing.FeedFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by anton on 18/12/17.
 */
//Interface to process RSS feeds which have the following structure
// <feed>
// <entry>
// </entry>
// </feed>
public interface FeedFeedAPI {
    @GET
    Call<FeedFeed> getFeed(@Url String url);

}
