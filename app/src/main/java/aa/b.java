package aa;

import ba.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Objects;

public final class b
  implements d, c, Cloneable, ByteChannel
{
  public s a;
  private long b;
  
  public final e A0()
  {
    int i;
    if (z0() <= 2147483647L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return B0((int)z0());
    }
    throw new IllegalStateException(a9.f.m("size > Int.MAX_VALUE: ", Long.valueOf(z0())).toString());
  }
  
  public final e B0(int paramInt)
  {
    if (paramInt == 0) {
      return e.e;
    }
    c0.b(z0(), 0L, paramInt);
    s locals = this.a;
    int k = 0;
    int j = 0;
    int i = j;
    while (j < paramInt)
    {
      a9.f.c(locals);
      int m = locals.c;
      int n = locals.b;
      if (m != n)
      {
        j += m - n;
        i += 1;
        locals = locals.f;
      }
      else
      {
        throw new AssertionError("s.limit == s.pos");
      }
    }
    byte[][] arrayOfByte = new byte[i][];
    int[] arrayOfInt = new int[i * 2];
    locals = this.a;
    j = 0;
    while (k < paramInt)
    {
      a9.f.c(locals);
      arrayOfByte[j] = locals.a;
      k += locals.c - locals.b;
      arrayOfInt[j] = Math.min(k, paramInt);
      arrayOfInt[(j + i)] = locals.b;
      locals.d = true;
      j += 1;
      locals = locals.f;
    }
    return new u(arrayOfByte, arrayOfInt);
  }
  
  public final s C0(int paramInt)
  {
    int i = 1;
    if ((paramInt < 1) || (paramInt > 8192)) {
      i = 0;
    }
    if (i != 0)
    {
      s locals = this.a;
      if (locals == null)
      {
        locals = t.c();
        this.a = locals;
        locals.g = locals;
        locals.f = locals;
        return locals;
      }
      a9.f.c(locals);
      locals = locals.g;
      a9.f.c(locals);
      if ((locals.c + paramInt <= 8192) && (locals.e)) {
        return locals;
      }
      return locals.c(t.c());
    }
    throw new IllegalArgumentException("unexpected capacity".toString());
  }
  
  public boolean D()
  {
    return this.b == 0L;
  }
  
  public b D0(e parame)
  {
    a9.f.f(parame, "byteString");
    parame.v(this, 0, parame.r());
    return this;
  }
  
  public int E(o paramo)
  {
    a9.f.f(paramo, "options");
    int i = a.d(this, paramo, false, 2, null);
    if (i == -1) {
      return -1;
    }
    skip(paramo.d()[i].r());
    return i;
  }
  
  public b E0(byte[] paramArrayOfByte)
  {
    a9.f.f(paramArrayOfByte, "source");
    return F0(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public b F0(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a9.f.f(paramArrayOfByte, "source");
    long l1 = paramArrayOfByte.length;
    long l2 = paramInt1;
    long l3 = paramInt2;
    c0.b(l1, l2, l3);
    int i = paramInt2 + paramInt1;
    while (paramInt1 < i)
    {
      s locals = C0(1);
      int j = Math.min(i - paramInt1, 8192 - locals.c);
      byte[] arrayOfByte = locals.a;
      int k = locals.c;
      paramInt2 = paramInt1 + j;
      p8.f.d(paramArrayOfByte, arrayOfByte, k, paramInt1, paramInt2);
      locals.c += j;
      paramInt1 = paramInt2;
    }
    y0(z0() + l3);
    return this;
  }
  
  public long G0(x paramx)
  {
    a9.f.f(paramx, "source");
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramx.k(this, 8192L);
      if (l2 == -1L) {
        return l1;
      }
    }
  }
  
  public byte[] H(long paramLong)
  {
    int i;
    if ((paramLong >= 0L) && (paramLong <= 2147483647L)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (z0() >= paramLong)
      {
        byte[] arrayOfByte = new byte[(int)paramLong];
        q0(arrayOfByte);
        return arrayOfByte;
      }
      throw new EOFException();
    }
    throw new IllegalArgumentException(a9.f.m("byteCount: ", Long.valueOf(paramLong)).toString());
  }
  
  public b H0(int paramInt)
  {
    s locals = C0(1);
    byte[] arrayOfByte = locals.a;
    int i = locals.c;
    locals.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    y0(z0() + 1L);
    return this;
  }
  
  public b I0(long paramLong)
  {
    boolean bool = paramLong < 0L;
    if (!bool) {
      return H0(48);
    }
    int j = 0;
    int i = 1;
    long l = paramLong;
    if (bool)
    {
      l = -paramLong;
      if (l < 0L) {
        return N0("-9223372036854775808");
      }
      j = 1;
    }
    if (l < 100000000L)
    {
      if (l < 10000L)
      {
        if (l < 100L)
        {
          if (l >= 10L) {
            i = 2;
          }
        }
        else if (l < 1000L) {
          i = 3;
        } else {
          i = 4;
        }
      }
      else if (l < 1000000L)
      {
        if (l < 100000L) {
          i = 5;
        } else {
          i = 6;
        }
      }
      else if (l < 10000000L) {
        i = 7;
      } else {
        i = 8;
      }
    }
    else if (l < 1000000000000L)
    {
      if (l < 10000000000L)
      {
        if (l < 1000000000L) {
          i = 9;
        } else {
          i = 10;
        }
      }
      else if (l < 100000000000L) {
        i = 11;
      } else {
        i = 12;
      }
    }
    else if (l < 1000000000000000L)
    {
      if (l < 10000000000000L) {
        i = 13;
      } else if (l < 100000000000000L) {
        i = 14;
      } else {
        i = 15;
      }
    }
    else if (l < 100000000000000000L)
    {
      if (l < 10000000000000000L) {
        i = 16;
      } else {
        i = 17;
      }
    }
    else if (l < 1000000000000000000L) {
      i = 18;
    } else {
      i = 19;
    }
    bool = i;
    int k;
    if (j != 0) {
      k = i + 1;
    }
    s locals = C0(k);
    byte[] arrayOfByte = locals.a;
    i = locals.c + k;
    while (l != 0L)
    {
      paramLong = 10;
      int m = (int)(l % paramLong);
      i -= 1;
      arrayOfByte[i] = a.a()[m];
      l /= paramLong;
    }
    if (j != 0) {
      arrayOfByte[(i - 1)] = ((byte)45);
    }
    locals.c += k;
    y0(z0() + k);
    return this;
  }
  
  public b J0(long paramLong)
  {
    if (paramLong == 0L) {
      return H0(48);
    }
    long l = paramLong >>> 1 | paramLong;
    l |= l >>> 2;
    l |= l >>> 4;
    l |= l >>> 8;
    l |= l >>> 16;
    l |= l >>> 32;
    l -= (l >>> 1 & 0x55555555);
    l = (l >>> 2 & 0x33333333) + (l & 0x33333333);
    l = (l >>> 4) + l & 0xF0F0F0F;
    l += (l >>> 8);
    l += (l >>> 16);
    int j = (int)(((l & 0x3F) + (l >>> 32 & 0x3F) + 3) / 4);
    s locals = C0(j);
    byte[] arrayOfByte = locals.a;
    int k = locals.c;
    int i = k + j - 1;
    while (i >= k)
    {
      arrayOfByte[i] = a.a()[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    locals.c += j;
    y0(z0() + j);
    return this;
  }
  
  public b K0(int paramInt)
  {
    s locals = C0(4);
    byte[] arrayOfByte = locals.a;
    int j = locals.c;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    locals.c = (i + 1);
    y0(z0() + 4L);
    return this;
  }
  
  public void L(b paramb, long paramLong)
  {
    a9.f.f(paramb, "source");
    int i;
    if (paramb != this) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      c0.b(paramb.z0(), 0L, paramLong);
      while (paramLong > 0L)
      {
        s locals1 = paramb.a;
        a9.f.c(locals1);
        i = locals1.c;
        locals1 = paramb.a;
        a9.f.c(locals1);
        if (paramLong < i - locals1.b)
        {
          locals1 = this.a;
          if (locals1 != null)
          {
            a9.f.c(locals1);
            locals1 = locals1.g;
          }
          else
          {
            locals1 = null;
          }
          if ((locals1 != null) && (locals1.e))
          {
            l = locals1.c;
            if (locals1.d) {
              i = 0;
            } else {
              i = locals1.b;
            }
            if (l + paramLong - i <= 8192L)
            {
              locals2 = paramb.a;
              a9.f.c(locals2);
              locals2.f(locals1, (int)paramLong);
              paramb.y0(paramb.z0() - paramLong);
              y0(z0() + paramLong);
              return;
            }
          }
          locals1 = paramb.a;
          a9.f.c(locals1);
          paramb.a = locals1.e((int)paramLong);
        }
        locals1 = paramb.a;
        a9.f.c(locals1);
        long l = locals1.c - locals1.b;
        paramb.a = locals1.b();
        s locals2 = this.a;
        if (locals2 == null)
        {
          this.a = locals1;
          locals1.g = locals1;
          locals1.f = locals1;
        }
        else
        {
          a9.f.c(locals2);
          locals2 = locals2.g;
          a9.f.c(locals2);
          locals2.c(locals1).a();
        }
        paramb.y0(paramb.z0() - l);
        y0(z0() + l);
        paramLong -= l;
      }
      return;
    }
    throw new IllegalArgumentException("source == this".toString());
  }
  
  public b L0(int paramInt)
  {
    s locals = C0(2);
    byte[] arrayOfByte = locals.a;
    int i = locals.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    locals.c = (j + 1);
    y0(z0() + 2L);
    return this;
  }
  
  public b M0(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    a9.f.f(paramString, "string");
    a9.f.f(paramCharset, "charset");
    int j = 1;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= paramString.length()) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (a9.f.a(paramCharset, f9.d.b)) {
            return O0(paramString, paramInt1, paramInt2);
          }
          paramString = paramString.substring(paramInt1, paramInt2);
          a9.f.e(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          Objects.requireNonNull(paramString, "null cannot be cast to non-null type java.lang.String");
          paramString = paramString.getBytes(paramCharset);
          a9.f.e(paramString, "(this as java.lang.String).getBytes(charset)");
          return F0(paramString, 0, paramString.length);
        }
        paramCharset = new StringBuilder();
        paramCharset.append("endIndex > string.length: ");
        paramCharset.append(paramInt2);
        paramCharset.append(" > ");
        paramCharset.append(paramString.length());
        throw new IllegalArgumentException(paramCharset.toString().toString());
      }
      paramString = new StringBuilder();
      paramString.append("endIndex < beginIndex: ");
      paramString.append(paramInt2);
      paramString.append(" < ");
      paramString.append(paramInt1);
      throw new IllegalArgumentException(paramString.toString().toString());
    }
    throw new IllegalArgumentException(a9.f.m("beginIndex < 0: ", Integer.valueOf(paramInt1)).toString());
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
      long l1 = 9223372036854775807L;
      if (paramLong != 9223372036854775807L) {
        l1 = paramLong + 1L;
      }
      byte b1 = (byte)10;
      long l2 = j0(b1, 0L, l1);
      if (l2 != -1L) {
        return a.b(this, l2);
      }
      if ((l1 < z0()) && (i0(l1 - 1L) == (byte)13) && (i0(l1) == b1)) {
        return a.b(this, l1);
      }
      b localb = new b();
      l1 = z0();
      h0(localb, 0L, Math.min(32, l1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\n not found: limit=");
      localStringBuilder.append(Math.min(z0(), paramLong));
      localStringBuilder.append(" content=");
      localStringBuilder.append(localb.p0().i());
      localStringBuilder.append('…');
      throw new EOFException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException(a9.f.m("limit < 0: ", Long.valueOf(paramLong)).toString());
  }
  
  public b N0(String paramString)
  {
    a9.f.f(paramString, "string");
    return O0(paramString, 0, paramString.length());
  }
  
  public b O0(String paramString, int paramInt1, int paramInt2)
  {
    a9.f.f(paramString, "string");
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= paramString.length()) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          while (paramInt1 < paramInt2)
          {
            int m = paramString.charAt(paramInt1);
            byte[] arrayOfByte;
            int j;
            int k;
            if (m < 128)
            {
              localObject = C0(1);
              arrayOfByte = ((s)localObject).a;
              j = ((s)localObject).c - paramInt1;
              k = Math.min(paramInt2, 8192 - j);
              i = paramInt1 + 1;
              arrayOfByte[(paramInt1 + j)] = ((byte)m);
              for (paramInt1 = i; paramInt1 < k; paramInt1 = i)
              {
                m = paramString.charAt(paramInt1);
                if (m >= 128) {
                  break;
                }
                i = paramInt1 + 1;
                arrayOfByte[(paramInt1 + j)] = ((byte)m);
              }
              i = ((s)localObject).c;
              j = j + paramInt1 - i;
              ((s)localObject).c = (i + j);
              y0(z0() + j);
            }
            else
            {
              long l1;
              if (m < 2048)
              {
                localObject = C0(2);
                arrayOfByte = ((s)localObject).a;
                i = ((s)localObject).c;
                arrayOfByte[i] = ((byte)(m >> 6 | 0xC0));
                arrayOfByte[(i + 1)] = ((byte)(m & 0x3F | 0x80));
                ((s)localObject).c = (i + 2);
                l1 = z0();
              }
              for (long l2 = 2L;; l2 = 3L)
              {
                y0(l1 + l2);
                paramInt1 += 1;
                break;
                if ((m >= 55296) && (m <= 57343))
                {
                  k = paramInt1 + 1;
                  if (k < paramInt2) {
                    i = paramString.charAt(k);
                  } else {
                    i = 0;
                  }
                  if (m <= 56319)
                  {
                    if ((56320 <= i) && (i <= 57343)) {
                      j = 1;
                    } else {
                      j = 0;
                    }
                    if (j != 0)
                    {
                      i = ((m & 0x3FF) << 10 | i & 0x3FF) + 65536;
                      localObject = C0(4);
                      arrayOfByte = ((s)localObject).a;
                      j = ((s)localObject).c;
                      arrayOfByte[j] = ((byte)(i >> 18 | 0xF0));
                      arrayOfByte[(j + 1)] = ((byte)(i >> 12 & 0x3F | 0x80));
                      arrayOfByte[(j + 2)] = ((byte)(i >> 6 & 0x3F | 0x80));
                      arrayOfByte[(j + 3)] = ((byte)(i & 0x3F | 0x80));
                      ((s)localObject).c = (j + 4);
                      y0(z0() + 4L);
                      paramInt1 += 2;
                      break;
                    }
                  }
                  H0(63);
                  paramInt1 = k;
                  break;
                }
                localObject = C0(3);
                arrayOfByte = ((s)localObject).a;
                i = ((s)localObject).c;
                arrayOfByte[i] = ((byte)(m >> 12 | 0xE0));
                arrayOfByte[(i + 1)] = ((byte)(0x3F & m >> 6 | 0x80));
                arrayOfByte[(i + 2)] = ((byte)(m & 0x3F | 0x80));
                ((s)localObject).c = (i + 3);
                l1 = z0();
              }
            }
          }
          return this;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("endIndex > string.length: ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" > ");
        ((StringBuilder)localObject).append(paramString.length());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
      }
      paramString = new StringBuilder();
      paramString.append("endIndex < beginIndex: ");
      paramString.append(paramInt2);
      paramString.append(" < ");
      paramString.append(paramInt1);
      throw new IllegalArgumentException(paramString.toString().toString());
    }
    throw new IllegalArgumentException(a9.f.m("beginIndex < 0: ", Integer.valueOf(paramInt1)).toString());
  }
  
  public b P0(int paramInt)
  {
    if (paramInt < 128)
    {
      H0(paramInt);
      return this;
    }
    s locals;
    byte[] arrayOfByte;
    int i;
    long l1;
    long l2;
    if (paramInt < 2048)
    {
      locals = C0(2);
      arrayOfByte = locals.a;
      i = locals.c;
      arrayOfByte[i] = ((byte)(paramInt >> 6 | 0xC0));
      arrayOfByte[(i + 1)] = ((byte)(paramInt & 0x3F | 0x80));
      locals.c = (i + 2);
      l1 = z0();
      l2 = 2L;
    }
    for (;;)
    {
      y0(l1 + l2);
      return this;
      int j = 0;
      i = j;
      if (55296 <= paramInt)
      {
        i = j;
        if (paramInt <= 57343) {
          i = 1;
        }
      }
      if (i != 0)
      {
        H0(63);
        return this;
      }
      if (paramInt < 65536)
      {
        locals = C0(3);
        arrayOfByte = locals.a;
        i = locals.c;
        arrayOfByte[i] = ((byte)(paramInt >> 12 | 0xE0));
        arrayOfByte[(i + 1)] = ((byte)(paramInt >> 6 & 0x3F | 0x80));
        arrayOfByte[(i + 2)] = ((byte)(paramInt & 0x3F | 0x80));
        locals.c = (i + 3);
        l1 = z0();
        l2 = 3L;
      }
      else
      {
        if (paramInt > 1114111) {
          break;
        }
        locals = C0(4);
        arrayOfByte = locals.a;
        i = locals.c;
        arrayOfByte[i] = ((byte)(paramInt >> 18 | 0xF0));
        arrayOfByte[(i + 1)] = ((byte)(paramInt >> 12 & 0x3F | 0x80));
        arrayOfByte[(i + 2)] = ((byte)(paramInt >> 6 & 0x3F | 0x80));
        arrayOfByte[(i + 3)] = ((byte)(paramInt & 0x3F | 0x80));
        locals.c = (i + 4);
        l1 = z0();
        l2 = 4L;
      }
    }
    throw new IllegalArgumentException(a9.f.m("Unexpected code point: 0x", c0.g(paramInt)));
  }
  
  public long T(v paramv)
  {
    a9.f.f(paramv, "sink");
    long l = z0();
    if (l > 0L) {
      paramv.L(this, l);
    }
    return l;
  }
  
  public void U(long paramLong)
  {
    if (this.b >= paramLong) {
      return;
    }
    throw new EOFException();
  }
  
  public final void a()
  {
    skip(z0());
  }
  
  public b b()
  {
    return this;
  }
  
  public long b0()
  {
    if (z0() != 0L)
    {
      int n = 0;
      int j = 0;
      long l1 = 0L;
      long l2;
      int k;
      label217:
      label245:
      do
      {
        s locals = this.a;
        a9.f.c(locals);
        byte[] arrayOfByte = locals.a;
        int m = locals.b;
        int i2 = locals.c;
        l2 = l1;
        k = n;
        int i1;
        int i;
        for (;;)
        {
          i1 = j;
          if (m >= i2) {
            break label245;
          }
          i = arrayOfByte[m];
          n = (byte)48;
          if ((i >= n) && (i <= (byte)57))
          {
            n = i - n;
          }
          else
          {
            n = (byte)97;
            if ((i >= n) && (i <= (byte)102)) {}
            for (;;)
            {
              n = i - n + 10;
              break;
              n = (byte)65;
              if ((i < n) || (i > (byte)70)) {
                break label217;
              }
            }
          }
          if ((0x0 & l2) != 0L) {
            break;
          }
          l2 = l2 << 4 | n;
          m += 1;
          k += 1;
        }
        throw new NumberFormatException(a9.f.m("Number too large: ", new b().J0(l2).H0(i).v0()));
        if (k != 0) {
          i1 = 1;
        } else {
          throw new NumberFormatException(a9.f.m("Expected leading [0-9a-fA-F] character but was 0x", c0.f(i)));
        }
        if (m == i2)
        {
          this.a = locals.b();
          t.b(locals);
        }
        else
        {
          locals.b = m;
        }
        if (i1 != 0) {
          break;
        }
        n = k;
        j = i1;
        l1 = l2;
      } while (this.a != null);
      y0(z0() - k);
      return l2;
    }
    throw new EOFException();
  }
  
  public y c()
  {
    return y.e;
  }
  
  public InputStream c0()
  {
    return new b(this);
  }
  
  public void close() {}
  
  public b e0()
  {
    return g0();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      long l1 = z0();
      paramObject = (b)paramObject;
      if (l1 != paramObject.z0()) {
        return false;
      }
      if (z0() != 0L)
      {
        Object localObject1 = this.a;
        a9.f.c(localObject1);
        paramObject = paramObject.a;
        a9.f.c(paramObject);
        int i = ((s)localObject1).b;
        int j = paramObject.b;
        l1 = 0L;
        while (l1 < z0())
        {
          long l3 = Math.min(((s)localObject1).c - i, paramObject.c - j);
          int m = i;
          int k = j;
          if (0L < l3)
          {
            long l2 = 0L;
            for (;;)
            {
              l2 += 1L;
              localObject2 = ((s)localObject1).a;
              k = i + 1;
              m = localObject2[i];
              localObject2 = paramObject.a;
              i = j + 1;
              if (m != localObject2[j]) {
                return false;
              }
              if (l2 >= l3)
              {
                m = k;
                k = i;
                break;
              }
              j = i;
              i = k;
            }
          }
          Object localObject2 = localObject1;
          i = m;
          if (m == ((s)localObject1).c)
          {
            localObject2 = ((s)localObject1).f;
            a9.f.c(localObject2);
            i = ((s)localObject2).b;
          }
          localObject1 = paramObject;
          j = k;
          if (k == paramObject.c)
          {
            localObject1 = paramObject.f;
            a9.f.c(localObject1);
            j = ((s)localObject1).b;
          }
          l1 += l3;
          paramObject = localObject1;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public final long f0()
  {
    long l2 = z0();
    if (l2 == 0L) {
      return 0L;
    }
    s locals = this.a;
    a9.f.c(locals);
    locals = locals.g;
    a9.f.c(locals);
    int i = locals.c;
    long l1 = l2;
    if (i < 8192)
    {
      l1 = l2;
      if (locals.e) {
        l1 = l2 - (i - locals.b);
      }
    }
    return l1;
  }
  
  public void flush() {}
  
  public final b g0()
  {
    b localb = new b();
    if (z0() == 0L) {
      return localb;
    }
    s locals2 = this.a;
    a9.f.c(locals2);
    s locals3 = locals2.d();
    localb.a = locals3;
    locals3.g = locals3;
    locals3.f = locals3;
    for (s locals1 = locals2.f; locals1 != locals2; locals1 = locals1.f)
    {
      s locals4 = locals3.g;
      a9.f.c(locals4);
      a9.f.c(locals1);
      locals4.c(locals1.d());
    }
    localb.y0(z0());
    return localb;
  }
  
  public final b h0(b paramb, long paramLong1, long paramLong2)
  {
    a9.f.f(paramb, "out");
    c0.b(z0(), paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    paramb.y0(paramb.z0() + paramLong2);
    int i;
    s locals2;
    long l1;
    long l2;
    for (s locals1 = this.a;; locals1 = locals1.f)
    {
      a9.f.c(locals1);
      i = locals1.c;
      int j = locals1.b;
      locals2 = locals1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < i - j) {
        break;
      }
      paramLong1 -= i - j;
    }
    while (l2 > 0L)
    {
      a9.f.c(locals2);
      locals1 = locals2.d();
      i = locals1.b + (int)l1;
      locals1.b = i;
      locals1.c = Math.min(i + (int)l2, locals1.c);
      s locals3 = paramb.a;
      if (locals3 == null)
      {
        locals1.g = locals1;
        locals1.f = locals1;
        paramb.a = locals1;
      }
      else
      {
        a9.f.c(locals3);
        locals3 = locals3.g;
        a9.f.c(locals3);
        locals3.c(locals1);
      }
      l2 -= locals1.c - locals1.b;
      locals2 = locals2.f;
      l1 = 0L;
    }
    return this;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    int i = 1;
    int j;
    s locals;
    do
    {
      int k = ((s)localObject).b;
      int m = ((s)localObject).c;
      j = i;
      while (k < m)
      {
        j = j * 31 + localObject.a[k];
        k += 1;
      }
      locals = ((s)localObject).f;
      a9.f.c(locals);
      localObject = locals;
      i = j;
    } while (locals != this.a);
    return j;
  }
  
  public final byte i0(long paramLong)
  {
    c0.b(z0(), paramLong, 1L);
    s locals = this.a;
    if (locals != null)
    {
      if (z0() - paramLong < paramLong)
      {
        for (l1 = z0(); l1 > paramLong; l1 -= locals.c - locals.b)
        {
          locals = locals.g;
          a9.f.c(locals);
        }
        a9.f.c(locals);
        return locals.a[((int)(locals.b + paramLong - l1))];
      }
      long l2;
      for (long l1 = 0L;; l1 = l2)
      {
        l2 = locals.c - locals.b + l1;
        if (l2 > paramLong)
        {
          a9.f.c(locals);
          return locals.a[((int)(locals.b + paramLong - l1))];
        }
        locals = locals.f;
        a9.f.c(locals);
      }
    }
    a9.f.c(null);
    throw null;
  }
  
  public boolean isOpen()
  {
    return true;
  }
  
  public long j0(byte paramByte, long paramLong1, long paramLong2)
  {
    long l1 = 0L;
    int j = 0;
    int i = j;
    if (0L <= paramLong1)
    {
      i = j;
      if (paramLong1 <= paramLong2) {
        i = 1;
      }
    }
    if (i != 0)
    {
      long l2 = paramLong2;
      if (paramLong2 > z0()) {
        l2 = z0();
      }
      if (paramLong1 == l2) {
        return -1L;
      }
      Object localObject2 = this.a;
      if (localObject2 == null) {
        return -1L;
      }
      paramLong2 = l1;
      localObject1 = localObject2;
      if (z0() - paramLong1 < paramLong1)
      {
        long l3;
        for (l1 = z0();; l1 -= ((s)localObject2).c - ((s)localObject2).b)
        {
          paramLong2 = l1;
          l3 = paramLong1;
          localObject1 = localObject2;
          if (l1 <= paramLong1) {
            break;
          }
          localObject2 = ((s)localObject2).g;
          a9.f.c(localObject2);
        }
        while (paramLong2 < l2)
        {
          localObject2 = ((s)localObject1).a;
          j = (int)Math.min(((s)localObject1).c, ((s)localObject1).b + l2 - paramLong2);
          i = (int)(((s)localObject1).b + l3 - paramLong2);
          while (i < j)
          {
            if (localObject2[i] == paramByte) {
              return i - ((s)localObject1).b + paramLong2;
            }
            i += 1;
          }
          paramLong2 += ((s)localObject1).c - ((s)localObject1).b;
          localObject1 = ((s)localObject1).f;
          a9.f.c(localObject1);
          l3 = paramLong2;
        }
      }
      for (;;)
      {
        l1 = ((s)localObject1).c - ((s)localObject1).b + paramLong2;
        if (l1 > paramLong1)
        {
          for (;;)
          {
            if (paramLong2 >= l2) {
              break label424;
            }
            localObject2 = ((s)localObject1).a;
            j = (int)Math.min(((s)localObject1).c, ((s)localObject1).b + l2 - paramLong2);
            i = (int)(((s)localObject1).b + paramLong1 - paramLong2);
            for (;;)
            {
              if (i >= j) {
                break label389;
              }
              if (localObject2[i] == paramByte) {
                break;
              }
              i += 1;
            }
            label389:
            paramLong2 += ((s)localObject1).c - ((s)localObject1).b;
            localObject1 = ((s)localObject1).f;
            a9.f.c(localObject1);
            paramLong1 = paramLong2;
          }
          label424:
          return -1L;
        }
        localObject1 = ((s)localObject1).f;
        a9.f.c(localObject1);
        paramLong2 = l1;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("size=");
    ((StringBuilder)localObject1).append(z0());
    ((StringBuilder)localObject1).append(" fromIndex=");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(" toIndex=");
    ((StringBuilder)localObject1).append(paramLong2);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString().toString());
  }
  
  public long k(b paramb, long paramLong)
  {
    a9.f.f(paramb, "sink");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (z0() == 0L) {
        return -1L;
      }
      long l = paramLong;
      if (paramLong > z0()) {
        l = z0();
      }
      paramb.L(this, l);
      return l;
    }
    throw new IllegalArgumentException(a9.f.m("byteCount < 0: ", Long.valueOf(paramLong)).toString());
  }
  
  public long k0(e parame)
  {
    a9.f.f(parame, "targetBytes");
    return l0(parame, 0L);
  }
  
  public long l0(e parame, long paramLong)
  {
    a9.f.f(parame, "targetBytes");
    long l1 = 0L;
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Object localObject2 = this.a;
      if (localObject2 == null) {
        return -1L;
      }
      Object localObject1 = localObject2;
      int k;
      int m;
      int j;
      int n;
      int i1;
      long l2;
      if (z0() - paramLong < paramLong)
      {
        l1 = z0();
        localObject1 = localObject2;
        while (l1 > paramLong)
        {
          localObject1 = ((s)localObject1).g;
          a9.f.c(localObject1);
          l1 -= ((s)localObject1).c - ((s)localObject1).b;
        }
        if (parame.r() == 2)
        {
          k = parame.d(0);
          m = parame.d(1);
          while (l1 < z0())
          {
            localObject2 = ((s)localObject1).a;
            j = (int)(((s)localObject1).b + paramLong - l1);
            n = ((s)localObject1).c;
            while (j < n)
            {
              i1 = localObject2[j];
              paramLong = l1;
              parame = (e)localObject1;
              i = j;
              if (i1 != k) {
                if (i1 == m)
                {
                  paramLong = l1;
                  parame = (e)localObject1;
                  i = j;
                }
                else
                {
                  j += 1;
                  continue;
                }
              }
              return i - parame.b + paramLong;
            }
            l1 += ((s)localObject1).c - ((s)localObject1).b;
            localObject1 = ((s)localObject1).f;
            a9.f.c(localObject1);
            paramLong = l1;
          }
        }
        localObject2 = parame.j();
        l2 = paramLong;
        parame = (e)localObject1;
        paramLong = l1;
        for (;;)
        {
          if (paramLong >= z0()) {
            break label730;
          }
          localObject1 = parame.a;
          i = (int)(parame.b + l2 - paramLong);
          k = parame.c;
          for (;;)
          {
            if (i >= k) {
              break label385;
            }
            m = localObject1[i];
            n = localObject2.length;
            j = 0;
            for (;;)
            {
              if (j < n)
              {
                i1 = localObject2[j];
                j += 1;
                if (m == i1) {
                  break;
                }
              }
            }
            i += 1;
          }
          label385:
          paramLong += parame.c - parame.b;
          parame = parame.f;
          a9.f.c(parame);
          l2 = paramLong;
        }
      }
      for (;;)
      {
        l2 = ((s)localObject1).c - ((s)localObject1).b + l1;
        if (l2 > paramLong)
        {
          if (parame.r() == 2)
          {
            k = parame.d(0);
            m = parame.d(1);
            for (;;)
            {
              if (l1 >= z0()) {
                break label730;
              }
              localObject2 = ((s)localObject1).a;
              j = (int)(((s)localObject1).b + paramLong - l1);
              n = ((s)localObject1).c;
              for (;;)
              {
                if (j >= n) {
                  break label557;
                }
                i1 = localObject2[j];
                paramLong = l1;
                parame = (e)localObject1;
                i = j;
                if (i1 == k) {
                  break;
                }
                if (i1 == m)
                {
                  paramLong = l1;
                  parame = (e)localObject1;
                  i = j;
                  break;
                }
                j += 1;
              }
              label557:
              l1 += ((s)localObject1).c - ((s)localObject1).b;
              localObject1 = ((s)localObject1).f;
              a9.f.c(localObject1);
              paramLong = l1;
            }
          }
          localObject2 = parame.j();
          l2 = paramLong;
          parame = (e)localObject1;
          paramLong = l1;
          for (;;)
          {
            if (paramLong >= z0()) {
              break label730;
            }
            localObject1 = parame.a;
            i = (int)(parame.b + l2 - paramLong);
            k = parame.c;
            for (;;)
            {
              if (i >= k) {
                break label702;
              }
              m = localObject1[i];
              n = localObject2.length;
              j = 0;
              for (;;)
              {
                if (j < n)
                {
                  i1 = localObject2[j];
                  j += 1;
                  if (m == i1) {
                    break;
                  }
                }
              }
              i += 1;
            }
            label702:
            paramLong += parame.c - parame.b;
            parame = parame.f;
            a9.f.c(parame);
            l2 = paramLong;
          }
          label730:
          return -1L;
        }
        localObject1 = ((s)localObject1).f;
        a9.f.c(localObject1);
        l1 = l2;
      }
    }
    throw new IllegalArgumentException(a9.f.m("fromIndex < 0: ", Long.valueOf(paramLong)).toString());
  }
  
  public OutputStream m0()
  {
    return new c(this);
  }
  
  public int n0(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a9.f.f(paramArrayOfByte, "sink");
    c0.b(paramArrayOfByte.length, paramInt1, paramInt2);
    s locals = this.a;
    if (locals == null) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, locals.c - locals.b);
    byte[] arrayOfByte = locals.a;
    int i = locals.b;
    p8.f.d(arrayOfByte, paramArrayOfByte, paramInt1, i, i + paramInt2);
    locals.b += paramInt2;
    y0(z0() - paramInt2);
    if (locals.b == locals.c)
    {
      this.a = locals.b();
      t.b(locals);
    }
    return paramInt2;
  }
  
  public e o(long paramLong)
  {
    int i;
    if ((paramLong >= 0L) && (paramLong <= 2147483647L)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (z0() >= paramLong)
      {
        if (paramLong >= 4096L)
        {
          e locale = B0((int)paramLong);
          skip(paramLong);
          return locale;
        }
        return new e(H(paramLong));
      }
      throw new EOFException();
    }
    throw new IllegalArgumentException(a9.f.m("byteCount: ", Long.valueOf(paramLong)).toString());
  }
  
  public byte[] o0()
  {
    return H(z0());
  }
  
  public e p0()
  {
    return o(z0());
  }
  
  public void q0(byte[] paramArrayOfByte)
  {
    a9.f.f(paramArrayOfByte, "sink");
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = n0(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j != -1) {
        i += j;
      } else {
        throw new EOFException();
      }
    }
  }
  
  public int r0()
  {
    return c0.d(readInt());
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    a9.f.f(paramByteBuffer, "sink");
    s locals = this.a;
    if (locals == null) {
      return -1;
    }
    int i = Math.min(paramByteBuffer.remaining(), locals.c - locals.b);
    paramByteBuffer.put(locals.a, locals.b, i);
    int j = locals.b + i;
    locals.b = j;
    this.b -= i;
    if (j == locals.c)
    {
      this.a = locals.b();
      t.b(locals);
    }
    return i;
  }
  
  public byte readByte()
  {
    if (z0() != 0L)
    {
      s locals = this.a;
      a9.f.c(locals);
      int i = locals.b;
      int j = locals.c;
      byte[] arrayOfByte = locals.a;
      int k = i + 1;
      byte b1 = arrayOfByte[i];
      y0(z0() - 1L);
      if (k == j)
      {
        this.a = locals.b();
        t.b(locals);
        return b1;
      }
      locals.b = k;
      return b1;
    }
    throw new EOFException();
  }
  
  public int readInt()
  {
    if (z0() >= 4L)
    {
      s locals = this.a;
      a9.f.c(locals);
      int j = locals.b;
      int i = locals.c;
      if (i - j < 4L) {
        return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF;
      }
      byte[] arrayOfByte = locals.a;
      int k = j + 1;
      j = arrayOfByte[j];
      int n = k + 1;
      k = arrayOfByte[k];
      int m = n + 1;
      n = arrayOfByte[n];
      int i1 = m + 1;
      m = arrayOfByte[m];
      y0(z0() - 4L);
      if (i1 == i)
      {
        this.a = locals.b();
        t.b(locals);
      }
      else
      {
        locals.b = i1;
      }
      return (j & 0xFF) << 24 | (k & 0xFF) << 16 | (n & 0xFF) << 8 | m & 0xFF;
    }
    throw new EOFException();
  }
  
  public short readShort()
  {
    if (z0() >= 2L)
    {
      s locals = this.a;
      a9.f.c(locals);
      int k = locals.b;
      int i = locals.c;
      if (i - k < 2) {
        return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
      }
      byte[] arrayOfByte = locals.a;
      int j = k + 1;
      k = arrayOfByte[k];
      int m = j + 1;
      j = arrayOfByte[j];
      y0(z0() - 2L);
      if (m == i)
      {
        this.a = locals.b();
        t.b(locals);
      }
      else
      {
        locals.b = m;
      }
      return (short)((k & 0xFF) << 8 | j & 0xFF);
    }
    throw new EOFException();
  }
  
  public short s0()
  {
    return c0.e(readShort());
  }
  
  public void skip(long paramLong)
  {
    while (paramLong > 0L)
    {
      s locals = this.a;
      if (locals != null)
      {
        int i = (int)Math.min(paramLong, locals.c - locals.b);
        long l1 = z0();
        long l2 = i;
        y0(l1 - l2);
        l1 = paramLong - l2;
        i = locals.b + i;
        locals.b = i;
        paramLong = l1;
        if (i == locals.c)
        {
          this.a = locals.b();
          t.b(locals);
          paramLong = l1;
        }
      }
      else
      {
        throw new EOFException();
      }
    }
  }
  
  public boolean t(long paramLong)
  {
    return this.b >= paramLong;
  }
  
  public String t0(long paramLong, Charset paramCharset)
  {
    a9.f.f(paramCharset, "charset");
    boolean bool = paramLong < 0L;
    int i;
    if ((!bool) && (paramLong <= 2147483647L)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.b >= paramLong)
      {
        if (!bool) {
          return "";
        }
        s locals = this.a;
        a9.f.c(locals);
        i = locals.b;
        if (i + paramLong > locals.c) {
          return new String(H(paramLong), paramCharset);
        }
        byte[] arrayOfByte = locals.a;
        int j = (int)paramLong;
        paramCharset = new String(arrayOfByte, i, j, paramCharset);
        i = locals.b + j;
        locals.b = i;
        this.b -= paramLong;
        if (i == locals.c)
        {
          this.a = locals.b();
          t.b(locals);
        }
        return paramCharset;
      }
      throw new EOFException();
    }
    throw new IllegalArgumentException(a9.f.m("byteCount: ", Long.valueOf(paramLong)).toString());
  }
  
  public String toString()
  {
    return A0().toString();
  }
  
  public String u0(Charset paramCharset)
  {
    a9.f.f(paramCharset, "charset");
    return t0(this.b, paramCharset);
  }
  
  public String v0()
  {
    return t0(this.b, f9.d.b);
  }
  
  public String w0(long paramLong)
  {
    return t0(paramLong, f9.d.b);
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    a9.f.f(paramByteBuffer, "source");
    int j = paramByteBuffer.remaining();
    int i = j;
    while (i > 0)
    {
      s locals = C0(1);
      int k = Math.min(i, 8192 - locals.c);
      paramByteBuffer.get(locals.a, locals.c, k);
      i -= k;
      locals.c += k;
    }
    this.b += j;
    return j;
  }
  
  public int x0()
  {
    if (z0() != 0L)
    {
      int i = i0(0L);
      int i1 = 0;
      int j;
      int m;
      int k;
      if ((i & 0x80) == 0)
      {
        j = i & 0x7F;
        m = 0;
        k = 1;
      }
      else if ((i & 0xE0) == 192)
      {
        j = i & 0x1F;
        k = 2;
        m = 128;
      }
      else if ((i & 0xF0) == 224)
      {
        j = i & 0xF;
        k = 3;
        m = 2048;
      }
      else
      {
        if ((i & 0xF8) != 240) {
          break label362;
        }
        j = i & 0x7;
        k = 4;
        m = 65536;
      }
      long l2 = z0();
      long l1 = k;
      if (l2 >= l1)
      {
        int n = j;
        if (1 < k)
        {
          int i2;
          for (n = 1;; n = i2)
          {
            i2 = n + 1;
            l2 = n;
            n = i0(l2);
            if ((n & 0xC0) != 128) {
              break;
            }
            j = j << 6 | n & 0x3F;
            if (i2 >= k)
            {
              n = j;
              break label214;
            }
          }
          skip(l2);
          return 65533;
        }
        label214:
        skip(l1);
        if (n > 1114111) {
          return 65533;
        }
        j = i1;
        if (55296 <= n)
        {
          j = i1;
          if (n <= 57343) {
            j = 1;
          }
        }
        if (j != 0) {
          return 65533;
        }
        if (n < m) {
          return 65533;
        }
        return n;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("size < ");
      localStringBuilder.append(k);
      localStringBuilder.append(": ");
      localStringBuilder.append(z0());
      localStringBuilder.append(" (to read code point prefixed 0x");
      localStringBuilder.append(c0.f(i));
      localStringBuilder.append(')');
      throw new EOFException(localStringBuilder.toString());
      label362:
      skip(1L);
      return 65533;
    }
    throw new EOFException();
  }
  
  public final void y0(long paramLong)
  {
    this.b = paramLong;
  }
  
  public String z()
  {
    return N(9223372036854775807L);
  }
  
  public final long z0()
  {
    return this.b;
  }
  
  public static final class a
    implements Closeable
  {
    public b a;
    private s b;
    public long c = -1L;
    public byte[] d;
    public int e = -1;
    public int f = -1;
    
    public final void a(s params)
    {
      this.b = params;
    }
    
    public void close()
    {
      int i;
      if (this.a != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.a = null;
        a(null);
        this.c = -1L;
        this.d = null;
        this.e = -1;
        this.f = -1;
        return;
      }
      throw new IllegalStateException("not attached to a buffer".toString());
    }
  }
  
  public static final class b
    extends InputStream
  {
    b(b paramb) {}
    
    public int available()
    {
      return (int)Math.min(this.a.z0(), 2147483647);
    }
    
    public void close() {}
    
    public int read()
    {
      if (this.a.z0() > 0L) {
        return this.a.readByte() & 0xFF;
      }
      return -1;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      a9.f.f(paramArrayOfByte, "sink");
      return this.a.n0(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(".inputStream()");
      return localStringBuilder.toString();
    }
  }
  
  public static final class c
    extends OutputStream
  {
    c(b paramb) {}
    
    public void close() {}
    
    public void flush() {}
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(".outputStream()");
      return localStringBuilder.toString();
    }
    
    public void write(int paramInt)
    {
      this.a.H0(paramInt);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      a9.f.f(paramArrayOfByte, "data");
      this.a.F0(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.b
 * JD-Core Version:    0.7.0.1
 */