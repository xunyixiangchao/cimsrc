package com.baidu.platform.comapi.map.e0.f;

import android.util.Pair;
import android.util.Pair<Lcom.baidu.platform.comapi.map.e0.a.d;Lcom.baidu.platform.comapi.map.e0.a.d;>;
import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapController.MapControlMode;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapStatus.WinRound;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.NaviMapViewListener;
import com.baidu.platform.comapi.map.Projection;
import com.baidu.platform.comapi.map.e0.a.a;
import com.baidu.platform.comapi.map.e0.a.b;
import com.baidu.platform.comapi.map.e0.a.c;
import com.baidu.platform.comapi.map.e0.a.d;
import com.baidu.platform.comapi.map.e0.c;
import com.baidu.platform.comapi.map.e0.e.b;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.util.LinkedList;
import java.util.Queue;

public class d
  extends a
{
  private GeoPoint b;
  private int c;
  private float d;
  private Queue<a.c> e = new LinkedList();
  private a.c f;
  private a.c g;
  private boolean h = false;
  private b i;
  private boolean j = false;
  private double k = 0.0D;
  private boolean l = false;
  private long m = 0L;
  
  public d(MapController paramMapController)
  {
    super(paramMapController);
  }
  
  private int a()
  {
    if (this.j)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll(this.e);
      if (localLinkedList.size() < 2) {
        return 0;
      }
      int i1 = (int)(((a.c)localLinkedList.get(localLinkedList.size() - 2)).a * 8.0D);
      if (i1 >= 180) {
        return 179;
      }
      int n = i1;
      if (i1 <= -180) {
        n = -179;
      }
      return n;
    }
    return 0;
  }
  
  private void a(MapStatus paramMapStatus)
  {
    if ((this.b != null) && ((Math.abs(this.g.c.a) > 0.0D) || (Math.abs(this.g.c.b) > 0.0D)))
    {
      a.b localb1 = this.i.a.a();
      a.b localb2 = this.i.c.a();
      double d1 = localb2.a - localb1.a;
      double d2 = localb2.b - localb1.b;
      d1 = Math.sqrt(d1 * d1 + d2 * d2);
      boolean bool = MapController.isCompass;
      if ((bool) && (d1 < 100.0D)) {
        return;
      }
      if ((!bool) && (!this.l))
      {
        paramMapStatus.centerPtX = this.b.getLongitude();
        paramMapStatus.centerPtY = this.b.getLatitude();
        localb1 = this.i.c.a();
        paramMapStatus.xOffset = ((float)(localb1.a - (paramMapStatus.winRound.left + this.a.getScreenWidth() / 2 + paramMapStatus.xScreenOffset)));
        paramMapStatus.yOffset = ((float)(localb1.b - (paramMapStatus.winRound.top + this.a.getScreenHeight() / 2 + paramMapStatus.yScreenOffset)) * -1.0F);
        return;
      }
      this.l = false;
      com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.d0.a());
      paramMapStatus = this.a.getMapView();
      if (paramMapStatus == null) {
        return;
      }
      localb1 = this.i.c.a();
      this.b = paramMapStatus.getProjection().fromPixels((int)localb1.a, (int)localb1.b);
    }
  }
  
  private void a(MapStatus paramMapStatus, int paramInt)
  {
    if (paramInt != 0)
    {
      paramMapStatus.rotation = ((paramMapStatus.rotation + paramInt) % 360);
      this.a.setMapStatusWithAnimation(paramMapStatus, 600);
    }
  }
  
  private void b(MapStatus paramMapStatus)
  {
    b localb = this.i;
    a.a locala = localb.b;
    double d2 = Math.abs(new a.c(new a.a(locala.a, localb.c.a), locala).a);
    localb = this.i;
    locala = localb.b;
    double d1 = Math.abs(new a.c(new a.a(locala.b, localb.c.b), locala).a);
    double d3 = this.k;
    int i2 = 0;
    int n;
    if ((d3 != 0.0D) && (d3 * this.g.b < 0.0D)) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0) {
      return;
    }
    if (this.j)
    {
      paramMapStatus.rotation = ((int)((this.c + this.f.a) % 360.0D));
    }
    else
    {
      d3 = this.g.b;
      if (((d3 < 1.0D) && (d2 > 60.0D)) || ((d3 > 1.0D) && (Math.abs(d2 - 180.0D) > 60.0D))) {
        n = 1;
      } else {
        n = 0;
      }
      d2 = this.g.b;
      int i1;
      if ((d2 <= 1.0D) || (d1 <= 60.0D))
      {
        i1 = i2;
        if (d2 < 1.0D)
        {
          i1 = i2;
          if (Math.abs(d1 - 180.0D) <= 60.0D) {}
        }
      }
      else
      {
        i1 = 1;
      }
      if ((n != 0) || (i1 != 0))
      {
        d1 = Math.abs(this.f.a);
        if (MapController.isCompass) {
          n = 30;
        } else {
          n = 10;
        }
        if (d1 > n)
        {
          this.j = true;
          this.a.getGestureMonitor().c();
          this.c = ((int)(this.c - this.f.a));
          if (MapController.isCompass)
          {
            this.l = true;
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.d0.a());
          }
        }
      }
    }
    this.k = this.g.b;
  }
  
  private void c(MapStatus paramMapStatus)
  {
    float f2 = this.d + (float)(Math.log(this.f.b) / Math.log(2.0D));
    paramMapStatus.level = f2;
    float f1 = f2;
    if (f2 < 4.0F) {
      f1 = 4.0F;
    }
    paramMapStatus.level = f1;
  }
  
  public void a(MapStatus paramMapStatus, b paramb, Pair<a.d, a.d> paramPair)
  {
    if (paramPair != null)
    {
      int i4 = a();
      Object localObject = (a.d)paramPair.first;
      double d1 = ((a.d)localObject).a;
      a.d locald = (a.d)paramPair.second;
      double d2 = locald.a;
      if ((d1 * d2 > 0.0D) && (((a.d)localObject).b * locald.b > 0.0D))
      {
        a(paramMapStatus, i4);
        return;
      }
      if ((Math.abs(d1 - d2) >= 1.0D) && (Math.abs(((a.d)paramPair.first).b - ((a.d)paramPair.second).b) >= 1.0D))
      {
        localObject = paramb.b;
        d1 = Math.abs(new a.c(new a.a(((a.a)localObject).a, paramb.c.a), (a.a)localObject).a);
        localObject = paramb.b;
        d2 = Math.abs(new a.c(new a.a(((a.a)localObject).b, paramb.c.b), (a.a)localObject).a);
        double d3 = this.k;
        int n;
        if ((d3 != 0.0D) && (d3 * this.g.b < 0.0D)) {
          n = 1;
        } else {
          n = 0;
        }
        if (n != 0)
        {
          a(paramMapStatus, i4);
          return;
        }
        paramb = (a.d)paramPair.first;
        d3 = paramb.a;
        paramPair = (a.d)paramPair.second;
        double d4 = paramPair.a;
        double d5 = paramb.b;
        double d6 = paramPair.b;
        float f1 = (float)Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5 + d6 * d6) * 2.0F;
        if (f1 > SysOSUtil.getInstance().getDensityDPI() * 100 / 320)
        {
          paramMapStatus.hasAnimation = 1;
          paramMapStatus.animationTime = 600;
          paramb = null;
          paramPair = null;
          int i1 = 0;
          int i3 = 0;
          int i2 = 0;
          n = i4;
          while (i1 < this.e.size())
          {
            localObject = (a.c)this.e.poll();
            if (localObject != null)
            {
              if (this.e.isEmpty()) {
                if (Math.abs(((a.c)localObject).b - 1.0D) < 0.01D)
                {
                  a(paramMapStatus, n);
                  return;
                }
              }
              if (((a.c)localObject).b > 1.0D)
              {
                i3 += 1;
                paramb = (b)localObject;
              }
              else
              {
                i2 += 1;
                paramPair = (Pair<a.d, a.d>)localObject;
              }
            }
            i1 += 1;
          }
          if (i3 < i2) {
            paramb = paramPair;
          }
          if ((paramb != null) && (Math.abs(paramb.b - 1.0D) < 0.01D))
          {
            a(paramMapStatus, n);
            return;
          }
          d3 = paramb.b;
          if (((d3 < 1.0D) && (d1 > 60.0D)) || ((d3 > 1.0D) && (Math.abs(d1 - 180.0D) > 60.0D))) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          d1 = paramb.b;
          if (((d1 > 1.0D) && (d2 > 60.0D)) || ((d1 < 1.0D) && (Math.abs(d2 - 180.0D) > 60.0D))) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if ((i1 != 0) || (i2 != 0))
          {
            d1 = Math.abs(this.f.a);
            if (MapController.isCompass) {
              i1 = 30;
            } else {
              i1 = 15;
            }
            if (d1 > i1)
            {
              a(paramMapStatus, n);
              return;
            }
          }
          boolean bool;
          if (paramb.b > 1.0D) {
            bool = true;
          } else {
            bool = false;
          }
          this.h = bool;
          float f2 = f1 / (800000 / SysOSUtil.getInstance().getDensityDPI());
          f1 = f2;
          if (f2 > 2.0F) {
            f1 = 2.0F;
          }
          if (!this.h) {
            f1 = paramMapStatus.level - f1;
          } else {
            f1 = paramMapStatus.level + f1;
          }
          paramMapStatus.level = f1;
          f2 = paramMapStatus.level;
          f1 = f2;
          if (f2 < 4.0F) {
            f1 = 4.0F;
          }
          paramMapStatus.level = f1;
          if (n != 0) {
            paramMapStatus.rotation = ((paramMapStatus.rotation + n) % 360);
          }
          this.a.setMapStatus(paramMapStatus);
          this.a.mIsAnimating = true;
        }
      }
      else
      {
        a(paramMapStatus, i4);
      }
    }
  }
  
  public void a(b paramb)
  {
    MapViewInterface localMapViewInterface = this.a.getMapView();
    if (localMapViewInterface == null) {
      return;
    }
    MapStatus localMapStatus = this.a.getMapStatus();
    paramb = paramb.a.a();
    this.b = localMapViewInterface.getProjection().fromPixels((int)paramb.a, (int)paramb.b);
    this.d = this.a.getZoomLevel();
    this.c = localMapStatus.rotation;
    this.k = 0.0D;
  }
  
  public void a(b paramb, Pair<a.d, a.d> paramPair)
  {
    Object localObject = this.a.getMapView();
    if (localObject == null) {
      return;
    }
    MapStatus localMapStatus = this.a.getMapStatus();
    int i1 = (int)paramb.d.getX();
    int i2 = (int)paramb.d.getY();
    int n = i1;
    if (i1 < 0) {
      n = 0;
    }
    i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    localObject = ((MapViewInterface)localObject).getProjection().fromPixels((int)(this.a.getScreenWidth() / 2 + localMapStatus.winRound.left + localMapStatus.xScreenOffset), (int)(this.a.getScreenHeight() / 2 + localMapStatus.winRound.top + localMapStatus.yScreenOffset));
    double d1;
    double d2;
    if (localObject != null)
    {
      d1 = ((GeoPoint)localObject).getLongitude();
      d2 = ((GeoPoint)localObject).getLatitude();
    }
    else
    {
      d1 = 0.0D;
      d2 = d1;
    }
    this.a.MapMsgProc(5, 1, i1 << 16 | n, 0, 0, d1, d2, 0.0D, 0.0D);
    this.a.getGestureMonitor().c(this.a.getZoomLevel());
    if (System.currentTimeMillis() - this.m > 100L) {
      return;
    }
    if (this.a.isEnableZoom()) {
      a(this.a.getMapStatus(), paramb, paramPair);
    }
  }
  
  public void b(b paramb)
  {
    this.i = paramb;
    this.f = new a.c(paramb.a, paramb.c);
    this.g = new a.c(paramb.b, paramb.c);
    paramb = this.a.getMapStatus();
    if (this.a.isEnableZoom()) {
      c(paramb);
    }
    if ((this.a.is3DGestureEnable()) && (this.a.getMapControlMode() != MapController.MapControlMode.STREET))
    {
      if ((paramb.overlooking == 0) && (this.a.isCanTouchMove())) {
        a(paramb);
      }
      b(paramb);
    }
    this.a.setMapStatus(paramb);
    if ((this.a.isNaviMode()) && (this.a.getNaviMapViewListener() != null)) {
      this.a.getNaviMapViewListener().onAction(520, null);
    }
    this.a.mapStatusChangeStart();
    if (this.e.size() >= 10) {
      this.e.poll();
    }
    this.e.offer(this.g);
    com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.d0.d());
    this.m = System.currentTimeMillis();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.e0.f.d
 * JD-Core Version:    0.7.0.1
 */