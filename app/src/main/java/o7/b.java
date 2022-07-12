package o7;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.View;

public class b
{
  public static TypedValue a(Context paramContext, int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true)) {
      return localTypedValue;
    }
    return null;
  }
  
  public static boolean b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    paramContext = a(paramContext, paramInt);
    boolean bool = paramBoolean;
    if (paramContext != null)
    {
      bool = paramBoolean;
      if (paramContext.type == 18)
      {
        if (paramContext.data != 0) {
          return true;
        }
        bool = false;
      }
    }
    return bool;
  }
  
  public static int c(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = a(paramContext, paramInt1);
    paramInt1 = paramInt2;
    if (paramContext != null)
    {
      paramInt1 = paramInt2;
      if (paramContext.type == 16) {
        paramInt1 = paramContext.data;
      }
    }
    return paramInt1;
  }
  
  public static int d(Context paramContext, int paramInt, String paramString)
  {
    TypedValue localTypedValue = a(paramContext, paramInt);
    if (localTypedValue != null) {
      return localTypedValue.data;
    }
    throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[] { paramString, paramContext.getResources().getResourceName(paramInt) }));
  }
  
  public static int e(View paramView, int paramInt)
  {
    return d(paramView.getContext(), paramInt, paramView.getClass().getCanonicalName());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o7.b
 * JD-Core Version:    0.7.0.1
 */