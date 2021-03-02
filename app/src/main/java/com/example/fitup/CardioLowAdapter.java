package com.example.fitup;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    private List<Exercise>  exercises= Arrays.asList(
            new Exercise("Exercise 1"),
            new Exercise("Exercise 2"),
            new Exercise("Exercise3")
    );

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
