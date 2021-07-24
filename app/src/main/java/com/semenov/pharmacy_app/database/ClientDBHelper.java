package com.semenov.pharmacy_app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClientDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "ClientDb";
    public static final String TABLE_TEXT = "ClientTable";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE_NUMBER = "phone";
    public static final String KEY_EMAIL = "email";

    public ClientDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TEXT + "(" + KEY_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + KEY_NAME + " text," + KEY_PHONE_NUMBER + " text," +
                KEY_EMAIL + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_TEXT);

        onCreate(db);

    }
}
