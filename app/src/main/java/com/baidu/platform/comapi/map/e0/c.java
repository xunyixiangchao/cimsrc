package com.baidu.platform.comapi.map.e0;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapViewInterface;
import java.util.IllegalFormatException;

public class c
{
  private float a;
  private StringBuffer b = new StringBuffer();
  private StringBuffer c = new StringBuffer();
  private MapController d;
  
  public c(MapController paramMapController)
  {
    this.d = paramMapController;
  }
  
  private void a(b paramb)
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((MapController)localObject1).getMapView();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((MapViewInterface)localObject1).getMapCenter();
    try
    {
      localObject1 = String.format("(%s,%d,%d,%d,%d)", new Object[] { b(paramb), Double.valueOf(((GeoPoint)localObject2).getLongitudeE6()), Double.valueOf(((GeoPoint)localObject2).getLatitudeE6()), Integer.valueOf((int)((MapViewInterface)localObject1).getZoomLevel()), Long.valueOf(System.currentTimeMillis()) });
    }
    catch (IllegalFormatException localIllegalFormatException)
    {
      label90:
      break label90;
    }
    localObject1 = b(paramb);
    localObject2 = this.b;
    if (localObject2 == null) {
      return;
    }
    ((StringBuffer)localObject2).append((String)localObject1);
    localObject1 = this.c;
    if (localObject1 == null) {
      return;
    }
    ((StringBuffer)localObject1).append(b(paramb));
  }
  
  private String b(b paramb)
  {
    switch (a.a[paramb.ordinal()])
    {
    default: 
      return "";
    case 8: 
      return "6";
    case 7: 
      return "5";
    case 6: 
      return "4";
    case 5: 
      return "3";
    case 4: 
      return "2";
    case 3: 
      return "1";
    }
    return "0";
  }
  
  private void d(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  private boolean e(float paramFloat)
  {
    return paramFloat < this.a;
  }
  
  private boolean f(float paramFloat)
  {
    return paramFloat > this.a;
  }
  
  public void a()
  {
    a(b.c);
  }
  
  public void a(float paramFloat)
  {
    a(b.f);
    d(paramFloat);
  }
  
  public void b()
  {
    a(b.h);
  }
  
  public void b(float paramFloat)
  {
    a(b.g);
    d(paramFloat);
  }
  
  public void c()
  {
    a(b.e);
  }
  
  public void c(float paramFloat)
  {
    if (f(paramFloat)) {
      a(b.a);
    }
    if (e(paramFloat)) {
      a(b.b);
    }
    d(paramFloat);
  }
  
  public void d()
  {
    a(b.d);
  }
  
  static enum b
  {
    static
    {
      b localb1 = new b("ZOOM_OUT", 0);
      a = localb1;
      b localb2 = new b("ZOOM_IN", 1);
      b = localb2;
      b localb3 = new b("FLING", 2);
      c = localb3;
      b localb4 = new b("MOVE", 3);
      d = localb4;
      b localb5 = new b("ROTATE", 4);
      e = localb5;
      b localb6 = new b("DOUBLE_CLICK_ZOOM_IN", 5);
      f = localb6;
      b localb7 = new b("TWO_CLICK_ZOOM_OUT", 6);
      g = localb7;
      b localb8 = new b("MOVE_OVERLOOK", 7);
      h = localb8;
      i = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8 };
    }
    
    private b() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.e0.c
 * JD-Core Version:    0.7.0.1
 */