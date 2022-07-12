package d1;

import android.content.Context;
import android.net.Uri;

public abstract class a
{
  private final a a;
  
  a(a parama)
  {
    this.a = parama;
  }
  
  public static a a(Context paramContext, Uri paramUri)
  {
    return new c(null, paramContext, paramUri);
  }
  
  public abstract String b();
  
  public abstract long c();
  
  public abstract long d();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d1.a
 * JD-Core Version:    0.7.0.1
 */