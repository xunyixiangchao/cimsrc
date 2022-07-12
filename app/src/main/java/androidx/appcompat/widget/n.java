package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;
import r0.a;

class n
  extends l
{
  private final SeekBar d;
  private Drawable e;
  private ColorStateList f = null;
  private PorterDuff.Mode g = null;
  private boolean h = false;
  private boolean i = false;
  
  n(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.d = paramSeekBar;
  }
  
  private void f()
  {
    Drawable localDrawable = this.e;
    if ((localDrawable != null) && ((this.h) || (this.i)))
    {
      localDrawable = a.r(localDrawable.mutate());
      this.e = localDrawable;
      if (this.h) {
        a.o(localDrawable, this.f);
      }
      if (this.i) {
        a.p(this.e, this.g);
      }
      if (this.e.isStateful()) {
        this.e.setState(this.d.getDrawableState());
      }
    }
  }
  
  void c(AttributeSet paramAttributeSet, int paramInt)
  {
    super.c(paramAttributeSet, paramInt);
    Object localObject = this.d.getContext();
    int[] arrayOfInt = R.styleable.AppCompatSeekBar;
    localObject = k0.v((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    SeekBar localSeekBar = this.d;
    x.o0(localSeekBar, localSeekBar.getContext(), arrayOfInt, paramAttributeSet, ((k0)localObject).r(), paramInt, 0);
    paramAttributeSet = ((k0)localObject).h(R.styleable.AppCompatSeekBar_android_thumb);
    if (paramAttributeSet != null) {
      this.d.setThumb(paramAttributeSet);
    }
    j(((k0)localObject).g(R.styleable.AppCompatSeekBar_tickMark));
    paramInt = R.styleable.AppCompatSeekBar_tickMarkTintMode;
    if (((k0)localObject).s(paramInt))
    {
      this.g = t.e(((k0)localObject).k(paramInt, -1), this.g);
      this.i = true;
    }
    paramInt = R.styleable.AppCompatSeekBar_tickMarkTint;
    if (((k0)localObject).s(paramInt))
    {
      this.f = ((k0)localObject).c(paramInt);
      this.h = true;
    }
    ((k0)localObject).w();
    f();
  }
  
  void g(Canvas paramCanvas)
  {
    if (this.e != null)
    {
      int m = this.d.getMax();
      int k = 1;
      if (m > 1)
      {
        int j = this.e.getIntrinsicWidth();
        int n = this.e.getIntrinsicHeight();
        if (j >= 0) {
          j /= 2;
        } else {
          j = 1;
        }
        if (n >= 0) {
          k = n / 2;
        }
        this.e.setBounds(-j, -k, j, k);
        float f1 = (this.d.getWidth() - this.d.getPaddingLeft() - this.d.getPaddingRight()) / m;
        k = paramCanvas.save();
        paramCanvas.translate(this.d.getPaddingLeft(), this.d.getHeight() / 2);
        j = 0;
        while (j <= m)
        {
          this.e.draw(paramCanvas);
          paramCanvas.translate(f1, 0.0F);
          j += 1;
        }
        paramCanvas.restoreToCount(k);
      }
    }
  }
  
  void h()
  {
    Drawable localDrawable = this.e;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(this.d.getDrawableState()))) {
      this.d.invalidateDrawable(localDrawable);
    }
  }
  
  void i()
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  void j(Drawable paramDrawable)
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.e = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this.d);
      a.m(paramDrawable, x.B(this.d));
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(this.d.getDrawableState());
      }
      f();
    }
    this.d.invalidate();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.n
 * JD-Core Version:    0.7.0.1
 */