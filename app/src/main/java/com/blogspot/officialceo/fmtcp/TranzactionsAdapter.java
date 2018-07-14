package com.blogspot.officialceo.fmtcp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TranzactionsAdapter extends RecyclerView.Adapter<TranzactionsAdapter.MyViewHolder> {

    private List<Tranzactions> tranzactionsList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView transImage;
        public TextView transName, transCategory, transAmount, transDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            transName = itemView.findViewById(R.id.trans_name);
            transCategory = itemView.findViewById(R.id.trans_category);
            transAmount = itemView.findViewById(R.id.trans_amount);
            transDate = itemView.findViewById(R.id.trans_date);
        }
    }

    public TranzactionsAdapter(List<Tranzactions> tranzactionsList){
        this.tranzactionsList = tranzactionsList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trans_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tranzactions tranzactions = tranzactionsList.get(position);
        holder.transName.setText(tranzactions.getTransName());
        holder.transCategory.setText(tranzactions.getTransCategory());
       // holder.transAmount.setText(tranzactions.getAmount());
        holder.transDate.setText(tranzactions.getDate());

    }

    @Override
    public int getItemCount() {
        return tranzactionsList.size();
    }
}
