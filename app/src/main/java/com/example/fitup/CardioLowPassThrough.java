package com.example.fitup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.os.Parcelable;
import android.util.AtomicFile;

import android.content.Intent;
import android.content.IntentSender;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.fitup.R.raw.silbato;
import static java.lang.String.valueOf;
//        startTime = System.currentTimeMillis();
//
//
//        nameofexercises = findViewById(R.id.nameofexercises);
//        animation = findViewById(R.id.animationgif);
//        repetitions = findViewById(R.id.amountcontent);
//        next = findViewById(R.id.nextexercise);
//        mTextCountDown = findViewById(R.id.text_countdown);
//        position = getIntent().getIntExtra("position", 0);
//        totaltiming=getIntent().getLongExtra("timespend",0);
//        Log.d("Tconsumedassthrough", String.valueOf(totaltiming));
//
//        Log.d("starttimer",String.valueOf(startTime));
//        Exercise excurrent = arrayofexercises.get(position);
//        Log.d("cw50", "Name of the exercise: " + excurrent.getName());
//        Log.d("Positioexercise", valueOf(position+1));
//        Log.d("exercisesize", valueOf(arrayofexercises.size()));
//        Log.d("istrue",String.valueOf(String.valueOf(position+1).equals(String.valueOf(arrayofexercises.size()))));
//        name = excurrent.getName();
//        amount = excurrent.getAmount();
//        animation_url = excurrent.getExercise_url();
//
//        nameofexercises.setText(name);
//
//        Glide.with(this).load(animation_url).diskCacheStrategy(DiskCacheStrategy.ALL).into(animation);
//
//
//
//        hastiming = excurrent.getTimer();
//        pito = MediaPlayer.create(this, silbato);
//        pito.start();
//        if (valueOf(hastiming).equals("0")) {
//            repetitions.setText(valueOf(amount) + " Repetitions");
//            mTextCountDown.setVisibility(View.INVISIBLE);
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(String.valueOf(position+1).equals(String.valueOf(arrayofexercises.size()))){
//                        Intent in=new Intent(CardioLowPassThrough.this,WorkoutInfo.class);
//                        int minutes = (int) (totaltiming/ 1000)/ 60;
//                        int seconds = (int) (totaltiming/ 1000)% 60;
//                        String timeld=String.format("%02d", minutes)+":"+ String.format("%02d", seconds) + " minutes";
//                        in.putExtra("timespend",timeld);
//                        startActivity(in);
//                        finish();
//                    }
//                    else {
//                        Log.d("differenceend-star",String.valueOf(System.currentTimeMillis()-startTime));
//                        Intent intent = new Intent(CardioLowPassThrough.this, TimerCountDown.class);
//                        intent.putExtra("repetitions", arrayofexercises.get(position + 1).getAmount());
//                        intent.putExtra("hastiming", arrayofexercises.get(position + 1).getTimer());
//                        intent.putExtra("nextex", arrayofexercises.get(position + 1).getName());
//                        intent.putExtra("animation_url", arrayofexercises.get(position + 1).getExercise_url());
//                        intent.putExtra("position", position + 1);
//
//                        intent.putExtra("timespend",(System.currentTimeMillis()-startTime)+totaltiming);
//                        startActivity(intent);
//                        finish();
//                    }
//
//
//
//                }
//            });
//
//        } else {
//            repetitions.setText(valueOf(amount) + " Seconds");
//            START_TIME_UN_MILLIS=amount*1000;
//
//            mTimeLeftInMillis=START_TIME_UN_MILLIS;
//            Log.d("STARTTIMING", valueOf(START_TIME_UN_MILLIS));
//            Log.d("TIMELEFT", valueOf(mTimeLeftInMillis));
//            mTextCountDown.setVisibility(View.VISIBLE);
//            startTimer();
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(valueOf(position+1).equals(valueOf(arrayofexercises.size()))){
//                        Intent in=new Intent(CardioLowPassThrough.this,WorkoutInfo.class);
//                        int minutes = (int) (totaltiming/ 1000)/ 60;
//                        int seconds = (int) (totaltiming/ 1000)% 60;
//                        String timeld=String.format("%02d", minutes)+":"+ String.format("%02d", seconds) + " seconds";
//                        in.putExtra("timespend",timeld);
//                        startActivity(in);
//                        finish();
//                    }
//                    else {
//                        mCountDownTimer.cancel();
//                        mCountDownTimer.onFinish();
//                        Intent intent = new Intent(CardioLowPassThrough.this, TimerCountDown.class);
//                        intent.putExtra("repetitions", arrayofexercises.get(position + 1).getAmount());
//                        intent.putExtra("hastiming", arrayofexercises.get(position + 1).getTimer());
//                        intent.putExtra("nextex", arrayofexercises.get(position + 1).getName());
//                        intent.putExtra("animation_url", arrayofexercises.get(position + 1).getExercise_url());
//                        intent.putExtra("timespend",(System.currentTimeMillis()-startTime)+totaltiming);
//                        intent.putExtra("position", position + 1);
//                        startActivity(intent);
//                        finish();
//
//                    }
//
//
//
//
//                }
//            });
//
//
//
//        }
public class CardioLowPassThrough extends AppCompatActivity {

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



//    private List<Exercise> arrayofexercises = Arrays.asList(
//            new Exercise("Jumping Jack", "Performed by jumping to a position with the legs spread wide and the hands going overhead and then returning to a position with the feet together and the arms at the sides.", "https://i.pinimg.com/originals/34/cb/99/34cb992c8c0c57e896a22c1036a7c038.gif", "https://darebee.com/images/workouts/muscles/recalibrator-workout.jpg", 0, 10),
//                new Exercise("Butt Kicks", "Kicking your shins back behind you to touch your buttocks with the bottom of your foot.", "https://i0.wp.com/thumbs.gfycat.com/ClutteredDentalAdmiralbutterfly-size_restricted.gif?w=1155&h=840", "https://fitnessvolt.com/wp-content/uploads/2020/10/butt-kicks-exercise-750x393.jpg", 0, 20),
//                new Exercise("High Knees", "Lift up your left knee to your chest. Switch to lift your right knee to your chest and repeat up to the number of repetitions indicated.", "https://media.istockphoto.com/vectors/high-knees-exercise-woman-colorful-cartoon-vector-illustration-vector-id1273899582?k=6&m=1273899582&s=170667a&w=0&h=gZ9pwVjGG9t-rgkd9aLEsBgqZoBVnlDiV4gwmtRhXVo=", "https://i1.wp.com/everything-badminton.com/wp-content/uploads/2020/08/37011101-High-Knee-Sprints_Cardio_medium.png?resize=800%2C538&ssl=1", 0, 20),
//                new Exercise("Seal Jack", "Performed by jumping to a position with the legs spread wide and the hands performing a frontal clap and then returning to a position with the feet together and the arms at the sides.", "https://i.pinimg.com/originals/15/b9/7b/15b97b777b943ff6b4dd9589884b478d.png", "https://russhowepti.com/wp-content/uploads/2020/07/EXERCISE-DEMO-jumping-jacks.jpg", 0, 20),
//                new Exercise("Alternating Fast Feet", "With your feet at hips width, lower your body down into a half squat position and reach out with your arms in front of you. Hold this body position, then start running as fast as you can on the spot.", "https://assets.menshealth.co.uk/main/assets/156-Sumo-fast-feet-side-centre-side_1.gif?mtime=1502699982", "https://www.gymvisual.com/14131/quick-feet-version-2.jpg", 1, 15),
//                new Exercise("Lateral Line Hop", "Jump to opposite side of line and land on forefeet. Continue jumping from side to side landing on forefeet.", "https://i.pinimg.com/originals/96/94/c5/9694c565c29f34641baa6b6df83b5d31.gif", "https://russhowepti.com/wp-content/uploads/2020/07/EXERCISE-DEMO-step-jumps.jpg", 1, 25),
//                new Exercise("Knee to elbow", "Stand with your feet shoulder width apart. Bend your arms and place your hands behind your head. Move each knee to the opposite elbow, while alternating sides. Squeeze your abs.", "https://media1.popsugar-assets.com/files/thumbor/_p8gv6MnKb0O-Y6r6bhItDjybXo/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2016/12/13/004/n/1922729/615e90366c4db264_8.-Standing-elbow-to-knee/i/Circuit-3-Standing-Elbow--Knee.jpg", "https://chunkfitness.com/sites/default/files/situps-elbow-to-knee-twist_1.jpg", 0, 10));
//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_low_pass_through);
        exercises=  getIntent().getParcelableArrayListExtra("arrayofexercises");


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
    public void passthroughexercises(List<Exercise> arrayofexercises){


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
                        Intent in=new Intent(CardioLowPassThrough.this,WorkoutInfo.class);
                        int minutes = (int) (totaltiming/ 1000)/ 60;
                        int seconds = (int) (totaltiming/ 1000)% 60;
                        String timeld=String.format("%02d", minutes)+":"+ String.format("%02d", seconds) + " minutes";
                        in.putExtra("timespend",timeld);
                        startActivity(in);
                        finish();
                    }
                    else {
                        Log.d("differenceend-star",String.valueOf(System.currentTimeMillis()-startTime));
                        Intent intent = new Intent(CardioLowPassThrough.this, TimerCountDown.class);
                        intent.putExtra("repetitions", arrayofexercises.get(position + 1).getAmount());
                        intent.putExtra("hastiming", arrayofexercises.get(position + 1).getTimer());
                        intent.putExtra("nextex", arrayofexercises.get(position + 1).getName());
                        intent.putExtra("animation_url", arrayofexercises.get(position + 1).getExercise_url());
                        intent.putExtra("position", position + 1);
                        intent.putParcelableArrayListExtra("arrayofexercises",exercises);

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
                        Intent in=new Intent(CardioLowPassThrough.this,WorkoutInfo.class);
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
                        Intent intent = new Intent(CardioLowPassThrough.this, TimerCountDown.class);
                        intent.putExtra("repetitions", arrayofexercises.get(position + 1).getAmount());
                        intent.putExtra("hastiming", arrayofexercises.get(position + 1).getTimer());
                        intent.putExtra("nextex", arrayofexercises.get(position + 1).getName());
                        intent.putExtra("animation_url", arrayofexercises.get(position + 1).getExercise_url());
                        intent.putExtra("timespend",(System.currentTimeMillis()-startTime)+totaltiming);
                        intent.putExtra("position", position + 1);
                        intent.putParcelableArrayListExtra("arrayofexercises",exercises);

                        startActivity(intent);
                        finish();

                    }




                }
            });



        }
    }


    public   List<Exercise> convert2(ArrayList<Exercise> list) {

        List<Exercise> array = list;


        return array;


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { if (keyCode == KeyEvent.KEYCODE_BACK) {

        if (valueOf(hastiming).equals("0")){


        }else{
            mCountDownTimer.cancel();
            mCountDownTimer.onFinish();

        }
        Intent i = new Intent(this,CardioLow.class);
        startActivity(i);
        finish();
    }
         return false; }



    public void startTimer() {
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

    public void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextCountDown.setText(timeLeftFormatted);
        Log.d("Timer", timeLeftFormatted);
        if (timeLeftFormatted.equals("00:00")) {
            if(valueOf(position+1).equals(valueOf(arrayofexercises.size()))){
                Intent in=new Intent(CardioLowPassThrough.this,WorkoutInfo.class);
                int totalmins = (int) (totaltiming/ 1000)/ 60;
                int totalsecs = (int) (totaltiming/ 1000)% 60;
                String timeld=String.format("%02d", totalmins)+":"+ String.format("%02d", totalmins) + " seconds";
                in.putExtra("timespend",timeld);
                startActivity(in);
                finish();
            }
            else {
                mCountDownTimer.cancel();
                mCountDownTimer.onFinish();
                Intent intent = new Intent(CardioLowPassThrough.this, TimerCountDown.class);
                intent.putExtra("repetitions", arrayofexercises.get(position + 1).getAmount());
                intent.putExtra("hastiming", arrayofexercises.get(position + 1).getTimer());
                intent.putExtra("nextex", arrayofexercises.get(position + 1).getName());
                intent.putExtra("animation_url", arrayofexercises.get(position + 1).getExercise_url());
                intent.putExtra("timespend",(System.currentTimeMillis()-startTime)+totaltiming);
                intent.putExtra("position", position + 1);
                intent.putParcelableArrayListExtra("arrayofexercises",exercises);

                startActivity(intent);
                finish();

            }


        }
    }
}

