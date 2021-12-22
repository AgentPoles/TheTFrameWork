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
public interface FolderDao {
    @Query("SELECT*FROM folders ORDER BY id")
    LiveData<List<Folders>> LoadAllFolders();
    @Insert
    void insertFolder(Folders folder);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateFolder(Folders folder);
    @Delete
    void deleteFolder(Folders folder);
    @Query("SELECT*FROM folders WHERE id = :id")
    LiveData<Folders> LoadFolderbyId (int id);
}
