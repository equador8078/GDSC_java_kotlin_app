package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button calculate;
    private EditText inches;
    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_converter);
        findView();
        setUpOnClickListener();
    }
    private void setUpOnClickListener(){
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double x=convert_meters();
                    results.setText(displayResults(x));
            }
        });
    }

    private String displayResults(double x) {
        DecimalFormat decimalFormatter = new DecimalFormat("0.00");
        String formatted_results=decimalFormatter.format(x);
        return "Unit in meters = "+formatted_results;
    }

    private double convert_meters() {
        String inches_String= inches.getText().toString();
        if(inches_String.isEmpty()){
            Toast.makeText(MainActivity.this,"Please enter valid value",Toast.LENGTH_SHORT).show();
            return 0.0;
        }
        else {
            int inches_Int = Integer.parseInt(inches_String);
            return inches_Int / 39.37;
        }
    }

    private void  findView(){
       calculate = findViewById(R.id.calculate_Button);
       inches = findViewById(R.id.inches_Edittext);
       results = findViewById(R.id.results_textview);
   }
}