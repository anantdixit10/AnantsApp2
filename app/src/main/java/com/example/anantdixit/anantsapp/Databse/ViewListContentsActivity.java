package com.example.anantdixit.anantsapp.Databse;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.anantdixit.anantsapp.R;

import java.util.ArrayList;

/**
 * Created by anantdixit on 10/15/2017.
 */

public class ViewListContentsActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    ListAdapter listadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewlistcontents_layout);

        RecyclerView rview = (RecyclerView) findViewById(R.id.rview);
        myDB = new DatabaseHelper(this);

        //populate an ArrayList<String> from the database and then view it
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        if(!(data.getCount()==0))

        {
            while (data.moveToNext()) {
                theList.add(data.getString(1));
            }
        };
                final ListAdapter adapter = new ListAdapter(this,theList);
                rview.setLayoutManager(new LinearLayoutManager(this));
                rview.setAdapter(adapter);
            }
        }


