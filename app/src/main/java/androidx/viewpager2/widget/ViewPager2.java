package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.q;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.RecyclerView.z;
import androidx.recyclerview.widget.n;
import androidx.recyclerview.widget.r;
import androidx.viewpager2.R.styleable;
import androidx.viewpager2.adapter.a;
import y0.d.a;
import y0.d.b;
import y0.g;
import y0.g.a;

public final class ViewPager2
  extends ViewGroup
{
  static boolean u = true;
  private final Rect a = new Rect();
  private final Rect b = new Rect();
  private b c = new b(3);
  int d;
  boolean e = false;
  private RecyclerView.j f = new a();
  private LinearLayoutManager g;
  private int h = -1;
  private Parcelable i;
  RecyclerView j;
  private n k;
  e l;
  private b m;
  private c n;
  private d o;
  private RecyclerView.m p = null;
  private boolean q = false;
  private boolean r = true;
  private int s = -1;
  e t;
  
  public ViewPager2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }
  
  public ViewPager2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet);
  }
  
  private RecyclerView.q a()
  {
    return new d();
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (u) {
      localObject = new j();
    } else {
      localObject = new f();
    }
    this.t = ((e)localObject);
    Object localObject = new m(paramContext);
    this.j = ((RecyclerView)localObject);
    ((ViewGroup)localObject).setId(x.k());
    this.j.setDescendantFocusability(131072);
    localObject = new h(paramContext);
    this.g = ((LinearLayoutManager)localObject);
    this.j.setLayoutManager((RecyclerView.p)localObject);
    this.j.setScrollingTouchSlop(1);
    k(paramContext, paramAttributeSet);
    this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.j.j(a());
    paramContext = new e(this);
    this.l = paramContext;
    this.n = new c(this, paramContext, this.j);
    paramContext = new l();
    this.k = paramContext;
    paramContext.b(this.j);
    this.j.l(this.l);
    paramContext = new b(3);
    this.m = paramContext;
    this.l.o(paramContext);
    paramContext = new b();
    paramAttributeSet = new c();
    this.m.d(paramContext);
    this.m.d(paramAttributeSet);
    this.t.h(this.m, this.j);
    this.m.d(this.c);
    paramContext = new d(this.g);
    this.o = paramContext;
    this.m.d(paramContext);
    paramContext = this.j;
    attachViewToParent(paramContext, 0, paramContext.getLayoutParams());
  }
  
  private void f(RecyclerView.h<?> paramh)
  {
    if (paramh != null) {
      paramh.E(this.f);
    }
  }
  
  private void h()
  {
    if (this.h == -1) {
      return;
    }
    RecyclerView.h localh = getAdapter();
    if (localh == null) {
      return;
    }
    Parcelable localParcelable = this.i;
    if (localParcelable != null)
    {
      if ((localh instanceof a)) {
        ((a)localh).b(localParcelable);
      }
      this.i = null;
    }
    int i1 = Math.max(0, Math.min(this.h, localh.d() - 1));
    this.d = i1;
    this.h = -1;
    this.j.k1(i1);
    this.t.m();
  }
  
  private void k(Context paramContext, AttributeSet paramAttributeSet)
  {
    int[] arrayOfInt = R.styleable.ViewPager2;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    if (Build.VERSION.SDK_INT >= 29) {
      saveAttributeDataForStyleable(paramContext, arrayOfInt, paramAttributeSet, localTypedArray, 0, 0);
    }
    try
    {
      setOrientation(localTypedArray.getInt(R.styleable.ViewPager2_android_orientation, 0));
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  private void l(RecyclerView.h<?> paramh)
  {
    if (paramh != null) {
      paramh.H(this.f);
    }
  }
  
  public boolean c()
  {
    return this.n.a();
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return this.j.canScrollHorizontally(paramInt);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return this.j.canScrollVertically(paramInt);
  }
  
  boolean d()
  {
    return this.g.Z() == 1;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    Parcelable localParcelable = (Parcelable)paramSparseArray.get(getId());
    if ((localParcelable instanceof SavedState))
    {
      int i1 = ((SavedState)localParcelable).a;
      paramSparseArray.put(this.j.getId(), paramSparseArray.get(i1));
      paramSparseArray.remove(i1);
    }
    super.dispatchRestoreInstanceState(paramSparseArray);
    h();
  }
  
  public boolean e()
  {
    return this.r;
  }
  
  public void g()
  {
    if (this.o.d() == null) {
      return;
    }
    double d1 = this.l.g();
    int i1 = (int)d1;
    float f1 = (float)(d1 - i1);
    int i2 = Math.round(getPageSize() * f1);
    this.o.b(i1, f1, i2);
  }
  
  public CharSequence getAccessibilityClassName()
  {
    if (this.t.a()) {
      return this.t.g();
    }
    return super.getAccessibilityClassName();
  }
  
  public RecyclerView.h getAdapter()
  {
    return this.j.getAdapter();
  }
  
  public int getCurrentItem()
  {
    return this.d;
  }
  
  public int getItemDecorationCount()
  {
    return this.j.getItemDecorationCount();
  }
  
  public int getOffscreenPageLimit()
  {
    return this.s;
  }
  
  public int getOrientation()
  {
    return this.g.l2();
  }
  
  int getPageSize()
  {
    RecyclerView localRecyclerView = this.j;
    int i2;
    int i1;
    if (getOrientation() == 0)
    {
      i2 = localRecyclerView.getWidth() - localRecyclerView.getPaddingLeft();
      i1 = localRecyclerView.getPaddingRight();
    }
    else
    {
      i2 = localRecyclerView.getHeight() - localRecyclerView.getPaddingTop();
      i1 = localRecyclerView.getPaddingBottom();
    }
    return i2 - i1;
  }
  
  public int getScrollState()
  {
    return this.l.h();
  }
  
  public void i(int paramInt, boolean paramBoolean)
  {
    if (!c())
    {
      j(paramInt, paramBoolean);
      return;
    }
    throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
  }
  
  void j(int paramInt, boolean paramBoolean)
  {
    Object localObject = getAdapter();
    if (localObject == null)
    {
      if (this.h != -1) {
        this.h = Math.max(paramInt, 0);
      }
      return;
    }
    if (((RecyclerView.h)localObject).d() <= 0) {
      return;
    }
    int i1 = Math.min(Math.max(paramInt, 0), ((RecyclerView.h)localObject).d() - 1);
    if ((i1 == this.d) && (this.l.j())) {
      return;
    }
    paramInt = this.d;
    if ((i1 == paramInt) && (paramBoolean)) {
      return;
    }
    double d1 = paramInt;
    this.d = i1;
    this.t.q();
    if (!this.l.j()) {
      d1 = this.l.g();
    }
    this.l.m(i1, paramBoolean);
    if (!paramBoolean)
    {
      this.j.k1(i1);
      return;
    }
    double d2 = i1;
    if (Math.abs(d2 - d1) > 3.0D)
    {
      localObject = this.j;
      if (d2 > d1) {
        paramInt = i1 - 3;
      } else {
        paramInt = i1 + 3;
      }
      ((RecyclerView)localObject).k1(paramInt);
      localObject = this.j;
      ((ViewGroup)localObject).post(new n(i1, (RecyclerView)localObject));
      return;
    }
    this.j.s1(i1);
  }
  
  void m()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = ((n)localObject).f(this.g);
      if (localObject == null) {
        return;
      }
      int i1 = this.g.h0((View)localObject);
      if ((i1 != this.d) && (getScrollState() == 0)) {
        this.m.c(i1);
      }
      this.e = false;
      return;
    }
    throw new IllegalStateException("Design assumption violated.");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    this.t.i(paramAccessibilityNodeInfo);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.j.getMeasuredWidth();
    int i2 = this.j.getMeasuredHeight();
    this.a.left = getPaddingLeft();
    this.a.right = (paramInt3 - paramInt1 - getPaddingRight());
    this.a.top = getPaddingTop();
    this.a.bottom = (paramInt4 - paramInt2 - getPaddingBottom());
    Gravity.apply(8388659, i1, i2, this.a, this.b);
    RecyclerView localRecyclerView = this.j;
    Rect localRect = this.b;
    localRecyclerView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
    if (this.e) {
      m();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChild(this.j, paramInt1, paramInt2);
    int i5 = this.j.getMeasuredWidth();
    int i2 = this.j.getMeasuredHeight();
    int i1 = this.j.getMeasuredState();
    int i6 = getPaddingLeft();
    int i7 = getPaddingRight();
    int i3 = getPaddingTop();
    int i4 = getPaddingBottom();
    i5 = Math.max(i5 + (i6 + i7), getSuggestedMinimumWidth());
    i2 = Math.max(i2 + (i3 + i4), getSuggestedMinimumHeight());
    setMeasuredDimension(ViewGroup.resolveSizeAndState(i5, paramInt1, i1), ViewGroup.resolveSizeAndState(i2, paramInt2, i1 << 16));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.h = paramParcelable.b;
    this.i = paramParcelable.c;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = this.j.getId();
    int i2 = this.h;
    int i1 = i2;
    if (i2 == -1) {
      i1 = this.d;
    }
    localSavedState.b = i1;
    Object localObject = this.i;
    if (localObject != null) {}
    for (;;)
    {
      localSavedState.c = ((Parcelable)localObject);
      return localSavedState;
      localObject = this.j.getAdapter();
      if (!(localObject instanceof a)) {
        break;
      }
      localObject = ((a)localObject).a();
    }
    return localSavedState;
  }
  
  public void onViewAdded(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(ViewPager2.class.getSimpleName());
    paramView.append(" does not support direct child views");
    throw new IllegalStateException(paramView.toString());
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (this.t.c(paramInt, paramBundle)) {
      return this.t.l(paramInt, paramBundle);
    }
    return super.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public void setAdapter(RecyclerView.h paramh)
  {
    RecyclerView.h localh = this.j.getAdapter();
    this.t.f(localh);
    l(localh);
    this.j.setAdapter(paramh);
    this.d = 0;
    h();
    this.t.e(paramh);
    f(paramh);
  }
  
  public void setCurrentItem(int paramInt)
  {
    i(paramInt, true);
  }
  
  public void setLayoutDirection(int paramInt)
  {
    super.setLayoutDirection(paramInt);
    this.t.p();
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    if ((paramInt < 1) && (paramInt != -1)) {
      throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }
    this.s = paramInt;
    this.j.requestLayout();
  }
  
  public void setOrientation(int paramInt)
  {
    this.g.A2(paramInt);
    this.t.r();
  }
  
  public void setPageTransformer(k paramk)
  {
    boolean bool = this.q;
    if (paramk != null)
    {
      if (!bool)
      {
        this.p = this.j.getItemAnimator();
        this.q = true;
      }
      this.j.setItemAnimator(null);
    }
    else if (bool)
    {
      this.j.setItemAnimator(this.p);
      this.p = null;
      this.q = false;
    }
    if (paramk == this.o.d()) {
      return;
    }
    this.o.e(paramk);
    g();
  }
  
  public void setUserInputEnabled(boolean paramBoolean)
  {
    this.r = paramBoolean;
    this.t.s();
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int a;
    int b;
    Parcelable c;
    
    SavedState(Parcel paramParcel)
    {
      super();
      g(paramParcel, null);
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      g(paramParcel, paramClassLoader);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    private void g(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      this.c = paramParcel.readParcelable(paramClassLoader);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
      paramParcel.writeParcelable(this.c, paramInt);
    }
    
    static final class a
      implements Parcelable.ClassLoaderCreator<ViewPager2.SavedState>
    {
      public ViewPager2.SavedState a(Parcel paramParcel)
      {
        return b(paramParcel, null);
      }
      
      public ViewPager2.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        if (Build.VERSION.SDK_INT >= 24) {
          return new ViewPager2.SavedState(paramParcel, paramClassLoader);
        }
        return new ViewPager2.SavedState(paramParcel);
      }
      
      public ViewPager2.SavedState[] c(int paramInt)
      {
        return new ViewPager2.SavedState[paramInt];
      }
    }
  }
  
  class a
    extends ViewPager2.g
  {
    a()
    {
      super();
    }
    
    public void a()
    {
      ViewPager2 localViewPager2 = ViewPager2.this;
      localViewPager2.e = true;
      localViewPager2.l.l();
    }
  }
  
  class b
    extends ViewPager2.i
  {
    b() {}
    
    public void a(int paramInt)
    {
      if (paramInt == 0) {
        ViewPager2.this.m();
      }
    }
    
    public void c(int paramInt)
    {
      ViewPager2 localViewPager2 = ViewPager2.this;
      if (localViewPager2.d != paramInt)
      {
        localViewPager2.d = paramInt;
        localViewPager2.t.q();
      }
    }
  }
  
  class c
    extends ViewPager2.i
  {
    c() {}
    
    public void c(int paramInt)
    {
      ViewPager2.this.clearFocus();
      if (ViewPager2.this.hasFocus()) {
        ViewPager2.this.j.requestFocus(2);
      }
    }
  }
  
  class d
    implements RecyclerView.q
  {
    d() {}
    
    public void a(View paramView)
    {
      paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((paramView.width == -1) && (paramView.height == -1)) {
        return;
      }
      throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
    }
    
    public void b(View paramView) {}
  }
  
  private abstract class e
  {
    private e() {}
    
    boolean a()
    {
      return false;
    }
    
    boolean b(int paramInt)
    {
      return false;
    }
    
    boolean c(int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    boolean d()
    {
      return false;
    }
    
    void e(RecyclerView.h<?> paramh) {}
    
    void f(RecyclerView.h<?> paramh) {}
    
    String g()
    {
      throw new IllegalStateException("Not implemented.");
    }
    
    void h(b paramb, RecyclerView paramRecyclerView) {}
    
    void i(AccessibilityNodeInfo paramAccessibilityNodeInfo) {}
    
    void j(y0.d paramd) {}
    
    boolean k(int paramInt)
    {
      throw new IllegalStateException("Not implemented.");
    }
    
    boolean l(int paramInt, Bundle paramBundle)
    {
      throw new IllegalStateException("Not implemented.");
    }
    
    void m() {}
    
    CharSequence n()
    {
      throw new IllegalStateException("Not implemented.");
    }
    
    void o(AccessibilityEvent paramAccessibilityEvent) {}
    
    void p() {}
    
    void q() {}
    
    void r() {}
    
    void s() {}
  }
  
  class f
    extends ViewPager2.e
  {
    f()
    {
      super(null);
    }
    
    public boolean b(int paramInt)
    {
      return ((paramInt == 8192) || (paramInt == 4096)) && (!ViewPager2.this.e());
    }
    
    public boolean d()
    {
      return true;
    }
    
    public void j(y0.d paramd)
    {
      if (!ViewPager2.this.e())
      {
        paramd.T(d.a.r);
        paramd.T(d.a.q);
        paramd.z0(false);
      }
    }
    
    public boolean k(int paramInt)
    {
      if (b(paramInt)) {
        return false;
      }
      throw new IllegalStateException();
    }
    
    public CharSequence n()
    {
      if (d()) {
        return "androidx.viewpager.widget.ViewPager";
      }
      throw new IllegalStateException();
    }
  }
  
  private static abstract class g
    extends RecyclerView.j
  {
    public abstract void a();
    
    public final void b(int paramInt1, int paramInt2)
    {
      a();
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      a();
    }
    
    public final void d(int paramInt1, int paramInt2)
    {
      a();
    }
    
    public final void e(int paramInt1, int paramInt2, int paramInt3)
    {
      a();
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      a();
    }
  }
  
  private class h
    extends LinearLayoutManager
  {
    h(Context paramContext)
    {
      super();
    }
    
    public void M0(RecyclerView.v paramv, RecyclerView.z paramz, y0.d paramd)
    {
      super.M0(paramv, paramz, paramd);
      ViewPager2.this.t.j(paramd);
    }
    
    protected void M1(RecyclerView.z paramz, int[] paramArrayOfInt)
    {
      int i = ViewPager2.this.getOffscreenPageLimit();
      if (i == -1)
      {
        super.M1(paramz, paramArrayOfInt);
        return;
      }
      i = ViewPager2.this.getPageSize() * i;
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = i;
    }
    
    public boolean h1(RecyclerView.v paramv, RecyclerView.z paramz, int paramInt, Bundle paramBundle)
    {
      if (ViewPager2.this.t.b(paramInt)) {
        return ViewPager2.this.t.k(paramInt);
      }
      return super.h1(paramv, paramz, paramInt, paramBundle);
    }
    
    public boolean s1(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      return false;
    }
  }
  
  public static abstract class i
  {
    public void a(int paramInt) {}
    
    public void b(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void c(int paramInt) {}
  }
  
  class j
    extends ViewPager2.e
  {
    private final g b = new a();
    private final g c = new b();
    private RecyclerView.j d;
    
    j()
    {
      super(null);
    }
    
    private void t(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      int i;
      int j;
      if (ViewPager2.this.getAdapter() != null)
      {
        if (ViewPager2.this.getOrientation() == 1)
        {
          i = ViewPager2.this.getAdapter().d();
          j = 0;
        }
        else
        {
          j = ViewPager2.this.getAdapter().d();
          i = 0;
        }
      }
      else
      {
        i = 0;
        j = i;
      }
      y0.d.J0(paramAccessibilityNodeInfo).e0(d.b.b(i, j, false, 0));
    }
    
    private void u(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      RecyclerView.h localh = ViewPager2.this.getAdapter();
      if (localh == null) {
        return;
      }
      int i = localh.d();
      if (i != 0)
      {
        if (!ViewPager2.this.e()) {
          return;
        }
        if (ViewPager2.this.d > 0) {
          paramAccessibilityNodeInfo.addAction(8192);
        }
        if (ViewPager2.this.d < i - 1) {
          paramAccessibilityNodeInfo.addAction(4096);
        }
        paramAccessibilityNodeInfo.setScrollable(true);
      }
    }
    
    public boolean a()
    {
      return true;
    }
    
    public boolean c(int paramInt, Bundle paramBundle)
    {
      return (paramInt == 8192) || (paramInt == 4096);
    }
    
    public void e(RecyclerView.h<?> paramh)
    {
      w();
      if (paramh != null) {
        paramh.E(this.d);
      }
    }
    
    public void f(RecyclerView.h<?> paramh)
    {
      if (paramh != null) {
        paramh.H(this.d);
      }
    }
    
    public String g()
    {
      if (a()) {
        return "androidx.viewpager.widget.ViewPager";
      }
      throw new IllegalStateException();
    }
    
    public void h(b paramb, RecyclerView paramRecyclerView)
    {
      x.B0(paramRecyclerView, 2);
      this.d = new c();
      if (x.z(ViewPager2.this) == 0) {
        x.B0(ViewPager2.this, 1);
      }
    }
    
    public void i(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      t(paramAccessibilityNodeInfo);
      u(paramAccessibilityNodeInfo);
    }
    
    public boolean l(int paramInt, Bundle paramBundle)
    {
      if (c(paramInt, paramBundle))
      {
        if (paramInt == 8192) {
          paramInt = ViewPager2.this.getCurrentItem() - 1;
        } else {
          paramInt = ViewPager2.this.getCurrentItem() + 1;
        }
        v(paramInt);
        return true;
      }
      throw new IllegalStateException();
    }
    
    public void m()
    {
      w();
    }
    
    public void o(AccessibilityEvent paramAccessibilityEvent)
    {
      paramAccessibilityEvent.setSource(ViewPager2.this);
      paramAccessibilityEvent.setClassName(g());
    }
    
    public void p()
    {
      w();
    }
    
    public void q()
    {
      w();
    }
    
    public void r()
    {
      w();
    }
    
    public void s()
    {
      w();
    }
    
    void v(int paramInt)
    {
      if (ViewPager2.this.e()) {
        ViewPager2.this.j(paramInt, true);
      }
    }
    
    void w()
    {
      ViewPager2 localViewPager2 = ViewPager2.this;
      int j = 16908360;
      x.k0(localViewPager2, 16908360);
      x.k0(localViewPager2, 16908361);
      x.k0(localViewPager2, 16908358);
      x.k0(localViewPager2, 16908359);
      if (ViewPager2.this.getAdapter() == null) {
        return;
      }
      int k = ViewPager2.this.getAdapter().d();
      if (k == 0) {
        return;
      }
      if (!ViewPager2.this.e()) {
        return;
      }
      if (ViewPager2.this.getOrientation() == 0)
      {
        boolean bool = ViewPager2.this.d();
        int i;
        if (bool) {
          i = 16908360;
        } else {
          i = 16908361;
        }
        if (bool) {
          j = 16908361;
        }
        if (ViewPager2.this.d < k - 1) {
          x.m0(localViewPager2, new d.a(i, null), null, this.b);
        }
        if (ViewPager2.this.d > 0) {
          x.m0(localViewPager2, new d.a(j, null), null, this.c);
        }
      }
      else
      {
        if (ViewPager2.this.d < k - 1) {
          x.m0(localViewPager2, new d.a(16908359, null), null, this.b);
        }
        if (ViewPager2.this.d > 0) {
          x.m0(localViewPager2, new d.a(16908358, null), null, this.c);
        }
      }
    }
    
    class a
      implements g
    {
      a() {}
      
      public boolean a(View paramView, g.a parama)
      {
        paramView = (ViewPager2)paramView;
        ViewPager2.j.this.v(paramView.getCurrentItem() + 1);
        return true;
      }
    }
    
    class b
      implements g
    {
      b() {}
      
      public boolean a(View paramView, g.a parama)
      {
        paramView = (ViewPager2)paramView;
        ViewPager2.j.this.v(paramView.getCurrentItem() - 1);
        return true;
      }
    }
    
    class c
      extends ViewPager2.g
    {
      c()
      {
        super();
      }
      
      public void a()
      {
        ViewPager2.j.this.w();
      }
    }
  }
  
  public static abstract interface k
  {
    public abstract void a(View paramView, float paramFloat);
  }
  
  private class l
    extends n
  {
    l() {}
    
    public View f(RecyclerView.p paramp)
    {
      if (ViewPager2.this.c()) {
        return null;
      }
      return super.f(paramp);
    }
  }
  
  private class m
    extends RecyclerView
  {
    m(Context paramContext)
    {
      super();
    }
    
    public CharSequence getAccessibilityClassName()
    {
      if (ViewPager2.this.t.d()) {
        return ViewPager2.this.t.n();
      }
      return super.getAccessibilityClassName();
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setFromIndex(ViewPager2.this.d);
      paramAccessibilityEvent.setToIndex(ViewPager2.this.d);
      ViewPager2.this.t.o(paramAccessibilityEvent);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      return (ViewPager2.this.e()) && (super.onInterceptTouchEvent(paramMotionEvent));
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return (ViewPager2.this.e()) && (super.onTouchEvent(paramMotionEvent));
    }
  }
  
  private static class n
    implements Runnable
  {
    private final int a;
    private final RecyclerView b;
    
    n(int paramInt, RecyclerView paramRecyclerView)
    {
      this.a = paramInt;
      this.b = paramRecyclerView;
    }
    
    public void run()
    {
      this.b.s1(this.a);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2
 * JD-Core Version:    0.7.0.1
 */