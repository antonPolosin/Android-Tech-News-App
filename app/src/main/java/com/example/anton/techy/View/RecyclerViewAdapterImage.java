package com.example.anton.techy.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.anton.techy.Model.NewsClass;
import com.example.anton.techy.R;
import com.example.anton.techy.WebViewActivity;

import java.util.List;


/**
 * Created by anton on 23/12/17.
 */

public class RecyclerViewAdapterImage extends android.support.v7.widget.RecyclerView.Adapter<RecyclerViewAdapterImage.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapterImage";

    private List<NewsClass> newsItems;
    private Context mContext;
    //Setting library for the time elapsed after news were published

    public RecyclerViewAdapterImage(List<NewsClass> newsItems, Context mContext) {
        this.newsItems = newsItems;
        this.mContext = mContext;
//           setupImageLoader();
    }

    @Override
    public RecyclerViewAdapterImage.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.card_layout_image, null);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {

        return newsItems.size();
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapterImage.ViewHolder holder, int position) {


        final NewsClass newsItem = newsItems.get(position);
        String imgUrl = newsItem.getNewsImage();

        String formattedDate = newsItem.formattedDate(newsItem.getUpdated());

            holder.date_updated.setText(formattedDate);
            holder.title.setText(newsItem.getTitle());
            holder.source.setText(newsItem.getSource());

        Glide.with(mContext).asBitmap().load(imgUrl).into(holder.newsImage);

//          link to WebView Activity
            holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("url", newsItem.getNewsURL());
                    mContext.startActivity(intent);

                }
            });

    }

    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder{

        TextView title;
        TextView date_updated;
        ImageView newsImage;
        TextView source;
        public RelativeLayout mRelativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.cardTitle);
            date_updated = itemView.findViewById(R.id.cardUpdated);
            newsImage = itemView.findViewById(R.id.cardImage);
            source = itemView.findViewById(R.id.cardAuthor);
            mRelativeLayout = itemView.findViewById(R.id.relative_layout);
        }
    }

}
