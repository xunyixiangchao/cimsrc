package aa;

import a9.f;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class r
  implements d
{
  public final x a;
  public final b b;
  public boolean c;
  
  public r(x paramx)
  {
    this.a = paramx;
    this.b = new b();
  }
  
  public boolean D()
  {
    if ((this.c ^ true)) {
      return (this.b.D()) && (this.a.k(this.b, 8192L) == -1L);
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public int E(o paramo)
  {
    f.f(paramo, "options");
    if ((this.c ^ true))
    {
      int i = ba.a.c(this.b, paramo, true);
      if (i != -2) {
        if (i != -1)
        {
          int j = paramo.d()[i].r();
          this.b.skip(j);
          return i;
        }
      }
      for (;;)
      {
        return -1;
        if (this.a.k(this.b, 8192L) != -1L) {
          break;
        }
      }
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public byte[] H(long paramLong)
  {
    U(paramLong);
    return this.b.H(paramLong);
  }
  
  public String N(long paramLong)
  {
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramLong == 9223372036854775807L) {
        l1 = 9223372036854775807L;
      } else {
        l1 = paramLong + 1L;
      }
      byte b1 = (byte)10;
      long l2 = g(b1, 0L, l1);
      if (l2 != -1L) {
        return ba.a.b(this.b, l2);
      }
      if ((l1 < 9223372036854775807L) && (t(l1)) && (this.b.i0(l1 - 1L) == (byte)13) && (t(1L + l1)) && (this.b.i0(l1) == b1)) {
        return ba.a.b(this.b, l1);
      }
      b localb = new b();
      Object localObject = this.b;
      long l1 = ((b)localObject).z0();
      ((b)localObject).h0(localb, 0L, Math.min(32, l1));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\\n not found: limit=");
      ((StringBuilder)localObject).append(Math.min(this.b.z0(), paramLong));
      ((StringBuilder)localObject).append(" content=");
      ((StringBuilder)localObject).append(localb.p0().i());
      ((StringBuilder)localObject).append('…');
      throw new EOFException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException(f.m("limit < 0: ", Long.valueOf(paramLong)).toString());
  }
  
  public long T(v paramv)
  {
    f.f(paramv, "sink");
    long l1 = 0L;
    while (this.a.k(this.b, 8192L) != -1L)
    {
      l2 = this.b.f0();
      if (l2 > 0L)
      {
        l1 += l2;
        paramv.L(this.b, l2);
      }
    }
    long l2 = l1;
    if (this.b.z0() > 0L)
    {
      l2 = l1 + this.b.z0();
      b localb = this.b;
      paramv.L(localb, localb.z0());
    }
    return l2;
  }
  
  public void U(long paramLong)
  {
    if (t(paramLong)) {
      return;
    }
    throw new EOFException();
  }
  
  public long a(byte paramByte)
  {
    return g(paramByte, 0L, 9223372036854775807L);
  }
  
  public b b()
  {
    return this.b;
  }
  
  public long b0()
  {
    U(1L);
    int j;
    int k;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!t(j)) {
        break label123;
      }
      k = this.b.i0(i);
      if (((k < (byte)48) || (k > (byte)57)) && ((k < (byte)97) || (k > (byte)102)) && ((k < (byte)65) || (k > (byte)70))) {
        break;
      }
    }
    if (i == 0)
    {
      String str = Integer.toString(k, f9.a.a(f9.a.a(16)));
      f.e(str, "java.lang.Integer.toStri…(this, checkRadix(radix))");
      throw new NumberFormatException(f.m("Expected leading [0-9a-fA-F] character but was 0x", str));
    }
    label123:
    return this.b.b0();
  }
  
  public y c()
  {
    return this.a.c();
  }
  
  public InputStream c0()
  {
    return new a(this);
  }
  
  public void close()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.a.close();
    this.b.a();
  }
  
  public long g(byte paramByte, long paramLong1, long paramLong2)
  {
    boolean bool = this.c;
    int i = 1;
    if ((bool ^ true))
    {
      if ((0L > paramLong1) || (paramLong1 > paramLong2)) {
        i = 0;
      }
      if (i != 0)
      {
        while (paramLong1 < paramLong2)
        {
          long l = this.b.j0(paramByte, paramLong1, paramLong2);
          if (l != -1L) {
            return l;
          }
          l = this.b.z0();
          if (l >= paramLong2) {
            break;
          }
          if (this.a.k(this.b, 8192L) == -1L) {
            return -1L;
          }
          paramLong1 = Math.max(paramLong1, l);
        }
        return -1L;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromIndex=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" toIndex=");
      localStringBuilder.append(paramLong2);
      throw new IllegalArgumentException(localStringBuilder.toString().toString());
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public int h()
  {
    U(4L);
    return this.b.r0();
  }
  
  public short i()
  {
    U(2L);
    return this.b.s0();
  }
  
  public boolean isOpen()
  {
    return this.c ^ true;
  }
  
  public long k(b paramb, long paramLong)
  {
    f.f(paramb, "sink");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((this.c ^ true))
      {
        if ((this.b.z0() == 0L) && (this.a.k(this.b, 8192L) == -1L)) {
          return -1L;
        }
        paramLong = Math.min(paramLong, this.b.z0());
        return this.b.k(paramb, paramLong);
      }
      throw new IllegalStateException("closed".toString());
    }
    throw new IllegalArgumentException(f.m("byteCount < 0: ", Long.valueOf(paramLong)).toString());
  }
  
  public e o(long paramLong)
  {
    U(paramLong);
    return this.b.o(paramLong);
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    f.f(paramByteBuffer, "sink");
    if ((this.b.z0() == 0L) && (this.a.k(this.b, 8192L) == -1L)) {
      return -1;
    }
    return this.b.read(paramByteBuffer);
  }
  
  public byte readByte()
  {
    U(1L);
    return this.b.readByte();
  }
  
  public int readInt()
  {
    U(4L);
    return this.b.readInt();
  }
  
  public short readShort()
  {
    U(2L);
    return this.b.readShort();
  }
  
  public void skip(long paramLong)
  {
    if ((this.c ^ true))
    {
      while (paramLong > 0L)
      {
        if ((this.b.z0() == 0L) && (this.a.k(this.b, 8192L) == -1L)) {
          throw new EOFException();
        }
        long l = Math.min(paramLong, this.b.z0());
        this.b.skip(l);
        paramLong -= l;
      }
      return;
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public boolean t(long paramLong)
  {
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((this.c ^ true))
      {
        while (this.b.z0() < paramLong) {
          if (this.a.k(this.b, 8192L) == -1L) {
            return false;
          }
        }
        return true;
      }
      throw new IllegalStateException("closed".toString());
    }
    throw new IllegalArgumentException(f.m("byteCount < 0: ", Long.valueOf(paramLong)).toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public String z()
  {
    return N(9223372036854775807L);
  }
  
  public static final class a
    extends InputStream
  {
    a(r paramr) {}
    
    public int available()
    {
      r localr = this.a;
      if (!localr.c) {
        return (int)Math.min(localr.b.z0(), 2147483647);
      }
      throw new IOException("closed");
    }
    
    public void close()
    {
      this.a.close();
    }
    
    public int read()
    {
      r localr = this.a;
      if (!localr.c)
      {
        if (localr.b.z0() == 0L)
        {
          localr = this.a;
          if (localr.a.k(localr.b, 8192L) == -1L) {
            return -1;
          }
        }
        return this.a.b.readByte() & 0xFF;
      }
      throw new IOException("closed");
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      f.f(paramArrayOfByte, "data");
      if (!this.a.c)
      {
        c0.b(paramArrayOfByte.length, paramInt1, paramInt2);
        if (this.a.b.z0() == 0L)
        {
          r localr = this.a;
          if (localr.a.k(localr.b, 8192L) == -1L) {
            return -1;
          }
        }
        return this.a.b.n0(paramArrayOfByte, paramInt1, paramInt2);
      }
      throw new IOException("closed");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(".inputStream()");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.r
 * JD-Core Version:    0.7.0.1
 */