package com.example.basicactivity;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

//import android.arch.persistence.room.processor.Context;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class TaskRoomDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();

    private static volatile TaskRoomDatabase INSTANCE;

    static TaskRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TaskRoomDatabase.class) {
                if(INSTANCE == null) {

                    //COMMENTED OUT BECAUSE WE DO NOT WANT ALL CONTENT TO BE DELETED UPON OPENING THE APP
                    //add the callback to the database build sequence
                    //right before calling .build()
                    //.addCallback(sRoomDatabaseCallback)

                    //build the database
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TaskRoomDatabase.class, "tasks_db").build();
                }
            }
        }
        return INSTANCE;
    }

    //COMMENTED OUT BECAUSE WE DO NOT WANT ALL CONTENT TO BE DELETED UPON OPENING THE APP
    //12. populate the database
    //callback and override onOpen() to delete all content
    //and repopulate the database whenever the app is started
    /*private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
            @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }//end of onOpen override
            };*///end of RoomDatabase.Callback class

    //AsyncTask that deletes the contents of the database
    //then populates it with the two words "Hello" and "World"
    /*private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final TaskDao mDao;

        PopulateDbAsync(TaskRoomDatabase db){
            mDao = db.taskDao();
        }//end of PopulateDbAsync method

        @Override
        protected Void doInBackground(final Void... params){
            mDao.deleteAll();
            Task task = new Task("Hello");
            mDao.insert(task);

            task = new Task("World");
            mDao.insert(task);

            return null;
        }//end of doInBackground method
    }*///end of PopulateDbAsync class
}//end of TaskRoomDatabase class

