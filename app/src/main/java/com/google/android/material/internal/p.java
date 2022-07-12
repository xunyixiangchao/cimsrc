package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.k0;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;

public final class p
{
  private static final int[] a = { R.attr.colorPrimary };
  private static final int[] b = { R.attr.colorPrimaryVariant };
  
  public static void a(Context paramContext)
  {
    e(paramContext, a, "Theme.AppCompat");
  }
  
  private static void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = paramAttributeSet.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
    paramAttributeSet.recycle();
    if (bool)
    {
      paramAttributeSet = new TypedValue();
      if ((!paramContext.getTheme().resolveAttribute(R.attr.isMaterialTheme, paramAttributeSet, true)) || ((paramAttributeSet.type == 18) && (paramAttributeSet.data == 0))) {
        c(paramContext);
      }
    }
    a(paramContext);
  }
  
  public static void c(Context paramContext)
  {
    e(paramContext, b, "Theme.MaterialComponents");
  }
  
  private static void d(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    int i = R.styleable.ThemeEnforcement_enforceTextAppearance;
    boolean bool = false;
    if (!localTypedArray.getBoolean(i, false))
    {
      localTypedArray.recycle();
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      bool = f(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    } else if (localTypedArray.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1) {
      bool = true;
    }
    localTypedArray.recycle();
    if (bool) {
      return;
    }
    throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
  }
  
  private static void e(Context paramContext, int[] paramArrayOfInt, String paramString)
  {
    if (g(paramContext, paramArrayOfInt)) {
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("The style on this component requires your app theme to be ");
    paramContext.append(paramString);
    paramContext.append(" (or a descendant).");
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  private static boolean f(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    paramInt2 = paramVarArgs.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramContext.getResourceId(paramVarArgs[paramInt1], -1) == -1)
      {
        paramContext.recycle();
        return false;
      }
      paramInt1 += 1;
    }
    paramContext.recycle();
    return true;
  }
  
  private static boolean g(Context paramContext, int[] paramArrayOfInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (!paramContext.hasValue(i))
      {
        paramContext.recycle();
        return false;
      }
      i += 1;
    }
    paramContext.recycle();
    return true;
  }
  
  public static TypedArray h(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    b(paramContext, paramAttributeSet, paramInt1, paramInt2);
    d(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  public static k0 i(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    b(paramContext, paramAttributeSet, paramInt1, paramInt2);
    d(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return k0.v(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.p
 * JD-Core Version:    0.7.0.1
 */