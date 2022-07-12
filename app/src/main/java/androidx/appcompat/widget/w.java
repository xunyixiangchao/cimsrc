package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ListView;
import h.e;

public abstract class w
  implements View.OnTouchListener, View.OnAttachStateChangeListener
{
  private final float a;
  private final int b;
  private final int c;
  final View d;
  private Runnable e;
  private Runnable f;
  private boolean g;
  private int h;
  private final int[] i = new int[2];
  
  public w(View paramView)
  {
    this.d = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.a = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    int j = ViewConfiguration.getTapTimeout();
    this.b = j;
    this.c = ((j + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private void a()
  {
    Runnable localRunnable = this.f;
    if (localRunnable != null) {
      this.d.removeCallbacks(localRunnable);
    }
    localRunnable = this.e;
    if (localRunnable != null) {
      this.d.removeCallbacks(localRunnable);
    }
  }
  
  private boolean f(MotionEvent paramMotionEvent)
  {
    View localView = this.d;
    Object localObject = b();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (!((e)localObject).c()) {
        return false;
      }
      localObject = (u)((e)localObject).h();
      bool1 = bool2;
      if (localObject != null)
      {
        if (!((ListView)localObject).isShown()) {
          return false;
        }
        MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        i(localView, localMotionEvent);
        j((View)localObject, localMotionEvent);
        boolean bool3 = ((u)localObject).e(localMotionEvent, this.h);
        localMotionEvent.recycle();
        int j = paramMotionEvent.getActionMasked();
        if ((j != 1) && (j != 3)) {
          j = 1;
        } else {
          j = 0;
        }
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (j != 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean g(MotionEvent paramMotionEvent)
  {
    View localView = this.d;
    if (!localView.isEnabled()) {
      return false;
    }
    int j = paramMotionEvent.getActionMasked();
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            return false;
          }
        }
        else
        {
          j = paramMotionEvent.findPointerIndex(this.h);
          if ((j < 0) || (h(localView, paramMotionEvent.getX(j), paramMotionEvent.getY(j), this.a))) {
            break label171;
          }
          a();
          localView.getParent().requestDisallowInterceptTouchEvent(true);
          return true;
        }
      }
      a();
      return false;
    }
    else
    {
      this.h = paramMotionEvent.getPointerId(0);
      if (this.e == null) {
        this.e = new a();
      }
      localView.postDelayed(this.e, this.b);
      if (this.f == null) {
        this.f = new b();
      }
      localView.postDelayed(this.f, this.c);
    }
    label171:
    return false;
  }
  
  private static boolean h(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = -paramFloat3;
    return (paramFloat1 >= f1) && (paramFloat2 >= f1) && (paramFloat1 < paramView.getRight() - paramView.getLeft() + paramFloat3) && (paramFloat2 < paramView.getBottom() - paramView.getTop() + paramFloat3);
  }
  
  private boolean i(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.i;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
    return true;
  }
  
  private boolean j(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.i;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
    return true;
  }
  
  public abstract e b();
  
  protected abstract boolean c();
  
  protected boolean d()
  {
    e locale = b();
    if ((locale != null) && (locale.c())) {
      locale.dismiss();
    }
    return true;
  }
  
  void e()
  {
    a();
    View localView = this.d;
    if (localView.isEnabled())
    {
      if (localView.isLongClickable()) {
        return;
      }
      if (!c()) {
        return;
      }
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      localView.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.g = true;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool4 = this.g;
    boolean bool3 = true;
    boolean bool1;
    if (bool4)
    {
      if ((!f(paramMotionEvent)) && (d())) {
        bool1 = false;
      } else {
        bool1 = true;
      }
    }
    else
    {
      if ((g(paramMotionEvent)) && (c())) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 = bool2;
      if (bool2)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.d.onTouchEvent(paramView);
        paramView.recycle();
        bool1 = bool2;
      }
    }
    this.g = bool1;
    boolean bool2 = bool3;
    if (!bool1)
    {
      if (bool4) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.g = false;
    this.h = -1;
    paramView = this.e;
    if (paramView != null) {
      this.d.removeCallbacks(paramView);
    }
  }
  
  private class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      ViewParent localViewParent = w.this.d.getParent();
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  private class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      w.this.e();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.w
 * JD-Core Version:    0.7.0.1
 */