package com.google.android.material.tabs;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import e7.a;

class b
  extends c
{
  void d(TabLayout paramTabLayout, View paramView1, View paramView2, float paramFloat, Drawable paramDrawable)
  {
    boolean bool = paramFloat < 0.5F;
    if (!bool) {
      paramView1 = paramView2;
    }
    paramTabLayout = c.a(paramTabLayout, paramView1);
    if (bool) {
      paramFloat = a.b(1.0F, 0.0F, 0.0F, 0.5F, paramFloat);
    } else {
      paramFloat = a.b(0.0F, 1.0F, 0.5F, 1.0F, paramFloat);
    }
    paramDrawable.setBounds((int)paramTabLayout.left, paramDrawable.getBounds().top, (int)paramTabLayout.right, paramDrawable.getBounds().bottom);
    paramDrawable.setAlpha((int)(paramFloat * 255.0F));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.tabs.b
 * JD-Core Version:    0.7.0.1
 */