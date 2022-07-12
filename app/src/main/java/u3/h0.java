package u3;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.k;
import com.farsunset.hoxin.HoxinApplication;
import d2.q;
import java.util.concurrent.Future;
import s3.d;

public class h0
  implements r
{
  private void p(ImageView paramImageView, String paramString, Drawable paramDrawable, final s3.c paramc)
  {
    t2.i locali = (t2.i)((t2.i)((t2.i)new t2.i().e(d2.j.a)).m(b2.b.b)).f();
    if (paramDrawable != null)
    {
      locali.l(paramDrawable);
      locali.Z(paramDrawable);
    }
    if ((paramString != null) && (b0.n(paramString)))
    {
      paramDrawable = p3.b.b(paramString);
      if (!TextUtils.isEmpty(paramDrawable)) {
        locali.g0(new w2.b(paramDrawable));
      }
    }
    com.bumptech.glide.c.t(HoxinApplication.h()).h().D0(paramString).p0(locali).o0(new a(paramc)).z0(paramImageView);
  }
  
  public void a()
  {
    com.bumptech.glide.c.c(HoxinApplication.h()).b();
  }
  
  @SuppressLint({"CheckResult"})
  public void b(Uri paramUri, d paramd)
  {
    d(paramUri, 1, paramd);
  }
  
  public void c(String paramString)
  {
    g(paramString, null);
  }
  
  @SuppressLint({"CheckResult"})
  public void d(final Uri paramUri, int paramInt, final d paramd)
  {
    t2.i locali = (t2.i)new t2.i().e(d2.j.a);
    if (b0.n(paramUri.toString()))
    {
      String str = p3.b.b(paramUri.toString());
      if (!TextUtils.isEmpty(str)) {
        locali.g0(new w2.b(str));
      }
    }
    ((com.bumptech.glide.j)com.bumptech.glide.c.t(HoxinApplication.h()).h().j0(new m8.b(25, paramInt))).B0(paramUri).p0(locali).w0(new c(-2147483648, -2147483648, paramd, paramUri));
  }
  
  public void e(ImageView paramImageView, String paramString, Bitmap paramBitmap, s3.c paramc)
  {
    p(paramImageView, paramString, new BitmapDrawable(paramImageView.getResources(), paramBitmap), paramc);
  }
  
  public void f(ImageView paramImageView, String paramString)
  {
    t2.i locali = (t2.i)((t2.i)new t2.i().e(d2.j.a)).m(b2.b.b);
    com.bumptech.glide.c.t(HoxinApplication.h()).m().D0(paramString).p0(locali).z0(paramImageView);
  }
  
  public void g(String paramString, d paramd)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = Uri.parse(paramString);
    }
    o(paramString, -2147483648, paramd);
  }
  
  public void h(ImageView paramImageView, String paramString, s3.c paramc)
  {
    i(paramImageView, paramString, 0, paramc);
  }
  
  public void i(ImageView paramImageView, String paramString, int paramInt, s3.c paramc)
  {
    Drawable localDrawable;
    if (paramInt == 0) {
      localDrawable = null;
    } else {
      localDrawable = androidx.core.content.b.d(paramImageView.getContext(), paramInt);
    }
    p(paramImageView, paramString, localDrawable, paramc);
  }
  
  public void j(Uri paramUri, d paramd)
  {
    o(paramUri, -2147483648, paramd);
  }
  
  public void k(ImageView paramImageView, String paramString, int paramInt)
  {
    i(paramImageView, paramString, paramInt, null);
  }
  
  public void l(ImageView paramImageView, String paramString)
  {
    h(paramImageView, paramString, null);
  }
  
  public void m(ImageView paramImageView, String paramString, int paramInt)
  {
    t2.i locali = (t2.i)((t2.i)((t2.i)((t2.i)((t2.i)new t2.i().e(d2.j.a)).m(b2.b.b)).k(paramInt)).Y(paramInt)).f();
    ((com.bumptech.glide.j)com.bumptech.glide.c.t(HoxinApplication.h()).h().j0(new m8.c())).D0(paramString).p0(locali).z0(paramImageView);
  }
  
  @SuppressLint({"CheckResult"})
  public Bitmap n(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    t2.i locali = (t2.i)new t2.i().e(d2.j.a);
    if (b0.n(paramString))
    {
      String str = p3.b.b(paramString);
      if (!TextUtils.isEmpty(str)) {
        locali.g0(new w2.b(str));
      }
    }
    paramString = com.bumptech.glide.c.t(HoxinApplication.h()).h().D0(paramString).p0(locali);
    try
    {
      paramString = (Bitmap)paramString.G0().get();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  @SuppressLint({"CheckResult"})
  public void o(final Uri paramUri, int paramInt, final d paramd)
  {
    if ((paramUri == null) && (paramd != null))
    {
      paramd.v(null);
      return;
    }
    t2.i locali = (t2.i)new t2.i().e(d2.j.a);
    if (b0.n(paramUri.toString()))
    {
      String str = p3.b.b(paramUri.toString());
      if (!TextUtils.isEmpty(str)) {
        locali.g0(new w2.b(str));
      }
    }
    com.bumptech.glide.c.t(HoxinApplication.h()).h().B0(paramUri).p0(locali).w0(new b(paramInt, paramInt, paramd, paramUri));
  }
  
  class a
    implements t2.h<Bitmap>
  {
    a(s3.c paramc) {}
    
    public boolean a(Bitmap paramBitmap, Object paramObject, u2.h<Bitmap> paramh, b2.a parama, boolean paramBoolean)
    {
      if (paramc == null) {
        return false;
      }
      paramh = (ImageView)((u2.b)paramh).h();
      paramc.p(paramObject, paramh, new BitmapDrawable(Resources.getSystem(), paramBitmap));
      return false;
    }
    
    public boolean m(q paramq, Object paramObject, u2.h paramh, boolean paramBoolean)
    {
      if (paramc == null) {
        return false;
      }
      paramq = (ImageView)((u2.b)paramh).h();
      paramc.l0(paramObject, paramq);
      return false;
    }
  }
  
  class b
    extends u2.c<Bitmap>
  {
    b(int paramInt1, int paramInt2, d paramd, Uri paramUri)
    {
      super(paramInt2);
    }
    
    public void c(Drawable paramDrawable)
    {
      paramDrawable = paramd;
      if (paramDrawable != null) {
        paramDrawable.v(paramUri);
      }
    }
    
    public void e(Bitmap paramBitmap, v2.b<? super Bitmap> paramb)
    {
      paramb = paramd;
      if (paramb != null) {
        paramb.D0(paramUri, paramBitmap);
      }
    }
    
    public void k(Drawable paramDrawable) {}
  }
  
  class c
    extends u2.c<Bitmap>
  {
    c(int paramInt1, int paramInt2, d paramd, Uri paramUri)
    {
      super(paramInt2);
    }
    
    public void c(Drawable paramDrawable)
    {
      paramd.v(paramUri);
    }
    
    public void e(Bitmap paramBitmap, v2.b<? super Bitmap> paramb)
    {
      paramd.D0(paramUri, paramBitmap);
    }
    
    public void k(Drawable paramDrawable) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.h0
 * JD-Core Version:    0.7.0.1
 */