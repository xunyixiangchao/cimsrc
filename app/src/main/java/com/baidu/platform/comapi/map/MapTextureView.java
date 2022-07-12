package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.TextureView;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmObject;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class MapTextureView
  extends g
  implements MapRenderModeChangeListener, MapViewInterface, w
{
  private d A;
  protected com.baidu.mapsdkplatform.comapi.map.c o;
  protected MapController p = null;
  protected r q = null;
  protected j r = null;
  protected k s = null;
  int t;
  int u;
  private List<BmLayer> v = new ArrayList();
  protected List<Overlay> w = new ArrayList();
  protected p x;
  protected y y;
  protected GestureDetector z;
  
  public MapTextureView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MapTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MapTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setEGLContextClientVersion(2);
    this.y = new y();
    this.z = new GestureDetector(paramContext, this.y);
    this.y.a(new c(null));
  }
  
  private boolean a(long paramLong, BmLayer paramBmLayer)
  {
    if (paramBmLayer != null) {
      try
      {
        Object localObject = this.p;
        if (localObject != null)
        {
          localObject = ((MapController)localObject).getBaseMap();
          if (localObject == null) {
            return false;
          }
          try
          {
            if (this.v.contains(paramBmLayer)) {
              return false;
            }
            this.v.add(paramBmLayer);
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
  
  public boolean addBmLayer(BmLayer paramBmLayer)
  {
    return a(0L, paramBmLayer);
  }
  
  public boolean addBmLayerBelow(Overlay paramOverlay, BmLayer paramBmLayer)
  {
    if (paramOverlay != null) {}
    for (long l = paramOverlay.mLayerID;; l = 0L) {
      return a(l, paramBmLayer);
    }
  }
  
  public boolean addOverlay(Overlay paramOverlay)
  {
    if (paramOverlay != null)
    {
      Object localObject = this.p;
      if (localObject == null) {
        return false;
      }
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
        if (((InnerOverlay)localObject).addedToMapView())
        {
          this.w.add(paramOverlay);
          this.q.a((InnerOverlay)localObject);
          return true;
        }
        return false;
      }
      if ((paramOverlay instanceof ItemizedOverlay))
      {
        ItemizedOverlay localItemizedOverlay = (ItemizedOverlay)paramOverlay;
        long l = ((AppBaseMap)localObject).AddLayer(localItemizedOverlay.getUpdateType(), 0, "item");
        paramOverlay.mLayerID = l;
        if (l == 0L) {
          return false;
        }
        this.w.add(paramOverlay);
        localItemizedOverlay.c();
        ((AppBaseMap)localObject).SetLayersClickable(paramOverlay.mLayerID, true);
        ((AppBaseMap)localObject).ShowLayers(paramOverlay.mLayerID, true);
        ((AppBaseMap)localObject).UpdateLayers(paramOverlay.mLayerID);
        return true;
      }
    }
    return false;
  }
  
  public void animateTo(MapStatus paramMapStatus, int paramInt)
  {
    MapController localMapController = this.p;
    if (localMapController != null) {
      localMapController.setMapStatusWithAnimation(paramMapStatus, paramInt);
    }
  }
  
  public void attachBaseMapController(MapController paramMapController)
  {
    k localk = new k(this, this);
    this.s = localk;
    this.p = paramMapController;
    localk.a(paramMapController.getBaseMap());
    setEGLContextFactory(new b(null));
    setRenderer(this.s);
    setRenderMode(0);
    this.s.a(true);
    paramMapController = new r(this.p.getBaseMap());
    this.q = paramMapController;
    this.p.setOverlayMapCallBack(paramMapController);
    this.p.setMapViewInterface(this);
    e();
    this.p.setMapRenderModeChangeListener(this);
    paramMapController = this.p;
    this.r = new j(paramMapController);
    this.y.a(paramMapController);
  }
  
  protected void d()
  {
    MapController localMapController = this.p;
    if (localMapController == null) {
      return;
    }
    if (localMapController.getBaseMap() == null) {
      return;
    }
    if (this.q == null) {
      return;
    }
    this.w.clear();
    this.q.a();
  }
  
  public void destroyForMultiViews()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      ((MapController)localObject).unInitForMultiTextureView();
      this.p = null;
    }
    localObject = this.q;
    if (localObject != null)
    {
      ((r)localObject).a();
      this.q = null;
    }
    this.r = null;
  }
  
  public void doCaptureMapView(c paramc, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    this.s.a(paramc, paramInt1, paramInt2, paramConfig);
  }
  
  public void doCaptureMapView(c paramc, Rect paramRect, Bitmap.Config paramConfig)
  {
    if (paramRect != null)
    {
      int n = paramRect.left;
      int i = this.u;
      int j = paramRect.bottom;
      if (i < j) {
        i = 0;
      } else {
        i -= j;
      }
      int m = paramRect.width();
      int k = paramRect.height();
      if ((n >= 0) && (i >= 0) && (m > 0))
      {
        if (k <= 0) {
          return;
        }
        j = m;
        if (m > this.t) {
          j = Math.abs(paramRect.width()) - (paramRect.right - this.t);
        }
        if (k > this.u) {
          k = Math.abs(paramRect.height()) - (paramRect.bottom - this.u);
        }
        if (n <= SysOSUtil.getScreenSizeX())
        {
          if (i > SysOSUtil.getScreenSizeY()) {
            return;
          }
          this.s.a(paramc, n, i, j, k, paramConfig);
        }
      }
    }
  }
  
  protected void e()
  {
    MapController localMapController = this.p;
    if (localMapController == null) {
      return;
    }
    if (localMapController.getBaseMap() == null) {
      return;
    }
    d();
  }
  
  public boolean enable3D()
  {
    return false;
  }
  
  public com.baidu.mapsdkplatform.comapi.map.c getBaseMap()
  {
    return this.o;
  }
  
  public List<BmLayer> getBmlayers()
  {
    return this.v;
  }
  
  public MapController getController()
  {
    return this.p;
  }
  
  public MapStatus getCurrentMapStatus()
  {
    MapController localMapController = this.p;
    if (localMapController != null) {
      return localMapController.getCurrentMapStatus();
    }
    return null;
  }
  
  public float getCurrentZoomLevel()
  {
    MapController localMapController = this.p;
    if (localMapController != null) {
      return localMapController.getCurrentZoomLevel();
    }
    return 0.0F;
  }
  
  public MapStatus.GeoBound getGeoRound()
  {
    MapController localMapController = this.p;
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
    Object localObject = this.p;
    if (localObject == null) {
      return null;
    }
    localObject = ((MapController)localObject).getMapStatus();
    return new GeoPoint(((MapStatus)localObject).centerPtY, ((MapStatus)localObject).centerPtX);
  }
  
  public int getMapRotation()
  {
    MapController localMapController = this.p;
    if (localMapController == null) {
      return 0;
    }
    return localMapController.getMapStatus().rotation;
  }
  
  public MapStatus getMapStatus()
  {
    MapController localMapController = this.p;
    if (localMapController != null) {
      return localMapController.getMapStatus();
    }
    return null;
  }
  
  public Overlay getOverlay(int paramInt)
  {
    try
    {
      Iterator localIterator = this.w.iterator();
      while (localIterator.hasNext())
      {
        Overlay localOverlay = (Overlay)localIterator.next();
        int i = localOverlay.mType;
        if (i == paramInt) {
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
      Iterator localIterator = this.w.iterator();
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
    return this.w;
  }
  
  public int getOverlooking()
  {
    MapController localMapController = this.p;
    if (localMapController == null) {
      return 0;
    }
    return localMapController.getMapStatus().overlooking;
  }
  
  public Overlay getPopupOverlay()
  {
    return null;
  }
  
  public Projection getProjection()
  {
    return this.r;
  }
  
  public MapStatus.WinRound getWinRound()
  {
    MapController localMapController = this.p;
    if (localMapController == null) {
      return null;
    }
    return localMapController.getMapStatus().winRound;
  }
  
  public float getZoomLevel()
  {
    MapController localMapController = this.p;
    if (localMapController != null) {
      return localMapController.getZoomLevel();
    }
    return 0.0F;
  }
  
  public float getZoomToBound(MapBound paramMapBound)
  {
    return getZoomToBound(paramMapBound, this.t, this.u);
  }
  
  public float getZoomToBound(MapBound paramMapBound, int paramInt1, int paramInt2)
  {
    if (this.p == null) {
      return 0.0F;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("left", paramMapBound.leftBottomPt.getIntX());
    localBundle.putInt("bottom", paramMapBound.leftBottomPt.getIntY());
    localBundle.putInt("right", paramMapBound.rightTopPt.getIntX());
    localBundle.putInt("top", paramMapBound.rightTopPt.getIntY());
    return this.p.getZoomToBound(localBundle, paramInt1, paramInt2);
  }
  
  public float getZoomToBoundF(MapBound paramMapBound)
  {
    return getZoomToBoundF(paramMapBound, this.t, this.u);
  }
  
  public float getZoomToBoundF(MapBound paramMapBound, int paramInt1, int paramInt2)
  {
    if (this.p == null) {
      return 0.0F;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("left", paramMapBound.leftBottomPt.getIntX());
    localBundle.putInt("bottom", paramMapBound.leftBottomPt.getIntY());
    localBundle.putInt("right", paramMapBound.rightTopPt.getIntX());
    localBundle.putInt("top", paramMapBound.rightTopPt.getIntY());
    return this.p.getZoomToBoundF(localBundle);
  }
  
  public boolean isBaseIndoorMap()
  {
    return false;
  }
  
  public boolean isSatellite()
  {
    return false;
  }
  
  public boolean isStreetRoad()
  {
    return false;
  }
  
  public boolean isTraffic()
  {
    return false;
  }
  
  public void listenMapRenderMessage(d paramd)
  {
    this.A = paramd;
  }
  
  public void onDestroy()
  {
    Object localObject = this.o;
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
      this.o.g();
      this.o = null;
    }
    this.p.unInit();
    this.p = null;
    this.q.a();
    this.q = null;
    this.r = null;
  }
  
  public void onMapRenderModeChange(int paramInt)
  {
    Object localObject = this.A;
    if (localObject != null) {
      ((d)localObject).a(paramInt);
    }
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
      localObject = this.x;
      if (localObject != null) {
        ((p)localObject).a();
      }
    }
  }
  
  public void onPause()
  {
    MapController localMapController = this.p;
    if (localMapController != null) {
      localMapController.getBaseMap().OnPause();
    }
    super.onPause();
  }
  
  public void onRecycle()
  {
    MapController localMapController = this.p;
    if ((localMapController != null) && (localMapController.getBaseMap() != null)) {
      this.p.getBaseMap().ResetImageRes();
    }
  }
  
  public void onRequestRender() {}
  
  public void onResume()
  {
    MapController localMapController = this.p;
    if (localMapController != null) {
      localMapController.getBaseMap().OnResume();
    }
    super.onResume();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    this.t = paramInt1;
    this.u = paramInt2;
    paramSurfaceTexture = this.p;
    if (paramSurfaceTexture != null)
    {
      if (paramSurfaceTexture.getMapViewSurfaceListener() != null) {
        this.p.getMapViewSurfaceListener().a(paramInt1, paramInt2);
      }
      paramSurfaceTexture = getMapStatus();
      MapStatus.WinRound localWinRound = paramSurfaceTexture.winRound;
      this.t = Math.abs(localWinRound.right - localWinRound.left);
      paramSurfaceTexture = paramSurfaceTexture.winRound;
      this.u = Math.abs(paramSurfaceTexture.bottom - paramSurfaceTexture.top);
    }
    paramSurfaceTexture = this.o;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.b(this.t, this.u);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    this.t = paramInt1;
    this.u = paramInt2;
    paramSurfaceTexture = this.s;
    paramSurfaceTexture.r = paramInt1;
    paramSurfaceTexture.s = paramInt2;
    paramSurfaceTexture.t = 0;
    if (this.p != null)
    {
      paramSurfaceTexture = getMapStatus();
      MapStatus.WinRound localWinRound = paramSurfaceTexture.winRound;
      localWinRound.left = 0;
      localWinRound.top = 0;
      localWinRound.bottom = paramInt2;
      localWinRound.right = paramInt1;
      this.p.setMapStatusWithAnimation(paramSurfaceTexture, 4, 0);
      if (this.p.getMapViewSurfaceListener() != null) {
        this.p.getMapViewSurfaceListener().a(paramInt1, paramInt2);
      }
      paramSurfaceTexture = getMapStatus();
      localWinRound = paramSurfaceTexture.winRound;
      this.t = Math.abs(localWinRound.right - localWinRound.left);
      paramSurfaceTexture = paramSurfaceTexture.winRound;
      paramInt1 = Math.abs(paramSurfaceTexture.bottom - paramSurfaceTexture.top);
      this.u = paramInt1;
      this.p.setScreenSize(this.t, paramInt1);
    }
    paramSurfaceTexture = this.o;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.b(this.t, this.u);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    super.onSurfaceTextureUpdated(paramSurfaceTexture);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      Object localObject = this.z;
      if ((localObject != null) && (((GestureDetector)localObject).onTouchEvent(paramMotionEvent))) {
        return true;
      }
      localObject = this.p;
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
      label46:
      break label46;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void refresh(Overlay paramOverlay)
  {
    if (paramOverlay != null)
    {
      if (this.p == null) {
        return;
      }
      if ((paramOverlay instanceof ItemizedOverlay))
      {
        localObject = (ItemizedOverlay)paramOverlay;
        if (((ItemizedOverlay)localObject).b())
        {
          if (((ItemizedOverlay)localObject).getAllItem().size() <= 0)
          {
            this.p.getBaseMap().ClearLayer(paramOverlay.mLayerID);
            this.p.getBaseMap().ShowLayers(paramOverlay.mLayerID, false);
          }
          else
          {
            this.p.getBaseMap().ShowLayers(paramOverlay.mLayerID, true);
          }
          this.p.getBaseMap().UpdateLayers(paramOverlay.mLayerID);
          ((ItemizedOverlay)localObject).b(false);
        }
      }
      Object localObject = this.p;
      if ((localObject != null) && (((MapController)localObject).getBaseMap() != null)) {
        this.p.getBaseMap().UpdateLayers(paramOverlay.mLayerID);
      }
    }
  }
  
  public boolean removeBmLayer(BmLayer paramBmLayer)
  {
    if (paramBmLayer != null) {
      try
      {
        Object localObject = this.p;
        if (localObject != null)
        {
          localObject = ((MapController)localObject).getBaseMap();
          if (localObject == null) {
            return false;
          }
          ((AppBaseMap)localObject).removeBmLayer(paramBmLayer.b());
          try
          {
            this.v.remove(paramBmLayer);
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
    if (paramOverlay != null)
    {
      Object localObject = this.p;
      if (localObject == null) {
        return false;
      }
      localObject = ((MapController)localObject).getBaseMap();
      if (localObject == null) {
        return false;
      }
      ((AppBaseMap)localObject).ClearLayer(paramOverlay.mLayerID);
      ((AppBaseMap)localObject).ShowLayers(paramOverlay.mLayerID, false);
      ((AppBaseMap)localObject).UpdateLayers(paramOverlay.mLayerID);
      ((AppBaseMap)localObject).RemoveLayer(paramOverlay.mLayerID);
      if ((paramOverlay instanceof ItemizedOverlay))
      {
        this.w.remove(paramOverlay);
      }
      else if ((paramOverlay instanceof InnerOverlay))
      {
        this.w.remove(paramOverlay);
        this.q.a(paramOverlay);
      }
      paramOverlay.mLayerID = 0L;
      return true;
    }
    return false;
  }
  
  public void saveScreenToLocal(String paramString) {}
  
  public void setBaseIndoorMap(boolean paramBoolean) {}
  
  public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.c paramc)
  {
    this.o = paramc;
  }
  
  public void setGeoRound(MapStatus.GeoBound paramGeoBound) {}
  
  public void setMapCenter(GeoPoint paramGeoPoint)
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((MapController)localObject).getMapStatus();
      ((MapStatus)localObject).centerPtX = paramGeoPoint.getLongitude();
      ((MapStatus)localObject).centerPtY = paramGeoPoint.getLatitude();
      this.p.setMapStatus((MapStatus)localObject);
    }
  }
  
  public void setMapRenderStableListener(p paramp)
  {
    this.x = paramp;
  }
  
  public void setMapStatus(MapStatus paramMapStatus)
  {
    MapController localMapController = this.p;
    if (localMapController != null) {
      localMapController.setMapStatus(paramMapStatus);
    }
  }
  
  public void setMapTo2D(boolean paramBoolean) {}
  
  public void setOverlooking(int paramInt)
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((MapController)localObject).getMapStatus();
      ((MapStatus)localObject).overlooking = paramInt;
      this.p.setMapStatus((MapStatus)localObject);
    }
  }
  
  public void setRotation(int paramInt)
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((MapController)localObject).getMapStatus();
      ((MapStatus)localObject).rotation = paramInt;
      this.p.setMapStatus((MapStatus)localObject);
    }
  }
  
  public void setSatellite(boolean paramBoolean) {}
  
  public void setStreetRoad(boolean paramBoolean) {}
  
  public void setTraffic(boolean paramBoolean)
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((MapController)localObject).getBaseMap();
      if (localObject != null) {
        ((AppBaseMap)localObject).ShowTrafficMap(paramBoolean);
      }
    }
  }
  
  public void setWinRound(MapStatus.WinRound paramWinRound)
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((MapController)localObject).getMapStatus();
      ((MapStatus)localObject).winRound = paramWinRound;
      this.p.setMapStatus((MapStatus)localObject);
    }
  }
  
  public void setZoomLevel(float paramFloat)
  {
    if (this.p == null) {
      return;
    }
    int i = 21;
    if (getController().getFocusedBaseIndoorMapInfo() != null) {
      i = 22;
    }
    float f;
    if (paramFloat < 4.0F)
    {
      f = 4.0F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat > i) {
        f = 21.0F;
      }
    }
    MapStatus localMapStatus = getMapStatus();
    if (localMapStatus != null)
    {
      localMapStatus.level = f;
      animateTo(localMapStatus, 300);
    }
  }
  
  public void setZoomLevel(int paramInt)
  {
    setZoomLevel(paramInt);
  }
  
  public boolean switchOverlay(Overlay paramOverlay1, Overlay paramOverlay2)
  {
    if ((paramOverlay1 != null) && (paramOverlay2 != null))
    {
      Object localObject = this.p;
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
  
  public void unListenMapRenderMessage()
  {
    this.A = null;
  }
  
  private class b
    implements GLSurfaceView.EGLContextFactory
  {
    private int a = 12440;
    
    private b() {}
    
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
        MapTextureView.this.onRecycle();
        return;
      }
      b("eglDestroyContex", paramEGL10.eglGetError());
      throw null;
    }
  }
  
  private class c
    extends GestureDetector.SimpleOnGestureListener
  {
    private c() {}
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      super.onLongPress(paramMotionEvent);
      Object localObject1 = MapTextureView.this.p;
      if ((localObject1 != null) && (((MapController)localObject1).getBaseMap() != null))
      {
        localObject1 = MapTextureView.this.p;
        if (!((MapController)localObject1).mIsMapLoadFinish) {
          return;
        }
        Object localObject3 = ((MapController)localObject1).getBaseMap().GetNearlyObjID(-1L, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), MapTextureView.this.p.nearlyRadius);
        Object localObject2 = null;
        localObject1 = null;
        if ((localObject3 != null) && (!((String)localObject3).equals("")))
        {
          localObject2 = MapTextureView.this;
          if (((MapTextureView)localObject2).p.mListeners != null)
          {
            if (((MapTextureView)localObject2).getProjection() != null) {
              localObject1 = MapTextureView.this.getProjection().fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
            }
            paramMotionEvent = MapTextureView.this.p.mListeners.iterator();
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
                MapTextureView.this.p.mHasMapObjDraging = true;
              }
              else if (localObject1 != null)
              {
                ((x)localObject2).d((GeoPoint)localObject1);
                continue;
                localObject3 = MapTextureView.this;
                if (((MapTextureView)localObject3).p.mListeners != null)
                {
                  localObject1 = localObject2;
                  if (((MapTextureView)localObject3).getProjection() != null) {
                    localObject1 = MapTextureView.this.getProjection().fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
                  }
                  if (localObject1 == null) {
                    return;
                  }
                  paramMotionEvent = MapTextureView.this.p.mListeners.iterator();
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
  
  public static abstract interface d
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.MapTextureView
 * JD-Core Version:    0.7.0.1
 */