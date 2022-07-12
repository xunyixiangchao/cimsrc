package y7;

import b8.a;
import b8.b;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import v7.i;
import v7.n;
import v7.o;
import v7.q;

public final class e
  extends a
{
  private static final Reader u = new a();
  private static final Object v = new Object();
  private Object[] q;
  private int r;
  private String[] s;
  private int[] t;
  
  private void G0(b paramb)
  {
    if (u0() == paramb) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected ");
    localStringBuilder.append(paramb);
    localStringBuilder.append(" but was ");
    localStringBuilder.append(u0());
    localStringBuilder.append(j0());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private Object H0()
  {
    return this.q[(this.r - 1)];
  }
  
  private Object I0()
  {
    Object[] arrayOfObject = this.q;
    int i = this.r - 1;
    this.r = i;
    Object localObject = arrayOfObject[i];
    arrayOfObject[i] = null;
    return localObject;
  }
  
  private void K0(Object paramObject)
  {
    int i = this.r;
    Object[] arrayOfObject1 = this.q;
    if (i == arrayOfObject1.length)
    {
      Object[] arrayOfObject2 = new Object[i * 2];
      int[] arrayOfInt = new int[i * 2];
      String[] arrayOfString = new String[i * 2];
      System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      System.arraycopy(this.t, 0, arrayOfInt, 0, this.r);
      System.arraycopy(this.s, 0, arrayOfString, 0, this.r);
      this.q = arrayOfObject2;
      this.t = arrayOfInt;
      this.s = arrayOfString;
    }
    arrayOfObject1 = this.q;
    i = this.r;
    this.r = (i + 1);
    arrayOfObject1[i] = paramObject;
  }
  
  private String j0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" at path ");
    localStringBuilder.append(G());
    return localStringBuilder.toString();
  }
  
  public void E0()
  {
    if (u0() == b.e)
    {
      o0();
      this.s[(this.r - 2)] = "null";
    }
    else
    {
      I0();
      i = this.r;
      if (i > 0) {
        this.s[(i - 1)] = "null";
      }
    }
    int i = this.r;
    if (i > 0)
    {
      int[] arrayOfInt = this.t;
      i -= 1;
      arrayOfInt[i] += 1;
    }
  }
  
  public String G()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    int i;
    for (int j = 0; j < this.r; j = i + 1)
    {
      Object localObject = this.q;
      if ((localObject[j] instanceof i))
      {
        j += 1;
        i = j;
        if ((localObject[j] instanceof Iterator))
        {
          localStringBuilder.append('[');
          localStringBuilder.append(this.t[j]);
          localStringBuilder.append(']');
          i = j;
        }
      }
      else
      {
        i = j;
        if ((localObject[j] instanceof o))
        {
          j += 1;
          i = j;
          if ((localObject[j] instanceof Iterator))
          {
            localStringBuilder.append('.');
            localObject = this.s;
            i = j;
            if (localObject[j] != null)
            {
              localStringBuilder.append(localObject[j]);
              i = j;
            }
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void J0()
  {
    G0(b.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)H0()).next();
    K0(localEntry.getValue());
    K0(new q((String)localEntry.getKey()));
  }
  
  public void a()
  {
    G0(b.a);
    K0(((i)H0()).iterator());
    this.t[(this.r - 1)] = 0;
  }
  
  public void close()
  {
    this.q = new Object[] { v };
    this.r = 1;
  }
  
  public void d0()
  {
    G0(b.b);
    I0();
    I0();
    int i = this.r;
    if (i > 0)
    {
      int[] arrayOfInt = this.t;
      i -= 1;
      arrayOfInt[i] += 1;
    }
  }
  
  public void e0()
  {
    G0(b.d);
    I0();
    I0();
    int i = this.r;
    if (i > 0)
    {
      int[] arrayOfInt = this.t;
      i -= 1;
      arrayOfInt[i] += 1;
    }
  }
  
  public void g()
  {
    G0(b.c);
    K0(((o)H0()).i().iterator());
  }
  
  public boolean g0()
  {
    b localb = u0();
    return (localb != b.d) && (localb != b.b);
  }
  
  public boolean k0()
  {
    G0(b.h);
    boolean bool = ((q)I0()).h();
    int i = this.r;
    if (i > 0)
    {
      int[] arrayOfInt = this.t;
      i -= 1;
      arrayOfInt[i] += 1;
    }
    return bool;
  }
  
  public double l0()
  {
    Object localObject = u0();
    b localb = b.g;
    if ((localObject != localb) && (localObject != b.f))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ");
      localStringBuilder.append(localb);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(j0());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    double d = ((q)H0()).j();
    if ((!h0()) && ((Double.isNaN(d)) || (Double.isInfinite(d))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSON forbids NaN and infinities: ");
      ((StringBuilder)localObject).append(d);
      throw new NumberFormatException(((StringBuilder)localObject).toString());
    }
    I0();
    int i = this.r;
    if (i > 0)
    {
      localObject = this.t;
      i -= 1;
      localObject[i] += 1;
    }
    return d;
  }
  
  public int m0()
  {
    Object localObject = u0();
    b localb = b.g;
    if ((localObject != localb) && (localObject != b.f))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ");
      localStringBuilder.append(localb);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(j0());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    int i = ((q)H0()).k();
    I0();
    int j = this.r;
    if (j > 0)
    {
      localObject = this.t;
      j -= 1;
      localObject[j] += 1;
    }
    return i;
  }
  
  public long n0()
  {
    Object localObject = u0();
    b localb = b.g;
    if ((localObject != localb) && (localObject != b.f))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ");
      localStringBuilder.append(localb);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(j0());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    long l = ((q)H0()).l();
    I0();
    int i = this.r;
    if (i > 0)
    {
      localObject = this.t;
      i -= 1;
      localObject[i] += 1;
    }
    return l;
  }
  
  public String o0()
  {
    G0(b.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)H0()).next();
    String str = (String)localEntry.getKey();
    this.s[(this.r - 1)] = str;
    K0(localEntry.getValue());
    return str;
  }
  
  public void q0()
  {
    G0(b.i);
    I0();
    int i = this.r;
    if (i > 0)
    {
      int[] arrayOfInt = this.t;
      i -= 1;
      arrayOfInt[i] += 1;
    }
  }
  
  public String s0()
  {
    Object localObject1 = u0();
    Object localObject2 = b.f;
    if ((localObject1 != localObject2) && (localObject1 != b.g))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localObject1);
      localStringBuilder.append(j0());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    localObject1 = ((q)I0()).n();
    int i = this.r;
    if (i > 0)
    {
      localObject2 = this.t;
      i -= 1;
      localObject2[i] += 1;
    }
    return localObject1;
  }
  
  public String toString()
  {
    return e.class.getSimpleName();
  }
  
  public b u0()
  {
    if (this.r == 0) {
      return b.j;
    }
    Object localObject = H0();
    if ((localObject instanceof Iterator))
    {
      boolean bool = this.q[(this.r - 2)] instanceof o;
      localObject = (Iterator)localObject;
      if (((Iterator)localObject).hasNext())
      {
        if (bool) {
          return b.e;
        }
        K0(((Iterator)localObject).next());
        return u0();
      }
      if (bool) {
        return b.d;
      }
      return b.b;
    }
    if ((localObject instanceof o)) {
      return b.c;
    }
    if ((localObject instanceof i)) {
      return b.a;
    }
    if ((localObject instanceof q))
    {
      localObject = (q)localObject;
      if (((q)localObject).s()) {
        return b.f;
      }
      if (((q)localObject).o()) {
        return b.h;
      }
      if (((q)localObject).q()) {
        return b.g;
      }
      throw new AssertionError();
    }
    if ((localObject instanceof n)) {
      return b.i;
    }
    if (localObject == v) {
      throw new IllegalStateException("JsonReader is closed");
    }
    throw new AssertionError();
  }
  
  static final class a
    extends Reader
  {
    public void close()
    {
      throw new AssertionError();
    }
    
    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      throw new AssertionError();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.e
 * JD-Core Version:    0.7.0.1
 */