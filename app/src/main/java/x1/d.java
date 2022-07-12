package x1;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

public class d
{
  private static boolean a = false;
  private static int b = 50;
  
  public static int a(Context paramContext)
  {
    try
    {
      if (!a)
      {
        i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i > 0)
        {
          i = paramContext.getResources().getDimensionPixelSize(i);
          b = i;
          a = true;
          Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", new Object[] { Integer.valueOf(i) }));
        }
      }
      int i = b;
      return i;
    }
    finally {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x1.d
 * JD-Core Version:    0.7.0.1
 */