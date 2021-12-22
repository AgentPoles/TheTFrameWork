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
public interface UserDao {
    @Query("SELECT*FROM users ORDER BY id")
    LiveData<List<User>> LoadAllUsers();
 @Insert
void insertUser(User user);
 @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User user);
 @Delete
    void deleteUser(User user);
    @Query("SELECT*FROM users WHERE id = :id")
    LiveData<User> LoadUserbyId (int id);
}
