package com.bumptech.glide.load.data;

import e2.b;
import java.io.OutputStream;

public final class c
  extends OutputStream
{
  private final OutputStream a;
  private byte[] b;
  private b c;
  private int d;
  
  public c(OutputStream paramOutputStream, b paramb)
  {
    this(paramOutputStream, paramb, 65536);
  }
  
  c(OutputStream paramOutputStream, b paramb, int paramInt)
  {
    this.a = paramOutputStream;
    this.c = paramb;
    this.b = ((byte[])paramb.e(paramInt, [B.class));
  }
  
  private void a()
  {
    int i = this.d;
    if (i > 0)
    {
      this.a.write(this.b, 0, i);
      this.d = 0;
    }
  }
  
  private void g()
  {
    if (this.d == this.b.length) {
      a();
    }
  }
  
  private void h()
  {
    byte[] arrayOfByte = this.b;
    if (arrayOfByte != null)
    {
      this.c.d(arrayOfByte);
      this.b = null;
    }
  }
  
  public void close()
  {
    try
    {
      flush();
      this.a.close();
      h();
      return;
    }
    finally
    {
      this.a.close();
    }
  }
  
  public void flush()
  {
    a();
    this.a.flush();
  }
  
  public void write(int paramInt)
  {
    byte[] arrayOfByte = this.b;
    int i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    g();
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j;
    do
    {
      int k = paramInt2 - i;
      j = paramInt1 + i;
      int m = this.d;
      if ((m == 0) && (k >= this.b.length))
      {
        this.a.write(paramArrayOfByte, j, k);
        return;
      }
      k = Math.min(k, this.b.length - m);
      System.arraycopy(paramArrayOfByte, j, this.b, this.d, k);
      this.d += k;
      j = i + k;
      g();
      i = j;
    } while (j < paramInt2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.c
 * JD-Core Version:    0.7.0.1
 */