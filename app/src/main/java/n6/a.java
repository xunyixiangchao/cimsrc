package n6;

import com.farsunset.hoxin.organization.api.response.OrganizationResult;
import com.farsunset.hoxin.organization.entity.Organization;
import ea.t;
import java.io.IOException;

public class a
  extends l3.b
{
  public static Organization b(long paramLong)
  {
    Object localObject = (o6.a)l3.b.a(o6.a.class);
    try
    {
      localObject = ((o6.a)localObject).a(paramLong).g();
      if ((((t)localObject).d()) && (((t)localObject).a() != null))
      {
        localObject = ((OrganizationResult)((t)localObject).a()).data;
        return localObject;
      }
    }
    catch (IOException localIOException)
    {
      label49:
      break label49;
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n6.a
 * JD-Core Version:    0.7.0.1
 */