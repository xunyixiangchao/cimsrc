package f9;

import a9.f;
import b9.a;
import c9.g;
import java.util.Iterator;
import java.util.NoSuchElementException;
import o8.h;

final class e
  implements e9.c<c9.c>
{
  private final CharSequence a;
  private final int b;
  private final int c;
  private final z8.c<CharSequence, Integer, h<Integer, Integer>> d;
  
  public e(CharSequence paramCharSequence, int paramInt1, int paramInt2, z8.c<? super CharSequence, ? super Integer, h<Integer, Integer>> paramc)
  {
    this.a = paramCharSequence;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramc;
  }
  
  public Iterator<c9.c> iterator()
  {
    return new a(this);
  }
  
  public static final class a
    implements Iterator<c9.c>, a
  {
    private int a = -1;
    private int b;
    private int c;
    private c9.c d;
    private int e;
    
    a(e parame)
    {
      int i = g.e(e.e(parame), 0, e.c(parame).length());
      this.b = i;
      this.c = i;
    }
    
    private final void a()
    {
      int j = this.c;
      int i = 0;
      if (j < 0)
      {
        this.a = 0;
        this.d = null;
        return;
      }
      int k = e.d(this.f);
      j = -1;
      if (k > 0)
      {
        k = this.e + 1;
        this.e = k;
        if (k >= e.d(this.f)) {}
      }
      else
      {
        if (this.c <= e.c(this.f).length()) {
          break label117;
        }
      }
      Object localObject = new c9.c(this.b, v.H(e.c(this.f)));
      this.d = ((c9.c)localObject);
      for (i = j;; i = k + i)
      {
        this.c = i;
        break label237;
        label117:
        localObject = (h)e.b(this.f).a(e.c(this.f), Integer.valueOf(this.c));
        if (localObject == null)
        {
          localObject = new c9.c(this.b, v.H(e.c(this.f)));
          break;
        }
        k = ((Number)((h)localObject).a()).intValue();
        j = ((Number)((h)localObject).b()).intValue();
        this.d = g.i(this.b, k);
        k += j;
        this.b = k;
        if (j == 0) {
          i = 1;
        }
      }
      label237:
      this.a = 1;
    }
    
    public c9.c b()
    {
      if (this.a == -1) {
        a();
      }
      if (this.a != 0)
      {
        c9.c localc = this.d;
        f.d(localc, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.d = null;
        this.a = -1;
        return localc;
      }
      throw new NoSuchElementException();
    }
    
    public boolean hasNext()
    {
      if (this.a == -1) {
        a();
      }
      return this.a == 1;
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.e
 * JD-Core Version:    0.7.0.1
 */