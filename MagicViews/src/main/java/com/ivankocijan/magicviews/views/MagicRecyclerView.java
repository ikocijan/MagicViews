package com.ivankocijan.magicviews.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * MagicRecyclerView adds support for endless scrolling and empty state.
 *
 * Endless scrolling
 * To support endless scrolling add {@link LoadMoreDataListener}. When user scrolls down to the last item {@link @onLoadMoreData} method
 * will be called. If {@link loadMoreDataListner} is not set MagicRecyclerView will behave as normal RecyclerView.
 *
 * Empty state
 * MagicRecyclerView will show empty state out of the box if {@link emptyStateView} is set. If view is not set it will behave as normal
 * RecyclerView.
 *
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 10/01/16
 */
public class MagicRecyclerView extends RecyclerView {

    protected LoadMoreDataListener loadMoreDataListener;

    protected int firstVisibleItem;

    protected int visibleItemCount;

    protected int totalItemCount;

    private View emptyStateView;

    private final AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            setRecyclerViewVisibility();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            setRecyclerViewVisibility();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            setRecyclerViewVisibility();
        }
    };


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

                //Only check scroll down
                if (loadMoreDataListener != null && dy > 0 && getLayoutManager() != null && getLayoutManager() instanceof LinearLayoutManager) {

                    firstVisibleItem = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
                    visibleItemCount = getLayoutManager().getChildCount();
                    totalItemCount = getLayoutManager().getItemCount();

                    if ((visibleItemCount + firstVisibleItem) >= totalItemCount) {
                        loadMoreDataListener.onLoadMoreData();
                    }

                }

            }
        });

    }

    /**
     * @param listener loadMoreDataListener which notifies when user scrolls down to the last item
     */
    public void setLoadMoreDataListener(LoadMoreDataListener listener) {
        this.loadMoreDataListener = listener;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        final Adapter currentAdapter = getAdapter();
        if (currentAdapter != null) {
            currentAdapter.unregisterAdapterDataObserver(observer);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(observer);
        }

        setRecyclerViewVisibility();
    }

    /**
     * @param emptyState empty state view which recycler view will show when the list is empty
     */
    public void setEmptyStateView(View emptyState) {
        this.emptyStateView = emptyState;
        setRecyclerViewVisibility();
    }

    /**
     * If adapter has no items {@link emptyStateView} is shown and RecyclerView visibility is set to GONE.
     */
    private void setRecyclerViewVisibility() {

        if (emptyStateView != null && getAdapter() != null) {

            boolean emptyViewVisible = getAdapter().getItemCount() == 0;
            emptyStateView.setVisibility(emptyViewVisible ? VISIBLE : GONE);
            setVisibility(emptyViewVisible ? GONE : VISIBLE);

        }
    }


}
