package com.example.fitup;

import java.util.ArrayList;
import java.util.List;

public class ListtoArray {

    public static  ArrayList<Exercise> converting(List<Exercise> list) {
        ArrayList<Exercise> array = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            array.add(list.get(i));
        }

        return array;


    }
}