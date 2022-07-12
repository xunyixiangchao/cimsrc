package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R.attr;
import androidx.core.view.c0;
import androidx.core.widget.i;
import d.c;
import java.lang.reflect.Field;

class u
  extends ListView
{
  private final Rect a = new Rect();
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f;
  private Field g;
  private a h;
  private boolean i;
  private boolean j;
  private boolean k;
  private c0 l;
  private i m;
  b n;
  
  u(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.dropDownListViewStyle);
    this.j = paramBoolean;
    setCacheColorHint(0);
    try
    {
      paramContext = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.g = paramContext;
      paramContext.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a()
  {
    this.k = false;
    setPressed(false);
    drawableStateChanged();
    Object localObject = getChildAt(this.f - getFirstVisiblePosition());
    if (localObject != null) {
      ((View)localObject).setPressed(false);
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((c0)localObject).b();
      this.l = null;
    }
  }
  
  private void b(View paramView, int paramInt)
  {
    performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt));
  }
  
  private void c(Canvas paramCanvas)
  {
    if (!this.a.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.a);
        localDrawable.draw(paramCanvas);
      }
    }
  }
  
  private void f(int paramInt, View paramView)
  {
    Rect localRect = this.a;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    localRect.left -= this.b;
    localRect.top -= this.c;
    localRect.right += this.d;
    localRect.bottom += this.e;
    for (;;)
    {
      try
      {
        bool = this.g.getBoolean(this);
        if (paramView.isEnabled() != bool)
        {
          paramView = this.g;
          if (bool) {
            break label143;
          }
          bool = true;
          paramView.set(this, Boolean.valueOf(bool));
          if (paramInt != -1)
          {
            refreshDrawableState();
            return;
          }
        }
      }
      catch (IllegalAccessException paramView)
      {
        paramView.printStackTrace();
      }
      return;
      label143:
      boolean bool = false;
    }
  }
  
  private void g(int paramInt, View paramView)
  {
    Drawable localDrawable = getSelector();
    boolean bool = true;
    int i1;
    if ((localDrawable != null) && (paramInt != -1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      localDrawable.setVisible(false, false);
    }
    f(paramInt, paramView);
    if (i1 != 0)
    {
      paramView = this.a;
      float f1 = paramView.exactCenterX();
      float f2 = paramView.exactCenterY();
      if (getVisibility() != 0) {
        bool = false;
      }
      localDrawable.setVisible(bool, false);
      r0.a.k(localDrawable, f1, f2);
    }
  }
  
  private void h(int paramInt, View paramView, float paramFloat1, float paramFloat2)
  {
    g(paramInt, paramView);
    paramView = getSelector();
    if ((paramView != null) && (paramInt != -1)) {
      r0.a.k(paramView, paramFloat1, paramFloat2);
    }
  }
  
  private void i(View paramView, int paramInt, float paramFloat1, float paramFloat2)
  {
    this.k = true;
    drawableHotspotChanged(paramFloat1, paramFloat2);
    if (!isPressed()) {
      setPressed(true);
    }
    layoutChildren();
    int i1 = this.f;
    if (i1 != -1)
    {
      View localView = getChildAt(i1 - getFirstVisiblePosition());
      if ((localView != null) && (localView != paramView) && (localView.isPressed())) {
        localView.setPressed(false);
      }
    }
    this.f = paramInt;
    paramView.drawableHotspotChanged(paramFloat1 - paramView.getLeft(), paramFloat2 - paramView.getTop());
    if (!paramView.isPressed()) {
      paramView.setPressed(true);
    }
    h(paramInt, paramView, paramFloat1, paramFloat2);
    setSelectorEnabled(false);
    refreshDrawableState();
  }
  
  private boolean j()
  {
    return this.k;
  }
  
  private void k()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (j()) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  private void setSelectorEnabled(boolean paramBoolean)
  {
    a locala = this.h;
    if (locala != null) {
      locala.c(paramBoolean);
    }
  }
  
  public int d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt2 = getListPaddingTop();
    paramInt3 = getListPaddingBottom();
    int i2 = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    paramInt3 = paramInt2 + paramInt3;
    if (localListAdapter == null) {
      return paramInt3;
    }
    if ((i2 <= 0) || (localObject == null)) {
      i2 = 0;
    }
    int i6 = localListAdapter.getCount();
    int i3 = 0;
    int i1 = i3;
    paramInt2 = i1;
    localObject = null;
    int i4 = i1;
    i1 = i3;
    while (i1 < i6)
    {
      int i5 = localListAdapter.getItemViewType(i1);
      i3 = i4;
      if (i5 != i4)
      {
        localObject = null;
        i3 = i5;
      }
      View localView = localListAdapter.getView(i1, (View)localObject, this);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject = generateDefaultLayoutParams();
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      i4 = ((ViewGroup.LayoutParams)localObject).height;
      if (i4 > 0) {
        i4 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
      } else {
        i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
      localView.measure(paramInt1, i4);
      localView.forceLayout();
      i4 = paramInt3;
      if (i1 > 0) {
        i4 = paramInt3 + i2;
      }
      paramInt3 = i4 + localView.getMeasuredHeight();
      if (paramInt3 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 >= 0)
        {
          paramInt1 = paramInt4;
          if (i1 > paramInt5)
          {
            paramInt1 = paramInt4;
            if (paramInt2 > 0)
            {
              paramInt1 = paramInt4;
              if (paramInt3 != paramInt4) {
                paramInt1 = paramInt2;
              }
            }
          }
        }
        return paramInt1;
      }
      i5 = paramInt2;
      if (paramInt5 >= 0)
      {
        i5 = paramInt2;
        if (i1 >= paramInt5) {
          i5 = paramInt3;
        }
      }
      i1 += 1;
      i4 = i3;
      localObject = localView;
      paramInt2 = i5;
    }
    return paramInt3;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    c(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.n != null) {
      return;
    }
    super.drawableStateChanged();
    setSelectorEnabled(true);
    k();
  }
  
  public boolean e(MotionEvent paramMotionEvent, int paramInt)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 1) {
      if (i1 != 2) {
        if (i1 == 3) {}
      }
    }
    boolean bool2;
    boolean bool1;
    for (;;)
    {
      bool2 = false;
      bool1 = true;
      break;
      label48:
      do
      {
        bool2 = false;
        bool1 = bool2;
        break;
        bool1 = true;
        break label48;
        bool1 = false;
        i2 = paramMotionEvent.findPointerIndex(paramInt);
      } while (i2 < 0);
      paramInt = (int)paramMotionEvent.getX(i2);
      int i2 = (int)paramMotionEvent.getY(i2);
      int i3 = pointToPosition(paramInt, i2);
      if (i3 == -1)
      {
        bool2 = true;
        break;
      }
      View localView = getChildAt(i3 - getFirstVisiblePosition());
      i(localView, i3, paramInt, i2);
      if (i1 == 1) {
        b(localView, i3);
      }
    }
    if ((!bool1) || (bool2)) {
      a();
    }
    if (bool1)
    {
      if (this.m == null) {
        this.m = new i(this);
      }
      this.m.m(true);
      this.m.onTouch(this, paramMotionEvent);
      return bool1;
    }
    paramMotionEvent = this.m;
    if (paramMotionEvent != null) {
      paramMotionEvent.m(false);
    }
    return bool1;
  }
  
  public boolean hasFocus()
  {
    return (this.j) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (this.j) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (this.j) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    return ((this.j) && (this.i)) || (super.isInTouchMode());
  }
  
  protected void onDetachedFromWindow()
  {
    this.n = null;
    super.onDetachedFromWindow();
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return super.onHoverEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getActionMasked();
    if ((i1 == 10) && (this.n == null))
    {
      b localb = new b();
      this.n = localb;
      localb.b();
    }
    boolean bool = super.onHoverEvent(paramMotionEvent);
    if ((i1 != 9) && (i1 != 7))
    {
      setSelection(-1);
      return bool;
    }
    i1 = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((i1 != -1) && (i1 != getSelectedItemPosition()))
    {
      paramMotionEvent = getChildAt(i1 - getFirstVisiblePosition());
      if (paramMotionEvent.isEnabled()) {
        setSelectionFromTop(i1, paramMotionEvent.getTop() - getTop());
      }
      k();
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.f = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    b localb = this.n;
    if (localb != null) {
      localb.a();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  void setListSelectionHidden(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      localObject = new a(paramDrawable);
    } else {
      localObject = null;
    }
    this.h = ((a)localObject);
    super.setSelector((Drawable)localObject);
    Object localObject = new Rect();
    if (paramDrawable != null) {
      paramDrawable.getPadding((Rect)localObject);
    }
    this.b = ((Rect)localObject).left;
    this.c = ((Rect)localObject).top;
    this.d = ((Rect)localObject).right;
    this.e = ((Rect)localObject).bottom;
  }
  
  private static class a
    extends c
  {
    private boolean b = true;
    
    a(Drawable paramDrawable)
    {
      super();
    }
    
    void c(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public void draw(Canvas paramCanvas)
    {
      if (this.b) {
        super.draw(paramCanvas);
      }
    }
    
    public void setHotspot(float paramFloat1, float paramFloat2)
    {
      if (this.b) {
        super.setHotspot(paramFloat1, paramFloat2);
      }
    }
    
    public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (this.b) {
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public boolean setState(int[] paramArrayOfInt)
    {
      if (this.b) {
        return super.setState(paramArrayOfInt);
      }
      return false;
    }
    
    public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (this.b) {
        return super.setVisible(paramBoolean1, paramBoolean2);
      }
      return false;
    }
  }
  
  private class b
    implements Runnable
  {
    b() {}
    
    public void a()
    {
      u localu = u.this;
      localu.n = null;
      localu.removeCallbacks(this);
    }
    
    public void b()
    {
      u.this.post(this);
    }
    
    public void run()
    {
      u localu = u.this;
      localu.n = null;
      localu.drawableStateChanged();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.u
 * JD-Core Version:    0.7.0.1
 */