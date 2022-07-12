package k2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import b2.h;
import b2.j;
import d2.v;
import e2.d;
import m2.e;

public class x
  implements j<Uri, Bitmap>
{
  private final e a;
  private final d b;
  
  public x(e parame, d paramd)
  {
    this.a = parame;
    this.b = paramd;
  }
  
  public v<Bitmap> c(Uri paramUri, int paramInt1, int paramInt2, h paramh)
  {
    paramUri = this.a.c(paramUri, paramInt1, paramInt2, paramh);
    if (paramUri == null) {
      return null;
    }
    paramUri = (Drawable)paramUri.get();
    return n.a(this.b, paramUri, paramInt1, paramInt2);
  }
  
  public boolean d(Uri paramUri, h paramh)
  {
    return "android.resource".equals(paramUri.getScheme());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.x
 * JD-Core Version:    0.7.0.1
 */