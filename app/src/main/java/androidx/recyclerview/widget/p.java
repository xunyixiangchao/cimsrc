package androidx.recyclerview.widget;

import android.view.View;

class p
{
  static int a(RecyclerView.z paramz, m paramm, View paramView1, View paramView2, RecyclerView.p paramp, boolean paramBoolean)
  {
    if ((paramp.J() != 0) && (paramz.b() != 0) && (paramView1 != null) && (paramView2 != null))
    {
      if (!paramBoolean) {
        return Math.abs(paramp.h0(paramView1) - paramp.h0(paramView2)) + 1;
      }
      int i = paramm.d(paramView2);
      int j = paramm.g(paramView1);
      return Math.min(paramm.n(), i - j);
    }
    return 0;
  }
  
  static int b(RecyclerView.z paramz, m paramm, View paramView1, View paramView2, RecyclerView.p paramp, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramp.J() != 0) && (paramz.b() != 0) && (paramView1 != null))
    {
      if (paramView2 == null) {
        return 0;
      }
      int i = Math.min(paramp.h0(paramView1), paramp.h0(paramView2));
      int j = Math.max(paramp.h0(paramView1), paramp.h0(paramView2));
      if (paramBoolean2) {
        i = Math.max(0, paramz.b() - j - 1);
      } else {
        i = Math.max(0, i);
      }
      if (!paramBoolean1) {
        return i;
      }
      j = Math.abs(paramm.d(paramView2) - paramm.g(paramView1));
      int k = Math.abs(paramp.h0(paramView1) - paramp.h0(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (paramm.m() - paramm.g(paramView1)));
    }
    return 0;
  }
  
  static int c(RecyclerView.z paramz, m paramm, View paramView1, View paramView2, RecyclerView.p paramp, boolean paramBoolean)
  {
    if ((paramp.J() != 0) && (paramz.b() != 0) && (paramView1 != null) && (paramView2 != null))
    {
      if (!paramBoolean) {
        return paramz.b();
      }
      int i = paramm.d(paramView2);
      int j = paramm.g(paramView1);
      int k = Math.abs(paramp.h0(paramView1) - paramp.h0(paramView2));
      return (int)((i - j) / (k + 1) * paramz.b());
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.p
 * JD-Core Version:    0.7.0.1
 */