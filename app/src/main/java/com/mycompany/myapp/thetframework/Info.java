package com.mycompany.myapp.thetframework;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Paul on 5/23/2018.
 */
@Entity(tableName = "infos")
public class Info {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private boolean hasimage;
    private String writer;
    private String date;
    private boolean pending;
    private String time;
    private boolean isread;
    private String body;
    private boolean hasattachment;
    private boolean isimportant;
@Ignore
    public Info(){

    }

    @Ignore
    public Info(String writer, String body, String date, String time, boolean hasimage, boolean hasattachment, boolean isimportant, boolean isread, boolean pending){
        this.body = body;
        this.date = date;
        this.hasattachment = hasattachment;
        this.hasimage = hasimage;
        this.time = time;
        this.isread = isread;
        this.isimportant = isimportant;
        this.writer = writer;
        this.pending = pending;

    }
    public Info(int id, String writer, String body, String date, String time, boolean hasimage, boolean hasattachment, boolean isimportant, boolean isread, boolean pending){
        this.body = body;
        this.id = id;
        this.date = date;
        this.hasattachment = hasattachment;
        this.hasimage = hasimage;
        this.time = time;
        this.isread = isread;
        this.isimportant = isimportant;
        this.writer = writer;
        this.pending = pending;
    }

    public boolean isIsread() {
        return isread;
    }

    public void setIsread(boolean isread) {
        this.isread = isread;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getWriter() {
        return writer;
    }

    public boolean isHasimage() {
        return hasimage;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public boolean isHasattachment() {
        return hasattachment;
    }

    public boolean isimportant() {
        return isimportant;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHasattachment(boolean hasattachment) {
        this.hasattachment = hasattachment;
    }

    public void setHasimage(boolean hasimage) {
        this.hasimage = hasimage;
    }

    public void setIsimportant(boolean isimportant) {
        this.isimportant = isimportant;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isPending() {
        return pending;
    }

}
