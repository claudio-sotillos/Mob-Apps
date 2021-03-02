package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Pase de actividad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void challenge(View v){
        Intent inte=new Intent(this,Levelexercise.class);
        startActivity(inte);
    }
    public void cardio(View v){
        Intent inte=new Intent(this,Cardiolevel.class);
        startActivity(inte);
    }
    public void flexibility(View v){
        Intent inte=new Intent(this,FlexibilityLevel.class);
        startActivity(inte);
    }
    public void strength(View v){
        Intent inte=new Intent(this,StrengthLevel.class);
        startActivity(inte);
    }
}