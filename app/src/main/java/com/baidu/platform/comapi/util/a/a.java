package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.baidu.vi.VIContext;

public class a
{
  private int a = -1;
  private int b = -1;
  private float c = -1.0F;
  private int d = -1;
  
  public float a()
  {
    if (this.c == -1.0F) {
      a(VIContext.getContext());
    }
    return this.c;
  }
  
  public void a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.a = paramContext.widthPixels;
    this.b = paramContext.heightPixels;
    this.c = paramContext.density;
    int i = paramContext.densityDpi;
    this.d = i;
    if (i < 240) {
      this.d = i;
    }
    if (this.d == 0) {
      this.d = 160;
    }
  }
  
  public int b()
  {
    if (this.d == -1) {
      a(VIContext.getContext());
    }
    return this.d;
  }
  
  public int c()
  {
    if (this.b == -1) {
      a(VIContext.getContext());
    }
    return this.b;
  }
  
  public int d()
  {
    if (this.a == -1) {
      a(VIContext.getContext());
    }
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.a.a
 * JD-Core Version:    0.7.0.1
 */