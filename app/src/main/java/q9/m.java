package q9;

import a9.f;
import java.util.LinkedHashSet;
import java.util.Set;
import l9.h0;

public final class m
{
  private final Set<h0> a = new LinkedHashSet();
  
  public final void a(h0 paramh0)
  {
    try
    {
      f.f(paramh0, "route");
      this.a.remove(paramh0);
      return;
    }
    finally
    {
      paramh0 = finally;
      throw paramh0;
    }
  }
  
  public final void b(h0 paramh0)
  {
    try
    {
      f.f(paramh0, "failedRoute");
      this.a.add(paramh0);
      return;
    }
    finally
    {
      paramh0 = finally;
      throw paramh0;
    }
  }
  
  public final boolean c(h0 paramh0)
  {
    try
    {
      f.f(paramh0, "route");
      boolean bool = this.a.contains(paramh0);
      return bool;
    }
    finally
    {
      paramh0 = finally;
      throw paramh0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.m
 * JD-Core Version:    0.7.0.1
 */