package com.mycompany.myapp.thetframework;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Paul on 5/31/2018.
 */
@Entity(tableName = "documents")
public class Documents {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String foldername;
    private String docname;
    private String docpath;
    private boolean pending;
    private boolean read;
    private int docimage;
    private boolean general;
@Ignore
  public   Documents(){
        }
    @Ignore
    public Documents( String docname, String docpath, boolean general, String foldername, boolean read, boolean pending){
        this.docname =docname;
        this.docpath = docpath;
        this.general = general;
        this.read = read;
        this.pending = pending;
        this.foldername = foldername;
    }
    public Documents(int id, String docname, String docpath, boolean general, String foldername, boolean read, boolean pending){
    this.id = id;
        this.docname =docname;
        this.docpath = docpath;
        this.read = read;
        this.pending = pending;
        this.general = general;
        this.foldername = foldername;
    }
    public int getDocimage() {
        return docimage;
    }

    public String getDocname() {
        return docname;
    }

    public String getDocpath() {
        return docpath;
    }

    public boolean isGeneral() {
        return general;
    }

    public void setDocimage(int docimage) {
        this.docimage = docimage;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public void setDocpath(String docpath) {
        this.docpath = docpath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isPending() {
        return pending;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public void setFoldername(String foldername) {
        this.foldername = foldername;
    }

    public String getFoldername() {
        return foldername;
    }

    public void setGeneral(boolean general) {
        this.general = general;
    }
}
