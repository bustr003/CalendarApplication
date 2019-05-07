package com.example.basicactivity;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    //a private member variable to hold a reference to the repos
    private TaskRepository mRepository;

    //a private LiveData member variable to cache the list of tasks
    private LiveData<List<Task>> mAllTasks;

    //a constructor. gets a reference to the repos
    //and gets the list of tasks from the repos
    public TaskViewModel (Application application){
        super(application);
        mRepository = new TaskRepository(application);
        mAllTasks = mRepository.getAllTasks();
    }

    //a getter method for all tasks
    //this completely hides the implementation from the UI
    LiveData<List<Task>> getAllTasks() {return mAllTasks;}

    //a wrapper insert() method
    //calls the Repository's insert() method
    //the implementation of insert() is completely hidden from the UI
    public void insert(Task task) {mRepository.insert(task);}
}
