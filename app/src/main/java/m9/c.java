package m9;

import a9.f;
import l9.h;

public final class c
{
  public static final boolean a(h paramh, Object paramObject)
  {
    f.f(paramh, "<this>");
    if ((paramObject instanceof h))
    {
      paramObject = (h)paramObject;
      if ((f.a(paramObject.d(), paramh.d())) && (f.a(paramObject.a(), paramh.a()))) {
        return true;
      }
    }
    return false;
  }
  
  public static final int b(h paramh)
  {
    f.f(paramh, "<this>");
    return (899 + paramh.d().hashCode()) * 31 + paramh.a().hashCode();
  }
  
  public static final String c(h paramh)
  {
    f.f(paramh, "<this>");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramh.d());
    localStringBuilder.append(" authParams=");
    localStringBuilder.append(paramh.a());
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.c
 * JD-Core Version:    0.7.0.1
 */