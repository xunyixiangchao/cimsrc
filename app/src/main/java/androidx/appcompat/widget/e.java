package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;
import androidx.core.widget.c;

class e
{
  private final CheckedTextView a;
  private ColorStateList b = null;
  private PorterDuff.Mode c = null;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
  e(CheckedTextView paramCheckedTextView)
  {
    this.a = paramCheckedTextView;
  }
  
  void a()
  {
    Drawable localDrawable = c.a(this.a);
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
      this.a.setCheckMarkDrawable(localDrawable);
    }
  }
  
  ColorStateList b()
  {
    return this.b;
  }
  
  PorterDuff.Mode c()
  {
    return this.c;
  }
  
  void d(AttributeSet paramAttributeSet, int paramInt)
  {
    localObject = this.a.getContext();
    int[] arrayOfInt = R.styleable.CheckedTextView;
    localObject = k0.v((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    CheckedTextView localCheckedTextView = this.a;
    x.o0(localCheckedTextView, localCheckedTextView.getContext(), arrayOfInt, paramAttributeSet, ((k0)localObject).r(), paramInt, 0);
    try
    {
      paramInt = R.styleable.CheckedTextView_checkMarkCompat;
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
      paramAttributeSet.setCheckMarkDrawable(c.a.b(paramAttributeSet.getContext(), paramInt));
      paramInt = 1;
    }
    catch (Resources.NotFoundException paramAttributeSet)
    {
      break label93;
    }
    paramInt = 0;
    if (paramInt == 0)
    {
      paramInt = R.styleable.CheckedTextView_android_checkMark;
      if (((k0)localObject).s(paramInt))
      {
        paramInt = ((k0)localObject).n(paramInt, 0);
        if (paramInt != 0)
        {
          paramAttributeSet = this.a;
          paramAttributeSet.setCheckMarkDrawable(c.a.b(paramAttributeSet.getContext(), paramInt));
        }
      }
    }
    paramInt = R.styleable.CheckedTextView_checkMarkTint;
    if (((k0)localObject).s(paramInt)) {
      c.b(this.a, ((k0)localObject).c(paramInt));
    }
    paramInt = R.styleable.CheckedTextView_checkMarkTintMode;
    if (((k0)localObject).s(paramInt)) {
      c.c(this.a, t.e(((k0)localObject).k(paramInt, -1), null));
    }
    ((k0)localObject).w();
  }
  
  void e()
  {
    if (this.f)
    {
      this.f = false;
      return;
    }
    this.f = true;
    a();
  }
  
  void f(ColorStateList paramColorStateList)
  {
    this.b = paramColorStateList;
    this.d = true;
    a();
  }
  
  void g(PorterDuff.Mode paramMode)
  {
    this.c = paramMode;
    this.e = true;
    a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.e
 * JD-Core Version:    0.7.0.1
 */