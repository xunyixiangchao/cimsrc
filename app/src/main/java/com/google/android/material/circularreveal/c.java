package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import l7.a;

public abstract interface c
  extends b.a
{
  public abstract void b();
  
  public abstract void e();
  
  public abstract int getCircularRevealScrimColor();
  
  public abstract e getRevealInfo();
  
  public abstract void setCircularRevealOverlayDrawable(Drawable paramDrawable);
  
  public abstract void setCircularRevealScrimColor(int paramInt);
  
  public abstract void setRevealInfo(e parame);
  
  public static class b
    implements TypeEvaluator<c.e>
  {
    public static final TypeEvaluator<c.e> b = new b();
    private final c.e a = new c.e(null);
    
    public c.e a(float paramFloat, c.e parame1, c.e parame2)
    {
      this.a.b(a.d(parame1.a, parame2.a, paramFloat), a.d(parame1.b, parame2.b, paramFloat), a.d(parame1.c, parame2.c, paramFloat));
      return this.a;
    }
  }
  
  public static class c
    extends Property<c, c.e>
  {
    public static final Property<c, c.e> a = new c("circularReveal");
    
    private c(String paramString)
    {
      super(paramString);
    }
    
    public c.e a(c paramc)
    {
      return paramc.getRevealInfo();
    }
    
    public void b(c paramc, c.e parame)
    {
      paramc.setRevealInfo(parame);
    }
  }
  
  public static class d
    extends Property<c, Integer>
  {
    public static final Property<c, Integer> a = new d("circularRevealScrimColor");
    
    private d(String paramString)
    {
      super(paramString);
    }
    
    public Integer a(c paramc)
    {
      return Integer.valueOf(paramc.getCircularRevealScrimColor());
    }
    
    public void b(c paramc, Integer paramInteger)
    {
      paramc.setCircularRevealScrimColor(paramInteger.intValue());
    }
  }
  
  public static class e
  {
    public float a;
    public float b;
    public float c;
    
    private e() {}
    
    public e(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
    }
    
    public e(e parame)
    {
      this(parame.a, parame.b, parame.c);
    }
    
    public boolean a()
    {
      return this.c == 3.4028235E+38F;
    }
    
    public void b(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
    }
    
    public void c(e parame)
    {
      b(parame.a, parame.b, parame.c);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.circularreveal.c
 * JD-Core Version:    0.7.0.1
 */