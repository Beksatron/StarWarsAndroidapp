package com.example.androidwarsapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExAdapter extends RecyclerView.Adapter<ExAdapter.ExViewHolder> {
    private static final String TAG = "ExAdapter";
    private Context mContext;
    private ArrayList<People> mExList;
    ConstraintLayout parentLayout;

    public ExAdapter(Context context, ArrayList<People> exList) {
        mContext = context;
        mExList = exList;
    }

    @NonNull
    @Override
    public ExViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.show_main_screen, parent, false);

        return new ExViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ExViewHolder holder, int position) {
        People currentItem = mExList.get(position);

        String name = currentItem.getName();
        String height = currentItem.getHeight();
        String mass = currentItem.getMass();

        holder.mName.setText("Name: " + name);
        holder.mHeight.setText("Height: " + height);
        holder.mMass.setText("Mass: " + mass);

        Intent intent = new Intent(mContext, PersonDetailActivity.class);
        intent.putExtra("text", currentItem);


    }

    @Override
    public int getItemCount() {
        return mExList.size();
    }

    public class ExViewHolder extends RecyclerView.ViewHolder  {
        public TextView mName;
        public TextView mHeight;
        public TextView mMass;


        public ExViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.text_name);
            mHeight = itemView.findViewById(R.id.text_height);
            mMass = itemView.findViewById(R.id.text_mass);
        }
    }
}