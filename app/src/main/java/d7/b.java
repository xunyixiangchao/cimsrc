package d7;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class b
{
  private int a = -1;
  private int b = 0;
  private final ScaleGestureDetector c;
  private VelocityTracker d;
  private boolean e;
  private float f;
  private float g;
  private final float h;
  private final float i;
  private c j;
  
  b(Context paramContext, c paramc)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.i = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.h = localViewConfiguration.getScaledTouchSlop();
    this.j = paramc;
    this.c = new ScaleGestureDetector(paramContext, new a());
  }
  
  private float b(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getX(this.b);
      return f1;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return paramMotionEvent.getX();
  }
  
  private float c(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getY(this.b);
      return f1;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return paramMotionEvent.getY();
  }
  
  private boolean g(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction() & 0xFF;
    int m = 0;
    VelocityTracker localVelocityTracker;
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 6) {
              break label447;
            }
            k = l.b(paramMotionEvent.getAction());
            if (paramMotionEvent.getPointerId(k) != this.a) {
              break label447;
            }
            if (k == 0) {
              k = 1;
            } else {
              k = 0;
            }
            this.a = paramMotionEvent.getPointerId(k);
            this.f = paramMotionEvent.getX(k);
            this.g = paramMotionEvent.getY(k);
            break label447;
          }
          this.a = -1;
          localVelocityTracker = this.d;
          if (localVelocityTracker == null) {
            break label447;
          }
        }
      }
      for (;;)
      {
        localVelocityTracker.recycle();
        this.d = null;
        break;
        float f1 = b(paramMotionEvent);
        float f2 = c(paramMotionEvent);
        float f3 = f1 - this.f;
        float f4 = f2 - this.g;
        if (!this.e)
        {
          boolean bool;
          if (Math.sqrt(f3 * f3 + f4 * f4) >= this.h) {
            bool = true;
          } else {
            bool = false;
          }
          this.e = bool;
        }
        if (!this.e) {
          break;
        }
        this.j.a(f3, f4);
        this.f = f1;
        this.g = f2;
        localVelocityTracker = this.d;
        if (localVelocityTracker == null) {
          break;
        }
        localVelocityTracker.addMovement(paramMotionEvent);
        break;
        this.a = -1;
        if ((this.e) && (this.d != null))
        {
          this.f = b(paramMotionEvent);
          this.g = c(paramMotionEvent);
          this.d.addMovement(paramMotionEvent);
          this.d.computeCurrentVelocity(1000);
          f1 = this.d.getXVelocity();
          f2 = this.d.getYVelocity();
          if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.i) {
            this.j.c(this.f, this.g, -f1, -f2);
          }
        }
        localVelocityTracker = this.d;
        if (localVelocityTracker == null) {
          break;
        }
      }
    }
    else
    {
      this.a = paramMotionEvent.getPointerId(0);
      localVelocityTracker = VelocityTracker.obtain();
      this.d = localVelocityTracker;
      if (localVelocityTracker != null) {
        localVelocityTracker.addMovement(paramMotionEvent);
      }
      this.f = b(paramMotionEvent);
      this.g = c(paramMotionEvent);
      this.e = false;
    }
    label447:
    int n = this.a;
    k = m;
    if (n != -1) {
      k = n;
    }
    this.b = paramMotionEvent.findPointerIndex(k);
    return true;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.c.isInProgress();
  }
  
  public boolean f(MotionEvent paramMotionEvent)
  {
    try
    {
      this.c.onTouchEvent(paramMotionEvent);
      boolean bool = g(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      label17:
      break label17;
    }
    return true;
  }
  
  class a
    implements ScaleGestureDetector.OnScaleGestureListener
  {
    a() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      float f = paramScaleGestureDetector.getScaleFactor();
      if ((!Float.isNaN(f)) && (!Float.isInfinite(f)))
      {
        if (f >= 0.0F) {
          b.a(b.this).b(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        }
        return true;
      }
      return false;
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d7.b
 * JD-Core Version:    0.7.0.1
 */