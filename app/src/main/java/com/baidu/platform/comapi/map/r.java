package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.map.basemap.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class r
  implements a
{
  static final String c = "com.baidu.platform.comapi.map.r";
  Map<Long, InnerOverlay> a = new ConcurrentHashMap();
  AppBaseMap b;
  
  public r(AppBaseMap paramAppBaseMap)
  {
    this.b = paramAppBaseMap;
  }
  
  public void a()
  {
    if (this.b != null)
    {
      Iterator localIterator = this.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if (localLong.longValue() > 0L)
        {
          this.b.ClearLayer(localLong.longValue());
          this.b.RemoveLayer(localLong.longValue());
        }
      }
    }
    this.a.clear();
  }
  
  public void a(InnerOverlay paramInnerOverlay)
  {
    this.a.put(Long.valueOf(paramInnerOverlay.mLayerID), paramInnerOverlay);
    paramInnerOverlay.SetMapParam(paramInnerOverlay.mLayerID, this.b);
  }
  
  public void a(Overlay paramOverlay)
  {
    this.a.remove(Long.valueOf(paramOverlay.mLayerID));
  }
  
  public boolean hasLayer(long paramLong)
  {
    return this.a.containsKey(Long.valueOf(paramLong));
  }
  
  public int mapLayerDataReq(Bundle paramBundle, long paramLong, int paramInt)
  {
    long l;
    if (l.a) {
      l = System.currentTimeMillis();
    } else {
      l = 0L;
    }
    InnerOverlay localInnerOverlay = (InnerOverlay)this.a.get(Long.valueOf(paramLong));
    if (localInnerOverlay != null)
    {
      String str = localInnerOverlay.getData();
      Object localObject;
      if (this.b.LayersIsShow(paramLong))
      {
        paramBundle.putString("jsondata", str);
        localObject = localInnerOverlay.getParam();
        if (localObject != null) {
          paramBundle.putBundle("param", (Bundle)localObject);
        }
      }
      else
      {
        paramBundle.putString("jsondata", null);
      }
      if (l.a)
      {
        paramBundle = c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MapLayerDataReq:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" tag:");
        ((StringBuilder)localObject).append(localInnerOverlay.getLayerTag());
        ((StringBuilder)localObject).append(" [");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject).append("ms] LayerData:");
        ((StringBuilder)localObject).append(str);
        l.a(paramBundle, ((StringBuilder)localObject).toString());
      }
      return localInnerOverlay.getType();
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.r
 * JD-Core Version:    0.7.0.1
 */