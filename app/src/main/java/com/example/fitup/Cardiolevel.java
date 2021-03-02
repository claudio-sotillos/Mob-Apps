package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cardiolevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiolevel);
    }
    public void cardiolow(View v){
        Intent inte=new Intent(this,Cardiolow.class);
        startActivity(inte);
    }
}