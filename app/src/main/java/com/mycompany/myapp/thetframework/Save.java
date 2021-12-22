package com.mycompany.myapp.thetframework;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Paul on 2/12/2018.
 */
public class Save extends AsyncTaskLoader<String> {
    String arrayName;
    String[] array;
    Context mContext;
    public Save(Context context, String arroyName, String[] arroy){
        super(context);
        this.arrayName = arroyName;
        this.array = arroy;
        this.mContext = context;

    }

    @Override
    public String loadInBackground() {
        SharedPreferences prefs = mContext.getSharedPreferences(arrayName, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.length);
        for(int i=0;i<array.length;i++) {
            editor.putString(arrayName + "_" + i, array[i]);
//            displayu(array[i]);
        }
        return String.valueOf(editor.commit());
    }
}

