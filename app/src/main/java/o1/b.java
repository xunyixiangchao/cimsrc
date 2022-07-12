package o1;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;

public class b
{
  public static Cursor a(Cursor paramCursor)
  {
    for (;;)
    {
      Object[] arrayOfObject;
      int i;
      try
      {
        MatrixCursor localMatrixCursor = new MatrixCursor(paramCursor.getColumnNames(), paramCursor.getCount());
        if (paramCursor.moveToNext())
        {
          arrayOfObject = new Object[paramCursor.getColumnCount()];
          i = 0;
          if (i < paramCursor.getColumnCount())
          {
            int j = paramCursor.getType(i);
            if (j != 0)
            {
              if (j != 1)
              {
                if (j != 2)
                {
                  if (j != 3)
                  {
                    if (j == 4)
                    {
                      arrayOfObject[i] = paramCursor.getBlob(i);
                      break label185;
                    }
                    throw new IllegalStateException();
                  }
                  arrayOfObject[i] = paramCursor.getString(i);
                  break label185;
                }
                arrayOfObject[i] = Double.valueOf(paramCursor.getDouble(i));
                break label185;
              }
              arrayOfObject[i] = Long.valueOf(paramCursor.getLong(i));
              break label185;
            }
          }
          else
          {
            localMatrixCursor.addRow(arrayOfObject);
          }
        }
        else
        {
          return localMatrixCursor;
        }
      }
      finally
      {
        paramCursor.close();
      }
      arrayOfObject[i] = null;
      label185:
      i += 1;
    }
  }
  
  private static int b(Cursor paramCursor, String paramString)
  {
    if (Build.VERSION.SDK_INT > 25) {
      return -1;
    }
    if (paramString.length() == 0) {
      return -1;
    }
    return c(paramCursor.getColumnNames(), paramString);
  }
  
  static int c(String[] paramArrayOfString, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(paramString);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(".");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("`");
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i];
      if (str.length() >= paramString.length() + 2)
      {
        if (str.endsWith((String)localObject1)) {
          return i;
        }
        if ((str.charAt(0) == '`') && (str.endsWith((String)localObject2))) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public static int d(Cursor paramCursor, String paramString)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("`");
    localStringBuilder.append(paramString);
    localStringBuilder.append("`");
    i = paramCursor.getColumnIndex(localStringBuilder.toString());
    if (i >= 0) {
      return i;
    }
    return b(paramCursor, paramString);
  }
  
  public static int e(Cursor paramCursor, String paramString)
  {
    int i = d(paramCursor, paramString);
    if (i >= 0) {
      return i;
    }
    try
    {
      paramCursor = Arrays.toString(paramCursor.getColumnNames());
    }
    catch (Exception paramCursor)
    {
      Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", paramCursor);
      paramCursor = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("column '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' does not exist. Available columns: ");
    localStringBuilder.append(paramCursor);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o1.b
 * JD-Core Version:    0.7.0.1
 */