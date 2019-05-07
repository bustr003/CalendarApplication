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

public class RegisterUser extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    String firstName;
    String lastName;
    String email;
    String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();
        final DatabaseReference myDatabase;
        myDatabase = FirebaseDatabase.getInstance().getReference();

        setContentView(R.layout.register_user);

        Button registerUser = (Button) findViewById(R.id.reg);
        TextView cancel = (TextView) findViewById(R.id.cancel_user);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText fNameEdit = (EditText) findViewById(R.id.fName);
                firstName =  fNameEdit.getText().toString();

                EditText lNameEdit = (EditText) findViewById(R.id.lName);
                lastName =  lNameEdit.getText().toString();

                //For email
                EditText eEdit = (EditText) findViewById(R.id.email);
                email =  eEdit.getText().toString();

                EditText passEdit = (EditText) findViewById(R.id.pass);
                password =  passEdit.getText().toString();

                if(firstName.matches("") || lastName.matches("") || email.matches("") || password.matches("")){
                    Toast.makeText(getApplicationContext(), "Please Enter All Information", Toast.LENGTH_LONG).show();
                }
                else {


                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            User user = new User(email,password,firstName,lastName);
                            myDatabase.child("users").child(user.userCode).setValue(user);
                            Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_LONG).show();
                        }
                    });


                    backToLogin();

                }

            }
        });

    }

    public void backToLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
