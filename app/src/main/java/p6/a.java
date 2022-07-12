package p6;

import com.farsunset.hoxin.organization.entity.Department;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q6.c;

public class a
{
  private static c a;
  
  public static void a(Department paramDepartment)
  {
    a.h(paramDepartment);
  }
  
  public static void b(List<Department> paramList)
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
  
  public static void d(long paramLong)
  {
    a.g(Long.valueOf(paramLong));
  }
  
  public static List<Department> e(long paramLong)
  {
    return a.i(paramLong);
  }
  
  public static List<Department> f(String paramString)
  {
    c localc = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    return localc.d(localStringBuilder.toString());
  }
  
  public static Map<Long, String> g(long paramLong)
  {
    Object localObject = a.e(Long.valueOf(paramLong));
    HashMap localHashMap = new HashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Department localDepartment = (Department)((Iterator)localObject).next();
      localHashMap.put(localDepartment.id, localDepartment.name);
    }
    return localHashMap;
  }
  
  public static Department h(long paramLong)
  {
    return a.c(Long.valueOf(paramLong));
  }
  
  public static List<Department> i(long paramLong)
  {
    return a.a(Long.valueOf(paramLong));
  }
  
  public static void j(c paramc)
  {
    a = paramc;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p6.a
 * JD-Core Version:    0.7.0.1
 */