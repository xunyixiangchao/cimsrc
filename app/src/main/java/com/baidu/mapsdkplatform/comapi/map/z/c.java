package com.baidu.mapsdkplatform.comapi.map.z;

import android.os.Looper;
import android.os.Message;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.InnerOverlay;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.a0;
import com.baidu.platform.comapi.map.c0;
import com.baidu.platform.comapi.map.s;
import com.baidu.platform.comapi.util.g;
import com.baidu.platform.comapi.util.h;
import com.baidu.platform.comjni.engine.MessageProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class c
{
  private a a;
  private com.baidu.mapsdkplatform.comapi.map.c b;
  private int c = 1;
  private TraceAnimationListener d;
  private d e = new d();
  private b f;
  private MapSurfaceView g;
  private MapTextureView h;
  private volatile boolean i = false;
  
  public c(MapSurfaceView paramMapSurfaceView)
  {
    if (paramMapSurfaceView == null) {
      return;
    }
    this.a = new a();
    this.g = paramMapSurfaceView;
    this.b = paramMapSurfaceView.getBaseMap();
    paramMapSurfaceView.addOverlay(this.a);
    this.a.SetOverlayShow(true);
    this.c = 1;
  }
  
  public c(MapTextureView paramMapTextureView)
  {
    if (paramMapTextureView == null) {
      return;
    }
    this.a = new a();
    this.h = paramMapTextureView;
    this.b = paramMapTextureView.getBaseMap();
    paramMapTextureView.addOverlay(this.a);
    this.a.SetOverlayShow(true);
    this.c = 2;
  }
  
  private List<GeoPoint> a(TraceOverlay paramTraceOverlay)
  {
    if ((paramTraceOverlay != null) && (paramTraceOverlay.getPoints() != null))
    {
      LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
      ArrayList localArrayList = new ArrayList();
      paramTraceOverlay = paramTraceOverlay.getPoints().iterator();
      while (paramTraceOverlay.hasNext())
      {
        LatLng localLatLng = (LatLng)paramTraceOverlay.next();
        localArrayList.add(CoordUtil.ll2mc(localLatLng));
        localBuilder.include(localLatLng);
      }
      return localArrayList;
    }
    return null;
  }
  
  private boolean b(TraceOverlay paramTraceOverlay)
  {
    if (paramTraceOverlay != null)
    {
      if (this.a == null) {
        return false;
      }
      d();
    }
    return false;
  }
  
  private void c(TraceOverlay paramTraceOverlay)
  {
    if (this.a != null)
    {
      if (paramTraceOverlay == null) {
        return;
      }
      boolean bool = paramTraceOverlay.isAnimate();
      this.a.a(bool, paramTraceOverlay.getAnimationTime(), paramTraceOverlay.getAnimationDuration(), paramTraceOverlay.getAnimationType());
      s locals = new s(new a0().a(-15794282).b(14));
      locals.a(a(paramTraceOverlay));
      locals.a(new c0().d(1032).a(paramTraceOverlay.getColor()).b(paramTraceOverlay.getWidth()));
      locals.c = paramTraceOverlay.isTrackMove();
      this.a.a(locals);
    }
  }
  
  private void d(final TraceOverlay paramTraceOverlay)
  {
    if (paramTraceOverlay != null)
    {
      a locala = this.a;
      if (locala == null) {
        return;
      }
      locala.clear();
      h.a().execute(new c(paramTraceOverlay));
    }
  }
  
  public TraceOverlay a(final TraceOptions paramTraceOptions)
  {
    if (paramTraceOptions == null) {
      return null;
    }
    paramTraceOptions = paramTraceOptions.getOverlay();
    paramTraceOptions.mListener = this.f;
    h.a().execute(new b(paramTraceOptions));
    return paramTraceOptions;
  }
  
  public void a()
  {
    a locala = this.a;
    if (locala == null) {
      return;
    }
    locala.clear();
    this.a.a();
  }
  
  public void a(TraceAnimationListener paramTraceAnimationListener)
  {
    this.d = paramTraceAnimationListener;
  }
  
  public void b()
  {
    this.f = new a();
    MessageProxy.registerMessageHandler(65302, this.e);
    MessageProxy.registerMessageHandler(65303, this.e);
  }
  
  public boolean c()
  {
    return this.i;
  }
  
  public void d()
  {
    MessageProxy.unRegisterMessageHandler(65302, this.e);
    MessageProxy.unRegisterMessageHandler(65303, this.e);
    int j = this.c;
    Object localObject;
    if (j == 1)
    {
      localObject = this.g;
      if (localObject != null)
      {
        ((MapSurfaceView)localObject).removeOverlay(this.a);
        break label72;
      }
    }
    if (j == 2)
    {
      localObject = this.h;
      if (localObject != null) {
        ((MapTextureView)localObject).removeOverlay(this.a);
      }
    }
    label72:
    if (this.d != null) {
      this.d = null;
    }
    this.i = true;
  }
  
  class a
    implements b
  {
    a() {}
    
    public void a(TraceOverlay paramTraceOverlay)
    {
      c.b(c.this, paramTraceOverlay);
    }
    
    public void b(TraceOverlay paramTraceOverlay)
    {
      c.this.a();
    }
    
    public void c(TraceOverlay paramTraceOverlay)
    {
      c.a(c.this, paramTraceOverlay);
    }
  }
  
  class b
    implements Runnable
  {
    b(TraceOverlay paramTraceOverlay) {}
    
    public void run()
    {
      if (c.a(c.this) != null)
      {
        if (c.b(c.this) == null) {
          return;
        }
        c.c(c.this, paramTraceOptions);
        c.a(c.this).a();
      }
    }
  }
  
  class c
    implements Runnable
  {
    c(TraceOverlay paramTraceOverlay) {}
    
    public void run()
    {
      c.c(c.this, paramTraceOverlay);
      c.a(c.this).a();
    }
  }
  
  private class d
    extends g
  {
    d()
    {
      super();
    }
    
    public void a(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i == 65302)
      {
        i = paramMessage.arg1;
        if ((i > 0) && (i <= 1000) && (c.c(c.this) != null)) {
          c.c(c.this).onTraceAnimationUpdate(paramMessage.arg1 / 10);
        }
        if ((paramMessage.arg2 == 1) && (c.c(c.this) != null)) {
          c.c(c.this).onTraceAnimationFinish();
        }
      }
      else if ((i == 65303) && (c.c(c.this) != null))
      {
        paramMessage = CoordUtil.mc2ll(new GeoPoint(paramMessage.arg2 / 100.0F, paramMessage.arg1 / 100.0F));
        c.c(c.this).onTraceUpdatePosition(paramMessage);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.z.c
 * JD-Core Version:    0.7.0.1
 */