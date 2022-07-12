package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e.a;
import androidx.appcompat.widget.k0;
import androidx.core.view.h0;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.p;
import r7.m;
import r7.m.b;
import r7.n;

public class NavigationView
  extends ScrimInsetsFrameLayout
{
  private static final int[] s = { 16842912 };
  private static final int[] t = { -16842910 };
  private static final int u = R.style.Widget_Design_NavigationView;
  private final com.google.android.material.internal.h f;
  private final com.google.android.material.internal.i g;
  c h;
  private final int i;
  private final int[] j;
  private MenuInflater k;
  private ViewTreeObserver.OnGlobalLayoutListener l;
  private boolean m;
  private boolean n;
  private int o;
  private int p;
  private Path q;
  private final RectF r;
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, com.google.android.material.R.attr.navigationViewStyle);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i1), paramAttributeSet, paramInt);
    com.google.android.material.internal.i locali = new com.google.android.material.internal.i();
    this.g = locali;
    this.j = new int[2];
    this.m = true;
    this.n = true;
    this.o = 0;
    this.p = 0;
    this.r = new RectF();
    Context localContext = getContext();
    com.google.android.material.internal.h localh = new com.google.android.material.internal.h(localContext);
    this.f = localh;
    k0 localk0 = p.i(localContext, paramAttributeSet, R.styleable.NavigationView, paramInt, i1, new int[0]);
    int i2 = R.styleable.NavigationView_android_background;
    if (localk0.s(i2)) {
      x.u0(this, localk0.g(i2));
    }
    this.p = localk0.f(R.styleable.NavigationView_drawerLayoutCornerSize, 0);
    this.o = localk0.k(R.styleable.NavigationView_android_layout_gravity, 0);
    if ((getBackground() == null) || ((getBackground() instanceof ColorDrawable)))
    {
      paramAttributeSet = m.e(localContext, paramAttributeSet, paramInt, i1).m();
      paramContext = getBackground();
      paramAttributeSet = new r7.h(paramAttributeSet);
      if ((paramContext instanceof ColorDrawable)) {
        paramAttributeSet.b0(ColorStateList.valueOf(((ColorDrawable)paramContext).getColor()));
      }
      paramAttributeSet.Q(localContext);
      x.u0(this, paramAttributeSet);
    }
    paramInt = R.styleable.NavigationView_elevation;
    if (localk0.s(paramInt)) {
      setElevation(localk0.f(paramInt, 0));
    }
    setFitsSystemWindows(localk0.a(R.styleable.NavigationView_android_fitsSystemWindows, false));
    this.i = localk0.f(R.styleable.NavigationView_android_maxWidth, 0);
    paramInt = R.styleable.NavigationView_subheaderColor;
    if (localk0.s(paramInt)) {
      paramContext = localk0.c(paramInt);
    } else {
      paramContext = null;
    }
    paramInt = R.styleable.NavigationView_subheaderTextAppearance;
    if (localk0.s(paramInt)) {
      paramInt = localk0.n(paramInt, 0);
    } else {
      paramInt = 0;
    }
    paramAttributeSet = paramContext;
    if (paramInt == 0)
    {
      paramAttributeSet = paramContext;
      if (paramContext == null) {
        paramAttributeSet = d(16842808);
      }
    }
    i1 = R.styleable.NavigationView_itemIconTint;
    ColorStateList localColorStateList1;
    if (localk0.s(i1)) {
      localColorStateList1 = localk0.c(i1);
    } else {
      localColorStateList1 = d(16842808);
    }
    i1 = R.styleable.NavigationView_itemTextAppearance;
    if (localk0.s(i1)) {
      i1 = localk0.n(i1, 0);
    } else {
      i1 = 0;
    }
    i2 = R.styleable.NavigationView_itemIconSize;
    if (localk0.s(i2)) {
      setItemIconSize(localk0.f(i2, 0));
    }
    i2 = R.styleable.NavigationView_itemTextColor;
    if (localk0.s(i2)) {
      paramContext = localk0.c(i2);
    } else {
      paramContext = null;
    }
    Object localObject = paramContext;
    if (i1 == 0)
    {
      localObject = paramContext;
      if (paramContext == null) {
        localObject = d(16842806);
      }
    }
    Drawable localDrawable = localk0.g(R.styleable.NavigationView_itemBackground);
    paramContext = localDrawable;
    if (localDrawable == null)
    {
      paramContext = localDrawable;
      if (g(localk0))
      {
        localDrawable = e(localk0);
        ColorStateList localColorStateList2 = o7.c.b(localContext, localk0, R.styleable.NavigationView_itemRippleColor);
        paramContext = localDrawable;
        if (localColorStateList2 != null)
        {
          paramContext = f(localk0, null);
          locali.I(new RippleDrawable(p7.b.d(localColorStateList2), null, paramContext));
          paramContext = localDrawable;
        }
      }
    }
    i2 = R.styleable.NavigationView_itemHorizontalPadding;
    if (localk0.s(i2)) {
      setItemHorizontalPadding(localk0.f(i2, 0));
    }
    i2 = R.styleable.NavigationView_itemVerticalPadding;
    if (localk0.s(i2)) {
      setItemVerticalPadding(localk0.f(i2, 0));
    }
    setDividerInsetStart(localk0.f(R.styleable.NavigationView_dividerInsetStart, 0));
    setDividerInsetEnd(localk0.f(R.styleable.NavigationView_dividerInsetEnd, 0));
    setSubheaderInsetStart(localk0.f(R.styleable.NavigationView_subheaderInsetStart, 0));
    setSubheaderInsetEnd(localk0.f(R.styleable.NavigationView_subheaderInsetEnd, 0));
    setTopInsetScrimEnabled(localk0.a(R.styleable.NavigationView_topInsetScrimEnabled, this.m));
    setBottomInsetScrimEnabled(localk0.a(R.styleable.NavigationView_bottomInsetScrimEnabled, this.n));
    i2 = localk0.f(R.styleable.NavigationView_itemIconPadding, 0);
    setItemMaxLines(localk0.k(R.styleable.NavigationView_itemMaxLines, 1));
    localh.V(new a());
    locali.G(1);
    locali.d(localContext, localh);
    if (paramInt != 0) {
      locali.U(paramInt);
    }
    locali.S(paramAttributeSet);
    locali.M(localColorStateList1);
    locali.R(getOverScrollMode());
    if (i1 != 0) {
      locali.O(i1);
    }
    locali.P((ColorStateList)localObject);
    locali.H(paramContext);
    locali.K(i2);
    localh.b(locali);
    addView((View)locali.y(this));
    paramInt = R.styleable.NavigationView_menu;
    if (localk0.s(paramInt)) {
      i(localk0.n(paramInt, 0));
    }
    paramInt = R.styleable.NavigationView_headerLayout;
    if (localk0.s(paramInt)) {
      h(localk0.n(paramInt, 0));
    }
    localk0.w();
    m();
  }
  
  private ColorStateList d(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = c.a.a(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, (TypedValue)localObject, true)) {
      return null;
    }
    paramInt = ((TypedValue)localObject).data;
    int i1 = localColorStateList.getDefaultColor();
    localObject = t;
    int[] arrayOfInt1 = s;
    int[] arrayOfInt2 = FrameLayout.EMPTY_STATE_SET;
    int i2 = localColorStateList.getColorForState((int[])localObject, i1);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { i2, paramInt, i1 });
  }
  
  private Drawable e(k0 paramk0)
  {
    return f(paramk0, o7.c.b(getContext(), paramk0, R.styleable.NavigationView_itemShapeFillColor));
  }
  
  private Drawable f(k0 paramk0, ColorStateList paramColorStateList)
  {
    int i1 = paramk0.n(R.styleable.NavigationView_itemShapeAppearance, 0);
    int i2 = paramk0.n(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0);
    r7.h localh = new r7.h(m.b(getContext(), i1, i2).m());
    localh.b0(paramColorStateList);
    return new InsetDrawable(localh, paramk0.f(R.styleable.NavigationView_itemShapeInsetStart, 0), paramk0.f(R.styleable.NavigationView_itemShapeInsetTop, 0), paramk0.f(R.styleable.NavigationView_itemShapeInsetEnd, 0), paramk0.f(R.styleable.NavigationView_itemShapeInsetBottom, 0));
  }
  
  private boolean g(k0 paramk0)
  {
    return (paramk0.s(R.styleable.NavigationView_itemShapeAppearance)) || (paramk0.s(R.styleable.NavigationView_itemShapeAppearanceOverlay));
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.k == null) {
      this.k = new g.g(getContext());
    }
    return this.k;
  }
  
  private void l(int paramInt1, int paramInt2)
  {
    if (((getParent() instanceof DrawerLayout)) && (this.p > 0) && ((getBackground() instanceof r7.h)))
    {
      r7.h localh = (r7.h)getBackground();
      m.b localb = localh.E().v();
      if (androidx.core.view.e.b(this.o, x.B(this)) == 3)
      {
        localb.I(this.p);
        localb.z(this.p);
      }
      else
      {
        localb.E(this.p);
        localb.v(this.p);
      }
      localh.setShapeAppearanceModel(localb.m());
      if (this.q == null) {
        this.q = new Path();
      }
      this.q.reset();
      this.r.set(0.0F, 0.0F, paramInt1, paramInt2);
      n.k().d(localh.E(), localh.y(), this.r, this.q);
      invalidate();
      return;
    }
    this.q = null;
    this.r.setEmpty();
  }
  
  private void m()
  {
    this.l = new b();
    getViewTreeObserver().addOnGlobalLayoutListener(this.l);
  }
  
  protected void a(h0 paramh0)
  {
    this.g.h(paramh0);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.q == null)
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    int i1 = paramCanvas.save();
    paramCanvas.clipPath(this.q);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restoreToCount(i1);
  }
  
  public MenuItem getCheckedItem()
  {
    return this.g.n();
  }
  
  public int getDividerInsetEnd()
  {
    return this.g.o();
  }
  
  public int getDividerInsetStart()
  {
    return this.g.p();
  }
  
  public int getHeaderCount()
  {
    return this.g.q();
  }
  
  public Drawable getItemBackground()
  {
    return this.g.r();
  }
  
  public int getItemHorizontalPadding()
  {
    return this.g.s();
  }
  
  public int getItemIconPadding()
  {
    return this.g.t();
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.g.w();
  }
  
  public int getItemMaxLines()
  {
    return this.g.u();
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.g.v();
  }
  
  public int getItemVerticalPadding()
  {
    return this.g.x();
  }
  
  public Menu getMenu()
  {
    return this.f;
  }
  
  public int getSubheaderInsetEnd()
  {
    return this.g.z();
  }
  
  public int getSubheaderInsetStart()
  {
    return this.g.A();
  }
  
  public View h(int paramInt)
  {
    return this.g.B(paramInt);
  }
  
  public void i(int paramInt)
  {
    this.g.V(true);
    getMenuInflater().inflate(paramInt, this.f);
    this.g.V(false);
    this.g.g(false);
  }
  
  public boolean j()
  {
    return this.n;
  }
  
  public boolean k()
  {
    return this.m;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    r7.i.e(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getViewTreeObserver().removeOnGlobalLayoutListener(this.l);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    if (i1 != -2147483648)
    {
      if (i1 != 0) {
        break label47;
      }
      paramInt1 = this.i;
    }
    else
    {
      paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt1), this.i);
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    label47:
    super.onMeasure(paramInt1, paramInt2);
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
    this.f.S(paramParcelable.c);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Bundle localBundle = new Bundle();
    localSavedState.c = localBundle;
    this.f.U(localBundle);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    l(paramInt1, paramInt2);
  }
  
  public void setBottomInsetScrimEnabled(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setCheckedItem(int paramInt)
  {
    MenuItem localMenuItem = this.f.findItem(paramInt);
    if (localMenuItem != null) {
      this.g.D((androidx.appcompat.view.menu.g)localMenuItem);
    }
  }
  
  public void setCheckedItem(MenuItem paramMenuItem)
  {
    paramMenuItem = this.f.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.g.D((androidx.appcompat.view.menu.g)paramMenuItem);
      return;
    }
    throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
  }
  
  public void setDividerInsetEnd(int paramInt)
  {
    this.g.E(paramInt);
  }
  
  public void setDividerInsetStart(int paramInt)
  {
    this.g.F(paramInt);
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    r7.i.d(this, paramFloat);
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.g.H(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    setItemBackground(androidx.core.content.b.d(getContext(), paramInt));
  }
  
  public void setItemHorizontalPadding(int paramInt)
  {
    this.g.J(paramInt);
  }
  
  public void setItemHorizontalPaddingResource(int paramInt)
  {
    this.g.J(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconPadding(int paramInt)
  {
    this.g.K(paramInt);
  }
  
  public void setItemIconPaddingResource(int paramInt)
  {
    this.g.K(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.g.L(paramInt);
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.g.M(paramColorStateList);
  }
  
  public void setItemMaxLines(int paramInt)
  {
    this.g.N(paramInt);
  }
  
  public void setItemTextAppearance(int paramInt)
  {
    this.g.O(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.g.P(paramColorStateList);
  }
  
  public void setItemVerticalPadding(int paramInt)
  {
    this.g.Q(paramInt);
  }
  
  public void setItemVerticalPaddingResource(int paramInt)
  {
    this.g.Q(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setNavigationItemSelectedListener(c paramc)
  {
    this.h = paramc;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(paramInt);
    com.google.android.material.internal.i locali = this.g;
    if (locali != null) {
      locali.R(paramInt);
    }
  }
  
  public void setSubheaderInsetEnd(int paramInt)
  {
    this.g.T(paramInt);
  }
  
  public void setSubheaderInsetStart(int paramInt)
  {
    this.g.T(paramInt);
  }
  
  public void setTopInsetScrimEnabled(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    public Bundle c;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.c = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.c);
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<NavigationView.SavedState>
    {
      public NavigationView.SavedState a(Parcel paramParcel)
      {
        return new NavigationView.SavedState(paramParcel, null);
      }
      
      public NavigationView.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new NavigationView.SavedState(paramParcel, paramClassLoader);
      }
      
      public NavigationView.SavedState[] c(int paramInt)
      {
        return new NavigationView.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements e.a
  {
    a() {}
    
    public boolean a(androidx.appcompat.view.menu.e parame, MenuItem paramMenuItem)
    {
      parame = NavigationView.this.h;
      return (parame != null) && (parame.c(paramMenuItem));
    }
    
    public void b(androidx.appcompat.view.menu.e parame) {}
  }
  
  class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public void onGlobalLayout()
    {
      Object localObject = NavigationView.this;
      ((FrameLayout)localObject).getLocationOnScreen(NavigationView.b((NavigationView)localObject));
      localObject = NavigationView.b(NavigationView.this);
      boolean bool2 = true;
      boolean bool1;
      if (localObject[1] == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      NavigationView.c(NavigationView.this).C(bool1);
      localObject = NavigationView.this;
      if ((bool1) && (((NavigationView)localObject).k())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((ScrimInsetsFrameLayout)localObject).setDrawTopInsetForeground(bool1);
      localObject = com.google.android.material.internal.c.a(NavigationView.this.getContext());
      if (localObject != null)
      {
        int i;
        if (((Activity)localObject).findViewById(16908290).getHeight() == NavigationView.this.getHeight()) {
          i = 1;
        } else {
          i = 0;
        }
        int j;
        if (Color.alpha(((Activity)localObject).getWindow().getNavigationBarColor()) != 0) {
          j = 1;
        } else {
          j = 0;
        }
        localObject = NavigationView.this;
        if ((i != 0) && (j != 0) && (((NavigationView)localObject).j())) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        ((ScrimInsetsFrameLayout)localObject).setDrawBottomInsetForeground(bool1);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean c(MenuItem paramMenuItem);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.navigation.NavigationView
 * JD-Core Version:    0.7.0.1
 */