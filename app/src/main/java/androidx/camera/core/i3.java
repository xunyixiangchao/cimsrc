package androidx.camera.core;

import android.util.Rational;
import x0.h;

public final class i3
{
  private int a;
  private Rational b;
  private int c;
  private int d;
  
  i3(int paramInt1, Rational paramRational, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramRational;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public Rational a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.a;
  }
  
  public static final class a
  {
    private int a = 1;
    private final Rational b;
    private final int c;
    private int d = 0;
    
    public a(Rational paramRational, int paramInt)
    {
      this.b = paramRational;
      this.c = paramInt;
    }
    
    public i3 a()
    {
      h.h(this.b, "The crop aspect ratio must be set.");
      return new i3(this.a, this.b, this.c, this.d);
    }
    
    public a b(int paramInt)
    {
      this.d = paramInt;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.i3
 * JD-Core Version:    0.7.0.1
 */