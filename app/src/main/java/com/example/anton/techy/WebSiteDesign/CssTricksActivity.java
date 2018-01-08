package com.example.anton.techy.WebSiteDesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.anton.techy.ChannelFeedProcessing.Item;
import com.example.anton.techy.ChannelFeedProcessing.RssFeed;
import com.example.anton.techy.InterfaceAPI.FeedChannelAPI;
import com.example.anton.techy.News;
import com.example.anton.techy.R;
import com.example.anton.techy.URLS;

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

public class CssTricksActivity extends AppCompatActivity {

    private static final String TAG = "CssTricksActivity";

    URLS usedUrls = new URLS("https://css-tricks.com/", "https://css-tricks.com/feed/");




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "starting");
        init();

    }

    private void init(){
        //initialising retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(usedUrls.getBase_url())
                //converter XML
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FeedChannelAPI feed = retrofit.create(FeedChannelAPI.class);

        Call<RssFeed> call = feed.getFeed(usedUrls.getUrl_path());

        //starting callbacks
        call.enqueue(new Callback<RssFeed>() {
            @Override
            public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                Log.d(TAG, "onResponse: feed: " + response.body().toString());

                List<Item> mItems = response.body().getmChannel().getItems();

                Log.d(TAG, "onResponse: Server Response: " + response.toString());

                //initialise arraylist to add news to the class
                ArrayList<News> news = new ArrayList<News>();
                for (int i = 0; i < mItems.size(); i++) {
                    news.add(new News(
                            mItems.get(i).getTitle(),
                            mItems.get(i).getPubDate(),
                            mItems.get(i).getLink()

                    ));

                }
                //SET UP LIST VIEW TO CARD LAYOUT

            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
                Toast.makeText(CssTricksActivity.this, "The error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}