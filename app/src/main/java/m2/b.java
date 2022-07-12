package m2;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import c.a;
import g.d;
import p0.h;

public final class b
{
  private static volatile boolean a = true;
  
  public static Drawable a(Context paramContext, int paramInt, Resources.Theme paramTheme)
  {
    return c(paramContext, paramContext, paramInt, paramTheme);
  }
  
  public static Drawable b(Context paramContext1, Context paramContext2, int paramInt)
  {
    return c(paramContext1, paramContext2, paramInt, null);
  }
  
  private static Drawable c(Context paramContext1, Context paramContext2, int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      if (a)
      {
        Drawable localDrawable = e(paramContext2, paramInt, paramTheme);
        return localDrawable;
      }
    }
    catch (IllegalStateException paramTheme)
    {
      if (!paramContext1.getPackageName().equals(paramContext2.getPackageName())) {
        return androidx.core.content.b.d(paramContext2, paramInt);
      }
      throw paramTheme;
      a = false;
      if (paramTheme == null) {
        paramTheme = paramContext2.getTheme();
      }
      return d(paramContext2, paramInt, paramTheme);
    }
    catch (NoClassDefFoundError paramContext1)
    {
      break label40;
    }
    catch (Resources.NotFoundException paramContext1)
    {
      label40:
      label44:
      break label44;
    }
  }
  
  private static Drawable d(Context paramContext, int paramInt, Resources.Theme paramTheme)
  {
    return h.e(paramContext.getResources(), paramInt, paramTheme);
  }
  
  private static Drawable e(Context paramContext, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject = paramContext;
    if (paramTheme != null) {
      localObject = new d(paramContext, paramTheme);
    }
    return a.b((Context)localObject, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m2.b
 * JD-Core Version:    0.7.0.1
 */