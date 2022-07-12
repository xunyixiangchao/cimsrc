package p2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import b2.h;
import d2.v;
import e2.d;

public final class c
  implements e<Drawable, byte[]>
{
  private final d a;
  private final e<Bitmap, byte[]> b;
  private final e<o2.c, byte[]> c;
  
  public c(d paramd, e<Bitmap, byte[]> parame, e<o2.c, byte[]> parame1)
  {
    this.a = paramd;
    this.b = parame;
    this.c = parame1;
  }
  
  private static v<o2.c> b(v<Drawable> paramv)
  {
    return paramv;
  }
  
  public v<byte[]> a(v<Drawable> paramv, h paramh)
  {
    Drawable localDrawable = (Drawable)paramv.get();
    if ((localDrawable instanceof BitmapDrawable)) {
      return this.b.a(k2.e.f(((BitmapDrawable)localDrawable).getBitmap(), this.a), paramh);
    }
    if ((localDrawable instanceof o2.c)) {
      return this.c.a(b(paramv), paramh);
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p2.c
 * JD-Core Version:    0.7.0.1
 */