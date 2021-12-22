package com.mycompany.myapp.thetframework;

import java.util.List;

public class Processors {
     private static Processors ourInstance = new Processors();
      public static  int APP_DATABASE_VERSION ;
    List<Info> infod;
    List<Folders> folders;

  public static Processors getInstance() {
        return ourInstance;
    }

    private Processors() {

    }

    public static int getAppDatabaseVersion() {
        return APP_DATABASE_VERSION;
    }

    public static void setAppDatabaseVersion(int appDatabaseVersion) {
        APP_DATABASE_VERSION = appDatabaseVersion;
    }

    public  List<Info> getInfod() {
        return infod;
    }

    public void setInfod(List<Info> infod) {
       this.infod = infod;
    }

    public List<Folders> getFolders() {
        return folders;
    }

    public void setFolders(List<Folders> folders) {
        this.folders = folders;
    }
}
