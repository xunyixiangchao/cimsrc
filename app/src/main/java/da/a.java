package da;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends OutputStream
{
  private static final byte[] g = new byte[0];
  private final List<byte[]> a = new ArrayList();
  private int b;
  private int c;
  private byte[] d;
  private int e;
  private boolean f = true;
  
  public a()
  {
    this(1024);
  }
  
  public a(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        a(paramInt);
        return;
      }
      finally {}
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Negative initial size: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void a(int paramInt)
  {
    if (this.b < this.a.size() - 1)
    {
      this.c += this.d.length;
      paramInt = this.b + 1;
      this.b = paramInt;
      this.d = ((byte[])this.a.get(paramInt));
      return;
    }
    byte[] arrayOfByte = this.d;
    int i;
    if (arrayOfByte == null)
    {
      i = 0;
    }
    else
    {
      paramInt = Math.max(arrayOfByte.length << 1, paramInt - this.c);
      i = this.c + this.d.length;
    }
    this.c = i;
    this.b += 1;
    arrayOfByte = new byte[paramInt];
    this.d = arrayOfByte;
    this.a.add(arrayOfByte);
  }
  
  public void close() {}
  
  public byte[] g()
  {
    try
    {
      int i = this.e;
      if (i == 0)
      {
        arrayOfByte1 = g;
        return arrayOfByte1;
      }
      byte[] arrayOfByte1 = new byte[i];
      Iterator localIterator = this.a.iterator();
      int j = 0;
      int k;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        byte[] arrayOfByte2 = (byte[])localIterator.next();
        k = Math.min(arrayOfByte2.length, i);
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, k);
        j += k;
        k = i - k;
        i = k;
      } while (k != 0);
      return arrayOfByte1;
    }
    finally {}
  }
  
  @Deprecated
  public String toString()
  {
    return new String(g(), Charset.defaultCharset());
  }
  
  public void write(int paramInt)
  {
    try
    {
      int k = this.e;
      int j = k - this.c;
      int i = j;
      if (j == this.d.length)
      {
        a(k + 1);
        i = 0;
      }
      this.d[i] = ((byte)paramInt);
      this.e += 1;
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramArrayOfByte.length) && (paramInt2 >= 0))
    {
      int j = paramInt1 + paramInt2;
      if ((j <= paramArrayOfByte.length) && (j >= 0))
      {
        if (paramInt2 == 0) {
          return;
        }
        try
        {
          paramInt1 = this.e;
          int k = paramInt1 + paramInt2;
          paramInt1 -= this.c;
          while (paramInt2 > 0)
          {
            int i = Math.min(paramInt2, this.d.length - paramInt1);
            System.arraycopy(paramArrayOfByte, j - paramInt2, this.d, paramInt1, i);
            i = paramInt2 - i;
            paramInt2 = i;
            if (i > 0)
            {
              a(k);
              paramInt1 = 0;
              paramInt2 = i;
            }
          }
          this.e = k;
          return;
        }
        finally {}
      }
    }
    throw new IndexOutOfBoundsException();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     da.a
 * JD-Core Version:    0.7.0.1
 */