package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.DragShadowBuilder;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R.id;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import y0.d;
import y0.d.a;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class x
{
  private static final AtomicInteger a = new AtomicInteger(1);
  private static WeakHashMap<View, c0> b = null;
  private static Field c;
  private static boolean d = false;
  private static final int[] e = { R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31 };
  private static final t f = w.a;
  private static final e g = new e();
  
  @SuppressLint({"InlinedApi"})
  public static int A(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return p.b(paramView);
    }
    return 0;
  }
  
  public static void A0(View paramView, boolean paramBoolean)
  {
    h.r(paramView, paramBoolean);
  }
  
  public static int B(View paramView)
  {
    return i.d(paramView);
  }
  
  public static void B0(View paramView, int paramInt)
  {
    h.s(paramView, paramInt);
  }
  
  public static int C(View paramView)
  {
    return h.d(paramView);
  }
  
  public static void C0(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      p.l(paramView, paramInt);
    }
  }
  
  public static int D(View paramView)
  {
    return h.e(paramView);
  }
  
  public static void D0(View paramView, Paint paramPaint)
  {
    i.i(paramView, paramPaint);
  }
  
  public static String[] E(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 31) {
      return t.a(paramView);
    }
    return (String[])paramView.getTag(R.id.tag_on_receive_content_mime_types);
  }
  
  public static void E0(View paramView, r paramr)
  {
    m.u(paramView, paramr);
  }
  
  public static int F(View paramView)
  {
    return i.e(paramView);
  }
  
  public static void F0(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    i.k(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static int G(View paramView)
  {
    return i.f(paramView);
  }
  
  public static void G0(View paramView, v paramv)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (paramv != null) {
        paramv = paramv.a();
      } else {
        paramv = null;
      }
      o.d(paramView, (PointerIcon)paramv);
    }
  }
  
  public static ViewParent H(View paramView)
  {
    return h.f(paramView);
  }
  
  public static void H0(View paramView, boolean paramBoolean)
  {
    p0().g(paramView, Boolean.valueOf(paramBoolean));
  }
  
  public static h0 I(View paramView)
  {
    return n.a(paramView);
  }
  
  public static void I0(View paramView, int paramInt1, int paramInt2)
  {
    n.d(paramView, paramInt1, paramInt2);
  }
  
  public static CharSequence J(View paramView)
  {
    return (CharSequence)O0().f(paramView);
  }
  
  public static void J0(View paramView, CharSequence paramCharSequence)
  {
    O0().g(paramView, paramCharSequence);
  }
  
  public static String K(View paramView)
  {
    return m.k(paramView);
  }
  
  public static void K0(View paramView, String paramString)
  {
    m.v(paramView, paramString);
  }
  
  public static float L(View paramView)
  {
    return m.l(paramView);
  }
  
  public static void L0(View paramView, float paramFloat)
  {
    m.w(paramView, paramFloat);
  }
  
  @Deprecated
  public static int M(View paramView)
  {
    return h.g(paramView);
  }
  
  private static void M0(View paramView)
  {
    if (z(paramView) == 0) {
      B0(paramView, 1);
    }
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent instanceof View); localViewParent = localViewParent.getParent()) {
      if (z((View)localViewParent) == 4)
      {
        B0(paramView, 2);
        return;
      }
    }
  }
  
  public static float N(View paramView)
  {
    return m.m(paramView);
  }
  
  public static void N0(View paramView, float paramFloat)
  {
    m.x(paramView, paramFloat);
  }
  
  public static boolean O(View paramView)
  {
    return m(paramView) != null;
  }
  
  private static f<CharSequence> O0()
  {
    return new c(R.id.tag_state_description, CharSequence.class, 64, 30);
  }
  
  public static boolean P(View paramView)
  {
    return g.a(paramView);
  }
  
  public static void P0(View paramView)
  {
    m.z(paramView);
  }
  
  public static boolean Q(View paramView)
  {
    return h.h(paramView);
  }
  
  public static boolean R(View paramView)
  {
    return h.i(paramView);
  }
  
  public static boolean S(View paramView)
  {
    paramView = (Boolean)b().f(paramView);
    return (paramView != null) && (paramView.booleanValue());
  }
  
  public static boolean T(View paramView)
  {
    return k.b(paramView);
  }
  
  public static boolean U(View paramView)
  {
    return k.c(paramView);
  }
  
  public static boolean V(View paramView)
  {
    return m.p(paramView);
  }
  
  public static boolean W(View paramView)
  {
    return i.g(paramView);
  }
  
  public static boolean X(View paramView)
  {
    paramView = (Boolean)p0().f(paramView);
    return (paramView != null) && (paramView.booleanValue());
  }
  
  static void Z(View paramView, int paramInt)
  {
    Object localObject1 = (AccessibilityManager)paramView.getContext().getSystemService("accessibility");
    if (!((AccessibilityManager)localObject1).isEnabled()) {
      return;
    }
    int i;
    if ((p(paramView) != null) && (paramView.getVisibility() == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    int k = o(paramView);
    int j = 32;
    if ((k == 0) && (i == 0))
    {
      Object localObject2;
      if (paramInt == 32)
      {
        localObject2 = AccessibilityEvent.obtain();
        paramView.onInitializeAccessibilityEvent((AccessibilityEvent)localObject2);
        ((AccessibilityEvent)localObject2).setEventType(32);
        k.g((AccessibilityEvent)localObject2, paramInt);
        ((AccessibilityEvent)localObject2).setSource(paramView);
        paramView.onPopulateAccessibilityEvent((AccessibilityEvent)localObject2);
        ((AccessibilityEvent)localObject2).getText().add(p(paramView));
        ((AccessibilityManager)localObject1).sendAccessibilityEvent((AccessibilityEvent)localObject2);
        return;
      }
      if (paramView.getParent() == null) {
        return;
      }
      localObject1 = paramView.getParent();
      try
      {
        k.e((ViewParent)localObject1, paramView, paramView, paramInt);
        return;
      }
      catch (AbstractMethodError localAbstractMethodError)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramView.getParent().getClass().getSimpleName());
        ((StringBuilder)localObject2).append(" does not fully implement ViewParent");
        Log.e("ViewCompat", ((StringBuilder)localObject2).toString(), localAbstractMethodError);
        return;
      }
    }
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
    if (i == 0) {
      j = 2048;
    }
    localAccessibilityEvent.setEventType(j);
    k.g(localAccessibilityEvent, paramInt);
    if (i != 0)
    {
      localAccessibilityEvent.getText().add(p(paramView));
      M0(paramView);
    }
    paramView.sendAccessibilityEventUnchecked(localAccessibilityEvent);
  }
  
  public static void a0(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
  }
  
  private static f<Boolean> b()
  {
    return new d(R.id.tag_accessibility_heading, Boolean.class, 28);
  }
  
  public static void b0(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
  }
  
  public static int c(View paramView, CharSequence paramCharSequence, y0.g paramg)
  {
    int i = r(paramView, paramCharSequence);
    if (i != -1) {
      d(paramView, new d.a(i, paramCharSequence, paramg));
    }
    return i;
  }
  
  public static h0 c0(View paramView, h0 paramh0)
  {
    WindowInsets localWindowInsets1 = paramh0.v();
    if (localWindowInsets1 != null)
    {
      WindowInsets localWindowInsets2 = l.b(paramView, localWindowInsets1);
      if (!localWindowInsets2.equals(localWindowInsets1)) {
        return h0.x(localWindowInsets2, paramView);
      }
    }
    return paramh0;
  }
  
  private static void d(View paramView, d.a parama)
  {
    j(paramView);
    l0(parama.b(), paramView);
    q(paramView).add(parama);
    Z(paramView, 0);
  }
  
  public static void d0(View paramView, d paramd)
  {
    paramView.onInitializeAccessibilityNodeInfo(paramd.I0());
  }
  
  public static c0 e(View paramView)
  {
    if (b == null) {
      b = new WeakHashMap();
    }
    c0 localc02 = (c0)b.get(paramView);
    c0 localc01 = localc02;
    if (localc02 == null)
    {
      localc01 = new c0(paramView);
      b.put(paramView, localc01);
    }
    return localc01;
  }
  
  private static f<CharSequence> e0()
  {
    return new b(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
  }
  
  public static h0 f(View paramView, h0 paramh0, Rect paramRect)
  {
    return m.b(paramView, paramh0, paramRect);
  }
  
  public static boolean f0(View paramView, int paramInt, Bundle paramBundle)
  {
    return h.j(paramView, paramInt, paramBundle);
  }
  
  public static h0 g(View paramView, h0 paramh0)
  {
    WindowInsets localWindowInsets1 = paramh0.v();
    if (localWindowInsets1 != null)
    {
      WindowInsets localWindowInsets2 = l.a(paramView, localWindowInsets1);
      if (!localWindowInsets2.equals(localWindowInsets1)) {
        return h0.x(localWindowInsets2, paramView);
      }
    }
    return paramh0;
  }
  
  public static c g0(View paramView, c paramc)
  {
    if (Log.isLoggable("ViewCompat", 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("performReceiveContent: ");
      ((StringBuilder)localObject).append(paramc);
      ((StringBuilder)localObject).append(", view=");
      ((StringBuilder)localObject).append(paramView.getClass().getSimpleName());
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(paramView.getId());
      ((StringBuilder)localObject).append("]");
      Log.d("ViewCompat", ((StringBuilder)localObject).toString());
    }
    if (Build.VERSION.SDK_INT >= 31) {
      return t.b(paramView, paramc);
    }
    Object localObject = (s)paramView.getTag(R.id.tag_on_receive_content_listener);
    if (localObject != null)
    {
      paramc = ((s)localObject).a(paramView, paramc);
      if (paramc == null) {
        return null;
      }
      return x(paramView).a(paramc);
    }
    return x(paramView).a(paramc);
  }
  
  static boolean h(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return false;
    }
    return w.a(paramView).b(paramView, paramKeyEvent);
  }
  
  public static void h0(View paramView)
  {
    h.k(paramView);
  }
  
  static boolean i(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return false;
    }
    return w.a(paramView).f(paramKeyEvent);
  }
  
  public static void i0(View paramView, Runnable paramRunnable)
  {
    h.m(paramView, paramRunnable);
  }
  
  static void j(View paramView)
  {
    a locala2 = l(paramView);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    q0(paramView, locala1);
  }
  
  @SuppressLint({"LambdaLast"})
  public static void j0(View paramView, Runnable paramRunnable, long paramLong)
  {
    h.n(paramView, paramRunnable, paramLong);
  }
  
  public static int k()
  {
    return i.a();
  }
  
  public static void k0(View paramView, int paramInt)
  {
    l0(paramInt, paramView);
    Z(paramView, 0);
  }
  
  public static a l(View paramView)
  {
    paramView = m(paramView);
    if (paramView == null) {
      return null;
    }
    if ((paramView instanceof a.a)) {
      return ((a.a)paramView).a;
    }
    return new a(paramView);
  }
  
  private static void l0(int paramInt, View paramView)
  {
    paramView = q(paramView);
    int i = 0;
    while (i < paramView.size())
    {
      if (((d.a)paramView.get(i)).b() == paramInt)
      {
        paramView.remove(i);
        return;
      }
      i += 1;
    }
  }
  
  private static View.AccessibilityDelegate m(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return r.a(paramView);
    }
    return n(paramView);
  }
  
  public static void m0(View paramView, d.a parama, CharSequence paramCharSequence, y0.g paramg)
  {
    if ((paramg == null) && (paramCharSequence == null))
    {
      k0(paramView, parama.b());
      return;
    }
    d(paramView, parama.a(paramCharSequence, paramg));
  }
  
  /* Error */
  private static View.AccessibilityDelegate n(View paramView)
  {
    // Byte code:
    //   0: getstatic 100	androidx/core/view/x:d	Z
    //   3: ifeq +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: getstatic 718	androidx/core/view/x:c	Ljava/lang/reflect/Field;
    //   11: ifnonnull +31 -> 42
    //   14: ldc_w 256
    //   17: ldc_w 720
    //   20: invokevirtual 724	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   23: astore_1
    //   24: aload_1
    //   25: putstatic 718	androidx/core/view/x:c	Ljava/lang/reflect/Field;
    //   28: aload_1
    //   29: iconst_1
    //   30: invokevirtual 730	java/lang/reflect/Field:setAccessible	(Z)V
    //   33: goto +9 -> 42
    //   36: iconst_1
    //   37: putstatic 100	androidx/core/view/x:d	Z
    //   40: aconst_null
    //   41: areturn
    //   42: getstatic 718	androidx/core/view/x:c	Ljava/lang/reflect/Field;
    //   45: aload_0
    //   46: invokevirtual 731	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore_0
    //   50: aload_0
    //   51: instanceof 733
    //   54: ifeq +10 -> 64
    //   57: aload_0
    //   58: checkcast 733	android/view/View$AccessibilityDelegate
    //   61: astore_0
    //   62: aload_0
    //   63: areturn
    //   64: aconst_null
    //   65: areturn
    //   66: iconst_1
    //   67: putstatic 100	androidx/core/view/x:d	Z
    //   70: aconst_null
    //   71: areturn
    //   72: astore_0
    //   73: goto -37 -> 36
    //   76: astore_0
    //   77: goto -11 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramView	View
    //   23	6	1	localField	Field
    // Exception table:
    //   from	to	target	type
    //   14	33	72	finally
    //   42	62	76	finally
  }
  
  public static void n0(View paramView)
  {
    l.c(paramView);
  }
  
  public static int o(View paramView)
  {
    return k.a(paramView);
  }
  
  public static void o0(View paramView, @SuppressLint({"ContextFirst"}) Context paramContext, int[] paramArrayOfInt, AttributeSet paramAttributeSet, TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      r.c(paramView, paramContext, paramArrayOfInt, paramAttributeSet, paramTypedArray, paramInt1, paramInt2);
    }
  }
  
  public static CharSequence p(View paramView)
  {
    return (CharSequence)e0().f(paramView);
  }
  
  private static f<Boolean> p0()
  {
    return new a(R.id.tag_screen_reader_focusable, Boolean.class, 28);
  }
  
  private static List<d.a> q(View paramView)
  {
    int i = R.id.tag_accessibility_actions;
    ArrayList localArrayList2 = (ArrayList)paramView.getTag(i);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      paramView.setTag(i, localArrayList1);
    }
    return localArrayList1;
  }
  
  public static void q0(View paramView, a parama)
  {
    a locala = parama;
    if (parama == null)
    {
      locala = parama;
      if ((m(paramView) instanceof a.a)) {
        locala = new a();
      }
    }
    if (locala == null) {
      parama = null;
    } else {
      parama = locala.d();
    }
    paramView.setAccessibilityDelegate(parama);
  }
  
  private static int r(View paramView, CharSequence paramCharSequence)
  {
    paramView = q(paramView);
    int i = 0;
    while (i < paramView.size())
    {
      if (TextUtils.equals(paramCharSequence, ((d.a)paramView.get(i)).c())) {
        return ((d.a)paramView.get(i)).b();
      }
      i += 1;
    }
    int j = -1;
    i = 0;
    for (;;)
    {
      paramCharSequence = e;
      if ((i >= paramCharSequence.length) || (j != -1)) {
        break;
      }
      int i1 = paramCharSequence[i];
      int m = 0;
      int k = 1;
      while (m < paramView.size())
      {
        int n;
        if (((d.a)paramView.get(m)).b() != i1) {
          n = 1;
        } else {
          n = 0;
        }
        k &= n;
        m += 1;
      }
      if (k != 0) {
        j = i1;
      }
      i += 1;
    }
    return j;
  }
  
  public static void r0(View paramView, boolean paramBoolean)
  {
    b().g(paramView, Boolean.valueOf(paramBoolean));
  }
  
  public static ColorStateList s(View paramView)
  {
    return m.g(paramView);
  }
  
  public static void s0(View paramView, int paramInt)
  {
    k.f(paramView, paramInt);
  }
  
  public static PorterDuff.Mode t(View paramView)
  {
    return m.h(paramView);
  }
  
  public static void t0(View paramView, CharSequence paramCharSequence)
  {
    e0().g(paramView, paramCharSequence);
    if (paramCharSequence != null)
    {
      g.a(paramView);
      return;
    }
    g.d(paramView);
  }
  
  public static Rect u(View paramView)
  {
    return j.a(paramView);
  }
  
  public static void u0(View paramView, Drawable paramDrawable)
  {
    h.q(paramView, paramDrawable);
  }
  
  public static Display v(View paramView)
  {
    return i.b(paramView);
  }
  
  public static void v0(View paramView, ColorStateList paramColorStateList)
  {
    m.q(paramView, paramColorStateList);
  }
  
  public static float w(View paramView)
  {
    return m.i(paramView);
  }
  
  public static void w0(View paramView, PorterDuff.Mode paramMode)
  {
    m.r(paramView, paramMode);
  }
  
  private static t x(View paramView)
  {
    if ((paramView instanceof t)) {
      return (t)paramView;
    }
    return f;
  }
  
  public static void x0(View paramView, Rect paramRect)
  {
    j.c(paramView, paramRect);
  }
  
  public static boolean y(View paramView)
  {
    return h.b(paramView);
  }
  
  public static void y0(View paramView, float paramFloat)
  {
    m.s(paramView, paramFloat);
  }
  
  public static int z(View paramView)
  {
    return h.c(paramView);
  }
  
  @Deprecated
  public static void z0(View paramView, boolean paramBoolean)
  {
    paramView.setFitsSystemWindows(paramBoolean);
  }
  
  class a
    extends x.f<Boolean>
  {
    a(Class paramClass, int paramInt)
    {
      super(paramClass, paramInt);
    }
    
    Boolean i(View paramView)
    {
      return Boolean.valueOf(x.q.d(paramView));
    }
    
    void j(View paramView, Boolean paramBoolean)
    {
      x.q.i(paramView, paramBoolean.booleanValue());
    }
    
    boolean k(Boolean paramBoolean1, Boolean paramBoolean2)
    {
      return a(paramBoolean1, paramBoolean2) ^ true;
    }
  }
  
  class b
    extends x.f<CharSequence>
  {
    b(Class paramClass, int paramInt1, int paramInt2)
    {
      super(paramClass, paramInt1, paramInt2);
    }
    
    CharSequence i(View paramView)
    {
      return x.q.b(paramView);
    }
    
    void j(View paramView, CharSequence paramCharSequence)
    {
      x.q.h(paramView, paramCharSequence);
    }
    
    boolean k(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
    {
      return TextUtils.equals(paramCharSequence1, paramCharSequence2) ^ true;
    }
  }
  
  class c
    extends x.f<CharSequence>
  {
    c(Class paramClass, int paramInt1, int paramInt2)
    {
      super(paramClass, paramInt1, paramInt2);
    }
    
    CharSequence i(View paramView)
    {
      return x.s.a(paramView);
    }
    
    void j(View paramView, CharSequence paramCharSequence)
    {
      x.s.b(paramView, paramCharSequence);
    }
    
    boolean k(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
    {
      return TextUtils.equals(paramCharSequence1, paramCharSequence2) ^ true;
    }
  }
  
  class d
    extends x.f<Boolean>
  {
    d(Class paramClass, int paramInt)
    {
      super(paramClass, paramInt);
    }
    
    Boolean i(View paramView)
    {
      return Boolean.valueOf(x.q.c(paramView));
    }
    
    void j(View paramView, Boolean paramBoolean)
    {
      x.q.g(paramView, paramBoolean.booleanValue());
    }
    
    boolean k(Boolean paramBoolean1, Boolean paramBoolean2)
    {
      return a(paramBoolean1, paramBoolean2) ^ true;
    }
  }
  
  static class e
    implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener
  {
    private final WeakHashMap<View, Boolean> a = new WeakHashMap();
    
    private void b(View paramView, boolean paramBoolean)
    {
      boolean bool;
      if (paramView.getVisibility() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramBoolean != bool)
      {
        int i;
        if (bool) {
          i = 16;
        } else {
          i = 32;
        }
        x.Z(paramView, i);
        this.a.put(paramView, Boolean.valueOf(bool));
      }
    }
    
    private void c(View paramView)
    {
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
    
    private void e(View paramView)
    {
      x.h.o(paramView.getViewTreeObserver(), this);
    }
    
    void a(View paramView)
    {
      WeakHashMap localWeakHashMap = this.a;
      boolean bool;
      if (paramView.getVisibility() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localWeakHashMap.put(paramView, Boolean.valueOf(bool));
      paramView.addOnAttachStateChangeListener(this);
      if (x.k.b(paramView)) {
        c(paramView);
      }
    }
    
    void d(View paramView)
    {
      this.a.remove(paramView);
      paramView.removeOnAttachStateChangeListener(this);
      e(paramView);
    }
    
    public void onGlobalLayout()
    {
      if (Build.VERSION.SDK_INT < 28)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          b((View)localEntry.getKey(), ((Boolean)localEntry.getValue()).booleanValue());
        }
      }
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      c(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView) {}
  }
  
  static abstract class f<T>
  {
    private final int a;
    private final Class<T> b;
    private final int c;
    private final int d;
    
    f(int paramInt1, Class<T> paramClass, int paramInt2)
    {
      this(paramInt1, paramClass, 0, paramInt2);
    }
    
    f(int paramInt1, Class<T> paramClass, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramClass;
      this.d = paramInt2;
      this.c = paramInt3;
    }
    
    private boolean b()
    {
      return true;
    }
    
    private boolean c()
    {
      return Build.VERSION.SDK_INT >= this.c;
    }
    
    boolean a(Boolean paramBoolean1, Boolean paramBoolean2)
    {
      int i;
      if ((paramBoolean1 != null) && (paramBoolean1.booleanValue())) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if ((paramBoolean2 != null) && (paramBoolean2.booleanValue())) {
        j = 1;
      } else {
        j = 0;
      }
      return i == j;
    }
    
    abstract T d(View paramView);
    
    abstract void e(View paramView, T paramT);
    
    T f(View paramView)
    {
      if (c()) {
        return d(paramView);
      }
      if (b())
      {
        paramView = paramView.getTag(this.a);
        if (this.b.isInstance(paramView)) {
          return paramView;
        }
      }
      return null;
    }
    
    void g(View paramView, T paramT)
    {
      if (c())
      {
        e(paramView, paramT);
        return;
      }
      if ((b()) && (h(f(paramView), paramT)))
      {
        x.j(paramView);
        paramView.setTag(this.a, paramT);
        x.Z(paramView, this.d);
      }
    }
    
    abstract boolean h(T paramT1, T paramT2);
  }
  
  static class g
  {
    static boolean a(View paramView)
    {
      return paramView.hasOnClickListeners();
    }
  }
  
  static class h
  {
    static AccessibilityNodeProvider a(View paramView)
    {
      return paramView.getAccessibilityNodeProvider();
    }
    
    static boolean b(View paramView)
    {
      return paramView.getFitsSystemWindows();
    }
    
    static int c(View paramView)
    {
      return paramView.getImportantForAccessibility();
    }
    
    static int d(View paramView)
    {
      return paramView.getMinimumHeight();
    }
    
    static int e(View paramView)
    {
      return paramView.getMinimumWidth();
    }
    
    static ViewParent f(View paramView)
    {
      return paramView.getParentForAccessibility();
    }
    
    static int g(View paramView)
    {
      return paramView.getWindowSystemUiVisibility();
    }
    
    static boolean h(View paramView)
    {
      return paramView.hasOverlappingRendering();
    }
    
    static boolean i(View paramView)
    {
      return paramView.hasTransientState();
    }
    
    static boolean j(View paramView, int paramInt, Bundle paramBundle)
    {
      return paramView.performAccessibilityAction(paramInt, paramBundle);
    }
    
    static void k(View paramView)
    {
      paramView.postInvalidateOnAnimation();
    }
    
    static void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.postInvalidateOnAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    static void m(View paramView, Runnable paramRunnable)
    {
      paramView.postOnAnimation(paramRunnable);
    }
    
    static void n(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postOnAnimationDelayed(paramRunnable, paramLong);
    }
    
    static void o(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
    {
      paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
    
    static void p(View paramView)
    {
      paramView.requestFitSystemWindows();
    }
    
    static void q(View paramView, Drawable paramDrawable)
    {
      paramView.setBackground(paramDrawable);
    }
    
    static void r(View paramView, boolean paramBoolean)
    {
      paramView.setHasTransientState(paramBoolean);
    }
    
    static void s(View paramView, int paramInt)
    {
      paramView.setImportantForAccessibility(paramInt);
    }
  }
  
  static class i
  {
    static int a()
    {
      return View.generateViewId();
    }
    
    static Display b(View paramView)
    {
      return paramView.getDisplay();
    }
    
    static int c(View paramView)
    {
      return paramView.getLabelFor();
    }
    
    static int d(View paramView)
    {
      return paramView.getLayoutDirection();
    }
    
    static int e(View paramView)
    {
      return paramView.getPaddingEnd();
    }
    
    static int f(View paramView)
    {
      return paramView.getPaddingStart();
    }
    
    static boolean g(View paramView)
    {
      return paramView.isPaddingRelative();
    }
    
    static void h(View paramView, int paramInt)
    {
      paramView.setLabelFor(paramInt);
    }
    
    static void i(View paramView, Paint paramPaint)
    {
      paramView.setLayerPaint(paramPaint);
    }
    
    static void j(View paramView, int paramInt)
    {
      paramView.setLayoutDirection(paramInt);
    }
    
    static void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  static class j
  {
    static Rect a(View paramView)
    {
      return paramView.getClipBounds();
    }
    
    static boolean b(View paramView)
    {
      return paramView.isInLayout();
    }
    
    static void c(View paramView, Rect paramRect)
    {
      paramView.setClipBounds(paramRect);
    }
  }
  
  static class k
  {
    static int a(View paramView)
    {
      return paramView.getAccessibilityLiveRegion();
    }
    
    static boolean b(View paramView)
    {
      return paramView.isAttachedToWindow();
    }
    
    static boolean c(View paramView)
    {
      return paramView.isLaidOut();
    }
    
    static boolean d(View paramView)
    {
      return paramView.isLayoutDirectionResolved();
    }
    
    static void e(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
    {
      paramViewParent.notifySubtreeAccessibilityStateChanged(paramView1, paramView2, paramInt);
    }
    
    static void f(View paramView, int paramInt)
    {
      paramView.setAccessibilityLiveRegion(paramInt);
    }
    
    static void g(AccessibilityEvent paramAccessibilityEvent, int paramInt)
    {
      paramAccessibilityEvent.setContentChangeTypes(paramInt);
    }
  }
  
  static class l
  {
    static WindowInsets a(View paramView, WindowInsets paramWindowInsets)
    {
      return paramView.dispatchApplyWindowInsets(paramWindowInsets);
    }
    
    static WindowInsets b(View paramView, WindowInsets paramWindowInsets)
    {
      return paramView.onApplyWindowInsets(paramWindowInsets);
    }
    
    static void c(View paramView)
    {
      paramView.requestApplyInsets();
    }
  }
  
  private static class m
  {
    static void a(WindowInsets paramWindowInsets, View paramView)
    {
      View.OnApplyWindowInsetsListener localOnApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener)paramView.getTag(R.id.tag_window_insets_animation_callback);
      if (localOnApplyWindowInsetsListener != null) {
        localOnApplyWindowInsetsListener.onApplyWindowInsets(paramView, paramWindowInsets);
      }
    }
    
    static h0 b(View paramView, h0 paramh0, Rect paramRect)
    {
      WindowInsets localWindowInsets = paramh0.v();
      if (localWindowInsets != null) {
        return h0.x(paramView.computeSystemWindowInsets(localWindowInsets, paramRect), paramView);
      }
      paramRect.setEmpty();
      return paramh0;
    }
    
    static boolean c(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      return paramView.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    }
    
    static boolean d(View paramView, float paramFloat1, float paramFloat2)
    {
      return paramView.dispatchNestedPreFling(paramFloat1, paramFloat2);
    }
    
    static boolean e(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      return paramView.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    
    static boolean f(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
    {
      return paramView.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    
    static ColorStateList g(View paramView)
    {
      return paramView.getBackgroundTintList();
    }
    
    static PorterDuff.Mode h(View paramView)
    {
      return paramView.getBackgroundTintMode();
    }
    
    static float i(View paramView)
    {
      return paramView.getElevation();
    }
    
    public static h0 j(View paramView)
    {
      return h0.a.a(paramView);
    }
    
    static String k(View paramView)
    {
      return paramView.getTransitionName();
    }
    
    static float l(View paramView)
    {
      return paramView.getTranslationZ();
    }
    
    static float m(View paramView)
    {
      return paramView.getZ();
    }
    
    static boolean n(View paramView)
    {
      return paramView.hasNestedScrollingParent();
    }
    
    static boolean o(View paramView)
    {
      return paramView.isImportantForAccessibility();
    }
    
    static boolean p(View paramView)
    {
      return paramView.isNestedScrollingEnabled();
    }
    
    static void q(View paramView, ColorStateList paramColorStateList)
    {
      paramView.setBackgroundTintList(paramColorStateList);
    }
    
    static void r(View paramView, PorterDuff.Mode paramMode)
    {
      paramView.setBackgroundTintMode(paramMode);
    }
    
    static void s(View paramView, float paramFloat)
    {
      paramView.setElevation(paramFloat);
    }
    
    static void t(View paramView, boolean paramBoolean)
    {
      paramView.setNestedScrollingEnabled(paramBoolean);
    }
    
    static void u(View paramView, final r paramr)
    {
      if (Build.VERSION.SDK_INT < 30) {
        paramView.setTag(R.id.tag_on_apply_window_listener, paramr);
      }
      if (paramr == null)
      {
        paramView.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)paramView.getTag(R.id.tag_window_insets_animation_callback));
        return;
      }
      paramView.setOnApplyWindowInsetsListener(new a(paramr));
    }
    
    static void v(View paramView, String paramString)
    {
      paramView.setTransitionName(paramString);
    }
    
    static void w(View paramView, float paramFloat)
    {
      paramView.setTranslationZ(paramFloat);
    }
    
    static void x(View paramView, float paramFloat)
    {
      paramView.setZ(paramFloat);
    }
    
    static boolean y(View paramView, int paramInt)
    {
      return paramView.startNestedScroll(paramInt);
    }
    
    static void z(View paramView)
    {
      paramView.stopNestedScroll();
    }
    
    class a
      implements View.OnApplyWindowInsetsListener
    {
      h0 a = null;
      
      a(r paramr) {}
      
      public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
      {
        h0 localh0 = h0.x(paramWindowInsets, paramView);
        int i = Build.VERSION.SDK_INT;
        if (i < 30)
        {
          x.m.a(paramWindowInsets, x.m.this);
          if (localh0.equals(this.a)) {
            return paramr.a(paramView, localh0).v();
          }
        }
        this.a = localh0;
        paramWindowInsets = paramr.a(paramView, localh0);
        if (i >= 30) {
          return paramWindowInsets.v();
        }
        x.n0(paramView);
        return paramWindowInsets.v();
      }
    }
  }
  
  private static class n
  {
    public static h0 a(View paramView)
    {
      Object localObject = paramView.getRootWindowInsets();
      if (localObject == null) {
        return null;
      }
      localObject = h0.w((WindowInsets)localObject);
      ((h0)localObject).t((h0)localObject);
      ((h0)localObject).d(paramView.getRootView());
      return localObject;
    }
    
    static int b(View paramView)
    {
      return paramView.getScrollIndicators();
    }
    
    static void c(View paramView, int paramInt)
    {
      paramView.setScrollIndicators(paramInt);
    }
    
    static void d(View paramView, int paramInt1, int paramInt2)
    {
      paramView.setScrollIndicators(paramInt1, paramInt2);
    }
  }
  
  static class o
  {
    static void a(View paramView)
    {
      paramView.cancelDragAndDrop();
    }
    
    static void b(View paramView)
    {
      paramView.dispatchFinishTemporaryDetach();
    }
    
    static void c(View paramView)
    {
      paramView.dispatchStartTemporaryDetach();
    }
    
    static void d(View paramView, PointerIcon paramPointerIcon)
    {
      paramView.setPointerIcon(paramPointerIcon);
    }
    
    static boolean e(View paramView, ClipData paramClipData, View.DragShadowBuilder paramDragShadowBuilder, Object paramObject, int paramInt)
    {
      return paramView.startDragAndDrop(paramClipData, paramDragShadowBuilder, paramObject, paramInt);
    }
    
    static void f(View paramView, View.DragShadowBuilder paramDragShadowBuilder)
    {
      paramView.updateDragShadow(paramDragShadowBuilder);
    }
  }
  
  static class p
  {
    static void a(View paramView, Collection<View> paramCollection, int paramInt)
    {
      paramView.addKeyboardNavigationClusters(paramCollection, paramInt);
    }
    
    static int b(View paramView)
    {
      return paramView.getImportantForAutofill();
    }
    
    static int c(View paramView)
    {
      return paramView.getNextClusterForwardId();
    }
    
    static boolean d(View paramView)
    {
      return paramView.hasExplicitFocusable();
    }
    
    static boolean e(View paramView)
    {
      return paramView.isFocusedByDefault();
    }
    
    static boolean f(View paramView)
    {
      return paramView.isImportantForAutofill();
    }
    
    static boolean g(View paramView)
    {
      return paramView.isKeyboardNavigationCluster();
    }
    
    static View h(View paramView1, View paramView2, int paramInt)
    {
      return paramView1.keyboardNavigationClusterSearch(paramView2, paramInt);
    }
    
    static boolean i(View paramView)
    {
      return paramView.restoreDefaultFocus();
    }
    
    static void j(View paramView, String... paramVarArgs)
    {
      paramView.setAutofillHints(paramVarArgs);
    }
    
    static void k(View paramView, boolean paramBoolean)
    {
      paramView.setFocusedByDefault(paramBoolean);
    }
    
    static void l(View paramView, int paramInt)
    {
      paramView.setImportantForAutofill(paramInt);
    }
    
    static void m(View paramView, boolean paramBoolean)
    {
      paramView.setKeyboardNavigationCluster(paramBoolean);
    }
    
    static void n(View paramView, int paramInt)
    {
      paramView.setNextClusterForwardId(paramInt);
    }
    
    static void o(View paramView, CharSequence paramCharSequence)
    {
      paramView.setTooltipText(paramCharSequence);
    }
  }
  
  static class q
  {
    static void a(View paramView, x.v paramv)
    {
      int i = R.id.tag_unhandled_key_listeners;
      Object localObject2 = (g0.g)paramView.getTag(i);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new g0.g();
        paramView.setTag(i, localObject1);
      }
      Objects.requireNonNull(paramv);
      localObject2 = new y(paramv);
      ((g0.g)localObject1).put(paramv, localObject2);
      paramView.addOnUnhandledKeyEventListener((View.OnUnhandledKeyEventListener)localObject2);
    }
    
    static CharSequence b(View paramView)
    {
      return paramView.getAccessibilityPaneTitle();
    }
    
    static boolean c(View paramView)
    {
      return paramView.isAccessibilityHeading();
    }
    
    static boolean d(View paramView)
    {
      return paramView.isScreenReaderFocusable();
    }
    
    static void e(View paramView, x.v paramv)
    {
      g0.g localg = (g0.g)paramView.getTag(R.id.tag_unhandled_key_listeners);
      if (localg == null) {
        return;
      }
      paramv = (View.OnUnhandledKeyEventListener)localg.get(paramv);
      if (paramv != null) {
        paramView.removeOnUnhandledKeyEventListener(paramv);
      }
    }
    
    static <T> T f(View paramView, int paramInt)
    {
      return paramView.requireViewById(paramInt);
    }
    
    static void g(View paramView, boolean paramBoolean)
    {
      paramView.setAccessibilityHeading(paramBoolean);
    }
    
    static void h(View paramView, CharSequence paramCharSequence)
    {
      paramView.setAccessibilityPaneTitle(paramCharSequence);
    }
    
    static void i(View paramView, boolean paramBoolean)
    {
      paramView.setScreenReaderFocusable(paramBoolean);
    }
  }
  
  private static class r
  {
    static View.AccessibilityDelegate a(View paramView)
    {
      return paramView.getAccessibilityDelegate();
    }
    
    static List<Rect> b(View paramView)
    {
      return paramView.getSystemGestureExclusionRects();
    }
    
    static void c(View paramView, Context paramContext, int[] paramArrayOfInt, AttributeSet paramAttributeSet, TypedArray paramTypedArray, int paramInt1, int paramInt2)
    {
      paramView.saveAttributeDataForStyleable(paramContext, paramArrayOfInt, paramAttributeSet, paramTypedArray, paramInt1, paramInt2);
    }
    
    static void d(View paramView, List<Rect> paramList)
    {
      paramView.setSystemGestureExclusionRects(paramList);
    }
  }
  
  private static class s
  {
    static CharSequence a(View paramView)
    {
      return paramView.getStateDescription();
    }
    
    static void b(View paramView, CharSequence paramCharSequence)
    {
      paramView.setStateDescription(paramCharSequence);
    }
  }
  
  private static final class t
  {
    public static String[] a(View paramView)
    {
      return paramView.getReceiveContentMimeTypes();
    }
    
    public static c b(View paramView, c paramc)
    {
      ContentInfo localContentInfo = paramc.f();
      paramView = paramView.performReceiveContent(localContentInfo);
      if (paramView == null) {
        return null;
      }
      if (paramView == localContentInfo) {
        return paramc;
      }
      return c.g(paramView);
    }
    
    public static void c(View paramView, String[] paramArrayOfString, s params)
    {
      if (params == null)
      {
        paramView.setOnReceiveContentListener(paramArrayOfString, null);
        return;
      }
      paramView.setOnReceiveContentListener(paramArrayOfString, new x.u(params));
    }
  }
  
  private static final class u
    implements OnReceiveContentListener
  {
    private final s a;
    
    u(s params)
    {
      this.a = params;
    }
    
    public ContentInfo onReceiveContent(View paramView, ContentInfo paramContentInfo)
    {
      c localc = c.g(paramContentInfo);
      paramView = this.a.a(paramView, localc);
      if (paramView == null) {
        return null;
      }
      if (paramView == localc) {
        return paramContentInfo;
      }
      return paramView.f();
    }
  }
  
  public static abstract interface v
  {
    public abstract boolean onUnhandledKeyEvent(View paramView, KeyEvent paramKeyEvent);
  }
  
  static class w
  {
    private static final ArrayList<WeakReference<View>> d = new ArrayList();
    private WeakHashMap<View, Boolean> a = null;
    private SparseArray<WeakReference<View>> b = null;
    private WeakReference<KeyEvent> c = null;
    
    static w a(View paramView)
    {
      int i = R.id.tag_unhandled_key_event_manager;
      w localw2 = (w)paramView.getTag(i);
      w localw1 = localw2;
      if (localw2 == null)
      {
        localw1 = new w();
        paramView.setTag(i, localw1);
      }
      return localw1;
    }
    
    private View c(View paramView, KeyEvent paramKeyEvent)
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (!((WeakHashMap)localObject).containsKey(paramView)) {
          return null;
        }
        if ((paramView instanceof ViewGroup))
        {
          localObject = (ViewGroup)paramView;
          int i = ((ViewGroup)localObject).getChildCount() - 1;
          while (i >= 0)
          {
            View localView = c(((ViewGroup)localObject).getChildAt(i), paramKeyEvent);
            if (localView != null) {
              return localView;
            }
            i -= 1;
          }
        }
        if (e(paramView, paramKeyEvent)) {
          return paramView;
        }
      }
      return null;
    }
    
    private SparseArray<WeakReference<View>> d()
    {
      if (this.b == null) {
        this.b = new SparseArray();
      }
      return this.b;
    }
    
    private boolean e(View paramView, KeyEvent paramKeyEvent)
    {
      ArrayList localArrayList = (ArrayList)paramView.getTag(R.id.tag_unhandled_key_listeners);
      if (localArrayList != null)
      {
        int i = localArrayList.size() - 1;
        while (i >= 0)
        {
          if (((x.v)localArrayList.get(i)).onUnhandledKeyEvent(paramView, paramKeyEvent)) {
            return true;
          }
          i -= 1;
        }
      }
      return false;
    }
    
    private void g()
    {
      Object localObject1 = this.a;
      if (localObject1 != null) {
        ((WeakHashMap)localObject1).clear();
      }
      ArrayList localArrayList = d;
      if (localArrayList.isEmpty()) {
        return;
      }
      for (;;)
      {
        int i;
        try
        {
          if (this.a == null) {
            this.a = new WeakHashMap();
          }
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            localObject1 = d;
            View localView = (View)((WeakReference)((ArrayList)localObject1).get(i)).get();
            if (localView == null)
            {
              ((ArrayList)localObject1).remove(i);
            }
            else
            {
              this.a.put(localView, Boolean.TRUE);
              localObject1 = localView.getParent();
              if ((localObject1 instanceof View))
              {
                this.a.put((View)localObject1, Boolean.TRUE);
                localObject1 = ((ViewParent)localObject1).getParent();
                continue;
              }
            }
          }
          else
          {
            return;
          }
        }
        finally {}
        i -= 1;
      }
    }
    
    boolean b(View paramView, KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent.getAction() == 0) {
        g();
      }
      paramView = c(paramView, paramKeyEvent);
      if (paramKeyEvent.getAction() == 0)
      {
        int i = paramKeyEvent.getKeyCode();
        if ((paramView != null) && (!KeyEvent.isModifierKey(i))) {
          d().put(i, new WeakReference(paramView));
        }
      }
      return paramView != null;
    }
    
    boolean f(KeyEvent paramKeyEvent)
    {
      Object localObject1 = this.c;
      if ((localObject1 != null) && (((WeakReference)localObject1).get() == paramKeyEvent)) {
        return false;
      }
      this.c = new WeakReference(paramKeyEvent);
      Object localObject2 = null;
      SparseArray localSparseArray = d();
      localObject1 = localObject2;
      if (paramKeyEvent.getAction() == 1)
      {
        int i = localSparseArray.indexOfKey(paramKeyEvent.getKeyCode());
        localObject1 = localObject2;
        if (i >= 0)
        {
          localObject1 = (WeakReference)localSparseArray.valueAt(i);
          localSparseArray.removeAt(i);
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (WeakReference)localSparseArray.get(paramKeyEvent.getKeyCode());
      }
      if (localObject2 != null)
      {
        localObject1 = (View)((WeakReference)localObject2).get();
        if ((localObject1 != null) && (x.T((View)localObject1))) {
          e((View)localObject1, paramKeyEvent);
        }
        return true;
      }
      return false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.x
 * JD-Core Version:    0.7.0.1
 */