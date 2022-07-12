package h0;

import java.util.Arrays;
import java.util.HashSet;

public class i
  implements Comparable<i>
{
  private static int r = 1;
  public boolean a;
  private String b;
  public int c = -1;
  int d = -1;
  public int e = 0;
  public float f;
  public boolean g = false;
  float[] h = new float[9];
  float[] i = new float[9];
  a j;
  b[] k = new b[16];
  int l = 0;
  public int m = 0;
  boolean n = false;
  int o = -1;
  float p = 0.0F;
  HashSet<b> q = null;
  
  public i(a parama, String paramString)
  {
    this.j = parama;
  }
  
  static void c()
  {
    r += 1;
  }
  
  public final void a(b paramb)
  {
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = this.l;
      if (i1 >= i2) {
        break;
      }
      if (this.k[i1] == paramb) {
        return;
      }
      i1 += 1;
    }
    b[] arrayOfb = this.k;
    if (i2 >= arrayOfb.length) {
      this.k = ((b[])Arrays.copyOf(arrayOfb, arrayOfb.length * 2));
    }
    arrayOfb = this.k;
    i1 = this.l;
    arrayOfb[i1] = paramb;
    this.l = (i1 + 1);
  }
  
  public int b(i parami)
  {
    return this.c - parami.c;
  }
  
  public final void d(b paramb)
  {
    int i3 = this.l;
    int i1 = 0;
    while (i1 < i3)
    {
      if (this.k[i1] == paramb)
      {
        while (i1 < i3 - 1)
        {
          paramb = this.k;
          int i2 = i1 + 1;
          paramb[i1] = paramb[i2];
          i1 = i2;
        }
        this.l -= 1;
        return;
      }
      i1 += 1;
    }
  }
  
  public void e()
  {
    this.b = null;
    this.j = a.e;
    this.e = 0;
    this.c = -1;
    this.d = -1;
    this.f = 0.0F;
    this.g = false;
    this.n = false;
    this.o = -1;
    this.p = 0.0F;
    int i2 = this.l;
    int i1 = 0;
    while (i1 < i2)
    {
      this.k[i1] = null;
      i1 += 1;
    }
    this.l = 0;
    this.m = 0;
    this.a = false;
    Arrays.fill(this.i, 0.0F);
  }
  
  public void f(d paramd, float paramFloat)
  {
    this.f = paramFloat;
    this.g = true;
    this.n = false;
    this.o = -1;
    this.p = 0.0F;
    int i2 = this.l;
    this.d = -1;
    int i1 = 0;
    while (i1 < i2)
    {
      this.k[i1].A(paramd, this, false);
      i1 += 1;
    }
    this.l = 0;
  }
  
  public void g(a parama, String paramString)
  {
    this.j = parama;
  }
  
  public final void h(d paramd, b paramb)
  {
    int i2 = this.l;
    int i1 = 0;
    while (i1 < i2)
    {
      this.k[i1].B(paramd, paramb, false);
      i1 += 1;
    }
    this.l = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    if (this.b != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.b);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.c);
    }
    return localStringBuilder.toString();
  }
  
  public static enum a
  {
    static
    {
      a locala1 = new a("UNRESTRICTED", 0);
      a = locala1;
      a locala2 = new a("CONSTANT", 1);
      b = locala2;
      a locala3 = new a("SLACK", 2);
      c = locala3;
      a locala4 = new a("ERROR", 3);
      d = locala4;
      a locala5 = new a("UNKNOWN", 4);
      e = locala5;
      f = new a[] { locala1, locala2, locala3, locala4, locala5 };
    }
    
    private a() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h0.i
 * JD-Core Version:    0.7.0.1
 */