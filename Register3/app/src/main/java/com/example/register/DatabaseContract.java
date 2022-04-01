package com.example.register;


import android.provider.BaseColumns;

public class DatabaseContract {
    public DatabaseContract() {}
    public static abstract class Users implements BaseColumns {
        public static final String TABLE_NAME = "Users";
        public static final String COL_ID = "ID";
        public static final String COL_NAME = "Name";
        public static final String COL_EMAIL = "Email";
        public static final String COL_PHONE="Phone";
        public static final String COL_IMAGE="Image";
    }

}

