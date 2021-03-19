package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WorkoutInfo extends AppCompatActivity {

    private TextView totaltime;
    private String gettimeworkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_info);
        totaltime = findViewById(R.id.tottime);


        gettimeworkout = getIntent().getStringExtra("timespend");
        totaltime.setText("Total Time: \n" + gettimeworkout);
    }

    public void backtothemain(View v){
        Intent inte=new Intent(this,MainActivity.class);
        startActivity(inte);
    }
}