package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.f;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.k;
import com.baidu.mapsdkplatform.comapi.map.l;
import com.baidu.mapsdkplatform.comapi.map.m;
import com.baidu.mapsdkplatform.comapi.map.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MKOfflineMap
{
  public static final int TYPE_DOWNLOAD_UPDATE = 0;
  public static final int TYPE_NETWORK_ERROR = 2;
  public static final int TYPE_NEW_OFFLINE = 6;
  public static final int TYPE_VER_UPDATE = 4;
  private k a;
  private MKOfflineMapListener b;
  
  public void destroy()
  {
    this.a.f(0);
    this.a.b(null);
    this.a.b();
    f.a();
  }
  
  public ArrayList<MKOLUpdateElement> getAllUpdateInfo()
  {
    Object localObject = this.a.d();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(((m)((Iterator)localObject).next()).a()));
    }
    return localArrayList;
  }
  
  public ArrayList<MKOLSearchRecord> getHotCityList()
  {
    Object localObject = this.a.e();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo((j)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  public ArrayList<MKOLSearchRecord> getOfflineCityList()
  {
    Object localObject = this.a.c();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo((j)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  public MKOLUpdateElement getUpdateInfo(int paramInt)
  {
    m localm = this.a.b(paramInt);
    if (localm == null) {
      return null;
    }
    return OfflineMapUtil.getUpdatElementFromLocalMapElement(localm.a());
  }
  
  @Deprecated
  public int importOfflineData()
  {
    return importOfflineData(false);
  }
  
  @Deprecated
  public int importOfflineData(boolean paramBoolean)
  {
    ArrayList localArrayList = this.a.d();
    int i = 0;
    if (localArrayList != null) {
      i = localArrayList.size();
    }
    this.a.a(paramBoolean, true);
    localArrayList = this.a.d();
    int j = i;
    if (localArrayList != null) {
      j = localArrayList.size();
    }
    return j - i;
  }
  
  public boolean init(MKOfflineMapListener paramMKOfflineMapListener)
  {
    f.b();
    k localk = k.f();
    this.a = localk;
    if (localk == null) {
      return false;
    }
    localk.a(new a());
    this.b = paramMKOfflineMapListener;
    return true;
  }
  
  public boolean pause(int paramInt)
  {
    return this.a.e(paramInt);
  }
  
  public boolean remove(int paramInt)
  {
    return this.a.c(paramInt);
  }
  
  public ArrayList<MKOLSearchRecord> searchCity(String paramString)
  {
    Object localObject = this.a.a(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo((j)((Iterator)localObject).next()));
    }
    return paramString;
  }
  
  public boolean start(int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    if (((k)localObject).d() != null)
    {
      localObject = this.a.d().iterator();
      while (((Iterator)localObject).hasNext())
      {
        l locall = ((m)((Iterator)localObject).next()).a;
        if (locall.a == paramInt)
        {
          if (!locall.g)
          {
            int i = locall.h;
            if ((i != 2) && (i != 3) && (i != 6)) {
              return false;
            }
          }
          return this.a.d(paramInt);
        }
      }
    }
    return this.a.a(paramInt);
  }
  
  public boolean update(int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    if (((k)localObject).d() != null)
    {
      localObject = this.a.d().iterator();
      while (((Iterator)localObject).hasNext())
      {
        l locall = ((m)((Iterator)localObject).next()).a;
        if (locall.a == paramInt) {
          if (locall.g) {
            return this.a.g(paramInt);
          }
        }
      }
    }
    return false;
  }
  
  class a
    implements n
  {
    a() {}
    
    public void a(int paramInt1, int paramInt2)
    {
      if (paramInt1 != 4)
      {
        int i = 6;
        if (paramInt1 != 6)
        {
          if (paramInt1 != 8)
          {
            if (paramInt1 != 10)
            {
              if (paramInt1 != 12) {
                return;
              }
              MKOfflineMap.a(MKOfflineMap.this).a(true, false);
              return;
            }
            localObject = MKOfflineMap.b(MKOfflineMap.this);
            paramInt1 = 2;
          }
          else
          {
            MKOfflineMap.b(MKOfflineMap.this).onGetOfflineMapState(0, paramInt2 >> 8);
          }
        }
        else
        {
          localObject = MKOfflineMap.b(MKOfflineMap.this);
          paramInt1 = i;
        }
        ((MKOfflineMapListener)localObject).onGetOfflineMapState(paramInt1, paramInt2);
        return;
      }
      Object localObject = MKOfflineMap.this.getAllUpdateInfo();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MKOLUpdateElement localMKOLUpdateElement = (MKOLUpdateElement)((Iterator)localObject).next();
          if (localMKOLUpdateElement.update) {
            MKOfflineMap.b(MKOfflineMap.this).onGetOfflineMapState(4, localMKOLUpdateElement.cityID);
          }
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.offline.MKOfflineMap
 * JD-Core Version:    0.7.0.1
 */