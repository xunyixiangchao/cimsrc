package o3;

public enum c
{
  private final int a;
  
  static
  {
    c localc1 = new c("GONE", 0, 0);
    b = localc1;
    c localc2 = new c("VISIBLE", 1, 1);
    c = localc2;
    d = new c[] { localc1, localc2 };
  }
  
  private c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o3.c
 * JD-Core Version:    0.7.0.1
 */