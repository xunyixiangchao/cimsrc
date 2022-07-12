package y7;

import b8.c;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import v7.i;
import v7.l;
import v7.n;
import v7.o;
import v7.q;

public final class f
  extends c
{
  private static final Writer o = new a();
  private static final q p = new q("closed");
  private final List<l> l = new ArrayList();
  private String m;
  private l n = n.a;
  
  public f()
  {
    super(o);
  }
  
  private l B0()
  {
    List localList = this.l;
    return (l)localList.get(localList.size() - 1);
  }
  
  private void C0(l paraml)
  {
    if (this.m != null)
    {
      if ((!paraml.e()) || (f0())) {
        ((o)B0()).h(this.m, paraml);
      }
      this.m = null;
      return;
    }
    if (this.l.isEmpty())
    {
      this.n = paraml;
      return;
    }
    l locall = B0();
    if ((locall instanceof i))
    {
      ((i)locall).h(paraml);
      return;
    }
    throw new IllegalStateException();
  }
  
  public l A0()
  {
    if (this.l.isEmpty()) {
      return this.n;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected one JSON element but was ");
    localStringBuilder.append(this.l);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void close()
  {
    if (this.l.isEmpty())
    {
      this.l.add(p);
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public c d0()
  {
    if ((!this.l.isEmpty()) && (this.m == null))
    {
      if ((B0() instanceof i))
      {
        List localList = this.l;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public c e0()
  {
    if ((!this.l.isEmpty()) && (this.m == null))
    {
      if ((B0() instanceof o))
      {
        List localList = this.l;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public void flush() {}
  
  public c h()
  {
    i locali = new i();
    C0(locali);
    this.l.add(locali);
    return this;
  }
  
  public c i()
  {
    o localo = new o();
    C0(localo);
    this.l.add(localo);
    return this;
  }
  
  public c i0(String paramString)
  {
    if ((!this.l.isEmpty()) && (this.m == null))
    {
      if ((B0() instanceof o))
      {
        this.m = paramString;
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public c k0()
  {
    C0(n.a);
    return this;
  }
  
  public c u0(long paramLong)
  {
    C0(new q(Long.valueOf(paramLong)));
    return this;
  }
  
  public c v0(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return k0();
    }
    C0(new q(paramBoolean));
    return this;
  }
  
  public c w0(Number paramNumber)
  {
    if (paramNumber == null) {
      return k0();
    }
    if (!h0())
    {
      double d = paramNumber.doubleValue();
      if ((Double.isNaN(d)) || (Double.isInfinite(d)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("JSON forbids NaN and infinities: ");
        localStringBuilder.append(paramNumber);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    C0(new q(paramNumber));
    return this;
  }
  
  public c x0(String paramString)
  {
    if (paramString == null) {
      return k0();
    }
    C0(new q(paramString));
    return this;
  }
  
  public c y0(boolean paramBoolean)
  {
    C0(new q(Boolean.valueOf(paramBoolean)));
    return this;
  }
  
  static final class a
    extends Writer
  {
    public void close()
    {
      throw new AssertionError();
    }
    
    public void flush()
    {
      throw new AssertionError();
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      throw new AssertionError();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.f
 * JD-Core Version:    0.7.0.1
 */