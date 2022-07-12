package x0;

public class g<T>
  extends f<T>
{
  private final Object c = new Object();
  
  public g(int paramInt)
  {
    super(paramInt);
  }
  
  public boolean a(T paramT)
  {
    synchronized (this.c)
    {
      boolean bool = super.a(paramT);
      return bool;
    }
  }
  
  public T b()
  {
    synchronized (this.c)
    {
      Object localObject2 = super.b();
      return localObject2;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x0.g
 * JD-Core Version:    0.7.0.1
 */