package r9;

import a9.f;
import java.util.List;
import l9.d0;
import l9.e;
import l9.f0;
import l9.j;
import l9.y;
import l9.y.a;
import q9.c;
import q9.d;
import q9.h;
import q9.n;

public final class g
  implements y.a
{
  private final h a;
  private final List<y> b;
  private final int c;
  private final c d;
  private final d0 e;
  private final int f;
  private final int g;
  private final int h;
  private int i;
  
  public g(h paramh, List<? extends y> paramList, int paramInt1, c paramc, d0 paramd0, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramh;
    this.b = paramList;
    this.c = paramInt1;
    this.d = paramc;
    this.e = paramd0;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
  }
  
  public f0 a(d0 paramd0)
  {
    f.f(paramd0, "request");
    int j = this.c;
    int m = this.b.size();
    int k = 0;
    if (j < m) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      this.i += 1;
      Object localObject = this.d;
      if (localObject != null) {
        if (((c)localObject).j().b().d(paramd0.j()))
        {
          if (this.i == 1) {
            j = 1;
          } else {
            j = 0;
          }
          if (j == 0)
          {
            paramd0 = new StringBuilder();
            paramd0.append("network interceptor ");
            paramd0.append(this.b.get(this.c - 1));
            paramd0.append(" must call proceed() exactly once");
            throw new IllegalStateException(paramd0.toString().toString());
          }
        }
        else
        {
          paramd0 = new StringBuilder();
          paramd0.append("network interceptor ");
          paramd0.append(this.b.get(this.c - 1));
          paramd0.append(" must retain the same host and port");
          throw new IllegalStateException(paramd0.toString().toString());
        }
      }
      localObject = d(this, this.c + 1, null, paramd0, 0, 0, 0, 58, null);
      paramd0 = (y)this.b.get(this.c);
      f0 localf0 = paramd0.a((y.a)localObject);
      if (localf0 != null)
      {
        if (this.d != null)
        {
          if ((this.c + 1 < this.b.size()) && (((g)localObject).i != 1)) {
            j = 0;
          } else {
            j = 1;
          }
          if (j == 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("network interceptor ");
            ((StringBuilder)localObject).append(paramd0);
            ((StringBuilder)localObject).append(" must call proceed() exactly once");
            throw new IllegalStateException(((StringBuilder)localObject).toString().toString());
          }
        }
        j = k;
        if (localf0.a() != null) {
          j = 1;
        }
        if (j != 0) {
          return localf0;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("interceptor ");
        ((StringBuilder)localObject).append(paramd0);
        ((StringBuilder)localObject).append(" returned a response with no body");
        throw new IllegalStateException(((StringBuilder)localObject).toString().toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("interceptor ");
      ((StringBuilder)localObject).append(paramd0);
      ((StringBuilder)localObject).append(" returned null");
      throw new NullPointerException(((StringBuilder)localObject).toString());
    }
    throw new IllegalStateException("Check failed.".toString());
  }
  
  public j b()
  {
    c localc = this.d;
    if (localc == null) {
      return null;
    }
    return localc.h();
  }
  
  public final g c(int paramInt1, c paramc, d0 paramd0, int paramInt2, int paramInt3, int paramInt4)
  {
    f.f(paramd0, "request");
    return new g(this.a, this.b, paramInt1, paramc, paramd0, paramInt2, paramInt3, paramInt4);
  }
  
  public e call()
  {
    return this.a;
  }
  
  public final h e()
  {
    return this.a;
  }
  
  public final c f()
  {
    return this.d;
  }
  
  public final int g()
  {
    return this.g;
  }
  
  public d0 h()
  {
    return this.e;
  }
  
  public final d0 i()
  {
    return this.e;
  }
  
  public final int j()
  {
    return this.h;
  }
  
  public int k()
  {
    return this.g;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r9.g
 * JD-Core Version:    0.7.0.1
 */