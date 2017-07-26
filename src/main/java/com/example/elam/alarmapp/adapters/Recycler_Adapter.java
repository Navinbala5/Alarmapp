package com.example.elam.alarmapp.adapters;

/**
 * Created by elam on 24-07-2017.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elam.alarmapp.beans.DrugsData;
import com.example.elam.alarmapp.R;

import java.util.ArrayList;
public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.ViewHolder> {


    private ArrayList<DrugsData> mTaskArrayList;

    //DrugsData arrayList;
    Context context;

    public Recycler_Adapter(ArrayList<DrugsData> mTaskArrayList, Context context) {
        this.mTaskArrayList = mTaskArrayList;
        this.context = context;
    }

    public void setmTaskArrayList(ArrayList<DrugsData> mTaskArrayList) {
        this.mTaskArrayList = mTaskArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows,null);

        ViewHolder viewHolder = new ViewHolder(holder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        DrugsData arraylist = mTaskArrayList.get(position);
        holder.name.setText(arraylist.getName());
        holder.desp.setText(arraylist.getDescription());
        holder.price.setText(arraylist.getPrice());


    }

    @Override
    public int getItemCount() {

        return mTaskArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,desp,price;

        private ViewHolder(View itemView) {


            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name_row);
            desp= (TextView)itemView.findViewById(R.id.description_row);
            price=(TextView)itemView.findViewById(R.id.price_row);
        }
    }
}
