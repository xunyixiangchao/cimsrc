package t9;

import a9.f;
import aa.v;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import m9.l;
import m9.o;

public final class j
  implements Closeable
{
  public static final a g = new a(null);
  private static final Logger h = Logger.getLogger(e.class.getName());
  private final aa.c a;
  private final boolean b;
  private final aa.b c;
  private int d;
  private boolean e;
  private final d.b f;
  
  public j(aa.c paramc, boolean paramBoolean)
  {
    this.a = paramc;
    this.b = paramBoolean;
    paramc = new aa.b();
    this.c = paramc;
    this.d = 16384;
    this.f = new d.b(0, false, paramc, 3, null);
  }
  
  private final void l0(int paramInt, long paramLong)
  {
    while (paramLong > 0L)
    {
      long l = Math.min(this.d, paramLong);
      paramLong -= l;
      int j = (int)l;
      int i;
      if (paramLong == 0L) {
        i = 4;
      } else {
        i = 0;
      }
      B(paramInt, j, 9, i);
      this.a.L(this.c, l);
    }
  }
  
  public final void B(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = h;
    if (((Logger)localObject).isLoggable(Level.FINE)) {
      ((Logger)localObject).fine(e.a.c(false, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    int i = this.d;
    int j = 1;
    if (paramInt2 <= i) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((0x80000000 & paramInt1) == 0) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        l.H(this.a, paramInt2);
        this.a.F(paramInt3 & 0xFF);
        this.a.F(paramInt4 & 0xFF);
        this.a.w(paramInt1 & 0x7FFFFFFF);
        return;
      }
      throw new IllegalArgumentException(f.m("reserved bit set: ", Integer.valueOf(paramInt1)).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FRAME_SIZE_ERROR length > ");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(paramInt2);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
  }
  
  public final void a(m paramm)
  {
    try
    {
      f.f(paramm, "peerSettings");
      if (!this.e)
      {
        this.d = paramm.e(this.d);
        if (paramm.b() != -1) {
          this.f.e(paramm.b());
        }
        B(0, 0, 4, 1);
        this.a.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void close()
  {
    try
    {
      this.e = true;
      this.a.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void d0(int paramInt, b paramb, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        f.f(paramb, "errorCode");
        f.f(paramArrayOfByte, "debugData");
        if (!this.e)
        {
          i = paramb.b();
          int j = 0;
          if (i != -1)
          {
            i = 1;
            if (i != 0)
            {
              B(0, paramArrayOfByte.length + 8, 7, 0);
              this.a.w(paramInt);
              this.a.w(paramb.b());
              paramInt = j;
              if (paramArrayOfByte.length == 0) {
                paramInt = 1;
              }
              if ((paramInt ^ 0x1) != 0) {
                this.a.K(paramArrayOfByte);
              }
              this.a.flush();
              return;
            }
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
          }
        }
        else
        {
          throw new IOException("closed");
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public final void e0(boolean paramBoolean, int paramInt, List<c> paramList)
  {
    for (;;)
    {
      try
      {
        f.f(paramList, "headerBlock");
        if (!this.e)
        {
          this.f.g(paramList);
          long l1 = this.c.z0();
          long l2 = Math.min(this.d, l1);
          boolean bool = l1 < l2;
          if (!bool)
          {
            i = 4;
            break label124;
            B(paramInt, (int)l2, 1, j);
            this.a.L(this.c, l2);
            if (bool) {
              l0(paramInt, l1 - l2);
            }
          }
        }
        else
        {
          throw new IOException("closed");
        }
      }
      finally {}
      int i = 0;
      label124:
      int j = i;
      if (paramBoolean) {
        j = i | 0x1;
      }
    }
  }
  
  public final int f0()
  {
    return this.d;
  }
  
  public final void flush()
  {
    try
    {
      if (!this.e)
      {
        this.a.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public final void g()
  {
    try
    {
      if (!this.e)
      {
        boolean bool = this.b;
        if (!bool) {
          return;
        }
        Logger localLogger = h;
        if (localLogger.isLoggable(Level.FINE)) {
          localLogger.fine(o.i(f.m(">> CONNECTION ", e.b.i()), new Object[0]));
        }
        this.a.Y(e.b);
        this.a.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public final void g0(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if (!this.e)
        {
          if (paramBoolean)
          {
            i = 1;
            B(0, 8, 6, i);
            this.a.w(paramInt1);
            this.a.w(paramInt2);
            this.a.flush();
          }
        }
        else {
          throw new IOException("closed");
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public final void h(boolean paramBoolean, int paramInt1, aa.b paramb, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void h0(int paramInt1, int paramInt2, List<c> paramList)
  {
    for (;;)
    {
      try
      {
        f.f(paramList, "requestHeaders");
        if (!this.e)
        {
          this.f.g(paramList);
          long l1 = this.c.z0();
          int j = (int)Math.min(this.d - 4L, l1);
          long l2 = j;
          boolean bool = l1 < l2;
          if (!bool)
          {
            i = 4;
            B(paramInt1, j + 4, 5, i);
            this.a.w(paramInt2 & 0x7FFFFFFF);
            this.a.L(this.c, l2);
            if (bool) {
              l0(paramInt1, l1 - l2);
            }
          }
        }
        else
        {
          throw new IOException("closed");
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public final void i(int paramInt1, int paramInt2, aa.b paramb, int paramInt3)
  {
    B(paramInt1, paramInt3, 0, paramInt2);
    if (paramInt3 > 0)
    {
      aa.c localc = this.a;
      f.c(paramb);
      localc.L(paramb, paramInt3);
    }
  }
  
  public final void i0(int paramInt, b paramb)
  {
    for (;;)
    {
      try
      {
        f.f(paramb, "errorCode");
        if (!this.e)
        {
          if (paramb.b() != -1)
          {
            i = 1;
            if (i != 0)
            {
              B(paramInt, 4, 3, 0);
              this.a.w(paramb.b());
              this.a.flush();
              return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
          }
        }
        else {
          throw new IOException("closed");
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public final void j0(m paramm)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        f.f(paramm, "settings");
        if (!this.e)
        {
          j = paramm.i();
          i = 0;
          B(0, j * 6, 4, 0);
          if (i < 10)
          {
            if (!paramm.f(i))
            {
              break label133;
              this.a.s(j);
              this.a.w(paramm.a(i));
            }
          }
          else {
            this.a.flush();
          }
        }
        else
        {
          throw new IOException("closed");
        }
      }
      finally {}
      if (i != 4)
      {
        if (i != 7) {
          j = i;
        } else {
          j = 4;
        }
      }
      else
      {
        j = 3;
        continue;
        label133:
        i += 1;
      }
    }
  }
  
  public final void k0(int paramInt, long paramLong)
  {
    for (;;)
    {
      try
      {
        if (!this.e)
        {
          if ((paramLong != 0L) && (paramLong <= 2147483647L))
          {
            i = 1;
            if (i != 0)
            {
              B(paramInt, 4, 8, 0);
              this.a.w((int)paramLong);
              this.a.flush();
              return;
            }
            throw new IllegalArgumentException(f.m("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", Long.valueOf(paramLong)).toString());
          }
        }
        else {
          throw new IOException("closed");
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.j
 * JD-Core Version:    0.7.0.1
 */