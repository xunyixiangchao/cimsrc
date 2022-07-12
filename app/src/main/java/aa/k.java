package aa;

import a9.f;
import java.io.IOException;
import java.io.InputStream;

class k
  implements x
{
  private final InputStream a;
  private final y b;
  
  public k(InputStream paramInputStream, y paramy)
  {
    this.a = paramInputStream;
    this.b = paramy;
  }
  
  public y c()
  {
    return this.b;
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public long k(b paramb, long paramLong)
  {
    f.f(paramb, "sink");
    boolean bool = paramLong < 0L;
    if (!bool) {
      return 0L;
    }
    if (!bool) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      try
      {
        this.b.f();
        s locals = paramb.C0(1);
        int i = (int)Math.min(paramLong, 8192 - locals.c);
        i = this.a.read(locals.a, locals.c, i);
        if (i == -1)
        {
          if (locals.b != locals.c) {
            break label198;
          }
          paramb.a = locals.b();
          t.b(locals);
          break label198;
        }
        locals.c += i;
        paramLong = paramb.z0();
        long l = i;
        paramb.y0(paramLong + l);
        return l;
      }
      catch (AssertionError paramb)
      {
        if (l.c(paramb)) {
          throw new IOException(paramb);
        }
        throw paramb;
      }
    } else {
      throw new IllegalArgumentException(f.m("byteCount < 0: ", Long.valueOf(paramLong)).toString());
    }
    label198:
    return -1L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("source(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.k
 * JD-Core Version:    0.7.0.1
 */