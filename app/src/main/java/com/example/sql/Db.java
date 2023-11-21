package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class Db extends SQLiteOpenHelper{

    private static final String NAME_COL ="nameCourse" ;

    private static final String TIME_COL = "timeCourse";
    private static final String PRICE_COL = "priceCourse" ;
    private static final String DESCRIPTION_COL ="descriptionCourse";
    private static final String TABLE_NAME ="Mycourses";
    private static final String DB_NAME = "coursesDb";
    private static final int DB_VERSION = 1;
    private static final String ID_COL = "id";


    public Db(Context context){ super(context, DB_NAME, null, DB_VERSION);}

    public Db(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version ) {

        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "("
                + ID_COL + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME_COL + "TEXT,"
                + DESCRIPTION_COL +"TEXT,"
                + TIME_COL +"TEXT,"
                + PRICE_COL + "TEXT)";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        SQLiteDatabase db = null;
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);


    }



    public void addCourse(String nameCourse, String timeCourse, String priceCourse, String descriptionCourse) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, nameCourse);
        values.put(TIME_COL, timeCourse);
        values.put(PRICE_COL, priceCourse);
        values.put(DESCRIPTION_COL, descriptionCourse);
        db.insert(TABLE_NAME, null, values);
        db.close();

    }
}
