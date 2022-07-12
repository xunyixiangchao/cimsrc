package com.baidu.platform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.map.d0.d;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comapi.util.g;
import com.baidu.platform.comapi.util.h;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapController
{
  public static final String ANDROID_SDK_LAYER_TAG = "android_sdk";
  public static final String CITY_AREA_TAG = "cityarea";
  public static final String COMPASS_LAYER_TAG = "compass";
  public static final String DEFAULT_LAYER_TAG = "default";
  public static final String DYNAMIC_MAP_LAYER_TAG = "dynamicmap";
  public static final String FOOTSURFACE_LAYER_TAG = "footsurface";
  public static final String HEATMAP_LAYER_TAG = "heatmap";
  public static final String ITEM_LAYER_TAG = "item";
  public static final String ITSROUTE_LAYER_TAG = "itsroute";
  public static final String LOCAL_LIMIT_MAP_LAYER_TAG = "dynamiclimit";
  public static final String LOCATION_LAYER_TAG = "location";
  public static final int MSG_LONGLINK_CONNECT = 1;
  public static final int MSG_LONGLINK_DISCONNECT = 2;
  private static final String P = "MapController";
  public static final String POISON_LAYER_TAG = "poison";
  public static final String POPUP_LAYER_TAG = "popup";
  private static boolean Q = true;
  private static float R = 0.0F;
  public static final String RTPOPUP_LAYER_TAG = "rtpopup";
  public static final String RT_POPUP_LAYER_TAG = "rtpopup";
  private static float S = 0.0F;
  public static final String SHARELOCATION_BUBBLE = "smshare";
  public static final String STREETPOPUP_LAYER_TAG = "streetpopup";
  public static final String STREETROUTE_LAYER_TAG = "streetroute";
  private static boolean T = false;
  private static long U = 0L;
  private static List<AppBaseMap> V = new ArrayList();
  public static boolean isCompass = false;
  public static boolean mLocIconOnScreen = true;
  public static boolean m_registered_SENSOR_ORIENTATION;
  private boolean A = true;
  MapViewListener B = null;
  CaptureMapListener C = null;
  i D = null;
  z E = null;
  MapRenderModeChangeListener F = null;
  EngineMsgListener G = null;
  o H = null;
  SoftReference<MapViewInterface> I;
  NaviMapViewListener J;
  private long K;
  private boolean L = false;
  private boolean M = false;
  private com.baidu.platform.comapi.map.e0.b N = new com.baidu.platform.comapi.map.e0.b(this);
  private MapControlMode O = MapControlMode.DEFAULT;
  private com.baidu.platform.comapi.map.e0.c a;
  private boolean b = true;
  int c = 0;
  private int d = 1;
  private int e = 1;
  private MapFirstFrameCallback f;
  private boolean g = false;
  private AppBaseMap h = null;
  private long i = 0L;
  private Handler j = null;
  private int k = SysOSUtil.getInstance().getScreenWidth();
  private int l = SysOSUtil.getInstance().getScreenHeight();
  private boolean m = false;
  public boolean mHasMapObjDraging;
  public boolean mIsAnimating = false;
  public boolean mIsMapLoadFinish;
  public boolean mIsMoving = false;
  public List<x> mListeners = new CopyOnWriteArrayList();
  public float mMaxZoomLevel = 21.0F;
  public float mMinZoomLevel = 4.0F;
  private boolean n = false;
  public int nearlyRadius = 20;
  private boolean o = false;
  private a p = new a();
  private boolean q = true;
  private boolean r = false;
  private boolean s = true;
  private boolean t = false;
  private float u = -1.0F;
  private long v;
  private boolean w = false;
  private boolean x = true;
  private boolean y = true;
  private boolean z = true;
  
  public MapController()
  {
    b();
  }
  
  public static native int CleanAfterDBClick(long paramLong, float paramFloat1, float paramFloat2);
  
  public static int GetAdaptKeyCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 22: 
      return 18;
    case 21: 
      return 16;
    case 20: 
      return 19;
    }
    return 17;
  }
  
  public static native int MapProc(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  private MapStatus a(boolean paramBoolean)
  {
    if (!a()) {
      return new MapStatus();
    }
    Object localObject = this.h.GetMapStatus(paramBoolean);
    if (localObject == null) {
      return new MapStatus();
    }
    MapStatus localMapStatus = new MapStatus();
    localMapStatus.level = ((float)((Bundle)localObject).getDouble("level"));
    localMapStatus.rotation = ((int)((Bundle)localObject).getDouble("rotation"));
    localMapStatus.overlooking = ((int)((Bundle)localObject).getDouble("overlooking"));
    localMapStatus.centerPtX = ((Bundle)localObject).getDouble("centerptx");
    localMapStatus.centerPtY = ((Bundle)localObject).getDouble("centerpty");
    localMapStatus.centerPtZ = ((Bundle)localObject).getDouble("centerptz");
    localMapStatus.winRound.left = ((Bundle)localObject).getInt("left");
    localMapStatus.winRound.right = ((Bundle)localObject).getInt("right");
    localMapStatus.winRound.top = ((Bundle)localObject).getInt("top");
    localMapStatus.winRound.bottom = ((Bundle)localObject).getInt("bottom");
    localMapStatus.geoRound.left = ((Bundle)localObject).getLong("gleft");
    localMapStatus.geoRound.right = ((Bundle)localObject).getLong("gright");
    localMapStatus.geoRound.top = ((Bundle)localObject).getLong("gtop");
    localMapStatus.geoRound.bottom = ((Bundle)localObject).getLong("gbottom");
    localMapStatus.xOffset = ((Bundle)localObject).getFloat("xoffset");
    localMapStatus.yOffset = ((Bundle)localObject).getFloat("yoffset");
    int i1 = ((Bundle)localObject).getInt("bfpp");
    boolean bool = false;
    if (i1 == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localMapStatus.bfpp = paramBoolean;
    localMapStatus.panoId = ((Bundle)localObject).getString("panoid");
    localMapStatus.streetIndicateAngle = ((Bundle)localObject).getFloat("siangle");
    if (((Bundle)localObject).getInt("isbirdeye") == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localMapStatus.isBirdEye = paramBoolean;
    localMapStatus.streetExt = ((Bundle)localObject).getInt("ssext");
    localMapStatus.roadOffsetX = ((Bundle)localObject).getFloat("roadOffsetX");
    localMapStatus.roadOffsetY = ((Bundle)localObject).getFloat("roadOffsetY");
    paramBoolean = bool;
    if (((Bundle)localObject).getInt("boverlookback") == 1) {
      paramBoolean = true;
    }
    localMapStatus.bOverlookSpringback = paramBoolean;
    localMapStatus.minOverlooking = ((int)((Bundle)localObject).getFloat("minoverlook"));
    localMapStatus.xScreenOffset = ((Bundle)localObject).getFloat("xScreenOffset");
    localMapStatus.yScreenOffset = ((Bundle)localObject).getFloat("yScreenOffset");
    localObject = localMapStatus.geoRound;
    if (((MapStatus.GeoBound)localObject).left <= -20037508L) {
      ((MapStatus.GeoBound)localObject).left = -20037508L;
    }
    if (((MapStatus.GeoBound)localObject).right >= 20037508L) {
      ((MapStatus.GeoBound)localObject).right = 20037508L;
    }
    if (((MapStatus.GeoBound)localObject).top >= 20037508L) {
      ((MapStatus.GeoBound)localObject).top = 20037508L;
    }
    if (((MapStatus.GeoBound)localObject).bottom <= -20037508L) {
      ((MapStatus.GeoBound)localObject).bottom = -20037508L;
    }
    return localMapStatus;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    R = i1;
    S = i2;
    MapMsgProc(4, 0, i1 | i2 << 16);
    T = true;
    this.K = paramMotionEvent.getDownTime();
  }
  
  private boolean a()
  {
    return (this.o) && (this.h != null);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (!a()) {
      return false;
    }
    if ((getMapViewListener() == null) && (this.J == null)) {
      return false;
    }
    int i1 = (int)(this.nearlyRadius * getZoomUnitsInMeter());
    Object localObject1 = new Point(paramInt1, paramInt2);
    Object localObject3;
    if (isNaviMode())
    {
      localObject3 = this.J;
      if (localObject3 != null)
      {
        localObject1 = ((NaviMapViewListener)localObject3).onTapInterception((Point)localObject1);
        break label84;
      }
    }
    localObject1 = null;
    label84:
    if (localObject1 != null)
    {
      paramInt1 = ((Point)localObject1).getIntX();
      paramInt2 = ((Point)localObject1).getIntY();
    }
    String str = this.h.GetNearlyObjID(-1L, paramInt1, paramInt2, i1);
    if (str == null) {
      return false;
    }
    if (isNaviMode())
    {
      localObject1 = this.J;
      if ((localObject1 != null) && (((NaviMapViewListener)localObject1).onItemClick(str, paramInt1, paramInt2))) {
        return true;
      }
    }
    Object localObject4;
    int i2;
    Object localObject6;
    Object localObject5;
    ArrayList localArrayList1;
    Object localObject7;
    label499:
    label511:
    Object localObject9;
    label526:
    label725:
    double d2;
    for (;;)
    {
      try
      {
        localObject3 = new JSONObject(str);
        localArrayList2 = new ArrayList();
        bool = ((JSONObject)localObject3).has("mcar");
        if (bool)
        {
          localObject1 = ((JSONObject)localObject3).getJSONObject("mcar");
          if (localObject1 != null)
          {
            localObject3 = new ArrayList();
            localObject4 = new MapObj();
            ((MapObj)localObject4).routeType = "mcar";
            if (((JSONObject)localObject1).has("id")) {
              ((MapObj)localObject4).routeId = ((JSONObject)localObject1).getInt("id");
            }
            if (((JSONObject)localObject1).has("status")) {
              ((MapObj)localObject4).status = ((JSONObject)localObject1).getInt("status");
            }
            if (((JSONObject)localObject1).has("in")) {
              ((MapObj)localObject4).index = ((JSONObject)localObject1).getInt("in");
            }
            ((List)localObject3).add(localObject4);
            if (getMapViewListener() == null) {
              continue;
            }
            getMapViewListener().onClickedRouteObj((List)localObject3);
            return true;
          }
        }
        localJSONArray = ((JSONObject)localObject3).getJSONArray("dataset");
        i2 = ((JSONObject)localJSONArray.get(0)).getInt("ty");
        if (i2 != 22) {
          break label2534;
        }
      }
      catch (JSONException localJSONException1)
      {
        ArrayList localArrayList2;
        boolean bool;
        JSONArray localJSONArray;
        Object localObject8;
        int i3;
        Point localPoint;
        double d1;
        label776:
        label784:
        label848:
        label2297:
        continue;
        label1973:
        label2248:
        label2380:
        label2401:
        return true;
        label2176:
        label2189:
        label2212:
        label2226:
        label2359:
        label2501:
        localObject3 = null;
        label2322:
        label2343:
        label2483:
        break label2670;
        label2446:
        label2462:
        return false;
      }
      try
      {
        localObject1 = new ArrayList();
      }
      catch (JSONException localJSONException2) {}
    }
    if (i2 == 6)
    {
      localObject4 = new ArrayList();
      localObject1 = null;
      localObject3 = null;
      localObject6 = null;
    }
    else
    {
      if (i2 == 24)
      {
        localObject5 = new ArrayList();
        localObject1 = null;
        localObject3 = null;
        localObject6 = null;
        localObject4 = null;
        break label2679;
      }
      if (i2 == 1239)
      {
        localObject1 = new ArrayList();
      }
      else if (i2 == 7000)
      {
        localArrayList1 = new ArrayList();
        localObject7 = null;
        localObject3 = null;
        localObject6 = null;
        localObject4 = null;
        localObject5 = null;
        break label2686;
        localObject1 = new ArrayList();
        break label2657;
        localObject3 = new ArrayList();
        localObject1 = null;
        break label2670;
        if (paramInt2 >= localJSONArray.length()) {
          break label2925;
        }
        localObject8 = (JSONObject)localJSONArray.get(paramInt2);
        i3 = ((JSONObject)localObject8).getInt("ty");
        if (i3 == 26)
        {
          i1 = paramInt1;
          break label2913;
        }
        localObject6 = new MapObj();
        if (((JSONObject)localObject8).has("layerid")) {
          ((MapObj)localObject6).layer_id = ((int)((JSONObject)localObject8).getLong("layerid"));
        }
        try
        {
          ((MapObj)localObject6).layer_id = 0;
          bool = ((JSONObject)localObject8).has("ud");
          if (bool) {
            ((MapObj)localObject6).strUid = ((JSONObject)localObject8).getString("ud");
          } else {
            ((MapObj)localObject6).strUid = "";
          }
          ((MapObj)localObject6).strText = ((JSONObject)localObject8).optString("tx");
          if (((JSONObject)localObject8).has("in")) {}
          for (i1 = ((JSONObject)localObject8).getInt("in");; i1 = ((JSONObject)localObject8).getInt("index"))
          {
            ((MapObj)localObject6).nIndex = i1;
            break label725;
            if (!((JSONObject)localObject8).has("index")) {
              break;
            }
          }
          ((MapObj)localObject6).nIndex = 0;
          if (((JSONObject)localObject8).has("geo"))
          {
            localObject9 = CoordinateUtil.complexPtToPoint(((JSONObject)localObject8).getString("geo"));
            localPoint = ((MapObj)localObject6).geoPt;
            if (localObject9 == null)
            {
              d1 = 0.0D;
              break label2701;
            }
            d1 = ((Point)localObject9).getIntX();
            break label2701;
            d2 = ((Point)localObject9).getIntY();
            localPoint.setTo(d1, d2);
            break label2712;
          }
          if ((!((JSONObject)localObject8).has("ptx")) || (!((JSONObject)localObject8).has("pty"))) {
            break label2712;
          }
          ((MapObj)localObject6).geoPt.setTo((int)((JSONObject)localObject8).getDouble("ptx"), (int)((JSONObject)localObject8).getDouble("pty"));
          if (((JSONObject)localObject8).has("geoz")) {
            ((MapObj)localObject6).geoZ = ((float)((JSONObject)localObject8).getDouble("geoz"));
          }
          if (((JSONObject)localObject8).has("indoorpoi")) {
            ((MapObj)localObject6).indoorpoi = ((JSONObject)localObject8).getBoolean("indoorpoi");
          }
          if (((JSONObject)localObject8).has("onlineType")) {
            ((MapObj)localObject6).poiOnlineType = ((JSONObject)localObject8).getInt("onlineType");
          }
          if (((JSONObject)localObject8).has("bid")) {
            ((MapObj)localObject6).bid = ((JSONObject)localObject8).getString("bid");
          }
          if (((JSONObject)localObject8).has("ts")) {
            ((MapObj)localObject6).sltime = ((JSONObject)localObject8).getInt("ts");
          }
          if (((JSONObject)localObject8).has("obj")) {
            ((MapObj)localObject6).slobj = ((JSONObject)localObject8).getInt("obj");
          }
          if (((JSONObject)localObject8).has("visible")) {
            ((MapObj)localObject6).slvisi = ((JSONObject)localObject8).getInt("visible");
          }
          ((MapObj)localObject6).nType = i3;
          if (((JSONObject)localObject8).has("of")) {
            ((MapObj)localObject6).offset = ((JSONObject)localObject8).getInt("of");
          }
          if (((JSONObject)localObject8).has("poiname")) {
            ((MapObj)localObject6).ssName = ((JSONObject)localObject8).getString("poiname");
          }
          if (((JSONObject)localObject8).has("poiindoorid")) {
            ((MapObj)localObject6).ssIndoorId = ((JSONObject)localObject8).getString("poiindoorid");
          }
          if (((JSONObject)localObject8).has("ud")) {
            ((MapObj)localObject6).ssPoiUid = ((JSONObject)localObject8).getString("ud");
          }
          if (((JSONObject)localObject8).has("streetType")) {
            ((MapObj)localObject6).ssType = ((JSONObject)localObject8).getString("streetType");
          }
          if (((JSONObject)localObject8).has("dis")) {
            ((MapObj)localObject6).offset = ((JSONObject)localObject8).getInt("dis");
          }
          if (((JSONObject)localObject8).has("x"))
          {
            ((MapObj)localObject6).geoPt.setIntX(((JSONObject)localObject8).getInt("x"));
            ((MapObj)localObject6).streetArrowCenterX = ((JSONObject)localObject8).getDouble("x");
          }
          if (((JSONObject)localObject8).has("y"))
          {
            ((MapObj)localObject6).geoPt.setIntY(((JSONObject)localObject8).getInt("y"));
            ((MapObj)localObject6).streetArrowCenterY = ((JSONObject)localObject8).getDouble("y");
          }
          if (((JSONObject)localObject8).has("z")) {
            ((MapObj)localObject6).ssZ = ((JSONObject)localObject8).getInt("z");
          }
          if (((JSONObject)localObject8).has("rotation")) {
            ((MapObj)localObject6).ssRotation = ((JSONObject)localObject8).getDouble("rotation");
          }
          if (((JSONObject)localObject8).has("pid")) {
            ((MapObj)localObject6).ssPanoId = ((JSONObject)localObject8).getString("pid");
          }
          if (((JSONObject)localObject8).has("customdata")) {
            ((MapObj)localObject6).ssData = ((JSONObject)localObject8).getString("customdata");
          }
          if (((JSONObject)localObject8).has("src"))
          {
            paramInt1 = ((JSONObject)localObject8).getInt("src");
            ((MapObj)localObject6).dynamicSrc = paramInt1;
          }
          else
          {
            ((MapObj)localObject6).dynamicSrc = -1;
          }
          if (((JSONObject)localObject8).has("ad")) {
            ((MapObj)localObject6).ad = ((JSONObject)localObject8).getInt("ad");
          } else {
            ((MapObj)localObject6).ad = -1;
          }
          if (((JSONObject)localObject8).has("ad_style")) {
            ((MapObj)localObject6).adstyle = ((JSONObject)localObject8).getInt("ad_style");
          } else {
            ((MapObj)localObject6).adstyle = -1;
          }
          if (((JSONObject)localObject8).has("qid")) {
            ((MapObj)localObject6).qid = ((JSONObject)localObject8).getString("qid");
          } else {
            ((MapObj)localObject6).qid = "";
          }
          if (((JSONObject)localObject8).has("puid")) {
            ((MapObj)localObject6).puid = ((JSONObject)localObject8).getString("puid");
          } else {
            ((MapObj)localObject6).puid = "";
          }
          if (((JSONObject)localObject8).has("dy_src")) {
            ((MapObj)localObject6).dysrc = ((JSONObject)localObject8).getInt("dy_src");
          } else {
            ((MapObj)localObject6).dysrc = -1;
          }
          if (((JSONObject)localObject8).has("dy_stge")) {
            ((MapObj)localObject6).dystge = ((JSONObject)localObject8).getInt("dy_stge");
          } else {
            ((MapObj)localObject6).dystge = -1;
          }
          if (((JSONObject)localObject8).has("is_aggregate")) {
            ((MapObj)localObject6).isAgg = ((JSONObject)localObject8).getBoolean("is_aggregate");
          }
          if (((JSONObject)localObject8).has("ad_log")) {
            ((MapObj)localObject6).adLog = ((JSONObject)localObject8).getString("ad_log");
          } else {
            ((MapObj)localObject6).adLog = "";
          }
          if (((JSONObject)localObject8).has("url")) {
            ((MapObj)localObject6).url = ((JSONObject)localObject8).getString("url");
          } else {
            ((MapObj)localObject6).url = "";
          }
          if (((JSONObject)localObject8).has("style_id")) {
            ((MapObj)localObject6).style_id = ((JSONObject)localObject8).getInt("style_id");
          }
        }
        catch (JSONException localJSONException3)
        {
          break label2923;
        }
        try
        {
          ((MapObj)localObject6).style_id = 0;
          if (((JSONObject)localObject8).has("level")) {
            ((MapObj)localObject6).level = ((JSONObject)localObject8).getInt("level");
          } else {
            ((MapObj)localObject6).level = -1;
          }
          if (((JSONObject)localObject8).has("clickaction")) {
            ((MapObj)localObject6).clickAction = ((JSONObject)localObject8).getString("clickaction");
          } else {
            ((MapObj)localObject6).clickAction = "";
          }
          if (((JSONObject)localObject8).has("exjson")) {
            ((MapObj)localObject6).exJson = ((JSONObject)localObject8).getString("exjson");
          } else {
            ((MapObj)localObject6).exJson = "";
          }
          if (((JSONObject)localObject8).has("statisticValue")) {
            ((MapObj)localObject6).statisticValue = ((JSONObject)localObject8).getInt("statisticValue");
          }
          if (i2 != 22) {
            break label2721;
          }
          localObject9 = new ItsMapObj();
          ((ItsMapObj)localObject9).baseMapObj = ((MapObj)localObject6);
          ((ItsMapObj)localObject9).tTrafficStart = ((JSONObject)localObject8).getLong("iest");
          ((ItsMapObj)localObject9).tTrafficEnd = ((JSONObject)localObject8).getLong("ieend");
          ((ItsMapObj)localObject9).strTrafficDetail = ((JSONObject)localObject8).getString("iedetail");
          if (localObject7 == null) {
            break label2715;
          }
          ((List)localObject7).add(localObject9);
        }
        catch (JSONException localJSONException4)
        {
          return false;
        }
        if (i2 == 6)
        {
          localObject8 = localObject4;
          if (localObject8 == null) {
            break label2838;
          }
          ((List)localObject8).add(localObject6);
          break label2838;
        }
        if (i2 != 24) {
          break label2844;
        }
        localObject8 = localObject5;
        if (localObject8 == null) {
          break label2841;
        }
        ((List)localObject8).add(localObject6);
        break label2841;
        if (i2 == 1235)
        {
          if (getMapViewListener() == null) {
            break label2879;
          }
          getMapViewListener().onClickStreetArrow((MapObj)localObject6);
          break label2879;
        }
        if (i2 == 2002)
        {
          if (getMapViewListener() == null) {
            break label2879;
          }
          getMapViewListener().onClickStreetSurface((MapObj)localObject6);
          break label2879;
        }
        if (i2 == 1239)
        {
          localObject5 = localObject3;
          if (localObject5 != null) {
            ((List)localObject5).add(localObject6);
          }
          if (getMapViewListener() == null) {
            break label2879;
          }
          getMapViewListener().onClickedRouteLabelObj((List)localObject5);
          break label2879;
        }
        if (i2 == 6000)
        {
          if (getMapViewListener() == null) {
            break label2879;
          }
          getMapViewListener().onClickedTrafficUgcEventMapObj((MapObj)localObject6, true);
          break label2879;
        }
        if (i2 == 7000)
        {
          localObject8 = localArrayList1;
          if (localObject8 == null) {
            break label2904;
          }
          ((List)localObject8).add(localObject6);
          break label2904;
        }
        if (i2 != 6002) {
          break label2882;
        }
        if (getMapViewListener() == null) {
          break label2904;
        }
        getMapViewListener().onClickedTrafficUgcEventMapObj((MapObj)localObject6, ((JSONObject)localObject8).optBoolean("bchecked"));
        break label2904;
        localArrayList2.add(localObject6);
        break label2904;
        if (getMapViewListener() == null) {
          break label2904;
        }
        getMapViewListener().onClickSdkMapObj(i2, (JSONObject)localObject8);
        break label2904;
        getMapViewListener().onClickedStreetIndoorPoi((MapObj)localObject6);
        break label2901;
        localObject8 = localObject3;
        if (localObject8 == null) {
          break label2904;
        }
        ((List)localObject8).add(localObject6);
        break label2904;
        localObject8 = localObject1;
        i1 = paramInt1;
        if (localObject8 == null) {
          break label2913;
        }
        ((List)localObject8).add(localObject6);
        i1 = paramInt1;
        break label2913;
        if (getMapViewListener() != null)
        {
          getMapViewListener().onClickedStreetPopup(str);
          break label2501;
          if (getMapViewListener() != null)
          {
            for (localObject1 = getMapViewListener();; localObject1 = getMapViewListener())
            {
              ((MapViewListener)localObject1).onClickedMapObj(localArrayList2);
              break;
              if (getMapViewListener() == null) {
                break;
              }
              getMapViewListener().onClickedUniversalLayerPoiEventMapObj((List)localObject5);
              break;
              if (getMapViewListener() == null) {
                break;
              }
            }
            if (getMapViewListener() != null)
            {
              getMapViewListener().onClickedItsMapObj((List)localObject7);
              break label2501;
              if (getMapViewListener() != null)
              {
                getMapViewListener().onClickedParticleEventMapObj(localArrayList1);
                break label2501;
                if (getMapViewListener() != null) {
                  if (paramInt1 == 27)
                  {
                    getMapViewListener().onClickPolymericMapObj((List)localObject5);
                  }
                  else
                  {
                    for (localObject1 = getMapViewListener();; localObject1 = getMapViewListener())
                    {
                      ((MapViewListener)localObject1).onClickedPoiObj((List)localObject5);
                      break;
                      if (getMapViewListener() == null) {
                        break;
                      }
                    }
                    if (getMapViewListener() != null)
                    {
                      getMapViewListener().onClickedRouteObj((List)localObject3);
                      break label2501;
                      if (getMapViewListener() != null) {
                        getMapViewListener().onClickedMapObj((List)localObject4);
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
    for (;;)
    {
      return true;
      return false;
      for (;;)
      {
        label2534:
        if ((i2 == 3) || (i2 == 13) || (i2 == 14) || (i2 == 16) || (i2 == 15) || (i2 == 4) || (i2 == 103) || (i2 == 25) || (i2 == 31) || (i2 == 104) || (i2 == 5000) || (i2 == 6018) || (i2 == 6019)) {
          break label2655;
        }
        if ((i2 == 8) || (i2 == 1)) {
          break label499;
        }
        if (i2 != 2) {
          break;
        }
        break label499;
        localObject2 = null;
      }
      label2655:
      break label511;
      label2657:
      localObject6 = localObject2;
      Object localObject2 = null;
      localObject3 = null;
      break label2673;
      label2670:
      localObject6 = null;
      label2673:
      localObject4 = null;
      localObject5 = null;
      label2679:
      localArrayList1 = null;
      localObject7 = localObject2;
      label2686:
      paramInt2 = 0;
      paramInt1 = -1;
      localObject2 = localObject3;
      localObject3 = localObject6;
      break label526;
      label2701:
      if (localObject9 != null) {
        break label776;
      }
      d2 = 0.0D;
      break label784;
      label2712:
      break label848;
      label2838:
      label2841:
      for (;;)
      {
        label2715:
        i1 = paramInt1;
        break label2913;
        label2721:
        if ((i2 == 3) || (i2 == 13) || (i2 == 14) || (i2 == 16) || (i2 == 15) || (i2 == 4) || (i2 == 103) || (i2 == 25) || (i2 == 31) || (i2 == 104) || (i2 == 5000) || (i2 == 6018)) {
          break label2910;
        }
        if (i2 == 6019) {
          break label2248;
        }
        if ((i2 == 8) || (i2 == 1)) {
          break label2226;
        }
        if (i2 != 2) {
          break;
        }
        break label2226;
      }
      label2844:
      if ((i2 == 1234) || (i2 == 1236) || (i2 == 2000)) {
        break label2212;
      }
      if (i2 != 2001) {
        break label1973;
      }
      break label2212;
      label2879:
      break label2901;
      label2882:
      if (i2 == 90909) {
        break label2189;
      }
      if (i2 != 90910) {
        break label2176;
      }
      break label2189;
      label2901:
      break label2925;
      label2904:
      i1 = paramInt1;
      break label2913;
      label2910:
      break label2248;
      label2913:
      paramInt2 += 1;
      paramInt1 = i1;
      break label526;
      label2923:
      return false;
      label2925:
      localObject5 = localObject2;
      if (i2 == 6) {
        break label2483;
      }
      if (i2 == 8) {
        break label2462;
      }
      if ((i2 == 25) || (i2 == 31)) {
        break label2446;
      }
      if (i2 == 5000) {
        break label2401;
      }
      if (i2 == 7000) {
        break label2380;
      }
      if (i2 == 22) {
        break label2359;
      }
      if (i2 == 23) {
        break label2343;
      }
      if ((i2 == 103) || (i2 == 104)) {
        break label2446;
      }
      if ((i2 == 6018) || (i2 == 6019)) {
        break label2322;
      }
      if ((i2 == 6060) || (i2 == 6061)) {
        break label2297;
      }
      if ((i2 == 1) || (i2 == 2)) {
        break label2462;
      }
      if ((i2 == 3) || (i2 == 4)) {
        break label2446;
      }
      switch (i2)
      {
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool4 = a();
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool4) {
      return false;
    }
    Object localObject1 = this.I;
    if (localObject1 != null)
    {
      if (((SoftReference)localObject1).get() == null) {
        return false;
      }
      localObject1 = (MapViewInterface)this.I.get();
      l2 = 0L;
      l1 = l2;
      for (;;)
      {
        try
        {
          i1 = ((MapViewInterface)localObject1).getOverlays().size() - 1;
          if (i1 >= 0)
          {
            l1 = l2;
            localObject2 = (Overlay)((MapViewInterface)localObject1).getOverlays().get(i1);
            l1 = l2;
            if (((Overlay)localObject2).mType != 27)
            {
              l3 = l2;
            }
            else
            {
              l1 = l2;
              l2 = ((Overlay)localObject2).mLayerID;
              l1 = l2;
              i2 = (int)(this.nearlyRadius * getZoomUnitsInMeter());
              l1 = l2;
              localObject2 = this.h;
              l3 = l2;
              if (localObject2 != null)
              {
                l1 = l2;
                localObject2 = ((AppBaseMap)localObject2).GetNearlyObjID(l2, paramInt2, paramInt3, i2);
                l3 = l2;
                if (localObject2 != null)
                {
                  l3 = l2;
                  l1 = l2;
                  if (!((String)localObject2).equals(""))
                  {
                    l1 = l2;
                    localObject2 = (JSONObject)new JSONObject((String)localObject2).getJSONArray("dataset").get(0);
                    l1 = l2;
                    i2 = ((JSONObject)localObject2).getInt("itemindex");
                  }
                }
              }
            }
          }
        }
        catch (JSONException localJSONException1)
        {
          int i1;
          Object localObject2;
          long l3;
          int i2;
          continue;
        }
        try
        {
          i1 = ((JSONObject)localObject2).optInt("clickindex", -1);
          l1 = l2;
          bool1 = true;
        }
        catch (JSONException localJSONException2)
        {
          l1 = l2;
          continue;
        }
        i1 -= 1;
        l2 = l3;
      }
      i2 = -1;
      i1 = i2;
      bool1 = bool3;
      l1 = l2;
      break label319;
      i2 = -1;
      i1 = -1;
      label319:
      bool2 = bool1;
      if (paramInt1 == 1)
      {
        bool2 = bool1;
        if (getMapViewListener() != null)
        {
          bool2 = bool1;
          if (getMapView() != null)
          {
            bool2 = bool1;
            if (getMapView().getProjection() != null)
            {
              localObject1 = ((MapViewInterface)localObject1).getProjection().fromPixels(paramInt2, paramInt3);
              if (i1 != -1)
              {
                getMapViewListener().onClickedItem(i2, i1, (GeoPoint)localObject1, l1);
                return bool1;
              }
              getMapViewListener().onClickedItem(i2, (GeoPoint)localObject1, l1);
              bool2 = bool1;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private void b()
  {
    MessageProxy.registerMessageHandler(4000, this.j);
    MessageProxy.registerMessageHandler(519, this.j);
    MessageProxy.registerMessageHandler(39, this.j);
    MessageProxy.registerMessageHandler(512, this.j);
    MessageProxy.registerMessageHandler(65297, this.j);
    MessageProxy.registerMessageHandler(65298, this.j);
    MessageProxy.registerMessageHandler(50, this.j);
    MessageProxy.registerMessageHandler(51, this.j);
    MessageProxy.registerMessageHandler(65301, this.j);
    MessageProxy.registerMessageHandler(41, this.j);
    MessageProxy.registerMessageHandler(2082, this.j);
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    Object localObject = this.I;
    if (localObject != null)
    {
      if (((SoftReference)localObject).get() == null) {
        return false;
      }
      int i2 = (int)(this.nearlyRadius * getZoomUnitsInMeter());
      localObject = (MapViewInterface)this.I.get();
      int i1 = ((MapViewInterface)localObject).getBmlayers().size() - 1;
      while (i1 >= 0)
      {
        if (((BmLayer)((MapViewInterface)localObject).getBmlayers().get(i1)).a(paramInt1, paramInt2, i2)) {
          return true;
        }
        i1 -= 1;
      }
    }
    return false;
  }
  
  private void c()
  {
    this.r = false;
    this.u = -1.0F;
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    localObject3 = "poiname";
    String str7 = "geo";
    String str5 = "index";
    String str6 = "in";
    String str8 = "ty";
    String str1 = "z";
    localObject4 = "y";
    String str2 = "x";
    Object localObject1 = "ud";
    boolean bool = a();
    String str3 = "dis";
    if (!bool) {
      return false;
    }
    if (getMapViewListener() == null) {
      return false;
    }
    int i1 = this.nearlyRadius;
    String str4 = "poiindoorid";
    i1 = (int)(i1 * getZoomUnitsInMeter());
    Object localObject5 = this.h.GetNearlyObjID(-1L, paramInt1, paramInt2, i1);
    if (localObject5 == null) {
      return false;
    }
    new ArrayList();
    try
    {
      localJSONArray = new JSONObject((String)localObject5).getJSONArray("dataset");
      if (((JSONObject)localJSONArray.get(0)).getInt("ty") != 7000) {
        break label1149;
      }
      localObject5 = new ArrayList();
      paramInt1 = 0;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        Object localObject6;
        MapObj localMapObj;
        label344:
        Object localObject7;
        Point localPoint;
        double d1;
        double d2;
        label1149:
        continue;
        if (localObject6 == null)
        {
          localObject6 = localObject3;
          localObject3 = localJSONException1;
          Object localObject2 = localObject6;
          if (localObject7 == null)
          {
            d2 = 0.0D;
            continue;
            continue;
            continue;
            localObject6 = localObject4;
            localObject4 = localObject2;
            paramInt1 += 1;
            localObject2 = localObject3;
            localObject3 = localObject4;
            localObject4 = localObject6;
          }
        }
      }
    }
    paramInt2 = localJSONArray.length();
    if (paramInt1 < paramInt2)
    {
      try
      {
        JSONObject localJSONObject = (JSONObject)localJSONArray.get(paramInt1);
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        localObject6 = null;
      }
      i1 = localObject6.getInt(str8);
      if (i1 == 26) {
        break label1161;
      }
      localMapObj = new MapObj();
      bool = localObject6.has((String)localObject1);
      if (bool) {
        localMapObj.strUid = localObject6.getString((String)localObject1);
      } else {
        localMapObj.strUid = "";
      }
      localMapObj.strText = localObject6.optString("tx");
      if (localObject6.has(str6)) {}
      for (paramInt2 = localObject6.getInt(str6);; paramInt2 = localObject6.getInt(str5))
      {
        localMapObj.nIndex = paramInt2;
        break label344;
        if (!localObject6.has(str5)) {
          break;
        }
      }
      localMapObj.nIndex = 0;
      if (localObject6.has(str7))
      {
        localObject7 = CoordinateUtil.complexPtToPoint(localObject6.getString(str7));
        localPoint = localMapObj.geoPt;
        if (localObject7 == null)
        {
          d1 = 0.0D;
          break label1176;
        }
        d1 = ((Point)localObject7).getIntX();
        break label1176;
        d2 = ((Point)localObject7).getIntY();
        localPoint.setTo(d1, d2);
        break label1187;
      }
      if ((!localObject6.has("ptx")) || (!localObject6.has("pty"))) {
        break label1187;
      }
      localMapObj.geoPt.setTo((int)localObject6.getDouble("ptx"), (int)localObject6.getDouble("pty"));
      if (localObject6.has("ts")) {
        localMapObj.sltime = localObject6.getInt("ts");
      }
      if (localObject6.has("obj")) {
        localMapObj.slobj = localObject6.getInt("obj");
      }
      if (localObject6.has("visible")) {
        localMapObj.slvisi = localObject6.getInt("visible");
      }
      localMapObj.nType = i1;
      if (localObject6.has("of")) {
        localMapObj.offset = localObject6.getInt("of");
      }
      if (localObject6.has((String)localObject3)) {
        localMapObj.ssName = localObject6.getString((String)localObject3);
      }
      if (localObject6.has(str4)) {
        localMapObj.ssIndoorId = localObject6.getString(str4);
      }
      if (localObject6.has((String)localObject1)) {
        localMapObj.ssPoiUid = localObject6.getString((String)localObject1);
      }
      localObject7 = str3;
      if (localObject6.has((String)localObject7)) {
        localMapObj.offset = localObject6.getInt((String)localObject7);
      }
      localObject7 = str2;
      if (localObject6.has((String)localObject7))
      {
        localMapObj.geoPt.setIntX(localObject6.getInt((String)localObject7));
        localMapObj.streetArrowCenterX = localObject6.getDouble((String)localObject7);
      }
      localObject7 = localObject4;
      if (localObject6.has((String)localObject7))
      {
        localMapObj.geoPt.setIntY(localObject6.getInt((String)localObject7));
        localMapObj.streetArrowCenterY = localObject6.getDouble((String)localObject7);
      }
      localObject7 = str1;
      if (localObject6.has((String)localObject7)) {
        localMapObj.ssZ = localObject6.getInt((String)localObject7);
      }
      if (!localObject6.has("rotation")) {
        break label1190;
      }
      localMapObj.ssRotation = localObject6.getDouble("rotation");
      localObject7 = localObject3;
      if (localObject6.has("pid")) {
        localMapObj.ssPanoId = localObject6.getString("pid");
      }
      if (localObject6.has("customdata")) {
        localMapObj.ssData = localObject6.getString("customdata");
      }
      if (localObject6.has("src")) {
        localMapObj.dynamicSrc = localObject6.getInt("src");
      } else {
        localMapObj.dynamicSrc = -1;
      }
      if (localObject6.has("ad")) {
        localMapObj.ad = localObject6.getInt("ad");
      } else {
        localMapObj.ad = -1;
      }
      if (localObject6.has("ad_style")) {
        localMapObj.adstyle = localObject6.getInt("ad_style");
      } else {
        localMapObj.adstyle = -1;
      }
      if (localObject6.has("qid")) {
        localMapObj.qid = localObject6.getString("qid");
      } else {
        localMapObj.qid = "";
      }
      localObject3 = "";
      if (localObject6.has("puid")) {
        localMapObj.puid = localObject6.getString("puid");
      } else {
        localMapObj.puid = ((String)localObject3);
      }
      if (localObject6.has("ad_log")) {
        localMapObj.adLog = localObject6.getString("ad_log");
      } else {
        localMapObj.adLog = ((String)localObject3);
      }
      if (localObject6.has("url")) {
        localObject3 = localObject6.getString("url");
      }
      localMapObj.url = ((String)localObject3);
      if (localObject6.has("level")) {
        localMapObj.level = localObject6.getInt("level");
      } else {
        localMapObj.level = -1;
      }
      ((List)localObject5).add(localMapObj);
      localObject3 = localObject1;
      localObject1 = localObject7;
      break label1193;
    }
    else
    {
      getMapViewListener().onClickedParticleEventMapObj((List)localObject5);
      return true;
      return false;
    }
  }
  
  private void d()
  {
    MessageProxy.unRegisterMessageHandler(4000, this.j);
    MessageProxy.unRegisterMessageHandler(519, this.j);
    MessageProxy.unRegisterMessageHandler(39, this.j);
    MessageProxy.unRegisterMessageHandler(512, this.j);
    MessageProxy.unRegisterMessageHandler(65297, this.j);
    MessageProxy.unRegisterMessageHandler(65298, this.j);
    MessageProxy.unRegisterMessageHandler(50, this.j);
    MessageProxy.unRegisterMessageHandler(51, this.j);
    MessageProxy.unRegisterMessageHandler(65301, this.j);
    MessageProxy.unRegisterMessageHandler(41, this.j);
    MessageProxy.unRegisterMessageHandler(2082, this.j);
  }
  
  private boolean d(int paramInt1, int paramInt2)
  {
    boolean bool = a();
    int i2 = 0;
    int i1 = 0;
    if (!bool) {
      return false;
    }
    Object localObject1 = this.h.GetNearlyObjID(-1L, paramInt1, paramInt2, this.nearlyRadius);
    Object localObject2 = null;
    if ((localObject1 != null) && (!((String)localObject1).equals("")))
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        try
        {
          ((JSONObject)localObject1).put("px", paramInt1);
          ((JSONObject)localObject1).put("py", paramInt2);
        }
        catch (JSONException localJSONException1) {}
        localJSONException2.printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        localObject1 = localObject2;
      }
      if (this.mListeners != null) {
        paramInt1 = i1;
      }
    }
    else
    {
      while (paramInt1 < this.mListeners.size())
      {
        x localx = (x)this.mListeners.get(paramInt1);
        if ((localObject1 != null) && (localx != null)) {
          localx.b(((JSONObject)localObject1).toString());
        }
        paramInt1 += 1;
        continue;
        if (this.mListeners != null)
        {
          if (getMapView() != null)
          {
            if (getMapView().getProjection() == null) {
              return false;
            }
            localObject1 = getMapView().getProjection().fromPixels(paramInt1, paramInt2);
            paramInt1 = i2;
            while (paramInt1 < this.mListeners.size())
            {
              localx = (x)this.mListeners.get(paramInt1);
              if (localx != null) {
                localx.c((GeoPoint)localObject1);
              }
              paramInt1 += 1;
            }
          }
          return false;
        }
      }
    }
    return true;
  }
  
  public static int getScaleDis(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 22: 
      return 2;
    case 21: 
      return 5;
    case 20: 
      return 10;
    case 19: 
      return 20;
    case 18: 
      return 50;
    case 17: 
      return 100;
    case 16: 
      return 200;
    case 15: 
      return 500;
    case 14: 
      return 1000;
    case 13: 
      return 2000;
    case 12: 
      return 5000;
    case 11: 
      return 10000;
    case 10: 
      return 20000;
    case 9: 
      return 25000;
    case 8: 
      return 50000;
    case 7: 
      return 100000;
    case 6: 
      return 200000;
    case 5: 
      return 500000;
    case 4: 
      return 1000000;
    case 3: 
      return 2000000;
    case 2: 
      return 5000000;
    }
    return 10000000;
  }
  
  public float GetFZoomToBoundF(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (!a()) {
      return 0.0F;
    }
    return this.h.GetFZoomToBoundF(paramBundle1, paramBundle2);
  }
  
  public int MapMsgProc(int paramInt1, int paramInt2, int paramInt3)
  {
    return MapMsgProc(paramInt1, paramInt2, paramInt3, 0, 0, 0.0D, 0.0D, 0.0D, 0.0D);
  }
  
  public int MapMsgProc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    if (!a()) {
      return -1;
    }
    return MapProc(this.i, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  public void SetStyleMode(int paramInt)
  {
    setMapScene(paramInt);
  }
  
  public void addOneOverlayItem(Bundle paramBundle)
  {
    this.h.addOneOverlayItem(paramBundle);
  }
  
  public void addStreetCustomMarker(Bundle paramBundle, Bitmap paramBitmap)
  {
    if (!a()) {
      return;
    }
    this.h.AddStreetCustomMarker(paramBundle, paramBitmap);
  }
  
  public void animateTo(GeoPoint paramGeoPoint, int paramInt)
  {
    if (!a()) {
      return;
    }
    MapStatus localMapStatus = getMapStatus();
    localMapStatus.centerPtX = paramGeoPoint.getLongitude();
    localMapStatus.centerPtY = paramGeoPoint.getLatitude();
    setMapStatusWithAnimation(localMapStatus, paramInt);
  }
  
  public boolean cleanCache(MapLayerType paramMapLayerType)
  {
    AppBaseMap localAppBaseMap = this.h;
    return (localAppBaseMap != null) && (localAppBaseMap.CleanCache(MapLayerType.a(paramMapLayerType)));
  }
  
  public void clearUniversalLayer()
  {
    if (a()) {
      this.h.clearUniversalLayer();
    }
  }
  
  public boolean createByDuplicateAppBaseMap(long paramLong)
  {
    Object localObject = new AppBaseMap();
    this.h = ((AppBaseMap)localObject);
    if (((AppBaseMap)localObject).CreateByDuplicate(paramLong))
    {
      this.M = true;
      this.i = this.h.GetId();
      localObject = V;
      if (localObject != null) {
        ((List)localObject).add(this.h);
      }
      return true;
    }
    this.h = null;
    this.i = 0L;
    return false;
  }
  
  void e(int paramInt1, int paramInt2)
  {
    if (!a()) {
      return;
    }
    this.h.MoveToScrPoint(paramInt1, paramInt2);
  }
  
  public void enablePOIAnimation(boolean paramBoolean)
  {
    if (a()) {
      this.h.enablePOIAnimation(paramBoolean);
    }
  }
  
  public void forceSetMapScene(int paramInt)
  {
    this.d = paramInt;
    if (a()) {
      this.h.setMapScene(this.d);
    }
  }
  
  public boolean forceSetMapThemeScene(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.e = paramInt1;
    this.d = paramInt2;
    if (!a()) {
      return false;
    }
    return this.h.setMapThemeScene(paramInt1, paramInt2, paramBundle);
  }
  
  public float getAdapterZoomUnitsEx()
  {
    if (!a()) {
      return 0.0F;
    }
    return this.h.GetAdapterZoomUnitsEx();
  }
  
  public AppBaseMap getBaseMap()
  {
    return this.h;
  }
  
  public int getCacheSize(MapLayerType paramMapLayerType)
  {
    AppBaseMap localAppBaseMap = this.h;
    if (localAppBaseMap == null) {
      return 0;
    }
    return localAppBaseMap.GetCacheSize(MapLayerType.a(paramMapLayerType));
  }
  
  public CaptureMapListener getCaptureMapListener()
  {
    return this.C;
  }
  
  public String getCityInfoByID(int paramInt)
  {
    AppBaseMap localAppBaseMap = this.h;
    if (localAppBaseMap != null) {
      return localAppBaseMap.GetCityInfoByID(paramInt);
    }
    return null;
  }
  
  public MapStatus getCurrentMapStatus()
  {
    return a(false);
  }
  
  public float getCurrentZoomLevel()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return 4.0F;
    }
    localObject = ((AppBaseMap)localObject).GetMapStatus(false);
    if (localObject == null) {
      return 4.0F;
    }
    return (float)((Bundle)localObject).getDouble("level");
  }
  
  public IndoorMapInfo getFocusedBaseIndoorMapInfo()
  {
    if (!a()) {
      return null;
    }
    Object localObject1 = this.h.GetFocusedBaseIndoorMapInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject1);
        String str1 = localJSONObject.optString("focusindoorid");
        String str2 = localJSONObject.optString("curfloor");
        int i3 = localJSONObject.optInt("idrtype");
        localObject3 = localJSONObject.optJSONArray("floorlist");
        int i2 = 0;
        if (localObject3 == null) {
          break label246;
        }
        localObject1 = new String[((JSONArray)localObject3).length()];
        Object localObject4 = new ArrayList();
        int i1 = 0;
        if (i1 < ((JSONArray)localObject3).length())
        {
          ((List)localObject4).add(((JSONArray)localObject3).getString(i1));
          i1 += 1;
          continue;
        }
        ((List)localObject4).toArray((Object[])localObject1);
        JSONArray localJSONArray = localJSONObject.optJSONArray("floorattribute");
        if (localJSONArray == null) {
          break label252;
        }
        localObject4 = new int[localJSONArray.length()];
        i1 = i2;
        localObject3 = localObject4;
        if (i1 < localJSONArray.length())
        {
          localObject4[i1] = localJSONArray.optInt(i1);
          i1 += 1;
          continue;
        }
        localObject1 = new IndoorMapInfo(str1, str2, (String[])localObject1, (int[])localObject3, i3, localJSONObject.optInt("idrguide"), localJSONObject.optString("idrsearch"));
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        return null;
      }
      return null;
      label246:
      Object localObject2 = null;
      continue;
      label252:
      Object localObject3 = null;
    }
  }
  
  public com.baidu.platform.comapi.map.e0.c getGestureMonitor()
  {
    if (this.a == null) {
      this.a = new com.baidu.platform.comapi.map.e0.c(this);
    }
    return this.a;
  }
  
  public Bundle getGestureOptInfoForLog()
  {
    boolean bool = this.p.a;
    Bundle localBundle = null;
    if (!bool) {
      return null;
    }
    MapStatus localMapStatus = getMapStatus();
    int i1 = this.p.d.getIntX();
    int i2 = this.p.d.getIntY();
    double d1 = Math.sqrt(i1 * i1 + i2 * i2);
    i2 = 1;
    if (d1 > 100.0D) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    float f1 = this.p.b;
    if ((f1 <= 0.0F) || (Math.abs(localMapStatus.level - f1) < 0.5D)) {
      i2 = 0;
    }
    if ((i1 != 0) || (i2 != 0))
    {
      localBundle = new Bundle();
      localBundle.putDouble("pre_x", this.p.c.getLongitude());
      localBundle.putDouble("pre_y", this.p.c.getLatitude());
      localBundle.putFloat("pre_level", this.p.b);
    }
    this.p.a();
    return localBundle;
  }
  
  public i getHideIndoorPopupListener()
  {
    return this.D;
  }
  
  public EngineMsgListener getIndoorMapListener()
  {
    return this.G;
  }
  
  public boolean getMapBarData()
  {
    if (!a()) {
      return false;
    }
    Bundle localBundle = new Bundle();
    this.h.getMapBarData(localBundle);
    byte[] arrayOfByte = new byte[0];
    boolean bool = localBundle.containsKey("uid");
    String str3 = null;
    String str1;
    if (bool) {
      str1 = localBundle.getString("uid");
    } else {
      str1 = null;
    }
    String str2;
    if (localBundle.containsKey("searchbound")) {
      str2 = localBundle.getString("searchbound");
    } else {
      str2 = null;
    }
    if (localBundle.containsKey("curfloor")) {
      str3 = localBundle.getString("curfloor");
    }
    if (localBundle.containsKey("barinfo")) {
      arrayOfByte = localBundle.getByteArray("barinfo");
    }
    com.baidu.platform.comapi.util.a.a().a(new b(str1, str2, str3, arrayOfByte));
    return true;
  }
  
  public boolean getMapBarShowData()
  {
    if (!a()) {
      return false;
    }
    Bundle localBundle = new Bundle();
    return this.h.getMapBarData(localBundle);
  }
  
  public boolean getMapClickEnable()
  {
    return this.m;
  }
  
  public MapControlMode getMapControlMode()
  {
    return this.O;
  }
  
  public long getMapId()
  {
    return this.i;
  }
  
  public MapRenderModeChangeListener getMapRenderModeChangeListener()
  {
    return this.F;
  }
  
  public int getMapScene()
  {
    if (!a()) {
      return 0;
    }
    return this.h.getMapScene();
  }
  
  public MapStatus getMapStatus()
  {
    return a(true);
  }
  
  public s getMapStatusInner()
  {
    if (!a()) {
      return null;
    }
    Bundle localBundle = this.h.GetMapStatus();
    s locals = new s();
    locals.a(localBundle);
    return locals;
  }
  
  public int getMapTheme()
  {
    if (!a()) {
      return 0;
    }
    return this.h.getMapTheme();
  }
  
  public MapViewInterface getMapView()
  {
    SoftReference localSoftReference = this.I;
    if (localSoftReference != null) {
      return (MapViewInterface)localSoftReference.get();
    }
    return null;
  }
  
  public MapViewListener getMapViewListener()
  {
    return this.B;
  }
  
  public o getMapViewSurfaceListener()
  {
    return this.H;
  }
  
  public NaviMapViewListener getNaviMapViewListener()
  {
    return this.J;
  }
  
  public String getProjectionPt(String paramString)
  {
    if (!a()) {
      return null;
    }
    return this.h.getProjectionPt(paramString);
  }
  
  public int getScaleLevel(int paramInt1, int paramInt2)
  {
    if (!a()) {
      return 0;
    }
    return this.h.getScaleLevel(paramInt1, paramInt2);
  }
  
  public int getSceneLayerScene()
  {
    return this.d;
  }
  
  public int getSceneLayerTheme()
  {
    return this.e;
  }
  
  public int getScreenHeight()
  {
    MapStatus.WinRound localWinRound = getMapStatus().winRound;
    int i1 = localWinRound.bottom - localWinRound.top;
    this.l = i1;
    return i1;
  }
  
  public int getScreenWidth()
  {
    MapStatus.WinRound localWinRound = getMapStatus().winRound;
    int i1 = localWinRound.right - localWinRound.left;
    this.k = i1;
    return i1;
  }
  
  public z getStreetArrowClickListener()
  {
    return this.E;
  }
  
  public int getVMPMapCityCode()
  {
    if (this.h != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("querytype", "map");
      this.h.GetVMPMapCityInfo(localBundle);
      return localBundle.getInt("code");
    }
    return 0;
  }
  
  public int getVMPMapCityItsInfo()
  {
    if (this.h != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("querytype", "its");
      this.h.GetVMPMapCityInfo(localBundle);
      return localBundle.getInt("rst");
    }
    return 0;
  }
  
  public int getVMPMapCityLevel()
  {
    if (this.h != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("querytype", "map");
      this.h.GetVMPMapCityInfo(localBundle);
      return localBundle.getInt("level");
    }
    return 0;
  }
  
  public int getVMPMapCitySatInfo()
  {
    if (this.h != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("querytype", "sat");
      this.h.GetVMPMapCityInfo(localBundle);
      return localBundle.getInt("rst");
    }
    return 0;
  }
  
  public float getZoomLevel()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return 4.0F;
    }
    localObject = ((AppBaseMap)localObject).GetMapStatus();
    if (localObject == null) {
      return 4.0F;
    }
    return (float)((Bundle)localObject).getDouble("level");
  }
  
  public float getZoomToBound(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!a()) {
      return 0.0F;
    }
    return this.h.GetZoomToBound(paramBundle, paramInt1, paramInt2);
  }
  
  public float getZoomToBoundF(Bundle paramBundle)
  {
    if (!a()) {
      return 0.0F;
    }
    return this.h.GetZoomToBoundF(paramBundle);
  }
  
  public double getZoomUnitsInMeter()
  {
    Object localObject = getBaseMap();
    if (localObject != null)
    {
      localObject = ((AppBaseMap)localObject).GetMapStatus();
      if (localObject != null)
      {
        double d1 = ((Bundle)localObject).getFloat("adapterZoomUnits");
        if (d1 > 0.0001D) {
          return d1;
        }
      }
    }
    return Math.pow(2.0D, 18.0F - getZoomLevel());
  }
  
  public void handleClick(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getY();
    MapMsgProc(20738, 0, (int)paramMotionEvent.getX() | i1 << 16);
  }
  
  public void handleDoubleClickZoom(MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - this.v < 100L) {
      return;
    }
    mapStatusChangeStart();
    this.mIsAnimating = true;
    float f1 = paramMotionEvent.getY();
    MapMsgProc(8193, 3, (int)((this.u - f1) / (getScreenHeight() / 9.0F) * 10000.0F));
    this.u = f1;
    com.baidu.platform.comapi.util.a.a().a(new d());
    if ((isNaviMode()) && (getNaviMapViewListener() != null)) {
      getNaviMapViewListener().onAction(521, null);
    }
  }
  
  public void handleDoubleDownClick(MotionEvent paramMotionEvent)
  {
    this.r = true;
    paramMotionEvent.getX();
    this.u = paramMotionEvent.getY();
    this.v = System.currentTimeMillis();
    com.baidu.platform.comapi.util.a.a().a(new d());
  }
  
  public void handleDoubleTouch(MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - this.v > 150L) {
      return;
    }
    if (isNaviMode())
    {
      localObject = this.J;
      if (localObject != null)
      {
        ((NaviMapViewListener)localObject).onAction(513, paramMotionEvent);
        return;
      }
    }
    boolean bool = this.q;
    int i1 = 0;
    Object localObject = null;
    if (bool)
    {
      localObject = this.I;
      if ((localObject != null) && (((SoftReference)localObject).get() != null))
      {
        if (((MapViewInterface)this.I.get()).getProjection() == null) {
          return;
        }
        localObject = getMapStatus();
        float f1 = paramMotionEvent.getX() - (((MapStatus)localObject).winRound.left + getScreenWidth() / 2);
        float f2 = (paramMotionEvent.getY() - (((MapStatus)localObject).winRound.top + getScreenHeight() / 2)) * -1.0F;
        bool = isCompass;
        float f4 = 0.0F;
        if ((!bool) && (!this.t))
        {
          localObject = ((MapViewInterface)this.I.get()).getProjection().fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        }
        else
        {
          localObject = ((MapViewInterface)this.I.get()).getProjection().fromPixels(((MapStatus)localObject).winRound.left + getScreenWidth() / 2, ((MapStatus)localObject).winRound.top + getScreenHeight() / 2);
          f1 = 0.0F;
          f2 = f1;
        }
        float f3;
        if (localObject != null)
        {
          f3 = (float)((GeoPoint)localObject).getLongitudeE6();
          f4 = (float)((GeoPoint)localObject).getLatitudeE6();
        }
        else
        {
          f3 = 0.0F;
        }
        this.w = true;
        getGestureMonitor().a(((MapViewInterface)this.I.get()).getZoomLevel() + 1.0F);
        mapStatusChangeStart();
        int i2 = (int)paramMotionEvent.getY();
        MapMsgProc(8195, (int)paramMotionEvent.getX() | i2 << 16, this.l / 2 << 16 | this.k / 2, 0, 0, f3, f4, f1, f2);
        U = System.currentTimeMillis();
        procGestureForLog(false, null);
        paramMotionEvent = (MotionEvent)localObject;
      }
    }
    else
    {
      paramMotionEvent = (MotionEvent)localObject;
    }
    if ((paramMotionEvent != null) && (this.mListeners != null)) {
      while (i1 < this.mListeners.size())
      {
        localObject = (x)this.mListeners.get(i1);
        if (localObject != null) {
          ((x)localObject).b(paramMotionEvent);
        }
        i1 += 1;
      }
    }
  }
  
  @SuppressLint({"FloatMath"})
  public boolean handleFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = Q;
    int i1 = 0;
    if (!bool) {
      return false;
    }
    if (!this.A) {
      return false;
    }
    float f1 = SysOSUtil.getInstance().getDensityDPI() / 310.0F;
    paramFloat1 = (float)((float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) / f1 * 1.3D);
    if ((getMapControlMode() != MapControlMode.STREET) && (paramFloat1 < 300.0F))
    {
      this.n = false;
      return false;
    }
    this.n = true;
    getGestureMonitor().a();
    mapStatusChangeStart();
    MapMsgProc(34, (int)paramFloat1, (int)paramMotionEvent2.getY() << 16 | (int)paramMotionEvent2.getX());
    if (getMapViewListener() != null) {
      com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.d0.c());
    }
    this.L = false;
    if (this.mListeners != null) {
      while (i1 < this.mListeners.size())
      {
        paramMotionEvent1 = (x)this.mListeners.get(i1);
        if (paramMotionEvent1 != null) {
          paramMotionEvent1.a(paramMotionEvent2);
        }
        i1 += 1;
      }
    }
    return true;
  }
  
  public boolean handleKeyEvent(int paramInt, KeyEvent paramKeyEvent)
  {
    paramInt = GetAdaptKeyCode(paramInt);
    if (paramInt == 0) {
      return false;
    }
    MapMsgProc(1, paramInt, 0);
    return true;
  }
  
  public void handleLongClick(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getY();
    MapMsgProc(20737, 0, (int)paramMotionEvent.getX() | i1 << 16);
  }
  
  public int handleMapModeGet()
  {
    return MapMsgProc(4113, 0, 0);
  }
  
  public boolean handlePopupClick(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void handleRightClick()
  {
    MapMsgProc(20739, 0, 0);
  }
  
  public void handleStreetscapeDoubleTouch(MotionEvent paramMotionEvent)
  {
    Object localObject1 = this.I;
    if ((localObject1 != null) && (((SoftReference)localObject1).get() != null))
    {
      if (((MapViewInterface)this.I.get()).getProjection() == null) {
        return;
      }
      Object localObject2 = getMapStatus();
      localObject1 = ((MapViewInterface)this.I.get()).getProjection();
      localObject2 = ((MapStatus)localObject2).winRound;
      localObject1 = ((Projection)localObject1).fromPixels(((MapStatus.WinRound)localObject2).left + this.k / 2, ((MapStatus.WinRound)localObject2).top + this.l / 2);
      float f2 = 0.0F;
      float f1;
      if (localObject1 != null)
      {
        f1 = (float)((GeoPoint)localObject1).getLongitudeE6();
        f2 = (float)((GeoPoint)localObject1).getLatitudeE6();
      }
      else
      {
        f1 = 0.0F;
      }
      MapMsgProc(8195, (int)paramMotionEvent.getY() << 16 | (int)paramMotionEvent.getX(), this.l / 2 << 16 | this.k / 2, 0, 0, f1, f2, 0.0D, 0.0D);
    }
  }
  
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = a();
    int i1 = 0;
    if (!bool) {
      return false;
    }
    if (!this.n) {
      this.N.a(paramMotionEvent);
    }
    if (paramMotionEvent.getPointerCount() == 2)
    {
      this.b = true;
      Q = false;
      c();
      procGestureForLog(false, null);
    }
    if ((paramMotionEvent.getAction() != 2) && (this.r))
    {
      this.b = true;
      c();
    }
    int i2 = paramMotionEvent.getAction();
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 2) {
          return false;
        }
        if (this.r) {
          handleDoubleClickZoom(paramMotionEvent);
        } else if (this.A) {
          handleTouchMove(paramMotionEvent);
        }
      }
      else
      {
        Q = true;
        this.b = true;
        handleTouchUp(paramMotionEvent);
      }
    }
    else
    {
      this.b = true;
      a(paramMotionEvent);
    }
    if (this.mListeners != null) {
      while (i1 < this.mListeners.size())
      {
        x localx = (x)this.mListeners.get(i1);
        if (localx != null) {
          localx.a(paramMotionEvent);
        }
        i1 += 1;
      }
    }
    return true;
  }
  
  public boolean handleTouchMove(MotionEvent paramMotionEvent)
  {
    if (!Q) {
      return true;
    }
    if (System.currentTimeMillis() - U < 300L) {
      return true;
    }
    boolean bool = this.mHasMapObjDraging;
    int i1 = 0;
    if (bool)
    {
      if ((getMapView() != null) && (getMapView().getProjection() != null))
      {
        paramMotionEvent = getMapView().getProjection().fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (this.mListeners != null) {
          while (i1 < this.mListeners.size())
          {
            x localx = (x)this.mListeners.get(i1);
            if ((localx != null) && (paramMotionEvent != null)) {
              localx.e(paramMotionEvent);
            }
            i1 += 1;
          }
        }
      }
      return true;
    }
    float f1 = Math.abs(paramMotionEvent.getX() - R);
    float f2 = Math.abs(paramMotionEvent.getY() - S);
    double d2 = SysOSUtil.getInstance().getDensity();
    double d1 = d2;
    if (d2 > 1.5D) {
      d1 = d2 * 1.5D;
    }
    float f3 = (float)d1;
    if ((T) && (f1 / f3 <= 3.0F) && (f2 / f3 <= 3.0F)) {
      return true;
    }
    T = false;
    if (isCompass) {
      com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.d0.a());
    }
    procGestureForLog(true, new Point(f1, f2));
    int i2 = (int)paramMotionEvent.getX();
    int i3 = (int)paramMotionEvent.getY();
    i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    i2 = i3;
    if (i3 < 0) {
      i2 = 0;
    }
    if (this.b)
    {
      getGestureMonitor().d();
      this.b = false;
    }
    mapStatusChangeStart();
    MapMsgProc(3, 0, i2 << 16 | i1);
    com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.d0.b(false, true));
    this.n = false;
    this.g = true;
    this.L = true;
    return false;
  }
  
  public boolean handleTouchSingleClick(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    d(i1, i2);
    if (c(i1, i2)) {
      return true;
    }
    if (handlePopupClick(i1, i2)) {
      return true;
    }
    if (b(i1, i2)) {
      return true;
    }
    if (a(1, i1, i2)) {
      return true;
    }
    if ((this.m) && (a(i1, i2))) {
      return true;
    }
    if (isNaviMode())
    {
      NaviMapViewListener localNaviMapViewListener = this.J;
      if (localNaviMapViewListener != null) {
        localNaviMapViewListener.onAction(514, paramMotionEvent);
      }
    }
    if (getMapViewListener() != null) {
      getMapViewListener().onClickedBackground((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
  }
  
  public boolean handleTouchUp(MotionEvent paramMotionEvent)
  {
    int i2 = (int)paramMotionEvent.getX();
    int i3 = (int)paramMotionEvent.getY();
    int i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    i2 = i3;
    if (i3 < 0) {
      i2 = 0;
    }
    x localx;
    if (this.mHasMapObjDraging)
    {
      if ((this.mListeners != null) && (getMapView() != null) && (getMapView().getProjection() != null))
      {
        paramMotionEvent = getMapView().getProjection().fromPixels(i1, i2);
        i1 = 0;
        while (i1 < this.mListeners.size())
        {
          localx = (x)this.mListeners.get(i1);
          if ((localx != null) && (paramMotionEvent != null)) {
            localx.a(paramMotionEvent);
          }
          i1 += 1;
        }
      }
      this.mHasMapObjDraging = false;
      return true;
    }
    if (Q) {
      MapMsgProc(5, 0, i1 | i2 << 16);
    }
    if ((!this.n) && (getMapViewListener() != null)) {
      getMapViewListener().onMapAnimationFinish();
    }
    if ((!this.n) && (isNaviMode()) && (getNaviMapViewListener() != null)) {
      getNaviMapViewListener().onMapAnimationFinish();
    }
    if ((paramMotionEvent.getEventTime() - this.K < 300L) && (Math.abs(paramMotionEvent.getX() - R) < 10.0F) && (Math.abs(paramMotionEvent.getY() - S) < 10.0F)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((!this.n) && ((i1 == 0) || (this.L)) && (!this.w) && (!this.mIsAnimating) && (this.mListeners != null))
    {
      paramMotionEvent = getMapStatusInner();
      i1 = 0;
      while (i1 < this.mListeners.size())
      {
        localx = (x)this.mListeners.get(i1);
        if (localx != null) {
          localx.b(paramMotionEvent);
        }
        i1 += 1;
      }
    }
    this.L = false;
    this.n = false;
    com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.d0.b(true, false));
    com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.d0.c());
    return true;
  }
  
  public boolean handleTrackballEvent(MotionEvent paramMotionEvent)
  {
    if (!a()) {
      return false;
    }
    if (paramMotionEvent.getAction() != 2) {
      return true;
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    int i1;
    if (f1 > 0.0F) {
      i1 = 18;
    } else if (f1 < 0.0F) {
      i1 = 16;
    } else {
      i1 = 0;
    }
    if (f2 > 0.0F) {
      i1 = 19;
    } else if (f2 < 0.0F) {
      i1 = 17;
    }
    if (i1 == 0) {
      return false;
    }
    MapMsgProc(1, i1, 0);
    return true;
  }
  
  public boolean handleZoomTo(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return false;
      }
      paramInt = 4096;
    }
    else
    {
      paramInt = 4097;
    }
    MapMsgProc(paramInt, -1, 0);
    return false;
  }
  
  public boolean importMapTheme(int paramInt)
  {
    if (!a()) {
      return false;
    }
    return this.h.importMapTheme(paramInt);
  }
  
  public void initAppBaseMap()
  {
    if (V.size() == 0)
    {
      initBaseMap();
      return;
    }
    createByDuplicateAppBaseMap(((AppBaseMap)V.get(0)).GetId());
  }
  
  public void initBaseMap()
  {
    Object localObject = new AppBaseMap();
    this.h = ((AppBaseMap)localObject);
    ((AppBaseMap)localObject).Create();
    this.i = this.h.GetId();
    localObject = V;
    if (localObject != null) {
      ((List)localObject).add(this.h);
    }
  }
  
  public void initMapResources(Bundle paramBundle)
  {
    if (this.o) {
      return;
    }
    if (paramBundle != null)
    {
      if (this.h == null) {
        return;
      }
      int i1;
      if (SysOSUtil.getInstance().getDensityDPI() >= 180) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.nearlyRadius = (SysOSUtil.getInstance().getDensityDPI() * 25 / 240);
      String str5 = paramBundle.getString("modulePath");
      Object localObject1 = paramBundle.getString("appSdcardPath");
      String str4 = paramBundle.getString("appCachePath");
      String str3 = paramBundle.getString("appSecondCachePath");
      String str2 = paramBundle.getString("engineErrorPath");
      int i2 = paramBundle.getInt("mapTmpMax");
      int i3 = paramBundle.getInt("domTmpMax");
      int i4 = paramBundle.getInt("itsTmpMax");
      int i5 = paramBundle.getInt("ssgTmpMax");
      if (i1 != 0) {
        str1 = "/h/";
      } else {
        str1 = "/l/";
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str5);
      ((StringBuilder)localObject2).append("/cfg");
      str5 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/vmp");
      Object localObject3 = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str5);
      ((StringBuilder)localObject1).append("/a/");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str5);
      ((StringBuilder)localObject2).append("/a/");
      str5 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append(str1);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(str1);
      String str1 = localStringBuilder.toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str4);
      ((StringBuilder)localObject3).append("/tmp/");
      str4 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str3);
      ((StringBuilder)localObject3).append("/tmp/");
      str3 = ((StringBuilder)localObject3).toString();
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("cfgdataroot", (String)localObject1);
      ((Bundle)localObject3).putString("vmpdataroot", (String)localObject2);
      ((Bundle)localObject3).putString("tmpdataroot", str4);
      ((Bundle)localObject3).putString("tmpdatapast", str3);
      ((Bundle)localObject3).putString("importroot", str1);
      ((Bundle)localObject3).putString("stylerespath", str5);
      if ((str2 != null) && (str2.length() > 0)) {
        ((Bundle)localObject3).putString("engineerrorpath", str2);
      }
      ((Bundle)localObject3).putInt("cx", this.k);
      ((Bundle)localObject3).putInt("cy", this.l);
      ((Bundle)localObject3).putInt("ndpi", SysOSUtil.getInstance().getDensityDPI());
      ((Bundle)localObject3).putFloat("fdpi", SysOSUtil.getInstance().getDensityDPI());
      ((Bundle)localObject3).putInt("maptmpmax", i2);
      ((Bundle)localObject3).putInt("domtmpmax", i3);
      ((Bundle)localObject3).putInt("itstmpmax", i4);
      ((Bundle)localObject3).putInt("ssgtmpmax", i5);
      ((Bundle)localObject3).putInt("pathchange", 0);
      if (paramBundle.containsKey("maptheme")) {
        ((Bundle)localObject3).putInt("maptheme", paramBundle.getInt("maptheme"));
      }
      if (paramBundle.containsKey("mapscene")) {
        ((Bundle)localObject3).putInt("mapscene", paramBundle.getInt("mapscene"));
      }
      if (paramBundle.containsKey("fontsizelevel")) {
        ((Bundle)localObject3).putInt("fontsizelevel", paramBundle.getInt("fontsizelevel"));
      }
      if (!com.baidu.platform.comapi.b.g()) {
        com.baidu.platform.comapi.b.e();
      }
      if (!this.h.initWithOptions((Bundle)localObject3, false))
      {
        Log.e(P, "MapControl init fail!");
        if (OpenLogUtil.isMapLogEnable()) {
          com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("MapControl init fail");
        }
        return;
      }
      this.h.SetMapStatus(paramBundle);
      this.o = true;
    }
  }
  
  public boolean is3DGestureEnable()
  {
    return this.x;
  }
  
  public boolean isBaseIndoorMapMode()
  {
    if (!a()) {
      return false;
    }
    return this.h.IsBaseIndoorMapMode();
  }
  
  public boolean isCanTouchMove()
  {
    return this.A;
  }
  
  public boolean isDoubleClickZoom()
  {
    return this.q;
  }
  
  public boolean isDuplicate()
  {
    return this.M;
  }
  
  public boolean isEnableDMoveZoom()
  {
    return this.r;
  }
  
  public boolean isEnableIndoor3D()
  {
    if (a()) {
      return this.h.isEnableIndoor3D();
    }
    return true;
  }
  
  public boolean isEnableZoom()
  {
    return this.z;
  }
  
  public boolean isEnlargeCenterWithDoubleClickEnabled()
  {
    return this.t;
  }
  
  public boolean isInFocusBarBorder(GeoPoint paramGeoPoint, double paramDouble)
  {
    boolean bool1 = a();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (paramGeoPoint != null)
    {
      bool1 = bool2;
      if (this.h.IsPointInFocusBarBorder(paramGeoPoint.getLongitude(), paramGeoPoint.getLatitude(), paramDouble)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isInFocusIndoorBuilding(GeoPoint paramGeoPoint)
  {
    boolean bool1 = a();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (paramGeoPoint != null)
    {
      bool1 = bool2;
      if (this.h.IsPointInFocusIDRBorder(paramGeoPoint.getLongitude(), paramGeoPoint.getLatitude())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isMapAnimationRunning()
  {
    if (!a()) {
      return false;
    }
    return this.h.isAnimationRunning();
  }
  
  public boolean isMovedMap()
  {
    return this.g;
  }
  
  public boolean isNaviMode()
  {
    if (a()) {
      return this.h.isNaviMode();
    }
    return false;
  }
  
  public boolean isOverlookGestureEnable()
  {
    return this.y;
  }
  
  public boolean isPressedOnPopup(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean isStreetArrowShown()
  {
    if (!a()) {
      return false;
    }
    return this.h.IsStreetArrowShown();
  }
  
  public boolean isStreetCustomMarkerShown()
  {
    if (!a()) {
      return false;
    }
    return this.h.IsStreetCustomMarkerShown();
  }
  
  public boolean isStreetPOIMarkerShown()
  {
    if (!a()) {
      return false;
    }
    return this.h.IsStreetPOIMarkerShown();
  }
  
  public boolean isStreetRoadClickable()
  {
    if (!a()) {
      return false;
    }
    return this.h.IsStreetRoadClickable();
  }
  
  public boolean isTwoTouchClickZoomEnabled()
  {
    return this.s;
  }
  
  public void mapStatusChangeStart()
  {
    if (this.mIsMoving) {
      return;
    }
    this.mIsMoving = true;
    int i1 = 0;
    this.mIsAnimating = false;
    s locals = getMapStatusInner();
    if (this.mListeners != null) {
      while (i1 < this.mListeners.size())
      {
        x localx = (x)this.mListeners.get(i1);
        if (localx != null) {
          localx.a(locals);
        }
        i1 += 1;
      }
    }
  }
  
  public void onPause()
  {
    if (a()) {
      this.h.OnPause();
    }
  }
  
  public void onResume()
  {
    if (a()) {
      this.h.OnResume();
    }
  }
  
  public void procGestureForLog(boolean paramBoolean, Point paramPoint)
  {
    if (!this.p.a)
    {
      MapStatus localMapStatus = getMapStatus();
      a locala = this.p;
      locala.a = true;
      locala.b = localMapStatus.level;
      locala.c = new GeoPoint(localMapStatus.centerPtX, localMapStatus.centerPtY);
      this.p.d = new Point(0, 0);
    }
    if (paramBoolean)
    {
      int i1 = Math.abs(paramPoint.getIntX());
      int i2 = Math.abs(paramPoint.getIntY());
      paramPoint = this.p.d;
      paramPoint.setIntX(paramPoint.getIntX() + i1);
      paramPoint = this.p.d;
      paramPoint.setIntY(paramPoint.getIntY() + i2);
    }
  }
  
  public void recycleMemory(RecycleMemoryLevel paramRecycleMemoryLevel)
  {
    if (a()) {
      this.h.recycleMemory(paramRecycleMemoryLevel.getLevel());
    }
  }
  
  public void registMapViewListener(x paramx)
  {
    if (paramx != null)
    {
      List localList = this.mListeners;
      if (localList == null) {
        return;
      }
      localList.add(paramx);
    }
  }
  
  public void removeOneOverlayItem(Bundle paramBundle)
  {
    this.h.removeOneOverlayItem(paramBundle);
  }
  
  public void removeStreetAllCustomMarker()
  {
    if (!a()) {
      return;
    }
    this.h.RemoveStreetAllCustomMarker();
  }
  
  public void removeStreetCustomMarker(String paramString)
  {
    if (!a()) {
      return;
    }
    this.h.RemoveStreetCustomMaker(paramString);
  }
  
  public void saveScreenToLocal(String paramString)
  {
    saveScreenToLocal(paramString, 0, 0, 0, 0);
  }
  
  public void saveScreenToLocal(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject3;
    Object localObject1;
    if (a())
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject3 = null;
      localObject1 = localObject3;
      if (paramInt3 != 0)
      {
        localObject1 = localObject3;
        if (paramInt4 != 0) {
          localObject1 = new JSONObject();
        }
      }
    }
    try
    {
      ((JSONObject)localObject1).put("x", paramInt1);
      ((JSONObject)localObject1).put("y", paramInt2);
      ((JSONObject)localObject1).put("width", paramInt3);
      ((JSONObject)localObject1).put("height", paramInt4);
      localObject1 = ((JSONObject)localObject1).toString();
      this.h.SaveScreenToLocal(paramString, (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    MapStatus.WinRound localWinRound = getMapStatus().winRound;
    e(localWinRound.left + this.k / 2 + paramInt1, localWinRound.top + this.l / 2 + paramInt2);
  }
  
  public void set3DGestureEnable(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public void setAllStreetCustomMarkerVisibility(boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    this.h.SetAllStreetCustomMarkerVisibility(paramBoolean);
  }
  
  public void setCanTouchMove(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public void setCaptureMapListener(CaptureMapListener paramCaptureMapListener)
  {
    this.C = paramCaptureMapListener;
  }
  
  public void setDoubleClickZoom(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setEnableIndoor3D(boolean paramBoolean)
  {
    if (a()) {
      this.h.setEnableIndoor3D(paramBoolean);
    }
  }
  
  public void setEnableZoom(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void setEngineMsgListener(EngineMsgListener paramEngineMsgListener)
  {
    this.G = paramEngineMsgListener;
  }
  
  public void setEnlargeCenterWithDoubleClickEnable(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void setHideIndoorPopupListener(i parami)
  {
    this.D = parami;
  }
  
  public boolean setLayerSceneMode(long paramLong, MapSceneMode paramMapSceneMode)
  {
    if (!a()) {
      return false;
    }
    return this.h.SetLayerSceneMode(paramLong, paramMapSceneMode.getMode());
  }
  
  public void setMapClickEnable(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public int setMapControlMode(MapControlMode paramMapControlMode)
  {
    if (!a()) {
      return -1;
    }
    this.O = paramMapControlMode;
    return this.h.SetMapControlMode(MapControlMode.a(paramMapControlMode));
  }
  
  public void setMapFirstFrameCallback(MapFirstFrameCallback paramMapFirstFrameCallback)
  {
    this.f = paramMapFirstFrameCallback;
  }
  
  public void setMapRenderModeChangeListener(MapRenderModeChangeListener paramMapRenderModeChangeListener)
  {
    this.F = paramMapRenderModeChangeListener;
  }
  
  public void setMapScene(int paramInt)
  {
    if (paramInt == getMapScene()) {
      return;
    }
    this.d = paramInt;
    if (a()) {
      this.h.setMapScene(this.d);
    }
  }
  
  public void setMapStatus(Bundle paramBundle)
  {
    if (!a()) {
      return;
    }
    this.h.SetMapStatus(paramBundle);
  }
  
  public void setMapStatus(MapStatus paramMapStatus)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setMapStatus(MapStatus paramMapStatus, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setMapStatusWithAnimation(MapStatus paramMapStatus, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setMapStatusWithAnimation(MapStatus paramMapStatus, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setMapStatusWithAnimation(MapStatus paramMapStatus, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean setMapTheme(int paramInt, Bundle paramBundle)
  {
    if (!a()) {
      return false;
    }
    if (this.h.getMapTheme() == paramInt) {
      return true;
    }
    this.e = paramInt;
    return this.h.setMapTheme(paramInt, paramBundle);
  }
  
  public boolean setMapThemeScene(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (!a()) {
      return false;
    }
    if ((this.h.getMapTheme() == paramInt1) && (this.h.getMapScene() == paramInt2)) {
      return true;
    }
    this.e = paramInt1;
    this.d = paramInt2;
    return this.h.setMapThemeScene(paramInt1, paramInt2, paramBundle);
  }
  
  public void setMapViewInterface(MapViewInterface paramMapViewInterface)
  {
    this.I = new SoftReference(paramMapViewInterface);
  }
  
  public void setMapViewListener(MapViewListener paramMapViewListener)
  {
    this.B = paramMapViewListener;
  }
  
  public void setMapViewSurfaceListener(o paramo)
  {
    this.H = paramo;
  }
  
  public void setMaxAndMinZoomLevel(float paramFloat1, float paramFloat2)
  {
    this.mMaxZoomLevel = paramFloat1;
    this.mMinZoomLevel = paramFloat2;
  }
  
  public void setNaviMapViewListener(NaviMapViewListener paramNaviMapViewListener)
  {
    this.J = paramNaviMapViewListener;
  }
  
  public void setNetStatus(int paramInt)
  {
    EngineMsgListener localEngineMsgListener = this.G;
    if (localEngineMsgListener == null) {
      return;
    }
    if (paramInt == 1) {
      localEngineMsgListener.onLongLinkConnect();
    } else if ((paramInt == 2) && (this.c != paramInt)) {
      localEngineMsgListener.onLongLinkDisConnect();
    }
    this.c = paramInt;
  }
  
  public void setOverlayMapCallBack(r paramr)
  {
    if (paramr != null)
    {
      AppBaseMap localAppBaseMap = this.h;
      if (localAppBaseMap != null) {
        localAppBaseMap.SetCallback(paramr);
      }
    }
  }
  
  public void setOverlookGestureEnable(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setRecommendPOIScene(RecommendPoiScene paramRecommendPoiScene)
  {
    if (a()) {
      this.h.setRecommendPOIScene(paramRecommendPoiScene.value);
    }
  }
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  public void setStreetArrowClickListener(z paramz)
  {
    this.E = paramz;
  }
  
  public void setStreetArrowShow(boolean paramBoolean)
  {
    if (a()) {
      this.h.SetStreetArrowShow(paramBoolean);
    }
  }
  
  public void setStreetMarkerClickable(String paramString, boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    this.h.SetStreetMarkerClickable(paramString, paramBoolean);
  }
  
  public void setStreetRoadClickable(boolean paramBoolean)
  {
    if (a()) {
      this.h.SetStreetRoadClickable(paramBoolean);
    }
  }
  
  public void setStyleMode(MapStyleMode paramMapStyleMode)
  {
    if (!a()) {
      return;
    }
    this.h.SetStyleMode(paramMapStyleMode.getMode());
  }
  
  public void setTargetStreetCustomMarkerVisibility(boolean paramBoolean, String paramString)
  {
    if (!a()) {
      return;
    }
    this.h.SetTargetStreetCustomMarkerVisibility(paramBoolean, paramString);
  }
  
  public void setTravelMode(boolean paramBoolean) {}
  
  public void setTwoTouchClickZoomEnabled(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void setUniversalFilter(String paramString)
  {
    if (a()) {
      this.h.setUniversalFilter(paramString);
    }
  }
  
  public void showBaseIndoorMap(boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    this.h.ShowBaseIndoorMap(paramBoolean);
  }
  
  public void showStreetPOIMarker(boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    this.h.ShowStreetPOIMarker(paramBoolean);
  }
  
  public void showUniversalLayer(Bundle paramBundle)
  {
    if (a()) {
      this.h.showUniversalLayer(paramBundle);
    }
  }
  
  public void startIndoorAnimation()
  {
    if (!a()) {
      return;
    }
    this.h.StartIndoorAnimation();
  }
  
  public boolean switchBaseIndoorMapFloor(String paramString1, String paramString2)
  {
    if (!a()) {
      return false;
    }
    return this.h.SwitchBaseIndoorMapFloor(paramString1, paramString2);
  }
  
  public void unInit()
  {
    d();
    Object localObject = this.j;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.j = null;
    }
    localObject = V;
    if (localObject != null) {
      ((List)localObject).remove(this.h);
    }
    localObject = this.mListeners;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    if (this.o)
    {
      localObject = this.h;
      if (localObject != null)
      {
        ((AppBaseMap)localObject).Release();
        this.h = null;
        this.o = false;
      }
    }
  }
  
  public void unInitForMultiTextureView()
  {
    if (this.o)
    {
      AppBaseMap localAppBaseMap = this.h;
      if (localAppBaseMap != null)
      {
        localAppBaseMap.Release();
        this.h = null;
        this.o = false;
      }
    }
  }
  
  public void updateDrawFPS()
  {
    if (a()) {
      this.h.updateDrawFPS();
    }
  }
  
  public void updateOneOverlayItem(Bundle paramBundle)
  {
    this.h.updateOneOverlayItem(paramBundle);
  }
  
  public static enum HeatMapType
  {
    private final int a;
    
    static
    {
      HeatMapType localHeatMapType1 = new HeatMapType("CITY", 0, 0);
      CITY = localHeatMapType1;
      HeatMapType localHeatMapType2 = new HeatMapType("SCENERY", 1, 1);
      SCENERY = localHeatMapType2;
      HeatMapType localHeatMapType3 = new HeatMapType("CEMETERY", 2, 2);
      CEMETERY = localHeatMapType3;
      b = new HeatMapType[] { localHeatMapType1, localHeatMapType2, localHeatMapType3 };
    }
    
    private HeatMapType(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getId()
    {
      return this.a;
    }
  }
  
  public static enum MapControlMode
  {
    private final int a;
    
    static
    {
      MapControlMode localMapControlMode1 = new MapControlMode("DEFAULT", 0, 1);
      DEFAULT = localMapControlMode1;
      MapControlMode localMapControlMode2 = new MapControlMode("INDOOR", 1, 2);
      INDOOR = localMapControlMode2;
      MapControlMode localMapControlMode3 = new MapControlMode("STREET", 2, 3);
      STREET = localMapControlMode3;
      MapControlMode localMapControlMode4 = new MapControlMode("STREET_WAITING", 3, 4);
      STREET_WAITING = localMapControlMode4;
      b = new MapControlMode[] { localMapControlMode1, localMapControlMode2, localMapControlMode3, localMapControlMode4 };
    }
    
    private MapControlMode(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  public static abstract interface MapFirstFrameCallback
  {
    public abstract void onFirstFrameDrawing(MapController paramMapController);
  }
  
  public static enum MapLayerType
  {
    private final int a;
    
    static
    {
      MapLayerType localMapLayerType1 = new MapLayerType("DEFAULT", 0, 1);
      DEFAULT = localMapLayerType1;
      MapLayerType localMapLayerType2 = new MapLayerType("SATELLITE", 1, 2);
      SATELLITE = localMapLayerType2;
      MapLayerType localMapLayerType3 = new MapLayerType("INDOOR", 2, 3);
      INDOOR = localMapLayerType3;
      MapLayerType localMapLayerType4 = new MapLayerType("STREET", 3, 5);
      STREET = localMapLayerType4;
      b = new MapLayerType[] { localMapLayerType1, localMapLayerType2, localMapLayerType3, localMapLayerType4 };
    }
    
    private MapLayerType(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  public static enum MapSceneMode
  {
    private final int a;
    
    static
    {
      MapSceneMode localMapSceneMode1 = new MapSceneMode("DEFAULT", 0, 0);
      DEFAULT = localMapSceneMode1;
      MapSceneMode localMapSceneMode2 = new MapSceneMode("POI", 1, 1);
      POI = localMapSceneMode2;
      MapSceneMode localMapSceneMode3 = new MapSceneMode("ROUTE", 2, 2);
      ROUTE = localMapSceneMode3;
      MapSceneMode localMapSceneMode4 = new MapSceneMode("INTERNAL", 3, 3);
      INTERNAL = localMapSceneMode4;
      MapSceneMode localMapSceneMode5 = new MapSceneMode("INDOOR", 4, 7);
      INDOOR = localMapSceneMode5;
      b = new MapSceneMode[] { localMapSceneMode1, localMapSceneMode2, localMapSceneMode3, localMapSceneMode4, localMapSceneMode5 };
    }
    
    private MapSceneMode(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getMode()
    {
      return this.a;
    }
  }
  
  public static enum MapStyleMode
  {
    private final int a;
    
    static
    {
      MapStyleMode localMapStyleMode1 = new MapStyleMode("DEFAULT", 0, 1);
      DEFAULT = localMapStyleMode1;
      MapStyleMode localMapStyleMode2 = new MapStyleMode("SEARCH_POI", 1, 2);
      SEARCH_POI = localMapStyleMode2;
      MapStyleMode localMapStyleMode3 = new MapStyleMode("SEARCH_ROUTE", 2, 3);
      SEARCH_ROUTE = localMapStyleMode3;
      MapStyleMode localMapStyleMode4 = new MapStyleMode("NAV_DAY", 3, 4);
      NAV_DAY = localMapStyleMode4;
      MapStyleMode localMapStyleMode5 = new MapStyleMode("NAV_NIGHT", 4, 5);
      NAV_NIGHT = localMapStyleMode5;
      MapStyleMode localMapStyleMode6 = new MapStyleMode("WALK_DAY", 5, 6);
      WALK_DAY = localMapStyleMode6;
      MapStyleMode localMapStyleMode7 = new MapStyleMode("INTERNAL", 6, 7);
      INTERNAL = localMapStyleMode7;
      MapStyleMode localMapStyleMode8 = new MapStyleMode("INTERNAL_SPECIAL", 7, 8);
      INTERNAL_SPECIAL = localMapStyleMode8;
      MapStyleMode localMapStyleMode9 = new MapStyleMode("FOOT_PRINT", 8, 9);
      FOOT_PRINT = localMapStyleMode9;
      b = new MapStyleMode[] { localMapStyleMode1, localMapStyleMode2, localMapStyleMode3, localMapStyleMode4, localMapStyleMode5, localMapStyleMode6, localMapStyleMode7, localMapStyleMode8, localMapStyleMode9 };
    }
    
    private MapStyleMode(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getMode()
    {
      return this.a;
    }
  }
  
  public static enum RecommendPoiScene
  {
    public int value;
    
    static
    {
      RecommendPoiScene localRecommendPoiScene1 = new RecommendPoiScene("BASE", 0, 0);
      BASE = localRecommendPoiScene1;
      RecommendPoiScene localRecommendPoiScene2 = new RecommendPoiScene("INTERNATIONAL", 1, 1);
      INTERNATIONAL = localRecommendPoiScene2;
      a = new RecommendPoiScene[] { localRecommendPoiScene1, localRecommendPoiScene2 };
    }
    
    private RecommendPoiScene(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum RecycleMemoryLevel
  {
    private final int a;
    
    static
    {
      RecycleMemoryLevel localRecycleMemoryLevel1 = new RecycleMemoryLevel("NORMAL", 0, 0);
      NORMAL = localRecycleMemoryLevel1;
      RecycleMemoryLevel localRecycleMemoryLevel2 = new RecycleMemoryLevel("FULL", 1, 1);
      FULL = localRecycleMemoryLevel2;
      b = new RecycleMemoryLevel[] { localRecycleMemoryLevel1, localRecycleMemoryLevel2 };
    }
    
    private RecycleMemoryLevel(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getLevel()
    {
      return this.a;
    }
  }
  
  class a
  {
    public boolean a = false;
    float b = 0.0F;
    GeoPoint c;
    Point d;
    
    a() {}
    
    public void a()
    {
      this.a = false;
      this.b = 0.0F;
      this.c = null;
      this.d = null;
    }
  }
  
  class b
    extends g
  {
    b()
    {
      super();
    }
    
    public void a(Message paramMessage)
    {
      Object localObject1;
      boolean bool;
      if (paramMessage.what == 4000)
      {
        localObject1 = MapController.this.C;
        if (localObject1 != null)
        {
          if (paramMessage.arg2 == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((CaptureMapListener)localObject1).onGetCaptureMap(bool);
        }
      }
      if (paramMessage.what == 519)
      {
        localObject1 = MapController.this.D;
        if (localObject1 != null) {
          ((i)localObject1).a();
        }
      }
      int i = paramMessage.what;
      Object localObject2;
      int j;
      if (i == 39)
      {
        if (((Long)paramMessage.obj).longValue() != MapController.a(MapController.this)) {
          return;
        }
        i = paramMessage.arg1;
        if (i != 2)
        {
          if (i != 100)
          {
            if (i != 200)
            {
              if (i != 300)
              {
                localObject1 = MapController.this.F;
                if (localObject1 != null) {
                  ((MapRenderModeChangeListener)localObject1).onMapRenderModeChange(i);
                }
                if (MapController.this.isNaviMode())
                {
                  localObject1 = MapController.this.J;
                  if (localObject1 != null) {
                    ((NaviMapViewListener)localObject1).onMapRenderModeChange(paramMessage.arg1);
                  }
                }
              }
              else if (MapController.c(MapController.this) != null)
              {
                MapController.c(MapController.this).onFirstFrameDrawing(MapController.this);
              }
            }
            else {
              MapController.this.mIsMoving = false;
            }
          }
          else
          {
            if (MapController.b(MapController.this))
            {
              localObject1 = MapController.this.I;
              if (localObject1 != null)
              {
                if (((SoftReference)localObject1).get() == null) {
                  return;
                }
                localObject1 = MapController.this.getMapStatus();
                h.a().execute(new a((MapStatus)localObject1));
              }
              else
              {
                return;
              }
            }
            MapController.b(MapController.this, false);
            localObject1 = MapController.this;
            ((MapController)localObject1).mIsMoving = false;
            ((MapController)localObject1).mIsAnimating = false;
            if (((MapController)localObject1).getMapViewListener() != null) {
              MapController.this.getMapViewListener().onMapAnimationFinish();
            }
            if (MapController.this.isNaviMode())
            {
              localObject1 = MapController.this.J;
              if (localObject1 != null) {
                ((NaviMapViewListener)localObject1).onMapAnimationFinish();
              }
            }
            localObject1 = MapController.this.getMapStatusInner();
            if (MapController.this.mListeners != null)
            {
              i = 0;
              while (i < MapController.this.mListeners.size())
              {
                localObject2 = (x)MapController.this.mListeners.get(i);
                if (localObject2 != null) {
                  ((x)localObject2).b((s)localObject1);
                }
                i += 1;
              }
            }
          }
        }
        else
        {
          if (MapController.this.mListeners == null) {
            return;
          }
          i = 0;
          while (i < MapController.this.mListeners.size())
          {
            localObject1 = (x)MapController.this.mListeners.get(i);
            if (localObject1 != null) {
              ((x)localObject1).b();
            }
            i += 1;
          }
          localObject1 = MapController.this;
          ((MapController)localObject1).mIsMoving = false;
          ((MapController)localObject1).mIsAnimating = false;
        }
        localObject1 = MapController.this;
        if ((!((MapController)localObject1).mIsMapLoadFinish) && (MapController.d((MapController)localObject1) > 0) && (MapController.e(MapController.this) > 0) && (MapController.this.getMapView() != null) && (MapController.this.getMapView().getProjection() != null) && (MapController.this.getMapView().getProjection().fromPixels(0, 0) != null))
        {
          MapController.this.mIsMapLoadFinish = true;
          h.a(new b(), 0L);
        }
        if (MapController.this.mListeners != null)
        {
          i = 0;
          while (i < MapController.this.mListeners.size())
          {
            localObject1 = (x)MapController.this.mListeners.get(i);
            if (localObject1 != null) {
              ((x)localObject1).c();
            }
            i += 1;
          }
        }
      }
      else if (i == 41)
      {
        if (((Long)paramMessage.obj).longValue() != MapController.a(MapController.this)) {
          return;
        }
        localObject1 = MapController.this;
        if (((MapController)localObject1).mListeners == null) {
          return;
        }
        if ((((MapController)localObject1).mIsMoving) || (((MapController)localObject1).mIsAnimating))
        {
          localObject1 = ((MapController)localObject1).getMapStatusInner();
          i = 0;
          while (i < MapController.this.mListeners.size())
          {
            localObject2 = (x)MapController.this.mListeners.get(i);
            if (localObject2 != null) {
              ((x)localObject2).c((s)localObject1);
            }
            i += 1;
          }
        }
      }
      else if (i == 2082)
      {
        i = paramMessage.arg1;
        if (i == 1003)
        {
          bool = true;
          i = 0;
        }
        else
        {
          bool = false;
        }
        if (OpenLogUtil.isMapLogEnable())
        {
          localObject1 = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onMapRenderValidFrame isValid = ");
          ((StringBuilder)localObject2).append(bool);
          ((StringBuilder)localObject2).append("; errorCode = ");
          ((StringBuilder)localObject2).append(i);
          ((com.baidu.mapsdkplatform.comapi.commonutils.b)localObject1).a(((StringBuilder)localObject2).toString());
        }
        if (MapController.this.mListeners != null)
        {
          j = 0;
          while (j < MapController.this.mListeners.size())
          {
            localObject1 = (x)MapController.this.mListeners.get(j);
            if (localObject1 != null) {
              ((x)localObject1).a(bool, i);
            }
            j += 1;
          }
        }
      }
      if (paramMessage.what == 512)
      {
        i = paramMessage.arg1;
        if (MapController.this.getMapViewListener() != null) {
          MapController.this.getMapViewListener().onClickedPopup(i);
        }
      }
      if (paramMessage.what == 50)
      {
        if (OpenLogUtil.isMapLogEnable())
        {
          localObject1 = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("EngineMeassage IndoorMap msg.what = ");
          ((StringBuilder)localObject2).append(paramMessage.what);
          ((StringBuilder)localObject2).append("; msg.arg1 = ");
          ((StringBuilder)localObject2).append(paramMessage.arg1);
          ((com.baidu.mapsdkplatform.comapi.commonutils.b)localObject1).a(((StringBuilder)localObject2).toString());
        }
        localObject1 = MapController.this;
        localObject2 = ((MapController)localObject1).G;
        if (localObject2 != null)
        {
          i = paramMessage.arg1;
          if (i == 1)
          {
            localObject1 = ((MapController)localObject1).getFocusedBaseIndoorMapInfo();
            MapController.this.G.onEnterIndoorMapMode((IndoorMapInfo)localObject1);
          }
          else if (i == 0)
          {
            ((EngineMsgListener)localObject2).onExitIndoorMapMode();
          }
        }
        localObject1 = MapController.this;
        if (((MapController)localObject1).mListeners == null) {
          return;
        }
        localObject1 = ((MapController)localObject1).getFocusedBaseIndoorMapInfo();
        i = 0;
        while (i < MapController.this.mListeners.size())
        {
          localObject2 = (x)MapController.this.mListeners.get(i);
          if (localObject2 != null)
          {
            j = paramMessage.arg1;
            if (j == 0) {}
            do
            {
              ((x)localObject2).a(false);
              MapController.this.mMaxZoomLevel = 21.0F;
              break;
              if (j != 1) {
                break;
              }
            } while ((MapController.this.getMapStatus().level < 18.0F) || (localObject1 == null));
            ((x)localObject2).a(true);
            MapController.this.mMaxZoomLevel = 22.0F;
          }
          i += 1;
        }
      }
      if (paramMessage.what == 51) {
        MapController.this.setNetStatus(paramMessage.arg1);
      }
      if (paramMessage.what == 65301)
      {
        localObject1 = MapController.this;
        if (((MapController)localObject1).G != null)
        {
          i = paramMessage.arg1;
          if (i == 1)
          {
            ((MapController)localObject1).getMapBarData();
            return;
          }
          if (i == 0) {
            com.baidu.platform.comapi.util.a.a().a(new a());
          }
        }
      }
    }
    
    class a
      implements Runnable
    {
      a(MapStatus paramMapStatus) {}
      
      public void run()
      {
        GeoPoint localGeoPoint;
        if ((MapController.this.getMapView() != null) && (MapController.this.getMapView().getProjection() != null)) {
          localGeoPoint = ((MapViewInterface)MapController.this.I.get()).getProjection().fromPixels(this.a.winRound.left + MapController.this.getScreenWidth() / 2, this.a.winRound.top + MapController.this.getScreenHeight() / 2);
        } else {
          localGeoPoint = null;
        }
        if (localGeoPoint != null)
        {
          float f1 = (float)localGeoPoint.getLongitudeE6();
          float f2 = (float)localGeoPoint.getLatitudeE6();
          MapController.CleanAfterDBClick(MapController.a(MapController.this), f1, f2);
        }
        MapController.a(MapController.this, false);
      }
    }
    
    class b
      implements Runnable
    {
      b() {}
      
      public void run()
      {
        if (MapController.this.mListeners != null)
        {
          int i = 0;
          while (i < MapController.this.mListeners.size())
          {
            x localx = (x)MapController.this.mListeners.get(i);
            if (localx != null) {
              localx.d();
            }
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.MapController
 * JD-Core Version:    0.7.0.1
 */