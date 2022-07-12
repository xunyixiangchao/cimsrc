package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;
import androidx.core.widget.h;
import c.a;

public class k
{
  private final ImageView a;
  private i0 b;
  private i0 c;
  private i0 d;
  private int e = 0;
  
  public k(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.d == null) {
      this.d = new i0();
    }
    i0 locali0 = this.d;
    locali0.a();
    Object localObject = h.a(this.a);
    if (localObject != null)
    {
      locali0.d = true;
      locali0.a = ((ColorStateList)localObject);
    }
    localObject = h.b(this.a);
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
  
  private boolean l()
  {
    return this.b != null;
  }
  
  void b()
  {
    if (this.a.getDrawable() != null) {
      this.a.getDrawable().setLevel(this.e);
    }
  }
  
  void c()
  {
    Drawable localDrawable = this.a.getDrawable();
    if (localDrawable != null) {
      t.b(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((l()) && (a(localDrawable))) {
        return;
      }
      i0 locali0 = this.c;
      if (locali0 != null)
      {
        g.i(localDrawable, locali0, this.a.getDrawableState());
        return;
      }
      locali0 = this.b;
      if (locali0 != null) {
        g.i(localDrawable, locali0, this.a.getDrawableState());
      }
    }
  }
  
  ColorStateList d()
  {
    i0 locali0 = this.c;
    if (locali0 != null) {
      return locali0.a;
    }
    return null;
  }
  
  PorterDuff.Mode e()
  {
    i0 locali0 = this.c;
    if (locali0 != null) {
      return locali0.b;
    }
    return null;
  }
  
  boolean f()
  {
    return !(this.a.getBackground() instanceof RippleDrawable);
  }
  
  public void g(AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject2 = this.a.getContext();
    Object localObject1 = R.styleable.AppCompatImageView;
    localObject2 = k0.v((Context)localObject2, paramAttributeSet, (int[])localObject1, paramInt, 0);
    ImageView localImageView = this.a;
    x.o0(localImageView, localImageView.getContext(), (int[])localObject1, paramAttributeSet, ((k0)localObject2).r(), paramInt, 0);
    try
    {
      localObject1 = this.a.getDrawable();
      paramAttributeSet = (AttributeSet)localObject1;
      if (localObject1 == null)
      {
        paramInt = ((k0)localObject2).n(R.styleable.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = (AttributeSet)localObject1;
        if (paramInt != -1)
        {
          localObject1 = a.b(this.a.getContext(), paramInt);
          paramAttributeSet = (AttributeSet)localObject1;
          if (localObject1 != null)
          {
            this.a.setImageDrawable((Drawable)localObject1);
            paramAttributeSet = (AttributeSet)localObject1;
          }
        }
      }
      if (paramAttributeSet != null) {
        t.b(paramAttributeSet);
      }
      paramInt = R.styleable.AppCompatImageView_tint;
      if (((k0)localObject2).s(paramInt)) {
        h.c(this.a, ((k0)localObject2).c(paramInt));
      }
      paramInt = R.styleable.AppCompatImageView_tintMode;
      if (((k0)localObject2).s(paramInt)) {
        h.d(this.a, t.e(((k0)localObject2).k(paramInt, -1), null));
      }
      return;
    }
    finally
    {
      ((k0)localObject2).w();
    }
  }
  
  void h(Drawable paramDrawable)
  {
    this.e = paramDrawable.getLevel();
  }
  
  public void i(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = a.b(this.a.getContext(), paramInt);
      if (localDrawable != null) {
        t.b(localDrawable);
      }
      this.a.setImageDrawable(localDrawable);
    }
    else
    {
      this.a.setImageDrawable(null);
    }
    c();
  }
  
  void j(ColorStateList paramColorStateList)
  {
    if (this.c == null) {
      this.c = new i0();
    }
    i0 locali0 = this.c;
    locali0.a = paramColorStateList;
    locali0.d = true;
    c();
  }
  
  void k(PorterDuff.Mode paramMode)
  {
    if (this.c == null) {
      this.c = new i0();
    }
    i0 locali0 = this.c;
    locali0.b = paramMode;
    locali0.c = true;
    c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.k
 * JD-Core Version:    0.7.0.1
 */