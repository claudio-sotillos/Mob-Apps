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
                    Exercise excurrent=(Exercise) containerview.getTag();
                    Intent intent=new Intent(view.getContext(),CardioLowActivity.class);
                    intent.putExtra("name",excurrent.getName());
                    view.getContext().startActivity(intent);
                }
            });
        }

    }
    private List<Exercise>  exercises= new ArrayList<>();

    private RequestQueue requestQueue;
    CardioLowAdapter(Context context){
        requestQueue= Volley.newRequestQueue(context);
        loadExercises();
    }
    public void loadExercises(){
//        String urlset="https://wger.de/api/v2/set/";
        String url="https://wger.de/api/v2/exercise/?limit=100&offset=100";

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                Get the key of a jsonobject
                try {

                    JSONArray results = response.getJSONArray("results");
                    for (int i=0;i<results.length();i++){
                        JSONObject result=results.getJSONObject(i);
                        exercises.add(new Exercise(result.getString("description")));

                    }
                } catch (JSONException e) {
                    Log.e("cs50", "JsonError", e);
                }
                notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("cs50","Exercises list error");
            }


    });

        requestQueue.add(request);
    }

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
