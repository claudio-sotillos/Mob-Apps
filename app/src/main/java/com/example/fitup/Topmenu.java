package com.example.fitup;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Topmenu extends AppCompatActivity {
    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }


    public  void setActionBar(ActionBar actionBar) {


        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(R.layout.abs_layout);
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#006064"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
    }


    // Define ActionBar object


}
