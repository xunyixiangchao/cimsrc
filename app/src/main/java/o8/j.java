package o8;

import a9.f;

public final class j
{
  public static final Object a(Throwable paramThrowable)
  {
    f.f(paramThrowable, "exception");
    return new i.b(paramThrowable);
  }
  
  public static final void b(Object paramObject)
  {
    if (!(paramObject instanceof i.b)) {
      return;
    }
    throw ((i.b)paramObject).a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o8.j
 * JD-Core Version:    0.7.0.1
 */