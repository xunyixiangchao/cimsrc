package androidx.camera.core;

public abstract class u
{
  public static u a(b paramb)
  {
    return b(paramb, null);
  }
  
  public static u b(b paramb, a parama)
  {
    return new f(paramb, parama);
  }
  
  public abstract a c();
  
  public abstract b d();
  
  public static abstract class a
  {
    public static a a(int paramInt)
    {
      return b(paramInt, null);
    }
    
    public static a b(int paramInt, Throwable paramThrowable)
    {
      return new g(paramInt, paramThrowable);
    }
    
    public abstract Throwable c();
    
    public abstract int d();
  }
  
  public static enum b
  {
    static
    {
      b localb1 = new b("PENDING_OPEN", 0);
      a = localb1;
      b localb2 = new b("OPENING", 1);
      b = localb2;
      b localb3 = new b("OPEN", 2);
      c = localb3;
      b localb4 = new b("CLOSING", 3);
      d = localb4;
      b localb5 = new b("CLOSED", 4);
      e = localb5;
      f = new b[] { localb1, localb2, localb3, localb4, localb5 };
    }
    
    private b() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.u
 * JD-Core Version:    0.7.0.1
 */