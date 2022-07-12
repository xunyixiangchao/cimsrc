package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import t2.a;
import t2.b;
import t2.d;
import t2.f;
import t2.g;

public class j<TranscodeType>
  extends a<j<TranscodeType>>
{
  protected static final t2.i P = (t2.i)((t2.i)((t2.i)new t2.i().e(d2.j.c)).a0(h.d)).i0(true);
  private final Context A;
  private final k B;
  private final Class<TranscodeType> C;
  private final c E;
  private final e F;
  private l<?, ? super TranscodeType> G;
  private Object H;
  private List<t2.h<TranscodeType>> I;
  private j<TranscodeType> J;
  private j<TranscodeType> K;
  private Float L;
  private boolean M = true;
  private boolean N;
  private boolean O;
  
  @SuppressLint({"CheckResult"})
  protected j(c paramc, k paramk, Class<TranscodeType> paramClass, Context paramContext)
  {
    this.E = paramc;
    this.B = paramk;
    this.C = paramClass;
    this.A = paramContext;
    this.G = paramk.q(paramClass);
    this.F = paramc.i();
    v0(paramk.o());
    p0(paramk.p());
  }
  
  private boolean A0(a<?> parama, t2.e parame)
  {
    return (!parama.I()) && (parame.j());
  }
  
  private j<TranscodeType> E0(Object paramObject)
  {
    if (H()) {
      return t0().E0(paramObject);
    }
    this.H = paramObject;
    this.N = true;
    return (j)e0();
  }
  
  private t2.e F0(Object paramObject, u2.h<TranscodeType> paramh, t2.h<TranscodeType> paramh1, a<?> parama, f paramf, l<?, ? super TranscodeType> paraml, h paramh2, int paramInt1, int paramInt2, Executor paramExecutor)
  {
    Context localContext = this.A;
    e locale = this.F;
    return t2.k.y(localContext, locale, paramObject, this.H, this.C, parama, paramInt1, paramInt2, paramh2, paramh, paramh1, this.I, paramf, locale.f(), paraml.b(), paramExecutor);
  }
  
  private t2.e q0(u2.h<TranscodeType> paramh, t2.h<TranscodeType> paramh1, a<?> parama, Executor paramExecutor)
  {
    return r0(new Object(), paramh, paramh1, null, this.G, parama.y(), parama.v(), parama.u(), parama, paramExecutor);
  }
  
  private t2.e r0(Object paramObject, u2.h<TranscodeType> paramh, t2.h<TranscodeType> paramh1, f paramf, l<?, ? super TranscodeType> paraml, h paramh2, int paramInt1, int paramInt2, a<?> parama, Executor paramExecutor)
  {
    Object localObject1;
    if (this.K != null)
    {
      localObject1 = new b(paramObject, paramf);
      paramf = (f)localObject1;
    }
    else
    {
      Object localObject2 = null;
      localObject1 = paramf;
      paramf = localObject2;
    }
    paraml = s0(paramObject, paramh, paramh1, (f)localObject1, paraml, paramh2, paramInt1, paramInt2, parama, paramExecutor);
    if (paramf == null) {
      return paraml;
    }
    int k = this.K.v();
    int m = this.K.u();
    int j = k;
    int i = m;
    if (x2.l.t(paramInt1, paramInt2))
    {
      j = k;
      i = m;
      if (!this.K.Q())
      {
        j = parama.v();
        i = parama.u();
      }
    }
    paramh2 = this.K;
    paramf.p(paraml, paramh2.r0(paramObject, paramh, paramh1, paramf, paramh2.G, paramh2.y(), j, i, this.K, paramExecutor));
    return paramf;
  }
  
  private t2.e s0(Object paramObject, u2.h<TranscodeType> paramh, t2.h<TranscodeType> paramh1, f paramf, l<?, ? super TranscodeType> paraml, h paramh2, int paramInt1, int paramInt2, a<?> parama, Executor paramExecutor)
  {
    Object localObject2 = this.J;
    if (localObject2 != null)
    {
      if (!this.O)
      {
        Object localObject1 = ((j)localObject2).G;
        if (((j)localObject2).M) {
          localObject1 = paraml;
        }
        if (((a)localObject2).J()) {
          localObject2 = this.J.y();
        } else {
          localObject2 = u0(paramh2);
        }
        int k = this.J.v();
        int m = this.J.u();
        int j = k;
        int i = m;
        if (x2.l.t(paramInt1, paramInt2))
        {
          j = k;
          i = m;
          if (!this.J.Q())
          {
            j = parama.v();
            i = parama.u();
          }
        }
        paramf = new t2.l(paramObject, paramf);
        paraml = F0(paramObject, paramh, paramh1, parama, paramf, paraml, paramh2, paramInt1, paramInt2, paramExecutor);
        this.O = true;
        paramh2 = this.J;
        paramObject = paramh2.r0(paramObject, paramh, paramh1, paramf, (l)localObject1, (h)localObject2, j, i, paramh2, paramExecutor);
        this.O = false;
        paramf.o(paraml, paramObject);
        return paramf;
      }
      throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
    }
    if (this.L != null)
    {
      paramf = new t2.l(paramObject, paramf);
      paramf.o(F0(paramObject, paramh, paramh1, parama, paramf, paraml, paramh2, paramInt1, paramInt2, paramExecutor), F0(paramObject, paramh, paramh1, parama.c().h0(this.L.floatValue()), paramf, paraml, u0(paramh2), paramInt1, paramInt2, paramExecutor));
      return paramf;
    }
    return F0(paramObject, paramh, paramh1, parama, paramf, paraml, paramh2, paramInt1, paramInt2, paramExecutor);
  }
  
  private h u0(h paramh)
  {
    int i = a.b[paramh.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          paramh = new StringBuilder();
          paramh.append("unknown priority: ");
          paramh.append(y());
          throw new IllegalArgumentException(paramh.toString());
        }
        return h.a;
      }
      return h.b;
    }
    return h.c;
  }
  
  @SuppressLint({"CheckResult"})
  private void v0(List<t2.h<Object>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      o0((t2.h)paramList.next());
    }
  }
  
  private <Y extends u2.h<TranscodeType>> Y y0(Y paramY, t2.h<TranscodeType> paramh, a<?> parama, Executor paramExecutor)
  {
    x2.k.d(paramY);
    if (this.N)
    {
      paramh = q0(paramY, paramh, parama, paramExecutor);
      paramExecutor = paramY.j();
      if ((paramh.k(paramExecutor)) && (!A0(parama, paramExecutor)))
      {
        if (!((t2.e)x2.k.d(paramExecutor)).isRunning()) {
          paramExecutor.i();
        }
        return paramY;
      }
      this.B.n(paramY);
      paramY.l(paramh);
      this.B.w(paramY, paramh);
      return paramY;
    }
    throw new IllegalArgumentException("You must call #load() before calling #into()");
  }
  
  public j<TranscodeType> B0(Uri paramUri)
  {
    return E0(paramUri);
  }
  
  public j<TranscodeType> C0(Object paramObject)
  {
    return E0(paramObject);
  }
  
  public j<TranscodeType> D0(String paramString)
  {
    return E0(paramString);
  }
  
  public d<TranscodeType> G0()
  {
    return H0(-2147483648, -2147483648);
  }
  
  public d<TranscodeType> H0(int paramInt1, int paramInt2)
  {
    g localg = new g(paramInt1, paramInt2);
    return (d)x0(localg, localg, x2.e.a());
  }
  
  public j<TranscodeType> o0(t2.h<TranscodeType> paramh)
  {
    if (H()) {
      return t0().o0(paramh);
    }
    if (paramh != null)
    {
      if (this.I == null) {
        this.I = new ArrayList();
      }
      this.I.add(paramh);
    }
    return (j)e0();
  }
  
  public j<TranscodeType> p0(a<?> parama)
  {
    x2.k.d(parama);
    return (j)super.a(parama);
  }
  
  public j<TranscodeType> t0()
  {
    j localj1 = (j)super.c();
    localj1.G = localj1.G.a();
    if (localj1.I != null) {
      localj1.I = new ArrayList(localj1.I);
    }
    j localj2 = localj1.J;
    if (localj2 != null) {
      localj1.J = localj2.t0();
    }
    localj2 = localj1.K;
    if (localj2 != null) {
      localj1.K = localj2.t0();
    }
    return localj1;
  }
  
  public <Y extends u2.h<TranscodeType>> Y w0(Y paramY)
  {
    return x0(paramY, null, x2.e.b());
  }
  
  <Y extends u2.h<TranscodeType>> Y x0(Y paramY, t2.h<TranscodeType> paramh, Executor paramExecutor)
  {
    return y0(paramY, paramh, this, paramExecutor);
  }
  
  public u2.i<ImageView, TranscodeType> z0(ImageView paramImageView)
  {
    x2.l.b();
    x2.k.d(paramImageView);
    if ((!P()) && (N()) && (paramImageView.getScaleType() != null)) {
      switch (a.a[paramImageView.getScaleType().ordinal()])
      {
      default: 
        break;
      case 3: 
      case 4: 
      case 5: 
        localObject = c().U();
        break;
      case 2: 
      case 6: 
        localObject = c().T();
        break;
      case 1: 
        localObject = c().S();
        break;
      }
    }
    Object localObject = this;
    return (u2.i)y0(this.F.a(paramImageView, this.C), null, (a)localObject, x2.e.b());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.j
 * JD-Core Version:    0.7.0.1
 */