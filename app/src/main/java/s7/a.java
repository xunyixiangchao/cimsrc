package s7;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R.attr;
import g.d;

public class a
{
  private static final int[] a = { 16842752, R.attr.theme };
  private static final int[] b = { R.attr.materialThemeOverlay };
  
  private static int a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a);
    int i = paramContext.getResourceId(0, 0);
    int j = paramContext.getResourceId(1, 0);
    paramContext.recycle();
    if (i != 0) {
      return i;
    }
    return j;
  }
  
  private static int b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b, paramInt1, paramInt2);
    paramInt1 = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    return paramInt1;
  }
  
  public static Context c(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramInt2 = b(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (((paramContext instanceof d)) && (((d)paramContext).c() == paramInt2)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt2 != 0)
    {
      if (paramInt1 != 0) {
        return paramContext;
      }
      d locald = new d(paramContext, paramInt2);
      paramInt1 = a(paramContext, paramAttributeSet);
      if (paramInt1 != 0) {
        locald.getTheme().applyStyle(paramInt1, true);
      }
      return locald;
    }
    return paramContext;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s7.a
 * JD-Core Version:    0.7.0.1
 */