package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.map.MapLayer;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.InnerOverlay;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.Overlay;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.map.Projection;
import com.baidu.platform.comapi.map.d;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class c
  implements MapSDKLayerDataInterface
{
  public static float J = 1096.0F;
  private static int K;
  private static int L;
  private Queue<b> A = new LinkedList();
  public MapStatusUpdate B = null;
  private boolean C = false;
  private boolean D = false;
  private boolean E = false;
  private MapController F;
  private LocationOverlay G;
  private d H;
  private boolean I = false;
  public float a = 21.0F;
  public float b = 4.0F;
  public float c = 21.0F;
  private boolean d;
  private boolean e;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = true;
  boolean k = true;
  boolean l = true;
  private boolean m = true;
  private x n;
  private w o;
  private Context p;
  public List<com.baidu.platform.comapi.map.x> q;
  AppBaseMap r;
  private List<b> s;
  private HashMap<MapLayer, b> t;
  private v u;
  private h v;
  private i w;
  private int x;
  private int y;
  private boolean z = false;
  
  public c(Context paramContext, MapSurfaceView paramMapSurfaceView, q paramq, String paramString, int paramInt)
  {
    this.p = paramContext;
    this.q = new CopyOnWriteArrayList();
    paramContext = new MapController();
    this.F = paramContext;
    paramContext.initAppBaseMap();
    a(this.F);
    paramMapSurfaceView.setMapController(this.F);
    this.r = this.F.getBaseMap();
    a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.F.getMapId());
    D();
    a(paramq);
    this.F.getBaseMap().SetSDKLayerCallback(this);
    this.F.onResume();
  }
  
  public c(Context paramContext, MapTextureView paramMapTextureView, q paramq, String paramString, int paramInt)
  {
    this.p = paramContext;
    this.q = new CopyOnWriteArrayList();
    paramContext = new MapController();
    this.F = paramContext;
    paramContext.initAppBaseMap();
    a(this.F);
    paramMapTextureView.attachBaseMapController(this.F);
    this.r = this.F.getBaseMap();
    D();
    this.r = this.F.getBaseMap();
    a(paramq);
    this.F.getBaseMap().SetSDKLayerCallback(this);
    this.F.onResume();
  }
  
  private void C()
  {
    try
    {
      K = (int)(SysOSUtil.getInstance().getDensity() * 40.0F);
      L = (int)(SysOSUtil.getInstance().getDensity() * 40.0F);
      JSONObject localJSONObject1 = new JSONObject();
      Object localObject = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("x", K);
      localJSONObject2.put("y", K);
      localJSONObject2.put("hidetime", 1000);
      ((JSONArray)localObject).put(localJSONObject2);
      localJSONObject1.put("dataset", localObject);
      localObject = this.H;
      if (localObject != null)
      {
        ((d)localObject).setData(localJSONObject1.toString());
        this.H.UpdateOverlay();
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  private void D()
  {
    this.s = new CopyOnWriteArrayList();
    this.t = new HashMap();
    Object localObject = new v();
    this.u = ((v)localObject);
    a((b)localObject);
    this.t.put(MapLayer.MAP_LAYER_OVERLAY, this.u);
    v(false);
    localObject = this.r;
    if (localObject != null) {
      ((AppBaseMap)localObject).setDEMEnable(false);
    }
  }
  
  private void O()
  {
    Object localObject = this.F;
    if (localObject == null) {
      return;
    }
    if (!((MapController)localObject).mIsMoving)
    {
      ((MapController)localObject).mIsMoving = true;
      int i1 = 0;
      ((MapController)localObject).mIsAnimating = false;
      if (this.q != null)
      {
        localObject = t();
        while (i1 < this.q.size())
        {
          com.baidu.platform.comapi.map.x localx = (com.baidu.platform.comapi.map.x)this.q.get(i1);
          if (localx != null) {
            localx.a((s)localObject);
          }
          i1 += 1;
        }
      }
    }
  }
  
  private long a(MapLayer paramMapLayer)
  {
    AppBaseMap localAppBaseMap = this.r;
    long l1 = -1L;
    if (localAppBaseMap == null) {
      return -1L;
    }
    int i1 = a.a[paramMapLayer.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return -1L;
          }
          localAppBaseMap = this.r;
          paramMapLayer = "basepoi";
        }
        else
        {
          localAppBaseMap = this.r;
          paramMapLayer = "poiindoormarklayer";
        }
        return localAppBaseMap.getLayerIDByTag(paramMapLayer);
      }
      paramMapLayer = this.u;
      if (paramMapLayer != null) {
        return paramMapLayer.a;
      }
    }
    else
    {
      paramMapLayer = this.G;
      if (paramMapLayer != null) {
        l1 = paramMapLayer.mLayerID;
      }
    }
    return l1;
  }
  
  private void a()
  {
    Object localObject;
    if ((!this.h) && (!this.e) && (!this.d) && (!this.i))
    {
      float f1 = this.c;
      this.a = f1;
      localObject = this.F;
      if (localObject != null) {
        ((MapController)localObject).mMaxZoomLevel = f1;
      }
    }
    else
    {
      if (this.a > 20.0F)
      {
        this.a = 20.0F;
        localObject = this.F;
        if (localObject != null) {
          ((MapController)localObject).mMaxZoomLevel = 20.0F;
        }
      }
      if (t().a > 20.0F)
      {
        localObject = t();
        ((s)localObject).a = 20.0F;
        a((s)localObject);
      }
    }
  }
  
  private void a(b paramb)
  {
    ??? = this.r;
    if (??? == null) {
      return;
    }
    paramb.a = ((AppBaseMap)???).AddLayer(paramb.c, paramb.d, paramb.b);
    synchronized (this.s)
    {
      this.s.add(paramb);
      return;
    }
  }
  
  private void a(q paramq)
  {
    q localq = paramq;
    if (paramq == null) {
      localq = new q();
    }
    paramq = localq.a;
    boolean bool = localq.f;
    this.j = bool;
    this.m = localq.d;
    this.k = localq.e;
    this.l = localq.g;
    n(bool);
    o(this.m);
    q(this.k);
    t(this.l);
    this.r.SetMapStatus(paramq.a(this));
    this.r.SetMapControlMode(p.a.ordinal());
    bool = localq.b;
    this.f = bool;
    if (bool)
    {
      if (this.H == null)
      {
        this.H = new d(this.r);
        paramq = this.F.getMapView();
        if (paramq != null)
        {
          paramq.addOverlay(this.H);
          C();
        }
      }
      this.r.ShowLayers(this.H.mLayerID, true);
      this.r.ResetImageRes();
    }
    int i1 = localq.c;
    if (i1 == 2) {
      p(true);
    }
    if (i1 == 3)
    {
      if (P()) {
        y(false);
      }
      if (B()) {
        w(false);
      }
      e(false);
      v(false);
    }
  }
  
  private void a(MapController paramMapController)
  {
    synchronized () {}
    Bundle localBundle = new Bundle();
    localBundle.putDouble("level", 12.0D);
    localBundle.putDouble("centerptx", 12958157.98D);
    localBundle.putDouble("centerpty", 4825999.7400000002D);
    localBundle.putDouble("centerptz", 0.0D);
    localBundle.putInt("left", 0);
    localBundle.putInt("top", 0);
    int i1 = SysOSUtil.getInstance().getScreenHeight();
    localBundle.putInt("right", SysOSUtil.getInstance().getScreenWidth());
    localBundle.putInt("bottom", i1);
    localBundle.putString("modulePath", SysOSUtil.getInstance().getOutputDirPath());
    localBundle.putString("appSdcardPath", SysOSUtil.getInstance().getExternalFilesDir());
    localBundle.putString("appCachePath", SysOSUtil.getInstance().getOutputCache());
    localBundle.putString("appSecondCachePath", SysOSUtil.getInstance().getOutputCache());
    localBundle.putInt("mapTmpMax", EnvironmentUtilities.getMapTmpStgMax());
    localBundle.putInt("domTmpMax", EnvironmentUtilities.getDomTmpStgMax());
    localBundle.putInt("itsTmpMax", EnvironmentUtilities.getItsTmpStgMax());
    localBundle.putInt("ssgTmpMax", EnvironmentUtilities.getSsgTmpStgMax());
    paramMapController.initMapResources(localBundle);
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      paramString1 = Class.forName(paramString1);
      Object localObject = paramString1.newInstance();
      paramString1.getMethod(paramString2, new Class[] { Long.TYPE }).invoke(localObject, new Object[] { Long.valueOf(paramLong) });
      return;
    }
    catch (Exception paramString1) {}
  }
  
  private boolean d(Bundle paramBundle)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return false;
    }
    return localAppBaseMap.addSDKTileData(paramBundle);
  }
  
  private boolean g(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return false;
    }
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return false;
    }
    boolean bool = localAppBaseMap.updateSDKTile(paramBundle);
    if (bool)
    {
      u(bool);
      this.r.UpdateLayers(this.n.a);
    }
    return bool;
  }
  
  public void A()
  {
    if (this.r == null) {
      return;
    }
    synchronized (this.s)
    {
      Iterator localIterator = this.s.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        this.r.ShowLayers(localb.a, false);
      }
      return;
    }
  }
  
  public boolean B()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null) {
      return localAppBaseMap.LayersIsShow(localAppBaseMap.getLayerIDByTag("poiindoormarklayer"));
    }
    return false;
  }
  
  public boolean E()
  {
    return this.i;
  }
  
  public boolean F()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return false;
    }
    return localAppBaseMap.IsBaseIndoorMapMode();
  }
  
  public boolean G()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return false;
    }
    return localAppBaseMap.LayersIsShow(localAppBaseMap.getLayerIDByTag("basemap"));
  }
  
  public boolean H()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return false;
    }
    return localAppBaseMap.getDrawHouseHeightEnable();
  }
  
  public boolean I()
  {
    return this.j;
  }
  
  public boolean J()
  {
    return this.m;
  }
  
  public boolean K()
  {
    return this.e;
  }
  
  public boolean L()
  {
    return this.k;
  }
  
  public boolean M()
  {
    return this.d;
  }
  
  public boolean N()
  {
    return this.l;
  }
  
  public boolean P()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null) {
      return localAppBaseMap.LayersIsShow(localAppBaseMap.getLayerIDByTag("basepoi"));
    }
    return false;
  }
  
  public void Q()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null)
    {
      x localx = this.n;
      if (localx == null) {
        return;
      }
      localAppBaseMap.RemoveLayer(localx.a);
      this.s.remove(this.n);
    }
  }
  
  public void R()
  {
    if (this.r == null) {
      return;
    }
    synchronized (this.s)
    {
      Iterator localIterator = this.s.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb instanceof h)) {
          this.r.ShowLayers(localb.a, false);
        } else {
          this.r.ShowLayers(localb.a, true);
        }
      }
      this.r.ShowTrafficMap(false);
      return;
    }
  }
  
  public void S()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null)
    {
      h localh = this.v;
      if (localh == null) {
        return;
      }
      localAppBaseMap.UpdateLayers(localh.a);
    }
  }
  
  public float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (!this.F.mIsMapLoadFinish) {
      return 12.0F;
    }
    if (this.r == null) {
      return 0.0F;
    }
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("left", paramInt1);
    localBundle1.putInt("right", paramInt3);
    localBundle1.putInt("bottom", paramInt4);
    localBundle1.putInt("top", paramInt2);
    localBundle1.putInt("hasHW", 1);
    localBundle1.putInt("width", paramInt5);
    localBundle1.putInt("height", paramInt6);
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("left", 0);
    localBundle2.putInt("bottom", paramInt6);
    localBundle2.putInt("right", paramInt5);
    localBundle2.putInt("top", 0);
    return this.r.GetFZoomToBoundF(localBundle1, localBundle2);
  }
  
  public android.graphics.Point a(GeoPoint paramGeoPoint)
  {
    paramGeoPoint = this.F.getMapView().getProjection().toPixels(paramGeoPoint, null);
    if (paramGeoPoint != null) {
      return new android.graphics.Point(paramGeoPoint.getIntX(), paramGeoPoint.getIntY());
    }
    return new android.graphics.Point();
  }
  
  public GeoPoint a(int paramInt1, int paramInt2)
  {
    return this.F.getMapView().getProjection().fromPixels(paramInt1, paramInt2);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.c = paramFloat1;
    this.b = paramFloat2;
    Object localObject = this.F;
    if (localObject != null) {
      ((MapController)localObject).setMaxAndMinZoomLevel(paramFloat1, paramFloat2);
    }
    if (this.r != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("maxLevel", (int)paramFloat1);
      ((Bundle)localObject).putInt("minLevel", (int)paramFloat2);
      this.r.setMaxAndMinZoomLevel((Bundle)localObject);
    }
  }
  
  public void a(int paramInt)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    localAppBaseMap.CleanCache(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (this.r == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = new JSONObject();
    try
    {
      localJSONObject.put("type", 0);
      ((JSONObject)localObject1).put("x", K);
      ((JSONObject)localObject1).put("y", L);
      ((JSONObject)localObject1).put("hidetime", 1000);
      localJSONArray.put(localObject1);
      localJSONObject.put("dataset", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (paramBitmap == null)
    {
      paramBitmap = null;
    }
    else
    {
      Bundle localBundle = new Bundle();
      localObject1 = new Bundle();
      Object localObject2 = ByteBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight() * 4);
      paramBitmap.copyPixelsToBuffer((Buffer)localObject2);
      ((Bundle)localObject1).putByteArray("imgData", ((ByteBuffer)localObject2).array());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramBitmap.hashCode());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      ((Bundle)localObject1).putString("imgKey", ((StringBuilder)localObject2).toString());
      ((Bundle)localObject1).putInt("imgH", paramBitmap.getHeight());
      ((Bundle)localObject1).putInt("imgW", paramBitmap.getWidth());
      ((Bundle)localObject1).putInt("hasIcon", 1);
      localBundle.putBundle("iconData", (Bundle)localObject1);
      paramBitmap = localBundle;
    }
    if (this.H != null)
    {
      if (!TextUtils.isEmpty(localJSONObject.toString())) {
        this.H.setData(localJSONObject.toString());
      }
      if (paramBitmap != null) {
        this.H.setParam(paramBitmap);
      }
      this.H.UpdateOverlay();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int i1;
    Bundle localBundle;
    if (paramBundle.get("param") != null)
    {
      paramBundle = (Bundle)paramBundle.get("param");
      i1 = paramBundle.getInt("type");
      if (i1 != e.d.ordinal())
      {
        localBundle = paramBundle;
        if (i1 < e.f.ordinal())
        {
          e.b.ordinal();
          paramBundle = localBundle;
        }
      }
    }
    else
    {
      i1 = paramBundle.getInt("type");
      if (i1 != e.d.ordinal()) {
        break label102;
      }
    }
    for (;;)
    {
      paramBundle.putLong("layer_addr", this.u.a);
      return;
      label102:
      localBundle = paramBundle;
      if (i1 < e.f.ordinal()) {
        break;
      }
    }
  }
  
  public void a(MapLayer paramMapLayer1, MapLayer paramMapLayer2)
  {
    if (this.r == null) {
      return;
    }
    long l1 = a(paramMapLayer1);
    long l2 = a(paramMapLayer2);
    if (l1 != -1L)
    {
      if (l2 == -1L) {
        return;
      }
      this.r.SwitchLayer(l1, l2);
    }
  }
  
  public void a(MapLayer paramMapLayer, boolean paramBoolean)
  {
    if (this.r == null) {
      return;
    }
    long l1 = a(paramMapLayer);
    if (l1 == -1L) {
      return;
    }
    this.r.SetLayersClickable(l1, paramBoolean);
  }
  
  public void a(MapStatusUpdate paramMapStatusUpdate)
  {
    this.B = paramMapStatusUpdate;
  }
  
  public void a(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds != null)
    {
      if (this.r == null) {
        return;
      }
      Object localObject = paramLatLngBounds.northeast;
      paramLatLngBounds = paramLatLngBounds.southwest;
      localObject = CoordUtil.ll2mc((LatLng)localObject);
      paramLatLngBounds = CoordUtil.ll2mc(paramLatLngBounds);
      int i1 = (int)((GeoPoint)localObject).getLongitudeE6();
      int i2 = (int)paramLatLngBounds.getLatitudeE6();
      int i3 = (int)paramLatLngBounds.getLongitudeE6();
      int i4 = (int)((GeoPoint)localObject).getLatitudeE6();
      paramLatLngBounds = new Bundle();
      paramLatLngBounds.putInt("maxCoorx", i1);
      paramLatLngBounds.putInt("minCoory", i2);
      paramLatLngBounds.putInt("minCoorx", i3);
      paramLatLngBounds.putInt("maxCoory", i4);
      this.r.setMapStatusLimits(paramLatLngBounds);
    }
  }
  
  public void a(i parami)
  {
    this.w = parami;
  }
  
  public void a(s params)
  {
    if (this.r != null)
    {
      if (params == null) {
        return;
      }
      params = params.a(this);
      params.putInt("animation", 0);
      params.putInt("animatime", 0);
      O();
      this.r.SetMapStatus(params);
    }
  }
  
  public void a(s params, int paramInt)
  {
    if (this.r != null)
    {
      if (params == null) {
        return;
      }
      params = params.a(this);
      params.putInt("animation", 1);
      params.putInt("animatime", paramInt);
      if (this.z)
      {
        params = new b(params);
        this.A.add(params);
        return;
      }
      b();
      this.r.SetMapStatus(params);
    }
  }
  
  public void a(w paramw)
  {
    this.o = paramw;
  }
  
  public void a(com.baidu.platform.comapi.map.x paramx)
  {
    if (paramx != null)
    {
      if (this.q == null) {
        return;
      }
      this.F.registMapViewListener(paramx);
      this.q.add(paramx);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    LocationOverlay localLocationOverlay = this.G;
    if (localLocationOverlay == null) {
      return;
    }
    localLocationOverlay.setData(paramString);
    this.G.setParam(paramBundle);
    this.G.UpdateOverlay();
  }
  
  public void a(String paramString1, String paramString2)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    localAppBaseMap.initCustomStyle(paramString1, paramString2);
  }
  
  public void a(List<OverlayLocationData> paramList)
  {
    LocationOverlay localLocationOverlay = this.G;
    if (localLocationOverlay == null) {
      return;
    }
    localLocationOverlay.setLocationLayerData(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    LocationOverlay localLocationOverlay;
    if (paramBoolean)
    {
      if (this.D) {
        return;
      }
      localLocationOverlay = this.G;
      if (localLocationOverlay == null) {
        return;
      }
      localAppBaseMap.SwitchLayer(this.u.a, localLocationOverlay.mLayerID);
      paramBoolean = true;
    }
    else
    {
      if (!this.D) {
        return;
      }
      localLocationOverlay = this.G;
      if (localLocationOverlay == null) {
        return;
      }
      localAppBaseMap.SwitchLayer(localLocationOverlay.mLayerID, this.u.a);
      paramBoolean = false;
    }
    this.D = paramBoolean;
  }
  
  public void a(Bundle[] paramArrayOfBundle)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null)
    {
      if (paramArrayOfBundle == null) {
        return;
      }
      localAppBaseMap.addOverlayItems(paramArrayOfBundle, paramArrayOfBundle.length);
    }
  }
  
  public boolean a(android.graphics.Point paramPoint)
  {
    if (paramPoint == null) {
      return false;
    }
    if (this.r == null) {
      return false;
    }
    int i1 = paramPoint.x;
    if (i1 >= 0)
    {
      int i2 = paramPoint.y;
      if (i2 >= 0)
      {
        K = i1;
        L = i2;
        paramPoint = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("x", K);
          localJSONObject.put("y", L);
          localJSONObject.put("hidetime", 1000);
          localJSONArray.put(localJSONObject);
          paramPoint.put("dataset", localJSONArray);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        if (this.H != null)
        {
          if (!TextUtils.isEmpty(paramPoint.toString())) {
            this.H.setData(paramPoint.toString());
          }
          this.H.UpdateOverlay();
          return true;
        }
      }
    }
    return false;
  }
  
  void b()
  {
    Object localObject = this.F;
    if (localObject == null) {
      return;
    }
    if ((!((MapController)localObject).mIsMoving) && (!((MapController)localObject).mIsAnimating))
    {
      ((MapController)localObject).mIsAnimating = true;
      if (this.q == null) {
        return;
      }
      localObject = t();
      int i1 = 0;
      while (i1 < this.q.size())
      {
        com.baidu.platform.comapi.map.x localx = (com.baidu.platform.comapi.map.x)this.q.get(i1);
        if (localx != null) {
          localx.a((s)localObject);
        }
        i1 += 1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null) {
      localAppBaseMap.setFontSizeLevel(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.r == null) {
      return;
    }
    a(paramBundle);
    this.r.addOneOverlayItem(paramBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    localAppBaseMap.setDrawHouseHeightEnable(paramBoolean);
  }
  
  public void b(Bundle[] paramArrayOfBundle)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    localAppBaseMap.removeOverlayItems(paramArrayOfBundle);
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return false;
    }
    return localAppBaseMap.SwitchBaseIndoorMapFloor(paramString1, paramString2);
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = this.r;
    if (localObject == null) {
      return;
    }
    if (this.H == null)
    {
      this.H = new d((AppBaseMap)localObject);
      localObject = this.F.getMapView();
      if (localObject != null)
      {
        ((MapViewInterface)localObject).addOverlay(this.H);
        C();
      }
    }
    this.r.ShowLayers(this.H.mLayerID, paramBoolean);
  }
  
  public boolean c()
  {
    x localx = this.n;
    if (localx != null)
    {
      AppBaseMap localAppBaseMap = this.r;
      if (localAppBaseMap != null) {
        return localAppBaseMap.cleanSDKTileDataCache(localx.a);
      }
    }
    return false;
  }
  
  public boolean c(Bundle paramBundle)
  {
    if (this.r == null) {
      return false;
    }
    ??? = new x();
    this.n = ((x)???);
    long l1 = this.r.AddLayer(((b)???).c, ((b)???).d, ((b)???).b);
    if (l1 != 0L)
    {
      this.n.a = l1;
      synchronized (this.s)
      {
        this.s.add(this.n);
        paramBundle.putLong("sdktileaddr", l1);
        if ((d(paramBundle)) && (g(paramBundle))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void d()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    localAppBaseMap.ClearSDKLayer(this.u.a);
  }
  
  public void d(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    this.i = paramBoolean;
    localAppBaseMap.ShowHotMap(paramBoolean, 0);
  }
  
  public void e()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null)
    {
      h localh = this.v;
      if (localh == null) {
        return;
      }
      localAppBaseMap.clearHeatMapLayerCache(localh.a);
      this.r.UpdateLayers(this.v.a);
    }
  }
  
  public void e(Bundle paramBundle)
  {
    if (this.r == null) {
      return;
    }
    a(paramBundle);
    this.r.removeOneOverlayItem(paramBundle);
  }
  
  public void e(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    localAppBaseMap.ShowLayers(localAppBaseMap.getLayerIDByTag("basemap"), paramBoolean);
  }
  
  public void f()
  {
    this.G.clearLocationLayerData(null);
  }
  
  public void f(Bundle paramBundle)
  {
    if (this.r == null) {
      return;
    }
    a(paramBundle);
    this.r.updateOneOverlayItem(paramBundle);
  }
  
  public void f(boolean paramBoolean)
  {
    Object localObject = this.r;
    if (localObject == null) {
      return;
    }
    this.f = paramBoolean;
    if (this.H == null)
    {
      this.H = new d((AppBaseMap)localObject);
      localObject = this.F.getMapView();
      if (localObject != null)
      {
        ((MapViewInterface)localObject).addOverlay(this.H);
        C();
      }
    }
    this.r.ShowLayers(this.H.mLayerID, paramBoolean);
  }
  
  public void g() {}
  
  public void g(boolean paramBoolean)
  {
    MapController localMapController = this.F;
    if (localMapController == null) {
      return;
    }
    localMapController.setDoubleClickZoom(paramBoolean);
  }
  
  public AppBaseMap h()
  {
    return this.r;
  }
  
  public void h(boolean paramBoolean)
  {
    MapController localMapController = this.F;
    if (localMapController == null) {
      return;
    }
    localMapController.setEnlargeCenterWithDoubleClickEnable(paramBoolean);
  }
  
  public boolean hasLayer(long paramLong)
  {
    synchronized (this.s)
    {
      Iterator localIterator = this.s.iterator();
      while (localIterator.hasNext()) {
        if (((b)localIterator.next()).a == paramLong) {
          return true;
        }
      }
      return false;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.r == null) {
      return;
    }
    if (this.v == null)
    {
      h localh = new h();
      this.v = localh;
      a(localh);
    }
    this.h = paramBoolean;
    this.r.ShowLayers(this.v.a, paramBoolean);
  }
  
  public boolean i()
  {
    return false;
  }
  
  public void j(boolean paramBoolean)
  {
    Object localObject = this.r;
    if (localObject == null) {
      return;
    }
    this.g = paramBoolean;
    LocationOverlay localLocationOverlay = this.G;
    if (localLocationOverlay == null)
    {
      localObject = this.F.getMapView();
      if (localObject != null)
      {
        localLocationOverlay = new LocationOverlay(this.r);
        this.G = localLocationOverlay;
        ((MapViewInterface)localObject).addOverlay(localLocationOverlay);
      }
    }
    else
    {
      ((AppBaseMap)localObject).ShowLayers(localLocationOverlay.mLayerID, paramBoolean);
    }
  }
  
  public boolean j()
  {
    return this.f;
  }
  
  public String k()
  {
    return null;
  }
  
  public void k(boolean paramBoolean)
  {
    Object localObject = this.r;
    if (localObject == null) {
      return;
    }
    this.I = paramBoolean;
    ((AppBaseMap)localObject).setCustomStyleEnable(paramBoolean);
    if (OpenLogUtil.isMapLogEnable())
    {
      localObject = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CustomMap setMapCustomEnable enable = ");
      localStringBuilder.append(paramBoolean);
      ((com.baidu.mapsdkplatform.comapi.commonutils.b)localObject).a(localStringBuilder.toString());
    }
  }
  
  public s l()
  {
    Object localObject = this.r;
    if (localObject == null) {
      return null;
    }
    localObject = ((AppBaseMap)localObject).GetMapStatus(false);
    s locals = new s();
    locals.a((Bundle)localObject);
    return locals;
  }
  
  public void l(boolean paramBoolean) {}
  
  /* Error */
  public com.baidu.mapapi.map.MapBaseIndoorMapInfo m()
  {
    // Byte code:
    //   0: ldc_w 951
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 148	com/baidu/mapsdkplatform/comapi/map/c:r	Lcom/baidu/platform/comjni/map/basemap/AppBaseMap;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_2
    //   17: invokevirtual 954	com/baidu/platform/comjni/map/basemap/AppBaseMap:GetFocusedBaseIndoorMapInfo	()Ljava/lang/String;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new 956	java/util/ArrayList
    //   30: dup
    //   31: iconst_1
    //   32: invokespecial 958	java/util/ArrayList:<init>	(I)V
    //   35: astore 7
    //   37: new 198	org/json/JSONObject
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 960	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore 5
    //   47: aload 5
    //   49: ldc_w 962
    //   52: invokevirtual 966	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_3
    //   56: aload 4
    //   58: astore_2
    //   59: aload 5
    //   61: ldc_w 968
    //   64: invokevirtual 966	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 4
    //   69: aload 4
    //   71: astore_2
    //   72: aload 5
    //   74: ldc_w 970
    //   77: invokevirtual 974	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   80: astore 8
    //   82: aload 4
    //   84: astore 6
    //   86: aload_3
    //   87: astore 5
    //   89: aload 8
    //   91: ifnull +74 -> 165
    //   94: iconst_0
    //   95: istore_1
    //   96: aload 4
    //   98: astore_2
    //   99: aload 4
    //   101: astore 6
    //   103: aload_3
    //   104: astore 5
    //   106: iload_1
    //   107: aload 8
    //   109: invokevirtual 977	org/json/JSONArray:length	()I
    //   112: if_icmpge +53 -> 165
    //   115: aload 4
    //   117: astore_2
    //   118: aload 7
    //   120: aload 8
    //   122: iload_1
    //   123: invokevirtual 978	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   126: invokevirtual 979	java/lang/Object:toString	()Ljava/lang/String;
    //   129: invokevirtual 980	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   132: pop
    //   133: iload_1
    //   134: iconst_1
    //   135: iadd
    //   136: istore_1
    //   137: goto -41 -> 96
    //   140: astore 5
    //   142: goto +12 -> 154
    //   145: astore 5
    //   147: ldc_w 951
    //   150: astore_2
    //   151: aload 4
    //   153: astore_3
    //   154: aload 5
    //   156: invokevirtual 669	org/json/JSONException:printStackTrace	()V
    //   159: aload_3
    //   160: astore 5
    //   162: aload_2
    //   163: astore 6
    //   165: new 982	com/baidu/mapapi/map/MapBaseIndoorMapInfo
    //   168: dup
    //   169: aload 5
    //   171: aload 6
    //   173: aload 7
    //   175: invokespecial 985	com/baidu/mapapi/map/MapBaseIndoorMapInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   178: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	c
    //   95	42	1	i1	int
    //   9	154	2	localObject1	Object
    //   55	105	3	str1	String
    //   3	149	4	str2	String
    //   45	60	5	localObject2	Object
    //   140	1	5	localJSONException1	JSONException
    //   145	10	5	localJSONException2	JSONException
    //   160	10	5	localObject3	Object
    //   84	88	6	localObject4	Object
    //   35	139	7	localArrayList	java.util.ArrayList
    //   80	41	8	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   59	69	140	org/json/JSONException
    //   72	82	140	org/json/JSONException
    //   106	115	140	org/json/JSONException
    //   118	133	140	org/json/JSONException
    //   37	56	145	org/json/JSONException
  }
  
  public void m(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    if (paramBoolean)
    {
      if (this.C) {
        return;
      }
      localAppBaseMap.SwitchLayer(localAppBaseMap.getLayerIDByTag("indoorlayer"), this.u.a);
      paramBoolean = true;
    }
    else
    {
      if (!this.C) {
        return;
      }
      localAppBaseMap.SwitchLayer(this.u.a, localAppBaseMap.getLayerIDByTag("indoorlayer"));
      paramBoolean = false;
    }
    this.C = paramBoolean;
  }
  
  public int mapLayerDataReq(Bundle paramBundle, long paramLong, int paramInt)
  {
    Object localObject = this.v;
    int i1;
    int i2;
    if ((localObject != null) && (paramLong == ((b)localObject).a))
    {
      paramInt = paramBundle.getInt("x");
      i1 = paramBundle.getInt("y");
      i2 = paramBundle.getInt("zoom");
      paramBundle.putBundle("param", this.w.a(paramInt, i1, i2));
    }
    for (paramBundle = this.v;; paramBundle = this.n)
    {
      return paramBundle.e;
      localObject = this.n;
      if ((localObject == null) || (paramLong != ((b)localObject).a)) {
        break;
      }
      paramInt = paramBundle.getInt("x");
      i1 = paramBundle.getInt("y");
      i2 = paramBundle.getInt("zoom");
      paramBundle.putBundle("param", this.o.a(paramInt, i1, i2, this.p));
    }
    return 0;
  }
  
  public int n()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null) {
      localAppBaseMap.getFontSizeLevel();
    }
    return 1;
  }
  
  public void n(boolean paramBoolean)
  {
    MapController localMapController = this.F;
    if (localMapController == null) {
      return;
    }
    localMapController.setOverlookGestureEnable(paramBoolean);
    this.j = paramBoolean;
  }
  
  public int o()
  {
    return this.y;
  }
  
  public void o(boolean paramBoolean)
  {
    MapController localMapController = this.F;
    if (localMapController == null) {
      return;
    }
    localMapController.set3DGestureEnable(paramBoolean);
    this.m = paramBoolean;
  }
  
  public MapStatusUpdate p()
  {
    return this.B;
  }
  
  public void p(boolean paramBoolean)
  {
    if (this.r == null) {
      return;
    }
    this.e = paramBoolean;
    a();
    this.r.ShowSatelliteMap(this.e);
    MapController localMapController = this.F;
    if (localMapController != null)
    {
      Bundle localBundle;
      int i1;
      if (paramBoolean)
      {
        localBundle = new Bundle();
        i1 = 2;
      }
      else
      {
        localBundle = new Bundle();
        i1 = 1;
      }
      localMapController.setMapTheme(i1, localBundle);
    }
  }
  
  public void q(boolean paramBoolean)
  {
    MapController localMapController = this.F;
    if (localMapController == null) {
      return;
    }
    localMapController.setCanTouchMove(paramBoolean);
    this.k = paramBoolean;
  }
  
  public boolean q()
  {
    return this.g;
  }
  
  public String r()
  {
    if (this.I) {
      return "";
    }
    return "GS(2022)460号";
  }
  
  public void r(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    this.d = paramBoolean;
    localAppBaseMap.ShowTrafficMap(paramBoolean);
  }
  
  public int s()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return 0;
    }
    return localAppBaseMap.getMapLanguage();
  }
  
  public void s(boolean paramBoolean)
  {
    MapController localMapController = this.F;
    if (localMapController == null) {
      return;
    }
    localMapController.setTwoTouchClickZoomEnabled(paramBoolean);
  }
  
  public s t()
  {
    Object localObject = this.r;
    if (localObject == null) {
      return null;
    }
    localObject = ((AppBaseMap)localObject).GetMapStatus();
    s locals = new s();
    locals.a((Bundle)localObject);
    return locals;
  }
  
  public void t(boolean paramBoolean)
  {
    MapController localMapController = this.F;
    if (localMapController == null) {
      return;
    }
    localMapController.setEnableZoom(paramBoolean);
    this.l = paramBoolean;
  }
  
  public LatLngBounds u()
  {
    Object localObject = this.r;
    if (localObject == null) {
      return null;
    }
    localObject = ((AppBaseMap)localObject).getMapStatusLimits();
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    int i1 = ((Bundle)localObject).getInt("maxCoorx");
    int i2 = ((Bundle)localObject).getInt("minCoorx");
    int i3 = ((Bundle)localObject).getInt("maxCoory");
    localBuilder.include(CoordUtil.mc2ll(new GeoPoint(((Bundle)localObject).getInt("minCoory"), i1))).include(CoordUtil.mc2ll(new GeoPoint(i3, i2)));
    return localBuilder.build();
  }
  
  public void u(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null)
    {
      x localx = this.n;
      if (localx == null) {
        return;
      }
      localAppBaseMap.ShowLayers(localx.a, paramBoolean);
    }
  }
  
  public float v()
  {
    MapController localMapController = this.F;
    if (localMapController != null) {
      return localMapController.mMaxZoomLevel;
    }
    return this.a;
  }
  
  public void v(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    float f1;
    MapController localMapController;
    if (paramBoolean)
    {
      f1 = 22.0F;
      this.a = 22.0F;
      this.c = 22.0F;
      localMapController = this.F;
      if (localMapController == null) {
        break label75;
      }
    }
    else
    {
      f1 = 21.0F;
      this.a = 21.0F;
      this.c = 21.0F;
      localMapController = this.F;
      if (localMapController == null) {
        break label75;
      }
    }
    localMapController.mMaxZoomLevel = f1;
    label75:
    localAppBaseMap.ShowBaseIndoorMap(paramBoolean);
  }
  
  public void w(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null) {
      localAppBaseMap.ShowLayers(localAppBaseMap.getLayerIDByTag("poiindoormarklayer"), paramBoolean);
    }
  }
  
  public float[] w()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return null;
    }
    return localAppBaseMap.getProjectionMatrix();
  }
  
  public void x(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return;
    }
    long l1 = localAppBaseMap.getLayerIDByTag("opgrid");
    this.r.ShowLayers(l1, paramBoolean);
  }
  
  public float[] x()
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap == null) {
      return null;
    }
    return localAppBaseMap.getViewMatrix();
  }
  
  public int y()
  {
    return this.x;
  }
  
  public void y(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    if (localAppBaseMap != null) {
      localAppBaseMap.ShowLayers(localAppBaseMap.getLayerIDByTag("basepoi"), paramBoolean);
    }
  }
  
  public double z()
  {
    return t().m;
  }
  
  public boolean z(boolean paramBoolean)
  {
    AppBaseMap localAppBaseMap = this.r;
    boolean bool2 = false;
    if (localAppBaseMap == null) {
      return false;
    }
    long l1 = localAppBaseMap.getLayerIDByTag("routeicon");
    long l2 = this.r.getLayerIDByTag("android_sdk");
    boolean bool1 = bool2;
    if (l1 != 0L)
    {
      if (l2 == 0L) {
        return false;
      }
      if (paramBoolean)
      {
        bool1 = bool2;
        if (!this.E)
        {
          paramBoolean = this.r.SwitchLayer(l1, l2);
          this.E = true;
          return paramBoolean;
        }
      }
      else
      {
        bool1 = bool2;
        if (this.E)
        {
          bool1 = this.r.SwitchLayer(l2, l1);
          this.E = false;
        }
      }
    }
    return bool1;
  }
  
  public static class b
  {
    public b(Bundle paramBundle) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.c
 * JD-Core Version:    0.7.0.1
 */