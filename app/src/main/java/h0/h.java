package h0;

import java.util.Arrays;
import java.util.Comparator;

public class h
  extends b
{
  private int g = 128;
  private i[] h = new i[''];
  private i[] i = new i[''];
  private int j = 0;
  b k = new b(this);
  c l;
  
  public h(c paramc)
  {
    super(paramc);
    this.l = paramc;
  }
  
  private final void F(i parami)
  {
    int m = this.j;
    i[] arrayOfi = this.h;
    if (m + 1 > arrayOfi.length)
    {
      arrayOfi = (i[])Arrays.copyOf(arrayOfi, arrayOfi.length * 2);
      this.h = arrayOfi;
      this.i = ((i[])Arrays.copyOf(arrayOfi, arrayOfi.length * 2));
    }
    arrayOfi = this.h;
    m = this.j;
    arrayOfi[m] = parami;
    m += 1;
    this.j = m;
    if ((m > 1) && (arrayOfi[(m - 1)].c > parami.c))
    {
      int n = 0;
      m = 0;
      int i1;
      for (;;)
      {
        i1 = this.j;
        if (m >= i1) {
          break;
        }
        this.i[m] = this.h[m];
        m += 1;
      }
      Arrays.sort(this.i, 0, i1, new a());
      m = n;
      while (m < this.j)
      {
        this.h[m] = this.i[m];
        m += 1;
      }
    }
    parami.a = true;
    parami.a(this);
  }
  
  private final void G(i parami)
  {
    int m = 0;
    while (m < this.j)
    {
      if (this.h[m] == parami)
      {
        int n;
        for (;;)
        {
          n = this.j;
          if (m >= n - 1) {
            break;
          }
          i[] arrayOfi = this.h;
          n = m + 1;
          arrayOfi[m] = arrayOfi[n];
          m = n;
        }
        this.j = (n - 1);
        parami.a = false;
        return;
      }
      m += 1;
    }
  }
  
  public void B(d paramd, b paramb, boolean paramBoolean)
  {
    paramd = paramb.a;
    if (paramd == null) {
      return;
    }
    b.a locala = paramb.e;
    int n = locala.e();
    int m = 0;
    while (m < n)
    {
      i locali = locala.i(m);
      float f = locala.a(m);
      this.k.b(locali);
      if (this.k.a(paramd, f)) {
        F(locali);
      }
      this.b += paramb.b * f;
      m += 1;
    }
    G(paramd);
  }
  
  public i a(d paramd, boolean[] paramArrayOfBoolean)
  {
    int m = 0;
    int i1;
    for (int n = -1; m < this.j; n = i1)
    {
      paramd = this.h[m];
      if (paramArrayOfBoolean[paramd.c] != 0)
      {
        i1 = n;
      }
      else
      {
        this.k.b(paramd);
        paramd = this.k;
        if (n == -1)
        {
          i1 = n;
          if (!paramd.c()) {
            break label90;
          }
        }
        else
        {
          i1 = n;
          if (!paramd.d(this.h[n])) {
            break label90;
          }
        }
        i1 = m;
      }
      label90:
      m += 1;
    }
    if (n == -1) {
      return null;
    }
    return this.h[n];
  }
  
  public void b(i parami)
  {
    this.k.b(parami);
    this.k.e();
    parami.i[parami.e] = 1.0F;
    F(parami);
  }
  
  public void clear()
  {
    this.j = 0;
    this.b = 0.0F;
  }
  
  public boolean isEmpty()
  {
    return this.j == 0;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(" goal -> (");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(") : ");
    localObject1 = ((StringBuilder)localObject1).toString();
    int m = 0;
    while (m < this.j)
    {
      Object localObject2 = this.h[m];
      this.k.b((i)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.k);
      ((StringBuilder)localObject2).append(" ");
      localObject1 = ((StringBuilder)localObject2).toString();
      m += 1;
    }
    return localObject1;
  }
  
  class a
    implements Comparator<i>
  {
    a() {}
    
    public int a(i parami1, i parami2)
    {
      return parami1.c - parami2.c;
    }
  }
  
  class b
  {
    i a;
    h b;
    
    public b(h paramh)
    {
      this.b = paramh;
    }
    
    public boolean a(i parami, float paramFloat)
    {
      boolean bool = this.a.a;
      int j = 1;
      int i = 0;
      if (bool)
      {
        i = 0;
        while (i < 9)
        {
          float[] arrayOfFloat = this.a.i;
          arrayOfFloat[i] += parami.i[i] * paramFloat;
          if (Math.abs(arrayOfFloat[i]) < 1.0E-004F) {
            this.a.i[i] = 0.0F;
          } else {
            j = 0;
          }
          i += 1;
        }
        if (j != 0) {
          h.E(h.this, this.a);
        }
        return false;
      }
      while (i < 9)
      {
        float f1 = parami.i[i];
        if (f1 != 0.0F)
        {
          float f2 = f1 * paramFloat;
          f1 = f2;
          if (Math.abs(f2) < 1.0E-004F) {
            f1 = 0.0F;
          }
          this.a.i[i] = f1;
        }
        else
        {
          this.a.i[i] = 0.0F;
        }
        i += 1;
      }
      return true;
    }
    
    public void b(i parami)
    {
      this.a = parami;
    }
    
    public final boolean c()
    {
      int i = 8;
      while (i >= 0)
      {
        float f = this.a.i[i];
        if (f > 0.0F) {
          return false;
        }
        if (f < 0.0F) {
          return true;
        }
        i -= 1;
      }
      return false;
    }
    
    public final boolean d(i parami)
    {
      int i = 8;
      while (i >= 0)
      {
        float f1 = parami.i[i];
        float f2 = this.a.i[i];
        if (f2 == f1) {
          i -= 1;
        } else if (f2 < f1) {
          return true;
        }
      }
      return false;
    }
    
    public void e()
    {
      Arrays.fill(this.a.i, 0.0F);
    }
    
    public String toString()
    {
      i locali = this.a;
      Object localObject1 = "[ ";
      Object localObject2 = localObject1;
      if (locali != null)
      {
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= 9) {
            break;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(this.a.i[i]);
          ((StringBuilder)localObject2).append(" ");
          localObject1 = ((StringBuilder)localObject2).toString();
          i += 1;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("] ");
      ((StringBuilder)localObject1).append(this.a);
      return ((StringBuilder)localObject1).toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h0.h
 * JD-Core Version:    0.7.0.1
 */