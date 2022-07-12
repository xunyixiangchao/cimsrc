package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.l;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineMapUtil
{
  public static MKOLSearchRecord getSearchRecordFromLocalCityInfo(j paramj)
  {
    if (paramj == null) {
      return null;
    }
    MKOLSearchRecord localMKOLSearchRecord = new MKOLSearchRecord();
    localMKOLSearchRecord.cityID = paramj.a;
    localMKOLSearchRecord.cityName = paramj.b;
    localMKOLSearchRecord.cityType = paramj.d;
    long l2 = 0L;
    long l1 = l2;
    if (paramj.a() != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramj.a().iterator();
      for (;;)
      {
        l1 = l2;
        if (!localIterator.hasNext()) {
          break;
        }
        j localj = (j)localIterator.next();
        localArrayList.add(getSearchRecordFromLocalCityInfo(localj));
        l2 += localj.c;
        localMKOLSearchRecord.childCities = localArrayList;
      }
    }
    if (localMKOLSearchRecord.cityType != 1) {
      l1 = paramj.c;
    }
    localMKOLSearchRecord.dataSize = l1;
    return localMKOLSearchRecord;
  }
  
  public static MKOLUpdateElement getUpdatElementFromLocalMapElement(l paraml)
  {
    if (paraml == null) {
      return null;
    }
    MKOLUpdateElement localMKOLUpdateElement = new MKOLUpdateElement();
    localMKOLUpdateElement.cityID = paraml.a;
    localMKOLUpdateElement.cityName = paraml.b;
    GeoPoint localGeoPoint = paraml.d;
    if (localGeoPoint != null) {
      localMKOLUpdateElement.geoPt = CoordUtil.mc2ll(localGeoPoint);
    }
    localMKOLUpdateElement.level = paraml.c;
    int j = paraml.f;
    localMKOLUpdateElement.ratio = j;
    int i = paraml.e;
    localMKOLUpdateElement.serversize = i;
    if (j != 100) {
      i = i / 100 * j;
    }
    localMKOLUpdateElement.size = i;
    localMKOLUpdateElement.status = paraml.h;
    localMKOLUpdateElement.update = paraml.g;
    return localMKOLUpdateElement;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.offline.OfflineMapUtil
 * JD-Core Version:    0.7.0.1
 */