package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BaseMapCallback
{
  private static final ConcurrentHashMap<Long, a> a = new ConcurrentHashMap(2);
  private static final ConcurrentHashMap<Long, MapSDKLayerDataInterface> b = new ConcurrentHashMap(2);
  
  public static void release(long paramLong)
  {
    a.remove(Long.valueOf(paramLong));
    b.remove(Long.valueOf(paramLong));
  }
  
  public static int reqLayerData(Bundle paramBundle, long paramLong, int paramInt)
  {
    Object localObject1 = a;
    if (((ConcurrentHashMap)localObject1).isEmpty()) {
      return 0;
    }
    localObject1 = ((ConcurrentHashMap)localObject1).entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if ((localObject2 != null) && (((a)localObject2).hasLayer(paramLong))) {
        return ((a)localObject2).mapLayerDataReq(paramBundle, paramLong, paramInt);
      }
    }
    localObject1 = b.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MapSDKLayerDataInterface)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if ((localObject2 != null) && (((MapSDKLayerDataInterface)localObject2).hasLayer(paramLong))) {
        return ((MapSDKLayerDataInterface)localObject2).mapLayerDataReq(paramBundle, paramLong, paramInt);
      }
    }
    return 0;
  }
  
  public static boolean setMapCallback(long paramLong, a parama)
  {
    if ((parama != null) && (paramLong != 0L))
    {
      a.put(Long.valueOf(paramLong), parama);
      return true;
    }
    return false;
  }
  
  public static boolean setMapSDKCallback(long paramLong, MapSDKLayerDataInterface paramMapSDKLayerDataInterface)
  {
    if ((paramMapSDKLayerDataInterface != null) && (paramLong != 0L))
    {
      b.put(Long.valueOf(paramLong), paramMapSDKLayerDataInterface);
      return true;
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.map.basemap.BaseMapCallback
 * JD-Core Version:    0.7.0.1
 */