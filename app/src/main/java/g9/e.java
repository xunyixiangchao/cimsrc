package g9;

import a9.f;
import java.util.concurrent.TimeUnit;

class e
{
  public static final long a(long paramLong, d paramd1, d paramd2)
  {
    f.f(paramd1, "sourceUnit");
    f.f(paramd2, "targetUnit");
    return paramd2.b().convert(paramLong, paramd1.b());
  }
  
  public static final long b(long paramLong, d paramd1, d paramd2)
  {
    f.f(paramd1, "sourceUnit");
    f.f(paramd2, "targetUnit");
    return paramd2.b().convert(paramLong, paramd1.b());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g9.e
 * JD-Core Version:    0.7.0.1
 */