package com.farsunset.cim.sdk.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class CIMCacheProvider
        extends ContentProvider {
    public int delete(Uri paramUri, String paramString, String[] paramArrayOfString) {
        getContext().getSharedPreferences("PRIVATE_CIM_CONFIG", 0).edit().remove(paramString).apply();
        return 0;
    }

    public String getType(Uri paramUri) {
        return null;
    }

    public Uri insert(Uri paramUri, ContentValues paramContentValues) {
        paramUri = paramContentValues.getAsString("key");
        paramContentValues = paramContentValues.getAsString("value");
        getContext().getSharedPreferences("PRIVATE_CIM_CONFIG", 0).edit().putString(paramUri, paramContentValues).apply();
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
        paramUri = new MatrixCursor(new String[]{"value"});
        paramUri.addRow(new Object[]{getContext().getSharedPreferences("PRIVATE_CIM_CONFIG", 0).getString(paramArrayOfString1[0], null)});
        return paramUri;
    }

    public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
        return 0;
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.cim.sdk.android.CIMCacheProvider

 * JD-Core Version:    0.7.0.1

 */