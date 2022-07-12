package v7;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y7.n;

public final class g
{
  private x7.d a = x7.d.g;
  private u b = u.a;
  private e c = d.a;
  private final Map<Type, h<?>> d = new HashMap();
  private final List<w> e = new ArrayList();
  private final List<w> f = new ArrayList();
  private boolean g = false;
  private String h;
  private int i = 2;
  private int j = 2;
  private boolean k = false;
  private boolean l = false;
  private boolean m = true;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  
  private void b(String paramString, int paramInt1, int paramInt2, List<w> paramList)
  {
    a locala2;
    a locala1;
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      a locala3 = new a(java.util.Date.class, paramString);
      locala2 = new a(Timestamp.class, paramString);
      locala1 = new a(java.sql.Date.class, paramString);
      paramString = locala3;
    }
    else
    {
      if ((paramInt1 == 2) || (paramInt2 == 2)) {
        return;
      }
      paramString = new a(java.util.Date.class, paramInt1, paramInt2);
      locala2 = new a(Timestamp.class, paramInt1, paramInt2);
      locala1 = new a(java.sql.Date.class, paramInt1, paramInt2);
    }
    paramList.add(n.b(java.util.Date.class, paramString));
    paramList.add(n.b(Timestamp.class, locala2));
    paramList.add(n.b(java.sql.Date.class, locala1));
  }
  
  public g a(b paramb)
  {
    this.a = this.a.p(paramb, true, false);
    return this;
  }
  
  public f c()
  {
    ArrayList localArrayList1 = new ArrayList(this.e.size() + this.f.size() + 3);
    localArrayList1.addAll(this.e);
    Collections.reverse(localArrayList1);
    ArrayList localArrayList2 = new ArrayList(this.f);
    Collections.reverse(localArrayList2);
    localArrayList1.addAll(localArrayList2);
    b(this.h, this.i, this.j, localArrayList1);
    return new f(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.b, this.h, this.i, this.j, this.e, this.f, localArrayList1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.g
 * JD-Core Version:    0.7.0.1
 */