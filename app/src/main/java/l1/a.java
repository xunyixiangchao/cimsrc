package l1;

import android.graphics.Color;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

final class a
{
  private static final Comparator<b> g = new a();
  final int[] a;
  final int[] b;
  final List<b.e> c;
  final TimingLogger d = null;
  final b.c[] e;
  private final float[] f = new float[3];
  
  a(int[] paramArrayOfInt, int paramInt, b.c[] paramArrayOfc)
  {
    this.e = paramArrayOfc;
    paramArrayOfc = new int[32768];
    this.b = paramArrayOfc;
    int n = 0;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      j = g(paramArrayOfInt[i]);
      paramArrayOfInt[i] = j;
      paramArrayOfc[j] += 1;
      i += 1;
    }
    int j = 0;
    for (i = j; j < 32768; i = k)
    {
      if ((paramArrayOfc[j] > 0) && (l(j))) {
        paramArrayOfc[j] = 0;
      }
      k = i;
      if (paramArrayOfc[j] > 0) {
        k = i + 1;
      }
      j += 1;
    }
    paramArrayOfInt = new int[i];
    this.a = paramArrayOfInt;
    j = 0;
    int m;
    for (int k = j; j < 32768; k = m)
    {
      m = k;
      if (paramArrayOfc[j] > 0)
      {
        paramArrayOfInt[k] = j;
        m = k + 1;
      }
      j += 1;
    }
    if (i <= paramInt)
    {
      this.c = new ArrayList();
      paramInt = n;
      while (paramInt < i)
      {
        j = paramArrayOfInt[paramInt];
        this.c.add(new b.e(a(j), paramArrayOfc[j]));
        paramInt += 1;
      }
    }
    this.c = h(paramInt);
  }
  
  private static int a(int paramInt)
  {
    return b(k(paramInt), j(paramInt), i(paramInt));
  }
  
  static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return Color.rgb(f(paramInt1, 5, 8), f(paramInt2, 5, 8), f(paramInt3, 5, 8));
  }
  
  private List<b.e> c(Collection<b> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      b.e locale = ((b)paramCollection.next()).d();
      if (!n(locale)) {
        localArrayList.add(locale);
      }
    }
    return localArrayList;
  }
  
  static void e(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    int j;
    if (paramInt1 != -2)
    {
      if (paramInt1 != -1) {
        return;
      }
      while (paramInt2 <= paramInt3)
      {
        paramInt1 = paramArrayOfInt[paramInt2];
        i = i(paramInt1);
        j = j(paramInt1);
        paramArrayOfInt[paramInt2] = (k(paramInt1) | i << 10 | j << 5);
        paramInt2 += 1;
      }
    }
    while (i <= paramInt3)
    {
      paramInt1 = paramArrayOfInt[i];
      paramInt2 = j(paramInt1);
      j = k(paramInt1);
      paramArrayOfInt[i] = (i(paramInt1) | paramInt2 << 10 | j << 5);
      i += 1;
    }
  }
  
  private static int f(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramInt2) {
      paramInt1 <<= paramInt3 - paramInt2;
    } else {
      paramInt1 >>= paramInt2 - paramInt3;
    }
    return paramInt1 & (1 << paramInt3) - 1;
  }
  
  private static int g(int paramInt)
  {
    int i = f(Color.red(paramInt), 8, 5);
    int j = f(Color.green(paramInt), 8, 5);
    return f(Color.blue(paramInt), 8, 5) | i << 10 | j << 5;
  }
  
  private List<b.e> h(int paramInt)
  {
    PriorityQueue localPriorityQueue = new PriorityQueue(paramInt, g);
    localPriorityQueue.offer(new b(0, this.a.length - 1));
    o(localPriorityQueue, paramInt);
    return c(localPriorityQueue);
  }
  
  static int i(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  static int j(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  static int k(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  private boolean l(int paramInt)
  {
    paramInt = a(paramInt);
    q0.a.g(paramInt, this.f);
    return m(paramInt, this.f);
  }
  
  private boolean m(int paramInt, float[] paramArrayOfFloat)
  {
    b.c[] arrayOfc = this.e;
    if ((arrayOfc != null) && (arrayOfc.length > 0))
    {
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        if (!this.e[i].a(paramInt, paramArrayOfFloat)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private boolean n(b.e parame)
  {
    return m(parame.e(), parame.c());
  }
  
  private void o(PriorityQueue<b> paramPriorityQueue, int paramInt)
  {
    while (paramPriorityQueue.size() < paramInt)
    {
      b localb = (b)paramPriorityQueue.poll();
      if ((localb == null) || (!localb.a())) {
        break;
      }
      paramPriorityQueue.offer(localb.h());
      paramPriorityQueue.offer(localb);
    }
  }
  
  List<b.e> d()
  {
    return this.c;
  }
  
  static final class a
    implements Comparator<a.b>
  {
    public int a(a.b paramb1, a.b paramb2)
    {
      return paramb2.g() - paramb1.g();
    }
  }
  
  private class b
  {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    
    b(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      c();
    }
    
    final boolean a()
    {
      return e() > 1;
    }
    
    final int b()
    {
      int k = f();
      Object localObject = a.this;
      int[] arrayOfInt = ((a)localObject).a;
      localObject = ((a)localObject).b;
      a.e(arrayOfInt, k, this.a, this.b);
      Arrays.sort(arrayOfInt, this.a, this.b + 1);
      a.e(arrayOfInt, k, this.a, this.b);
      int n = this.c / 2;
      k = this.a;
      int m = 0;
      for (;;)
      {
        int i1 = this.b;
        if (k > i1) {
          break;
        }
        m += localObject[arrayOfInt[k]];
        if (m >= n) {
          return Math.min(i1 - 1, k);
        }
        k += 1;
      }
      return this.a;
    }
    
    final void c()
    {
      Object localObject = a.this;
      int[] arrayOfInt = ((a)localObject).a;
      localObject = ((a)localObject).b;
      int i4 = this.a;
      int i5 = 2147483647;
      int i6 = -2147483648;
      int k = i6;
      int m = k;
      int i3 = 0;
      int i1 = 2147483647;
      int n = i1;
      int i2 = k;
      k = n;
      n = i4;
      while (n <= this.b)
      {
        i4 = arrayOfInt[n];
        int i9 = i3 + localObject[i4];
        int i7 = a.k(i4);
        int i8 = a.j(i4);
        i4 = a.i(i4);
        i3 = i6;
        if (i7 > i6) {
          i3 = i7;
        }
        i6 = i5;
        if (i7 < i5) {
          i6 = i7;
        }
        i7 = i2;
        if (i8 > i2) {
          i7 = i8;
        }
        i2 = i1;
        if (i8 < i1) {
          i2 = i8;
        }
        i8 = m;
        if (i4 > m) {
          i8 = i4;
        }
        m = k;
        if (i4 < k) {
          m = i4;
        }
        n += 1;
        i5 = i6;
        i1 = i2;
        k = m;
        i6 = i3;
        i2 = i7;
        m = i8;
        i3 = i9;
      }
      this.d = i5;
      this.e = i6;
      this.f = i1;
      this.g = i2;
      this.h = k;
      this.i = m;
      this.c = i3;
    }
    
    final b.e d()
    {
      Object localObject = a.this;
      int[] arrayOfInt = ((a)localObject).a;
      localObject = ((a)localObject).b;
      int n = this.a;
      int i1 = 0;
      int i2 = 0;
      int k = i2;
      int m = k;
      while (n <= this.b)
      {
        int i3 = arrayOfInt[n];
        int i4 = localObject[i3];
        i2 += i4;
        i1 += a.k(i3) * i4;
        k += a.j(i3) * i4;
        m += i4 * a.i(i3);
        n += 1;
      }
      float f1 = i1;
      float f2 = i2;
      return new b.e(a.b(Math.round(f1 / f2), Math.round(k / f2), Math.round(m / f2)), i2);
    }
    
    final int e()
    {
      return this.b + 1 - this.a;
    }
    
    final int f()
    {
      int k = this.e - this.d;
      int m = this.g - this.f;
      int n = this.i - this.h;
      if ((k >= m) && (k >= n)) {
        return -3;
      }
      if ((m >= k) && (m >= n)) {
        return -2;
      }
      return -1;
    }
    
    final int g()
    {
      return (this.e - this.d + 1) * (this.g - this.f + 1) * (this.i - this.h + 1);
    }
    
    final b h()
    {
      if (a())
      {
        int k = b();
        b localb = new b(a.this, k + 1, this.b);
        this.b = k;
        c();
        return localb;
      }
      throw new IllegalStateException("Can not split a box with only 1 color");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l1.a
 * JD-Core Version:    0.7.0.1
 */