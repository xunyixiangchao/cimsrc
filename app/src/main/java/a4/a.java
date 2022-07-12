package a4;

import b4.c;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class a
{
  private static c a;
  
  public static void a(Emoticon paramEmoticon)
  {
    paramEmoticon.index = System.currentTimeMillis();
    a.g(paramEmoticon);
    b.a(paramEmoticon.itemList);
  }
  
  public static void b(List<Emoticon> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      AtomicLong localAtomicLong = new AtomicLong(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)paramList.next();
        localEmoticon.index = localAtomicLong.getAndDecrement();
        a.g(localEmoticon);
        b.a(localEmoticon.itemList);
      }
    }
  }
  
  public static void c(long paramLong)
  {
    a.i(Long.valueOf(paramLong));
  }
  
  public static void d(long paramLong)
  {
    a.f(Long.valueOf(paramLong));
  }
  
  public static boolean e(long paramLong)
  {
    return a.j(paramLong) > 0L;
  }
  
  public static List<Emoticon> f()
  {
    return a.k();
  }
  
  public static List<Emoticon> g()
  {
    List localList = a.e();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Emoticon localEmoticon = (Emoticon)localIterator.next();
      localEmoticon.itemList = b.b(localEmoticon.id.longValue());
    }
    return localList;
  }
  
  public static Emoticon h(long paramLong)
  {
    return a.a(paramLong);
  }
  
  public static boolean i(long paramLong)
  {
    c localc = a;
    boolean bool = false;
    if ((localc.h(paramLong, (byte)0) > 0L) || (a.h(paramLong, (byte)1) > 0L)) {
      bool = true;
    }
    return bool;
  }
  
  public static void j(c paramc)
  {
    a = paramc;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a4.a
 * JD-Core Version:    0.7.0.1
 */