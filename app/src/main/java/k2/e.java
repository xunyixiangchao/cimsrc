package k2;

import android.graphics.Bitmap;
import d2.r;
import d2.v;
import e2.d;
import x2.k;
import x2.l;

public class e
  implements v<Bitmap>, r
{
  private final Bitmap a;
  private final d b;
  
  public e(Bitmap paramBitmap, d paramd)
  {
    this.a = ((Bitmap)k.e(paramBitmap, "Bitmap must not be null"));
    this.b = ((d)k.e(paramd, "BitmapPool must not be null"));
  }
  
  public static e f(Bitmap paramBitmap, d paramd)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new e(paramBitmap, paramd);
  }
  
  public void a()
  {
    this.b.d(this.a);
  }
  
  public void b()
  {
    this.a.prepareToDraw();
  }
  
  public int c()
  {
    return l.h(this.a);
  }
  
  public Class<Bitmap> d()
  {
    return Bitmap.class;
  }
  
  public Bitmap e()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.e
 * JD-Core Version:    0.7.0.1
 */