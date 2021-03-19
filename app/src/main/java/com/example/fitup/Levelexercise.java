package com.example.fitup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Levelexercise extends AppCompatActivity {
    private   Topmenu topmenu;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelexercise);

        // Get the topmenucontent
        topmenu=new Topmenu();
        actionBar=getSupportActionBar();
        topmenu.setActionBar(actionBar);


    }
}