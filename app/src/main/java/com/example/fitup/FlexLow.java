package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.valueOf;

public class FlexLow extends CardioLow {
    private List<Exercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        exercises = Arrays.asList(
                new Exercise("Loko Jack", "Estirarse de piernas paqui .", "https://i.pinimg.com/originals/34/cb/99/34cb992c8c0c57e896a22c1036a7c038.gif", "https://darebee.com/images/workouts/muscles/recalibrator-workout.jpg", 0, 10),
                new Exercise("que no llegas Kicks", "No llegas abajo ni de coña foot.", "https://i0.wp.com/thumbs.gfycat.com/ClutteredDentalAdmiralbutterfly-size_restricted.gif?w=1155&h=840", "https://fitnessvolt.com/wp-content/uploads/2020/10/butt-kicks-exercise-750x393.jpg", 0, 20),
                new Exercise("Aunque lo intentes no lo va a conseguir Knees", "Lift up your left knee to your chest. Switch to lift your right knee to your chest and repeat up to the number of repetitions indicated.", "https://media.istockphoto.com/vectors/high-knees-exercise-woman-colorful-cartoon-vector-illustration-vector-id1273899582?k=6&m=1273899582&s=170667a&w=0&h=gZ9pwVjGG9t-rgkd9aLEsBgqZoBVnlDiV4gwmtRhXVo=", "https://i1.wp.com/everything-badminton.com/wp-content/uploads/2020/08/37011101-High-Knee-Sprints_Cardio_medium.png?resize=800%2C538&ssl=1", 0, 20),
                new Exercise("Tio que no mal  Jack", "Performed by jumping to a position with the legs spread wide and the hands performing a frontal clap and then returning to a position with the feet together and the arms at the sides.", "https://i.pinimg.com/originals/15/b9/7b/15b97b777b943ff6b4dd9589884b478d.png", "https://russhowepti.com/wp-content/uploads/2020/07/EXERCISE-DEMO-jumping-jacks.jpg", 0, 20),
                new Exercise("Alternando Feet", "With your feet at hips width, lower your body down into a half squat position and reach out with your arms in front of you. Hold this body position, then start running as fast as you can on the spot.", "https://assets.menshealth.co.uk/main/assets/156-Sumo-fast-feet-side-centre-side_1.gif?mtime=1502699982", "https://www.gymvisual.com/14131/quick-feet-version-2.jpg", 1, 15),
                new Exercise("Tu tienes calle y Line Hop eh?", "Jump to opposite side of line and land on forefeet. Continue jumping from side to side landing on forefeet.", "https://i.pinimg.com/originals/96/94/c5/9694c565c29f34641baa6b6df83b5d31.gif", "https://russhowepti.com/wp-content/uploads/2020/07/EXERCISE-DEMO-step-jumps.jpg", 1, 25),
                new Exercise("Te partes las hombrillas", "Stand with your feet shoulder width apart. Bend your arms and place your hands behind your head. Move each knee to the opposite elbow, while alternating sides. Squeeze your abs.", "https://media1.popsugar-assets.com/files/thumbor/_p8gv6MnKb0O-Y6r6bhItDjybXo/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2016/12/13/004/n/1922729/615e90366c4db264_8.-Standing-elbow-to-knee/i/Circuit-3-Standing-Elbow--Knee.jpg", "https://chunkfitness.com/sites/default/files/situps-elbow-to-knee-twist_1.jpg", 0, 10));


      initialize(exercises);

    }
    @Override
    public void passthroughlowexercises(View v){
        super.passthroughlowexercises(v);
        ArrayList<Exercise>  listtoArray=converting(exercises);
        Log.d("FLEEEEEX", String.valueOf(listtoArray));
        Intent inteflex=new Intent(this,FlexLowPassThrough.class);
        inteflex.putExtra("position",0);
        inteflex.putParcelableArrayListExtra("arrayofflexexercises",listtoArray  );
        startActivity(inteflex);
        finish();

    }





}

