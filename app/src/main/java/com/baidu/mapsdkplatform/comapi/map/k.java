package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k
{
  private static k d;
  private AppBaseMap a;
  private o b;
  private Handler c;
  
  public static k f()
  {
    if (d == null)
    {
      k localk = new k();
      d = localk;
      localk.g();
    }
    return d;
  }
  
  private void g()
  {
    h();
    this.b = new o();
    a locala = new a();
    this.c = locala;
    MessageCenter.registMessage(65289, locala);
  }
  
  private void h()
  {
    EnvironmentUtilities.initAppDirectory(BMapManager.getContext());
    Object localObject1 = new AppBaseMap();
    this.a = ((AppBaseMap)localObject1);
    ((AppBaseMap)localObject1).Create();
    Object localObject3 = com.baidu.mapapi.common.SysOSUtil.getModuleFileName();
    Object localObject2 = EnvironmentUtilities.getAppSDCardPath();
    String str2 = EnvironmentUtilities.getAppCachePath();
    String str1 = EnvironmentUtilities.getAppSecondCachePath();
    int i = EnvironmentUtilities.getMapTmpStgMax();
    int j = EnvironmentUtilities.getDomTmpStgMax();
    int k = EnvironmentUtilities.getItsTmpStgMax();
    int m = EnvironmentUtilities.getSsgTmpStgMax();
    if (com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI() >= 180) {
      localObject1 = "/h/";
    } else {
      localObject1 = "/l/";
    }
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append("/cfg");
    localObject4 = ((StringBuilder)localObject4).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("/vmp");
    Object localObject5 = ((StringBuilder)localObject3).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject4);
    ((StringBuilder)localObject2).append("/a/");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject4);
    ((StringBuilder)localObject3).append("/a/");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append((String)localObject4);
    ((StringBuilder)localObject6).append("/idrres/");
    localObject4 = ((StringBuilder)localObject6).toString();
    localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append((String)localObject5);
    ((StringBuilder)localObject6).append((String)localObject1);
    localObject6 = ((StringBuilder)localObject6).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject5);
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(str2);
    ((StringBuilder)localObject5).append("/tmp/");
    str2 = ((StringBuilder)localObject5).toString();
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(str1);
    ((StringBuilder)localObject5).append("/tmp/");
    str1 = ((StringBuilder)localObject5).toString();
    this.a.Init((String)localObject2, (String)localObject4, (String)localObject6, str2, str1, (String)localObject1, (String)localObject3, com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenWidth(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenHeight(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI(), i, j, k, m, false, false);
    this.a.OnResume();
  }
  
  public ArrayList<j> a(String paramString)
  {
    Object localObject1;
    if (!paramString.equals(""))
    {
      localObject1 = this.a;
      if (localObject1 != null)
      {
        localObject1 = ((AppBaseMap)localObject1).OnSchcityGet(paramString);
        if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
          paramString = new ArrayList();
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject1).length() == 0) {
          return null;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("dataset");
        if (localObject1 != null) {
          break label354;
        }
        return null;
      }
      catch (JSONException paramString)
      {
        j localj1;
        Object localObject2;
        int j;
        ArrayList localArrayList;
        j localj2;
        JSONObject localJSONObject;
        paramString.printStackTrace();
        return null;
      }
      if (i < ((JSONArray)localObject1).length())
      {
        localj1 = new j();
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        j = ((JSONObject)localObject2).optInt("id");
        if ((j <= 2000) || (j == 2912) || (j == 2911) || (j == 9000))
        {
          localj1.a = j;
          localj1.b = ((JSONObject)localObject2).optString("name");
          localj1.c = ((JSONObject)localObject2).optInt("mapsize");
          localj1.d = ((JSONObject)localObject2).optInt("cty");
          if (((JSONObject)localObject2).has("child"))
          {
            localObject2 = ((JSONObject)localObject2).optJSONArray("child");
            localArrayList = new ArrayList();
            j = 0;
            if (j < ((JSONArray)localObject2).length())
            {
              localj2 = new j();
              localJSONObject = ((JSONArray)localObject2).optJSONObject(j);
              localj2.a = localJSONObject.optInt("id");
              localj2.b = localJSONObject.optString("name");
              localj2.c = localJSONObject.optInt("mapsize");
              localj2.d = localJSONObject.optInt("cty");
              localArrayList.add(localj2);
              j += 1;
              continue;
            }
            localj1.a(localArrayList);
          }
          paramString.add(localj1);
        }
        i += 1;
      }
      else
      {
        return paramString;
        return null;
        return null;
        label354:
        i = 0;
      }
    }
  }
  
  public void a(n paramn)
  {
    o localo = this.b;
    if (localo != null) {
      localo.a(paramn);
    }
  }
  
  public boolean a(int paramInt)
  {
    AppBaseMap localAppBaseMap = this.a;
    if (localAppBaseMap != null)
    {
      if (paramInt < 0) {
        return false;
      }
      if ((paramInt > 2000) && (paramInt != 2912) && (paramInt != 2911) && (paramInt != 9000)) {
        return false;
      }
      return localAppBaseMap.OnRecordAdd(paramInt);
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppBaseMap localAppBaseMap = this.a;
    if (localAppBaseMap == null) {
      return false;
    }
    return localAppBaseMap.OnRecordImport(paramBoolean1, paramBoolean2);
  }
  
  public m b(int paramInt)
  {
    Object localObject1 = this.a;
    Object localObject2;
    l locall;
    if (localObject1 != null)
    {
      if (paramInt < 0) {
        return null;
      }
      localObject2 = ((AppBaseMap)localObject1).OnRecordGetAt(paramInt);
      if (localObject2 != null)
      {
        if (((String)localObject2).equals("")) {
          return null;
        }
        localObject1 = new m();
        locall = new l();
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (((JSONObject)localObject2).length() == 0) {
          return null;
        }
        paramInt = ((JSONObject)localObject2).optInt("id");
        if ((paramInt > 2000) && (paramInt != 2912) && (paramInt != 2911) && (paramInt != 9000)) {
          return null;
        }
        locall.a = paramInt;
        locall.b = ((JSONObject)localObject2).optString("name");
        ((JSONObject)localObject2).optString("pinyin");
        ((JSONObject)localObject2).optString("headchar");
        locall.e = ((JSONObject)localObject2).optInt("mapoldsize");
        locall.f = ((JSONObject)localObject2).optInt("ratio");
        locall.h = ((JSONObject)localObject2).optInt("status");
        locall.d = new GeoPoint(((JSONObject)localObject2).optInt("y"), ((JSONObject)localObject2).optInt("x"));
        paramInt = ((JSONObject)localObject2).optInt("up");
        bool = true;
        if (paramInt != 1) {
          break label296;
        }
        locall.g = bool;
        locall.c = ((JSONObject)localObject2).optInt("lev");
        if (locall.g) {
          ((JSONObject)localObject2).optInt("mapsize");
        }
        ((JSONObject)localObject2).optInt("ver");
        ((m)localObject1).a(locall);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return null;
      label296:
      boolean bool = false;
    }
  }
  
  public void b()
  {
    MessageCenter.unregistMessage(65289, this.c);
    this.a.releaseFromOfflineMap();
    d = null;
  }
  
  public void b(n paramn)
  {
    o localo = this.b;
    if (localo != null) {
      localo.b(paramn);
    }
  }
  
  public ArrayList<j> c()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((AppBaseMap)localObject1).OnSchcityGet("");
    localObject1 = new ArrayList();
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2).optJSONArray("dataset");
        i = 0;
        if (i < ((JSONArray)localObject2).length())
        {
          localj1 = new j();
          Object localObject3 = ((JSONArray)localObject2).optJSONObject(i);
          j = ((JSONObject)localObject3).optInt("id");
          if ((j <= 2000) || (j == 2912) || (j == 2911) || (j == 9000))
          {
            localj1.a = j;
            localj1.b = ((JSONObject)localObject3).optString("name");
            localj1.c = ((JSONObject)localObject3).optInt("mapsize");
            localj1.d = ((JSONObject)localObject3).optInt("cty");
            if (((JSONObject)localObject3).has("child"))
            {
              localObject3 = ((JSONObject)localObject3).optJSONArray("child");
              localArrayList = new ArrayList();
              j = 0;
              if (j < ((JSONArray)localObject3).length())
              {
                localj2 = new j();
                localJSONObject = ((JSONArray)localObject3).optJSONObject(j);
              }
            }
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        int i;
        j localj1;
        int j;
        ArrayList localArrayList;
        j localj2;
        JSONObject localJSONObject;
        continue;
      }
      catch (Exception localException1)
      {
        continue;
      }
      try
      {
        localj2.a = localJSONObject.optInt("id");
        localj2.b = localJSONObject.optString("name");
        localj2.c = localJSONObject.optInt("mapsize");
        localj2.d = localJSONObject.optInt("cty");
        localArrayList.add(localj2);
        j += 1;
      }
      catch (JSONException localJSONException2)
      {
        continue;
      }
      catch (Exception localException2)
      {
        continue;
      }
      localj1.a(localArrayList);
      ((ArrayList)localObject1).add(localj1);
      i += 1;
    }
    return null;
    return null;
    return localObject1;
    return null;
    return null;
  }
  
  public boolean c(int paramInt)
  {
    AppBaseMap localAppBaseMap = this.a;
    if (localAppBaseMap != null)
    {
      if (paramInt < 0) {
        return false;
      }
      return localAppBaseMap.OnRecordRemove(paramInt, false);
    }
    return false;
  }
  
  public ArrayList<m> d()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((AppBaseMap)localObject1).OnRecordGetAll();
    if (localObject2 != null)
    {
      if (((String)localObject2).equals("")) {
        return null;
      }
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (((JSONObject)localObject2).length() == 0) {
          return null;
        }
        localObject2 = ((JSONObject)localObject2).optJSONArray("dataset");
        int i = 0;
        if (i < ((JSONArray)localObject2).length())
        {
          m localm = new m();
          l locall = new l();
          JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
          locall.a = localJSONObject.optInt("id");
          locall.b = localJSONObject.optString("name");
          localJSONObject.optString("pinyin");
          locall.e = localJSONObject.optInt("mapoldsize");
          locall.f = localJSONObject.optInt("ratio");
          locall.h = localJSONObject.optInt("status");
          locall.d = new GeoPoint(localJSONObject.optInt("y"), localJSONObject.optInt("x"));
          int j = localJSONObject.optInt("up");
          bool = true;
          if (j != 1) {
            break label301;
          }
          locall.g = bool;
          locall.c = localJSONObject.optInt("lev");
          if (locall.g) {
            localJSONObject.optInt("mapsize");
          }
          localm.a(locall);
          ((ArrayList)localObject1).add(localm);
          i += 1;
          continue;
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
      label301:
      boolean bool = false;
    }
  }
  
  public boolean d(int paramInt)
  {
    AppBaseMap localAppBaseMap = this.a;
    if (localAppBaseMap != null)
    {
      if (paramInt < 0) {
        return false;
      }
      if ((paramInt > 2000) && (paramInt != 2912) && (paramInt != 2911) && (paramInt != 9000)) {
        return false;
      }
      return localAppBaseMap.OnRecordStart(paramInt, false, 0);
    }
    return false;
  }
  
  public ArrayList<j> e()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((AppBaseMap)localObject1).OnHotcityGet();
    localObject1 = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        localObject2 = new JSONObject((String)localObject2).optJSONArray("dataset");
        if (localObject2 != null) {
          break label271;
        }
        return null;
      }
      catch (JSONException localJSONException)
      {
        j localj1;
        Object localObject3;
        ArrayList localArrayList;
        int j;
        j localj2;
        JSONObject localJSONObject;
        localJSONException.printStackTrace();
        return null;
      }
      if (i < ((JSONArray)localObject2).length())
      {
        localj1 = new j();
        localObject3 = ((JSONArray)localObject2).optJSONObject(i);
        localj1.a = ((JSONObject)localObject3).optInt("id");
        localj1.b = ((JSONObject)localObject3).optString("name");
        localj1.c = ((JSONObject)localObject3).optInt("mapsize");
        localj1.d = ((JSONObject)localObject3).optInt("cty");
        if (((JSONObject)localObject3).has("child"))
        {
          localObject3 = ((JSONObject)localObject3).optJSONArray("child");
          localArrayList = new ArrayList();
          j = 0;
          if (j < ((JSONArray)localObject3).length())
          {
            localj2 = new j();
            localJSONObject = ((JSONArray)localObject3).optJSONObject(j);
            localj2.a = localJSONObject.optInt("id");
            localj2.b = localJSONObject.optString("name");
            localj2.c = localJSONObject.optInt("mapsize");
            localj2.d = localJSONObject.optInt("cty");
            localArrayList.add(localj2);
            j += 1;
            continue;
          }
          localj1.a(localArrayList);
        }
        ((ArrayList)localObject1).add(localj1);
        i += 1;
      }
      else
      {
        return localObject1;
        label271:
        i = 0;
      }
    }
  }
  
  public boolean e(int paramInt)
  {
    AppBaseMap localAppBaseMap = this.a;
    if (localAppBaseMap != null)
    {
      if (paramInt < 0) {
        return false;
      }
      return localAppBaseMap.OnRecordSuspend(paramInt, false, 0);
    }
    return false;
  }
  
  public boolean f(int paramInt)
  {
    AppBaseMap localAppBaseMap = this.a;
    if (localAppBaseMap == null) {
      return false;
    }
    return localAppBaseMap.OnRecordSuspend(0, true, paramInt);
  }
  
  public boolean g(int paramInt)
  {
    AppBaseMap localAppBaseMap = this.a;
    if (localAppBaseMap != null)
    {
      if (paramInt < 0) {
        return false;
      }
      if ((paramInt > 2000) && (paramInt != 2912) && (paramInt != 2911) && (paramInt != 9000)) {
        return false;
      }
      return localAppBaseMap.OnRecordReload(paramInt, false);
    }
    return false;
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (k.a() != null) {
        k.a(k.this).a(paramMessage);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.k
 * JD-Core Version:    0.7.0.1
 */