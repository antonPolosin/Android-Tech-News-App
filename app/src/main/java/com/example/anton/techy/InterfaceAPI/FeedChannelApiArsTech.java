package com.example.anton.techy.InterfaceAPI;

import com.example.anton.techy.ArsTechChannelProcessing.RssFeedArsTech;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by anton on 4/01/18.
 */

public interface FeedChannelApiArsTech {

    @GET
    Call<RssFeedArsTech> getFeed(@Url String url);
}
