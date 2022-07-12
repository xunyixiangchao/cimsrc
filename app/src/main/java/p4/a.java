package p4;

import android.text.TextUtils;
import com.farsunset.hoxin.group.entity.Group;
import i3.e;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import q4.c;

public abstract class a
{
  private static c a;
  
  public static void a(Group paramGroup)
  {
    a.h(paramGroup);
    b.e(paramGroup.id);
    b.c(paramGroup.memberList);
  }
  
  public static void b(List<Group> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      a.b(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Group localGroup = (Group)paramList.next();
        b.e(localGroup.id);
        b.c(localGroup.memberList);
      }
    }
  }
  
  public static void c(Long paramLong)
  {
    a.j(paramLong);
  }
  
  public static void d(Long paramLong)
  {
    a.a(paramLong);
  }
  
  public static boolean e(long paramLong)
  {
    return a.f(Long.valueOf(paramLong));
  }
  
  public static List<Group> f()
  {
    return a.e();
  }
  
  public static List<Group> g(String paramString)
  {
    if (TextUtils.isEmpty(paramString.trim())) {
      return Collections.emptyList();
    }
    c localc = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    return localc.d(localStringBuilder.toString());
  }
  
  public static Group h(Long paramLong)
  {
    return a.c(paramLong);
  }
  
  public static boolean i(Long paramLong)
  {
    return a.l(paramLong);
  }
  
  public static boolean j(Long paramLong)
  {
    return a.o(paramLong);
  }
  
  public static boolean k(long paramLong)
  {
    return a.i(paramLong, e.o());
  }
  
  public static void l(Long paramLong)
  {
    a.a(paramLong);
  }
  
  public static void m(c paramc)
  {
    a = paramc;
  }
  
  public static void n(long paramLong1, long paramLong2)
  {
    Group localGroup = h(Long.valueOf(paramLong1));
    a.k(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    b.r(Long.valueOf(paramLong1), Long.valueOf(localGroup.uid), (byte)0);
    b.r(Long.valueOf(paramLong1), Long.valueOf(paramLong2), (byte)1);
  }
  
  public static void o(Long paramLong)
  {
    a.m(paramLong);
  }
  
  public static void p(Long paramLong, String paramString)
  {
    a.g(paramLong, paramString);
  }
  
  public static void q(Long paramLong, String paramString)
  {
    a.n(paramLong, paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p4.a
 * JD-Core Version:    0.7.0.1
 */