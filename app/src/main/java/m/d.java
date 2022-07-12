package m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import s.n0;
import s.s1;

public final class d
  extends s1<c>
{
  public d(c... paramVarArgs)
  {
    a(Arrays.asList(paramVarArgs));
  }
  
  public static d e()
  {
    return new d(new c[0]);
  }
  
  public s1<c> b()
  {
    d locald = e();
    locald.a(c());
    return locald;
  }
  
  public a d()
  {
    return new a(c());
  }
  
  public static final class a
  {
    private final List<c> a = new ArrayList();
    
    a(List<c> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        c localc = (c)paramList.next();
        this.a.add(localc);
      }
    }
    
    public List<n0> a()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        n0 localn0 = ((c)localIterator.next()).d();
        if (localn0 != null) {
          localArrayList.add(localn0);
        }
      }
      return localArrayList;
    }
    
    public List<n0> b()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        n0 localn0 = ((c)localIterator.next()).e();
        if (localn0 != null) {
          localArrayList.add(localn0);
        }
      }
      return localArrayList;
    }
    
    public List<n0> c()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        n0 localn0 = ((c)localIterator.next()).f();
        if (localn0 != null) {
          localArrayList.add(localn0);
        }
      }
      return localArrayList;
    }
    
    public List<n0> d()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        n0 localn0 = ((c)localIterator.next()).g();
        if (localn0 != null) {
          localArrayList.add(localn0);
        }
      }
      return localArrayList;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m.d
 * JD-Core Version:    0.7.0.1
 */