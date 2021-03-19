package com.example.fitup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cardiolevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        barmenu();


    }
    public void barmenu(){
        setContentView(R.layout.activity_cardiolevel);
        // Get the topmenucontent
        Topmenu topmenu=new Topmenu();
        ActionBar actionBar=getSupportActionBar();
        topmenu.setActionBar(actionBar);
    }
    public void cardiolow(View v){
        Intent inte=new Intent(this,CardioLow.class);
        startActivity(inte);
    }
    public void cardiomedium(View v){
        Intent inte=new Intent(this,CardioMedium.class);
        startActivity(inte);
    }
    public void cardiohigh(View v){
        Intent inte=new Intent(this,CardioMedium.class);
        startActivity(inte);
    }
}
