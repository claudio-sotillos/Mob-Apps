package com.example.fitup;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardioLowAdapter extends RecyclerView.Adapter<CardioLowAdapter.CardioLowViewHolder> {
    public static class CardioLowViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout containerview;
        public TextView textview;
        CardioLowViewHolder(View view) {
            super(view);
            containerview = view.findViewById(R.id.cardiolow_row);
            textview = view.findViewById(R.id.cardiolow_row_text_view);

            containerview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Exercise excurrent= (Exercise) containerview.getTag();
                    Intent intent=new Intent(view.getContext(),CardioLowActivity.class);
                    intent.putExtra("name",excurrent.getName());
                    intent.putExtra("description",excurrent.getDescription());
                    intent.putExtra("exercise_url",excurrent.getExercise_url());
                    intent.putExtra("work_url",excurrent.getWork_url());
                    intent.putExtra("timer",String.valueOf(excurrent.getTimer()));
                    intent.putExtra("amount",String.valueOf(excurrent.getAmount()));
                    view.getContext().startActivity(intent);
                }
            });
        }

    }
//    private List<Exercise>  exercises= Arrays.asList(
//            new Exercise("Push-ups"),
//            new Exercise("Run"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),new Exercise("Run-treadmile"),
//            new Exercise("Run-treadmile"),new Exercise("Run-treadmile")
//
//
//
//
//            );

    private List<Exercise>  exercises= Arrays.asList(
            new Exercise("Jumping Jack", "Performed by jumping to a position with the legs spread wide and the hands going overhead and then returning to a position with the feet together and the arms at the sides.", "https://i.pinimg.com/originals/34/cb/99/34cb992c8c0c57e896a22c1036a7c038.gif","https://darebee.com/images/workouts/muscles/recalibrator-workout.jpg",0, 10),
            new Exercise("Butt Kicks", "Kicking your shins back behind you to touch your buttocks with the bottom of your foot.", "https://i0.wp.com/thumbs.gfycat.com/ClutteredDentalAdmiralbutterfly-size_restricted.gif?w=1155&h=840","https://fitnessvolt.com/wp-content/uploads/2020/10/butt-kicks-exercise-750x393.jpg",0, 20),
            new Exercise("High Knees", "Lift up your left knee to your chest. Switch to lift your right knee to your chest and repeat up to the number of repetitions indicated.", "https://media.istockphoto.com/vectors/high-knees-exercise-woman-colorful-cartoon-vector-illustration-vector-id1273899582?k=6&m=1273899582&s=170667a&w=0&h=gZ9pwVjGG9t-rgkd9aLEsBgqZoBVnlDiV4gwmtRhXVo=","https://i1.wp.com/everything-badminton.com/wp-content/uploads/2020/08/37011101-High-Knee-Sprints_Cardio_medium.png?resize=800%2C538&ssl=1",0, 20),
            new Exercise("Seal Jack", "Performed by jumping to a position with the legs spread wide and the hands performing a frontal clap and then returning to a position with the feet together and the arms at the sides.", "https://i.pinimg.com/originals/15/b9/7b/15b97b777b943ff6b4dd9589884b478d.png","https://russhowepti.com/wp-content/uploads/2020/07/EXERCISE-DEMO-jumping-jacks.jpg",0,20),
            new Exercise("Alternating Fast Feet", "With your feet at hips width, lower your body down into a half squat position and reach out with your arms in front of you. Hold this body position, then start running as fast as you can on the spot.", "https://assets.menshealth.co.uk/main/assets/156-Sumo-fast-feet-side-centre-side_1.gif?mtime=1502699982","https://www.gymvisual.com/14131/quick-feet-version-2.jpg",1, 15),
            new Exercise("Lateral Line Hop", "Jump to opposite side of line and land on forefeet. Continue jumping from side to side landing on forefeet.", "https://i.pinimg.com/originals/96/94/c5/9694c565c29f34641baa6b6df83b5d31.gif","https://russhowepti.com/wp-content/uploads/2020/07/EXERCISE-DEMO-step-jumps.jpg",1,25),
            new Exercise("Knee to elbow", "Stand with your feet shoulder width apart. Bend your arms and place your hands behind your head. Move each knee to the opposite elbow, while alternating sides. Squeeze your abs.", "https://media1.popsugar-assets.com/files/thumbor/_p8gv6MnKb0O-Y6r6bhItDjybXo/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2016/12/13/004/n/1922729/615e90366c4db264_8.-Standing-elbow-to-knee/i/Circuit-3-Standing-Elbow--Knee.jpg","https://chunkfitness.com/sites/default/files/situps-elbow-to-knee-twist_1.jpg",0,10));
//    private RequestQueue requestQueue;
//    CardioLowAdapter(Context context){
//        requestQueue= Volley.newRequestQueue(context);
//        loadExercises();
//    }
//    public void loadExercises(){
////        String urlset="https://wger.de/api/v2/set/";
//        String url="https://wger.de/api/v2/exercise/?limit=100&offset=100";
//
//        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
////                Get the key of a jsonobject
//                try {
//
//                    JSONArray results = response.getJSONArray("results");
//                    for (int i=0;i<results.length();i++){
//                        JSONObject result=results.getJSONObject(i);
//                        exercises.add(new Exercise(result.getString("description")));
//
//                    }
//                } catch (JSONException e) {
//                    Log.e("cs50", "JsonError", e);
//                }
//                notifyDataSetChanged();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("cs50","Exercises list error");
//            }
//
//
//    });
//
//        requestQueue.add(request);
//    }

    @NonNull
    @Override
    public CardioLowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardiolowexercise,parent,false);
        return new CardioLowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardioLowViewHolder holder, int position) {
            Exercise excurrent=exercises.get(position);
            holder.textview.setText(excurrent.getName());
            holder.containerview.setTag(excurrent);
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}
