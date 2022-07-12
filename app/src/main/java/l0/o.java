package l0;

import h0.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import k0.b;
import k0.e;
import k0.f;

public class o
{
  static int g;
  ArrayList<e> a = new ArrayList();
  int b;
  boolean c = false;
  int d;
  ArrayList<a> e = null;
  private int f = -1;
  
  public o(int paramInt)
  {
    int i = g;
    g = i + 1;
    this.b = i;
    this.d = paramInt;
  }
  
  private String e()
  {
    int i = this.d;
    if (i == 0) {
      return "Horizontal";
    }
    if (i == 1) {
      return "Vertical";
    }
    if (i == 2) {
      return "Both";
    }
    return "Unknown";
  }
  
  private int j(d paramd, ArrayList<e> paramArrayList, int paramInt)
  {
    int j = 0;
    f localf = (f)((e)paramArrayList.get(0)).M();
    paramd.D();
    localf.g(paramd, false);
    int i = 0;
    while (i < paramArrayList.size())
    {
      ((e)paramArrayList.get(i)).g(paramd, false);
      i += 1;
    }
    if ((paramInt == 0) && (localf.g1 > 0)) {
      b.b(localf, paramd, paramArrayList, 0);
    }
    if ((paramInt == 1) && (localf.h1 > 0)) {
      b.b(localf, paramd, paramArrayList, 1);
    }
    try
    {
      paramd.z();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.e = new ArrayList();
    i = j;
    while (i < paramArrayList.size())
    {
      a locala = new a((e)paramArrayList.get(i), paramd, paramInt);
      this.e.add(locala);
      i += 1;
    }
    if (paramInt == 0) {
      paramInt = paramd.x(localf.Q);
    }
    for (paramArrayList = localf.S;; paramArrayList = localf.T)
    {
      i = paramd.x(paramArrayList);
      paramd.D();
      return i - paramInt;
      paramInt = paramd.x(localf.R);
    }
  }
  
  public boolean a(e parame)
  {
    if (this.a.contains(parame)) {
      return false;
    }
    this.a.add(parame);
    return true;
  }
  
  public void b(ArrayList<o> paramArrayList)
  {
    int j = this.a.size();
    if ((this.f != -1) && (j > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        o localo = (o)paramArrayList.get(i);
        if (this.f == localo.b) {
          g(this.d, localo);
        }
        i += 1;
      }
    }
    if (j == 0) {
      paramArrayList.remove(this);
    }
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int f(d paramd, int paramInt)
  {
    if (this.a.size() == 0) {
      return 0;
    }
    return j(paramd, this.a, paramInt);
  }
  
  public void g(int paramInt, o paramo)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      paramo.a(locale);
      int i = paramo.c();
      if (paramInt == 0) {
        locale.S0 = i;
      } else {
        locale.T0 = i;
      }
    }
    this.f = paramo.b;
  }
  
  public void h(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void i(int paramInt)
  {
    this.d = paramInt;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(e());
    ((StringBuilder)localObject1).append(" [");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append("] <");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.a.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" ");
      localStringBuilder.append(locale.v());
      localObject1 = localStringBuilder.toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" >");
    return ((StringBuilder)localObject2).toString();
  }
  
  class a
  {
    WeakReference<e> a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    
    public a(e parame, d paramd, int paramInt)
    {
      this.a = new WeakReference(parame);
      this.b = paramd.x(parame.Q);
      this.c = paramd.x(parame.R);
      this.d = paramd.x(parame.S);
      this.e = paramd.x(parame.T);
      this.f = paramd.x(parame.U);
      this.g = paramInt;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.o
 * JD-Core Version:    0.7.0.1
 */