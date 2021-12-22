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
public interface InfoDao {
    @Query("SELECT*FROM infos ORDER BY id")
    LiveData<List<Info>> LoadAllInfo();
    @Insert
    void insertInfo(Info info);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateInfo(Info info);
    @Delete
    void deleteInfo(Info info);
    @Query("SELECT*FROM infos WHERE id = :id")
    LiveData<Info> LoadInfobyId (int id);
}

