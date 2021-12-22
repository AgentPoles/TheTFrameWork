package com.mycompany.myapp.thetframework;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by Paul on 2/15/2018.
 */
public class Classopro {
    public static String namep;
    public static double number;
    private DataSnapshot df;
    public Classopro(){

    }
    public Classopro(DataSnapshot df){
        this.df = df;
    }
    public void atteund(){
        namep = df.child("name").getValue().toString();
        number = Double.parseDouble(df.child("value").getValue().toString());

    }

    public static double getNumber() {
        return number;
    }

    public static String getNamep() {
        return namep;
    }

    public void setDf(DataSnapshot df) {
        this.df = df;
    }

    public static void setNamep(String namep) {
        Classopro.namep = namep;
    }

    public static void setNumber(double number) {
        Classopro.number = number;
    }

    public DataSnapshot getDf() {
        return df;
    }

}
