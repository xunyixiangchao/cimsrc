package o7;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import t0.a;

public class g
{
  public static Typeface a(Context paramContext, Typeface paramTypeface)
  {
    return b(paramContext.getResources().getConfiguration(), paramTypeface);
  }
  
  public static Typeface b(Configuration paramConfiguration, Typeface paramTypeface)
  {
    if (Build.VERSION.SDK_INT >= 31)
    {
      int i = paramConfiguration.fontWeightAdjustment;
      if ((i != 2147483647) && (i != 0)) {
        return Typeface.create(paramTypeface, a.b(paramTypeface.getWeight() + paramConfiguration.fontWeightAdjustment, 1, 1000), paramTypeface.isItalic());
      }
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o7.g
 * JD-Core Version:    0.7.0.1
 */