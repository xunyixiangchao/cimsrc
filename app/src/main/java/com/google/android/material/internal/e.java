package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.Window;
import androidx.core.view.g0;
import androidx.core.view.i0;

public class e
{
  public static void a(Window paramWindow, boolean paramBoolean, Integer paramInteger1, Integer paramInteger2)
  {
    int j = 0;
    if ((paramInteger1 != null) && (paramInteger1.intValue() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((paramInteger2 == null) || (paramInteger2.intValue() == 0)) {
      j = 1;
    }
    Integer localInteger1;
    Integer localInteger2;
    if (i == 0)
    {
      localInteger1 = paramInteger1;
      localInteger2 = paramInteger2;
      if (j == 0) {}
    }
    else
    {
      int k = g7.a.b(paramWindow.getContext(), 16842801, -16777216);
      if (i != 0) {
        paramInteger1 = Integer.valueOf(k);
      }
      localInteger1 = paramInteger1;
      localInteger2 = paramInteger2;
      if (j != 0)
      {
        localInteger2 = Integer.valueOf(k);
        localInteger1 = paramInteger1;
      }
    }
    g0.b(paramWindow, paramBoolean ^ true);
    int i = c(paramWindow.getContext(), paramBoolean);
    j = b(paramWindow.getContext(), paramBoolean);
    paramWindow.setStatusBarColor(i);
    paramWindow.setNavigationBarColor(j);
    paramBoolean = d(i, g7.a.f(localInteger1.intValue()));
    boolean bool = d(j, g7.a.f(localInteger2.intValue()));
    paramWindow = g0.a(paramWindow, paramWindow.getDecorView());
    if (paramWindow != null)
    {
      paramWindow.b(paramBoolean);
      paramWindow.a(bool);
    }
  }
  
  @TargetApi(21)
  private static int b(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 27)) {
      return q0.a.o(g7.a.b(paramContext, 16843858, -16777216), 128);
    }
    if (paramBoolean) {
      return 0;
    }
    return g7.a.b(paramContext, 16843858, -16777216);
  }
  
  @TargetApi(21)
  private static int c(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return g7.a.b(paramContext, 16843857, -16777216);
  }
  
  private static boolean d(int paramInt, boolean paramBoolean)
  {
    return (g7.a.f(paramInt)) || ((paramInt == 0) && (paramBoolean));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.e
 * JD-Core Version:    0.7.0.1
 */