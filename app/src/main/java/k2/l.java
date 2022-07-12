package k2;

import b2.g;

public abstract class l
{
  public static final l a = new a();
  public static final l b = new b();
  public static final l c = new e();
  public static final l d = new c();
  public static final l e;
  public static final l f;
  public static final l g;
  public static final g<l> h;
  static final boolean i = true;
  
  static
  {
    d locald = new d();
    e = locald;
    f = new f();
    g = locald;
    h = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", locald);
  }
  
  public abstract g a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static class a
    extends l
  {
    public l.g a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return l.g.b;
    }
    
    public float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt1 = Math.min(paramInt2 / paramInt4, paramInt1 / paramInt3);
      if (paramInt1 == 0) {
        return 1.0F;
      }
      return 1.0F / Integer.highestOneBit(paramInt1);
    }
  }
  
  private static class b
    extends l
  {
    public l.g a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return l.g.a;
    }
    
    public float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt3 = (int)Math.ceil(Math.max(paramInt2 / paramInt4, paramInt1 / paramInt3));
      paramInt2 = Integer.highestOneBit(paramInt3);
      paramInt1 = 1;
      paramInt2 = Math.max(1, paramInt2);
      if (paramInt2 >= paramInt3) {
        paramInt1 = 0;
      }
      return 1.0F / (paramInt2 << paramInt1);
    }
  }
  
  private static class c
    extends l
  {
    public l.g a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (b(paramInt1, paramInt2, paramInt3, paramInt4) == 1.0F) {
        return l.g.b;
      }
      return l.c.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return Math.min(1.0F, l.c.b(paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  private static class d
    extends l
  {
    public l.g a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return l.g.b;
    }
    
    public float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return Math.max(paramInt3 / paramInt1, paramInt4 / paramInt2);
    }
  }
  
  private static class e
    extends l
  {
    public l.g a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (l.i) {
        return l.g.b;
      }
      return l.g.a;
    }
    
    public float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (l.i) {
        return Math.min(paramInt3 / paramInt1, paramInt4 / paramInt2);
      }
      paramInt1 = Math.max(paramInt2 / paramInt4, paramInt1 / paramInt3);
      if (paramInt1 == 0) {
        return 1.0F;
      }
      return 1.0F / Integer.highestOneBit(paramInt1);
    }
  }
  
  private static class f
    extends l
  {
    public l.g a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return l.g.b;
    }
    
    public float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return 1.0F;
    }
  }
  
  public static enum g
  {
    static
    {
      g localg1 = new g("MEMORY", 0);
      a = localg1;
      g localg2 = new g("QUALITY", 1);
      b = localg2;
      c = new g[] { localg1, localg2 };
    }
    
    private g() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.l
 * JD-Core Version:    0.7.0.1
 */