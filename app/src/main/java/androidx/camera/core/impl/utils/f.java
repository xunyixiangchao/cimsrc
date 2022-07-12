package androidx.camera.core.impl.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

final class f
{
  static final Charset e = StandardCharsets.US_ASCII;
  static final String[] f = { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
  static final int[] g = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
  static final byte[] h = { 65, 83, 67, 73, 73, 0, 0, 0 };
  public final int a;
  public final int b;
  public final long c;
  public final byte[] d;
  
  f(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong;
    this.d = paramArrayOfByte;
  }
  
  f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this(paramInt1, paramInt2, -1L, paramArrayOfByte);
  }
  
  public static f a(String paramString)
  {
    if ((paramString.length() == 1) && (paramString.charAt(0) >= '0') && (paramString.charAt(0) <= '1')) {
      return new f(1, 1, new byte[] { (byte)(paramString.charAt(0) - '0') });
    }
    paramString = paramString.getBytes(e);
    return new f(1, paramString.length, paramString);
  }
  
  public static f b(double[] paramArrayOfDouble, ByteOrder paramByteOrder)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[g[12] * paramArrayOfDouble.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putDouble(paramArrayOfDouble[i]);
      i += 1;
    }
    return new f(12, paramArrayOfDouble.length, localByteBuffer.array());
  }
  
  public static f c(int[] paramArrayOfInt, ByteOrder paramByteOrder)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[g[9] * paramArrayOfInt.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putInt(paramArrayOfInt[i]);
      i += 1;
    }
    return new f(9, paramArrayOfInt.length, localByteBuffer.array());
  }
  
  public static f d(j[] paramArrayOfj, ByteOrder paramByteOrder)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[g[10] * paramArrayOfj.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfj.length;
    int i = 0;
    while (i < j)
    {
      paramByteOrder = paramArrayOfj[i];
      localByteBuffer.putInt((int)paramByteOrder.b());
      localByteBuffer.putInt((int)paramByteOrder.a());
      i += 1;
    }
    return new f(10, paramArrayOfj.length, localByteBuffer.array());
  }
  
  public static f e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('\000');
    paramString = localStringBuilder.toString().getBytes(e);
    return new f(2, paramString.length, paramString);
  }
  
  public static f f(long paramLong, ByteOrder paramByteOrder)
  {
    return g(new long[] { paramLong }, paramByteOrder);
  }
  
  public static f g(long[] paramArrayOfLong, ByteOrder paramByteOrder)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[g[4] * paramArrayOfLong.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putInt((int)paramArrayOfLong[i]);
      i += 1;
    }
    return new f(4, paramArrayOfLong.length, localByteBuffer.array());
  }
  
  public static f h(j[] paramArrayOfj, ByteOrder paramByteOrder)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[g[5] * paramArrayOfj.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfj.length;
    int i = 0;
    while (i < j)
    {
      paramByteOrder = paramArrayOfj[i];
      localByteBuffer.putInt((int)paramByteOrder.b());
      localByteBuffer.putInt((int)paramByteOrder.a());
      i += 1;
    }
    return new f(5, paramArrayOfj.length, localByteBuffer.array());
  }
  
  public static f i(int[] paramArrayOfInt, ByteOrder paramByteOrder)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[g[3] * paramArrayOfInt.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putShort((short)paramArrayOfInt[i]);
      i += 1;
    }
    return new f(3, paramArrayOfInt.length, localByteBuffer.array());
  }
  
  public int j()
  {
    return g[this.a] * this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(f[this.a]);
    localStringBuilder.append(", data length:");
    localStringBuilder.append(this.d.length);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.f
 * JD-Core Version:    0.7.0.1
 */