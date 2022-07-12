package aa;

import a9.f;
import java.nio.ByteBuffer;

public final class q
  implements c
{
  public final v a;
  public final b b;
  public boolean c;
  
  public q(v paramv)
  {
    this.a = paramv;
    this.b = new b();
  }
  
  public c F(int paramInt)
  {
    if ((this.c ^ true))
    {
      this.b.H0(paramInt);
      return a();
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public c K(byte[] paramArrayOfByte)
  {
    f.f(paramArrayOfByte, "source");
    if ((this.c ^ true))
    {
      this.b.E0(paramArrayOfByte);
      return a();
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public void L(b paramb, long paramLong)
  {
    f.f(paramb, "source");
    if ((this.c ^ true))
    {
      this.b.L(paramb, paramLong);
      a();
      return;
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public c V(String paramString)
  {
    f.f(paramString, "string");
    if ((this.c ^ true))
    {
      this.b.N0(paramString);
      return a();
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public c W(long paramLong)
  {
    if ((this.c ^ true))
    {
      this.b.I0(paramLong);
      return a();
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public c Y(e parame)
  {
    f.f(parame, "byteString");
    if ((this.c ^ true))
    {
      this.b.D0(parame);
      return a();
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public c a()
  {
    if ((this.c ^ true))
    {
      long l = this.b.f0();
      if (l > 0L) {
        this.a.L(this.b, l);
      }
      return this;
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public b b()
  {
    return this.b;
  }
  
  public y c()
  {
    return this.a.c();
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	aa/q:c	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_2
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 32	aa/q:b	Laa/b;
    //   16: invokevirtual 104	aa/b:z0	()J
    //   19: lconst_0
    //   20: lcmp
    //   21: ifle +30 -> 51
    //   24: aload_0
    //   25: getfield 27	aa/q:a	Laa/v;
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 32	aa/q:b	Laa/b;
    //   33: astore_3
    //   34: aload_1
    //   35: aload_3
    //   36: aload_3
    //   37: invokevirtual 104	aa/b:z0	()J
    //   40: invokeinterface 96 4 0
    //   45: aload_2
    //   46: astore_1
    //   47: goto +4 -> 51
    //   50: astore_1
    //   51: aload_0
    //   52: getfield 27	aa/q:a	Laa/v;
    //   55: invokeinterface 106 1 0
    //   60: aload_1
    //   61: astore_2
    //   62: goto +12 -> 74
    //   65: astore_3
    //   66: aload_1
    //   67: astore_2
    //   68: aload_1
    //   69: ifnonnull +5 -> 74
    //   72: aload_3
    //   73: astore_2
    //   74: aload_0
    //   75: iconst_1
    //   76: putfield 37	aa/q:c	Z
    //   79: aload_2
    //   80: ifnonnull +4 -> 84
    //   83: return
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	q
    //   11	36	1	localObject1	Object
    //   50	19	1	localObject2	Object
    //   9	76	2	localObject3	Object
    //   33	4	3	localb	b
    //   65	8	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   12	45	50	finally
    //   51	60	65	finally
  }
  
  public c d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    f.f(paramArrayOfByte, "source");
    if ((this.c ^ true))
    {
      this.b.F0(paramArrayOfByte, paramInt1, paramInt2);
      return a();
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public void flush()
  {
    if ((this.c ^ true))
    {
      if (this.b.z0() > 0L)
      {
        v localv = this.a;
        b localb = this.b;
        localv.L(localb, localb.z0());
      }
      this.a.flush();
      return;
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public boolean isOpen()
  {
    return this.c ^ true;
  }
  
  public c l(long paramLong)
  {
    if ((this.c ^ true))
    {
      this.b.J0(paramLong);
      return a();
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public c s(int paramInt)
  {
    if ((this.c ^ true))
    {
      this.b.L0(paramInt);
      return a();
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public c w(int paramInt)
  {
    if ((this.c ^ true))
    {
      this.b.K0(paramInt);
      return a();
    }
    throw new IllegalStateException("closed".toString());
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    f.f(paramByteBuffer, "source");
    if ((this.c ^ true))
    {
      int i = this.b.write(paramByteBuffer);
      a();
      return i;
    }
    throw new IllegalStateException("closed".toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.q
 * JD-Core Version:    0.7.0.1
 */