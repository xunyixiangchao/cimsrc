package com.baidu.mapapi.map;

import android.graphics.Point;

class a
{
  public final double a;
  public final double b;
  public final double c;
  public final double d;
  public final double e;
  public final double f;
  
  public a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.a = paramDouble1;
    this.b = paramDouble3;
    this.c = paramDouble2;
    this.d = paramDouble4;
    this.e = ((paramDouble1 + paramDouble2) / 2.0D);
    this.f = ((paramDouble3 + paramDouble4) / 2.0D);
  }
  
  public boolean a(double paramDouble1, double paramDouble2)
  {
    return (this.a <= paramDouble1) && (paramDouble1 <= this.c) && (this.b <= paramDouble2) && (paramDouble2 <= this.d);
  }
  
  public boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return (paramDouble1 < this.c) && (this.a < paramDouble2) && (paramDouble3 < this.d) && (this.b < paramDouble4);
  }
  
  public boolean a(Point paramPoint)
  {
    return a(paramPoint.x, paramPoint.y);
  }
  
  public boolean a(a parama)
  {
    return (parama.a >= this.a) && (parama.c <= this.c) && (parama.b >= this.b) && (parama.d <= this.d);
  }
  
  public boolean b(a parama)
  {
    return a(parama.a, parama.c, parama.b, parama.d);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("minX: ");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" minY: ");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" maxX: ");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" maxY: ");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" midX: ");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" midY: ");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.a
 * JD-Core Version:    0.7.0.1
 */