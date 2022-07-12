package com.google.android.material.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.k;
import androidx.core.view.x;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import androidx.transition.r;
import com.google.android.material.R.integer;
import com.google.android.material.internal.n;
import java.util.ArrayList;
import java.util.HashSet;
import r7.h;
import r7.m;
import y0.d;
import y0.d.b;

public abstract class c
  extends ViewGroup
  implements k
{
  private static final int[] C = { 16842912 };
  private static final int[] E = { -16842910 };
  private NavigationBarPresenter A;
  private androidx.appcompat.view.menu.e B;
  private final TransitionSet a;
  private final View.OnClickListener b;
  private final x0.e<a> c = new x0.g(5);
  private final SparseArray<View.OnTouchListener> d = new SparseArray(5);
  private int e;
  private a[] f;
  private int g = 0;
  private int h = 0;
  private ColorStateList i;
  private int j;
  private ColorStateList k;
  private final ColorStateList l = e(16842808);
  private int m;
  private int n;
  private Drawable o;
  private int p;
  private final SparseArray<com.google.android.material.badge.a> q = new SparseArray(5);
  private int r = -1;
  private int s = -1;
  private boolean t;
  private int u;
  private int v;
  private int w;
  private m x;
  private boolean y = false;
  private ColorStateList z;
  
  public c(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode())
    {
      this.a = null;
    }
    else
    {
      paramContext = new AutoTransition();
      this.a = paramContext;
      paramContext.v0(0);
      paramContext.t0(m7.a.d(getContext(), com.google.android.material.R.attr.motionDurationLong1, getResources().getInteger(R.integer.material_motion_duration_long_1)));
      paramContext.u0(m7.a.e(getContext(), com.google.android.material.R.attr.motionEasingStandard, e7.a.b));
      paramContext.n0(new n());
    }
    this.b = new a();
    x.B0(this, 1);
  }
  
  private Drawable f()
  {
    if ((this.x != null) && (this.z != null))
    {
      h localh = new h(this.x);
      localh.b0(this.z);
      return localh;
    }
    return null;
  }
  
  private a getNewItem()
  {
    a locala2 = (a)this.c.b();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = g(getContext());
    }
    return locala1;
  }
  
  private boolean k(int paramInt)
  {
    return paramInt != -1;
  }
  
  private void m()
  {
    HashSet localHashSet = new HashSet();
    int i3 = 0;
    int i2 = 0;
    int i1;
    for (;;)
    {
      i1 = i3;
      if (i2 >= this.B.size()) {
        break;
      }
      localHashSet.add(Integer.valueOf(this.B.getItem(i2).getItemId()));
      i2 += 1;
    }
    while (i1 < this.q.size())
    {
      i2 = this.q.keyAt(i1);
      if (!localHashSet.contains(Integer.valueOf(i2))) {
        this.q.delete(i2);
      }
      i1 += 1;
    }
  }
  
  private void q(int paramInt)
  {
    if (k(paramInt)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is not a valid view id");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void setBadgeIfNeeded(a parama)
  {
    int i1 = parama.getId();
    if (!k(i1)) {
      return;
    }
    com.google.android.material.badge.a locala = (com.google.android.material.badge.a)this.q.get(i1);
    if (locala != null) {
      parama.setBadge(locala);
    }
  }
  
  public void b(androidx.appcompat.view.menu.e parame)
  {
    this.B = parame;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void d()
  {
    removeAllViews();
    Object localObject1 = this.f;
    int i2;
    Object localObject2;
    if (localObject1 != null)
    {
      i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject2 = localObject1[i1];
        if (localObject2 != null)
        {
          this.c.a(localObject2);
          ((a)localObject2).g();
        }
        i1 += 1;
      }
    }
    if (this.B.size() == 0)
    {
      this.g = 0;
      this.h = 0;
      this.f = null;
      return;
    }
    m();
    this.f = new a[this.B.size()];
    boolean bool = j(this.e, this.B.G().size());
    int i1 = 0;
    while (i1 < this.B.size())
    {
      this.A.h(true);
      this.B.getItem(i1).setCheckable(true);
      this.A.h(false);
      localObject1 = getNewItem();
      this.f[i1] = localObject1;
      ((a)localObject1).setIconTintList(this.i);
      ((a)localObject1).setIconSize(this.j);
      ((a)localObject1).setTextColor(this.l);
      ((a)localObject1).setTextAppearanceInactive(this.m);
      ((a)localObject1).setTextAppearanceActive(this.n);
      ((a)localObject1).setTextColor(this.k);
      i2 = this.r;
      if (i2 != -1) {
        ((a)localObject1).setItemPaddingTop(i2);
      }
      i2 = this.s;
      if (i2 != -1) {
        ((a)localObject1).setItemPaddingBottom(i2);
      }
      ((a)localObject1).setActiveIndicatorWidth(this.u);
      ((a)localObject1).setActiveIndicatorHeight(this.v);
      ((a)localObject1).setActiveIndicatorMarginHorizontal(this.w);
      ((a)localObject1).setActiveIndicatorDrawable(f());
      ((a)localObject1).setActiveIndicatorResizeable(this.y);
      ((a)localObject1).setActiveIndicatorEnabled(this.t);
      localObject2 = this.o;
      if (localObject2 != null) {
        ((a)localObject1).setItemBackground((Drawable)localObject2);
      } else {
        ((a)localObject1).setItemBackground(this.p);
      }
      ((a)localObject1).setShifting(bool);
      ((a)localObject1).setLabelVisibilityMode(this.e);
      localObject2 = (androidx.appcompat.view.menu.g)this.B.getItem(i1);
      ((a)localObject1).j((androidx.appcompat.view.menu.g)localObject2, 0);
      ((a)localObject1).setItemPosition(i1);
      i2 = ((androidx.appcompat.view.menu.g)localObject2).getItemId();
      ((FrameLayout)localObject1).setOnTouchListener((View.OnTouchListener)this.d.get(i2));
      ((FrameLayout)localObject1).setOnClickListener(this.b);
      int i3 = this.g;
      if ((i3 != 0) && (i2 == i3)) {
        this.h = i1;
      }
      setBadgeIfNeeded((a)localObject1);
      addView((View)localObject1);
      i1 += 1;
    }
    i1 = Math.min(this.B.size() - 1, this.h);
    this.h = i1;
    this.B.getItem(i1).setChecked(true);
  }
  
  public ColorStateList e(int paramInt)
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
    localObject = E;
    int[] arrayOfInt1 = C;
    int[] arrayOfInt2 = ViewGroup.EMPTY_STATE_SET;
    int i2 = localColorStateList.getColorForState((int[])localObject, i1);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { i2, paramInt, i1 });
  }
  
  protected abstract a g(Context paramContext);
  
  SparseArray<com.google.android.material.badge.a> getBadgeDrawables()
  {
    return this.q;
  }
  
  public ColorStateList getIconTintList()
  {
    return this.i;
  }
  
  public ColorStateList getItemActiveIndicatorColor()
  {
    return this.z;
  }
  
  public boolean getItemActiveIndicatorEnabled()
  {
    return this.t;
  }
  
  public int getItemActiveIndicatorHeight()
  {
    return this.v;
  }
  
  public int getItemActiveIndicatorMarginHorizontal()
  {
    return this.w;
  }
  
  public m getItemActiveIndicatorShapeAppearance()
  {
    return this.x;
  }
  
  public int getItemActiveIndicatorWidth()
  {
    return this.u;
  }
  
  public Drawable getItemBackground()
  {
    a[] arrayOfa = this.f;
    if ((arrayOfa != null) && (arrayOfa.length > 0)) {
      return arrayOfa[0].getBackground();
    }
    return this.o;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.p;
  }
  
  public int getItemIconSize()
  {
    return this.j;
  }
  
  public int getItemPaddingBottom()
  {
    return this.s;
  }
  
  public int getItemPaddingTop()
  {
    return this.r;
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.n;
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.m;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.k;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.e;
  }
  
  protected androidx.appcompat.view.menu.e getMenu()
  {
    return this.B;
  }
  
  public int getSelectedItemId()
  {
    return this.g;
  }
  
  protected int getSelectedItemPosition()
  {
    return this.h;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public a h(int paramInt)
  {
    q(paramInt);
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        a locala = arrayOfa[i1];
        if (locala.getId() == paramInt) {
          return locala;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  com.google.android.material.badge.a i(int paramInt)
  {
    q(paramInt);
    Object localObject2 = (com.google.android.material.badge.a)this.q.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = com.google.android.material.badge.a.c(getContext());
      this.q.put(paramInt, localObject1);
    }
    localObject2 = h(paramInt);
    if (localObject2 != null) {
      ((a)localObject2).setBadge((com.google.android.material.badge.a)localObject1);
    }
    return localObject1;
  }
  
  protected boolean j(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      if (paramInt2 > 3) {
        return true;
      }
    }
    else if (paramInt1 == 0) {
      return true;
    }
    return false;
  }
  
  void l(int paramInt)
  {
    q(paramInt);
    com.google.android.material.badge.a locala = (com.google.android.material.badge.a)this.q.get(paramInt);
    a locala1 = h(paramInt);
    if (locala1 != null) {
      locala1.n();
    }
    if (locala != null) {
      this.q.remove(paramInt);
    }
  }
  
  void n(SparseArray<com.google.android.material.badge.a> paramSparseArray)
  {
    int i2 = 0;
    int i1 = 0;
    int i3;
    while (i1 < paramSparseArray.size())
    {
      i3 = paramSparseArray.keyAt(i1);
      if (this.q.indexOfKey(i3) < 0) {
        this.q.append(i3, paramSparseArray.get(i3));
      }
      i1 += 1;
    }
    paramSparseArray = this.f;
    if (paramSparseArray != null)
    {
      i3 = paramSparseArray.length;
      i1 = i2;
      while (i1 < i3)
      {
        Object localObject = paramSparseArray[i1];
        localObject.setBadge((com.google.android.material.badge.a)this.q.get(localObject.getId()));
        i1 += 1;
      }
    }
  }
  
  void o(int paramInt)
  {
    int i2 = this.B.size();
    int i1 = 0;
    while (i1 < i2)
    {
      MenuItem localMenuItem = this.B.getItem(i1);
      if (paramInt == localMenuItem.getItemId())
      {
        this.g = paramInt;
        this.h = i1;
        localMenuItem.setChecked(true);
        return;
      }
      i1 += 1;
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    d.J0(paramAccessibilityNodeInfo).e0(d.b.b(1, this.B.G().size(), false, 1));
  }
  
  public void p()
  {
    Object localObject = this.B;
    if (localObject != null)
    {
      if (this.f == null) {
        return;
      }
      int i2 = ((androidx.appcompat.view.menu.e)localObject).size();
      if (i2 != this.f.length)
      {
        d();
        return;
      }
      int i3 = this.g;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = this.B.getItem(i1);
        if (((MenuItem)localObject).isChecked())
        {
          this.g = ((MenuItem)localObject).getItemId();
          this.h = i1;
        }
        i1 += 1;
      }
      if (i3 != this.g)
      {
        localObject = this.a;
        if (localObject != null) {
          r.a(this, (Transition)localObject);
        }
      }
      boolean bool = j(this.e, this.B.G().size());
      i1 = 0;
      while (i1 < i2)
      {
        this.A.h(true);
        this.f[i1].setLabelVisibilityMode(this.e);
        this.f[i1].setShifting(bool);
        this.f[i1].j((androidx.appcompat.view.menu.g)this.B.getItem(i1), 0);
        this.A.h(false);
        i1 += 1;
      }
    }
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.i = paramColorStateList;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setIconTintList(paramColorStateList);
        i1 += 1;
      }
    }
  }
  
  public void setItemActiveIndicatorColor(ColorStateList paramColorStateList)
  {
    this.z = paramColorStateList;
    paramColorStateList = this.f;
    if (paramColorStateList != null)
    {
      int i2 = paramColorStateList.length;
      int i1 = 0;
      while (i1 < i2)
      {
        paramColorStateList[i1].setActiveIndicatorDrawable(f());
        i1 += 1;
      }
    }
  }
  
  public void setItemActiveIndicatorEnabled(boolean paramBoolean)
  {
    this.t = paramBoolean;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setActiveIndicatorEnabled(paramBoolean);
        i1 += 1;
      }
    }
  }
  
  public void setItemActiveIndicatorHeight(int paramInt)
  {
    this.v = paramInt;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setActiveIndicatorHeight(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void setItemActiveIndicatorMarginHorizontal(int paramInt)
  {
    this.w = paramInt;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setActiveIndicatorMarginHorizontal(paramInt);
        i1 += 1;
      }
    }
  }
  
  protected void setItemActiveIndicatorResizeable(boolean paramBoolean)
  {
    this.y = paramBoolean;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setActiveIndicatorResizeable(paramBoolean);
        i1 += 1;
      }
    }
  }
  
  public void setItemActiveIndicatorShapeAppearance(m paramm)
  {
    this.x = paramm;
    paramm = this.f;
    if (paramm != null)
    {
      int i2 = paramm.length;
      int i1 = 0;
      while (i1 < i2)
      {
        paramm[i1].setActiveIndicatorDrawable(f());
        i1 += 1;
      }
    }
  }
  
  public void setItemActiveIndicatorWidth(int paramInt)
  {
    this.u = paramInt;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setActiveIndicatorWidth(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.o = paramDrawable;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setItemBackground(paramDrawable);
        i1 += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    this.p = paramInt;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setItemBackground(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.j = paramInt;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setIconSize(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void setItemPaddingBottom(int paramInt)
  {
    this.s = paramInt;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setItemPaddingBottom(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void setItemPaddingTop(int paramInt)
  {
    this.r = paramInt;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setItemPaddingTop(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    this.n = paramInt;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        a locala = arrayOfa[i1];
        locala.setTextAppearanceActive(paramInt);
        ColorStateList localColorStateList = this.k;
        if (localColorStateList != null) {
          locala.setTextColor(localColorStateList);
        }
        i1 += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.m = paramInt;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        a locala = arrayOfa[i1];
        locala.setTextAppearanceInactive(paramInt);
        ColorStateList localColorStateList = this.k;
        if (localColorStateList != null) {
          locala.setTextColor(localColorStateList);
        }
        i1 += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.k = paramColorStateList;
    a[] arrayOfa = this.f;
    if (arrayOfa != null)
    {
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].setTextColor(paramColorStateList);
        i1 += 1;
      }
    }
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setPresenter(NavigationBarPresenter paramNavigationBarPresenter)
  {
    this.A = paramNavigationBarPresenter;
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      paramView = ((a)paramView).getItemData();
      if (!c.c(c.this).O(paramView, c.a(c.this), 0)) {
        paramView.setChecked(true);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.navigation.c
 * JD-Core Version:    0.7.0.1
 */