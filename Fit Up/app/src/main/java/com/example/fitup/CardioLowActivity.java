package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CardioLowActivity extends AppCompatActivity {
    private TextView nameexercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_low_activity);
        String name=getIntent().getStringExtra("name");
        nameexercise=findViewById(R.id.cardilow_name);
        nameexercise.setText(name);
    }
}