package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.x;
import com.google.android.material.R.id;
import com.google.android.material.internal.t;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

final class MaterialCalendarGridView
  extends GridView
{
  private final Calendar a = p.q();
  private final boolean b;
  
  public MaterialCalendarGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaterialCalendarGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (g.O(getContext()))
    {
      setNextFocusLeftId(R.id.cancel_button);
      setNextFocusRightId(R.id.confirm_button);
    }
    this.b = g.P(getContext());
    x.q0(this, new a());
  }
  
  private void a(int paramInt, Rect paramRect)
  {
    if (paramInt == 33) {}
    for (paramInt = b().i();; paramInt = b().b())
    {
      setSelection(paramInt);
      return;
      if (paramInt != 130) {
        break;
      }
    }
    super.onFocusChanged(true, paramInt, paramRect);
  }
  
  private View c(int paramInt)
  {
    return getChildAt(paramInt - getFirstVisiblePosition());
  }
  
  private static int d(View paramView)
  {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private static boolean e(Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramLong1 != null)
    {
      bool1 = bool2;
      if (paramLong2 != null)
      {
        bool1 = bool2;
        if (paramLong3 != null)
        {
          if (paramLong4 == null) {
            return true;
          }
          bool1 = bool2;
          if (paramLong3.longValue() <= paramLong2.longValue())
          {
            if (paramLong4.longValue() < paramLong1.longValue()) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public j b()
  {
    return (j)super.getAdapter();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b().notifyDataSetChanged();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    j localj = b();
    Object localObject1 = localj.b;
    b localb = localj.d;
    int m = Math.max(localj.b(), getFirstVisiblePosition());
    int k = Math.min(localj.i(), getLastVisiblePosition());
    Long localLong1 = localj.c(m);
    Long localLong2 = localj.c(k);
    localObject1 = ((DateSelector)localObject1).d().iterator();
    for (;;)
    {
      Object localObject2 = this;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      Object localObject3 = (x0.d)((Iterator)localObject1).next();
      Object localObject4 = ((x0.d)localObject3).a;
      if (localObject4 != null) {
        if (((x0.d)localObject3).b != null)
        {
          long l1 = ((Long)localObject4).longValue();
          long l2 = ((Long)((x0.d)localObject3).b).longValue();
          if (!e(localLong1, localLong2, Long.valueOf(l1), Long.valueOf(l2)))
          {
            boolean bool = t.i(this);
            int i;
            int i2;
            if (l1 < localLong1.longValue())
            {
              if (localj.f(m))
              {
                i = 0;
              }
              else
              {
                localObject3 = ((MaterialCalendarGridView)localObject2).c(m - 1);
                if (!bool) {
                  i = ((View)localObject3).getRight();
                } else {
                  i = ((View)localObject3).getLeft();
                }
              }
              i2 = m;
            }
            else
            {
              ((MaterialCalendarGridView)localObject2).a.setTimeInMillis(l1);
              i2 = localj.a(((MaterialCalendarGridView)localObject2).a.get(5));
              i = d(((MaterialCalendarGridView)localObject2).c(i2));
            }
            int j;
            int i3;
            if (l2 > localLong2.longValue())
            {
              if (localj.g(k))
              {
                j = getWidth();
              }
              else
              {
                localObject2 = ((MaterialCalendarGridView)localObject2).c(k);
                if (!bool) {
                  j = ((View)localObject2).getRight();
                } else {
                  j = ((View)localObject2).getLeft();
                }
              }
              i3 = k;
            }
            else
            {
              ((MaterialCalendarGridView)localObject2).a.setTimeInMillis(l2);
              i3 = localj.a(((MaterialCalendarGridView)localObject2).a.get(5));
              j = d(((MaterialCalendarGridView)localObject2).c(i3));
            }
            int i4 = (int)localj.getItemId(i2);
            int i6 = (int)localj.getItemId(i3);
            while (i4 <= i6)
            {
              int i1 = getNumColumns() * i4;
              int i5 = i1 + getNumColumns() - 1;
              localObject2 = c(i1);
              int i7 = ((View)localObject2).getTop();
              int i8 = localb.a.c();
              int i9 = ((View)localObject2).getBottom();
              int i10 = localb.a.b();
              int n;
              if (!bool)
              {
                if (i1 > i2) {
                  n = 0;
                } else {
                  n = i;
                }
                if (i3 > i5)
                {
                  i5 = getWidth();
                  i1 = n;
                  n = i5;
                }
                else
                {
                  i5 = j;
                  i1 = n;
                  n = i5;
                }
              }
              else
              {
                if (i3 > i5) {
                  n = 0;
                } else {
                  n = j;
                }
                if (i1 > i2) {
                  i1 = getWidth();
                } else {
                  i1 = i;
                }
                i5 = n;
                n = i1;
                i1 = i5;
              }
              paramCanvas.drawRect(i1, i7 + i8, n, i9 - i10, localb.h);
              i4 += 1;
            }
          }
        }
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean)
    {
      a(paramInt, paramRect);
      return;
    }
    super.onFocusChanged(false, paramInt, paramRect);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!super.onKeyDown(paramInt, paramKeyEvent)) {
      return false;
    }
    if (getSelectedItemPosition() != -1)
    {
      if (getSelectedItemPosition() >= b().b()) {
        return true;
      }
      if (19 == paramInt)
      {
        setSelection(b().b());
        return true;
      }
      return false;
    }
    return true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.b)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(16777215, -2147483648));
      getLayoutParams().height = getMeasuredHeight();
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof j))
    {
      super.setAdapter(paramListAdapter);
      return;
    }
    throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[] { MaterialCalendarGridView.class.getCanonicalName(), j.class.getCanonicalName() }));
  }
  
  public void setSelection(int paramInt)
  {
    int i = paramInt;
    if (paramInt < b().b()) {
      i = b().b();
    }
    super.setSelection(i);
  }
  
  class a
    extends androidx.core.view.a
  {
    a() {}
    
    public void g(View paramView, y0.d paramd)
    {
      super.g(paramView, paramd);
      paramd.e0(null);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendarGridView
 * JD-Core Version:    0.7.0.1
 */