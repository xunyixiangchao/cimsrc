package com.baidu.platform.comapi.map.e0;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.NaviMapViewListener;
import com.baidu.platform.comapi.map.e0.e.a;
import com.baidu.platform.comapi.map.e0.e.a.a;

public class b
{
  private MapController a;
  private com.baidu.platform.comapi.map.e0.e.b b;
  private a c;
  a.a d = new a();
  
  public b(MapController paramMapController)
  {
    this.a = paramMapController;
    this.b = new com.baidu.platform.comapi.map.e0.e.b(new com.baidu.platform.comapi.map.e0.f.b(paramMapController));
    this.c = new a(this.d);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.b.b(paramMotionEvent);
    this.c.b(paramMotionEvent);
  }
  
  class a
    implements a.a
  {
    a() {}
    
    public boolean a(a parama)
    {
      if (!b.a(b.this).isTwoTouchClickZoomEnabled()) {
        return false;
      }
      b.a(b.this).getGestureMonitor().b(b.a(b.this).getZoomLevel() - 1.0F);
      b.a(b.this).mapStatusChangeStart();
      b.a(b.this).MapMsgProc(8193, 4, 0);
      if ((b.a(b.this).isNaviMode()) && (b.a(b.this).getNaviMapViewListener() != null)) {
        b.a(b.this).getNaviMapViewListener().onAction(521, null);
      }
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.e0.b
 * JD-Core Version:    0.7.0.1
 */