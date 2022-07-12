package s;

import androidx.camera.core.m1;
import androidx.camera.core.n1;
import androidx.camera.core.v;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class h0
{
  private final Object a = new Object();
  private final Map<String, g0> b = new LinkedHashMap();
  private final Set<g0> c = new HashSet();
  
  public LinkedHashSet<g0> a()
  {
    synchronized (this.a)
    {
      LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.b.values());
      return localLinkedHashSet;
    }
  }
  
  public void b(d0 paramd0)
  {
    synchronized (this.a)
    {
      try
      {
        Iterator localIterator = paramd0.c().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Added camera: ");
          localStringBuilder.append(str);
          n1.a("CameraRepository", localStringBuilder.toString());
          this.b.put(str, paramd0.a(str));
        }
        return;
      }
      catch (v paramd0)
      {
        throw new m1(paramd0);
      }
      throw paramd0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.h0
 * JD-Core Version:    0.7.0.1
 */