package d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import r0.a;

class b
  extends Drawable
  implements Drawable.Callback
{
  private d a;
  private Rect b;
  private Drawable c;
  private Drawable d;
  private int e = 255;
  private boolean f;
  private int g = -1;
  private boolean h;
  private Runnable i;
  private long j;
  private long k;
  private c l;
  
  private void d(Drawable paramDrawable)
  {
    if (this.l == null) {
      this.l = new c();
    }
    paramDrawable.setCallback(this.l.b(paramDrawable.getCallback()));
    try
    {
      if ((this.a.A <= 0) && (this.f)) {
        paramDrawable.setAlpha(this.e);
      }
      Object localObject1 = this.a;
      if (((d)localObject1).E)
      {
        paramDrawable.setColorFilter(((d)localObject1).D);
      }
      else
      {
        if (((d)localObject1).H) {
          a.o(paramDrawable, ((d)localObject1).F);
        }
        localObject1 = this.a;
        if (((d)localObject1).I) {
          a.p(paramDrawable, ((d)localObject1).G);
        }
      }
      paramDrawable.setVisible(isVisible(), true);
      paramDrawable.setDither(this.a.x);
      paramDrawable.setState(getState());
      paramDrawable.setLevel(getLevel());
      paramDrawable.setBounds(getBounds());
      a.m(paramDrawable, a.f(this));
      a.j(paramDrawable, this.a.C);
      localObject1 = this.b;
      if (localObject1 != null) {
        a.l(paramDrawable, ((Rect)localObject1).left, ((Rect)localObject1).top, ((Rect)localObject1).right, ((Rect)localObject1).bottom);
      }
      return;
    }
    finally
    {
      paramDrawable.setCallback(this.l.a());
    }
  }
  
  private boolean e()
  {
    return (isAutoMirrored()) && (a.f(this) == 1);
  }
  
  static int f(Resources paramResources, int paramInt)
  {
    if (paramResources != null) {
      paramInt = paramResources.getDisplayMetrics().densityDpi;
    }
    int m = paramInt;
    if (paramInt == 0) {
      m = 160;
    }
    return m;
  }
  
  void a(boolean paramBoolean)
  {
    int n = 1;
    this.f = true;
    long l1 = SystemClock.uptimeMillis();
    Drawable localDrawable = this.c;
    long l2;
    if (localDrawable != null)
    {
      l2 = this.j;
      if (l2 == 0L) {
        break label102;
      }
      if (l2 <= l1)
      {
        localDrawable.setAlpha(this.e);
      }
      else
      {
        localDrawable.setAlpha((255 - (int)((l2 - l1) * 255L) / this.a.A) * this.e / 255);
        m = 1;
        break label104;
      }
    }
    this.j = 0L;
    label102:
    int m = 0;
    label104:
    localDrawable = this.d;
    if (localDrawable != null)
    {
      l2 = this.k;
      if (l2 == 0L) {
        break label194;
      }
      if (l2 <= l1)
      {
        localDrawable.setVisible(false, false);
        this.d = null;
      }
      else
      {
        localDrawable.setAlpha((int)((l2 - l1) * 255L) / this.a.B * this.e / 255);
        m = n;
        break label194;
      }
    }
    this.k = 0L;
    label194:
    if ((paramBoolean) && (m != 0)) {
      scheduleSelf(this.i, l1 + 16L);
    }
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    this.a.b(paramTheme);
  }
  
  d b()
  {
    throw null;
  }
  
  int c()
  {
    return this.g;
  }
  
  public boolean canApplyTheme()
  {
    return this.a.canApplyTheme();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    localDrawable = this.d;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  boolean g(int paramInt)
  {
    if (paramInt == this.g) {
      return false;
    }
    long l1 = SystemClock.uptimeMillis();
    Object localObject;
    if (this.a.B > 0)
    {
      localObject = this.d;
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
      localObject = this.c;
      if (localObject != null)
      {
        this.d = ((Drawable)localObject);
        this.k = (this.a.B + l1);
      }
      else
      {
        this.d = null;
        this.k = 0L;
      }
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
    }
    if (paramInt >= 0)
    {
      localObject = this.a;
      if (paramInt < ((d)localObject).h)
      {
        localObject = ((d)localObject).g(paramInt);
        this.c = ((Drawable)localObject);
        this.g = paramInt;
        if (localObject == null) {
          break label191;
        }
        paramInt = this.a.A;
        if (paramInt > 0) {
          this.j = (l1 + paramInt);
        }
        d((Drawable)localObject);
        break label191;
      }
    }
    this.c = null;
    this.g = -1;
    label191:
    if ((this.j != 0L) || (this.k != 0L))
    {
      localObject = this.i;
      if (localObject == null) {
        this.i = new a();
      } else {
        unscheduleSelf((Runnable)localObject);
      }
      a(true);
    }
    invalidateSelf();
    return true;
  }
  
  public int getAlpha()
  {
    return this.e;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.a.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.a.c())
    {
      this.a.d = getChangingConfigurations();
      return this.a;
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.c;
  }
  
  public void getHotspotBounds(Rect paramRect)
  {
    Rect localRect = this.b;
    if (localRect != null)
    {
      paramRect.set(localRect);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.a.q()) {
      return this.a.i();
    }
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.a.q()) {
      return this.a.m();
    }
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getMinimumHeight()
  {
    if (this.a.q()) {
      return this.a.j();
    }
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      return localDrawable.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.a.q()) {
      return this.a.k();
    }
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      return localDrawable.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.c;
    if ((localDrawable != null) && (localDrawable.isVisible())) {
      return this.a.n();
    }
    return -2;
  }
  
  public void getOutline(Outline paramOutline)
  {
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      b.b(localDrawable, paramOutline);
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Object localObject = this.a.l();
    int m;
    boolean bool;
    if (localObject != null)
    {
      paramRect.set((Rect)localObject);
      m = ((Rect)localObject).left;
      int n = ((Rect)localObject).top;
      int i1 = ((Rect)localObject).bottom;
      if ((((Rect)localObject).right | m | n | i1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        bool = ((Drawable)localObject).getPadding(paramRect);
      } else {
        bool = super.getPadding(paramRect);
      }
    }
    if (e())
    {
      m = paramRect.left;
      paramRect.left = paramRect.right;
      paramRect.right = m;
    }
    return bool;
  }
  
  void h(d paramd)
  {
    this.a = paramd;
    int m = this.g;
    if (m >= 0)
    {
      paramd = paramd.g(m);
      this.c = paramd;
      if (paramd != null) {
        d(paramd);
      }
    }
    this.d = null;
  }
  
  final void i(Resources paramResources)
  {
    this.a.y(paramResources);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    d locald = this.a;
    if (locald != null) {
      locald.p();
    }
    if ((paramDrawable == this.c) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.a.C;
  }
  
  public void jumpToCurrentState()
  {
    Drawable localDrawable = this.d;
    int n = 1;
    int m;
    if (localDrawable != null)
    {
      localDrawable.jumpToCurrentState();
      this.d = null;
      m = 1;
    }
    else
    {
      m = 0;
    }
    localDrawable = this.c;
    if (localDrawable != null)
    {
      localDrawable.jumpToCurrentState();
      if (this.f) {
        this.c.setAlpha(this.e);
      }
    }
    if (this.k != 0L)
    {
      this.k = 0L;
      m = 1;
    }
    if (this.j != 0L)
    {
      this.j = 0L;
      m = n;
    }
    if (m != 0) {
      invalidateSelf();
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.h) && (super.mutate() == this))
    {
      d locald = b();
      locald.r();
      h(locald);
      this.h = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.d;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
    localDrawable = this.c;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    return this.a.w(paramInt, c());
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = this.d;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    localDrawable = this.c;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = this.d;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    localDrawable = this.c;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.c) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.f) || (this.e != paramInt))
    {
      this.f = true;
      this.e = paramInt;
      Drawable localDrawable = this.c;
      if (localDrawable != null)
      {
        if (this.j == 0L)
        {
          localDrawable.setAlpha(paramInt);
          return;
        }
        a(false);
      }
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (((d)localObject).C != paramBoolean)
    {
      ((d)localObject).C = paramBoolean;
      localObject = this.c;
      if (localObject != null) {
        a.j((Drawable)localObject, paramBoolean);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Object localObject = this.a;
    ((d)localObject).E = true;
    if (((d)localObject).D != paramColorFilter)
    {
      ((d)localObject).D = paramColorFilter;
      localObject = this.c;
      if (localObject != null) {
        ((Drawable)localObject).setColorFilter(paramColorFilter);
      }
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (((d)localObject).x != paramBoolean)
    {
      ((d)localObject).x = paramBoolean;
      localObject = this.c;
      if (localObject != null) {
        ((Drawable)localObject).setDither(paramBoolean);
      }
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      a.k(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.b;
    if (localObject == null) {
      this.b = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    } else {
      ((Rect)localObject).set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.c;
    if (localObject != null) {
      a.l((Drawable)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    d locald = this.a;
    locald.H = true;
    if (locald.F != paramColorStateList)
    {
      locald.F = paramColorStateList;
      a.o(this.c, paramColorStateList);
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    d locald = this.a;
    locald.I = true;
    if (locald.G != paramMode)
    {
      locald.G = paramMode;
      a.p(this.c, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    Drawable localDrawable = this.d;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    localDrawable = this.c;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == this.c) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      b.this.a(true);
      b.this.invalidateSelf();
    }
  }
  
  private static class b
  {
    public static boolean a(Drawable.ConstantState paramConstantState)
    {
      return paramConstantState.canApplyTheme();
    }
    
    public static void b(Drawable paramDrawable, Outline paramOutline)
    {
      paramDrawable.getOutline(paramOutline);
    }
    
    public static Resources c(Resources.Theme paramTheme)
    {
      return paramTheme.getResources();
    }
  }
  
  static class c
    implements Drawable.Callback
  {
    private Drawable.Callback a;
    
    public Drawable.Callback a()
    {
      Drawable.Callback localCallback = this.a;
      this.a = null;
      return localCallback;
    }
    
    public c b(Drawable.Callback paramCallback)
    {
      this.a = paramCallback;
      return this;
    }
    
    public void invalidateDrawable(Drawable paramDrawable) {}
    
    public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      Drawable.Callback localCallback = this.a;
      if (localCallback != null) {
        localCallback.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
    
    public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      Drawable.Callback localCallback = this.a;
      if (localCallback != null) {
        localCallback.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
  }
  
  static abstract class d
    extends Drawable.ConstantState
  {
    int A;
    int B;
    boolean C;
    ColorFilter D;
    boolean E;
    ColorStateList F;
    PorterDuff.Mode G;
    boolean H;
    boolean I;
    final b a;
    Resources b;
    int c;
    int d;
    int e;
    SparseArray<Drawable.ConstantState> f;
    Drawable[] g;
    int h;
    boolean i;
    boolean j;
    Rect k;
    boolean l;
    boolean m;
    int n;
    int o;
    int p;
    int q;
    boolean r;
    int s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    int z;
    
    d(d paramd, b paramb, Resources paramResources)
    {
      int i2 = 0;
      this.i = false;
      this.l = false;
      this.x = true;
      this.A = 0;
      this.B = 0;
      this.a = paramb;
      Object localObject = null;
      if (paramResources != null) {
        paramb = paramResources;
      } else if (paramd != null) {
        paramb = paramd.b;
      } else {
        paramb = null;
      }
      this.b = paramb;
      if (paramd != null) {
        i1 = paramd.c;
      } else {
        i1 = 0;
      }
      int i1 = b.f(paramResources, i1);
      this.c = i1;
      if (paramd != null)
      {
        this.d = paramd.d;
        this.e = paramd.e;
        this.v = true;
        this.w = true;
        this.i = paramd.i;
        this.l = paramd.l;
        this.x = paramd.x;
        this.y = paramd.y;
        this.z = paramd.z;
        this.A = paramd.A;
        this.B = paramd.B;
        this.C = paramd.C;
        this.D = paramd.D;
        this.E = paramd.E;
        this.F = paramd.F;
        this.G = paramd.G;
        this.H = paramd.H;
        this.I = paramd.I;
        if (paramd.c == i1)
        {
          if (paramd.j)
          {
            paramb = localObject;
            if (paramd.k != null) {
              paramb = new Rect(paramd.k);
            }
            this.k = paramb;
            this.j = true;
          }
          if (paramd.m)
          {
            this.n = paramd.n;
            this.o = paramd.o;
            this.p = paramd.p;
            this.q = paramd.q;
            this.m = true;
          }
        }
        if (paramd.r)
        {
          this.s = paramd.s;
          this.r = true;
        }
        if (paramd.t)
        {
          this.u = paramd.u;
          this.t = true;
        }
        paramb = paramd.g;
        this.g = new Drawable[paramb.length];
        this.h = paramd.h;
        paramd = paramd.f;
        if (paramd != null) {
          paramd = paramd.clone();
        } else {
          paramd = new SparseArray(this.h);
        }
        this.f = paramd;
        int i3 = this.h;
        i1 = i2;
        while (i1 < i3)
        {
          if (paramb[i1] != null)
          {
            paramd = paramb[i1].getConstantState();
            if (paramd != null) {
              this.f.put(i1, paramd);
            } else {
              this.g[i1] = paramb[i1];
            }
          }
          i1 += 1;
        }
      }
      this.g = new Drawable[10];
      this.h = 0;
    }
    
    private void e()
    {
      Object localObject = this.f;
      if (localObject != null)
      {
        int i2 = ((SparseArray)localObject).size();
        int i1 = 0;
        while (i1 < i2)
        {
          int i3 = this.f.keyAt(i1);
          localObject = (Drawable.ConstantState)this.f.valueAt(i1);
          this.g[i3] = s(((Drawable.ConstantState)localObject).newDrawable(this.b));
          i1 += 1;
        }
        this.f = null;
      }
    }
    
    private Drawable s(Drawable paramDrawable)
    {
      a.m(paramDrawable, this.z);
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.a);
      return paramDrawable;
    }
    
    public final int a(Drawable paramDrawable)
    {
      int i1 = this.h;
      if (i1 >= this.g.length) {
        o(i1, i1 + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.a);
      this.g[i1] = paramDrawable;
      this.h += 1;
      int i2 = this.e;
      this.e = (paramDrawable.getChangingConfigurations() | i2);
      p();
      this.k = null;
      this.j = false;
      this.m = false;
      this.v = false;
      return i1;
    }
    
    final void b(Resources.Theme paramTheme)
    {
      if (paramTheme != null)
      {
        e();
        int i2 = this.h;
        Drawable[] arrayOfDrawable = this.g;
        int i1 = 0;
        while (i1 < i2)
        {
          if ((arrayOfDrawable[i1] != null) && (a.b(arrayOfDrawable[i1])))
          {
            a.a(arrayOfDrawable[i1], paramTheme);
            this.e |= arrayOfDrawable[i1].getChangingConfigurations();
          }
          i1 += 1;
        }
        y(b.b.c(paramTheme));
      }
    }
    
    public boolean c()
    {
      if (this.v) {
        return this.w;
      }
      e();
      this.v = true;
      int i2 = this.h;
      Drawable[] arrayOfDrawable = this.g;
      int i1 = 0;
      while (i1 < i2)
      {
        if (arrayOfDrawable[i1].getConstantState() == null)
        {
          this.w = false;
          return false;
        }
        i1 += 1;
      }
      this.w = true;
      return true;
    }
    
    public boolean canApplyTheme()
    {
      int i2 = this.h;
      Drawable[] arrayOfDrawable = this.g;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = arrayOfDrawable[i1];
        if (localObject != null)
        {
          if (a.b((Drawable)localObject)) {
            return true;
          }
        }
        else
        {
          localObject = (Drawable.ConstantState)this.f.get(i1);
          if ((localObject != null) && (b.b.a((Drawable.ConstantState)localObject))) {
            return true;
          }
        }
        i1 += 1;
      }
      return false;
    }
    
    protected void d()
    {
      this.m = true;
      e();
      int i2 = this.h;
      Drawable[] arrayOfDrawable = this.g;
      this.o = -1;
      this.n = -1;
      int i1 = 0;
      this.q = 0;
      this.p = 0;
      while (i1 < i2)
      {
        Drawable localDrawable = arrayOfDrawable[i1];
        int i3 = localDrawable.getIntrinsicWidth();
        if (i3 > this.n) {
          this.n = i3;
        }
        i3 = localDrawable.getIntrinsicHeight();
        if (i3 > this.o) {
          this.o = i3;
        }
        i3 = localDrawable.getMinimumWidth();
        if (i3 > this.p) {
          this.p = i3;
        }
        i3 = localDrawable.getMinimumHeight();
        if (i3 > this.q) {
          this.q = i3;
        }
        i1 += 1;
      }
    }
    
    final int f()
    {
      return this.g.length;
    }
    
    public final Drawable g(int paramInt)
    {
      Object localObject = this.g[paramInt];
      if (localObject != null) {
        return localObject;
      }
      localObject = this.f;
      if (localObject != null)
      {
        int i1 = ((SparseArray)localObject).indexOfKey(paramInt);
        if (i1 >= 0)
        {
          localObject = s(((Drawable.ConstantState)this.f.valueAt(i1)).newDrawable(this.b));
          this.g[paramInt] = localObject;
          this.f.removeAt(i1);
          if (this.f.size() == 0) {
            this.f = null;
          }
          return localObject;
        }
      }
      return null;
    }
    
    public int getChangingConfigurations()
    {
      return this.d | this.e;
    }
    
    public final int h()
    {
      return this.h;
    }
    
    public final int i()
    {
      if (!this.m) {
        d();
      }
      return this.o;
    }
    
    public final int j()
    {
      if (!this.m) {
        d();
      }
      return this.q;
    }
    
    public final int k()
    {
      if (!this.m) {
        d();
      }
      return this.p;
    }
    
    public final Rect l()
    {
      boolean bool = this.i;
      Object localObject1 = null;
      if (bool) {
        return null;
      }
      Object localObject2 = this.k;
      if (localObject2 == null)
      {
        if (this.j) {
          return localObject2;
        }
        e();
        Rect localRect = new Rect();
        int i2 = this.h;
        Drawable[] arrayOfDrawable = this.g;
        int i1 = 0;
        while (i1 < i2)
        {
          Object localObject3 = localObject1;
          if (arrayOfDrawable[i1].getPadding(localRect))
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new Rect(0, 0, 0, 0);
            }
            int i3 = localRect.left;
            if (i3 > ((Rect)localObject2).left) {
              ((Rect)localObject2).left = i3;
            }
            i3 = localRect.top;
            if (i3 > ((Rect)localObject2).top) {
              ((Rect)localObject2).top = i3;
            }
            i3 = localRect.right;
            if (i3 > ((Rect)localObject2).right) {
              ((Rect)localObject2).right = i3;
            }
            i3 = localRect.bottom;
            localObject3 = localObject2;
            if (i3 > ((Rect)localObject2).bottom)
            {
              ((Rect)localObject2).bottom = i3;
              localObject3 = localObject2;
            }
          }
          i1 += 1;
          localObject1 = localObject3;
        }
        this.j = true;
        this.k = localObject1;
        return localObject1;
      }
      return localObject2;
    }
    
    public final int m()
    {
      if (!this.m) {
        d();
      }
      return this.n;
    }
    
    public final int n()
    {
      if (this.r) {
        return this.s;
      }
      e();
      int i3 = this.h;
      Drawable[] arrayOfDrawable = this.g;
      int i1;
      if (i3 > 0) {
        i1 = arrayOfDrawable[0].getOpacity();
      } else {
        i1 = -2;
      }
      int i2 = 1;
      while (i2 < i3)
      {
        i1 = Drawable.resolveOpacity(i1, arrayOfDrawable[i2].getOpacity());
        i2 += 1;
      }
      this.s = i1;
      this.r = true;
      return i1;
    }
    
    public void o(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable1 = new Drawable[paramInt2];
      Drawable[] arrayOfDrawable2 = this.g;
      if (arrayOfDrawable2 != null) {
        System.arraycopy(arrayOfDrawable2, 0, arrayOfDrawable1, 0, paramInt1);
      }
      this.g = arrayOfDrawable1;
    }
    
    void p()
    {
      this.r = false;
      this.t = false;
    }
    
    public final boolean q()
    {
      return this.l;
    }
    
    abstract void r();
    
    public final void t(boolean paramBoolean)
    {
      this.l = paramBoolean;
    }
    
    public final void u(int paramInt)
    {
      this.A = paramInt;
    }
    
    public final void v(int paramInt)
    {
      this.B = paramInt;
    }
    
    final boolean w(int paramInt1, int paramInt2)
    {
      int i2 = this.h;
      Drawable[] arrayOfDrawable = this.g;
      int i1 = 0;
      boolean bool2;
      for (boolean bool1 = false; i1 < i2; bool1 = bool2)
      {
        bool2 = bool1;
        if (arrayOfDrawable[i1] != null)
        {
          boolean bool3 = a.m(arrayOfDrawable[i1], paramInt1);
          bool2 = bool1;
          if (i1 == paramInt2) {
            bool2 = bool3;
          }
        }
        i1 += 1;
      }
      this.z = paramInt1;
      return bool1;
    }
    
    public final void x(boolean paramBoolean)
    {
      this.i = paramBoolean;
    }
    
    final void y(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.b = paramResources;
        int i1 = b.f(paramResources, this.c);
        int i2 = this.c;
        this.c = i1;
        if (i2 != i1)
        {
          this.m = false;
          this.j = false;
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d.b
 * JD-Core Version:    0.7.0.1
 */