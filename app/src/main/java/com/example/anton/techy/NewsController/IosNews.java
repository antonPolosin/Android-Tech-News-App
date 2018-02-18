package com.example.anton.techy.NewsController;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.anton.techy.Model.ChannelFeedModel.Item;
import com.example.anton.techy.Model.ChannelFeedModel.RssFeed;
import com.example.anton.techy.Model.FeedFeedModel.XmlExtraction;
import com.example.anton.techy.UtilsURL.IconListClass;
import com.example.anton.techy.InterfaceAPI.FeedChannelAPI;
import com.example.anton.techy.Model.NewsClass;
import com.example.anton.techy.R;
import com.example.anton.techy.View.RecyclerViewAdapterImage;
import com.example.anton.techy.UtilsURL.UrlsList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by anton on 20/12/17.
 */

public class IosNews extends AppCompatActivity {

    private static final String TAG = "AiMlNews";

    private android.support.v7.widget.RecyclerView recyclerView;
    private android.support.v7.widget.RecyclerView.Adapter adapter;
    private ArrayList<NewsClass> news = new ArrayList<>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    //setup recycler views
    private void initViews() {
        recyclerView = (android.support.v7.widget.RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        init();

    }


    private void init() {
        //initialising retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlsList.getBaseUrlsList().get(4))
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FeedChannelAPI feed = retrofit.create(FeedChannelAPI.class);

        Call<RssFeed> call = feed.getFeed(UrlsList.getRssUrlsList().get(4));


        //starting callbacks
        call.enqueue(new Callback<RssFeed>() {
            @Override
            public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                Log.d(TAG, "onResponse: feed: " + response.body().toString());

                List<Item> mItems = response.body().getmChannel().getItems();

                Log.d(TAG, "onResponse: Server Response: " + response.toString());

                //initialise arraylist to add news to the class

                for (int i = 0; i < mItems.size(); i++) {
                    XmlExtraction extractVerge = new XmlExtraction(mItems.get(i).getDescription(), "img src=");
                    List<String> postContent = extractVerge.start();
                    news.add(new NewsClass(
                            mItems.get(i).getTitle(),
                            mItems.get(i).getPubDate(),
                            mItems.get(i).getLink(),
                            postContent.get(0),
                            IconListClass.getLOGOS().get(5)

                    ));

                }
            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
                Toast.makeText(IosNews.this, "The error occured", Toast.LENGTH_SHORT).show();
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl(UrlsList.getBaseUrlsList().get(5))
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        feed = retrofit.create(FeedChannelAPI.class);

        call = feed.getFeed(UrlsList.getRssUrlsList().get(5));
        call.enqueue(new Callback<RssFeed>() {
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
                            IconListClass.getLOGOS().get(8)
                    ));

                }
                adapter = new RecyclerViewAdapterImage(news, getApplicationContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
                Toast.makeText(IosNews.this, "The error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

