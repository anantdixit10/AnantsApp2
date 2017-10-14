package com.example.anantdixit.anantsapp.Meal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anantdixit.anantsapp.R;

import java.util.ArrayList;

/**
 * Created by anantdixit on 10/10/2017.
 */

public class mealRecycleradapter extends RecyclerView.Adapter<mealRecycleradapter.CourseViewHolder> {

    Context context;
    ArrayList<meal> coursesList;

    public mealRecycleradapter(Context context, ArrayList<meal> coursesList) {
        this.context = context;
        this.coursesList = coursesList;
    }


    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list,parent,false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, final int position) {
        holder.tvCourse.setText(coursesList.get(position).getCourseName());
        holder.tvTeacher.setText(coursesList.get(position).getTeacher());
        holder.tvClasses.setText(coursesList.get(position).getClasses().toString());
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coursesList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder{
        TextView tvCourse,tvTeacher,tvClasses;
        ImageView ivDelete;
        public CourseViewHolder(View itemView) {
            super(itemView);
            tvCourse = (TextView) itemView.findViewById(R.id.tvClasses);
            tvTeacher = (TextView) itemView.findViewById(R.id.tvteacher);
            tvClasses = (TextView) itemView.findViewById(R.id.tvCourseName);
            ivDelete = (ImageView) itemView.findViewById(R.id.delete);
        }
    }
}

