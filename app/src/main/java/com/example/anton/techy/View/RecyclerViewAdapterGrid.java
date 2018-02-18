package com.example.anton.techy.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.anton.techy.Model.GridFrontCoverClass;
import com.example.anton.techy.NewsController.AiMlNews;
import com.example.anton.techy.NewsController.AndroidNews;
import com.example.anton.techy.NewsController.CryptocurrencyNews;
import com.example.anton.techy.NewsController.GamingNews;
import com.example.anton.techy.NewsController.IosNews;
import com.example.anton.techy.NewsController.LinuxNews;
import com.example.anton.techy.NewsController.MainNews;
import com.example.anton.techy.NewsController.MicrosoftNews;
import com.example.anton.techy.NewsController.ScienceNews;
import com.example.anton.techy.NewsController.WebDesignNews;
import com.example.anton.techy.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by anton on 16/01/18.
 */

public class RecyclerViewAdapterGrid extends RecyclerView.Adapter<RecyclerViewAdapterGrid.ViewHolder> {


    private Context mContext;
    private List<GridFrontCoverClass> gridCoverList;

    public RecyclerViewAdapterGrid(Context mContext, List<GridFrontCoverClass> gridCoverList) {
        this.mContext = mContext;
        this.gridCoverList = gridCoverList;
        setupImageLoader();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_grid, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        setupImageLoader();
        final GridFrontCoverClass gridCover = gridCoverList.get(position);
        holder.title.setText(gridCover.getName());
        String imgUrl = gridCover.getThumbnail();

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
        imageLoader.displayImage(imgUrl, holder.thumbnail, options, new ImageLoadingListener() {
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
        return gridCoverList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView thumbnail;
        public TextView title;
        public ProgressBar mProgressBar;


        public ViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            thumbnail = itemView.findViewById(R.id.thumbnailGrid);
            title = itemView.findViewById(R.id.titleGrid);
            mProgressBar = itemView.findViewById(R.id.cardProgressDialogGrid);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        //setting onClickListener to switch between Activities

        @Override
        public void onClick(View view) {
            final Intent intent;

                switch(getAdapterPosition()){
                    case 0:
                        intent = new Intent(mContext, AiMlNews.class);
                        break;
                    case 1:
                        intent = new Intent(mContext, AndroidNews.class);
                        break;
                    case 2:
                        intent = new Intent(mContext, IosNews.class);
                        break;
                    case 3:
                        intent = new Intent(mContext, GamingNews.class);
                        break;
                    case 4:
                        intent = new Intent(mContext, LinuxNews.class);
                        break;
                    case 5:
                        intent = new Intent(mContext, MicrosoftNews.class);
                        break;
                    case 6:
                        intent = new Intent(mContext, CryptocurrencyNews.class);
                        break;
                    case 7:
                        intent = new Intent(mContext, ScienceNews.class);
                        break;

                    default:
                        intent = new Intent(mContext, MainNews.class);
                }
                mContext.startActivity(intent);
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
