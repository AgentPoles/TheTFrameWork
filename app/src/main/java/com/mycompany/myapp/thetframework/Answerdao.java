package com.mycompany.myapp.thetframework;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface Answerdao {
    @Query("SELECT*FROM answers ORDER BY id")
    LiveData<List<Answer>> LoadAllAnswer();
    @Query("SELECT*FROM answers ORDER BY id")
    List<Answer> LoadAllOrdinaryAnswer();
    @Insert
    void insertAnswer(Answer answer);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateAnswer(Answer answer);
    @Delete
    void deleteAnswer(Answer answer);
    @Query("SELECT*FROM answers WHERE id = :id")
    LiveData<Answer> LoadAnswerbyId (int id);
    @Query("SELECT*FROM answers WHERE coolid = :coolid")
    Answer LoadOrdinaryAnswerbycoolid (String coolid);
}


