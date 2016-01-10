package com.ivankocijan.magicviews.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 10/01/16
 */
public class MagicRecyclerView extends RecyclerView {

    protected LoadMoreDataListener listener;

    protected int firstVisibleItem;

    protected int visibleItemCount;

    protected int totalItemCount;

    public MagicRecyclerView(Context context) {
        this(context, null);
    }

    public MagicRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public interface LoadMoreDataListener {
        void onLoadMoreData();
    }

    protected void init() {

        this.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (listener == null) {
                    throw new IllegalStateException("LoadMoreDataListener is not set");
                }

                //Only check scroll down
                if (dy > 0 && getLayoutManager() != null && getLayoutManager() instanceof LinearLayoutManager) {

                    firstVisibleItem = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
                    visibleItemCount = getLayoutManager().getChildCount();
                    totalItemCount = getLayoutManager().getItemCount();

                    if ((visibleItemCount + firstVisibleItem) >= totalItemCount) {
                        listener.onLoadMoreData();
                    }

                }

            }
        });

    }

    public void setLoadMoreDataListener(LoadMoreDataListener listener) {
        this.listener = listener;
    }


}
