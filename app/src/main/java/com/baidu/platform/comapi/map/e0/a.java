package com.baidu.platform.comapi.map.e0;

import android.view.MotionEvent;

public class a
{
  public static final a a = new a(new b(0.0D, 0.0D), new b(1.0D, 0.0D));
  public static final a b = new a(new b(0.0D, 0.0D), new b(0.0D, 1.0D));
  public static final a c = new a(new b(0.0D, 1.0D), new b(0.0D, 0.0D));
  
  public static class a
  {
    public a.b a;
    public a.b b;
    
    public a(a.b paramb1, a.b paramb2)
    {
      this.a = paramb1;
      this.b = paramb2;
    }
    
    public static a a(MotionEvent paramMotionEvent)
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(0);
      float f3 = paramMotionEvent.getX(1);
      float f4 = paramMotionEvent.getY(1);
      return new a(new a.b(f1, f2), new a.b(f3, f4));
    }
    
    public a.b a()
    {
      a.b localb1 = this.a;
      double d = localb1.a;
      a.b localb2 = this.b;
      return new a.b((d + localb2.a) / 2.0D, (localb1.b + localb2.b) / 2.0D);
    }
    
    public double b()
    {
      a.b localb1 = this.a;
      double d1 = localb1.a;
      a.b localb2 = this.b;
      d1 -= localb2.a;
      double d2 = localb1.b - localb2.b;
      return Math.sqrt(d1 * d1 + d2 * d2);
    }
    
    public a.d c()
    {
      a.b localb1 = this.b;
      double d = localb1.a;
      a.b localb2 = this.a;
      return new a.d(d - localb2.a, localb1.b - localb2.b);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a.class.getSimpleName());
      localStringBuilder.append("  a : ");
      localStringBuilder.append(this.a.toString());
      localStringBuilder.append(" b : ");
      localStringBuilder.append(this.b.toString());
      return localStringBuilder.toString();
    }
  }
  
  public static class b
  {
    public double a;
    public double b;
    
    public b(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.class.getSimpleName());
      localStringBuilder.append(" x : ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" y : ");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
  }
  
  public static class c
  {
    public final double a;
    public final double b;
    public final a.d c;
    
    public c(a.a parama1, a.a parama2)
    {
      this.c = new a.d(parama1.a(), parama2.a());
      this.b = (parama2.b() / parama1.b());
      this.a = a.d.a(parama1.c(), parama2.c());
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c.class.getSimpleName());
      localStringBuilder.append(" rotate : ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" scale : ");
      localStringBuilder.append(this.b * 100.0D);
      localStringBuilder.append(" move : ");
      localStringBuilder.append(this.c.toString());
      return localStringBuilder.toString();
    }
  }
  
  public static class d
  {
    public double a;
    public double b;
    
    public d(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }
    
    public d(a.b paramb1, a.b paramb2)
    {
      this.a = (paramb2.a - paramb1.a);
      this.b = (paramb2.b - paramb1.b);
    }
    
    public static double a(d paramd1, d paramd2)
    {
      double d2 = Math.atan2(paramd1.b, paramd1.a) - Math.atan2(paramd2.b, paramd2.a);
      double d1;
      if (d2 > 3.141592653589793D)
      {
        d1 = d2 - 6.283185307179586D;
      }
      else
      {
        d1 = d2;
        if (d2 < -3.141592653589793D) {
          d1 = d2 + 6.283185307179586D;
        }
      }
      return d1 * 180.0D / 3.141592653589793D;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(d.class.getSimpleName());
      localStringBuilder.append(" x : ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" y : ");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.e0.a
 * JD-Core Version:    0.7.0.1
 */