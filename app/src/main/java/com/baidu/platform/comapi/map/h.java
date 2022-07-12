package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.util.JsonBuilder;

public abstract class h
{
  protected a0 a;
  public boolean b;
  public boolean c;
  protected double[] d;
  protected GeoPoint e = new GeoPoint(0, 0);
  protected GeoPoint f = new GeoPoint(0, 0);
  protected boolean g = true;
  protected JsonBuilder h;
  protected int i = -1;
  protected int j = 0;
  
  public h(a0 parama0)
  {
    this.a = parama0;
  }
  
  public abstract String a();
  
  protected String a(int paramInt)
  {
    Object localObject = new JsonBuilder();
    this.h = ((JsonBuilder)localObject);
    ((JsonBuilder)localObject).object();
    if (paramInt == 0)
    {
      this.h.key("path").arrayValue();
      if (this.d != null)
      {
        paramInt = 0;
        for (;;)
        {
          localObject = this.d;
          if (paramInt >= localObject.length) {
            break;
          }
          this.h.value(localObject[paramInt]);
          paramInt += 1;
        }
      }
      this.h.endArrayValue();
    }
    else if (paramInt == 1)
    {
      this.h.key("sgeo");
      this.h.object();
      this.h.key("bound").arrayValue();
      localObject = this.e;
      if ((localObject != null) && (this.f != null))
      {
        this.h.value(((GeoPoint)localObject).getLongitude());
        this.h.value(this.e.getLatitude());
        this.h.value(this.f.getLongitude());
        this.h.value(this.f.getLatitude());
      }
      this.h.endArrayValue();
      if (this.j == 4) {
        this.h.key("type").value(3);
      } else {
        this.h.key("type").value(this.j);
      }
      this.h.key("elements").arrayValue();
      this.h.object();
      this.h.key("points").arrayValue();
      if (this.d != null)
      {
        paramInt = 0;
        for (;;)
        {
          localObject = this.d;
          if (paramInt >= localObject.length) {
            break;
          }
          this.h.value(localObject[paramInt]);
          paramInt += 1;
        }
      }
      this.h.endArrayValue();
      this.h.endObject();
      this.h.endArrayValue();
      this.h.endObject();
    }
    this.h.key("ud").value(String.valueOf(hashCode()));
    this.h.key("dir").value(0);
    localObject = this.a;
    if ((localObject != null) && (((a0)localObject).c() != 0))
    {
      this.h.key("nst").value(this.a.c());
      this.h.key("fst").value(this.a.c());
      localObject = this.h.key("ty");
      paramInt = 32;
    }
    else
    {
      paramInt = this.j;
      if (paramInt != 3) {
        break label486;
      }
      localObject = this.h.key("ty");
      paramInt = 3100;
    }
    for (;;)
    {
      ((JsonBuilder)localObject).value(paramInt);
      break;
      label486:
      if (paramInt == 4)
      {
        localObject = this.h.key("ty");
        paramInt = 3200;
      }
      else
      {
        localObject = this.h.key("ty");
        paramInt = -1;
      }
    }
    this.h.key("of").value(0);
    this.h.key("in").value(0);
    this.h.key("tx").value("");
    this.h.key("dis").value(0);
    this.h.key("align").value(0);
    if (this.b)
    {
      this.h.key("dash").value(1);
      this.h.key("ty").value(this.j);
    }
    if (this.c)
    {
      this.h.key("trackMove").object();
      this.h.key("pointStyle").value(((c0)this.a).e());
      this.h.endObject();
    }
    this.h.key("style").object();
    if (this.a != null)
    {
      this.h.key("width").value(this.a.d());
      this.h.key("color").value(a0.c(this.a.a()));
      paramInt = this.j;
      if ((paramInt == 3) || (paramInt == 4)) {
        this.h.key("scolor").value(a0.c(this.a.b()));
      }
    }
    this.h.endObject();
    this.h.endObject();
    return this.h.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.h
 * JD-Core Version:    0.7.0.1
 */