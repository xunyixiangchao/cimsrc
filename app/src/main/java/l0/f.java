package l0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k0.e;

public class f
  implements d
{
  public d a = null;
  public boolean b = false;
  public boolean c = false;
  p d;
  a e = a.a;
  int f;
  public int g;
  int h = 1;
  g i = null;
  public boolean j = false;
  List<d> k = new ArrayList();
  List<f> l = new ArrayList();
  
  public f(p paramp)
  {
    this.d = paramp;
  }
  
  public void a(d paramd)
  {
    paramd = this.l.iterator();
    while (paramd.hasNext()) {
      if (!((f)paramd.next()).j) {
        return;
      }
    }
    this.c = true;
    paramd = this.a;
    if (paramd != null) {
      paramd.a(this);
    }
    if (this.b)
    {
      this.d.a(this);
      return;
    }
    paramd = null;
    int m = 0;
    Iterator localIterator = this.l.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (f)localIterator.next();
      if (!(localObject instanceof g))
      {
        m += 1;
        paramd = (d)localObject;
      }
    }
    if ((paramd != null) && (m == 1) && (paramd.j))
    {
      localObject = this.i;
      if (localObject != null) {
        if (((f)localObject).j) {
          this.f = (this.h * ((f)localObject).g);
        } else {
          return;
        }
      }
      d(paramd.g + this.f);
    }
    paramd = this.a;
    if (paramd != null) {
      paramd.a(this);
    }
  }
  
  public void b(d paramd)
  {
    this.k.add(paramd);
    if (this.j) {
      paramd.a(paramd);
    }
  }
  
  public void c()
  {
    this.l.clear();
    this.k.clear();
    this.j = false;
    this.g = 0;
    this.c = false;
    this.b = false;
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.b.v());
    localStringBuilder.append(":");
    localStringBuilder.append(this.e);
    localStringBuilder.append("(");
    Object localObject;
    if (this.j) {
      localObject = Integer.valueOf(this.g);
    } else {
      localObject = "unresolved";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(") <t=");
    localStringBuilder.append(this.l.size());
    localStringBuilder.append(":d=");
    localStringBuilder.append(this.k.size());
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
  
  static enum a
  {
    static
    {
      a locala1 = new a("UNKNOWN", 0);
      a = locala1;
      a locala2 = new a("HORIZONTAL_DIMENSION", 1);
      b = locala2;
      a locala3 = new a("VERTICAL_DIMENSION", 2);
      c = locala3;
      a locala4 = new a("LEFT", 3);
      d = locala4;
      a locala5 = new a("RIGHT", 4);
      e = locala5;
      a locala6 = new a("TOP", 5);
      f = locala6;
      a locala7 = new a("BOTTOM", 6);
      g = locala7;
      a locala8 = new a("BASELINE", 7);
      h = locala8;
      i = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8 };
    }
    
    private a() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.f
 * JD-Core Version:    0.7.0.1
 */