package com.example.recyclerview;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {
    Context c;
    public static final String DBname = "Accounts";
    public static final String tableName = "Data";
    public static final int dbVersion = 1;
    public Database(Context context){
        super(context,DBname,null,dbVersion);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            String qry = "create table Account(Name TEXT PRIMARY KEY,id TEXT,date TEXT,debit REAL,credit REAL,balance REAL)";
            db.execSQL(qry);
            Toast.makeText(c,"Table Created",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Log.e("DB_create","DB Creation Error");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertData(String name,String date,String id,double credit,double debit,double balance) {
        try {
            String qry = "insert into Account values('" + name + "','" + id + "','" + date + "'," + debit + "," + credit + "," + balance + ")";
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(qry);
            Toast.makeText(c, "Data inserted successfully", Toast.LENGTH_LONG).show();
            return true;
        } catch (Exception e) {
            Log.e("DB_insert", "Data insertion failed");
            return false;
        }
    }
}
