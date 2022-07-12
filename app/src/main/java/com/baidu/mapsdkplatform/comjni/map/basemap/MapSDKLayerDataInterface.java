package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.a;

public abstract interface MapSDKLayerDataInterface
  extends a
{
  public abstract boolean hasLayer(long paramLong);
  
  public abstract int mapLayerDataReq(Bundle paramBundle, long paramLong, int paramInt);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface
 * JD-Core Version:    0.7.0.1
 */