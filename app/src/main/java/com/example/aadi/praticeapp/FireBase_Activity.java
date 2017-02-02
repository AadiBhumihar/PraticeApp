package com.example.aadi.praticeapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FireBase_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText email_inp ,password_inp ;
    Button register;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    public  final static String firebase_url = "https://dataproject-8c146.firebaseio.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base_);
        Firebase.setAndroidContext(this);
        //auth = FirebaseAuth.getInstance();

        progressBar = (ProgressBar)findViewById(R.id.id_progressBar);
        email_inp = (EditText)findViewById(R.id.et_email);
        password_inp = (EditText)findViewById(R.id.et_password);
        register = (Button)findViewById(R.id.btn_register);

        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Firebase ref = new Firebase(firebase_url);

        String email = email_inp.getText().toString().trim();
        int password = Integer.valueOf(password_inp.getText().toString().trim());

        dataclass peopledata = new dataclass(email ,password);

        ref.child("Person").setValue(peopledata);
    }

}
