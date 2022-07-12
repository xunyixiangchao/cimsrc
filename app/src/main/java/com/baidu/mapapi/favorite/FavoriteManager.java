package com.baidu.mapapi.favorite;

import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.map.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FavoriteManager
{
  private static FavoriteManager a;
  private static com.baidu.mapsdkplatform.comapi.favrite.a b;
  
  public static FavoriteManager getInstance()
  {
    if (a == null) {
      a = new FavoriteManager();
    }
    return a;
  }
  
  public int add(FavoritePoiInfo paramFavoritePoiInfo)
  {
    if (b == null) {}
    for (paramFavoritePoiInfo = "you may have not call init method!";; paramFavoritePoiInfo = "object or pt can not be null!")
    {
      Log.e("baidumapsdk", paramFavoritePoiInfo);
      return 0;
      if ((paramFavoritePoiInfo != null) && (paramFavoritePoiInfo.c != null))
      {
        Object localObject = paramFavoritePoiInfo.b;
        if ((localObject != null) && (!((String)localObject).equals("")))
        {
          localObject = a.a(paramFavoritePoiInfo);
          int i = b.a(((FavSyncPoi)localObject).b, (FavSyncPoi)localObject);
          if (i == 1)
          {
            paramFavoritePoiInfo.a = ((FavSyncPoi)localObject).a;
            paramFavoritePoiInfo.g = Long.parseLong(((FavSyncPoi)localObject).h);
          }
          return i;
        }
        Log.e("baidumapsdk", "poiName can not be null or empty!");
        return -1;
      }
    }
  }
  
  public boolean clearAllFavPois()
  {
    com.baidu.mapsdkplatform.comapi.favrite.a locala = b;
    if (locala == null)
    {
      Log.e("baidumapsdk", "you may have not call init method!");
      return false;
    }
    return locala.a();
  }
  
  public boolean deleteFavPoi(String paramString)
  {
    if (b == null)
    {
      Log.e("baidumapsdk", "you may have not call init method!");
      return false;
    }
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return false;
      }
      return b.a(paramString);
    }
    return false;
  }
  
  public void destroy()
  {
    com.baidu.mapsdkplatform.comapi.favrite.a locala = b;
    if (locala != null)
    {
      locala.b();
      b = null;
      BMapManager.destroy();
      f.a();
    }
  }
  
  public List<FavoritePoiInfo> getAllFavPois()
  {
    Object localObject = b;
    if (localObject == null)
    {
      Log.e("baidumapsdk", "you may have not call init method!");
      return null;
    }
    localObject = ((com.baidu.mapsdkplatform.comapi.favrite.a)localObject).c();
    if (localObject != null)
    {
      if (((String)localObject).equals("")) {
        return null;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).optInt("favpoinum") == 0) {
          return null;
        }
        localObject = ((JSONObject)localObject).optJSONArray("favcontents");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          ArrayList localArrayList = new ArrayList();
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            if (localJSONObject != null) {
              localArrayList.add(a.a(localJSONObject));
            }
            i += 1;
          }
          return localArrayList;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return null;
  }
  
  public FavoritePoiInfo getFavPoi(String paramString)
  {
    if (b == null)
    {
      Log.e("baidumapsdk", "you may have not call init method!");
      return null;
    }
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return null;
      }
      paramString = b.b(paramString);
      if (paramString != null) {
        return a.a(paramString);
      }
    }
    return null;
  }
  
  public void init()
  {
    if (b == null)
    {
      f.b();
      BMapManager.init();
      b = com.baidu.mapsdkplatform.comapi.favrite.a.f();
    }
  }
  
  public boolean updateFavPoi(String paramString, FavoritePoiInfo paramFavoritePoiInfo)
  {
    if (b == null) {
      paramString = "you may have not call init method!";
    }
    for (;;)
    {
      Log.e("baidumapsdk", paramString);
      return false;
      if ((paramString == null) || (paramString.equals(""))) {
        break;
      }
      if (paramFavoritePoiInfo == null) {
        return false;
      }
      if (paramFavoritePoiInfo.c == null)
      {
        paramString = "object or pt can not be null!";
      }
      else
      {
        String str = paramFavoritePoiInfo.b;
        if ((str != null) && (!str.equals("")))
        {
          paramFavoritePoiInfo.a = paramString;
          paramFavoritePoiInfo = a.a(paramFavoritePoiInfo);
          return b.b(paramString, paramFavoritePoiInfo);
        }
        paramString = "poiName can not be null or empty!";
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.favorite.FavoriteManager
 * JD-Core Version:    0.7.0.1
 */