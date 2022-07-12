package q9;

import a9.f;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m9.l;
import o8.h;

public final class g
{
  public static final List<InetAddress> a(List<? extends InetAddress> paramList)
  {
    f.f(paramList, "addresses");
    if (paramList.size() < 2) {
      return paramList;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (((InetAddress)localObject4 instanceof Inet6Address)) {
        ((ArrayList)localObject1).add(localObject4);
      } else {
        ((ArrayList)localObject2).add(localObject4);
      }
    }
    localObject1 = new h(localObject1, localObject2);
    localObject2 = (List)((h)localObject1).a();
    localObject3 = (List)((h)localObject1).b();
    localObject1 = paramList;
    if (!((List)localObject2).isEmpty())
    {
      if (((List)localObject3).isEmpty()) {
        return paramList;
      }
      localObject1 = l.v((Iterable)localObject2, (Iterable)localObject3);
    }
    return localObject1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.g
 * JD-Core Version:    0.7.0.1
 */