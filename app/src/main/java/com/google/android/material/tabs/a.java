package com.google.android.material.tabs;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

class a
  extends c
{
  private static float e(float paramFloat)
  {
    return (float)(1.0D - Math.cos(paramFloat * 3.141592653589793D / 2.0D));
  }
  
  private static float f(float paramFloat)
  {
    return (float)Math.sin(paramFloat * 3.141592653589793D / 2.0D);
  }
  
  void d(TabLayout paramTabLayout, View paramView1, View paramView2, float paramFloat, Drawable paramDrawable)
  {
    paramView1 = c.a(paramTabLayout, paramView1);
    paramTabLayout = c.a(paramTabLayout, paramView2);
    int i;
    if (paramView1.left < paramTabLayout.left) {
      i = 1;
    } else {
      i = 0;
    }
    float f1;
    float f2;
    if (i != 0)
    {
      f1 = e(paramFloat);
      f2 = f(paramFloat);
      paramFloat = f1;
      f1 = f2;
    }
    else
    {
      f2 = f(paramFloat);
      f1 = e(paramFloat);
      paramFloat = f2;
    }
    paramDrawable.setBounds(e7.a.c((int)paramView1.left, (int)paramTabLayout.left, paramFloat), paramDrawable.getBounds().top, e7.a.c((int)paramView1.right, (int)paramTabLayout.right, f1), paramDrawable.getBounds().bottom);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.tabs.a
 * JD-Core Version:    0.7.0.1
 */