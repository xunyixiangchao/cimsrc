package t9;

import a9.f;
import aa.d;
import aa.x;
import aa.y;
import c9.a;
import c9.g;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import m9.l;
import m9.o;

public final class h
  implements Closeable
{
  public static final a e = new a(null);
  private static final Logger f;
  private final d a;
  private final boolean b;
  private final b c;
  private final d.a d;
  
  static
  {
    Logger localLogger = Logger.getLogger(e.class.getName());
    f.e(localLogger, "getLogger(Http2::class.java.name)");
    f = localLogger;
  }
  
  public h(d paramd, boolean paramBoolean)
  {
    this.a = paramd;
    this.b = paramBoolean;
    paramd = new b(paramd);
    this.c = paramd;
    this.d = new d.a(paramd, 4096, 0, 4, null);
  }
  
  private final void B(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 8)
    {
      if (paramInt3 == 0)
      {
        paramInt2 = this.a.readInt();
        paramInt3 = this.a.readInt();
        paramInt1 -= 8;
        b localb = b.b.a(paramInt3);
        if (localb != null)
        {
          aa.e locale = aa.e.e;
          if (paramInt1 > 0) {
            locale = this.a.o(paramInt1);
          }
          paramc.i(paramInt2, localb, locale);
          return;
        }
        throw new IOException(f.m("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(paramInt3)));
      }
      throw new IOException("TYPE_GOAWAY streamId != 0");
    }
    throw new IOException(f.m("TYPE_GOAWAY length < 8: ", Integer.valueOf(paramInt1)));
  }
  
  private final List<c> d0(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.i(paramInt1);
    b localb = this.c;
    localb.B(localb.a());
    this.c.d0(paramInt2);
    this.c.h(paramInt3);
    this.c.e0(paramInt4);
    this.d.k();
    return this.d.e();
  }
  
  private final void e0(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      int i = 0;
      boolean bool;
      if ((paramInt2 & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramInt2 & 0x8) != 0) {
        i = l.b(this.a.readByte(), 255);
      }
      int j = paramInt1;
      if ((paramInt2 & 0x20) != 0)
      {
        g0(paramc, paramInt3);
        j = paramInt1 - 5;
      }
      paramc.f(bool, paramInt3, -1, d0(e.b(j, paramInt2, i), i, paramInt2, paramInt3));
      return;
    }
    throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
  }
  
  private final void f0(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 8)
    {
      if (paramInt3 == 0)
      {
        paramInt1 = this.a.readInt();
        paramInt3 = this.a.readInt();
        boolean bool = true;
        if ((paramInt2 & 0x1) == 0) {
          bool = false;
        }
        paramc.d(bool, paramInt1, paramInt3);
        return;
      }
      throw new IOException("TYPE_PING streamId != 0");
    }
    throw new IOException(f.m("TYPE_PING length != 8: ", Integer.valueOf(paramInt1)));
  }
  
  private final void g0(c paramc, int paramInt)
  {
    int i = this.a.readInt();
    boolean bool;
    if ((0x80000000 & i) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramc.e(paramInt, i & 0x7FFFFFFF, l.b(this.a.readByte(), 255) + 1, bool);
  }
  
  private final void h0(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 5)
    {
      if (paramInt3 != 0)
      {
        g0(paramc, paramInt3);
        return;
      }
      throw new IOException("TYPE_PRIORITY streamId == 0");
    }
    paramc = new StringBuilder();
    paramc.append("TYPE_PRIORITY length: ");
    paramc.append(paramInt1);
    paramc.append(" != 5");
    throw new IOException(paramc.toString());
  }
  
  private final void i(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      int j = 0;
      int i = 1;
      boolean bool;
      if ((paramInt2 & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramInt2 & 0x20) == 0) {
        i = 0;
      }
      if (i == 0)
      {
        i = j;
        if ((paramInt2 & 0x8) != 0) {
          i = l.b(this.a.readByte(), 255);
        }
        paramInt1 = e.b(paramInt1, paramInt2, i);
        paramc.k(bool, paramInt3, this.a, paramInt1);
        this.a.skip(i);
        return;
      }
      throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
    }
    throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
  }
  
  private final void i0(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      int i;
      if ((paramInt2 & 0x8) != 0) {
        i = l.b(this.a.readByte(), 255);
      } else {
        i = 0;
      }
      paramc.j(paramInt3, this.a.readInt() & 0x7FFFFFFF, d0(e.b(paramInt1 - 4, paramInt2, i), i, paramInt2, paramInt3));
      return;
    }
    throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
  }
  
  private final void j0(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 4)
    {
      if (paramInt3 != 0)
      {
        paramInt1 = this.a.readInt();
        b localb = b.b.a(paramInt1);
        if (localb != null)
        {
          paramc.g(paramInt3, localb);
          return;
        }
        throw new IOException(f.m("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(paramInt1)));
      }
      throw new IOException("TYPE_RST_STREAM streamId == 0");
    }
    paramc = new StringBuilder();
    paramc.append("TYPE_RST_STREAM length: ");
    paramc.append(paramInt1);
    paramc.append(" != 4");
    throw new IOException(paramc.toString());
  }
  
  private final void k0(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      if ((paramInt2 & 0x1) != 0)
      {
        if (paramInt1 == 0)
        {
          paramc.c();
          return;
        }
        throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
      }
      if (paramInt1 % 6 == 0)
      {
        m localm = new m();
        a locala = g.h(g.i(0, paramInt1), 6);
        paramInt1 = locala.a();
        int i = locala.b();
        int j = locala.c();
        if (j > 0)
        {
          paramInt2 = paramInt1;
          if (paramInt1 <= i) {}
        }
        else
        {
          if ((j >= 0) || (i > paramInt1)) {
            break label289;
          }
          paramInt2 = paramInt1;
        }
        for (;;)
        {
          paramInt3 = l.c(this.a.readShort(), 65535);
          int k = this.a.readInt();
          if (paramInt3 != 2)
          {
            if (paramInt3 != 3)
            {
              if (paramInt3 != 4)
              {
                if (paramInt3 != 5) {
                  paramInt1 = paramInt3;
                } else if ((k >= 16384) && (k <= 16777215)) {
                  paramInt1 = paramInt3;
                } else {
                  throw new IOException(f.m("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", Integer.valueOf(k)));
                }
              }
              else
              {
                paramInt1 = 7;
                if (k < 0) {
                  throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                }
              }
            }
            else {
              paramInt1 = 4;
            }
          }
          else
          {
            paramInt1 = paramInt3;
            if (k != 0) {
              if (k == 1) {
                paramInt1 = paramInt3;
              } else {
                throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
              }
            }
          }
          localm.h(paramInt1, k);
          if (paramInt2 == i) {
            break;
          }
          paramInt2 += j;
        }
        label289:
        paramc.a(false, localm);
        return;
      }
      throw new IOException(f.m("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(paramInt1)));
    }
    throw new IOException("TYPE_SETTINGS streamId != 0");
  }
  
  private final void l0(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 4)
    {
      long l = l.d(this.a.readInt(), 2147483647L);
      if (l != 0L)
      {
        paramc.h(paramInt3, l);
        return;
      }
      throw new IOException("windowSizeIncrement was 0");
    }
    throw new IOException(f.m("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(paramInt1)));
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public final boolean g(boolean paramBoolean, c paramc)
  {
    f.f(paramc, "handler");
    try
    {
      this.a.U(9L);
      int i = l.A(this.a);
      if (i <= 16384)
      {
        int j = l.b(this.a.readByte(), 255);
        int k = l.b(this.a.readByte(), 255);
        int m = this.a.readInt() & 0x7FFFFFFF;
        Logger localLogger = f;
        if (localLogger.isLoggable(Level.FINE)) {
          localLogger.fine(e.a.c(true, m, i, j, k));
        }
        if ((paramBoolean) && (j != 4)) {
          throw new IOException(f.m("Expected a SETTINGS frame but was ", e.a.b(j)));
        }
        switch (j)
        {
        default: 
          this.a.skip(i);
          break;
        case 8: 
          l0(paramc, i, k, m);
          break;
        case 7: 
          B(paramc, i, k, m);
          break;
        case 6: 
          f0(paramc, i, k, m);
          break;
        case 5: 
          i0(paramc, i, k, m);
          break;
        case 4: 
          k0(paramc, i, k, m);
          break;
        case 3: 
          j0(paramc, i, k, m);
          break;
        case 2: 
          h0(paramc, i, k, m);
          break;
        case 1: 
          e0(paramc, i, k, m);
          break;
        case 0: 
          i(paramc, i, k, m);
        }
        return true;
      }
      throw new IOException(f.m("FRAME_SIZE_ERROR: ", Integer.valueOf(i)));
    }
    catch (EOFException paramc)
    {
      label352:
      break label352;
    }
    return false;
  }
  
  public final void h(c paramc)
  {
    f.f(paramc, "handler");
    if (this.b)
    {
      if (g(true, paramc)) {
        return;
      }
      throw new IOException("Required SETTINGS preface not received");
    }
    Object localObject = this.a;
    paramc = e.b;
    localObject = ((d)localObject).o(paramc.r());
    Logger localLogger = f;
    if (localLogger.isLoggable(Level.FINE)) {
      localLogger.fine(o.i(f.m("<< CONNECTION ", ((aa.e)localObject).i()), new Object[0]));
    }
    if (f.a(paramc, localObject)) {
      return;
    }
    throw new IOException(f.m("Expected a connection header but was ", ((aa.e)localObject).u()));
  }
  
  public static final class a
  {
    public final Logger a()
    {
      return h.a();
    }
    
    public final int b(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = paramInt1;
      if ((paramInt2 & 0x8) != 0) {
        i = paramInt1 - 1;
      }
      if (paramInt3 <= i) {
        return i - paramInt3;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PROTOCOL_ERROR padding ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" > remaining length ");
      localStringBuilder.append(i);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public static final class b
    implements x
  {
    private final d a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    
    public b(d paramd)
    {
      this.a = paramd;
    }
    
    private final void g()
    {
      int i = this.d;
      int j = l.A(this.a);
      this.e = j;
      this.b = j;
      j = l.b(this.a.readByte(), 255);
      this.c = l.b(this.a.readByte(), 255);
      Object localObject = h.e;
      if (((h.a)localObject).a().isLoggable(Level.FINE)) {
        ((h.a)localObject).a().fine(e.a.c(true, this.d, this.b, j, this.c));
      }
      int k = this.a.readInt() & 0x7FFFFFFF;
      this.d = k;
      if (j == 9)
      {
        if (k == i) {
          return;
        }
        throw new IOException("TYPE_CONTINUATION streamId changed");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" != TYPE_CONTINUATION");
      throw new IOException(((StringBuilder)localObject).toString());
    }
    
    public final void B(int paramInt)
    {
      this.b = paramInt;
    }
    
    public final int a()
    {
      return this.e;
    }
    
    public y c()
    {
      return this.a.c();
    }
    
    public void close() {}
    
    public final void d0(int paramInt)
    {
      this.f = paramInt;
    }
    
    public final void e0(int paramInt)
    {
      this.d = paramInt;
    }
    
    public final void h(int paramInt)
    {
      this.c = paramInt;
    }
    
    public final void i(int paramInt)
    {
      this.e = paramInt;
    }
    
    public long k(aa.b paramb, long paramLong)
    {
      f.f(paramb, "sink");
      int i;
      for (;;)
      {
        i = this.e;
        if (i != 0) {
          break;
        }
        this.a.skip(this.f);
        this.f = 0;
        if ((this.c & 0x4) != 0) {
          return -1L;
        }
        g();
      }
      paramLong = this.a.k(paramb, Math.min(paramLong, i));
      if (paramLong == -1L) {
        return -1L;
      }
      this.e -= (int)paramLong;
      return paramLong;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, m paramm);
    
    public abstract void c();
    
    public abstract void d(boolean paramBoolean, int paramInt1, int paramInt2);
    
    public abstract void e(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
    
    public abstract void f(boolean paramBoolean, int paramInt1, int paramInt2, List<c> paramList);
    
    public abstract void g(int paramInt, b paramb);
    
    public abstract void h(int paramInt, long paramLong);
    
    public abstract void i(int paramInt, b paramb, aa.e parame);
    
    public abstract void j(int paramInt1, int paramInt2, List<c> paramList);
    
    public abstract void k(boolean paramBoolean, int paramInt1, d paramd, int paramInt2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.h
 * JD-Core Version:    0.7.0.1
 */