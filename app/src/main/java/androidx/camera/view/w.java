package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.camera.core.n1;
import androidx.camera.core.u2;
import androidx.camera.core.u2.f;
import androidx.concurrent.futures.c.a;
import androidx.core.content.b;
import java.util.concurrent.atomic.AtomicReference;
import s.v0;
import u7.a;
import x0.h;

final class w
  extends k
{
  TextureView e;
  SurfaceTexture f;
  a<u2.f> g;
  u2 h;
  boolean i = false;
  SurfaceTexture j;
  AtomicReference<c.a<Void>> k = new AtomicReference();
  k.a l;
  
  w(FrameLayout paramFrameLayout, f paramf)
  {
    super(paramFrameLayout, paramf);
  }
  
  private void s()
  {
    k.a locala = this.l;
    if (locala != null)
    {
      locala.a();
      this.l = null;
    }
  }
  
  private void t()
  {
    if ((this.i) && (this.j != null))
    {
      SurfaceTexture localSurfaceTexture1 = this.e.getSurfaceTexture();
      SurfaceTexture localSurfaceTexture2 = this.j;
      if (localSurfaceTexture1 != localSurfaceTexture2)
      {
        this.e.setSurfaceTexture(localSurfaceTexture2);
        this.j = null;
        this.i = false;
      }
    }
  }
  
  View b()
  {
    return this.e;
  }
  
  Bitmap c()
  {
    TextureView localTextureView = this.e;
    if ((localTextureView != null) && (localTextureView.isAvailable())) {
      return this.e.getBitmap();
    }
    return null;
  }
  
  void d()
  {
    t();
  }
  
  void e()
  {
    this.i = true;
  }
  
  void g(u2 paramu2, k.a parama)
  {
    this.a = paramu2.l();
    this.l = parama;
    n();
    parama = this.h;
    if (parama != null) {
      parama.y();
    }
    this.h = paramu2;
    paramu2.i(b.g(this.e.getContext()), new u(this, paramu2));
    u();
  }
  
  a<Void> i()
  {
    return androidx.concurrent.futures.c.a(new r(this));
  }
  
  public void n()
  {
    h.g(this.b);
    h.g(this.a);
    TextureView localTextureView = new TextureView(this.b.getContext());
    this.e = localTextureView;
    localTextureView.setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight()));
    this.e.setSurfaceTextureListener(new a());
    this.b.removeAllViews();
    this.b.addView(this.e);
  }
  
  void u()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      Object localObject2 = this.f;
      if (localObject2 != null)
      {
        if (this.h == null) {
          return;
        }
        ((SurfaceTexture)localObject2).setDefaultBufferSize(((Size)localObject1).getWidth(), this.a.getHeight());
        localObject1 = new Surface(this.f);
        localObject2 = this.h;
        a locala = androidx.concurrent.futures.c.a(new s(this, (Surface)localObject1));
        this.g = locala;
        locala.h(new t(this, (Surface)localObject1, locala, (u2)localObject2), b.g(this.e.getContext()));
        f();
      }
    }
  }
  
  class a
    implements TextureView.SurfaceTextureListener
  {
    a() {}
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SurfaceTexture available. Size: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramInt2);
      n1.a("TextureViewImpl", ((StringBuilder)localObject).toString());
      localObject = w.this;
      ((w)localObject).f = paramSurfaceTexture;
      if (((w)localObject).g != null)
      {
        h.g(((w)localObject).h);
        paramSurfaceTexture = new StringBuilder();
        paramSurfaceTexture.append("Surface invalidated ");
        paramSurfaceTexture.append(w.this.h);
        n1.a("TextureViewImpl", paramSurfaceTexture.toString());
        w.this.h.k().c();
        return;
      }
      ((w)localObject).u();
    }
    
    public boolean onSurfaceTextureDestroyed(final SurfaceTexture paramSurfaceTexture)
    {
      Object localObject = w.this;
      ((w)localObject).f = null;
      localObject = ((w)localObject).g;
      if (localObject != null)
      {
        u.f.b((a)localObject, new a(paramSurfaceTexture), b.g(w.this.e.getContext()));
        w.this.j = paramSurfaceTexture;
        return false;
      }
      n1.a("TextureViewImpl", "SurfaceTexture about to be destroyed");
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append("SurfaceTexture size changed: ");
      paramSurfaceTexture.append(paramInt1);
      paramSurfaceTexture.append("x");
      paramSurfaceTexture.append(paramInt2);
      n1.a("TextureViewImpl", paramSurfaceTexture.toString());
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      paramSurfaceTexture = (c.a)w.this.k.getAndSet(null);
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.c(null);
      }
    }
    
    class a
      implements u.c<u2.f>
    {
      a(SurfaceTexture paramSurfaceTexture) {}
      
      public void a(Throwable paramThrowable)
      {
        throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", paramThrowable);
      }
      
      public void c(u2.f paramf)
      {
        boolean bool;
        if (paramf.a() != 3) {
          bool = true;
        } else {
          bool = false;
        }
        h.j(bool, "Unexpected result from SurfaceRequest. Surface was provided twice.");
        n1.a("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
        paramSurfaceTexture.release();
        paramf = w.this;
        if (paramf.j != null) {
          paramf.j = null;
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.view.w
 * JD-Core Version:    0.7.0.1
 */