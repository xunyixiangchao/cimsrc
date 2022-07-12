package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;
import com.baidu.mapsdkplatform.comapi.map.e;

public class ItemizedOverlay
  extends Overlay
{
  MapView e;
  
  public ItemizedOverlay(Drawable paramDrawable, MapView paramMapView)
  {
    this.type = e.c;
    this.e = paramMapView;
  }
  
  public void addItem(OverlayOptions paramOverlayOptions)
  {
    if (paramOverlayOptions != null) {
      this.e.getMap().addOverlay(paramOverlayOptions);
    }
  }
  
  public void reAddAll() {}
  
  public void removeAll()
  {
    this.e.getMap().clear();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.ItemizedOverlay
 * JD-Core Version:    0.7.0.1
 */