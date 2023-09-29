package com.example.resturantmenuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView Starters;
    CardView Mains;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Starters=findViewById(R.id.Card_View_Starters);
        Mains= findViewById(R.id.Card_view_mains);

        Starters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startersActivityIntent = new Intent(MainActivity.this,StartersActivity.class);
                startActivity(startersActivityIntent);
            }
        });

    }
}