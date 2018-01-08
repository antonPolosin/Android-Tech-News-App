package com.example.anton.techy.Android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.anton.techy.ChannelFeedProcessing.Item;
import com.example.anton.techy.ChannelFeedProcessing.RssFeed;
import com.example.anton.techy.InterfaceAPI.FeedChannelAPI;
import com.example.anton.techy.News;
import com.example.anton.techy.R;
import com.example.anton.techy.RecyclerViewAdapter;
import com.example.anton.techy.URLS;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by anton on 15/12/17.
 */

public class AndroidNewsActivity extends AppCompatActivity{

    private static final String TAG = "MainNewsActivity";

    private android.support.v7.widget.RecyclerView recyclerView;
    private android.support.v7.widget.RecyclerView.Adapter adapter;
    ArrayList<News> news = new ArrayList<News>();

    URLS url_1 = new URLS("https://www.androidauthority.com/", "https://www.androidauthority.com/feed/");
    URLS url_2 = new URLS("http://www.techmanik.com/", "http://feeds.feedburner.com/Techmanik/");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "starting");
        initViews();

    }
    //setup recycler views
    private void initViews(){
        recyclerView = (android.support.v7.widget.RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        init();
        init2();
    }


    private void init(){
        //initialising retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url_1.getBase_url())
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FeedChannelAPI feed = retrofit.create(FeedChannelAPI.class);

        Call<RssFeed> call = feed.getFeed(url_1.getUrl_path());

        //starting callbacks
        call.enqueue(new Callback<RssFeed>() {
            @Override
            public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                Log.d(TAG, "onResponse: feed: " + response.body().toString());

                List<Item> mItems = response.body().getmChannel().getItems();

                Log.d(TAG, "onResponse: Server Response: " + response.toString());

                //initialise arraylist to add news to the class
                for (int i = 0; i < mItems.size(); i++) {
//                    XmlExtraction extractVerge = new XmlExtraction(mItems.get(i).getContent(), "img src=");
//                    List<String> postContent = extractVerge.start();
                    news.add(new News(
                            mItems.get(i).getTitle(),
                            mItems.get(i).getPubDate(),
                            mItems.get(i).getLink()

                    ));

                }
                adapter = new RecyclerViewAdapter(news, getApplicationContext());
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
                Toast.makeText(AndroidNewsActivity.this, "The error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init2(){
        //initialising retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url_2.getBase_url())
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FeedChannelAPI feed = retrofit.create(FeedChannelAPI.class);

        Call<RssFeed> call = feed.getFeed(url_2.getUrl_path());

        //starting callbacks
        call.enqueue(new Callback<RssFeed>() {
            @Override
            public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                Log.d(TAG, "onResponse: feed: " + response.body().toString());

                List<Item> mItems = response.body().getmChannel().getItems();

                Log.d(TAG, "onResponse: Server Response: " + response.toString());

                //initialise arraylist to add news to the class
                for (int i = 0; i < mItems.size(); i++) {
//                    XmlExtraction extractVerge = new XmlExtraction(mItems.get(i).getContent(), "img src=");
//                    List<String> postContent = extractVerge.start();
                    news.add(new News(
                            mItems.get(i).getTitle(),
                            mItems.get(i).getPubDate(),
                            mItems.get(i).getLink()

                    ));

                }
                adapter = new RecyclerViewAdapter(news, getApplicationContext());
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
                Toast.makeText(AndroidNewsActivity.this, "The error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

