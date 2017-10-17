package com.example.anantdixit.anantsapp.Meal;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by anantdixit on 10/10/2017.
 */

public class meal {
    String mealName;
    String Protein;
    String Carbs;

    public String getMealName() {
        return mealName;
    }

    public String getProtein() {
        return Protein;
    }

    public String getCarbs() {
        return Carbs;
    }

    public meal(String mealName, String Protein, String Carbs) {

        this.mealName = mealName;
        this.Protein = Protein;
        this.Carbs = Carbs;
    }

    static String meals[] = {"milk","Rice","Dal","Roti","Chicken","soyabean",};
    static String proteins[] = {"3.4gm","2.7gm","6.8gm","11.5gm","25.3gm","16.6gm"};
    static String Carbos[] = {"5gm","28gm","14gm","55.8gm","0gm","21gm"};
    public static ArrayList<meal> getCourses(int n){
        ArrayList<meal> coursesList  = new ArrayList<>();
        Random r = new Random();

        for(int i = 0 ;i< n ;i++){
            meal newCourse = new meal(
                    meals[r.nextInt(meals.length)],
                    proteins[r.nextInt(proteins.length)],
                    Carbos[r.nextInt(Carbos.length)]

            );
            coursesList.add(newCourse);
        }

        return coursesList;

    }
}
