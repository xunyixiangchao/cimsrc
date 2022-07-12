package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;

class d
{
  private final View a;
  private final g b;
  private int c = -1;
  private i0 d;
  private i0 e;
  private i0 f;
  
  d(View paramView)
  {
    this.a = paramView;
    this.b = g.b();
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.f == null) {
      this.f = new i0();
    }
    i0 locali0 = this.f;
    locali0.a();
    Object localObject = x.s(this.a);
    if (localObject != null)
    {
      locali0.d = true;
      locali0.a = ((ColorStateList)localObject);
    }
    localObject = x.t(this.a);
    if (localObject != null)
    {
      locali0.c = true;
      locali0.b = ((PorterDuff.Mode)localObject);
    }
    if ((!locali0.d) && (!locali0.c)) {
      return false;
    }
    g.i(paramDrawable, locali0, this.a.getDrawableState());
    return true;
  }
  
  private boolean k()
  {
    return this.d != null;
  }
  
  void b()
  {
    Drawable localDrawable = this.a.getBackground();
    if (localDrawable != null)
    {
      if ((k()) && (a(localDrawable))) {
        return;
      }
      i0 locali0 = this.e;
      if (locali0 != null)
      {
        g.i(localDrawable, locali0, this.a.getDrawableState());
        return;
      }
      locali0 = this.d;
      if (locali0 != null) {
        g.i(localDrawable, locali0, this.a.getDrawableState());
      }
    }
  }
  
  ColorStateList c()
  {
    i0 locali0 = this.e;
    if (locali0 != null) {
      return locali0.a;
    }
    return null;
  }
  
  PorterDuff.Mode d()
  {
    i0 locali0 = this.e;
    if (locali0 != null) {
      return locali0.b;
    }
    return null;
  }
  
  void e(AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject = this.a.getContext();
    int[] arrayOfInt = R.styleable.ViewBackgroundHelper;
    localObject = k0.v((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    View localView = this.a;
    x.o0(localView, localView.getContext(), arrayOfInt, paramAttributeSet, ((k0)localObject).r(), paramInt, 0);
    try
    {
      paramInt = R.styleable.ViewBackgroundHelper_android_background;
      if (((k0)localObject).s(paramInt))
      {
        this.c = ((k0)localObject).n(paramInt, -1);
        paramAttributeSet = this.b.f(this.a.getContext(), this.c);
        if (paramAttributeSet != null) {
          h(paramAttributeSet);
        }
      }
      paramInt = R.styleable.ViewBackgroundHelper_backgroundTint;
      if (((k0)localObject).s(paramInt)) {
        x.v0(this.a, ((k0)localObject).c(paramInt));
      }
      paramInt = R.styleable.ViewBackgroundHelper_backgroundTintMode;
      if (((k0)localObject).s(paramInt)) {
        x.w0(this.a, t.e(((k0)localObject).k(paramInt, -1), null));
      }
      return;
    }
    finally
    {
      ((k0)localObject).w();
    }
  }
  
  void f(Drawable paramDrawable)
  {
    this.c = -1;
    h(null);
    b();
  }
  
  void g(int paramInt)
  {
    this.c = paramInt;
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((g)localObject).f(this.a.getContext(), paramInt);
    } else {
      localObject = null;
    }
    h((ColorStateList)localObject);
    b();
  }
  
  void h(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.d == null) {
        this.d = new i0();
      }
      i0 locali0 = this.d;
      locali0.a = paramColorStateList;
      locali0.d = true;
    }
    else
    {
      this.d = null;
    }
    b();
  }
  
  void i(ColorStateList paramColorStateList)
  {
    if (this.e == null) {
      this.e = new i0();
    }
    i0 locali0 = this.e;
    locali0.a = paramColorStateList;
    locali0.d = true;
    b();
  }
  
  void j(PorterDuff.Mode paramMode)
  {
    if (this.e == null) {
      this.e = new i0();
    }
    i0 locali0 = this.e;
    locali0.b = paramMode;
    locali0.c = true;
    b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.d
 * JD-Core Version:    0.7.0.1
 */