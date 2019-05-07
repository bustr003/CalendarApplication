package com.example.basicactivity;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class TaskRepository {
    //member variables for the DAO and the list of tasks
    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTasks;

    //constructor that gets a handle to the db
    // and initializes the member variables
    TaskRepository(Application application){
        TaskRoomDatabase db = TaskRoomDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.getAllTasks();
    }

    //a wrapper for getAllTasks()
    //Room executes all queries on a separate thread.
    //observed LiveData will notify the observer when data has changed.
    LiveData<List<Task>> getAllTasks(){
        return mAllTasks;
    }

    //a wrapper for the insert() method
    //must be called on a non-UI thread. otherwise, app will crash.
    //Room ensures that you don't do any long-running operations on the main thread,
    //blocking the UI
    public void insert (Task task){
        new insertAsyncTask(mTaskDao).execute(task);
    }

    private static class insertAsyncTask extends AsyncTask<Task, Void, Void> {
        private TaskDao mAsyncTaskDao;

        insertAsyncTask(TaskDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Task... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
