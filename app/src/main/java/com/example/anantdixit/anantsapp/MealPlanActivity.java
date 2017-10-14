package com.example.anantdixit.anantsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anantdixit.anantsapp.Meal.meal;
import com.example.anantdixit.anantsapp.Meal.mealRecycleradapter;

import java.util.ArrayList;

public class MealPlanActivity extends AppCompatActivity {
    EditText etCourse,etTeacher,etClasses;
    Button btnAdd;
    RecyclerView rvCourseList;
    ArrayList<meal> coursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        etCourse = (EditText) findViewById(R.id.edit1);
        etTeacher = (EditText) findViewById(R.id.edit2);
        etClasses = (EditText) findViewById(R.id.edit2);
        btnAdd = (Button) findViewById(R.id.btn1);
        rvCourseList = (RecyclerView) findViewById(R.id.rvCourses);

        coursesList = meal.getCourses(10);

        final mealRecycleradapter adapter = new mealRecycleradapter(this,coursesList);
        rvCourseList.setLayoutManager(new LinearLayoutManager(this));
        rvCourseList.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkCourse = etCourse.getText().toString();
                String checkTeacher = etTeacher.getText().toString();
                String checkClasses = etClasses.getText().toString();
                if(TextUtils.isEmpty(checkCourse)||TextUtils.isEmpty(checkTeacher)||TextUtils.isEmpty(checkClasses)){
                    Toast.makeText(MealPlanActivity.this, "Fields Cannot Be Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                meal newCourse = new meal(
                        checkCourse,
                        checkTeacher,
                        Integer.valueOf(checkClasses)
                );
                coursesList.add(newCourse);
                adapter.notifyDataSetChanged();
            }
        });
    }
}






