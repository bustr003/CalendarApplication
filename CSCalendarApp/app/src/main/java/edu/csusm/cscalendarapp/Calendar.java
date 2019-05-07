package edu.csusm.cscalendarapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class Calendar<eventCode> extends AppCompatActivity {

    ArrayList<String> events;
    ArrayAdapter<String> adapter;

    String eventCode = getEventCode();

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    if(eventCode == null)
    {
        DatabaseReference myRef = db.getReference("events").child(eventCode);
    }
    private String getEventCode() {
        return EventPop.getCode();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addEvent = (Button) findViewById(R.id.add_event);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Calendar.this,EventPop.class));
                CreateEvent();

            }
        });

    }

    private void CreateEvent() {
        ListView eventList = (ListView) findViewById(R.id.event_list);
        String[] items = {"Walk Dog","Do Homework"};
        events = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, R.layout.activity_main,R.id.event_list,events);
        eventList.setAdapter(adapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                adapter.add(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}
