package h0;

import java.util.Arrays;

public class j
  implements b.a
{
  private static float n = 0.001F;
  private final int a = -1;
  private int b = 16;
  private int c = 16;
  int[] d = new int[16];
  int[] e = new int[16];
  int[] f = new int[16];
  float[] g = new float[16];
  int[] h = new int[16];
  int[] i = new int[16];
  int j = 0;
  int k = -1;
  private final b l;
  protected final c m;
  
  j(b paramb, c paramc)
  {
    this.l = paramb;
    this.m = paramc;
    clear();
  }
  
  private void l(i parami, int paramInt)
  {
    int i3 = parami.c % this.c;
    parami = this.d;
    int i2 = parami[i3];
    int i1 = i2;
    if (i2 == -1)
    {
      parami[i3] = paramInt;
    }
    else
    {
      for (;;)
      {
        parami = this.e;
        if (parami[i1] == -1) {
          break;
        }
        i1 = parami[i1];
      }
      parami[i1] = paramInt;
    }
    this.e[paramInt] = -1;
  }
  
  private void m(int paramInt, i parami, float paramFloat)
  {
    this.f[paramInt] = parami.c;
    this.g[paramInt] = paramFloat;
    this.h[paramInt] = -1;
    this.i[paramInt] = -1;
    parami.a(this.l);
    parami.m += 1;
    this.j += 1;
  }
  
  private int n()
  {
    int i1 = 0;
    while (i1 < this.b)
    {
      if (this.f[i1] == -1) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void o()
  {
    int i2 = this.b * 2;
    this.f = Arrays.copyOf(this.f, i2);
    this.g = Arrays.copyOf(this.g, i2);
    this.h = Arrays.copyOf(this.h, i2);
    this.i = Arrays.copyOf(this.i, i2);
    this.e = Arrays.copyOf(this.e, i2);
    int i1 = this.b;
    while (i1 < i2)
    {
      this.f[i1] = -1;
      this.e[i1] = -1;
      i1 += 1;
    }
    this.b = i2;
  }
  
  private void q(int paramInt, i parami, float paramFloat)
  {
    int i1 = n();
    m(i1, parami, paramFloat);
    if (paramInt != -1)
    {
      this.h[i1] = paramInt;
      arrayOfInt = this.i;
      arrayOfInt[i1] = arrayOfInt[paramInt];
      arrayOfInt[paramInt] = i1;
    }
    else
    {
      this.h[i1] = -1;
      if (this.j > 0)
      {
        this.i[i1] = this.k;
        this.k = i1;
      }
      else
      {
        this.i[i1] = -1;
      }
    }
    int[] arrayOfInt = this.i;
    if (arrayOfInt[i1] != -1) {
      this.h[arrayOfInt[i1]] = i1;
    }
    l(parami, i1);
  }
  
  private void r(i parami)
  {
    int i3 = parami.c;
    int i4 = i3 % this.c;
    parami = this.d;
    int i2 = parami[i4];
    if (i2 == -1) {
      return;
    }
    int i1 = i2;
    if (this.f[i2] == i3)
    {
      int[] arrayOfInt = this.e;
      parami[i4] = arrayOfInt[i2];
      arrayOfInt[i2] = -1;
      return;
    }
    for (;;)
    {
      parami = this.e;
      if ((parami[i1] == -1) || (this.f[parami[i1]] == i3)) {
        break;
      }
      i1 = parami[i1];
    }
    i2 = parami[i1];
    if ((i2 != -1) && (this.f[i2] == i3))
    {
      parami[i1] = parami[i2];
      parami[i2] = -1;
    }
  }
  
  public float a(int paramInt)
  {
    int i3 = this.j;
    int i2 = this.k;
    int i1 = 0;
    while (i1 < i3)
    {
      if (i1 == paramInt) {
        return this.g[i2];
      }
      i2 = this.i[i2];
      if (i2 == -1) {
        break;
      }
      i1 += 1;
    }
    return 0.0F;
  }
  
  public float b(i parami)
  {
    int i1 = p(parami);
    if (i1 != -1) {
      return this.g[i1];
    }
    return 0.0F;
  }
  
  public void c(i parami, float paramFloat)
  {
    float f1 = n;
    if ((paramFloat > -f1) && (paramFloat < f1))
    {
      f(parami, true);
      return;
    }
    int i1 = this.j;
    int i3 = 0;
    if (i1 == 0)
    {
      m(0, parami, paramFloat);
      l(parami, 0);
      this.k = 0;
      return;
    }
    i1 = p(parami);
    if (i1 != -1)
    {
      this.g[i1] = paramFloat;
      return;
    }
    if (this.j + 1 >= this.b) {
      o();
    }
    int i5 = this.j;
    i1 = this.k;
    int i2 = -1;
    int i4;
    for (;;)
    {
      i4 = i2;
      if (i3 >= i5) {
        break;
      }
      int[] arrayOfInt = this.f;
      int i6 = arrayOfInt[i1];
      i4 = parami.c;
      if (i6 == i4)
      {
        this.g[i1] = paramFloat;
        return;
      }
      if (arrayOfInt[i1] < i4) {
        i2 = i1;
      }
      i1 = this.i[i1];
      if (i1 == -1)
      {
        i4 = i2;
        break;
      }
      i3 += 1;
    }
    q(i4, parami, paramFloat);
  }
  
  public void clear()
  {
    int i2 = this.j;
    int i1 = 0;
    while (i1 < i2)
    {
      i locali = i(i1);
      if (locali != null) {
        locali.d(this.l);
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.b)
    {
      this.f[i1] = -1;
      this.e[i1] = -1;
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.c)
    {
      this.d[i1] = -1;
      i1 += 1;
    }
    this.j = 0;
    this.k = -1;
  }
  
  public boolean d(i parami)
  {
    return p(parami) != -1;
  }
  
  public int e()
  {
    return this.j;
  }
  
  public float f(i parami, boolean paramBoolean)
  {
    int i1 = p(parami);
    if (i1 == -1) {
      return 0.0F;
    }
    r(parami);
    float f1 = this.g[i1];
    if (this.k == i1) {
      this.k = this.i[i1];
    }
    this.f[i1] = -1;
    int[] arrayOfInt1 = this.h;
    if (arrayOfInt1[i1] != -1)
    {
      arrayOfInt2 = this.i;
      arrayOfInt2[arrayOfInt1[i1]] = arrayOfInt2[i1];
    }
    int[] arrayOfInt2 = this.i;
    if (arrayOfInt2[i1] != -1) {
      arrayOfInt1[arrayOfInt2[i1]] = arrayOfInt1[i1];
    }
    this.j -= 1;
    parami.m -= 1;
    if (paramBoolean) {
      parami.d(this.l);
    }
    return f1;
  }
  
  public void g(i parami, float paramFloat, boolean paramBoolean)
  {
    float f1 = n;
    if ((paramFloat > -f1) && (paramFloat < f1)) {
      return;
    }
    int i1 = p(parami);
    if (i1 == -1)
    {
      c(parami, paramFloat);
      return;
    }
    float[] arrayOfFloat = this.g;
    arrayOfFloat[i1] += paramFloat;
    paramFloat = arrayOfFloat[i1];
    f1 = n;
    if ((paramFloat > -f1) && (arrayOfFloat[i1] < f1))
    {
      arrayOfFloat[i1] = 0.0F;
      f(parami, paramBoolean);
    }
  }
  
  public float h(b paramb, boolean paramBoolean)
  {
    float f1 = b(paramb.a);
    f(paramb.a, paramBoolean);
    paramb = (j)paramb.e;
    int i4 = paramb.e();
    int i2 = 0;
    int i1 = 0;
    while (i2 < i4)
    {
      int[] arrayOfInt = paramb.f;
      int i3 = i2;
      if (arrayOfInt[i1] != -1)
      {
        float f2 = paramb.g[i1];
        g(this.m.d[arrayOfInt[i1]], f2 * f1, paramBoolean);
        i3 = i2 + 1;
      }
      i1 += 1;
      i2 = i3;
    }
    return f1;
  }
  
  public i i(int paramInt)
  {
    int i3 = this.j;
    if (i3 == 0) {
      return null;
    }
    int i2 = this.k;
    int i1 = 0;
    while (i1 < i3)
    {
      if ((i1 == paramInt) && (i2 != -1)) {
        return this.m.d[this.f[i2]];
      }
      i2 = this.i[i2];
      if (i2 == -1) {
        return null;
      }
      i1 += 1;
    }
    return null;
  }
  
  public void j(float paramFloat)
  {
    int i3 = this.j;
    int i2 = this.k;
    int i1 = 0;
    while (i1 < i3)
    {
      float[] arrayOfFloat = this.g;
      arrayOfFloat[i2] /= paramFloat;
      i2 = this.i[i2];
      if (i2 == -1) {
        return;
      }
      i1 += 1;
    }
  }
  
  public void k()
  {
    int i3 = this.j;
    int i2 = this.k;
    int i1 = 0;
    while (i1 < i3)
    {
      float[] arrayOfFloat = this.g;
      arrayOfFloat[i2] *= -1.0F;
      i2 = this.i[i2];
      if (i2 == -1) {
        return;
      }
      i1 += 1;
    }
  }
  
  public int p(i parami)
  {
    if (this.j != 0)
    {
      if (parami == null) {
        return -1;
      }
      int i3 = parami.c;
      int i1 = this.c;
      int i2 = this.d[(i3 % i1)];
      if (i2 == -1) {
        return -1;
      }
      i1 = i2;
      if (this.f[i2] == i3) {
        return i2;
      }
      for (;;)
      {
        parami = this.e;
        if ((parami[i1] == -1) || (this.f[parami[i1]] == i3)) {
          break;
        }
        i1 = parami[i1];
      }
      if (parami[i1] == -1) {
        return -1;
      }
      if (this.f[parami[i1]] == i3) {
        return parami[i1];
      }
    }
    return -1;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(hashCode());
    ((StringBuilder)localObject1).append(" { ");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i2 = this.j;
    int i1 = 0;
    while (i1 < i2)
    {
      localObject2 = i(i1);
      if (localObject2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(localObject2);
        localStringBuilder.append(" = ");
        localStringBuilder.append(a(i1));
        localStringBuilder.append(" ");
        localObject1 = localStringBuilder.toString();
        int i3 = p((i)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("[p: ");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (this.h[i3] != -1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(this.m.d[this.f[this.h[i3]]]);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("none");
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", n: ");
        localObject1 = ((StringBuilder)localObject2).toString();
        if (this.i[i3] != -1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(this.m.d[this.f[this.i[i3]]]);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("none");
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      i1 += 1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" }");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h0.j
 * JD-Core Version:    0.7.0.1
 */