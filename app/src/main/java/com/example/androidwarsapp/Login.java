package com.example.androidwarsapp;

import android.util.Log;

public class Login {


    private static final String TAG = "textLogin";

    public boolean validate(String text) {

        return length(text) && letterA(text) && number7(text) && upitnik(text) && hasNumberBeforeB(text);

    }

    public boolean length(String text) {

        if (text.length() > 4 && text.length() < 14) {
            return true;
        }
        return false;

    }

    public boolean letterA(String text) {
        return text.toLowerCase().split("a", -1).length > 2;
    }


    public boolean number7(String text) {
        return text.contains("7");

    }

    public boolean upitnik(String text) {
        return !text.contains("?");
    }

    public static boolean isNumeric(String strNum) {
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean hasNumberBeforeB(String text) {
        String[] txtArr = text.toLowerCase().split("b", -1);
        boolean hasB = false;
        boolean lastB = text.substring(text.length() - 1).equals("b");
        for(int i=0; i < txtArr.length; i++) {
            String str = txtArr[i];
            int l = str.length() - 1;
            if(l < 0 || i == txtArr.length - 1 && !lastB) {
                continue;
            }
            if(isNumeric(str.substring(l))) {
                hasB = true;
                break;
            }
        }
        return !hasB;
    }
}

