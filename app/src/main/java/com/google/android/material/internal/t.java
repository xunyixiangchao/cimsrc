package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.h0;
import androidx.core.view.x;
import com.google.android.material.R.styleable;

public class t
{
  public static void a(View paramView, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, final e parame)
  {
    paramAttributeSet = paramView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.Insets, paramInt1, paramInt2);
    boolean bool1 = paramAttributeSet.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
    final boolean bool2 = paramAttributeSet.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
    final boolean bool3 = paramAttributeSet.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
    paramAttributeSet.recycle();
    b(paramView, new b(bool1, bool2, bool3, parame));
  }
  
  public static void b(View paramView, e parame)
  {
    x.E0(paramView, new c(parame, new f(x.G(paramView), paramView.getPaddingTop(), x.F(paramView), paramView.getPaddingBottom())));
    k(paramView);
  }
  
  public static float c(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    return TypedValue.applyDimension(1, paramInt, paramContext.getDisplayMetrics());
  }
  
  public static Integer d(View paramView)
  {
    if ((paramView.getBackground() instanceof ColorDrawable)) {
      return Integer.valueOf(((ColorDrawable)paramView.getBackground()).getColor());
    }
    return null;
  }
  
  public static ViewGroup e(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    View localView = paramView.getRootView();
    ViewGroup localViewGroup = (ViewGroup)localView.findViewById(16908290);
    if (localViewGroup != null) {
      return localViewGroup;
    }
    if ((localView != paramView) && ((localView instanceof ViewGroup))) {
      return (ViewGroup)localView;
    }
    return null;
  }
  
  public static s f(View paramView)
  {
    return g(e(paramView));
  }
  
  public static s g(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return new r(paramView);
  }
  
  public static float h(View paramView)
  {
    paramView = paramView.getParent();
    float f = 0.0F;
    while ((paramView instanceof View))
    {
      f += x.w((View)paramView);
      paramView = paramView.getParent();
    }
    return f;
  }
  
  public static boolean i(View paramView)
  {
    return x.B(paramView) == 1;
  }
  
  public static PorterDuff.Mode j(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  public static void k(View paramView)
  {
    if (x.T(paramView))
    {
      x.n0(paramView);
      return;
    }
    paramView.addOnAttachStateChangeListener(new d());
  }
  
  public static void l(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new a());
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      ((InputMethodManager)t.this.getContext().getSystemService("input_method")).showSoftInput(t.this, 1);
    }
  }
  
  class b
    implements t.e
  {
    b(boolean paramBoolean1, boolean paramBoolean2, t.e parame) {}
    
    public h0 a(View paramView, h0 paramh0, t.f paramf)
    {
      if (this.a) {
        paramf.d += paramh0.i();
      }
      boolean bool = t.i(paramView);
      if (bool2) {
        if (bool) {
          paramf.c += paramh0.j();
        } else {
          paramf.a += paramh0.j();
        }
      }
      if (bool3) {
        if (bool) {
          paramf.a += paramh0.k();
        } else {
          paramf.c += paramh0.k();
        }
      }
      paramf.a(paramView);
      t.e locale = parame;
      h0 localh0 = paramh0;
      if (locale != null) {
        localh0 = locale.a(paramView, paramh0, paramf);
      }
      return localh0;
    }
  }
  
  class c
    implements androidx.core.view.r
  {
    c(t.f paramf) {}
    
    public h0 a(View paramView, h0 paramh0)
    {
      return t.this.a(paramView, paramh0, new t.f(this.b));
    }
  }
  
  class d
    implements View.OnAttachStateChangeListener
  {
    public void onViewAttachedToWindow(View paramView)
    {
      paramView.removeOnAttachStateChangeListener(this);
      x.n0(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView) {}
  }
  
  public static abstract interface e
  {
    public abstract h0 a(View paramView, h0 paramh0, t.f paramf);
  }
  
  public static class f
  {
    public int a;
    public int b;
    public int c;
    public int d;
    
    public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
    }
    
    public f(f paramf)
    {
      this.a = paramf.a;
      this.b = paramf.b;
      this.c = paramf.c;
      this.d = paramf.d;
    }
    
    public void a(View paramView)
    {
      x.F0(paramView, this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.t
 * JD-Core Version:    0.7.0.1
 */