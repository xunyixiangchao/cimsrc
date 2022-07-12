package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;
import androidx.core.widget.d;

class f
{
  private final CompoundButton a;
  private ColorStateList b = null;
  private PorterDuff.Mode c = null;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
  f(CompoundButton paramCompoundButton)
  {
    this.a = paramCompoundButton;
  }
  
  void a()
  {
    Drawable localDrawable = d.a(this.a);
    if ((localDrawable != null) && ((this.d) || (this.e)))
    {
      localDrawable = r0.a.r(localDrawable).mutate();
      if (this.d) {
        r0.a.o(localDrawable, this.b);
      }
      if (this.e) {
        r0.a.p(localDrawable, this.c);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.a.getDrawableState());
      }
      this.a.setButtonDrawable(localDrawable);
    }
  }
  
  int b(int paramInt)
  {
    return paramInt;
  }
  
  ColorStateList c()
  {
    return this.b;
  }
  
  PorterDuff.Mode d()
  {
    return this.c;
  }
  
  void e(AttributeSet paramAttributeSet, int paramInt)
  {
    localObject = this.a.getContext();
    int[] arrayOfInt = R.styleable.CompoundButton;
    localObject = k0.v((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    CompoundButton localCompoundButton = this.a;
    x.o0(localCompoundButton, localCompoundButton.getContext(), arrayOfInt, paramAttributeSet, ((k0)localObject).r(), paramInt, 0);
    try
    {
      paramInt = R.styleable.CompoundButton_buttonCompat;
      if (((k0)localObject).s(paramInt))
      {
        paramInt = ((k0)localObject).n(paramInt, 0);
        if (paramInt == 0) {}
      }
    }
    finally
    {
      label93:
      ((k0)localObject).w();
    }
    try
    {
      paramAttributeSet = this.a;
      paramAttributeSet.setButtonDrawable(c.a.b(paramAttributeSet.getContext(), paramInt));
      paramInt = 1;
    }
    catch (Resources.NotFoundException paramAttributeSet)
    {
      break label93;
    }
    paramInt = 0;
    if (paramInt == 0)
    {
      paramInt = R.styleable.CompoundButton_android_button;
      if (((k0)localObject).s(paramInt))
      {
        paramInt = ((k0)localObject).n(paramInt, 0);
        if (paramInt != 0)
        {
          paramAttributeSet = this.a;
          paramAttributeSet.setButtonDrawable(c.a.b(paramAttributeSet.getContext(), paramInt));
        }
      }
    }
    paramInt = R.styleable.CompoundButton_buttonTint;
    if (((k0)localObject).s(paramInt)) {
      d.c(this.a, ((k0)localObject).c(paramInt));
    }
    paramInt = R.styleable.CompoundButton_buttonTintMode;
    if (((k0)localObject).s(paramInt)) {
      d.d(this.a, t.e(((k0)localObject).k(paramInt, -1), null));
    }
    ((k0)localObject).w();
  }
  
  void f()
  {
    if (this.f)
    {
      this.f = false;
      return;
    }
    this.f = true;
    a();
  }
  
  void g(ColorStateList paramColorStateList)
  {
    this.b = paramColorStateList;
    this.d = true;
    a();
  }
  
  void h(PorterDuff.Mode paramMode)
  {
    this.c = paramMode;
    this.e = true;
    a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.f
 * JD-Core Version:    0.7.0.1
 */