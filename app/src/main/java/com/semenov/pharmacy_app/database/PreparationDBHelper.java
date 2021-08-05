package com.semenov.pharmacy_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.SQLException;
import android.util.Log;

import com.semenov.pharmacy_app.TextPreparation;

public class PreparationDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PreparationDb";
    public static final String TABLE_TEXT = "textTable";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_TEXT = "text";

    public PreparationDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TEXT + "(" + KEY_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + KEY_NAME + " text," + KEY_TEXT + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_TEXT);

        onCreate(db);
    }

/*    public SQLiteDatabase open()throws SQLException {

        return SQLiteDatabase.openDatabase(DATABASE_NAME, null, SQLiteDatabase.OPEN_READWRITE);
    }*/

    //Adding new contact
    void addContact(TextPreparation contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_TEXT, contact.getText()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_TEXT, null, values);
        db.close(); // Closing database connection
    }

    public TextPreparation getContact(String name) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(TABLE_TEXT, new String[] { KEY_ID,
                            KEY_NAME, KEY_TEXT }, KEY_NAME + "=?",
                    new String[] { name }, null, null, null, null);

/*    // Getting single contact
    Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NUM }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);*/
/*        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contact;*/

            TextPreparation contact = null;
            if (cursor.moveToFirst()) {
                contact = new TextPreparation(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2));
            }
            cursor.close();
// can return null if no contact was found.
            return contact;
        } catch (Exception ex){
            Log.d("mLog","No this name in database");
        }
        return null;
    }
}
