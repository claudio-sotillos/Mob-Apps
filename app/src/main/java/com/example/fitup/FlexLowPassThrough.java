package com.example.fitup;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import static com.example.fitup.R.raw.silbato;
import static java.lang.String.valueOf;

public class FlexLowPassThrough extends CardioLowPassThrough{
    private TextView nameofexercises;
    private ImageView animation;
    private TextView repetitions;
    private Button next;
    private MediaPlayer pito;
    private long START_TIME_UN_MILLIS;
    private long mTimeLeftInMillis;

    private int amount;
    private String animation_url;
    private String name;
    private int hastiming;
    private int position;
    private long totaltiming;
    private TextView mTextCountDown;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private ArrayList<Exercise> exercises;
    private List<Exercise> arrayofexercises;
    private long startTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exercises=  getIntent().getParcelableArrayListExtra("arrayofflexexercises");


        nameofexercises = findViewById(R.id.nameofexercises);
        animation = findViewById(R.id.animationgif);
        repetitions = findViewById(R.id.amountcontent);
        next = findViewById(R.id.nextexercise);
        mTextCountDown = findViewById(R.id.text_countdown);
        position = getIntent().getIntExtra("position", 0);
        totaltiming=getIntent().getLongExtra("timespend",0);









        Log.d("SIZE",String.valueOf(exercises.size()));
        arrayofexercises=convert2(exercises);
        for (int i = 0; i < arrayofexercises.size(); i++) {
            Log.d("Nameofthexercise:" ,arrayofexercises.get(i).getName());
        }


        passthroughexercises(arrayofexercises);
    }

    @Override
    public void passthroughexercises(List<Exercise> arrayofexercises) {
        super.passthroughexercises(arrayofexercises);
        {


            startTime = System.currentTimeMillis();



            Log.d("Tconsumedassthrough", String.valueOf(totaltiming));

            Log.d("starttimer",String.valueOf(startTime));
            Exercise excurrent = arrayofexercises.get(position);
            Log.d("cw50", "Name of the exercise: " + excurrent.getName());
            Log.d("Positioexercise", valueOf(position+1));
            Log.d("exercisesize", valueOf(arrayofexercises.size()));
            Log.d("istrue",String.valueOf(String.valueOf(position+1).equals(String.valueOf(arrayofexercises.size()))));
            name = excurrent.getName();
            amount = excurrent.getAmount();
            animation_url = excurrent.getExercise_url();

            nameofexercises.setText(name);

            Glide.with(this).load(animation_url).diskCacheStrategy(DiskCacheStrategy.ALL).into(animation);



            hastiming = excurrent.getTimer();
            pito = MediaPlayer.create(this, silbato);
            pito.start();
            if (valueOf(hastiming).equals("0")) {
                repetitions.setText(valueOf(amount) + " Repetitions");
                mTextCountDown.setVisibility(View.INVISIBLE);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(String.valueOf(position+1).equals(String.valueOf(arrayofexercises.size()))){
                            Intent in=new Intent(FlexLowPassThrough.this,WorkoutInfo.class);
                            int minutes = (int) (totaltiming/ 1000)/ 60;
                            int seconds = (int) (totaltiming/ 1000)% 60;
                            String timeld=String.format("%02d", minutes)+":"+ String.format("%02d", seconds) + " minutes";
                            in.putExtra("timespend",timeld);
                            startActivity(in);
                            finish();
                        }
                        else {
                            Log.d("differenceend-star",String.valueOf(System.currentTimeMillis()-startTime));
                            Intent intent = new Intent(FlexLowPassThrough.this, TimerCountDown.class);
                            intent.putExtra("repetitions", arrayofexercises.get(position + 1).getAmount());
                            intent.putExtra("hastiming", arrayofexercises.get(position + 1).getTimer());
                            intent.putExtra("nextex", arrayofexercises.get(position + 1).getName());
                            intent.putExtra("animation_url", arrayofexercises.get(position + 1).getExercise_url());
                            intent.putExtra("position", position + 1);
                            intent.putParcelableArrayListExtra("arrayofflexexercises",exercises);

                            intent.putExtra("timespend",(System.currentTimeMillis()-startTime)+totaltiming);
                            startActivity(intent);
                            finish();
                        }



                    }
                });

            } else {
                repetitions.setText(valueOf(amount) + " Seconds");
                START_TIME_UN_MILLIS=amount*1000;

                mTimeLeftInMillis=START_TIME_UN_MILLIS;
                Log.d("STARTTIMING", valueOf(START_TIME_UN_MILLIS));
                Log.d("TIMELEFT", valueOf(mTimeLeftInMillis));
                mTextCountDown.setVisibility(View.VISIBLE);
                startTimer();
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(valueOf(position+1).equals(valueOf(arrayofexercises.size()))){
                            Intent in=new Intent(FlexLowPassThrough.this,WorkoutInfo.class);
                            int minutes = (int) (totaltiming/ 1000)/ 60;
                            int seconds = (int) (totaltiming/ 1000)% 60;
                            String timeld=String.format("%02d", minutes)+":"+ String.format("%02d", seconds) + " seconds";
                            in.putExtra("timespend",timeld);
                            startActivity(in);
                            finish();
                        }
                        else {
                            mCountDownTimer.cancel();
                            mCountDownTimer.onFinish();
                            Intent intent = new Intent(FlexLowPassThrough.this, TimerCountDown.class);
                            intent.putExtra("repetitions", arrayofexercises.get(position + 1).getAmount());
                            intent.putExtra("hastiming", arrayofexercises.get(position + 1).getTimer());
                            intent.putExtra("nextex", arrayofexercises.get(position + 1).getName());
                            intent.putExtra("animation_url", arrayofexercises.get(position + 1).getExercise_url());
                            intent.putExtra("timespend",(System.currentTimeMillis()-startTime)+totaltiming);
                            intent.putExtra("position", position + 1);
                            intent.putParcelableArrayListExtra("arrayofflexexercises",exercises);

                            startActivity(intent);
                            finish();

                        }




                    }
                });



            }
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { if (keyCode == KeyEvent.KEYCODE_BACK) {

        if (valueOf(hastiming).equals("0")){


        }else{
            mCountDownTimer.cancel();
            mCountDownTimer.onFinish();

        }
        Intent i = new Intent(this,FlexLow.class);
        startActivity(i);
        finish();
    }
        return false; }
}
