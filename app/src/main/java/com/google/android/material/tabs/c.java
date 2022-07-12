package com.google.android.material.tabs;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.internal.t;
import e7.a;

class c
{
  static RectF a(TabLayout paramTabLayout, View paramView)
  {
    if (paramView == null) {
      return new RectF();
    }
    if ((!paramTabLayout.y()) && ((paramView instanceof TabLayout.i))) {
      return b((TabLayout.i)paramView, 24);
    }
    return new RectF(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  static RectF b(TabLayout.i parami, int paramInt)
  {
    int i = parami.getContentWidth();
    int k = parami.getContentHeight();
    int j = (int)t.c(parami.getContext(), paramInt);
    paramInt = i;
    if (i < j) {
      paramInt = j;
    }
    i = (parami.getLeft() + parami.getRight()) / 2;
    j = (parami.getTop() + parami.getBottom()) / 2;
    paramInt /= 2;
    k /= 2;
    int m = i / 2;
    return new RectF(i - paramInt, j - k, paramInt + i, j + m);
  }
  
  void c(TabLayout paramTabLayout, View paramView, Drawable paramDrawable)
  {
    paramTabLayout = a(paramTabLayout, paramView);
    paramDrawable.setBounds((int)paramTabLayout.left, paramDrawable.getBounds().top, (int)paramTabLayout.right, paramDrawable.getBounds().bottom);
  }
  
  void d(TabLayout paramTabLayout, View paramView1, View paramView2, float paramFloat, Drawable paramDrawable)
  {
    paramView1 = a(paramTabLayout, paramView1);
    paramTabLayout = a(paramTabLayout, paramView2);
    paramDrawable.setBounds(a.c((int)paramView1.left, (int)paramTabLayout.left, paramFloat), paramDrawable.getBounds().top, a.c((int)paramView1.right, (int)paramTabLayout.right, paramFloat), paramDrawable.getBounds().bottom);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.tabs.c
 * JD-Core Version:    0.7.0.1
 */