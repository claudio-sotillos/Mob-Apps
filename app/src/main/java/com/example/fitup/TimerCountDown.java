package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import java.util.Locale;

public class TimerCountDown extends AppCompatActivity {
    private int amount;
    private int hastiming;
    private String NextExercise;
    private String url_animation;
    private int position;
    private final long START_TIME_UN_MILLIS = 20000;
    private long mTimeLeftInMillis = START_TIME_UN_MILLIS;
    private long totaltiming;


    private TextView name;
    private ImageView animationnextexercise;
    private TextView repetitionsnextexercise;
    private TextView mTextViewCountDown;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private ArrayList<Exercise> Arrayofexercises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_count_down);

        name = findViewById(R.id.nameofnextexercise);
        animationnextexercise = findViewById(R.id.nextanimationgif);
        repetitionsnextexercise = findViewById(R.id.amountcontentnextexercise);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);


        Arrayofexercises=getIntent().getParcelableArrayListExtra("arrayofexercises");
        Log.d("Arrayhasgottoreach",String.valueOf(Arrayofexercises));
        amount = getIntent().getIntExtra("repetitions", 10);
        NextExercise = getIntent().getStringExtra("nextex");
        url_animation = getIntent().getStringExtra("animation_url");
        hastiming = getIntent().getIntExtra("hastiming", 0);
        position = getIntent().getIntExtra("position", 0);
        totaltiming=getIntent().getLongExtra("timespend",0);
        Log.d("Totaltimingconsumed",String.valueOf(totaltiming));
        name.setText(NextExercise);

        Glide.with(this).load(url_animation).diskCacheStrategy(DiskCacheStrategy.ALL).into(animationnextexercise);

       startTimer();

        if (String.valueOf(hastiming).equals("0")) {
            repetitionsnextexercise.setText(String.valueOf(amount) + " Repetitions");
        } else {
            repetitionsnextexercise.setText(String.valueOf(amount) + " Seconds");

        }





        }

        public void norest(View v){

            mCountDownTimer.cancel();
            mCountDownTimer.onFinish();
            Intent neintent=new Intent(this,CardioLowPassThrough.class);
            neintent.putExtra("position",position);
            neintent.putExtra("timespend",totaltiming);
            neintent.putParcelableArrayListExtra("arrayofexercises",Arrayofexercises);
            startActivity(neintent);
            finish();

        }


        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) { if (keyCode == KeyEvent.KEYCODE_BACK) {

                mCountDownTimer.cancel();
                mCountDownTimer.onFinish();
                Intent i = new Intent(this,CardioLow.class);
                startActivity(i);
                finish();

          }
            return false; }

        //        Timer functions

        private void startTimer () {
            mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();

                }

                @Override
                public void onFinish() {
                    mTimerRunning = false;
//                    mButtonStartPause.setText("Start");
//                    mButtonStartPause.setVisibility(View.INVISIBLE);
//                    mButtonReset.setVisibility(View.VISIBLE);
                }
            }.start();
            mTimerRunning = true;
//            mButtonStartPause.setText("Pause");
//            mButtonReset.setVisibility(View.INVISIBLE);
        }
//        private void pauseTimer () {
//            mCountDownTimer.cancel();
//            mTimerRunning = false;
//            mButtonStartPause.setText("Start");
//            mButtonReset.setVisibility(View.VISIBLE);
//        }
//        private void resetTimer () {
//            mTimeLeftInMillis = START_TIME_UN_MILLIS;
//            updateCountDownText();
//            mButtonReset.setVisibility(View.INVISIBLE);
//            mButtonStartPause.setVisibility(View.VISIBLE);
//        }

        private void updateCountDownText () {
            int minutes = (int) (mTimeLeftInMillis/ 1000)/ 60;
            int seconds = (int) (mTimeLeftInMillis/ 1000)% 60;

            String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes, seconds);
            mTextViewCountDown.setText(timeLeftFormatted);
            Log.d("Timer",timeLeftFormatted);
            if (timeLeftFormatted.equals("00:00")){
                Intent neintent=new Intent(this,CardioLowPassThrough.class);
                neintent.putExtra("position",position);
                neintent.putExtra("timespend",totaltiming);
                neintent.putParcelableArrayListExtra("arrayofexercises",Arrayofexercises);

                startActivity(neintent);
                finish();
            }

        }



}
