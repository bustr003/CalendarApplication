package com.example.basicactivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //a member variable for the ViewModel
    private TaskViewModel mTaskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this,
                        NewTaskActivity.class);
                startActivityForResult(intent,NEW_TASK_ACTIVITY_REQUEST_CODE);
            }
        });

        FloatingActionButton trash = findViewById(R.id.trash);
        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this,
                        RemoveTask.class);
                startActivityForResult(intent,NEW_TASK_ACTIVITY_REQUEST_CODE);
            }
        });

        //add the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final TaskListAdapter adapter = new TaskListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //get a ViewModel from the ViewModelProvider
        mTaskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);

        //an observer for the LiveData returned by getAllWords()
        //the onChanged method fires when the observed data changes
        //and the activity is in the foreround
        mTaskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable final List<Task> tasks) {
                //update the cached copy of the tasks in the adapter
                adapter.setTasks(tasks);
            }
        });//end of onChanged method
    }//end of onCreate method

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //onActivityResult() code for the NewTaskActivity
    //of the activity returns with RESULT_OK, insert the returned
    //word into the db by calling the insert() method of the TaskViewModel
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE
        && resultCode == RESULT_OK){
            Task task = new Task(data.getStringExtra(NewTaskActivity.EXTRA_REPLY));
            mTaskViewModel.insert(task);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }//end of else
    }//end of OnActivityResult method

    //define the missing request code
    public static final int NEW_TASK_ACTIVITY_REQUEST_CODE = 1;

    //start NewTaskActivity when the user taps the FAB
    //(Floating Action Button)
    //see the FAB's onClick() click handler.
}//end of MainActivity class
