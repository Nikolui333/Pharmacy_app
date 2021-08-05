package com.semenov.pharmacy_app.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.semenov.pharmacy_app.R;
import com.semenov.pharmacy_app.TextPreparation;
import com.semenov.pharmacy_app.preparationActivity.DescriptionPreparationActivity;

import java.util.List;

public class CureSearchAdapter extends RecyclerView.Adapter<CureSearchAdapter.CureSearchViewHolder> {

    private List<TextPreparation> mDataset;

    public Context parent;

    class CureSearchViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public CureSearchViewHolder(TextView v) {
            super(v);

            textView = v;
        }

    }

    public CureSearchAdapter(List<TextPreparation> myDataset, Context parent) {
        mDataset = myDataset;

        this.parent = parent;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public  CureSearchAdapter.CureSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        Context context = parent.getContext();
        TextView v = (TextView) LayoutInflater.from(context)
                .inflate(R.layout.item_preparation, parent, false);

        CureSearchAdapter.CureSearchViewHolder vh = new CureSearchAdapter.CureSearchViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CureSearchAdapter.CureSearchViewHolder holder, @SuppressLint("RecyclerView") int position) {

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
