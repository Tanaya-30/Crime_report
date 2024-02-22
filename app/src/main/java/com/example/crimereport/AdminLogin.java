package com.example.crimereport;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    EditText username,password;
    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        username=(EditText)findViewById(R.id.uid);
        password=(EditText)findViewById(R.id.pass);
    }
    public void admin_login(View v){
         s1=username.getText().toString();
         s2=password.getText().toString();

        if(s1.equals("Admin")&& s2.equals("1234")){
           Intent i1 = new Intent(this, Admin_Dashboard.class);
           startActivity(i1);
        }
        else{
            Toast.makeText(this,"Wrong Credentials",Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View v){
       Intent iHome = new Intent(this, MainActivity.class);
        startActivity(iHome);
    }
}