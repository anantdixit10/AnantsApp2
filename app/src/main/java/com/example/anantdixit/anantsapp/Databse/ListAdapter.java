package com.example.anantdixit.anantsapp.Databse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.anantdixit.anantsapp.R;

import java.util.ArrayList;

/**
 * Created by anantdixit on 10/15/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CourseViewHolder> {


    Context context;
    ArrayList<String> mealList;

    public ListAdapter(Context context, ArrayList<String> coursesList) {
        this.context = context;
        this.mealList = coursesList;
    }


    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.final_list, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, final int position) {
        holder.txt1.setText(mealList.get(position));
    }


    @Override
    public int getItemCount() {
        return mealList.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView txt1;
        CheckBox chkbox;

        public CourseViewHolder(View itemView) {
            super(itemView);
            txt1 = (TextView) itemView.findViewById(R.id.txt1);
            chkbox = (CheckBox) itemView.findViewById(R.id.chkbox);

        }

}

}