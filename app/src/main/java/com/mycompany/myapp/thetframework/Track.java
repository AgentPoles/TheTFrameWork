package com.mycompany.myapp.thetframework;

import android.net.Uri;

/**
 * Created by Paul on 2/23/2018.
 */
public class Track {
    private String id;
    private Uri uri;
    public Track(){

    }
    public Track(String id, Uri uri){
        this.id = id;
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
