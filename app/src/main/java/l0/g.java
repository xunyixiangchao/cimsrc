package l0;

import java.util.Iterator;
import java.util.List;

class g
  extends f
{
  public int m;
  
  public g(p paramp)
  {
    super(paramp);
    if ((paramp instanceof l)) {
      paramp = f.a.b;
    } else {
      paramp = f.a.c;
    }
    this.e = paramp;
  }
  
  public void d(int paramInt)
  {
    if (this.j) {
      return;
    }
    this.j = true;
    this.g = paramInt;
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      locald.a(locald);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.g
 * JD-Core Version:    0.7.0.1
 */