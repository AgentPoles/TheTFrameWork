package com.mycompany.myapp.thetframework;

/**
 * Created by Paul on 5/24/2018.
 */
public class Chatmessage {
    private String usermessage;
    private String useremail;
    private String username;
    private String messagetime;
    public Chatmessage(){

    }
    public Chatmessage( String useremail, String usermessage, String username){
        this.useremail = useremail;
        this.username = username;
        this.usermessage = usermessage;
    }

    public String getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(String messagetime) {
        this.messagetime = messagetime;
    }

    public String getUseremail() {
        return useremail;
    }

    public String getUsermessage() {
        return usermessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
