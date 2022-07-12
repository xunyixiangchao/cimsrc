package w8;

import a9.f;

public class a
  extends v8.a
{
  public void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    f.f(paramThrowable1, "cause");
    f.f(paramThrowable2, "exception");
    paramThrowable1.addSuppressed(paramThrowable2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w8.a
 * JD-Core Version:    0.7.0.1
 */