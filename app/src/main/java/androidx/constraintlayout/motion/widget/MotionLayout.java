package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.Constraints.LayoutParams;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.c;
import i0.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import k0.e.b;
import k0.g;
import k0.h;
import k0.i;
import k0.j;
import k0.l;

public class MotionLayout
  extends ConstraintLayout
  implements androidx.core.view.p
{
  public static boolean d1;
  Interpolator A = null;
  protected boolean A0 = false;
  float B = 0.0F;
  int B0;
  private int C = -1;
  int C0;
  int D0;
  int E = -1;
  int E0;
  private int F = -1;
  int F0;
  private int G = 0;
  int G0;
  private int H = 0;
  float H0;
  private boolean I = true;
  private d I0 = new d();
  HashMap<View, m> J = new HashMap();
  private boolean J0 = false;
  private long K = 0L;
  private i K0;
  private float L = 1.0F;
  private Runnable L0 = null;
  float M = 0.0F;
  private int[] M0 = null;
  float N = 0.0F;
  int N0 = 0;
  private long O;
  private boolean O0 = false;
  float P = 0.0F;
  int P0 = 0;
  private boolean Q;
  HashMap<View, n0.e> Q0 = new HashMap();
  boolean R = false;
  private int R0;
  boolean S = false;
  private int S0;
  private j T;
  private int T0;
  private float U;
  Rect U0 = new Rect();
  private float V;
  private boolean V0 = false;
  int W = 0;
  k W0 = k.a;
  f X0 = new f();
  private boolean Y0 = false;
  private RectF Z0 = new RectF();
  e a0;
  private View a1 = null;
  private boolean b0 = false;
  private Matrix b1 = null;
  private n0.b c0 = new n0.b();
  ArrayList<Integer> c1 = new ArrayList();
  private d d0 = new d();
  private b e0;
  boolean f0 = true;
  int g0;
  int h0;
  int i0;
  int j0;
  boolean k0 = false;
  float l0;
  float m0;
  long n0;
  float o0;
  private boolean p0 = false;
  private ArrayList<MotionHelper> q0 = null;
  private ArrayList<MotionHelper> r0 = null;
  private ArrayList<MotionHelper> s0 = null;
  private CopyOnWriteArrayList<j> t0 = null;
  private int u0 = 0;
  private long v0 = -1L;
  private float w0 = 0.0F;
  private int x0 = 0;
  p y;
  private float y0 = 0.0F;
  Interpolator z;
  boolean z0 = false;
  
  public MotionLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    r0(paramAttributeSet);
  }
  
  public MotionLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    r0(paramAttributeSet);
  }
  
  private void A0()
  {
    int i2 = getChildCount();
    this.X0.a();
    int i1 = 1;
    this.R = true;
    Object localObject1 = new SparseArray();
    int n = 0;
    int m = 0;
    int i = 0;
    while (i < i2)
    {
      localObject2 = getChildAt(i);
      ((SparseArray)localObject1).put(((View)localObject2).getId(), (m)this.J.get(localObject2));
      i += 1;
    }
    int i3 = getWidth();
    int i4 = getHeight();
    int j = this.y.j();
    if (j != -1)
    {
      i = 0;
      while (i < i2)
      {
        localObject1 = (m)this.J.get(getChildAt(i));
        if (localObject1 != null) {
          ((m)localObject1).D(j);
        }
        i += 1;
      }
    }
    localObject1 = new SparseBooleanArray();
    Object localObject2 = new int[this.J.size()];
    j = 0;
    Object localObject3;
    int k;
    for (i = j; j < i2; i = k)
    {
      localObject3 = getChildAt(j);
      localObject3 = (m)this.J.get(localObject3);
      k = i;
      if (((m)localObject3).h() != -1)
      {
        ((SparseBooleanArray)localObject1).put(((m)localObject3).h(), true);
        localObject2[i] = ((m)localObject3).h();
        k = i + 1;
      }
      j += 1;
    }
    if (this.s0 != null)
    {
      j = 0;
      while (j < i)
      {
        localObject3 = (m)this.J.get(findViewById(localObject2[j]));
        if (localObject3 != null) {
          this.y.t((m)localObject3);
        }
        j += 1;
      }
      localObject3 = this.s0.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((MotionHelper)((Iterator)localObject3).next()).D(this, this.J);
      }
      j = 0;
      while (j < i)
      {
        localObject3 = (m)this.J.get(findViewById(localObject2[j]));
        if (localObject3 != null) {
          ((m)localObject3).I(i3, i4, this.L, getNanoTime());
        }
        j += 1;
      }
    }
    j = 0;
    while (j < i)
    {
      localObject3 = (m)this.J.get(findViewById(localObject2[j]));
      if (localObject3 != null)
      {
        this.y.t((m)localObject3);
        ((m)localObject3).I(i3, i4, this.L, getNanoTime());
      }
      j += 1;
    }
    i = 0;
    while (i < i2)
    {
      localObject2 = getChildAt(i);
      localObject3 = (m)this.J.get(localObject2);
      if ((!((SparseBooleanArray)localObject1).get(((View)localObject2).getId())) && (localObject3 != null))
      {
        this.y.t((m)localObject3);
        ((m)localObject3).I(i3, i4, this.L, getNanoTime());
      }
      i += 1;
    }
    float f1 = this.y.E();
    if (f1 != 0.0F)
    {
      if (f1 < 0.0D) {
        i = 1;
      } else {
        i = 0;
      }
      float f6 = Math.abs(f1);
      float f4 = -3.402824E+038F;
      float f5 = 3.4028235E+38F;
      j = 0;
      f1 = -3.402824E+038F;
      float f2 = 3.4028235E+38F;
      float f3;
      while (j < i2)
      {
        localObject1 = (m)this.J.get(getChildAt(j));
        if (!Float.isNaN(((m)localObject1).m))
        {
          j = i1;
          break label756;
        }
        f3 = ((m)localObject1).n();
        float f7 = ((m)localObject1).o();
        if (i != 0) {
          f3 = f7 - f3;
        } else {
          f3 = f7 + f3;
        }
        f2 = Math.min(f2, f3);
        f1 = Math.max(f1, f3);
        j += 1;
      }
      j = 0;
      label756:
      k = n;
      if (j != 0)
      {
        j = 0;
        f2 = f5;
        f1 = f4;
        for (;;)
        {
          k = m;
          if (j >= i2) {
            break;
          }
          localObject1 = (m)this.J.get(getChildAt(j));
          f4 = f1;
          f3 = f2;
          if (!Float.isNaN(((m)localObject1).m))
          {
            f3 = Math.min(f2, ((m)localObject1).m);
            f4 = Math.max(f1, ((m)localObject1).m);
          }
          j += 1;
          f1 = f4;
          f2 = f3;
        }
        while (k < i2)
        {
          localObject1 = (m)this.J.get(getChildAt(k));
          if (!Float.isNaN(((m)localObject1).m))
          {
            ((m)localObject1).o = (1.0F / (1.0F - f6));
            f3 = ((m)localObject1).m;
            if (i != 0) {
              f3 = (f1 - f3) / (f1 - f2) * f6;
            } else {
              f3 = (f3 - f2) * f6 / (f1 - f2);
            }
            ((m)localObject1).n = (f6 - f3);
          }
          k += 1;
        }
      }
      while (k < i2)
      {
        localObject1 = (m)this.J.get(getChildAt(k));
        f3 = ((m)localObject1).n();
        f4 = ((m)localObject1).o();
        if (i != 0) {
          f3 = f4 - f3;
        } else {
          f3 = f4 + f3;
        }
        ((m)localObject1).o = (1.0F / (1.0F - f6));
        ((m)localObject1).n = (f6 - (f3 - f2) * f6 / (f1 - f2));
        k += 1;
      }
    }
  }
  
  private Rect B0(k0.e parame)
  {
    this.U0.top = parame.a0();
    this.U0.left = parame.Z();
    Rect localRect2 = this.U0;
    int i = parame.Y();
    Rect localRect1 = this.U0;
    localRect2.right = (i + localRect1.left);
    i = parame.z();
    parame = this.U0;
    localRect1.bottom = (i + parame.top);
    return parame;
  }
  
  private static boolean N0(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > 0.0F)
    {
      f = paramFloat1 / paramFloat3;
      return paramFloat2 + (paramFloat1 * f - paramFloat3 * f * f / 2.0F) > 1.0F;
    }
    float f = -paramFloat1 / paramFloat3;
    return paramFloat2 + (paramFloat1 * f + paramFloat3 * f * f / 2.0F) < 0.0F;
  }
  
  private boolean a0(View paramView, MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = paramView.getMatrix();
    if (localMatrix.isIdentity())
    {
      paramMotionEvent.offsetLocation(paramFloat1, paramFloat2);
      bool = paramView.onTouchEvent(paramMotionEvent);
      paramMotionEvent.offsetLocation(-paramFloat1, -paramFloat2);
      return bool;
    }
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.offsetLocation(paramFloat1, paramFloat2);
    if (this.b1 == null) {
      this.b1 = new Matrix();
    }
    localMatrix.invert(this.b1);
    paramMotionEvent.transform(this.b1);
    boolean bool = paramView.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
    return bool;
  }
  
  private void b0()
  {
    Object localObject1 = this.y;
    if (localObject1 == null)
    {
      Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
      return;
    }
    int i = ((p)localObject1).F();
    localObject1 = this.y;
    c0(i, ((p)localObject1).l(((p)localObject1).F()));
    localObject1 = new SparseIntArray();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    Iterator localIterator = this.y.o().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (p.b)localIterator.next();
      if (localObject2 == this.y.c) {
        Log.v("MotionLayout", "CHECK: CURRENT");
      }
      d0((p.b)localObject2);
      i = ((p.b)localObject2).A();
      int j = ((p.b)localObject2).y();
      localObject2 = a.c(getContext(), i);
      Object localObject3 = a.c(getContext(), j);
      StringBuilder localStringBuilder;
      if (((SparseIntArray)localObject1).get(i) == j)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CHECK: two transitions with the same start and end ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("->");
        localStringBuilder.append((String)localObject3);
        Log.e("MotionLayout", localStringBuilder.toString());
      }
      if (localSparseIntArray.get(j) == i)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CHECK: you can't have reverse transitions");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("->");
        localStringBuilder.append((String)localObject3);
        Log.e("MotionLayout", localStringBuilder.toString());
      }
      ((SparseIntArray)localObject1).put(i, j);
      localSparseIntArray.put(j, i);
      if (this.y.l(i) == null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" no such constraintSetStart ");
        ((StringBuilder)localObject3).append((String)localObject2);
        Log.e("MotionLayout", ((StringBuilder)localObject3).toString());
      }
      if (this.y.l(j) == null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" no such constraintSetEnd ");
        ((StringBuilder)localObject3).append((String)localObject2);
        Log.e("MotionLayout", ((StringBuilder)localObject3).toString());
      }
    }
  }
  
  private void c0(int paramInt, c paramc)
  {
    String str = a.c(getContext(), paramInt);
    int j = getChildCount();
    int i = 0;
    paramInt = 0;
    Object localObject2;
    while (paramInt < j)
    {
      localObject1 = getChildAt(paramInt);
      int k = ((View)localObject1).getId();
      if (k == -1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CHECK: ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" ALL VIEWS SHOULD HAVE ID's ");
        ((StringBuilder)localObject2).append(localObject1.getClass().getName());
        ((StringBuilder)localObject2).append(" does not!");
        Log.w("MotionLayout", ((StringBuilder)localObject2).toString());
      }
      if (paramc.w(k) == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CHECK: ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" NO CONSTRAINTS for ");
        ((StringBuilder)localObject2).append(a.d((View)localObject1));
        Log.w("MotionLayout", ((StringBuilder)localObject2).toString());
      }
      paramInt += 1;
    }
    Object localObject1 = paramc.y();
    paramInt = i;
    while (paramInt < localObject1.length)
    {
      i = localObject1[paramInt];
      localObject2 = a.c(getContext(), i);
      StringBuilder localStringBuilder;
      if (findViewById(localObject1[paramInt]) == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CHECK: ");
        localStringBuilder.append(str);
        localStringBuilder.append(" NO View matches id ");
        localStringBuilder.append((String)localObject2);
        Log.w("MotionLayout", localStringBuilder.toString());
      }
      if (paramc.x(i) == -1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CHECK: ");
        localStringBuilder.append(str);
        localStringBuilder.append("(");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(") no LAYOUT_HEIGHT");
        Log.w("MotionLayout", localStringBuilder.toString());
      }
      if (paramc.C(i) == -1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CHECK: ");
        localStringBuilder.append(str);
        localStringBuilder.append("(");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(") no LAYOUT_HEIGHT");
        Log.w("MotionLayout", localStringBuilder.toString());
      }
      paramInt += 1;
    }
  }
  
  private void d0(p.b paramb)
  {
    if (paramb.A() == paramb.y()) {
      Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
    }
  }
  
  private void e0()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      m localm = (m)this.J.get(localView);
      if (localm != null) {
        localm.E(localView);
      }
      i += 1;
    }
  }
  
  private void h0()
  {
    float f3 = Math.signum(this.P - this.N);
    long l = getNanoTime();
    Object localObject = this.z;
    if (!(localObject instanceof n0.b)) {
      f1 = (float)(l - this.O) * f3 * 1.0E-009F / this.L;
    } else {
      f1 = 0.0F;
    }
    float f2 = this.N + f1;
    if (this.Q) {
      f2 = this.P;
    }
    boolean bool = f3 < 0.0F;
    int j = 0;
    int i;
    if (((bool) && (f2 >= this.P)) || ((f3 <= 0.0F) && (f2 <= this.P)))
    {
      f2 = this.P;
      i = 1;
    }
    else
    {
      i = 0;
    }
    float f1 = f2;
    if (localObject != null)
    {
      f1 = f2;
      if (i == 0) {
        if (this.b0) {
          f1 = ((Interpolator)localObject).getInterpolation((float)(l - this.K) * 1.0E-009F);
        } else {
          f1 = ((Interpolator)localObject).getInterpolation(f2);
        }
      }
    }
    if ((!bool) || (f1 < this.P))
    {
      f2 = f1;
      if (f3 <= 0.0F)
      {
        f2 = f1;
        if (f1 > this.P) {}
      }
    }
    else
    {
      f2 = this.P;
    }
    this.H0 = f2;
    int k = getChildCount();
    l = getNanoTime();
    localObject = this.A;
    if (localObject == null)
    {
      i = j;
    }
    else
    {
      f2 = ((Interpolator)localObject).getInterpolation(f2);
      i = j;
    }
    while (i < k)
    {
      localObject = getChildAt(i);
      m localm = (m)this.J.get(localObject);
      if (localm != null) {
        localm.x((View)localObject, f2, l, this.I0);
      }
      i += 1;
    }
    if (this.A0) {
      requestLayout();
    }
  }
  
  private void i0()
  {
    Object localObject;
    if (this.T == null)
    {
      localObject = this.t0;
      if ((localObject == null) || (((CopyOnWriteArrayList)localObject).isEmpty())) {}
    }
    else if (this.y0 != this.M)
    {
      if (this.x0 != -1)
      {
        localObject = this.T;
        if (localObject != null) {
          ((j)localObject).b(this, this.C, this.F);
        }
        localObject = this.t0;
        if (localObject != null)
        {
          localObject = ((CopyOnWriteArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((j)((Iterator)localObject).next()).b(this, this.C, this.F);
          }
        }
        this.z0 = true;
      }
      this.x0 = -1;
      float f = this.M;
      this.y0 = f;
      localObject = this.T;
      if (localObject != null) {
        ((j)localObject).a(this, this.C, this.F, f);
      }
      localObject = this.t0;
      if (localObject != null)
      {
        localObject = ((CopyOnWriteArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((j)((Iterator)localObject).next()).a(this, this.C, this.F, this.M);
        }
      }
      this.z0 = true;
    }
  }
  
  private boolean q0(float paramFloat1, float paramFloat2, View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if (q0(localView.getLeft() + paramFloat1 - paramView.getScrollX(), localView.getTop() + paramFloat2 - paramView.getScrollY(), localView, paramMotionEvent))
        {
          bool = true;
          break label93;
        }
        i -= 1;
      }
    }
    boolean bool = false;
    label93:
    if (!bool)
    {
      this.Z0.set(paramFloat1, paramFloat2, paramView.getRight() + paramFloat1 - paramView.getLeft(), paramView.getBottom() + paramFloat2 - paramView.getTop());
      if (((paramMotionEvent.getAction() != 0) || (this.Z0.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) && (a0(paramView, paramMotionEvent, -paramFloat1, -paramFloat2))) {
        return true;
      }
    }
    return bool;
  }
  
  private void r0(AttributeSet paramAttributeSet)
  {
    d1 = isInEditMode();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MotionLayout);
      int k = paramAttributeSet.getIndexCount();
      boolean bool1 = true;
      int j = 0;
      while (j < k)
      {
        int i = paramAttributeSet.getIndex(j);
        boolean bool2;
        if (i == R.styleable.MotionLayout_layoutDescription)
        {
          i = paramAttributeSet.getResourceId(i, -1);
          this.y = new p(getContext(), this, i);
          bool2 = bool1;
        }
        else if (i == R.styleable.MotionLayout_currentState)
        {
          this.E = paramAttributeSet.getResourceId(i, -1);
          bool2 = bool1;
        }
        else if (i == R.styleable.MotionLayout_motionProgress)
        {
          this.P = paramAttributeSet.getFloat(i, 0.0F);
          this.R = true;
          bool2 = bool1;
        }
        else if (i == R.styleable.MotionLayout_applyMotionScene)
        {
          bool2 = paramAttributeSet.getBoolean(i, bool1);
        }
        else
        {
          if (i == R.styleable.MotionLayout_showPaths)
          {
            bool2 = bool1;
            if (this.W != 0) {
              break label220;
            }
            if (paramAttributeSet.getBoolean(i, false)) {
              i = 2;
            } else {
              i = 0;
            }
          }
          else
          {
            bool2 = bool1;
            if (i != R.styleable.MotionLayout_motionDebug) {
              break label220;
            }
            i = paramAttributeSet.getInt(i, 0);
          }
          this.W = i;
          bool2 = bool1;
        }
        label220:
        j += 1;
        bool1 = bool2;
      }
      paramAttributeSet.recycle();
      if (this.y == null) {
        Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
      }
      if (!bool1) {
        this.y = null;
      }
    }
    if (this.W != 0) {
      b0();
    }
    if (this.E == -1)
    {
      paramAttributeSet = this.y;
      if (paramAttributeSet != null)
      {
        this.E = paramAttributeSet.F();
        this.C = this.y.F();
        this.F = this.y.q();
      }
    }
  }
  
  private void v0()
  {
    if (this.T == null)
    {
      localObject1 = this.t0;
      if ((localObject1 == null) || (((CopyOnWriteArrayList)localObject1).isEmpty())) {
        return;
      }
    }
    this.z0 = false;
    Object localObject1 = this.c1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject1).next();
      Object localObject2 = this.T;
      if (localObject2 != null) {
        ((j)localObject2).d(this, localInteger.intValue());
      }
      localObject2 = this.t0;
      if (localObject2 != null)
      {
        localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((j)((Iterator)localObject2).next()).d(this, localInteger.intValue());
        }
      }
    }
    this.c1.clear();
  }
  
  public void C0(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (this.y == null) {
      return;
    }
    if (this.N == paramFloat1) {
      return;
    }
    this.b0 = true;
    this.K = getNanoTime();
    this.L = (this.y.p() / 1000.0F);
    this.P = paramFloat1;
    this.R = true;
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if ((paramInt == 6) || (paramInt == 7)) {
            break label211;
          }
          break label344;
        }
        if (!N0(paramFloat2, this.N, this.y.u()))
        {
          this.c0.b(this.N, paramFloat1, paramFloat2, this.L, this.y.u(), this.y.v());
          this.B = 0.0F;
        }
      }
    }
    for (;;)
    {
      paramInt = this.E;
      this.P = paramFloat1;
      this.E = paramInt;
      Object localObject = this.c0;
      break label202;
      this.d0.b(paramFloat2, this.N, this.y.u());
      localObject = this.d0;
      label202:
      this.z = ((Interpolator)localObject);
      break;
      label211:
      if ((paramInt != 1) && (paramInt != 7))
      {
        if ((paramInt == 2) || (paramInt == 6)) {
          paramFloat1 = 1.0F;
        }
      }
      else {
        paramFloat1 = 0.0F;
      }
      paramInt = this.y.k();
      localObject = this.c0;
      float f = this.N;
      if (paramInt == 0) {
        ((n0.b)localObject).b(f, paramFloat1, paramFloat2, this.L, this.y.u(), this.y.v());
      } else {
        ((n0.b)localObject).d(f, paramFloat1, paramFloat2, this.y.B(), this.y.C(), this.y.A(), this.y.D(), this.y.z());
      }
    }
    label344:
    this.Q = false;
    this.K = getNanoTime();
    invalidate();
  }
  
  public void D0()
  {
    Y(1.0F);
    this.L0 = null;
  }
  
  public void E0(Runnable paramRunnable)
  {
    Y(1.0F);
    this.L0 = paramRunnable;
  }
  
  public void F0()
  {
    Y(0.0F);
  }
  
  public void G0(int paramInt)
  {
    if (!isAttachedToWindow())
    {
      if (this.K0 == null) {
        this.K0 = new i();
      }
      this.K0.d(paramInt);
      return;
    }
    I0(paramInt, -1, -1);
  }
  
  public void H0(int paramInt1, int paramInt2)
  {
    if (!isAttachedToWindow())
    {
      if (this.K0 == null) {
        this.K0 = new i();
      }
      this.K0.d(paramInt1);
      return;
    }
    J0(paramInt1, -1, -1, paramInt2);
  }
  
  public void I0(int paramInt1, int paramInt2, int paramInt3)
  {
    J0(paramInt1, paramInt2, paramInt3, -1);
  }
  
  public void J0(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.y;
    int i = paramInt1;
    if (localObject != null)
    {
      localObject = ((p)localObject).b;
      i = paramInt1;
      if (localObject != null)
      {
        paramInt2 = ((androidx.constraintlayout.widget.f)localObject).a(this.E, paramInt1, paramInt2, paramInt3);
        i = paramInt1;
        if (paramInt2 != -1) {
          i = paramInt2;
        }
      }
    }
    paramInt1 = this.E;
    if (paramInt1 == i) {
      return;
    }
    if (this.C == i)
    {
      Y(0.0F);
      if (paramInt4 > 0) {
        this.L = (paramInt4 / 1000.0F);
      }
      return;
    }
    if (this.F == i)
    {
      Y(1.0F);
      if (paramInt4 > 0) {
        this.L = (paramInt4 / 1000.0F);
      }
      return;
    }
    this.F = i;
    if (paramInt1 != -1)
    {
      z0(paramInt1, i);
      Y(1.0F);
      this.N = 0.0F;
      D0();
      if (paramInt4 > 0) {
        this.L = (paramInt4 / 1000.0F);
      }
      return;
    }
    paramInt3 = 0;
    this.b0 = false;
    this.P = 1.0F;
    this.M = 0.0F;
    this.N = 0.0F;
    this.O = getNanoTime();
    this.K = getNanoTime();
    this.Q = false;
    this.z = null;
    if (paramInt4 == -1) {
      this.L = (this.y.p() / 1000.0F);
    }
    this.C = -1;
    this.y.X(-1, this.F);
    localObject = new SparseArray();
    if (paramInt4 == 0) {
      paramInt4 = this.y.p();
    }
    while (paramInt4 > 0)
    {
      this.L = (paramInt4 / 1000.0F);
      break;
    }
    paramInt4 = getChildCount();
    this.J.clear();
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      View localView = getChildAt(paramInt1);
      m localm = new m(localView);
      this.J.put(localView, localm);
      ((SparseArray)localObject).put(localView.getId(), (m)this.J.get(localView));
      paramInt1 += 1;
    }
    this.R = true;
    this.X0.e(this.c, null, this.y.l(i));
    w0();
    this.X0.a();
    e0();
    paramInt2 = getWidth();
    i = getHeight();
    if (this.s0 != null)
    {
      paramInt1 = 0;
      while (paramInt1 < paramInt4)
      {
        localObject = (m)this.J.get(getChildAt(paramInt1));
        if (localObject != null) {
          this.y.t((m)localObject);
        }
        paramInt1 += 1;
      }
      localObject = this.s0.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MotionHelper)((Iterator)localObject).next()).D(this, this.J);
      }
      paramInt1 = 0;
      while (paramInt1 < paramInt4)
      {
        localObject = (m)this.J.get(getChildAt(paramInt1));
        if (localObject != null) {
          ((m)localObject).I(paramInt2, i, this.L, getNanoTime());
        }
        paramInt1 += 1;
      }
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      localObject = (m)this.J.get(getChildAt(paramInt1));
      if (localObject != null)
      {
        this.y.t((m)localObject);
        ((m)localObject).I(paramInt2, i, this.L, getNanoTime());
      }
      paramInt1 += 1;
    }
    float f3 = this.y.E();
    if (f3 != 0.0F)
    {
      float f2 = 3.4028235E+38F;
      float f1 = -3.402824E+038F;
      paramInt1 = 0;
      float f4;
      for (;;)
      {
        paramInt2 = paramInt3;
        if (paramInt1 >= paramInt4) {
          break;
        }
        localObject = (m)this.J.get(getChildAt(paramInt1));
        f4 = ((m)localObject).n();
        f4 = ((m)localObject).o() + f4;
        f2 = Math.min(f2, f4);
        f1 = Math.max(f1, f4);
        paramInt1 += 1;
      }
      while (paramInt2 < paramInt4)
      {
        localObject = (m)this.J.get(getChildAt(paramInt2));
        f4 = ((m)localObject).n();
        float f5 = ((m)localObject).o();
        ((m)localObject).o = (1.0F / (1.0F - f3));
        ((m)localObject).n = (f3 - (f4 + f5 - f2) * f3 / (f1 - f2));
        paramInt2 += 1;
      }
    }
    this.M = 0.0F;
    this.N = 0.0F;
    this.R = true;
    invalidate();
  }
  
  public void K0()
  {
    this.X0.e(this.c, this.y.l(this.C), this.y.l(this.F));
    w0();
  }
  
  public void L0(int paramInt, c paramc)
  {
    p localp = this.y;
    if (localp != null) {
      localp.U(paramInt, paramc);
    }
    K0();
    if (this.E == paramInt) {
      paramc.i(this);
    }
  }
  
  public void M0(int paramInt, View... paramVarArgs)
  {
    p localp = this.y;
    if (localp != null)
    {
      localp.c0(paramInt, paramVarArgs);
      return;
    }
    Log.e("MotionLayout", " no motionScene");
  }
  
  void Y(float paramFloat)
  {
    p localp = this.y;
    if (localp == null) {
      return;
    }
    float f1 = this.N;
    float f2 = this.M;
    if ((f1 != f2) && (this.Q)) {
      this.N = f2;
    }
    f1 = this.N;
    if (f1 == paramFloat) {
      return;
    }
    this.b0 = false;
    this.P = paramFloat;
    this.L = (localp.p() / 1000.0F);
    setProgress(this.P);
    this.z = null;
    this.A = this.y.s();
    this.Q = false;
    this.K = getNanoTime();
    this.R = true;
    this.M = f1;
    this.N = f1;
    invalidate();
  }
  
  public boolean Z(int paramInt, m paramm)
  {
    p localp = this.y;
    if (localp != null) {
      return localp.g(paramInt, paramm);
    }
    return false;
  }
  
  public void c(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    this.n0 = getNanoTime();
    this.o0 = 0.0F;
    this.l0 = 0.0F;
    this.m0 = 0.0F;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = this.s0;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MotionHelper)((Iterator)localObject).next()).C(paramCanvas);
      }
    }
    g0(false);
    localObject = this.y;
    if (localObject != null)
    {
      localObject = ((p)localObject).s;
      if (localObject != null) {
        ((t)localObject).c();
      }
    }
    super.dispatchDraw(paramCanvas);
    if (this.y == null) {
      return;
    }
    if (((this.W & 0x1) == 1) && (!isInEditMode()))
    {
      this.u0 += 1;
      long l1 = getNanoTime();
      long l2 = this.v0;
      if (l2 != -1L)
      {
        l2 = l1 - l2;
        if (l2 > 200000000L)
        {
          this.w0 = ((int)(this.u0 / ((float)l2 * 1.0E-009F) * 100.0F) / 100.0F);
          this.u0 = 0;
        }
      }
      else
      {
        this.v0 = l1;
      }
      Paint localPaint = new Paint();
      localPaint.setTextSize(42.0F);
      float f = (int)(getProgress() * 1000.0F) / 10.0F;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.w0);
      ((StringBuilder)localObject).append(" fps ");
      ((StringBuilder)localObject).append(a.e(this, this.C));
      ((StringBuilder)localObject).append(" -> ");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(a.e(this, this.F));
      localStringBuilder.append(" (progress: ");
      localStringBuilder.append(f);
      localStringBuilder.append(" ) state=");
      int i = this.E;
      if (i == -1) {
        localObject = "undefined";
      } else {
        localObject = a.e(this, i);
      }
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
      localPaint.setColor(-16777216);
      paramCanvas.drawText((String)localObject, 11.0F, getHeight() - 29, localPaint);
      localPaint.setColor(-7864184);
      paramCanvas.drawText((String)localObject, 10.0F, getHeight() - 30, localPaint);
    }
    if (this.W > 1)
    {
      if (this.a0 == null) {
        this.a0 = new e();
      }
      this.a0.a(paramCanvas, this.J, this.y.p(), this.W);
    }
    localObject = this.s0;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MotionHelper)((Iterator)localObject).next()).B(paramCanvas);
      }
    }
  }
  
  void f0(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      localObject = (m)this.J.get(localObject);
      if (localObject != null) {
        ((m)localObject).f(paramBoolean);
      }
      i += 1;
    }
  }
  
  void g0(boolean paramBoolean)
  {
    if (this.O == -1L) {
      this.O = getNanoTime();
    }
    float f1 = this.N;
    if ((f1 > 0.0F) && (f1 < 1.0F)) {
      this.E = -1;
    }
    boolean bool3 = this.p0;
    int m = 1;
    boolean bool2 = false;
    int j = 0;
    boolean bool1;
    if (!bool3)
    {
      bool1 = bool2;
      if (!this.R) {
        break label1147;
      }
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (this.P == f1) {
          break label1147;
        }
      }
    }
    float f4 = Math.signum(this.P - f1);
    long l = getNanoTime();
    Object localObject1 = this.z;
    if (!(localObject1 instanceof n)) {
      f2 = (float)(l - this.O) * f4 * 1.0E-009F / this.L;
    } else {
      f2 = 0.0F;
    }
    f1 = this.N + f2;
    if (this.Q) {
      f1 = this.P;
    }
    bool2 = f4 < 0.0F;
    if (((bool2) && (f1 >= this.P)) || ((f4 <= 0.0F) && (f1 <= this.P)))
    {
      f1 = this.P;
      this.R = false;
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    this.N = f1;
    this.M = f1;
    this.O = l;
    float f3;
    Object localObject2;
    if ((localObject1 != null) && (!bool1))
    {
      if (this.b0)
      {
        f3 = ((Interpolator)localObject1).getInterpolation((float)(l - this.K) * 1.0E-009F);
        localObject1 = this.z;
        localObject2 = this.c0;
        if (localObject1 == localObject2)
        {
          if (((n0.b)localObject2).c()) {
            i = 2;
          } else {
            i = 1;
          }
        }
        else {
          i = 0;
        }
        this.N = f3;
        this.O = l;
        localObject1 = this.z;
        f2 = f3;
        if ((localObject1 instanceof n))
        {
          float f5 = ((n)localObject1).a();
          this.B = f5;
          if ((Math.abs(f5) * this.L <= 1.0E-005F) && (i == 2)) {
            this.R = false;
          }
          f1 = f3;
          if (f5 > 0.0F)
          {
            f1 = f3;
            if (f3 >= 1.0F)
            {
              this.N = 1.0F;
              this.R = false;
              f1 = 1.0F;
            }
          }
          f2 = f1;
          if (f5 < 0.0F)
          {
            f2 = f1;
            if (f1 <= 0.0F)
            {
              this.N = 0.0F;
              this.R = false;
              f1 = 0.0F;
              break label532;
            }
          }
        }
        f1 = f2;
        break label532;
      }
      f3 = ((Interpolator)localObject1).getInterpolation(f1);
      localObject1 = this.z;
      if ((localObject1 instanceof n)) {
        f1 = ((n)localObject1).a();
      } else {
        f1 = (((Interpolator)localObject1).getInterpolation(f1 + f2) - f3) * f4 / f2;
      }
      this.B = f1;
      f1 = f3;
    }
    else
    {
      this.B = f2;
    }
    int i = 0;
    label532:
    if (Math.abs(this.B) > 1.0E-005F) {
      setState(k.c);
    }
    float f2 = f1;
    if (i != 1)
    {
      if ((!bool2) || (f1 < this.P))
      {
        f3 = f1;
        if (f4 <= 0.0F)
        {
          f3 = f1;
          if (f1 > this.P) {}
        }
      }
      else
      {
        f3 = this.P;
        this.R = false;
      }
      if (f3 < 1.0F)
      {
        f2 = f3;
        if (f3 > 0.0F) {}
      }
      else
      {
        this.R = false;
        setState(k.d);
        f2 = f3;
      }
    }
    int n = getChildCount();
    this.p0 = false;
    l = getNanoTime();
    this.H0 = f2;
    localObject1 = this.A;
    if (localObject1 == null) {
      f1 = f2;
    } else {
      f1 = ((Interpolator)localObject1).getInterpolation(f2);
    }
    localObject1 = this.A;
    if (localObject1 != null)
    {
      f3 = ((Interpolator)localObject1).getInterpolation(f4 / this.L + f2);
      this.B = f3;
      this.B = (f3 - this.A.getInterpolation(f2));
    }
    i = 0;
    while (i < n)
    {
      localObject1 = getChildAt(i);
      localObject2 = (m)this.J.get(localObject1);
      if (localObject2 != null)
      {
        paramBoolean = this.p0;
        this.p0 = (((m)localObject2).x((View)localObject1, f1, l, this.I0) | paramBoolean);
      }
      i += 1;
    }
    if (((bool2) && (f2 >= this.P)) || ((f4 <= 0.0F) && (f2 <= this.P))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!this.p0) && (!this.R) && (i != 0)) {
      setState(k.d);
    }
    if (this.A0) {
      requestLayout();
    }
    this.p0 = (i ^ 0x1 | this.p0);
    i = j;
    if (f2 <= 0.0F)
    {
      n = this.C;
      i = j;
      if (n != -1)
      {
        i = j;
        if (this.E != n)
        {
          this.E = n;
          this.y.l(n).g(this);
          setState(k.d);
          i = 1;
        }
      }
    }
    j = i;
    if (f2 >= 1.0D)
    {
      n = this.E;
      int i1 = this.F;
      j = i;
      if (n != i1)
      {
        this.E = i1;
        this.y.l(i1).g(this);
        setState(k.d);
        j = 1;
      }
    }
    if ((!this.p0) && (!this.R))
    {
      if (((bool2) && (f2 == 1.0F)) || ((f4 < 0.0F) && (f2 == 0.0F))) {
        setState(k.d);
      }
    }
    else {
      invalidate();
    }
    i = j;
    if (!this.p0)
    {
      i = j;
      if (!this.R) {
        if ((!bool2) || (f2 != 1.0F))
        {
          i = j;
          if (f4 < 0.0F)
          {
            i = j;
            if (f2 != 0.0F) {}
          }
        }
        else
        {
          u0();
          i = j;
        }
      }
    }
    label1147:
    f1 = this.N;
    int k;
    if (f1 >= 1.0F)
    {
      n = this.E;
      k = this.F;
      j = k;
      if (n != k)
      {
        j = k;
        i = m;
      }
    }
    for (;;)
    {
      this.E = j;
      j = i;
      break;
      j = i;
      if (f1 > 0.0F) {
        break;
      }
      n = this.E;
      k = this.C;
      j = k;
      if (n != k)
      {
        j = k;
        i = m;
      }
    }
    this.Y0 |= j;
    if ((j != 0) && (!this.J0)) {
      requestLayout();
    }
    this.M = this.N;
  }
  
  public int[] getConstraintSetIds()
  {
    p localp = this.y;
    if (localp == null) {
      return null;
    }
    return localp.n();
  }
  
  public int getCurrentState()
  {
    return this.E;
  }
  
  public ArrayList<p.b> getDefinedTransitions()
  {
    p localp = this.y;
    if (localp == null) {
      return null;
    }
    return localp.o();
  }
  
  public b getDesignTool()
  {
    if (this.e0 == null) {
      this.e0 = new b(this);
    }
    return this.e0;
  }
  
  public int getEndState()
  {
    return this.F;
  }
  
  protected long getNanoTime()
  {
    return System.nanoTime();
  }
  
  public float getProgress()
  {
    return this.N;
  }
  
  public p getScene()
  {
    return this.y;
  }
  
  public int getStartState()
  {
    return this.C;
  }
  
  public float getTargetPosition()
  {
    return this.P;
  }
  
  public Bundle getTransitionState()
  {
    if (this.K0 == null) {
      this.K0 = new i();
    }
    this.K0.c();
    return this.K0.b();
  }
  
  public long getTransitionTimeMs()
  {
    p localp = this.y;
    if (localp != null) {
      this.L = (localp.p() / 1000.0F);
    }
    return (this.L * 1000.0F);
  }
  
  public float getVelocity()
  {
    return this.B;
  }
  
  public void i(View paramView, int paramInt)
  {
    paramView = this.y;
    if (paramView != null)
    {
      float f = this.o0;
      if (f == 0.0F) {
        return;
      }
      paramView.Q(this.l0 / f, this.m0 / f);
    }
  }
  
  public boolean isAttachedToWindow()
  {
    return super.isAttachedToWindow();
  }
  
  public void j(final View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    p localp = this.y;
    if (localp == null) {
      return;
    }
    p.b localb = localp.c;
    if (localb != null)
    {
      if (!localb.C()) {
        return;
      }
      boolean bool = localb.C();
      int i = -1;
      q localq;
      if (bool)
      {
        localq = localb.B();
        if (localq != null)
        {
          paramInt3 = localq.q();
          if ((paramInt3 != -1) && (paramView.getId() != paramInt3)) {
            return;
          }
        }
      }
      if (localp.w())
      {
        localq = localb.B();
        paramInt3 = i;
        if (localq != null)
        {
          paramInt3 = i;
          if ((localq.e() & 0x4) != 0) {
            paramInt3 = paramInt2;
          }
        }
        f1 = this.M;
        if (((f1 == 1.0F) || (f1 == 0.0F)) && (paramView.canScrollVertically(paramInt3))) {
          return;
        }
      }
      if ((localb.B() != null) && ((localb.B().e() & 0x1) != 0))
      {
        f1 = localp.x(paramInt1, paramInt2);
        f2 = this.N;
        if (((f2 <= 0.0F) && (f1 < 0.0F)) || ((f2 >= 1.0F) && (f1 > 0.0F)))
        {
          paramView.setNestedScrollingEnabled(false);
          paramView.post(new a(paramView));
          return;
        }
      }
      float f1 = this.M;
      long l = getNanoTime();
      float f2 = paramInt1;
      this.l0 = f2;
      float f3 = paramInt2;
      this.m0 = f3;
      this.o0 = ((float)((l - this.n0) * 1.E-009D));
      this.n0 = l;
      localp.P(f2, f3);
      if (f1 != this.M)
      {
        paramArrayOfInt[0] = paramInt1;
        paramArrayOfInt[1] = paramInt2;
      }
      g0(false);
      if ((paramArrayOfInt[0] != 0) || (paramArrayOfInt[1] != 0)) {
        this.k0 = true;
      }
    }
  }
  
  protected void j0()
  {
    if (this.T == null)
    {
      localObject = this.t0;
      if ((localObject == null) || (((CopyOnWriteArrayList)localObject).isEmpty())) {}
    }
    else if (this.x0 == -1)
    {
      this.x0 = this.E;
      int i;
      if (!this.c1.isEmpty())
      {
        localObject = this.c1;
        i = ((Integer)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).intValue();
      }
      else
      {
        i = -1;
      }
      int j = this.E;
      if ((i != j) && (j != -1)) {
        this.c1.add(Integer.valueOf(j));
      }
    }
    v0();
    Object localObject = this.L0;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    localObject = this.M0;
    if ((localObject != null) && (this.N0 > 0))
    {
      G0(localObject[0]);
      localObject = this.M0;
      System.arraycopy(localObject, 1, localObject, 0, localObject.length - 1);
      this.N0 -= 1;
    }
  }
  
  public void k0(int paramInt, boolean paramBoolean, float paramFloat)
  {
    Object localObject = this.T;
    if (localObject != null) {
      ((j)localObject).c(this, paramInt, paramBoolean, paramFloat);
    }
    localObject = this.t0;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((j)((Iterator)localObject).next()).c(this, paramInt, paramBoolean, paramFloat);
      }
    }
  }
  
  void l0(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat)
  {
    Object localObject2 = this.J;
    Object localObject1 = l(paramInt);
    localObject2 = (m)((HashMap)localObject2).get(localObject1);
    if (localObject2 != null)
    {
      ((m)localObject2).l(paramFloat1, paramFloat2, paramFloat3, paramArrayOfFloat);
      paramFloat2 = ((View)localObject1).getY();
      this.U = paramFloat1;
      this.V = paramFloat2;
      return;
    }
    if (localObject1 == null)
    {
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("");
      paramArrayOfFloat.append(paramInt);
      paramArrayOfFloat = paramArrayOfFloat.toString();
    }
    else
    {
      paramArrayOfFloat = ((View)localObject1).getContext().getResources().getResourceName(paramInt);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("WARNING could not find view id ");
    ((StringBuilder)localObject1).append(paramArrayOfFloat);
    Log.w("MotionLayout", ((StringBuilder)localObject1).toString());
  }
  
  public void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    if ((this.k0) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      paramArrayOfInt[0] += paramInt3;
      paramArrayOfInt[1] += paramInt4;
    }
    this.k0 = false;
  }
  
  public c m0(int paramInt)
  {
    p localp = this.y;
    if (localp == null) {
      return null;
    }
    return localp.l(paramInt);
  }
  
  public void n(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  m n0(int paramInt)
  {
    return (m)this.J.get(findViewById(paramInt));
  }
  
  public boolean o(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    paramView1 = this.y;
    if (paramView1 != null)
    {
      paramView1 = paramView1.c;
      if ((paramView1 != null) && (paramView1.B() != null) && ((this.y.c.B().e() & 0x2) == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public p.b o0(int paramInt)
  {
    return this.y.G(paramInt);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject1 = getDisplay();
    if (localObject1 != null) {
      this.T0 = ((Display)localObject1).getRotation();
    }
    localObject1 = this.y;
    if (localObject1 != null)
    {
      int i = this.E;
      if (i != -1)
      {
        localObject1 = ((p)localObject1).l(i);
        this.y.T(this);
        Object localObject2 = this.s0;
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((MotionHelper)((Iterator)localObject2).next()).A(this);
          }
        }
        if (localObject1 != null) {
          ((c)localObject1).i(this);
        }
        this.C = this.E;
      }
    }
    u0();
    localObject1 = this.K0;
    if (localObject1 != null)
    {
      if (this.V0)
      {
        post(new b());
        return;
      }
      ((i)localObject1).a();
      return;
    }
    localObject1 = this.y;
    if (localObject1 != null)
    {
      localObject1 = ((p)localObject1).c;
      if ((localObject1 != null) && (((p.b)localObject1).x() == 4))
      {
        D0();
        setState(k.b);
        setState(k.c);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      if (!this.I) {
        return false;
      }
      localObject = ((p)localObject).s;
      if (localObject != null) {
        ((t)localObject).h(paramMotionEvent);
      }
      localObject = this.y.c;
      if ((localObject != null) && (((p.b)localObject).C()))
      {
        localObject = ((p.b)localObject).B();
        if (localObject != null)
        {
          if (paramMotionEvent.getAction() == 0)
          {
            RectF localRectF = ((q)localObject).p(this, new RectF());
            if ((localRectF != null) && (!localRectF.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
              return false;
            }
          }
          int i = ((q)localObject).q();
          if (i != -1)
          {
            localObject = this.a1;
            if ((localObject == null) || (((View)localObject).getId() != i)) {
              this.a1 = findViewById(i);
            }
            localObject = this.a1;
            if (localObject != null)
            {
              this.Z0.set(((View)localObject).getLeft(), this.a1.getTop(), this.a1.getRight(), this.a1.getBottom());
              if ((this.Z0.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!q0(this.a1.getLeft(), this.a1.getTop(), this.a1, paramMotionEvent))) {
                return onTouchEvent(paramMotionEvent);
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.J0 = true;
    try
    {
      if (this.y == null)
      {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      paramInt1 = paramInt3 - paramInt1;
      paramInt2 = paramInt4 - paramInt2;
      if ((this.i0 != paramInt1) || (this.j0 != paramInt2))
      {
        w0();
        g0(true);
      }
      this.i0 = paramInt1;
      this.j0 = paramInt2;
      this.g0 = paramInt1;
      this.h0 = paramInt2;
      return;
    }
    finally
    {
      this.J0 = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.y == null)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = this.G;
    int j = 0;
    if ((i == paramInt1) && (this.H == paramInt2)) {
      i = 0;
    } else {
      i = 1;
    }
    if (this.Y0)
    {
      this.Y0 = false;
      u0();
      v0();
      i = 1;
    }
    if (this.h) {
      i = 1;
    }
    this.G = paramInt1;
    this.H = paramInt2;
    int k = this.y.F();
    int m = this.y.q();
    if (((i != 0) || (this.X0.f(k, m))) && (this.C != -1))
    {
      super.onMeasure(paramInt1, paramInt2);
      this.X0.e(this.c, this.y.l(k), this.y.l(m));
      this.X0.h();
      this.X0.i(k, m);
      paramInt1 = j;
    }
    else
    {
      if (i != 0) {
        super.onMeasure(paramInt1, paramInt2);
      }
      paramInt1 = 1;
    }
    if ((this.A0) || (paramInt1 != 0))
    {
      paramInt2 = getPaddingTop();
      i = getPaddingBottom();
      paramInt1 = getPaddingLeft();
      j = getPaddingRight();
      paramInt1 = this.c.Y() + (paramInt1 + j);
      paramInt2 = this.c.z() + (paramInt2 + i);
      i = this.F0;
      if ((i == -2147483648) || (i == 0))
      {
        paramInt1 = this.B0;
        paramInt1 = (int)(paramInt1 + this.H0 * (this.D0 - paramInt1));
        requestLayout();
      }
      i = this.G0;
      if ((i == -2147483648) || (i == 0))
      {
        paramInt2 = this.C0;
        paramInt2 = (int)(paramInt2 + this.H0 * (this.E0 - paramInt2));
        requestLayout();
      }
      setMeasuredDimension(paramInt1, paramInt2);
    }
    h0();
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    p localp = this.y;
    if (localp != null) {
      localp.W(r());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.y;
    if ((localObject != null) && (this.I) && (((p)localObject).b0()))
    {
      localObject = this.y.c;
      if ((localObject != null) && (!((p.b)localObject).C())) {
        return super.onTouchEvent(paramMotionEvent);
      }
      this.y.R(paramMotionEvent, getCurrentState(), this);
      if (this.y.c.D(4)) {
        return this.y.c.B().r();
      }
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    if ((paramView instanceof MotionHelper))
    {
      paramView = (MotionHelper)paramView;
      if (this.t0 == null) {
        this.t0 = new CopyOnWriteArrayList();
      }
      this.t0.add(paramView);
      if (paramView.z())
      {
        if (this.q0 == null) {
          this.q0 = new ArrayList();
        }
        this.q0.add(paramView);
      }
      if (paramView.y())
      {
        if (this.r0 == null) {
          this.r0 = new ArrayList();
        }
        this.r0.add(paramView);
      }
      if (paramView.x())
      {
        if (this.s0 == null) {
          this.s0 = new ArrayList();
        }
        this.s0.add(paramView);
      }
    }
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    ArrayList localArrayList = this.q0;
    if (localArrayList != null) {
      localArrayList.remove(paramView);
    }
    localArrayList = this.r0;
    if (localArrayList != null) {
      localArrayList.remove(paramView);
    }
  }
  
  public void p0(View paramView, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat, int paramInt)
  {
    float f1 = this.B;
    float f2 = this.N;
    if (this.z != null)
    {
      f1 = Math.signum(this.P - f2);
      float f3 = this.z.getInterpolation(this.N + 1.0E-005F);
      f2 = this.z.getInterpolation(this.N);
      f1 = f1 * ((f3 - f2) / 1.0E-005F) / this.L;
    }
    Object localObject = this.z;
    if ((localObject instanceof n)) {
      f1 = ((n)localObject).a();
    }
    localObject = (m)this.J.get(paramView);
    if ((paramInt & 0x1) == 0) {
      ((m)localObject).r(f2, paramView.getWidth(), paramView.getHeight(), paramFloat1, paramFloat2, paramArrayOfFloat);
    } else {
      ((m)localObject).l(f2, paramFloat1, paramFloat2, paramArrayOfFloat);
    }
    if (paramInt < 2)
    {
      paramArrayOfFloat[0] *= f1;
      paramArrayOfFloat[1] *= f1;
    }
  }
  
  public void requestLayout()
  {
    if ((!this.A0) && (this.E == -1))
    {
      Object localObject = this.y;
      if (localObject != null)
      {
        localObject = ((p)localObject).c;
        if (localObject != null)
        {
          int i = ((p.b)localObject).z();
          if (i == 0) {
            return;
          }
          if (i == 2)
          {
            int j = getChildCount();
            i = 0;
            while (i < j)
            {
              localObject = getChildAt(i);
              ((m)this.J.get(localObject)).z();
              i += 1;
            }
            return;
          }
        }
      }
    }
    super.requestLayout();
  }
  
  public boolean s0()
  {
    return this.I;
  }
  
  public void setDebugMode(int paramInt)
  {
    this.W = paramInt;
    invalidate();
  }
  
  public void setDelayedApplicationOfInitialState(boolean paramBoolean)
  {
    this.V0 = paramBoolean;
  }
  
  public void setInteractionEnabled(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void setInterpolatedProgress(float paramFloat)
  {
    if (this.y != null)
    {
      setState(k.c);
      Interpolator localInterpolator = this.y.s();
      if (localInterpolator != null)
      {
        setProgress(localInterpolator.getInterpolation(paramFloat));
        return;
      }
    }
    setProgress(paramFloat);
  }
  
  public void setOnHide(float paramFloat)
  {
    ArrayList localArrayList = this.r0;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((MotionHelper)this.r0.get(i)).setProgress(paramFloat);
        i += 1;
      }
    }
  }
  
  public void setOnShow(float paramFloat)
  {
    ArrayList localArrayList = this.q0;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((MotionHelper)this.q0.get(i)).setProgress(paramFloat);
        i += 1;
      }
    }
  }
  
  public void setProgress(float paramFloat)
  {
    boolean bool = paramFloat < 0.0F;
    if ((bool) || (paramFloat > 1.0F)) {
      Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
    }
    if (!isAttachedToWindow())
    {
      if (this.K0 == null) {
        this.K0 = new i();
      }
      this.K0.e(paramFloat);
      return;
    }
    if (!bool)
    {
      if ((this.N == 1.0F) && (this.E == this.F)) {
        setState(k.c);
      }
      this.E = this.C;
      if (this.N != 0.0F) {}
    }
    else
    {
      for (;;)
      {
        localk = k.d;
        break label176;
        if (paramFloat < 1.0F) {
          break;
        }
        if ((this.N == 0.0F) && (this.E == this.C)) {
          setState(k.c);
        }
        this.E = this.F;
        if (this.N != 1.0F) {
          break label181;
        }
      }
      this.E = -1;
      k localk = k.c;
      label176:
      setState(localk);
    }
    label181:
    if (this.y == null) {
      return;
    }
    this.Q = true;
    this.P = paramFloat;
    this.M = paramFloat;
    this.O = -1L;
    this.K = -1L;
    this.z = null;
    this.R = true;
    invalidate();
  }
  
  public void setScene(p paramp)
  {
    this.y = paramp;
    paramp.W(r());
    w0();
  }
  
  void setStartState(int paramInt)
  {
    if (!isAttachedToWindow())
    {
      if (this.K0 == null) {
        this.K0 = new i();
      }
      this.K0.f(paramInt);
      this.K0.d(paramInt);
      return;
    }
    this.E = paramInt;
  }
  
  void setState(k paramk)
  {
    k localk1 = k.d;
    if ((paramk == localk1) && (this.E == -1)) {
      return;
    }
    k localk2 = this.W0;
    this.W0 = paramk;
    k localk3 = k.c;
    if ((localk2 == localk3) && (paramk == localk3)) {
      i0();
    }
    int i = c.a[localk2.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (i != 3) {
        return;
      }
      if (paramk != localk1) {}
    }
    else
    {
      do
      {
        j0();
        return;
        if (paramk == localk3) {
          i0();
        }
      } while (paramk == localk1);
    }
  }
  
  public void setTransition(int paramInt)
  {
    if (this.y != null)
    {
      Object localObject = o0(paramInt);
      this.C = ((p.b)localObject).A();
      this.F = ((p.b)localObject).y();
      if (!isAttachedToWindow())
      {
        if (this.K0 == null) {
          this.K0 = new i();
        }
        this.K0.f(this.C);
        this.K0.d(this.F);
        return;
      }
      float f1 = (0.0F / 0.0F);
      paramInt = this.E;
      int i = this.C;
      float f2 = 0.0F;
      if (paramInt == i) {
        f1 = 0.0F;
      } else if (paramInt == this.F) {
        f1 = 1.0F;
      }
      this.y.Y((p.b)localObject);
      this.X0.e(this.c, this.y.l(this.C), this.y.l(this.F));
      w0();
      if (this.N != f1)
      {
        if (f1 == 0.0F)
        {
          f0(true);
          localObject = this.y;
        }
        for (paramInt = this.C;; paramInt = this.F)
        {
          ((p)localObject).l(paramInt).i(this);
          break;
          if (f1 != 1.0F) {
            break;
          }
          f0(false);
          localObject = this.y;
        }
      }
      if (!Float.isNaN(f1)) {
        f2 = f1;
      }
      this.N = f2;
      if (Float.isNaN(f1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a.b());
        ((StringBuilder)localObject).append(" transitionToStart ");
        Log.v("MotionLayout", ((StringBuilder)localObject).toString());
        F0();
        return;
      }
      setProgress(f1);
    }
  }
  
  protected void setTransition(p.b paramb)
  {
    this.y.Y(paramb);
    setState(k.b);
    float f;
    if (this.E == this.y.q()) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    this.N = f;
    this.M = f;
    this.P = f;
    long l;
    if (paramb.D(1)) {
      l = -1L;
    } else {
      l = getNanoTime();
    }
    this.O = l;
    int i = this.y.F();
    int j = this.y.q();
    if ((i == this.C) && (j == this.F)) {
      return;
    }
    this.C = i;
    this.F = j;
    this.y.X(i, j);
    this.X0.e(this.c, this.y.l(this.C), this.y.l(this.F));
    this.X0.i(this.C, this.F);
    this.X0.h();
    w0();
  }
  
  public void setTransitionDuration(int paramInt)
  {
    p localp = this.y;
    if (localp == null)
    {
      Log.e("MotionLayout", "MotionScene not defined");
      return;
    }
    localp.V(paramInt);
  }
  
  public void setTransitionListener(j paramj)
  {
    this.T = paramj;
  }
  
  public void setTransitionState(Bundle paramBundle)
  {
    if (this.K0 == null) {
      this.K0 = new i();
    }
    this.K0.g(paramBundle);
    if (isAttachedToWindow()) {
      this.K0.a();
    }
  }
  
  protected void t(int paramInt)
  {
    this.k = null;
  }
  
  protected g t0()
  {
    return h.f();
  }
  
  public String toString()
  {
    Context localContext = getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.c(localContext, this.C));
    localStringBuilder.append("->");
    localStringBuilder.append(a.c(localContext, this.F));
    localStringBuilder.append(" (pos:");
    localStringBuilder.append(this.N);
    localStringBuilder.append(" Dpos/Dt:");
    localStringBuilder.append(this.B);
    return localStringBuilder.toString();
  }
  
  void u0()
  {
    p localp = this.y;
    if (localp == null) {
      return;
    }
    if (localp.h(this, this.E))
    {
      requestLayout();
      return;
    }
    int i = this.E;
    if (i != -1) {
      this.y.f(this, i);
    }
    if (this.y.b0()) {
      this.y.Z();
    }
  }
  
  public void w0()
  {
    this.X0.h();
    invalidate();
  }
  
  public void x0(float paramFloat1, float paramFloat2)
  {
    if (!isAttachedToWindow())
    {
      if (this.K0 == null) {
        this.K0 = new i();
      }
      this.K0.e(paramFloat1);
      this.K0.h(paramFloat2);
      return;
    }
    setProgress(paramFloat1);
    setState(k.c);
    this.B = paramFloat2;
    float f = 0.0F;
    boolean bool = paramFloat2 < 0.0F;
    if (bool)
    {
      paramFloat2 = f;
      if (!bool) {}
    }
    for (;;)
    {
      paramFloat2 = 1.0F;
      do
      {
        Y(paramFloat2);
        return;
        if ((paramFloat1 == 0.0F) || (paramFloat1 == 1.0F)) {
          break;
        }
        paramFloat2 = f;
      } while (paramFloat1 <= 0.5F);
    }
  }
  
  public void y0(int paramInt1, int paramInt2, int paramInt3)
  {
    setState(k.b);
    this.E = paramInt1;
    this.C = -1;
    this.F = -1;
    Object localObject = this.k;
    if (localObject != null)
    {
      ((androidx.constraintlayout.widget.b)localObject).d(paramInt1, paramInt2, paramInt3);
      return;
    }
    localObject = this.y;
    if (localObject != null) {
      ((p)localObject).l(paramInt1).i(this);
    }
  }
  
  public void z0(int paramInt1, int paramInt2)
  {
    if (!isAttachedToWindow())
    {
      if (this.K0 == null) {
        this.K0 = new i();
      }
      this.K0.f(paramInt1);
      this.K0.d(paramInt2);
      return;
    }
    p localp = this.y;
    if (localp != null)
    {
      this.C = paramInt1;
      this.F = paramInt2;
      localp.X(paramInt1, paramInt2);
      this.X0.e(this.c, this.y.l(paramInt1), this.y.l(paramInt2));
      w0();
      this.N = 0.0F;
      F0();
    }
  }
  
  class a
    implements Runnable
  {
    a(View paramView) {}
    
    public void run()
    {
      paramView.setNestedScrollingEnabled(true);
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      MotionLayout.B(MotionLayout.this).a();
    }
  }
  
  class d
    extends n
  {
    float a = 0.0F;
    float b = 0.0F;
    float c;
    
    d() {}
    
    public float a()
    {
      return MotionLayout.this.B;
    }
    
    public void b(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
    }
    
    public float getInterpolation(float paramFloat)
    {
      float f2 = this.a;
      float f3;
      float f1;
      if (f2 > 0.0F)
      {
        f3 = this.c;
        f1 = paramFloat;
        if (f2 / f3 < paramFloat) {
          f1 = f2 / f3;
        }
        MotionLayout.this.B = (f2 - f3 * f1);
      }
      for (paramFloat = f2 * f1 - f3 * f1 * f1 / 2.0F;; paramFloat = f2 * f1 + f3 * f1 * f1 / 2.0F)
      {
        return paramFloat + this.b;
        float f4 = -f2;
        f3 = this.c;
        f1 = paramFloat;
        if (f4 / f3 < paramFloat) {
          f1 = -f2 / f3;
        }
        MotionLayout.this.B = (f3 * f1 + f2);
      }
    }
  }
  
  private class e
  {
    float[] a;
    int[] b;
    float[] c;
    Path d;
    Paint e;
    Paint f;
    Paint g;
    Paint h;
    Paint i;
    private float[] j;
    final int k = -21965;
    final int l = -2067046;
    final int m = -13391360;
    final int n = 1996488704;
    final int o = 10;
    DashPathEffect p;
    int q;
    Rect r = new Rect();
    boolean s = false;
    int t = 1;
    
    public e()
    {
      Paint localPaint = new Paint();
      this.e = localPaint;
      localPaint.setAntiAlias(true);
      this.e.setColor(-21965);
      this.e.setStrokeWidth(2.0F);
      this.e.setStyle(Paint.Style.STROKE);
      localPaint = new Paint();
      this.f = localPaint;
      localPaint.setAntiAlias(true);
      this.f.setColor(-2067046);
      this.f.setStrokeWidth(2.0F);
      this.f.setStyle(Paint.Style.STROKE);
      localPaint = new Paint();
      this.g = localPaint;
      localPaint.setAntiAlias(true);
      this.g.setColor(-13391360);
      this.g.setStrokeWidth(2.0F);
      this.g.setStyle(Paint.Style.STROKE);
      localPaint = new Paint();
      this.h = localPaint;
      localPaint.setAntiAlias(true);
      this.h.setColor(-13391360);
      this.h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0F);
      this.j = new float[8];
      this$1 = new Paint();
      this.i = MotionLayout.this;
      MotionLayout.this.setAntiAlias(true);
      this$1 = new DashPathEffect(new float[] { 4.0F, 8.0F }, 0.0F);
      this.p = MotionLayout.this;
      this.g.setPathEffect(MotionLayout.this);
      this.c = new float[100];
      this.b = new int[50];
      if (this.s)
      {
        this.e.setStrokeWidth(8.0F);
        this.i.setStrokeWidth(8.0F);
        this.f.setStrokeWidth(8.0F);
        this.t = 4;
      }
    }
    
    private void c(Canvas paramCanvas)
    {
      paramCanvas.drawLines(this.a, this.e);
    }
    
    private void d(Canvas paramCanvas)
    {
      int i1 = 0;
      int i3 = 0;
      int i2 = i3;
      while (i1 < this.q)
      {
        int[] arrayOfInt = this.b;
        if (arrayOfInt[i1] == 1) {
          i3 = 1;
        }
        if (arrayOfInt[i1] == 0) {
          i2 = 1;
        }
        i1 += 1;
      }
      if (i3 != 0) {
        g(paramCanvas);
      }
      if (i2 != 0) {
        e(paramCanvas);
      }
    }
    
    private void e(Canvas paramCanvas)
    {
      float[] arrayOfFloat = this.a;
      float f1 = arrayOfFloat[0];
      float f2 = arrayOfFloat[1];
      float f3 = arrayOfFloat[(arrayOfFloat.length - 2)];
      float f4 = arrayOfFloat[(arrayOfFloat.length - 1)];
      paramCanvas.drawLine(Math.min(f1, f3), Math.max(f2, f4), Math.max(f1, f3), Math.max(f2, f4), this.g);
      paramCanvas.drawLine(Math.min(f1, f3), Math.min(f2, f4), Math.min(f1, f3), Math.max(f2, f4), this.g);
    }
    
    private void f(Canvas paramCanvas, float paramFloat1, float paramFloat2)
    {
      Object localObject = this.a;
      float f1 = localObject[0];
      float f2 = localObject[1];
      float f3 = localObject[(localObject.length - 2)];
      float f4 = localObject[(localObject.length - 1)];
      float f5 = Math.min(f1, f3);
      float f6 = Math.max(f2, f4);
      float f7 = paramFloat1 - Math.min(f1, f3);
      float f8 = Math.max(f2, f4) - paramFloat2;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append((int)(f7 * 100.0F / Math.abs(f3 - f1) + 0.5D) / 100.0F);
      localObject = ((StringBuilder)localObject).toString();
      l((String)localObject, this.h);
      paramCanvas.drawText((String)localObject, f7 / 2.0F - this.r.width() / 2 + f5, paramFloat2 - 20.0F, this.h);
      paramCanvas.drawLine(paramFloat1, paramFloat2, Math.min(f1, f3), paramFloat2, this.g);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append((int)(f8 * 100.0F / Math.abs(f4 - f2) + 0.5D) / 100.0F);
      localObject = ((StringBuilder)localObject).toString();
      l((String)localObject, this.h);
      paramCanvas.drawText((String)localObject, paramFloat1 + 5.0F, f6 - (f8 / 2.0F - this.r.height() / 2), this.h);
      paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat1, Math.max(f2, f4), this.g);
    }
    
    private void g(Canvas paramCanvas)
    {
      float[] arrayOfFloat = this.a;
      paramCanvas.drawLine(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[(arrayOfFloat.length - 2)], arrayOfFloat[(arrayOfFloat.length - 1)], this.g);
    }
    
    private void h(Canvas paramCanvas, float paramFloat1, float paramFloat2)
    {
      Object localObject1 = this.a;
      float f3 = localObject1[0];
      float f2 = localObject1[1];
      float f4 = localObject1[(localObject1.length - 2)];
      float f5 = localObject1[(localObject1.length - 1)];
      float f1 = (float)Math.hypot(f3 - f4, f2 - f5);
      f4 -= f3;
      f5 -= f2;
      float f6 = ((paramFloat1 - f3) * f4 + (paramFloat2 - f2) * f5) / (f1 * f1);
      f3 += f4 * f6;
      f2 += f6 * f5;
      localObject1 = new Path();
      ((Path)localObject1).moveTo(paramFloat1, paramFloat2);
      ((Path)localObject1).lineTo(f3, f2);
      f4 = (float)Math.hypot(f3 - paramFloat1, f2 - paramFloat2);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append((int)(f4 * 100.0F / f1) / 100.0F);
      localObject2 = ((StringBuilder)localObject2).toString();
      l((String)localObject2, this.h);
      paramCanvas.drawTextOnPath((String)localObject2, (Path)localObject1, f4 / 2.0F - this.r.width() / 2, -20.0F, this.h);
      paramCanvas.drawLine(paramFloat1, paramFloat2, f3, f2, this.g);
    }
    
    private void i(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append((int)((paramFloat1 - paramInt1 / 2) * 100.0F / (MotionLayout.this.getWidth() - paramInt1) + 0.5D) / 100.0F);
      localObject = ((StringBuilder)localObject).toString();
      l((String)localObject, this.h);
      paramCanvas.drawText((String)localObject, paramFloat1 / 2.0F - this.r.width() / 2 + 0.0F, paramFloat2 - 20.0F, this.h);
      paramCanvas.drawLine(paramFloat1, paramFloat2, Math.min(0.0F, 1.0F), paramFloat2, this.g);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append((int)((paramFloat2 - paramInt2 / 2) * 100.0F / (MotionLayout.this.getHeight() - paramInt2) + 0.5D) / 100.0F);
      localObject = ((StringBuilder)localObject).toString();
      l((String)localObject, this.h);
      paramCanvas.drawText((String)localObject, paramFloat1 + 5.0F, 0.0F - (paramFloat2 / 2.0F - this.r.height() / 2), this.h);
      paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat1, Math.max(0.0F, 1.0F), this.g);
    }
    
    private void j(Canvas paramCanvas, m paramm)
    {
      this.d.reset();
      int i1 = 0;
      while (i1 <= 50)
      {
        paramm.e(i1 / 50, this.j, 0);
        Path localPath = this.d;
        float[] arrayOfFloat = this.j;
        localPath.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
        localPath = this.d;
        arrayOfFloat = this.j;
        localPath.lineTo(arrayOfFloat[2], arrayOfFloat[3]);
        localPath = this.d;
        arrayOfFloat = this.j;
        localPath.lineTo(arrayOfFloat[4], arrayOfFloat[5]);
        localPath = this.d;
        arrayOfFloat = this.j;
        localPath.lineTo(arrayOfFloat[6], arrayOfFloat[7]);
        this.d.close();
        i1 += 1;
      }
      this.e.setColor(1140850688);
      paramCanvas.translate(2.0F, 2.0F);
      paramCanvas.drawPath(this.d, this.e);
      paramCanvas.translate(-2.0F, -2.0F);
      this.e.setColor(-65536);
      paramCanvas.drawPath(this.d, this.e);
    }
    
    private void k(Canvas paramCanvas, int paramInt1, int paramInt2, m paramm)
    {
      Object localObject = paramm.b;
      int i1;
      int i2;
      if (localObject != null)
      {
        i1 = ((View)localObject).getWidth();
        i2 = paramm.b.getHeight();
      }
      else
      {
        i1 = 0;
        i2 = i1;
      }
      int i3 = 1;
      while (i3 < paramInt2 - 1)
      {
        if ((paramInt1 != 4) || (this.b[(i3 - 1)] != 0))
        {
          localObject = this.c;
          int i4 = i3 * 2;
          float f2 = localObject[i4];
          float f1 = localObject[(i4 + 1)];
          this.d.reset();
          this.d.moveTo(f2, f1 + 10.0F);
          this.d.lineTo(f2 + 10.0F, f1);
          this.d.lineTo(f2, f1 - 10.0F);
          this.d.lineTo(f2 - 10.0F, f1);
          this.d.close();
          i4 = i3 - 1;
          paramm.q(i4);
          if (paramInt1 == 4)
          {
            localObject = this.b;
            if (localObject[i4] == 1) {
              h(paramCanvas, f2 - 0.0F, f1 - 0.0F);
            }
            for (;;)
            {
              break;
              if (localObject[i4] == 0) {
                f(paramCanvas, f2 - 0.0F, f1 - 0.0F);
              } else if (localObject[i4] == 2) {
                i(paramCanvas, f2 - 0.0F, f1 - 0.0F, i1, i2);
              }
            }
            paramCanvas.drawPath(this.d, this.i);
          }
          if (paramInt1 == 2) {
            h(paramCanvas, f2 - 0.0F, f1 - 0.0F);
          }
          if (paramInt1 == 3) {
            f(paramCanvas, f2 - 0.0F, f1 - 0.0F);
          }
          if (paramInt1 == 6) {
            i(paramCanvas, f2 - 0.0F, f1 - 0.0F, i1, i2);
          }
          paramCanvas.drawPath(this.d, this.i);
        }
        i3 += 1;
      }
      paramm = this.a;
      if (paramm.length > 1)
      {
        paramCanvas.drawCircle(paramm[0], paramm[1], 8.0F, this.f);
        paramm = this.a;
        paramCanvas.drawCircle(paramm[(paramm.length - 2)], paramm[(paramm.length - 1)], 8.0F, this.f);
      }
    }
    
    public void a(Canvas paramCanvas, HashMap<View, m> paramHashMap, int paramInt1, int paramInt2)
    {
      if (paramHashMap != null)
      {
        if (paramHashMap.size() == 0) {
          return;
        }
        paramCanvas.save();
        Object localObject;
        if ((!MotionLayout.this.isInEditMode()) && ((paramInt2 & 0x1) == 2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.C(MotionLayout.this)));
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append(MotionLayout.this.getProgress());
          localObject = ((StringBuilder)localObject).toString();
          paramCanvas.drawText((String)localObject, 10.0F, MotionLayout.this.getHeight() - 30, this.h);
          paramCanvas.drawText((String)localObject, 11.0F, MotionLayout.this.getHeight() - 29, this.e);
        }
        paramHashMap = paramHashMap.values().iterator();
        while (paramHashMap.hasNext())
        {
          localObject = (m)paramHashMap.next();
          int i2 = ((m)localObject).m();
          int i1 = i2;
          if (paramInt2 > 0)
          {
            i1 = i2;
            if (i2 == 0) {
              i1 = 1;
            }
          }
          if (i1 != 0)
          {
            this.q = ((m)localObject).c(this.c, this.b);
            if (i1 >= 1)
            {
              i2 = paramInt1 / 16;
              float[] arrayOfFloat = this.a;
              if ((arrayOfFloat == null) || (arrayOfFloat.length != i2 * 2))
              {
                this.a = new float[i2 * 2];
                this.d = new Path();
              }
              int i3 = this.t;
              paramCanvas.translate(i3, i3);
              this.e.setColor(1996488704);
              this.i.setColor(1996488704);
              this.f.setColor(1996488704);
              this.g.setColor(1996488704);
              ((m)localObject).d(this.a, i2);
              b(paramCanvas, i1, this.q, (m)localObject);
              this.e.setColor(-21965);
              this.f.setColor(-2067046);
              this.i.setColor(-2067046);
              this.g.setColor(-13391360);
              i2 = this.t;
              paramCanvas.translate(-i2, -i2);
              b(paramCanvas, i1, this.q, (m)localObject);
              if (i1 == 5) {
                j(paramCanvas, (m)localObject);
              }
            }
          }
        }
        paramCanvas.restore();
      }
    }
    
    public void b(Canvas paramCanvas, int paramInt1, int paramInt2, m paramm)
    {
      if (paramInt1 == 4) {
        d(paramCanvas);
      }
      if (paramInt1 == 2) {
        g(paramCanvas);
      }
      if (paramInt1 == 3) {
        e(paramCanvas);
      }
      c(paramCanvas);
      k(paramCanvas, paramInt1, paramInt2, paramm);
    }
    
    void l(String paramString, Paint paramPaint)
    {
      paramPaint.getTextBounds(paramString, 0, paramString.length(), this.r);
    }
  }
  
  class f
  {
    k0.f a = new k0.f();
    k0.f b = new k0.f();
    c c = null;
    c d = null;
    int e;
    int f;
    
    f() {}
    
    private void b(int paramInt1, int paramInt2)
    {
      int k = MotionLayout.this.getOptimizationLevel();
      Object localObject1 = MotionLayout.this;
      Object localObject2;
      Object localObject3;
      int i;
      int j;
      if (((MotionLayout)localObject1).E == ((MotionLayout)localObject1).getStartState())
      {
        localObject1 = MotionLayout.this;
        localObject2 = this.b;
        localObject3 = this.d;
        if ((localObject3 != null) && (((c)localObject3).d != 0)) {
          i = paramInt2;
        } else {
          i = paramInt1;
        }
        if ((localObject3 != null) && (((c)localObject3).d != 0)) {
          j = paramInt1;
        } else {
          j = paramInt2;
        }
        MotionLayout.J((MotionLayout)localObject1, (k0.f)localObject2, k, i, j);
        localObject1 = this.c;
        if (localObject1 != null)
        {
          localObject2 = MotionLayout.this;
          localObject3 = this.a;
          j = ((c)localObject1).d;
          if (j == 0) {
            i = paramInt1;
          } else {
            i = paramInt2;
          }
          if (j == 0) {
            paramInt1 = paramInt2;
          }
          MotionLayout.K((MotionLayout)localObject2, (k0.f)localObject3, k, i, paramInt1);
        }
      }
      else
      {
        localObject1 = this.c;
        if (localObject1 != null)
        {
          localObject2 = MotionLayout.this;
          localObject3 = this.a;
          j = ((c)localObject1).d;
          if (j == 0) {
            i = paramInt1;
          } else {
            i = paramInt2;
          }
          if (j == 0) {
            j = paramInt2;
          } else {
            j = paramInt1;
          }
          MotionLayout.L((MotionLayout)localObject2, (k0.f)localObject3, k, i, j);
        }
        localObject1 = MotionLayout.this;
        localObject2 = this.b;
        localObject3 = this.d;
        if ((localObject3 != null) && (((c)localObject3).d != 0)) {
          i = paramInt2;
        } else {
          i = paramInt1;
        }
        if ((localObject3 == null) || (((c)localObject3).d == 0)) {
          paramInt1 = paramInt2;
        }
        MotionLayout.M((MotionLayout)localObject1, (k0.f)localObject2, k, i, paramInt1);
      }
    }
    
    private void j(k0.f paramf, c paramc)
    {
      SparseArray localSparseArray = new SparseArray();
      Object localObject1 = new Constraints.LayoutParams(-2, -2);
      localSparseArray.clear();
      localSparseArray.put(0, paramf);
      localSparseArray.put(MotionLayout.this.getId(), paramf);
      if ((paramc != null) && (paramc.d != 0))
      {
        localObject2 = MotionLayout.this;
        MotionLayout.D((MotionLayout)localObject2, this.b, ((ConstraintLayout)localObject2).getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
      }
      Object localObject2 = paramf.v1().iterator();
      k0.e locale;
      while (((Iterator)localObject2).hasNext())
      {
        locale = (k0.e)((Iterator)localObject2).next();
        locale.D0(true);
        localSparseArray.put(((View)locale.u()).getId(), locale);
      }
      localObject2 = paramf.v1().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        locale = (k0.e)((Iterator)localObject2).next();
        View localView = (View)locale.u();
        paramc.l(localView.getId(), (ConstraintLayout.LayoutParams)localObject1);
        locale.o1(paramc.C(localView.getId()));
        locale.P0(paramc.x(localView.getId()));
        if ((localView instanceof ConstraintHelper))
        {
          paramc.j((ConstraintHelper)localView, locale, (ConstraintLayout.LayoutParams)localObject1, localSparseArray);
          if ((localView instanceof Barrier)) {
            ((Barrier)localView).w();
          }
        }
        ((ConstraintLayout.LayoutParams)localObject1).resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
        MotionLayout.E(MotionLayout.this, false, localView, locale, (ConstraintLayout.LayoutParams)localObject1, localSparseArray);
        int i;
        if (paramc.B(localView.getId()) == 1) {
          i = localView.getVisibility();
        } else {
          i = paramc.A(localView.getId());
        }
        locale.n1(i);
      }
      paramc = paramf.v1().iterator();
      while (paramc.hasNext())
      {
        localObject2 = (k0.e)paramc.next();
        if ((localObject2 instanceof k0.m))
        {
          localObject1 = (ConstraintHelper)((k0.e)localObject2).u();
          localObject2 = (i)localObject2;
          ((ConstraintHelper)localObject1).v(paramf, (i)localObject2, localSparseArray);
          ((k0.m)localObject2).y1();
        }
      }
    }
    
    public void a()
    {
      int j = MotionLayout.this.getChildCount();
      MotionLayout.this.J.clear();
      SparseArray localSparseArray = new SparseArray();
      int[] arrayOfInt = new int[j];
      int i = 0;
      Object localObject1;
      Object localObject2;
      int k;
      while (i < j)
      {
        localObject1 = MotionLayout.this.getChildAt(i);
        localObject2 = new m((View)localObject1);
        k = ((View)localObject1).getId();
        arrayOfInt[i] = k;
        localSparseArray.put(k, localObject2);
        MotionLayout.this.J.put(localObject1, localObject2);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        localObject1 = MotionLayout.this.getChildAt(i);
        localObject2 = (m)MotionLayout.this.J.get(localObject1);
        if (localObject2 != null)
        {
          Object localObject3;
          if (this.c != null)
          {
            localObject3 = d(this.a, (View)localObject1);
            if (localObject3 != null)
            {
              ((m)localObject2).F(MotionLayout.O(MotionLayout.this, (k0.e)localObject3), this.c, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
            }
            else if (MotionLayout.this.W != 0)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(a.b());
              ((StringBuilder)localObject3).append("no widget for  ");
              ((StringBuilder)localObject3).append(a.d((View)localObject1));
              ((StringBuilder)localObject3).append(" (");
              ((StringBuilder)localObject3).append(localObject1.getClass().getName());
              ((StringBuilder)localObject3).append(")");
              Log.e("MotionLayout", ((StringBuilder)localObject3).toString());
            }
          }
          else if (MotionLayout.R(MotionLayout.this))
          {
            localObject3 = (n0.e)MotionLayout.this.Q0.get(localObject1);
            MotionLayout localMotionLayout = MotionLayout.this;
            ((m)localObject2).G((n0.e)localObject3, (View)localObject1, localMotionLayout.P0, MotionLayout.P(localMotionLayout), MotionLayout.Q(MotionLayout.this));
          }
          if (this.d != null)
          {
            localObject3 = d(this.b, (View)localObject1);
            if (localObject3 != null)
            {
              ((m)localObject2).C(MotionLayout.O(MotionLayout.this, (k0.e)localObject3), this.d, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
            }
            else if (MotionLayout.this.W != 0)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(a.b());
              ((StringBuilder)localObject2).append("no widget for  ");
              ((StringBuilder)localObject2).append(a.d((View)localObject1));
              ((StringBuilder)localObject2).append(" (");
              ((StringBuilder)localObject2).append(localObject1.getClass().getName());
              ((StringBuilder)localObject2).append(")");
              Log.e("MotionLayout", ((StringBuilder)localObject2).toString());
            }
          }
        }
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        localObject1 = (m)localSparseArray.get(arrayOfInt[i]);
        k = ((m)localObject1).h();
        if (k != -1) {
          ((m)localObject1).J((m)localSparseArray.get(k));
        }
        i += 1;
      }
    }
    
    void c(k0.f paramf1, k0.f paramf2)
    {
      ArrayList localArrayList = paramf1.v1();
      HashMap localHashMap = new HashMap();
      localHashMap.put(paramf1, paramf2);
      paramf2.v1().clear();
      paramf2.n(paramf1, localHashMap);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        k0.e locale = (k0.e)localIterator.next();
        if ((locale instanceof k0.a)) {
          paramf1 = new k0.a();
        } else if ((locale instanceof h)) {
          paramf1 = new h();
        } else if ((locale instanceof g)) {
          paramf1 = new g();
        } else if ((locale instanceof l)) {
          paramf1 = new l();
        } else if ((locale instanceof i)) {
          paramf1 = new j();
        } else {
          paramf1 = new k0.e();
        }
        paramf2.a(paramf1);
        localHashMap.put(locale, paramf1);
      }
      paramf1 = localArrayList.iterator();
      while (paramf1.hasNext())
      {
        paramf2 = (k0.e)paramf1.next();
        ((k0.e)localHashMap.get(paramf2)).n(paramf2, localHashMap);
      }
    }
    
    k0.e d(k0.f paramf, View paramView)
    {
      if (paramf.u() == paramView) {
        return paramf;
      }
      paramf = paramf.v1();
      int j = paramf.size();
      int i = 0;
      while (i < j)
      {
        k0.e locale = (k0.e)paramf.get(i);
        if (locale.u() == paramView) {
          return locale;
        }
        i += 1;
      }
      return null;
    }
    
    void e(k0.f paramf, c paramc1, c paramc2)
    {
      this.c = paramc1;
      this.d = paramc2;
      this.a = new k0.f();
      this.b = new k0.f();
      this.a.Z1(MotionLayout.S(MotionLayout.this).M1());
      this.b.Z1(MotionLayout.T(MotionLayout.this).M1());
      this.a.y1();
      this.b.y1();
      c(MotionLayout.U(MotionLayout.this), this.a);
      c(MotionLayout.V(MotionLayout.this), this.b);
      if (MotionLayout.this.N > 0.5D)
      {
        if (paramc1 != null) {
          j(this.a, paramc1);
        }
        j(this.b, paramc2);
      }
      else
      {
        j(this.b, paramc2);
        if (paramc1 != null) {
          j(this.a, paramc1);
        }
      }
      this.a.c2(MotionLayout.W(MotionLayout.this));
      this.a.e2();
      this.b.c2(MotionLayout.X(MotionLayout.this));
      this.b.e2();
      paramf = MotionLayout.this.getLayoutParams();
      if (paramf != null)
      {
        if (paramf.width == -2)
        {
          paramc1 = this.a;
          paramc2 = e.b.b;
          paramc1.T0(paramc2);
          this.b.T0(paramc2);
        }
        if (paramf.height == -2)
        {
          paramf = this.a;
          paramc1 = e.b.b;
          paramf.k1(paramc1);
          this.b.k1(paramc1);
        }
      }
    }
    
    public boolean f(int paramInt1, int paramInt2)
    {
      return (paramInt1 != this.e) || (paramInt2 != this.f);
    }
    
    public void g(int paramInt1, int paramInt2)
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt2);
      MotionLayout localMotionLayout = MotionLayout.this;
      localMotionLayout.F0 = i;
      localMotionLayout.G0 = j;
      localMotionLayout.getOptimizationLevel();
      b(paramInt1, paramInt2);
      if (((MotionLayout.this.getParent() instanceof MotionLayout)) && (i == 1073741824) && (j == 1073741824)) {
        i = 0;
      } else {
        i = 1;
      }
      boolean bool1;
      if (i != 0)
      {
        b(paramInt1, paramInt2);
        MotionLayout.this.B0 = this.a.Y();
        MotionLayout.this.C0 = this.a.z();
        MotionLayout.this.D0 = this.b.Y();
        MotionLayout.this.E0 = this.b.z();
        localMotionLayout = MotionLayout.this;
        if ((localMotionLayout.B0 == localMotionLayout.D0) && (localMotionLayout.C0 == localMotionLayout.E0)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        localMotionLayout.A0 = bool1;
      }
      localMotionLayout = MotionLayout.this;
      j = localMotionLayout.B0;
      int k = localMotionLayout.C0;
      int m = localMotionLayout.F0;
      if (m != -2147483648)
      {
        i = j;
        if (m != 0) {}
      }
      else
      {
        i = (int)(j + localMotionLayout.H0 * (localMotionLayout.D0 - j));
      }
      m = localMotionLayout.G0;
      if (m != -2147483648)
      {
        j = k;
        if (m != 0) {}
      }
      else
      {
        j = (int)(k + localMotionLayout.H0 * (localMotionLayout.E0 - k));
      }
      if ((!this.a.U1()) && (!this.b.U1())) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      boolean bool2;
      if ((!this.a.S1()) && (!this.b.S1())) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      MotionLayout.I(MotionLayout.this, paramInt1, paramInt2, i, j, bool1, bool2);
    }
    
    public void h()
    {
      g(MotionLayout.F(MotionLayout.this), MotionLayout.G(MotionLayout.this));
      MotionLayout.H(MotionLayout.this);
    }
    
    public void i(int paramInt1, int paramInt2)
    {
      this.e = paramInt1;
      this.f = paramInt2;
    }
  }
  
  protected static abstract interface g
  {
    public abstract void a();
    
    public abstract void b(MotionEvent paramMotionEvent);
    
    public abstract float c();
    
    public abstract float d();
    
    public abstract void e(int paramInt);
  }
  
  private static class h
    implements MotionLayout.g
  {
    private static h b = new h();
    VelocityTracker a;
    
    public static h f()
    {
      b.a = VelocityTracker.obtain();
      return b;
    }
    
    public void a()
    {
      VelocityTracker localVelocityTracker = this.a;
      if (localVelocityTracker != null)
      {
        localVelocityTracker.recycle();
        this.a = null;
      }
    }
    
    public void b(MotionEvent paramMotionEvent)
    {
      VelocityTracker localVelocityTracker = this.a;
      if (localVelocityTracker != null) {
        localVelocityTracker.addMovement(paramMotionEvent);
      }
    }
    
    public float c()
    {
      VelocityTracker localVelocityTracker = this.a;
      if (localVelocityTracker != null) {
        return localVelocityTracker.getYVelocity();
      }
      return 0.0F;
    }
    
    public float d()
    {
      VelocityTracker localVelocityTracker = this.a;
      if (localVelocityTracker != null) {
        return localVelocityTracker.getXVelocity();
      }
      return 0.0F;
    }
    
    public void e(int paramInt)
    {
      VelocityTracker localVelocityTracker = this.a;
      if (localVelocityTracker != null) {
        localVelocityTracker.computeCurrentVelocity(paramInt);
      }
    }
  }
  
  class i
  {
    float a = (0.0F / 0.0F);
    float b = (0.0F / 0.0F);
    int c = -1;
    int d = -1;
    final String e = "motion.progress";
    final String f = "motion.velocity";
    final String g = "motion.StartState";
    final String h = "motion.EndState";
    
    i() {}
    
    void a()
    {
      int j = this.c;
      if ((j != -1) || (this.d != -1))
      {
        if (j == -1)
        {
          MotionLayout.this.G0(this.d);
        }
        else
        {
          int k = this.d;
          if (k == -1) {
            MotionLayout.this.y0(j, -1, -1);
          } else {
            MotionLayout.this.z0(j, k);
          }
        }
        MotionLayout.this.setState(MotionLayout.k.b);
      }
      if (Float.isNaN(this.b))
      {
        if (Float.isNaN(this.a)) {
          return;
        }
        MotionLayout.this.setProgress(this.a);
        return;
      }
      MotionLayout.this.x0(this.a, this.b);
      this.a = (0.0F / 0.0F);
      this.b = (0.0F / 0.0F);
      this.c = -1;
      this.d = -1;
    }
    
    public Bundle b()
    {
      Bundle localBundle = new Bundle();
      localBundle.putFloat("motion.progress", this.a);
      localBundle.putFloat("motion.velocity", this.b);
      localBundle.putInt("motion.StartState", this.c);
      localBundle.putInt("motion.EndState", this.d);
      return localBundle;
    }
    
    public void c()
    {
      this.d = MotionLayout.C(MotionLayout.this);
      this.c = MotionLayout.N(MotionLayout.this);
      this.b = MotionLayout.this.getVelocity();
      this.a = MotionLayout.this.getProgress();
    }
    
    public void d(int paramInt)
    {
      this.d = paramInt;
    }
    
    public void e(float paramFloat)
    {
      this.a = paramFloat;
    }
    
    public void f(int paramInt)
    {
      this.c = paramInt;
    }
    
    public void g(Bundle paramBundle)
    {
      this.a = paramBundle.getFloat("motion.progress");
      this.b = paramBundle.getFloat("motion.velocity");
      this.c = paramBundle.getInt("motion.StartState");
      this.d = paramBundle.getInt("motion.EndState");
    }
    
    public void h(float paramFloat)
    {
      this.b = paramFloat;
    }
  }
  
  public static abstract interface j
  {
    public abstract void a(MotionLayout paramMotionLayout, int paramInt1, int paramInt2, float paramFloat);
    
    public abstract void b(MotionLayout paramMotionLayout, int paramInt1, int paramInt2);
    
    public abstract void c(MotionLayout paramMotionLayout, int paramInt, boolean paramBoolean, float paramFloat);
    
    public abstract void d(MotionLayout paramMotionLayout, int paramInt);
  }
  
  static enum k
  {
    private k() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionLayout
 * JD-Core Version:    0.7.0.1
 */