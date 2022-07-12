package f2;

import java.io.File;

public class d
  implements a.a
{
  private final long a;
  private final a b;
  
  public d(a parama, long paramLong)
  {
    this.a = paramLong;
    this.b = parama;
  }
  
  public a build()
  {
    File localFile = this.b.a();
    if (localFile == null) {
      return null;
    }
    if ((!localFile.isDirectory()) && (!localFile.mkdirs())) {
      return null;
    }
    return e.c(localFile, this.a);
  }
  
  public static abstract interface a
  {
    public abstract File a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f2.d
 * JD-Core Version:    0.7.0.1
 */