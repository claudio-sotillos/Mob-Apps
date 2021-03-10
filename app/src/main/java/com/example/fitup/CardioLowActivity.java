package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.InputStream;
import java.net.URL;

public class CardioLowActivity extends AppCompatActivity {
    private TextView nameexercise;
    private TextView descrexercise;
//    private TextView urlexercise;
//    private TextView work_urlexercise;
    private TextView amountexercise;
    private ImageView image_string_url;
    private ImageView  image_work_url;
//    public static Drawable LoadImageFromWebOperations(String url) {
//        try {
//            InputStream is = (InputStream) new URL(url).getContent();
//            Drawable d = Drawable.createFromStream(is, "src name");
//            return d;
//        } catch (Exception e) {
//            return null;
//        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cardio_low_activity);
        String name = getIntent().getStringExtra("name");
        String descr = getIntent().getStringExtra("description");
        String exercise_url = getIntent().getStringExtra("exercise_url");
        String work_url = getIntent().getStringExtra("work_url");
        String hastiming = getIntent().getStringExtra("timer");
//        Drawable imageurl=LoadImageFromWebOperations(work_url);

        nameexercise = findViewById(R.id.cardilow_name);
        descrexercise = findViewById(R.id.cardilow_description);
//        urlexercise = findViewById(R.id.cardilow_string_url);
//        work_urlexercise = findViewById(R.id.cardilow_work_url);
        amountexercise = findViewById(R.id.cardilow_rep);
        image_string_url=findViewById(R.id.cardiolowstring_image);
        image_work_url=findViewById(R.id.cardiolowstring_work_image);
        if (image_string_url != null)
            Glide.with(this).load(exercise_url).diskCacheStrategy(DiskCacheStrategy.ALL).into(image_string_url);



//        Glide.with(this).load(exercise_url).into(image_string_url);
        Glide.with(this).load(work_url).into(image_work_url);
        nameexercise.setText(name);
        descrexercise.setText(descr);
//        urlexercise.setText(exercise_url);
//        work_urlexercise.setText(work_url);


        if (hastiming.equals("0")) {
            String amount = getIntent().getStringExtra("amount") + "Repetitions";
            amountexercise.setText(amount);
        } else {
            String amount = getIntent().getStringExtra("amount") + "Seconds";
            amountexercise.setText(amount);
        }


    }

}