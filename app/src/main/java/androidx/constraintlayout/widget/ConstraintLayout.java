package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import k0.d.b;
import k0.e.b;
import k0.f;
import k0.h;
import k0.k;
import k0.m;
import k0.n;
import l0.b.a;
import l0.b.b;

public class ConstraintLayout
  extends ViewGroup
{
  private static e x;
  SparseArray<View> a = new SparseArray();
  private ArrayList<ConstraintHelper> b = new ArrayList(4);
  protected f c = new f();
  private int d = 0;
  private int e = 0;
  private int f = 2147483647;
  private int g = 2147483647;
  protected boolean h = true;
  private int i = 257;
  private c j = null;
  protected b k = null;
  private int l = -1;
  private HashMap<String, Integer> m = new HashMap();
  private int n = -1;
  private int o = -1;
  int p = -1;
  int q = -1;
  int r = 0;
  int s = 0;
  private SparseArray<k0.e> t = new SparseArray();
  b u = new b(this);
  private int v = 0;
  private int w = 0;
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    q(paramAttributeSet, 0, 0);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    q(paramAttributeSet, paramInt, 0);
  }
  
  private boolean A()
  {
    int i2 = getChildCount();
    boolean bool2 = false;
    int i1 = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      if (getChildAt(i1).isLayoutRequested())
      {
        bool1 = true;
        break;
      }
      i1 += 1;
    }
    if (bool1) {
      w();
    }
    return bool1;
  }
  
  private int getPaddingWidth()
  {
    int i1 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
    int i2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
    if (i2 > 0) {
      i1 = i2;
    }
    return i1;
  }
  
  public static e getSharedValues()
  {
    if (x == null) {
      x = new e();
    }
    return x;
  }
  
  private final k0.e k(int paramInt)
  {
    if (paramInt == 0) {
      return this.c;
    }
    View localView2 = (View)this.a.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView2 = findViewById(paramInt);
      localView1 = localView2;
      if (localView2 != null)
      {
        localView1 = localView2;
        if (localView2 != this)
        {
          localView1 = localView2;
          if (localView2.getParent() == this)
          {
            onViewAdded(localView2);
            localView1 = localView2;
          }
        }
      }
    }
    if (localView1 == this) {
      return this.c;
    }
    if (localView1 == null) {
      return null;
    }
    return ((LayoutParams)localView1.getLayoutParams()).v0;
  }
  
  private void q(AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.c.F0(this);
    this.c.Z1(this.u);
    this.a.put(getId(), this);
    this.j = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout, paramInt1, paramInt2);
      paramInt2 = paramAttributeSet.getIndexCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        int i1 = paramAttributeSet.getIndex(paramInt1);
        if (i1 == R.styleable.ConstraintLayout_Layout_android_minWidth)
        {
          this.d = paramAttributeSet.getDimensionPixelOffset(i1, this.d);
        }
        else if (i1 == R.styleable.ConstraintLayout_Layout_android_minHeight)
        {
          this.e = paramAttributeSet.getDimensionPixelOffset(i1, this.e);
        }
        else if (i1 == R.styleable.ConstraintLayout_Layout_android_maxWidth)
        {
          this.f = paramAttributeSet.getDimensionPixelOffset(i1, this.f);
        }
        else if (i1 == R.styleable.ConstraintLayout_Layout_android_maxHeight)
        {
          this.g = paramAttributeSet.getDimensionPixelOffset(i1, this.g);
        }
        else if (i1 == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel)
        {
          this.i = paramAttributeSet.getInt(i1, this.i);
        }
        else if (i1 == R.styleable.ConstraintLayout_Layout_layoutDescription)
        {
          i1 = paramAttributeSet.getResourceId(i1, 0);
          if (i1 == 0) {
            break label294;
          }
        }
        try
        {
          t(i1);
        }
        catch (Resources.NotFoundException localNotFoundException1)
        {
          label229:
          break label229;
        }
        this.k = null;
        break label294;
        if (i1 == R.styleable.ConstraintLayout_Layout_constraintSet) {
          i1 = paramAttributeSet.getResourceId(i1, 0);
        }
        try
        {
          c localc = new c();
          this.j = localc;
          localc.D(getContext(), i1);
        }
        catch (Resources.NotFoundException localNotFoundException2)
        {
          label283:
          break label283;
        }
        this.j = null;
        this.l = i1;
        label294:
        paramInt1 += 1;
      }
      paramAttributeSet.recycle();
    }
    else
    {
      this.c.a2(this.i);
      return;
    }
  }
  
  private void s()
  {
    this.h = true;
    this.n = -1;
    this.o = -1;
    this.p = -1;
    this.q = -1;
    this.r = 0;
    this.s = 0;
  }
  
  private void w()
  {
    boolean bool = isInEditMode();
    int i2 = getChildCount();
    int i1 = 0;
    Object localObject1;
    while (i1 < i2)
    {
      localObject1 = p(getChildAt(i1));
      if (localObject1 != null) {
        ((k0.e)localObject1).v0();
      }
      i1 += 1;
    }
    Object localObject3;
    if (bool)
    {
      i1 = 0;
      while (i1 < i2)
      {
        localObject3 = getChildAt(i1);
        try
        {
          localObject2 = getResources().getResourceName(((View)localObject3).getId());
          x(0, localObject2, Integer.valueOf(((View)localObject3).getId()));
          i3 = ((String)localObject2).indexOf('/');
          localObject1 = localObject2;
          if (i3 != -1) {
            localObject1 = ((String)localObject2).substring(i3 + 1);
          }
          k(((View)localObject3).getId()).G0((String)localObject1);
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          Object localObject2;
          int i3;
          label138:
          break label138;
        }
        i1 += 1;
      }
    }
    else
    {
      if (this.l != -1)
      {
        i1 = 0;
        while (i1 < i2)
        {
          localObject1 = getChildAt(i1);
          if ((((View)localObject1).getId() == this.l) && ((localObject1 instanceof Constraints))) {
            this.j = ((Constraints)localObject1).getConstraintSet();
          }
          i1 += 1;
        }
      }
      localObject1 = this.j;
      if (localObject1 != null) {
        ((c)localObject1).k(this, true);
      }
      this.c.y1();
      i3 = this.b.size();
      if (i3 > 0)
      {
        i1 = 0;
        while (i1 < i3)
        {
          ((ConstraintHelper)this.b.get(i1)).u(this);
          i1 += 1;
        }
      }
      i1 = 0;
      while (i1 < i2)
      {
        localObject1 = getChildAt(i1);
        if ((localObject1 instanceof Placeholder)) {
          ((Placeholder)localObject1).c(this);
        }
        i1 += 1;
      }
      this.t.clear();
      this.t.put(0, this.c);
      this.t.put(getId(), this.c);
      i1 = 0;
      while (i1 < i2)
      {
        localObject1 = getChildAt(i1);
        localObject2 = p((View)localObject1);
        this.t.put(((View)localObject1).getId(), localObject2);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < i2)
      {
        localObject1 = getChildAt(i1);
        localObject2 = p((View)localObject1);
        if (localObject2 != null)
        {
          localObject3 = (LayoutParams)((View)localObject1).getLayoutParams();
          this.c.a((k0.e)localObject2);
          e(bool, (View)localObject1, (k0.e)localObject2, (LayoutParams)localObject3, this.t);
        }
        i1 += 1;
      }
      return;
    }
  }
  
  private void z(k0.e parame, LayoutParams paramLayoutParams, SparseArray<k0.e> paramSparseArray, int paramInt, d.b paramb)
  {
    Object localObject = (View)this.a.get(paramInt);
    paramSparseArray = (k0.e)paramSparseArray.get(paramInt);
    if ((paramSparseArray != null) && (localObject != null) && ((((View)localObject).getLayoutParams() instanceof LayoutParams)))
    {
      paramLayoutParams.g0 = true;
      d.b localb = d.b.f;
      if (paramb == localb)
      {
        localObject = (LayoutParams)((View)localObject).getLayoutParams();
        ((LayoutParams)localObject).g0 = true;
        ((LayoutParams)localObject).v0.O0(true);
      }
      parame.q(localb).b(paramSparseArray.q(paramb), paramLayoutParams.D, paramLayoutParams.C, true);
      parame.O0(true);
      parame.q(d.b.c).q();
      parame.q(d.b.e).q();
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = this.b;
    int i2;
    int i1;
    if (localObject != null)
    {
      i2 = ((ArrayList)localObject).size();
      if (i2 > 0)
      {
        i1 = 0;
        while (i1 < i2)
        {
          ((ConstraintHelper)this.b.get(i1)).t(this);
          i1 += 1;
        }
      }
    }
    super.dispatchDraw(paramCanvas);
    if (isInEditMode())
    {
      float f1 = getWidth();
      float f2 = getHeight();
      i2 = getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        localObject = getChildAt(i1);
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject != null) && ((localObject instanceof String)))
          {
            localObject = ((String)localObject).split(",");
            if (localObject.length == 4)
            {
              int i4 = Integer.parseInt(localObject[0]);
              int i6 = Integer.parseInt(localObject[1]);
              int i5 = Integer.parseInt(localObject[2]);
              int i3 = Integer.parseInt(localObject[3]);
              i4 = (int)(i4 / 1080.0F * f1);
              i6 = (int)(i6 / 1920.0F * f2);
              i5 = (int)(i5 / 1080.0F * f1);
              i3 = (int)(i3 / 1920.0F * f2);
              localObject = new Paint();
              ((Paint)localObject).setColor(-65536);
              float f3 = i4;
              float f4 = i6;
              float f5 = i4 + i5;
              paramCanvas.drawLine(f3, f4, f5, f4, (Paint)localObject);
              float f6 = i6 + i3;
              paramCanvas.drawLine(f5, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f5, f6, f3, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f3, f4, (Paint)localObject);
              ((Paint)localObject).setColor(-16711936);
              paramCanvas.drawLine(f3, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f5, f4, (Paint)localObject);
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  protected void e(boolean paramBoolean, View paramView, k0.e parame, LayoutParams paramLayoutParams, SparseArray<k0.e> paramSparseArray)
  {
    paramLayoutParams.c();
    paramLayoutParams.w0 = false;
    parame.n1(paramView.getVisibility());
    if (paramLayoutParams.j0)
    {
      parame.X0(true);
      parame.n1(8);
    }
    parame.F0(paramView);
    if ((paramView instanceof ConstraintHelper)) {
      ((ConstraintHelper)paramView).q(parame, this.c.T1());
    }
    int i1;
    int i2;
    float f1;
    if (paramLayoutParams.h0)
    {
      paramView = (h)parame;
      i1 = paramLayoutParams.s0;
      i2 = paramLayoutParams.t0;
      f1 = paramLayoutParams.u0;
      if (f1 != -1.0F)
      {
        paramView.D1(f1);
        return;
      }
      if (i1 != -1)
      {
        paramView.B1(i1);
        return;
      }
      if (i2 != -1) {
        paramView.C1(i2);
      }
    }
    else
    {
      i1 = paramLayoutParams.l0;
      int i6 = paramLayoutParams.m0;
      int i3 = paramLayoutParams.n0;
      int i4 = paramLayoutParams.o0;
      int i5 = paramLayoutParams.p0;
      i2 = paramLayoutParams.q0;
      f1 = paramLayoutParams.r0;
      int i7 = paramLayoutParams.p;
      if (i7 != -1)
      {
        paramView = (k0.e)paramSparseArray.get(i7);
        if (paramView != null) {
          parame.m(paramView, paramLayoutParams.r, paramLayoutParams.q);
        }
      }
      else
      {
        Object localObject2;
        Object localObject1;
        if (i1 != -1)
        {
          localObject2 = (k0.e)paramSparseArray.get(i1);
          if (localObject2 == null) {
            break label331;
          }
          paramView = d.b.b;
          i1 = paramLayoutParams.leftMargin;
          localObject1 = paramView;
        }
        else
        {
          if (i6 == -1) {
            break label331;
          }
          localObject2 = (k0.e)paramSparseArray.get(i6);
          if (localObject2 == null) {
            break label331;
          }
          localObject1 = d.b.b;
          paramView = d.b.d;
          i1 = paramLayoutParams.leftMargin;
        }
        parame.g0((d.b)localObject1, (k0.e)localObject2, paramView, i1, i5);
        label331:
        if (i3 != -1)
        {
          localObject1 = (k0.e)paramSparseArray.get(i3);
          if (localObject1 == null) {
            break label424;
          }
          paramView = d.b.d;
          localObject2 = d.b.b;
          i1 = paramLayoutParams.rightMargin;
        }
        else
        {
          if (i4 == -1) {
            break label424;
          }
          localObject1 = (k0.e)paramSparseArray.get(i4);
          if (localObject1 == null) {
            break label424;
          }
          localObject2 = d.b.d;
          i1 = paramLayoutParams.rightMargin;
          paramView = (View)localObject2;
        }
        parame.g0(paramView, (k0.e)localObject1, (d.b)localObject2, i1, i2);
        label424:
        i1 = paramLayoutParams.i;
        if (i1 != -1)
        {
          localObject2 = (k0.e)paramSparseArray.get(i1);
          if (localObject2 == null) {
            break label544;
          }
          paramView = d.b.c;
          i1 = paramLayoutParams.topMargin;
          i2 = paramLayoutParams.x;
          localObject1 = paramView;
        }
        else
        {
          i1 = paramLayoutParams.j;
          if (i1 == -1) {
            break label544;
          }
          localObject2 = (k0.e)paramSparseArray.get(i1);
          if (localObject2 == null) {
            break label544;
          }
          localObject1 = d.b.c;
          paramView = d.b.e;
          i1 = paramLayoutParams.topMargin;
          i2 = paramLayoutParams.x;
        }
        parame.g0((d.b)localObject1, (k0.e)localObject2, paramView, i1, i2);
        label544:
        i1 = paramLayoutParams.k;
        if (i1 != -1)
        {
          localObject1 = (k0.e)paramSparseArray.get(i1);
          if (localObject1 == null) {
            break label665;
          }
          paramView = d.b.e;
          localObject2 = d.b.c;
          i1 = paramLayoutParams.bottomMargin;
          i2 = paramLayoutParams.z;
        }
        else
        {
          i1 = paramLayoutParams.l;
          if (i1 == -1) {
            break label665;
          }
          localObject1 = (k0.e)paramSparseArray.get(i1);
          if (localObject1 == null) {
            break label665;
          }
          localObject2 = d.b.e;
          i1 = paramLayoutParams.bottomMargin;
          i2 = paramLayoutParams.z;
          paramView = (View)localObject2;
        }
        parame.g0(paramView, (k0.e)localObject1, (d.b)localObject2, i1, i2);
        label665:
        i1 = paramLayoutParams.m;
        if (i1 != -1) {
          paramView = d.b.f;
        }
        for (;;)
        {
          z(parame, paramLayoutParams, paramSparseArray, i1, paramView);
          break;
          i1 = paramLayoutParams.n;
          if (i1 != -1)
          {
            paramView = d.b.c;
          }
          else
          {
            i1 = paramLayoutParams.o;
            if (i1 == -1) {
              break;
            }
            paramView = d.b.e;
          }
        }
        if (f1 >= 0.0F) {
          parame.Q0(f1);
        }
        f1 = paramLayoutParams.H;
        if (f1 >= 0.0F) {
          parame.h1(f1);
        }
      }
      if (paramBoolean)
      {
        i1 = paramLayoutParams.X;
        if ((i1 != -1) || (paramLayoutParams.Y != -1)) {
          parame.f1(i1, paramLayoutParams.Y);
        }
      }
      if (!paramLayoutParams.e0)
      {
        if (paramLayoutParams.width == -1)
        {
          if (paramLayoutParams.a0) {
            paramView = e.b.c;
          } else {
            paramView = e.b.d;
          }
          parame.T0(paramView);
          parame.q(d.b.b).g = paramLayoutParams.leftMargin;
          parame.q(d.b.d).g = paramLayoutParams.rightMargin;
        }
        else
        {
          parame.T0(e.b.c);
          parame.o1(0);
        }
      }
      else
      {
        parame.T0(e.b.a);
        parame.o1(paramLayoutParams.width);
        if (paramLayoutParams.width == -2) {
          parame.T0(e.b.b);
        }
      }
      if (!paramLayoutParams.f0)
      {
        if (paramLayoutParams.height == -1)
        {
          if (paramLayoutParams.b0) {
            paramView = e.b.c;
          } else {
            paramView = e.b.d;
          }
          parame.k1(paramView);
          parame.q(d.b.c).g = paramLayoutParams.topMargin;
          parame.q(d.b.e).g = paramLayoutParams.bottomMargin;
        }
        else
        {
          parame.k1(e.b.c);
          parame.P0(0);
        }
      }
      else
      {
        parame.k1(e.b.a);
        parame.P0(paramLayoutParams.height);
        if (paramLayoutParams.height == -2) {
          parame.k1(e.b.b);
        }
      }
      parame.H0(paramLayoutParams.I);
      parame.V0(paramLayoutParams.L);
      parame.m1(paramLayoutParams.M);
      parame.R0(paramLayoutParams.N);
      parame.i1(paramLayoutParams.O);
      parame.p1(paramLayoutParams.d0);
      parame.U0(paramLayoutParams.P, paramLayoutParams.R, paramLayoutParams.T, paramLayoutParams.V);
      parame.l1(paramLayoutParams.Q, paramLayoutParams.S, paramLayoutParams.U, paramLayoutParams.W);
    }
  }
  
  protected LayoutParams f()
  {
    return new LayoutParams(-2, -2);
  }
  
  public void forceLayout()
  {
    s();
    super.forceLayout();
  }
  
  public LayoutParams g(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getMaxHeight()
  {
    return this.g;
  }
  
  public int getMaxWidth()
  {
    return this.f;
  }
  
  public int getMinHeight()
  {
    return this.e;
  }
  
  public int getMinWidth()
  {
    return this.d;
  }
  
  public int getOptimizationLevel()
  {
    return this.c.N1();
  }
  
  public String getSceneString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1;
    if (this.c.o == null)
    {
      i1 = getId();
      if (i1 != -1)
      {
        localObject1 = getContext().getResources().getResourceEntryName(i1);
        this.c.o = ((String)localObject1);
      }
      else
      {
        this.c.o = "parent";
      }
    }
    if (this.c.v() == null)
    {
      localObject1 = this.c;
      ((k0.e)localObject1).G0(((k0.e)localObject1).o);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" setDebugName ");
      ((StringBuilder)localObject1).append(this.c.v());
      Log.v("ConstraintLayout", ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.c.v1().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      k0.e locale = (k0.e)((Iterator)localObject1).next();
      Object localObject2 = (View)locale.u();
      if (localObject2 != null)
      {
        if (locale.o == null)
        {
          i1 = ((View)localObject2).getId();
          if (i1 != -1) {
            locale.o = getContext().getResources().getResourceEntryName(i1);
          }
        }
        if (locale.v() == null)
        {
          locale.G0(locale.o);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" setDebugName ");
          ((StringBuilder)localObject2).append(locale.v());
          Log.v("ConstraintLayout", ((StringBuilder)localObject2).toString());
        }
      }
    }
    this.c.Q(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public Object h(int paramInt, Object paramObject)
  {
    if ((paramInt == 0) && ((paramObject instanceof String)))
    {
      paramObject = (String)paramObject;
      HashMap localHashMap = this.m;
      if ((localHashMap != null) && (localHashMap.containsKey(paramObject))) {
        return this.m.get(paramObject);
      }
    }
    return null;
  }
  
  public View l(int paramInt)
  {
    return (View)this.a.get(paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      k0.e locale = localLayoutParams.v0;
      if (((localView.getVisibility() != 8) || (localLayoutParams.h0) || (localLayoutParams.i0) || (localLayoutParams.k0) || (paramBoolean)) && (!localLayoutParams.j0))
      {
        paramInt4 = locale.Z();
        int i1 = locale.a0();
        int i2 = locale.Y() + paramInt4;
        int i3 = locale.z() + i1;
        localView.layout(paramInt4, i1, i2, i3);
        if ((localView instanceof Placeholder))
        {
          localView = ((Placeholder)localView).getContent();
          if (localView != null)
          {
            localView.setVisibility(0);
            localView.layout(paramInt4, i1, i2, i3);
          }
        }
      }
      paramInt1 += 1;
    }
    paramInt3 = this.b.size();
    if (paramInt3 > 0)
    {
      paramInt1 = paramInt2;
      while (paramInt1 < paramInt3)
      {
        ((ConstraintHelper)this.b.get(paramInt1)).r(this);
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1;
    if (this.v == paramInt1) {
      i1 = this.w;
    }
    if (!this.h)
    {
      int i2 = getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        if (getChildAt(i1).isLayoutRequested())
        {
          this.h = true;
          break;
        }
        i1 += 1;
      }
    }
    boolean bool = this.h;
    this.v = paramInt1;
    this.w = paramInt2;
    this.c.c2(r());
    if (this.h)
    {
      this.h = false;
      if (A()) {
        this.c.e2();
      }
    }
    v(this.c, this.i, paramInt1, paramInt2);
    u(paramInt1, paramInt2, this.c.Y(), this.c.z(), this.c.U1(), this.c.S1());
  }
  
  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    Object localObject = p(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof h)))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      h localh = new h();
      ((LayoutParams)localObject).v0 = localh;
      ((LayoutParams)localObject).h0 = true;
      localh.E1(((LayoutParams)localObject).Z);
    }
    if ((paramView instanceof ConstraintHelper))
    {
      localObject = (ConstraintHelper)paramView;
      ((ConstraintHelper)localObject).w();
      ((LayoutParams)paramView.getLayoutParams()).i0 = true;
      if (!this.b.contains(localObject)) {
        this.b.add(localObject);
      }
    }
    this.a.put(paramView.getId(), paramView);
    this.h = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    this.a.remove(paramView.getId());
    k0.e locale = p(paramView);
    this.c.x1(locale);
    this.b.remove(paramView);
    this.h = true;
  }
  
  public final k0.e p(View paramView)
  {
    if (paramView == this) {
      return this.c;
    }
    if (paramView != null)
    {
      if ((paramView.getLayoutParams() instanceof LayoutParams)) {}
      do
      {
        return ((LayoutParams)paramView.getLayoutParams()).v0;
        paramView.setLayoutParams(generateLayoutParams(paramView.getLayoutParams()));
      } while ((paramView.getLayoutParams() instanceof LayoutParams));
    }
    return null;
  }
  
  protected boolean r()
  {
    int i1 = getContext().getApplicationInfo().flags;
    boolean bool2 = false;
    if ((i1 & 0x400000) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1 = bool2;
    if (i1 != 0)
    {
      bool1 = bool2;
      if (1 == getLayoutDirection()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void requestLayout()
  {
    s();
    super.requestLayout();
  }
  
  public void setConstraintSet(c paramc)
  {
    this.j = paramc;
  }
  
  public void setId(int paramInt)
  {
    this.a.remove(getId());
    super.setId(paramInt);
    this.a.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == this.g) {
      return;
    }
    this.g = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == this.f) {
      return;
    }
    this.f = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == this.e) {
      return;
    }
    this.e = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == this.d) {
      return;
    }
    this.d = paramInt;
    requestLayout();
  }
  
  public void setOnConstraintsChanged(d paramd)
  {
    b localb = this.k;
    if (localb != null) {
      localb.c(paramd);
    }
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.i = paramInt;
    this.c.a2(paramInt);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  protected void t(int paramInt)
  {
    this.k = new b(getContext(), this, paramInt);
  }
  
  protected void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    b localb = this.u;
    int i1 = localb.e;
    paramInt1 = ViewGroup.resolveSizeAndState(paramInt3 + localb.d, paramInt1, 0);
    paramInt3 = ViewGroup.resolveSizeAndState(paramInt4 + i1, paramInt2, 0);
    paramInt2 = Math.min(this.f, paramInt1 & 0xFFFFFF);
    paramInt3 = Math.min(this.g, paramInt3 & 0xFFFFFF);
    paramInt1 = paramInt2;
    if (paramBoolean1) {
      paramInt1 = paramInt2 | 0x1000000;
    }
    paramInt2 = paramInt3;
    if (paramBoolean2) {
      paramInt2 = paramInt3 | 0x1000000;
    }
    setMeasuredDimension(paramInt1, paramInt2);
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  protected void v(f paramf, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i6 = View.MeasureSpec.getSize(paramInt2);
    int i2 = View.MeasureSpec.getMode(paramInt3);
    int i4 = View.MeasureSpec.getSize(paramInt3);
    int i3 = Math.max(0, getPaddingTop());
    int i8 = Math.max(0, getPaddingBottom());
    int i5 = i3 + i8;
    int i7 = getPaddingWidth();
    this.u.c(paramInt2, paramInt3, i3, i8, i7, i5);
    paramInt2 = Math.max(0, getPaddingStart());
    paramInt3 = Math.max(0, getPaddingEnd());
    if ((paramInt2 <= 0) && (paramInt3 <= 0)) {
      paramInt2 = Math.max(0, getPaddingLeft());
    } else if (r()) {
      paramInt2 = paramInt3;
    }
    paramInt3 = i6 - i7;
    i4 -= i5;
    y(paramf, i1, paramInt3, i2, i4);
    paramf.V1(paramInt1, i1, paramInt3, i2, i4, this.n, this.o, paramInt2, i3);
  }
  
  public void x(int paramInt, Object paramObject1, Object paramObject2)
  {
    if ((paramInt == 0) && ((paramObject1 instanceof String)) && ((paramObject2 instanceof Integer)))
    {
      if (this.m == null) {
        this.m = new HashMap();
      }
      String str = (String)paramObject1;
      paramInt = str.indexOf("/");
      paramObject1 = str;
      if (paramInt != -1) {
        paramObject1 = str.substring(paramInt + 1);
      }
      paramInt = ((Integer)paramObject2).intValue();
      this.m.put(paramObject1, Integer.valueOf(paramInt));
    }
  }
  
  protected void y(f paramf, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = this.u;
    int i1 = ((b)localObject1).e;
    int i2 = ((b)localObject1).d;
    localObject1 = e.b.a;
    int i3 = getChildCount();
    Object localObject2;
    e.b localb;
    if (paramInt1 != -2147483648)
    {
      if (paramInt1 != 0) {
        if (paramInt1 != 1073741824) {
          localObject2 = localObject1;
        }
      }
      do
      {
        paramInt2 = 0;
        break;
        paramInt2 = Math.min(this.f - i2, paramInt2);
        localObject2 = localObject1;
        break;
        localb = e.b.b;
        localObject2 = localb;
      } while (i3 != 0);
      localObject2 = localb;
    }
    else
    {
      localb = e.b.b;
      localObject2 = localb;
      if (i3 != 0) {
        break label125;
      }
      localObject2 = localb;
    }
    paramInt2 = Math.max(0, this.d);
    label125:
    if (paramInt3 != -2147483648)
    {
      if (paramInt3 != 0) {
        if (paramInt3 == 1073741824) {}
      }
      do
      {
        paramInt4 = 0;
        break;
        paramInt4 = Math.min(this.g - i1, paramInt4);
        break;
        localb = e.b.b;
        localObject1 = localb;
      } while (i3 != 0);
      localObject1 = localb;
    }
    else
    {
      localb = e.b.b;
      localObject1 = localb;
      if (i3 != 0) {
        break label218;
      }
      localObject1 = localb;
    }
    paramInt4 = Math.max(0, this.e);
    label218:
    if ((paramInt2 != paramf.Y()) || (paramInt4 != paramf.z())) {
      paramf.R1();
    }
    paramf.q1(0);
    paramf.r1(0);
    paramf.b1(this.f - i2);
    paramf.a1(this.g - i1);
    paramf.e1(0);
    paramf.d1(0);
    paramf.T0(localObject2);
    paramf.o1(paramInt2);
    paramf.k1((e.b)localObject1);
    paramf.P0(paramInt4);
    paramf.e1(this.d - i2);
    paramf.d1(this.e - i1);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int A = -2147483648;
    public int B = -2147483648;
    public int C = -2147483648;
    public int D = 0;
    boolean E = true;
    boolean F = true;
    public float G = 0.5F;
    public float H = 0.5F;
    public String I = null;
    float J = 0.0F;
    int K = 1;
    public float L = -1.0F;
    public float M = -1.0F;
    public int N = 0;
    public int O = 0;
    public int P = 0;
    public int Q = 0;
    public int R = 0;
    public int S = 0;
    public int T = 0;
    public int U = 0;
    public float V = 1.0F;
    public float W = 1.0F;
    public int X = -1;
    public int Y = -1;
    public int Z = -1;
    public int a = -1;
    public boolean a0 = false;
    public int b = -1;
    public boolean b0 = false;
    public float c = -1.0F;
    public String c0 = null;
    public boolean d = true;
    public int d0 = 0;
    public int e = -1;
    boolean e0 = true;
    public int f = -1;
    boolean f0 = true;
    public int g = -1;
    boolean g0 = false;
    public int h = -1;
    boolean h0 = false;
    public int i = -1;
    boolean i0 = false;
    public int j = -1;
    boolean j0 = false;
    public int k = -1;
    boolean k0 = false;
    public int l = -1;
    int l0 = -1;
    public int m = -1;
    int m0 = -1;
    public int n = -1;
    int n0 = -1;
    public int o = -1;
    int o0 = -1;
    public int p = -1;
    int p0 = -2147483648;
    public int q = 0;
    int q0 = -2147483648;
    public float r = 0.0F;
    float r0 = 0.5F;
    public int s = -1;
    int s0;
    public int t = -1;
    int t0;
    public int u = -1;
    float u0;
    public int v = -1;
    k0.e v0 = new k0.e();
    public int w = -2147483648;
    public boolean w0 = false;
    public int x = -2147483648;
    public int y = -2147483648;
    public int z = -2147483648;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i2 = paramAttributeSet.getIndexCount();
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = paramAttributeSet.getIndex(i1);
        int i4 = a.a.get(i3);
        switch (i4)
        {
        default: 
          switch (i4)
          {
          default: 
            switch (i4)
            {
            default: 
              break;
            case 67: 
              this.d = paramAttributeSet.getBoolean(i3, this.d);
              break;
            case 66: 
              this.d0 = paramAttributeSet.getInt(i3, this.d0);
              break;
            case 65: 
              c.G(this, paramAttributeSet, i3, 1);
              this.F = true;
              break;
            case 64: 
              c.G(this, paramAttributeSet, i3, 0);
              this.E = true;
            }
            break;
          case 55: 
            this.C = paramAttributeSet.getDimensionPixelSize(i3, this.C);
            break;
          case 54: 
            this.D = paramAttributeSet.getDimensionPixelSize(i3, this.D);
            break;
          case 53: 
            i4 = paramAttributeSet.getResourceId(i3, this.o);
            this.o = i4;
            if (i4 == -1) {
              this.o = paramAttributeSet.getInt(i3, -1);
            }
            break;
          case 52: 
            i4 = paramAttributeSet.getResourceId(i3, this.n);
            this.n = i4;
            if (i4 == -1) {
              this.n = paramAttributeSet.getInt(i3, -1);
            }
            break;
          case 51: 
            this.c0 = paramAttributeSet.getString(i3);
            break;
          case 50: 
            this.Y = paramAttributeSet.getDimensionPixelOffset(i3, this.Y);
            break;
          case 49: 
            this.X = paramAttributeSet.getDimensionPixelOffset(i3, this.X);
            break;
          case 48: 
            this.O = paramAttributeSet.getInt(i3, 0);
            break;
          case 47: 
            this.N = paramAttributeSet.getInt(i3, 0);
            break;
          case 46: 
            this.M = paramAttributeSet.getFloat(i3, this.M);
            break;
          case 45: 
            this.L = paramAttributeSet.getFloat(i3, this.L);
            break;
          case 44: 
            c.I(this, paramAttributeSet.getString(i3));
          }
          break;
        case 38: 
          this.W = Math.max(0.0F, paramAttributeSet.getFloat(i3, this.W));
          this.Q = 2;
          break;
        }
        try
        {
          this.U = paramAttributeSet.getDimensionPixelSize(i3, this.U);
        }
        catch (Exception paramContext)
        {
          label1040:
          break label1040;
        }
        if (paramAttributeSet.getInt(i3, this.U) == -2) {
          this.U = -2;
        }
        label1081:
        label1266:
        try
        {
          this.S = paramAttributeSet.getDimensionPixelSize(i3, this.S);
        }
        catch (Exception paramContext)
        {
          label1148:
          break label1081;
        }
        if (paramAttributeSet.getInt(i3, this.S) == -2)
        {
          this.S = -2;
          break label2103;
          this.V = Math.max(0.0F, paramAttributeSet.getFloat(i3, this.V));
          this.P = 2;
        }
        try
        {
          this.T = paramAttributeSet.getDimensionPixelSize(i3, this.T);
        }
        catch (Exception paramContext)
        {
          break label1148;
        }
        if (paramAttributeSet.getInt(i3, this.T) == -2) {
          this.T = -2;
        }
        try
        {
          this.R = paramAttributeSet.getDimensionPixelSize(i3, this.R);
        }
        catch (Exception paramContext)
        {
          label1189:
          float f1;
          break label1189;
        }
        if (paramAttributeSet.getInt(i3, this.R) == -2)
        {
          this.R = -2;
          break label2103;
          i3 = paramAttributeSet.getInt(i3, 0);
          this.Q = i3;
          if (i3 == 1)
          {
            paramContext = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
            break label1266;
            i3 = paramAttributeSet.getInt(i3, 0);
            this.P = i3;
            if (i3 == 1)
            {
              paramContext = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
              Log.e("ConstraintLayout", paramContext);
              break label2103;
              this.H = paramAttributeSet.getFloat(i3, this.H);
              break label2103;
              this.G = paramAttributeSet.getFloat(i3, this.G);
              break label2103;
              this.b0 = paramAttributeSet.getBoolean(i3, this.b0);
              break label2103;
              this.a0 = paramAttributeSet.getBoolean(i3, this.a0);
              break label2103;
              this.B = paramAttributeSet.getDimensionPixelSize(i3, this.B);
              break label2103;
              this.A = paramAttributeSet.getDimensionPixelSize(i3, this.A);
              break label2103;
              this.z = paramAttributeSet.getDimensionPixelSize(i3, this.z);
              break label2103;
              this.y = paramAttributeSet.getDimensionPixelSize(i3, this.y);
              break label2103;
              this.x = paramAttributeSet.getDimensionPixelSize(i3, this.x);
              break label2103;
              this.w = paramAttributeSet.getDimensionPixelSize(i3, this.w);
              break label2103;
              i4 = paramAttributeSet.getResourceId(i3, this.v);
              this.v = i4;
              if (i4 == -1)
              {
                this.v = paramAttributeSet.getInt(i3, -1);
                break label2103;
                i4 = paramAttributeSet.getResourceId(i3, this.u);
                this.u = i4;
                if (i4 == -1)
                {
                  this.u = paramAttributeSet.getInt(i3, -1);
                  break label2103;
                  i4 = paramAttributeSet.getResourceId(i3, this.t);
                  this.t = i4;
                  if (i4 == -1)
                  {
                    this.t = paramAttributeSet.getInt(i3, -1);
                    break label2103;
                    i4 = paramAttributeSet.getResourceId(i3, this.s);
                    this.s = i4;
                    if (i4 == -1)
                    {
                      this.s = paramAttributeSet.getInt(i3, -1);
                      break label2103;
                      i4 = paramAttributeSet.getResourceId(i3, this.m);
                      this.m = i4;
                      if (i4 == -1)
                      {
                        this.m = paramAttributeSet.getInt(i3, -1);
                        break label2103;
                        i4 = paramAttributeSet.getResourceId(i3, this.l);
                        this.l = i4;
                        if (i4 == -1)
                        {
                          this.l = paramAttributeSet.getInt(i3, -1);
                          break label2103;
                          i4 = paramAttributeSet.getResourceId(i3, this.k);
                          this.k = i4;
                          if (i4 == -1)
                          {
                            this.k = paramAttributeSet.getInt(i3, -1);
                            break label2103;
                            i4 = paramAttributeSet.getResourceId(i3, this.j);
                            this.j = i4;
                            if (i4 == -1)
                            {
                              this.j = paramAttributeSet.getInt(i3, -1);
                              break label2103;
                              i4 = paramAttributeSet.getResourceId(i3, this.i);
                              this.i = i4;
                              if (i4 == -1)
                              {
                                this.i = paramAttributeSet.getInt(i3, -1);
                                break label2103;
                                i4 = paramAttributeSet.getResourceId(i3, this.h);
                                this.h = i4;
                                if (i4 == -1)
                                {
                                  this.h = paramAttributeSet.getInt(i3, -1);
                                  break label2103;
                                  i4 = paramAttributeSet.getResourceId(i3, this.g);
                                  this.g = i4;
                                  if (i4 == -1)
                                  {
                                    this.g = paramAttributeSet.getInt(i3, -1);
                                    break label2103;
                                    i4 = paramAttributeSet.getResourceId(i3, this.f);
                                    this.f = i4;
                                    if (i4 == -1)
                                    {
                                      this.f = paramAttributeSet.getInt(i3, -1);
                                      break label2103;
                                      i4 = paramAttributeSet.getResourceId(i3, this.e);
                                      this.e = i4;
                                      if (i4 == -1)
                                      {
                                        this.e = paramAttributeSet.getInt(i3, -1);
                                        break label2103;
                                        this.c = paramAttributeSet.getFloat(i3, this.c);
                                        break label2103;
                                        this.b = paramAttributeSet.getDimensionPixelOffset(i3, this.b);
                                        break label2103;
                                        this.a = paramAttributeSet.getDimensionPixelOffset(i3, this.a);
                                        break label2103;
                                        f1 = paramAttributeSet.getFloat(i3, this.r) % 360.0F;
                                        this.r = f1;
                                        if (f1 < 0.0F)
                                        {
                                          this.r = ((360.0F - f1) % 360.0F);
                                          break label2103;
                                          this.q = paramAttributeSet.getDimensionPixelSize(i3, this.q);
                                          break label2103;
                                          i4 = paramAttributeSet.getResourceId(i3, this.p);
                                          this.p = i4;
                                          if (i4 == -1)
                                          {
                                            this.p = paramAttributeSet.getInt(i3, -1);
                                            break label2103;
                                            this.Z = paramAttributeSet.getInt(i3, this.Z);
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label2103:
        i1 += 1;
      }
      paramAttributeSet.recycle();
      c();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public String a()
    {
      return this.c0;
    }
    
    public k0.e b()
    {
      return this.v0;
    }
    
    public void c()
    {
      this.h0 = false;
      this.e0 = true;
      this.f0 = true;
      int i1 = this.width;
      if ((i1 == -2) && (this.a0))
      {
        this.e0 = false;
        if (this.P == 0) {
          this.P = 1;
        }
      }
      int i2 = this.height;
      if ((i2 == -2) && (this.b0))
      {
        this.f0 = false;
        if (this.Q == 0) {
          this.Q = 1;
        }
      }
      if ((i1 == 0) || (i1 == -1))
      {
        this.e0 = false;
        if ((i1 == 0) && (this.P == 1))
        {
          this.width = -2;
          this.a0 = true;
        }
      }
      if ((i2 == 0) || (i2 == -1))
      {
        this.f0 = false;
        if ((i2 == 0) && (this.Q == 1))
        {
          this.height = -2;
          this.b0 = true;
        }
      }
      if ((this.c != -1.0F) || (this.a != -1) || (this.b != -1))
      {
        this.h0 = true;
        this.e0 = true;
        this.f0 = true;
        if (!(this.v0 instanceof h)) {
          this.v0 = new h();
        }
        ((h)this.v0).E1(this.Z);
      }
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int paramInt)
    {
      int i2 = this.leftMargin;
      int i3 = this.rightMargin;
      super.resolveLayoutDirection(paramInt);
      paramInt = getLayoutDirection();
      int i1 = 0;
      if (1 == paramInt) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      this.n0 = -1;
      this.o0 = -1;
      this.l0 = -1;
      this.m0 = -1;
      this.p0 = this.w;
      this.q0 = this.y;
      float f1 = this.G;
      this.r0 = f1;
      int i4 = this.a;
      this.s0 = i4;
      int i5 = this.b;
      this.t0 = i5;
      float f2 = this.c;
      this.u0 = f2;
      if (paramInt != 0)
      {
        paramInt = this.s;
        if (paramInt != -1) {
          this.n0 = paramInt;
        }
        for (;;)
        {
          paramInt = 1;
          break;
          int i6 = this.t;
          paramInt = i1;
          if (i6 == -1) {
            break;
          }
          this.o0 = i6;
        }
        i1 = this.u;
        if (i1 != -1)
        {
          this.m0 = i1;
          paramInt = 1;
        }
        i1 = this.v;
        if (i1 != -1)
        {
          this.l0 = i1;
          paramInt = 1;
        }
        i1 = this.A;
        if (i1 != -2147483648) {
          this.q0 = i1;
        }
        i1 = this.B;
        if (i1 != -2147483648) {
          this.p0 = i1;
        }
        if (paramInt != 0) {
          this.r0 = (1.0F - f1);
        }
        if ((this.h0) && (this.Z == 1) && (this.d)) {
          if (f2 != -1.0F)
          {
            this.u0 = (1.0F - f2);
            this.s0 = -1;
            this.t0 = -1;
          }
          else
          {
            if (i4 != -1)
            {
              this.t0 = i4;
              this.s0 = -1;
            }
            for (;;)
            {
              this.u0 = -1.0F;
              break;
              if (i5 == -1) {
                break;
              }
              this.s0 = i5;
              this.t0 = -1;
            }
          }
        }
      }
      else
      {
        paramInt = this.s;
        if (paramInt != -1) {
          this.m0 = paramInt;
        }
        paramInt = this.t;
        if (paramInt != -1) {
          this.l0 = paramInt;
        }
        paramInt = this.u;
        if (paramInt != -1) {
          this.n0 = paramInt;
        }
        paramInt = this.v;
        if (paramInt != -1) {
          this.o0 = paramInt;
        }
        paramInt = this.A;
        if (paramInt != -2147483648) {
          this.p0 = paramInt;
        }
        paramInt = this.B;
        if (paramInt != -2147483648) {
          this.q0 = paramInt;
        }
      }
      if ((this.u == -1) && (this.v == -1) && (this.t == -1) && (this.s == -1))
      {
        paramInt = this.g;
        if (paramInt != -1)
        {
          this.n0 = paramInt;
          if ((this.rightMargin > 0) || (i3 <= 0)) {}
        }
        else
        {
          do
          {
            this.rightMargin = i3;
            break;
            paramInt = this.h;
            if (paramInt == -1) {
              break;
            }
            this.o0 = paramInt;
          } while ((this.rightMargin <= 0) && (i3 > 0));
        }
        paramInt = this.e;
        if (paramInt != -1)
        {
          this.l0 = paramInt;
          if ((this.leftMargin > 0) || (i2 <= 0)) {}
        }
        else
        {
          do
          {
            this.leftMargin = i2;
            return;
            paramInt = this.f;
            if (paramInt == -1) {
              break;
            }
            this.m0 = paramInt;
          } while ((this.leftMargin <= 0) && (i2 > 0));
        }
      }
    }
    
    private static class a
    {
      public static final SparseIntArray a;
      
      static
      {
        SparseIntArray localSparseIntArray = new SparseIntArray();
        a = localSparseIntArray;
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
      }
    }
  }
  
  class b
    implements b.b
  {
    ConstraintLayout a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    
    public b(ConstraintLayout paramConstraintLayout)
    {
      this.a = paramConstraintLayout;
    }
    
    private boolean d(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 == paramInt2) {
        return true;
      }
      int i = View.MeasureSpec.getMode(paramInt1);
      View.MeasureSpec.getSize(paramInt1);
      paramInt1 = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      return (paramInt1 == 1073741824) && ((i == -2147483648) || (i == 0)) && (paramInt3 == paramInt2);
    }
    
    public final void a()
    {
      int k = this.a.getChildCount();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        View localView = this.a.getChildAt(i);
        if ((localView instanceof Placeholder)) {
          ((Placeholder)localView).b(this.a);
        }
        i += 1;
      }
      k = ConstraintLayout.d(this.a).size();
      if (k > 0)
      {
        i = j;
        while (i < k)
        {
          ((ConstraintHelper)ConstraintLayout.d(this.a).get(i)).s(this.a);
          i += 1;
        }
      }
    }
    
    @SuppressLint({"WrongCall"})
    public final void b(k0.e parame, b.a parama)
    {
      if (parame == null) {
        return;
      }
      if ((parame.X() == 8) && (!parame.l0()))
      {
        parama.e = 0;
        parama.f = 0;
        parama.g = 0;
        return;
      }
      if (parame.M() == null) {
        return;
      }
      Object localObject1 = parama.a;
      Object localObject2 = parama.b;
      int i = parama.c;
      int m = parama.d;
      int n = this.b + this.c;
      int j = this.d;
      View localView = (View)parame.u();
      Object localObject3 = ConstraintLayout.a.a;
      int k = localObject3[localObject1.ordinal()];
      int i1;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              i = 0;
              break label341;
            }
            k = ViewGroup.getChildMeasureSpec(this.f, j, -2);
            if (parame.w == 1) {
              j = 1;
            } else {
              j = 0;
            }
            i1 = parama.j;
            if (i1 != b.a.l)
            {
              i = k;
              if (i1 != b.a.m) {
                break label341;
              }
            }
            if (localView.getMeasuredHeight() == parame.z()) {
              i = 1;
            } else {
              i = 0;
            }
            if ((parama.j != b.a.m) && (j != 0) && ((j == 0) || (i == 0)) && (!(localView instanceof Placeholder)) && (!parame.p0())) {
              j = 0;
            } else {
              j = 1;
            }
            i = k;
            if (j == 0) {
              break label341;
            }
            i = parame.Y();
            break label332;
          }
          i = this.f;
          j += parame.D();
          k = -1;
        }
        else
        {
          i = this.f;
          k = -2;
        }
        i = ViewGroup.getChildMeasureSpec(i, j, k);
        break label341;
      }
      label332:
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      label341:
      k = localObject3[localObject2.ordinal()];
      j = m;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              j = 0;
              break label590;
            }
            m = ViewGroup.getChildMeasureSpec(this.g, n, -2);
            if (parame.x == 1) {
              k = 1;
            } else {
              k = 0;
            }
            n = parama.j;
            if (n != b.a.l)
            {
              j = m;
              if (n != b.a.m) {
                break label590;
              }
            }
            if (localView.getMeasuredWidth() == parame.Y()) {
              j = 1;
            } else {
              j = 0;
            }
            if ((parama.j != b.a.m) && (k != 0) && ((k == 0) || (j == 0)) && (!(localView instanceof Placeholder)) && (!parame.q0())) {
              k = 0;
            } else {
              k = 1;
            }
            j = m;
            if (k == 0) {
              break label590;
            }
            j = parame.z();
            break label581;
          }
          j = this.g;
          k = n + parame.W();
          m = -1;
        }
        else
        {
          j = this.g;
          m = -2;
          k = n;
        }
        j = ViewGroup.getChildMeasureSpec(j, k, m);
        break label590;
      }
      label581:
      j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
      label590:
      localObject3 = (f)parame.M();
      if ((localObject3 != null) && (k.b(ConstraintLayout.b(ConstraintLayout.this), 256)) && (localView.getMeasuredWidth() == parame.Y()) && (localView.getMeasuredWidth() < ((k0.e)localObject3).Y()) && (localView.getMeasuredHeight() == parame.z()) && (localView.getMeasuredHeight() < ((k0.e)localObject3).z()) && (localView.getBaseline() == parame.r()) && (!parame.o0()))
      {
        if ((d(parame.E(), i, parame.Y())) && (d(parame.F(), j, parame.z()))) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
        {
          parama.e = parame.Y();
          parama.f = parame.z();
          parama.g = parame.r();
          return;
        }
      }
      localObject3 = e.b.c;
      if (localObject1 == localObject3) {
        k = 1;
      } else {
        k = 0;
      }
      if (localObject2 == localObject3) {
        m = 1;
      } else {
        m = 0;
      }
      localObject3 = e.b.d;
      int i2;
      if ((localObject2 != localObject3) && (localObject2 != e.b.a)) {
        i2 = 0;
      } else {
        i2 = 1;
      }
      int i3;
      if ((localObject1 != localObject3) && (localObject1 != e.b.a)) {
        i3 = 0;
      } else {
        i3 = 1;
      }
      int i4;
      if ((k != 0) && (parame.f0 > 0.0F)) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      int i5;
      if ((m != 0) && (parame.f0 > 0.0F)) {
        i5 = 1;
      } else {
        i5 = 0;
      }
      if (localView == null) {
        return;
      }
      localObject1 = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      n = parama.j;
      if ((n != b.a.l) && (n != b.a.m) && (k != 0) && (parame.w == 0) && (m != 0) && (parame.x == 0))
      {
        k = 0;
        i1 = 0;
        i2 = 0;
      }
      else
      {
        if (((localView instanceof VirtualLayout)) && ((parame instanceof m)))
        {
          localObject2 = (m)parame;
          ((VirtualLayout)localView).x((m)localObject2, i, j);
        }
        else
        {
          localView.measure(i, j);
        }
        parame.Z0(i, j);
        int i7 = localView.getMeasuredWidth();
        int i6 = localView.getMeasuredHeight();
        int i8 = localView.getBaseline();
        k = parame.z;
        if (k > 0) {
          m = Math.max(k, i7);
        } else {
          m = i7;
        }
        n = parame.A;
        k = m;
        if (n > 0) {
          k = Math.min(n, m);
        }
        m = parame.C;
        if (m > 0) {
          m = Math.max(m, i6);
        } else {
          m = i6;
        }
        n = parame.D;
        i1 = m;
        if (n > 0) {
          i1 = Math.min(n, m);
        }
        m = i1;
        n = k;
        if (!k.b(ConstraintLayout.b(ConstraintLayout.this), 1))
        {
          float f1;
          if ((i4 != 0) && (i2 != 0))
          {
            f1 = parame.f0;
            n = (int)(i1 * f1 + 0.5F);
            m = i1;
          }
          else
          {
            m = i1;
            n = k;
            if (i5 != 0)
            {
              m = i1;
              n = k;
              if (i3 != 0)
              {
                f1 = parame.f0;
                m = (int)(k / f1 + 0.5F);
                n = k;
              }
            }
          }
        }
        if (i7 == n)
        {
          k = m;
          i1 = i8;
          i2 = n;
          if (i6 != m) {}
        }
        for (;;)
        {
          break;
          if (i7 != n) {
            i = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
          }
          if (i6 != m) {
            j = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
          }
          localView.measure(i, j);
          parame.Z0(i, j);
          i2 = localView.getMeasuredWidth();
          k = localView.getMeasuredHeight();
          i1 = localView.getBaseline();
        }
      }
      boolean bool1;
      if (i1 != -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((i2 == parama.c) && (k == parama.d)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      parama.i = bool2;
      if (((ConstraintLayout.LayoutParams)localObject1).g0) {
        bool1 = true;
      }
      if ((bool1) && (i1 != -1) && (parame.r() != i1)) {
        parama.i = true;
      }
      parama.e = i2;
      parama.f = k;
      parama.h = bool1;
      parama.g = i1;
    }
    
    public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.b = paramInt3;
      this.c = paramInt4;
      this.d = paramInt5;
      this.e = paramInt6;
      this.f = paramInt1;
      this.g = paramInt2;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintLayout
 * JD-Core Version:    0.7.0.1
 */