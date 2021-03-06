package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class rAdapter extends RecyclerView.Adapter<rAdapter.rViewHolder> {
    ArrayList<Data> mtemp;

    public rAdapter(Context context, ArrayList<Data> mtemp){
        this.mtemp = mtemp;
    }
    @NonNull
    @Override
    public rViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_layout,viewGroup,false);
        return new rViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rViewHolder holder, int i) {
        String name1 = mtemp.get(i).getName();
        String date1 = mtemp.get(i).getDate();
        String balance1 = String.valueOf(mtemp.get(i).getDebitAmt()- mtemp.get(i).getCreditAmt());
        holder.nameView.setText(name1);
        holder.dateView.setText(date1);
        holder.balanceView.setText(balance1);

    }

    @Override
    public int getItemCount() {
        return mtemp.size();
    }

    public class rViewHolder extends RecyclerView.ViewHolder{
        TextView nameView;
        TextView dateView;
        TextView balanceView;

        public rViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = (TextView)itemView.findViewById(R.id.nameDisplay);
            dateView = (TextView)itemView.findViewById(R.id.dateDisplay);
            balanceView = (TextView)itemView.findViewById(R.id.balanceDisplay);

        }
    }
}