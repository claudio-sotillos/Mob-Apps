package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CardioLow extends AppCompatActivity {
    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutmanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_low);
        recyclerview= findViewById(R.id.cardiolow_recycler_view);
        adapter = new CardioLowAdapter();
        layoutmanager= new LinearLayoutManager(this);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(layoutmanager);
    }
}