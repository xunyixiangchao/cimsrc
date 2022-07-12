package aa;

import a9.f;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class i
  implements x
{
  private byte a;
  private final r b;
  private final Inflater c;
  private final j d;
  private final CRC32 e;
  
  public i(x paramx)
  {
    paramx = new r(paramx);
    this.b = paramx;
    Inflater localInflater = new Inflater(true);
    this.c = localInflater;
    this.d = new j(paramx, localInflater);
    this.e = new CRC32();
  }
  
  private final void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return;
    }
    paramString = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }, 3));
    f.e(paramString, "java.lang.String.format(this, *args)");
    throw new IOException(paramString);
  }
  
  private final void g()
  {
    this.b.U(10L);
    int m = this.b.b.i0(3L);
    int k = 1;
    int i;
    if ((m >> 1 & 0x1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i(this.b.b, 0L, 10L);
    }
    a("ID1ID2", 8075, this.b.readShort());
    this.b.skip(8L);
    int j;
    if ((m >> 2 & 0x1) == 1) {
      j = 1;
    } else {
      j = 0;
    }
    long l;
    if (j != 0)
    {
      this.b.U(2L);
      if (i != 0) {
        i(this.b.b, 0L, 2L);
      }
      l = this.b.b.s0();
      this.b.U(l);
      if (i != 0) {
        i(this.b.b, 0L, l);
      }
      this.b.skip(l);
    }
    if ((m >> 3 & 0x1) == 1) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      l = this.b.a((byte)0);
      if (l != -1L)
      {
        if (i != 0) {
          i(this.b.b, 0L, l + 1L);
        }
        this.b.skip(l + 1L);
      }
      else
      {
        throw new EOFException();
      }
    }
    if ((m >> 4 & 0x1) == 1) {
      j = k;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      l = this.b.a((byte)0);
      if (l != -1L)
      {
        if (i != 0) {
          i(this.b.b, 0L, l + 1L);
        }
        this.b.skip(l + 1L);
      }
      else
      {
        throw new EOFException();
      }
    }
    if (i != 0)
    {
      a("FHCRC", this.b.i(), (short)(int)this.e.getValue());
      this.e.reset();
    }
  }
  
  private final void h()
  {
    a("CRC", this.b.h(), (int)this.e.getValue());
    a("ISIZE", this.b.h(), (int)this.c.getBytesWritten());
  }
  
  private final void i(b paramb, long paramLong1, long paramLong2)
  {
    int i;
    int j;
    for (paramb = paramb.a;; paramb = paramb.f)
    {
      f.c(paramb);
      i = paramb.c;
      j = paramb.b;
      if (paramLong1 < i - j) {
        break;
      }
      paramLong1 -= i - j;
    }
    while (paramLong2 > 0L)
    {
      i = (int)(paramb.b + paramLong1);
      j = (int)Math.min(paramb.c - i, paramLong2);
      this.e.update(paramb.a, i, j);
      paramLong2 -= j;
      paramb = paramb.f;
      f.c(paramb);
      paramLong1 = 0L;
    }
  }
  
  public y c()
  {
    return this.b.c();
  }
  
  public void close()
  {
    this.d.close();
  }
  
  public long k(b paramb, long paramLong)
  {
    f.f(paramb, "sink");
    boolean bool = paramLong < 0L;
    int i;
    if (!bool) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (!bool) {
        return 0L;
      }
      if (this.a == 0)
      {
        g();
        this.a = 1;
      }
      if (this.a == 1)
      {
        long l = paramb.z0();
        paramLong = this.d.k(paramb, paramLong);
        if (paramLong != -1L)
        {
          i(paramb, l, paramLong);
          return paramLong;
        }
        this.a = 2;
      }
      if (this.a == 2)
      {
        h();
        this.a = 3;
        if (this.b.D()) {
          return -1L;
        }
        throw new IOException("gzip finished without exhausting source");
      }
      return -1L;
    }
    throw new IllegalArgumentException(f.m("byteCount < 0: ", Long.valueOf(paramLong)).toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.i
 * JD-Core Version:    0.7.0.1
 */