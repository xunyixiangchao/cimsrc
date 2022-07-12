package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.platform.comapi.basestruct.Point;
import org.json.JSONObject;

class a
{
  static FavoritePoiInfo a(FavSyncPoi paramFavSyncPoi)
  {
    if ((paramFavSyncPoi != null) && (paramFavSyncPoi.c != null) && (!paramFavSyncPoi.b.equals("")))
    {
      FavoritePoiInfo localFavoritePoiInfo = new FavoritePoiInfo();
      localFavoritePoiInfo.a = paramFavSyncPoi.a;
      localFavoritePoiInfo.b = paramFavSyncPoi.b;
      Point localPoint = paramFavSyncPoi.c;
      localFavoritePoiInfo.c = new LatLng(localPoint.y / 1000000.0D, localPoint.x / 1000000.0D);
      localFavoritePoiInfo.e = paramFavSyncPoi.e;
      localFavoritePoiInfo.f = paramFavSyncPoi.f;
      localFavoritePoiInfo.d = paramFavSyncPoi.d;
      localFavoritePoiInfo.g = Long.parseLong(paramFavSyncPoi.h);
      return localFavoritePoiInfo;
    }
    return null;
  }
  
  static FavoritePoiInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    FavoritePoiInfo localFavoritePoiInfo = new FavoritePoiInfo();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("pt");
    if (localJSONObject != null)
    {
      int i = localJSONObject.optInt("x");
      localFavoritePoiInfo.c = new LatLng(localJSONObject.optInt("y") / 1000000.0D, i / 1000000.0D);
    }
    localFavoritePoiInfo.b = paramJSONObject.optString("uspoiname");
    localFavoritePoiInfo.g = Long.parseLong(paramJSONObject.optString("addtimesec"));
    localFavoritePoiInfo.d = paramJSONObject.optString("addr");
    localFavoritePoiInfo.f = paramJSONObject.optString("uspoiuid");
    localFavoritePoiInfo.e = paramJSONObject.optString("ncityid");
    localFavoritePoiInfo.a = paramJSONObject.optString("key");
    return localFavoritePoiInfo;
  }
  
  static FavSyncPoi a(FavoritePoiInfo paramFavoritePoiInfo)
  {
    if ((paramFavoritePoiInfo != null) && (paramFavoritePoiInfo.c != null))
    {
      Object localObject = paramFavoritePoiInfo.b;
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        localObject = new FavSyncPoi();
        ((FavSyncPoi)localObject).b = paramFavoritePoiInfo.b;
        LatLng localLatLng = paramFavoritePoiInfo.c;
        ((FavSyncPoi)localObject).c = new Point((int)(localLatLng.longitude * 1000000.0D), (int)(localLatLng.latitude * 1000000.0D));
        ((FavSyncPoi)localObject).d = paramFavoritePoiInfo.d;
        ((FavSyncPoi)localObject).e = paramFavoritePoiInfo.e;
        ((FavSyncPoi)localObject).f = paramFavoritePoiInfo.f;
        ((FavSyncPoi)localObject).i = false;
        return localObject;
      }
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.favorite.a
 * JD-Core Version:    0.7.0.1
 */