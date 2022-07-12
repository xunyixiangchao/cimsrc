package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;

public final class MapPoi
{
  String a;
  LatLng b;
  String c;
  
  void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    String str = paramJSONObject.optString("tx");
    this.a = str;
    if ((str != null) && (!str.equals(""))) {
      this.a = this.a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
    }
    this.b = CoordUtil.decodeNodeLocation(paramJSONObject.optString("geo"));
    this.c = paramJSONObject.optString("ud");
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public LatLng getPosition()
  {
    return this.b;
  }
  
  public String getUid()
  {
    return this.c;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MapPoi
 * JD-Core Version:    0.7.0.1
 */