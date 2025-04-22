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

public class RecycleSecond extends RecyclerView.Adapter<RecycleSecond.Berger> {
    Context context;
    ArrayList<Second> seconds;
    public RecycleSecond(Context context,ArrayList<Second> seconds){
        this.context = context;
        this.seconds = seconds;
    }
    @NonNull
    @Override
    public Berger onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.second,parent,false);
        return new Berger(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull Berger holder, int position) {
          holder.imageView.setImageResource(seconds.get(position).image);
          holder.name.setText(seconds.get(position).name);
          holder.rate.setText(seconds.get(position).rate);
          holder.price.setText(seconds.get(position).price);
          holder.itemView.setOnClickListener(view -> {
              Intent intent = new Intent(context, MainActivity4.class);
              intent.putExtra("img",seconds.get(holder.getAdapterPosition()).image);
              intent.putExtra("rate",seconds.get(holder.getAdapterPosition()).rate);
              intent.putExtra("price",seconds.get(holder.getAdapterPosition()).price);
              intent.putExtra("name",seconds.get(holder.getAdapterPosition()).name);
              intent.putExtra("more",seconds.get(holder.getAdapterPosition()).description);
              context.startActivity(intent);
          });
    }

    @Override
    public int getItemCount() {
        return seconds.size();
    }

    public static class Berger extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        TextView rate;
        TextView price;
        public Berger(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.berger);
            name = itemView.findViewById(R.id.name);
            rate = itemView.findViewById(R.id.rate);
            price = itemView.findViewById(R.id.price);
        }
    }
}
