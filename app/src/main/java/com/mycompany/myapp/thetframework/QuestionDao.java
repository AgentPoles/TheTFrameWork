package com.mycompany.myapp.thetframework;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface QuestionDao {
    @Query("SELECT*FROM questions")
   LiveData<List<question>> LoadAllQuestions();
    @Insert
    void insertQuestion(question questione);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateQuestion(question questione);
    @Delete
    void deleteQuestion(question questione);
    @Query("SELECT*FROM questions WHERE queid = :queid")
    question loadQuestion(String queid);
    @Query("DELETE FROM questions")
    void  deleteAll();
 @Query("SELECT*FROM questions WHERE id = :id")
 LiveData<question> LoadQuestionById (int id);
 @Query("SELECT*FROM questions WHERE coolid = :coolid")
 question LoadOrdinaryBycoolId (String coolid);
    @Query("SELECT*FROM questions")
    List<question> LoadAllOrdunaryQuestions();
}
