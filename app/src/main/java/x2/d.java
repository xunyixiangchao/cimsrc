package x2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class d
  extends InputStream
{
  private static final Queue<d> c = l.f(0);
  private InputStream a;
  private IOException b;
  
  public static d g(InputStream paramInputStream)
  {
    synchronized (c)
    {
      d locald = (d)((Queue)???).poll();
      ??? = locald;
      if (locald == null) {
        ??? = new d();
      }
      ((d)???).i(paramInputStream);
      return ???;
    }
  }
  
  public IOException a()
  {
    return this.b;
  }
  
  public int available()
  {
    return this.a.available();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void h()
  {
    this.b = null;
    this.a = null;
    synchronized (c)
    {
      ???.offer(this);
      return;
    }
  }
  
  void i(InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }
  
  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  public int read()
  {
    try
    {
      int i = this.a.read();
      return i;
    }
    catch (IOException localIOException)
    {
      this.b = localIOException;
      throw localIOException;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    try
    {
      int i = this.a.read(paramArrayOfByte);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      this.b = paramArrayOfByte;
      throw paramArrayOfByte;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      this.b = paramArrayOfByte;
      throw paramArrayOfByte;
    }
  }
  
  public void reset()
  {
    try
    {
      this.a.reset();
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
    try
    {
      paramLong = this.a.skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      this.b = localIOException;
      throw localIOException;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.d
 * JD-Core Version:    0.7.0.1
 */