package androidx.camera.core.impl.utils;

import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
  extends FilterOutputStream
{
  private static final byte[] g = "".getBytes(f.e);
  private final g a;
  private final byte[] b = new byte[1];
  private final ByteBuffer c = ByteBuffer.allocate(4);
  private int d = 0;
  private int e;
  private int f;
  
  public h(OutputStream paramOutputStream, g paramg)
  {
    super(new BufferedOutputStream(paramOutputStream, 65536));
    this.a = paramg;
  }
  
  private int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt1 = Math.min(paramInt3, paramInt1 - this.c.position());
    this.c.put(paramArrayOfByte, paramInt2, paramInt1);
    return paramInt1;
  }
  
  private void g(a parama)
  {
    Object localObject1 = g.i;
    int[] arrayOfInt = new int[localObject1.length];
    localObject1 = new int[localObject1.length];
    Object localObject2 = g.g;
    int k = localObject2.length;
    int i = 0;
    i locali;
    while (i < k)
    {
      locali = localObject2[i];
      j = 0;
      while (j < g.i.length)
      {
        this.a.b(j).remove(locali.b);
        j += 1;
      }
      i += 1;
    }
    if (!this.a.b(1).isEmpty()) {
      this.a.b(0).put(g.g[1].b, f.f(0L, this.a.c()));
    }
    if (!this.a.b(2).isEmpty()) {
      this.a.b(0).put(g.g[2].b, f.f(0L, this.a.c()));
    }
    if (!this.a.b(3).isEmpty()) {
      this.a.b(1).put(g.g[3].b, f.f(0L, this.a.c()));
    }
    i = 0;
    while (i < g.i.length)
    {
      localObject2 = this.a.b(i).entrySet().iterator();
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        k = ((f)((Map.Entry)((Iterator)localObject2).next()).getValue()).j();
        if (k > 4) {
          j += k;
        }
      }
      localObject1[i] += j;
      i += 1;
    }
    int j = 8;
    i = 0;
    while (i < g.i.length)
    {
      k = j;
      if (!this.a.b(i).isEmpty())
      {
        arrayOfInt[i] = j;
        k = j + (this.a.b(i).size() * 12 + 2 + 4 + localObject1[i]);
      }
      i += 1;
      j = k;
    }
    if (!this.a.b(1).isEmpty()) {
      this.a.b(0).put(g.g[1].b, f.f(arrayOfInt[1], this.a.c()));
    }
    if (!this.a.b(2).isEmpty()) {
      this.a.b(0).put(g.g[2].b, f.f(arrayOfInt[2], this.a.c()));
    }
    if (!this.a.b(3).isEmpty()) {
      this.a.b(1).put(g.g[3].b, f.f(arrayOfInt[3], this.a.c()));
    }
    parama.d0(j + 8);
    parama.write(g);
    short s;
    if (this.a.c() == ByteOrder.BIG_ENDIAN) {
      s = 19789;
    } else {
      s = 18761;
    }
    parama.i(s);
    parama.a(this.a.c());
    parama.d0(42);
    parama.B(8L);
    i = 0;
    while (i < g.i.length)
    {
      if (!this.a.b(i).isEmpty())
      {
        parama.d0(this.a.b(i).size());
        j = arrayOfInt[i] + 2 + this.a.b(i).size() * 12 + 4;
        localObject1 = this.a.b(i).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          locali = (i)((HashMap)g.b.f.get(i)).get(((Map.Entry)localObject2).getKey());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Tag not supported: ");
          localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
          localStringBuilder.append(". Tag needs to be ported from ExifInterface to ExifData.");
          int m = ((i)x0.h.h(locali, localStringBuilder.toString())).a;
          localObject2 = (f)((Map.Entry)localObject2).getValue();
          k = ((f)localObject2).j();
          parama.d0(m);
          parama.d0(((f)localObject2).a);
          parama.h(((f)localObject2).b);
          if (k > 4)
          {
            parama.B(j);
            j += k;
          }
          else
          {
            parama.write(((f)localObject2).d);
            if (k < 4) {
              while (k < 4)
              {
                parama.g(0);
                k += 1;
              }
            }
          }
        }
        parama.B(0L);
        localObject1 = this.a.b(i).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((f)((Map.Entry)((Iterator)localObject1).next()).getValue()).d;
          if (localObject2.length > 4) {
            parama.write((byte[])localObject2, 0, localObject2.length);
          }
        }
      }
      i += 1;
    }
    parama.a(ByteOrder.BIG_ENDIAN);
  }
  
  public void write(int paramInt)
  {
    byte[] arrayOfByte = this.b;
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    write(arrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int k = this.e;
      if (((k <= 0) && (this.f <= 0) && (this.d == 2)) || (paramInt2 <= 0)) {
        break label477;
      }
      int i = paramInt1;
      int j = paramInt2;
      if (k > 0)
      {
        i = Math.min(paramInt2, k);
        j = paramInt2 - i;
        this.e -= i;
        i = paramInt1 + i;
      }
      k = this.f;
      paramInt1 = i;
      paramInt2 = j;
      if (k > 0)
      {
        paramInt1 = Math.min(j, k);
        this.out.write(paramArrayOfByte, i, paramInt1);
        paramInt2 = j - paramInt1;
        this.f -= paramInt1;
        paramInt1 = i + paramInt1;
      }
      if (paramInt2 == 0) {
        return;
      }
      i = this.d;
      if (i != 0)
      {
        if (i == 1)
        {
          i = a(4, paramArrayOfByte, paramInt1, paramInt2);
          paramInt1 += i;
          paramInt2 -= i;
          if ((this.c.position() == 2) && (this.c.getShort() == -39))
          {
            this.out.write(this.c.array(), 0, 2);
            this.c.rewind();
          }
          if (this.c.position() < 4) {
            return;
          }
          this.c.rewind();
          short s = this.c.getShort();
          if (s == -31) {
            this.e = ((this.c.getShort() & 0xFFFF) - 2);
          }
          for (;;)
          {
            this.d = 2;
            break;
            if (!a.a(s))
            {
              this.out.write(this.c.array(), 0, 4);
              this.f = ((this.c.getShort() & 0xFFFF) - 2);
              break;
            }
            this.out.write(this.c.array(), 0, 4);
          }
          this.c.rewind();
        }
      }
      else
      {
        i = a(2, paramArrayOfByte, paramInt1, paramInt2);
        paramInt1 += i;
        paramInt2 -= i;
        if (this.c.position() < 2) {
          return;
        }
        this.c.rewind();
        if (this.c.getShort() != -40) {
          break;
        }
        this.out.write(this.c.array(), 0, 2);
        this.d = 1;
        this.c.rewind();
        a locala = new a(this.out, ByteOrder.BIG_ENDIAN);
        locala.i((short)-31);
        g(locala);
      }
    }
    throw new IOException("Not a valid jpeg image, cannot write exif");
    label477:
    if (paramInt2 > 0) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  static final class a
  {
    public static boolean a(short paramShort)
    {
      return (paramShort >= -64) && (paramShort <= -49) && (paramShort != -60) && (paramShort != -56) && (paramShort != -52);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.h
 * JD-Core Version:    0.7.0.1
 */