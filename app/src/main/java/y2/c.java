package y2;

public abstract class c
{
  public static c a()
  {
    return new b();
  }
  
  abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  private static class b
    extends c
  {
    private volatile boolean a;
    
    b()
    {
      super();
    }
    
    public void b(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public void c()
    {
      if (!this.a) {
        return;
      }
      throw new IllegalStateException("Already released");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y2.c
 * JD-Core Version:    0.7.0.1
 */