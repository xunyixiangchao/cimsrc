package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import androidx.core.view.c0;
import androidx.core.view.d0;
import androidx.core.view.x;

abstract class a
  extends ViewGroup
{
  protected final a a = new a();
  protected final Context b;
  protected ActionMenuView c;
  protected ActionMenuPresenter d;
  protected int e;
  protected c0 f;
  private boolean g;
  private boolean h;
  
  a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.b = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.b = paramContext;
  }
  
  protected static int d(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
  }
  
  protected int c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
  }
  
  protected int e(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 += (paramInt3 - j) / 2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
    } else {
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
    }
    paramInt1 = i;
    if (paramBoolean) {
      paramInt1 = -i;
    }
    return paramInt1;
  }
  
  public c0 f(int paramInt, long paramLong)
  {
    c0 localc0 = this.f;
    if (localc0 != null) {
      localc0.b();
    }
    if (paramInt == 0) {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
    }
    for (localc0 = x.e(this).a(1.0F);; localc0 = x.e(this).a(0.0F))
    {
      localc0.d(paramLong);
      localc0.f(this.a.d(localc0, paramInt));
      return localc0;
    }
  }
  
  public int getAnimatedVisibility()
  {
    if (this.f != null) {
      return this.a.b;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.e;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Object localObject = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(((TypedArray)localObject).getLayoutDimension(R.styleable.ActionBar_height, 0));
    ((TypedArray)localObject).recycle();
    localObject = this.d;
    if (localObject != null) {
      ((ActionMenuPresenter)localObject).I(paramConfiguration);
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.h = false;
    }
    if (!this.h)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.h = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.h = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.g = false;
    }
    if (!this.g)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.g = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.g = false;
    }
    return true;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.e = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      c0 localc0 = this.f;
      if (localc0 != null) {
        localc0.b();
      }
      super.setVisibility(paramInt);
    }
  }
  
  protected class a
    implements d0
  {
    private boolean a = false;
    int b;
    
    protected a() {}
    
    public void a(View paramView)
    {
      this.a = true;
    }
    
    public void b(View paramView)
    {
      if (this.a) {
        return;
      }
      paramView = a.this;
      paramView.f = null;
      a.b(paramView, this.b);
    }
    
    public void c(View paramView)
    {
      a.a(a.this, 0);
      this.a = false;
    }
    
    public a d(c0 paramc0, int paramInt)
    {
      a.this.f = paramc0;
      this.b = paramInt;
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.a
 * JD-Core Version:    0.7.0.1
 */