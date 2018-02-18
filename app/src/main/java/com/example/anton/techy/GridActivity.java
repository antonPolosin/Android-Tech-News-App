package com.example.anton.techy;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.anton.techy.Model.GridFrontCoverClass;
import com.example.anton.techy.UtilsURL.IconListClass;
import com.example.anton.techy.View.RecyclerViewAdapterGrid;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends android.support.v4.app.Fragment {

    private static final String TAG = "Grid";

    private RecyclerView recyclerView;
    private RecyclerViewAdapterGrid adapter;
    private List<GridFrontCoverClass> gridCoverList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        Log.d(TAG, "starting");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        gridCoverList = new ArrayList<>();
        adapter = new RecyclerViewAdapterGrid(getActivity(), gridCoverList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        displayGridCover();

        return rootView;
    }

    private void displayGridCover(){


        GridFrontCoverClass gridCover = new GridFrontCoverClass("AI & ML", IconListClass.getIcons().get(0));
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Android", IconListClass.getIcons().get(1));
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("IOS", IconListClass.getIcons().get(2));
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Gaming", IconListClass.getIcons().get(3));
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Linux", IconListClass.getIcons().get(4));
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Microsoft", IconListClass.getIcons().get(5));
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Cryptocurrency", IconListClass.getIcons().get(6));
        gridCoverList.add(gridCover);

        gridCover = new GridFrontCoverClass("Science", IconListClass.getIcons().get(0));
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
