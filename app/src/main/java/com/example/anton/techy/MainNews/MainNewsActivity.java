package com.example.anton.techy.MainNews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.anton.techy.ChannelFeedProcessing.Item;
import com.example.anton.techy.ChannelFeedProcessing.RssFeed;
import com.example.anton.techy.FeedFeedProcessing.Entry;
import com.example.anton.techy.FeedFeedProcessing.FeedFeed;
import com.example.anton.techy.FeedFeedProcessing.XmlExtraction;
import com.example.anton.techy.InterfaceAPI.FeedChannelAPI;
import com.example.anton.techy.InterfaceAPI.FeedFeedAPI;
import com.example.anton.techy.News;
import com.example.anton.techy.R;
import com.example.anton.techy.RecyclerViewAdapter;
import com.example.anton.techy.URLS;
import com.example.anton.techy.YCombinatorFirebase.IconImageList;

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

public class MainNewsActivity extends AppCompatActivity {

    private static final String TAG = "MainNewsActivity";

    private android.support.v7.widget.RecyclerView recyclerView;
    private android.support.v7.widget.RecyclerView.Adapter adapter;
    private ArrayList<News> news = new ArrayList<News>();
    private String iconImage;

    URLS vergeUrl = new URLS("https://www.theverge.com/", "https://www.theverge.com/rss/index.xml");

    URLS arsTechUrl = new URLS("https://arstechnica.com/", "http://feeds.arstechnica.com/arstechnica/index");

    URLS techCrunchUrl = new URLS("https://techcrunch.com/", "http://feeds.feedburner.com/TechCrunch/");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "starting");

        initViews();

    }

    private void initViews(){
        recyclerView = (android.support.v7.widget.RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        init();
//        init2();
        init3();
    }

    private void init() {
        //initialising retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(vergeUrl.getBase_url())
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        final FeedFeedAPI feed = retrofit.create(FeedFeedAPI.class);

        Call<FeedFeed> call = feed.getFeed(vergeUrl.getUrl_path());


        //starting callbacks
        call.enqueue(new Callback<FeedFeed>() {
            @Override
            public void onResponse(Call<FeedFeed> call, Response<FeedFeed> response) {
                List<Entry> entries = response.body().getEntries();
                //getting icon from the header of the rss feed
                iconImage = response.body().getIcon();

                for (int i = 0; i < entries.size(); i++) {
                    //Extracting image from the verge feed
                    XmlExtraction extractVerge = new XmlExtraction(entries.get(i).getContent(), "img alt=\"\" src=");
                    List<String> postContent = extractVerge.start();

                    //adding news to the arrayList
                    news.add(new News(
                            entries.get(i).getTitle(),
                            entries.get(i).getUpdated(),
                            entries.get(i).getId(),
                            postContent.get(0),
                            iconImage

                    ));

                }
                adapter = new RecyclerViewAdapter(news, getApplicationContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<FeedFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
                Toast.makeText(MainNewsActivity.this, "The error occured", Toast.LENGTH_SHORT).show();
            }
        });


    }

//    private void init2() {
//        //initialising retrofit
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(arsTechUrl.getBase_url())
//                //converter XML
//                .addConverterFactory(SimpleXmlConverterFactory.create())
//                .build();
//
//        FeedChannelApiArsTech feed = retrofit.create(FeedChannelApiArsTech.class);
//        Call<RssFeedArsTech> call = feed.getFeed(arsTechUrl.getUrl_path());
////        Call<RssFeedArsTech> call = feed.getFeed(arsTechUrl.getUrl_path());
//
//        //starting callbacks
//        call.enqueue(new Callback<RssFeedArsTech>() {
//            @Override
//            public void onResponse(Call<RssFeedArsTech> call, Response<RssFeedArsTech> response) {
//                Log.d(TAG, "onResponse: feed: " + response.body().toString());
//
//                List<ItemArsTech> mItems = response.body().getmChannel().getItems();
//
//                Log.d(TAG, "onResponse: Server Response: " + response.toString());
//
//                //initialise arraylist to add news to the class
//                for (int i = 0; i < mItems.size(); i++) {
//                    XmlExtraction extractVerge = new XmlExtraction(mItems.get(i).getContent(), "<img src=");
//                    List<String> postContent = extractVerge.start();
//
//                    int lastPosition = postContent.size() - 1;
//
//                    try {
//                        news.add(new News(
//                                mItems.get(i).getTitle(),
//                                mItems.get(i).getPubDate(),
//                                mItems.get(i).getLink(),
//                                postContent.get(lastPosition)
//                        ));
//                    }catch(NullPointerException e){
//                        e.getMessage();
//                    }
//
//                }
//                adapter = new RecyclerViewAdapter(news, getApplicationContext());
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<RssFeedArsTech> call, Throwable t) {
//        Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
//        Toast.makeText(MainNewsActivity.this, "The error occured", Toast.LENGTH_SHORT).show();
//            }
//
//
//    });
//    }

    private void init3(){
        //initialising retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(techCrunchUrl.getBase_url())
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FeedChannelAPI feed = retrofit.create(FeedChannelAPI.class);

        Call<RssFeed> call = feed.getFeed(techCrunchUrl.getUrl_path());

        //starting callbacks
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
                    news.add(new News(
                            mItems.get(i).getTitle(),
                            mItems.get(i).getPubDate(),
                            mItems.get(i).getLink(),
                            postContent.get(0),
                            IconImageList.getTechCrunchIcon()
                    ));

                }
                adapter = new RecyclerViewAdapter(news, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
                Toast.makeText(MainNewsActivity.this, "The error occured", Toast.LENGTH_SHORT).show();
            }

        });
    }
}


