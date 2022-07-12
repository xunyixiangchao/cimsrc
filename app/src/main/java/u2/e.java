package u2;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import v2.b;
import v2.b.a;

public abstract class e<Z>
  extends i<ImageView, Z>
  implements b.a
{
  private Animatable h;
  
  public e(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  private void p(Z paramZ)
  {
    if ((paramZ instanceof Animatable))
    {
      paramZ = (Animatable)paramZ;
      this.h = paramZ;
      paramZ.start();
      return;
    }
    this.h = null;
  }
  
  private void s(Z paramZ)
  {
    r(paramZ);
    p(paramZ);
  }
  
  public void a()
  {
    Animatable localAnimatable = this.h;
    if (localAnimatable != null) {
      localAnimatable.start();
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    super.c(paramDrawable);
    s(null);
    q(paramDrawable);
  }
  
  public void d()
  {
    Animatable localAnimatable = this.h;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
  }
  
  public void f(Z paramZ, b<? super Z> paramb)
  {
    if ((paramb != null) && (paramb.a(paramZ, this)))
    {
      p(paramZ);
      return;
    }
    s(paramZ);
  }
  
  public void g(Drawable paramDrawable)
  {
    super.g(paramDrawable);
    s(null);
    q(paramDrawable);
  }
  
  public void k(Drawable paramDrawable)
  {
    super.k(paramDrawable);
    Animatable localAnimatable = this.h;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
    s(null);
    q(paramDrawable);
  }
  
  public void q(Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
  
  protected abstract void r(Z paramZ);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u2.e
 * JD-Core Version:    0.7.0.1
 */