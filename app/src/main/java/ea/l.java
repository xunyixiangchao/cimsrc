package ea;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public final class l
{
  private final Method a;
  private final List<?> b;
  
  l(Method paramMethod, List<?> paramList)
  {
    this.a = paramMethod;
    this.b = Collections.unmodifiableList(paramList);
  }
  
  public Method a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return String.format("%s.%s() %s", new Object[] { this.a.getDeclaringClass().getName(), this.a.getName(), this.b });
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.l
 * JD-Core Version:    0.7.0.1
 */