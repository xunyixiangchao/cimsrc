package x2;

public final class f
{
  public static <T> b<T> a(b<T> paramb)
  {
    return new a();
  }
  
  class a
    implements f.b<T>
  {
    private volatile T a;
    
    a() {}
    
    public T get()
    {
      if (this.a == null) {
        try
        {
          if (this.a == null) {
            this.a = k.d(f.this.get());
          }
        }
        finally {}
      }
      return this.a;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract T get();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.f
 * JD-Core Version:    0.7.0.1
 */