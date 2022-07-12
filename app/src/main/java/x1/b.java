package x1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class b
{
  private static volatile SharedPreferences a;
  
  public static int a(Context paramContext, int paramInt)
  {
    return c(paramContext).getInt("sp.key.keyboard.height", paramInt);
  }
  
  public static boolean b(Context paramContext, int paramInt)
  {
    return c(paramContext).edit().putInt("sp.key.keyboard.height", paramInt).commit();
  }
  
  private static SharedPreferences c(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = paramContext.getSharedPreferences("keyboard.common", 0);
        }
      }
      finally {}
    }
    return a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x1.b
 * JD-Core Version:    0.7.0.1
 */