package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import androidx.appcompat.R.id;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;

public class ActionBarContainer
  extends FrameLayout
{
  private boolean a;
  private View b;
  private View c;
  private View d;
  Drawable e;
  Drawable f;
  Drawable g;
  boolean h;
  boolean i;
  private int j;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    x.u0(this, new b(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar);
    this.e = paramContext.getDrawable(R.styleable.ActionBar_background);
    this.f = paramContext.getDrawable(R.styleable.ActionBar_backgroundStacked);
    this.j = paramContext.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
    int k = getId();
    int m = R.id.split_action_bar;
    boolean bool = true;
    if (k == m)
    {
      this.h = true;
      this.g = paramContext.getDrawable(R.styleable.ActionBar_backgroundSplit);
    }
    paramContext.recycle();
    if (this.h ? this.g == null : (this.e != null) || (this.f != null)) {
      bool = false;
    }
    setWillNotDraw(bool);
  }
  
  private int a(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    return paramView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
  }
  
  private boolean b(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.e;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.e.setState(getDrawableState());
    }
    localDrawable = this.f;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.f.setState(getDrawableState());
    }
    localDrawable = this.g;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.g.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.b;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.f;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.g;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = findViewById(R.id.action_bar);
    this.d = findViewById(R.id.action_context_bar);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.a) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.b;
    paramInt4 = 1;
    int k = 0;
    paramInt2 = 0;
    if ((localView != null) && (localView.getVisibility() != 8)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    Object localObject;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int m = getMeasuredHeight();
      localObject = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int i1 = ((FrameLayout.LayoutParams)localObject).bottomMargin;
      localView.layout(paramInt1, m - n - i1, paramInt3, m - i1);
    }
    if (this.h)
    {
      localObject = this.g;
      paramInt1 = paramInt2;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        paramInt1 = paramInt4;
        break label355;
      }
    }
    for (;;)
    {
      break;
      paramInt2 = k;
      if (this.e != null)
      {
        Drawable localDrawable;
        if (this.c.getVisibility() == 0)
        {
          localDrawable = this.e;
          paramInt2 = this.c.getLeft();
          paramInt3 = this.c.getTop();
          paramInt1 = this.c.getRight();
        }
        for (localObject = this.c;; localObject = this.d)
        {
          localDrawable.setBounds(paramInt2, paramInt3, paramInt1, ((View)localObject).getBottom());
          break label301;
          localObject = this.d;
          if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
            break;
          }
          localDrawable = this.e;
          paramInt2 = this.d.getLeft();
          paramInt3 = this.d.getTop();
          paramInt1 = this.d.getRight();
        }
        this.e.setBounds(0, 0, 0, 0);
        label301:
        paramInt2 = 1;
      }
      this.i = paramBoolean;
      paramInt1 = paramInt2;
      if (paramBoolean)
      {
        localObject = this.f;
        paramInt1 = paramInt2;
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = paramInt4;
        }
      }
    }
    label355:
    if (paramInt1 != 0) {
      invalidate();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k = paramInt2;
    if (this.c == null)
    {
      k = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == -2147483648)
      {
        int m = this.j;
        k = paramInt2;
        if (m >= 0) {
          k = View.MeasureSpec.makeMeasureSpec(Math.min(m, View.MeasureSpec.getSize(paramInt2)), -2147483648);
        }
      }
    }
    super.onMeasure(paramInt1, k);
    if (this.c == null) {
      return;
    }
    paramInt2 = View.MeasureSpec.getMode(k);
    View localView = this.b;
    if ((localView != null) && (localView.getVisibility() != 8) && (paramInt2 != 1073741824))
    {
      if (!b(this.c)) {}
      for (localView = this.c;; localView = this.d)
      {
        paramInt1 = a(localView);
        break label143;
        if (b(this.d)) {
          break;
        }
      }
      paramInt1 = 0;
      label143:
      if (paramInt2 == -2147483648) {
        paramInt2 = View.MeasureSpec.getSize(k);
      } else {
        paramInt2 = 2147483647;
      }
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + a(this.b), paramInt2));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(this.e);
    }
    this.e = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      paramDrawable = this.c;
      if (paramDrawable != null) {
        this.e.setBounds(paramDrawable.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
      }
    }
    boolean bool2 = this.h;
    boolean bool1 = true;
    if (bool2 ? this.g == null : (this.e != null) || (this.f != null)) {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    invalidate();
    invalidateOutline();
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = this.g;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(this.g);
    }
    this.g = paramDrawable;
    boolean bool2 = false;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.h)
      {
        paramDrawable = this.g;
        if (paramDrawable != null) {
          paramDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
      }
    }
    boolean bool1;
    if (this.h)
    {
      bool1 = bool2;
      if (this.g != null) {}
    }
    else
    {
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (this.e != null) {
          break;
        }
        bool1 = bool2;
      } while (this.f == null);
    }
    setWillNotDraw(bool1);
    invalidate();
    invalidateOutline();
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = this.f;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(this.f);
    }
    this.f = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.i)
      {
        paramDrawable = this.f;
        if (paramDrawable != null) {
          paramDrawable.setBounds(this.b.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom());
        }
      }
    }
    boolean bool2 = this.h;
    boolean bool1 = true;
    if (bool2 ? this.g == null : (this.e != null) || (this.f != null)) {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    invalidate();
    invalidateOutline();
  }
  
  public void setTabContainer(d0 paramd0)
  {
    Object localObject = this.b;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.b = paramd0;
    if (paramd0 != null)
    {
      addView(paramd0);
      localObject = paramd0.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -1;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      paramd0.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    this.a = paramBoolean;
    int k;
    if (paramBoolean) {
      k = 393216;
    } else {
      k = 262144;
    }
    setDescendantFocusability(k);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
    localDrawable = this.f;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
    localDrawable = this.g;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    if (paramInt != 0) {
      return super.startActionModeForChild(paramView, paramCallback, paramInt);
    }
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable == this.e) && (!this.h)) || ((paramDrawable == this.f) && (this.i)) || ((paramDrawable == this.g) && (this.h)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */