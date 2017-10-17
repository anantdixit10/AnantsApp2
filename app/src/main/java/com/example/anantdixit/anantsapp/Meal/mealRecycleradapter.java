package com.example.anantdixit.anantsapp.Meal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.anantdixit.anantsapp.Databse.DatabaseHelper;
import com.example.anantdixit.anantsapp.R;

import java.util.ArrayList;

/**
 * Created by anantdixit on 10/10/2017.
 */

public class mealRecycleradapter extends RecyclerView.Adapter<mealRecycleradapter.CourseViewHolder> {

    Context context;
    ArrayList<meal> mealList;
    DatabaseHelper mydb;

    public mealRecycleradapter(Context context, ArrayList<meal> coursesList) {
        this.context = context;
        this.mealList = coursesList;
    }


    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mydb = new DatabaseHelper(this.context);
        View itemView = li.inflate(R.layout.list,parent,false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, final int position) {
        holder.tvCourse.setText(mealList.get(position).getMealName());
        holder.tvTeacher.setText(mealList.get(position).getProtein());
        holder.tvClasses.setText(mealList.get(position).getCarbs());
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealList.remove(position);
                notifyDataSetChanged();
            }
        });
        if(holder.chk.isChecked()){
            String newEntry1 = holder.tvCourse.getText().toString();

            AddData(newEntry1);
        }
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder{
        TextView tvCourse,tvTeacher,tvClasses;
        ImageView ivDelete;
        RadioButton chk;
        public CourseViewHolder(View itemView) {
            super(itemView);
            tvCourse = (TextView) itemView.findViewById(R.id.tvCourseName);
            tvTeacher = (TextView) itemView.findViewById(R.id.tvteacher);
            tvClasses = (TextView) itemView.findViewById(R.id.tvClasses);
            ivDelete = (ImageView) itemView.findViewById(R.id.delete);
            chk = (RadioButton) itemView.findViewById(R.id.chk);

        }
    }
    public void AddData(String newEntry) {

         mydb.addData(newEntry);

    }
}

