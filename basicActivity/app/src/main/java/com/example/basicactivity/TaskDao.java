package com.example.basicactivity;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insert(Task task);

    @Query("DELETE FROM tasks")
    void deleteAll();

    //@Query("DELETE FROM tasks WHERE ")

    @Query("SELECT * FROM tasks ORDER BY task ASC")
    LiveData<List<Task>> getAllTasks();

    /*
    @Query("SELECT * FROM tasks WHERE _id LIKE :id")
    Task getTask(int id);
    */
}

