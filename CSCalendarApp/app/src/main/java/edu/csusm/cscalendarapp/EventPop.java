package edu.csusm.cscalendarapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import edu.csusm.cscalendarapp.EventObject;

import com.google.android.gms.common.util.Strings;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class EventPop extends Activity {

    String startDate = "";
    String dueDate = "";

    public static String eventId;

    //Will let users pick the Start and due dates
    //start listener

    private TextView sDisplayDate;
    private DatePickerDialog.OnDateSetListener sDateSetListener;

    //Due listeners
    private TextView dDisplayDate;
    private DatePickerDialog.OnDateSetListener dDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_popup);

        final DatabaseReference myDatabase;
        myDatabase = FirebaseDatabase.getInstance().getReference();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        sDisplayDate = (TextView) findViewById(R.id.start_date);

        sDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(EventPop.this,android.R.style.Theme_Holo_Light_Dialog, sDateSetListener, year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        dDisplayDate = (TextView) findViewById(R.id.due_date);

        dDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(EventPop.this, android.R.style.Theme_Holo_Light_Dialog, dDateSetListener, year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        sDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {

                String date = month + "/" + day + "/" + year;
                sDisplayDate.setText(date);

                startDate = date;
            }
        };

        dDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {

                String date = month + "/" + day + "/" + year;
                dDisplayDate.setText(date);

                dueDate = date;
            }
        };



        Button sub = (Button)findViewById(R.id.submit_event);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eName;
                String description;

                EditText eNameEdit = (EditText) findViewById(R.id.event_name);
                eName =  eNameEdit.getText().toString();

                EditText dNameEdit = (EditText) findViewById(R.id.event_des);
                description = dNameEdit.getText().toString();

                if (eName.matches("") || startDate.matches("") || dueDate.matches("")){
                    Toast.makeText(getApplicationContext(), "Please Enter All Information", Toast.LENGTH_LONG).show();
                }else{

                    if(description.matches("")){
                        description = "No Description";
                    }

                    EventObject event = new EventObject(eName,startDate,dueDate,description);

                    String eventCode = event.getEventID();

                    myDatabase.child("events").child(event.eventID).setValue(event);

                    Toast.makeText(getApplicationContext(), "Event Added", Toast.LENGTH_LONG).show();

                    eventId = eventCode;


                    finish();
                }


            }


        });

    }

    public static String getCode(){
        return eventId;
    }
}
