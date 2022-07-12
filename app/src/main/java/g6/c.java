package g6;

import com.farsunset.hoxin.moment.entity.MomentRule;
import h6.e;
import java.util.List;

public class c
{
  private static e a;
  
  public static void a(MomentRule paramMomentRule)
  {
    a.e(paramMomentRule);
  }
  
  public static boolean b(Long paramLong, byte paramByte)
  {
    return a.c(paramLong, paramByte);
  }
  
  static List<Long> c()
  {
    return a.d();
  }
  
  public static void d(MomentRule paramMomentRule)
  {
    a.a(Long.valueOf(paramMomentRule.targetId), paramMomentRule.type);
  }
  
  public static void e(List<MomentRule> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      a.b(paramList);
    }
  }
  
  public static void f(e parame)
  {
    a = parame;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g6.c
 * JD-Core Version:    0.7.0.1
 */