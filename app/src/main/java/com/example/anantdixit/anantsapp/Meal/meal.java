package com.example.anantdixit.anantsapp.Meal;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by anantdixit on 10/10/2017.
 */

public class meal {
    String courseName;
    String teacher;
    Integer classes;

    public String getCourseName() {
        return courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public Integer getClasses() {
        return classes;
    }

    public meal(String courseName, String teacher, Integer classes) {

        this.courseName = courseName;
        this.teacher = teacher;
        this.classes = classes;
    }

    static String courses[] = {"Crux","Launchpad","Pandora","Algo++","Elixir"};
    static String teachers[] = {"Arnav","Prateek","Sumit","Rishabh","Harshit","Aayush"};

    public static ArrayList<meal> getCourses(int n){
        ArrayList<meal> coursesList  = new ArrayList<>();
        Random r = new Random();

        for(int i = 0 ;i< n ;i++){
            meal newCourse = new meal(
                    courses[r.nextInt(courses.length)],
                    teachers[r.nextInt(teachers.length)],
                    20 + r.nextInt(5)
            );
            coursesList.add(newCourse);
        }

        return coursesList;

    }
}
