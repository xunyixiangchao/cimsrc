package q5;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import u3.l;

public class a
{
  private Set<Long> a = new HashSet();
  private Long b;
  
  public static a c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new a();
    }
    try
    {
      paramString = (a)l.s0(paramString, a.class);
      return paramString;
    }
    catch (Exception paramString)
    {
      label27:
      break label27;
    }
    return new a();
  }
  
  public void a(Long paramLong)
  {
    this.a.add(paramLong);
  }
  
  public void b()
  {
    this.a.clear();
  }
  
  public Set<Long> d()
  {
    return this.a;
  }
  
  public Long e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    return this.a.isEmpty() ^ true;
  }
  
  public boolean g()
  {
    return this.b != null;
  }
  
  public void h(Long paramLong)
  {
    this.a.remove(paramLong);
  }
  
  public void i(Long paramLong)
  {
    this.b = paramLong;
  }
  
  public String toString()
  {
    if ((this.a.isEmpty()) && (this.b == null)) {
      return null;
    }
    return l.H0(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q5.a
 * JD-Core Version:    0.7.0.1
 */