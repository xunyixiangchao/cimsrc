package y1;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class b
  implements Closeable
{
  private final InputStream a;
  private final Charset b;
  private byte[] c;
  private int d;
  private int e;
  
  public b(InputStream paramInputStream, int paramInt, Charset paramCharset)
  {
    if ((paramInputStream != null) && (paramCharset != null))
    {
      if (paramInt >= 0)
      {
        if (paramCharset.equals(c.a))
        {
          this.a = paramInputStream;
          this.b = paramCharset;
          this.c = new byte[paramInt];
          return;
        }
        throw new IllegalArgumentException("Unsupported encoding");
      }
      throw new IllegalArgumentException("capacity <= 0");
    }
    throw null;
  }
  
  public b(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, 8192, paramCharset);
  }
  
  private void g()
  {
    InputStream localInputStream = this.a;
    byte[] arrayOfByte = this.c;
    int i = localInputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (i != -1)
    {
      this.d = 0;
      this.e = i;
      return;
    }
    throw new EOFException();
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      if (this.c != null)
      {
        this.c = null;
        this.a.close();
      }
      return;
    }
  }
  
  public boolean h()
  {
    return this.e == -1;
  }
  
  public String i()
  {
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        if (this.c != null)
        {
          if (this.d >= this.e) {
            g();
          }
          i = this.d;
          Object localObject1;
          if (i != this.e)
          {
            localObject1 = this.c;
            if (localObject1[i] != 10) {
              break label268;
            }
            int k = this.d;
            if (i != k)
            {
              j = i - 1;
              if (localObject1[j] == 13)
              {
                localObject1 = new String((byte[])localObject1, k, j - k, this.b.name());
                this.d = (i + 1);
                return localObject1;
              }
            }
          }
          else
          {
            localObject1 = new a(this.e - this.d + 80);
            byte[] arrayOfByte = this.c;
            i = this.d;
            ((ByteArrayOutputStream)localObject1).write(arrayOfByte, i, this.e - i);
            this.e = -1;
            g();
            i = this.d;
            if (i == this.e) {
              continue;
            }
            arrayOfByte = this.c;
            if (arrayOfByte[i] != 10) {
              break label275;
            }
            j = this.d;
            if (i != j) {
              ((ByteArrayOutputStream)localObject1).write(arrayOfByte, j, i - j);
            }
            this.d = (i + 1);
            localObject1 = ((ByteArrayOutputStream)localObject1).toString();
            return localObject1;
          }
        }
        else
        {
          throw new IOException("LineReader is closed");
        }
      }
      int j = i;
      continue;
      label268:
      i += 1;
      continue;
      label275:
      i += 1;
    }
  }
  
  class a
    extends ByteArrayOutputStream
  {
    a(int paramInt)
    {
      super();
    }
    
    public String toString()
    {
      int j = this.count;
      int i = j;
      if (j > 0)
      {
        i = j;
        if (this.buf[(j - 1)] == 13) {
          i = j - 1;
        }
      }
      try
      {
        String str = new String(this.buf, 0, i, b.a(b.this).name());
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new AssertionError(localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y1.b
 * JD-Core Version:    0.7.0.1
 */