package com.example.fitup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FlexibilityLevel extends AppCompatActivity {
    private   Topmenu topmenu;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexibility_level);
        // Get the topmenucontent
        topmenu=new Topmenu();
        actionBar=getSupportActionBar();
        topmenu.setActionBar(actionBar);

    }

    public void flexlow(View v){
        Intent inte=new Intent(this,FlexLow.class);
        startActivity(inte);
    }
    public void flexmedium(View v){
        Intent inte=new Intent(this,FlexMedium.class);
        startActivity(inte);
    }
    public void flexhigh(View v){
        Intent inte=new Intent(this,FlexHigh.class);
        startActivity(inte);
    }
}