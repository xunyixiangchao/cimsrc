package t9;

import a9.f;

public final class m
{
  public static final a c = new a(null);
  private int a;
  private final int[] b = new int[10];
  
  public final int a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public final int b()
  {
    if ((this.a & 0x2) != 0) {
      return this.b[1];
    }
    return -1;
  }
  
  public final int c()
  {
    if ((this.a & 0x80) != 0) {
      return this.b[7];
    }
    return 65535;
  }
  
  public final int d()
  {
    if ((this.a & 0x10) != 0) {
      return this.b[4];
    }
    return 2147483647;
  }
  
  public final int e(int paramInt)
  {
    if ((this.a & 0x20) != 0) {
      paramInt = this.b[5];
    }
    return paramInt;
  }
  
  public final boolean f(int paramInt)
  {
    return (1 << paramInt & this.a) != 0;
  }
  
  public final void g(m paramm)
  {
    f.f(paramm, "other");
    int i = 0;
    while (i < 10)
    {
      if (paramm.f(i)) {
        h(i, paramm.a(i));
      }
      i += 1;
    }
  }
  
  public final m h(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      int[] arrayOfInt = this.b;
      if (paramInt1 >= arrayOfInt.length) {
        return this;
      }
      this.a = (1 << paramInt1 | this.a);
      arrayOfInt[paramInt1] = paramInt2;
    }
    return this;
  }
  
  public final int i()
  {
    return Integer.bitCount(this.a);
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.m
 * JD-Core Version:    0.7.0.1
 */