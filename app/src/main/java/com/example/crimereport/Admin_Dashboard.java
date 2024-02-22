package com.example.crimereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin_Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }
    public void back_to_Admin_login(View v){
        Intent i= new Intent(this,AdminLogin.class);
        startActivity(i);
    }
}