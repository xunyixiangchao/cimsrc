package androidx.recyclerview.widget;

import g0.d;

abstract interface s
{
  public abstract d a();
  
  public static class a
    implements s
  {
    long a = 0L;
    
    public s.d a()
    {
      return new a();
    }
    
    long b()
    {
      long l = this.a;
      this.a = (1L + l);
      return l;
    }
    
    class a
      implements s.d
    {
      private final d<Long> a = new d();
      
      a() {}
      
      public long a(long paramLong)
      {
        Long localLong2 = (Long)this.a.e(paramLong);
        Long localLong1 = localLong2;
        if (localLong2 == null)
        {
          localLong1 = Long.valueOf(s.a.this.b());
          this.a.l(paramLong, localLong1);
        }
        return localLong1.longValue();
      }
    }
  }
  
  public static class b
    implements s
  {
    private final s.d a = new a();
    
    public s.d a()
    {
      return this.a;
    }
    
    class a
      implements s.d
    {
      a() {}
      
      public long a(long paramLong)
      {
        return -1L;
      }
    }
  }
  
  public static class c
    implements s
  {
    private final s.d a = new a();
    
    public s.d a()
    {
      return this.a;
    }
    
    class a
      implements s.d
    {
      a() {}
      
      public long a(long paramLong)
      {
        return paramLong;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract long a(long paramLong);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.s
 * JD-Core Version:    0.7.0.1
 */