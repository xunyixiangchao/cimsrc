package x2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c
  extends FilterInputStream
{
  private final long a;
  private int b;
  
  private c(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    this.a = paramLong;
  }
  
  private int a(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.b += paramInt;
      return paramInt;
    }
    if (this.a - this.b <= 0L) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failed to read all expected data, expected: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", but read: ");
    localStringBuilder.append(this.b);
    throw new IOException(localStringBuilder.toString());
  }
  
  public static InputStream g(InputStream paramInputStream, long paramLong)
  {
    return new c(paramInputStream, paramLong);
  }
  
  public int available()
  {
    try
    {
      long l = Math.max(this.a - this.b, this.in.available());
      int i = (int)l;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int read()
  {
    for (;;)
    {
      try
      {
        int j = super.read();
        if (j >= 0)
        {
          i = 1;
          a(i);
          return j;
        }
      }
      finally {}
      int i = -1;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = a(super.read(paramArrayOfByte, paramInt1, paramInt2));
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.c
 * JD-Core Version:    0.7.0.1
 */