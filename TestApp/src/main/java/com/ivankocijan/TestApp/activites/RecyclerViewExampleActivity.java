package com.ivankocijan.TestApp.activites;

import com.ivankocijan.TestApp.R;
import com.ivankocijan.TestApp.adapter.ExampleAdapter;
import com.ivankocijan.TestApp.model.ExampleModel;
import com.ivankocijan.magicviews.views.MagicRecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RecyclerViewExampleActivity extends Activity implements MagicRecyclerView.LoadMoreDataListener {

    @InjectView(R.id.recycler_view)
    MagicRecyclerView recyclerView;

    private ExampleAdapter adapter;

    private List<ExampleModel> exampleModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example);
        ButterKnife.inject(this);

        init();

    }

    private void init() {

        adapter = new ExampleAdapter(this, exampleModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setLoadMoreDataListener(this);

        addDummyItemsToList(20);
    }

    private void addDummyItemsToList(int numberOfItems) {

        for (int i = 0; i < numberOfItems; i++) {
            exampleModelList.add(new ExampleModel());
        }

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onLoadMoreData() {
        addDummyItemsToList(10);
    }
}
