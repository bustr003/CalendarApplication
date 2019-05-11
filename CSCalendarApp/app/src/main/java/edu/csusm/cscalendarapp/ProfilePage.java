package edu.csusm.cscalendarapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfilePage{

    private FirebaseAuth firebaseAuth;
    String firstName;
    String lastName;
    String email;
    String password;
    String userID;

    ProfilePage(String theUserId)
    {
        userID = theUserId;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();
        final DatabaseReference myDatabase;
        myDatabase = FirebaseDatabase.getInstance().getReference();

        setContentView(R.layout.profile_page);

        MyDatabase.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        }
    }
}
