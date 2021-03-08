package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FlexibilityLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexibility_level);
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