package com.example.anton.techy;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.anton.techy.MainNews.MainNewsActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Grid";

    private RecyclerView recyclerView;
    private RecyclerViewAdapterGrid adapter;
    private List<GridFrontCoverClass> gridCoverList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "starting");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        gridCoverList = new ArrayList<>();
        adapter = new RecyclerViewAdapterGrid(this, gridCoverList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        displayGridCover();



    }

    private void displayGridCover(){

        String[] covers = new String[]{
                IconListClass.getAiCover(),
                IconListClass.getAndroidCover(),
                IconListClass.getAppleCover(),
                IconListClass.getGamingCover(),
                IconListClass.getLinuxCover(),
                IconListClass.getMicrosoftCover(),
                IconListClass.getRedditCover(),
                IconListClass.getWebsiteDesignCover()
        };

        GridFrontCoverClass gridCover = new GridFrontCoverClass("AI & ML", covers[0]);
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Android", covers[1]);
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("IOS", covers[2]);
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Gaming", covers[3]);
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Linux", covers[4]);
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Microsoft", covers[5]);
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Reddit", covers[6]);
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Web Design", covers[7]);
        gridCoverList.add(gridCover);

        adapter.notifyDataSetChanged();

    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
