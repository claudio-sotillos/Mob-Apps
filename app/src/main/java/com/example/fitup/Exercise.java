package com.example.fitup;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

//public class Exercise {
//    String name;
//    String description;
//    String exercise_url;
//    String work_url;
//    int timer;  // If this attribute is 1, this means that the timer will be needed
//    int amount;  // Thus if timer == 1, then the 'amount' number will be seconds. If timer == 0, then it will be repetitions
//
//
////    public Exercise(String name, String description, String exercise_url, String work_url, int timer, int amount) {
////        this.name = name;
////        this.description = description;
////        this.exercise_url = exercise_url;
////        this.work_url = work_url;
////        this.timer = timer;
////        this.amount = amount;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public String getDescription() {
////        return description;
////    }
////
////    public void setDescription(String description) {
////        this.description = description;
////    }
////
////    public String getExercise_url() {
////        return exercise_url;
////    }
////
////    public void setExercise_url(String exercise_url) {
////        this.exercise_url = exercise_url;
////    }
////
////    public String getWork_url() {
////        return work_url;
////    }
////
////    public void setWork_url(String work_url) {
////        this.work_url = work_url;
////    }
////
////    public int getTimer() {
////        return timer;
////    }
////
////    public void setTimer(int timer) {
////        this.timer = timer;
////    }
////
////    public int getAmount() {
////        return amount;
////    }
////
////    public void setAmount(int amount) {
////        this.amount = amount;
////    }
////
////
////}

public class Exercise implements Parcelable {
        String name;
        String description;
        String exercise_url;
        String work_url;
        int timer;  // If this attribute is 1, this means that the timer will be needed
        int amount;  // Thus if timer == 1, then the 'amount' number will be seconds. If timer == 0, then it will be repetitions


        public Exercise(String name, String description, String exercise_url, String work_url, int timer, int amount) {
            this.name = name;
            this.description = description;
            this.exercise_url = exercise_url;
            this.work_url = work_url;
            this.timer = timer;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getExercise_url() {
            return exercise_url;
        }

        public void setExercise_url(String exercise_url) {
            this.exercise_url = exercise_url;
        }

        public String getWork_url() {
            return work_url;
        }

        public void setWork_url(String work_url) {
            this.work_url = work_url;
        }

        public int getTimer() {
            return timer;
        }

        public void setTimer(int timer) {
            this.timer = timer;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }


        protected Exercise(Parcel in) {
            name = in.readString();
            description = in.readString();
            exercise_url = in.readString();
            work_url = in.readString();
            timer = in.readInt();
            amount = in.readInt();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(description);
            dest.writeString(exercise_url);
            dest.writeString(work_url);
            dest.writeInt(timer);
            dest.writeInt(amount);
        }

        @SuppressWarnings("unused")
        public static final Parcelable.Creator<Exercise> CREATOR = new Parcelable.Creator<Exercise>() {
            @Override
            public Exercise createFromParcel(Parcel in) {
                return new Exercise(in);
            }

            @Override
            public Exercise[] newArray(int size) {
                return new Exercise[size];
            }
        };
    }
