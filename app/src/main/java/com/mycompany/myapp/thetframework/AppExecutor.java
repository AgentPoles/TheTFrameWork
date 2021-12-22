package com.mycompany.myapp.thetframework;

import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutor {
    private static final Object LOCK = new Object();
    private static AppExecutor sInstance;
    private final Executor diskIO;
    private final Executor mainThread;
    private final Executor networkIO;

    private AppExecutor(Executor diskIO, Executor networkIO, Executor mainThread ){
        this.mainThread = mainThread;
        this.networkIO = networkIO;
        this.diskIO = diskIO;
    }

    public static AppExecutor getsInstance() {
       if(sInstance == null){
           synchronized (LOCK){
               sInstance = new AppExecutor(Executors.newSingleThreadExecutor(),Executors.newFixedThreadPool(10),new MainThreadExecutor());
           }
       }

        return sInstance;
    }

    public Executor diskIO() {
        return diskIO;
    }

    public Executor mainThread() {
        return mainThread;
    }

    public Executor networkIO() {
        return networkIO;
    }
    public static class MainThreadExecutor implements Executor{
        android.os.Handler mainThreadHandler = new android.os.Handler(Looper.getMainLooper());
        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
