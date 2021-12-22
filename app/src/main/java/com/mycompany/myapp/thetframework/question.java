package com.mycompany.myapp.thetframework;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * Created by Paul on 2/7/2018.
 */
@Entity(tableName = "questions")
public class question {
    @PrimaryKey
    @NonNull
    private String coolid;
    private int id;
    private String queid;
    private String  coursetitle;
    private String  date;
    private boolean anspending;
    private String who;
    private boolean failed;
    private String failedmessage;
    private String uristring;
    private double timestamp;
    private String  time;
    private String body;
    private String thumblineuri;
    private String downloadurid;
    private boolean read;
    private boolean pending;
    private boolean answered;
    private  String ynumber;
    private String yemail;
    private String mclass;
    private int nocomment;
    private int noanswer;
    private boolean hasImage;
    private boolean yettoupdate;

    private Double totalnoquestion;
    @Ignore
    public question() {

    }
    @Ignore
    public question(String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered){
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
        this.read = read;
        this.who = who;
        this.mclass = mclass;
        this.body = body;
        this.time = time;
   }
   @Ignore
    public question(int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail){
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
        this.read = read;
        this.who = who;
        this.mclass = mclass;
        this.body = body;
        this.time = time;
        this.noanswer = noanswer;
        this.nocomment = nocomment;
        this.yemail = yemail;
        this.ynumber = ynumber;

    }
    @Ignore
    public question(String queid, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail){
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
        this.read = read;
        this.who = who;
        this.mclass = mclass;
        this.body = body;
        this.time = time;
        this.noanswer = noanswer;
        this.nocomment = nocomment;
        this.yemail = yemail;
        this.ynumber = ynumber;
        this.queid = ynumber;

    }
    @Ignore
    public question(Boolean hasImage, String queid, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail){
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
        this.read = read;
        this.who = who;
        this.mclass = mclass;
        this.body = body;
        this.time = time;
        this.noanswer = noanswer;
        this.nocomment = nocomment;
        this.yemail = yemail;
        this.ynumber = ynumber;
        this.queid = queid;
        this.hasImage = hasImage;
    }@Ignore
    public question(Boolean hasImage, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail){
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
        this.read = read;
        this.who = who;
        this.mclass = mclass;
        this.body = body;
        this.time = time;
        this.noanswer = noanswer;
        this.nocomment = nocomment;
        this.yemail = yemail;
        this.ynumber = ynumber;
        this.hasImage = hasImage;
   }
    @Ignore
    public question(Double totalnoquestion, Boolean hasImage, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail){
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
        this.read = read;
        this.who = who;
        this.mclass = mclass;
        this.body = body;
        this.time = time;
        this.noanswer = noanswer;
        this.nocomment = nocomment;
        this.yemail = yemail;
        this.ynumber = ynumber;
        this.hasImage = hasImage;
        this.totalnoquestion = totalnoquestion;
    }
    @Ignore
    public question(String downloadurid,String thumblineuri, Double totalnoquestion, Boolean hasImage, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail){
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
        this.read = read;
        this.who = who;
        this.mclass = mclass;
        this.body = body;
        this.thumblineuri = thumblineuri;
        this.time = time;
        this.noanswer = noanswer;
        this.downloadurid = downloadurid;
        this.nocomment = nocomment;
        this.yemail = yemail;
        this.ynumber = ynumber;
        this.hasImage = hasImage;
        this.totalnoquestion = totalnoquestion;
    }
@Ignore
public question(double timestamp, String downloadurid,String thumblineuri, Double totalnoquestion, Boolean hasImage, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail){
    this.answered = answered;
    this.coursetitle = coursetitle;
    this.date = date;
    this.who = who;
    this.mclass = mclass;
    this.body = body;
    this.thumblineuri = thumblineuri;
    this.time = time;
    this.noanswer = noanswer;
    this.downloadurid = downloadurid;
    this.nocomment = nocomment;
    this.yemail = yemail;
    this.ynumber = ynumber;
    this.hasImage = hasImage;
    this.timestamp = timestamp;
    this.totalnoquestion = totalnoquestion;
}

@Ignore
    public question(double timestamp, String downloadurid,String thumblineuri, Double totalnoquestion, Boolean hasImage, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail, boolean yettoupdate, boolean pending, String uristring, boolean failed, String failedmessage, String coolid, String queid, boolean anspending) {
        this.pending = pending;
        this.yettoupdate = yettoupdate;
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
        this.coolid = coolid;
        this.who = who;
        this.read = read;
        this.anspending = anspending;
        this.mclass = mclass;
        this.body = body;
        this.thumblineuri = thumblineuri;
        this.time = time;
        this.queid = queid;
        this.noanswer = noanswer;
        this.downloadurid = downloadurid;
        this.nocomment = nocomment;
        this.yemail = yemail;
        this.uristring = uristring;
        this.ynumber = ynumber;
        this.hasImage = hasImage;
        this.timestamp = timestamp;
        this.totalnoquestion = totalnoquestion;
    }

    public question(int id, double timestamp, String downloadurid,String thumblineuri, Double totalnoquestion, boolean hasImage, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail, boolean yettoupdate, boolean pending, String uristring, boolean failed, String failedmessage, String coolid, String queid, boolean anspending) {
        this.pending = pending;
        this.yettoupdate = yettoupdate;
        this.uristring = uristring;
        this.queid = queid;
        this.failed = failed;
        this.coolid = coolid;
        this.failedmessage = failedmessage;
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
        this.anspending = anspending;
        this.who = who;
        this.id = id;
        this.read = read;
        this.mclass = mclass;
        this.body = body;
        this.thumblineuri = thumblineuri;
        this.time = time;
        this.noanswer = noanswer;
        this.downloadurid = downloadurid;
        this.nocomment = nocomment;
        this.yemail = yemail;
        this.ynumber = ynumber;
        this.hasImage = hasImage;
        this.timestamp = timestamp;
        this.totalnoquestion = totalnoquestion;
    }
    @Ignore
    public question(int id, double timestamp, String downloadurid,String thumblineuri, Double totalnoquestion, boolean hasImage, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail, boolean yettoupdate, boolean pending, String uristring, boolean failed, String failedmessage) {
        this.pending = pending;
        this.yettoupdate = yettoupdate;
        this.uristring = uristring;
        this.failed = failed;
        this.coolid = coolid;
        this.failedmessage = failedmessage;
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
        this.who = who;
        this.id = id;
        this.read = read;
        this.mclass = mclass;
        this.body = body;
        this.thumblineuri = thumblineuri;
        this.time = time;
        this.noanswer = noanswer;
        this.downloadurid = downloadurid;
        this.nocomment = nocomment;
        this.yemail = yemail;
        this.ynumber = ynumber;
        this.hasImage = hasImage;
        this.timestamp = timestamp;
        this.totalnoquestion = totalnoquestion;
    }
//    public question( double timestamp, String downloadurid,String thumblineuri, Double totalnoquestion, Boolean hasImage, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean read, boolean answered, String ynumber, String yemail, boolean yettoupdate){
//        this.yettoupdate = yettoupdate;
//        this.answered = answered;
//        this.coursetitle = coursetitle;
//        this.date = date;
//        this.read = read;
//        this.who = who;
//        this.mclass = mclass;
//        this.body = body;
//        this.thumblineuri = thumblineuri;
//        this.time = time;
//        this.noanswer = noanswer;
//        this.downloadurid = downloadurid;
//        this.nocomment = nocomment;
//        this.yemail = yemail;
//        this.ynumber = ynumber;
//        this.hasImage = hasImage;
//        this.timestamp = timestamp;
//        this.totalnoquestion = totalnoquestion;
//        this.id = id;
//    }
@Ignore
    public question( String downloaduri, Double totalnoquestion, Boolean hasImage, int nocomment, int noanswer, String mclass, String body, String coursetitle, String date,String who, String time, boolean answered, String ynumber, String yemail){
        this.answered = answered;
        this.coursetitle = coursetitle;
        this.date = date;
     this.read = read;
        this.who = who;
        this.mclass = mclass;
        this.body = body;
        this.time = time;
        this.noanswer = noanswer;
        this.downloadurid = downloaduri;
        this.nocomment = nocomment;
        this.yemail = yemail;
        this.ynumber = ynumber;
        this.hasImage = hasImage;
        this.totalnoquestion = totalnoquestion;
    }
    public boolean isHasImage() {
        return hasImage;
    }

//    public void setDownloaduri(Uri downloaduri) {
//        this.downloaduri = downloaduri;
//    }
//
//    public Uri getDownloaduri() {
//        return downloaduri;
//    }


    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public String getDownloadurid() {
        return downloadurid;
    }

    public void setDownloadurid(String downloadurid) {
        this.downloadurid = downloadurid;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQueid() {
        return queid;
    }

    public void setQueid(String queid) {
        this.queid = queid;
    }
    public String getYemail() {
        return yemail;
    }

    public String getYnumber() {
        return ynumber;
    }

    public void setYemail(String yemail) {
        this.yemail = yemail;
    }

    public void setYnumber(String ynumber) {
        this.ynumber = ynumber;
    }

    public int getNoanswer() {
        return noanswer;
    }

    public String getThumblineuri() {
        return thumblineuri;
    }

    public void setThumblineuri(String thumblineuri) {
        this.thumblineuri = thumblineuri;
    }

    public Double getTotalnoquestion() {
        return totalnoquestion;
    }

    public void setTotalnoquestion(Double totalnoquestion) {
        this.totalnoquestion = totalnoquestion;
    }

    public void setNoanswer(int noanswer) {
        this.noanswer = noanswer;
    }

    public void setNocomment(int nocomment) {
        this.nocomment = nocomment;
    }

    public int getNocomment() {
        return nocomment;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
    public String getMclass() {
        return mclass;
    }

    public void setMclass(String mclass) {
        this.mclass = mclass;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isRead() {
        return read;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public String getDate() {
        return date;
    }


    public String getTime() {
        return time;
    }

    public String getWho() {
        return who;
    }

    public void setYettoupdate(boolean yettoupdate) {
        this.yettoupdate = yettoupdate;
    }

    public boolean isYettoupdate() {
        return yettoupdate;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public String getFailedmessage() {
        return failedmessage;
    }

    public String getUristring() {
        return uristring;
    }

    public void setFailedmessage(String failedmessage) {
        this.failedmessage = failedmessage;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public void setUristring(String uristring) {
        uristring = uristring;
    }

    public boolean isFailed() {
        return failed;
    }

    public String getCoolid() {
        return coolid;
    }

    public boolean isAnspending() {
        return anspending;
    }

    public void setAnspending(boolean anspending) {
        this.anspending = anspending;
    }

    public void setCoolid(String coolid) {
        this.coolid = coolid;
    }
}
