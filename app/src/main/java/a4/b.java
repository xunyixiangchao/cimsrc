package a4;

import b4.a;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import java.util.List;

public class b
{
  private static a a;
  
  public static void a(List<EmoticonItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      a.b(paramList);
    }
  }
  
  public static List<EmoticonItem> b(long paramLong)
  {
    return a.e(paramLong);
  }
  
  public static void c(a parama)
  {
    a = parama;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a4.b
 * JD-Core Version:    0.7.0.1
 */