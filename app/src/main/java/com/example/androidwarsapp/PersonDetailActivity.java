package com.example.androidwarsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PersonDetailActivity extends AppCompatActivity {
    String text_name;
    String text_height;
    String text_mass;
    String text_films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_person_detail);

        TextView name = (TextView) findViewById(R.id.person_name);
        TextView height = (TextView) findViewById(R.id.person_height);
        TextView mass = (TextView) findViewById(R.id.person_mass);
        TextView movie = (TextView) findViewById(R.id.person_movie);
    }
}