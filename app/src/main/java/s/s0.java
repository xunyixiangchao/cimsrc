package s;

import java.util.Set;

public abstract interface s0
{
  public abstract Set<c> F(a<?> parama);
  
  public abstract <ValueT> ValueT a(a<ValueT> parama);
  
  public abstract boolean b(a<?> parama);
  
  public abstract Set<a<?>> c();
  
  public abstract c d(a<?> parama);
  
  public abstract <ValueT> ValueT e(a<ValueT> parama, ValueT paramValueT);
  
  public abstract <ValueT> ValueT g(a<ValueT> parama, c paramc);
  
  public abstract void i(String paramString, b paramb);
  
  public static abstract class a<T>
  {
    public static <T> a<T> a(String paramString, Class<?> paramClass)
    {
      return b(paramString, paramClass, null);
    }
    
    public static <T> a<T> b(String paramString, Class<?> paramClass, Object paramObject)
    {
      return new d(paramString, paramClass, paramObject);
    }
    
    public abstract String c();
    
    public abstract Object d();
    
    public abstract Class<T> e();
  }
  
  public static abstract interface b
  {
    public abstract boolean a(s0.a<?> parama);
  }
  
  public static enum c
  {
    static
    {
      c localc1 = new c("ALWAYS_OVERRIDE", 0);
      a = localc1;
      c localc2 = new c("REQUIRED", 1);
      b = localc2;
      c localc3 = new c("OPTIONAL", 2);
      c = localc3;
      d = new c[] { localc1, localc2, localc3 };
    }
    
    private c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.s0
 * JD-Core Version:    0.7.0.1
 */