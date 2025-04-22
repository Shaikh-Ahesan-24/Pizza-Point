package com.example.pizza_point;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleFirst extends RecyclerView.Adapter<RecycleFirst.Food> {
    Context context;
    ArrayList<First> firsts;
    public RecycleFirst(Context context,ArrayList<First> firsts){
        this.context = context;
        this.firsts = firsts;
    }
    @NonNull
    @Override
    public Food onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.first,parent,false);
        return new Food(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Food holder, int position) {
        holder.imageView.setImageResource(firsts.get(position).image);
        holder.name.setText(firsts.get(position).name);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, MainActivity4.class);
            intent.putExtra("img",firsts.get(holder.getAdapterPosition()).image);
            intent.putExtra("rate",firsts.get(holder.getAdapterPosition()).rate);
            intent.putExtra("price",firsts.get(holder.getAdapterPosition()).price);
            intent.putExtra("name",firsts.get(holder.getAdapterPosition()).name);
            intent.putExtra("more",firsts.get(holder.getAdapterPosition()).description);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return firsts.size();
    }

    public static class Food extends RecyclerView.ViewHolder{
         ImageView imageView;
         TextView rate;
         TextView price;
         TextView name;
         TextView description;
        public Food(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pizza);
            rate = itemView.findViewById(R.id.rate);
            price = itemView.findViewById(R.id.price);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
        }
    }
}
