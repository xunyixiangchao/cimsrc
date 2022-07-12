package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.b;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.util.h;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class k
  implements b0
{
  public static boolean u = false;
  private AppBaseMap a = null;
  private boolean b = false;
  private w c;
  private WeakReference<MapSurfaceView> d;
  private WeakReference<g> e;
  private c f;
  private volatile boolean g = false;
  private int h;
  private int i;
  private int j;
  private int k;
  private Bitmap.Config l;
  private e m;
  private boolean n;
  private int o;
  private boolean p = false;
  private volatile boolean q = false;
  public int r;
  public int s;
  public int t;
  
  public k(g paramg, w paramw)
  {
    this.e = new WeakReference(paramg);
    this.c = paramw;
  }
  
  public k(WeakReference<MapSurfaceView> paramWeakReference, w paramw)
  {
    this.c = paramw;
    this.d = paramWeakReference;
  }
  
  private boolean a()
  {
    return (this.a != null) && (this.b);
  }
  
  private void b(Object paramObject)
  {
    if (this.f == null) {
      return;
    }
    Object localObject = this.d;
    int i1;
    int i2;
    if (localObject != null)
    {
      localObject = (MapSurfaceView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        i1 = this.h;
        if (i1 > 0)
        {
          i2 = this.i;
          if (i2 > 0) {
            h.a(new b(((MapSurfaceView)localObject).captureImageFromSurface(this.j, this.k, i1, i2, paramObject, this.l)), 0L);
          }
        }
      }
    }
    localObject = this.e;
    if (localObject != null)
    {
      localObject = (g)((WeakReference)localObject).get();
      if (localObject != null)
      {
        i1 = this.h;
        if (i1 > 0)
        {
          i2 = this.i;
          if (i2 > 0) {
            h.a(new c(((g)localObject).captureImageFromSurface(this.j, this.k, i1, i2, paramObject, this.l)), 0L);
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((AppBaseMap)localObject).renderResize(paramInt1, paramInt2);
    }
    if (OpenLogUtil.isMapLogEnable())
    {
      localObject = b.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BasicMap onSurfaceChanged width = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("; height = ");
      localStringBuilder.append(paramInt2);
      ((b)localObject).a(localStringBuilder.toString());
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.n = false;
    this.o = 0;
    if (!a()) {
      return;
    }
    Surface localSurface = null;
    if (paramSurfaceHolder != null) {
      localSurface = paramSurfaceHolder.getSurface();
    }
    this.a.renderInit(paramInt1, paramInt2, localSurface, paramInt3);
    if (OpenLogUtil.isMapLogEnable()) {
      b.a().a("BasicMap onSurfaceCreated ok");
    }
  }
  
  public void a(c paramc, int paramInt1, int paramInt2)
  {
    this.g = true;
    this.f = paramc;
    this.h = paramInt1;
    this.i = paramInt2;
    this.l = null;
  }
  
  public void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.Config paramConfig)
  {
    this.g = true;
    this.f = paramc;
    this.j = paramInt1;
    this.k = paramInt2;
    this.h = paramInt3;
    this.i = paramInt4;
    this.l = paramConfig;
  }
  
  public void a(c paramc, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    this.g = true;
    this.f = paramc;
    this.h = paramInt1;
    this.i = paramInt2;
    this.l = paramConfig;
  }
  
  public void a(e parame)
  {
    this.m = parame;
  }
  
  public void a(AppBaseMap paramAppBaseMap)
  {
    this.a = paramAppBaseMap;
  }
  
  public void a(Object paramObject)
  {
    if (!a()) {
      return;
    }
    boolean bool2 = this.p;
    boolean bool1 = true;
    if (!bool2)
    {
      this.p = true;
      localObject = this.d;
      if (localObject != null)
      {
        localObject = (MapSurfaceView)((WeakReference)localObject).get();
        if (localObject != null) {
          ((SurfaceView)localObject).post(new a((MapSurfaceView)localObject));
        }
      }
    }
    if (u)
    {
      u = false;
      return;
    }
    if (this.q) {
      return;
    }
    int i1 = this.a.Draw();
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (MapSurfaceView)((WeakReference)localObject).get();
      if (localObject != null) {
        if (i1 == 1) {
          ((MapSurfaceView)localObject).requestRender();
        } else if (((MapSurfaceView)localObject).getRenderMode() != 0) {
          ((MapSurfaceView)localObject).setRenderMode(0);
        }
      }
    }
    localObject = this.e;
    if (localObject != null)
    {
      localObject = (g)((WeakReference)localObject).get();
      if (localObject != null) {
        if (i1 == 1) {
          ((g)localObject).requestRender();
        } else if (((g)localObject).getRenderMode() != 0) {
          ((g)localObject).setRenderMode(0);
        }
      }
    }
    if (this.g)
    {
      this.g = false;
      if (this.f != null) {
        b(paramObject);
      }
    }
    if (!this.n)
    {
      i1 = this.o + 1;
      this.o = i1;
      if (i1 == 2)
      {
        paramObject = this.m;
        if (paramObject != null)
        {
          paramObject.a();
          if (OpenLogUtil.isMapLogEnable()) {
            b.a().a("BasicMap onDrawFirstFrame");
          }
        }
      }
      if (this.o != 2) {
        bool1 = false;
      }
      this.n = bool1;
    }
    paramObject = this.d;
    if ((paramObject != null) && (((MapSurfaceView)paramObject.get()).getBaseMap() != null) && (((MapSurfaceView)this.d.get()).getBaseMap().q != null))
    {
      paramObject = ((MapSurfaceView)this.d.get()).getBaseMap().q.iterator();
      while (paramObject.hasNext())
      {
        localObject = (x)paramObject.next();
        if (((MapSurfaceView)this.d.get()).getBaseMap() == null) {
          return;
        }
        s locals = ((MapSurfaceView)this.d.get()).getBaseMap().l();
        if (localObject != null) {
          ((x)localObject).a(null, locals);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b()
  {
    this.q = true;
  }
  
  public void c()
  {
    this.q = false;
  }
  
  class a
    implements Runnable
  {
    a(MapSurfaceView paramMapSurfaceView) {}
    
    public void run()
    {
      MapSurfaceView localMapSurfaceView = this.a;
      if (localMapSurfaceView != null) {
        localMapSurfaceView.setBackgroundResource(0);
      }
    }
  }
  
  class b
    implements Runnable
  {
    b(Bitmap paramBitmap) {}
    
    public void run()
    {
      k.a(k.this).a(this.a);
    }
  }
  
  class c
    implements Runnable
  {
    c(Bitmap paramBitmap) {}
    
    public void run()
    {
      k.a(k.this).a(this.a);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.k
 * JD-Core Version:    0.7.0.1
 */