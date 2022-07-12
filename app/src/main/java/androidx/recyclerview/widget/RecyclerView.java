package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.l;
import androidx.core.view.m;
import androidx.core.view.n;
import androidx.core.view.x;
import androidx.core.view.z;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R.attr;
import androidx.recyclerview.R.dimen;
import androidx.recyclerview.R.styleable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u0.f;
import y0.d;
import y0.d.b;

public class RecyclerView
  extends ViewGroup
  implements m
{
  private static final int[] D0 = { 16843830 };
  static final boolean E0 = false;
  static final boolean F0 = true;
  static final boolean G0 = true;
  static final boolean H0 = true;
  private static final boolean I0 = false;
  private static final boolean J0 = false;
  private static final Class<?>[] K0;
  static final Interpolator L0 = new c();
  private int A;
  private int A0;
  boolean B;
  private int B0;
  private final AccessibilityManager C;
  private final u.b C0;
  private List<q> E;
  boolean F = false;
  boolean G = false;
  private int H = 0;
  private int I = 0;
  private l J = new l();
  private EdgeEffect K;
  private EdgeEffect L;
  private EdgeEffect M;
  private EdgeEffect N;
  m O = new e();
  private int P = 0;
  private int Q = -1;
  private VelocityTracker R;
  private int S;
  private int T;
  private int U;
  private int V;
  private int W;
  private final x a = new x();
  private r a0;
  final v b = new v();
  private final int b0;
  SavedState c;
  private final int c0;
  a d;
  private float d0 = 1.4E-45F;
  b e;
  private float e0 = 1.4E-45F;
  final u f = new u();
  private boolean f0 = true;
  boolean g;
  final b0 g0 = new b0();
  final Runnable h = new a();
  h h0;
  final Rect i = new Rect();
  h.b i0;
  private final Rect j = new Rect();
  final z j0;
  final RectF k = new RectF();
  private t k0;
  h l;
  private List<t> l0;
  p m;
  boolean m0;
  w n;
  boolean n0;
  final List<w> o = new ArrayList();
  private RecyclerView.m.b o0;
  final ArrayList<o> p = new ArrayList();
  boolean p0;
  private final ArrayList<s> q = new ArrayList();
  o q0;
  private s r;
  private k r0;
  boolean s;
  private final int[] s0;
  boolean t;
  private n t0;
  boolean u;
  private final int[] u0;
  boolean v;
  private final int[] v0;
  private int w = 0;
  final int[] w0;
  boolean x;
  final List<c0> x0;
  boolean y;
  private Runnable y0;
  private boolean z;
  private boolean z0;
  
  static
  {
    Class localClass = Integer.TYPE;
    K0 = new Class[] { Context.class, AttributeSet.class, localClass, localClass };
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.recyclerViewStyle);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (H0) {
      localObject1 = new h.b();
    } else {
      localObject1 = null;
    }
    this.i0 = ((h.b)localObject1);
    this.j0 = new z();
    this.m0 = false;
    this.n0 = false;
    this.o0 = new n();
    this.p0 = false;
    this.s0 = new int[2];
    this.u0 = new int[2];
    this.v0 = new int[2];
    this.w0 = new int[2];
    this.x0 = new ArrayList();
    this.y0 = new b();
    this.A0 = 0;
    this.B0 = 0;
    this.C0 = new d();
    setScrollContainer(true);
    setFocusableInTouchMode(true);
    Object localObject1 = ViewConfiguration.get(paramContext);
    this.W = ((ViewConfiguration)localObject1).getScaledTouchSlop();
    this.d0 = z.b((ViewConfiguration)localObject1, paramContext);
    this.e0 = z.d((ViewConfiguration)localObject1, paramContext);
    this.b0 = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
    this.c0 = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
    if (getOverScrollMode() == 2) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    this.O.v(this.o0);
    q0();
    s0();
    r0();
    if (x.z(this) == 0) {
      x.B0(this, 1);
    }
    this.C = ((AccessibilityManager)getContext().getSystemService("accessibility"));
    setAccessibilityDelegateCompat(new o(this));
    Object localObject2 = R.styleable.RecyclerView;
    localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject2, paramInt, 0);
    x.o0(this, paramContext, (int[])localObject2, paramAttributeSet, (TypedArray)localObject1, paramInt, 0);
    localObject2 = ((TypedArray)localObject1).getString(R.styleable.RecyclerView_layoutManager);
    if (((TypedArray)localObject1).getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
      setDescendantFocusability(262144);
    }
    this.g = ((TypedArray)localObject1).getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
    boolean bool = ((TypedArray)localObject1).getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
    this.u = bool;
    if (bool) {
      t0((StateListDrawable)((TypedArray)localObject1).getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), ((TypedArray)localObject1).getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable)((TypedArray)localObject1).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), ((TypedArray)localObject1).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
    }
    ((TypedArray)localObject1).recycle();
    w(paramContext, (String)localObject2, paramAttributeSet, paramInt, 0);
    localObject1 = D0;
    localObject2 = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject1, paramInt, 0);
    x.o0(this, paramContext, (int[])localObject1, paramAttributeSet, (TypedArray)localObject2, paramInt, 0);
    bool = ((TypedArray)localObject2).getBoolean(0, true);
    ((TypedArray)localObject2).recycle();
    setNestedScrollingEnabled(bool);
  }
  
  private void B()
  {
    int i1 = this.A;
    this.A = 0;
    if ((i1 != 0) && (v0()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      y0.b.b(localAccessibilityEvent, i1);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private void B0(int paramInt1, int paramInt2, MotionEvent paramMotionEvent, int paramInt3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void D()
  {
    Object localObject = this.j0;
    boolean bool = true;
    ((z)localObject).a(1);
    R(this.j0);
    this.j0.j = false;
    t1();
    this.f.f();
    J0();
    R0();
    g1();
    localObject = this.j0;
    if ((!((z)localObject).k) || (!this.n0)) {
      bool = false;
    }
    ((z)localObject).i = bool;
    this.n0 = false;
    this.m0 = false;
    ((z)localObject).h = ((z)localObject).l;
    ((z)localObject).f = this.l.d();
    V(this.s0);
    int i2;
    int i1;
    RecyclerView.m.c localc;
    if (this.j0.k)
    {
      i2 = this.e.g();
      i1 = 0;
      while (i1 < i2)
      {
        localObject = h0(this.e.f(i1));
        if ((!((c0)localObject).J()) && ((!((c0)localObject).t()) || (this.l.i())))
        {
          localc = this.O.t(this.j0, (c0)localObject, m.e((c0)localObject), ((c0)localObject).o());
          this.f.e((c0)localObject, localc);
          if ((this.j0.i) && (((c0)localObject).y()) && (!((c0)localObject).v()) && (!((c0)localObject).J()) && (!((c0)localObject).t()))
          {
            long l1 = d0((c0)localObject);
            this.f.c(l1, (c0)localObject);
          }
        }
        i1 += 1;
      }
    }
    if (this.j0.l)
    {
      h1();
      localObject = this.j0;
      bool = ((z)localObject).g;
      ((z)localObject).g = false;
      this.m.X0(this.b, (z)localObject);
      this.j0.g = bool;
      i1 = 0;
      while (i1 < this.e.g())
      {
        localObject = h0(this.e.f(i1));
        if ((!((c0)localObject).J()) && (!this.f.i((c0)localObject)))
        {
          int i3 = m.e((c0)localObject);
          bool = ((c0)localObject).p(8192);
          i2 = i3;
          if (!bool) {
            i2 = i3 | 0x1000;
          }
          localc = this.O.t(this.j0, (c0)localObject, i2, ((c0)localObject).o());
          if (bool) {
            U0((c0)localObject, localc);
          } else {
            this.f.a((c0)localObject, localc);
          }
        }
        i1 += 1;
      }
    }
    t();
    K0();
    v1(false);
    this.j0.e = 2;
  }
  
  private void E()
  {
    t1();
    J0();
    this.j0.a(6);
    this.d.j();
    this.j0.f = this.l.d();
    this.j0.d = 0;
    if ((this.c != null) && (this.l.b()))
    {
      localObject = this.c.c;
      if (localObject != null) {
        this.m.c1((Parcelable)localObject);
      }
      this.c = null;
    }
    Object localObject = this.j0;
    ((z)localObject).h = false;
    this.m.X0(this.b, (z)localObject);
    localObject = this.j0;
    ((z)localObject).g = false;
    boolean bool;
    if ((((z)localObject).k) && (this.O != null)) {
      bool = true;
    } else {
      bool = false;
    }
    ((z)localObject).k = bool;
    ((z)localObject).e = 4;
    K0();
    v1(false);
  }
  
  private void F()
  {
    this.j0.a(4);
    t1();
    J0();
    Object localObject = this.j0;
    ((z)localObject).e = 1;
    if (((z)localObject).k)
    {
      int i1 = this.e.g() - 1;
      while (i1 >= 0)
      {
        localObject = h0(this.e.f(i1));
        if (!((c0)localObject).J())
        {
          long l1 = d0((c0)localObject);
          RecyclerView.m.c localc2 = this.O.s(this.j0, (c0)localObject);
          c0 localc0 = this.f.g(l1);
          if ((localc0 != null) && (!localc0.J()))
          {
            boolean bool1 = this.f.h(localc0);
            boolean bool2 = this.f.h((c0)localObject);
            if ((!bool1) || (localc0 != localObject))
            {
              RecyclerView.m.c localc1 = this.f.n(localc0);
              this.f.d((c0)localObject, localc2);
              localc2 = this.f.m((c0)localObject);
              if (localc1 == null)
              {
                n0(l1, (c0)localObject, localc0);
                break label236;
              }
              n(localc0, (c0)localObject, localc1, localc2, bool1, bool2);
              break label236;
            }
          }
          this.f.d((c0)localObject, localc2);
        }
        label236:
        i1 -= 1;
      }
      this.f.o(this.C0);
    }
    this.m.l1(this.b);
    localObject = this.j0;
    ((z)localObject).c = ((z)localObject).f;
    this.F = false;
    this.G = false;
    ((z)localObject).k = false;
    ((z)localObject).l = false;
    this.m.h = false;
    localObject = this.b.b;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = this.m;
    if (((p)localObject).n)
    {
      ((p)localObject).m = 0;
      ((p)localObject).n = false;
      this.b.K();
    }
    this.m.Y0(this.j0);
    K0();
    v1(false);
    this.f.f();
    localObject = this.s0;
    if (y(localObject[0], localObject[1])) {
      J(0, 0);
    }
    V0();
    e1();
  }
  
  private boolean L(MotionEvent paramMotionEvent)
  {
    s locals = this.r;
    if (locals == null)
    {
      if (paramMotionEvent.getAction() == 0) {
        return false;
      }
      return U(paramMotionEvent);
    }
    locals.b(this, paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 3) || (i1 == 1)) {
      this.r = null;
    }
    return true;
  }
  
  private void M0(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.Q)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.Q = paramMotionEvent.getPointerId(i1);
      int i2 = (int)(paramMotionEvent.getX(i1) + 0.5F);
      this.U = i2;
      this.S = i2;
      i1 = (int)(paramMotionEvent.getY(i1) + 0.5F);
      this.V = i1;
      this.T = i1;
    }
  }
  
  private boolean Q0()
  {
    return (this.O != null) && (this.m.L1());
  }
  
  private void R0()
  {
    if (this.F)
    {
      this.d.y();
      if (this.G) {
        this.m.S0(this);
      }
    }
    if (Q0()) {
      this.d.w();
    } else {
      this.d.j();
    }
    boolean bool1 = this.m0;
    boolean bool2 = false;
    int i1;
    if ((!bool1) && (!this.n0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    z localz = this.j0;
    if ((this.v) && (this.O != null))
    {
      bool1 = this.F;
      if (((bool1) || (i1 != 0) || (this.m.h)) && ((!bool1) || (this.l.i())))
      {
        bool1 = true;
        break label145;
      }
    }
    bool1 = false;
    label145:
    localz.k = bool1;
    localz = this.j0;
    bool1 = bool2;
    if (localz.k)
    {
      bool1 = bool2;
      if (i1 != 0)
      {
        bool1 = bool2;
        if (!this.F)
        {
          bool1 = bool2;
          if (Q0()) {
            bool1 = true;
          }
        }
      }
    }
    localz.l = bool1;
  }
  
  private void T0(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i2 = 1;
    EdgeEffect localEdgeEffect;
    float f2;
    float f1;
    if (paramFloat2 < 0.0F)
    {
      N();
      localEdgeEffect = this.K;
      f2 = -paramFloat2 / getWidth();
      f1 = 1.0F - paramFloat3 / getHeight();
      paramFloat3 = f2;
    }
    for (;;)
    {
      androidx.core.widget.g.c(localEdgeEffect, paramFloat3, f1);
      i1 = 1;
      break label104;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      O();
      localEdgeEffect = this.M;
      f1 = paramFloat2 / getWidth();
      f2 = paramFloat3 / getHeight();
      paramFloat3 = f1;
      f1 = f2;
    }
    int i1 = 0;
    label104:
    if (paramFloat4 < 0.0F)
    {
      P();
      androidx.core.widget.g.c(this.L, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i1 = i2;
    }
    else if (paramFloat4 > 0.0F)
    {
      M();
      androidx.core.widget.g.c(this.N, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
      i1 = i2;
    }
    if ((i1 != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
      x.h0(this);
    }
  }
  
  private boolean U(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getAction();
    int i3 = this.q.size();
    int i1 = 0;
    while (i1 < i3)
    {
      s locals = (s)this.q.get(i1);
      if ((locals.a(this, paramMotionEvent)) && (i2 != 3))
      {
        this.r = locals;
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private void V(int[] paramArrayOfInt)
  {
    int i7 = this.e.g();
    if (i7 == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    int i2 = 2147483647;
    int i4 = -2147483648;
    int i3 = 0;
    while (i3 < i7)
    {
      c0 localc0 = h0(this.e.f(i3));
      int i6;
      if (localc0.J())
      {
        i6 = i4;
      }
      else
      {
        int i5 = localc0.m();
        int i1 = i2;
        if (i5 < i2) {
          i1 = i5;
        }
        i2 = i1;
        i6 = i4;
        if (i5 > i4)
        {
          i6 = i5;
          i2 = i1;
        }
      }
      i3 += 1;
      i4 = i6;
    }
    paramArrayOfInt[0] = i2;
    paramArrayOfInt[1] = i4;
  }
  
  private void V0()
  {
    if ((this.f0) && (this.l != null) && (hasFocus()) && (getDescendantFocusability() != 393216))
    {
      if ((getDescendantFocusability() == 131072) && (isFocused())) {
        return;
      }
      Object localObject1;
      if (!isFocused())
      {
        localObject1 = getFocusedChild();
        if ((J0) && ((((View)localObject1).getParent() == null) || (!((View)localObject1).hasFocus())))
        {
          if (this.e.g() == 0) {
            requestFocus();
          }
        }
        else if (!this.e.n((View)localObject1)) {
          return;
        }
      }
      long l1 = this.j0.n;
      Object localObject2 = null;
      if ((l1 != -1L) && (this.l.i())) {
        localObject1 = Z(this.j0.n);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (!this.e.n(((c0)localObject1).a)) && (((c0)localObject1).a.hasFocusable()))
      {
        localObject1 = ((c0)localObject1).a;
      }
      else
      {
        localObject1 = localObject2;
        if (this.e.g() > 0) {
          localObject1 = X();
        }
      }
      if (localObject1 != null)
      {
        int i1 = this.j0.o;
        localObject2 = localObject1;
        if (i1 != -1L)
        {
          View localView = ((View)localObject1).findViewById(i1);
          localObject2 = localObject1;
          if (localView != null)
          {
            localObject2 = localObject1;
            if (localView.isFocusable()) {
              localObject2 = localView;
            }
          }
        }
        localObject2.requestFocus();
      }
    }
  }
  
  static RecyclerView W(View paramView)
  {
    if (!(paramView instanceof ViewGroup)) {
      return null;
    }
    if ((paramView instanceof RecyclerView)) {
      return (RecyclerView)paramView;
    }
    paramView = (ViewGroup)paramView;
    int i2 = paramView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      RecyclerView localRecyclerView = W(paramView.getChildAt(i1));
      if (localRecyclerView != null) {
        return localRecyclerView;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void W0()
  {
    EdgeEffect localEdgeEffect = this.K;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool2 = this.K.isFinished();
    }
    else
    {
      bool2 = false;
    }
    localEdgeEffect = this.L;
    boolean bool1 = bool2;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool1 = bool2 | this.L.isFinished();
    }
    localEdgeEffect = this.M;
    boolean bool2 = bool1;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool2 = bool1 | this.M.isFinished();
    }
    localEdgeEffect = this.N;
    bool1 = bool2;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool1 = bool2 | this.N.isFinished();
    }
    if (bool1) {
      x.h0(this);
    }
  }
  
  private View X()
  {
    Object localObject = this.j0;
    int i1 = ((z)localObject).m;
    if (i1 == -1) {
      i1 = 0;
    }
    int i3 = ((z)localObject).b();
    int i2 = i1;
    while (i2 < i3)
    {
      localObject = Y(i2);
      if (localObject == null) {
        break;
      }
      if (((c0)localObject).a.hasFocusable()) {
        return ((c0)localObject).a;
      }
      i2 += 1;
    }
    i1 = Math.min(i3, i1) - 1;
    while (i1 >= 0)
    {
      localObject = Y(i1);
      if (localObject == null) {
        return null;
      }
      if (((c0)localObject).a.hasFocusable()) {
        return ((c0)localObject).a;
      }
      i1 -= 1;
    }
    return null;
  }
  
  private void d1(View paramView1, View paramView2)
  {
    if (paramView2 != null) {
      localObject = paramView2;
    } else {
      localObject = paramView1;
    }
    this.i.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
    Object localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof LayoutParams))
    {
      localObject = (LayoutParams)localObject;
      if (!((LayoutParams)localObject).c)
      {
        localObject = ((LayoutParams)localObject).b;
        localRect = this.i;
        localRect.left -= ((Rect)localObject).left;
        localRect.right += ((Rect)localObject).right;
        localRect.top -= ((Rect)localObject).top;
        localRect.bottom += ((Rect)localObject).bottom;
      }
    }
    if (paramView2 != null)
    {
      offsetDescendantRectToMyCoords(paramView2, this.i);
      offsetRectIntoDescendantCoords(paramView1, this.i);
    }
    localObject = this.m;
    Rect localRect = this.i;
    boolean bool2 = this.v;
    boolean bool1;
    if (paramView2 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((p)localObject).s1(this, paramView1, localRect, bool2 ^ true, bool1);
  }
  
  private void e1()
  {
    z localz = this.j0;
    localz.n = -1L;
    localz.m = -1;
    localz.o = -1;
  }
  
  private void f1()
  {
    VelocityTracker localVelocityTracker = this.R;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    w1(0);
    W0();
  }
  
  private void g(c0 paramc0)
  {
    View localView = paramc0.a;
    int i1;
    if (localView.getParent() == this) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.b.J(g0(localView));
    if (paramc0.x())
    {
      this.e.c(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    paramc0 = this.e;
    if (i1 == 0)
    {
      paramc0.b(localView, true);
      return;
    }
    paramc0.k(localView);
  }
  
  private void g1()
  {
    boolean bool = this.f0;
    z localz = null;
    Object localObject;
    if ((bool) && (hasFocus()) && (this.l != null)) {
      localObject = getFocusedChild();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      localObject = localz;
    } else {
      localObject = T((View)localObject);
    }
    if (localObject == null)
    {
      e1();
      return;
    }
    localz = this.j0;
    long l1;
    if (this.l.i()) {
      l1 = ((c0)localObject).k();
    } else {
      l1 = -1L;
    }
    localz.n = l1;
    localz = this.j0;
    int i1;
    if (this.F) {
      i1 = -1;
    } else if (((c0)localObject).v()) {
      i1 = ((c0)localObject).d;
    } else {
      i1 = ((c0)localObject).j();
    }
    localz.m = i1;
    this.j0.o = k0(((c0)localObject).a);
  }
  
  private n getScrollingChildHelper()
  {
    if (this.t0 == null) {
      this.t0 = new n(this);
    }
    return this.t0;
  }
  
  static c0 h0(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).a;
  }
  
  static void j0(View paramView, Rect paramRect)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.b;
    paramRect.set(paramView.getLeft() - localRect.left - localLayoutParams.leftMargin, paramView.getTop() - localRect.top - localLayoutParams.topMargin, paramView.getRight() + localRect.right + localLayoutParams.rightMargin, paramView.getBottom() + localRect.bottom + localLayoutParams.bottomMargin);
  }
  
  private int k0(View paramView)
  {
    int i1;
    for (;;)
    {
      i1 = paramView.getId();
      View localView;
      do
      {
        if ((paramView.isFocused()) || (!(paramView instanceof ViewGroup)) || (!paramView.hasFocus())) {
          break;
        }
        localView = ((ViewGroup)paramView).getFocusedChild();
        paramView = localView;
      } while (localView.getId() == -1);
      paramView = localView;
    }
    return i1;
  }
  
  private String l0(Context paramContext, String paramString)
  {
    if (paramString.charAt(0) == '.')
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    if (paramString.contains(".")) {
      return paramString;
    }
    paramContext = new StringBuilder();
    paramContext.append(RecyclerView.class.getPackage().getName());
    paramContext.append('.');
    paramContext.append(paramString);
    return paramContext.toString();
  }
  
  private void l1(h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    h localh = this.l;
    if (localh != null)
    {
      localh.H(this.a);
      this.l.z(this);
    }
    if ((!paramBoolean1) || (paramBoolean2)) {
      X0();
    }
    this.d.y();
    localh = this.l;
    this.l = paramh;
    if (paramh != null)
    {
      paramh.E(this.a);
      paramh.v(this);
    }
    paramh = this.m;
    if (paramh != null) {
      paramh.E0(localh, this.l);
    }
    this.b.x(localh, this.l, paramBoolean1);
    this.j0.g = true;
  }
  
  private void n(c0 paramc01, c0 paramc02, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramc01.G(false);
    if (paramBoolean1) {
      g(paramc01);
    }
    if (paramc01 != paramc02)
    {
      if (paramBoolean2) {
        g(paramc02);
      }
      paramc01.h = paramc02;
      g(paramc01);
      this.b.J(paramc01);
      paramc02.G(false);
      paramc02.i = paramc01;
    }
    if (this.O.b(paramc01, paramc02, paramc1, paramc2)) {
      P0();
    }
  }
  
  private void n0(long paramLong, c0 paramc01, c0 paramc02)
  {
    int i2 = this.e.g();
    int i1 = 0;
    while (i1 < i2)
    {
      localObject = h0(this.e.f(i1));
      if ((localObject != paramc01) && (d0((c0)localObject) == paramLong))
      {
        paramc02 = this.l;
        if ((paramc02 != null) && (paramc02.i()))
        {
          paramc02 = new StringBuilder();
          paramc02.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
          paramc02.append(localObject);
          paramc02.append(" \n View Holder 2:");
          paramc02.append(paramc01);
          paramc02.append(Q());
          throw new IllegalStateException(paramc02.toString());
        }
        paramc02 = new StringBuilder();
        paramc02.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        paramc02.append(localObject);
        paramc02.append(" \n View Holder 2:");
        paramc02.append(paramc01);
        paramc02.append(Q());
        throw new IllegalStateException(paramc02.toString());
      }
      i1 += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
    ((StringBuilder)localObject).append(paramc02);
    ((StringBuilder)localObject).append(" cannot be found but it is necessary for ");
    ((StringBuilder)localObject).append(paramc01);
    ((StringBuilder)localObject).append(Q());
    Log.e("RecyclerView", ((StringBuilder)localObject).toString());
  }
  
  private boolean p0()
  {
    int i2 = this.e.g();
    int i1 = 0;
    while (i1 < i2)
    {
      c0 localc0 = h0(this.e.f(i1));
      if ((localc0 != null) && (!localc0.J()) && (localc0.y())) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private void r()
  {
    f1();
    setScrollState(0);
  }
  
  @SuppressLint({"InlinedApi"})
  private void r0()
  {
    if (x.A(this) == 0) {
      x.C0(this, 8);
    }
  }
  
  static void s(c0 paramc0)
  {
    Object localObject = paramc0.b;
    if (localObject != null)
    {
      localObject = ((WeakReference)localObject).get();
      for (localObject = (View)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label52;
        }
        if (localObject == paramc0.a) {
          return;
        }
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof View)) {
          break;
        }
      }
      label52:
      paramc0.b = null;
    }
  }
  
  private void s0()
  {
    this.e = new b(new e());
  }
  
  private void w(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (!paramString.isEmpty())
      {
        String str = l0(paramContext, paramString);
        try
        {
          if (isInEditMode()) {
            paramString = getClass().getClassLoader();
          } else {
            paramString = paramContext.getClassLoader();
          }
          Class localClass = Class.forName(str, false, paramString).asSubclass(p.class);
          Object localObject = null;
          try
          {
            paramString = localClass.getConstructor(K0);
            paramContext = new Object[] { paramContext, paramAttributeSet, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) };
          }
          catch (NoSuchMethodException paramContext) {}
          try
          {
            paramString = localClass.getConstructor(new Class[0]);
            paramContext = localObject;
            paramString.setAccessible(true);
            setLayoutManager((p)paramString.newInstance(paramContext));
            return;
          }
          catch (NoSuchMethodException paramString)
          {
            paramString.initCause(paramContext);
            paramContext = new StringBuilder();
            paramContext.append(paramAttributeSet.getPositionDescription());
            paramContext.append(": Error creating LayoutManager ");
            paramContext.append(str);
            throw new IllegalStateException(paramContext.toString(), paramString);
          }
          return;
        }
        catch (ClassCastException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Class is not a LayoutManager ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (IllegalAccessException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Cannot access non-public constructor ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (InstantiationException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Could not instantiate the LayoutManager: ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (InvocationTargetException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Could not instantiate the LayoutManager: ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (ClassNotFoundException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Unable to find LayoutManager ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
      }
    }
  }
  
  private boolean x0(View paramView1, View paramView2, int paramInt)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool7 = false;
    boolean bool3 = false;
    boolean bool1 = bool7;
    if (paramView2 != null)
    {
      bool1 = bool7;
      if (paramView2 != this)
      {
        if (paramView2 == paramView1) {
          return false;
        }
        if (S(paramView2) == null) {
          return false;
        }
        if (paramView1 == null) {
          return true;
        }
        if (S(paramView1) == null) {
          return true;
        }
        this.i.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
        this.j.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
        offsetDescendantRectToMyCoords(paramView1, this.i);
        offsetDescendantRectToMyCoords(paramView2, this.j);
        int i1 = this.m.Z();
        int i2 = -1;
        int i3;
        if (i1 == 1) {
          i3 = -1;
        } else {
          i3 = 1;
        }
        paramView1 = this.i;
        i1 = paramView1.left;
        paramView2 = this.j;
        int i4 = paramView2.left;
        int i6;
        if (((i1 < i4) || (paramView1.right <= i4)) && (paramView1.right < paramView2.right))
        {
          i1 = 1;
        }
        else
        {
          i5 = paramView1.right;
          i6 = paramView2.right;
          if (((i5 > i6) || (i1 >= i6)) && (i1 > i4)) {
            i1 = -1;
          } else {
            i1 = 0;
          }
        }
        i4 = paramView1.top;
        int i5 = paramView2.top;
        if (((i4 < i5) || (paramView1.bottom <= i5)) && (paramView1.bottom < paramView2.bottom))
        {
          i2 = 1;
        }
        else
        {
          i6 = paramView1.bottom;
          int i7 = paramView2.bottom;
          if (((i6 <= i7) && (i4 < i7)) || (i4 <= i5)) {
            i2 = 0;
          }
        }
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 17)
            {
              if (paramInt != 33)
              {
                if (paramInt != 66)
                {
                  if (paramInt == 130)
                  {
                    bool1 = bool3;
                    if (i2 > 0) {
                      bool1 = true;
                    }
                    return bool1;
                  }
                  paramView1 = new StringBuilder();
                  paramView1.append("Invalid direction: ");
                  paramView1.append(paramInt);
                  paramView1.append(Q());
                  throw new IllegalArgumentException(paramView1.toString());
                }
                bool1 = bool4;
                if (i1 > 0) {
                  bool1 = true;
                }
                return bool1;
              }
              bool1 = bool5;
              if (i2 < 0) {
                bool1 = true;
              }
              return bool1;
            }
            bool1 = bool6;
            if (i1 < 0) {
              bool1 = true;
            }
            return bool1;
          }
          if (i2 <= 0)
          {
            bool1 = bool2;
            if (i2 == 0)
            {
              bool1 = bool2;
              if (i1 * i3 <= 0) {}
            }
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
        if (i2 >= 0)
        {
          bool1 = bool7;
          if (i2 == 0)
          {
            bool1 = bool7;
            if (i1 * i3 >= 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean y(int paramInt1, int paramInt2)
  {
    V(this.s0);
    int[] arrayOfInt = this.s0;
    boolean bool = false;
    if ((arrayOfInt[0] != paramInt1) || (arrayOfInt[1] != paramInt2)) {
      bool = true;
    }
    return bool;
  }
  
  private void y1()
  {
    this.g0.f();
    p localp = this.m;
    if (localp != null) {
      localp.K1();
    }
  }
  
  void A(View paramView)
  {
    Object localObject = h0(paramView);
    I0(paramView);
    h localh = this.l;
    if ((localh != null) && (localObject != null)) {
      localh.C((c0)localObject);
    }
    localObject = this.E;
    if (localObject != null)
    {
      int i1 = ((List)localObject).size() - 1;
      while (i1 >= 0)
      {
        ((q)this.E.get(i1)).b(paramView);
        i1 -= 1;
      }
    }
  }
  
  void A0()
  {
    int i2 = this.e.j();
    int i1 = 0;
    while (i1 < i2)
    {
      c0 localc0 = h0(this.e.i(i1));
      if ((localc0 != null) && (!localc0.J())) {
        localc0.b(6);
      }
      i1 += 1;
    }
    z0();
    this.b.t();
  }
  
  void C()
  {
    if (this.l == null)
    {
      Log.w("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (this.m == null)
    {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    this.j0.j = false;
    int i1;
    if ((this.z0) && ((this.A0 != getWidth()) || (this.B0 != getHeight()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.A0 = 0;
    this.B0 = 0;
    this.z0 = false;
    if (this.j0.e == 1) {
      D();
    }
    while ((this.d.q()) || (i1 != 0) || (this.m.o0() != getWidth()) || (this.m.W() != getHeight()))
    {
      this.m.z1(this);
      E();
      break;
    }
    this.m.z1(this);
    F();
  }
  
  public void C0(int paramInt)
  {
    int i2 = this.e.g();
    int i1 = 0;
    while (i1 < i2)
    {
      this.e.f(i1).offsetLeftAndRight(paramInt);
      i1 += 1;
    }
  }
  
  public void D0(int paramInt)
  {
    int i2 = this.e.g();
    int i1 = 0;
    while (i1 < i2)
    {
      this.e.f(i1).offsetTopAndBottom(paramInt);
      i1 += 1;
    }
  }
  
  void E0(int paramInt1, int paramInt2)
  {
    int i2 = this.e.j();
    int i1 = 0;
    while (i1 < i2)
    {
      c0 localc0 = h0(this.e.i(i1));
      if ((localc0 != null) && (!localc0.J()) && (localc0.c >= paramInt1))
      {
        localc0.A(paramInt2, false);
        this.j0.g = true;
      }
      i1 += 1;
    }
    this.b.u(paramInt1, paramInt2);
    requestLayout();
  }
  
  void F0(int paramInt1, int paramInt2)
  {
    int i5 = this.e.j();
    int i1;
    int i2;
    int i3;
    if (paramInt1 < paramInt2)
    {
      i1 = -1;
      i2 = paramInt1;
      i3 = paramInt2;
    }
    else
    {
      i3 = paramInt1;
      i2 = paramInt2;
      i1 = 1;
    }
    int i4 = 0;
    while (i4 < i5)
    {
      c0 localc0 = h0(this.e.i(i4));
      if (localc0 != null)
      {
        int i6 = localc0.c;
        if ((i6 >= i2) && (i6 <= i3))
        {
          if (i6 == paramInt1) {
            localc0.A(paramInt2 - paramInt1, false);
          } else {
            localc0.A(i1, false);
          }
          this.j0.g = true;
        }
      }
      i4 += 1;
    }
    this.b.v(paramInt1, paramInt2);
    requestLayout();
  }
  
  public boolean G(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().d(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  void G0(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = this.e.j();
    int i1 = 0;
    while (i1 < i2)
    {
      c0 localc0 = h0(this.e.i(i1));
      if ((localc0 != null) && (!localc0.J()))
      {
        int i3 = localc0.c;
        if (i3 >= paramInt1 + paramInt2) {
          localc0.A(-paramInt2, paramBoolean);
        }
        for (;;)
        {
          this.j0.g = true;
          break;
          if (i3 < paramInt1) {
            break;
          }
          localc0.i(paramInt1 - 1, -paramInt2, paramBoolean);
        }
      }
      i1 += 1;
    }
    this.b.w(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  public final void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, int[] paramArrayOfInt2)
  {
    getScrollingChildHelper().e(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public void H0(View paramView) {}
  
  void I(int paramInt)
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((p)localObject).e1(paramInt);
    }
    N0(paramInt);
    localObject = this.k0;
    if (localObject != null) {
      ((t)localObject).a(this, paramInt);
    }
    localObject = this.l0;
    if (localObject != null)
    {
      int i1 = ((List)localObject).size() - 1;
      while (i1 >= 0)
      {
        ((t)this.l0.get(i1)).a(this, paramInt);
        i1 -= 1;
      }
    }
  }
  
  public void I0(View paramView) {}
  
  void J(int paramInt1, int paramInt2)
  {
    this.I += 1;
    int i1 = getScrollX();
    int i2 = getScrollY();
    onScrollChanged(i1, i2, i1 - paramInt1, i2 - paramInt2);
    O0(paramInt1, paramInt2);
    Object localObject = this.k0;
    if (localObject != null) {
      ((t)localObject).b(this, paramInt1, paramInt2);
    }
    localObject = this.l0;
    if (localObject != null)
    {
      i1 = ((List)localObject).size() - 1;
      while (i1 >= 0)
      {
        ((t)this.l0.get(i1)).b(this, paramInt1, paramInt2);
        i1 -= 1;
      }
    }
    this.I -= 1;
  }
  
  void J0()
  {
    this.H += 1;
  }
  
  void K()
  {
    int i1 = this.x0.size() - 1;
    while (i1 >= 0)
    {
      c0 localc0 = (c0)this.x0.get(i1);
      if ((localc0.a.getParent() == this) && (!localc0.J()))
      {
        int i2 = localc0.q;
        if (i2 != -1)
        {
          x.B0(localc0.a, i2);
          localc0.q = -1;
        }
      }
      i1 -= 1;
    }
    this.x0.clear();
  }
  
  void K0()
  {
    L0(true);
  }
  
  void L0(boolean paramBoolean)
  {
    int i1 = this.H - 1;
    this.H = i1;
    if (i1 < 1)
    {
      this.H = 0;
      if (paramBoolean)
      {
        B();
        K();
      }
    }
  }
  
  void M()
  {
    if (this.N != null) {
      return;
    }
    EdgeEffect localEdgeEffect = this.J.a(this, 3);
    this.N = localEdgeEffect;
    int i1;
    int i2;
    if (this.g)
    {
      i1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
      i2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    }
    else
    {
      i1 = getMeasuredWidth();
      i2 = getMeasuredHeight();
    }
    localEdgeEffect.setSize(i1, i2);
  }
  
  void N()
  {
    if (this.K != null) {
      return;
    }
    EdgeEffect localEdgeEffect = this.J.a(this, 0);
    this.K = localEdgeEffect;
    int i1;
    int i2;
    if (this.g)
    {
      i1 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
      i2 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    }
    else
    {
      i1 = getMeasuredHeight();
      i2 = getMeasuredWidth();
    }
    localEdgeEffect.setSize(i1, i2);
  }
  
  public void N0(int paramInt) {}
  
  void O()
  {
    if (this.M != null) {
      return;
    }
    EdgeEffect localEdgeEffect = this.J.a(this, 2);
    this.M = localEdgeEffect;
    int i1;
    int i2;
    if (this.g)
    {
      i1 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
      i2 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    }
    else
    {
      i1 = getMeasuredHeight();
      i2 = getMeasuredWidth();
    }
    localEdgeEffect.setSize(i1, i2);
  }
  
  public void O0(int paramInt1, int paramInt2) {}
  
  void P()
  {
    if (this.L != null) {
      return;
    }
    EdgeEffect localEdgeEffect = this.J.a(this, 1);
    this.L = localEdgeEffect;
    int i1;
    int i2;
    if (this.g)
    {
      i1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
      i2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    }
    else
    {
      i1 = getMeasuredWidth();
      i2 = getMeasuredHeight();
    }
    localEdgeEffect.setSize(i1, i2);
  }
  
  void P0()
  {
    if ((!this.p0) && (this.s))
    {
      x.i0(this, this.y0);
      this.p0 = true;
    }
  }
  
  String Q()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", adapter:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", layout:");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", context:");
    localStringBuilder.append(getContext());
    return localStringBuilder.toString();
  }
  
  final void R(z paramz)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.g0.c;
      paramz.p = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      paramz.q = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    paramz.p = 0;
    paramz.q = 0;
  }
  
  public View S(View paramView)
  {
    ViewParent localViewParent;
    for (;;)
    {
      localViewParent = paramView.getParent();
      if ((localViewParent == null) || (localViewParent == this) || (!(localViewParent instanceof View))) {
        break;
      }
      paramView = (View)localViewParent;
    }
    if (localViewParent == this) {
      return paramView;
    }
    return null;
  }
  
  void S0(boolean paramBoolean)
  {
    this.G = (paramBoolean | this.G);
    this.F = true;
    A0();
  }
  
  public c0 T(View paramView)
  {
    paramView = S(paramView);
    if (paramView == null) {
      return null;
    }
    return g0(paramView);
  }
  
  void U0(c0 paramc0, RecyclerView.m.c paramc)
  {
    paramc0.F(0, 8192);
    if ((this.j0.i) && (paramc0.y()) && (!paramc0.v()) && (!paramc0.J()))
    {
      long l1 = d0(paramc0);
      this.f.c(l1, paramc0);
    }
    this.f.e(paramc0, paramc);
  }
  
  void X0()
  {
    Object localObject = this.O;
    if (localObject != null) {
      ((m)localObject).k();
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((p)localObject).k1(this.b);
      this.m.l1(this.b);
    }
    this.b.c();
  }
  
  public c0 Y(int paramInt)
  {
    boolean bool = this.F;
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    int i2 = this.e.j();
    int i1 = 0;
    while (i1 < i2)
    {
      c0 localc0 = h0(this.e.i(i1));
      Object localObject2 = localObject1;
      if (localc0 != null)
      {
        localObject2 = localObject1;
        if (!localc0.v())
        {
          localObject2 = localObject1;
          if (c0(localc0) == paramInt) {
            if (this.e.n(localc0.a)) {
              localObject2 = localc0;
            } else {
              return localc0;
            }
          }
        }
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  boolean Y0(View paramView)
  {
    t1();
    boolean bool = this.e.r(paramView);
    if (bool)
    {
      paramView = h0(paramView);
      this.b.J(paramView);
      this.b.C(paramView);
    }
    v1(bool ^ true);
    return bool;
  }
  
  public c0 Z(long paramLong)
  {
    Object localObject3 = this.l;
    Object localObject2 = null;
    Object localObject1 = null;
    if (localObject3 != null)
    {
      if (!((h)localObject3).i()) {
        return null;
      }
      int i2 = this.e.j();
      int i1 = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i1 >= i2) {
          break;
        }
        localObject3 = h0(this.e.i(i1));
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!((c0)localObject3).v())
          {
            localObject2 = localObject1;
            if (((c0)localObject3).k() == paramLong) {
              if (this.e.n(((c0)localObject3).a)) {
                localObject2 = localObject3;
              } else {
                return localObject3;
              }
            }
          }
        }
        i1 += 1;
        localObject1 = localObject2;
      }
    }
    return localObject2;
  }
  
  public void Z0(o paramo)
  {
    p localp = this.m;
    if (localp != null) {
      localp.g("Cannot remove item decoration during a scroll  or layout");
    }
    this.p.remove(paramo);
    if (this.p.isEmpty())
    {
      boolean bool;
      if (getOverScrollMode() == 2) {
        bool = true;
      } else {
        bool = false;
      }
      setWillNotDraw(bool);
    }
    z0();
    requestLayout();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      N();
      if (this.K.isFinished()) {
        this.K.onAbsorb(-paramInt1);
      }
    }
    else if (paramInt1 > 0)
    {
      O();
      if (this.M.isFinished()) {
        this.M.onAbsorb(paramInt1);
      }
    }
    if (paramInt2 < 0)
    {
      P();
      if (this.L.isFinished()) {
        this.L.onAbsorb(-paramInt2);
      }
    }
    else if (paramInt2 > 0)
    {
      M();
      if (this.N.isFinished()) {
        this.N.onAbsorb(paramInt2);
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      x.h0(this);
    }
  }
  
  c0 a0(int paramInt, boolean paramBoolean)
  {
    int i2 = this.e.j();
    Object localObject1 = null;
    int i1 = 0;
    while (i1 < i2)
    {
      c0 localc0 = h0(this.e.i(i1));
      Object localObject2 = localObject1;
      if (localc0 != null)
      {
        localObject2 = localObject1;
        if (!localc0.v())
        {
          if (paramBoolean)
          {
            if (localc0.c != paramInt)
            {
              localObject2 = localObject1;
              break label115;
            }
          }
          else if (localc0.m() != paramInt)
          {
            localObject2 = localObject1;
            break label115;
          }
          if (this.e.n(localc0.a)) {
            localObject2 = localc0;
          } else {
            return localc0;
          }
        }
      }
      label115:
      i1 += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void a1(s params)
  {
    this.q.remove(params);
    if (this.r == params) {
      this.r = null;
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    p localp = this.m;
    if ((localp == null) || (!localp.F0(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public boolean b0(int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b1(t paramt)
  {
    List localList = this.l0;
    if (localList != null) {
      localList.remove(paramt);
    }
  }
  
  int c0(c0 paramc0)
  {
    if ((!paramc0.p(524)) && (paramc0.s())) {
      return this.d.e(paramc0.c);
    }
    return -1;
  }
  
  void c1()
  {
    int i2 = this.e.g();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = this.e.f(i1);
      Object localObject = g0(localView);
      if (localObject != null)
      {
        localObject = ((c0)localObject).i;
        if (localObject != null)
        {
          localObject = ((c0)localObject).a;
          int i3 = localView.getLeft();
          int i4 = localView.getTop();
          if ((i3 != ((View)localObject).getLeft()) || (i4 != ((View)localObject).getTop())) {
            ((View)localObject).layout(i3, i4, ((View)localObject).getWidth() + i3, ((View)localObject).getHeight() + i4);
          }
        }
      }
      i1 += 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (this.m.m((LayoutParams)paramLayoutParams));
  }
  
  public int computeHorizontalScrollExtent()
  {
    p localp = this.m;
    int i1 = 0;
    if (localp == null) {
      return 0;
    }
    if (localp.k()) {
      i1 = this.m.q(this.j0);
    }
    return i1;
  }
  
  public int computeHorizontalScrollOffset()
  {
    p localp = this.m;
    int i1 = 0;
    if (localp == null) {
      return 0;
    }
    if (localp.k()) {
      i1 = this.m.r(this.j0);
    }
    return i1;
  }
  
  public int computeHorizontalScrollRange()
  {
    p localp = this.m;
    int i1 = 0;
    if (localp == null) {
      return 0;
    }
    if (localp.k()) {
      i1 = this.m.s(this.j0);
    }
    return i1;
  }
  
  public int computeVerticalScrollExtent()
  {
    p localp = this.m;
    int i1 = 0;
    if (localp == null) {
      return 0;
    }
    if (localp.l()) {
      i1 = this.m.t(this.j0);
    }
    return i1;
  }
  
  public int computeVerticalScrollOffset()
  {
    p localp = this.m;
    int i1 = 0;
    if (localp == null) {
      return 0;
    }
    if (localp.l()) {
      i1 = this.m.u(this.j0);
    }
    return i1;
  }
  
  public int computeVerticalScrollRange()
  {
    p localp = this.m;
    int i1 = 0;
    if (localp == null) {
      return 0;
    }
    if (localp.l()) {
      i1 = this.m.v(this.j0);
    }
    return i1;
  }
  
  long d0(c0 paramc0)
  {
    if (this.l.i()) {
      return paramc0.k();
    }
    return paramc0.c;
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().b(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().c(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().f(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    return true;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i2 = this.p.size();
    int i3 = 0;
    int i1 = 0;
    while (i1 < i2)
    {
      ((o)this.p.get(i1)).i(paramCanvas, this, this.j0);
      i1 += 1;
    }
    EdgeEffect localEdgeEffect = this.K;
    int i4 = 1;
    int i5;
    if ((localEdgeEffect != null) && (!localEdgeEffect.isFinished()))
    {
      i5 = paramCanvas.save();
      if (this.g) {
        i1 = getPaddingBottom();
      } else {
        i1 = 0;
      }
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-getHeight() + i1, 0.0F);
      localEdgeEffect = this.K;
      if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      paramCanvas.restoreToCount(i5);
    }
    else
    {
      i2 = 0;
    }
    localEdgeEffect = this.L;
    i1 = i2;
    if (localEdgeEffect != null)
    {
      i1 = i2;
      if (!localEdgeEffect.isFinished())
      {
        i5 = paramCanvas.save();
        if (this.g) {
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        }
        localEdgeEffect = this.L;
        if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        i1 = i2 | i1;
        paramCanvas.restoreToCount(i5);
      }
    }
    localEdgeEffect = this.M;
    i2 = i1;
    if (localEdgeEffect != null)
    {
      i2 = i1;
      if (!localEdgeEffect.isFinished())
      {
        i5 = paramCanvas.save();
        int i6 = getWidth();
        if (this.g) {
          i2 = getPaddingTop();
        } else {
          i2 = 0;
        }
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(i2, -i6);
        localEdgeEffect = this.M;
        if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        i2 = i1 | i2;
        paramCanvas.restoreToCount(i5);
      }
    }
    localEdgeEffect = this.N;
    i1 = i2;
    if (localEdgeEffect != null)
    {
      i1 = i2;
      if (!localEdgeEffect.isFinished())
      {
        i5 = paramCanvas.save();
        paramCanvas.rotate(180.0F);
        float f1;
        if (this.g)
        {
          f1 = -getWidth() + getPaddingRight();
          i1 = -getHeight() + getPaddingBottom();
        }
        else
        {
          f1 = -getWidth();
          i1 = -getHeight();
        }
        paramCanvas.translate(f1, i1);
        localEdgeEffect = this.N;
        i1 = i3;
        if (localEdgeEffect != null)
        {
          i1 = i3;
          if (localEdgeEffect.draw(paramCanvas)) {
            i1 = 1;
          }
        }
        i1 = i2 | i1;
        paramCanvas.restoreToCount(i5);
      }
    }
    if ((i1 == 0) && (this.O != null) && (this.p.size() > 0) && (this.O.p())) {
      i1 = i4;
    }
    if (i1 != 0) {
      x.h0(this);
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public int e0(View paramView)
  {
    paramView = h0(paramView);
    if (paramView != null) {
      return paramView.j();
    }
    return -1;
  }
  
  public int f0(View paramView)
  {
    paramView = h0(paramView);
    if (paramView != null) {
      return paramView.m();
    }
    return -1;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    Object localObject = this.m.Q0(paramView, paramInt);
    if (localObject != null) {
      return localObject;
    }
    localObject = this.l;
    int i4 = 1;
    int i1;
    if ((localObject != null) && (this.m != null) && (!w0()) && (!this.y)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject = FocusFinder.getInstance();
    if ((i1 != 0) && ((paramInt == 2) || (paramInt == 1)))
    {
      if (this.m.l())
      {
        if (paramInt == 2) {
          i2 = 130;
        } else {
          i2 = 33;
        }
        if (((FocusFinder)localObject).findNextFocus(this, paramView, i2) == null) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        i1 = i3;
        if (I0)
        {
          paramInt = i2;
          i1 = i3;
        }
      }
      else
      {
        i1 = 0;
      }
      int i3 = i1;
      int i2 = paramInt;
      if (i1 == 0)
      {
        i3 = i1;
        i2 = paramInt;
        if (this.m.k())
        {
          if (this.m.Z() == 1) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (paramInt == 2) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if ((i1 ^ i2) != 0) {
            i1 = 66;
          } else {
            i1 = 17;
          }
          if (((FocusFinder)localObject).findNextFocus(this, paramView, i1) == null) {
            i2 = i4;
          } else {
            i2 = 0;
          }
          if (I0) {
            paramInt = i1;
          }
          i3 = i2;
          i2 = paramInt;
        }
      }
      if (i3 != 0)
      {
        v();
        if (S(paramView) == null) {
          return null;
        }
        t1();
        this.m.J0(paramView, i2, this.b, this.j0);
        v1(false);
      }
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, i2);
      paramInt = i2;
    }
    else
    {
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
      if ((localObject == null) && (i1 != 0))
      {
        v();
        if (S(paramView) == null) {
          return null;
        }
        t1();
        localObject = this.m.J0(paramView, paramInt, this.b, this.j0);
        v1(false);
      }
    }
    if ((localObject != null) && (!((View)localObject).hasFocusable()))
    {
      if (getFocusedChild() == null) {
        return super.focusSearch(paramView, paramInt);
      }
      d1((View)localObject, null);
      return paramView;
    }
    if (x0(paramView, (View)localObject, paramInt)) {
      return localObject;
    }
    return super.focusSearch(paramView, paramInt);
  }
  
  public c0 g0(View paramView)
  {
    Object localObject = paramView.getParent();
    if ((localObject != null) && (localObject != this))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("View ");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(" is not a direct child of ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return h0(paramView);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    Object localObject = this.m;
    if (localObject != null) {
      return ((p)localObject).D();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RecyclerView has no LayoutManager");
    ((StringBuilder)localObject).append(Q());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    p localp = this.m;
    if (localp != null) {
      return localp.E(getContext(), paramAttributeSet);
    }
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("RecyclerView has no LayoutManager");
    paramAttributeSet.append(Q());
    throw new IllegalStateException(paramAttributeSet.toString());
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    p localp = this.m;
    if (localp != null) {
      return localp.F(paramLayoutParams);
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("RecyclerView has no LayoutManager");
    paramLayoutParams.append(Q());
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  public CharSequence getAccessibilityClassName()
  {
    return "androidx.recyclerview.widget.RecyclerView";
  }
  
  public h getAdapter()
  {
    return this.l;
  }
  
  public int getBaseline()
  {
    p localp = this.m;
    if (localp != null) {
      return localp.G();
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    k localk = this.r0;
    if (localk == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return localk.a(paramInt1, paramInt2);
  }
  
  public boolean getClipToPadding()
  {
    return this.g;
  }
  
  public o getCompatAccessibilityDelegate()
  {
    return this.q0;
  }
  
  public l getEdgeEffectFactory()
  {
    return this.J;
  }
  
  public m getItemAnimator()
  {
    return this.O;
  }
  
  public int getItemDecorationCount()
  {
    return this.p.size();
  }
  
  public p getLayoutManager()
  {
    return this.m;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.c0;
  }
  
  public int getMinFlingVelocity()
  {
    return this.b0;
  }
  
  long getNanoTime()
  {
    if (H0) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  public r getOnFlingListener()
  {
    return this.a0;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.f0;
  }
  
  public u getRecycledViewPool()
  {
    return this.b.i();
  }
  
  public int getScrollState()
  {
    return this.P;
  }
  
  public void h(o paramo)
  {
    i(paramo, -1);
  }
  
  void h1()
  {
    int i2 = this.e.j();
    int i1 = 0;
    while (i1 < i2)
    {
      c0 localc0 = h0(this.e.i(i1));
      if (!localc0.J()) {
        localc0.E();
      }
      i1 += 1;
    }
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().j();
  }
  
  public void i(o paramo, int paramInt)
  {
    p localp = this.m;
    if (localp != null) {
      localp.g("Cannot add item decoration during a scroll  or layout");
    }
    if (this.p.isEmpty()) {
      setWillNotDraw(false);
    }
    if (paramInt < 0) {
      this.p.add(paramo);
    } else {
      this.p.add(paramInt, paramo);
    }
    z0();
    requestLayout();
  }
  
  public void i0(View paramView, Rect paramRect)
  {
    j0(paramView, paramRect);
  }
  
  boolean i1(int paramInt1, int paramInt2, MotionEvent paramMotionEvent, int paramInt3)
  {
    v();
    Object localObject = this.l;
    boolean bool2 = true;
    int i3;
    int i4;
    int i1;
    int i2;
    if (localObject != null)
    {
      localObject = this.w0;
      localObject[0] = 0;
      localObject[1] = 0;
      j1(paramInt1, paramInt2, (int[])localObject);
      localObject = this.w0;
      i3 = localObject[0];
      i4 = localObject[1];
      i1 = i4;
      i2 = i3;
      i3 = paramInt1 - i3;
      i4 = paramInt2 - i4;
    }
    else
    {
      i5 = 0;
      i1 = i5;
      i2 = i1;
      i4 = i2;
      i3 = i2;
      i2 = i1;
      i1 = i5;
    }
    if (!this.p.isEmpty()) {
      invalidate();
    }
    localObject = this.w0;
    localObject[0] = 0;
    localObject[1] = 0;
    H(i2, i1, i3, i4, this.u0, paramInt3, (int[])localObject);
    localObject = this.w0;
    int i5 = localObject[0];
    int i6 = localObject[1];
    if ((localObject[0] == 0) && (localObject[1] == 0)) {
      paramInt3 = 0;
    } else {
      paramInt3 = 1;
    }
    int i7 = this.U;
    localObject = this.u0;
    this.U = (i7 - localObject[0]);
    this.V -= localObject[1];
    int[] arrayOfInt = this.v0;
    arrayOfInt[0] += localObject[0];
    arrayOfInt[1] += localObject[1];
    if (getOverScrollMode() != 2)
    {
      if ((paramMotionEvent != null) && (!l.a(paramMotionEvent, 8194))) {
        T0(paramMotionEvent.getX(), i3 - i5, paramMotionEvent.getY(), i4 - i6);
      }
      u(paramInt1, paramInt2);
    }
    if ((i2 != 0) || (i1 != 0)) {
      J(i2, i1);
    }
    if (!awakenScrollBars()) {
      invalidate();
    }
    boolean bool1 = bool2;
    if (paramInt3 == 0)
    {
      bool1 = bool2;
      if (i2 == 0)
      {
        if (i1 != 0) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean isAttachedToWindow()
  {
    return this.s;
  }
  
  public final boolean isLayoutSuppressed()
  {
    return this.y;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().l();
  }
  
  public void j(q paramq)
  {
    if (this.E == null) {
      this.E = new ArrayList();
    }
    this.E.add(paramq);
  }
  
  void j1(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    t1();
    J0();
    f.a("RV Scroll");
    R(this.j0);
    if (paramInt1 != 0) {
      paramInt1 = this.m.w1(paramInt1, this.b, this.j0);
    } else {
      paramInt1 = 0;
    }
    if (paramInt2 != 0) {
      paramInt2 = this.m.y1(paramInt2, this.b, this.j0);
    } else {
      paramInt2 = 0;
    }
    f.b();
    c1();
    K0();
    v1(false);
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void k(s params)
  {
    this.q.add(params);
  }
  
  public void k1(int paramInt)
  {
    if (this.y) {
      return;
    }
    x1();
    p localp = this.m;
    if (localp == null)
    {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    localp.x1(paramInt);
    awakenScrollBars();
  }
  
  public void l(t paramt)
  {
    if (this.l0 == null) {
      this.l0 = new ArrayList();
    }
    this.l0.add(paramt);
  }
  
  void m(c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2)
  {
    paramc0.G(false);
    if (this.O.a(paramc0, paramc1, paramc2)) {
      P0();
    }
  }
  
  Rect m0(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.c) {
      return localLayoutParams.b;
    }
    if ((this.j0.e()) && ((localLayoutParams.b()) || (localLayoutParams.d()))) {
      return localLayoutParams.b;
    }
    Rect localRect1 = localLayoutParams.b;
    localRect1.set(0, 0, 0, 0);
    int i2 = this.p.size();
    int i1 = 0;
    while (i1 < i2)
    {
      this.i.set(0, 0, 0, 0);
      ((o)this.p.get(i1)).e(this.i, paramView, this, this.j0);
      int i3 = localRect1.left;
      Rect localRect2 = this.i;
      localRect1.left = (i3 + localRect2.left);
      localRect1.top += localRect2.top;
      localRect1.right += localRect2.right;
      localRect1.bottom += localRect2.bottom;
      i1 += 1;
    }
    localLayoutParams.c = false;
    return localRect1;
  }
  
  boolean m1(c0 paramc0, int paramInt)
  {
    if (w0())
    {
      paramc0.q = paramInt;
      this.x0.add(paramc0);
      return false;
    }
    x.B0(paramc0.a, paramInt);
    return true;
  }
  
  boolean n1(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = w0();
    int i2 = 0;
    if (bool)
    {
      int i1;
      if (paramAccessibilityEvent != null) {
        i1 = y0.b.a(paramAccessibilityEvent);
      } else {
        i1 = 0;
      }
      if (i1 == 0) {
        i1 = i2;
      }
      this.A |= i1;
      return true;
    }
    return false;
  }
  
  void o(c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2)
  {
    g(paramc0);
    paramc0.G(false);
    if (this.O.c(paramc0, paramc1, paramc2)) {
      P0();
    }
  }
  
  public boolean o0()
  {
    return (!this.v) || (this.F) || (this.d.p());
  }
  
  public void o1(int paramInt1, int paramInt2)
  {
    p1(paramInt1, paramInt2, null);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.H = 0;
    boolean bool = true;
    this.s = true;
    if ((!this.v) || (isLayoutRequested())) {
      bool = false;
    }
    this.v = bool;
    Object localObject1 = this.m;
    if (localObject1 != null) {
      ((p)localObject1).z(this);
    }
    this.p0 = false;
    if (H0)
    {
      localObject1 = h.e;
      Object localObject2 = (h)((ThreadLocal)localObject1).get();
      this.h0 = ((h)localObject2);
      if (localObject2 == null)
      {
        this.h0 = new h();
        localObject2 = x.v(this);
        float f2 = 60.0F;
        float f1 = f2;
        if (!isInEditMode())
        {
          f1 = f2;
          if (localObject2 != null)
          {
            float f3 = ((Display)localObject2).getRefreshRate();
            f1 = f2;
            if (f3 >= 30.0F) {
              f1 = f3;
            }
          }
        }
        localObject2 = this.h0;
        ((h)localObject2).c = ((1.0E+009F / f1));
        ((ThreadLocal)localObject1).set(localObject2);
      }
      this.h0.a(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.O;
    if (localObject != null) {
      ((m)localObject).k();
    }
    x1();
    this.s = false;
    localObject = this.m;
    if (localObject != null) {
      ((p)localObject).A(this, this.b);
    }
    this.x0.clear();
    removeCallbacks(this.y0);
    this.f.j();
    if (H0)
    {
      localObject = this.h0;
      if (localObject != null)
      {
        ((h)localObject).j(this);
        this.h0 = null;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = this.p.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((o)this.p.get(i1)).g(paramCanvas, this, this.j0);
      i1 += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.m == null) {
      return false;
    }
    if (this.y) {
      return false;
    }
    if (paramMotionEvent.getAction() == 8)
    {
      float f1;
      float f2;
      if ((paramMotionEvent.getSource() & 0x2) != 0)
      {
        if (this.m.l()) {
          f1 = -paramMotionEvent.getAxisValue(9);
        } else {
          f1 = 0.0F;
        }
        f2 = f1;
        if (this.m.k())
        {
          f2 = paramMotionEvent.getAxisValue(10);
          break label145;
        }
      }
      for (;;)
      {
        float f3 = 0.0F;
        f1 = f2;
        f2 = f3;
        break label145;
        if ((paramMotionEvent.getSource() & 0x400000) == 0) {
          break label141;
        }
        f2 = paramMotionEvent.getAxisValue(26);
        if (!this.m.l()) {
          break;
        }
        f2 = -f2;
      }
      if (this.m.k())
      {
        f1 = 0.0F;
      }
      else
      {
        label141:
        f1 = 0.0F;
        f2 = f1;
      }
      label145:
      if ((f1 != 0.0F) || (f2 != 0.0F)) {
        B0((int)(f2 * this.d0), (int)(f1 * this.e0), paramMotionEvent, 1);
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    f.a("RV OnLayout");
    C();
    f.b();
    this.v = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = this.m;
    if (localObject == null)
    {
      x(paramInt1, paramInt2);
      return;
    }
    boolean bool1 = ((p)localObject).s0();
    boolean bool2 = false;
    if (bool1)
    {
      int i1 = View.MeasureSpec.getMode(paramInt1);
      int i2 = View.MeasureSpec.getMode(paramInt2);
      this.m.Z0(this.b, this.j0, paramInt1, paramInt2);
      bool1 = bool2;
      if (i1 == 1073741824)
      {
        bool1 = bool2;
        if (i2 == 1073741824) {
          bool1 = true;
        }
      }
      this.z0 = bool1;
      if (!bool1)
      {
        if (this.l == null) {
          return;
        }
        if (this.j0.e == 1) {
          D();
        }
        this.m.A1(paramInt1, paramInt2);
        this.j0.j = true;
        E();
        this.m.D1(paramInt1, paramInt2);
        if (this.m.G1())
        {
          this.m.A1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
          this.j0.j = true;
          E();
          this.m.D1(paramInt1, paramInt2);
        }
        this.A0 = getMeasuredWidth();
        this.B0 = getMeasuredHeight();
        return;
      }
      return;
    }
    if (this.t)
    {
      this.m.Z0(this.b, this.j0, paramInt1, paramInt2);
      return;
    }
    if (this.B)
    {
      t1();
      J0();
      R0();
      K0();
      localObject = this.j0;
      if (((z)localObject).l)
      {
        ((z)localObject).h = true;
      }
      else
      {
        this.d.j();
        this.j0.h = false;
      }
      this.B = false;
      v1(false);
    }
    else if (this.j0.l)
    {
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
    localObject = this.l;
    if (localObject != null) {
      this.j0.f = ((h)localObject).d();
    } else {
      this.j0.f = 0;
    }
    t1();
    this.m.Z0(this.b, this.j0, paramInt1, paramInt2);
    v1(false);
    this.j0.h = false;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (w0()) {
      return false;
    }
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    this.c = paramParcelable;
    super.onRestoreInstanceState(paramParcelable.g());
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Object localObject = this.c;
    if (localObject != null)
    {
      localSavedState.h((SavedState)localObject);
      return localSavedState;
    }
    localObject = this.m;
    if (localObject != null) {
      localObject = ((p)localObject).d1();
    } else {
      localObject = null;
    }
    localSavedState.c = ((Parcelable)localObject);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      u0();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void p(String paramString)
  {
    if (w0())
    {
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramString.append(Q());
        throw new IllegalStateException(paramString.toString());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.I > 0)
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(Q());
      Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(paramString.toString()));
    }
  }
  
  public void p1(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    q1(paramInt1, paramInt2, paramInterpolator, -2147483648);
  }
  
  boolean q(c0 paramc0)
  {
    m localm = this.O;
    return (localm == null) || (localm.g(paramc0, paramc0.o()));
  }
  
  void q0()
  {
    this.d = new a(new f());
  }
  
  public void q1(int paramInt1, int paramInt2, Interpolator paramInterpolator, int paramInt3)
  {
    r1(paramInt1, paramInt2, paramInterpolator, paramInt3, false);
  }
  
  void r1(int paramInt1, int paramInt2, Interpolator paramInterpolator, int paramInt3, boolean paramBoolean)
  {
    p localp = this.m;
    if (localp == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (this.y) {
      return;
    }
    boolean bool = localp.k();
    int i2 = 0;
    int i1 = paramInt1;
    if (!bool) {
      i1 = 0;
    }
    if (!this.m.l()) {
      paramInt2 = 0;
    }
    if ((i1 != 0) || (paramInt2 != 0))
    {
      if ((paramInt3 != -2147483648) && (paramInt3 <= 0)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        if (paramBoolean)
        {
          paramInt1 = i2;
          if (i1 != 0) {
            paramInt1 = 1;
          }
          i2 = paramInt1;
          if (paramInt2 != 0) {
            i2 = paramInt1 | 0x2;
          }
          u1(i2, 1);
        }
        this.g0.e(i1, paramInt2, paramInt3, paramInterpolator);
        return;
      }
      scrollBy(i1, paramInt2);
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    c0 localc0 = h0(paramView);
    if (localc0 != null) {
      if (localc0.x())
      {
        localc0.f();
      }
      else if (!localc0.J())
      {
        paramView = new StringBuilder();
        paramView.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
        paramView.append(localc0);
        paramView.append(Q());
        throw new IllegalArgumentException(paramView.toString());
      }
    }
    paramView.clearAnimation();
    A(paramView);
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((!this.m.b1(this, this.j0, paramView1, paramView2)) && (paramView2 != null)) {
      d1(paramView1, paramView2);
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.m.r1(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int i2 = this.q.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((s)this.q.get(i1)).c(paramBoolean);
      i1 += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.w == 0) && (!this.y))
    {
      super.requestLayout();
      return;
    }
    this.x = true;
  }
  
  public void s1(int paramInt)
  {
    if (this.y) {
      return;
    }
    p localp = this.m;
    if (localp == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    localp.I1(this, this.j0, paramInt);
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    p localp = this.m;
    if (localp == null)
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (this.y) {
      return;
    }
    boolean bool1 = localp.k();
    boolean bool2 = this.m.l();
    if ((bool1) || (bool2))
    {
      if (!bool1) {
        paramInt1 = 0;
      }
      if (!bool2) {
        paramInt2 = 0;
      }
      i1(paramInt1, paramInt2, null, 0);
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    if (n1(paramAccessibilityEvent)) {
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegateCompat(o paramo)
  {
    this.q0 = paramo;
    x.q0(this, paramo);
  }
  
  public void setAdapter(h paramh)
  {
    setLayoutFrozen(false);
    l1(paramh, false, true);
    S0(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(k paramk)
  {
    if (paramk == this.r0) {
      return;
    }
    this.r0 = paramk;
    boolean bool;
    if (paramk != null) {
      bool = true;
    } else {
      bool = false;
    }
    setChildrenDrawingOrderEnabled(bool);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.g) {
      u0();
    }
    this.g = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.v) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(l paraml)
  {
    x0.h.g(paraml);
    this.J = paraml;
    u0();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void setItemAnimator(m paramm)
  {
    m localm = this.O;
    if (localm != null)
    {
      localm.k();
      this.O.v(null);
    }
    this.O = paramm;
    if (paramm != null) {
      paramm.v(this.o0);
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    this.b.G(paramInt);
  }
  
  @Deprecated
  public void setLayoutFrozen(boolean paramBoolean)
  {
    suppressLayout(paramBoolean);
  }
  
  public void setLayoutManager(p paramp)
  {
    if (paramp == this.m) {
      return;
    }
    x1();
    Object localObject;
    if (this.m != null)
    {
      localObject = this.O;
      if (localObject != null) {
        ((m)localObject).k();
      }
      this.m.k1(this.b);
      this.m.l1(this.b);
      this.b.c();
      if (this.s) {
        this.m.A(this, this.b);
      }
      this.m.E1(null);
      this.m = null;
    }
    else
    {
      this.b.c();
    }
    this.e.o();
    this.m = paramp;
    if (paramp != null) {
      if (paramp.b == null)
      {
        paramp.E1(this);
        if (this.s) {
          this.m.z(this);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LayoutManager ");
        ((StringBuilder)localObject).append(paramp);
        ((StringBuilder)localObject).append(" is already attached to a RecyclerView:");
        ((StringBuilder)localObject).append(paramp.b.Q());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    this.b.K();
    requestLayout();
  }
  
  @Deprecated
  public void setLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    if (paramLayoutTransition == null)
    {
      super.setLayoutTransition(null);
      return;
    }
    throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().m(paramBoolean);
  }
  
  public void setOnFlingListener(r paramr)
  {
    this.a0 = paramr;
  }
  
  @Deprecated
  public void setOnScrollListener(t paramt)
  {
    this.k0 = paramt;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.f0 = paramBoolean;
  }
  
  public void setRecycledViewPool(u paramu)
  {
    this.b.E(paramu);
  }
  
  @Deprecated
  public void setRecyclerListener(w paramw)
  {
    this.n = paramw;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.P) {
      return;
    }
    this.P = paramInt;
    if (paramInt != 2) {
      y1();
    }
    I(paramInt);
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("; using default value");
        Log.w("RecyclerView", localStringBuilder.toString());
      }
      else
      {
        paramInt = localViewConfiguration.getScaledPagingTouchSlop();
        break label74;
      }
    }
    paramInt = localViewConfiguration.getScaledTouchSlop();
    label74:
    this.W = paramInt;
  }
  
  public void setViewCacheExtension(a0 parama0)
  {
    this.b.F(parama0);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().o(paramInt);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().q();
  }
  
  public final void suppressLayout(boolean paramBoolean)
  {
    if (paramBoolean != this.y)
    {
      p("Do not suppressLayout in layout or scroll");
      if (!paramBoolean)
      {
        this.y = false;
        if ((this.x) && (this.m != null) && (this.l != null)) {
          requestLayout();
        }
        this.x = false;
        return;
      }
      long l1 = SystemClock.uptimeMillis();
      onTouchEvent(MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0));
      this.y = true;
      this.z = true;
      x1();
    }
  }
  
  void t()
  {
    int i2 = this.e.j();
    int i1 = 0;
    while (i1 < i2)
    {
      c0 localc0 = h0(this.e.i(i1));
      if (!localc0.J()) {
        localc0.c();
      }
      i1 += 1;
    }
    this.b.d();
  }
  
  void t0(StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2)
  {
    if ((paramStateListDrawable1 != null) && (paramDrawable1 != null) && (paramStateListDrawable2 != null) && (paramDrawable2 != null))
    {
      Resources localResources = getContext().getResources();
      new g(this, paramStateListDrawable1, paramDrawable1, paramStateListDrawable2, paramDrawable2, localResources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), localResources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), localResources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
      return;
    }
    paramStateListDrawable1 = new StringBuilder();
    paramStateListDrawable1.append("Trying to set fast scroller without both required drawables.");
    paramStateListDrawable1.append(Q());
    throw new IllegalArgumentException(paramStateListDrawable1.toString());
  }
  
  void t1()
  {
    int i1 = this.w + 1;
    this.w = i1;
    if ((i1 == 1) && (!this.y)) {
      this.x = false;
    }
  }
  
  void u(int paramInt1, int paramInt2)
  {
    EdgeEffect localEdgeEffect = this.K;
    if ((localEdgeEffect != null) && (!localEdgeEffect.isFinished()) && (paramInt1 > 0))
    {
      this.K.onRelease();
      bool2 = this.K.isFinished();
    }
    else
    {
      bool2 = false;
    }
    localEdgeEffect = this.M;
    boolean bool1 = bool2;
    if (localEdgeEffect != null)
    {
      bool1 = bool2;
      if (!localEdgeEffect.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 < 0)
        {
          this.M.onRelease();
          bool1 = bool2 | this.M.isFinished();
        }
      }
    }
    localEdgeEffect = this.L;
    boolean bool2 = bool1;
    if (localEdgeEffect != null)
    {
      bool2 = bool1;
      if (!localEdgeEffect.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 > 0)
        {
          this.L.onRelease();
          bool2 = bool1 | this.L.isFinished();
        }
      }
    }
    localEdgeEffect = this.N;
    bool1 = bool2;
    if (localEdgeEffect != null)
    {
      bool1 = bool2;
      if (!localEdgeEffect.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 < 0)
        {
          this.N.onRelease();
          bool1 = bool2 | this.N.isFinished();
        }
      }
    }
    if (bool1) {
      x.h0(this);
    }
  }
  
  void u0()
  {
    this.N = null;
    this.L = null;
    this.M = null;
    this.K = null;
  }
  
  public boolean u1(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().p(paramInt1, paramInt2);
  }
  
  void v()
  {
    if ((this.v) && (!this.F))
    {
      if (!this.d.p()) {
        return;
      }
      if ((this.d.o(4)) && (!this.d.o(11)))
      {
        f.a("RV PartialInvalidate");
        t1();
        J0();
        this.d.w();
        if (!this.x) {
          if (p0()) {
            C();
          } else {
            this.d.i();
          }
        }
        v1(true);
        K0();
      }
      else
      {
        if (!this.d.p()) {
          break label135;
        }
        f.a("RV FullInvalidate");
        C();
      }
      f.b();
      label135:
      return;
    }
    f.a("RV FullInvalidate");
    C();
    f.b();
  }
  
  boolean v0()
  {
    AccessibilityManager localAccessibilityManager = this.C;
    return (localAccessibilityManager != null) && (localAccessibilityManager.isEnabled());
  }
  
  void v1(boolean paramBoolean)
  {
    if (this.w < 1) {
      this.w = 1;
    }
    if ((!paramBoolean) && (!this.y)) {
      this.x = false;
    }
    if (this.w == 1)
    {
      if ((paramBoolean) && (this.x) && (!this.y) && (this.m != null) && (this.l != null)) {
        C();
      }
      if (!this.y) {
        this.x = false;
      }
    }
    this.w -= 1;
  }
  
  public boolean w0()
  {
    return this.H > 0;
  }
  
  public void w1(int paramInt)
  {
    getScrollingChildHelper().r(paramInt);
  }
  
  void x(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(p.n(paramInt1, getPaddingLeft() + getPaddingRight(), x.D(this)), p.n(paramInt2, getPaddingTop() + getPaddingBottom(), x.C(this)));
  }
  
  public void x1()
  {
    setScrollState(0);
    y1();
  }
  
  void y0(int paramInt)
  {
    if (this.m == null) {
      return;
    }
    setScrollState(2);
    this.m.x1(paramInt);
    awakenScrollBars();
  }
  
  void z(View paramView)
  {
    Object localObject = h0(paramView);
    H0(paramView);
    h localh = this.l;
    if ((localh != null) && (localObject != null)) {
      localh.B((c0)localObject);
    }
    localObject = this.E;
    if (localObject != null)
    {
      int i1 = ((List)localObject).size() - 1;
      while (i1 >= 0)
      {
        ((q)this.E.get(i1)).a(paramView);
        i1 -= 1;
      }
    }
  }
  
  void z0()
  {
    int i2 = this.e.j();
    int i1 = 0;
    while (i1 < i2)
    {
      ((LayoutParams)this.e.i(i1).getLayoutParams()).c = true;
      i1 += 1;
    }
    this.b.s();
  }
  
  void z1(int paramInt1, int paramInt2, Object paramObject)
  {
    int i2 = this.e.j();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = this.e.i(i1);
      c0 localc0 = h0(localView);
      if ((localc0 != null) && (!localc0.J()))
      {
        int i3 = localc0.c;
        if ((i3 >= paramInt1) && (i3 < paramInt1 + paramInt2))
        {
          localc0.b(2);
          localc0.a(paramObject);
          ((LayoutParams)localView.getLayoutParams()).c = true;
        }
      }
      i1 += 1;
    }
    this.b.M(paramInt1, paramInt2);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    RecyclerView.c0 a;
    final Rect b = new Rect();
    boolean c = true;
    boolean d = false;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public int a()
    {
      return this.a.m();
    }
    
    public boolean b()
    {
      return this.a.y();
    }
    
    public boolean c()
    {
      return this.a.v();
    }
    
    public boolean d()
    {
      return this.a.t();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    Parcelable c;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader == null) {
        paramClassLoader = RecyclerView.p.class.getClassLoader();
      }
      this.c = paramParcel.readParcelable(paramClassLoader);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    void h(SavedState paramSavedState)
    {
      this.c = paramSavedState.c;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.c, 0);
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<RecyclerView.SavedState>
    {
      public RecyclerView.SavedState a(Parcel paramParcel)
      {
        return new RecyclerView.SavedState(paramParcel, null);
      }
      
      public RecyclerView.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new RecyclerView.SavedState(paramParcel, paramClassLoader);
      }
      
      public RecyclerView.SavedState[] c(int paramInt)
      {
        return new RecyclerView.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      RecyclerView localRecyclerView = RecyclerView.this;
      if (localRecyclerView.v)
      {
        if (localRecyclerView.isLayoutRequested()) {
          return;
        }
        localRecyclerView = RecyclerView.this;
        if (!localRecyclerView.s)
        {
          localRecyclerView.requestLayout();
          return;
        }
        if (localRecyclerView.y)
        {
          localRecyclerView.x = true;
          return;
        }
        localRecyclerView.v();
      }
    }
  }
  
  public static abstract class a0 {}
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      RecyclerView.m localm = RecyclerView.this.O;
      if (localm != null) {
        localm.u();
      }
      RecyclerView.this.p0 = false;
    }
  }
  
  class b0
    implements Runnable
  {
    private int a;
    private int b;
    OverScroller c;
    Interpolator d;
    private boolean e;
    private boolean f;
    
    b0()
    {
      Interpolator localInterpolator = RecyclerView.L0;
      this.d = localInterpolator;
      this.e = false;
      this.f = false;
      this.c = new OverScroller(RecyclerView.this.getContext(), localInterpolator);
    }
    
    private int a(int paramInt1, int paramInt2)
    {
      int i = Math.abs(paramInt1);
      int j = Math.abs(paramInt2);
      if (i > j) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      RecyclerView localRecyclerView = RecyclerView.this;
      if (paramInt1 != 0) {
        paramInt2 = localRecyclerView.getWidth();
      } else {
        paramInt2 = localRecyclerView.getHeight();
      }
      if (paramInt1 != 0) {
        paramInt1 = i;
      } else {
        paramInt1 = j;
      }
      return Math.min((int)((paramInt1 / paramInt2 + 1.0F) * 300.0F), 2000);
    }
    
    private void c()
    {
      RecyclerView.this.removeCallbacks(this);
      x.i0(RecyclerView.this, this);
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      RecyclerView.this.setScrollState(2);
      this.b = 0;
      this.a = 0;
      Interpolator localInterpolator1 = this.d;
      Interpolator localInterpolator2 = RecyclerView.L0;
      if (localInterpolator1 != localInterpolator2)
      {
        this.d = localInterpolator2;
        this.c = new OverScroller(RecyclerView.this.getContext(), localInterpolator2);
      }
      this.c.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      d();
    }
    
    void d()
    {
      if (this.e)
      {
        this.f = true;
        return;
      }
      c();
    }
    
    public void e(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      int i = paramInt3;
      if (paramInt3 == -2147483648) {
        i = a(paramInt1, paramInt2);
      }
      Interpolator localInterpolator = paramInterpolator;
      if (paramInterpolator == null) {
        localInterpolator = RecyclerView.L0;
      }
      if (this.d != localInterpolator)
      {
        this.d = localInterpolator;
        this.c = new OverScroller(RecyclerView.this.getContext(), localInterpolator);
      }
      this.b = 0;
      this.a = 0;
      RecyclerView.this.setScrollState(2);
      this.c.startScroll(0, 0, paramInt1, paramInt2, i);
      d();
    }
    
    public void f()
    {
      RecyclerView.this.removeCallbacks(this);
      this.c.abortAnimation();
    }
    
    public void run()
    {
      Object localObject1 = RecyclerView.this;
      if (((RecyclerView)localObject1).m == null)
      {
        f();
        return;
      }
      this.f = false;
      this.e = true;
      ((RecyclerView)localObject1).v();
      localObject1 = this.c;
      if (((OverScroller)localObject1).computeScrollOffset())
      {
        int i = ((OverScroller)localObject1).getCurrX();
        int j = ((OverScroller)localObject1).getCurrY();
        int m = i - this.a;
        int k = j - this.b;
        this.a = i;
        this.b = j;
        Object localObject2 = RecyclerView.this;
        int[] arrayOfInt = ((RecyclerView)localObject2).w0;
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        i = m;
        j = k;
        if (((RecyclerView)localObject2).G(m, k, arrayOfInt, null, 1))
        {
          localObject2 = RecyclerView.this.w0;
          i = m - localObject2[0];
          j = k - localObject2[1];
        }
        if (RecyclerView.this.getOverScrollMode() != 2) {
          RecyclerView.this.u(i, j);
        }
        localObject2 = RecyclerView.this;
        if (((RecyclerView)localObject2).l != null)
        {
          arrayOfInt = ((RecyclerView)localObject2).w0;
          arrayOfInt[0] = 0;
          arrayOfInt[1] = 0;
          ((RecyclerView)localObject2).j1(i, j, arrayOfInt);
          localObject2 = RecyclerView.this;
          arrayOfInt = ((RecyclerView)localObject2).w0;
          n = arrayOfInt[0];
          i1 = arrayOfInt[1];
          int i2 = i - n;
          int i3 = j - i1;
          localObject2 = ((RecyclerView)localObject2).m.g;
          i = i2;
          k = i1;
          j = n;
          m = i3;
          if (localObject2 != null)
          {
            i = i2;
            k = i1;
            j = n;
            m = i3;
            if (!((RecyclerView.y)localObject2).g())
            {
              i = i2;
              k = i1;
              j = n;
              m = i3;
              if (((RecyclerView.y)localObject2).h())
              {
                i = RecyclerView.this.j0.b();
                if (i == 0)
                {
                  ((RecyclerView.y)localObject2).r();
                  i = i2;
                  k = i1;
                  j = n;
                  m = i3;
                }
                else
                {
                  if (((RecyclerView.y)localObject2).f() >= i) {
                    ((RecyclerView.y)localObject2).p(i - 1);
                  }
                  ((RecyclerView.y)localObject2).j(n, i1);
                  i = i2;
                  k = i1;
                  j = n;
                  m = i3;
                }
              }
            }
          }
        }
        else
        {
          k = 0;
          n = k;
          m = j;
          j = n;
        }
        if (!RecyclerView.this.p.isEmpty()) {
          RecyclerView.this.invalidate();
        }
        localObject2 = RecyclerView.this;
        arrayOfInt = ((RecyclerView)localObject2).w0;
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        ((RecyclerView)localObject2).H(j, k, i, m, null, 1, arrayOfInt);
        localObject2 = RecyclerView.this;
        arrayOfInt = ((RecyclerView)localObject2).w0;
        int i1 = i - arrayOfInt[0];
        int n = m - arrayOfInt[1];
        if ((j != 0) || (k != 0)) {
          ((RecyclerView)localObject2).J(j, k);
        }
        if (!RecyclerView.e(RecyclerView.this)) {
          RecyclerView.this.invalidate();
        }
        if (((OverScroller)localObject1).getCurrX() == ((OverScroller)localObject1).getFinalX()) {
          i = 1;
        } else {
          i = 0;
        }
        if (((OverScroller)localObject1).getCurrY() == ((OverScroller)localObject1).getFinalY()) {
          m = 1;
        } else {
          m = 0;
        }
        if ((!((OverScroller)localObject1).isFinished()) && (((i == 0) && (i1 == 0)) || ((m == 0) && (n == 0)))) {
          i = 0;
        } else {
          i = 1;
        }
        localObject2 = RecyclerView.this.m.g;
        if ((localObject2 != null) && (((RecyclerView.y)localObject2).g())) {
          m = 1;
        } else {
          m = 0;
        }
        if ((m == 0) && (i != 0))
        {
          if (RecyclerView.this.getOverScrollMode() != 2)
          {
            j = (int)((OverScroller)localObject1).getCurrVelocity();
            if (i1 < 0) {
              i = -j;
            } else if (i1 > 0) {
              i = j;
            } else {
              i = 0;
            }
            if (n < 0) {
              j = -j;
            } else if (n <= 0) {
              j = 0;
            }
            RecyclerView.this.a(i, j);
          }
          if (RecyclerView.H0) {
            RecyclerView.this.i0.b();
          }
        }
        else
        {
          d();
          localObject1 = RecyclerView.this;
          localObject2 = ((RecyclerView)localObject1).h0;
          if (localObject2 != null) {
            ((h)localObject2).f((RecyclerView)localObject1, j, k);
          }
        }
      }
      localObject1 = RecyclerView.this.m.g;
      if ((localObject1 != null) && (((RecyclerView.y)localObject1).g())) {
        ((RecyclerView.y)localObject1).j(0, 0);
      }
      this.e = false;
      if (this.f)
      {
        c();
        return;
      }
      RecyclerView.this.setScrollState(0);
      RecyclerView.this.w1(1);
    }
  }
  
  class c
    implements Interpolator
  {
    public float getInterpolation(float paramFloat)
    {
      paramFloat -= 1.0F;
      return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
    }
  }
  
  public static abstract class c0
  {
    private static final List<Object> t = ;
    public final View a;
    WeakReference<RecyclerView> b;
    int c = -1;
    int d = -1;
    long e = -1L;
    int f = -1;
    int g = -1;
    c0 h = null;
    c0 i = null;
    int j;
    List<Object> k = null;
    List<Object> l = null;
    private int m = 0;
    RecyclerView.v n = null;
    boolean o = false;
    private int p = 0;
    int q = -1;
    RecyclerView r;
    RecyclerView.h<? extends c0> s;
    
    public c0(View paramView)
    {
      if (paramView != null)
      {
        this.a = paramView;
        return;
      }
      throw new IllegalArgumentException("itemView may not be null");
    }
    
    private void g()
    {
      if (this.k == null)
      {
        ArrayList localArrayList = new ArrayList();
        this.k = localArrayList;
        this.l = Collections.unmodifiableList(localArrayList);
      }
    }
    
    void A(int paramInt, boolean paramBoolean)
    {
      if (this.d == -1) {
        this.d = this.c;
      }
      if (this.g == -1) {
        this.g = this.c;
      }
      if (paramBoolean) {
        this.g += paramInt;
      }
      this.c += paramInt;
      if (this.a.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.a.getLayoutParams()).c = true;
      }
    }
    
    void B(RecyclerView paramRecyclerView)
    {
      int i1 = this.q;
      if (i1 == -1) {
        i1 = x.z(this.a);
      }
      this.p = i1;
      paramRecyclerView.m1(this, 4);
    }
    
    void C(RecyclerView paramRecyclerView)
    {
      paramRecyclerView.m1(this, this.p);
      this.p = 0;
    }
    
    void D()
    {
      this.j = 0;
      this.c = -1;
      this.d = -1;
      this.e = -1L;
      this.g = -1;
      this.m = 0;
      this.h = null;
      this.i = null;
      d();
      this.p = 0;
      this.q = -1;
      RecyclerView.s(this);
    }
    
    void E()
    {
      if (this.d == -1) {
        this.d = this.c;
      }
    }
    
    void F(int paramInt1, int paramInt2)
    {
      this.j = (paramInt1 & paramInt2 | this.j & paramInt2);
    }
    
    public final void G(boolean paramBoolean)
    {
      int i1 = this.m;
      if (paramBoolean) {
        i1 -= 1;
      } else {
        i1 += 1;
      }
      this.m = i1;
      if (i1 < 0)
      {
        this.m = 0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
        localStringBuilder.append(this);
        Log.e("View", localStringBuilder.toString());
        return;
      }
      if ((!paramBoolean) && (i1 == 1)) {}
      for (i1 = this.j | 0x10;; i1 = this.j & 0xFFFFFFEF)
      {
        this.j = i1;
        return;
        if ((!paramBoolean) || (i1 != 0)) {
          break;
        }
      }
    }
    
    void H(RecyclerView.v paramv, boolean paramBoolean)
    {
      this.n = paramv;
      this.o = paramBoolean;
    }
    
    boolean I()
    {
      return (this.j & 0x10) != 0;
    }
    
    boolean J()
    {
      return (this.j & 0x80) != 0;
    }
    
    void K()
    {
      this.n.J(this);
    }
    
    boolean L()
    {
      return (this.j & 0x20) != 0;
    }
    
    void a(Object paramObject)
    {
      if (paramObject == null)
      {
        b(1024);
        return;
      }
      if ((0x400 & this.j) == 0)
      {
        g();
        this.k.add(paramObject);
      }
    }
    
    void b(int paramInt)
    {
      this.j = (paramInt | this.j);
    }
    
    void c()
    {
      this.d = -1;
      this.g = -1;
    }
    
    void d()
    {
      List localList = this.k;
      if (localList != null) {
        localList.clear();
      }
      this.j &= 0xFFFFFBFF;
    }
    
    void e()
    {
      this.j &= 0xFFFFFFDF;
    }
    
    void f()
    {
      this.j &= 0xFFFFFEFF;
    }
    
    boolean h()
    {
      return ((this.j & 0x10) == 0) && (x.R(this.a));
    }
    
    void i(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      b(8);
      A(paramInt2, paramBoolean);
      this.c = paramInt1;
    }
    
    public final int j()
    {
      RecyclerView localRecyclerView = this.r;
      if (localRecyclerView == null) {
        return -1;
      }
      return localRecyclerView.c0(this);
    }
    
    public final long k()
    {
      return this.e;
    }
    
    public final int l()
    {
      return this.f;
    }
    
    public final int m()
    {
      int i2 = this.g;
      int i1 = i2;
      if (i2 == -1) {
        i1 = this.c;
      }
      return i1;
    }
    
    public final int n()
    {
      return this.d;
    }
    
    List<Object> o()
    {
      if ((this.j & 0x400) == 0)
      {
        List localList = this.k;
        if ((localList != null) && (localList.size() != 0)) {
          return this.l;
        }
        return t;
      }
      return t;
    }
    
    boolean p(int paramInt)
    {
      return (paramInt & this.j) != 0;
    }
    
    boolean q()
    {
      return ((this.j & 0x200) != 0) || (t());
    }
    
    boolean r()
    {
      return (this.a.getParent() != null) && (this.a.getParent() != this.r);
    }
    
    boolean s()
    {
      return (this.j & 0x1) != 0;
    }
    
    boolean t()
    {
      return (this.j & 0x4) != 0;
    }
    
    public String toString()
    {
      Object localObject;
      if (getClass().isAnonymousClass()) {
        localObject = "ViewHolder";
      } else {
        localObject = getClass().getSimpleName();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("{");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      localStringBuilder.append(" position=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" id=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", oldPos=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", pLpos:");
      localStringBuilder.append(this.g);
      localStringBuilder = new StringBuilder(localStringBuilder.toString());
      if (w())
      {
        localStringBuilder.append(" scrap ");
        if (this.o) {
          localObject = "[changeScrap]";
        } else {
          localObject = "[attachedScrap]";
        }
        localStringBuilder.append((String)localObject);
      }
      if (t()) {
        localStringBuilder.append(" invalid");
      }
      if (!s()) {
        localStringBuilder.append(" unbound");
      }
      if (z()) {
        localStringBuilder.append(" update");
      }
      if (v()) {
        localStringBuilder.append(" removed");
      }
      if (J()) {
        localStringBuilder.append(" ignored");
      }
      if (x()) {
        localStringBuilder.append(" tmpDetached");
      }
      if (!u())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" not recyclable(");
        ((StringBuilder)localObject).append(this.m);
        ((StringBuilder)localObject).append(")");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      if (q()) {
        localStringBuilder.append(" undefined adapter position");
      }
      if (this.a.getParent() == null) {
        localStringBuilder.append(" no parent");
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public final boolean u()
    {
      return ((this.j & 0x10) == 0) && (!x.R(this.a));
    }
    
    boolean v()
    {
      return (this.j & 0x8) != 0;
    }
    
    boolean w()
    {
      return this.n != null;
    }
    
    boolean x()
    {
      return (this.j & 0x100) != 0;
    }
    
    boolean y()
    {
      return (this.j & 0x2) != 0;
    }
    
    boolean z()
    {
      return (this.j & 0x2) != 0;
    }
  }
  
  class d
    implements u.b
  {
    d() {}
    
    public void a(RecyclerView.c0 paramc0)
    {
      RecyclerView localRecyclerView = RecyclerView.this;
      localRecyclerView.m.m1(paramc0.a, localRecyclerView.b);
    }
    
    public void b(RecyclerView.c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2)
    {
      RecyclerView.this.m(paramc0, paramc1, paramc2);
    }
    
    public void c(RecyclerView.c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2)
    {
      RecyclerView.this.b.J(paramc0);
      RecyclerView.this.o(paramc0, paramc1, paramc2);
    }
    
    public void d(RecyclerView.c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2)
    {
      paramc0.G(false);
      Object localObject = RecyclerView.this;
      boolean bool = ((RecyclerView)localObject).F;
      localObject = ((RecyclerView)localObject).O;
      if (bool ? ((RecyclerView.m)localObject).b(paramc0, paramc0, paramc1, paramc2) : ((RecyclerView.m)localObject).d(paramc0, paramc1, paramc2)) {
        RecyclerView.this.P0();
      }
    }
  }
  
  class e
    implements b.b
  {
    e() {}
    
    public View a(int paramInt)
    {
      return RecyclerView.this.getChildAt(paramInt);
    }
    
    public void b(View paramView)
    {
      paramView = RecyclerView.h0(paramView);
      if (paramView != null) {
        paramView.B(RecyclerView.this);
      }
    }
    
    public RecyclerView.c0 c(View paramView)
    {
      return RecyclerView.h0(paramView);
    }
    
    public void d(int paramInt)
    {
      Object localObject = a(paramInt);
      if (localObject != null)
      {
        localObject = RecyclerView.h0((View)localObject);
        if (localObject != null)
        {
          if ((((RecyclerView.c0)localObject).x()) && (!((RecyclerView.c0)localObject).J()))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("called detach on an already detached child ");
            localStringBuilder.append(localObject);
            localStringBuilder.append(RecyclerView.this.Q());
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          ((RecyclerView.c0)localObject).b(256);
        }
      }
      RecyclerView.d(RecyclerView.this, paramInt);
    }
    
    public void e(View paramView)
    {
      paramView = RecyclerView.h0(paramView);
      if (paramView != null) {
        paramView.C(RecyclerView.this);
      }
    }
    
    public void f(View paramView, int paramInt)
    {
      RecyclerView.this.addView(paramView, paramInt);
      RecyclerView.this.z(paramView);
    }
    
    public int g()
    {
      return RecyclerView.this.getChildCount();
    }
    
    public void h(int paramInt)
    {
      View localView = RecyclerView.this.getChildAt(paramInt);
      if (localView != null)
      {
        RecyclerView.this.A(localView);
        localView.clearAnimation();
      }
      RecyclerView.this.removeViewAt(paramInt);
    }
    
    public void i()
    {
      int j = g();
      int i = 0;
      while (i < j)
      {
        View localView = a(i);
        RecyclerView.this.A(localView);
        localView.clearAnimation();
        i += 1;
      }
      RecyclerView.this.removeAllViews();
    }
    
    public void j(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
    {
      RecyclerView.c0 localc0 = RecyclerView.h0(paramView);
      if (localc0 != null)
      {
        if ((!localc0.x()) && (!localc0.J()))
        {
          paramView = new StringBuilder();
          paramView.append("Called attach on a child which is not detached: ");
          paramView.append(localc0);
          paramView.append(RecyclerView.this.Q());
          throw new IllegalArgumentException(paramView.toString());
        }
        localc0.f();
      }
      RecyclerView.c(RecyclerView.this, paramView, paramInt, paramLayoutParams);
    }
    
    public int k(View paramView)
    {
      return RecyclerView.this.indexOfChild(paramView);
    }
  }
  
  class f
    implements a.a
  {
    f() {}
    
    public void a(int paramInt1, int paramInt2)
    {
      RecyclerView.this.F0(paramInt1, paramInt2);
      RecyclerView.this.m0 = true;
    }
    
    public void b(a.b paramb)
    {
      i(paramb);
    }
    
    public RecyclerView.c0 c(int paramInt)
    {
      RecyclerView.c0 localc0 = RecyclerView.this.a0(paramInt, true);
      if (localc0 == null) {
        return null;
      }
      if (RecyclerView.this.e.n(localc0.a)) {
        return null;
      }
      return localc0;
    }
    
    public void d(int paramInt1, int paramInt2)
    {
      RecyclerView.this.G0(paramInt1, paramInt2, false);
      RecyclerView.this.m0 = true;
    }
    
    public void e(int paramInt1, int paramInt2)
    {
      RecyclerView.this.E0(paramInt1, paramInt2);
      RecyclerView.this.m0 = true;
    }
    
    public void f(int paramInt1, int paramInt2)
    {
      RecyclerView.this.G0(paramInt1, paramInt2, true);
      Object localObject = RecyclerView.this;
      ((RecyclerView)localObject).m0 = true;
      localObject = ((RecyclerView)localObject).j0;
      ((RecyclerView.z)localObject).d += paramInt2;
    }
    
    public void g(a.b paramb)
    {
      i(paramb);
    }
    
    public void h(int paramInt1, int paramInt2, Object paramObject)
    {
      RecyclerView.this.z1(paramInt1, paramInt2, paramObject);
      RecyclerView.this.n0 = true;
    }
    
    void i(a.b paramb)
    {
      int i = paramb.a;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 4)
          {
            if (i != 8) {
              return;
            }
            localRecyclerView = RecyclerView.this;
            localRecyclerView.m.T0(localRecyclerView, paramb.b, paramb.d, 1);
            return;
          }
          localRecyclerView = RecyclerView.this;
          localRecyclerView.m.W0(localRecyclerView, paramb.b, paramb.d, paramb.c);
          return;
        }
        localRecyclerView = RecyclerView.this;
        localRecyclerView.m.U0(localRecyclerView, paramb.b, paramb.d);
        return;
      }
      RecyclerView localRecyclerView = RecyclerView.this;
      localRecyclerView.m.R0(localRecyclerView, paramb.b, paramb.d);
    }
  }
  
  public static abstract class h<VH extends RecyclerView.c0>
  {
    private final RecyclerView.i a = new RecyclerView.i();
    private boolean b = false;
    private a c = a.a;
    
    public boolean A(VH paramVH)
    {
      return false;
    }
    
    public void B(VH paramVH) {}
    
    public void C(VH paramVH) {}
    
    public void D(VH paramVH) {}
    
    public void E(RecyclerView.j paramj)
    {
      this.a.registerObserver(paramj);
    }
    
    public void F(boolean paramBoolean)
    {
      if (!h())
      {
        this.b = paramBoolean;
        return;
      }
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    
    public void G(a parama)
    {
      this.c = parama;
      this.a.h();
    }
    
    public void H(RecyclerView.j paramj)
    {
      this.a.unregisterObserver(paramj);
    }
    
    public final void a(VH paramVH, int paramInt)
    {
      int i;
      if (paramVH.s == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramVH.c = paramInt;
        if (i()) {
          paramVH.e = e(paramInt);
        }
        paramVH.F(1, 519);
        f.a("RV OnBindView");
      }
      paramVH.s = this;
      x(paramVH, paramInt, paramVH.o());
      if (i != 0)
      {
        paramVH.d();
        paramVH = paramVH.a.getLayoutParams();
        if ((paramVH instanceof RecyclerView.LayoutParams)) {
          ((RecyclerView.LayoutParams)paramVH).c = true;
        }
        f.b();
      }
    }
    
    boolean b()
    {
      int i = RecyclerView.g.a[this.c.ordinal()];
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        bool1 = bool2;
        if (d() > 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public final VH c(ViewGroup paramViewGroup, int paramInt)
    {
      try
      {
        f.a("RV CreateView");
        paramViewGroup = y(paramViewGroup, paramInt);
        if (paramViewGroup.a.getParent() == null)
        {
          paramViewGroup.f = paramInt;
          return paramViewGroup;
        }
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      }
      finally
      {
        f.b();
      }
    }
    
    public abstract int d();
    
    public long e(int paramInt)
    {
      return -1L;
    }
    
    public int f(int paramInt)
    {
      return 0;
    }
    
    public final a g()
    {
      return this.c;
    }
    
    public final boolean h()
    {
      return this.a.a();
    }
    
    public final boolean i()
    {
      return this.b;
    }
    
    public final void j()
    {
      this.a.b();
    }
    
    public final void k(int paramInt)
    {
      this.a.d(paramInt, 1);
    }
    
    public final void p(int paramInt)
    {
      this.a.f(paramInt, 1);
    }
    
    public final void q(int paramInt1, int paramInt2)
    {
      this.a.c(paramInt1, paramInt2);
    }
    
    public final void r(int paramInt1, int paramInt2, Object paramObject)
    {
      this.a.e(paramInt1, paramInt2, paramObject);
    }
    
    public final void s(int paramInt1, int paramInt2)
    {
      this.a.f(paramInt1, paramInt2);
    }
    
    public final void t(int paramInt1, int paramInt2)
    {
      this.a.g(paramInt1, paramInt2);
    }
    
    public final void u(int paramInt)
    {
      this.a.g(paramInt, 1);
    }
    
    public void v(RecyclerView paramRecyclerView) {}
    
    public abstract void w(VH paramVH, int paramInt);
    
    public void x(VH paramVH, int paramInt, List<Object> paramList)
    {
      w(paramVH, paramInt);
    }
    
    public abstract VH y(ViewGroup paramViewGroup, int paramInt);
    
    public void z(RecyclerView paramRecyclerView) {}
    
    public static enum a
    {
      static
      {
        a locala1 = new a("ALLOW", 0);
        a = locala1;
        a locala2 = new a("PREVENT_WHEN_EMPTY", 1);
        b = locala2;
        a locala3 = new a("PREVENT", 2);
        c = locala3;
        d = new a[] { locala1, locala2, locala3 };
      }
      
      private a() {}
    }
  }
  
  static class i
    extends Observable<RecyclerView.j>
  {
    public boolean a()
    {
      return this.mObservers.isEmpty() ^ true;
    }
    
    public void b()
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.j)this.mObservers.get(i)).a();
        i -= 1;
      }
    }
    
    public void c(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.j)this.mObservers.get(i)).e(paramInt1, paramInt2, 1);
        i -= 1;
      }
    }
    
    public void d(int paramInt1, int paramInt2)
    {
      e(paramInt1, paramInt2, null);
    }
    
    public void e(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.j)this.mObservers.get(i)).c(paramInt1, paramInt2, paramObject);
        i -= 1;
      }
    }
    
    public void f(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.j)this.mObservers.get(i)).d(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public void g(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.j)this.mObservers.get(i)).f(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public void h()
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.j)this.mObservers.get(i)).g();
        i -= 1;
      }
    }
  }
  
  public static abstract class j
  {
    public void a() {}
    
    public void b(int paramInt1, int paramInt2) {}
    
    public void c(int paramInt1, int paramInt2, Object paramObject)
    {
      b(paramInt1, paramInt2);
    }
    
    public void d(int paramInt1, int paramInt2) {}
    
    public void e(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void f(int paramInt1, int paramInt2) {}
    
    public void g() {}
  }
  
  public static abstract interface k
  {
    public abstract int a(int paramInt1, int paramInt2);
  }
  
  public static class l
  {
    protected EdgeEffect a(RecyclerView paramRecyclerView, int paramInt)
    {
      return new EdgeEffect(paramRecyclerView.getContext());
    }
  }
  
  public static abstract class m
  {
    private b a = null;
    private ArrayList<a> b = new ArrayList();
    private long c = 120L;
    private long d = 120L;
    private long e = 250L;
    private long f = 250L;
    
    static int e(RecyclerView.c0 paramc0)
    {
      int j = paramc0.j & 0xE;
      if (paramc0.t()) {
        return 4;
      }
      int i = j;
      if ((j & 0x4) == 0)
      {
        int k = paramc0.n();
        int m = paramc0.j();
        i = j;
        if (k != -1)
        {
          i = j;
          if (m != -1)
          {
            i = j;
            if (k != m) {
              i = j | 0x800;
            }
          }
        }
      }
      return i;
    }
    
    public abstract boolean a(RecyclerView.c0 paramc0, c paramc1, c paramc2);
    
    public abstract boolean b(RecyclerView.c0 paramc01, RecyclerView.c0 paramc02, c paramc1, c paramc2);
    
    public abstract boolean c(RecyclerView.c0 paramc0, c paramc1, c paramc2);
    
    public abstract boolean d(RecyclerView.c0 paramc0, c paramc1, c paramc2);
    
    public abstract boolean f(RecyclerView.c0 paramc0);
    
    public boolean g(RecyclerView.c0 paramc0, List<Object> paramList)
    {
      return f(paramc0);
    }
    
    public final void h(RecyclerView.c0 paramc0)
    {
      r(paramc0);
      b localb = this.a;
      if (localb != null) {
        localb.a(paramc0);
      }
    }
    
    public final void i()
    {
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.b.get(i)).a();
        i += 1;
      }
      this.b.clear();
    }
    
    public abstract void j(RecyclerView.c0 paramc0);
    
    public abstract void k();
    
    public long l()
    {
      return this.c;
    }
    
    public long m()
    {
      return this.f;
    }
    
    public long n()
    {
      return this.e;
    }
    
    public long o()
    {
      return this.d;
    }
    
    public abstract boolean p();
    
    public c q()
    {
      return new c();
    }
    
    public void r(RecyclerView.c0 paramc0) {}
    
    public c s(RecyclerView.z paramz, RecyclerView.c0 paramc0)
    {
      return q().a(paramc0);
    }
    
    public c t(RecyclerView.z paramz, RecyclerView.c0 paramc0, int paramInt, List<Object> paramList)
    {
      return q().a(paramc0);
    }
    
    public abstract void u();
    
    void v(b paramb)
    {
      this.a = paramb;
    }
    
    public static abstract interface a
    {
      public abstract void a();
    }
    
    static abstract interface b
    {
      public abstract void a(RecyclerView.c0 paramc0);
    }
    
    public static class c
    {
      public int a;
      public int b;
      public int c;
      public int d;
      
      public c a(RecyclerView.c0 paramc0)
      {
        return b(paramc0, 0);
      }
      
      public c b(RecyclerView.c0 paramc0, int paramInt)
      {
        paramc0 = paramc0.a;
        this.a = paramc0.getLeft();
        this.b = paramc0.getTop();
        this.c = paramc0.getRight();
        this.d = paramc0.getBottom();
        return this;
      }
    }
  }
  
  private class n
    implements RecyclerView.m.b
  {
    n() {}
    
    public void a(RecyclerView.c0 paramc0)
    {
      paramc0.G(true);
      if ((paramc0.h != null) && (paramc0.i == null)) {
        paramc0.h = null;
      }
      paramc0.i = null;
      if ((!paramc0.I()) && (!RecyclerView.this.Y0(paramc0.a)) && (paramc0.x())) {
        RecyclerView.this.removeDetachedView(paramc0.a, false);
      }
    }
  }
  
  public static abstract class o
  {
    @Deprecated
    public void d(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      paramRect.set(0, 0, 0, 0);
    }
    
    public void e(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.z paramz)
    {
      d(paramRect, ((RecyclerView.LayoutParams)paramView.getLayoutParams()).a(), paramRecyclerView);
    }
    
    @Deprecated
    public void f(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
    
    public void g(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.z paramz)
    {
      f(paramCanvas, paramRecyclerView);
    }
    
    @Deprecated
    public void h(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
    
    public void i(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.z paramz)
    {
      h(paramCanvas, paramRecyclerView);
    }
  }
  
  public static abstract class p
  {
    b a;
    RecyclerView b;
    private final t.b c;
    private final t.b d;
    t e;
    t f;
    RecyclerView.y g;
    boolean h;
    boolean i;
    boolean j;
    private boolean k;
    private boolean l;
    int m;
    boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    
    public p()
    {
      a locala = new a();
      this.c = locala;
      b localb = new b();
      this.d = localb;
      this.e = new t(locala);
      this.f = new t(localb);
      this.h = false;
      this.i = false;
      this.j = false;
      this.k = true;
      this.l = true;
    }
    
    public static int K(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      paramInt1 = Math.max(0, paramInt1 - paramInt3);
      if (paramBoolean)
      {
        if (paramInt4 < 0)
        {
          if (paramInt4 != -1) {
            break label100;
          }
          if (paramInt2 == -2147483648) {
            break label59;
          }
          if (paramInt2 == 0) {
            break label100;
          }
          if (paramInt2 == 1073741824) {
            break label59;
          }
          break label100;
        }
      }
      else {
        if (paramInt4 < 0) {
          break label54;
        }
      }
      paramInt2 = 1073741824;
      break label104;
      label54:
      if (paramInt4 == -1)
      {
        label59:
        paramInt4 = paramInt1;
      }
      else if (paramInt4 == -2)
      {
        if ((paramInt2 != -2147483648) && (paramInt2 != 1073741824))
        {
          paramInt2 = 0;
          paramInt4 = paramInt1;
        }
        else
        {
          paramInt2 = -2147483648;
          paramInt4 = paramInt1;
        }
      }
      else
      {
        label100:
        paramInt2 = 0;
        paramInt4 = paramInt2;
      }
      label104:
      return View.MeasureSpec.makeMeasureSpec(paramInt4, paramInt2);
    }
    
    private int[] L(View paramView, Rect paramRect)
    {
      int i1 = e0();
      int i2 = g0();
      int i3 = o0();
      int i10 = f0();
      int i5 = W();
      int i6 = d0();
      int i11 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
      int i7 = paramView.getTop() + paramRect.top - paramView.getScrollY();
      int i12 = paramRect.width();
      int i8 = paramRect.height();
      int i9 = i11 - i1;
      i1 = Math.min(0, i9);
      int i4 = i7 - i2;
      i2 = Math.min(0, i4);
      i10 = i12 + i11 - (i3 - i10);
      i3 = Math.max(0, i10);
      i5 = Math.max(0, i8 + i7 - (i5 - i6));
      if (Z() == 1)
      {
        if (i3 != 0) {
          i1 = i3;
        } else {
          i1 = Math.max(i1, i10);
        }
      }
      else if (i1 == 0) {
        i1 = Math.min(i9, i3);
      }
      if (i2 == 0) {
        i2 = Math.min(i4, i5);
      }
      return new int[] { i1, i2 };
    }
    
    private void f(View paramView, int paramInt, boolean paramBoolean)
    {
      Object localObject = RecyclerView.h0(paramView);
      if ((!paramBoolean) && (!((RecyclerView.c0)localObject).v())) {
        this.b.f.p((RecyclerView.c0)localObject);
      } else {
        this.b.f.b((RecyclerView.c0)localObject);
      }
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!((RecyclerView.c0)localObject).L()) && (!((RecyclerView.c0)localObject).w()))
      {
        if (paramView.getParent() == this.b)
        {
          int i2 = this.a.m(paramView);
          int i1 = paramInt;
          if (paramInt == -1) {
            i1 = this.a.g();
          }
          if (i2 != -1)
          {
            if (i2 != i1) {
              this.b.m.B0(i2, i1);
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
            ((StringBuilder)localObject).append(this.b.indexOfChild(paramView));
            ((StringBuilder)localObject).append(this.b.Q());
            throw new IllegalStateException(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          this.a.a(paramView, paramInt, false);
          localLayoutParams.c = true;
          RecyclerView.y localy = this.g;
          if ((localy != null) && (localy.h())) {
            this.g.k(paramView);
          }
        }
      }
      else
      {
        if (((RecyclerView.c0)localObject).w()) {
          ((RecyclerView.c0)localObject).K();
        } else {
          ((RecyclerView.c0)localObject).e();
        }
        this.a.c(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      if (localLayoutParams.d)
      {
        ((RecyclerView.c0)localObject).a.invalidate();
        localLayoutParams.d = false;
      }
    }
    
    public static d i0(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      d locald = new d();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
      locald.a = paramContext.getInt(R.styleable.RecyclerView_android_orientation, 1);
      locald.b = paramContext.getInt(R.styleable.RecyclerView_spanCount, 1);
      locald.c = paramContext.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
      locald.d = paramContext.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
      paramContext.recycle();
      return locald;
    }
    
    public static int n(int paramInt1, int paramInt2, int paramInt3)
    {
      int i1 = View.MeasureSpec.getMode(paramInt1);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      if (i1 != -2147483648)
      {
        if (i1 != 1073741824) {
          paramInt1 = Math.max(paramInt2, paramInt3);
        }
        return paramInt1;
      }
      return Math.min(paramInt1, Math.max(paramInt2, paramInt3));
    }
    
    private boolean t0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      paramRecyclerView = paramRecyclerView.getFocusedChild();
      if (paramRecyclerView == null) {
        return false;
      }
      int i1 = e0();
      int i2 = g0();
      int i3 = o0();
      int i4 = f0();
      int i5 = W();
      int i6 = d0();
      Rect localRect = this.b.i;
      P(paramRecyclerView, localRect);
      if ((localRect.left - paramInt1 < i3 - i4) && (localRect.right - paramInt1 > i1) && (localRect.top - paramInt2 < i5 - i6)) {
        return localRect.bottom - paramInt2 > i2;
      }
      return false;
    }
    
    private void v1(RecyclerView.v paramv, int paramInt, View paramView)
    {
      RecyclerView.c0 localc0 = RecyclerView.h0(paramView);
      if (localc0.J()) {
        return;
      }
      if ((localc0.t()) && (!localc0.v()) && (!this.b.l.i()))
      {
        q1(paramInt);
        paramv.C(localc0);
        return;
      }
      x(paramInt);
      paramv.D(paramView);
      this.b.f.k(localc0);
    }
    
    private static boolean w0(int paramInt1, int paramInt2, int paramInt3)
    {
      int i1 = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      boolean bool2 = false;
      boolean bool1 = false;
      if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {
        return false;
      }
      if (i1 != -2147483648)
      {
        if (i1 != 0)
        {
          if (i1 != 1073741824) {
            return false;
          }
          if (paramInt2 == paramInt1) {
            bool1 = true;
          }
          return bool1;
        }
        return true;
      }
      bool1 = bool2;
      if (paramInt2 >= paramInt1) {
        bool1 = true;
      }
      return bool1;
    }
    
    private void y(int paramInt, View paramView)
    {
      this.a.d(paramInt);
    }
    
    void A(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      this.i = false;
      I0(paramRecyclerView, paramv);
    }
    
    public void A0(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.b.m0(paramView);
      int i3 = localRect.left;
      int i4 = localRect.right;
      int i1 = localRect.top;
      int i2 = localRect.bottom;
      paramInt1 = K(o0(), p0(), e0() + f0() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + (paramInt1 + (i3 + i4)), localLayoutParams.width, k());
      paramInt2 = K(W(), X(), g0() + d0() + localLayoutParams.topMargin + localLayoutParams.bottomMargin + (paramInt2 + (i1 + i2)), localLayoutParams.height, l());
      if (F1(paramView, paramInt1, paramInt2, localLayoutParams)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    void A1(int paramInt1, int paramInt2)
    {
      this.q = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = View.MeasureSpec.getMode(paramInt1);
      this.o = paramInt1;
      if ((paramInt1 == 0) && (!RecyclerView.F0)) {
        this.q = 0;
      }
      this.r = View.MeasureSpec.getSize(paramInt2);
      paramInt1 = View.MeasureSpec.getMode(paramInt2);
      this.p = paramInt1;
      if ((paramInt1 == 0) && (!RecyclerView.F0)) {
        this.r = 0;
      }
    }
    
    public View B(View paramView)
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView == null) {
        return null;
      }
      paramView = localRecyclerView.S(paramView);
      if (paramView == null) {
        return null;
      }
      if (this.a.n(paramView)) {
        return null;
      }
      return paramView;
    }
    
    public void B0(int paramInt1, int paramInt2)
    {
      Object localObject = I(paramInt1);
      if (localObject != null)
      {
        x(paramInt1);
        h((View)localObject, paramInt2);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot move a child from non-existing index:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(this.b.toString());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public void B1(int paramInt1, int paramInt2)
    {
      RecyclerView.f(this.b, paramInt1, paramInt2);
    }
    
    public View C(int paramInt)
    {
      int i2 = J();
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = I(i1);
        RecyclerView.c0 localc0 = RecyclerView.h0(localView);
        if ((localc0 != null) && (localc0.m() == paramInt) && (!localc0.J()) && ((this.b.j0.e()) || (!localc0.v()))) {
          return localView;
        }
        i1 += 1;
      }
      return null;
    }
    
    public void C0(int paramInt)
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView != null) {
        localRecyclerView.C0(paramInt);
      }
    }
    
    public void C1(Rect paramRect, int paramInt1, int paramInt2)
    {
      int i1 = paramRect.width();
      int i2 = e0();
      int i3 = f0();
      int i4 = paramRect.height();
      int i5 = g0();
      int i6 = d0();
      B1(n(paramInt1, i1 + i2 + i3, c0()), n(paramInt2, i4 + i5 + i6, b0()));
    }
    
    public abstract RecyclerView.LayoutParams D();
    
    public void D0(int paramInt)
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView != null) {
        localRecyclerView.D0(paramInt);
      }
    }
    
    void D1(int paramInt1, int paramInt2)
    {
      int i8 = J();
      if (i8 == 0)
      {
        this.b.x(paramInt1, paramInt2);
        return;
      }
      int i2 = 0;
      int i6 = -2147483648;
      int i5 = 2147483647;
      int i3 = i5;
      int i1 = -2147483648;
      while (i2 < i8)
      {
        View localView = I(i2);
        Rect localRect = this.b.i;
        P(localView, localRect);
        int i7 = localRect.left;
        int i4 = i5;
        if (i7 < i5) {
          i4 = i7;
        }
        i7 = localRect.right;
        i5 = i6;
        if (i7 > i6) {
          i5 = i7;
        }
        i6 = localRect.top;
        i7 = i3;
        if (i6 < i3) {
          i7 = i6;
        }
        i6 = localRect.bottom;
        i3 = i1;
        if (i6 > i1) {
          i3 = i6;
        }
        i2 += 1;
        i6 = i5;
        i1 = i3;
        i5 = i4;
        i3 = i7;
      }
      this.b.i.set(i5, i3, i6, i1);
      C1(this.b.i, paramInt1, paramInt2);
    }
    
    public RecyclerView.LayoutParams E(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }
    
    public void E0(RecyclerView.h paramh1, RecyclerView.h paramh2) {}
    
    void E1(RecyclerView paramRecyclerView)
    {
      int i1;
      if (paramRecyclerView == null)
      {
        this.b = null;
        this.a = null;
        i1 = 0;
        this.q = 0;
      }
      else
      {
        this.b = paramRecyclerView;
        this.a = paramRecyclerView.e;
        this.q = paramRecyclerView.getWidth();
        i1 = paramRecyclerView.getHeight();
      }
      this.r = i1;
      this.o = 1073741824;
      this.p = 1073741824;
    }
    
    public RecyclerView.LayoutParams F(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
        return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new RecyclerView.LayoutParams(paramLayoutParams);
    }
    
    public boolean F0(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
    {
      return false;
    }
    
    boolean F1(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!this.k) || (!w0(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!w0(paramView.getHeight(), paramInt2, paramLayoutParams.height));
    }
    
    public int G()
    {
      return -1;
    }
    
    public void G0(RecyclerView paramRecyclerView) {}
    
    boolean G1()
    {
      return false;
    }
    
    public int H(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).b.bottom;
    }
    
    @Deprecated
    public void H0(RecyclerView paramRecyclerView) {}
    
    boolean H1(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (!this.k) || (!w0(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) || (!w0(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height));
    }
    
    public View I(int paramInt)
    {
      b localb = this.a;
      if (localb != null) {
        return localb.f(paramInt);
      }
      return null;
    }
    
    public void I0(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      H0(paramRecyclerView);
    }
    
    public void I1(RecyclerView paramRecyclerView, RecyclerView.z paramz, int paramInt)
    {
      Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }
    
    public int J()
    {
      b localb = this.a;
      if (localb != null) {
        return localb.g();
      }
      return 0;
    }
    
    public View J0(View paramView, int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
    {
      return null;
    }
    
    public void J1(RecyclerView.y paramy)
    {
      RecyclerView.y localy = this.g;
      if ((localy != null) && (paramy != localy) && (localy.h())) {
        this.g.r();
      }
      this.g = paramy;
      paramy.q(this.b, this);
    }
    
    public void K0(AccessibilityEvent paramAccessibilityEvent)
    {
      RecyclerView localRecyclerView = this.b;
      L0(localRecyclerView.b, localRecyclerView.j0, paramAccessibilityEvent);
    }
    
    void K1()
    {
      RecyclerView.y localy = this.g;
      if (localy != null) {
        localy.r();
      }
    }
    
    public void L0(RecyclerView.v paramv, RecyclerView.z paramz, AccessibilityEvent paramAccessibilityEvent)
    {
      paramv = this.b;
      if (paramv != null)
      {
        if (paramAccessibilityEvent == null) {
          return;
        }
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (!paramv.canScrollVertically(1))
        {
          bool1 = bool2;
          if (!this.b.canScrollVertically(-1))
          {
            bool1 = bool2;
            if (!this.b.canScrollHorizontally(-1)) {
              if (this.b.canScrollHorizontally(1)) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
          }
        }
        paramAccessibilityEvent.setScrollable(bool1);
        paramv = this.b.l;
        if (paramv != null) {
          paramAccessibilityEvent.setItemCount(paramv.d());
        }
      }
    }
    
    public boolean L1()
    {
      return false;
    }
    
    public boolean M()
    {
      RecyclerView localRecyclerView = this.b;
      return (localRecyclerView != null) && (localRecyclerView.g);
    }
    
    public void M0(RecyclerView.v paramv, RecyclerView.z paramz, d paramd)
    {
      if ((this.b.canScrollVertically(-1)) || (this.b.canScrollHorizontally(-1)))
      {
        paramd.a(8192);
        paramd.z0(true);
      }
      if ((this.b.canScrollVertically(1)) || (this.b.canScrollHorizontally(1)))
      {
        paramd.a(4096);
        paramd.z0(true);
      }
      paramd.e0(d.b.b(k0(paramv, paramz), N(paramv, paramz), v0(paramv, paramz), l0(paramv, paramz)));
    }
    
    public int N(RecyclerView.v paramv, RecyclerView.z paramz)
    {
      return -1;
    }
    
    void N0(d paramd)
    {
      RecyclerView localRecyclerView = this.b;
      M0(localRecyclerView.b, localRecyclerView.j0, paramd);
    }
    
    public int O(View paramView)
    {
      return paramView.getBottom() + H(paramView);
    }
    
    void O0(View paramView, d paramd)
    {
      Object localObject = RecyclerView.h0(paramView);
      if ((localObject != null) && (!((RecyclerView.c0)localObject).v()) && (!this.a.n(((RecyclerView.c0)localObject).a)))
      {
        localObject = this.b;
        P0(((RecyclerView)localObject).b, ((RecyclerView)localObject).j0, paramView, paramd);
      }
    }
    
    public void P(View paramView, Rect paramRect)
    {
      RecyclerView.j0(paramView, paramRect);
    }
    
    public void P0(RecyclerView.v paramv, RecyclerView.z paramz, View paramView, d paramd) {}
    
    public int Q(View paramView)
    {
      return paramView.getLeft() - a0(paramView);
    }
    
    public View Q0(View paramView, int paramInt)
    {
      return null;
    }
    
    public int R(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).b;
      return paramView.getMeasuredHeight() + localRect.top + localRect.bottom;
    }
    
    public void R0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public int S(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).b;
      return paramView.getMeasuredWidth() + localRect.left + localRect.right;
    }
    
    public void S0(RecyclerView paramRecyclerView) {}
    
    public int T(View paramView)
    {
      return paramView.getRight() + j0(paramView);
    }
    
    public void T0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public int U(View paramView)
    {
      return paramView.getTop() - m0(paramView);
    }
    
    public void U0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public View V()
    {
      Object localObject = this.b;
      if (localObject == null) {
        return null;
      }
      localObject = ((ViewGroup)localObject).getFocusedChild();
      if (localObject != null)
      {
        if (this.a.n((View)localObject)) {
          return null;
        }
        return localObject;
      }
      return null;
    }
    
    public void V0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public int W()
    {
      return this.r;
    }
    
    public void W0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
    {
      V0(paramRecyclerView, paramInt1, paramInt2);
    }
    
    public int X()
    {
      return this.p;
    }
    
    public void X0(RecyclerView.v paramv, RecyclerView.z paramz)
    {
      Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }
    
    public int Y()
    {
      Object localObject = this.b;
      if (localObject != null) {
        localObject = ((RecyclerView)localObject).getAdapter();
      } else {
        localObject = null;
      }
      if (localObject != null) {
        return ((RecyclerView.h)localObject).d();
      }
      return 0;
    }
    
    public void Y0(RecyclerView.z paramz) {}
    
    public int Z()
    {
      return x.B(this.b);
    }
    
    public void Z0(RecyclerView.v paramv, RecyclerView.z paramz, int paramInt1, int paramInt2)
    {
      this.b.x(paramInt1, paramInt2);
    }
    
    public int a0(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).b.left;
    }
    
    @Deprecated
    public boolean a1(RecyclerView paramRecyclerView, View paramView1, View paramView2)
    {
      return (x0()) || (paramRecyclerView.w0());
    }
    
    public void b(View paramView)
    {
      c(paramView, -1);
    }
    
    public int b0()
    {
      return x.C(this.b);
    }
    
    public boolean b1(RecyclerView paramRecyclerView, RecyclerView.z paramz, View paramView1, View paramView2)
    {
      return a1(paramRecyclerView, paramView1, paramView2);
    }
    
    public void c(View paramView, int paramInt)
    {
      f(paramView, paramInt, true);
    }
    
    public int c0()
    {
      return x.D(this.b);
    }
    
    public void c1(Parcelable paramParcelable) {}
    
    public void d(View paramView)
    {
      e(paramView, -1);
    }
    
    public int d0()
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView != null) {
        return localRecyclerView.getPaddingBottom();
      }
      return 0;
    }
    
    public Parcelable d1()
    {
      return null;
    }
    
    public void e(View paramView, int paramInt)
    {
      f(paramView, paramInt, false);
    }
    
    public int e0()
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView != null) {
        return localRecyclerView.getPaddingLeft();
      }
      return 0;
    }
    
    public void e1(int paramInt) {}
    
    public int f0()
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView != null) {
        return localRecyclerView.getPaddingRight();
      }
      return 0;
    }
    
    void f1(RecyclerView.y paramy)
    {
      if (this.g == paramy) {
        this.g = null;
      }
    }
    
    public void g(String paramString)
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView != null) {
        localRecyclerView.p(paramString);
      }
    }
    
    public int g0()
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView != null) {
        return localRecyclerView.getPaddingTop();
      }
      return 0;
    }
    
    boolean g1(int paramInt, Bundle paramBundle)
    {
      RecyclerView localRecyclerView = this.b;
      return h1(localRecyclerView.b, localRecyclerView.j0, paramInt, paramBundle);
    }
    
    public void h(View paramView, int paramInt)
    {
      i(paramView, paramInt, (RecyclerView.LayoutParams)paramView.getLayoutParams());
    }
    
    public int h0(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).a();
    }
    
    public boolean h1(RecyclerView.v paramv, RecyclerView.z paramz, int paramInt, Bundle paramBundle)
    {
      paramv = this.b;
      if (paramv == null) {
        return false;
      }
      if (paramInt != 4096)
      {
        if (paramInt != 8192)
        {
          paramInt = 0;
          i1 = paramInt;
          break label169;
        }
        if (paramv.canScrollVertically(-1)) {
          paramInt = -(W() - g0() - d0());
        } else {
          paramInt = 0;
        }
        i1 = paramInt;
        if (!this.b.canScrollHorizontally(-1)) {
          break label167;
        }
        i1 = -(o0() - e0() - f0());
      }
      else
      {
        if (paramv.canScrollVertically(1)) {
          paramInt = W() - g0() - d0();
        } else {
          paramInt = 0;
        }
        i1 = paramInt;
        if (!this.b.canScrollHorizontally(1)) {
          break label167;
        }
        i1 = o0() - e0() - f0();
      }
      int i2 = paramInt;
      paramInt = i1;
      int i1 = i2;
      break label169;
      label167:
      paramInt = 0;
      label169:
      if ((i1 == 0) && (paramInt == 0)) {
        return false;
      }
      this.b.r1(paramInt, i1, null, -2147483648, true);
      return true;
    }
    
    public void i(View paramView, int paramInt, RecyclerView.LayoutParams paramLayoutParams)
    {
      RecyclerView.c0 localc0 = RecyclerView.h0(paramView);
      if (localc0.v()) {
        this.b.f.b(localc0);
      } else {
        this.b.f.p(localc0);
      }
      this.a.c(paramView, paramInt, paramLayoutParams, localc0.v());
    }
    
    boolean i1(View paramView, int paramInt, Bundle paramBundle)
    {
      RecyclerView localRecyclerView = this.b;
      return j1(localRecyclerView.b, localRecyclerView.j0, paramView, paramInt, paramBundle);
    }
    
    public void j(View paramView, Rect paramRect)
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(localRecyclerView.m0(paramView));
    }
    
    public int j0(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).b.right;
    }
    
    public boolean j1(RecyclerView.v paramv, RecyclerView.z paramz, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public boolean k()
    {
      return false;
    }
    
    public int k0(RecyclerView.v paramv, RecyclerView.z paramz)
    {
      return -1;
    }
    
    public void k1(RecyclerView.v paramv)
    {
      int i1 = J() - 1;
      while (i1 >= 0)
      {
        if (!RecyclerView.h0(I(i1)).J()) {
          n1(i1, paramv);
        }
        i1 -= 1;
      }
    }
    
    public boolean l()
    {
      return false;
    }
    
    public int l0(RecyclerView.v paramv, RecyclerView.z paramz)
    {
      return 0;
    }
    
    void l1(RecyclerView.v paramv)
    {
      int i2 = paramv.j();
      int i1 = i2 - 1;
      while (i1 >= 0)
      {
        View localView = paramv.n(i1);
        RecyclerView.c0 localc0 = RecyclerView.h0(localView);
        if (!localc0.J())
        {
          localc0.G(false);
          if (localc0.x()) {
            this.b.removeDetachedView(localView, false);
          }
          RecyclerView.m localm = this.b.O;
          if (localm != null) {
            localm.j(localc0);
          }
          localc0.G(true);
          paramv.y(localView);
        }
        i1 -= 1;
      }
      paramv.e();
      if (i2 > 0) {
        this.b.invalidate();
      }
    }
    
    public boolean m(RecyclerView.LayoutParams paramLayoutParams)
    {
      return paramLayoutParams != null;
    }
    
    public int m0(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).b.top;
    }
    
    public void m1(View paramView, RecyclerView.v paramv)
    {
      p1(paramView);
      paramv.B(paramView);
    }
    
    public void n0(View paramView, boolean paramBoolean, Rect paramRect)
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).b;
        paramRect.set(-((Rect)localObject).left, -((Rect)localObject).top, paramView.getWidth() + ((Rect)localObject).right, paramView.getHeight() + ((Rect)localObject).bottom);
      }
      else
      {
        paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
      }
      if (this.b != null)
      {
        localObject = paramView.getMatrix();
        if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
        {
          RectF localRectF = this.b.k;
          localRectF.set(paramRect);
          ((Matrix)localObject).mapRect(localRectF);
          paramRect.set((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
        }
      }
      paramRect.offset(paramView.getLeft(), paramView.getTop());
    }
    
    public void n1(int paramInt, RecyclerView.v paramv)
    {
      View localView = I(paramInt);
      q1(paramInt);
      paramv.B(localView);
    }
    
    public void o(int paramInt1, int paramInt2, RecyclerView.z paramz, c paramc) {}
    
    public int o0()
    {
      return this.q;
    }
    
    public boolean o1(Runnable paramRunnable)
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView != null) {
        return localRecyclerView.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public void p(int paramInt, c paramc) {}
    
    public int p0()
    {
      return this.o;
    }
    
    public void p1(View paramView)
    {
      this.a.p(paramView);
    }
    
    public int q(RecyclerView.z paramz)
    {
      return 0;
    }
    
    boolean q0()
    {
      int i2 = J();
      int i1 = 0;
      while (i1 < i2)
      {
        ViewGroup.LayoutParams localLayoutParams = I(i1).getLayoutParams();
        if ((localLayoutParams.width < 0) && (localLayoutParams.height < 0)) {
          return true;
        }
        i1 += 1;
      }
      return false;
    }
    
    public void q1(int paramInt)
    {
      if (I(paramInt) != null) {
        this.a.q(paramInt);
      }
    }
    
    public int r(RecyclerView.z paramz)
    {
      return 0;
    }
    
    public boolean r0()
    {
      return this.i;
    }
    
    public boolean r1(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      return s1(paramRecyclerView, paramView, paramRect, paramBoolean, false);
    }
    
    public int s(RecyclerView.z paramz)
    {
      return 0;
    }
    
    public boolean s0()
    {
      return this.j;
    }
    
    public boolean s1(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramView = L(paramView, paramRect);
      int i1 = paramView[0];
      int i2 = paramView[1];
      if (((paramBoolean2) && (!t0(paramRecyclerView, i1, i2))) || ((i1 == 0) && (i2 == 0))) {
        return false;
      }
      if (paramBoolean1)
      {
        paramRecyclerView.scrollBy(i1, i2);
        return true;
      }
      paramRecyclerView.o1(i1, i2);
      return true;
    }
    
    public int t(RecyclerView.z paramz)
    {
      return 0;
    }
    
    public void t1()
    {
      RecyclerView localRecyclerView = this.b;
      if (localRecyclerView != null) {
        localRecyclerView.requestLayout();
      }
    }
    
    public int u(RecyclerView.z paramz)
    {
      return 0;
    }
    
    public final boolean u0()
    {
      return this.l;
    }
    
    public void u1()
    {
      this.h = true;
    }
    
    public int v(RecyclerView.z paramz)
    {
      return 0;
    }
    
    public boolean v0(RecyclerView.v paramv, RecyclerView.z paramz)
    {
      return false;
    }
    
    public void w(RecyclerView.v paramv)
    {
      int i1 = J() - 1;
      while (i1 >= 0)
      {
        v1(paramv, i1, I(i1));
        i1 -= 1;
      }
    }
    
    public int w1(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
    {
      return 0;
    }
    
    public void x(int paramInt)
    {
      y(paramInt, I(paramInt));
    }
    
    public boolean x0()
    {
      RecyclerView.y localy = this.g;
      return (localy != null) && (localy.h());
    }
    
    public void x1(int paramInt) {}
    
    public boolean y0(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.e.b(paramView, 24579)) && (this.f.b(paramView, 24579))) {
        paramBoolean2 = true;
      } else {
        paramBoolean2 = false;
      }
      if (paramBoolean1) {
        return paramBoolean2;
      }
      return paramBoolean2 ^ true;
    }
    
    public int y1(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
    {
      return 0;
    }
    
    void z(RecyclerView paramRecyclerView)
    {
      this.i = true;
      G0(paramRecyclerView);
    }
    
    public void z0(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.b;
      paramView.layout(paramInt1 + localRect.left + localLayoutParams.leftMargin, paramInt2 + localRect.top + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
    }
    
    void z1(RecyclerView paramRecyclerView)
    {
      A1(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
    
    class a
      implements t.b
    {
      a() {}
      
      public View a(int paramInt)
      {
        return RecyclerView.p.this.I(paramInt);
      }
      
      public int b()
      {
        return RecyclerView.p.this.o0() - RecyclerView.p.this.f0();
      }
      
      public int c(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return RecyclerView.p.this.Q(paramView) - localLayoutParams.leftMargin;
      }
      
      public int d()
      {
        return RecyclerView.p.this.e0();
      }
      
      public int e(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return RecyclerView.p.this.T(paramView) + localLayoutParams.rightMargin;
      }
    }
    
    class b
      implements t.b
    {
      b() {}
      
      public View a(int paramInt)
      {
        return RecyclerView.p.this.I(paramInt);
      }
      
      public int b()
      {
        return RecyclerView.p.this.W() - RecyclerView.p.this.d0();
      }
      
      public int c(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return RecyclerView.p.this.U(paramView) - localLayoutParams.topMargin;
      }
      
      public int d()
      {
        return RecyclerView.p.this.g0();
      }
      
      public int e(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return RecyclerView.p.this.O(paramView) + localLayoutParams.bottomMargin;
      }
    }
    
    public static abstract interface c
    {
      public abstract void a(int paramInt1, int paramInt2);
    }
    
    public static class d
    {
      public int a;
      public int b;
      public boolean c;
      public boolean d;
    }
  }
  
  public static abstract interface q
  {
    public abstract void a(View paramView);
    
    public abstract void b(View paramView);
  }
  
  public static abstract class r
  {
    public abstract boolean a(int paramInt1, int paramInt2);
  }
  
  public static abstract interface s
  {
    public abstract boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
    
    public abstract void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
    
    public abstract void c(boolean paramBoolean);
  }
  
  public static abstract class t
  {
    public void a(RecyclerView paramRecyclerView, int paramInt) {}
    
    public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  }
  
  public static class u
  {
    SparseArray<a> a = new SparseArray();
    private int b = 0;
    
    private a g(int paramInt)
    {
      a locala2 = (a)this.a.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        this.a.put(paramInt, locala1);
      }
      return locala1;
    }
    
    void a()
    {
      this.b += 1;
    }
    
    public void b()
    {
      int i = 0;
      while (i < this.a.size())
      {
        ((a)this.a.valueAt(i)).a.clear();
        i += 1;
      }
    }
    
    void c()
    {
      this.b -= 1;
    }
    
    void d(int paramInt, long paramLong)
    {
      a locala = g(paramInt);
      locala.d = j(locala.d, paramLong);
    }
    
    void e(int paramInt, long paramLong)
    {
      a locala = g(paramInt);
      locala.c = j(locala.c, paramLong);
    }
    
    public RecyclerView.c0 f(int paramInt)
    {
      Object localObject = (a)this.a.get(paramInt);
      if ((localObject != null) && (!((a)localObject).a.isEmpty()))
      {
        localObject = ((a)localObject).a;
        paramInt = ((ArrayList)localObject).size() - 1;
        while (paramInt >= 0)
        {
          if (!((RecyclerView.c0)((ArrayList)localObject).get(paramInt)).r()) {
            return (RecyclerView.c0)((ArrayList)localObject).remove(paramInt);
          }
          paramInt -= 1;
        }
      }
      return null;
    }
    
    void h(RecyclerView.h paramh1, RecyclerView.h paramh2, boolean paramBoolean)
    {
      if (paramh1 != null) {
        c();
      }
      if ((!paramBoolean) && (this.b == 0)) {
        b();
      }
      if (paramh2 != null) {
        a();
      }
    }
    
    public void i(RecyclerView.c0 paramc0)
    {
      int i = paramc0.l();
      ArrayList localArrayList = g(i).a;
      if (((a)this.a.get(i)).b <= localArrayList.size()) {
        return;
      }
      paramc0.D();
      localArrayList.add(paramc0);
    }
    
    long j(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L) {
        return paramLong2;
      }
      return paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    
    boolean k(int paramInt, long paramLong1, long paramLong2)
    {
      long l = g(paramInt).d;
      return (l == 0L) || (paramLong1 + l < paramLong2);
    }
    
    boolean l(int paramInt, long paramLong1, long paramLong2)
    {
      long l = g(paramInt).c;
      return (l == 0L) || (paramLong1 + l < paramLong2);
    }
    
    static class a
    {
      final ArrayList<RecyclerView.c0> a = new ArrayList();
      int b = 5;
      long c = 0L;
      long d = 0L;
    }
  }
  
  public final class v
  {
    final ArrayList<RecyclerView.c0> a;
    ArrayList<RecyclerView.c0> b;
    final ArrayList<RecyclerView.c0> c;
    private final List<RecyclerView.c0> d;
    private int e;
    int f;
    RecyclerView.u g;
    
    public v()
    {
      this$1 = new ArrayList();
      this.a = RecyclerView.this;
      this.b = null;
      this.c = new ArrayList();
      this.d = Collections.unmodifiableList(RecyclerView.this);
      this.e = 2;
      this.f = 2;
    }
    
    private boolean H(RecyclerView.c0 paramc0, int paramInt1, int paramInt2, long paramLong)
    {
      paramc0.s = null;
      paramc0.r = RecyclerView.this;
      int i = paramc0.l();
      long l = RecyclerView.this.getNanoTime();
      if ((paramLong != 9223372036854775807L) && (!this.g.k(i, l, paramLong))) {
        return false;
      }
      RecyclerView.this.l.a(paramc0, paramInt1);
      paramLong = RecyclerView.this.getNanoTime();
      this.g.d(paramc0.l(), paramLong - l);
      b(paramc0);
      if (RecyclerView.this.j0.e()) {
        paramc0.g = paramInt2;
      }
      return true;
    }
    
    private void b(RecyclerView.c0 paramc0)
    {
      if (RecyclerView.this.v0())
      {
        paramc0 = paramc0.a;
        if (x.z(paramc0) == 0) {
          x.B0(paramc0, 1);
        }
        Object localObject = RecyclerView.this.q0;
        if (localObject == null) {
          return;
        }
        localObject = ((o)localObject).n();
        if ((localObject instanceof o.a)) {
          ((o.a)localObject).o(paramc0);
        }
        x.q0(paramc0, (androidx.core.view.a)localObject);
      }
    }
    
    private void q(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      int i = paramViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          q((ViewGroup)localView, true);
        }
        i -= 1;
      }
      if (!paramBoolean) {
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        return;
      }
      i = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(i);
    }
    
    private void r(RecyclerView.c0 paramc0)
    {
      paramc0 = paramc0.a;
      if ((paramc0 instanceof ViewGroup)) {
        q((ViewGroup)paramc0, false);
      }
    }
    
    void A(int paramInt)
    {
      a((RecyclerView.c0)this.c.get(paramInt), true);
      this.c.remove(paramInt);
    }
    
    public void B(View paramView)
    {
      RecyclerView.c0 localc0 = RecyclerView.h0(paramView);
      if (localc0.x()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localc0.w()) {
        localc0.K();
      } else if (localc0.L()) {
        localc0.e();
      }
      C(localc0);
      if ((RecyclerView.this.O != null) && (!localc0.u())) {
        RecyclerView.this.O.j(localc0);
      }
    }
    
    void C(RecyclerView.c0 paramc0)
    {
      boolean bool2 = paramc0.w();
      boolean bool1 = false;
      int j = 0;
      int k = 1;
      if ((!bool2) && (paramc0.a.getParent() == null))
      {
        if (!paramc0.x())
        {
          if (!paramc0.J())
          {
            bool1 = paramc0.h();
            localObject = RecyclerView.this.l;
            int i;
            if ((localObject != null) && (bool1) && (((RecyclerView.h)localObject).A(paramc0))) {
              i = 1;
            } else {
              i = 0;
            }
            if ((i == 0) && (!paramc0.u()))
            {
              k = 0;
              i = j;
              j = k;
            }
            else
            {
              if ((this.f > 0) && (!paramc0.p(526)))
              {
                j = this.c.size();
                i = j;
                if (j >= this.f)
                {
                  i = j;
                  if (j > 0)
                  {
                    A(0);
                    i = j - 1;
                  }
                }
                j = i;
                if (RecyclerView.H0)
                {
                  j = i;
                  if (i > 0)
                  {
                    j = i;
                    if (!RecyclerView.this.i0.d(paramc0.c))
                    {
                      i -= 1;
                      while (i >= 0)
                      {
                        j = ((RecyclerView.c0)this.c.get(i)).c;
                        if (!RecyclerView.this.i0.d(j)) {
                          break;
                        }
                        i -= 1;
                      }
                      j = i + 1;
                    }
                  }
                }
                this.c.add(j, paramc0);
                i = 1;
              }
              else
              {
                i = 0;
              }
              if (i == 0)
              {
                a(paramc0, true);
                j = k;
              }
              else
              {
                j = 0;
              }
            }
            RecyclerView.this.f.q(paramc0);
            if ((i == 0) && (j == 0) && (bool1))
            {
              paramc0.s = null;
              paramc0.r = null;
            }
            return;
          }
          paramc0 = new StringBuilder();
          paramc0.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
          paramc0.append(RecyclerView.this.Q());
          throw new IllegalArgumentException(paramc0.toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
        ((StringBuilder)localObject).append(paramc0);
        ((StringBuilder)localObject).append(RecyclerView.this.Q());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Scrapped or attached views may not be recycled. isScrap:");
      ((StringBuilder)localObject).append(paramc0.w());
      ((StringBuilder)localObject).append(" isAttached:");
      if (paramc0.a.getParent() != null) {
        bool1 = true;
      }
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(RecyclerView.this.Q());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    void D(View paramView)
    {
      RecyclerView.c0 localc0 = RecyclerView.h0(paramView);
      if ((!localc0.p(12)) && (localc0.y()) && (!RecyclerView.this.q(localc0)))
      {
        if (this.b == null) {
          this.b = new ArrayList();
        }
        localc0.H(this, true);
        paramView = this.b;
      }
      else
      {
        if ((localc0.t()) && (!localc0.v()) && (!RecyclerView.this.l.i()))
        {
          paramView = new StringBuilder();
          paramView.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
          paramView.append(RecyclerView.this.Q());
          throw new IllegalArgumentException(paramView.toString());
        }
        localc0.H(this, false);
        paramView = this.a;
      }
      paramView.add(localc0);
    }
    
    void E(RecyclerView.u paramu)
    {
      RecyclerView.u localu = this.g;
      if (localu != null) {
        localu.c();
      }
      this.g = paramu;
      if ((paramu != null) && (RecyclerView.this.getAdapter() != null)) {
        this.g.a();
      }
    }
    
    void F(RecyclerView.a0 parama0) {}
    
    public void G(int paramInt)
    {
      this.e = paramInt;
      K();
    }
    
    RecyclerView.c0 I(int paramInt, boolean paramBoolean, long paramLong)
    {
      if ((paramInt >= 0) && (paramInt < RecyclerView.this.j0.b()))
      {
        boolean bool2 = RecyclerView.this.j0.e();
        boolean bool1 = true;
        if (bool2)
        {
          localObject2 = h(paramInt);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            j = 1;
            break label70;
          }
        }
        else
        {
          localObject1 = null;
        }
        int j = 0;
        Object localObject2 = localObject1;
        label70:
        localObject1 = localObject2;
        int i = j;
        if (localObject2 == null)
        {
          localObject2 = m(paramInt, paramBoolean);
          localObject1 = localObject2;
          i = j;
          if (localObject2 != null) {
            if (!L((RecyclerView.c0)localObject2))
            {
              if (!paramBoolean)
              {
                ((RecyclerView.c0)localObject2).b(4);
                if (((RecyclerView.c0)localObject2).w())
                {
                  RecyclerView.this.removeDetachedView(((RecyclerView.c0)localObject2).a, false);
                  ((RecyclerView.c0)localObject2).K();
                }
                else if (((RecyclerView.c0)localObject2).L())
                {
                  ((RecyclerView.c0)localObject2).e();
                }
                C((RecyclerView.c0)localObject2);
              }
              localObject1 = null;
              i = j;
            }
            else
            {
              i = 1;
              localObject1 = localObject2;
            }
          }
        }
        Object localObject3 = localObject1;
        int k = i;
        if (localObject1 == null)
        {
          k = RecyclerView.this.d.m(paramInt);
          if ((k >= 0) && (k < RecyclerView.this.l.d()))
          {
            int m = RecyclerView.this.l.f(k);
            j = i;
            if (RecyclerView.this.l.i())
            {
              localObject2 = l(RecyclerView.this.l.e(k), m, paramBoolean);
              localObject1 = localObject2;
              j = i;
              if (localObject2 != null)
              {
                ((RecyclerView.c0)localObject2).c = k;
                j = 1;
                localObject1 = localObject2;
              }
            }
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = i().f(m);
              if (localObject2 != null)
              {
                ((RecyclerView.c0)localObject2).D();
                if (RecyclerView.E0) {
                  r((RecyclerView.c0)localObject2);
                }
              }
            }
            localObject3 = localObject2;
            k = j;
            if (localObject2 == null)
            {
              long l1 = RecyclerView.this.getNanoTime();
              if ((paramLong != 9223372036854775807L) && (!this.g.l(m, l1, paramLong))) {
                return null;
              }
              localObject1 = RecyclerView.this;
              localObject1 = ((RecyclerView)localObject1).l.c((ViewGroup)localObject1, m);
              if (RecyclerView.H0)
              {
                localObject2 = RecyclerView.W(((RecyclerView.c0)localObject1).a);
                if (localObject2 != null) {
                  ((RecyclerView.c0)localObject1).b = new WeakReference(localObject2);
                }
              }
              long l2 = RecyclerView.this.getNanoTime();
              this.g.e(m, l2 - l1);
              break label584;
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Inconsistency detected. Invalid item position ");
            ((StringBuilder)localObject1).append(paramInt);
            ((StringBuilder)localObject1).append("(offset:");
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append(").state:");
            ((StringBuilder)localObject1).append(RecyclerView.this.j0.b());
            ((StringBuilder)localObject1).append(RecyclerView.this.Q());
            throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
          }
        }
        localObject1 = localObject3;
        j = k;
        label584:
        if ((j != 0) && (!RecyclerView.this.j0.e()) && (((RecyclerView.c0)localObject1).p(8192)))
        {
          ((RecyclerView.c0)localObject1).F(0, 8192);
          if (RecyclerView.this.j0.k)
          {
            i = RecyclerView.m.e((RecyclerView.c0)localObject1);
            localObject2 = RecyclerView.this;
            localObject2 = ((RecyclerView)localObject2).O.t(((RecyclerView)localObject2).j0, (RecyclerView.c0)localObject1, i | 0x1000, ((RecyclerView.c0)localObject1).o());
            RecyclerView.this.U0((RecyclerView.c0)localObject1, (RecyclerView.m.c)localObject2);
          }
        }
        if ((RecyclerView.this.j0.e()) && (((RecyclerView.c0)localObject1).s())) {
          ((RecyclerView.c0)localObject1).g = paramInt;
        } else {
          if ((!((RecyclerView.c0)localObject1).s()) || (((RecyclerView.c0)localObject1).z()) || (((RecyclerView.c0)localObject1).t())) {
            break label749;
          }
        }
        paramBoolean = false;
        break label769;
        label749:
        paramBoolean = H((RecyclerView.c0)localObject1, RecyclerView.this.d.m(paramInt), paramInt, paramLong);
        label769:
        localObject2 = ((RecyclerView.c0)localObject1).a.getLayoutParams();
        if (localObject2 == null) {}
        for (localObject2 = RecyclerView.this.generateDefaultLayoutParams();; localObject2 = RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject2))
        {
          localObject2 = (RecyclerView.LayoutParams)localObject2;
          ((RecyclerView.c0)localObject1).a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break label846;
          if (RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject2)) {
            break;
          }
        }
        localObject2 = (RecyclerView.LayoutParams)localObject2;
        label846:
        ((RecyclerView.LayoutParams)localObject2).a = ((RecyclerView.c0)localObject1);
        if ((j != 0) && (paramBoolean)) {
          paramBoolean = bool1;
        } else {
          paramBoolean = false;
        }
        ((RecyclerView.LayoutParams)localObject2).d = paramBoolean;
        return localObject1;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid item position ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("). Item count:");
      ((StringBuilder)localObject1).append(RecyclerView.this.j0.b());
      ((StringBuilder)localObject1).append(RecyclerView.this.Q());
      throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
    }
    
    void J(RecyclerView.c0 paramc0)
    {
      ArrayList localArrayList;
      if (paramc0.o) {
        localArrayList = this.b;
      } else {
        localArrayList = this.a;
      }
      localArrayList.remove(paramc0);
      paramc0.n = null;
      paramc0.o = false;
      paramc0.e();
    }
    
    void K()
    {
      RecyclerView.p localp = RecyclerView.this.m;
      if (localp != null) {
        i = localp.m;
      } else {
        i = 0;
      }
      this.f = (this.e + i);
      int i = this.c.size() - 1;
      while ((i >= 0) && (this.c.size() > this.f))
      {
        A(i);
        i -= 1;
      }
    }
    
    boolean L(RecyclerView.c0 paramc0)
    {
      if (paramc0.v()) {
        return RecyclerView.this.j0.e();
      }
      int i = paramc0.c;
      if ((i >= 0) && (i < RecyclerView.this.l.d()))
      {
        boolean bool2 = RecyclerView.this.j0.e();
        boolean bool1 = false;
        if ((!bool2) && (RecyclerView.this.l.f(paramc0.c) != paramc0.l())) {
          return false;
        }
        if (RecyclerView.this.l.i())
        {
          if (paramc0.k() == RecyclerView.this.l.e(paramc0.c)) {
            bool1 = true;
          }
          return bool1;
        }
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
      localStringBuilder.append(paramc0);
      localStringBuilder.append(RecyclerView.this.Q());
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    void M(int paramInt1, int paramInt2)
    {
      int i = this.c.size() - 1;
      while (i >= 0)
      {
        RecyclerView.c0 localc0 = (RecyclerView.c0)this.c.get(i);
        if (localc0 != null)
        {
          int j = localc0.c;
          if ((j >= paramInt1) && (j < paramInt2 + paramInt1))
          {
            localc0.b(2);
            A(i);
          }
        }
        i -= 1;
      }
    }
    
    void a(RecyclerView.c0 paramc0, boolean paramBoolean)
    {
      RecyclerView.s(paramc0);
      View localView = paramc0.a;
      Object localObject = RecyclerView.this.q0;
      if (localObject != null)
      {
        localObject = ((o)localObject).n();
        if ((localObject instanceof o.a)) {
          localObject = ((o.a)localObject).n(localView);
        } else {
          localObject = null;
        }
        x.q0(localView, (androidx.core.view.a)localObject);
      }
      if (paramBoolean) {
        g(paramc0);
      }
      paramc0.s = null;
      paramc0.r = null;
      i().i(paramc0);
    }
    
    public void c()
    {
      this.a.clear();
      z();
    }
    
    void d()
    {
      int k = this.c.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        ((RecyclerView.c0)this.c.get(i)).c();
        i += 1;
      }
      k = this.a.size();
      i = 0;
      while (i < k)
      {
        ((RecyclerView.c0)this.a.get(i)).c();
        i += 1;
      }
      ArrayList localArrayList = this.b;
      if (localArrayList != null)
      {
        k = localArrayList.size();
        i = j;
        while (i < k)
        {
          ((RecyclerView.c0)this.b.get(i)).c();
          i += 1;
        }
      }
    }
    
    void e()
    {
      this.a.clear();
      ArrayList localArrayList = this.b;
      if (localArrayList != null) {
        localArrayList.clear();
      }
    }
    
    public int f(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < RecyclerView.this.j0.b()))
      {
        if (!RecyclerView.this.j0.e()) {
          return paramInt;
        }
        return RecyclerView.this.d.m(paramInt);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid position ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(". State item count is ");
      localStringBuilder.append(RecyclerView.this.j0.b());
      localStringBuilder.append(RecyclerView.this.Q());
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    void g(RecyclerView.c0 paramc0)
    {
      Object localObject = RecyclerView.this.n;
      if (localObject != null) {
        ((RecyclerView.w)localObject).a(paramc0);
      }
      int j = RecyclerView.this.o.size();
      int i = 0;
      while (i < j)
      {
        ((RecyclerView.w)RecyclerView.this.o.get(i)).a(paramc0);
        i += 1;
      }
      localObject = RecyclerView.this.l;
      if (localObject != null) {
        ((RecyclerView.h)localObject).D(paramc0);
      }
      localObject = RecyclerView.this;
      if (((RecyclerView)localObject).j0 != null) {
        ((RecyclerView)localObject).f.q(paramc0);
      }
    }
    
    RecyclerView.c0 h(int paramInt)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        int k = ((ArrayList)localObject).size();
        if (k == 0) {
          return null;
        }
        int j = 0;
        int i = 0;
        while (i < k)
        {
          localObject = (RecyclerView.c0)this.b.get(i);
          if ((!((RecyclerView.c0)localObject).L()) && (((RecyclerView.c0)localObject).m() == paramInt))
          {
            ((RecyclerView.c0)localObject).b(32);
            return localObject;
          }
          i += 1;
        }
        if (RecyclerView.this.l.i())
        {
          paramInt = RecyclerView.this.d.m(paramInt);
          if ((paramInt > 0) && (paramInt < RecyclerView.this.l.d()))
          {
            long l = RecyclerView.this.l.e(paramInt);
            paramInt = j;
            while (paramInt < k)
            {
              localObject = (RecyclerView.c0)this.b.get(paramInt);
              if ((!((RecyclerView.c0)localObject).L()) && (((RecyclerView.c0)localObject).k() == l))
              {
                ((RecyclerView.c0)localObject).b(32);
                return localObject;
              }
              paramInt += 1;
            }
          }
        }
      }
      return null;
    }
    
    RecyclerView.u i()
    {
      if (this.g == null) {
        this.g = new RecyclerView.u();
      }
      return this.g;
    }
    
    int j()
    {
      return this.a.size();
    }
    
    public List<RecyclerView.c0> k()
    {
      return this.d;
    }
    
    RecyclerView.c0 l(long paramLong, int paramInt, boolean paramBoolean)
    {
      int i = this.a.size() - 1;
      RecyclerView.c0 localc0;
      while (i >= 0)
      {
        localc0 = (RecyclerView.c0)this.a.get(i);
        if ((localc0.k() == paramLong) && (!localc0.L()))
        {
          if (paramInt == localc0.l())
          {
            localc0.b(32);
            if ((localc0.v()) && (!RecyclerView.this.j0.e())) {
              localc0.F(2, 14);
            }
            return localc0;
          }
          if (!paramBoolean)
          {
            this.a.remove(i);
            RecyclerView.this.removeDetachedView(localc0.a, false);
            y(localc0.a);
          }
        }
        i -= 1;
      }
      i = this.c.size() - 1;
      while (i >= 0)
      {
        localc0 = (RecyclerView.c0)this.c.get(i);
        if ((localc0.k() == paramLong) && (!localc0.r()))
        {
          if (paramInt == localc0.l())
          {
            if (!paramBoolean) {
              this.c.remove(i);
            }
            return localc0;
          }
          if (!paramBoolean)
          {
            A(i);
            return null;
          }
        }
        i -= 1;
      }
      return null;
    }
    
    RecyclerView.c0 m(int paramInt, boolean paramBoolean)
    {
      int k = this.a.size();
      int j = 0;
      int i = 0;
      RecyclerView.c0 localc0;
      while (i < k)
      {
        localc0 = (RecyclerView.c0)this.a.get(i);
        if ((!localc0.L()) && (localc0.m() == paramInt) && (!localc0.t()) && ((RecyclerView.this.j0.h) || (!localc0.v())))
        {
          localc0.b(32);
          return localc0;
        }
        i += 1;
      }
      if (!paramBoolean)
      {
        Object localObject = RecyclerView.this.e.e(paramInt);
        if (localObject != null)
        {
          localc0 = RecyclerView.h0((View)localObject);
          RecyclerView.this.e.s((View)localObject);
          paramInt = RecyclerView.this.e.m((View)localObject);
          if (paramInt != -1)
          {
            RecyclerView.this.e.d(paramInt);
            D((View)localObject);
            localc0.b(8224);
            return localc0;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("layout index should not be -1 after unhiding a view:");
          ((StringBuilder)localObject).append(localc0);
          ((StringBuilder)localObject).append(RecyclerView.this.Q());
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
      k = this.c.size();
      i = j;
      while (i < k)
      {
        localc0 = (RecyclerView.c0)this.c.get(i);
        if ((!localc0.t()) && (localc0.m() == paramInt) && (!localc0.r()))
        {
          if (!paramBoolean) {
            this.c.remove(i);
          }
          return localc0;
        }
        i += 1;
      }
      return null;
    }
    
    View n(int paramInt)
    {
      return ((RecyclerView.c0)this.a.get(paramInt)).a;
    }
    
    public View o(int paramInt)
    {
      return p(paramInt, false);
    }
    
    View p(int paramInt, boolean paramBoolean)
    {
      return I(paramInt, paramBoolean, 9223372036854775807L).a;
    }
    
    void s()
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((RecyclerView.c0)this.c.get(i)).a.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.c = true;
        }
        i += 1;
      }
    }
    
    void t()
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        localObject = (RecyclerView.c0)this.c.get(i);
        if (localObject != null)
        {
          ((RecyclerView.c0)localObject).b(6);
          ((RecyclerView.c0)localObject).a(null);
        }
        i += 1;
      }
      Object localObject = RecyclerView.this.l;
      if ((localObject == null) || (!((RecyclerView.h)localObject).i())) {
        z();
      }
    }
    
    void u(int paramInt1, int paramInt2)
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.c0 localc0 = (RecyclerView.c0)this.c.get(i);
        if ((localc0 != null) && (localc0.c >= paramInt1)) {
          localc0.A(paramInt2, false);
        }
        i += 1;
      }
    }
    
    void v(int paramInt1, int paramInt2)
    {
      int i;
      int j;
      int k;
      if (paramInt1 < paramInt2)
      {
        i = -1;
        j = paramInt1;
        k = paramInt2;
      }
      else
      {
        i = 1;
        k = paramInt1;
        j = paramInt2;
      }
      int n = this.c.size();
      int m = 0;
      while (m < n)
      {
        RecyclerView.c0 localc0 = (RecyclerView.c0)this.c.get(m);
        if (localc0 != null)
        {
          int i1 = localc0.c;
          if ((i1 >= j) && (i1 <= k)) {
            if (i1 == paramInt1) {
              localc0.A(paramInt2 - paramInt1, false);
            } else {
              localc0.A(i, false);
            }
          }
        }
        m += 1;
      }
    }
    
    void w(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = this.c.size() - 1;
      while (i >= 0)
      {
        RecyclerView.c0 localc0 = (RecyclerView.c0)this.c.get(i);
        if (localc0 != null)
        {
          int j = localc0.c;
          if (j >= paramInt1 + paramInt2)
          {
            localc0.A(-paramInt2, paramBoolean);
          }
          else if (j >= paramInt1)
          {
            localc0.b(8);
            A(i);
          }
        }
        i -= 1;
      }
    }
    
    void x(RecyclerView.h paramh1, RecyclerView.h paramh2, boolean paramBoolean)
    {
      c();
      i().h(paramh1, paramh2, paramBoolean);
    }
    
    void y(View paramView)
    {
      paramView = RecyclerView.h0(paramView);
      paramView.n = null;
      paramView.o = false;
      paramView.e();
      C(paramView);
    }
    
    void z()
    {
      int i = this.c.size() - 1;
      while (i >= 0)
      {
        A(i);
        i -= 1;
      }
      this.c.clear();
      if (RecyclerView.H0) {
        RecyclerView.this.i0.b();
      }
    }
  }
  
  public static abstract interface w
  {
    public abstract void a(RecyclerView.c0 paramc0);
  }
  
  private class x
    extends RecyclerView.j
  {
    x() {}
    
    public void a()
    {
      RecyclerView.this.p(null);
      RecyclerView localRecyclerView = RecyclerView.this;
      localRecyclerView.j0.g = true;
      localRecyclerView.S0(true);
      if (!RecyclerView.this.d.p()) {
        RecyclerView.this.requestLayout();
      }
    }
    
    public void c(int paramInt1, int paramInt2, Object paramObject)
    {
      RecyclerView.this.p(null);
      if (RecyclerView.this.d.r(paramInt1, paramInt2, paramObject)) {
        h();
      }
    }
    
    public void d(int paramInt1, int paramInt2)
    {
      RecyclerView.this.p(null);
      if (RecyclerView.this.d.s(paramInt1, paramInt2)) {
        h();
      }
    }
    
    public void e(int paramInt1, int paramInt2, int paramInt3)
    {
      RecyclerView.this.p(null);
      if (RecyclerView.this.d.t(paramInt1, paramInt2, paramInt3)) {
        h();
      }
    }
    
    public void f(int paramInt1, int paramInt2)
    {
      RecyclerView.this.p(null);
      if (RecyclerView.this.d.u(paramInt1, paramInt2)) {
        h();
      }
    }
    
    public void g()
    {
      Object localObject = RecyclerView.this;
      if (((RecyclerView)localObject).c == null) {
        return;
      }
      localObject = ((RecyclerView)localObject).l;
      if ((localObject != null) && (((RecyclerView.h)localObject).b())) {
        RecyclerView.this.requestLayout();
      }
    }
    
    void h()
    {
      if (RecyclerView.G0)
      {
        localRecyclerView = RecyclerView.this;
        if ((localRecyclerView.t) && (localRecyclerView.s))
        {
          x.i0(localRecyclerView, localRecyclerView.h);
          return;
        }
      }
      RecyclerView localRecyclerView = RecyclerView.this;
      localRecyclerView.B = true;
      localRecyclerView.requestLayout();
    }
  }
  
  public static abstract class y
  {
    private int a = -1;
    private RecyclerView b;
    private RecyclerView.p c;
    private boolean d;
    private boolean e;
    private View f;
    private final a g = new a(0, 0);
    private boolean h;
    
    public PointF a(int paramInt)
    {
      Object localObject = e();
      if ((localObject instanceof b)) {
        return ((b)localObject).a(paramInt);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
      ((StringBuilder)localObject).append(b.class.getCanonicalName());
      Log.w("RecyclerView", ((StringBuilder)localObject).toString());
      return null;
    }
    
    public View b(int paramInt)
    {
      return this.b.m.C(paramInt);
    }
    
    public int c()
    {
      return this.b.m.J();
    }
    
    public int d(View paramView)
    {
      return this.b.f0(paramView);
    }
    
    public RecyclerView.p e()
    {
      return this.c;
    }
    
    public int f()
    {
      return this.a;
    }
    
    public boolean g()
    {
      return this.d;
    }
    
    public boolean h()
    {
      return this.e;
    }
    
    protected void i(PointF paramPointF)
    {
      float f1 = paramPointF.x;
      float f2 = paramPointF.y;
      f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      paramPointF.x /= f1;
      paramPointF.y /= f1;
    }
    
    void j(int paramInt1, int paramInt2)
    {
      RecyclerView localRecyclerView = this.b;
      if ((this.a == -1) || (localRecyclerView == null)) {
        r();
      }
      if ((this.d) && (this.f == null) && (this.c != null))
      {
        localObject = a(this.a);
        if (localObject != null)
        {
          float f1 = ((PointF)localObject).x;
          if ((f1 != 0.0F) || (((PointF)localObject).y != 0.0F)) {
            localRecyclerView.j1((int)Math.signum(f1), (int)Math.signum(((PointF)localObject).y), null);
          }
        }
      }
      this.d = false;
      Object localObject = this.f;
      if (localObject != null) {
        if (d((View)localObject) == this.a)
        {
          o(this.f, localRecyclerView.j0, this.g);
          this.g.c(localRecyclerView);
          r();
        }
        else
        {
          Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
          this.f = null;
        }
      }
      if (this.e)
      {
        l(paramInt1, paramInt2, localRecyclerView.j0, this.g);
        boolean bool = this.g.a();
        this.g.c(localRecyclerView);
        if ((bool) && (this.e))
        {
          this.d = true;
          localRecyclerView.g0.d();
        }
      }
    }
    
    protected void k(View paramView)
    {
      if (d(paramView) == f()) {
        this.f = paramView;
      }
    }
    
    protected abstract void l(int paramInt1, int paramInt2, RecyclerView.z paramz, a parama);
    
    protected abstract void m();
    
    protected abstract void n();
    
    protected abstract void o(View paramView, RecyclerView.z paramz, a parama);
    
    public void p(int paramInt)
    {
      this.a = paramInt;
    }
    
    void q(RecyclerView paramRecyclerView, RecyclerView.p paramp)
    {
      paramRecyclerView.g0.f();
      if (this.h)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("An instance of ");
        localStringBuilder.append(getClass().getSimpleName());
        localStringBuilder.append(" was started more than once. Each instance of");
        localStringBuilder.append(getClass().getSimpleName());
        localStringBuilder.append(" is intended to only be used once. You should create a new instance for each use.");
        Log.w("RecyclerView", localStringBuilder.toString());
      }
      this.b = paramRecyclerView;
      this.c = paramp;
      int i = this.a;
      if (i != -1)
      {
        paramRecyclerView.j0.a = i;
        this.e = true;
        this.d = true;
        this.f = b(f());
        m();
        this.b.g0.d();
        this.h = true;
        return;
      }
      throw new IllegalArgumentException("Invalid target position");
    }
    
    protected final void r()
    {
      if (!this.e) {
        return;
      }
      this.e = false;
      n();
      this.b.j0.a = -1;
      this.f = null;
      this.a = -1;
      this.d = false;
      this.c.f1(this);
      this.c = null;
      this.b = null;
    }
    
    public static class a
    {
      private int a;
      private int b;
      private int c;
      private int d = -1;
      private Interpolator e;
      private boolean f = false;
      private int g = 0;
      
      public a(int paramInt1, int paramInt2)
      {
        this(paramInt1, paramInt2, -2147483648, null);
      }
      
      public a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.e = paramInterpolator;
      }
      
      private void e()
      {
        if ((this.e != null) && (this.c < 1)) {
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.c >= 1) {
          return;
        }
        throw new IllegalStateException("Scroll duration must be a positive number");
      }
      
      boolean a()
      {
        return this.d >= 0;
      }
      
      public void b(int paramInt)
      {
        this.d = paramInt;
      }
      
      void c(RecyclerView paramRecyclerView)
      {
        int i = this.d;
        if (i >= 0)
        {
          this.d = -1;
          paramRecyclerView.y0(i);
          this.f = false;
          return;
        }
        if (this.f)
        {
          e();
          paramRecyclerView.g0.e(this.a, this.b, this.c, this.e);
          i = this.g + 1;
          this.g = i;
          if (i > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
          }
          this.f = false;
          return;
        }
        this.g = 0;
      }
      
      public void d(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.e = paramInterpolator;
        this.f = true;
      }
    }
    
    public static abstract interface b
    {
      public abstract PointF a(int paramInt);
    }
  }
  
  public static class z
  {
    int a = -1;
    private SparseArray<Object> b;
    int c = 0;
    int d = 0;
    int e = 1;
    int f = 0;
    boolean g = false;
    boolean h = false;
    boolean i = false;
    boolean j = false;
    boolean k = false;
    boolean l = false;
    int m;
    long n;
    int o;
    int p;
    int q;
    
    void a(int paramInt)
    {
      if ((this.e & paramInt) != 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Layout state should be one of ");
      localStringBuilder.append(Integer.toBinaryString(paramInt));
      localStringBuilder.append(" but it is ");
      localStringBuilder.append(Integer.toBinaryString(this.e));
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public int b()
    {
      if (this.h) {
        return this.c - this.d;
      }
      return this.f;
    }
    
    public int c()
    {
      return this.a;
    }
    
    public boolean d()
    {
      return this.a != -1;
    }
    
    public boolean e()
    {
      return this.h;
    }
    
    void f(RecyclerView.h paramh)
    {
      this.e = 1;
      this.f = paramh.d();
      this.h = false;
      this.i = false;
      this.j = false;
    }
    
    public boolean g()
    {
      return this.l;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("State{mTargetPosition=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", mData=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", mItemCount=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", mIsMeasuring=");
      localStringBuilder.append(this.j);
      localStringBuilder.append(", mPreviousLayoutItemCount=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", mStructureChanged=");
      localStringBuilder.append(this.g);
      localStringBuilder.append(", mInPreLayout=");
      localStringBuilder.append(this.h);
      localStringBuilder.append(", mRunSimpleAnimations=");
      localStringBuilder.append(this.k);
      localStringBuilder.append(", mRunPredictiveAnimations=");
      localStringBuilder.append(this.l);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */