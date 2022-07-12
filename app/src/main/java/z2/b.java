package z2;

import android.net.NetworkInfo;
import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.SentBody;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class b
{
  private static final ArrayList<a> a = new ArrayList();
  private static final b b = new b(null);
  
  public static void a()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a();
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).h(paramBoolean);
    }
  }
  
  public static void c()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).i();
    }
  }
  
  public static void d(NetworkInfo paramNetworkInfo)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).f(paramNetworkInfo);
    }
  }
  
  public static void e(ReplyBody paramReplyBody)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).g(paramReplyBody);
    }
  }
  
  public static void f(SentBody paramSentBody)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramSentBody);
    }
  }
  
  private static class b
    implements Comparator<a>
  {
    public int a(a parama1, a parama2)
    {
      int i = parama1.c();
      return Integer.compare(parama2.c(), i);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z2.b
 * JD-Core Version:    0.7.0.1
 */