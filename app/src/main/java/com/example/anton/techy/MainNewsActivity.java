package com.example.anton.techy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anton.techy.ChannelFeedProcessing.Item;
import com.example.anton.techy.ChannelFeedProcessing.RssFeed;
import com.example.anton.techy.FeedFeedProcessing.Entry;
import com.example.anton.techy.FeedFeedProcessing.FeedFeed;
import com.example.anton.techy.FeedFeedProcessing.XmlExtraction;
import com.example.anton.techy.InterfaceAPI.FeedChannelAPI;
import com.example.anton.techy.InterfaceAPI.FeedFeedAPI;
import com.example.anton.techy.UtilsURL.URLS;
import com.example.anton.techy.UtilsURL.UrlsList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by anton on 7/12/17.
 */

public class MainNewsActivity extends android.support.v4.app.Fragment {

    private static final String TAG = "MainNewsActivity";

    private android.support.v7.widget.RecyclerView recyclerView;
    private android.support.v7.widget.RecyclerView.Adapter adapter;
    private ArrayList<NewsClass> news = new ArrayList();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        recyclerView = (android.support.v7.widget.RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        init();
        return rootView;
    }

    private void init() {
        //initialising retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlsList.getBaseUrlsList().get(6))
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FeedFeedAPI feed = retrofit.create(FeedFeedAPI.class);

        Call<FeedFeed> call = feed.getFeed(UrlsList.getRssUrlsList().get(6));


        //starting callbacks
        call.enqueue(new Callback<FeedFeed>() {
            @Override
            public void onResponse(Call<FeedFeed> call, Response<FeedFeed> response) {
                List<Entry> entries = response.body().getEntries();
                //getting icon from the header of the rss feed
                for (int i = 0; i < entries.size(); i++) {
                    //Extracting image from the verge feed
                    XmlExtraction extractVerge = new XmlExtraction(entries.get(i).getContent(), "img alt=\"\" src=");
                    List<String> postContent = extractVerge.start();

                    //adding news to the arrayList
                    news.add(new NewsClass(
                            entries.get(i).getTitle(),
                            entries.get(i).getUpdated(),
                            entries.get(i).getId(),
                            postContent.get(0),
                            IconListClass.getLOGOS().get(1)

                    ));

                }
                adapter = new RecyclerViewAdapterImage(news, getActivity());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<FeedFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());

            }
        });


        //initialising retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlsList.getBaseUrlsList().get(7))
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FeedChannelAPI feed_2 = retrofit.create(FeedChannelAPI.class);

        Call<RssFeed> call_2 = feed_2.getFeed(UrlsList.getRssUrlsList().get(7));

        //starting callbacks
        call_2.enqueue(new Callback<RssFeed>() {
            @Override
            public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                Log.d(TAG, "onResponse: feed: " + response.body().toString());

                List<Item> mItems = response.body().getmChannel().getItems();

                Log.d(TAG, "onResponse: Server Response: " + response.toString());

                //initialise arraylist to add news to the class
                for (int i = 0; i < mItems.size(); i++) {
                    XmlExtraction extractVerge = new XmlExtraction(mItems.get(i).getDescription(), "src=");
                    List<String> postContent = extractVerge.start();
                    news.add(new NewsClass(
                            mItems.get(i).getTitle(),
                            mItems.get(i).getPubDate(),
                            mItems.get(i).getLink(),
                            postContent.get(0),
                            IconListClass.getLOGOS().get(0)
                    ));

                }
                adapter = new RecyclerViewAdapterImage(news, getActivity());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());

            }

        });
    }
}



