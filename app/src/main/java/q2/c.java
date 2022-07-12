package q2;

import android.content.Context;

final class c
  implements a
{
  private final Context a;
  final a.a b;
  
  c(Context paramContext, a.a parama)
  {
    this.a = paramContext.getApplicationContext();
    this.b = parama;
  }
  
  private void e()
  {
    j.a(this.a).d(this.b);
  }
  
  private void h()
  {
    j.a(this.a).e(this.b);
  }
  
  public void a()
  {
    e();
  }
  
  public void d()
  {
    h();
  }
  
  public void onDestroy() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q2.c
 * JD-Core Version:    0.7.0.1
 */