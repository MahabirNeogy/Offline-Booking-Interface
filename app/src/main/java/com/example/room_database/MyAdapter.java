package com.example.room_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Ignore;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList title,amount;

    List<Expense> expenses;
    public MyAdapter(List<Expense> expenses){
        this.expenses=expenses;
    }

    @Ignore
    public MyAdapter(Context context, ArrayList title, ArrayList amount) {
        this.context = context;
        this.title = title;
        this.amount = amount;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title_id.setText(String.valueOf(title.get(position)));
        holder.amount_id.setText(String.valueOf(amount.get(position)));

    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title_id,amount_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title_id=itemView.findViewById(R.id.texttitle);
            amount_id=itemView.findViewById(R.id.textamount);
        }
    }
}
