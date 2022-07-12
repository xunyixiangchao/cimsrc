package aa;

import a9.f;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class j
  implements x
{
  private final d a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  public j(d paramd, Inflater paramInflater)
  {
    this.a = paramd;
    this.b = paramInflater;
  }
  
  private final void h()
  {
    int i = this.c;
    if (i == 0) {
      return;
    }
    i -= this.b.getRemaining();
    this.c -= i;
    this.a.skip(i);
  }
  
  public final long a(b paramb, long paramLong)
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
      if ((this.d ^ true))
      {
        if (!bool) {
          return 0L;
        }
        try
        {
          s locals = paramb.C0(1);
          i = (int)Math.min(paramLong, 8192 - locals.c);
          g();
          i = this.b.inflate(locals.a, locals.c, i);
          h();
          if (i > 0)
          {
            locals.c += i;
            paramLong = paramb.z0();
            long l = i;
            paramb.y0(paramLong + l);
            return l;
          }
          if (locals.b == locals.c)
          {
            paramb.a = locals.b();
            t.b(locals);
          }
          return 0L;
        }
        catch (DataFormatException paramb)
        {
          throw new IOException(paramb);
        }
      }
      throw new IllegalStateException("closed".toString());
    }
    throw new IllegalArgumentException(f.m("byteCount < 0: ", Long.valueOf(paramLong)).toString());
  }
  
  public y c()
  {
    return this.a.c();
  }
  
  public void close()
  {
    if (this.d) {
      return;
    }
    this.b.end();
    this.d = true;
    this.a.close();
  }
  
  public final boolean g()
  {
    if (!this.b.needsInput()) {
      return false;
    }
    if (this.a.D()) {
      return true;
    }
    s locals = this.a.b().a;
    f.c(locals);
    int j = locals.c;
    int i = locals.b;
    j -= i;
    this.c = j;
    this.b.setInput(locals.a, i, j);
    return false;
  }
  
  public long k(b paramb, long paramLong)
  {
    f.f(paramb, "sink");
    do
    {
      long l = a(paramb, paramLong);
      if (l > 0L) {
        return l;
      }
      if ((this.b.finished()) || (this.b.needsDictionary())) {
        break;
      }
    } while (!this.a.D());
    throw new EOFException("source exhausted prematurely");
    return -1L;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.j
 * JD-Core Version:    0.7.0.1
 */