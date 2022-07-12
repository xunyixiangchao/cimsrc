package androidx.gridlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.view.a0;
import androidx.core.view.x;
import androidx.gridlayout.R.dimen;
import androidx.gridlayout.R.styleable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GridLayout
  extends ViewGroup
{
  public static final i A = new f();
  public static final i B = new g();
  public static final i C = new h();
  static final Printer i = new LogPrinter(3, GridLayout.class.getName());
  static final Printer j = new a();
  private static final int k = R.styleable.GridLayout_orientation;
  private static final int l = R.styleable.GridLayout_rowCount;
  private static final int m = R.styleable.GridLayout_columnCount;
  private static final int n = R.styleable.GridLayout_useDefaultMargins;
  private static final int o = R.styleable.GridLayout_alignmentMode;
  private static final int p = R.styleable.GridLayout_rowOrderPreserved;
  private static final int q = R.styleable.GridLayout_columnOrderPreserved;
  static final i r = new b();
  private static final i s;
  private static final i t;
  public static final i u;
  public static final i v;
  public static final i w;
  public static final i x;
  public static final i y;
  public static final i z;
  final l a = new l(true);
  final l b = new l(false);
  int c = 0;
  boolean d = false;
  int e = 1;
  int f;
  int g = 0;
  Printer h = i;
  
  static
  {
    c localc = new c();
    s = localc;
    d locald = new d();
    t = locald;
    u = localc;
    v = locald;
    w = localc;
    x = locald;
    y = h(localc, locald);
    z = h(locald, localc);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f = paramContext.getResources().getDimensionPixelOffset(R.dimen.default_gap);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GridLayout);
    try
    {
      setRowCount(paramContext.getInt(l, -2147483648));
      setColumnCount(paramContext.getInt(m, -2147483648));
      setOrientation(paramContext.getInt(k, 0));
      setUseDefaultMargins(paramContext.getBoolean(n, false));
      setAlignmentMode(paramContext.getInt(o, 1));
      setRowOrderPreserved(paramContext.getBoolean(p, true));
      setColumnOrderPreserved(paramContext.getBoolean(q, true));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  static int A(int[] paramArrayOfInt, int paramInt)
  {
    int i3 = paramArrayOfInt.length;
    int i2 = 0;
    int i1 = paramInt;
    paramInt = i2;
    while (paramInt < i3)
    {
      i1 = Math.max(i1, paramArrayOfInt[paramInt]);
      paramInt += 1;
    }
    return i1;
  }
  
  private void B(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.measure(ViewGroup.getChildMeasureSpec(paramInt1, v(paramView, true), paramInt3), ViewGroup.getChildMeasureSpec(paramInt2, v(paramView, false), paramInt4));
  }
  
  private void C(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i5 = getChildCount();
    int i3 = 0;
    while (i3 < i5)
    {
      View localView = getChildAt(i3);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = q(localView);
        int i1;
        int i2;
        if (paramBoolean)
        {
          i1 = localLayoutParams.width;
          i2 = localLayoutParams.height;
        }
        for (;;)
        {
          B(localView, paramInt1, paramInt2, i1, i2);
          break;
          boolean bool;
          if (this.c == 0) {
            bool = true;
          } else {
            bool = false;
          }
          if (bool) {
            localObject = localLayoutParams.b;
          } else {
            localObject = localLayoutParams.a;
          }
          if (((q)localObject).b(bool) != C) {
            break;
          }
          n localn = ((q)localObject).b;
          if (bool) {
            localObject = this.a;
          } else {
            localObject = this.b;
          }
          Object localObject = ((l)localObject).u();
          i2 = localObject[localn.b] - localObject[localn.a] - v(localView, bool);
          if (bool)
          {
            int i4 = localLayoutParams.height;
            i1 = i2;
            i2 = i4;
          }
          else
          {
            i1 = localLayoutParams.width;
          }
        }
      }
      i3 += 1;
    }
  }
  
  private static void D(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramArrayOfInt.length;
    Arrays.fill(paramArrayOfInt, Math.min(paramInt1, i1), Math.min(paramInt2, i1), paramInt3);
  }
  
  private static void E(LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramLayoutParams.d(new n(paramInt1, paramInt2 + paramInt1));
    paramLayoutParams.c(new n(paramInt3, paramInt4 + paramInt3));
  }
  
  public static q F(int paramInt)
  {
    return G(paramInt, 1);
  }
  
  public static q G(int paramInt1, int paramInt2)
  {
    return H(paramInt1, paramInt2, r);
  }
  
  public static q H(int paramInt1, int paramInt2, i parami)
  {
    return I(paramInt1, paramInt2, parami, 0.0F);
  }
  
  public static q I(int paramInt1, int paramInt2, i parami, float paramFloat)
  {
    boolean bool;
    if (paramInt1 != -2147483648) {
      bool = true;
    } else {
      bool = false;
    }
    return new q(bool, paramInt1, paramInt2, parami, paramFloat);
  }
  
  private void J()
  {
    int i7;
    if (this.c == 0) {
      i7 = 1;
    } else {
      i7 = 0;
    }
    Object localObject;
    if (i7 != 0) {
      localObject = this.a;
    } else {
      localObject = this.b;
    }
    int i8 = ((l)localObject).b;
    if (i8 == -2147483648) {
      i8 = 0;
    }
    int[] arrayOfInt = new int[i8];
    int i10 = getChildCount();
    int i9 = 0;
    int i1 = i9;
    int i2 = i1;
    while (i9 < i10)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i9).getLayoutParams();
      if (i7 != 0) {
        localObject = localLayoutParams.a;
      } else {
        localObject = localLayoutParams.b;
      }
      n localn = ((q)localObject).b;
      boolean bool1 = ((q)localObject).a;
      int i11 = localn.b();
      if (bool1) {
        i1 = localn.a;
      }
      if (i7 != 0) {
        localObject = localLayoutParams.b;
      } else {
        localObject = localLayoutParams.a;
      }
      localn = ((q)localObject).b;
      boolean bool2 = ((q)localObject).a;
      int i12 = e(localn, bool2, i8);
      if (bool2) {
        i2 = localn.a;
      }
      int i5 = i1;
      int i6 = i2;
      if (i8 != 0)
      {
        int i3 = i1;
        int i4 = i2;
        if (bool1)
        {
          i5 = i1;
          i6 = i2;
          if (!bool2)
          {
            i4 = i2;
            i3 = i1;
          }
        }
        else
        {
          for (;;)
          {
            i1 = i4 + i12;
            i5 = i3;
            i6 = i4;
            if (i(arrayOfInt, i3, i4, i1)) {
              break;
            }
            if (bool2)
            {
              i3 += 1;
            }
            else if (i1 <= i8)
            {
              i4 += 1;
            }
            else
            {
              i3 += 1;
              i4 = 0;
            }
          }
        }
        D(arrayOfInt, i6, i6 + i12, i5 + i11);
      }
      if (i7 != 0) {
        E(localLayoutParams, i5, i11, i6, i12);
      } else {
        E(localLayoutParams, i6, i12, i5, i11);
      }
      i2 = i6 + i12;
      i9 += 1;
      i1 = i5;
    }
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2 + paramInt1), View.MeasureSpec.getMode(paramInt1));
  }
  
  static <T> T[] b(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT1.getClass().getComponentType(), paramArrayOfT1.length + paramArrayOfT2.length);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, paramArrayOfT1.length, paramArrayOfT2.length);
    return arrayOfObject;
  }
  
  static boolean c(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private void d(LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "column";
    } else {
      str = "row";
    }
    if (paramBoolean) {
      paramLayoutParams = paramLayoutParams.b;
    } else {
      paramLayoutParams = paramLayoutParams.a;
    }
    n localn = paramLayoutParams.b;
    int i1 = localn.a;
    if ((i1 != -2147483648) && (i1 < 0))
    {
      paramLayoutParams = new StringBuilder();
      paramLayoutParams.append(str);
      paramLayoutParams.append(" indices must be positive");
      w(paramLayoutParams.toString());
    }
    if (paramBoolean) {
      paramLayoutParams = this.a;
    } else {
      paramLayoutParams = this.b;
    }
    i1 = paramLayoutParams.b;
    if (i1 != -2147483648)
    {
      if (localn.b > i1)
      {
        paramLayoutParams = new StringBuilder();
        paramLayoutParams.append(str);
        paramLayoutParams.append(" indices (start + span) mustn't exceed the ");
        paramLayoutParams.append(str);
        paramLayoutParams.append(" count");
        w(paramLayoutParams.toString());
      }
      if (localn.b() > i1)
      {
        paramLayoutParams = new StringBuilder();
        paramLayoutParams.append(str);
        paramLayoutParams.append(" span mustn't exceed the ");
        paramLayoutParams.append(str);
        paramLayoutParams.append(" count");
        w(paramLayoutParams.toString());
      }
    }
  }
  
  private static int e(n paramn, boolean paramBoolean, int paramInt)
  {
    int i2 = paramn.b();
    if (paramInt == 0) {
      return i2;
    }
    int i1;
    if (paramBoolean) {
      i1 = Math.min(paramn.a, paramInt);
    } else {
      i1 = 0;
    }
    return Math.min(i2, paramInt - i1);
  }
  
  private int f()
  {
    int i3 = getChildCount();
    int i2 = 1;
    int i1 = 0;
    while (i1 < i3)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 8) {
        i2 = i2 * 31 + ((LayoutParams)localView.getLayoutParams()).hashCode();
      }
      i1 += 1;
    }
    return i2;
  }
  
  private void g()
  {
    int i1 = this.g;
    if (i1 == 0)
    {
      J();
      this.g = f();
      return;
    }
    if (i1 != f())
    {
      this.h.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
      x();
      g();
    }
  }
  
  private static i h(i parami1, final i parami2)
  {
    return new e(parami1, parami2);
  }
  
  private static boolean i(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramArrayOfInt.length) {
      return false;
    }
    while (paramInt2 < paramInt3)
    {
      if (paramArrayOfInt[paramInt2] > paramInt1) {
        return false;
      }
      paramInt2 += 1;
    }
    return true;
  }
  
  static i m(int paramInt, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 7;
    } else {
      i1 = 112;
    }
    int i2;
    if (paramBoolean) {
      i2 = 0;
    } else {
      i2 = 4;
    }
    paramInt = (paramInt & i1) >> i2;
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 5)
        {
          if (paramInt != 7)
          {
            if (paramInt != 8388611)
            {
              if (paramInt != 8388613) {
                return r;
              }
              return x;
            }
            return w;
          }
          return C;
        }
        if (paramBoolean) {
          return z;
        }
        return v;
      }
      if (paramBoolean) {
        return y;
      }
      return u;
    }
    return A;
  }
  
  private int n(View paramView, LayoutParams paramLayoutParams, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = this.d;
    boolean bool2 = false;
    if (!bool1) {
      return 0;
    }
    if (paramBoolean1) {
      paramLayoutParams = paramLayoutParams.b;
    } else {
      paramLayoutParams = paramLayoutParams.a;
    }
    l locall;
    if (paramBoolean1) {
      locall = this.a;
    } else {
      locall = this.b;
    }
    paramLayoutParams = paramLayoutParams.b;
    if ((paramBoolean1) && (z()))
    {
      if (!paramBoolean2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    else {
      bool1 = paramBoolean2;
    }
    if (bool1)
    {
      bool1 = bool2;
      if (paramLayoutParams.a != 0) {
        break label127;
      }
    }
    else
    {
      bool1 = bool2;
      if (paramLayoutParams.b != locall.p()) {
        break label127;
      }
    }
    bool1 = true;
    label127:
    return p(paramView, bool1, paramBoolean1, paramBoolean2);
  }
  
  private int o(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramView.getClass() != androidx.legacy.widget.Space.class) && (paramView.getClass() != android.widget.Space.class)) {
      return this.f / 2;
    }
    return 0;
  }
  
  private int p(View paramView, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return o(paramView, paramBoolean2, paramBoolean3);
  }
  
  private int r(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e == 1) {
      return s(paramView, paramBoolean1, paramBoolean2);
    }
    Object localObject;
    if (paramBoolean1) {
      localObject = this.a;
    } else {
      localObject = this.b;
    }
    if (paramBoolean2) {
      localObject = ((l)localObject).t();
    } else {
      localObject = ((l)localObject).y();
    }
    paramView = q(paramView);
    if (paramBoolean1) {
      paramView = paramView.b;
    } else {
      paramView = paramView.a;
    }
    paramView = paramView.b;
    int i1;
    if (paramBoolean2) {
      i1 = paramView.a;
    } else {
      i1 = paramView.b;
    }
    return localObject[i1];
  }
  
  private int t(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramView.getMeasuredWidth();
    }
    return paramView.getMeasuredHeight();
  }
  
  private int v(View paramView, boolean paramBoolean)
  {
    return r(paramView, paramBoolean, true) + r(paramView, paramBoolean, false);
  }
  
  static void w(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(". ");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void x()
  {
    this.g = 0;
    l locall = this.a;
    if (locall != null) {
      locall.E();
    }
    locall = this.b;
    if (locall != null) {
      locall.E();
    }
    y();
  }
  
  private void y()
  {
    l locall = this.a;
    if ((locall != null) && (this.b != null))
    {
      locall.F();
      this.b.F();
    }
  }
  
  private boolean z()
  {
    return x.B(this) == 1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!(paramLayoutParams instanceof LayoutParams)) {
      return false;
    }
    paramLayoutParams = (LayoutParams)paramLayoutParams;
    d(paramLayoutParams, true);
    d(paramLayoutParams, false);
    return true;
  }
  
  public int getAlignmentMode()
  {
    return this.e;
  }
  
  public int getColumnCount()
  {
    return this.a.p();
  }
  
  public int getOrientation()
  {
    return this.c;
  }
  
  public Printer getPrinter()
  {
    return this.h;
  }
  
  public int getRowCount()
  {
    return this.b.p();
  }
  
  public boolean getUseDefaultMargins()
  {
    return this.d;
  }
  
  protected LayoutParams j()
  {
    return new LayoutParams();
  }
  
  public LayoutParams k(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams l(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = this;
    g();
    paramInt3 -= paramInt1;
    int i1 = getPaddingLeft();
    int i2 = getPaddingTop();
    int i3 = getPaddingRight();
    paramInt1 = getPaddingBottom();
    ((GridLayout)localObject1).a.G(paramInt3 - i1 - i3);
    ((GridLayout)localObject1).b.G(paramInt4 - paramInt2 - i2 - paramInt1);
    int[] arrayOfInt = ((GridLayout)localObject1).a.u();
    localObject1 = ((GridLayout)localObject1).b.u();
    paramInt4 = getChildCount();
    paramBoolean = false;
    paramInt1 = 0;
    for (;;)
    {
      GridLayout localGridLayout = this;
      if (paramInt1 >= paramInt4) {
        break;
      }
      View localView = localGridLayout.getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        Object localObject3 = localGridLayout.q(localView);
        Object localObject2 = ((LayoutParams)localObject3).b;
        localObject3 = ((LayoutParams)localObject3).a;
        Object localObject4 = ((q)localObject2).b;
        Object localObject5 = ((q)localObject3).b;
        paramInt2 = arrayOfInt[localObject4.a];
        int i4 = localObject1[localObject5.a];
        int i6 = arrayOfInt[localObject4.b];
        int i5 = localObject1[localObject5.b];
        int i10 = i6 - paramInt2;
        int i12 = i5 - i4;
        int i15 = localGridLayout.t(localView, true);
        int i13 = localGridLayout.t(localView, paramBoolean);
        localObject2 = ((q)localObject2).b(true);
        localObject3 = ((q)localObject3).b(paramBoolean);
        localObject4 = (m)localGridLayout.a.s().c(paramInt1);
        localObject5 = (m)localGridLayout.b.s().c(paramInt1);
        int i11 = ((i)localObject2).d(localView, i10 - ((m)localObject4).e(true));
        i5 = ((i)localObject3).d(localView, i12 - ((m)localObject5).e(true));
        int i8 = localGridLayout.r(localView, true, true);
        i6 = localGridLayout.r(localView, false, true);
        int i9 = localGridLayout.r(localView, true, false);
        int i7 = localGridLayout.r(localView, false, false);
        int i16 = i8 + i9;
        int i17 = i6 + i7;
        paramBoolean = false;
        int i14 = ((m)localObject4).a(this, localView, (i)localObject2, i15 + i16, true);
        i7 = ((m)localObject5).a(this, localView, (i)localObject3, i13 + i17, false);
        i10 = ((i)localObject2).e(localView, i15, i10 - i16);
        i12 = ((i)localObject3).e(localView, i13, i12 - i17);
        paramInt2 = paramInt2 + i11 + i14;
        if (!z()) {
          paramInt2 = i1 + i8 + paramInt2;
        } else {
          paramInt2 = paramInt3 - i10 - i3 - i9 - paramInt2;
        }
        i4 = i2 + i4 + i5 + i7 + i6;
        if ((i10 != localView.getMeasuredWidth()) || (i12 != localView.getMeasuredHeight())) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
        }
        localView.layout(paramInt2, i4, i10 + paramInt2, i12 + i4);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    g();
    y();
    int i4 = getPaddingLeft() + getPaddingRight();
    int i3 = getPaddingTop() + getPaddingBottom();
    int i5 = a(paramInt1, -i4);
    int i6 = a(paramInt2, -i3);
    C(i5, i6, true);
    if (this.c == 0)
    {
      i2 = this.a.w(i5);
      C(i5, i6, false);
      i1 = this.b.w(i6);
    }
    else
    {
      i1 = this.b.w(i6);
      C(i5, i6, false);
      i2 = this.a.w(i5);
    }
    int i2 = Math.max(i2 + i4, getSuggestedMinimumWidth());
    int i1 = Math.max(i1 + i3, getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(i2, paramInt1, 0), View.resolveSizeAndState(i1, paramInt2, 0));
  }
  
  final LayoutParams q(View paramView)
  {
    return (LayoutParams)paramView.getLayoutParams();
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    x();
  }
  
  int s(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    LayoutParams localLayoutParams = q(paramView);
    int i1;
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        i1 = localLayoutParams.leftMargin;
      } else {
        i1 = localLayoutParams.rightMargin;
      }
    }
    else if (paramBoolean2) {
      i1 = localLayoutParams.topMargin;
    } else {
      i1 = localLayoutParams.bottomMargin;
    }
    int i2 = i1;
    if (i1 == -2147483648) {
      i2 = n(paramView, localLayoutParams, paramBoolean1, paramBoolean2);
    }
    return i2;
  }
  
  public void setAlignmentMode(int paramInt)
  {
    this.e = paramInt;
    requestLayout();
  }
  
  public void setColumnCount(int paramInt)
  {
    this.a.J(paramInt);
    x();
    requestLayout();
  }
  
  public void setColumnOrderPreserved(boolean paramBoolean)
  {
    this.a.K(paramBoolean);
    x();
    requestLayout();
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      x();
      requestLayout();
    }
  }
  
  public void setPrinter(Printer paramPrinter)
  {
    Printer localPrinter = paramPrinter;
    if (paramPrinter == null) {
      localPrinter = j;
    }
    this.h = localPrinter;
  }
  
  public void setRowCount(int paramInt)
  {
    this.b.J(paramInt);
    x();
    requestLayout();
  }
  
  public void setRowOrderPreserved(boolean paramBoolean)
  {
    this.b.K(paramBoolean);
    x();
    requestLayout();
  }
  
  public void setUseDefaultMargins(boolean paramBoolean)
  {
    this.d = paramBoolean;
    requestLayout();
  }
  
  final int u(View paramView, boolean paramBoolean)
  {
    if (paramView.getVisibility() == 8) {
      return 0;
    }
    return t(paramView, paramBoolean) + v(paramView, paramBoolean);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final GridLayout.n c;
    private static final int d;
    private static final int e = R.styleable.GridLayout_Layout_android_layout_margin;
    private static final int f = R.styleable.GridLayout_Layout_android_layout_marginLeft;
    private static final int g = R.styleable.GridLayout_Layout_android_layout_marginTop;
    private static final int h = R.styleable.GridLayout_Layout_android_layout_marginRight;
    private static final int i = R.styleable.GridLayout_Layout_android_layout_marginBottom;
    private static final int j = R.styleable.GridLayout_Layout_layout_column;
    private static final int k = R.styleable.GridLayout_Layout_layout_columnSpan;
    private static final int l = R.styleable.GridLayout_Layout_layout_columnWeight;
    private static final int m = R.styleable.GridLayout_Layout_layout_row;
    private static final int n = R.styleable.GridLayout_Layout_layout_rowSpan;
    private static final int o = R.styleable.GridLayout_Layout_layout_rowWeight;
    private static final int p = R.styleable.GridLayout_Layout_layout_gravity;
    public GridLayout.q a;
    public GridLayout.q b;
    
    static
    {
      GridLayout.n localn = new GridLayout.n(-2147483648, -2147483647);
      c = localn;
      d = localn.b();
    }
    
    public LayoutParams()
    {
      this(localq, localq);
    }
    
    private LayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, GridLayout.q paramq1, GridLayout.q paramq2)
    {
      super(paramInt2);
      GridLayout.q localq = GridLayout.q.e;
      this.a = localq;
      this.b = localq;
      setMargins(paramInt3, paramInt4, paramInt5, paramInt6);
      this.a = paramq1;
      this.b = paramq2;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      GridLayout.q localq = GridLayout.q.e;
      this.a = localq;
      this.b = localq;
      b(paramContext, paramAttributeSet);
      a(paramContext, paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      paramLayoutParams = GridLayout.q.e;
      this.a = paramLayoutParams;
      this.b = paramLayoutParams;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      paramMarginLayoutParams = GridLayout.q.e;
      this.a = paramMarginLayoutParams;
      this.b = paramMarginLayoutParams;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      GridLayout.q localq = GridLayout.q.e;
      this.a = localq;
      this.b = localq;
      this.a = paramLayoutParams.a;
      this.b = paramLayoutParams.b;
    }
    
    public LayoutParams(GridLayout.q paramq1, GridLayout.q paramq2)
    {
      this(-2, -2, -2147483648, -2147483648, -2147483648, -2147483648, paramq1, paramq2);
    }
    
    private void a(Context paramContext, AttributeSet paramAttributeSet)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GridLayout_Layout);
      try
      {
        int i1 = paramContext.getInt(p, 0);
        int i3 = paramContext.getInt(j, -2147483648);
        int i4 = k;
        int i2 = d;
        i4 = paramContext.getInt(i4, i2);
        float f1 = paramContext.getFloat(l, 0.0F);
        this.b = GridLayout.I(i3, i4, GridLayout.m(i1, true), f1);
        i3 = paramContext.getInt(m, -2147483648);
        i2 = paramContext.getInt(n, i2);
        f1 = paramContext.getFloat(o, 0.0F);
        this.a = GridLayout.I(i3, i2, GridLayout.m(i1, false), f1);
        return;
      }
      finally
      {
        paramContext.recycle();
      }
    }
    
    private void b(Context paramContext, AttributeSet paramAttributeSet)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GridLayout_Layout);
      try
      {
        int i1 = paramContext.getDimensionPixelSize(e, -2147483648);
        this.leftMargin = paramContext.getDimensionPixelSize(f, i1);
        this.topMargin = paramContext.getDimensionPixelSize(g, i1);
        this.rightMargin = paramContext.getDimensionPixelSize(h, i1);
        this.bottomMargin = paramContext.getDimensionPixelSize(i, i1);
        return;
      }
      finally
      {
        paramContext.recycle();
      }
    }
    
    final void c(GridLayout.n paramn)
    {
      this.b = this.b.a(paramn);
    }
    
    final void d(GridLayout.n paramn)
    {
      this.a = this.a.a(paramn);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (LayoutParams)paramObject;
        if (!this.b.equals(paramObject.b)) {
          return false;
        }
        return this.a.equals(paramObject.a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode() * 31 + this.b.hashCode();
    }
    
    protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
    {
      this.width = paramTypedArray.getLayoutDimension(paramInt1, -2);
      this.height = paramTypedArray.getLayoutDimension(paramInt2, -2);
    }
  }
  
  static final class a
    implements Printer
  {
    public void println(String paramString) {}
  }
  
  static final class b
    extends GridLayout.i
  {
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      return -2147483648;
    }
    
    String c()
    {
      return "UNDEFINED";
    }
    
    int d(View paramView, int paramInt)
    {
      return -2147483648;
    }
  }
  
  static final class c
    extends GridLayout.i
  {
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    String c()
    {
      return "LEADING";
    }
    
    int d(View paramView, int paramInt)
    {
      return 0;
    }
  }
  
  static final class d
    extends GridLayout.i
  {
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      return paramInt1;
    }
    
    String c()
    {
      return "TRAILING";
    }
    
    int d(View paramView, int paramInt)
    {
      return paramInt;
    }
  }
  
  static final class e
    extends GridLayout.i
  {
    e(GridLayout.i parami1, GridLayout.i parami2) {}
    
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      int j = x.B(paramView);
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      GridLayout.i locali;
      if (i == 0) {
        locali = this.a;
      } else {
        locali = parami2;
      }
      return locali.a(paramView, paramInt1, paramInt2);
    }
    
    String c()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SWITCHING[L:");
      localStringBuilder.append(this.a.c());
      localStringBuilder.append(", R:");
      localStringBuilder.append(parami2.c());
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    
    int d(View paramView, int paramInt)
    {
      int j = x.B(paramView);
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      GridLayout.i locali;
      if (i == 0) {
        locali = this.a;
      } else {
        locali = parami2;
      }
      return locali.d(paramView, paramInt);
    }
  }
  
  static final class f
    extends GridLayout.i
  {
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      return paramInt1 >> 1;
    }
    
    String c()
    {
      return "CENTER";
    }
    
    int d(View paramView, int paramInt)
    {
      return paramInt >> 1;
    }
  }
  
  static final class g
    extends GridLayout.i
  {
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      if (paramView.getVisibility() == 8) {
        return 0;
      }
      paramInt2 = paramView.getBaseline();
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = -2147483648;
      }
      return paramInt1;
    }
    
    public GridLayout.m b()
    {
      return new a();
    }
    
    String c()
    {
      return "BASELINE";
    }
    
    int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    class a
      extends GridLayout.m
    {
      private int d;
      
      a() {}
      
      protected int a(GridLayout paramGridLayout, View paramView, GridLayout.i parami, int paramInt, boolean paramBoolean)
      {
        return Math.max(0, super.a(paramGridLayout, paramView, parami, paramInt, paramBoolean));
      }
      
      protected void b(int paramInt1, int paramInt2)
      {
        super.b(paramInt1, paramInt2);
        this.d = Math.max(this.d, paramInt1 + paramInt2);
      }
      
      protected void d()
      {
        super.d();
        this.d = -2147483648;
      }
      
      protected int e(boolean paramBoolean)
      {
        return Math.max(super.e(paramBoolean), this.d);
      }
    }
  }
  
  static final class h
    extends GridLayout.i
  {
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      return -2147483648;
    }
    
    String c()
    {
      return "FILL";
    }
    
    int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int e(View paramView, int paramInt1, int paramInt2)
    {
      return paramInt2;
    }
  }
  
  public static abstract class i
  {
    abstract int a(View paramView, int paramInt1, int paramInt2);
    
    GridLayout.m b()
    {
      return new GridLayout.m();
    }
    
    abstract String c();
    
    abstract int d(View paramView, int paramInt);
    
    int e(View paramView, int paramInt1, int paramInt2)
    {
      return paramInt1;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alignment:");
      localStringBuilder.append(c());
      return localStringBuilder.toString();
    }
  }
  
  static final class j
  {
    public final GridLayout.n a;
    public final GridLayout.o b;
    public boolean c = true;
    
    public j(GridLayout.n paramn, GridLayout.o paramo)
    {
      this.a = paramn;
      this.b = paramo;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(" ");
      String str;
      if (!this.c) {
        str = "+>";
      } else {
        str = "->";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
  }
  
  static final class k<K, V>
    extends ArrayList<Pair<K, V>>
  {
    private final Class<K> a;
    private final Class<V> b;
    
    private k(Class<K> paramClass, Class<V> paramClass1)
    {
      this.a = paramClass;
      this.b = paramClass1;
    }
    
    public static <K, V> k<K, V> a(Class<K> paramClass, Class<V> paramClass1)
    {
      return new k(paramClass, paramClass1);
    }
    
    public GridLayout.p<K, V> b()
    {
      int j = size();
      Object[] arrayOfObject1 = (Object[])Array.newInstance(this.a, j);
      Object[] arrayOfObject2 = (Object[])Array.newInstance(this.b, j);
      int i = 0;
      while (i < j)
      {
        arrayOfObject1[i] = ((Pair)get(i)).first;
        arrayOfObject2[i] = ((Pair)get(i)).second;
        i += 1;
      }
      return new GridLayout.p(arrayOfObject1, arrayOfObject2);
    }
    
    public void c(K paramK, V paramV)
    {
      add(Pair.create(paramK, paramV));
    }
  }
  
  final class l
  {
    public final boolean a;
    public int b = -2147483648;
    private int c = -2147483648;
    GridLayout.p<GridLayout.q, GridLayout.m> d;
    public boolean e = false;
    GridLayout.p<GridLayout.n, GridLayout.o> f;
    public boolean g = false;
    GridLayout.p<GridLayout.n, GridLayout.o> h;
    public boolean i = false;
    public int[] j;
    public boolean k = false;
    public int[] l;
    public boolean m = false;
    public GridLayout.j[] n;
    public boolean o = false;
    public int[] p;
    public boolean q = false;
    public boolean r;
    public boolean s = false;
    public int[] t;
    boolean u = true;
    private GridLayout.o v = new GridLayout.o(0);
    private GridLayout.o w = new GridLayout.o(-100000);
    
    l(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    private boolean A()
    {
      if (!this.s)
      {
        this.r = g();
        this.s = true;
      }
      return this.r;
    }
    
    private void B(List<GridLayout.j> paramList, GridLayout.n paramn, GridLayout.o paramo)
    {
      C(paramList, paramn, paramo, true);
    }
    
    private void C(List<GridLayout.j> paramList, GridLayout.n paramn, GridLayout.o paramo, boolean paramBoolean)
    {
      if (paramn.b() == 0) {
        return;
      }
      if (paramBoolean)
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((GridLayout.j)localIterator.next()).a.equals(paramn)) {
            return;
          }
        }
      }
      paramList.add(new GridLayout.j(paramn, paramo));
    }
    
    private void D(int[] paramArrayOfInt)
    {
      Arrays.fill(paramArrayOfInt, 0);
    }
    
    private void H(String paramString, GridLayout.j[] paramArrayOfj, boolean[] paramArrayOfBoolean)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i1 = 0;
      while (i1 < paramArrayOfj.length)
      {
        GridLayout.j localj = paramArrayOfj[i1];
        if (paramArrayOfBoolean[i1] != 0) {
          localArrayList1.add(localj);
        }
        if (!localj.c) {
          localArrayList2.add(localj);
        }
        i1 += 1;
      }
      paramArrayOfj = GridLayout.this.h;
      paramArrayOfBoolean = new StringBuilder();
      paramArrayOfBoolean.append(paramString);
      paramArrayOfBoolean.append(" constraints: ");
      paramArrayOfBoolean.append(b(localArrayList1));
      paramArrayOfBoolean.append(" are inconsistent; permanently removing: ");
      paramArrayOfBoolean.append(b(localArrayList2));
      paramArrayOfBoolean.append(". ");
      paramArrayOfj.println(paramArrayOfBoolean.toString());
    }
    
    private boolean I(int[] paramArrayOfInt, GridLayout.j paramj)
    {
      if (!paramj.c) {
        return false;
      }
      GridLayout.n localn = paramj.a;
      int i2 = localn.a;
      int i1 = localn.b;
      int i3 = paramj.b.a;
      i2 = paramArrayOfInt[i2] + i3;
      if (i2 > paramArrayOfInt[i1])
      {
        paramArrayOfInt[i1] = i2;
        return true;
      }
      return false;
    }
    
    private void L(int paramInt1, int paramInt2)
    {
      this.v.a = paramInt1;
      this.w.a = (-paramInt2);
      this.q = false;
    }
    
    private void M(int paramInt, float paramFloat)
    {
      Object localObject = this.t;
      int i2 = 0;
      Arrays.fill((int[])localObject, 0);
      int i3 = GridLayout.this.getChildCount();
      int i1 = paramInt;
      paramInt = i2;
      while (paramInt < i3)
      {
        localObject = GridLayout.this.getChildAt(paramInt);
        float f1;
        if (((View)localObject).getVisibility() == 8)
        {
          i2 = i1;
          f1 = paramFloat;
        }
        else
        {
          localObject = GridLayout.this.q((View)localObject);
          if (this.a) {
            localObject = ((GridLayout.LayoutParams)localObject).b;
          } else {
            localObject = ((GridLayout.LayoutParams)localObject).a;
          }
          float f2 = ((GridLayout.q)localObject).d;
          i2 = i1;
          f1 = paramFloat;
          if (f2 != 0.0F)
          {
            i2 = Math.round(i1 * f2 / paramFloat);
            this.t[paramInt] = i2;
            i2 = i1 - i2;
            f1 = paramFloat - f2;
          }
        }
        paramInt += 1;
        i1 = i2;
        paramFloat = f1;
      }
    }
    
    private int N(int[] paramArrayOfInt)
    {
      return paramArrayOfInt[p()];
    }
    
    private boolean O(int[] paramArrayOfInt)
    {
      return P(n(), paramArrayOfInt);
    }
    
    private boolean P(GridLayout.j[] paramArrayOfj, int[] paramArrayOfInt)
    {
      return Q(paramArrayOfj, paramArrayOfInt, true);
    }
    
    private boolean Q(GridLayout.j[] paramArrayOfj, int[] paramArrayOfInt, boolean paramBoolean)
    {
      String str;
      if (this.a) {
        str = "horizontal";
      } else {
        str = "vertical";
      }
      int i6 = p() + 1;
      Object localObject = null;
      int i1 = 0;
      while (i1 < paramArrayOfj.length)
      {
        D(paramArrayOfInt);
        int i2 = 0;
        int i3;
        while (i2 < i6)
        {
          int i7 = paramArrayOfj.length;
          i3 = 0;
          int i4 = i3;
          boolean bool;
          while (i3 < i7)
          {
            i4 |= I(paramArrayOfInt, paramArrayOfj[i3]);
            i3 += 1;
          }
          if (!bool)
          {
            if (localObject != null) {
              H(str, paramArrayOfj, (boolean[])localObject);
            }
            return true;
          }
          i2 += 1;
        }
        if (!paramBoolean) {
          return false;
        }
        boolean[] arrayOfBoolean = new boolean[paramArrayOfj.length];
        i2 = 0;
        while (i2 < i6)
        {
          int i5 = paramArrayOfj.length;
          i3 = 0;
          while (i3 < i5)
          {
            arrayOfBoolean[i3] |= I(paramArrayOfInt, paramArrayOfj[i3]);
            i3 += 1;
          }
          i2 += 1;
        }
        if (i1 == 0) {
          localObject = arrayOfBoolean;
        }
        i2 = 0;
        while (i2 < paramArrayOfj.length)
        {
          if (arrayOfBoolean[i2] != 0)
          {
            GridLayout.j localj = paramArrayOfj[i2];
            GridLayout.n localn = localj.a;
            if (localn.a >= localn.b)
            {
              localj.c = false;
              break;
            }
          }
          i2 += 1;
        }
        i1 += 1;
      }
      return true;
    }
    
    private void R(int[] paramArrayOfInt)
    {
      Arrays.fill(q(), 0);
      O(paramArrayOfInt);
      int i1 = this.v.a;
      int i2 = GridLayout.this.getChildCount();
      boolean bool = true;
      i1 = i1 * i2 + 1;
      if (i1 < 2) {
        return;
      }
      float f1 = d();
      i2 = -1;
      int i3 = 0;
      while (i3 < i1)
      {
        int i4 = (int)((i3 + i1) / 2L);
        F();
        M(i4, f1);
        bool = Q(n(), paramArrayOfInt, false);
        if (bool)
        {
          i3 = i4 + 1;
          i2 = i4;
        }
        else
        {
          i1 = i4;
        }
      }
      if ((i2 > 0) && (!bool))
      {
        F();
        M(i2, f1);
        O(paramArrayOfInt);
      }
    }
    
    private GridLayout.j[] S(List<GridLayout.j> paramList)
    {
      return T((GridLayout.j[])paramList.toArray(new GridLayout.j[paramList.size()]));
    }
    
    private GridLayout.j[] T(final GridLayout.j[] paramArrayOfj)
    {
      return new a(paramArrayOfj).a();
    }
    
    private void a(List<GridLayout.j> paramList, GridLayout.p<GridLayout.n, GridLayout.o> paramp)
    {
      int i1 = 0;
      for (;;)
      {
        Object[] arrayOfObject = paramp.b;
        if (i1 >= ((GridLayout.n[])arrayOfObject).length) {
          break;
        }
        C(paramList, ((GridLayout.n[])arrayOfObject)[i1], ((GridLayout.o[])paramp.c)[i1], false);
        i1 += 1;
      }
    }
    
    private String b(List<GridLayout.j> paramList)
    {
      String str;
      if (this.a) {
        str = "x";
      } else {
        str = "y";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int i1 = 1;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (GridLayout.j)paramList.next();
        if (i1 != 0) {
          i1 = 0;
        } else {
          localStringBuilder.append(", ");
        }
        GridLayout.n localn = ((GridLayout.j)localObject).a;
        int i3 = localn.a;
        int i4 = localn.b;
        int i2 = ((GridLayout.j)localObject).b.a;
        if (i3 < i4)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(i4);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(i3);
          ((StringBuilder)localObject).append(">=");
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(i3);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(i4);
          ((StringBuilder)localObject).append("<=");
          i2 = -i2;
        }
        ((StringBuilder)localObject).append(i2);
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      return localStringBuilder.toString();
    }
    
    private int c()
    {
      int i3 = GridLayout.this.getChildCount();
      int i2 = 0;
      int i1 = -1;
      while (i2 < i3)
      {
        Object localObject = GridLayout.this.getChildAt(i2);
        localObject = GridLayout.this.q((View)localObject);
        if (this.a) {
          localObject = ((GridLayout.LayoutParams)localObject).b;
        } else {
          localObject = ((GridLayout.LayoutParams)localObject).a;
        }
        localObject = ((GridLayout.q)localObject).b;
        i1 = Math.max(Math.max(Math.max(i1, ((GridLayout.n)localObject).a), ((GridLayout.n)localObject).b), ((GridLayout.n)localObject).b());
        i2 += 1;
      }
      i2 = i1;
      if (i1 == -1) {
        i2 = -2147483648;
      }
      return i2;
    }
    
    private float d()
    {
      int i2 = GridLayout.this.getChildCount();
      float f1 = 0.0F;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = GridLayout.this.getChildAt(i1);
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = GridLayout.this.q((View)localObject);
          if (this.a) {
            localObject = ((GridLayout.LayoutParams)localObject).b;
          } else {
            localObject = ((GridLayout.LayoutParams)localObject).a;
          }
          f1 += ((GridLayout.q)localObject).d;
        }
        i1 += 1;
      }
      return f1;
    }
    
    private void e()
    {
      r();
      o();
    }
    
    private void f()
    {
      Object localObject = (GridLayout.m[])this.d.c;
      int i1 = 0;
      while (i1 < localObject.length)
      {
        localObject[i1].d();
        i1 += 1;
      }
      int i3 = GridLayout.this.getChildCount();
      i1 = 0;
      while (i1 < i3)
      {
        View localView = GridLayout.this.getChildAt(i1);
        localObject = GridLayout.this.q(localView);
        boolean bool = this.a;
        if (bool) {
          localObject = ((GridLayout.LayoutParams)localObject).b;
        } else {
          localObject = ((GridLayout.LayoutParams)localObject).a;
        }
        int i4 = GridLayout.this.u(localView, bool);
        int i2;
        if (((GridLayout.q)localObject).d == 0.0F) {
          i2 = 0;
        } else {
          i2 = q()[i1];
        }
        ((GridLayout.m)this.d.c(i1)).c(GridLayout.this, localView, (GridLayout.q)localObject, this, i4 + i2);
        i1 += 1;
      }
    }
    
    private boolean g()
    {
      int i2 = GridLayout.this.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = GridLayout.this.getChildAt(i1);
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = GridLayout.this.q((View)localObject);
          if (this.a) {
            localObject = ((GridLayout.LayoutParams)localObject).b;
          } else {
            localObject = ((GridLayout.LayoutParams)localObject).a;
          }
          if (((GridLayout.q)localObject).d != 0.0F) {
            return true;
          }
        }
        i1 += 1;
      }
      return false;
    }
    
    private void h(GridLayout.p<GridLayout.n, GridLayout.o> paramp, boolean paramBoolean)
    {
      Object localObject = (GridLayout.o[])paramp.c;
      int i2 = 0;
      int i1 = 0;
      while (i1 < localObject.length)
      {
        localObject[i1].a();
        i1 += 1;
      }
      localObject = (GridLayout.m[])s().c;
      i1 = i2;
      while (i1 < localObject.length)
      {
        i2 = localObject[i1].e(paramBoolean);
        GridLayout.o localo = (GridLayout.o)paramp.c(i1);
        int i3 = localo.a;
        if (!paramBoolean) {
          i2 = -i2;
        }
        localo.a = Math.max(i3, i2);
        i1 += 1;
      }
    }
    
    private void i(int[] paramArrayOfInt)
    {
      if (!A()) {
        O(paramArrayOfInt);
      } else {
        R(paramArrayOfInt);
      }
      if (!this.u)
      {
        int i1 = 0;
        int i2 = paramArrayOfInt[0];
        int i3 = paramArrayOfInt.length;
        while (i1 < i3)
        {
          paramArrayOfInt[i1] -= i2;
          i1 += 1;
        }
      }
    }
    
    private void j(boolean paramBoolean)
    {
      int[] arrayOfInt;
      if (paramBoolean) {
        arrayOfInt = this.j;
      } else {
        arrayOfInt = this.l;
      }
      int i1 = 0;
      int i3 = GridLayout.this.getChildCount();
      while (i1 < i3)
      {
        View localView = GridLayout.this.getChildAt(i1);
        if (localView.getVisibility() != 8)
        {
          Object localObject = GridLayout.this.q(localView);
          boolean bool = this.a;
          if (bool) {
            localObject = ((GridLayout.LayoutParams)localObject).b;
          } else {
            localObject = ((GridLayout.LayoutParams)localObject).a;
          }
          localObject = ((GridLayout.q)localObject).b;
          int i2;
          if (paramBoolean) {
            i2 = ((GridLayout.n)localObject).a;
          } else {
            i2 = ((GridLayout.n)localObject).b;
          }
          arrayOfInt[i2] = Math.max(arrayOfInt[i2], GridLayout.this.s(localView, bool, paramBoolean));
        }
        i1 += 1;
      }
    }
    
    private GridLayout.j[] k()
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      a(localArrayList1, r());
      a(localArrayList2, o());
      if (this.u)
      {
        int i2;
        for (i1 = 0; i1 < p(); i1 = i2)
        {
          i2 = i1 + 1;
          B(localArrayList1, new GridLayout.n(i1, i2), new GridLayout.o(0));
        }
      }
      int i1 = p();
      C(localArrayList1, new GridLayout.n(0, i1), this.v, false);
      C(localArrayList2, new GridLayout.n(i1, 0), this.w, false);
      return (GridLayout.j[])GridLayout.b(S(localArrayList1), S(localArrayList2));
    }
    
    private GridLayout.p<GridLayout.q, GridLayout.m> l()
    {
      GridLayout.k localk = GridLayout.k.a(GridLayout.q.class, GridLayout.m.class);
      int i2 = GridLayout.this.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = GridLayout.this.getChildAt(i1);
        localObject = GridLayout.this.q((View)localObject);
        boolean bool = this.a;
        if (bool) {
          localObject = ((GridLayout.LayoutParams)localObject).b;
        } else {
          localObject = ((GridLayout.LayoutParams)localObject).a;
        }
        localk.c(localObject, ((GridLayout.q)localObject).b(bool).b());
        i1 += 1;
      }
      return localk.b();
    }
    
    private GridLayout.p<GridLayout.n, GridLayout.o> m(boolean paramBoolean)
    {
      GridLayout.k localk = GridLayout.k.a(GridLayout.n.class, GridLayout.o.class);
      GridLayout.q[] arrayOfq = (GridLayout.q[])s().b;
      int i2 = arrayOfq.length;
      int i1 = 0;
      while (i1 < i2)
      {
        GridLayout.n localn;
        if (paramBoolean) {
          localn = arrayOfq[i1].b;
        } else {
          localn = arrayOfq[i1].b.a();
        }
        localk.c(localn, new GridLayout.o());
        i1 += 1;
      }
      return localk.b();
    }
    
    private GridLayout.p<GridLayout.n, GridLayout.o> o()
    {
      if (this.h == null) {
        this.h = m(false);
      }
      if (!this.i)
      {
        h(this.h, false);
        this.i = true;
      }
      return this.h;
    }
    
    private GridLayout.p<GridLayout.n, GridLayout.o> r()
    {
      if (this.f == null) {
        this.f = m(true);
      }
      if (!this.g)
      {
        h(this.f, true);
        this.g = true;
      }
      return this.f;
    }
    
    private int v()
    {
      if (this.c == -2147483648) {
        this.c = Math.max(0, c());
      }
      return this.c;
    }
    
    private int x(int paramInt1, int paramInt2)
    {
      L(paramInt1, paramInt2);
      return N(u());
    }
    
    public void E()
    {
      this.c = -2147483648;
      this.d = null;
      this.f = null;
      this.h = null;
      this.j = null;
      this.l = null;
      this.n = null;
      this.p = null;
      this.t = null;
      this.s = false;
      F();
    }
    
    public void F()
    {
      this.e = false;
      this.g = false;
      this.i = false;
      this.k = false;
      this.m = false;
      this.o = false;
      this.q = false;
    }
    
    public void G(int paramInt)
    {
      L(paramInt, paramInt);
      u();
    }
    
    public void J(int paramInt)
    {
      if ((paramInt != -2147483648) && (paramInt < v()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str;
        if (this.a) {
          str = "column";
        } else {
          str = "row";
        }
        localStringBuilder.append(str);
        localStringBuilder.append("Count must be greater than or equal to the maximum of all grid indices ");
        localStringBuilder.append("(and spans) defined in the LayoutParams of each child");
        GridLayout.w(localStringBuilder.toString());
      }
      this.b = paramInt;
    }
    
    public void K(boolean paramBoolean)
    {
      this.u = paramBoolean;
      E();
    }
    
    public GridLayout.j[] n()
    {
      if (this.n == null) {
        this.n = k();
      }
      if (!this.o)
      {
        e();
        this.o = true;
      }
      return this.n;
    }
    
    public int p()
    {
      return Math.max(this.b, v());
    }
    
    public int[] q()
    {
      if (this.t == null) {
        this.t = new int[GridLayout.this.getChildCount()];
      }
      return this.t;
    }
    
    public GridLayout.p<GridLayout.q, GridLayout.m> s()
    {
      if (this.d == null) {
        this.d = l();
      }
      if (!this.e)
      {
        f();
        this.e = true;
      }
      return this.d;
    }
    
    public int[] t()
    {
      if (this.j == null) {
        this.j = new int[p() + 1];
      }
      if (!this.k)
      {
        j(true);
        this.k = true;
      }
      return this.j;
    }
    
    public int[] u()
    {
      if (this.p == null) {
        this.p = new int[p() + 1];
      }
      if (!this.q)
      {
        i(this.p);
        this.q = true;
      }
      return this.p;
    }
    
    public int w(int paramInt)
    {
      int i1 = View.MeasureSpec.getMode(paramInt);
      paramInt = View.MeasureSpec.getSize(paramInt);
      if (i1 != -2147483648)
      {
        if (i1 != 0)
        {
          if (i1 != 1073741824) {
            return 0;
          }
          return x(paramInt, paramInt);
        }
        return x(0, 100000);
      }
      return x(0, paramInt);
    }
    
    public int[] y()
    {
      if (this.l == null) {
        this.l = new int[p() + 1];
      }
      if (!this.m)
      {
        j(false);
        this.m = true;
      }
      return this.l;
    }
    
    GridLayout.j[][] z(GridLayout.j[] paramArrayOfj)
    {
      int i3 = p() + 1;
      GridLayout.j[][] arrayOfj; = new GridLayout.j[i3][];
      int[] arrayOfInt = new int[i3];
      int i4 = paramArrayOfj.length;
      int i2 = 0;
      int i1 = 0;
      while (i1 < i4)
      {
        int i5 = paramArrayOfj[i1].a.a;
        arrayOfInt[i5] += 1;
        i1 += 1;
      }
      i1 = 0;
      while (i1 < i3)
      {
        arrayOfj;[i1] = new GridLayout.j[arrayOfInt[i1]];
        i1 += 1;
      }
      Arrays.fill(arrayOfInt, 0);
      i3 = paramArrayOfj.length;
      i1 = i2;
      while (i1 < i3)
      {
        GridLayout.j localj = paramArrayOfj[i1];
        i2 = localj.a.a;
        [Landroidx.gridlayout.widget.GridLayout.j localj; = arrayOfj;[i2];
        i4 = arrayOfInt[i2];
        arrayOfInt[i2] = (i4 + 1);
        localj;[i4] = localj;
        i1 += 1;
      }
      return arrayOfj;;
    }
    
    class a
    {
      GridLayout.j[] a;
      int b;
      GridLayout.j[][] c;
      int[] d;
      
      a(GridLayout.j[] paramArrayOfj)
      {
        GridLayout.j[] arrayOfj = new GridLayout.j[paramArrayOfj.length];
        this.a = arrayOfj;
        this.b = (arrayOfj.length - 1);
        this.c = GridLayout.l.this.z(paramArrayOfj);
        this.d = new int[GridLayout.l.this.p() + 1];
      }
      
      GridLayout.j[] a()
      {
        int j = this.c.length;
        int i = 0;
        while (i < j)
        {
          b(i);
          i += 1;
        }
        return this.a;
      }
      
      void b(int paramInt)
      {
        Object localObject1 = this.d;
        if (localObject1[paramInt] != 0) {
          return;
        }
        localObject1[paramInt] = 1;
        localObject1 = this.c[paramInt];
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          b(localObject2.a.b);
          GridLayout.j[] arrayOfj = this.a;
          int k = this.b;
          this.b = (k - 1);
          arrayOfj[k] = localObject2;
          i += 1;
        }
        this.d[paramInt] = 2;
      }
    }
  }
  
  static class m
  {
    public int a;
    public int b;
    public int c;
    
    m()
    {
      d();
    }
    
    protected int a(GridLayout paramGridLayout, View paramView, GridLayout.i parami, int paramInt, boolean paramBoolean)
    {
      return this.a - parami.a(paramView, paramInt, a0.a(paramGridLayout));
    }
    
    protected void b(int paramInt1, int paramInt2)
    {
      this.a = Math.max(this.a, paramInt1);
      this.b = Math.max(this.b, paramInt2);
    }
    
    protected final void c(GridLayout paramGridLayout, View paramView, GridLayout.q paramq, GridLayout.l paraml, int paramInt)
    {
      this.c &= paramq.c();
      int i = paramq.b(paraml.a).a(paramView, paramInt, a0.a(paramGridLayout));
      b(i, paramInt - i);
    }
    
    protected void d()
    {
      this.a = -2147483648;
      this.b = -2147483648;
      this.c = 2;
    }
    
    protected int e(boolean paramBoolean)
    {
      if ((!paramBoolean) && (GridLayout.c(this.c))) {
        return 100000;
      }
      return this.a + this.b;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bounds{before=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", after=");
      localStringBuilder.append(this.b);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  static final class n
  {
    public final int a;
    public final int b;
    
    public n(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
    
    n a()
    {
      return new n(this.b, this.a);
    }
    
    int b()
    {
      return this.b - this.a;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (n.class != paramObject.getClass()) {
          return false;
        }
        paramObject = (n)paramObject;
        if (this.b != paramObject.b) {
          return false;
        }
        return this.a == paramObject.a;
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a * 31 + this.b;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  static final class o
  {
    public int a;
    
    public o()
    {
      a();
    }
    
    public o(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void a()
    {
      this.a = -2147483648;
    }
    
    public String toString()
    {
      return Integer.toString(this.a);
    }
  }
  
  static final class p<K, V>
  {
    public final int[] a;
    public final K[] b;
    public final V[] c;
    
    p(K[] paramArrayOfK, V[] paramArrayOfV)
    {
      int[] arrayOfInt = b(paramArrayOfK);
      this.a = arrayOfInt;
      this.b = a(paramArrayOfK, arrayOfInt);
      this.c = a(paramArrayOfV, arrayOfInt);
    }
    
    private static <K> K[] a(K[] paramArrayOfK, int[] paramArrayOfInt)
    {
      int j = paramArrayOfK.length;
      Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfK.getClass().getComponentType(), GridLayout.A(paramArrayOfInt, -1) + 1);
      int i = 0;
      while (i < j)
      {
        arrayOfObject[paramArrayOfInt[i]] = paramArrayOfK[i];
        i += 1;
      }
      return arrayOfObject;
    }
    
    private static <K> int[] b(K[] paramArrayOfK)
    {
      int j = paramArrayOfK.length;
      int[] arrayOfInt = new int[j];
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < j)
      {
        K ? = paramArrayOfK[i];
        Integer localInteger2 = (Integer)localHashMap.get(?);
        Integer localInteger1 = localInteger2;
        if (localInteger2 == null)
        {
          localInteger1 = Integer.valueOf(localHashMap.size());
          localHashMap.put(?, localInteger1);
        }
        arrayOfInt[i] = localInteger1.intValue();
        i += 1;
      }
      return arrayOfInt;
    }
    
    public V c(int paramInt)
    {
      return this.c[this.a[paramInt]];
    }
  }
  
  public static class q
  {
    static final q e = GridLayout.F(-2147483648);
    final boolean a;
    final GridLayout.n b;
    final GridLayout.i c;
    final float d;
    
    q(boolean paramBoolean, int paramInt1, int paramInt2, GridLayout.i parami, float paramFloat)
    {
      this(paramBoolean, new GridLayout.n(paramInt1, paramInt2 + paramInt1), parami, paramFloat);
    }
    
    private q(boolean paramBoolean, GridLayout.n paramn, GridLayout.i parami, float paramFloat)
    {
      this.a = paramBoolean;
      this.b = paramn;
      this.c = parami;
      this.d = paramFloat;
    }
    
    final q a(GridLayout.n paramn)
    {
      return new q(this.a, paramn, this.c, this.d);
    }
    
    public GridLayout.i b(boolean paramBoolean)
    {
      GridLayout.i locali = this.c;
      if (locali != GridLayout.r) {
        return locali;
      }
      if (this.d == 0.0F)
      {
        if (paramBoolean) {
          return GridLayout.w;
        }
        return GridLayout.B;
      }
      return GridLayout.C;
    }
    
    final int c()
    {
      if ((this.c == GridLayout.r) && (this.d == 0.0F)) {
        return 0;
      }
      return 2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (q)paramObject;
        if (!this.c.equals(paramObject.c)) {
          return false;
        }
        return this.b.equals(paramObject.b);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.b.hashCode() * 31 + this.c.hashCode();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.gridlayout.widget.GridLayout
 * JD-Core Version:    0.7.0.1
 */