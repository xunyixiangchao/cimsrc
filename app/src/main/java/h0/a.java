package h0;

import java.util.Arrays;

public class a
  implements b.a
{
  private static float l = 0.001F;
  int a = 0;
  private final b b;
  protected final c c;
  private int d = 8;
  private i e = null;
  private int[] f = new int[8];
  private int[] g = new int[8];
  private float[] h = new float[8];
  private int i = -1;
  private int j = -1;
  private boolean k = false;
  
  a(b paramb, c paramc)
  {
    this.b = paramb;
    this.c = paramc;
  }
  
  public float a(int paramInt)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      if (m == paramInt) {
        return this.h[n];
      }
      n = this.g[n];
      m += 1;
    }
    return 0.0F;
  }
  
  public final float b(i parami)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      if (this.f[n] == parami.c) {
        return this.h[n];
      }
      n = this.g[n];
      m += 1;
    }
    return 0.0F;
  }
  
  public final void c(i parami, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      f(parami, true);
      return;
    }
    int m = this.i;
    if (m == -1)
    {
      this.i = 0;
      this.h[0] = paramFloat;
      this.f[0] = parami.c;
      this.g[0] = -1;
      parami.m += 1;
      parami.a(this.b);
      this.a += 1;
      if (!this.k)
      {
        m = this.j + 1;
        this.j = m;
        parami = this.f;
        if (m >= parami.length)
        {
          this.k = true;
          this.j = (parami.length - 1);
        }
      }
      return;
    }
    int n = 0;
    int i2 = -1;
    int i1;
    while ((m != -1) && (n < this.a))
    {
      arrayOfInt = this.f;
      int i3 = arrayOfInt[m];
      i1 = parami.c;
      if (i3 == i1)
      {
        this.h[m] = paramFloat;
        return;
      }
      if (arrayOfInt[m] < i1) {
        i2 = m;
      }
      m = this.g[m];
      n += 1;
    }
    m = this.j;
    if (this.k)
    {
      arrayOfInt = this.f;
      if (arrayOfInt[m] != -1) {
        m = arrayOfInt.length;
      }
    }
    else
    {
      m += 1;
    }
    int[] arrayOfInt = this.f;
    n = m;
    if (m >= arrayOfInt.length)
    {
      n = m;
      if (this.a < arrayOfInt.length)
      {
        i1 = 0;
        for (;;)
        {
          arrayOfInt = this.f;
          n = m;
          if (i1 >= arrayOfInt.length) {
            break;
          }
          if (arrayOfInt[i1] == -1)
          {
            n = i1;
            break;
          }
          i1 += 1;
        }
      }
    }
    arrayOfInt = this.f;
    m = n;
    if (n >= arrayOfInt.length)
    {
      m = arrayOfInt.length;
      n = this.d * 2;
      this.d = n;
      this.k = false;
      this.j = (m - 1);
      this.h = Arrays.copyOf(this.h, n);
      this.f = Arrays.copyOf(this.f, this.d);
      this.g = Arrays.copyOf(this.g, this.d);
    }
    this.f[m] = parami.c;
    this.h[m] = paramFloat;
    arrayOfInt = this.g;
    if (i2 != -1)
    {
      arrayOfInt[m] = arrayOfInt[i2];
      arrayOfInt[i2] = m;
    }
    else
    {
      arrayOfInt[m] = this.i;
      this.i = m;
    }
    parami.m += 1;
    parami.a(this.b);
    m = this.a + 1;
    this.a = m;
    if (!this.k) {
      this.j += 1;
    }
    parami = this.f;
    if (m >= parami.length) {
      this.k = true;
    }
    if (this.j >= parami.length)
    {
      this.k = true;
      this.j = (parami.length - 1);
    }
  }
  
  public final void clear()
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      i locali = this.c.d[this.f[n]];
      if (locali != null) {
        locali.d(this.b);
      }
      n = this.g[n];
      m += 1;
    }
    this.i = -1;
    this.j = -1;
    this.k = false;
    this.a = 0;
  }
  
  public boolean d(i parami)
  {
    int n = this.i;
    if (n == -1) {
      return false;
    }
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      if (this.f[n] == parami.c) {
        return true;
      }
      n = this.g[n];
      m += 1;
    }
    return false;
  }
  
  public int e()
  {
    return this.a;
  }
  
  public final float f(i parami, boolean paramBoolean)
  {
    if (this.e == parami) {
      this.e = null;
    }
    int m = this.i;
    if (m == -1) {
      return 0.0F;
    }
    int n = 0;
    int i1 = -1;
    while ((m != -1) && (n < this.a))
    {
      if (this.f[m] == parami.c)
      {
        if (m == this.i)
        {
          this.i = this.g[m];
        }
        else
        {
          int[] arrayOfInt = this.g;
          arrayOfInt[i1] = arrayOfInt[m];
        }
        if (paramBoolean) {
          parami.d(this.b);
        }
        parami.m -= 1;
        this.a -= 1;
        this.f[m] = -1;
        if (this.k) {
          this.j = m;
        }
        return this.h[m];
      }
      int i2 = this.g[m];
      n += 1;
      i1 = m;
      m = i2;
    }
    return 0.0F;
  }
  
  public void g(i parami, float paramFloat, boolean paramBoolean)
  {
    float f1 = l;
    if ((paramFloat > -f1) && (paramFloat < f1)) {
      return;
    }
    int m = this.i;
    if (m == -1)
    {
      this.i = 0;
      this.h[0] = paramFloat;
      this.f[0] = parami.c;
      this.g[0] = -1;
      parami.m += 1;
      parami.a(this.b);
      this.a += 1;
      if (!this.k)
      {
        m = this.j + 1;
        this.j = m;
        parami = this.f;
        if (m >= parami.length)
        {
          this.k = true;
          this.j = (parami.length - 1);
        }
      }
      return;
    }
    int n = 0;
    int i2 = -1;
    int i1;
    while ((m != -1) && (n < this.a))
    {
      localObject = this.f;
      int i3 = localObject[m];
      i1 = parami.c;
      if (i3 == i1)
      {
        localObject = this.h;
        f1 = localObject[m] + paramFloat;
        float f2 = l;
        paramFloat = f1;
        if (f1 > -f2)
        {
          paramFloat = f1;
          if (f1 < f2) {
            paramFloat = 0.0F;
          }
        }
        localObject[m] = paramFloat;
        if (paramFloat == 0.0F)
        {
          if (m == this.i)
          {
            this.i = this.g[m];
          }
          else
          {
            localObject = this.g;
            localObject[i2] = localObject[m];
          }
          if (paramBoolean) {
            parami.d(this.b);
          }
          if (this.k) {
            this.j = m;
          }
          parami.m -= 1;
          this.a -= 1;
        }
        return;
      }
      if (localObject[m] < i1) {
        i2 = m;
      }
      m = this.g[m];
      n += 1;
    }
    m = this.j;
    if (this.k)
    {
      localObject = this.f;
      if (localObject[m] != -1) {
        m = localObject.length;
      }
    }
    else
    {
      m += 1;
    }
    Object localObject = this.f;
    n = m;
    if (m >= localObject.length)
    {
      n = m;
      if (this.a < localObject.length)
      {
        i1 = 0;
        for (;;)
        {
          localObject = this.f;
          n = m;
          if (i1 >= localObject.length) {
            break;
          }
          if (localObject[i1] == -1)
          {
            n = i1;
            break;
          }
          i1 += 1;
        }
      }
    }
    localObject = this.f;
    m = n;
    if (n >= localObject.length)
    {
      m = localObject.length;
      n = this.d * 2;
      this.d = n;
      this.k = false;
      this.j = (m - 1);
      this.h = Arrays.copyOf(this.h, n);
      this.f = Arrays.copyOf(this.f, this.d);
      this.g = Arrays.copyOf(this.g, this.d);
    }
    this.f[m] = parami.c;
    this.h[m] = paramFloat;
    localObject = this.g;
    if (i2 != -1)
    {
      localObject[m] = localObject[i2];
      localObject[i2] = m;
    }
    else
    {
      localObject[m] = this.i;
      this.i = m;
    }
    parami.m += 1;
    parami.a(this.b);
    this.a += 1;
    if (!this.k) {
      this.j += 1;
    }
    m = this.j;
    parami = this.f;
    if (m >= parami.length)
    {
      this.k = true;
      this.j = (parami.length - 1);
    }
  }
  
  public float h(b paramb, boolean paramBoolean)
  {
    float f1 = b(paramb.a);
    f(paramb.a, paramBoolean);
    paramb = paramb.e;
    int n = paramb.e();
    int m = 0;
    while (m < n)
    {
      i locali = paramb.i(m);
      g(locali, paramb.b(locali) * f1, paramBoolean);
      m += 1;
    }
    return f1;
  }
  
  public i i(int paramInt)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      if (m == paramInt) {
        return this.c.d[this.f[n]];
      }
      n = this.g[n];
      m += 1;
    }
    return null;
  }
  
  public void j(float paramFloat)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      float[] arrayOfFloat = this.h;
      arrayOfFloat[n] /= paramFloat;
      n = this.g[n];
      m += 1;
    }
  }
  
  public void k()
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      float[] arrayOfFloat = this.h;
      arrayOfFloat[n] *= -1.0F;
      n = this.g[n];
      m += 1;
    }
  }
  
  public String toString()
  {
    int n = this.i;
    String str = "";
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" -> ");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(this.h[n]);
      localStringBuilder.append(" : ");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(this.c.d[this.f[n]]);
      str = localStringBuilder.toString();
      n = this.g[n];
      m += 1;
    }
    return str;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h0.a
 * JD-Core Version:    0.7.0.1
 */