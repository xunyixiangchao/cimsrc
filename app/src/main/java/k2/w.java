package k2;

import e2.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class w
  extends FilterInputStream
{
  private volatile byte[] a;
  private int b;
  private int c;
  private int d = -1;
  private int e;
  private final b f;
  
  public w(InputStream paramInputStream, b paramb)
  {
    this(paramInputStream, paramb, 65536);
  }
  
  w(InputStream paramInputStream, b paramb, int paramInt)
  {
    super(paramInputStream);
    this.f = paramb;
    this.a = ((byte[])paramb.e(paramInt, [B.class));
  }
  
  private int a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    int j = this.d;
    if (j != -1)
    {
      int k = this.e;
      i = this.c;
      if (k - j < i)
      {
        byte[] arrayOfByte;
        if ((j == 0) && (i > paramArrayOfByte.length) && (this.b == paramArrayOfByte.length))
        {
          j = paramArrayOfByte.length * 2;
          if (j <= i) {
            i = j;
          }
          arrayOfByte = (byte[])this.f.e(i, [B.class);
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
          this.a = arrayOfByte;
          this.f.d(paramArrayOfByte);
        }
        else
        {
          arrayOfByte = paramArrayOfByte;
          if (j > 0)
          {
            System.arraycopy(paramArrayOfByte, j, paramArrayOfByte, 0, paramArrayOfByte.length - j);
            arrayOfByte = paramArrayOfByte;
          }
        }
        i = this.e - this.d;
        this.e = i;
        this.d = 0;
        this.b = 0;
        j = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
        i = this.e;
        if (j > 0) {
          i += j;
        }
        this.b = i;
        return j;
      }
    }
    int i = paramInputStream.read(paramArrayOfByte);
    if (i > 0)
    {
      this.d = -1;
      this.e = 0;
      this.b = i;
    }
    return i;
  }
  
  private static IOException i()
  {
    throw new IOException("BufferedInputStream is closed");
  }
  
  public int available()
  {
    try
    {
      InputStream localInputStream = this.in;
      if ((this.a != null) && (localInputStream != null))
      {
        int i = this.b;
        int j = this.e;
        int k = localInputStream.available();
        return i - j + k;
      }
      throw i();
    }
    finally {}
  }
  
  public void close()
  {
    if (this.a != null)
    {
      this.f.d(this.a);
      this.a = null;
    }
    InputStream localInputStream = this.in;
    this.in = null;
    if (localInputStream != null) {
      localInputStream.close();
    }
  }
  
  public void g()
  {
    try
    {
      this.c = this.a.length;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void h()
  {
    try
    {
      if (this.a != null)
      {
        this.f.d(this.a);
        this.a = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.c = Math.max(this.c, paramInt);
      this.d = this.e;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    try
    {
      byte[] arrayOfByte = this.a;
      Object localObject1 = this.in;
      if ((arrayOfByte != null) && (localObject1 != null))
      {
        if (this.e >= this.b)
        {
          i = a((InputStream)localObject1, arrayOfByte);
          if (i == -1) {
            return -1;
          }
        }
        localObject1 = arrayOfByte;
        if (arrayOfByte != this.a)
        {
          localObject1 = this.a;
          if (localObject1 == null) {
            throw i();
          }
        }
        int i = this.b;
        int j = this.e;
        if (i - j > 0)
        {
          this.e = (j + 1);
          i = localObject1[j];
          return i & 0xFF;
        }
        return -1;
      }
      throw i();
    }
    finally {}
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int j;
      int i;
      int k;
      try
      {
        Object localObject1 = this.a;
        if (localObject1 != null)
        {
          if (paramInt2 == 0) {
            return 0;
          }
          InputStream localInputStream = this.in;
          if (localInputStream != null)
          {
            j = this.e;
            i = this.b;
            if (j < i)
            {
              if (i - j < paramInt2) {
                break label379;
              }
              i = paramInt2;
              System.arraycopy(localObject1, j, paramArrayOfByte, paramInt1, i);
              this.e += i;
              if (i != paramInt2)
              {
                j = localInputStream.available();
                if (j != 0)
                {
                  j = paramInt1 + i;
                  paramInt1 = paramInt2 - i;
                  i = j;
                  continue;
                }
              }
              return i;
            }
            else
            {
              j = paramInt2;
              i = paramInt1;
              paramInt1 = j;
            }
            k = this.d;
            j = -1;
            if ((k == -1) && (paramInt1 >= localObject1.length))
            {
              int m = localInputStream.read(paramArrayOfByte, i, paramInt1);
              k = m;
              if (m == -1)
              {
                if (paramInt1 != paramInt2) {
                  j = paramInt2 - paramInt1;
                }
                return j;
              }
            }
            else
            {
              k = a(localInputStream, (byte[])localObject1);
              if (k == -1)
              {
                if (paramInt1 != paramInt2) {
                  j = paramInt2 - paramInt1;
                }
                return j;
              }
              Object localObject2 = localObject1;
              if (localObject1 != this.a)
              {
                localObject2 = this.a;
                if (localObject2 == null) {
                  throw i();
                }
              }
              j = this.b;
              k = this.e;
              if (j - k < paramInt1) {
                break label389;
              }
              j = paramInt1;
              System.arraycopy(localObject2, k, paramArrayOfByte, i, j);
              this.e += j;
              k = j;
              localObject1 = localObject2;
            }
            paramInt1 -= k;
            if (paramInt1 == 0) {
              return paramInt2;
            }
            j = localInputStream.available();
            if (j == 0) {
              return paramInt2 - paramInt1;
            }
            i += k;
            continue;
          }
          else
          {
            throw i();
          }
        }
        else
        {
          throw i();
        }
      }
      finally {}
      label379:
      i -= j;
      continue;
      label389:
      j -= k;
    }
  }
  
  public void reset()
  {
    try
    {
      if (this.a != null)
      {
        int i = this.d;
        if (-1 != i)
        {
          this.e = i;
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Mark has been invalidated, pos: ");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" markLimit: ");
        localStringBuilder.append(this.c);
        throw new a(localStringBuilder.toString());
      }
      throw new IOException("Stream is closed");
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    if (paramLong < 1L) {
      return 0L;
    }
    try
    {
      byte[] arrayOfByte = this.a;
      if (arrayOfByte != null)
      {
        InputStream localInputStream = this.in;
        if (localInputStream != null)
        {
          int i = this.b;
          int j = this.e;
          if (i - j >= paramLong)
          {
            this.e = ((int)(j + paramLong));
            return paramLong;
          }
          long l1 = i - j;
          this.e = i;
          if ((this.d != -1) && (paramLong <= this.c))
          {
            i = a(localInputStream, arrayOfByte);
            if (i == -1) {
              return l1;
            }
            i = this.b;
            j = this.e;
            if (i - j >= paramLong - l1)
            {
              this.e = ((int)(j + paramLong - l1));
              return paramLong;
            }
            paramLong = i;
            long l2 = j;
            this.e = i;
            return l1 + paramLong - l2;
          }
          paramLong = localInputStream.skip(paramLong - l1);
          if (paramLong > 0L) {
            this.d = -1;
          }
          return l1 + paramLong;
        }
        throw i();
      }
      throw i();
    }
    finally {}
  }
  
  static class a
    extends IOException
  {
    a(String paramString)
    {
      super();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.w
 * JD-Core Version:    0.7.0.1
 */