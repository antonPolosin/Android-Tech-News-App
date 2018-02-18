package com.example.anton.techy.InterfaceAPI;

import com.example.anton.techy.Model.ChannelFeedModel.RssFeed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by anton on 19/12/17.
 */

public interface FeedChannelAPI {

    @GET
    Call<RssFeed> getFeed(@Url String url);
}
