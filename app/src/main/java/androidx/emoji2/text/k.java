package androidx.emoji2.text;

import f1.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class k
{
  private static b a(c paramc)
  {
    paramc.a(4);
    int k = paramc.readUnsignedShort();
    if (k <= 100)
    {
      paramc.a(6);
      int j = 0;
      int i = 0;
      while (i < k)
      {
        int m = paramc.c();
        paramc.a(4);
        l1 = paramc.b();
        paramc.a(4);
        if (1835365473 == m) {
          break label89;
        }
        i += 1;
      }
      long l1 = -1L;
      label89:
      if (l1 != -1L)
      {
        paramc.a((int)(l1 - paramc.getPosition()));
        paramc.a(12);
        long l2 = paramc.b();
        i = j;
        while (i < l2)
        {
          j = paramc.c();
          long l3 = paramc.b();
          long l4 = paramc.b();
          if ((1164798569 != j) && (1701669481 != j)) {
            i += 1;
          } else {
            return new b(l3 + l1, l4);
          }
        }
      }
      throw new IOException("Cannot read metadata.");
    }
    throw new IOException("Cannot read metadata.");
  }
  
  static b b(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = paramByteBuffer.duplicate();
    paramByteBuffer.position((int)a(new a(paramByteBuffer)).a());
    return b.h(paramByteBuffer);
  }
  
  static long c(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  static int d(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  private static class a
    implements k.c
  {
    private final ByteBuffer a;
    
    a(ByteBuffer paramByteBuffer)
    {
      this.a = paramByteBuffer;
      paramByteBuffer.order(ByteOrder.BIG_ENDIAN);
    }
    
    public void a(int paramInt)
    {
      ByteBuffer localByteBuffer = this.a;
      localByteBuffer.position(localByteBuffer.position() + paramInt);
    }
    
    public long b()
    {
      return k.c(this.a.getInt());
    }
    
    public int c()
    {
      return this.a.getInt();
    }
    
    public long getPosition()
    {
      return this.a.position();
    }
    
    public int readUnsignedShort()
    {
      return k.d(this.a.getShort());
    }
  }
  
  private static class b
  {
    private final long a;
    private final long b;
    
    b(long paramLong1, long paramLong2)
    {
      this.a = paramLong1;
      this.b = paramLong2;
    }
    
    long a()
    {
      return this.a;
    }
  }
  
  private static abstract interface c
  {
    public abstract void a(int paramInt);
    
    public abstract long b();
    
    public abstract int c();
    
    public abstract long getPosition();
    
    public abstract int readUnsignedShort();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.emoji2.text.k
 * JD-Core Version:    0.7.0.1
 */