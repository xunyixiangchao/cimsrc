package k2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import d2.r;
import d2.v;
import x2.k;

public final class u
  implements v<BitmapDrawable>, r
{
  private final Resources a;
  private final v<Bitmap> b;
  
  private u(Resources paramResources, v<Bitmap> paramv)
  {
    this.a = ((Resources)k.d(paramResources));
    this.b = ((v)k.d(paramv));
  }
  
  public static v<BitmapDrawable> f(Resources paramResources, v<Bitmap> paramv)
  {
    if (paramv == null) {
      return null;
    }
    return new u(paramResources, paramv);
  }
  
  public void a()
  {
    this.b.a();
  }
  
  public void b()
  {
    v localv = this.b;
    if ((localv instanceof r)) {
      ((r)localv).b();
    }
  }
  
  public int c()
  {
    return this.b.c();
  }
  
  public Class<BitmapDrawable> d()
  {
    return BitmapDrawable.class;
  }
  
  public BitmapDrawable e()
  {
    return new BitmapDrawable(this.a, (Bitmap)this.b.get());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.u
 * JD-Core Version:    0.7.0.1
 */