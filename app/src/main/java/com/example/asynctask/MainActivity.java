package com.example.asynctask;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rcvFood;
    private GridLayoutManager gridLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Food

        rcvFood = findViewById(R.id.food_layout);
        gridLayoutManager = new GridLayoutManager(this,1);
        rcvFood.setLayoutManager(gridLayoutManager);

        FoodAdapter foodAdapter = new FoodAdapter(getListFood());
        rcvFood.setAdapter(foodAdapter);
    }

    private List<Food> getListFood() {

        List<Food> list= new ArrayList<>();

        list.add(new Food(R.drawable.banner,"Cháo sườn","Cháo là món ăn rất ngon"));
        list.add(new Food(R.drawable.banner,"Cháo sườn","Cháo là món ăn rất ngon"));
        list.add(new Food(R.drawable.banner,"Cháo sườn","Cháo là món ăn rất ngon"));
        list.add(new Food(R.drawable.banner,"Cháo sườn","Cháo là món ăn rất ngon"));
        list.add(new Food(R.drawable.banner,"Cháo sườn","Cháo là món ăn rất ngon"));

        return list;
    }



    private void scrollToItem(int index) {
        if(gridLayoutManager == null)
        {
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(index,0);
    }

}