package com.mycompany.myapp.thetframework;

/**
 * Created by Paul on 2/15/2018.
 */
public class Classor {
    private String name;
    private double value;
    public Classor(){

    }
    public Classor(String name, double value){
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
