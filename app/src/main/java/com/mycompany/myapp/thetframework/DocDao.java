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
public interface DocDao {
    @Query("SELECT*FROM documents ORDER BY id")
    LiveData<List<Documents>> LoadAllDocs();
    @Insert
    void insertDoc(Documents document);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateDoc(Documents document);
    @Delete
    void deleteDoc(Documents document);
    @Query("SELECT*FROM documents WHERE id = :id")
    LiveData<Documents> LoadDocbyId (int id);
}
