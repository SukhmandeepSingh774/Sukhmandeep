package com.example.register;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Assignment.db";
    private static final String TABLE_NAME = "Users";
    private static final String CREATE_TBL_USERS = "CREATE TABLE "
            + DatabaseContract.Users.TABLE_NAME + " ("
            + DatabaseContract.Users.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DatabaseContract.Users.COL_NAME + " TEXT NOT NULL, "
            + DatabaseContract.Users.COL_EMAIL + " TEXT,"
            + DatabaseContract.Users.COL_PHONE + " TEXT,"
            + DatabaseContract.Users.COL_IMAGE+ " BLOB )";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TBL_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Items> getAllItems() {
        List<Items> articlesList1 = new ArrayList<Items>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Items contact = new Items();
                contact.setId(cursor.getString(0));
                contact.setName(cursor.getString(1));
                contact.setEmail(cursor.getString(2));
                contact.setPhone(cursor.getString(3));;
                contact.setImage(cursor.getBlob(4));
                articlesList1.add(contact);
            } while (cursor.moveToNext());
        }
        // return contact list
        return articlesList1;
    }
}
