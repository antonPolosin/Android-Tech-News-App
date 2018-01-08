package com.example.anton.techy.InterfaceAPI;

import com.example.anton.techy.ChannelFeedProcessing.RssFeed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by anton on 11/12/17.
 */

public interface FeedGitXivAPI {
    String BASE_URL = "http://www.gitxiv.com/";

    @GET("feed.xml")
    Call<RssFeed> getGitXiv();

}
