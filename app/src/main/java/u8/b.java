package u8;

import s8.a;
import s8.c;

public final class b
  implements a<Object>
{
  public static final b a = new b();
  
  public void a(Object paramObject)
  {
    throw new IllegalStateException("This continuation is already complete".toString());
  }
  
  public c c()
  {
    throw new IllegalStateException("This continuation is already complete".toString());
  }
  
  public String toString()
  {
    return "This continuation is already complete";
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u8.b
 * JD-Core Version:    0.7.0.1
 */