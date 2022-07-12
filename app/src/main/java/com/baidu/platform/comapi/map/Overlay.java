package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;

public abstract class Overlay
{
  public String id;
  public long mLayerID;
  public int mType;
  
  protected Overlay()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_");
    localStringBuilder.append(hashCode());
    this.id = localStringBuilder.toString();
  }
  
  public static void putColorInfoIntoBundle(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("red", (paramInt >> 16 & 0xFF) / 255.0F);
    localBundle.putFloat("green", (paramInt >> 8 & 0xFF) / 255.0F);
    localBundle.putFloat("blue", (paramInt & 0xFF) / 255.0F);
    localBundle.putFloat("alpha", (paramInt >>> 24) / 255.0F);
    paramBundle.putBundle("color", localBundle);
  }
  
  public static void putPointsInfoIntoBundle(List<GeoPoint> paramList, Bundle paramBundle)
  {
    int j = paramList.size();
    double[] arrayOfDouble1 = new double[j];
    double[] arrayOfDouble2 = new double[j];
    int i = 0;
    while (i < j)
    {
      GeoPoint localGeoPoint = m.a((GeoPoint)paramList.get(i));
      arrayOfDouble1[i] = localGeoPoint.getLongitude();
      arrayOfDouble2[i] = localGeoPoint.getLatitude();
      i += 1;
    }
    paramBundle.putDoubleArray("x_array", arrayOfDouble1);
    paramBundle.putDoubleArray("y_array", arrayOfDouble2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.Overlay
 * JD-Core Version:    0.7.0.1
 */