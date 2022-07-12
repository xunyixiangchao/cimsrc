package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnKeyListener;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.b;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmObject;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.json.JSONObject;

public class MapSurfaceView
  extends v
  implements View.OnKeyListener, MapViewInterface, MapRenderModeChangeListener, w
{
  private static int B;
  private static final ExecutorService C = ;
  private int A = 0;
  private volatile boolean b = false;
  private volatile boolean c = false;
  private volatile boolean d = false;
  private volatile boolean e = true;
  private boolean f = true;
  private boolean g = true;
  protected MapController h = null;
  protected r i = null;
  protected j j = null;
  protected k k;
  private LocationOverlay l;
  protected volatile boolean m = false;
  private boolean n = true;
  private List<BmLayer> o = new ArrayList();
  private List<Overlay> p = new ArrayList();
  private int q = 0;
  private int r = 0;
  private HashSet<n> s = new HashSet();
  protected y t;
  protected GestureDetector u;
  protected p v;
  private boolean w = true;
  protected com.baidu.mapsdkplatform.comapi.map.c x;
  private int y = 0;
  private int z = 0;
  
  public MapSurfaceView(Context paramContext)
  {
    super(paramContext);
    B += 1;
  }
  
  public MapSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    B += 1;
  }
  
  public MapSurfaceView(Context paramContext, u.a parama)
  {
    super(paramContext, parama);
    B += 1;
  }
  
  public MapSurfaceView(Context paramContext, u.a parama, boolean paramBoolean)
  {
    super(paramContext, parama, paramBoolean);
    B += 1;
  }
  
  public MapSurfaceView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    B += 1;
  }
  
  private boolean a(long paramLong, BmLayer paramBmLayer)
  {
    if (paramBmLayer != null) {
      try
      {
        Object localObject = this.h;
        if (localObject != null)
        {
          localObject = ((MapController)localObject).getBaseMap();
          if (localObject == null) {
            return false;
          }
          try
          {
            if (this.o.contains(paramBmLayer)) {
              return false;
            }
            this.o.add(paramBmLayer);
            boolean bool = ((AppBaseMap)localObject).addBmLayerBelow(paramLong, paramBmLayer.b(), 1, 0);
            return bool;
          }
          finally {}
        }
      }
      finally {}
    }
    return false;
  }
  
  protected t a(u.a parama, boolean paramBoolean, Context paramContext)
  {
    parama = super.a(parama, paramBoolean, paramContext);
    if ((parama instanceof f))
    {
      paramContext = (f)parama;
      if (this.w) {
        paramContext.a(new f(null));
      }
    }
    return parama;
  }
  
  protected void a()
  {
    MapController localMapController = this.h;
    if (localMapController == null) {
      return;
    }
    if (localMapController.getBaseMap() == null) {
      return;
    }
    if (this.i == null) {
      return;
    }
    this.p.clear();
    this.i.a();
  }
  
  protected void a(Context paramContext, u.a parama, boolean paramBoolean)
  {
    super.a(paramContext, parama, paramBoolean);
    setBackgroundColor(Color.rgb(244, 242, 240));
    setPixelFormatTransparent(false);
    this.t = new y();
    this.u = new GestureDetector(paramContext, this.t);
    paramContext = new k(new WeakReference(this), this);
    this.k = paramContext;
    setRenderer(paramContext);
    setRenderMode(1);
    this.t.a(new g(null));
    if (OpenLogUtil.isMapLogEnable()) {
      b.a().a("BasicMap surfaceView initView");
    }
  }
  
  public boolean addBmLayer(BmLayer paramBmLayer)
  {
    return a(0L, paramBmLayer);
  }
  
  public boolean addBmLayerBelow(Overlay paramOverlay, BmLayer paramBmLayer)
  {
    if (paramOverlay != null) {}
    for (long l1 = paramOverlay.mLayerID;; l1 = 0L) {
      return a(l1, paramBmLayer);
    }
  }
  
  public boolean addOverlay(Overlay paramOverlay)
  {
    if (paramOverlay != null) {
      try
      {
        Object localObject = this.h;
        if (localObject != null)
        {
          localObject = ((MapController)localObject).getBaseMap();
          if (localObject == null) {
            return false;
          }
          if ((paramOverlay instanceof InnerOverlay))
          {
            localObject = (InnerOverlay)paramOverlay;
            if (((InnerOverlay)localObject).mBaseMap == null) {
              ((InnerOverlay)localObject).mBaseMap = getController().getBaseMap();
            }
            if (((InnerOverlay)localObject).addedToMapView()) {
              try
              {
                this.p.add(paramOverlay);
                this.i.a((InnerOverlay)paramOverlay);
                return true;
              }
              finally {}
            }
            return false;
          }
          if ((paramOverlay instanceof ItemizedOverlay))
          {
            ItemizedOverlay localItemizedOverlay = (ItemizedOverlay)paramOverlay;
            long l1 = ((AppBaseMap)localObject).AddLayer(localItemizedOverlay.getUpdateType(), 0, "item");
            paramOverlay.mLayerID = l1;
            if (l1 == 0L) {
              return false;
            }
            try
            {
              this.p.add(paramOverlay);
              localItemizedOverlay.c();
              ((AppBaseMap)localObject).SetLayersClickable(paramOverlay.mLayerID, true);
              ((AppBaseMap)localObject).ShowLayers(paramOverlay.mLayerID, true);
              ((AppBaseMap)localObject).UpdateLayers(paramOverlay.mLayerID);
              return true;
            }
            finally {}
          }
          return false;
        }
      }
      finally {}
    }
    return false;
  }
  
  public void addSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    this.t.a(paramSimpleOnGestureListener);
  }
  
  public void addStateListener(n paramn)
  {
    if (paramn != null) {
      this.s.add(paramn);
    }
  }
  
  public void animateTo(MapStatus paramMapStatus, int paramInt)
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      localMapController.setMapStatusWithAnimation(paramMapStatus, paramInt);
    }
  }
  
  public void animateTo(MapStatus paramMapStatus, int paramInt1, int paramInt2)
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      localMapController.setMapStatusWithAnimation(paramMapStatus, paramInt1, paramInt2);
    }
  }
  
  protected void b()
  {
    MapController localMapController = this.h;
    if (localMapController == null) {
      return;
    }
    if (localMapController.getBaseMap() == null) {
      return;
    }
    a();
  }
  
  public void beginLocationLayerAnimation()
  {
    LocationOverlay localLocationOverlay = this.l;
    if (localLocationOverlay != null) {
      localLocationOverlay.beginLocationLayerAnimation();
    }
  }
  
  public void clearDefaultLocationLayerData(Bundle paramBundle)
  {
    this.l.clearLocationLayerData(paramBundle);
  }
  
  public void doCaptureMapView(c paramc, int paramInt1, int paramInt2)
  {
    this.k.a(paramc, paramInt1, paramInt2);
  }
  
  public void doCaptureMapView(c paramc, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    this.k.a(paramc, paramInt1, paramInt2, paramConfig);
  }
  
  public void doCaptureMapView(c paramc, Rect paramRect, Bitmap.Config paramConfig)
  {
    if (paramRect != null)
    {
      int i5 = paramRect.left;
      int i1 = this.r;
      int i2 = paramRect.bottom;
      if (i1 < i2) {
        i1 = 0;
      } else {
        i1 -= i2;
      }
      int i4 = paramRect.width();
      int i3 = paramRect.height();
      if ((i5 >= 0) && (i1 >= 0) && (i4 > 0))
      {
        if (i3 <= 0) {
          return;
        }
        i2 = i4;
        if (i4 > this.q) {
          i2 = Math.abs(paramRect.width()) - (paramRect.right - this.q);
        }
        if (i3 > this.r) {
          i3 = Math.abs(paramRect.height()) - (paramRect.bottom - this.r);
        }
        if (i5 <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeX())
        {
          if (i1 > com.baidu.mapapi.common.SysOSUtil.getScreenSizeY()) {
            return;
          }
          this.k.a(paramc, i5, i1, i2, i3, paramConfig);
          requestRender();
        }
      }
    }
  }
  
  public boolean enable3D()
  {
    return true;
  }
  
  public void forceSetTraffic(boolean paramBoolean)
  {
    if (this.h != null) {
      this.b = paramBoolean;
    }
    C.submit(new b());
  }
  
  public com.baidu.mapsdkplatform.comapi.map.c getBaseMap()
  {
    return this.x;
  }
  
  public List<BmLayer> getBmlayers()
  {
    return this.o;
  }
  
  public MapController getController()
  {
    return this.h;
  }
  
  public MapStatus getCurrentMapStatus()
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      return localMapController.getCurrentMapStatus();
    }
    return null;
  }
  
  public float getCurrentZoomLevel()
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      return localMapController.getCurrentZoomLevel();
    }
    return 0.0F;
  }
  
  public LocationOverlay getDefaultLocationLay()
  {
    return this.l;
  }
  
  public int getFPS()
  {
    return this.a.getFPS();
  }
  
  public float getFZoomToBoundF(MapBound paramMapBound1, MapBound paramMapBound2)
  {
    if (this.h == null) {
      return 0.0F;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("left", paramMapBound1.leftBottomPt.getIntX());
    localBundle.putInt("bottom", paramMapBound1.leftBottomPt.getIntY());
    localBundle.putInt("right", paramMapBound1.rightTopPt.getIntX());
    localBundle.putInt("top", paramMapBound1.rightTopPt.getIntY());
    paramMapBound1 = new Bundle();
    paramMapBound1.putInt("left", paramMapBound2.leftBottomPt.getIntX());
    paramMapBound1.putInt("bottom", paramMapBound2.leftBottomPt.getIntY());
    paramMapBound1.putInt("right", paramMapBound2.rightTopPt.getIntX());
    paramMapBound1.putInt("top", paramMapBound2.rightTopPt.getIntY());
    return this.h.GetFZoomToBoundF(localBundle, paramMapBound1);
  }
  
  public MapStatus.GeoBound getGeoRound()
  {
    MapController localMapController = this.h;
    if (localMapController == null) {
      return null;
    }
    return localMapController.getMapStatus().geoRound;
  }
  
  public int getLatitudeSpan()
  {
    Object localObject3 = getMapStatus();
    Object localObject1 = (j)getProjection();
    Object localObject2 = ((MapStatus)localObject3).winRound;
    localObject2 = ((j)localObject1).fromPixels(((MapStatus.WinRound)localObject2).left, ((MapStatus.WinRound)localObject2).top);
    localObject3 = ((MapStatus)localObject3).winRound;
    localObject1 = ((j)localObject1).fromPixels(((MapStatus.WinRound)localObject3).right - 1, ((MapStatus.WinRound)localObject3).bottom - 1);
    return (int)Math.abs(((GeoPoint)localObject2).getLatitude() - ((GeoPoint)localObject1).getLatitude());
  }
  
  public int getLongitudeSpan()
  {
    Object localObject1 = getMapStatus();
    j localj = (j)getProjection();
    Object localObject2 = ((MapStatus)localObject1).winRound;
    localObject2 = localj.fromPixels(((MapStatus.WinRound)localObject2).left, ((MapStatus.WinRound)localObject2).top);
    localObject1 = ((MapStatus)localObject1).winRound;
    return (int)Math.abs(localj.fromPixels(((MapStatus.WinRound)localObject1).right - 1, ((MapStatus.WinRound)localObject1).bottom - 1).getLongitude() - ((GeoPoint)localObject2).getLongitude());
  }
  
  public GeoPoint getMapCenter()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return null;
    }
    localObject = ((MapController)localObject).getMapStatus();
    return new GeoPoint(((MapStatus)localObject).centerPtY, ((MapStatus)localObject).centerPtX);
  }
  
  public int getMapRotation()
  {
    MapController localMapController = this.h;
    if (localMapController == null) {
      return 0;
    }
    return localMapController.getMapStatus().rotation;
  }
  
  public MapStatus getMapStatus()
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      return localMapController.getMapStatus();
    }
    return null;
  }
  
  public MapViewListener getMapViewListener()
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      return localMapController.getMapViewListener();
    }
    return null;
  }
  
  public OnLongPressListener getOnLongPressListener()
  {
    return this.t.a();
  }
  
  public Overlay getOverlay(int paramInt)
  {
    if (paramInt == 21) {
      return null;
    }
    try
    {
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        Overlay localOverlay = (Overlay)localIterator.next();
        int i1 = localOverlay.mType;
        if (i1 == paramInt) {
          return localOverlay;
        }
      }
      return null;
    }
    finally {}
  }
  
  public Overlay getOverlay(Class<?> paramClass)
  {
    try
    {
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        Overlay localOverlay = (Overlay)localIterator.next();
        Class localClass = localOverlay.getClass();
        if (localClass == paramClass) {
          return localOverlay;
        }
      }
      return null;
    }
    finally {}
  }
  
  public List<Overlay> getOverlays()
  {
    return this.p;
  }
  
  public int getOverlooking()
  {
    MapController localMapController = this.h;
    if (localMapController == null) {
      return 0;
    }
    return localMapController.getMapStatus().overlooking;
  }
  
  public Projection getProjection()
  {
    return this.j;
  }
  
  public ExecutorService getSingleThreadPool()
  {
    return C;
  }
  
  public MapStatus.WinRound getWinRound()
  {
    MapController localMapController = this.h;
    if (localMapController == null) {
      return null;
    }
    return localMapController.getMapStatus().winRound;
  }
  
  public float getZoomLevel()
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      return localMapController.getZoomLevel();
    }
    return 0.0F;
  }
  
  public float getZoomToBound(MapBound paramMapBound)
  {
    com.baidu.platform.comapi.util.SysOSUtil localSysOSUtil = com.baidu.platform.comapi.util.SysOSUtil.getInstance();
    return getZoomToBound(paramMapBound, localSysOSUtil.getScreenWidth(), localSysOSUtil.getScreenHeight());
  }
  
  public float getZoomToBound(MapBound paramMapBound, int paramInt1, int paramInt2)
  {
    if (this.h == null) {
      return 0.0F;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("left", paramMapBound.leftBottomPt.getIntX());
    localBundle.putInt("bottom", paramMapBound.leftBottomPt.getIntY());
    localBundle.putInt("right", paramMapBound.rightTopPt.getIntX());
    localBundle.putInt("top", paramMapBound.rightTopPt.getIntY());
    return this.h.getZoomToBound(localBundle, paramInt1, paramInt2);
  }
  
  public float getZoomToBoundF(MapBound paramMapBound)
  {
    com.baidu.platform.comapi.util.SysOSUtil localSysOSUtil = com.baidu.platform.comapi.util.SysOSUtil.getInstance();
    return getZoomToBoundF(paramMapBound, localSysOSUtil.getScreenWidth(), localSysOSUtil.getScreenHeight());
  }
  
  public float getZoomToBoundF(MapBound paramMapBound, int paramInt1, int paramInt2)
  {
    if (this.h == null) {
      return 0.0F;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("left", paramMapBound.leftBottomPt.getIntX());
    localBundle.putInt("bottom", paramMapBound.leftBottomPt.getIntY());
    localBundle.putInt("right", paramMapBound.rightTopPt.getIntX());
    localBundle.putInt("top", paramMapBound.rightTopPt.getIntY());
    return this.h.getZoomToBoundF(localBundle);
  }
  
  public boolean inRangeOfView(float paramFloat1, float paramFloat2)
  {
    float f1 = 0;
    if ((paramFloat1 >= f1) && (paramFloat1 <= this.q + 0) && (paramFloat2 >= f1)) {
      return paramFloat2 <= this.r + 0;
    }
    return false;
  }
  
  public boolean insertOverlay(Overlay paramOverlay, int paramInt)
  {
    try
    {
      if ((paramOverlay instanceof InnerOverlay))
      {
        MapController localMapController = this.h;
        if (localMapController != null)
        {
          InnerOverlay localInnerOverlay = (InnerOverlay)paramOverlay;
          if (localInnerOverlay.mBaseMap == null) {
            localInnerOverlay.mBaseMap = localMapController.getBaseMap();
          }
          this.p.add(paramOverlay);
          this.i.a(localInnerOverlay);
        }
      }
      return false;
    }
    finally {}
  }
  
  public boolean isBaseIndoorMap()
  {
    return this.e;
  }
  
  public boolean isPredictTraffic()
  {
    return (this.y > 0) || (this.z > 0) || (this.A > 0);
  }
  
  public boolean isSatellite()
  {
    return this.c;
  }
  
  public boolean isStreetRoad()
  {
    return this.d;
  }
  
  public boolean isTraffic()
  {
    return this.b;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MapController localMapController = this.h;
    if (localMapController != null) {
      localMapController.updateDrawFPS();
    }
  }
  
  public void onBackground()
  {
    if (this.g) {
      return;
    }
    MapController localMapController = this.h;
    if ((localMapController != null) && (localMapController.getBaseMap() != null)) {
      this.h.getBaseMap().OnBackground();
    }
    this.g = true;
  }
  
  public void onDetachedFromWindow()
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      localMapController.updateDrawFPS();
    }
    super.onDetachedFromWindow();
  }
  
  public void onForeground()
  {
    if (this.g)
    {
      Object localObject = this.h;
      if ((localObject != null) && (((MapController)localObject).getBaseMap() != null)) {
        this.h.getBaseMap().OnForeground();
      }
      this.g = false;
      if (this.a.getViewType() == u.a.b)
      {
        localObject = this.k;
        if (localObject != null) {
          ((k)localObject).c();
        }
        super.onResume();
      }
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this == paramView)
    {
      if (paramKeyEvent.getAction() != 0) {
        return false;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 22: 
        this.h.scrollBy(50, 0);
        break;
      case 21: 
        this.h.scrollBy(-50, 0);
        break;
      case 20: 
        this.h.scrollBy(0, 50);
        break;
      case 19: 
        this.h.scrollBy(0, -50);
      }
      return true;
    }
    return false;
  }
  
  public void onMapRenderModeChange(int paramInt)
  {
    if (paramInt == 1)
    {
      requestRender();
      return;
    }
    if (paramInt == 0)
    {
      if (getRenderMode() != 0) {
        setRenderMode(0);
      }
    }
    else if (paramInt == 2)
    {
      p localp = this.v;
      if (localp != null) {
        localp.a();
      }
    }
  }
  
  public void onPause()
  {
    if (this.f) {
      return;
    }
    if (OpenLogUtil.isMapLogEnable()) {
      b.a().a("BasicMap onPause");
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((k)localObject).b();
    }
    localObject = this.h;
    if (localObject != null) {
      ((MapController)localObject).onPause();
    }
    localObject = this.s.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((n)((Iterator)localObject).next()).b(this);
    }
    super.onPause();
    this.f = true;
  }
  
  public void onRecycle()
  {
    MapController localMapController = this.h;
    if ((localMapController != null) && (localMapController.getBaseMap() != null)) {
      this.h.getBaseMap().ResetImageRes();
    }
  }
  
  public void onRequestRender()
  {
    requestRender();
  }
  
  public void onResume()
  {
    if (this.f)
    {
      if (OpenLogUtil.isMapLogEnable())
      {
        localObject = b.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("BasicMap onResume isInited = ");
        localStringBuilder.append(this.m);
        ((b)localObject).a(localStringBuilder.toString());
      }
      if (!this.m) {
        return;
      }
      Object localObject = this.k;
      if (localObject != null) {
        ((k)localObject).c();
      }
      localObject = this.h;
      if (localObject != null) {
        ((MapController)localObject).onResume();
      }
      localObject = this.s.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((n)((Iterator)localObject).next()).a(this);
      }
      setRenderMode(1);
      super.onResume();
      this.f = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = getMapStatus();
    int i2 = paramMotionEvent.getPointerCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = (int)paramMotionEvent.getX(i1);
      int i4 = (int)paramMotionEvent.getY(i1);
      if (localObject != null)
      {
        MapStatus.WinRound localWinRound = ((MapStatus)localObject).winRound;
        if ((i3 >= localWinRound.left) && (i3 <= localWinRound.right) && (i4 >= localWinRound.top))
        {
          if (i4 > localWinRound.bottom) {
            return false;
          }
          i1 += 1;
          continue;
        }
      }
      return false;
    }
    try
    {
      localObject = this.u;
      if ((localObject != null) && (((GestureDetector)localObject).onTouchEvent(paramMotionEvent))) {
        return true;
      }
      localObject = this.h;
      if (localObject != null)
      {
        boolean bool = ((MapController)localObject).handleTouchEvent(paramMotionEvent);
        if (bool) {
          return true;
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    catch (Exception localException)
    {
      label151:
      break label151;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void refresh(Overlay paramOverlay)
  {
    if (paramOverlay != null)
    {
      if (this.h == null) {
        return;
      }
      if ((paramOverlay instanceof ItemizedOverlay))
      {
        localObject = (ItemizedOverlay)paramOverlay;
        if (((ItemizedOverlay)localObject).b())
        {
          if (((ItemizedOverlay)localObject).getAllItem().size() <= 0)
          {
            this.h.getBaseMap().ClearLayer(paramOverlay.mLayerID);
            this.h.getBaseMap().ShowLayers(paramOverlay.mLayerID, false);
          }
          else
          {
            this.h.getBaseMap().ShowLayers(paramOverlay.mLayerID, true);
          }
          this.h.getBaseMap().UpdateLayers(paramOverlay.mLayerID);
          ((ItemizedOverlay)localObject).b(false);
        }
      }
      Object localObject = this.h;
      if ((localObject != null) && (((MapController)localObject).getBaseMap() != null)) {
        this.h.getBaseMap().UpdateLayers(paramOverlay.mLayerID);
      }
    }
  }
  
  public boolean removeBmLayer(BmLayer paramBmLayer)
  {
    if (paramBmLayer != null) {
      try
      {
        Object localObject = this.h;
        if (localObject != null)
        {
          localObject = ((MapController)localObject).getBaseMap();
          if (localObject == null) {
            return false;
          }
          ((AppBaseMap)localObject).removeBmLayer(paramBmLayer.b());
          try
          {
            this.o.remove(paramBmLayer);
            return true;
          }
          finally {}
        }
      }
      finally {}
    }
    return false;
  }
  
  public boolean removeOverlay(Overlay paramOverlay)
  {
    if (paramOverlay != null) {
      try
      {
        Object localObject = this.h;
        if (localObject != null)
        {
          localObject = ((MapController)localObject).getBaseMap();
          if (localObject == null) {
            return false;
          }
          ((AppBaseMap)localObject).ClearLayer(paramOverlay.mLayerID);
          ((AppBaseMap)localObject).ShowLayers(paramOverlay.mLayerID, false);
          ((AppBaseMap)localObject).UpdateLayers(paramOverlay.mLayerID);
          ((AppBaseMap)localObject).RemoveLayer(paramOverlay.mLayerID);
          try
          {
            if ((paramOverlay instanceof ItemizedOverlay))
            {
              this.p.remove(paramOverlay);
            }
            else if ((paramOverlay instanceof InnerOverlay))
            {
              this.p.remove(paramOverlay);
              this.i.a(paramOverlay);
            }
            paramOverlay.mLayerID = 0L;
            return true;
          }
          finally {}
        }
      }
      finally {}
    }
    return false;
  }
  
  public void removeSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    this.t.b(paramSimpleOnGestureListener);
  }
  
  public void removeStateListener(n paramn)
  {
    if (paramn != null) {
      this.s.remove(paramn);
    }
  }
  
  public void saveScreenToLocal(String paramString)
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      localMapController.saveScreenToLocal(paramString);
    }
  }
  
  public void saveScreenToLocal(String paramString, Rect paramRect)
  {
    localObject1 = this.x;
    int i5;
    int i1;
    int i2;
    int i3;
    if (localObject1 != null)
    {
      if (((com.baidu.mapsdkplatform.comapi.map.c)localObject1).h() == null) {
        return;
      }
      localObject2 = null;
      localObject1 = localObject2;
      if (paramRect != null)
      {
        i5 = paramRect.left;
        i1 = this.r;
        i2 = paramRect.bottom;
        if (i1 < i2) {
          i1 = 0;
        } else {
          i1 -= i2;
        }
        i3 = paramRect.width();
        int i4 = paramRect.height();
        if ((i5 >= 0) && (i1 >= 0) && (i3 > 0))
        {
          if (i4 <= 0) {
            return;
          }
          i2 = i3;
          if (i3 > this.q) {
            i2 = Math.abs(paramRect.width()) - (paramRect.right - this.q);
          }
          i3 = i4;
          if (i4 > this.r) {
            i3 = Math.abs(paramRect.height()) - (paramRect.bottom - this.r);
          }
          if ((i5 <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeX()) && (i1 <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeY()))
          {
            localObject1 = localObject2;
            if (i2 == 0) {
              break label265;
            }
            localObject1 = localObject2;
            if (i3 == 0) {
              break label265;
            }
            paramRect = new JSONObject();
          }
        }
      }
    }
    try
    {
      paramRect.put("x", i5);
      paramRect.put("y", i1);
      paramRect.put("width", i2);
      paramRect.put("height", i3);
      localObject1 = paramRect.toString();
    }
    catch (Exception paramRect)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
    this.x.h().SaveScreenToLocal(paramString, null);
    return;
    label265:
    this.x.h().SaveScreenToLocal(paramString, (String)localObject1);
  }
  
  public void setBaseIndoorMap(final boolean paramBoolean)
  {
    if (this.h != null) {
      this.e = paramBoolean;
    }
    C.submit(new e(paramBoolean));
  }
  
  public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.c paramc)
  {
    this.x = paramc;
  }
  
  public void setDefaultLocationLayerData(List<OverlayLocationData> paramList)
  {
    this.l.setLocationLayerData(paramList);
  }
  
  public void setFPS(int paramInt)
  {
    this.a.setFPS(paramInt);
  }
  
  public void setFirstFrameListener(e parame)
  {
    k localk = this.k;
    if (localk != null) {
      localk.a(parame);
    }
  }
  
  public void setGeoRound(MapStatus.GeoBound paramGeoBound) {}
  
  public boolean setItsPreTime(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.y == paramInt1) && (this.z == paramInt2) && (this.A == paramInt3)) {
      return true;
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((MapController)localObject).getBaseMap();
      if (localObject != null)
      {
        this.y = paramInt1;
        this.z = paramInt2;
        this.A = paramInt3;
        return ((AppBaseMap)localObject).SetItsPreTime(paramInt1, paramInt2, paramInt3);
      }
    }
    return false;
  }
  
  public void setMapCenter(GeoPoint paramGeoPoint)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((MapController)localObject).getMapStatus();
      ((MapStatus)localObject).centerPtX = paramGeoPoint.getLongitude();
      ((MapStatus)localObject).centerPtY = paramGeoPoint.getLatitude();
      this.h.setMapStatus((MapStatus)localObject);
    }
  }
  
  public void setMapController(MapController paramMapController)
  {
    if (this.h != null) {
      return;
    }
    this.h = paramMapController;
    this.k.a(paramMapController.getBaseMap());
    this.k.a(true);
    paramMapController = new r(this.h.getBaseMap());
    this.i = paramMapController;
    this.h.setOverlayMapCallBack(paramMapController);
    this.h.setMapViewInterface(this);
    b();
    this.h.setMapRenderModeChangeListener(this);
    this.m = true;
    paramMapController = this.h;
    this.j = new j(paramMapController);
    this.t.a(paramMapController);
  }
  
  public void setMapRenderStableListener(p paramp)
  {
    this.v = paramp;
  }
  
  public void setMapStatus(MapStatus paramMapStatus)
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      localMapController.setMapStatus(paramMapStatus);
    }
  }
  
  public void setMapTo2D(boolean paramBoolean) {}
  
  public void setOnLongPressListener(OnLongPressListener paramOnLongPressListener)
  {
    this.t.a(paramOnLongPressListener);
  }
  
  public void setOverlooking(int paramInt)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((MapController)localObject).getMapStatus();
      ((MapStatus)localObject).overlooking = paramInt;
      this.h.setMapStatus((MapStatus)localObject);
    }
  }
  
  public void setPixelFormatTransparent(boolean paramBoolean)
  {
    SurfaceHolder localSurfaceHolder;
    int i1;
    if (paramBoolean)
    {
      localSurfaceHolder = getHolder();
      i1 = -3;
    }
    else
    {
      localSurfaceHolder = getHolder();
      i1 = -1;
    }
    localSurfaceHolder.setFormat(i1);
  }
  
  public void setRotation(int paramInt)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((MapController)localObject).getMapStatus();
      ((MapStatus)localObject).rotation = paramInt;
      this.h.setMapStatus((MapStatus)localObject);
    }
  }
  
  public void setSatellite(boolean paramBoolean)
  {
    if (this.h != null) {
      this.c = paramBoolean;
    }
    C.submit(new a());
  }
  
  public void setStreetRoad(boolean paramBoolean)
  {
    if (this.h != null) {
      this.d = paramBoolean;
    }
    C.submit(new d());
  }
  
  public void setTraffic(boolean paramBoolean)
  {
    if (this.b == paramBoolean) {
      return;
    }
    if (this.h != null) {
      this.b = paramBoolean;
    }
    C.submit(new c());
  }
  
  public void setWinRound(MapStatus.WinRound paramWinRound)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((MapController)localObject).getMapStatus();
      ((MapStatus)localObject).winRound = paramWinRound;
      this.h.setMapStatus((MapStatus)localObject);
    }
  }
  
  public void setZoomLevel(float paramFloat)
  {
    if (this.h == null) {
      return;
    }
    int i1 = 21;
    if (getController().getFocusedBaseIndoorMapInfo() != null) {
      i1 = 22;
    }
    float f1;
    if (paramFloat < 4.0F)
    {
      f1 = 4.0F;
    }
    else
    {
      float f2 = i1;
      f1 = paramFloat;
      if (paramFloat > f2) {
        f1 = f2;
      }
    }
    MapStatus localMapStatus = getMapStatus();
    if (localMapStatus != null)
    {
      localMapStatus.level = f1;
      animateTo(localMapStatus, 300);
    }
  }
  
  public void setZoomLevel(int paramInt)
  {
    setZoomLevel(paramInt);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((MapController)localObject).updateDrawFPS();
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((k)localObject).r = paramInt2;
      ((k)localObject).s = paramInt3;
      ((k)localObject).t = 0;
    }
    this.q = paramInt2;
    this.r = paramInt3;
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    if (this.h != null)
    {
      paramSurfaceHolder = getMapStatus();
      if (paramSurfaceHolder != null)
      {
        localObject = paramSurfaceHolder.winRound;
        ((MapStatus.WinRound)localObject).left = 0;
        ((MapStatus.WinRound)localObject).top = 0;
        ((MapStatus.WinRound)localObject).bottom = paramInt3;
        ((MapStatus.WinRound)localObject).right = paramInt2;
        if (!this.n)
        {
          this.h.setMapStatus(paramSurfaceHolder, false);
        }
        else
        {
          this.n = false;
          this.h.setMapStatusWithAnimation(paramSurfaceHolder, 4, 0);
        }
        if (this.h.getMapViewSurfaceListener() != null) {
          this.h.getMapViewSurfaceListener().a(paramInt2, paramInt3);
        }
      }
      paramSurfaceHolder = getMapStatus();
      localObject = paramSurfaceHolder.winRound;
      this.q = Math.abs(((MapStatus.WinRound)localObject).right - ((MapStatus.WinRound)localObject).left);
      paramSurfaceHolder = paramSurfaceHolder.winRound;
      paramInt1 = Math.abs(paramSurfaceHolder.bottom - paramSurfaceHolder.top);
      this.r = paramInt1;
      this.h.setScreenSize(this.q, paramInt1);
      if ((this.h.isNaviMode()) && (this.h.getNaviMapViewListener() != null)) {
        this.h.getNaviMapViewListener().resizeScreen(paramInt2, paramInt3);
      }
    }
    paramSurfaceHolder = this.x;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.b(this.q, this.r);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      localMapController.updateDrawFPS();
    }
    super.surfaceCreated(paramSurfaceHolder);
    if ((paramSurfaceHolder != null) && (!paramSurfaceHolder.getSurface().isValid())) {
      surfaceDestroyed(paramSurfaceHolder);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    MapController localMapController = this.h;
    if (localMapController != null) {
      localMapController.updateDrawFPS();
    }
    super.surfaceDestroyed(paramSurfaceHolder);
  }
  
  public boolean switchOverlay(Overlay paramOverlay1, Overlay paramOverlay2)
  {
    if ((paramOverlay1 != null) && (paramOverlay2 != null))
    {
      Object localObject = this.h;
      if (localObject == null) {
        return false;
      }
      localObject = ((MapController)localObject).getBaseMap();
      if (localObject == null) {
        return false;
      }
      return ((AppBaseMap)localObject).SwitchLayer(paramOverlay1.mLayerID, paramOverlay2.mLayerID);
    }
    return false;
  }
  
  public void unInit()
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = ((com.baidu.mapsdkplatform.comapi.map.c)localObject).q;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          x localx = (x)((Iterator)localObject).next();
          if (localx != null) {
            localx.a();
          }
        }
      }
      this.x.g();
      this.x = null;
    }
    this.h.unInit();
    this.h = null;
    this.i.a();
    this.i = null;
    this.j = null;
    this.k = null;
    if (OpenLogUtil.isMapLogEnable()) {
      b.a().a("BasicMap surfaceView unInit");
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      Object localObject = MapSurfaceView.this.h;
      if (localObject != null)
      {
        localObject = ((MapController)localObject).getBaseMap();
        if (localObject != null) {
          ((AppBaseMap)localObject).ShowSatelliteMap(MapSurfaceView.a(MapSurfaceView.this));
        }
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      Object localObject = MapSurfaceView.this.h;
      if (localObject != null)
      {
        localObject = ((MapController)localObject).getBaseMap();
        if (localObject != null) {
          ((AppBaseMap)localObject).ShowTrafficMap(MapSurfaceView.b(MapSurfaceView.this));
        }
      }
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      Object localObject = MapSurfaceView.this.h;
      if (localObject != null)
      {
        localObject = ((MapController)localObject).getBaseMap();
        if (localObject != null) {
          ((AppBaseMap)localObject).ShowTrafficMap(MapSurfaceView.b(MapSurfaceView.this));
        }
      }
    }
  }
  
  class d
    implements Runnable
  {
    d() {}
    
    public void run()
    {
      Object localObject = MapSurfaceView.this.h;
      if (localObject != null)
      {
        localObject = ((MapController)localObject).getBaseMap();
        if (localObject != null) {
          ((AppBaseMap)localObject).ShowStreetRoadMap(MapSurfaceView.c(MapSurfaceView.this));
        }
      }
    }
  }
  
  class e
    implements Runnable
  {
    e(boolean paramBoolean) {}
    
    public void run()
    {
      Object localObject = MapSurfaceView.this.h;
      if (localObject != null)
      {
        localObject = ((MapController)localObject).getBaseMap();
        if (localObject != null) {
          ((AppBaseMap)localObject).ShowBaseIndoorMap(paramBoolean);
        }
      }
    }
  }
  
  private class f
    implements f.g
  {
    private int a = 12440;
    
    private f() {}
    
    private String a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return b(paramInt);
      case 12302: 
        return "EGL_CONTEXT_LOST";
      case 12301: 
        return "EGL_BAD_SURFACE";
      case 12300: 
        return "EGL_BAD_PARAMETER";
      case 12299: 
        return "EGL_BAD_NATIVE_WINDOW";
      case 12298: 
        return "EGL_BAD_NATIVE_PIXMAP";
      case 12297: 
        return "EGL_BAD_MATCH";
      case 12296: 
        return "EGL_BAD_DISPLAY";
      case 12295: 
        return "EGL_BAD_CURRENT_SURFACE";
      case 12294: 
        return "EGL_BAD_CONTEXT";
      case 12293: 
        return "EGL_BAD_CONFIG";
      case 12292: 
        return "EGL_BAD_ATTRIBUTE";
      case 12291: 
        return "EGL_BAD_ALLOC";
      case 12290: 
        return "EGL_BAD_ACCESS";
      case 12289: 
        return "EGL_NOT_INITIALIZED";
      }
      return "EGL_SUCCESS";
    }
    
    private String b(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0x");
      localStringBuilder.append(Integer.toHexString(paramInt));
      return localStringBuilder.toString();
    }
    
    public String a(String paramString, int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" failed: ");
      localStringBuilder.append(a(paramInt));
      return localStringBuilder.toString();
    }
    
    public void b(String paramString, int paramInt)
    {
      throw new RuntimeException(a(paramString, paramInt));
    }
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int i = this.a;
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        MapSurfaceView.this.onRecycle();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("display:");
      localStringBuilder.append(paramEGLDisplay);
      localStringBuilder.append(" context: ");
      localStringBuilder.append(paramEGLContext);
      Log.e("MapContextFactory", localStringBuilder.toString());
      b("eglDestroyContex", paramEGL10.eglGetError());
      throw null;
    }
  }
  
  private class g
    extends GestureDetector.SimpleOnGestureListener
  {
    private g() {}
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      super.onLongPress(paramMotionEvent);
      Object localObject1 = MapSurfaceView.this.h;
      if ((localObject1 != null) && (((MapController)localObject1).getBaseMap() != null))
      {
        localObject1 = MapSurfaceView.this.h;
        if (!((MapController)localObject1).mIsMapLoadFinish) {
          return;
        }
        Object localObject3 = ((MapController)localObject1).getBaseMap().GetNearlyObjID(-1L, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), MapSurfaceView.this.h.nearlyRadius);
        Object localObject2 = null;
        localObject1 = null;
        if ((localObject3 != null) && (!((String)localObject3).equals("")))
        {
          localObject2 = MapSurfaceView.this;
          if (((MapSurfaceView)localObject2).h.mListeners != null)
          {
            if (((MapSurfaceView)localObject2).getProjection() != null) {
              localObject1 = MapSurfaceView.this.getProjection().fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
            }
            paramMotionEvent = MapSurfaceView.this.h.mListeners.iterator();
          }
        }
        else
        {
          while (paramMotionEvent.hasNext())
          {
            localObject2 = (x)paramMotionEvent.next();
            if (localObject2 != null) {
              if (((x)localObject2).a((String)localObject3))
              {
                MapSurfaceView.this.h.mHasMapObjDraging = true;
              }
              else if (localObject1 != null)
              {
                ((x)localObject2).d((GeoPoint)localObject1);
                continue;
                localObject3 = MapSurfaceView.this;
                if (((MapSurfaceView)localObject3).h.mListeners != null)
                {
                  localObject1 = localObject2;
                  if (((MapSurfaceView)localObject3).getProjection() != null) {
                    localObject1 = MapSurfaceView.this.getProjection().fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
                  }
                  if (localObject1 == null) {
                    return;
                  }
                  paramMotionEvent = MapSurfaceView.this.h.mListeners.iterator();
                  while (paramMotionEvent.hasNext())
                  {
                    localObject2 = (x)paramMotionEvent.next();
                    if (localObject2 != null) {
                      ((x)localObject2).d((GeoPoint)localObject1);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.MapSurfaceView
 * JD-Core Version:    0.7.0.1
 */