package androidx.camera.extensions;

import a0.n;
import androidx.camera.core.q;
import androidx.camera.core.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s.c1;
import s.e0;

final class a
  implements q
{
  private final c1 b;
  private final n c;
  
  a(String paramString, n paramn)
  {
    this.b = c1.a(paramString);
    this.c = paramn;
  }
  
  public c1 a()
  {
    return this.b;
  }
  
  public List<r> b(List<r> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      r localr = (r)paramList.next();
      x0.h.b(localr instanceof e0, "The camera info doesn't contain internal implementation.");
      String str = r.h.b(localr).e();
      Map localMap = r.h.b(localr).d();
      if (this.c.c(str, localMap)) {
        localArrayList.add(localr);
      }
    }
    return localArrayList;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.extensions.a
 * JD-Core Version:    0.7.0.1
 */