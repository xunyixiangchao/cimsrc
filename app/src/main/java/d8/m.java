package d8;

import android.database.Cursor;

abstract interface m
{
  public abstract boolean a();
  
  public static class a
  {
    public static void a(Cursor paramCursor)
    {
      if (paramCursor.getCount() > 0)
      {
        paramCursor.moveToFirst();
        int i = paramCursor.getType(0);
        if ((i != 0) && (i != 4)) {
          paramCursor.getString(0);
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.m
 * JD-Core Version:    0.7.0.1
 */