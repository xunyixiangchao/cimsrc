package com.baidu.platform.comapi.map;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class y
  extends GestureDetector.SimpleOnGestureListener
{
  private MapController a;
  private OnLongPressListener b;
  private volatile Set<GestureDetector.SimpleOnGestureListener> c = new CopyOnWriteArraySet();
  private Object d = new Object();
  
  OnLongPressListener a()
  {
    return this.b;
  }
  
  public void a(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    synchronized (this.d)
    {
      this.c.add(paramSimpleOnGestureListener);
      return;
    }
  }
  
  public void a(MapController paramMapController)
  {
    this.a = paramMapController;
  }
  
  void a(OnLongPressListener paramOnLongPressListener)
  {
    this.b = paramOnLongPressListener;
  }
  
  public void b(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    synchronized (this.d)
    {
      this.c.remove(paramSimpleOnGestureListener);
      return;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    synchronized (this.d)
    {
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onDoubleTap(paramMotionEvent);
        }
      }
      ??? = this.a;
      if (??? != null) {
        ((MapController)???).handleDoubleDownClick(paramMotionEvent);
      }
      return true;
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    synchronized (this.d)
    {
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onDoubleTapEvent(paramMotionEvent);
        }
      }
      if (paramMotionEvent.getAction() == 1)
      {
        ??? = this.a;
        if (??? != null) {
          ((MapController)???).handleDoubleTouch(paramMotionEvent);
        }
      }
      return super.onDoubleTapEvent(paramMotionEvent);
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    synchronized (this.d)
    {
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onDown(paramMotionEvent);
        }
      }
      return super.onDown(paramMotionEvent);
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.d)
    {
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
      }
      ??? = this.a;
      if (??? == null) {
        return false;
      }
      if (((MapController)???).getMapControlMode() == MapController.MapControlMode.STREET) {
        this.a.handleTouchUp(paramMotionEvent2);
      }
      return this.a.handleFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    synchronized (this.d)
    {
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = (GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next();
          if (localSimpleOnGestureListener != null) {
            localSimpleOnGestureListener.onLongPress(paramMotionEvent);
          }
        }
      }
      ??? = this.a;
      if ((??? != null) && (!((MapController)???).isEnableDMoveZoom()) && (!this.a.isNaviMode()))
      {
        ??? = this.b;
        if (??? != null) {
          ((OnLongPressListener)???).onLongPress(paramMotionEvent);
        }
      }
      return;
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.d)
    {
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
      }
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    synchronized (this.d)
    {
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = (GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next();
          if (localSimpleOnGestureListener != null) {
            localSimpleOnGestureListener.onShowPress(paramMotionEvent);
          }
        }
      }
      super.onShowPress(paramMotionEvent);
      return;
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    synchronized (this.d)
    {
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = (GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next();
          if (localSimpleOnGestureListener != null) {
            localSimpleOnGestureListener.onSingleTapConfirmed(paramMotionEvent);
          }
        }
      }
      ??? = this.a;
      return (??? != null) && (((MapController)???).handleTouchSingleClick(paramMotionEvent));
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    synchronized (this.d)
    {
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onSingleTapUp(paramMotionEvent);
        }
      }
      return super.onSingleTapUp(paramMotionEvent);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.y
 * JD-Core Version:    0.7.0.1
 */