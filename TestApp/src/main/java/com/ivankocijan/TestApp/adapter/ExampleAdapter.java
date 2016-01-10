package com.ivankocijan.TestApp.adapter;

import com.ivankocijan.TestApp.R;
import com.ivankocijan.TestApp.model.ExampleModel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 10/01/16
 */
public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private Context context;

    private List<ExampleModel> exampleModelList;

    public ExampleAdapter(Context context, List<ExampleModel> exampleModelList) {
        this.context = context;
        this.exampleModelList = exampleModelList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExampleViewHolder(LayoutInflater.from(context).inflate(R.layout.example_list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        holder.exampleListItemText.setText(context.getString(R.string.example_item_s, position));
    }

    @Override
    public int getItemCount() {
        return exampleModelList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.example_list_item_text)
        TextView exampleListItemText;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }

}
