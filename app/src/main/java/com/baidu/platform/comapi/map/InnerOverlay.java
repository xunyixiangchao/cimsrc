package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public abstract class InnerOverlay
  extends Overlay
{
  protected String a = null;
  protected Bundle b = null;
  private boolean c = true;
  public AppBaseMap mBaseMap = null;
  
  public InnerOverlay() {}
  
  public InnerOverlay(int paramInt)
  {
    setType(paramInt);
  }
  
  public InnerOverlay(int paramInt, AppBaseMap paramAppBaseMap)
  {
    setType(paramInt);
    this.mBaseMap = paramAppBaseMap;
  }
  
  public boolean IsOverlayShow()
  {
    if (this.mLayerID != 0L)
    {
      AppBaseMap localAppBaseMap = this.mBaseMap;
      if ((localAppBaseMap != null) && (localAppBaseMap.GetId() != 0L) && (this.mBaseMap.LayersIsShow(this.mLayerID))) {
        return true;
      }
    }
    return false;
  }
  
  public void SetMapParam(long paramLong, AppBaseMap paramAppBaseMap)
  {
    this.mLayerID = paramLong;
    this.mBaseMap = paramAppBaseMap;
  }
  
  public void SetOverlayShow(boolean paramBoolean)
  {
    long l2 = this.mLayerID;
    long l1 = 0L;
    if (l2 != 0L)
    {
      Object localObject = this.mBaseMap;
      if (localObject != null)
      {
        if (((AppBaseMap)localObject).GetId() == 0L) {
          return;
        }
        if (l.a) {
          l1 = System.currentTimeMillis();
        }
        this.mBaseMap.ShowLayers(this.mLayerID, paramBoolean);
        if (l.a)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ShowLayer:");
          ((StringBuilder)localObject).append(this.mLayerID);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append(" tag:");
          ((StringBuilder)localObject).append(getLayerTag());
          ((StringBuilder)localObject).append(" [");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
          ((StringBuilder)localObject).append("ms]");
          l.a("InnerOverlay", ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void UpdateOverlay()
  {
    long l2 = this.mLayerID;
    long l1 = 0L;
    if (l2 != 0L)
    {
      Object localObject = this.mBaseMap;
      if (localObject != null)
      {
        if (((AppBaseMap)localObject).GetId() == 0L) {
          return;
        }
        if (l.a) {
          l1 = System.currentTimeMillis();
        }
        this.mBaseMap.UpdateLayers(this.mLayerID);
        if (l.a)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("UpdateLayer:");
          ((StringBuilder)localObject).append(this.mLayerID);
          ((StringBuilder)localObject).append(" tag:");
          ((StringBuilder)localObject).append(getLayerTag());
          ((StringBuilder)localObject).append(" [");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
          ((StringBuilder)localObject).append("ms]");
          l.a("InnerOverlay", ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public boolean addedToMapView()
  {
    Object localObject = this.mBaseMap;
    if (localObject != null)
    {
      if (((AppBaseMap)localObject).GetId() == 0L) {
        return false;
      }
      if (l.a) {
        l = System.currentTimeMillis();
      } else {
        l = 0L;
      }
      this.mLayerID = this.mBaseMap.AddLayer(getUpdateType(), getUpdateTimeInterval(), getLayerTag());
      if (l.a)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("AddLayer:");
        ((StringBuilder)localObject).append(this.mLayerID);
        ((StringBuilder)localObject).append(" type:");
        ((StringBuilder)localObject).append(this.mType);
        ((StringBuilder)localObject).append(" tag:");
        ((StringBuilder)localObject).append(getLayerTag());
        ((StringBuilder)localObject).append(" [");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject).append("ms]");
        l.a("InnerOverlay", ((StringBuilder)localObject).toString());
      }
      long l = this.mLayerID;
      if (l != 0L)
      {
        this.mBaseMap.SetLayersClickable(l, this.c);
        SetOverlayShow(getDefaultShowStatus());
        return true;
      }
    }
    return false;
  }
  
  public void clear()
  {
    long l;
    if (l.a) {
      l = System.currentTimeMillis();
    } else {
      l = 0L;
    }
    Object localObject;
    if (!TextUtils.isEmpty(this.a))
    {
      this.a = null;
      localObject = this.mBaseMap;
      if (localObject != null) {
        ((AppBaseMap)localObject).ClearLayer(this.mLayerID);
      }
    }
    if (l.a)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ClearLayer:");
      ((StringBuilder)localObject).append(this.mLayerID);
      ((StringBuilder)localObject).append(" tag:");
      ((StringBuilder)localObject).append(getLayerTag());
      ((StringBuilder)localObject).append(" [");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject).append("ms]");
      l.a("InnerOverlay", ((StringBuilder)localObject).toString());
    }
  }
  
  public String getData()
  {
    return this.a;
  }
  
  public boolean getDefaultShowStatus()
  {
    return false;
  }
  
  public String getLayerTag()
  {
    return "default";
  }
  
  public Bundle getParam()
  {
    return this.b;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public int getUpdateTimeInterval()
  {
    return 0;
  }
  
  public int getUpdateType()
  {
    return 0;
  }
  
  public void setClickAble(boolean paramBoolean)
  {
    this.c = paramBoolean;
    AppBaseMap localAppBaseMap = this.mBaseMap;
    if (localAppBaseMap != null)
    {
      if (localAppBaseMap.GetId() == 0L) {
        return;
      }
      long l = this.mLayerID;
      if (l != 0L) {
        this.mBaseMap.SetLayersClickable(l, paramBoolean);
      }
    }
  }
  
  public void setData(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public void setFocus(int paramInt, boolean paramBoolean)
  {
    setFocus(paramInt, paramBoolean, null);
  }
  
  public void setFocus(int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject = this.mBaseMap;
    if (localObject != null)
    {
      if (((AppBaseMap)localObject).GetId() == 0L) {
        return;
      }
      localObject = new Bundle();
      if (!TextUtils.isEmpty(paramString)) {
        ((Bundle)localObject).putString("uid", paramString);
      }
      this.mBaseMap.SetFocus(this.mLayerID, paramInt, paramBoolean, (Bundle)localObject);
    }
  }
  
  public void setParam(Bundle paramBundle)
  {
    this.b = paramBundle;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.InnerOverlay
 * JD-Core Version:    0.7.0.1
 */