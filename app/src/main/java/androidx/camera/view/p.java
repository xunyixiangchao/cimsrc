package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.util.Size;
import android.view.PixelCopy;
import android.view.PixelCopy.OnPixelCopyFinishedListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.camera.core.n1;
import androidx.camera.core.u2;
import androidx.core.content.b;
import s.v0;
import u7.a;
import x0.h;

final class p
  extends k
{
  SurfaceView e;
  final b f = new b();
  private k.a g;
  
  p(FrameLayout paramFrameLayout, f paramf)
  {
    super(paramFrameLayout, paramf);
  }
  
  View b()
  {
    return this.e;
  }
  
  Bitmap c()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((SurfaceView)localObject).getHolder().getSurface() != null) && (this.e.getHolder().getSurface().isValid()))
    {
      localObject = Bitmap.createBitmap(this.e.getWidth(), this.e.getHeight(), Bitmap.Config.ARGB_8888);
      SurfaceView localSurfaceView = this.e;
      a.a(localSurfaceView, (Bitmap)localObject, m.a, localSurfaceView.getHandler());
      return localObject;
    }
    return null;
  }
  
  void d() {}
  
  void e() {}
  
  void g(u2 paramu2, k.a parama)
  {
    this.a = paramu2.l();
    this.g = parama;
    l();
    paramu2.i(b.g(this.e.getContext()), new n(this));
    this.e.post(new o(this, paramu2));
  }
  
  a<Void> i()
  {
    return u.f.h(null);
  }
  
  void l()
  {
    h.g(this.b);
    h.g(this.a);
    SurfaceView localSurfaceView = new SurfaceView(this.b.getContext());
    this.e = localSurfaceView;
    localSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight()));
    this.b.removeAllViews();
    this.b.addView(this.e);
    this.e.getHolder().addCallback(this.f);
  }
  
  void o()
  {
    k.a locala = this.g;
    if (locala != null)
    {
      locala.a();
      this.g = null;
    }
  }
  
  private static class a
  {
    static void a(SurfaceView paramSurfaceView, Bitmap paramBitmap, PixelCopy.OnPixelCopyFinishedListener paramOnPixelCopyFinishedListener, Handler paramHandler)
    {
      PixelCopy.request(paramSurfaceView, paramBitmap, paramOnPixelCopyFinishedListener, paramHandler);
    }
  }
  
  class b
    implements SurfaceHolder.Callback
  {
    private Size a;
    private u2 b;
    private Size c;
    private boolean d = false;
    
    b() {}
    
    private boolean b()
    {
      if ((!this.d) && (this.b != null))
      {
        Size localSize = this.a;
        if ((localSize != null) && (localSize.equals(this.c))) {
          return true;
        }
      }
      return false;
    }
    
    private void c()
    {
      if (this.b != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Request canceled: ");
        localStringBuilder.append(this.b);
        n1.a("SurfaceViewImpl", localStringBuilder.toString());
        this.b.y();
      }
    }
    
    private void d()
    {
      if (this.b != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Surface invalidated ");
        localStringBuilder.append(this.b);
        n1.a("SurfaceViewImpl", localStringBuilder.toString());
        this.b.k().c();
      }
    }
    
    private boolean g()
    {
      Surface localSurface = p.this.e.getHolder().getSurface();
      if (b())
      {
        n1.a("SurfaceViewImpl", "Surface set on Preview.");
        this.b.v(localSurface, b.g(p.this.e.getContext()), new q(this));
        this.d = true;
        p.this.f();
        return true;
      }
      return false;
    }
    
    void f(u2 paramu2)
    {
      c();
      this.b = paramu2;
      paramu2 = paramu2.l();
      this.a = paramu2;
      this.d = false;
      if (!g())
      {
        n1.a("SurfaceViewImpl", "Wait for new Surface creation.");
        p.this.e.getHolder().setFixedSize(paramu2.getWidth(), paramu2.getHeight());
      }
    }
    
    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      paramSurfaceHolder = new StringBuilder();
      paramSurfaceHolder.append("Surface changed. Size: ");
      paramSurfaceHolder.append(paramInt2);
      paramSurfaceHolder.append("x");
      paramSurfaceHolder.append(paramInt3);
      n1.a("SurfaceViewImpl", paramSurfaceHolder.toString());
      this.c = new Size(paramInt2, paramInt3);
      g();
    }
    
    public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      n1.a("SurfaceViewImpl", "Surface created.");
    }
    
    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      n1.a("SurfaceViewImpl", "Surface destroyed.");
      if (this.d) {
        d();
      } else {
        c();
      }
      this.d = false;
      this.b = null;
      this.c = null;
      this.a = null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.view.p
 * JD-Core Version:    0.7.0.1
 */