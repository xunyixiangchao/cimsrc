package com.baidu.b.a;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class b
  implements Serializable, Cloneable
{
  private static final ObjectStreamField[] b = { new ObjectStreamField("bits", [J.class) };
  private long[] c;
  private transient int d = 0;
  private transient boolean e = false;
  
  public b()
  {
    g(64);
    this.e = false;
  }
  
  public b(int paramInt)
  {
    if (paramInt >= 0)
    {
      g(paramInt);
      this.e = true;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nbits < 0: ");
    localStringBuilder.append(paramInt);
    throw new NegativeArraySizeException(localStringBuilder.toString());
  }
  
  private b(long[] paramArrayOfLong)
  {
    this.c = paramArrayOfLong;
    this.d = paramArrayOfLong.length;
    d();
  }
  
  public static b a(long[] paramArrayOfLong)
  {
    int i = paramArrayOfLong.length;
    while ((i > 0) && (paramArrayOfLong[(i - 1)] == 0L)) {
      i -= 1;
    }
    return new b(Arrays.copyOf(paramArrayOfLong, i));
  }
  
  private void d()
  {
    boolean bool = a;
    int i;
    if (!bool)
    {
      i = this.d;
      if ((i != 0) && (this.c[(i - 1)] == 0L)) {
        throw new AssertionError();
      }
    }
    if (!bool)
    {
      i = this.d;
      if ((i < 0) || (i > this.c.length)) {
        throw new AssertionError();
      }
    }
    if (!bool)
    {
      i = this.d;
      long[] arrayOfLong = this.c;
      if (i != arrayOfLong.length)
      {
        if (arrayOfLong[i] == 0L) {
          return;
        }
        throw new AssertionError();
      }
    }
  }
  
  private static void d(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 >= 0)
      {
        if (paramInt1 <= paramInt2) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fromIndex: ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" > toIndex: ");
        localStringBuilder.append(paramInt2);
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("toIndex < 0: ");
      localStringBuilder.append(paramInt2);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex < 0: ");
    localStringBuilder.append(paramInt1);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  private void e()
  {
    int i = this.d - 1;
    while ((i >= 0) && (this.c[i] == 0L)) {
      i -= 1;
    }
    this.d = (i + 1);
  }
  
  private static int f(int paramInt)
  {
    return paramInt >> 6;
  }
  
  private void f()
  {
    int i = this.d;
    long[] arrayOfLong = this.c;
    if (i != arrayOfLong.length)
    {
      this.c = Arrays.copyOf(arrayOfLong, i);
      d();
    }
  }
  
  private void g(int paramInt)
  {
    this.c = new long[f(paramInt - 1) + 1];
  }
  
  private void h(int paramInt)
  {
    long[] arrayOfLong = this.c;
    if (arrayOfLong.length < paramInt)
    {
      paramInt = Math.max(arrayOfLong.length * 2, paramInt);
      this.c = Arrays.copyOf(this.c, paramInt);
      this.e = false;
    }
  }
  
  private void i(int paramInt)
  {
    paramInt += 1;
    if (this.d < paramInt)
    {
      h(paramInt);
      this.d = paramInt;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = f(paramInt);
      i(i);
      localObject = this.c;
      localObject[i] |= 1L << paramInt;
      d();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bitIndex < 0: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    d(paramInt1, paramInt2);
    if (paramInt1 == paramInt2) {
      return;
    }
    int i = f(paramInt1);
    int j = f(paramInt2 - 1);
    i(j);
    long l1 = -1L << paramInt1;
    long l2 = -1L >>> -paramInt2;
    long[] arrayOfLong;
    if (i == j)
    {
      arrayOfLong = this.c;
      arrayOfLong[i] = (l2 & l1 | arrayOfLong[i]);
    }
    else
    {
      arrayOfLong = this.c;
      arrayOfLong[i] = (l1 | arrayOfLong[i]);
      paramInt1 = i;
      for (;;)
      {
        paramInt1 += 1;
        if (paramInt1 >= j) {
          break;
        }
        this.c[paramInt1] = -1L;
      }
      arrayOfLong = this.c;
      arrayOfLong[j] = (l2 | arrayOfLong[j]);
    }
    d();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramInt1, paramInt2);
      return;
    }
    b(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramInt);
      return;
    }
    b(paramInt);
  }
  
  public void a(b paramb)
  {
    if (this == paramb) {
      return;
    }
    long[] arrayOfLong;
    for (;;)
    {
      i = this.d;
      if (i <= paramb.d) {
        break;
      }
      arrayOfLong = this.c;
      i -= 1;
      this.d = i;
      arrayOfLong[i] = 0L;
    }
    int i = 0;
    while (i < this.d)
    {
      arrayOfLong = this.c;
      arrayOfLong[i] &= paramb.c[i];
      i += 1;
    }
    e();
    d();
  }
  
  public byte[] a()
  {
    int i = this.d;
    int j = 0;
    if (i == 0) {
      return new byte[0];
    }
    int k = i - 1;
    i = k * 8;
    for (long l = this.c[k]; l != 0L; l >>>= 8) {
      i += 1;
    }
    byte[] arrayOfByte = new byte[i];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
    i = j;
    while (i < k)
    {
      localByteBuffer.putLong(this.c[i]);
      i += 1;
    }
    for (l = this.c[k]; l != 0L; l >>>= 8) {
      localByteBuffer.put((byte)(int)(0xFF & l));
    }
    return arrayOfByte;
  }
  
  public int b()
  {
    int i = this.d;
    if (i == 0) {
      return 0;
    }
    return (i - 1) * 64 + (64 - Long.numberOfLeadingZeros(this.c[(i - 1)]));
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = f(paramInt);
      if (i >= this.d) {
        return;
      }
      localObject = this.c;
      localObject[i] &= 1L << paramInt;
      e();
      d();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bitIndex < 0: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    d(paramInt1, paramInt2);
    if (paramInt1 == paramInt2) {
      return;
    }
    int j = f(paramInt1);
    if (j >= this.d) {
      return;
    }
    int k = f(paramInt2 - 1);
    int i = k;
    if (k >= this.d)
    {
      paramInt2 = b();
      i = this.d - 1;
    }
    long l1 = -1L << paramInt1;
    long l2 = -1L >>> -paramInt2;
    long[] arrayOfLong;
    if (j == i)
    {
      arrayOfLong = this.c;
      arrayOfLong[j] = (l2 & l1 & arrayOfLong[j]);
    }
    else
    {
      arrayOfLong = this.c;
      arrayOfLong[j] = (l1 & arrayOfLong[j]);
      paramInt1 = j;
      for (;;)
      {
        paramInt1 += 1;
        if (paramInt1 >= i) {
          break;
        }
        this.c[paramInt1] = 0L;
      }
      arrayOfLong = this.c;
      arrayOfLong[i] = (l2 & arrayOfLong[i]);
    }
    e();
    d();
  }
  
  public void b(b paramb)
  {
    if (this == paramb) {
      return;
    }
    int j = Math.min(this.d, paramb.d);
    int i = this.d;
    int k = paramb.d;
    if (i < k)
    {
      h(k);
      this.d = paramb.d;
    }
    i = 0;
    while (i < j)
    {
      long[] arrayOfLong = this.c;
      arrayOfLong[i] |= paramb.c[i];
      i += 1;
    }
    if (j < paramb.d) {
      System.arraycopy(paramb.c, j, this.c, j, this.d - j);
    }
    d();
  }
  
  public int c()
  {
    int i = 0;
    int j = 0;
    while (i < this.d)
    {
      j += Long.bitCount(this.c[i]);
      i += 1;
    }
    return j;
  }
  
  public b c(int paramInt1, int paramInt2)
  {
    d(paramInt1, paramInt2);
    d();
    int k = b();
    int j = 0;
    if ((k > paramInt1) && (paramInt1 != paramInt2))
    {
      int i = paramInt2;
      if (paramInt2 > k) {
        i = k;
      }
      paramInt2 = i - paramInt1;
      b localb = new b(paramInt2);
      int m = f(paramInt2 - 1) + 1;
      k = f(paramInt1);
      int n = paramInt1 & 0x3F;
      if (n == 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      int i1;
      long[] arrayOfLong2;
      for (;;)
      {
        i1 = m - 1;
        if (j >= i1) {
          break;
        }
        arrayOfLong1 = localb.c;
        arrayOfLong2 = this.c;
        if (paramInt2 != 0) {
          l1 = arrayOfLong2[k];
        } else {
          l1 = arrayOfLong2[k] >>> paramInt1 | arrayOfLong2[(k + 1)] << -paramInt1;
        }
        arrayOfLong1[j] = l1;
        j += 1;
        k += 1;
      }
      long l1 = -1L >>> -i;
      long[] arrayOfLong1 = localb.c;
      if ((i - 1 & 0x3F) < n)
      {
        arrayOfLong2 = this.c;
        long l2 = arrayOfLong2[k];
        l1 = (arrayOfLong2[(k + 1)] & l1) << -paramInt1 | l2 >>> paramInt1;
      }
      else
      {
        l1 = (this.c[k] & l1) >>> paramInt1;
      }
      arrayOfLong1[i1] = l1;
      localb.d = m;
      localb.e();
      localb.d();
      return localb;
    }
    return new b(0);
  }
  
  public void c(b paramb)
  {
    int j = Math.min(this.d, paramb.d);
    int i = this.d;
    int k = paramb.d;
    if (i < k)
    {
      h(k);
      this.d = paramb.d;
    }
    i = 0;
    while (i < j)
    {
      long[] arrayOfLong = this.c;
      arrayOfLong[i] ^= paramb.c[i];
      i += 1;
    }
    i = paramb.d;
    if (j < i) {
      System.arraycopy(paramb.c, j, this.c, j, i - j);
    }
    e();
    d();
  }
  
  public boolean c(int paramInt)
  {
    if (paramInt >= 0)
    {
      d();
      int i = f(paramInt);
      return (i < this.d) && ((this.c[i] & 1L << paramInt) != 0L);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bitIndex < 0: ");
    localStringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public Object clone()
  {
    if (!this.e) {
      f();
    }
    try
    {
      b localb = (b)super.clone();
      localb.c = ((long[])this.c.clone());
      localb.d();
      return localb;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label39:
      break label39;
    }
    throw new InternalError();
  }
  
  public int d(int paramInt)
  {
    if (paramInt >= 0)
    {
      d();
      int i = f(paramInt);
      if (i >= this.d) {
        return -1;
      }
      long l = this.c[i] & -1L << paramInt;
      paramInt = i;
      for (;;)
      {
        if (l != 0L) {
          return paramInt * 64 + Long.numberOfTrailingZeros(l);
        }
        paramInt += 1;
        if (paramInt == this.d) {
          return -1;
        }
        l = this.c[paramInt];
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex < 0: ");
    localStringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void d(b paramb)
  {
    int i = Math.min(this.d, paramb.d) - 1;
    while (i >= 0)
    {
      long[] arrayOfLong = this.c;
      arrayOfLong[i] &= paramb.c[i];
      i -= 1;
    }
    e();
    d();
  }
  
  public int e(int paramInt)
  {
    if (paramInt >= 0)
    {
      d();
      int i = f(paramInt);
      if (i >= this.d) {
        return paramInt;
      }
      long l = this.c[i] & -1L << paramInt;
      paramInt = i;
      for (;;)
      {
        if (l != 0L) {
          return paramInt * 64 + Long.numberOfTrailingZeros(l);
        }
        paramInt += 1;
        i = this.d;
        if (paramInt == i) {
          return i * 64;
        }
        l = this.c[paramInt];
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex < 0: ");
    localStringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (b)paramObject;
    d();
    paramObject.d();
    if (this.d != paramObject.d) {
      return false;
    }
    int i = 0;
    while (i < this.d)
    {
      if (this.c[i] != paramObject.c[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = this.d;
    for (long l = 1234L;; l ^= this.c[i] * (i + 1))
    {
      i -= 1;
      if (i < 0) {
        break;
      }
    }
    return (int)(l >> 32 ^ l);
  }
  
  public String toString()
  {
    d();
    int i = this.d;
    if (i > 128) {
      i = c();
    } else {
      i *= 64;
    }
    StringBuilder localStringBuilder = new StringBuilder(i * 6 + 2);
    localStringBuilder.append('{');
    int j = d(0);
    if (j != -1)
    {
      localStringBuilder.append(j);
      for (;;)
      {
        i = d(j + 1);
        if (i < 0) {
          break;
        }
        int k = e(i);
        do
        {
          localStringBuilder.append(", ");
          localStringBuilder.append(i);
          j = i + 1;
          i = j;
        } while (j < k);
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.a.b
 * JD-Core Version:    0.7.0.1
 */