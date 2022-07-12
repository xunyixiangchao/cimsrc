package p4;

import com.farsunset.hoxin.group.entity.GroupMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q4.a;
import u3.b0;

public class b
{
  private static a a;
  
  public static void a(GroupMember paramGroupMember)
  {
    a.i(paramGroupMember);
  }
  
  public static void b(Long paramLong, long paramLong1, String paramString)
  {
    GroupMember localGroupMember = new GroupMember();
    localGroupMember.groupId = paramLong.longValue();
    localGroupMember.uid = paramLong1;
    localGroupMember.type = 0;
    localGroupMember.name = paramString;
    a(localGroupMember);
  }
  
  public static void c(List<GroupMember> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((GroupMember)paramList.next());
      }
    }
  }
  
  public static long d(Long paramLong)
  {
    return a.c(paramLong);
  }
  
  public static void e(long paramLong)
  {
    a.a(Long.valueOf(paramLong));
  }
  
  public static boolean f(Long paramLong1, Long paramLong2)
  {
    return a.j(paramLong1, paramLong2);
  }
  
  public static List<GroupMember> g(Long paramLong)
  {
    return a.e(paramLong);
  }
  
  public static List<GroupMember> h(Long paramLong, long paramLong1)
  {
    return a.g(paramLong, paramLong1);
  }
  
  public static List<GroupMember> i(Long paramLong, String paramString)
  {
    a locala = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    return locala.n(paramLong, localStringBuilder.toString());
  }
  
  public static List<GroupMember> j(Long paramLong, List<Long> paramList)
  {
    return a.o(paramLong, paramList);
  }
  
  public static List<GroupMember> k(Long paramLong, List<Long> paramList, String paramString)
  {
    a locala = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    return locala.l(paramLong, paramList, localStringBuilder.toString());
  }
  
  public static String l(Long paramLong1, Long paramLong2)
  {
    return a.f(paramLong1, paramLong2);
  }
  
  public static GroupMember m(long paramLong, Long paramLong1)
  {
    return a.k(Long.valueOf(paramLong), paramLong1);
  }
  
  public static List<String> n(long paramLong, int paramInt)
  {
    Object localObject = a.d(Long.valueOf(paramLong), paramInt);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(b0.l(((Long)((Iterator)localObject).next()).longValue()));
    }
    return localArrayList;
  }
  
  public static List<Long> o(long paramLong)
  {
    return a.m(Long.valueOf(paramLong));
  }
  
  public static void p(Long paramLong1, Long paramLong2)
  {
    a.b(paramLong1, paramLong2);
  }
  
  public static void q(a parama)
  {
    a = parama;
  }
  
  public static void r(Long paramLong1, Long paramLong2, byte paramByte)
  {
    a.h(paramLong1, paramLong2, paramByte);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p4.b
 * JD-Core Version:    0.7.0.1
 */