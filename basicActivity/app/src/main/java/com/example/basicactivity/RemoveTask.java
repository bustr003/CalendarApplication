package com.example.basicactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RemoveTask extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditTaskView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_task);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_task);
        mEditTaskView = findViewById(R.id.edit_task);

        final Button button = findViewById(R.id.button_remove);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTaskView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String task = mEditTaskView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, task);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

        /*
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener()) {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTaskView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String task = mEditTaskView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, task);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        */

        /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

}//end of RemoveTaskActivity class
