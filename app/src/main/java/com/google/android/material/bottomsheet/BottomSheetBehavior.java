package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.view.h0;
import androidx.core.view.h0.m;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import c1.c.c;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.t;
import com.google.android.material.internal.t.e;
import com.google.android.material.internal.t.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import q0.b;
import r7.h;
import r7.m;
import r7.m.b;
import t0.a;
import y0.d.a;
import y0.g;
import y0.g.a;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private static final int d0 = R.style.Widget_Design_BottomSheet_Modal;
  private ValueAnimator A;
  int B;
  int C;
  int D;
  float E = 0.5F;
  int F;
  float G = -1.0F;
  boolean H;
  private boolean I;
  private boolean J = true;
  int K = 4;
  int L = 4;
  c1.c M;
  private boolean N;
  private int O;
  private boolean P;
  private int Q;
  int R;
  int S;
  WeakReference<V> T;
  WeakReference<View> U;
  private final ArrayList<f> V = new ArrayList();
  private VelocityTracker W;
  int X;
  private int Y;
  boolean Z;
  private int a = 0;
  private Map<View, Integer> a0;
  private boolean b = true;
  private int b0 = -1;
  private boolean c = false;
  private final c.c c0 = new d();
  private float d;
  private int e;
  private boolean f;
  private int g;
  private int h;
  private h i;
  private ColorStateList j;
  private int k = -1;
  private int l = -1;
  private int m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private int v;
  private int w;
  private m x;
  private boolean y;
  private final BottomSheetBehavior<V>.g z = new g(null);
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BottomSheetBehavior_Layout);
    int i1 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
    if (localTypedArray.hasValue(i1)) {
      this.j = o7.c.a(paramContext, localTypedArray, i1);
    }
    if (localTypedArray.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
      this.x = m.e(paramContext, paramAttributeSet, R.attr.bottomSheetStyle, d0).m();
    }
    b0(paramContext);
    c0();
    this.G = localTypedArray.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0F);
    i1 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
    if (localTypedArray.hasValue(i1)) {
      B0(localTypedArray.getDimensionPixelSize(i1, -1));
    }
    i1 = R.styleable.BottomSheetBehavior_Layout_android_maxHeight;
    if (localTypedArray.hasValue(i1)) {
      A0(localTypedArray.getDimensionPixelSize(i1, -1));
    }
    i1 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
    paramAttributeSet = localTypedArray.peekValue(i1);
    if (paramAttributeSet != null)
    {
      int i2 = paramAttributeSet.data;
      if (i2 == -1)
      {
        C0(i2);
        break label294;
      }
    }
    C0(localTypedArray.getDimensionPixelSize(i1, -1));
    label294:
    z0(localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
    x0(localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
    w0(localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
    F0(localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
    u0(localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
    E0(localTypedArray.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
    y0(localTypedArray.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5F));
    i1 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
    paramAttributeSet = localTypedArray.peekValue(i1);
    if ((paramAttributeSet != null) && (paramAttributeSet.type == 16)) {
      i1 = paramAttributeSet.data;
    } else {
      i1 = localTypedArray.getDimensionPixelOffset(i1, 0);
    }
    v0(i1);
    this.o = localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
    this.p = localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
    this.q = localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
    this.r = localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
    this.s = localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
    this.t = localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
    this.u = localTypedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
    localTypedArray.recycle();
    this.d = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private void I0(View paramView)
  {
    final boolean bool;
    if ((Build.VERSION.SDK_INT >= 29) && (!m0()) && (!this.f)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!this.o) && (!this.p) && (!this.q) && (!this.s) && (!this.t) && (!this.u) && (!bool)) {
      return;
    }
    t.b(paramView, new c(bool));
  }
  
  private boolean K0()
  {
    c1.c localc = this.M;
    boolean bool = true;
    if (localc != null)
    {
      if (this.J) {
        return bool;
      }
      if (this.K == 1) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private void O0(View paramView, int paramInt, boolean paramBoolean)
  {
    int i1 = k0(paramInt);
    c1.c localc = this.M;
    if ((localc != null) && (paramBoolean ? localc.P(paramView.getLeft(), i1) : localc.R(paramView, paramView.getLeft(), i1))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      H0(2);
      Q0(paramInt);
      this.z.c(paramInt);
      return;
    }
    H0(paramInt);
  }
  
  private void P0()
  {
    Object localObject = this.T;
    if (localObject == null) {
      return;
    }
    View localView = (View)((WeakReference)localObject).get();
    if (localView == null) {
      return;
    }
    x.k0(localView, 524288);
    x.k0(localView, 262144);
    x.k0(localView, 1048576);
    int i1 = this.b0;
    if (i1 != -1) {
      x.k0(localView, i1);
    }
    boolean bool = this.b;
    i1 = 6;
    if ((!bool) && (this.K != 6)) {
      this.b0 = V(localView, R.string.bottomsheet_action_expand_halfway, 6);
    }
    if ((this.H) && (this.K != 5)) {
      q0(localView, d.a.y, 5);
    }
    int i2 = this.K;
    if (i2 != 3)
    {
      if (i2 != 4)
      {
        if (i2 != 6) {
          return;
        }
        q0(localView, d.a.x, 4);
        q0(localView, d.a.w, 3);
        return;
      }
      if (this.b) {
        i1 = 3;
      }
      localObject = d.a.w;
    }
    else
    {
      if (this.b) {
        i1 = 4;
      }
      localObject = d.a.x;
    }
    q0(localView, (d.a)localObject, i1);
  }
  
  private void Q0(int paramInt)
  {
    if (paramInt == 2) {
      return;
    }
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.y != bool)
    {
      this.y = bool;
      if (this.i != null)
      {
        ValueAnimator localValueAnimator = this.A;
        if (localValueAnimator != null)
        {
          if (localValueAnimator.isRunning())
          {
            this.A.reverse();
            return;
          }
          float f1;
          if (bool) {
            f1 = 0.0F;
          } else {
            f1 = 1.0F;
          }
          this.A.setFloatValues(new float[] { 1.0F - f1, f1 });
          this.A.start();
        }
      }
    }
  }
  
  private void R0(boolean paramBoolean)
  {
    Object localObject = this.T;
    if (localObject == null) {
      return;
    }
    localObject = ((View)((WeakReference)localObject).get()).getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int i3 = ((ViewGroup)localObject).getChildCount();
    if (paramBoolean) {
      if (this.a0 == null) {
        this.a0 = new HashMap(i3);
      } else {
        return;
      }
    }
    int i1 = 0;
    while (i1 < i3)
    {
      View localView = ((ViewGroup)localObject).getChildAt(i1);
      if (localView != this.T.get()) {
        if (paramBoolean)
        {
          this.a0.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          if (!this.c) {}
        }
        else
        {
          for (int i2 = 4;; i2 = ((Integer)this.a0.get(localView)).intValue())
          {
            x.B0(localView, i2);
            break;
            if (!this.c) {
              break;
            }
            Map localMap = this.a0;
            if ((localMap == null) || (!localMap.containsKey(localView))) {
              break;
            }
          }
        }
      }
      i1 += 1;
    }
    if (!paramBoolean)
    {
      this.a0 = null;
      return;
    }
    if (this.c) {
      ((View)this.T.get()).sendAccessibilityEvent(8);
    }
  }
  
  private void S0(boolean paramBoolean)
  {
    if (this.T != null)
    {
      X();
      if (this.K == 4)
      {
        View localView = (View)this.T.get();
        if (localView != null)
        {
          if (paramBoolean)
          {
            G0(4);
            return;
          }
          localView.requestLayout();
        }
      }
    }
  }
  
  private int V(V paramV, int paramInt1, int paramInt2)
  {
    return x.c(paramV, paramV.getResources().getString(paramInt1), a0(paramInt2));
  }
  
  private void X()
  {
    int i1 = Z();
    if (this.b)
    {
      this.F = Math.max(this.S - i1, this.C);
      return;
    }
    this.F = (this.S - i1);
  }
  
  private void Y()
  {
    this.D = ((int)(this.S * (1.0F - this.E)));
  }
  
  private int Z()
  {
    if (this.f) {
      return Math.min(Math.max(this.g, this.S - this.R * 9 / 16), this.Q) + this.v;
    }
    if ((!this.n) && (!this.o))
    {
      int i1 = this.m;
      if (i1 > 0) {
        return Math.max(this.e, i1 + this.h);
      }
    }
    return this.e + this.v;
  }
  
  private g a0(final int paramInt)
  {
    return new e(paramInt);
  }
  
  private void b0(Context paramContext)
  {
    if (this.x == null) {
      return;
    }
    Object localObject = new h(this.x);
    this.i = ((h)localObject);
    ((h)localObject).Q(paramContext);
    localObject = this.j;
    if (localObject != null)
    {
      this.i.b0((ColorStateList)localObject);
      return;
    }
    localObject = new TypedValue();
    paramContext.getTheme().resolveAttribute(16842801, (TypedValue)localObject, true);
    this.i.setTint(((TypedValue)localObject).data);
  }
  
  private void c0()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.A = localValueAnimator;
    localValueAnimator.setDuration(500L);
    this.A.addUpdateListener(new b());
  }
  
  public static <V extends View> BottomSheetBehavior<V> f0(V paramV)
  {
    paramV = paramV.getLayoutParams();
    if ((paramV instanceof CoordinatorLayout.e))
    {
      paramV = ((CoordinatorLayout.e)paramV).f();
      if ((paramV instanceof BottomSheetBehavior)) {
        return (BottomSheetBehavior)paramV;
      }
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
  }
  
  private int g0(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt1, paramInt2, paramInt4);
    if (paramInt3 == -1) {
      return paramInt2;
    }
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 != 1073741824)
    {
      if (paramInt2 != 0) {
        paramInt3 = Math.min(paramInt2, paramInt3);
      }
      return View.MeasureSpec.makeMeasureSpec(paramInt3, -2147483648);
    }
    return View.MeasureSpec.makeMeasureSpec(Math.min(paramInt2, paramInt3), 1073741824);
  }
  
  private int k0(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt == 6) {
            return this.D;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid state to get top offset: ");
          localStringBuilder.append(paramInt);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return this.S;
      }
      return this.F;
    }
    return h0();
  }
  
  private float l0()
  {
    VelocityTracker localVelocityTracker = this.W;
    if (localVelocityTracker == null) {
      return 0.0F;
    }
    localVelocityTracker.computeCurrentVelocity(1000, this.d);
    return this.W.getYVelocity(this.X);
  }
  
  private boolean n0(V paramV)
  {
    ViewParent localViewParent = paramV.getParent();
    return (localViewParent != null) && (localViewParent.isLayoutRequested()) && (x.T(paramV));
  }
  
  private void q0(V paramV, d.a parama, int paramInt)
  {
    x.m0(paramV, parama, null, a0(paramInt));
  }
  
  private void r0()
  {
    this.X = -1;
    VelocityTracker localVelocityTracker = this.W;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.W = null;
    }
  }
  
  private void s0(SavedState paramSavedState)
  {
    int i1 = this.a;
    if (i1 == 0) {
      return;
    }
    if ((i1 == -1) || ((i1 & 0x1) == 1)) {
      this.e = paramSavedState.d;
    }
    if ((i1 == -1) || ((i1 & 0x2) == 2)) {
      this.b = paramSavedState.e;
    }
    if ((i1 == -1) || ((i1 & 0x4) == 4)) {
      this.H = paramSavedState.f;
    }
    if ((i1 == -1) || ((i1 & 0x8) == 8)) {
      this.I = paramSavedState.g;
    }
  }
  
  private void t0(V paramV, Runnable paramRunnable)
  {
    if (n0(paramV))
    {
      paramV.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  public boolean A(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.O = 0;
    this.P = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public void A0(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void B0(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void C(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    int i1 = paramV.getTop();
    int i2 = h0();
    paramInt = 3;
    if (i1 == i2)
    {
      H0(3);
      return;
    }
    if (o0())
    {
      paramCoordinatorLayout = this.U;
      if ((paramCoordinatorLayout == null) || (paramView != paramCoordinatorLayout.get()) || (!this.P)) {
        return;
      }
    }
    if (this.O > 0)
    {
      if ((this.b) || (paramV.getTop() <= this.D)) {
        break label273;
      }
    }
    else
    {
      if ((this.H) && (L0(paramV, l0())))
      {
        paramInt = 5;
        break label273;
      }
      if (this.O == 0)
      {
        i1 = paramV.getTop();
        if (this.b)
        {
          if (Math.abs(i1 - this.C) < Math.abs(i1 - this.F)) {
            break label273;
          }
        }
        else
        {
          i2 = this.D;
          if (i1 < i2)
          {
            if (i1 < Math.abs(i1 - this.F)) {
              break label273;
            }
            if (!M0()) {
              break label269;
            }
          }
          else if (Math.abs(i1 - i2) < Math.abs(i1 - this.F))
          {
            break label269;
          }
        }
      }
      else
      {
        if (!this.b) {
          break label240;
        }
      }
      label240:
      do
      {
        paramInt = 4;
        break;
        paramInt = paramV.getTop();
      } while (Math.abs(paramInt - this.D) >= Math.abs(paramInt - this.F));
    }
    label269:
    paramInt = 6;
    label273:
    O0(paramV, paramInt, false);
    this.P = false;
  }
  
  public void C0(int paramInt)
  {
    D0(paramInt, false);
  }
  
  public boolean D(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {
      return false;
    }
    int i1 = paramMotionEvent.getActionMasked();
    if ((this.K == 1) && (i1 == 0)) {
      return true;
    }
    if (K0()) {
      this.M.G(paramMotionEvent);
    }
    if (i1 == 0) {
      r0();
    }
    if (this.W == null) {
      this.W = VelocityTracker.obtain();
    }
    this.W.addMovement(paramMotionEvent);
    if ((K0()) && (i1 == 2) && (!this.N) && (Math.abs(this.Y - paramMotionEvent.getY()) > this.M.A())) {
      this.M.c(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    }
    return this.N ^ true;
  }
  
  public final void D0(int paramInt, boolean paramBoolean)
  {
    int i1 = 1;
    if (paramInt == -1)
    {
      if (!this.f)
      {
        this.f = true;
        paramInt = i1;
        break label63;
      }
    }
    else {
      if ((this.f) || (this.e != paramInt)) {
        break label47;
      }
    }
    paramInt = 0;
    break label63;
    label47:
    this.f = false;
    this.e = Math.max(0, paramInt);
    paramInt = i1;
    label63:
    if (paramInt != 0) {
      S0(paramBoolean);
    }
  }
  
  public void E0(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void F0(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void G0(int paramInt)
  {
    Object localObject;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((!this.H) && (paramInt == 5))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot set state: ");
        ((StringBuilder)localObject).append(paramInt);
        Log.w("BottomSheetBehavior", ((StringBuilder)localObject).toString());
        return;
      }
      final int i1;
      if ((paramInt == 6) && (this.b) && (k0(paramInt) <= this.C)) {
        i1 = 3;
      } else {
        i1 = paramInt;
      }
      localObject = this.T;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = (View)this.T.get();
        t0((View)localObject, new a((View)localObject, i1));
        return;
      }
      H0(paramInt);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("STATE_");
    if (paramInt == 1) {
      localObject = "DRAGGING";
    } else {
      localObject = "SETTLING";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" should not be set externally.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  void H0(int paramInt)
  {
    if (this.K == paramInt) {
      return;
    }
    this.K = paramInt;
    if ((paramInt == 4) || (paramInt == 3) || (paramInt == 6) || ((this.H) && (paramInt == 5))) {
      this.L = paramInt;
    }
    Object localObject = this.T;
    if (localObject == null) {
      return;
    }
    localObject = (View)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    int i1 = 0;
    if (paramInt == 3) {
      R0(true);
    } else if ((paramInt == 6) || (paramInt == 5) || (paramInt == 4)) {
      R0(false);
    }
    Q0(paramInt);
    while (i1 < this.V.size())
    {
      ((f)this.V.get(i1)).c((View)localObject, paramInt);
      i1 += 1;
    }
    P0();
  }
  
  public boolean J0(long paramLong, float paramFloat)
  {
    return false;
  }
  
  boolean L0(View paramView, float paramFloat)
  {
    if (this.I) {
      return true;
    }
    if (paramView.getTop() < this.F) {
      return false;
    }
    int i1 = Z();
    return Math.abs(paramView.getTop() + paramFloat * 0.1F - this.F) / i1 > 0.5F;
  }
  
  public boolean M0()
  {
    return false;
  }
  
  public boolean N0()
  {
    return true;
  }
  
  public void W(f paramf)
  {
    if (!this.V.contains(paramf)) {
      this.V.add(paramf);
    }
  }
  
  void d0(int paramInt)
  {
    View localView = (View)this.T.get();
    if ((localView != null) && (!this.V.isEmpty()))
    {
      int i1 = this.F;
      float f2;
      if ((paramInt <= i1) && (i1 != h0()))
      {
        i1 = this.F;
        f2 = i1 - paramInt;
        f1 = i1 - h0();
      }
      else
      {
        i1 = this.F;
        f2 = i1 - paramInt;
        f1 = this.S - i1;
      }
      float f1 = f2 / f1;
      paramInt = 0;
      while (paramInt < this.V.size())
      {
        ((f)this.V.get(paramInt)).b(localView, f1);
        paramInt += 1;
      }
    }
  }
  
  View e0(View paramView)
  {
    if (x.V(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i1 = 0;
      int i2 = paramView.getChildCount();
      while (i1 < i2)
      {
        View localView = e0(paramView.getChildAt(i1));
        if (localView != null) {
          return localView;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public void g(CoordinatorLayout.e parame)
  {
    super.g(parame);
    this.T = null;
    this.M = null;
  }
  
  public int h0()
  {
    if (this.b) {
      return this.C;
    }
    int i2 = this.B;
    int i1;
    if (this.r) {
      i1 = 0;
    } else {
      i1 = this.w;
    }
    return Math.max(i2, i1);
  }
  
  h i0()
  {
    return this.i;
  }
  
  public void j()
  {
    super.j();
    this.T = null;
    this.M = null;
  }
  
  public int j0()
  {
    return this.K;
  }
  
  public boolean k(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool1 = paramV.isShown();
    boolean bool2 = false;
    if ((bool1) && (this.J))
    {
      int i1 = paramMotionEvent.getActionMasked();
      if (i1 == 0) {
        r0();
      }
      if (this.W == null) {
        this.W = VelocityTracker.obtain();
      }
      this.W.addMovement(paramMotionEvent);
      Object localObject2 = null;
      if (i1 != 0)
      {
        if ((i1 == 1) || (i1 == 3))
        {
          this.Z = false;
          this.X = -1;
          if (this.N)
          {
            this.N = false;
            return false;
          }
        }
      }
      else
      {
        int i2 = (int)paramMotionEvent.getX();
        this.Y = ((int)paramMotionEvent.getY());
        if (this.K != 2)
        {
          localObject1 = this.U;
          if (localObject1 != null) {
            localObject1 = (View)((WeakReference)localObject1).get();
          } else {
            localObject1 = null;
          }
          if ((localObject1 != null) && (paramCoordinatorLayout.F((View)localObject1, i2, this.Y)))
          {
            this.X = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            this.Z = true;
          }
        }
        if ((this.X == -1) && (!paramCoordinatorLayout.F(paramV, i2, this.Y))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.N = bool1;
      }
      if (!this.N)
      {
        paramV = this.M;
        if ((paramV != null) && (paramV.Q(paramMotionEvent))) {
          return true;
        }
      }
      Object localObject1 = this.U;
      paramV = localObject2;
      if (localObject1 != null) {
        paramV = (View)((WeakReference)localObject1).get();
      }
      bool1 = bool2;
      if (i1 == 2)
      {
        bool1 = bool2;
        if (paramV != null)
        {
          bool1 = bool2;
          if (!this.N)
          {
            bool1 = bool2;
            if (this.K != 1)
            {
              bool1 = bool2;
              if (!paramCoordinatorLayout.F(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
              {
                bool1 = bool2;
                if (this.M != null)
                {
                  bool1 = bool2;
                  if (Math.abs(this.Y - paramMotionEvent.getY()) > this.M.A()) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    this.N = true;
    return false;
  }
  
  public boolean l(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((x.y(paramCoordinatorLayout)) && (!x.y(paramV))) {
      paramV.setFitsSystemWindows(true);
    }
    Object localObject = this.T;
    int i1 = 0;
    if (localObject == null)
    {
      this.g = paramCoordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
      I0(paramV);
      this.T = new WeakReference(paramV);
      localObject = this.i;
      if (localObject != null)
      {
        x.u0(paramV, (Drawable)localObject);
        localObject = this.i;
        float f2 = this.G;
        float f1 = f2;
        if (f2 == -1.0F) {
          f1 = x.w(paramV);
        }
        ((h)localObject).a0(f1);
        boolean bool;
        if (this.K == 3) {
          bool = true;
        } else {
          bool = false;
        }
        this.y = bool;
        localObject = this.i;
        if (bool) {
          f1 = 0.0F;
        } else {
          f1 = 1.0F;
        }
        ((h)localObject).c0(f1);
      }
      else
      {
        localObject = this.j;
        if (localObject != null) {
          x.v0(paramV, (ColorStateList)localObject);
        }
      }
      P0();
      if (x.z(paramV) == 0) {
        x.B0(paramV, 1);
      }
    }
    if (this.M == null) {
      this.M = c1.c.p(paramCoordinatorLayout, this.c0);
    }
    int i2 = paramV.getTop();
    paramCoordinatorLayout.M(paramV, paramInt);
    this.R = paramCoordinatorLayout.getWidth();
    this.S = paramCoordinatorLayout.getHeight();
    paramInt = paramV.getHeight();
    this.Q = paramInt;
    int i3 = this.S;
    int i4 = this.w;
    if (i3 - paramInt < i4) {
      if (this.r) {
        this.Q = i3;
      } else {
        this.Q = (i3 - i4);
      }
    }
    this.C = Math.max(0, i3 - this.Q);
    Y();
    X();
    paramInt = this.K;
    if (paramInt == 3) {
      paramInt = h0();
    }
    for (;;)
    {
      x.b0(paramV, paramInt);
      break label421;
      if (paramInt == 6)
      {
        paramInt = this.D;
      }
      else if ((this.H) && (paramInt == 5))
      {
        paramInt = this.S;
      }
      else
      {
        if (paramInt != 4) {
          break;
        }
        paramInt = this.F;
      }
    }
    if ((paramInt == 1) || (paramInt == 2)) {
      x.b0(paramV, i2 - paramV.getTop());
    }
    label421:
    this.U = new WeakReference(e0(paramV));
    paramInt = i1;
    while (paramInt < this.V.size())
    {
      ((f)this.V.get(paramInt)).a(paramV);
      paramInt += 1;
    }
    return true;
  }
  
  public boolean m(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramV.getLayoutParams();
    paramV.measure(g0(paramInt1, paramCoordinatorLayout.getPaddingLeft() + paramCoordinatorLayout.getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, this.k, localMarginLayoutParams.width), g0(paramInt3, paramCoordinatorLayout.getPaddingTop() + paramCoordinatorLayout.getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, this.l, localMarginLayoutParams.height));
    return true;
  }
  
  public boolean m0()
  {
    return this.n;
  }
  
  public boolean o(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool3 = o0();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      WeakReference localWeakReference = this.U;
      bool1 = bool2;
      if (localWeakReference != null)
      {
        bool1 = bool2;
        if (paramView == localWeakReference.get()) {
          if (this.K == 3)
          {
            bool1 = bool2;
            if (!super.o(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean o0()
  {
    return true;
  }
  
  public void p0(f paramf)
  {
    this.V.remove(paramf);
  }
  
  public void q(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {
      return;
    }
    paramCoordinatorLayout = this.U;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout = (View)paramCoordinatorLayout.get();
    } else {
      paramCoordinatorLayout = null;
    }
    if ((o0()) && (paramView != paramCoordinatorLayout)) {
      return;
    }
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0)
    {
      if (paramInt3 < h0())
      {
        paramArrayOfInt[1] = (paramInt1 - h0());
        x.b0(paramV, -paramArrayOfInt[1]);
        paramInt1 = 3;
        H0(paramInt1);
      }
      else
      {
        if (!this.J) {
          return;
        }
        paramArrayOfInt[1] = paramInt2;
      }
    }
    else {
      for (;;)
      {
        x.b0(paramV, -paramInt2);
        H0(1);
        break label207;
        if ((paramInt2 >= 0) || (paramView.canScrollVertically(-1))) {
          break label207;
        }
        int i1 = this.F;
        if ((paramInt3 > i1) && (!this.H))
        {
          paramArrayOfInt[1] = (paramInt1 - i1);
          x.b0(paramV, -paramArrayOfInt[1]);
          paramInt1 = 4;
          break;
        }
        if (!this.J) {
          return;
        }
        paramArrayOfInt[1] = paramInt2;
      }
    }
    label207:
    d0(paramV.getTop());
    this.O = paramInt2;
    this.P = true;
  }
  
  public void t(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt) {}
  
  public void u0(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public void v0(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.B = paramInt;
      return;
    }
    throw new IllegalArgumentException("offset must be greater than or equal to 0");
  }
  
  public void w0(boolean paramBoolean)
  {
    if (this.b == paramBoolean) {
      return;
    }
    this.b = paramBoolean;
    if (this.T != null) {
      X();
    }
    int i1;
    if ((this.b) && (this.K == 6)) {
      i1 = 3;
    } else {
      i1 = this.K;
    }
    H0(i1);
    P0();
  }
  
  public void x(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.x(paramCoordinatorLayout, paramV, paramParcelable.g());
    s0(paramParcelable);
    int i2 = paramParcelable.c;
    int i1;
    if (i2 != 1)
    {
      i1 = i2;
      if (i2 != 2) {}
    }
    else
    {
      i1 = 4;
    }
    this.K = i1;
    this.L = i1;
  }
  
  public void x0(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public Parcelable y(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new SavedState(super.y(paramCoordinatorLayout, paramV), this);
  }
  
  public void y0(float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F))
    {
      this.E = paramFloat;
      if (this.T != null) {
        Y();
      }
      return;
    }
    throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
  }
  
  public void z0(boolean paramBoolean)
  {
    if (this.H != paramBoolean)
    {
      this.H = paramBoolean;
      if ((!paramBoolean) && (this.K == 5)) {
        G0(4);
      }
      P0();
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    final int c;
    int d;
    boolean e;
    boolean f;
    boolean g;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
      int i = paramParcel.readInt();
      boolean bool2 = false;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.e = bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.f = bool1;
      boolean bool1 = bool2;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      this.g = bool1;
    }
    
    public SavedState(Parcelable paramParcelable, BottomSheetBehavior<?> paramBottomSheetBehavior)
    {
      super();
      this.c = paramBottomSheetBehavior.K;
      this.d = BottomSheetBehavior.K(paramBottomSheetBehavior);
      this.e = BottomSheetBehavior.J(paramBottomSheetBehavior);
      this.f = paramBottomSheetBehavior.H;
      this.g = BottomSheetBehavior.L(paramBottomSheetBehavior);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.SavedState>
    {
      public BottomSheetBehavior.SavedState a(Parcel paramParcel)
      {
        return new BottomSheetBehavior.SavedState(paramParcel, null);
      }
      
      public BottomSheetBehavior.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new BottomSheetBehavior.SavedState(paramParcel, paramClassLoader);
      }
      
      public BottomSheetBehavior.SavedState[] c(int paramInt)
      {
        return new BottomSheetBehavior.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements Runnable
  {
    a(View paramView, int paramInt) {}
    
    public void run()
    {
      BottomSheetBehavior.E(BottomSheetBehavior.this, this.a, i1, false);
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      if (BottomSheetBehavior.M(BottomSheetBehavior.this) != null) {
        BottomSheetBehavior.M(BottomSheetBehavior.this).c0(f);
      }
    }
  }
  
  class c
    implements t.e
  {
    c(boolean paramBoolean) {}
    
    public h0 a(View paramView, h0 paramh0, t.f paramf)
    {
      b localb1 = paramh0.f(h0.m.c());
      b localb2 = paramh0.f(h0.m.b());
      BottomSheetBehavior.N(BottomSheetBehavior.this, localb1.b);
      boolean bool = t.i(paramView);
      int k = paramView.getPaddingBottom();
      int m = paramView.getPaddingLeft();
      int n = paramView.getPaddingRight();
      if (BottomSheetBehavior.O(BottomSheetBehavior.this))
      {
        BottomSheetBehavior.Q(BottomSheetBehavior.this, paramh0.i());
        k = paramf.d + BottomSheetBehavior.P(BottomSheetBehavior.this);
      }
      if (BottomSheetBehavior.R(BottomSheetBehavior.this))
      {
        if (bool) {
          i = paramf.c;
        } else {
          i = paramf.a;
        }
        m = i + localb1.a;
      }
      if (BottomSheetBehavior.S(BottomSheetBehavior.this))
      {
        if (bool) {
          i = paramf.a;
        } else {
          i = paramf.c;
        }
        n = i + localb1.c;
      }
      paramf = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      bool = BottomSheetBehavior.T(BottomSheetBehavior.this);
      int i1 = 1;
      if (bool)
      {
        i = paramf.leftMargin;
        j = localb1.a;
        if (i != j)
        {
          paramf.leftMargin = j;
          j = 1;
          break label231;
        }
      }
      int j = 0;
      label231:
      int i = j;
      int i2;
      if (BottomSheetBehavior.U(BottomSheetBehavior.this))
      {
        i2 = paramf.rightMargin;
        int i3 = localb1.c;
        i = j;
        if (i2 != i3)
        {
          paramf.rightMargin = i3;
          i = 1;
        }
      }
      if (BottomSheetBehavior.F(BottomSheetBehavior.this))
      {
        j = paramf.topMargin;
        i2 = localb1.b;
        if (j != i2)
        {
          paramf.topMargin = i2;
          i = i1;
        }
      }
      if (i != 0) {
        paramView.setLayoutParams(paramf);
      }
      paramView.setPadding(m, paramView.getPaddingTop(), n, k);
      if (bool) {
        BottomSheetBehavior.G(BottomSheetBehavior.this, localb2.d);
      }
      if ((BottomSheetBehavior.O(BottomSheetBehavior.this)) || (bool)) {
        BottomSheetBehavior.H(BottomSheetBehavior.this, false);
      }
      return paramh0;
    }
  }
  
  class d
    extends c.c
  {
    private long a;
    
    d() {}
    
    private boolean n(View paramView)
    {
      int i = paramView.getTop();
      paramView = BottomSheetBehavior.this;
      return i > (paramView.S + paramView.h0()) / 2;
    }
    
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getLeft();
    }
    
    public int b(View paramView, int paramInt1, int paramInt2)
    {
      int i = BottomSheetBehavior.this.h0();
      paramView = BottomSheetBehavior.this;
      if (paramView.H) {
        paramInt2 = paramView.S;
      } else {
        paramInt2 = paramView.F;
      }
      return a.b(paramInt1, i, paramInt2);
    }
    
    public int e(View paramView)
    {
      paramView = BottomSheetBehavior.this;
      if (paramView.H) {
        return paramView.S;
      }
      return paramView.F;
    }
    
    public void j(int paramInt)
    {
      if ((paramInt == 1) && (BottomSheetBehavior.I(BottomSheetBehavior.this))) {
        BottomSheetBehavior.this.H0(1);
      }
    }
    
    public void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      BottomSheetBehavior.this.d0(paramInt2);
    }
    
    public void l(View paramView, float paramFloat1, float paramFloat2)
    {
      int i = 6;
      if (paramFloat2 < 0.0F) {
        if (!BottomSheetBehavior.J(BottomSheetBehavior.this)) {}
      }
      int j;
      for (;;)
      {
        i = 3;
        break label433;
        j = paramView.getTop();
        long l1 = System.currentTimeMillis();
        long l2 = this.a;
        if (BottomSheetBehavior.this.M0())
        {
          paramFloat1 = j;
          localBottomSheetBehavior = BottomSheetBehavior.this;
          if (!localBottomSheetBehavior.J0(l1 - l2, paramFloat1 * 100.0F / localBottomSheetBehavior.S)) {
            break label242;
          }
        }
        else if (j > BottomSheetBehavior.this.D)
        {
          break label433;
          localBottomSheetBehavior = BottomSheetBehavior.this;
          if ((!localBottomSheetBehavior.H) || (!localBottomSheetBehavior.L0(paramView, paramFloat2))) {
            break;
          }
          if (((Math.abs(paramFloat1) < Math.abs(paramFloat2)) && (paramFloat2 > 500.0F)) || (n(paramView)))
          {
            i = 5;
            break label433;
          }
          if (!BottomSheetBehavior.J(BottomSheetBehavior.this)) {
            if (Math.abs(paramView.getTop() - BottomSheetBehavior.this.h0()) >= Math.abs(paramView.getTop() - BottomSheetBehavior.this.D)) {
              break label433;
            }
          }
        }
      }
      if ((paramFloat2 != 0.0F) && (Math.abs(paramFloat1) <= Math.abs(paramFloat2))) {
        if (!BottomSheetBehavior.J(BottomSheetBehavior.this)) {}
      }
      label242:
      int k;
      label396:
      do
      {
        for (;;)
        {
          i = 4;
          break label433;
          j = paramView.getTop();
          if (Math.abs(j - BottomSheetBehavior.this.D) < Math.abs(j - BottomSheetBehavior.this.F))
          {
            if (!BottomSheetBehavior.this.M0()) {
              break label433;
            }
            continue;
            j = paramView.getTop();
            if (BottomSheetBehavior.J(BottomSheetBehavior.this))
            {
              if (Math.abs(j - BottomSheetBehavior.this.C) >= Math.abs(j - BottomSheetBehavior.this.F)) {
                continue;
              }
              break;
            }
            localBottomSheetBehavior = BottomSheetBehavior.this;
            k = localBottomSheetBehavior.D;
            if (j >= k) {
              break label396;
            }
            if (j < Math.abs(j - localBottomSheetBehavior.F)) {
              break;
            }
            if (!BottomSheetBehavior.this.M0()) {
              break label433;
            }
          }
        }
      } while ((Math.abs(j - k) >= Math.abs(j - BottomSheetBehavior.this.F)) || (BottomSheetBehavior.this.M0()));
      label433:
      BottomSheetBehavior localBottomSheetBehavior = BottomSheetBehavior.this;
      BottomSheetBehavior.E(localBottomSheetBehavior, paramView, i, localBottomSheetBehavior.N0());
    }
    
    public boolean m(View paramView, int paramInt)
    {
      Object localObject = BottomSheetBehavior.this;
      int i = ((BottomSheetBehavior)localObject).K;
      if (i == 1) {
        return false;
      }
      if (((BottomSheetBehavior)localObject).Z) {
        return false;
      }
      if ((i == 3) && (((BottomSheetBehavior)localObject).X == paramInt))
      {
        localObject = ((BottomSheetBehavior)localObject).U;
        if (localObject != null) {
          localObject = (View)((WeakReference)localObject).get();
        } else {
          localObject = null;
        }
        if ((localObject != null) && (((View)localObject).canScrollVertically(-1))) {
          return false;
        }
      }
      this.a = System.currentTimeMillis();
      localObject = BottomSheetBehavior.this.T;
      return (localObject != null) && (((WeakReference)localObject).get() == paramView);
    }
  }
  
  class e
    implements g
  {
    e(int paramInt) {}
    
    public boolean a(View paramView, g.a parama)
    {
      BottomSheetBehavior.this.G0(paramInt);
      return true;
    }
  }
  
  public static abstract class f
  {
    void a(View paramView) {}
    
    public abstract void b(View paramView, float paramFloat);
    
    public abstract void c(View paramView, int paramInt);
  }
  
  private class g
  {
    private int a;
    private boolean b;
    private final Runnable c = new a();
    
    private g() {}
    
    void c(int paramInt)
    {
      WeakReference localWeakReference = BottomSheetBehavior.this.T;
      if (localWeakReference != null)
      {
        if (localWeakReference.get() == null) {
          return;
        }
        this.a = paramInt;
        if (!this.b)
        {
          x.i0((View)BottomSheetBehavior.this.T.get(), this.c);
          this.b = true;
        }
      }
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        BottomSheetBehavior.g.a(BottomSheetBehavior.g.this, false);
        Object localObject = BottomSheetBehavior.this.M;
        if ((localObject != null) && (((c1.c)localObject).n(true)))
        {
          localObject = BottomSheetBehavior.g.this;
          ((BottomSheetBehavior.g)localObject).c(BottomSheetBehavior.g.b((BottomSheetBehavior.g)localObject));
          return;
        }
        localObject = BottomSheetBehavior.g.this;
        BottomSheetBehavior localBottomSheetBehavior = ((BottomSheetBehavior.g)localObject).d;
        if (localBottomSheetBehavior.K == 2) {
          localBottomSheetBehavior.H0(BottomSheetBehavior.g.b((BottomSheetBehavior.g)localObject));
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */