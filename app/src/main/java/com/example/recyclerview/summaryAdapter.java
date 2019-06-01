package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class summaryAdapter extends RecyclerView.Adapter<summaryAdapter.summaryViewHolder> {
    ArrayList<Data> mtemp;
    public summaryAdapter(Context context, ArrayList<Data> mtemp){
        this.mtemp = mtemp;
        System.out.println(this.mtemp);
    }

    @NonNull
    @Override
    public summaryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.summary_list,viewGroup,false);
        return new summaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull summaryViewHolder holder, int i) {
        String name = mtemp.get(i).getName();
        String id = mtemp.get(i).getID();
        String date = mtemp.get(i).getDate();
        String balance = String.valueOf(mtemp.get(i).getBalanceAmt());
        holder.idView.setText(id);
        holder.nameView.setText(name);
        holder.dateView.setText(date);
        holder.balanceView.setText(balance);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class summaryViewHolder extends RecyclerView.ViewHolder{
        TextView idView;
        TextView dateView;
        TextView nameView;
        TextView balanceView;

        public summaryViewHolder(@NonNull View itemView) {
            super(itemView);
            idView = itemView.findViewById(R.id.idval);
            dateView = itemView.findViewById(R.id.dateval);
            nameView = itemView.findViewById(R.id.nameval);
            balanceView = itemView.findViewById(R.id.balanceval);
        }
    }
}