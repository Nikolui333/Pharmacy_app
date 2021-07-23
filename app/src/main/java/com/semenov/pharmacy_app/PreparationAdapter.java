package com.semenov.pharmacy_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PreparationAdapter extends RecyclerView.Adapter<PreparationAdapter.PreparationViewHolder> {

    private List<TextPreparation> mDataset;

    public Context parent;

    class PreparationViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public PreparationViewHolder(TextView v) {
            super(v);

            textView = v;
        }

    }

    public PreparationAdapter(List<TextPreparation> myDataset, Context parent) {
        mDataset = myDataset;

        this.parent = parent;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public PreparationAdapter.PreparationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        Context context = parent.getContext();
        TextView v = (TextView) LayoutInflater.from(context)
                .inflate(R.layout.item_preparation, parent, false);

        PreparationViewHolder vh = new PreparationViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(PreparationViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataset.get(position).name);

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent, DescriptionPreparationActivity.class);
                intent.putExtra("name", mDataset.get(position).name);
                intent.putExtra("text", mDataset.get(position).text);
                parent.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
