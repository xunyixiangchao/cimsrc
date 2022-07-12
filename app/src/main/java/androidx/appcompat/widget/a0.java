package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R.drawable;
import androidx.core.content.b;
import g0.d;
import g0.e;
import g0.g;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a0
{
  private static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
  private static a0 i;
  private static final c j = new c(6);
  private WeakHashMap<Context, g0.h<ColorStateList>> a;
  private g<String, e> b;
  private g0.h<String> c;
  private final WeakHashMap<Context, d<WeakReference<Drawable.ConstantState>>> d = new WeakHashMap(0);
  private TypedValue e;
  private boolean f;
  private f g;
  
  private void a(String paramString, e parame)
  {
    if (this.b == null) {
      this.b = new g();
    }
    this.b.put(paramString, parame);
  }
  
  /* Error */
  private boolean b(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload 4
    //   4: invokevirtual 81	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   7: astore 7
    //   9: aload 7
    //   11: ifnull +68 -> 79
    //   14: aload_0
    //   15: getfield 64	androidx/appcompat/widget/a0:d	Ljava/util/WeakHashMap;
    //   18: aload_1
    //   19: invokevirtual 85	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 87	g0/d
    //   25: astore 6
    //   27: aload 6
    //   29: astore 4
    //   31: aload 6
    //   33: ifnonnull +23 -> 56
    //   36: new 87	g0/d
    //   39: dup
    //   40: invokespecial 88	g0/d:<init>	()V
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 64	androidx/appcompat/widget/a0:d	Ljava/util/WeakHashMap;
    //   49: aload_1
    //   50: aload 4
    //   52: invokevirtual 89	java/util/WeakHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload 4
    //   58: lload_2
    //   59: new 91	java/lang/ref/WeakReference
    //   62: dup
    //   63: aload 7
    //   65: invokespecial 94	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   68: invokevirtual 98	g0/d:l	(JLjava/lang/Object;)V
    //   71: iconst_1
    //   72: istore 5
    //   74: aload_0
    //   75: monitorexit
    //   76: iload 5
    //   78: ireturn
    //   79: iconst_0
    //   80: istore 5
    //   82: goto -8 -> 74
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a0
    //   0	90	1	paramContext	Context
    //   0	90	2	paramLong	long
    //   0	90	4	paramDrawable	Drawable
    //   72	9	5	bool	boolean
    //   25	7	6	locald	d
    //   7	57	7	localConstantState	Drawable.ConstantState
    // Exception table:
    //   from	to	target	type
    //   2	9	85	finally
    //   14	27	85	finally
    //   36	56	85	finally
    //   56	71	85	finally
  }
  
  private void c(Context paramContext, int paramInt, ColorStateList paramColorStateList)
  {
    if (this.a == null) {
      this.a = new WeakHashMap();
    }
    g0.h localh2 = (g0.h)this.a.get(paramContext);
    g0.h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new g0.h();
      this.a.put(paramContext, localh1);
    }
    localh1.a(paramInt, paramColorStateList);
  }
  
  private void d(Context paramContext)
  {
    if (this.f) {
      return;
    }
    this.f = true;
    paramContext = j(paramContext, R.drawable.abc_vector_test);
    if ((paramContext != null) && (q(paramContext))) {
      return;
    }
    this.f = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }
  
  private static long e(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  private Drawable f(Context paramContext, int paramInt)
  {
    if (this.e == null) {
      this.e = new TypedValue();
    }
    TypedValue localTypedValue = this.e;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l = e(localTypedValue);
    Object localObject = i(paramContext, l);
    if (localObject != null) {
      return localObject;
    }
    localObject = this.g;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((f)localObject).c(this, paramContext, paramInt);
    }
    if (localObject != null)
    {
      ((Drawable)localObject).setChangingConfigurations(localTypedValue.changingConfigurations);
      b(paramContext, l, (Drawable)localObject);
    }
    return localObject;
  }
  
  private static PorterDuffColorFilter g(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfInt)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return l(paramColorStateList.getColorForState(paramArrayOfInt, 0), paramMode);
    }
    return null;
  }
  
  public static a0 h()
  {
    try
    {
      if (i == null)
      {
        locala0 = new a0();
        i = locala0;
        p(locala0);
      }
      a0 locala0 = i;
      return locala0;
    }
    finally {}
  }
  
  private Drawable i(Context paramContext, long paramLong)
  {
    try
    {
      d locald = (d)this.d.get(paramContext);
      if (locald == null) {
        return null;
      }
      Object localObject = (WeakReference)locald.e(paramLong);
      if (localObject != null)
      {
        localObject = (Drawable.ConstantState)((WeakReference)localObject).get();
        if (localObject != null)
        {
          paramContext = ((Drawable.ConstantState)localObject).newDrawable(paramContext.getResources());
          return paramContext;
        }
        locald.m(paramLong);
      }
      return null;
    }
    finally {}
  }
  
  public static PorterDuffColorFilter l(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      c localc = j;
      PorterDuffColorFilter localPorterDuffColorFilter2 = localc.i(paramInt, paramMode);
      PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
      if (localPorterDuffColorFilter2 == null)
      {
        localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
        localc.j(paramInt, paramMode, localPorterDuffColorFilter1);
      }
      return localPorterDuffColorFilter1;
    }
    finally {}
  }
  
  private ColorStateList n(Context paramContext, int paramInt)
  {
    WeakHashMap localWeakHashMap = this.a;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localWeakHashMap != null)
    {
      paramContext = (g0.h)localWeakHashMap.get(paramContext);
      localObject1 = localObject2;
      if (paramContext != null) {
        localObject1 = (ColorStateList)paramContext.e(paramInt);
      }
    }
    return localObject1;
  }
  
  private static void p(a0 parama0)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      parama0.a("vector", new g());
      parama0.a("animated-vector", new b());
      parama0.a("animated-selector", new a());
      parama0.a("drawable", new d());
    }
  }
  
  private static boolean q(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof androidx.vectordrawable.graphics.drawable.h)) || ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()));
  }
  
  private Drawable r(Context paramContext, int paramInt)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (!((g)localObject1).isEmpty()))
    {
      localObject1 = this.c;
      if (localObject1 != null)
      {
        localObject1 = (String)((g0.h)localObject1).e(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.b.get(localObject1) == null))) {
          return null;
        }
      }
      else
      {
        this.c = new g0.h();
      }
      if (this.e == null) {
        this.e = new TypedValue();
      }
      TypedValue localTypedValue = this.e;
      localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l = e(localTypedValue);
      Drawable localDrawable = i(paramContext, l);
      if (localDrawable != null) {
        return localDrawable;
      }
      Object localObject3 = localTypedValue.string;
      Object localObject2 = localDrawable;
      if (localObject3 != null)
      {
        localObject2 = localDrawable;
        if (((CharSequence)localObject3).toString().endsWith(".xml"))
        {
          localObject2 = localDrawable;
          try
          {
            localObject3 = ((Resources)localObject1).getXml(paramInt);
            localObject2 = localDrawable;
            AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject3);
            int k;
            do
            {
              localObject2 = localDrawable;
              k = ((XmlPullParser)localObject3).next();
            } while ((k != 2) && (k != 1));
            if (k == 2)
            {
              localObject2 = localDrawable;
              localObject1 = ((XmlPullParser)localObject3).getName();
              localObject2 = localDrawable;
              this.c.a(paramInt, localObject1);
              localObject2 = localDrawable;
              e locale = (e)this.b.get(localObject1);
              localObject1 = localDrawable;
              if (locale != null)
              {
                localObject2 = localDrawable;
                localObject1 = locale.a(paramContext, (XmlPullParser)localObject3, localAttributeSet, paramContext.getTheme());
              }
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
                localObject2 = localObject1;
                b(paramContext, l, (Drawable)localObject1);
                localObject2 = localObject1;
              }
            }
            else
            {
              localObject2 = localDrawable;
              throw new XmlPullParserException("No start tag found");
            }
          }
          catch (Exception paramContext)
          {
            Log.e("ResourceManagerInternal", "Exception while inflating drawable", paramContext);
          }
        }
      }
      if (localObject2 == null) {
        this.c.a(paramInt, "appcompat_skip_skip");
      }
      return localObject2;
    }
    return null;
  }
  
  private Drawable v(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject = m(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (t.a(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = r0.a.r(paramContext);
      r0.a.o(paramContext, (ColorStateList)localObject);
      paramDrawable = o(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        r0.a.p(paramContext, paramDrawable);
        return paramContext;
      }
    }
    else
    {
      localObject = this.g;
      if ((localObject != null) && (((f)localObject).e(paramContext, paramInt, paramDrawable))) {
        return paramDrawable;
      }
      localObject = paramDrawable;
      if (!x(paramContext, paramInt, paramDrawable))
      {
        localObject = paramDrawable;
        if (paramBoolean) {
          localObject = null;
        }
      }
    }
    return localObject;
  }
  
  static void w(Drawable paramDrawable, i0 parami0, int[] paramArrayOfInt)
  {
    if ((t.a(paramDrawable)) && (paramDrawable.mutate() != paramDrawable))
    {
      Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
      return;
    }
    boolean bool = parami0.d;
    if ((!bool) && (!parami0.c))
    {
      paramDrawable.clearColorFilter();
    }
    else
    {
      ColorStateList localColorStateList;
      if (bool) {
        localColorStateList = parami0.a;
      } else {
        localColorStateList = null;
      }
      if (parami0.c) {
        parami0 = parami0.b;
      } else {
        parami0 = h;
      }
      paramDrawable.setColorFilter(g(localColorStateList, parami0, paramArrayOfInt));
    }
    if (Build.VERSION.SDK_INT <= 23) {
      paramDrawable.invalidateSelf();
    }
  }
  
  public Drawable j(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = k(paramContext, paramInt, false);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  Drawable k(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      d(paramContext);
      Object localObject2 = r(paramContext, paramInt);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = f(paramContext, paramInt);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = b.d(paramContext, paramInt);
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = v(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
      }
      if (localObject1 != null) {
        t.b((Drawable)localObject1);
      }
      return localObject1;
    }
    finally {}
  }
  
  ColorStateList m(Context paramContext, int paramInt)
  {
    try
    {
      Object localObject1 = n(paramContext, paramInt);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = this.g;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((f)localObject1).d(paramContext, paramInt);
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          c(paramContext, paramInt, (ColorStateList)localObject1);
          localObject2 = localObject1;
        }
      }
      return localObject2;
    }
    finally {}
  }
  
  PorterDuff.Mode o(int paramInt)
  {
    f localf = this.g;
    if (localf == null) {
      return null;
    }
    return localf.b(paramInt);
  }
  
  public void s(Context paramContext)
  {
    try
    {
      paramContext = (d)this.d.get(paramContext);
      if (paramContext != null) {
        paramContext.b();
      }
      return;
    }
    finally {}
  }
  
  Drawable t(Context paramContext, q0 paramq0, int paramInt)
  {
    try
    {
      Drawable localDrawable2 = r(paramContext, paramInt);
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null) {
        localDrawable1 = paramq0.a(paramInt);
      }
      if (localDrawable1 != null)
      {
        paramContext = v(paramContext, paramInt, false, localDrawable1);
        return paramContext;
      }
      return null;
    }
    finally {}
  }
  
  public void u(f paramf)
  {
    try
    {
      this.g = paramf;
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  boolean x(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    f localf = this.g;
    return (localf != null) && (localf.a(paramContext, paramInt, paramDrawable));
  }
  
  static class a
    implements a0.e
  {
    public Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = d.a.m(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", paramContext);
      }
      return null;
    }
  }
  
  private static class b
    implements a0.e
  {
    public Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = androidx.vectordrawable.graphics.drawable.c.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
      }
      return null;
    }
  }
  
  private static class c
    extends e<Integer, PorterDuffColorFilter>
  {
    public c(int paramInt)
    {
      super();
    }
    
    private static int h(int paramInt, PorterDuff.Mode paramMode)
    {
      return (paramInt + 31) * 31 + paramMode.hashCode();
    }
    
    PorterDuffColorFilter i(int paramInt, PorterDuff.Mode paramMode)
    {
      return (PorterDuffColorFilter)c(Integer.valueOf(h(paramInt, paramMode)));
    }
    
    PorterDuffColorFilter j(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
    {
      return (PorterDuffColorFilter)d(Integer.valueOf(h(paramInt, paramMode)), paramPorterDuffColorFilter);
    }
  }
  
  static class d
    implements a0.e
  {
    public Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      Object localObject = paramAttributeSet.getClassAttribute();
      if (localObject != null) {
        try
        {
          localObject = (Drawable)d.class.getClassLoader().loadClass((String)localObject).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
          e.c.c((Drawable)localObject, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
          return localObject;
        }
        catch (Exception paramContext)
        {
          Log.e("DrawableDelegate", "Exception while inflating <drawable>", paramContext);
        }
      }
      return null;
    }
  }
  
  private static abstract interface e
  {
    public abstract Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
  }
  
  public static abstract interface f
  {
    public abstract boolean a(Context paramContext, int paramInt, Drawable paramDrawable);
    
    public abstract PorterDuff.Mode b(int paramInt);
    
    public abstract Drawable c(a0 parama0, Context paramContext, int paramInt);
    
    public abstract ColorStateList d(Context paramContext, int paramInt);
    
    public abstract boolean e(Context paramContext, int paramInt, Drawable paramDrawable);
  }
  
  private static class g
    implements a0.e
  {
    public Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = androidx.vectordrawable.graphics.drawable.h.c(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", paramContext);
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.a0
 * JD-Core Version:    0.7.0.1
 */