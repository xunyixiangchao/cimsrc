package e1;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.x;
import java.util.ArrayList;

public abstract class b<T extends b<T>>
  implements a.b
{
  public static final r m = new f("translationX");
  public static final r n = new g("translationY");
  public static final r o = new h("translationZ");
  public static final r p = new i("scaleX");
  public static final r q = new j("scaleY");
  public static final r r = new k("rotation");
  public static final r s = new l("rotationX");
  public static final r t = new m("rotationY");
  public static final r u = new n("x");
  public static final r v = new a("y");
  public static final r w = new b("z");
  public static final r x = new c("alpha");
  public static final r y = new d("scrollX");
  public static final r z = new e("scrollY");
  float a = 0.0F;
  float b = 3.4028235E+38F;
  boolean c = false;
  final Object d;
  final c e;
  boolean f = false;
  float g = 3.4028235E+38F;
  float h = -3.4028235E+38F;
  private long i = 0L;
  private float j;
  private final ArrayList<p> k = new ArrayList();
  private final ArrayList<q> l = new ArrayList();
  
  <K> b(K paramK, c<K> paramc)
  {
    this.d = paramK;
    this.e = paramc;
    float f1;
    if ((paramc != r) && (paramc != s) && (paramc != t))
    {
      if (paramc == x) {}
      while ((paramc == p) || (paramc == q))
      {
        this.j = 0.0039063F;
        return;
      }
      f1 = 1.0F;
    }
    else
    {
      f1 = 0.1F;
    }
    this.j = f1;
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = 0;
    this.f = false;
    a.d().g(this);
    this.i = 0L;
    this.c = false;
    while (i1 < this.k.size())
    {
      if (this.k.get(i1) != null) {
        ((p)this.k.get(i1)).a(this, paramBoolean, this.b, this.a);
      }
      i1 += 1;
    }
    f(this.k);
  }
  
  private float c()
  {
    return this.e.a(this.d);
  }
  
  private static <T> void f(ArrayList<T> paramArrayList)
  {
    int i1 = paramArrayList.size() - 1;
    while (i1 >= 0)
    {
      if (paramArrayList.get(i1) == null) {
        paramArrayList.remove(i1);
      }
      i1 -= 1;
    }
  }
  
  private void j()
  {
    if (!this.f)
    {
      this.f = true;
      if (!this.c) {
        this.b = c();
      }
      float f1 = this.b;
      if ((f1 <= this.g) && (f1 >= this.h))
      {
        a.d().a(this, 0L);
        return;
      }
      throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }
  }
  
  public boolean a(long paramLong)
  {
    long l1 = this.i;
    if (l1 == 0L)
    {
      this.i = paramLong;
      g(this.b);
      return false;
    }
    this.i = paramLong;
    boolean bool = k(paramLong - l1);
    float f1 = Math.min(this.b, this.g);
    this.b = f1;
    f1 = Math.max(f1, this.h);
    this.b = f1;
    g(f1);
    if (bool) {
      b(false);
    }
    return bool;
  }
  
  float d()
  {
    return this.j * 0.75F;
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  void g(float paramFloat)
  {
    this.e.b(this.d, paramFloat);
    int i1 = 0;
    while (i1 < this.l.size())
    {
      if (this.l.get(i1) != null) {
        ((q)this.l.get(i1)).a(this, this.b, this.a);
      }
      i1 += 1;
    }
    f(this.l);
  }
  
  public T h(float paramFloat)
  {
    this.b = paramFloat;
    this.c = true;
    return this;
  }
  
  public void i()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (!this.f) {
        j();
      }
      return;
    }
    throw new AndroidRuntimeException("Animations may only be started on the main thread");
  }
  
  abstract boolean k(long paramLong);
  
  static final class a
    extends b.r
  {
    a(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getY();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setY(paramFloat);
    }
  }
  
  static final class b
    extends b.r
  {
    b(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return x.N(paramView);
    }
    
    public void d(View paramView, float paramFloat)
    {
      x.N0(paramView, paramFloat);
    }
  }
  
  static final class c
    extends b.r
  {
    c(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getAlpha();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setAlpha(paramFloat);
    }
  }
  
  static final class d
    extends b.r
  {
    d(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getScrollX();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setScrollX((int)paramFloat);
    }
  }
  
  static final class e
    extends b.r
  {
    e(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getScrollY();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setScrollY((int)paramFloat);
    }
  }
  
  static final class f
    extends b.r
  {
    f(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getTranslationX();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setTranslationX(paramFloat);
    }
  }
  
  static final class g
    extends b.r
  {
    g(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getTranslationY();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setTranslationY(paramFloat);
    }
  }
  
  static final class h
    extends b.r
  {
    h(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return x.L(paramView);
    }
    
    public void d(View paramView, float paramFloat)
    {
      x.L0(paramView, paramFloat);
    }
  }
  
  static final class i
    extends b.r
  {
    i(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getScaleX();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setScaleX(paramFloat);
    }
  }
  
  static final class j
    extends b.r
  {
    j(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getScaleY();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setScaleY(paramFloat);
    }
  }
  
  static final class k
    extends b.r
  {
    k(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getRotation();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setRotation(paramFloat);
    }
  }
  
  static final class l
    extends b.r
  {
    l(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getRotationX();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setRotationX(paramFloat);
    }
  }
  
  static final class m
    extends b.r
  {
    m(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getRotationY();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setRotationY(paramFloat);
    }
  }
  
  static final class n
    extends b.r
  {
    n(String paramString)
    {
      super(null);
    }
    
    public float c(View paramView)
    {
      return paramView.getX();
    }
    
    public void d(View paramView, float paramFloat)
    {
      paramView.setX(paramFloat);
    }
  }
  
  static class o
  {
    float a;
    float b;
  }
  
  public static abstract interface p
  {
    public abstract void a(b paramb, boolean paramBoolean, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface q
  {
    public abstract void a(b paramb, float paramFloat1, float paramFloat2);
  }
  
  public static abstract class r
    extends c<View>
  {
    private r(String paramString)
    {
      super();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e1.b
 * JD-Core Version:    0.7.0.1
 */