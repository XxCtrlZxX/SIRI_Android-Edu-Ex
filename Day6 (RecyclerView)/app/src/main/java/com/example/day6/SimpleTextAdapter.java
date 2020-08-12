package com.example.day6;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, descText;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
            descText = itemView.findViewById(R.id.descText);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    private ArrayList<Item> mData = null;
    SimpleTextAdapter(ArrayList<Item> list)
    {
        mData = list;
    }

    @Override
    public SimpleTextAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        return new SimpleTextAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleTextAdapter.ViewHolder holder, int position) {
        Item item = mData.get(position);
        holder.titleText.setText(item.getTitleStr());
        holder.descText.setText(item.getDescStr());
        holder.imageView.setImageDrawable(item.getIconDrawable());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
