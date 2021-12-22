package com.mycompany.myapp.thetframework;

/**
 * Created by Paul on 5/18/2018.
 */
public class Individual {
    private String name;
    private String phonenumber;
    private String email;
    private int image;
    private boolean admin;

    Individual(){

    }
    Individual(String name, String phonenumber, String email, int image, boolean admin){
        this.name = name;
        this.admin = admin;
        this.email = email;
        this.phonenumber = phonenumber;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getImage() {
        return image;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
}

