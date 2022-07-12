package c9;

import java.util.NoSuchElementException;
import p8.a0;

public final class b
  extends a0
{
  private final int a;
  private final int b;
  private boolean c;
  private int d;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt3;
    this.b = paramInt2;
    boolean bool = true;
    if (paramInt3 > 0 ? paramInt1 > paramInt2 : paramInt1 < paramInt2) {
      bool = false;
    }
    this.c = bool;
    if (!bool) {
      paramInt1 = paramInt2;
    }
    this.d = paramInt1;
  }
  
  public int a()
  {
    int i = this.d;
    if (i == this.b)
    {
      if (this.c)
      {
        this.c = false;
        return i;
      }
      throw new NoSuchElementException();
    }
    this.d = (this.a + i);
    return i;
  }
  
  public boolean hasNext()
  {
    return this.c;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c9.b
 * JD-Core Version:    0.7.0.1
 */