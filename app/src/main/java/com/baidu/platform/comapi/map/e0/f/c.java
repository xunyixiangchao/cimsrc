package com.baidu.platform.comapi.map.e0.f;

import android.util.Pair;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.e0.a.a;
import com.baidu.platform.comapi.map.e0.a.b;
import com.baidu.platform.comapi.map.e0.a.d;
import com.baidu.platform.comapi.map.e0.e.b;

public class c
  extends a
{
  private boolean b = true;
  private long c;
  
  public c(MapController paramMapController)
  {
    super(paramMapController);
  }
  
  private void a(double paramDouble, MapStatus paramMapStatus)
  {
    if (this.c == 0L) {
      this.c = System.currentTimeMillis();
    }
    long l = System.currentTimeMillis();
    this.c = l;
    if (l - l <= 50L)
    {
      if (Math.abs(paramDouble) < 4.0D) {
        return;
      }
      int i;
      if (paramDouble > 0.0D) {
        i = paramMapStatus.overlooking - 4;
      } else {
        i = (int)(paramMapStatus.overlooking + 2.0D);
      }
      paramMapStatus.overlooking = i;
    }
  }
  
  public void a(b paramb, Pair<a.d, a.d> paramPair)
  {
    paramb = this.a.getMapStatus();
    if (paramb.bOverlookSpringback)
    {
      int i;
      if (paramb.overlooking > 0) {
        i = 0;
      } else {
        i = paramb.minOverlooking;
      }
      paramb.overlooking = i;
      this.a.setMapStatusWithAnimation(paramb, 200);
    }
  }
  
  public void b(b paramb)
  {
    a.a locala = paramb.b;
    paramb = paramb.c;
    MapStatus localMapStatus = this.a.getMapStatus();
    double d1 = paramb.a.b - locala.a.b;
    double d2 = paramb.b.b - locala.b.b;
    boolean bool = d1 * d2 < 0.0D;
    if (bool) {}
    do
    {
      do
      {
        a(d1, localMapStatus);
        break label126;
        if (bool) {
          break;
        }
      } while (d1 != 0.0D);
      if (d2 == 0.0D) {
        break label126;
      }
      break;
    } while (Math.abs(d1) > Math.abs(d2));
    a(d2, localMapStatus);
    label126:
    this.a.setMapStatus(localMapStatus);
    if (this.b)
    {
      this.b = false;
      this.a.getGestureMonitor().b();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.e0.f.c
 * JD-Core Version:    0.7.0.1
 */