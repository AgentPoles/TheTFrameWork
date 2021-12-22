package com.mycompany.myapp.thetframework;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
@Entity(tableName = "folders")
public class Folders {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String foldername;
    private String folderpath;
    private boolean read;
    private boolean pending;
    @Ignore
    public Folders(){}
 @Ignore
    public Folders(String foldername, String folderpath,boolean read, boolean pending){
        this.foldername = foldername;
        this.read = read;
        this.pending = pending;
        this.folderpath = folderpath;
    }
    public Folders(int id, String foldername, String folderpath,boolean read,boolean pending){

        this.id = id;
        this.foldername = foldername;
        this.pending = pending;
        this.read = read;
        this.folderpath = folderpath;
    }

    public boolean isPending() {
        return pending;
    }

    public boolean isRead() {
        return read;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoldername() {
        return foldername;
    }

    public void setFoldername(String foldername) {
        this.foldername = foldername;
    }

    public String getFolderpath() {
        return folderpath;
    }

    public void setFolderpath(String folderpath) {
        this.folderpath = folderpath;
    }
}
