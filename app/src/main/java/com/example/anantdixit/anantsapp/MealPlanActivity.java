package com.example.anantdixit.anantsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anantdixit.anantsapp.Databse.ViewListContentsActivity;
import com.example.anantdixit.anantsapp.Meal.meal;
import com.example.anantdixit.anantsapp.Meal.mealRecycleradapter;

import java.util.ArrayList;

public class MealPlanActivity extends AppCompatActivity {
    EditText edit1,edit2,edit3;
    Button btnAdd,btnsubmit;
    RecyclerView rvmealList;
    ArrayList<meal> mealList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        btnAdd = (Button) findViewById(R.id.btn1);
        btnsubmit = (Button)findViewById(R.id.btnsubmit);
        rvmealList = (RecyclerView) findViewById(R.id.rvCourses);

        mealList = meal.getCourses(10);


        final mealRecycleradapter adapter = new mealRecycleradapter(this,mealList);
        rvmealList.setLayoutManager(new LinearLayoutManager(this));
        rvmealList.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkMeal = edit1.getText().toString();
                String checkProtein = edit2.getText().toString();
                String checkCarbs = edit3.getText().toString();
                if(TextUtils.isEmpty(checkMeal)||TextUtils.isEmpty(checkProtein)||TextUtils.isEmpty(checkCarbs)){
                    Toast.makeText(MealPlanActivity.this, "Fields Cannot Be Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                meal newCourse = new meal(
                        checkMeal,
                        checkProtein,
                        checkCarbs
                );
                mealList.add(newCourse);
                adapter.notifyDataSetChanged();
            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewListContentsActivity.class);
                startActivity(intent);
            }
        });

    }
}






