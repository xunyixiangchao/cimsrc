package t9;

public enum b
{
  public static final a b = new a(null);
  private final int a;
  
  private b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final int b()
  {
    return this.a;
  }
  
  public static final class a
  {
    public final b a(int paramInt)
    {
      b[] arrayOfb = b.values();
      int k = arrayOfb.length;
      int j = 0;
      while (j < k)
      {
        b localb = arrayOfb[j];
        j += 1;
        int i;
        if (localb.b() == paramInt) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return localb;
        }
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.b
 * JD-Core Version:    0.7.0.1
 */