package com.example.crimereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void admin_panel(View v){
        Intent i= new Intent(this,AdminLogin.class);
        startActivity(i);
    }
    public void user_panel(View v){
        Intent i= new Intent(this,User_Registeration.class);
        startActivity(i);
    }
}