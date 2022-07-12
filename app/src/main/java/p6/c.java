package p6;

import com.farsunset.hoxin.organization.entity.Department;
import com.farsunset.hoxin.organization.entity.DepartmentMember;
import com.farsunset.hoxin.organization.entity.Organization;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q6.e;

public class c
{
  private static e a;
  
  public static void a(Organization paramOrganization)
  {
    if (paramOrganization == null) {
      return;
    }
    a.d(paramOrganization);
    a.c(paramOrganization.id.longValue());
    a.b(paramOrganization.departmentList);
    b.c(paramOrganization.id.longValue());
    b.b(paramOrganization.memberList);
  }
  
  public static void b()
  {
    a.c();
  }
  
  public static Organization c()
  {
    return a.b();
  }
  
  public static Organization d(long paramLong)
  {
    return a.a(paramLong);
  }
  
  public static String e(long paramLong)
  {
    Organization localOrganization = c();
    if (localOrganization == null) {
      return null;
    }
    DepartmentMember localDepartmentMember = b.f(localOrganization.id.longValue(), paramLong);
    if (localDepartmentMember == null) {
      return localOrganization.name;
    }
    Department localDepartment = a.h(localDepartmentMember.departmentId.longValue());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localOrganization.name);
    localStringBuilder.append("-");
    localStringBuilder.append(localDepartment.name);
    localStringBuilder.append("-");
    localStringBuilder.append(localDepartmentMember.title);
    return localStringBuilder.toString();
  }
  
  public static Map<Long, String> f()
  {
    Organization localOrganization = c();
    if (localOrganization == null) {
      return Collections.emptyMap();
    }
    Map localMap = a.g(localOrganization.id.longValue());
    Object localObject = b.e(localOrganization.id.longValue());
    HashMap localHashMap = new HashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DepartmentMember localDepartmentMember = (DepartmentMember)((Iterator)localObject).next();
      Long localLong = localDepartmentMember.uid;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localOrganization.name);
      localStringBuilder.append("-");
      localStringBuilder.append((String)localMap.get(localDepartmentMember.departmentId));
      localStringBuilder.append("-");
      localStringBuilder.append(localDepartmentMember.title);
      localHashMap.put(localLong, localStringBuilder.toString());
    }
    return localHashMap;
  }
  
  public static void g(e parame)
  {
    a = parame;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p6.c
 * JD-Core Version:    0.7.0.1
 */