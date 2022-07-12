package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.e.a;
import androidx.appcompat.view.menu.e.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j.a;
import androidx.appcompat.view.menu.k;

public class ActionMenuView
  extends LinearLayoutCompat
  implements e.b, k
{
  d A;
  private e p;
  private Context q;
  private int r;
  private boolean s;
  private ActionMenuPresenter t;
  private j.a u;
  e.a v;
  private boolean w;
  private int x;
  private int y;
  private int z;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.y = ((int)(56.0F * f));
    this.z = ((int)(f * 4.0F));
    this.q = paramContext;
    this.r = 0;
  }
  
  static int L(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView)) {
      localActionMenuItemView = (ActionMenuItemView)paramView;
    } else {
      localActionMenuItemView = null;
    }
    boolean bool = true;
    if ((localActionMenuItemView != null) && (localActionMenuItemView.k())) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    paramInt4 = 2;
    if ((paramInt2 > 0) && ((paramInt3 == 0) || (paramInt2 >= 2)))
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 * paramInt1, -2147483648), j);
      int k = paramView.getMeasuredWidth();
      int i = k / paramInt1;
      paramInt2 = i;
      if (k % paramInt1 != 0) {
        paramInt2 = i + 1;
      }
      if ((paramInt3 != 0) && (paramInt2 < 2)) {
        paramInt2 = paramInt4;
      }
    }
    else
    {
      paramInt2 = 0;
    }
    if ((localLayoutParams.a) || (paramInt3 == 0)) {
      bool = false;
    }
    localLayoutParams.d = bool;
    localLayoutParams.b = paramInt2;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, 1073741824), j);
    return paramInt2;
  }
  
  private void M(int paramInt1, int paramInt2)
  {
    int i3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int i7 = getPaddingTop() + getPaddingBottom();
    int i11 = ViewGroup.getChildMeasureSpec(paramInt2, i7, -2);
    int i5 = paramInt1 - (i + j);
    paramInt1 = this.y;
    int i6 = i5 / paramInt1;
    if (i6 == 0)
    {
      setMeasuredDimension(i5, 0);
      return;
    }
    int i12 = paramInt1 + i5 % paramInt1 / i6;
    int i13 = getChildCount();
    j = 0;
    paramInt1 = j;
    int k = paramInt1;
    paramInt2 = k;
    i = paramInt2;
    int m = i;
    long l1 = 0L;
    int i1 = i;
    int i2 = paramInt2;
    int n = paramInt1;
    i = j;
    paramInt1 = i6;
    j = i4;
    Object localObject;
    LayoutParams localLayoutParams;
    while (n < i13)
    {
      localObject = getChildAt(n);
      if (((View)localObject).getVisibility() == 8)
      {
        paramInt2 = m;
      }
      else
      {
        boolean bool = localObject instanceof ActionMenuItemView;
        i2 += 1;
        if (bool)
        {
          paramInt2 = this.z;
          ((View)localObject).setPadding(paramInt2, 0, paramInt2, 0);
        }
        localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.f = false;
        localLayoutParams.c = 0;
        localLayoutParams.b = 0;
        localLayoutParams.d = false;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.rightMargin = 0;
        if ((bool) && (((ActionMenuItemView)localObject).k())) {
          bool = true;
        } else {
          bool = false;
        }
        localLayoutParams.e = bool;
        if (localLayoutParams.a) {
          paramInt2 = 1;
        } else {
          paramInt2 = paramInt1;
        }
        i4 = L((View)localObject, i12, paramInt2, i11, i7);
        i1 = Math.max(i1, i4);
        paramInt2 = m;
        if (localLayoutParams.d) {
          paramInt2 = m + 1;
        }
        if (localLayoutParams.a) {
          k = 1;
        }
        paramInt1 -= i4;
        i = Math.max(i, ((View)localObject).getMeasuredHeight());
        if (i4 == 1) {
          l1 |= 1 << n;
        }
      }
      n += 1;
      m = paramInt2;
    }
    if ((k != 0) && (i2 == 2)) {
      n = 1;
    } else {
      n = 0;
    }
    paramInt2 = 0;
    i4 = paramInt1;
    i6 = n;
    n = i5;
    while ((m > 0) && (i4 > 0))
    {
      i5 = 2147483647;
      int i8 = 0;
      i7 = 0;
      long l2;
      for (long l3 = 0L; i7 < i13; l3 = l2)
      {
        localObject = (LayoutParams)getChildAt(i7).getLayoutParams();
        int i9;
        if (!((LayoutParams)localObject).d)
        {
          paramInt1 = i8;
          i9 = i5;
          l2 = l3;
        }
        else
        {
          int i10 = ((LayoutParams)localObject).b;
          if (i10 < i5)
          {
            l2 = 1L << i7;
            i9 = i10;
            paramInt1 = 1;
          }
          else
          {
            paramInt1 = i8;
            i9 = i5;
            l2 = l3;
            if (i10 == i5)
            {
              paramInt1 = i8 + 1;
              l2 = l3 | 1L << i7;
              i9 = i5;
            }
          }
        }
        i7 += 1;
        i8 = paramInt1;
        i5 = i9;
      }
      paramInt1 = paramInt2;
      paramInt2 = i;
      l1 |= l3;
      if (i8 > i4) {
        break label763;
      }
      paramInt1 = 0;
      while (paramInt1 < i13)
      {
        localObject = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        long l4 = 1 << paramInt1;
        if ((l3 & l4) == 0L)
        {
          l2 = l1;
          if (localLayoutParams.b == i5 + 1) {
            l2 = l1 | l4;
          }
          l1 = l2;
        }
        else
        {
          if ((i6 != 0) && (localLayoutParams.e) && (i4 == 1))
          {
            i = this.z;
            ((View)localObject).setPadding(i + i12, 0, i, 0);
          }
          localLayoutParams.b += 1;
          localLayoutParams.f = true;
          i4 -= 1;
        }
        paramInt1 += 1;
      }
      i = paramInt2;
      paramInt2 = 1;
    }
    paramInt1 = paramInt2;
    paramInt2 = i;
    label763:
    if ((k == 0) && (i2 == 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i4 > 0) && (l1 != 0L) && ((i4 < i2 - 1) || (i != 0) || (i1 > 1)))
    {
      float f2 = Long.bitCount(l1);
      if (i == 0)
      {
        float f1 = f2;
        if ((l1 & 1L) != 0L)
        {
          f1 = f2;
          if (!((LayoutParams)getChildAt(0).getLayoutParams()).e) {
            f1 = f2 - 0.5F;
          }
        }
        i = i13 - 1;
        f2 = f1;
        if ((l1 & 1 << i) != 0L)
        {
          f2 = f1;
          if (!((LayoutParams)getChildAt(i).getLayoutParams()).e) {
            f2 = f1 - 0.5F;
          }
        }
      }
      if (f2 > 0.0F) {
        k = (int)(i4 * i12 / f2);
      } else {
        k = 0;
      }
      m = 0;
      for (;;)
      {
        i = paramInt1;
        if (m >= i13) {
          break;
        }
        if ((l1 & 1 << m) == 0L)
        {
          i = paramInt1;
        }
        else
        {
          localObject = getChildAt(m);
          localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
          if ((localObject instanceof ActionMenuItemView))
          {
            localLayoutParams.c = k;
            localLayoutParams.f = true;
            if ((m == 0) && (!localLayoutParams.e)) {
              localLayoutParams.leftMargin = (-k / 2);
            }
            i = 1;
          }
          else if (localLayoutParams.a)
          {
            localLayoutParams.c = k;
            localLayoutParams.f = true;
            localLayoutParams.rightMargin = (-k / 2);
            i = 1;
          }
          else
          {
            if (m != 0) {
              localLayoutParams.leftMargin = (k / 2);
            }
            i = paramInt1;
            if (m != i13 - 1)
            {
              localLayoutParams.rightMargin = (k / 2);
              i = paramInt1;
            }
          }
        }
        m += 1;
        paramInt1 = i;
      }
    }
    i = paramInt1;
    if (i != 0)
    {
      paramInt1 = 0;
      while (paramInt1 < i13)
      {
        localObject = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.f) {
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.b * i12 + localLayoutParams.c, 1073741824), i11);
        }
        paramInt1 += 1;
      }
    }
    if (i3 == 1073741824) {
      paramInt2 = j;
    }
    setMeasuredDimension(n, paramInt2);
  }
  
  public void B()
  {
    ActionMenuPresenter localActionMenuPresenter = this.t;
    if (localActionMenuPresenter != null) {
      localActionMenuPresenter.B();
    }
  }
  
  protected LayoutParams C()
  {
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public LayoutParams D(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams E(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof LayoutParams)) {
        paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      } else {
        paramLayoutParams = new LayoutParams(paramLayoutParams);
      }
      if (paramLayoutParams.gravity <= 0) {
        paramLayoutParams.gravity = 16;
      }
      return paramLayoutParams;
    }
    return C();
  }
  
  public LayoutParams F()
  {
    LayoutParams localLayoutParams = C();
    localLayoutParams.a = true;
    return localLayoutParams;
  }
  
  protected boolean G(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof a)) {
        bool1 = false | ((a)localView1).c();
      }
    }
    bool2 = bool1;
    if (paramInt > 0)
    {
      bool2 = bool1;
      if ((localView2 instanceof a)) {
        bool2 = bool1 | ((a)localView2).e();
      }
    }
    return bool2;
  }
  
  public boolean H()
  {
    ActionMenuPresenter localActionMenuPresenter = this.t;
    return (localActionMenuPresenter != null) && (localActionMenuPresenter.E());
  }
  
  public boolean I()
  {
    ActionMenuPresenter localActionMenuPresenter = this.t;
    return (localActionMenuPresenter != null) && (localActionMenuPresenter.G());
  }
  
  public boolean J()
  {
    ActionMenuPresenter localActionMenuPresenter = this.t;
    return (localActionMenuPresenter != null) && (localActionMenuPresenter.H());
  }
  
  public boolean K()
  {
    return this.s;
  }
  
  public e N()
  {
    return this.p;
  }
  
  public void O(j.a parama, e.a parama1)
  {
    this.u = parama;
    this.v = parama1;
  }
  
  public boolean P()
  {
    ActionMenuPresenter localActionMenuPresenter = this.t;
    return (localActionMenuPresenter != null) && (localActionMenuPresenter.N());
  }
  
  public boolean a(g paramg)
  {
    return this.p.N(paramg, 0);
  }
  
  public void b(e parame)
  {
    this.p = parame;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public Menu getMenu()
  {
    if (this.p == null)
    {
      Object localObject1 = getContext();
      Object localObject2 = new e((Context)localObject1);
      this.p = ((e)localObject2);
      ((e)localObject2).V(new c());
      localObject1 = new ActionMenuPresenter((Context)localObject1);
      this.t = ((ActionMenuPresenter)localObject1);
      ((ActionMenuPresenter)localObject1).M(true);
      localObject2 = this.t;
      localObject1 = this.u;
      if (localObject1 == null) {
        localObject1 = new b();
      }
      ((a)localObject2).m((j.a)localObject1);
      this.p.c(this.t, this.q);
      this.t.K(this);
    }
    return this.p;
  }
  
  public Drawable getOverflowIcon()
  {
    getMenu();
    return this.t.D();
  }
  
  public int getPopupTheme()
  {
    return this.r;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.t;
    if (paramConfiguration != null)
    {
      paramConfiguration.g(false);
      if (this.t.H())
      {
        this.t.E();
        this.t.N();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    B();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.w)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int m = getChildCount();
    int k = (paramInt4 - paramInt2) / 2;
    int n = getDividerWidth();
    int i1 = paramInt3 - paramInt1;
    paramInt1 = i1 - getPaddingRight() - getPaddingLeft();
    paramBoolean = r0.b(this);
    paramInt2 = 0;
    paramInt4 = 0;
    paramInt3 = 0;
    View localView;
    LayoutParams localLayoutParams;
    int i;
    int j;
    while (paramInt2 < m)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.a)
        {
          i = localView.getMeasuredWidth();
          paramInt4 = i;
          if (G(paramInt2)) {
            paramInt4 = i + n;
          }
          int i2 = localView.getMeasuredHeight();
          if (paramBoolean)
          {
            j = getPaddingLeft() + localLayoutParams.leftMargin;
            i = j + paramInt4;
          }
          else
          {
            i = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
            j = i - paramInt4;
          }
          int i3 = k - i2 / 2;
          localView.layout(j, i3, i, i2 + i3);
          paramInt1 -= paramInt4;
          paramInt4 = 1;
        }
        else
        {
          paramInt1 -= localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          G(paramInt2);
          paramInt3 += 1;
        }
      }
      paramInt2 += 1;
    }
    if ((m == 1) && (paramInt4 == 0))
    {
      localView = getChildAt(0);
      paramInt1 = localView.getMeasuredWidth();
      paramInt2 = localView.getMeasuredHeight();
      paramInt3 = i1 / 2 - paramInt1 / 2;
      paramInt4 = k - paramInt2 / 2;
      localView.layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
      return;
    }
    paramInt2 = paramInt3 - (paramInt4 ^ 0x1);
    if (paramInt2 > 0) {
      paramInt1 /= paramInt2;
    } else {
      paramInt1 = 0;
    }
    paramInt4 = Math.max(0, paramInt1);
    if (paramBoolean)
    {
      paramInt2 = getWidth() - getPaddingRight();
      paramInt1 = 0;
      while (paramInt1 < m)
      {
        localView = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8) {
          if (localLayoutParams.a)
          {
            paramInt3 = paramInt2;
          }
          else
          {
            paramInt2 -= localLayoutParams.rightMargin;
            paramInt3 = localView.getMeasuredWidth();
            i = localView.getMeasuredHeight();
            j = k - i / 2;
            localView.layout(paramInt2 - paramInt3, j, paramInt2, i + j);
            paramInt3 = paramInt2 - (paramInt3 + localLayoutParams.leftMargin + paramInt4);
          }
        }
        paramInt1 += 1;
        paramInt2 = paramInt3;
      }
    }
    paramInt2 = getPaddingLeft();
    paramInt1 = 0;
    while (paramInt1 < m)
    {
      localView = getChildAt(paramInt1);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8) {
        if (localLayoutParams.a)
        {
          paramInt3 = paramInt2;
        }
        else
        {
          paramInt2 += localLayoutParams.leftMargin;
          paramInt3 = localView.getMeasuredWidth();
          i = localView.getMeasuredHeight();
          j = k - i / 2;
          localView.layout(paramInt2, j, paramInt2 + paramInt3, i + j);
          paramInt3 = paramInt2 + (paramInt3 + localLayoutParams.rightMargin + paramInt4);
        }
      }
      paramInt1 += 1;
      paramInt2 = paramInt3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.w;
    boolean bool1;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.w = bool1;
    if (bool2 != bool1) {
      this.x = 0;
    }
    int i = View.MeasureSpec.getSize(paramInt1);
    Object localObject;
    if (this.w)
    {
      localObject = this.p;
      if ((localObject != null) && (i != this.x))
      {
        this.x = i;
        ((e)localObject).M(true);
      }
    }
    int j = getChildCount();
    if ((this.w) && (j > 0))
    {
      M(paramInt1, paramInt2);
      return;
    }
    i = 0;
    while (i < j)
    {
      localObject = (LayoutParams)getChildAt(i).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
      ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.t.J(paramBoolean);
  }
  
  public void setOnMenuItemClickListener(d paramd)
  {
    this.A = paramd;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    getMenu();
    this.t.L(paramDrawable);
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.r != paramInt)
    {
      this.r = paramInt;
      if (paramInt == 0)
      {
        this.q = getContext();
        return;
      }
      this.q = new ContextThemeWrapper(getContext(), paramInt);
    }
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.t = paramActionMenuPresenter;
    paramActionMenuPresenter.K(this);
  }
  
  public static class LayoutParams
    extends LinearLayoutCompat.LayoutParams
  {
    @ViewDebug.ExportedProperty
    public boolean a;
    @ViewDebug.ExportedProperty
    public int b;
    @ViewDebug.ExportedProperty
    public int c;
    @ViewDebug.ExportedProperty
    public boolean d;
    @ViewDebug.ExportedProperty
    public boolean e;
    boolean f;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.a = false;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.a = paramLayoutParams.a;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean c();
    
    public abstract boolean e();
  }
  
  private static class b
    implements j.a
  {
    public void b(e parame, boolean paramBoolean) {}
    
    public boolean c(e parame)
    {
      return false;
    }
  }
  
  private class c
    implements e.a
  {
    c() {}
    
    public boolean a(e parame, MenuItem paramMenuItem)
    {
      parame = ActionMenuView.this.A;
      return (parame != null) && (parame.onMenuItemClick(paramMenuItem));
    }
    
    public void b(e parame)
    {
      e.a locala = ActionMenuView.this.v;
      if (locala != null) {
        locala.b(parame);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.ActionMenuView
 * JD-Core Version:    0.7.0.1
 */