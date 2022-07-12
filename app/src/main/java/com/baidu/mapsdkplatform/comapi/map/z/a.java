package com.baidu.mapsdkplatform.comapi.map.z;

import com.baidu.platform.comapi.map.InnerOverlay;
import com.baidu.platform.comapi.map.h;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends InnerOverlay
{
  private boolean d = false;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  public final List<h> h = new ArrayList();
  private boolean i = true;
  
  public a()
  {
    super(36);
  }
  
  public void a()
  {
    this.i = true;
    UpdateOverlay();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramBoolean;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public boolean a(h paramh)
  {
    synchronized (this.h)
    {
      if (this.h.contains(paramh)) {
        return false;
      }
      boolean bool = this.h.add(paramh);
      this.i = bool;
      return bool;
    }
  }
  
  public void clear()
  {
    synchronized (this.h)
    {
      this.h.clear();
      super.clear();
      return;
    }
  }
  
  public String getData()
  {
    if (this.i) {
      synchronized (this.h)
      {
        int j = this.h.size();
        if (j == 0) {
          return "";
        }
        JsonBuilder localJsonBuilder = new JsonBuilder();
        localJsonBuilder.object();
        localJsonBuilder.key("dataset").arrayValue();
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext()) {
          localJsonBuilder.objectValue(((h)localIterator.next()).a());
        }
        localJsonBuilder.endArrayValue();
        localJsonBuilder.key("startValue").value(0);
        localJsonBuilder.key("endValue").value(1);
        if (this.d)
        {
          localJsonBuilder.key("isNeedRouteAnimate").value(1);
          localJsonBuilder.key("durationTime").value(this.e);
          localJsonBuilder.key("delayTime").value(this.f);
          localJsonBuilder.key("easingCurve").value(this.g);
          this.d = false;
        }
        else
        {
          localJsonBuilder.key("isNeedRouteAnimate").value(0);
          localJsonBuilder.key("durationTime").value(0);
          localJsonBuilder.key("delayTime").value(0);
          localJsonBuilder.key("easingCurve").value(0);
        }
        localJsonBuilder.endObject();
        setData(localJsonBuilder.getJson());
        this.i = false;
      }
    }
    return super.getData();
  }
  
  public void setData(String paramString)
  {
    super.setData(paramString);
    this.i = true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.z.a
 * JD-Core Version:    0.7.0.1
 */