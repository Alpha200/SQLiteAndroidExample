package de.dsendzik.sqlitetestapp;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class TestDatabase extends SQLiteAssetHelper {

    private static final String DB_NAME = "test.db";
    private static final int DB_VERSION = 1;

    public TestDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
}
