package com.example.crimereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class User_Registeration extends AppCompatActivity {
    EditText name,pwd,cpwd,email,contact;
    String uname,pwd1,pwd2,email1,contact1;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registeration);

        name=findViewById(R.id.Uname);
        pwd=findViewById(R.id.pass1);
        cpwd=findViewById(R.id.pass2);
        email=findViewById(R.id.Email);
        contact=findViewById(R.id.contact);
        db=new database(this);
    }
    public void user_dashboard(View v){
        uname=name.getText().toString();
        pwd1=pwd.getText().toString();
        pwd2=cpwd.getText().toString();
        email1=email.getText().toString();
       contact1=contact.getText().toString();

    if(uname.equals("")||pwd1.equals("")||pwd2.equals("")||email1.equals("")||contact1.equals("")){
        Toast.makeText(User_Registeration.this,"Please Fill All The Fields!!",Toast.LENGTH_LONG).show();
    }
    else{
       if(pwd1.equals(pwd2)){
           /* if(db.checkUsername(uname)){
                Toast.makeText(User_Registeration.this,"User name already exist!!!",Toast.LENGTH_LONG).show();
                return;
            }*/
            //Process with Registration
           boolean registerSuccess= db.insertData(uname,email1,contact1,pwd1);
           if(registerSuccess){
               Intent i= new Intent(this,User_Dashboard.class);
               startActivity(i);
              // Toast.makeText(User_Registeration.this,"User Registered Successfully!!!",Toast.LENGTH_LONG).show();
           }
           else{
               Toast.makeText(User_Registeration.this,"User Registration Failed!!!",Toast.LENGTH_LONG).show();
           }
        }
        else{
            Toast.makeText(User_Registeration.this,"Passwords does not match!!",Toast.LENGTH_LONG).show();
        }
    }

    }
    public void back_to_login_page(View v){
        Intent i= new Intent(this,User_login.class);
        startActivity(i);
    }
}