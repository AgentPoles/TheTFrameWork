package com.mycompany.myapp.thetframework;

public class DocHandler {
    private static String foldername;

    public static void setFoldername(String foldername) {
        DocHandler.foldername = foldername;
    }

    public static String getFoldername() {
        return foldername;
    }
    private static DocHandler ourInstance = new DocHandler();
    public static DocHandler getInstance() {
        return ourInstance;
    }

    public static void setOurInstance(DocHandler ourInstance) {
        DocHandler.ourInstance = ourInstance;
    }
}
