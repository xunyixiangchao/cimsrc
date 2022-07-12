package s3;

import com.farsunset.hoxin.common.model.FileResource;
import g0.a;
import u3.c0;

public class g0
  implements g
{
  private final a<String, Integer> a = new a();
  
  public static g0 a()
  {
    return b.a();
  }
  
  private int b(FileResource paramFileResource)
  {
    paramFileResource = (Integer)this.a.get(paramFileResource.name);
    if (paramFileResource == null) {
      return 0;
    }
    return paramFileResource.intValue();
  }
  
  public void N(FileResource paramFileResource)
  {
    this.a.remove(paramFileResource.name);
  }
  
  public void X(String paramString, float paramFloat) {}
  
  public void z(FileResource paramFileResource, Exception paramException)
  {
    int i = b(paramFileResource);
    if (i >= 3)
    {
      this.a.remove(paramFileResource.name);
      return;
    }
    c0.c(paramFileResource, this);
    this.a.put(paramFileResource.name, Integer.valueOf(i + 1));
  }
  
  private static class b
  {
    private static final g0 a = new g0(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s3.g0
 * JD-Core Version:    0.7.0.1
 */