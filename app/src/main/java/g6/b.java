package g6;

import android.text.TextUtils;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.moment.entity.Moment;
import i3.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import u3.b0;
import u3.l;

public class b
{
  private static h6.c a;
  
  public static void a(Moment paramMoment)
  {
    a.f(paramMoment);
    a.b(paramMoment.getCommentList());
  }
  
  public static void b(List<Moment> paramList)
  {
    a.b(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Moment localMoment = (Moment)paramList.next();
      a.e(localMoment.id);
      a.b(localMoment.getCommentList());
    }
  }
  
  public static void c(long paramLong)
  {
    a.a(Long.valueOf(paramLong));
    a.e(paramLong);
  }
  
  public static void d()
  {
    a.h();
    a.d();
  }
  
  public static void e(long paramLong)
  {
    a.l(paramLong);
  }
  
  public static List<Moment> f(String paramString)
  {
    if (TextUtils.isEmpty(paramString.trim())) {
      return Collections.emptyList();
    }
    h6.c localc = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    return localc.d(localStringBuilder.toString());
  }
  
  public static Moment g(long paramLong)
  {
    Moment localMoment = a.c(Long.valueOf(paramLong));
    if (localMoment == null) {
      return null;
    }
    localMoment.setCommentList(a.f(paramLong));
    return localMoment;
  }
  
  public static List<String> h(long paramLong)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = a.j(Long.valueOf(paramLong)).iterator();
    while (localIterator.hasNext())
    {
      localObject = (Moment)localIterator.next();
      int i = ((Moment)localObject).type;
      if (i == 2) {}
      for (localObject = ((CloudVideo)l.s0(((Moment)localObject).content, CloudVideo.class)).image;; localObject = ((CloudImage)l.s0(((Moment)localObject).content, CloudImage.class)).thumb)
      {
        localLinkedList.add(b0.h((String)localObject));
        break;
        if (i != 0) {
          break label113;
        }
      }
      label113:
      if (i == 4)
      {
        localObject = l.u0(((Moment)localObject).content, CloudImage.class).iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(b0.h(((CloudImage)((Iterator)localObject).next()).thumb));
        }
      }
    }
    Object localObject = localLinkedList;
    if (localLinkedList.size() > 4) {
      localObject = localLinkedList.subList(0, 4);
    }
    return localObject;
  }
  
  public static boolean i()
  {
    return a.isEmpty();
  }
  
  public static boolean j(long paramLong)
  {
    return a.i(paramLong);
  }
  
  public static List<Moment> k()
  {
    ArrayList localArrayList = new ArrayList(c.c());
    localArrayList.remove(e.o());
    List localList1;
    if (localArrayList.isEmpty()) {
      localList1 = a.e(20L);
    } else {
      localList1 = a.k(localArrayList, 20L);
    }
    Iterator localIterator = localList1.iterator();
    while (localIterator.hasNext())
    {
      Moment localMoment = (Moment)localIterator.next();
      List localList2;
      if (localArrayList.isEmpty()) {
        localList2 = a.f(localMoment.id);
      } else {
        localList2 = a.g(localMoment.id, localArrayList);
      }
      localMoment.setCommentList(localList2);
    }
    return localList1;
  }
  
  public static List<Moment> l(Long paramLong)
  {
    return a.g(paramLong, 20L);
  }
  
  public static void m(h6.c paramc)
  {
    a = paramc;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g6.b
 * JD-Core Version:    0.7.0.1
 */