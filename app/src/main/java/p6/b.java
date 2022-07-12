package p6;

import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.organization.entity.DepartmentMember;
import java.util.Collections;
import java.util.List;

public class b
{
  private static q6.a a;
  
  public static void a(DepartmentMember paramDepartmentMember)
  {
    a.a(paramDepartmentMember);
  }
  
  public static void b(List<DepartmentMember> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      a.b(paramList);
    }
  }
  
  public static void c(long paramLong)
  {
    a.f(Long.valueOf(paramLong));
  }
  
  public static List<Friend> d(long paramLong1, long paramLong2)
  {
    List localList = a.d(paramLong1, paramLong2);
    if (localList.isEmpty()) {
      return Collections.emptyList();
    }
    return i4.a.i(localList, true);
  }
  
  public static List<DepartmentMember> e(long paramLong)
  {
    return a.e(paramLong);
  }
  
  public static DepartmentMember f(long paramLong1, long paramLong2)
  {
    return a.c(paramLong1, paramLong2);
  }
  
  public static List<Long> g(long paramLong)
  {
    return a.g(paramLong);
  }
  
  public static void h(q6.a parama)
  {
    a = parama;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p6.b
 * JD-Core Version:    0.7.0.1
 */