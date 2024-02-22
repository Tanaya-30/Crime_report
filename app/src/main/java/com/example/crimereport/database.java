package com.example.crimereport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper{
    public static final String database_name="mydatabase";
    public static final String table_name="Userdata";
    public static final String col_1="Username";
    public static final String col_2="Email";
    public static final String col_3="contact";
    public static final String col_4="password";


    public database( Context context) {
        super(context,database_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+table_name+"(Username TEXT primary key,Email TEXT,Contact LONG,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+table_name);
    onCreate(db);
    }
    //registeration handler

    public boolean insertData(String uname, String email1, String contact1, String pwd1) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(col_1,uname);
        cv.put(col_2,email1);
        cv.put(col_3,contact1);
        cv.put(col_4,pwd1);
        long result= db.insert(table_name,null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }
    //Login handler
    public Cursor User_login(String uname, String pwd1 ){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from"+table_name+"where Username"+uname+"AND password"+pwd1+" ",null);
        return res;
    }
}

/*public class database extends SQLiteOpenHelper {

    public database(Context context){
        super(context,"Userdata.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Userdata(name TEXT primary key,Email TEXT, contact number,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }
    public boolean insertData(String uname, String email1, String contact1, String pwd1){
        SQLiteDatabase mydb =this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Username",uname);
        cv.put("Email",email1);
        cv.put("Conatact_No",contact1);
        cv.put("Password",pwd1);
        long result=mydb.insert("Userdata",null,cv);
        if(result == -1) return false;
        else return true;
    }
    public boolean checkUsername(String uname){
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("select * from Userdata where Username=?",new String[]{uname});
        if(cursor.getCount()>0) return true;
        else return false;
    }
}*/
