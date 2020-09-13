package com.example.androidwarsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;

public class MainActivity extends LocaleApp implements PopupMenu.OnMenuItemClickListener {
    private static final String TAG = "MainActivity";
    public EditText input;
    public Button btn_language;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starts");
        super.onCreate(savedInstanceState);
        LoadLanguage();


        setContentView(R.layout.validation_screen);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        btn_language = (Button) findViewById(R.id.btn_language);

//set btn_language text below
        if (btnChecker.equals("hr")) {
            btn_language.setText("Hrvatski");
        } else if (btnChecker.equals("en")) {
            btn_language.setText("English");
        } else {
            btn_language.setText("-");
        }

        input = (EditText) findViewById(R.id.input_text);
        input.setText("");
//get intent from rng screen and set text for input after RNG button is clicked
        Intent i = getIntent();
        RngActivity cRngActivity = new RngActivity();
        cRngActivity.text = i.getStringExtra("text");

        RngActivity cRngActivity1 = new RngActivity();
        cRngActivity1.number = i.getIntExtra("number", 0);

        if (cRngActivity1.number != 0) {
            String set = cRngActivity.text + Integer.toString(cRngActivity1.number);
            input.setText(set);
        } else {
            String set = cRngActivity.text;
            input.setText(set);
        }

        final Button btn_login = (Button) findViewById(R.id.btn_login);
        Button btn_rng = (Button) findViewById(R.id.btn_rng);

//on click for pop up menu, rest of the code within onMenuItemClick
        btn_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: starts");

                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.inflate(R.menu.popup_menu);
                popup.show();
                Log.d(TAG, "onClick: ends");
            }

        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                String login = input.getText().toString();
                boolean validate;
                Login cLogin = new Login();
                validate = cLogin.validate(login);


                if (validate) {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    Intent intent = new Intent(MainActivity.this, MainScreenActivity.class);
                    startActivityForResult(intent, 0);

                } else {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                }
            }
        });

        btn_rng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RngActivity.class);
                intent.putExtra("text", input.getText().toString());
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putString("text", input.getText().toString());
        super.onSaveInstanceState(outState);

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.but_eng:
                selectLocale("en");
                break;

            case R.id.but_cro:
                selectLocale("hr");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}


