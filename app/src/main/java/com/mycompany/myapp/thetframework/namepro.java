package com.mycompany.myapp.thetframework;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by Paul on 2/13/2018.
 */
public class namepro  {
    static String nusername, nemail, npassword, nmobile, nclassy, dateOfBirth,userid,skill,downloaduri, thumblineuri;
    static int nanswer, nquestion, nbusiness;
    static boolean hasimage;
    static long ntimemonitor;
    public namepro(){

    }
    public namepro(DataSnapshot dfr){
        attend(dfr);
    }
    public void attend (DataSnapshot dfe){
        try {
            ntimemonitor = Long.parseLong(dfe.child("timemonitor").getValue().toString());
            dateOfBirth = dfe.child("dateOfBirth").getValue().toString();
        }
        catch (Exception e){

        }
        nusername = dfe.child("username").getValue().toString();
        nemail = dfe.child("email").getValue().toString();
        nmobile = dfe.child("mobile").getValue().toString();
        nclassy = dfe.child("classe").getValue().toString();
        npassword = dfe.child("password").getValue().toString();
        dateOfBirth = dfe.child("dateOfBirth").getValue().toString();
        skill = dfe.child("skill").getValue().toString();
        downloaduri = dfe.child("downloaduri").getValue().toString();
        thumblineuri = dfe.child("thumblineuri").getValue().toString();
        userid = dfe.child("userid").getValue().toString();
        hasimage = Boolean.parseBoolean(dfe.child("hasimage").getValue().toString());
        nanswer = Integer.parseInt(dfe.child("answer").getValue().toString());
        nquestion = Integer.parseInt(dfe.child("question").getValue().toString());
        nbusiness = Integer.parseInt(dfe.child("business").getValue().toString());

    }

    public static String getDateOfBirth() {
        return dateOfBirth;
    }

    public static void setDateOfBirth(String dateOfBirth) {
        namepro.dateOfBirth = dateOfBirth;
    }
    public static int getNanswer() {
        return nanswer;
    }

    public static int getNbusiness() {
        return nbusiness;
    }

    public static int getNquestion() {
        return nquestion;
    }

    public static String getNclassy() {
        return nclassy;
    }

    public static String getNemail() {
        return nemail;
    }

    public static String getNmobile() {
        return nmobile;
    }

    public static String getNpassword() {
        return npassword;
    }

    public static String getNusername() {
        return nusername;
    }

    public static void setNanswer(int nanswer) {
        namepro.nanswer = nanswer;
    }

    public static void setNbusiness(int nbusiness) {
        namepro.nbusiness = nbusiness;
    }

    public static void setNclassy(String nclassy) {
        namepro.nclassy = nclassy;
    }

    public static void setNemail(String nemail) {
        namepro.nemail = nemail;
    }



    public static void setNmobile(String nmobile) {
        namepro.nmobile = nmobile;
    }

    public static void setNpassword(String npassword) {
        namepro.npassword = npassword;
    }

    public static void setNquestion(int nquestion) {
        namepro.nquestion = nquestion;
    }

    public static void setNusername(String nusername) {
        namepro.nusername = nusername;
    }

    public static void setNtimemonitor(long ntimemonitor) {
        namepro.ntimemonitor = ntimemonitor;
    }

    public static long getNtimemonitor() {
        return ntimemonitor;
    }

    public static void setUserid(String userid) {
        namepro.userid = userid;
    }

    public static void setSkill(String skill) {
        namepro.skill = skill;
    }

    public static String getUserid() {
        return userid;
    }

    public static String getSkill() {
        return skill;
    }

    public static boolean isHasimage() {
        return hasimage;
    }

    public void setHasimage(boolean hasimage) {
        this.hasimage = hasimage;
    }

    public static String getThumblineuri() {
        return thumblineuri;
    }

    public static void setDownloaduri(String downloaduri) {
        namepro.downloaduri = downloaduri;
    }

    public static String getDownloaduri() {
        return downloaduri;
    }
}
