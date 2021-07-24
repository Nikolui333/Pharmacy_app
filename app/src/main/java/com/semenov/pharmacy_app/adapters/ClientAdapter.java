package com.semenov.pharmacy_app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semenov.pharmacy_app.R;
import com.semenov.pharmacy_app.TextClients;
import com.semenov.pharmacy_app.clientsActivity.ContactsClientActivity;
import com.semenov.pharmacy_app.preparationActivity.DescriptionPreparationActivity;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {

    private List<TextClients> mDataset;

    public Context parent;

    public ClientAdapter(@NonNull List<TextClients> myDataset, Context parent) {
        mDataset = myDataset;

        this.parent = parent;
    }

    public class ClientViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ClientViewHolder(@NonNull TextView itemView) {
            super(itemView);

            textView = itemView;
        }
    }

    @NonNull
    @Override
    public ClientAdapter.ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        TextView v = (TextView) LayoutInflater.from(context)
                .inflate(R.layout.item_clients, parent, false);

        ClientAdapter.ClientViewHolder vh = new ClientAdapter.ClientViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ClientAdapter.ClientViewHolder holder, int position) {
        holder.textView.setText(mDataset.get(position).name);

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent, ContactsClientActivity.class);
                intent.putExtra("name", mDataset.get(position).name);
                intent.putExtra("phone", mDataset.get(position).phone_number);
                intent.putExtra("email", mDataset.get(position).email);
                parent.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
