package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class CardioLow extends AppCompatActivity {
    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutmanager;
//    private TextView numberofexercises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_low);
        recyclerview= findViewById(R.id.cardiolow_recycler_view);
//        numberofexercises=findViewById(R.id.listofcardiolowexercises);

//        adapter = new CardioLowAdapter(getApplicationContext());
        adapter = new CardioLowAdapter();
        layoutmanager= new LinearLayoutManager(this);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(layoutmanager);



//        numberofexercises.setText(String.valueOf(adapter.getItemCount()));



    }
}