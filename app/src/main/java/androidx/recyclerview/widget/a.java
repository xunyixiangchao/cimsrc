package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.List;
import x0.e;
import x0.f;

final class a
  implements l.a
{
  private e<b> a = new f(30);
  final ArrayList<b> b = new ArrayList();
  final ArrayList<b> c = new ArrayList();
  final a d;
  Runnable e;
  final boolean f;
  final l g;
  private int h = 0;
  
  a(a parama)
  {
    this(parama, false);
  }
  
  a(a parama, boolean paramBoolean)
  {
    this.d = parama;
    this.f = paramBoolean;
    this.g = new l(this);
  }
  
  private void c(b paramb)
  {
    v(paramb);
  }
  
  private void d(b paramb)
  {
    v(paramb);
  }
  
  private void f(b paramb)
  {
    int i1 = paramb.b;
    int m = paramb.d + i1;
    int j = -1;
    int i = i1;
    int k;
    for (int n = 0; i < m; n = k)
    {
      if ((this.d.c(i) == null) && (!h(i)))
      {
        if (j == 1)
        {
          v(b(2, i1, n, null));
          j = 1;
        }
        else
        {
          j = 0;
        }
        int i2 = 0;
        k = j;
        j = i2;
      }
      else
      {
        if (j == 0)
        {
          k(b(2, i1, n, null));
          k = 1;
        }
        else
        {
          k = 0;
        }
        j = 1;
      }
      if (k != 0)
      {
        i -= n;
        m -= n;
        k = 1;
      }
      else
      {
        k = n + 1;
      }
      i += 1;
    }
    b localb = paramb;
    if (n != paramb.d)
    {
      a(paramb);
      localb = b(2, i1, n, null);
    }
    if (j == 0)
    {
      k(localb);
      return;
    }
    v(localb);
  }
  
  private void g(b paramb)
  {
    int i1 = paramb.b;
    int i3 = paramb.d;
    int j = 0;
    int i2 = -1;
    int i = i1;
    int k = i1;
    while (k < i3 + i1)
    {
      int n;
      if ((this.d.c(k) == null) && (!h(k)))
      {
        n = i;
        m = j;
        if (i2 == 1)
        {
          v(b(4, i, j, paramb.c));
          n = k;
          m = 0;
        }
        j = 0;
        i = n;
        n = m;
      }
      else
      {
        m = i;
        n = j;
        if (i2 == 0)
        {
          k(b(4, i, j, paramb.c));
          m = k;
          n = 0;
        }
        j = 1;
        i = m;
      }
      int m = n + 1;
      k += 1;
      i2 = j;
      j = m;
    }
    Object localObject = paramb;
    if (j != paramb.d)
    {
      localObject = paramb.c;
      a(paramb);
      localObject = b(4, i, j, localObject);
    }
    if (i2 == 0)
    {
      k((b)localObject);
      return;
    }
    v((b)localObject);
  }
  
  private boolean h(int paramInt)
  {
    int m = this.c.size();
    int j = 0;
    while (j < m)
    {
      b localb = (b)this.c.get(j);
      int i = localb.a;
      if (i == 8)
      {
        if (n(localb.d, j + 1) == paramInt) {
          return true;
        }
      }
      else if (i == 1)
      {
        int k = localb.b;
        int n = localb.d;
        i = k;
        while (i < n + k)
        {
          if (n(i, j + 1) == paramInt) {
            return true;
          }
          i += 1;
        }
      }
      j += 1;
    }
    return false;
  }
  
  private void k(b paramb)
  {
    int i = paramb.a;
    if ((i != 1) && (i != 8))
    {
      int k = z(paramb.b, i);
      i = paramb.b;
      int j = paramb.a;
      int m;
      if (j != 2)
      {
        if (j == 4)
        {
          m = 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("op should be remove or update.");
          ((StringBuilder)localObject).append(paramb);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else {
        m = 0;
      }
      int n = 1;
      j = n;
      while (n < paramb.d)
      {
        int i2 = z(paramb.b + m * n, paramb.a);
        int i3 = paramb.a;
        int i1;
        if (i3 != 2)
        {
          if (i3 != 4) {}
          while (i2 != k + 1)
          {
            i1 = 0;
            break;
          }
        }
        for (;;)
        {
          i1 = 1;
          break label177;
          if (i2 != k) {
            break;
          }
        }
        label177:
        if (i1 != 0)
        {
          j += 1;
        }
        else
        {
          localObject = b(i3, k, j, paramb.c);
          l((b)localObject, i);
          a((b)localObject);
          k = i;
          if (paramb.a == 4) {
            k = i + j;
          }
          j = 1;
          i1 = i2;
          i = k;
          k = i1;
        }
        n += 1;
      }
      Object localObject = paramb.c;
      a(paramb);
      if (j > 0)
      {
        paramb = b(paramb.a, k, j, localObject);
        l(paramb, i);
        a(paramb);
      }
      return;
    }
    throw new IllegalArgumentException("should not dispatch add or move for pre layout");
  }
  
  private void v(b paramb)
  {
    this.c.add(paramb);
    int i = paramb.a;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8)
          {
            this.d.a(paramb.b, paramb.d);
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown update op type for ");
          localStringBuilder.append(paramb);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        this.d.h(paramb.b, paramb.d, paramb.c);
        return;
      }
      this.d.d(paramb.b, paramb.d);
      return;
    }
    this.d.e(paramb.b, paramb.d);
  }
  
  private int z(int paramInt1, int paramInt2)
  {
    int j = this.c.size() - 1;
    b localb;
    for (int i = paramInt1; j >= 0; i = paramInt1)
    {
      localb = (b)this.c.get(j);
      int k = localb.a;
      int m;
      if (k == 8)
      {
        k = localb.b;
        m = localb.d;
        int n;
        int i1;
        if (k < m)
        {
          n = k;
          paramInt1 = m;
          i1 = paramInt1;
        }
        else
        {
          i1 = k;
          paramInt1 = m;
          n = paramInt1;
        }
        if ((i >= n) && (i <= i1))
        {
          if (n == k)
          {
            if (paramInt2 == 1) {}
            for (paramInt1 = m + 1;; paramInt1 = m - 1)
            {
              localb.d = paramInt1;
              break;
              if (paramInt2 != 2) {
                break;
              }
            }
            paramInt1 = i + 1;
          }
          else
          {
            if (paramInt2 == 1) {}
            for (paramInt1 = k + 1;; paramInt1 = k - 1)
            {
              localb.b = paramInt1;
              break;
              if (paramInt2 != 2) {
                break;
              }
            }
            paramInt1 = i - 1;
          }
        }
        else
        {
          paramInt1 = i;
          if (i < k)
          {
            if (paramInt2 == 1) {
              localb.b = (k + 1);
            }
            for (paramInt1 = m + 1;; paramInt1 = m - 1)
            {
              localb.d = paramInt1;
              paramInt1 = i;
              break;
              paramInt1 = i;
              if (paramInt2 != 2) {
                break;
              }
              localb.b = (k - 1);
            }
          }
        }
      }
      else
      {
        m = localb.b;
        if (m <= i)
        {
          if (k == 1)
          {
            paramInt1 = i - localb.d;
          }
          else
          {
            paramInt1 = i;
            if (k == 2) {
              paramInt1 = i + localb.d;
            }
          }
        }
        else
        {
          if (paramInt2 == 1) {}
          for (paramInt1 = m + 1;; paramInt1 = m - 1)
          {
            localb.b = paramInt1;
            paramInt1 = i;
            break;
            paramInt1 = i;
            if (paramInt2 != 2) {
              break;
            }
          }
        }
      }
      j -= 1;
    }
    paramInt1 = this.c.size() - 1;
    while (paramInt1 >= 0)
    {
      localb = (b)this.c.get(paramInt1);
      if (localb.a == 8)
      {
        paramInt2 = localb.d;
        if (paramInt2 != localb.b) {
          if (paramInt2 >= 0) {
            break label427;
          }
        }
      }
      else
      {
        if (localb.d > 0) {
          break label427;
        }
      }
      this.c.remove(paramInt1);
      a(localb);
      label427:
      paramInt1 -= 1;
    }
    return i;
  }
  
  public void a(b paramb)
  {
    if (!this.f)
    {
      paramb.c = null;
      this.a.a(paramb);
    }
  }
  
  public b b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    b localb = (b)this.a.b();
    if (localb == null) {
      return new b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localb.a = paramInt1;
    localb.b = paramInt2;
    localb.d = paramInt3;
    localb.c = paramObject;
    return localb;
  }
  
  public int e(int paramInt)
  {
    int m = this.b.size();
    int k = 0;
    for (int i = paramInt; k < m; i = paramInt)
    {
      b localb = (b)this.b.get(k);
      paramInt = localb.a;
      if (paramInt != 1)
      {
        int j;
        if (paramInt != 2)
        {
          if (paramInt != 8)
          {
            paramInt = i;
          }
          else
          {
            paramInt = localb.b;
            if (paramInt == i)
            {
              paramInt = localb.d;
            }
            else
            {
              j = i;
              if (paramInt < i) {
                j = i - 1;
              }
              paramInt = j;
              if (localb.d <= j) {
                paramInt = j + 1;
              }
            }
          }
        }
        else
        {
          j = localb.b;
          paramInt = i;
          if (j <= i)
          {
            paramInt = localb.d;
            if (j + paramInt > i) {
              return -1;
            }
            paramInt = i - paramInt;
          }
        }
      }
      else
      {
        paramInt = i;
        if (localb.b <= i) {
          paramInt = i + localb.d;
        }
      }
      k += 1;
    }
    return i;
  }
  
  void i()
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      this.d.b((b)this.c.get(i));
      i += 1;
    }
    x(this.c);
    this.h = 0;
  }
  
  void j()
  {
    i();
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (b)this.b.get(i);
      int k = ((b)localObject).a;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k == 8)
            {
              this.d.b((b)localObject);
              this.d.a(((b)localObject).b, ((b)localObject).d);
            }
          }
          else
          {
            this.d.b((b)localObject);
            this.d.h(((b)localObject).b, ((b)localObject).d, ((b)localObject).c);
          }
        }
        else
        {
          this.d.b((b)localObject);
          this.d.f(((b)localObject).b, ((b)localObject).d);
        }
      }
      else
      {
        this.d.b((b)localObject);
        this.d.e(((b)localObject).b, ((b)localObject).d);
      }
      localObject = this.e;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      i += 1;
    }
    x(this.b);
    this.h = 0;
  }
  
  void l(b paramb, int paramInt)
  {
    this.d.g(paramb);
    int i = paramb.a;
    if (i != 2)
    {
      if (i == 4)
      {
        this.d.h(paramInt, paramb.d, paramb.c);
        return;
      }
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }
    this.d.f(paramInt, paramb.d);
  }
  
  int m(int paramInt)
  {
    return n(paramInt, 0);
  }
  
  int n(int paramInt1, int paramInt2)
  {
    int k = this.c.size();
    int j = paramInt2;
    for (paramInt2 = paramInt1; j < k; paramInt2 = paramInt1)
    {
      b localb = (b)this.c.get(j);
      int m = localb.a;
      int i;
      if (m == 8)
      {
        paramInt1 = localb.b;
        if (paramInt1 == paramInt2)
        {
          paramInt1 = localb.d;
        }
        else
        {
          i = paramInt2;
          if (paramInt1 < paramInt2) {
            i = paramInt2 - 1;
          }
          paramInt1 = i;
          if (localb.d <= i) {
            paramInt1 = i + 1;
          }
        }
      }
      else
      {
        i = localb.b;
        paramInt1 = paramInt2;
        if (i <= paramInt2) {
          if (m == 2)
          {
            paramInt1 = localb.d;
            if (paramInt2 < i + paramInt1) {
              return -1;
            }
            paramInt1 = paramInt2 - paramInt1;
          }
          else
          {
            paramInt1 = paramInt2;
            if (m == 1) {
              paramInt1 = paramInt2 + localb.d;
            }
          }
        }
      }
      j += 1;
    }
    return paramInt2;
  }
  
  boolean o(int paramInt)
  {
    return (paramInt & this.h) != 0;
  }
  
  boolean p()
  {
    return this.b.size() > 0;
  }
  
  boolean q()
  {
    return (!this.c.isEmpty()) && (!this.b.isEmpty());
  }
  
  boolean r(int paramInt1, int paramInt2, Object paramObject)
  {
    boolean bool = false;
    if (paramInt2 < 1) {
      return false;
    }
    this.b.add(b(4, paramInt1, paramInt2, paramObject));
    this.h |= 0x4;
    if (this.b.size() == 1) {
      bool = true;
    }
    return bool;
  }
  
  boolean s(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 < 1) {
      return false;
    }
    this.b.add(b(1, paramInt1, paramInt2, null));
    this.h |= 0x1;
    if (this.b.size() == 1) {
      bool = true;
    }
    return bool;
  }
  
  boolean t(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt1 == paramInt2) {
      return false;
    }
    if (paramInt3 == 1)
    {
      this.b.add(b(8, paramInt1, paramInt2, null));
      this.h |= 0x8;
      if (this.b.size() == 1) {
        bool = true;
      }
      return bool;
    }
    throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
  }
  
  boolean u(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 < 1) {
      return false;
    }
    this.b.add(b(2, paramInt1, paramInt2, null));
    this.h |= 0x2;
    if (this.b.size() == 1) {
      bool = true;
    }
    return bool;
  }
  
  void w()
  {
    this.g.b(this.b);
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (b)this.b.get(i);
      int k = ((b)localObject).a;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k == 8) {
              d((b)localObject);
            }
          }
          else {
            g((b)localObject);
          }
        }
        else {
          f((b)localObject);
        }
      }
      else {
        c((b)localObject);
      }
      localObject = this.e;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      i += 1;
    }
    this.b.clear();
  }
  
  void x(List<b> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a((b)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  void y()
  {
    x(this.b);
    x(this.c);
    this.h = 0;
  }
  
  static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void b(a.b paramb);
    
    public abstract RecyclerView.c0 c(int paramInt);
    
    public abstract void d(int paramInt1, int paramInt2);
    
    public abstract void e(int paramInt1, int paramInt2);
    
    public abstract void f(int paramInt1, int paramInt2);
    
    public abstract void g(a.b paramb);
    
    public abstract void h(int paramInt1, int paramInt2, Object paramObject);
  }
  
  static final class b
  {
    int a;
    int b;
    Object c;
    int d;
    
    b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.d = paramInt3;
      this.c = paramObject;
    }
    
    String a()
    {
      int i = this.a;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 4)
          {
            if (i != 8) {
              return "??";
            }
            return "mv";
          }
          return "up";
        }
        return "rm";
      }
      return "add";
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      Object localObject = (b)paramObject;
      int i = this.a;
      if (i != ((b)localObject).a) {
        return false;
      }
      if ((i == 8) && (Math.abs(this.d - this.b) == 1) && (this.d == ((b)localObject).b) && (this.b == ((b)localObject).d)) {
        return true;
      }
      if (this.d != ((b)localObject).d) {
        return false;
      }
      if (this.b != ((b)localObject).b) {
        return false;
      }
      paramObject = this.c;
      localObject = ((b)localObject).c;
      if (paramObject != null)
      {
        if (!paramObject.equals(localObject)) {
          return false;
        }
      }
      else if (localObject != null) {
        return false;
      }
      return true;
    }
    
    public int hashCode()
    {
      return (this.a * 31 + this.b) * 31 + this.d;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append("[");
      localStringBuilder.append(a());
      localStringBuilder.append(",s:");
      localStringBuilder.append(this.b);
      localStringBuilder.append("c:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",p:");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.a
 * JD-Core Version:    0.7.0.1
 */