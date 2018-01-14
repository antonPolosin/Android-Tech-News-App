package com.example.anton.techy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by anton on 13/01/18.
 */

public class RecyclerViewAdapterNoImage extends android.support.v7.widget.RecyclerView.Adapter<RecyclerViewAdapterNoImage.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapterNoImage";

    private List<NewsClass> newsItems;
    private Context mContext;
    //Setting library for the time elapsed after news were published
    PrettyTime p = new PrettyTime(Locale.ENGLISH);


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

    public RecyclerViewAdapterNoImage(List<NewsClass> newsItems, Context mContext) {
        this.newsItems = newsItems;
        this.mContext = mContext;
        setupImageLoader();
    }


    @Override
    public RecyclerViewAdapterNoImage.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.card_layout_noimage, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapterNoImage.ViewHolder holder, int position) {

        setupImageLoader();


        final NewsClass newsItem = newsItems.get(position);
        String iconUrl = newsItem.getIconNews();
//        try {
//            Date date = new Date(sdf.parse(newsItem.getUpdated()));
//            holder.date_updated.setText(p.format(new Date(newsItem.getUpdated())));
        holder.date_updated.setText(newsItem.getUpdated());
        holder.title.setText(newsItem.getTitle());
//        }catch(Exception j){
//            j.printStackTrace();
//        }
        // Change how the date is displayed depending on whether it was written in the last minute,
        // the hour, etc.




//        Setup onItemClick Listener
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra("url", newsItem.getNewsURL());
                mContext.startActivity(intent);

            }
        });


        //create the imageloader object
        ImageLoader imageLoader = ImageLoader.getInstance();

        int defaultImage = mContext.getResources().getIdentifier("@drawable/image_failed", null, mContext.getPackageName());

        //create display options
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();



        //download and display image from url
        imageLoader.displayImage(iconUrl, holder.iconImage, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                holder.mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                holder.mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                holder.mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                holder.mProgressBar.setVisibility(View.GONE);
            }

        });



    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }


    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder{

        TextView title;
        TextView date_updated;
        ProgressBar mProgressBar;
        ImageView iconImage;
        public RelativeLayout mRelativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.cardTitleNoImage);
            date_updated = (TextView) itemView.findViewById(R.id.cardUpdatedNoImage);
            iconImage = (ImageView) itemView.findViewById(R.id.cardAuthorNoImage);
            mProgressBar = (ProgressBar) itemView.findViewById(R.id.cardProgressDialogNoImage);
            mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_layout_no_image);
        }
    }

    /**
     * Required for setting up the Universal Image loader Library
     */
    private void setupImageLoader(){
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}
