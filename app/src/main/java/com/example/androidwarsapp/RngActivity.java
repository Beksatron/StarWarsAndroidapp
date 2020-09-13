package com.example.androidwarsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RngActivity extends MainActivity {

    private static final String TAG = "text1";
    public TextView textView;
    String text;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: RNG STARTS");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rng_screen);

        textView = (TextView) findViewById(R.id.rng_text);
        final Button numGen = (Button) findViewById(R.id.btn_numGen);
        Button previous = (Button) findViewById(R.id.btn_return);
//set user input into text field
        Intent i = getIntent();
        text = i.getStringExtra("text");
        textView.setText(text);

        numGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                number = random.nextInt(100 - 10) + 10;
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                return text + random number as a string value inside input on validation screen
//                if random number isn't pressed return only text
                Intent intent = new Intent(RngActivity.this, MainActivity.class);
                intent.putExtra("text", text);
                intent.putExtra("number", number);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("text", textView.getText().toString());
        outState.putInt("number", number);
        super.onSaveInstanceState(outState);
    }
}