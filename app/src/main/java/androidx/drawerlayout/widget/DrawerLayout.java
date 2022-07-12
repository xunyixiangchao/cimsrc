package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.e;
import androidx.core.view.h0;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.R.attr;
import androidx.drawerlayout.R.dimen;
import androidx.drawerlayout.R.styleable;
import c1.c;
import c1.c.c;
import java.util.ArrayList;
import java.util.List;
import y0.d;
import y0.d.a;
import y0.g;
import y0.g.a;

public class DrawerLayout
  extends ViewGroup
{
  private static final int[] M;
  static final int[] N;
  static final boolean O;
  private static final boolean P;
  private static boolean Q;
  private CharSequence A;
  private Object B;
  private boolean C;
  private Drawable E = null;
  private Drawable F = null;
  private Drawable G = null;
  private Drawable H = null;
  private final ArrayList<View> I;
  private Rect J;
  private Matrix K;
  private final g L = new a();
  private final d a = new d();
  private float b;
  private int c;
  private int d = -1728053248;
  private float e;
  private Paint f = new Paint();
  private final c g;
  private final c h;
  private final f i;
  private final f j;
  private int k;
  private boolean l;
  private boolean m = true;
  private int n = 3;
  private int o = 3;
  private int p = 3;
  private int q = 3;
  private boolean r;
  private e s;
  private List<e> t;
  private float u;
  private float v;
  private Drawable w;
  private Drawable x;
  private Drawable y;
  private CharSequence z;
  
  static
  {
    boolean bool = true;
    M = new int[] { 16843828 };
    N = new int[] { 16842931 };
    int i1 = Build.VERSION.SDK_INT;
    O = true;
    P = true;
    if (i1 < 29) {
      bool = false;
    }
    Q = bool;
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.drawerLayoutStyle);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.c = ((int)(64.0F * f1 + 0.5F));
    f1 *= 400.0F;
    Object localObject2 = new f(3);
    this.i = ((f)localObject2);
    Object localObject1 = new f(5);
    this.j = ((f)localObject1);
    c localc = c.o(this, 1.0F, (c.c)localObject2);
    this.g = localc;
    localc.N(1);
    localc.O(f1);
    ((f)localObject2).q(localc);
    localObject2 = c.o(this, 1.0F, (c.c)localObject1);
    this.h = ((c)localObject2);
    ((c)localObject2).N(2);
    ((c)localObject2).O(f1);
    ((f)localObject1).q((c)localObject2);
    setFocusableInTouchMode(true);
    x.B0(this, 1);
    x.q0(this, new c());
    setMotionEventSplittingEnabled(false);
    if (x.y(this))
    {
      setOnApplyWindowInsetsListener(new b());
      setSystemUiVisibility(1280);
      localObject1 = paramContext.obtainStyledAttributes(M);
    }
    try
    {
      this.w = ((TypedArray)localObject1).getDrawable(0);
      ((TypedArray)localObject1).recycle();
    }
    finally
    {
      ((TypedArray)localObject1).recycle();
    }
    try
    {
      paramInt = R.styleable.DrawerLayout_elevation;
      if (paramContext.hasValue(paramInt)) {}
      for (f1 = paramContext.getDimension(paramInt, 0.0F);; f1 = getResources().getDimension(R.dimen.def_drawer_elevation))
      {
        this.b = f1;
        break;
      }
      paramContext.recycle();
      this.I = new ArrayList();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private boolean D(float paramFloat1, float paramFloat2, View paramView)
  {
    if (this.J == null) {
      this.J = new Rect();
    }
    paramView.getHitRect(this.J);
    return this.J.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  private void E(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (r0.a.h(paramDrawable))) {
      r0.a.m(paramDrawable, paramInt);
    }
  }
  
  private Drawable J()
  {
    int i1 = x.B(this);
    Drawable localDrawable;
    if (i1 == 0)
    {
      localDrawable = this.E;
      if (localDrawable != null)
      {
        E(localDrawable, i1);
        return this.E;
      }
    }
    else
    {
      localDrawable = this.F;
      if (localDrawable != null)
      {
        E(localDrawable, i1);
        return this.F;
      }
    }
    return this.G;
  }
  
  private Drawable K()
  {
    int i1 = x.B(this);
    Drawable localDrawable;
    if (i1 == 0)
    {
      localDrawable = this.F;
      if (localDrawable != null)
      {
        E(localDrawable, i1);
        return this.F;
      }
    }
    else
    {
      localDrawable = this.E;
      if (localDrawable != null)
      {
        E(localDrawable, i1);
        return this.E;
      }
    }
    return this.H;
  }
  
  private void L()
  {
    if (P) {
      return;
    }
    this.x = J();
    this.y = K();
  }
  
  private void P(View paramView)
  {
    d.a locala = d.a.y;
    x.k0(paramView, locala.b());
    if ((A(paramView)) && (p(paramView) != 2)) {
      x.m0(paramView, locala, null, this.L);
    }
  }
  
  private void Q(View paramView, boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i1 = 0;
    while (i1 < i3)
    {
      View localView = getChildAt(i1);
      int i2;
      if (((!paramBoolean) && (!B(localView))) || ((paramBoolean) && (localView == paramView))) {
        i2 = 1;
      } else {
        i2 = 4;
      }
      x.B0(localView, i2);
      i1 += 1;
    }
  }
  
  private boolean k(MotionEvent paramMotionEvent, View paramView)
  {
    if (!paramView.getMatrix().isIdentity())
    {
      paramMotionEvent = t(paramMotionEvent, paramView);
      bool = paramView.dispatchGenericMotionEvent(paramMotionEvent);
      paramMotionEvent.recycle();
      return bool;
    }
    float f1 = getScrollX() - paramView.getLeft();
    float f2 = getScrollY() - paramView.getTop();
    paramMotionEvent.offsetLocation(f1, f2);
    boolean bool = paramView.dispatchGenericMotionEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-f1, -f2);
    return bool;
  }
  
  private MotionEvent t(MotionEvent paramMotionEvent, View paramView)
  {
    float f1 = getScrollX() - paramView.getLeft();
    float f2 = getScrollY() - paramView.getTop();
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.offsetLocation(f1, f2);
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity())
    {
      if (this.K == null) {
        this.K = new Matrix();
      }
      paramView.invert(this.K);
      paramMotionEvent.transform(this.K);
    }
    return paramMotionEvent;
  }
  
  static String u(int paramInt)
  {
    if ((paramInt & 0x3) == 3) {
      return "LEFT";
    }
    if ((paramInt & 0x5) == 5) {
      return "RIGHT";
    }
    return Integer.toHexString(paramInt);
  }
  
  private static boolean v(View paramView)
  {
    paramView = paramView.getBackground();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.getOpacity() == -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean w()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((LayoutParams)getChildAt(i1).getLayoutParams()).c) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean x()
  {
    return n() != null;
  }
  
  static boolean y(View paramView)
  {
    return (x.z(paramView) != 4) && (x.z(paramView) != 2);
  }
  
  public boolean A(View paramView)
  {
    if (B(paramView)) {
      return (((LayoutParams)paramView.getLayoutParams()).d & 0x1) == 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean B(View paramView)
  {
    int i1 = e.b(((LayoutParams)paramView.getLayoutParams()).a, x.B(paramView));
    if ((i1 & 0x3) != 0) {
      return true;
    }
    return (i1 & 0x5) != 0;
  }
  
  public boolean C(View paramView)
  {
    if (B(paramView)) {
      return ((LayoutParams)paramView.getLayoutParams()).b > 0.0F;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  void F(View paramView, float paramFloat)
  {
    float f1 = s(paramView);
    float f2 = paramView.getWidth();
    int i1 = (int)(f1 * f2);
    i1 = (int)(f2 * paramFloat) - i1;
    if (!c(paramView, 3)) {
      i1 = -i1;
    }
    paramView.offsetLeftAndRight(i1);
    O(paramView, paramFloat);
  }
  
  public void G(View paramView)
  {
    H(paramView, true);
  }
  
  public void H(View paramView, boolean paramBoolean)
  {
    if (B(paramView))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      if (this.m)
      {
        ((LayoutParams)localObject).b = 1.0F;
        ((LayoutParams)localObject).d = 1;
        Q(paramView, true);
        P(paramView);
      }
      else if (paramBoolean)
      {
        ((LayoutParams)localObject).d |= 0x2;
        if (c(paramView, 3)) {
          this.g.R(paramView, 0, paramView.getTop());
        } else {
          this.h.R(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
        }
      }
      else
      {
        F(paramView, 1.0F);
        R(0, paramView);
        paramView.setVisibility(0);
      }
      invalidate();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" is not a sliding drawer");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void I(e parame)
  {
    if (parame == null) {
      return;
    }
    List localList = this.t;
    if (localList == null) {
      return;
    }
    localList.remove(parame);
  }
  
  public void M(Object paramObject, boolean paramBoolean)
  {
    this.B = paramObject;
    this.C = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    setWillNotDraw(paramBoolean);
    requestLayout();
  }
  
  public void N(int paramInt1, int paramInt2)
  {
    int i1 = e.b(paramInt2, x.B(this));
    if (paramInt2 != 3)
    {
      if (paramInt2 != 5)
      {
        if (paramInt2 != 8388611)
        {
          if (paramInt2 == 8388613) {
            this.q = paramInt1;
          }
        }
        else {
          this.p = paramInt1;
        }
      }
      else {
        this.o = paramInt1;
      }
    }
    else {
      this.n = paramInt1;
    }
    Object localObject;
    if (paramInt1 != 0)
    {
      if (i1 == 3) {
        localObject = this.g;
      } else {
        localObject = this.h;
      }
      ((c)localObject).b();
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return;
      }
      localObject = l(i1);
      if (localObject != null) {
        G((View)localObject);
      }
    }
    else
    {
      localObject = l(i1);
      if (localObject != null) {
        d((View)localObject);
      }
    }
  }
  
  void O(View paramView, float paramFloat)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == localLayoutParams.b) {
      return;
    }
    localLayoutParams.b = paramFloat;
    j(paramView, paramFloat);
  }
  
  void R(int paramInt, View paramView)
  {
    int i3 = this.g.B();
    int i4 = this.h.B();
    int i2 = 2;
    int i1;
    if ((i3 != 1) && (i4 != 1))
    {
      i1 = i2;
      if (i3 != 2) {
        if (i4 == 2) {
          i1 = i2;
        } else {
          i1 = 0;
        }
      }
    }
    else
    {
      i1 = 1;
    }
    if ((paramView != null) && (paramInt == 0))
    {
      float f1 = ((LayoutParams)paramView.getLayoutParams()).b;
      if (f1 == 0.0F) {
        h(paramView);
      } else if (f1 == 1.0F) {
        i(paramView);
      }
    }
    if (i1 != this.k)
    {
      this.k = i1;
      paramView = this.t;
      if (paramView != null)
      {
        paramInt = paramView.size() - 1;
        while (paramInt >= 0)
        {
          ((e)this.t.get(paramInt)).a(i1);
          paramInt -= 1;
        }
      }
    }
  }
  
  public void a(e parame)
  {
    if (parame == null) {
      return;
    }
    if (this.t == null) {
      this.t = new ArrayList();
    }
    this.t.add(parame);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int i4 = getChildCount();
    int i3 = 0;
    int i1 = 0;
    int i2 = i1;
    View localView;
    while (i1 < i4)
    {
      localView = getChildAt(i1);
      if (B(localView))
      {
        if (A(localView))
        {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          i2 = 1;
        }
      }
      else {
        this.I.add(localView);
      }
      i1 += 1;
    }
    if (i2 == 0)
    {
      i2 = this.I.size();
      i1 = i3;
      while (i1 < i2)
      {
        localView = (View)this.I.get(i1);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i1 += 1;
      }
    }
    this.I.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((m() == null) && (!B(paramView))) {
      paramInt = 1;
    } else {
      paramInt = 4;
    }
    x.B0(paramView, paramInt);
    if (!O) {
      x.q0(paramView, this.a);
    }
  }
  
  void b()
  {
    if (!this.r)
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        getChildAt(i1).dispatchTouchEvent(localMotionEvent);
        i1 += 1;
      }
      localMotionEvent.recycle();
      this.r = true;
    }
  }
  
  boolean c(View paramView, int paramInt)
  {
    return (r(paramView) & paramInt) == paramInt;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    int i2 = getChildCount();
    float f1 = 0.0F;
    int i1 = 0;
    while (i1 < i2)
    {
      f1 = Math.max(f1, ((LayoutParams)getChildAt(i1).getLayoutParams()).b);
      i1 += 1;
    }
    this.e = f1;
    boolean bool1 = this.g.n(true);
    boolean bool2 = this.h.n(true);
    if ((bool1) || (bool2)) {
      x.h0(this);
    }
  }
  
  public void d(View paramView)
  {
    e(paramView, true);
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) != 0) && (paramMotionEvent.getAction() != 10) && (this.e > 0.0F))
    {
      int i1 = getChildCount();
      if (i1 != 0)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        i1 -= 1;
        while (i1 >= 0)
        {
          View localView = getChildAt(i1);
          if ((D(f1, f2, localView)) && (!z(localView)) && (k(paramMotionEvent, localView))) {
            return true;
          }
          i1 -= 1;
        }
      }
      return false;
    }
    return super.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i8 = getHeight();
    boolean bool1 = z(paramView);
    int i1 = getWidth();
    int i7 = paramCanvas.save();
    int i3 = 0;
    int i2 = i1;
    int i4;
    if (bool1)
    {
      int i9 = getChildCount();
      i3 = 0;
      int i5;
      for (i2 = i3; i3 < i9; i2 = i5)
      {
        View localView = getChildAt(i3);
        i4 = i1;
        i5 = i2;
        if (localView != paramView)
        {
          i4 = i1;
          i5 = i2;
          if (localView.getVisibility() == 0)
          {
            i4 = i1;
            i5 = i2;
            if (v(localView))
            {
              i4 = i1;
              i5 = i2;
              if (B(localView)) {
                if (localView.getHeight() < i8)
                {
                  i4 = i1;
                  i5 = i2;
                }
                else
                {
                  int i6;
                  if (c(localView, 3))
                  {
                    i6 = localView.getRight();
                    i4 = i1;
                    i5 = i2;
                    if (i6 > i2)
                    {
                      i5 = i6;
                      i4 = i1;
                    }
                  }
                  else
                  {
                    i6 = localView.getLeft();
                    i4 = i1;
                    i5 = i2;
                    if (i6 < i1)
                    {
                      i4 = i6;
                      i5 = i2;
                    }
                  }
                }
              }
            }
          }
        }
        i3 += 1;
        i1 = i4;
      }
      paramCanvas.clipRect(i2, 0, i1, getHeight());
      i3 = i2;
      i2 = i1;
    }
    boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i7);
    float f1 = this.e;
    if ((f1 > 0.0F) && (bool1))
    {
      i1 = this.d;
      i4 = (int)(((0xFF000000 & i1) >>> 24) * f1);
      this.f.setColor(i1 & 0xFFFFFF | i4 << 24);
      paramCanvas.drawRect(i3, 0.0F, i2, getHeight(), this.f);
      return bool2;
    }
    if ((this.x != null) && (c(paramView, 3)))
    {
      i1 = this.x.getIntrinsicWidth();
      i2 = paramView.getRight();
      i3 = this.g.y();
      f1 = Math.max(0.0F, Math.min(i2 / i3, 1.0F));
      this.x.setBounds(i2, paramView.getTop(), i1 + i2, paramView.getBottom());
      this.x.setAlpha((int)(f1 * 255.0F));
    }
    for (paramView = this.x;; paramView = this.y)
    {
      paramView.draw(paramCanvas);
      return bool2;
      if ((this.y == null) || (!c(paramView, 5))) {
        break;
      }
      i1 = this.y.getIntrinsicWidth();
      i2 = paramView.getLeft();
      i3 = getWidth();
      i4 = this.h.y();
      f1 = Math.max(0.0F, Math.min((i3 - i2) / i4, 1.0F));
      this.y.setBounds(i2 - i1, paramView.getTop(), i2, paramView.getBottom());
      this.y.setAlpha((int)(f1 * 255.0F));
    }
    return bool2;
  }
  
  public void e(View paramView, boolean paramBoolean)
  {
    if (B(paramView))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      if (this.m)
      {
        ((LayoutParams)localObject).b = 0.0F;
        ((LayoutParams)localObject).d = 0;
      }
      else if (paramBoolean)
      {
        ((LayoutParams)localObject).d |= 0x4;
        int i1;
        if (c(paramView, 3))
        {
          localObject = this.g;
          i1 = -paramView.getWidth();
        }
        else
        {
          localObject = this.h;
          i1 = getWidth();
        }
        ((c)localObject).R(paramView, i1, paramView.getTop());
      }
      else
      {
        F(paramView, 0.0F);
        R(0, paramView);
        paramView.setVisibility(4);
      }
      invalidate();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" is not a sliding drawer");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void f()
  {
    g(false);
  }
  
  void g(boolean paramBoolean)
  {
    int i4 = getChildCount();
    int i1 = 0;
    int i3;
    for (int i2 = i1; i1 < i4; i2 = i3)
    {
      View localView = getChildAt(i1);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      i3 = i2;
      if (B(localView)) {
        if ((paramBoolean) && (!localLayoutParams.c))
        {
          i3 = i2;
        }
        else
        {
          i3 = localView.getWidth();
          int i5;
          if (c(localView, 3)) {
            i5 = this.g.R(localView, -i3, localView.getTop());
          } else {
            i5 = this.h.R(localView, getWidth(), localView.getTop());
          }
          i3 = i2 | i5;
          localLayoutParams.c = false;
        }
      }
      i1 += 1;
    }
    this.i.p();
    this.j.p();
    if (i2 != 0) {
      invalidate();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public float getDrawerElevation()
  {
    if (P) {
      return this.b;
    }
    return 0.0F;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.w;
  }
  
  void h(View paramView)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    if ((((LayoutParams)localObject).d & 0x1) == 1)
    {
      ((LayoutParams)localObject).d = 0;
      localObject = this.t;
      if (localObject != null)
      {
        int i1 = ((List)localObject).size() - 1;
        while (i1 >= 0)
        {
          ((e)this.t.get(i1)).d(paramView);
          i1 -= 1;
        }
      }
      Q(paramView, false);
      P(paramView);
      if (hasWindowFocus())
      {
        paramView = getRootView();
        if (paramView != null) {
          paramView.sendAccessibilityEvent(32);
        }
      }
    }
  }
  
  void i(View paramView)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    if ((((LayoutParams)localObject).d & 0x1) == 0)
    {
      ((LayoutParams)localObject).d = 1;
      localObject = this.t;
      if (localObject != null)
      {
        int i1 = ((List)localObject).size() - 1;
        while (i1 >= 0)
        {
          ((e)this.t.get(i1)).c(paramView);
          i1 -= 1;
        }
      }
      Q(paramView, true);
      P(paramView);
      if (hasWindowFocus()) {
        sendAccessibilityEvent(32);
      }
    }
  }
  
  void j(View paramView, float paramFloat)
  {
    List localList = this.t;
    if (localList != null)
    {
      int i1 = localList.size() - 1;
      while (i1 >= 0)
      {
        ((e)this.t.get(i1)).b(paramView, paramFloat);
        i1 -= 1;
      }
    }
  }
  
  View l(int paramInt)
  {
    int i1 = e.b(paramInt, x.B(this));
    int i2 = getChildCount();
    paramInt = 0;
    while (paramInt < i2)
    {
      View localView = getChildAt(paramInt);
      if ((r(localView) & 0x7) == (i1 & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  View m()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((((LayoutParams)localView.getLayoutParams()).d & 0x1) == 1) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  View n()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((B(localView)) && (C(localView))) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  public int o(int paramInt)
  {
    int i1 = x.B(this);
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 8388611)
        {
          if (paramInt == 8388613)
          {
            paramInt = this.q;
            if (paramInt != 3) {
              return paramInt;
            }
            if (i1 == 0) {
              paramInt = this.o;
            } else {
              paramInt = this.n;
            }
            if (paramInt != 3) {
              return paramInt;
            }
          }
        }
        else
        {
          paramInt = this.p;
          if (paramInt != 3) {
            return paramInt;
          }
          if (i1 == 0) {
            paramInt = this.n;
          } else {
            paramInt = this.o;
          }
          if (paramInt != 3) {
            return paramInt;
          }
        }
      }
      else
      {
        paramInt = this.o;
        if (paramInt != 3) {
          return paramInt;
        }
        if (i1 == 0) {
          paramInt = this.q;
        } else {
          paramInt = this.p;
        }
        if (paramInt != 3) {
          return paramInt;
        }
      }
    }
    else
    {
      paramInt = this.n;
      if (paramInt != 3) {
        return paramInt;
      }
      if (i1 == 0) {
        paramInt = this.p;
      } else {
        paramInt = this.q;
      }
      if (paramInt != 3) {
        return paramInt;
      }
    }
    return 0;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.m = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.m = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.C) && (this.w != null))
    {
      Object localObject = this.B;
      int i1;
      if (localObject != null) {
        i1 = ((WindowInsets)localObject).getSystemWindowInsetTop();
      } else {
        i1 = 0;
      }
      if (i1 > 0)
      {
        this.w.setBounds(0, 0, getWidth(), i1);
        this.w.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool3 = this.g.Q(paramMotionEvent);
    boolean bool4 = this.h.Q(paramMotionEvent);
    boolean bool2 = true;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label93;
          }
        }
        else
        {
          if (!this.g.e(3)) {
            break label93;
          }
          this.i.p();
          this.j.p();
          break label93;
        }
      }
      g(true);
      this.r = false;
      label93:
      i1 = 0;
    }
    else
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.u = f1;
      this.v = f2;
      if (this.e > 0.0F)
      {
        paramMotionEvent = this.g.u((int)f1, (int)f2);
        if ((paramMotionEvent != null) && (z(paramMotionEvent)))
        {
          i1 = 1;
          break label161;
        }
      }
      i1 = 0;
      label161:
      this.r = false;
    }
    boolean bool1 = bool2;
    if (!(bool3 | bool4))
    {
      bool1 = bool2;
      if (i1 == 0)
      {
        bool1 = bool2;
        if (!w())
        {
          if (this.r) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (x()))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = n();
      if ((paramKeyEvent != null) && (p(paramKeyEvent) == 0)) {
        f();
      }
      return paramKeyEvent != null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.l = true;
    int i5 = paramInt3 - paramInt1;
    int i6 = getChildCount();
    paramInt3 = 0;
    Object localObject1;
    Object localObject2;
    while (paramInt3 < i6)
    {
      localObject1 = getChildAt(paramInt3);
      if (((View)localObject1).getVisibility() != 8)
      {
        localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        if (z((View)localObject1))
        {
          paramInt1 = ((ViewGroup.MarginLayoutParams)localObject2).leftMargin;
          ((View)localObject1).layout(paramInt1, ((ViewGroup.MarginLayoutParams)localObject2).topMargin, ((View)localObject1).getMeasuredWidth() + paramInt1, ((ViewGroup.MarginLayoutParams)localObject2).topMargin + ((View)localObject1).getMeasuredHeight());
        }
        else
        {
          int i7 = ((View)localObject1).getMeasuredWidth();
          int i8 = ((View)localObject1).getMeasuredHeight();
          float f1;
          int i1;
          if (c((View)localObject1, 3))
          {
            paramInt1 = -i7;
            f1 = i7;
            i1 = paramInt1 + (int)(((LayoutParams)localObject2).b * f1);
            f1 = (i7 + i1) / f1;
          }
          else
          {
            f1 = i7;
            i1 = i5 - (int)(((LayoutParams)localObject2).b * f1);
            f1 = (i5 - i1) / f1;
          }
          int i2;
          if (f1 != ((LayoutParams)localObject2).b) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          paramInt1 = ((LayoutParams)localObject2).a & 0x70;
          if (paramInt1 != 16)
          {
            if (paramInt1 != 80)
            {
              i4 = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
              paramInt1 = i7 + i1;
              i3 = i8 + i4;
            }
            for (;;)
            {
              ((View)localObject1).layout(i1, i4, paramInt1, i3);
              break;
              i3 = paramInt4 - paramInt2;
              i4 = i3 - ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin - ((View)localObject1).getMeasuredHeight();
              paramInt1 = i7 + i1;
              i3 -= ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin;
            }
          }
          int i4 = paramInt4 - paramInt2;
          int i3 = (i4 - i8) / 2;
          paramInt1 = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
          if (i3 >= paramInt1)
          {
            int i9 = ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin;
            paramInt1 = i3;
            if (i3 + i8 > i4 - i9) {
              paramInt1 = i4 - i9 - i8;
            }
          }
          ((View)localObject1).layout(i1, paramInt1, i7 + i1, i8 + paramInt1);
          if (i2 != 0) {
            O((View)localObject1, f1);
          }
          if (((LayoutParams)localObject2).b > 0.0F) {
            paramInt1 = 0;
          } else {
            paramInt1 = 4;
          }
          if (((View)localObject1).getVisibility() != paramInt1) {
            ((View)localObject1).setVisibility(paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    if (Q)
    {
      localObject1 = getRootWindowInsets();
      if (localObject1 != null)
      {
        localObject1 = h0.w((WindowInsets)localObject1).h();
        localObject2 = this.g;
        ((c)localObject2).M(Math.max(((c)localObject2).x(), ((q0.b)localObject1).a));
        localObject2 = this.h;
        ((c)localObject2).M(Math.max(((c)localObject2).x(), ((q0.b)localObject1).c));
      }
    }
    this.l = false;
    this.m = false;
  }
  
  @SuppressLint({"WrongConstant"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int i3;
    int i4;
    if (i6 == 1073741824)
    {
      i3 = i1;
      i4 = i2;
      if (i5 == 1073741824) {}
    }
    else
    {
      if (!isInEditMode()) {
        break label753;
      }
      if (i6 == 0) {
        i1 = 300;
      }
      i3 = i1;
      i4 = i2;
      if (i5 == 0)
      {
        i4 = 300;
        i3 = i1;
      }
    }
    setMeasuredDimension(i3, i4);
    if ((this.B != null) && (x.y(this))) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    int i8 = x.B(this);
    int i9 = getChildCount();
    i6 = 0;
    i2 = i6;
    i1 = i2;
    while (i6 < i9)
    {
      View localView = getChildAt(i6);
      LayoutParams localLayoutParams;
      int i7;
      Object localObject;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (i5 != 0)
        {
          i7 = e.b(localLayoutParams.a, i8);
          boolean bool = x.y(localView);
          WindowInsets localWindowInsets = (WindowInsets)this.B;
          if (bool)
          {
            if (i7 == 3)
            {
              localObject = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
            }
            else
            {
              localObject = localWindowInsets;
              if (i7 == 5) {
                localObject = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
              }
            }
            localView.dispatchApplyWindowInsets((WindowInsets)localObject);
          }
          else
          {
            if (i7 == 3)
            {
              localObject = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
            }
            else
            {
              localObject = localWindowInsets;
              if (i7 == 5) {
                localObject = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
              }
            }
            localLayoutParams.leftMargin = ((WindowInsets)localObject).getSystemWindowInsetLeft();
            localLayoutParams.topMargin = ((WindowInsets)localObject).getSystemWindowInsetTop();
            localLayoutParams.rightMargin = ((WindowInsets)localObject).getSystemWindowInsetRight();
            localLayoutParams.bottomMargin = ((WindowInsets)localObject).getSystemWindowInsetBottom();
          }
        }
        if (z(localView)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i3 - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
        }
      }
      else
      {
        break label678;
      }
      if (B(localView))
      {
        if (P)
        {
          float f1 = x.w(localView);
          float f2 = this.b;
          if (f1 != f2) {
            x.y0(localView, f2);
          }
        }
        int i10 = r(localView) & 0x7;
        if (i10 == 3) {
          i7 = 1;
        } else {
          i7 = 0;
        }
        if (((i7 != 0) && (i2 != 0)) || ((i7 == 0) && (i1 != 0)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Child drawer has absolute gravity ");
          ((StringBuilder)localObject).append(u(i10));
          ((StringBuilder)localObject).append(" but this ");
          ((StringBuilder)localObject).append("DrawerLayout");
          ((StringBuilder)localObject).append(" already has a drawer view along that edge");
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
        if (i7 != 0) {
          i2 = 1;
        } else {
          i1 = 1;
        }
        localView.measure(ViewGroup.getChildMeasureSpec(paramInt1, this.c + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), ViewGroup.getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
        label678:
        i6 += 1;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Child ");
        ((StringBuilder)localObject).append(localView);
        ((StringBuilder)localObject).append(" at index ");
        ((StringBuilder)localObject).append(i6);
        ((StringBuilder)localObject).append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    return;
    label753:
    throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.g());
    int i1 = paramParcelable.c;
    if (i1 != 0)
    {
      View localView = l(i1);
      if (localView != null) {
        G(localView);
      }
    }
    i1 = paramParcelable.d;
    if (i1 != 3) {
      N(i1, 3);
    }
    i1 = paramParcelable.e;
    if (i1 != 3) {
      N(i1, 5);
    }
    i1 = paramParcelable.f;
    if (i1 != 3) {
      N(i1, 8388611);
    }
    i1 = paramParcelable.g;
    if (i1 != 3) {
      N(i1, 8388613);
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    L();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int i4 = getChildCount();
    int i1 = 0;
    while (i1 < i4)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i1).getLayoutParams();
      int i5 = localLayoutParams.d;
      int i3 = 1;
      int i2;
      if (i5 == 1) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (i5 != 2) {
        i3 = 0;
      }
      if ((i2 == 0) && (i3 == 0)) {
        i1 += 1;
      } else {
        localSavedState.c = localLayoutParams.a;
      }
    }
    localSavedState.d = this.n;
    localSavedState.e = this.o;
    localSavedState.f = this.p;
    localSavedState.g = this.q;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.g.G(paramMotionEvent);
    this.h.G(paramMotionEvent);
    int i1 = paramMotionEvent.getAction() & 0xFF;
    boolean bool = false;
    float f2;
    float f1;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 3) {
          return true;
        }
        g(true);
      }
      else
      {
        f2 = paramMotionEvent.getX();
        f1 = paramMotionEvent.getY();
        paramMotionEvent = this.g.u((int)f2, (int)f1);
        if ((paramMotionEvent != null) && (z(paramMotionEvent)))
        {
          f2 -= this.u;
          f1 -= this.v;
          i1 = this.g.A();
          if (f2 * f2 + f1 * f1 < i1 * i1)
          {
            paramMotionEvent = m();
            if ((paramMotionEvent != null) && (p(paramMotionEvent) != 2)) {
              break label151;
            }
          }
        }
        bool = true;
        label151:
        g(bool);
        return true;
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.u = f1;
      this.v = f2;
    }
    this.r = false;
    return true;
  }
  
  public int p(View paramView)
  {
    if (B(paramView)) {
      return o(((LayoutParams)paramView.getLayoutParams()).a);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public CharSequence q(int paramInt)
  {
    paramInt = e.b(paramInt, x.B(this));
    if (paramInt == 3) {
      return this.z;
    }
    if (paramInt == 5) {
      return this.A;
    }
    return null;
  }
  
  int r(View paramView)
  {
    return e.b(((LayoutParams)paramView.getLayoutParams()).a, x.B(this));
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if (paramBoolean) {
      g(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.l) {
      super.requestLayout();
    }
  }
  
  float s(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).b;
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    this.b = paramFloat;
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (B(localView)) {
        x.y0(localView, this.b);
      }
      i1 += 1;
    }
  }
  
  @Deprecated
  public void setDrawerListener(e parame)
  {
    e locale = this.s;
    if (locale != null) {
      I(locale);
    }
    if (parame != null) {
      a(parame);
    }
    this.s = parame;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    N(paramInt, 3);
    N(paramInt, 5);
  }
  
  public void setScrimColor(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = androidx.core.content.b.d(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    this.w = localDrawable;
    invalidate();
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    this.w = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    this.w = new ColorDrawable(paramInt);
    invalidate();
  }
  
  boolean z(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).a == 0;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int a = 0;
    float b;
    boolean c;
    int d;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.N);
      this.a = paramContext.getInt(0, 0);
      paramContext.recycle();
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
      this.a = paramLayoutParams.a;
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int c = 0;
    int d;
    int e;
    int f;
    int g;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeInt(this.g);
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<DrawerLayout.SavedState>
    {
      public DrawerLayout.SavedState a(Parcel paramParcel)
      {
        return new DrawerLayout.SavedState(paramParcel, null);
      }
      
      public DrawerLayout.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new DrawerLayout.SavedState(paramParcel, paramClassLoader);
      }
      
      public DrawerLayout.SavedState[] c(int paramInt)
      {
        return new DrawerLayout.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements g
  {
    a() {}
    
    public boolean a(View paramView, g.a parama)
    {
      if ((DrawerLayout.this.A(paramView)) && (DrawerLayout.this.p(paramView) != 2))
      {
        DrawerLayout.this.d(paramView);
        return true;
      }
      return false;
    }
  }
  
  class b
    implements View.OnApplyWindowInsetsListener
  {
    b() {}
    
    public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
    {
      paramView = (DrawerLayout)paramView;
      boolean bool;
      if (paramWindowInsets.getSystemWindowInsetTop() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramView.M(paramWindowInsets, bool);
      return paramWindowInsets.consumeSystemWindowInsets();
    }
  }
  
  class c
    extends androidx.core.view.a
  {
    private final Rect d = new Rect();
    
    c() {}
    
    private void n(d paramd, ViewGroup paramViewGroup)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        if (DrawerLayout.y(localView)) {
          paramd.c(localView);
        }
        i += 1;
      }
    }
    
    private void o(d paramd1, d paramd2)
    {
      Rect localRect = this.d;
      paramd2.n(localRect);
      paramd1.Y(localRect);
      paramd1.H0(paramd2.N());
      paramd1.s0(paramd2.v());
      paramd1.c0(paramd2.p());
      paramd1.g0(paramd2.r());
      paramd1.i0(paramd2.F());
      paramd1.l0(paramd2.H());
      paramd1.V(paramd2.B());
      paramd1.A0(paramd2.L());
      paramd1.a(paramd2.k());
    }
    
    public boolean a(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramView = paramAccessibilityEvent.getText();
        paramAccessibilityEvent = DrawerLayout.this.n();
        if (paramAccessibilityEvent != null)
        {
          int i = DrawerLayout.this.r(paramAccessibilityEvent);
          paramAccessibilityEvent = DrawerLayout.this.q(i);
          if (paramAccessibilityEvent != null) {
            paramView.add(paramAccessibilityEvent);
          }
        }
        return true;
      }
      return super.a(paramView, paramAccessibilityEvent);
    }
    
    public void f(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.f(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
    }
    
    public void g(View paramView, d paramd)
    {
      if (DrawerLayout.O)
      {
        super.g(paramView, paramd);
      }
      else
      {
        d locald = d.Q(paramd);
        super.g(paramView, locald);
        paramd.C0(paramView);
        ViewParent localViewParent = x.H(paramView);
        if ((localViewParent instanceof View)) {
          paramd.u0((View)localViewParent);
        }
        o(paramd, locald);
        locald.S();
        n(paramd, (ViewGroup)paramView);
      }
      paramd.c0("androidx.drawerlayout.widget.DrawerLayout");
      paramd.k0(false);
      paramd.l0(false);
      paramd.T(d.a.e);
      paramd.T(d.a.f);
    }
    
    public boolean i(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((!DrawerLayout.O) && (!DrawerLayout.y(paramView))) {
        return false;
      }
      return super.i(paramViewGroup, paramView, paramAccessibilityEvent);
    }
  }
  
  static final class d
    extends androidx.core.view.a
  {
    public void g(View paramView, d paramd)
    {
      super.g(paramView, paramd);
      if (!DrawerLayout.y(paramView)) {
        paramd.u0(null);
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(int paramInt);
    
    public abstract void b(View paramView, float paramFloat);
    
    public abstract void c(View paramView);
    
    public abstract void d(View paramView);
  }
  
  private class f
    extends c.c
  {
    private final int a;
    private c b;
    private final Runnable c = new a();
    
    f(int paramInt)
    {
      this.a = paramInt;
    }
    
    private void n()
    {
      int j = this.a;
      int i = 3;
      if (j == 3) {
        i = 5;
      }
      View localView = DrawerLayout.this.l(i);
      if (localView != null) {
        DrawerLayout.this.d(localView);
      }
    }
    
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      int i;
      if (DrawerLayout.this.c(paramView, 3))
      {
        paramInt2 = -paramView.getWidth();
        i = 0;
      }
      for (;;)
      {
        return Math.max(paramInt2, Math.min(paramInt1, i));
        i = DrawerLayout.this.getWidth();
        paramInt2 = i - paramView.getWidth();
      }
    }
    
    public int b(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public int d(View paramView)
    {
      if (DrawerLayout.this.B(paramView)) {
        return paramView.getWidth();
      }
      return 0;
    }
    
    public void f(int paramInt1, int paramInt2)
    {
      if ((paramInt1 & 0x1) == 1)
      {
        localObject = DrawerLayout.this;
        paramInt1 = 3;
      }
      else
      {
        localObject = DrawerLayout.this;
        paramInt1 = 5;
      }
      Object localObject = ((DrawerLayout)localObject).l(paramInt1);
      if ((localObject != null) && (DrawerLayout.this.p((View)localObject) == 0)) {
        this.b.c((View)localObject, paramInt2);
      }
    }
    
    public boolean g(int paramInt)
    {
      return false;
    }
    
    public void h(int paramInt1, int paramInt2)
    {
      DrawerLayout.this.postDelayed(this.c, 160L);
    }
    
    public void i(View paramView, int paramInt)
    {
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).c = false;
      n();
    }
    
    public void j(int paramInt)
    {
      DrawerLayout.this.R(paramInt, this.b.w());
    }
    
    public void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt2 = paramView.getWidth();
      float f;
      if (DrawerLayout.this.c(paramView, 3)) {
        f = paramInt1 + paramInt2;
      } else {
        f = DrawerLayout.this.getWidth() - paramInt1;
      }
      f /= paramInt2;
      DrawerLayout.this.O(paramView, f);
      if (f == 0.0F) {
        paramInt1 = 4;
      } else {
        paramInt1 = 0;
      }
      paramView.setVisibility(paramInt1);
      DrawerLayout.this.invalidate();
    }
    
    public void l(View paramView, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = DrawerLayout.this.s(paramView);
      int k = paramView.getWidth();
      int i;
      if (DrawerLayout.this.c(paramView, 3))
      {
        boolean bool = paramFloat1 < 0.0F;
        if ((!bool) && ((bool) || (paramFloat2 <= 0.5F))) {
          i = -k;
        } else {
          i = 0;
        }
      }
      else
      {
        int j = DrawerLayout.this.getWidth();
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (paramFloat2 <= 0.5F) {}
          }
        }
        else
        {
          i = j - k;
        }
      }
      this.b.P(i, paramView.getTop());
      DrawerLayout.this.invalidate();
    }
    
    public boolean m(View paramView, int paramInt)
    {
      return (DrawerLayout.this.B(paramView)) && (DrawerLayout.this.c(paramView, this.a)) && (DrawerLayout.this.p(paramView) == 0);
    }
    
    void o()
    {
      int k = this.b.y();
      int i = this.a;
      int j = 0;
      if (i == 3) {
        i = 1;
      } else {
        i = 0;
      }
      View localView;
      if (i != 0)
      {
        localView = DrawerLayout.this.l(3);
        if (localView != null) {
          j = -localView.getWidth();
        }
        j += k;
      }
      else
      {
        localView = DrawerLayout.this.l(5);
        j = DrawerLayout.this.getWidth() - k;
      }
      if ((localView != null) && (((i != 0) && (localView.getLeft() < j)) || ((i == 0) && (localView.getLeft() > j) && (DrawerLayout.this.p(localView) == 0))))
      {
        DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        this.b.R(localView, j, localView.getTop());
        localLayoutParams.c = true;
        DrawerLayout.this.invalidate();
        n();
        DrawerLayout.this.b();
      }
    }
    
    public void p()
    {
      DrawerLayout.this.removeCallbacks(this.c);
    }
    
    public void q(c paramc)
    {
      this.b = paramc;
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        DrawerLayout.f.this.o();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.drawerlayout.widget.DrawerLayout
 * JD-Core Version:    0.7.0.1
 */