package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.sql.SQLOutput;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private TextView results;
    private Button calculate;
    private EditText weight;
    private EditText age;
    private EditText inches;
    private EditText feet;
    private RadioButton female_button;
    private RadioButton male_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);
        findviewbyID();
        setUpOnClickListener();
    }
    private void setUpOnClickListener(){
        calculate.setOnClickListener(view -> {
            double x=calculate_BMI();
            results.setText(Display(x));
        });
    }

    private double calculate_BMI() {
        String age_Text = age.getText().toString();
        String feet_Text= feet.getText().toString();
        String inch_Text= inches.getText().toString();
        String weight_Text =weight.getText().toString();
        int age_Int=  Integer.parseInt(age_Text);
        int feet_Int= Integer.parseInt(feet_Text);
        int inches_Int= Integer.parseInt(inch_Text);
        int weight_Int= Integer.parseInt(weight_Text);
        double height = (feet_Int+(inches_Int/12.0))/3.281;
        if (height==0){
            Toast.makeText(this ,"Height cannot be zero",Toast.LENGTH_LONG).show();
            return 0;
        }
        return weight_Int/(height*height);
    }

    private void findviewbyID() {
        results = findViewById(R.id.text_view_results);
        calculate = findViewById(R.id.button_calculate);
        weight = findViewById(R.id.edit_text_weight);
        ImageView image = findViewById(R.id.image_tape);
        age = findViewById(R.id.edit_text_age);
        inches = findViewById(R.id.edit_text_inches);
        feet = findViewById(R.id.edit_text_feets);
        female_button = findViewById(R.id.radio_button_female);
        male_button = findViewById(R.id.radio_button_male);
    }
    private String Display(double BMI) {
        java.text.DecimalFormat decimalFormatter = new DecimalFormat("0.00");
        String BMI_String = decimalFormatter.format(BMI);
        String result_Text = "";
        if (male_button.isChecked()) {
            if (BMI < 18.5) {
                result_Text = BMI_String + " you are underweight male";
            } else if (BMI > 25) {
                result_Text = BMI_String + " you are overweight male";
            } else
                result_Text = BMI_String + " you are healthy male";
        }
        else if (female_button.isChecked()) {
            if (BMI < 18.5) {
                result_Text = BMI_String + " you are underweight female";
            } else if (BMI > 25) {
                result_Text = BMI_String + " you are overweight female";
            } else
                result_Text = BMI_String + " you are healthy female";
        }
        else
            result_Text="Select gender first";
        return result_Text;
    }
}