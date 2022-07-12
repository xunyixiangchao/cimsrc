package m7;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import o7.b;
import q0.d;

public class a
{
  private static float a(String[] paramArrayOfString, int paramInt)
  {
    float f = Float.parseFloat(paramArrayOfString[paramInt]);
    if ((f >= 0.0F) && (f <= 1.0F)) {
      return f;
    }
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("Motion easing control point value must be between 0 and 1; instead got: ");
    paramArrayOfString.append(f);
    throw new IllegalArgumentException(paramArrayOfString.toString());
  }
  
  private static String b(String paramString1, String paramString2)
  {
    return paramString1.substring(paramString2.length() + 1, paramString1.length() - 1);
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("(");
    return (paramString1.startsWith(localStringBuilder.toString())) && (paramString1.endsWith(")"));
  }
  
  public static int d(Context paramContext, int paramInt1, int paramInt2)
  {
    return b.c(paramContext, paramInt1, paramInt2);
  }
  
  public static TimeInterpolator e(Context paramContext, int paramInt, TimeInterpolator paramTimeInterpolator)
  {
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true))
    {
      if (localTypedValue.type == 3)
      {
        paramContext = String.valueOf(localTypedValue.string);
        if (c(paramContext, "cubic-bezier"))
        {
          paramContext = b(paramContext, "cubic-bezier").split(",");
          if (paramContext.length == 4) {
            return z0.a.a(a(paramContext, 0), a(paramContext, 1), a(paramContext, 2), a(paramContext, 3));
          }
          paramTimeInterpolator = new StringBuilder();
          paramTimeInterpolator.append("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
          paramTimeInterpolator.append(paramContext.length);
          throw new IllegalArgumentException(paramTimeInterpolator.toString());
        }
        if (c(paramContext, "path")) {
          return z0.a.b(d.e(b(paramContext, "path")));
        }
        paramTimeInterpolator = new StringBuilder();
        paramTimeInterpolator.append("Invalid motion easing type: ");
        paramTimeInterpolator.append(paramContext);
        throw new IllegalArgumentException(paramTimeInterpolator.toString());
      }
      throw new IllegalArgumentException("Motion easing theme attribute must be a string");
    }
    return paramTimeInterpolator;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m7.a
 * JD-Core Version:    0.7.0.1
 */