package com.example.anton.techy.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.anton.techy.Model.NewsClass;
import com.example.anton.techy.R;
import com.example.anton.techy.WebViewActivity;

import java.util.List;

/**
 * Created by anton on 13/01/18.
 */

public class RecyclerViewAdapterNoImage extends android.support.v7.widget.RecyclerView.Adapter<RecyclerViewAdapterNoImage.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapterNoImage";

    private List<NewsClass> newsItems;
    private Context mContext;
    //Setting library for the time elapsed after news were published

    public RecyclerViewAdapterNoImage(List<NewsClass> newsItems, Context mContext) {
        this.newsItems = newsItems;
        this.mContext = mContext;

    }


    @Override
    public RecyclerViewAdapterNoImage.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.card_layout_noimage, null);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapterNoImage.ViewHolder holder, int position) {
        final NewsClass newsItem = newsItems.get(position);
        //processing pubDate tag with SimpleDateFormatter and PrettyTime
        String formattedDate = newsItem.formattedDate(newsItem.getUpdated());

        holder.date_updated.setText(formattedDate);
        holder.title.setText(newsItem.getTitle());
        holder.source.setText(newsItem.getSource());





//        Setup onItemClick Listener
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
        ProgressBar mProgressBar;
        TextView source;
        public RelativeLayout mRelativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.cardTitleNoImage);
            date_updated = (TextView) itemView.findViewById(R.id.cardUpdatedNoImage);
            source = (TextView) itemView.findViewById(R.id.cardAuthorNoImage);
            mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_layout_no_image);
        }
    }

}
