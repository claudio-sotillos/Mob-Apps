package com.example.fitup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StrengthLevel extends AppCompatActivity {
    private   Topmenu topmenu;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength_level);
        // Get the topmenucontent
        topmenu=new Topmenu();
        actionBar=getSupportActionBar();
        topmenu.setActionBar(actionBar);
    }
    public void strlow(View v){
        Intent inte=new Intent(this,StrLow.class);
        startActivity(inte);
    }
    public void strmedium(View v){
        Intent inte=new Intent(this,StrMedium.class);
        startActivity(inte);
    }
    public void strhigh(View v){
        Intent inte=new Intent(this,StrHigh.class);
        startActivity(inte);
    }
}