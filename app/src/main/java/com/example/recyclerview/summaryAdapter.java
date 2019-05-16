package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class summaryAdapter extends RecyclerView.Adapter<summaryAdapter.summaryViewHolder> {
    Data mtemp;
    public summaryAdapter(Data mtemp){
        this.mtemp = mtemp;
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
        String name = mtemp.getName();
        String id = mtemp.getID();
        String date = mtemp.getDate();
        String balance = String.valueOf(mtemp.getBalanceAmt());
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
