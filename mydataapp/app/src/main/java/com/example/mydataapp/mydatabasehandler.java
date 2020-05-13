package com.example.mydataapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class mydatabasehandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="products.db";
    public static final String TABLE_PRODUCTS="products";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_PRODUCTNAME="productname";

    public mydatabasehandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " +TABLE_PRODUCTS+ "(" +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +COLUMN_PRODUCTNAME+ " TEXT "+");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);

    }
    public void addproduct(Products product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME,product.get_productname());
        SQLiteDatabase db =getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);
        db.close();
    }
    public void deleteproduct(String productname){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_PRODUCTS + " WHERE "+COLUMN_PRODUCTNAME + "=\""+ productname +"\";" );
    }

    public String databasetostring(){
        String dbstring="";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_PRODUCTS+ " WHERE 1";
        Cursor c =db.rawQuery(query,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("productname"))!=null) {
                dbstring+=c.getString(c.getColumnIndex("productname"));
                dbstring+="\n";

            }
            c.moveToNext();

        }
        db.close();
        return dbstring;
    }
}
