package com.example.asynctask;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private Context context;
    private List<Food> mFood;

    public FoodAdapter(Context context , List<Food> mFood) {

        this.context = context;
        this.mFood = mFood;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_item,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = mFood.get(position);
        if(food ==null){
            return;
        }
        int id = context.getResources().getIdentifier(food.getImage(), "drawable", context.getPackageName());
        Log.d("id", String.valueOf(id));
        holder.imgFood.setImageDrawable(context.getResources().getDrawable(id));
        holder.nameFood.setText(food.getName());
        holder.descFood.setText(food.getDescription());
        holder.rateFood.setText(food.getRate());
        holder.minuteFood.setText(food.getMinute());
        holder.kilometFood.setText(food.getKilometer());

    }

    @Override
    public int getItemCount() {
        if(mFood != null){
            return mFood.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFood;
        private TextView nameFood;
        private TextView descFood;
        private TextView rateFood;
        private TextView minuteFood;
        private TextView kilometFood;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_food);
            nameFood =itemView.findViewById(R.id.name_food);
            descFood = itemView.findViewById(R.id.desc_food);
            rateFood = itemView.findViewById(R.id.star_rate);
            minuteFood = itemView.findViewById(R.id.minute);
            kilometFood = itemView.findViewById(R.id.kilomet);


        }
    }
}
