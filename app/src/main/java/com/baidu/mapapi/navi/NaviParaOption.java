package com.baidu.mapapi.navi;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NaviParaOption
{
  LatLng a;
  String b;
  LatLng c;
  String d;
  WayPoint e;
  NaviRoutePolicy f = NaviRoutePolicy.DEFAULT;
  
  public NaviParaOption endName(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public NaviParaOption endPoint(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public String getEndName()
  {
    return this.d;
  }
  
  public LatLng getEndPoint()
  {
    return this.c;
  }
  
  public String getNaviRoutePolicy()
  {
    int i = a.a[this.f.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return "DEFAULT";
            }
            return "HIGHWAY";
          }
          return "FEE";
        }
        return "DIS";
      }
      return "TIME";
    }
    return "BLK";
  }
  
  public String getStartName()
  {
    return this.b;
  }
  
  public LatLng getStartPoint()
  {
    return this.a;
  }
  
  public JSONArray getWayPoint()
  {
    Object localObject2 = this.e;
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    List localList = ((WayPoint)localObject2).getViaPoints();
    if (localList != null)
    {
      if (localList.size() == 0) {
        return null;
      }
      localObject2 = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= localList.size()) {
          break;
        }
        localObject1 = (WayPointInfo)localList.get(i);
        if (localObject1 != null) {
          try
          {
            boolean bool = TextUtils.isEmpty(((WayPointInfo)localObject1).getWayPointName());
            if (!bool) {
              localJSONObject.put("name", ((WayPointInfo)localObject1).getWayPointName());
            }
            LatLng localLatLng = ((WayPointInfo)localObject1).getLatLng();
            if (localLatLng != null)
            {
              localObject1 = localLatLng;
              if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                localObject1 = CoordTrans.gcjToBaidu(localLatLng);
              }
              localJSONObject.put("lng", ((LatLng)localObject1).longitude);
              localJSONObject.put("lat", ((LatLng)localObject1).latitude);
              ((JSONArray)localObject2).put(localJSONObject);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        i += 1;
      }
    }
    return localJSONException;
  }
  
  public NaviParaOption setNaviRoutePolicy(NaviRoutePolicy paramNaviRoutePolicy)
  {
    this.f = paramNaviRoutePolicy;
    return this;
  }
  
  public NaviParaOption setWayPoint(WayPoint paramWayPoint)
  {
    if (paramWayPoint == null) {
      return null;
    }
    this.e = paramWayPoint;
    return this;
  }
  
  public NaviParaOption startName(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public NaviParaOption startPoint(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public static enum NaviRoutePolicy
  {
    static
    {
      NaviRoutePolicy localNaviRoutePolicy1 = new NaviRoutePolicy("BLK", 0);
      BLK = localNaviRoutePolicy1;
      NaviRoutePolicy localNaviRoutePolicy2 = new NaviRoutePolicy("TIME", 1);
      TIME = localNaviRoutePolicy2;
      NaviRoutePolicy localNaviRoutePolicy3 = new NaviRoutePolicy("DIS", 2);
      DIS = localNaviRoutePolicy3;
      NaviRoutePolicy localNaviRoutePolicy4 = new NaviRoutePolicy("FEE", 3);
      FEE = localNaviRoutePolicy4;
      NaviRoutePolicy localNaviRoutePolicy5 = new NaviRoutePolicy("HIGHWAY", 4);
      HIGHWAY = localNaviRoutePolicy5;
      NaviRoutePolicy localNaviRoutePolicy6 = new NaviRoutePolicy("DEFAULT", 5);
      DEFAULT = localNaviRoutePolicy6;
      a = new NaviRoutePolicy[] { localNaviRoutePolicy1, localNaviRoutePolicy2, localNaviRoutePolicy3, localNaviRoutePolicy4, localNaviRoutePolicy5, localNaviRoutePolicy6 };
    }
    
    private NaviRoutePolicy() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.navi.NaviParaOption
 * JD-Core Version:    0.7.0.1
 */