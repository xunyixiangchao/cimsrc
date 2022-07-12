package com.farsunset.cim.sdk.android;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

class a
{
  private static void a(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    try
    {
      paramCursor.close();
      return;
    }
    catch (Exception paramCursor) {}
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    return Boolean.parseBoolean(d(paramContext, paramString));
  }
  
  public static int c(Context paramContext, String paramString)
  {
    paramContext = d(paramContext, paramString);
    if (paramContext == null) {
      return 0;
    }
    return Integer.parseInt(paramContext);
  }
  
  public static String d(Context paramContext, String paramString)
  {
    paramString = paramContext.getContentResolver().query(Uri.parse(String.format("content://%s.cim.provider", new Object[] { paramContext.getPackageName() })), new String[] { paramString }, null, null, null);
    if ((paramString != null) && (paramString.moveToFirst())) {
      paramContext = paramString.getString(0);
    } else {
      paramContext = null;
    }
    a(paramString);
    return paramContext;
  }
  
  public static void e(Context paramContext, String paramString, boolean paramBoolean)
  {
    g(paramContext, paramString, Boolean.toString(paramBoolean));
  }
  
  public static void f(Context paramContext, String paramString, int paramInt)
  {
    g(paramContext, paramString, String.valueOf(paramInt));
  }
  
  public static void g(Context paramContext, String paramString1, String paramString2)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("value", paramString2);
    localContentValues.put("key", paramString1);
    localContentResolver.insert(Uri.parse(String.format("content://%s.cim.provider", new Object[] { paramContext.getPackageName() })), localContentValues);
  }
  
  public static void h(Context paramContext, String paramString)
  {
    paramContext.getContentResolver().delete(Uri.parse(String.format("content://%s.cim.provider", new Object[] { paramContext.getPackageName() })), paramString, null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.cim.sdk.android.a
 * JD-Core Version:    0.7.0.1
 */