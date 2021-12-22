package com.mycompany.myapp.thetframework;

public class workingCalculation {
    private String  value;
    private String number;
    public workingCalculation(){

    }
    public workingCalculation(String value, String number){


    this.value = value;
    this.number = number;}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
