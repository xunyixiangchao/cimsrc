package x2;

import java.io.FilterInputStream;
import java.io.InputStream;

public class i
  extends FilterInputStream
{
  private int a = -2147483648;
  
  public i(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private long a(long paramLong)
  {
    int i = this.a;
    if (i == 0) {
      return -1L;
    }
    long l = paramLong;
    if (i != -2147483648)
    {
      l = paramLong;
      if (paramLong > i) {
        l = i;
      }
    }
    return l;
  }
  
  private void g(long paramLong)
  {
    int i = this.a;
    if ((i != -2147483648) && (paramLong != -1L)) {
      this.a = ((int)(i - paramLong));
    }
  }
  
  public int available()
  {
    int i = this.a;
    if (i == -2147483648) {
      return super.available();
    }
    return Math.min(i, super.available());
  }
  
  public void mark(int paramInt)
  {
    try
    {
      super.mark(paramInt);
      this.a = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int read()
  {
    if (a(1L) == -1L) {
      return -1;
    }
    int i = super.read();
    g(1L);
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = (int)a(paramInt2);
    if (paramInt2 == -1) {
      return -1;
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    g(paramInt1);
    return paramInt1;
  }
  
  public void reset()
  {
    try
    {
      super.reset();
      this.a = -2147483648;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
  {
    paramLong = a(paramLong);
    if (paramLong == -1L) {
      return 0L;
    }
    paramLong = super.skip(paramLong);
    g(paramLong);
    return paramLong;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.i
 * JD-Core Version:    0.7.0.1
 */