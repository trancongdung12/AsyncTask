package com.example.asynctask;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rcvFood;
    private GridLayoutManager gridLayoutManager;
    List<Food> listFood = new ArrayList<>();
    //ListView lvContact;
    ArrayAdapter<String> adapter;
    String TAG="FIREBASE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //adapter=new ArrayAdapter<>();
//        lvContact=findViewById(R.id.lvContact);
//        lvContact.setAdapter(adapter);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("products");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override public void onDataChange(DataSnapshot dataSnapshot) {
                listFood.clear();
        //vòng lặp để lấy dữ liệu khi có sự thay đổi trên Firebase
             for (DataSnapshot data : dataSnapshot.getChildren()) {
            //lấy key của dữ liệu
              String key = data.getKey();
        //lấy giá trị của key (nội dung)
                 String title = data.child("title").getValue().toString();
                 String image = data.child("image").getValue().toString();
                 String desc = data.child("desc").getValue().toString();
                 String rate = data.child("rate").getValue().toString();
                 String minute = data.child("minute").getValue().toString();
                 String kilomet =  data.child("kilometer").getValue().toString();


               //adapter.add(key + "\n" + title);
                Log.d("data",rate);

               listFood.add(new Food(image,title,desc,rate,minute ,kilomet ));
            }
           }
            public void addList(){

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });

        //Food
        rcvFood = findViewById(R.id.food_layout);
        gridLayoutManager = new GridLayoutManager(this,1);
        rcvFood.setLayoutManager(gridLayoutManager);

        FoodAdapter foodAdapter = new FoodAdapter(this,listFood);
        rcvFood.setAdapter(foodAdapter);
    }





//    private void scrollToItem(int index) {
//        if(gridLayoutManager == null)
//        {
//            return;
//        }
//        gridLayoutManager.scrollToPositionWithOffset(index,0);
//    }

}