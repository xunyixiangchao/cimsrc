package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import java.util.Arrays;

public abstract class a<S extends b>
  extends ProgressBar
{
  static final int o = R.style.Widget_MaterialComponents_ProgressIndicator;
  S a;
  private int b;
  private boolean c;
  private boolean d;
  private final int e;
  private final int f;
  private long g = -1L;
  n7.a h;
  private boolean i = false;
  private int j = 4;
  private final Runnable k = new a();
  private final Runnable l = new b();
  private final androidx.vectordrawable.graphics.drawable.b m = new c();
  private final androidx.vectordrawable.graphics.drawable.b n = new d();
  
  protected a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt1, o), paramAttributeSet, paramInt1);
    paramContext = getContext();
    this.a = i(paramContext, paramAttributeSet);
    paramContext = p.h(paramContext, paramAttributeSet, R.styleable.BaseProgressIndicator, paramInt1, paramInt2, new int[0]);
    this.e = paramContext.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
    this.f = Math.min(paramContext.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
    paramContext.recycle();
    this.h = new n7.a();
    this.d = true;
  }
  
  private g<S> getCurrentDrawingDelegate()
  {
    if (isIndeterminate())
    {
      if (getIndeterminateDrawable() == null) {
        return null;
      }
      return getIndeterminateDrawable().v();
    }
    if (getProgressDrawable() == null) {
      return null;
    }
    return getProgressDrawable().w();
  }
  
  private void j()
  {
    ((f)getCurrentDrawable()).p(false, false, true);
    if (m()) {
      setVisibility(4);
    }
  }
  
  private void k()
  {
    if (this.f > 0) {
      this.g = SystemClock.uptimeMillis();
    }
    setVisibility(0);
  }
  
  private boolean m()
  {
    return ((getProgressDrawable() == null) || (!getProgressDrawable().isVisible())) && ((getIndeterminateDrawable() == null) || (!getIndeterminateDrawable().isVisible()));
  }
  
  private void n()
  {
    if ((getProgressDrawable() != null) && (getIndeterminateDrawable() != null)) {
      getIndeterminateDrawable().u().d(this.m);
    }
    if (getProgressDrawable() != null) {
      getProgressDrawable().l(this.n);
    }
    if (getIndeterminateDrawable() != null) {
      getIndeterminateDrawable().l(this.n);
    }
  }
  
  private void p()
  {
    if (getIndeterminateDrawable() != null)
    {
      getIndeterminateDrawable().r(this.n);
      getIndeterminateDrawable().u().h();
    }
    if (getProgressDrawable() != null) {
      getProgressDrawable().r(this.n);
    }
  }
  
  public Drawable getCurrentDrawable()
  {
    if (isIndeterminate()) {
      return getIndeterminateDrawable();
    }
    return getProgressDrawable();
  }
  
  public int getHideAnimationBehavior()
  {
    return this.a.f;
  }
  
  public i<S> getIndeterminateDrawable()
  {
    return (i)super.getIndeterminateDrawable();
  }
  
  public int[] getIndicatorColor()
  {
    return this.a.c;
  }
  
  public e<S> getProgressDrawable()
  {
    return (e)super.getProgressDrawable();
  }
  
  public int getShowAnimationBehavior()
  {
    return this.a.e;
  }
  
  public int getTrackColor()
  {
    return this.a.d;
  }
  
  public int getTrackCornerRadius()
  {
    return this.a.b;
  }
  
  public int getTrackThickness()
  {
    return this.a.a;
  }
  
  protected void h(boolean paramBoolean)
  {
    if (!this.d) {
      return;
    }
    ((f)getCurrentDrawable()).p(q(), false, paramBoolean);
  }
  
  abstract S i(Context paramContext, AttributeSet paramAttributeSet);
  
  public void invalidate()
  {
    super.invalidate();
    if (getCurrentDrawable() != null) {
      getCurrentDrawable().invalidateSelf();
    }
  }
  
  boolean l()
  {
    for (Object localObject = this;; localObject = (View)localObject)
    {
      int i1 = ((View)localObject).getVisibility();
      boolean bool = false;
      if (i1 != 0) {
        return false;
      }
      localObject = ((View)localObject).getParent();
      if (localObject == null)
      {
        if (getWindowVisibility() == 0) {
          bool = true;
        }
        return bool;
      }
      if (!(localObject instanceof View)) {
        return true;
      }
    }
  }
  
  public void o(int paramInt, boolean paramBoolean)
  {
    if (isIndeterminate())
    {
      if (getProgressDrawable() != null)
      {
        this.b = paramInt;
        this.c = paramBoolean;
        this.i = true;
        if ((getIndeterminateDrawable().isVisible()) && (this.h.a(getContext().getContentResolver()) != 0.0F))
        {
          getIndeterminateDrawable().u().f();
          return;
        }
        this.m.a(getIndeterminateDrawable());
      }
    }
    else
    {
      super.setProgress(paramInt);
      if ((getProgressDrawable() != null) && (!paramBoolean)) {
        getProgressDrawable().jumpToCurrentState();
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    n();
    if (q()) {
      k();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.l);
    removeCallbacks(this.k);
    ((f)getCurrentDrawable()).h();
    p();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      int i1 = paramCanvas.save();
      if ((getPaddingLeft() != 0) || (getPaddingTop() != 0)) {
        paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      }
      if ((getPaddingRight() != 0) || (getPaddingBottom() != 0)) {
        paramCanvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
      }
      getCurrentDrawable().draw(paramCanvas);
      paramCanvas.restoreToCount(i1);
      return;
    }
    finally {}
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      g localg = getCurrentDrawingDelegate();
      if (localg == null) {
        return;
      }
      paramInt1 = localg.e();
      paramInt2 = localg.d();
      if (paramInt1 < 0) {
        paramInt1 = getMeasuredWidth();
      } else {
        paramInt1 = paramInt1 + getPaddingLeft() + getPaddingRight();
      }
      if (paramInt2 < 0) {
        paramInt2 = getMeasuredHeight();
      } else {
        paramInt2 = paramInt2 + getPaddingTop() + getPaddingBottom();
      }
      setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    h(bool);
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    h(false);
  }
  
  boolean q()
  {
    return (x.T(this)) && (getWindowVisibility() == 0) && (l());
  }
  
  public void setAnimatorDurationScaleProvider(n7.a parama)
  {
    this.h = parama;
    if (getProgressDrawable() != null) {
      getProgressDrawable().c = parama;
    }
    if (getIndeterminateDrawable() != null) {
      getIndeterminateDrawable().c = parama;
    }
  }
  
  public void setHideAnimationBehavior(int paramInt)
  {
    this.a.f = paramInt;
    invalidate();
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    try
    {
      boolean bool = isIndeterminate();
      if (paramBoolean == bool) {
        return;
      }
      f localf = (f)getCurrentDrawable();
      if (localf != null) {
        localf.h();
      }
      super.setIndeterminate(paramBoolean);
      localf = (f)getCurrentDrawable();
      if (localf != null) {
        localf.p(q(), false, false);
      }
      if (((localf instanceof i)) && (q())) {
        ((i)localf).u().g();
      }
      this.i = false;
      return;
    }
    finally {}
  }
  
  public void setIndeterminateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      super.setIndeterminateDrawable(null);
      return;
    }
    if ((paramDrawable instanceof i))
    {
      ((f)paramDrawable).h();
      super.setIndeterminateDrawable(paramDrawable);
      return;
    }
    throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
  }
  
  public void setIndicatorColor(int... paramVarArgs)
  {
    int[] arrayOfInt = paramVarArgs;
    if (paramVarArgs.length == 0)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = g7.a.b(getContext(), R.attr.colorPrimary, -1);
    }
    if (!Arrays.equals(getIndicatorColor(), arrayOfInt))
    {
      this.a.c = arrayOfInt;
      getIndeterminateDrawable().u().c();
      invalidate();
    }
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      boolean bool = isIndeterminate();
      if (bool) {
        return;
      }
      o(paramInt, false);
      return;
    }
    finally {}
  }
  
  public void setProgressDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      super.setProgressDrawable(null);
      return;
    }
    if ((paramDrawable instanceof e))
    {
      paramDrawable = (e)paramDrawable;
      paramDrawable.h();
      super.setProgressDrawable(paramDrawable);
      paramDrawable.A(getProgress() / getMax());
      return;
    }
    throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
  }
  
  public void setShowAnimationBehavior(int paramInt)
  {
    this.a.e = paramInt;
    invalidate();
  }
  
  public void setTrackColor(int paramInt)
  {
    b localb = this.a;
    if (localb.d != paramInt)
    {
      localb.d = paramInt;
      invalidate();
    }
  }
  
  public void setTrackCornerRadius(int paramInt)
  {
    b localb = this.a;
    if (localb.b != paramInt) {
      localb.b = Math.min(paramInt, localb.a / 2);
    }
  }
  
  public void setTrackThickness(int paramInt)
  {
    b localb = this.a;
    if (localb.a != paramInt)
    {
      localb.a = paramInt;
      requestLayout();
    }
  }
  
  public void setVisibilityAfterHide(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 4) && (paramInt != 8)) {
      throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }
    this.j = paramInt;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      a.a(a.this);
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      a.b(a.this);
      a.c(a.this, -1L);
    }
  }
  
  class c
    extends androidx.vectordrawable.graphics.drawable.b
  {
    c() {}
    
    public void a(Drawable paramDrawable)
    {
      a.this.setIndeterminate(false);
      paramDrawable = a.this;
      paramDrawable.o(a.d(paramDrawable), a.e(a.this));
    }
  }
  
  class d
    extends androidx.vectordrawable.graphics.drawable.b
  {
    d() {}
    
    public void a(Drawable paramDrawable)
    {
      super.a(paramDrawable);
      if (!a.f(a.this))
      {
        paramDrawable = a.this;
        paramDrawable.setVisibility(a.g(paramDrawable));
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.a
 * JD-Core Version:    0.7.0.1
 */