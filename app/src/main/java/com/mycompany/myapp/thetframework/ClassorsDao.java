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
public interface ClassorsDao {
    @Query("SELECT*FROM classes")
    LiveData<List<Classors>> LoadAllClasses();
    @Insert
    void insertClassor(Classors classors);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateClassor(Classors classors);
    @Delete
    void deleteClassor(Classors classors);
    @Query("SELECT*FROM classes WHERE classname = :classname")
    Classors loadClassor(String classname);
    @Query("DELETE FROM classes")
    void  deleteAll();
    @Query("DELETE FROM classes WHERE classname = :classname")
    void deleteClassorByClassname(String classname);
    @Query("SELECT*FROM classes WHERE classname = :classname")
    LiveData<Classors> LoadClassorById (String classname);
    @Query("SELECT*FROM classes WHERE classname = :classname")
    Classors LoadOrdinaryBycoolId (String classname);
    @Query("SELECT*FROM classes")
    List<Classors> LoadAllOrdunaryClassors();
}

