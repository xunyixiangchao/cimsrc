package p2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import b2.h;
import d2.v;
import k2.u;
import x2.k;

public class b
  implements e<Bitmap, BitmapDrawable>
{
  private final Resources a;
  
  public b(Resources paramResources)
  {
    this.a = ((Resources)k.d(paramResources));
  }
  
  public v<BitmapDrawable> a(v<Bitmap> paramv, h paramh)
  {
    return u.f(this.a, paramv);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p2.b
 * JD-Core Version:    0.7.0.1
 */