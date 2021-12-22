package com.mycompany.myapp.thetframework;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;
@Database(entities = {User.class, question.class, Info.class, Documents.class, Folders.class, Answer.class, Classors.class}, version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private  static final  String LOG_TAG = AppDatabase.class.getSimpleName();
    private  static final Object LOCK = new Object();
    private  static final String DATABASE_NAMEA = "Alllist";
    private  static final String DATABASE_NAMEB = "questionlist";
    private static AppDatabase sInstance, qInstance;

    public static AppDatabase getsInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(TAG, "creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAMEA)
                        .build();
//                Toast.makeText(context,"created base",Toast.LENGTH_LONG).show();

            }
//            if(qInstance==null){
//                synchronized (LOCK){
//                    Log.d(TAG, "creating new database instance");
//                    qInstance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,AppDatabase.DATABASE_NAMEB)
//                            .allowMainThreadQueries()
//                            .build();
//
//
//                }

//        }
        }
            return sInstance;

    }
 public abstract UserDao userDao();
    public abstract QuestionDao  questionDao();
    public abstract InfoDao infoDao();
    public abstract FolderDao folderDao();
    public abstract DocDao docDao();
    public abstract Answerdao answerdao();
    public abstract ClassorsDao classorsDao();
}
