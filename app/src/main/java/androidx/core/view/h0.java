package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets.Builder;
import android.view.WindowInsets.Type;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import q0.b;
import x0.c;
import x0.h;

public class h0
{
  public static final h0 b;
  private final l a;
  
  static
  {
    h0 localh0;
    if (Build.VERSION.SDK_INT >= 30) {
      localh0 = k.q;
    } else {
      localh0 = l.b;
    }
    b = localh0;
  }
  
  private h0(WindowInsets paramWindowInsets)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 30) {
      paramWindowInsets = new k(this, paramWindowInsets);
    }
    for (;;)
    {
      this.a = paramWindowInsets;
      return;
      if (i >= 29) {
        paramWindowInsets = new j(this, paramWindowInsets);
      } else if (i >= 28) {
        paramWindowInsets = new i(this, paramWindowInsets);
      } else {
        paramWindowInsets = new h(this, paramWindowInsets);
      }
    }
  }
  
  public h0(h0 paramh0)
  {
    if (paramh0 != null)
    {
      l locall = paramh0.a;
      int i = Build.VERSION.SDK_INT;
      if ((i >= 30) && ((locall instanceof k))) {
        paramh0 = new k(this, (k)locall);
      }
      for (;;)
      {
        this.a = paramh0;
        break;
        if ((i >= 29) && ((locall instanceof j))) {
          paramh0 = new j(this, (j)locall);
        } else if ((i >= 28) && ((locall instanceof i))) {
          paramh0 = new i(this, (i)locall);
        } else if ((locall instanceof h)) {
          paramh0 = new h(this, (h)locall);
        } else if ((locall instanceof g)) {
          paramh0 = new g(this, (g)locall);
        } else {
          paramh0 = new l(this);
        }
      }
      locall.e(this);
      return;
    }
    this.a = new l(this);
  }
  
  static b o(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Math.max(0, paramb.a - paramInt1);
    int j = Math.max(0, paramb.b - paramInt2);
    int k = Math.max(0, paramb.c - paramInt3);
    int m = Math.max(0, paramb.d - paramInt4);
    if ((i == paramInt1) && (j == paramInt2) && (k == paramInt3) && (m == paramInt4)) {
      return paramb;
    }
    return b.b(i, j, k, m);
  }
  
  public static h0 w(WindowInsets paramWindowInsets)
  {
    return x(paramWindowInsets, null);
  }
  
  public static h0 x(WindowInsets paramWindowInsets, View paramView)
  {
    paramWindowInsets = new h0((WindowInsets)h.g(paramWindowInsets));
    if ((paramView != null) && (x.T(paramView)))
    {
      paramWindowInsets.t(x.I(paramView));
      paramWindowInsets.d(paramView.getRootView());
    }
    return paramWindowInsets;
  }
  
  @Deprecated
  public h0 a()
  {
    return this.a.a();
  }
  
  @Deprecated
  public h0 b()
  {
    return this.a.b();
  }
  
  @Deprecated
  public h0 c()
  {
    return this.a.c();
  }
  
  void d(View paramView)
  {
    this.a.d(paramView);
  }
  
  public d e()
  {
    return this.a.f();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof h0)) {
      return false;
    }
    paramObject = (h0)paramObject;
    return c.a(this.a, paramObject.a);
  }
  
  public b f(int paramInt)
  {
    return this.a.g(paramInt);
  }
  
  @Deprecated
  public b g()
  {
    return this.a.i();
  }
  
  @Deprecated
  public b h()
  {
    return this.a.j();
  }
  
  public int hashCode()
  {
    l locall = this.a;
    if (locall == null) {
      return 0;
    }
    return locall.hashCode();
  }
  
  @Deprecated
  public int i()
  {
    return this.a.k().d;
  }
  
  @Deprecated
  public int j()
  {
    return this.a.k().a;
  }
  
  @Deprecated
  public int k()
  {
    return this.a.k().c;
  }
  
  @Deprecated
  public int l()
  {
    return this.a.k().b;
  }
  
  @Deprecated
  public boolean m()
  {
    return this.a.k().equals(b.e) ^ true;
  }
  
  public h0 n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.a.m(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean p()
  {
    return this.a.n();
  }
  
  @Deprecated
  public h0 q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new b(this).c(b.b(paramInt1, paramInt2, paramInt3, paramInt4)).a();
  }
  
  void r(b[] paramArrayOfb)
  {
    this.a.p(paramArrayOfb);
  }
  
  void s(b paramb)
  {
    this.a.q(paramb);
  }
  
  void t(h0 paramh0)
  {
    this.a.r(paramh0);
  }
  
  void u(b paramb)
  {
    this.a.s(paramb);
  }
  
  public WindowInsets v()
  {
    l locall = this.a;
    if ((locall instanceof g)) {
      return ((g)locall).c;
    }
    return null;
  }
  
  @SuppressLint({"SoonBlockedPrivateApi"})
  static class a
  {
    private static Field a;
    private static Field b;
    private static Field c;
    private static boolean d;
    
    static
    {
      try
      {
        Object localObject1 = View.class.getDeclaredField("mAttachInfo");
        a = (Field)localObject1;
        ((Field)localObject1).setAccessible(true);
        localObject1 = Class.forName("android.view.View$AttachInfo");
        localObject2 = ((Class)localObject1).getDeclaredField("mStableInsets");
        b = (Field)localObject2;
        ((Field)localObject2).setAccessible(true);
        localObject1 = ((Class)localObject1).getDeclaredField("mContentInsets");
        c = (Field)localObject1;
        ((Field)localObject1).setAccessible(true);
        d = true;
        return;
      }
      catch (ReflectiveOperationException localReflectiveOperationException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Failed to get visible insets from AttachInfo ");
        ((StringBuilder)localObject2).append(localReflectiveOperationException.getMessage());
        Log.w("WindowInsetsCompat", ((StringBuilder)localObject2).toString(), localReflectiveOperationException);
      }
    }
    
    public static h0 a(View paramView)
    {
      if (d)
      {
        if (!paramView.isAttachedToWindow()) {
          return null;
        }
        Object localObject1 = paramView.getRootView();
        try
        {
          Object localObject2 = a.get(localObject1);
          if (localObject2 != null)
          {
            localObject1 = (Rect)b.get(localObject2);
            localObject2 = (Rect)c.get(localObject2);
            if ((localObject1 != null) && (localObject2 != null))
            {
              localObject1 = new h0.b().b(b.c((Rect)localObject1)).c(b.c((Rect)localObject2)).a();
              ((h0)localObject1).t((h0)localObject1);
              ((h0)localObject1).d(paramView.getRootView());
              return localObject1;
            }
          }
        }
        catch (IllegalAccessException paramView)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Failed to get insets from AttachInfo. ");
          ((StringBuilder)localObject1).append(paramView.getMessage());
          Log.w("WindowInsetsCompat", ((StringBuilder)localObject1).toString(), paramView);
        }
      }
      return null;
    }
  }
  
  public static final class b
  {
    private final h0.f a;
    
    public b()
    {
      int i = Build.VERSION.SDK_INT;
      Object localObject;
      if (i >= 30) {
        localObject = new h0.e();
      }
      for (;;)
      {
        this.a = ((h0.f)localObject);
        return;
        if (i >= 29) {
          localObject = new h0.d();
        } else {
          localObject = new h0.c();
        }
      }
    }
    
    public b(h0 paramh0)
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 30) {
        paramh0 = new h0.e(paramh0);
      }
      for (;;)
      {
        this.a = paramh0;
        return;
        if (i >= 29) {
          paramh0 = new h0.d(paramh0);
        } else {
          paramh0 = new h0.c(paramh0);
        }
      }
    }
    
    public h0 a()
    {
      return this.a.b();
    }
    
    @Deprecated
    public b b(b paramb)
    {
      this.a.d(paramb);
      return this;
    }
    
    @Deprecated
    public b c(b paramb)
    {
      this.a.f(paramb);
      return this;
    }
  }
  
  private static class c
    extends h0.f
  {
    private static Field e;
    private static boolean f = false;
    private static Constructor<WindowInsets> g;
    private static boolean h = false;
    private WindowInsets c;
    private b d;
    
    c()
    {
      this.c = h();
    }
    
    c(h0 paramh0)
    {
      super();
      this.c = paramh0.v();
    }
    
    private static WindowInsets h()
    {
      if (!f)
      {
        try
        {
          e = WindowInsets.class.getDeclaredField("CONSUMED");
        }
        catch (ReflectiveOperationException localReflectiveOperationException1)
        {
          Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", localReflectiveOperationException1);
        }
        f = true;
      }
      Object localObject1 = e;
      if (localObject1 != null) {
        try
        {
          localObject1 = (WindowInsets)((Field)localObject1).get(null);
          if (localObject1 != null)
          {
            localObject1 = new WindowInsets((WindowInsets)localObject1);
            return localObject1;
          }
        }
        catch (ReflectiveOperationException localReflectiveOperationException2)
        {
          Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", localReflectiveOperationException2);
        }
      }
      if (!h)
      {
        try
        {
          g = WindowInsets.class.getConstructor(new Class[] { Rect.class });
        }
        catch (ReflectiveOperationException localReflectiveOperationException3)
        {
          Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", localReflectiveOperationException3);
        }
        h = true;
      }
      Object localObject2 = g;
      if (localObject2 != null) {
        try
        {
          localObject2 = (WindowInsets)((Constructor)localObject2).newInstance(new Object[] { new Rect() });
          return localObject2;
        }
        catch (ReflectiveOperationException localReflectiveOperationException4)
        {
          Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", localReflectiveOperationException4);
        }
      }
      return null;
    }
    
    h0 b()
    {
      a();
      h0 localh0 = h0.w(this.c);
      localh0.r(this.b);
      localh0.u(this.d);
      return localh0;
    }
    
    void d(b paramb)
    {
      this.d = paramb;
    }
    
    void f(b paramb)
    {
      WindowInsets localWindowInsets = this.c;
      if (localWindowInsets != null) {
        this.c = localWindowInsets.replaceSystemWindowInsets(paramb.a, paramb.b, paramb.c, paramb.d);
      }
    }
  }
  
  private static class d
    extends h0.f
  {
    final WindowInsets.Builder c;
    
    d()
    {
      this.c = new WindowInsets.Builder();
    }
    
    d(h0 paramh0)
    {
      super();
      paramh0 = paramh0.v();
      if (paramh0 != null) {
        paramh0 = new WindowInsets.Builder(paramh0);
      } else {
        paramh0 = new WindowInsets.Builder();
      }
      this.c = paramh0;
    }
    
    h0 b()
    {
      a();
      h0 localh0 = h0.w(this.c.build());
      localh0.r(this.b);
      return localh0;
    }
    
    void c(b paramb)
    {
      this.c.setMandatorySystemGestureInsets(paramb.e());
    }
    
    void d(b paramb)
    {
      this.c.setStableInsets(paramb.e());
    }
    
    void e(b paramb)
    {
      this.c.setSystemGestureInsets(paramb.e());
    }
    
    void f(b paramb)
    {
      this.c.setSystemWindowInsets(paramb.e());
    }
    
    void g(b paramb)
    {
      this.c.setTappableElementInsets(paramb.e());
    }
  }
  
  private static class e
    extends h0.d
  {
    e() {}
    
    e(h0 paramh0)
    {
      super();
    }
  }
  
  private static class f
  {
    private final h0 a;
    b[] b;
    
    f()
    {
      this(new h0(null));
    }
    
    f(h0 paramh0)
    {
      this.a = paramh0;
    }
    
    protected final void a()
    {
      Object localObject1 = this.b;
      if (localObject1 != null)
      {
        Object localObject3 = localObject1[h0.m.a(1)];
        Object localObject2 = this.b[h0.m.a(2)];
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.a.f(2);
        }
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = this.a.f(1);
        }
        f(b.a((b)localObject2, (b)localObject1));
        localObject1 = this.b[h0.m.a(16)];
        if (localObject1 != null) {
          e((b)localObject1);
        }
        localObject1 = this.b[h0.m.a(32)];
        if (localObject1 != null) {
          c((b)localObject1);
        }
        localObject1 = this.b[h0.m.a(64)];
        if (localObject1 != null) {
          g((b)localObject1);
        }
      }
    }
    
    h0 b()
    {
      throw null;
    }
    
    void c(b paramb) {}
    
    void d(b paramb)
    {
      throw null;
    }
    
    void e(b paramb) {}
    
    void f(b paramb)
    {
      throw null;
    }
    
    void g(b paramb) {}
  }
  
  private static class g
    extends h0.l
  {
    private static boolean h = false;
    private static Method i;
    private static Class<?> j;
    private static Field k;
    private static Field l;
    final WindowInsets c;
    private b[] d;
    private b e = null;
    private h0 f;
    b g;
    
    g(h0 paramh0, WindowInsets paramWindowInsets)
    {
      super();
      this.c = paramWindowInsets;
    }
    
    g(h0 paramh0, g paramg)
    {
      this(paramh0, new WindowInsets(paramg.c));
    }
    
    @SuppressLint({"WrongConstant"})
    private b t(int paramInt, boolean paramBoolean)
    {
      b localb = b.e;
      int m = 1;
      while (m <= 256)
      {
        if ((paramInt & m) != 0) {
          localb = b.a(localb, u(m, paramBoolean));
        }
        m <<= 1;
      }
      return localb;
    }
    
    private b v()
    {
      h0 localh0 = this.f;
      if (localh0 != null) {
        return localh0.g();
      }
      return b.e;
    }
    
    private b w(View paramView)
    {
      if (Build.VERSION.SDK_INT < 30)
      {
        if (!h) {
          x();
        }
        Object localObject = i;
        StringBuilder localStringBuilder = null;
        if ((localObject != null) && (j != null))
        {
          if (k == null) {
            return null;
          }
          try
          {
            paramView = ((Method)localObject).invoke(paramView, new Object[0]);
            if (paramView == null)
            {
              Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
              return null;
            }
            paramView = l.get(paramView);
            localObject = (Rect)k.get(paramView);
            paramView = localStringBuilder;
            if (localObject != null) {
              paramView = b.c((Rect)localObject);
            }
            return paramView;
          }
          catch (ReflectiveOperationException paramView)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Failed to get visible insets. (Reflection error). ");
            localStringBuilder.append(paramView.getMessage());
            Log.e("WindowInsetsCompat", localStringBuilder.toString(), paramView);
          }
        }
        return null;
      }
      throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
    }
    
    @SuppressLint({"PrivateApi"})
    private static void x()
    {
      try
      {
        i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
        Class localClass = Class.forName("android.view.View$AttachInfo");
        j = localClass;
        k = localClass.getDeclaredField("mVisibleInsets");
        l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
        k.setAccessible(true);
        l.setAccessible(true);
      }
      catch (ReflectiveOperationException localReflectiveOperationException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to get visible insets. (Reflection error). ");
        localStringBuilder.append(localReflectiveOperationException.getMessage());
        Log.e("WindowInsetsCompat", localStringBuilder.toString(), localReflectiveOperationException);
      }
      h = true;
    }
    
    void d(View paramView)
    {
      b localb = w(paramView);
      paramView = localb;
      if (localb == null) {
        paramView = b.e;
      }
      q(paramView);
    }
    
    void e(h0 paramh0)
    {
      paramh0.t(this.f);
      paramh0.s(this.g);
    }
    
    public boolean equals(Object paramObject)
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (g)paramObject;
      return Objects.equals(this.g, paramObject.g);
    }
    
    public b g(int paramInt)
    {
      return t(paramInt, false);
    }
    
    final b k()
    {
      if (this.e == null) {
        this.e = b.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
      }
      return this.e;
    }
    
    h0 m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      h0.b localb = new h0.b(h0.w(this.c));
      localb.c(h0.o(k(), paramInt1, paramInt2, paramInt3, paramInt4));
      localb.b(h0.o(i(), paramInt1, paramInt2, paramInt3, paramInt4));
      return localb.a();
    }
    
    boolean o()
    {
      return this.c.isRound();
    }
    
    public void p(b[] paramArrayOfb)
    {
      this.d = paramArrayOfb;
    }
    
    void q(b paramb)
    {
      this.g = paramb;
    }
    
    void r(h0 paramh0)
    {
      this.f = paramh0;
    }
    
    protected b u(int paramInt, boolean paramBoolean)
    {
      if (paramInt != 1)
      {
        Object localObject1 = null;
        b localb = null;
        if (paramInt != 2)
        {
          if (paramInt != 8)
          {
            if (paramInt != 16)
            {
              if (paramInt != 32)
              {
                if (paramInt != 64)
                {
                  if (paramInt != 128) {
                    return b.e;
                  }
                  localObject1 = this.f;
                  if (localObject1 != null) {
                    localObject1 = ((h0)localObject1).e();
                  } else {
                    localObject1 = f();
                  }
                  if (localObject1 != null) {
                    return b.b(((d)localObject1).b(), ((d)localObject1).d(), ((d)localObject1).c(), ((d)localObject1).a());
                  }
                  return b.e;
                }
                return l();
              }
              return h();
            }
            return j();
          }
          localObject2 = this.d;
          localObject1 = localb;
          if (localObject2 != null) {
            localObject1 = localObject2[h0.m.a(8)];
          }
          if (localObject1 != null) {
            return localObject1;
          }
          localb = k();
          localObject1 = v();
          paramInt = localb.d;
          if (paramInt > ((b)localObject1).d) {
            return b.b(0, 0, 0, paramInt);
          }
          localb = this.g;
          if ((localb != null) && (!localb.equals(b.e)))
          {
            paramInt = this.g.d;
            if (paramInt > ((b)localObject1).d) {
              return b.b(0, 0, 0, paramInt);
            }
          }
          return b.e;
        }
        if (paramBoolean)
        {
          localObject1 = v();
          localb = i();
          return b.b(Math.max(((b)localObject1).a, localb.a), 0, Math.max(((b)localObject1).c, localb.c), Math.max(((b)localObject1).d, localb.d));
        }
        localb = k();
        Object localObject2 = this.f;
        if (localObject2 != null) {
          localObject1 = ((h0)localObject2).g();
        }
        int m = localb.d;
        paramInt = m;
        if (localObject1 != null) {
          paramInt = Math.min(m, ((b)localObject1).d);
        }
        return b.b(localb.a, 0, localb.c, paramInt);
      }
      if (paramBoolean) {
        return b.b(0, Math.max(v().b, k().b), 0, 0);
      }
      return b.b(0, k().b, 0, 0);
    }
  }
  
  private static class h
    extends h0.g
  {
    private b m = null;
    
    h(h0 paramh0, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    h(h0 paramh0, h paramh)
    {
      super(paramh);
      this.m = paramh.m;
    }
    
    h0 b()
    {
      return h0.w(this.c.consumeStableInsets());
    }
    
    h0 c()
    {
      return h0.w(this.c.consumeSystemWindowInsets());
    }
    
    final b i()
    {
      if (this.m == null) {
        this.m = b.b(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
      }
      return this.m;
    }
    
    boolean n()
    {
      return this.c.isConsumed();
    }
    
    public void s(b paramb)
    {
      this.m = paramb;
    }
  }
  
  private static class i
    extends h0.h
  {
    i(h0 paramh0, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    i(h0 paramh0, i parami)
    {
      super(parami);
    }
    
    h0 a()
    {
      return h0.w(this.c.consumeDisplayCutout());
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof i)) {
        return false;
      }
      paramObject = (i)paramObject;
      return (Objects.equals(this.c, paramObject.c)) && (Objects.equals(this.g, paramObject.g));
    }
    
    d f()
    {
      return d.e(this.c.getDisplayCutout());
    }
    
    public int hashCode()
    {
      return this.c.hashCode();
    }
  }
  
  private static class j
    extends h0.i
  {
    private b n = null;
    private b o = null;
    private b p = null;
    
    j(h0 paramh0, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    j(h0 paramh0, j paramj)
    {
      super(paramj);
    }
    
    b h()
    {
      if (this.o == null) {
        this.o = b.d(this.c.getMandatorySystemGestureInsets());
      }
      return this.o;
    }
    
    b j()
    {
      if (this.n == null) {
        this.n = b.d(this.c.getSystemGestureInsets());
      }
      return this.n;
    }
    
    b l()
    {
      if (this.p == null) {
        this.p = b.d(this.c.getTappableElementInsets());
      }
      return this.p;
    }
    
    h0 m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return h0.w(this.c.inset(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    
    public void s(b paramb) {}
  }
  
  private static class k
    extends h0.j
  {
    static final h0 q = h0.w(WindowInsets.CONSUMED);
    
    k(h0 paramh0, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    k(h0 paramh0, k paramk)
    {
      super(paramk);
    }
    
    final void d(View paramView) {}
    
    public b g(int paramInt)
    {
      return b.d(this.c.getInsets(h0.n.a(paramInt)));
    }
  }
  
  private static class l
  {
    static final h0 b = new h0.b().a().a().b().c();
    final h0 a;
    
    l(h0 paramh0)
    {
      this.a = paramh0;
    }
    
    h0 a()
    {
      return this.a;
    }
    
    h0 b()
    {
      return this.a;
    }
    
    h0 c()
    {
      return this.a;
    }
    
    void d(View paramView) {}
    
    void e(h0 paramh0) {}
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof l)) {
        return false;
      }
      paramObject = (l)paramObject;
      return (o() == paramObject.o()) && (n() == paramObject.n()) && (c.a(k(), paramObject.k())) && (c.a(i(), paramObject.i())) && (c.a(f(), paramObject.f()));
    }
    
    d f()
    {
      return null;
    }
    
    b g(int paramInt)
    {
      return b.e;
    }
    
    b h()
    {
      return k();
    }
    
    public int hashCode()
    {
      return c.b(new Object[] { Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f() });
    }
    
    b i()
    {
      return b.e;
    }
    
    b j()
    {
      return k();
    }
    
    b k()
    {
      return b.e;
    }
    
    b l()
    {
      return k();
    }
    
    h0 m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return b;
    }
    
    boolean n()
    {
      return false;
    }
    
    boolean o()
    {
      return false;
    }
    
    public void p(b[] paramArrayOfb) {}
    
    void q(b paramb) {}
    
    void r(h0 paramh0) {}
    
    public void s(b paramb) {}
  }
  
  public static final class m
  {
    static int a(int paramInt)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 8)
            {
              if (paramInt != 16)
              {
                if (paramInt != 32)
                {
                  if (paramInt != 64)
                  {
                    if (paramInt != 128)
                    {
                      if (paramInt == 256) {
                        return 8;
                      }
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("type needs to be >= FIRST and <= LAST, type=");
                      localStringBuilder.append(paramInt);
                      throw new IllegalArgumentException(localStringBuilder.toString());
                    }
                    return 7;
                  }
                  return 6;
                }
                return 5;
              }
              return 4;
            }
            return 3;
          }
          return 2;
        }
        return 1;
      }
      return 0;
    }
    
    public static int b()
    {
      return 32;
    }
    
    public static int c()
    {
      return 7;
    }
  }
  
  private static final class n
  {
    static int a(int paramInt)
    {
      int k = 0;
      int j = 1;
      while (j <= 256)
      {
        int i = k;
        if ((paramInt & j) != 0)
        {
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 4)
              {
                if (j != 8)
                {
                  if (j != 16)
                  {
                    if (j != 32)
                    {
                      if (j != 64)
                      {
                        if (j != 128)
                        {
                          i = k;
                          break label127;
                        }
                        i = WindowInsets.Type.displayCutout();
                      }
                      else
                      {
                        i = WindowInsets.Type.tappableElement();
                      }
                    }
                    else {
                      i = WindowInsets.Type.mandatorySystemGestures();
                    }
                  }
                  else {
                    i = WindowInsets.Type.systemGestures();
                  }
                }
                else {
                  i = WindowInsets.Type.ime();
                }
              }
              else {
                i = WindowInsets.Type.captionBar();
              }
            }
            else {
              i = WindowInsets.Type.navigationBars();
            }
          }
          else {
            i = WindowInsets.Type.statusBars();
          }
          i = k | i;
        }
        label127:
        j <<= 1;
        k = i;
      }
      return k;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.h0
 * JD-Core Version:    0.7.0.1
 */