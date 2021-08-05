package com.semenov.pharmacy_app.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semenov.pharmacy_app.R;
import com.semenov.pharmacy_app.TextPreparation;
import com.semenov.pharmacy_app.TextSearch;
import com.semenov.pharmacy_app.preparationActivity.DescriptionPreparationActivity;

import java.util.ArrayList;
import java.util.List;

public class CureSearchAdapter extends RecyclerView.Adapter<CureSearchAdapter.CureSearchViewHolder> {


    ArrayList<TextSearch> contactArrayList;

    public CureSearchAdapter(ArrayList<TextSearch> contactArrayList) {
        this.contactArrayList = contactArrayList;
    }

    @NonNull
    @Override
    public CureSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_curesearch, parent, false);
        return new CureSearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CureSearchViewHolder holder, int position) {
        try {
            holder.name.setText(contactArrayList.get(position).getName());
            holder.phoneNumber.setText(contactArrayList.get(position).getText());
        } catch (Exception ex){
            Log.d("mLog", "Not text in holder");
        }
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public class CureSearchViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView phoneNumber;

        public CureSearchViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textView);
            phoneNumber = (TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
