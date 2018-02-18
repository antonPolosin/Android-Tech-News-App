package com.example.anton.techy.NewsController;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.anton.techy.Model.NewsClass;
import com.example.anton.techy.Model.ChannelFeedModel.Item;
import com.example.anton.techy.Model.ChannelFeedModel.RssFeed;
import com.example.anton.techy.InterfaceAPI.FeedChannelAPI;
import com.example.anton.techy.R;
import com.example.anton.techy.View.RecyclerViewAdapterNoImage;
import com.example.anton.techy.UtilsURL.IconListClass;
import com.example.anton.techy.UtilsURL.UrlsList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by anton on 29/01/18.
 */

public class LinuxNews extends AppCompatActivity {

    private static final String TAG = "LinuxNews";

    private android.support.v7.widget.RecyclerView recyclerView;
    private android.support.v7.widget.RecyclerView.Adapter adapter;
    private ArrayList<NewsClass> news = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    //recycler views setup
    private void initViews() {
        recyclerView = (android.support.v7.widget.RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        init();
    }


    //RSS Consuming
    private void init() {
        //initialising retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlsList.getBaseUrlsList().get(8))
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FeedChannelAPI feed = retrofit.create(FeedChannelAPI.class);

        Call<RssFeed> call = feed.getFeed(UrlsList.getRssUrlsList().get(8));

        //starting callbacks
        call.enqueue(new Callback<RssFeed>() {
            @Override
            public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                Log.d(TAG, "onResponse: feed: " + response.body().toString());

                List<Item> mItems = response.body().getmChannel().getItems();

                Log.d(TAG, "onResponse: Server Response: " + response.toString());

                //initialise arraylist to add news to the class
                for (int i = 0; i < mItems.size(); i++) {

                    news.add(new NewsClass(
                            mItems.get(i).getTitle(),
                            mItems.get(i).getPubDate(),
                            mItems.get(i).getLink(),
                            null,
                            IconListClass.getLOGOS().get(9)
                    ));
//                    adapter = new RecyclerViewAdapterNoImage(news, getApplicationContext());
//                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());

            }

        });

        //initialising retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlsList.getBaseUrlsList().get(9))
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        feed = retrofit.create(FeedChannelAPI.class);

        call = feed.getFeed(UrlsList.getRssUrlsList().get(9));

        //starting callbacks
        call.enqueue(new Callback<RssFeed>() {
            @Override
            public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                Log.d(TAG, "onResponse: feed: " + response.body().toString());

                List<Item> mItems = response.body().getmChannel().getItems();

                Log.d(TAG, "onResponse: Server Response: " + response.toString());

                //initialise arraylist to add news to the class
                for (int i = 0; i < mItems.size(); i++) {
                    news.add(new NewsClass(
                            mItems.get(i).getTitle(),
                            mItems.get(i).getPubDate(),
                            mItems.get(i).getLink(),
                            null,
                            IconListClass.getLOGOS().get(10)

                    ));

                }
                adapter = new RecyclerViewAdapterNoImage(news, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
            }
        });
    }
}
