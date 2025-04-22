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

public class RecycleChef extends RecyclerView.Adapter<RecycleChef.Simple> {

    Context context;
    ArrayList<Chef> chefs;
    public RecycleChef(Context context,ArrayList<Chef> chef){
        this.context = context;
        this.chefs = chef;
    }
    @NonNull
    @Override
    public Simple onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chef,parent,false);
        return  new Simple(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Simple holder, int position) {
       holder.imageView.setImageResource(chefs.get(position).image);
       holder.name.setText(chefs.get(position).name);
       holder.itemView.setOnClickListener(view -> {
           Intent intent = new Intent(context, MainActivity3.class);
           intent.putExtra("img",chefs.get(holder.getAdapterPosition()).image);
           intent.putExtra("name",chefs.get(holder.getAdapterPosition()).description);
           context.startActivity(intent);

       });
    }

    @Override
    public int getItemCount() {
        return chefs.size();
    }

    public static class Simple extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        TextView description;
        public Simple(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profile);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.extra);
        }
    }
}
