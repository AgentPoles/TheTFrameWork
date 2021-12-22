package com.mycompany.myapp.thetframework;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Paul on 3/3/2018.
 */
public class Spreferences {
    SharedPreferences mySharedpreferences;
    SharedPreferences.Editor sharedpreferenceEditor;
    int  before;
    int now;
    static int b;
    public Spreferences(){

    }
    public static boolean ReadState(SharedPreferences sharedPreferences, String key, SharedPreferences.Editor e, int c, int d){
        int a = 0;
        boolean isread = false;
            a = sharedPreferences.getInt(key, -1);
         b = c+d;
        if(b>a){
//            sharedPreferences = context.getSharedPreferences(preference_name,Context.MODE_PRIVATE);
//            e = sharedPreferences.edit();
            isread = false;
        }
        else {
            isread = true;
        }
        return isread;
    }
    public static boolean setReadState(SharedPreferences sharedPreferences, String key, SharedPreferences.Editor e, int c, int d){
        boolean isread = true;
        b = c+d;
//            sharedPreferences = context.getSharedPreferences(preference_name,Context.MODE_PRIVATE);
//            e = sharedPreferences.edit();
            e.putInt(key,b);
            e.apply();
        return isread;
    }
}
