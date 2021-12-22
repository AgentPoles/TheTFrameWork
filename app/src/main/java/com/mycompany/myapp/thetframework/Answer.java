package com.mycompany.myapp.thetframework;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * Created by Paul on 2/8/2018.
 */
@Entity(tableName = "answers")
public class Answer  {
    @PrimaryKey
    @NonNull
    private String coolid;
    private int id;
    private String name;
    private String date;
    private String time;
    private boolean failed;
    String answerid;
    private String failedmessage;
    private double timestamp;
    private String number;
    String questioncoolid;
    private String uristring;
    private String downloaduri;
    private String email;
    boolean pending;
    private String thumblineuri;
    private String answerbody;
    private boolean isanswer;
    private String mclassi;
    private String queid;
    private boolean hasimage;

    @Ignore
    public Answer(String name,String date, String time, String number, String email, String answerbody,boolean isanswer){
        this.answerbody = answerbody;
        this.date = date;
        this.time = time;
        this.number = number;
        this.email = email;
        this.isanswer = isanswer;
        this.answerbody = answerbody;
        this.name = name;

    }
    @Ignore
    public Answer (){

    }
    @Ignore
    public Answer(String queid, String mclassi, String name,String date, String time, String number, String email, String answerbody,boolean isanswer){
        this.answerbody = answerbody;
        this.date = date;
        this.time = time;
        this.number = number;
        this.email = email;
        this.isanswer = isanswer;
        this.answerbody = answerbody;
        this.name = name;
        this.mclassi = mclassi;
        this.queid = queid;
    }
@Ignore
    public Answer(boolean hasimage, String queid, String mclassi, String name,String date, String time, String number, String email, String answerbody,boolean isanswer){
        this.answerbody = answerbody;
        this.date = date;
        this.time = time;
        this.number = number;
        this.email = email;
        this.isanswer = isanswer;
        this.answerbody = answerbody;
        this.name = name;
        this.mclassi = mclassi;
        this.hasimage = hasimage;
        this.queid = queid;
    }
@Ignore
    public Answer(String thumblineuri,String downloaduri,boolean hasimage, String queid, String mclassi, String name,String date, String time, String number, String email, String answerbody,boolean isanswer){
        this.answerbody = answerbody;
        this.date = date;
        this.time = time;
        this.number = number;
        this.email = email;
        this.isanswer = isanswer;
        this.answerbody = answerbody;
        this.name = name;
        this.mclassi = mclassi;
        this.hasimage = hasimage;
        this.queid = queid;
        this.downloaduri = downloaduri;
        this.thumblineuri = thumblineuri;
    }

    public Answer(int id,double timestamp, String thumblineuri,String downloaduri,boolean hasimage, String queid, String mclassi, String name,String date, String time, String number, String email, String answerbody,boolean isanswer, boolean pending,String uristring, boolean failed, String failedmessage,String coolid , String questioncoolid, String answerid){
        this.answerbody = answerbody;
        this.date = date;
        this.time = time;
        this.number = number;
        this.email = email;
        this.timestamp =timestamp;
        this.isanswer = isanswer;
        this.id = id;
        this.answerid = answerid;
        this.questioncoolid =questioncoolid;
        this.coolid = coolid;
        this.pending = pending;
        this.failed = failed;
        this.uristring = uristring;
        this.failedmessage = failedmessage;
        this.answerbody = answerbody;
        this.name = name;
        this.mclassi = mclassi;
        this.hasimage = hasimage;
        this.queid = queid;
        this.downloaduri = downloaduri;
        this.thumblineuri = thumblineuri;
    }
    @Ignore
    public Answer(double timestamp, String thumblineuri,String downloaduri,boolean hasimage, String queid, String mclassi, String name,String date, String time, String number, String email, String answerbody,boolean isanswer, boolean pending, String uristring, boolean failed, String failedmessage, String coolid, String questioncoolid, String answerid){
        this.answerid = answerid;
        this.failedmessage = failedmessage;
        this.failed = failed;
        this.answerbody = answerbody;
        this.date = date;
        this.time = time;
        this.coolid = coolid;
        this.number = number;
        this.email = email;
        this.timestamp =timestamp;
        this.isanswer = isanswer;
        this.answerbody = answerbody;
        this.name = name;
        this.questioncoolid = questioncoolid;
        this.pending = pending;
        this.uristring = uristring;
        this.mclassi = mclassi;
        this.hasimage = hasimage;
        this.queid = queid;
        this.downloaduri = downloaduri;
        this.thumblineuri = thumblineuri;
    }

    public String getDownloaduri() {
        return downloaduri;
    }

    public void setDownloaduri(String downloaduri) {
        this.downloaduri = downloaduri;
    }

    public void setThumblineuri(String thumblineuri) {
        this.thumblineuri = thumblineuri;
    }

    public String getThumblineuri() {
        return thumblineuri;
    }

    public boolean isPending() {
        return pending;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public String getFailedmessage() {
        return failedmessage;
    }

    public void setFailedmessage(String failedmessage) {
        this.failedmessage = failedmessage;
    }
    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public void setQueid(String queid) {
        this.queid = queid;
    }

    public boolean isHasimage() {
        return hasimage;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setHasimage(boolean hasimage) {
        this.hasimage = hasimage;
    }

//    public boolean isAnanwer() {
//        return ananwer;
//    }
//
//    public void setAnanwer(boolean ananwer) {
//        this.ananwer = ananwer;
//    }

    public String getQueid() {
        return queid;
    }

    public String getMclassi() {
        return mclassi;
    }

    public void setIsanswer(boolean isanswer) {
        this.isanswer = isanswer;
    }

    public boolean isIsanswer() {
        return isanswer;
    }

    public void setMclassi(String mclassi) {
        this.mclassi = mclassi;
    }


    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnswerbody() {
        return answerbody;
    }

    public String getDate() {
        return date;

    }
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getTime() {
        return time;
    }

    public void setAnswerbody(String answerbody) {
        this.answerbody = answerbody;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getQuestioncoolid() {
        return questioncoolid;
    }

    public void setQuestioncoolid(String questioncoolid) {
        this.questioncoolid = questioncoolid;
    }

    public String getUristring() {
        return uristring;
    }
    public void setUristring(String uristring) {
        this.uristring = uristring;
    }

    @NonNull
    public String getCoolid() {
        return coolid;
    }

    public void setCoolid(@NonNull String coolid) {
        this.coolid = coolid;
    }

    public String getAnswerid() {
        return answerid;
    }

    public void setAnswerid(String answerid) {
        this.answerid = answerid;
    }
}

