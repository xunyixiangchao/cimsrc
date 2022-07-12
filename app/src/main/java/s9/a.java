package s9;

import aa.d;
import l9.w;
import l9.w.a;

public final class a
{
  public static final a c = new a(null);
  private final d a;
  private long b;
  
  public a(d paramd)
  {
    this.a = paramd;
    this.b = 262144L;
  }
  
  public final w a()
  {
    w.a locala = new w.a();
    for (;;)
    {
      String str = b();
      int i;
      if (str.length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return locala.f();
      }
      locala.c(str);
    }
  }
  
  public final String b()
  {
    String str = this.a.N(this.b);
    this.b -= str.length();
    return str;
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s9.a
 * JD-Core Version:    0.7.0.1
 */