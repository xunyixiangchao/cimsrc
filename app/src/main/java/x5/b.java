package x5;

import com.farsunset.hoxin.micro.entity.MicroServerMenu;
import java.util.List;
import y5.a;

public class b
{
  private static a a;
  
  public static void a(List<MicroServerMenu> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      a.b(paramList);
    }
  }
  
  public static void b(Long paramLong)
  {
    a.a(paramLong);
  }
  
  public static List<MicroServerMenu> c(Long paramLong)
  {
    return a.e(paramLong);
  }
  
  public static void d(a parama)
  {
    a = parama;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x5.b
 * JD-Core Version:    0.7.0.1
 */