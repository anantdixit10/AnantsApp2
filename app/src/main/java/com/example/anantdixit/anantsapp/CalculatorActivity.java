package com.example.anantdixit.anantsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    Spinner spin;
    EditText editz;
    ImageView arrow;
    TextView resultc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        spin = (Spinner)findViewById(R.id.spin);
        editz = (EditText)findViewById(R.id.editz);
        resultc = (TextView)findViewById(R.id.resultc);
        arrow = (ImageView)findViewById(R.id.arrow);
        String [] nutrients = {"Protein","Carbs","Fat","Fiber","Calories"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,nutrients);
        spin.setAdapter(adapter);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItem = (String) spin.getSelectedItem();
                if(selectedItem.trim().equals("Protein")){
                    float result = (Float.parseFloat(editz.getText().toString()) * 11 / 10) ;
                    resultc.setText(Float.toString(result) + "gm");
                }else if(selectedItem.trim().equals("Carbs")){
                    float result = Float.parseFloat(editz.getText().toString()) * 9 / 10;
                    resultc.setText(Float.toString(result) + "gm");
                }else if(selectedItem.trim().equals("Fat")){
                    float result = Float.parseFloat(editz.getText().toString())* 4 / 10;
                    resultc.setText(Float.toString(result) + "gm");
                }else if(selectedItem.trim().equals("Fiber")) {
                    float result = 38;
                    resultc.setText(Float.toString(result) + "gm");
                }else if(selectedItem.trim().equals("Calories")){
                    float result = Float.parseFloat(editz.getText().toString())* 35;
                    resultc.setText(Float.toString(result));

                }
            }
        });
    }
}
