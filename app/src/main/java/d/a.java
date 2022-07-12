package d;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.R.styleable;
import androidx.appcompat.widget.a0;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p0.i;

@SuppressLint({"RestrictedAPI"})
public class a
  extends d
{
  private static final String t = a.class.getSimpleName();
  private c o;
  private g p;
  private int q = -1;
  private int r = -1;
  private boolean s;
  
  public a()
  {
    this(null, null);
  }
  
  a(c paramc, Resources paramResources)
  {
    super(null);
    h(new c(paramc, this, paramResources));
    onStateChange(getState());
    jumpToCurrentState();
  }
  
  public static a m(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject = paramXmlPullParser.getName();
    if (((String)localObject).equals("animated-selector"))
    {
      localObject = new a();
      ((a)localObject).n(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return localObject;
    }
    paramContext = new StringBuilder();
    paramContext.append(paramXmlPullParser.getPositionDescription());
    paramContext.append(": invalid animated-selector tag ");
    paramContext.append((String)localObject);
    throw new XmlPullParserException(paramContext.toString());
  }
  
  private void o(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    int i = paramXmlPullParser.getDepth() + 1;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3)) {
        break;
      }
      if ((j == 2) && (k <= i)) {
        if (paramXmlPullParser.getName().equals("item")) {
          q(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else if (paramXmlPullParser.getName().equals("transition")) {
          r(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        }
      }
    }
  }
  
  private void p()
  {
    onStateChange(getState());
  }
  
  private int q(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject = i.k(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableItem);
    int i = ((TypedArray)localObject).getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
    int j = ((TypedArray)localObject).getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
    if (j > 0) {
      paramContext = a0.h().j(paramContext, j);
    } else {
      paramContext = null;
    }
    ((TypedArray)localObject).recycle();
    int[] arrayOfInt = k(paramAttributeSet);
    localObject = paramContext;
    if (paramContext == null)
    {
      do
      {
        j = paramXmlPullParser.next();
      } while (j == 4);
      if (j == 2)
      {
        if (paramXmlPullParser.getName().equals("vector")) {
          localObject = androidx.vectordrawable.graphics.drawable.h.c(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else {
          localObject = e.c.a(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append(paramXmlPullParser.getPositionDescription());
        paramContext.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(paramContext.toString());
      }
    }
    if (localObject != null) {
      return this.o.B(arrayOfInt, (Drawable)localObject, i);
    }
    paramContext = new StringBuilder();
    paramContext.append(paramXmlPullParser.getPositionDescription());
    paramContext.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    throw new XmlPullParserException(paramContext.toString());
  }
  
  private int r(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject = i.k(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableTransition);
    int i = ((TypedArray)localObject).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
    int j = ((TypedArray)localObject).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
    int k = ((TypedArray)localObject).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
    Drawable localDrawable;
    if (k > 0) {
      localDrawable = a0.h().j(paramContext, k);
    } else {
      localDrawable = null;
    }
    boolean bool = ((TypedArray)localObject).getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
    ((TypedArray)localObject).recycle();
    localObject = localDrawable;
    if (localDrawable == null)
    {
      do
      {
        k = paramXmlPullParser.next();
      } while (k == 4);
      if (k == 2)
      {
        if (paramXmlPullParser.getName().equals("animated-vector")) {
          localObject = androidx.vectordrawable.graphics.drawable.c.a(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else {
          localObject = e.c.a(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append(paramXmlPullParser.getPositionDescription());
        paramContext.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(paramContext.toString());
      }
    }
    if (localObject != null)
    {
      if ((i != -1) && (j != -1)) {
        return this.o.C(i, j, (Drawable)localObject, bool);
      }
      paramContext = new StringBuilder();
      paramContext.append(paramXmlPullParser.getPositionDescription());
      paramContext.append(": <transition> tag requires 'fromId' & 'toId' attributes");
      throw new XmlPullParserException(paramContext.toString());
    }
    paramContext = new StringBuilder();
    paramContext.append(paramXmlPullParser.getPositionDescription());
    paramContext.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
    throw new XmlPullParserException(paramContext.toString());
  }
  
  private boolean s(int paramInt)
  {
    Object localObject = this.p;
    int i;
    if (localObject != null)
    {
      if (paramInt == this.q) {
        return true;
      }
      if ((paramInt == this.r) && (((g)localObject).a()))
      {
        ((g)localObject).b();
        this.q = this.r;
        this.r = paramInt;
        return true;
      }
      i = this.q;
      ((g)localObject).d();
    }
    else
    {
      i = c();
    }
    this.p = null;
    this.r = -1;
    this.q = -1;
    localObject = this.o;
    int j = ((c)localObject).E(i);
    int k = ((c)localObject).E(paramInt);
    if (k != 0)
    {
      if (j == 0) {
        return false;
      }
      int m = ((c)localObject).G(j, k);
      if (m < 0) {
        return false;
      }
      boolean bool1 = ((c)localObject).I(j, k);
      g(m);
      Drawable localDrawable = getCurrent();
      if ((localDrawable instanceof AnimationDrawable))
      {
        boolean bool2 = ((c)localObject).H(j, k);
        localObject = new e((AnimationDrawable)localDrawable, bool2, bool1);
      }
      else if ((localDrawable instanceof androidx.vectordrawable.graphics.drawable.c))
      {
        localObject = new d((androidx.vectordrawable.graphics.drawable.c)localDrawable);
      }
      else
      {
        if (!(localDrawable instanceof Animatable)) {
          break label271;
        }
        localObject = new b((Animatable)localDrawable);
      }
      ((g)localObject).c();
      this.p = ((g)localObject);
      this.r = i;
      this.q = paramInt;
      return true;
    }
    label271:
    return false;
  }
  
  private void t(TypedArray paramTypedArray)
  {
    c localc = this.o;
    localc.d |= e.c.b(paramTypedArray);
    localc.x(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, localc.i));
    localc.t(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, localc.l));
    localc.u(paramTypedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, localc.A));
    localc.v(paramTypedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, localc.B));
    setDither(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, localc.x));
  }
  
  void h(b.d paramd)
  {
    super.h(paramd);
    if ((paramd instanceof c)) {
      this.o = ((c)paramd);
    }
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public void jumpToCurrentState()
  {
    super.jumpToCurrentState();
    g localg = this.p;
    if (localg != null)
    {
      localg.d();
      this.p = null;
      g(this.q);
      this.q = -1;
      this.r = -1;
    }
  }
  
  c l()
  {
    return new c(this.o, this, null);
  }
  
  public Drawable mutate()
  {
    if ((!this.s) && (super.mutate() == this))
    {
      this.o.r();
      this.s = true;
    }
    return this;
  }
  
  public void n(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    TypedArray localTypedArray = i.k(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableCompat);
    setVisible(localTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
    t(localTypedArray);
    i(paramResources);
    localTypedArray.recycle();
    o(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    p();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.o.F(paramArrayOfInt);
    boolean bool1;
    if ((i != c()) && ((s(i)) || (g(i)))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Drawable localDrawable = getCurrent();
    boolean bool2 = bool1;
    if (localDrawable != null) {
      bool2 = bool1 | localDrawable.setState(paramArrayOfInt);
    }
    return bool2;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    g localg = this.p;
    if ((localg != null) && ((bool) || (paramBoolean2)))
    {
      if (paramBoolean1)
      {
        localg.c();
        return bool;
      }
      jumpToCurrentState();
    }
    return bool;
  }
  
  private static class b
    extends a.g
  {
    private final Animatable a;
    
    b(Animatable paramAnimatable)
    {
      super();
      this.a = paramAnimatable;
    }
    
    public void c()
    {
      this.a.start();
    }
    
    public void d()
    {
      this.a.stop();
    }
  }
  
  static class c
    extends d.a
  {
    g0.d<Long> K;
    g0.h<Integer> L;
    
    c(c paramc, a parama, Resources paramResources)
    {
      super(parama, paramResources);
      if (paramc != null)
      {
        this.K = paramc.K;
        paramc = paramc.L;
      }
      else
      {
        this.K = new g0.d();
        paramc = new g0.h();
      }
      this.L = paramc;
    }
    
    private static long D(int paramInt1, int paramInt2)
    {
      long l = paramInt1;
      return paramInt2 | l << 32;
    }
    
    int B(int[] paramArrayOfInt, Drawable paramDrawable, int paramInt)
    {
      int i = super.z(paramArrayOfInt, paramDrawable);
      this.L.l(i, Integer.valueOf(paramInt));
      return i;
    }
    
    int C(int paramInt1, int paramInt2, Drawable paramDrawable, boolean paramBoolean)
    {
      int i = super.a(paramDrawable);
      long l2 = D(paramInt1, paramInt2);
      long l1;
      if (paramBoolean) {
        l1 = 8589934592L;
      } else {
        l1 = 0L;
      }
      paramDrawable = this.K;
      long l3 = i;
      paramDrawable.a(l2, Long.valueOf(l3 | l1));
      if (paramBoolean)
      {
        l2 = D(paramInt2, paramInt1);
        this.K.a(l2, Long.valueOf(0x0 | l3 | l1));
      }
      return i;
    }
    
    int E(int paramInt)
    {
      if (paramInt < 0) {
        return 0;
      }
      return ((Integer)this.L.f(paramInt, Integer.valueOf(0))).intValue();
    }
    
    int F(int[] paramArrayOfInt)
    {
      int i = super.A(paramArrayOfInt);
      if (i >= 0) {
        return i;
      }
      return super.A(StateSet.WILD_CARD);
    }
    
    int G(int paramInt1, int paramInt2)
    {
      long l = D(paramInt1, paramInt2);
      return (int)((Long)this.K.f(l, Long.valueOf(-1L))).longValue();
    }
    
    boolean H(int paramInt1, int paramInt2)
    {
      long l = D(paramInt1, paramInt2);
      return (((Long)this.K.f(l, Long.valueOf(-1L))).longValue() & 0x0) != 0L;
    }
    
    boolean I(int paramInt1, int paramInt2)
    {
      long l = D(paramInt1, paramInt2);
      return (((Long)this.K.f(l, Long.valueOf(-1L))).longValue() & 0x0) != 0L;
    }
    
    public Drawable newDrawable()
    {
      return new a(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new a(this, paramResources);
    }
    
    void r()
    {
      this.K = this.K.c();
      this.L = this.L.c();
    }
  }
  
  private static class d
    extends a.g
  {
    private final androidx.vectordrawable.graphics.drawable.c a;
    
    d(androidx.vectordrawable.graphics.drawable.c paramc)
    {
      super();
      this.a = paramc;
    }
    
    public void c()
    {
      this.a.start();
    }
    
    public void d()
    {
      this.a.stop();
    }
  }
  
  private static class e
    extends a.g
  {
    private final ObjectAnimator a;
    private final boolean b;
    
    e(AnimationDrawable paramAnimationDrawable, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      int j = paramAnimationDrawable.getNumberOfFrames();
      int i;
      if (paramBoolean1) {
        i = j - 1;
      } else {
        i = 0;
      }
      if (paramBoolean1) {
        j = 0;
      } else {
        j -= 1;
      }
      a.f localf = new a.f(paramAnimationDrawable, paramBoolean1);
      paramAnimationDrawable = ObjectAnimator.ofInt(paramAnimationDrawable, "currentIndex", new int[] { i, j });
      e.b.a(paramAnimationDrawable, true);
      paramAnimationDrawable.setDuration(localf.a());
      paramAnimationDrawable.setInterpolator(localf);
      this.b = paramBoolean2;
      this.a = paramAnimationDrawable;
    }
    
    public boolean a()
    {
      return this.b;
    }
    
    public void b()
    {
      this.a.reverse();
    }
    
    public void c()
    {
      this.a.start();
    }
    
    public void d()
    {
      this.a.cancel();
    }
  }
  
  private static class f
    implements TimeInterpolator
  {
    private int[] a;
    private int b;
    private int c;
    
    f(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
    {
      b(paramAnimationDrawable, paramBoolean);
    }
    
    int a()
    {
      return this.c;
    }
    
    int b(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
    {
      int m = paramAnimationDrawable.getNumberOfFrames();
      this.b = m;
      int[] arrayOfInt = this.a;
      if ((arrayOfInt == null) || (arrayOfInt.length < m)) {
        this.a = new int[m];
      }
      arrayOfInt = this.a;
      int i = 0;
      int j = 0;
      while (i < m)
      {
        if (paramBoolean) {
          k = m - i - 1;
        } else {
          k = i;
        }
        int k = paramAnimationDrawable.getDuration(k);
        arrayOfInt[i] = k;
        j += k;
        i += 1;
      }
      this.c = j;
      return j;
    }
    
    public float getInterpolation(float paramFloat)
    {
      int j = (int)(paramFloat * this.c + 0.5F);
      int k = this.b;
      int[] arrayOfInt = this.a;
      int i = 0;
      while ((i < k) && (j >= arrayOfInt[i]))
      {
        j -= arrayOfInt[i];
        i += 1;
      }
      if (i < k) {
        paramFloat = j / this.c;
      } else {
        paramFloat = 0.0F;
      }
      return i / k + paramFloat;
    }
  }
  
  private static abstract class g
  {
    public boolean a()
    {
      return false;
    }
    
    public void b() {}
    
    public abstract void c();
    
    public abstract void d();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d.a
 * JD-Core Version:    0.7.0.1
 */