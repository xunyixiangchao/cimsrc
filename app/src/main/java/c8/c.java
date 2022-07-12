package c8;

import android.os.Build.VERSION;
import e8.b;
import e8.d;
import e8.f;
import i8.e;

public class c
  implements f8.a
{
  private static final a b;
  private static final b c = new g8.a();
  private l8.c a;
  
  static
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 26) {
      localObject = new f();
    } else {
      localObject = new d();
    }
    b = (a)localObject;
  }
  
  public c(l8.c paramc)
  {
    this.a = paramc;
  }
  
  public b a()
  {
    return b.a(this.a);
  }
  
  public j8.a b()
  {
    return new e(this.a);
  }
  
  public static abstract interface a
  {
    public abstract b a(l8.c paramc);
  }
  
  public static abstract interface b {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c8.c
 * JD-Core Version:    0.7.0.1
 */