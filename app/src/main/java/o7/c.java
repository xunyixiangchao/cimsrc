package o7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.appcompat.widget.k0;
import c.a;
import com.google.android.material.R.styleable;

public class c
{
  public static ColorStateList a(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = a.a(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    return paramTypedArray.getColorStateList(paramInt);
  }
  
  public static ColorStateList b(Context paramContext, k0 paramk0, int paramInt)
  {
    if (paramk0.s(paramInt))
    {
      int i = paramk0.n(paramInt, 0);
      if (i != 0)
      {
        paramContext = a.a(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    return paramk0.c(paramInt);
  }
  
  private static int c(TypedValue paramTypedValue)
  {
    return paramTypedValue.getComplexUnit();
  }
  
  public static int d(Context paramContext, TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    TypedValue localTypedValue = new TypedValue();
    if ((paramTypedArray.getValue(paramInt1, localTypedValue)) && (localTypedValue.type == 2))
    {
      paramContext = paramContext.getTheme().obtainStyledAttributes(new int[] { localTypedValue.data });
      paramInt1 = paramContext.getDimensionPixelSize(0, paramInt2);
      paramContext.recycle();
      return paramInt1;
    }
    return paramTypedArray.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public static Drawable e(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = a.b(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    return paramTypedArray.getDrawable(paramInt);
  }
  
  static int f(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    if (paramTypedArray.hasValue(paramInt1)) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static d g(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return new d(paramContext, paramInt);
      }
    }
    return null;
  }
  
  public static int h(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return paramInt2;
    }
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt1, R.styleable.TextAppearance);
    TypedValue localTypedValue = new TypedValue();
    boolean bool = localTypedArray.getValue(R.styleable.TextAppearance_android_textSize, localTypedValue);
    localTypedArray.recycle();
    if (!bool) {
      return paramInt2;
    }
    if (c(localTypedValue) == 2) {
      return Math.round(TypedValue.complexToFloat(localTypedValue.data) * paramContext.getResources().getDisplayMetrics().density);
    }
    return TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
  }
  
  public static boolean i(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().fontScale >= 1.3F;
  }
  
  public static boolean j(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().fontScale >= 2.0F;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o7.c
 * JD-Core Version:    0.7.0.1
 */