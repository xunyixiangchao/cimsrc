package androidx.recyclerview.widget;

import java.util.List;

class l
{
  final a a;
  
  l(a parama)
  {
    this.a = parama;
  }
  
  private int a(List<a.b> paramList)
  {
    int i = paramList.size() - 1;
    int k;
    for (int j = 0; i >= 0; j = k)
    {
      if (((a.b)paramList.get(i)).a == 8)
      {
        k = j;
        if (j != 0) {
          return i;
        }
      }
      else
      {
        k = 1;
      }
      i -= 1;
    }
    return -1;
  }
  
  private void c(List<a.b> paramList, int paramInt1, a.b paramb1, int paramInt2, a.b paramb2)
  {
    int k = paramb1.d;
    int m = paramb2.b;
    if (k < m) {
      i = -1;
    } else {
      i = 0;
    }
    int n = paramb1.b;
    int j = i;
    if (n < m) {
      j = i + 1;
    }
    if (m <= n) {
      paramb1.b = (n + paramb2.d);
    }
    int i = paramb2.b;
    if (i <= k) {
      paramb1.d = (k + paramb2.d);
    }
    paramb2.b = (i + j);
    paramList.set(paramInt1, paramb2);
    paramList.set(paramInt2, paramb1);
  }
  
  private void d(List<a.b> paramList, int paramInt1, int paramInt2)
  {
    a.b localb1 = (a.b)paramList.get(paramInt1);
    a.b localb2 = (a.b)paramList.get(paramInt2);
    int i = localb2.a;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4) {
          return;
        }
        f(paramList, paramInt1, localb1, paramInt2, localb2);
        return;
      }
      e(paramList, paramInt1, localb1, paramInt2, localb2);
      return;
    }
    c(paramList, paramInt1, localb1, paramInt2, localb2);
  }
  
  void b(List<a.b> paramList)
  {
    for (;;)
    {
      int i = a(paramList);
      if (i == -1) {
        break;
      }
      d(paramList, i, i + 1);
    }
  }
  
  void e(List<a.b> paramList, int paramInt1, a.b paramb1, int paramInt2, a.b paramb2)
  {
    int i = paramb1.b;
    int k = paramb1.d;
    int j = 0;
    int m = paramb2.b;
    if (i < k)
    {
      if ((m == i) && (paramb2.d == k - i))
      {
        i = 0;
        j = 1;
      }
      else
      {
        i = 0;
      }
    }
    else if ((m == k + 1) && (paramb2.d == i - k))
    {
      i = 1;
      j = i;
    }
    else
    {
      i = 1;
    }
    m = paramb2.b;
    int n;
    if (k < m)
    {
      paramb2.b = (m - 1);
    }
    else
    {
      n = paramb2.d;
      if (k < m + n)
      {
        paramb2.d = (n - 1);
        paramb1.a = 2;
        paramb1.d = 1;
        if (paramb2.d == 0)
        {
          paramList.remove(paramInt2);
          this.a.a(paramb2);
        }
        return;
      }
    }
    k = paramb1.b;
    m = paramb2.b;
    a.b localb = null;
    if (k <= m)
    {
      paramb2.b = (m + 1);
    }
    else
    {
      n = paramb2.d;
      if (k < m + n)
      {
        localb = this.a.b(2, k + 1, m + n - k, null);
        paramb2.d = (paramb1.b - paramb2.b);
      }
    }
    if (j != 0)
    {
      paramList.set(paramInt1, paramb2);
      paramList.remove(paramInt2);
      this.a.a(paramb1);
      return;
    }
    if (i != 0)
    {
      if (localb != null)
      {
        i = paramb1.b;
        if (i > localb.b) {
          paramb1.b = (i - localb.d);
        }
        i = paramb1.d;
        if (i > localb.b) {
          paramb1.d = (i - localb.d);
        }
      }
      i = paramb1.b;
      if (i > paramb2.b) {
        paramb1.b = (i - paramb2.d);
      }
      i = paramb1.d;
      if (i <= paramb2.b) {
        break label547;
      }
    }
    else
    {
      if (localb != null)
      {
        i = paramb1.b;
        if (i >= localb.b) {
          paramb1.b = (i - localb.d);
        }
        i = paramb1.d;
        if (i >= localb.b) {
          paramb1.d = (i - localb.d);
        }
      }
      i = paramb1.b;
      if (i >= paramb2.b) {
        paramb1.b = (i - paramb2.d);
      }
      i = paramb1.d;
      if (i < paramb2.b) {
        break label547;
      }
    }
    paramb1.d = (i - paramb2.d);
    label547:
    paramList.set(paramInt1, paramb2);
    if (paramb1.b != paramb1.d) {
      paramList.set(paramInt2, paramb1);
    } else {
      paramList.remove(paramInt2);
    }
    if (localb != null) {
      paramList.add(paramInt1, localb);
    }
  }
  
  void f(List<a.b> paramList, int paramInt1, a.b paramb1, int paramInt2, a.b paramb2)
  {
    int i = paramb1.d;
    int j = paramb2.b;
    a.b localb2 = null;
    int k;
    if (i < j)
    {
      paramb2.b = (j - 1);
    }
    else
    {
      k = paramb2.d;
      if (i < j + k)
      {
        paramb2.d = (k - 1);
        localb1 = this.a.b(4, paramb1.b, 1, paramb2.c);
        break label89;
      }
    }
    a.b localb1 = null;
    label89:
    i = paramb1.b;
    j = paramb2.b;
    if (i <= j)
    {
      paramb2.b = (j + 1);
    }
    else
    {
      k = paramb2.d;
      if (i < j + k)
      {
        j = j + k - i;
        localb2 = this.a.b(4, i + 1, j, paramb2.c);
        paramb2.d -= j;
      }
    }
    paramList.set(paramInt2, paramb1);
    if (paramb2.d > 0)
    {
      paramList.set(paramInt1, paramb2);
    }
    else
    {
      paramList.remove(paramInt1);
      this.a.a(paramb2);
    }
    if (localb1 != null) {
      paramList.add(paramInt1, localb1);
    }
    if (localb2 != null) {
      paramList.add(paramInt1, localb2);
    }
  }
  
  static abstract interface a
  {
    public abstract void a(a.b paramb);
    
    public abstract a.b b(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.l
 * JD-Core Version:    0.7.0.1
 */