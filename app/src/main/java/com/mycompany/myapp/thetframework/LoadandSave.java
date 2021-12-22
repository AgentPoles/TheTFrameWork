package com.mycompany.myapp.thetframework;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Paul on 2/13/2018.
 */
public class LoadandSave {
    String [] att;
    String arrayName;
    String [] arroy;
     List<String> free = new ArrayList<>();
    Context context;
    Activity fr;
    public LoadandSave(){

    }
    public LoadandSave(String arrayName, String [] arroy, Context context, List<String> free){
        this.arrayName = arrayName;
        this.arroy = arroy;
        this.context = context;
        this.fr = fr;
        this.free = free;

    }
    public LoadandSave(String arrayName, Context context){
        this.context = context;
        this.arrayName = arrayName;
    }
    public LoadandSave(String arrayName,List<String> free, Context context ){
        this.arrayName = arrayName;
        this.free = free;
        this.context = context;
    }
    public String [] loadInBackground(String arrayName,List<String> free, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(arrayName, 0);
        int size = prefs.getInt(arrayName + "_size", 0);
//            displayoe(String.valueOf(size));
        String array[] = new String[size];
        for(int i=0;i<size;i++) {
            array[i] = prefs.getString(arrayName + "_" + i, null);
//                displayu(array[i]);

        }
        free.addAll(Arrays.asList(array));
//            displayu(String.valueOf(size));


            return array;
    }
    public boolean saveInBackground() {
        String [] arroyb = free.toArray(new String[0]);
        SharedPreferences prefs = context.getSharedPreferences(arrayName, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", arroyb.length);
        for(int i=0;i<arroyb.length;i++) {
            editor.putString(arrayName + "_" + i, arroyb[i]);
//            displayu(array[i]);
        }
        return editor.commit();
    }
}
