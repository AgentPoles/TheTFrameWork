package com.mycompany.myapp.thetframework;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Paul on 2/12/2018.
 */
public class Load  extends AsyncTaskLoader<String []> {
    String arrayName;
    String[] array;
    Context mContext;
    public Load(Context context, String arroyName, String[] arroy){
        super(context);
        this.arrayName = arroyName;
        this.array = arroy;
        this.mContext = context;

    }

    @Override
    public String [] loadInBackground() {
        SharedPreferences prefs = mContext.getSharedPreferences(arrayName, 0);
        int size = prefs.getInt(arrayName + "_size", 0);
//            displayoe(String.valueOf(size));
        String array[] = new String[size];
        for(int i=0;i<size;i++) {
            array[i] = prefs.getString(arrayName + "_" + i, null);
//                displayu(array[i]);

        }
//            displayu(String.valueOf(size));
        return array;
    }
}


