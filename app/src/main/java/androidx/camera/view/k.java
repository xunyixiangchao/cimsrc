package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.u2;
import u7.a;

abstract class k
{
  Size a;
  FrameLayout b;
  private final f c;
  private boolean d = false;
  
  k(FrameLayout paramFrameLayout, f paramf)
  {
    this.b = paramFrameLayout;
    this.c = paramf;
  }
  
  Bitmap a()
  {
    Bitmap localBitmap = c();
    if (localBitmap == null) {
      return null;
    }
    return this.c.a(localBitmap, new Size(this.b.getWidth(), this.b.getHeight()), this.b.getLayoutDirection());
  }
  
  abstract View b();
  
  abstract Bitmap c();
  
  abstract void d();
  
  abstract void e();
  
  void f()
  {
    this.d = true;
    h();
  }
  
  abstract void g(u2 paramu2, a parama);
  
  void h()
  {
    View localView = b();
    if (localView != null)
    {
      if (!this.d) {
        return;
      }
      this.c.q(new Size(this.b.getWidth(), this.b.getHeight()), this.b.getLayoutDirection(), localView);
    }
  }
  
  abstract a<Void> i();
  
  static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.view.k
 * JD-Core Version:    0.7.0.1
 */