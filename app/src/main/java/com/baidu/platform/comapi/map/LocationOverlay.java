package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationOverlay
  extends InnerOverlay
{
  private AppBaseMap d;
  
  public LocationOverlay()
  {
    super(7);
  }
  
  public LocationOverlay(AppBaseMap paramAppBaseMap)
  {
    super(7, paramAppBaseMap);
    this.d = paramAppBaseMap;
  }
  
  public void beginLocationLayerAnimation()
  {
    this.d.BeginLocationLayerAnimation();
  }
  
  public void clearLocationLayerData(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putLong("locationaddr", this.mLayerID);
    this.d.ClearLocationLayerData(localBundle);
  }
  
  public boolean getDefaultShowStatus()
  {
    return true;
  }
  
  public String getLayerTag()
  {
    return "location";
  }
  
  public void setLocationLayerData(List<OverlayLocationData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (this.mLayerID == 0L) {
        return;
      }
      Bundle localBundle1 = new Bundle();
      localBundle1.putLong("locationaddr", this.mLayerID);
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int i = 0;
      while (i < paramList.size())
      {
        OverlayLocationData localOverlayLocationData = (OverlayLocationData)paramList.get(i);
        if (localOverlayLocationData.getImage() == null) {
          return;
        }
        ParcelItem localParcelItem = new ParcelItem();
        Object localObject1 = localOverlayLocationData.getImage();
        Bundle localBundle2 = new Bundle();
        Object localObject2 = ByteBuffer.allocate(((Bitmap)localObject1).getWidth() * ((Bitmap)localObject1).getHeight() * 4);
        ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject2);
        localObject1 = ((ByteBuffer)localObject2).array();
        localBundle2.putByteArray("imgbin", (byte[])localObject1);
        localBundle2.putInt("w", localOverlayLocationData.getImgWidth());
        localBundle2.putInt("h", localOverlayLocationData.getImgHeight());
        localBundle2.putInt("rotation", localOverlayLocationData.isRotation());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localOverlayLocationData.getImgName());
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(Arrays.hashCode((byte[])localObject1));
        localBundle2.putString("name", ((StringBuilder)localObject2).toString());
        localParcelItem.setBundle(localBundle2);
        localArrayList.add(localParcelItem);
        i += 1;
      }
      if (localArrayList.size() > 0)
      {
        paramList = new ParcelItem[localArrayList.size()];
        i = j;
        while (i < localArrayList.size())
        {
          paramList[i] = ((ParcelItem)localArrayList.get(i));
          i += 1;
        }
        localBundle1.putParcelableArray("imagedata", paramList);
      }
      this.d.SetLocationLayerData(localBundle1);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.LocationOverlay
 * JD-Core Version:    0.7.0.1
 */