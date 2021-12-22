package com.mycompany.myapp.thetframework;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "classes")
public class Classors {
    @PrimaryKey
    @NonNull
    private String classname;
    private boolean blocked;
    private String useremail;
    private boolean unread;
    private long timestamp;
    private boolean recent;
    @Ignore
    public Classors() {

    }

    public Classors(String classname, String useremail, boolean unread, boolean blocked, long timestamp, boolean recent){
    this.classname = classname;
    this.unread = unread;
    this.useremail = useremail;
    this.blocked = blocked;
    this.timestamp = timestamp;
    this.recent = recent;

    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @NonNull
    public String getClassname() {
        return classname;
    }

    public void setClassname(@NonNull String classname) {
        this.classname = classname;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public boolean isUnread() {
        return unread;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isRecent() {
        return recent;
    }

    public void setRecent(boolean recent) {
        this.recent = recent;
    }
}
