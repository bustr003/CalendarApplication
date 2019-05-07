package com.example.basicactivity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "tasks")
public class Task {
    @PrimaryKey
    //private int _id;

    @NonNull
    @ColumnInfo(name = "task")
    private String mTask;

    public Task(String task) {this.mTask = task;}
    public String getTask(){return this.mTask;}

    /*
    @NonNull
    @ColumnInfo(name = "date")
    private String date;

    public int get_id(){return _id;}
    public void set_id(int the_id){ _id = the_id;}

    public String get_task(){return task;}
    public void set_task(String the_task){task = the_task;}

    public String get_date(){return date;}
    public void set_date(String the_date){date = the_date;}
    */
}

