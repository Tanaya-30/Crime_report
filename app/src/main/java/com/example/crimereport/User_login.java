package com.example.crimereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class User_login extends AppCompatActivity {
    EditText uid, pwd;
    database mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        mydatabase = new database(this);
        uid = (EditText) findViewById(R.id.uid);
        pwd = (EditText) findViewById(R.id.pass);
    }

    public void Userlogin(View v) {
        String Username = uid.getText().toString();
        String password = pwd.getText().toString();

        if (!isUnameValid(Username)) {
            Toast.makeText(this, "Username Invalid", Toast.LENGTH_LONG).show();
        }
        if (!isPasswordValid(password)) {
            Toast.makeText(this, "Password Invalid", Toast.LENGTH_LONG).show();
        }
        Cursor res = mydatabase.User_login(Username,password);
        if (res.getCount() == 1) {
            final Intent i1 = new Intent(this, User_Dashboard.class);
            startActivity(i1);
        } else {
            Toast.makeText(this, "Invalid Account", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isUnameValid(String username) {
        return username.contains("0");
    }
    private boolean isPasswordValid(String password){
        return password.contains("0");
    }
}

