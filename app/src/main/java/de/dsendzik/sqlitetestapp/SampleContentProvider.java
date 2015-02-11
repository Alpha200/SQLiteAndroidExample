package de.dsendzik.sqlitetestapp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class SampleContentProvider extends ContentProvider {

    private TestDatabase database;

    public static final String BASE_URI = "de.dsendzik.sqlitetestapp.SampleContentProvider";
    public static final String BASE_PATH = "sampletable";
    public static final Uri CONTENT_URI = Uri.parse("content://" + BASE_URI + "/" + BASE_PATH);

    @Override
    public boolean onCreate() {
        database = new TestDatabase(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = database.getReadableDatabase().query(false, "sampletable", projection, selection, selectionArgs, null, null, sortOrder, null);

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
