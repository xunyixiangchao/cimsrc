package g6;

import com.farsunset.hoxin.moment.entity.Comment;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static h6.a a;
  
  public static void a(Comment paramComment)
  {
    a.d(paramComment);
  }
  
  public static void b(List<Comment> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      a.b(paramList);
    }
  }
  
  public static void c(Long paramLong)
  {
    a.a(paramLong);
  }
  
  public static void d()
  {
    a.h();
  }
  
  public static void e(long paramLong)
  {
    a.f(Long.valueOf(paramLong));
  }
  
  public static List<Comment> f(long paramLong)
  {
    return g(paramLong, new ArrayList(c.c()));
  }
  
  public static List<Comment> g(long paramLong, List<Long> paramList)
  {
    if (paramList.isEmpty()) {
      return a.e(Long.valueOf(paramLong));
    }
    return a.i(paramLong, paramList);
  }
  
  public static Comment h(long paramLong)
  {
    return a.c(Long.valueOf(paramLong));
  }
  
  public static void i(h6.a parama)
  {
    a = parama;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g6.a
 * JD-Core Version:    0.7.0.1
 */