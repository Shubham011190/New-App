package com.example.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Accounts";
    public static final String TABLE_NAME="Data";
    public static final String col1="NAME";
    public static final String col2="ID";
    public static final String col3="DATE";
    public static final String col4="DEBIT";
    public static final String col5="CREDIT";
    public static final String col6="BALANCE";
    public static final String col7="USERID";
    public Database(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table "+ TABLE_NAME +" (USERID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT ,ID INTEGER,DATE TEXT,DEBIT REAL,CREDIT REAL,BALANCE REAL)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
    public void insertData(String name,String id,String date,double debit,double credit,double balance){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1,name);
        contentValues.put(col2,id);
        contentValues.put(col3,date);
        contentValues.put(col4,debit);
        contentValues.put(col5,credit);
        contentValues.put(col6,balance);
        db.insert(TABLE_NAME,null ,contentValues);
        db.close();

    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    Data getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{col1,col2,col3,col4,col5,col6},col1 + "=?", new String[]{String.valueOf(col1)},null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        Data data = new Data();
        data.setName(cursor.getString(0));
        data.setID(cursor.getString(1));
        data.setDate(cursor.getString(2));
        data.setDebitAmt(Double.parseDouble(cursor.getString(3)));
        data.setCreditAmt(Double.parseDouble(cursor.getString(4)));
        data.setBalanceAmt(Double.parseDouble(cursor.getString(5)));
        return data;
    }
}
