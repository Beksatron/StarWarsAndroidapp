package com.example.androidwarsapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class LocaleApp extends AppCompatActivity {
    private static final String TAG = "tag";
    public String btnChecker;


    public void saveLocale(String language) {

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.myapp.PREFERENCES",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USER_LANGUAGE", language);
        editor.commit();

    }


    public void LoadLanguage() {

        SharedPreferences shp = getSharedPreferences(
                "com.example.myapp.PREFERENCES", Context.MODE_PRIVATE);
        String language = shp.getString("USER_LANGUAGE", "");

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        btnChecker = language.toString();
    }

    public void selectLocale(String language) {

        Toast.makeText(this, "Language updated", Toast.LENGTH_LONG).show();
        Locale locale;
        Configuration config;

        locale = new Locale(language);
        Locale.setDefault(locale);

        config = new Configuration();
        config.locale = locale;

        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        saveLocale(language);
        setContentView(R.layout.validation_screen);
        recreate();
    }
}
