package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.e.a;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.k0;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R.dimen;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import g.g;
import r7.h;
import r7.i;
import r7.m;
import r7.m.b;

public abstract class NavigationBarView
  extends FrameLayout
{
  private final b a;
  private final c b;
  private final NavigationBarPresenter c;
  private ColorStateList d;
  private MenuInflater e;
  private c f;
  private b g;
  
  public NavigationBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt1, paramInt2), paramAttributeSet, paramInt1);
    paramContext = new NavigationBarPresenter();
    this.c = paramContext;
    Context localContext = getContext();
    Object localObject = R.styleable.NavigationBarView;
    int i = R.styleable.NavigationBarView_itemTextAppearanceInactive;
    int j = R.styleable.NavigationBarView_itemTextAppearanceActive;
    paramAttributeSet = p.i(localContext, paramAttributeSet, (int[])localObject, paramInt1, paramInt2, new int[] { i, j });
    localObject = new b(localContext, getClass(), getMaxItemCount());
    this.a = ((b)localObject);
    c localc = d(localContext);
    this.b = localc;
    paramContext.c(localc);
    paramContext.a(1);
    localc.setPresenter(paramContext);
    ((e)localObject).b(paramContext);
    paramContext.d(getContext(), (e)localObject);
    paramInt1 = R.styleable.NavigationBarView_itemIconTint;
    if (paramAttributeSet.s(paramInt1)) {
      paramContext = paramAttributeSet.c(paramInt1);
    } else {
      paramContext = localc.e(16842808);
    }
    localc.setIconTintList(paramContext);
    setItemIconSize(paramAttributeSet.f(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
    if (paramAttributeSet.s(i)) {
      setItemTextAppearanceInactive(paramAttributeSet.n(i, 0));
    }
    if (paramAttributeSet.s(j)) {
      setItemTextAppearanceActive(paramAttributeSet.n(j, 0));
    }
    paramInt1 = R.styleable.NavigationBarView_itemTextColor;
    if (paramAttributeSet.s(paramInt1)) {
      setItemTextColor(paramAttributeSet.c(paramInt1));
    }
    if ((getBackground() == null) || ((getBackground() instanceof ColorDrawable))) {
      x.u0(this, c(localContext));
    }
    paramInt1 = R.styleable.NavigationBarView_itemPaddingTop;
    if (paramAttributeSet.s(paramInt1)) {
      setItemPaddingTop(paramAttributeSet.f(paramInt1, 0));
    }
    paramInt1 = R.styleable.NavigationBarView_itemPaddingBottom;
    if (paramAttributeSet.s(paramInt1)) {
      setItemPaddingBottom(paramAttributeSet.f(paramInt1, 0));
    }
    paramInt1 = R.styleable.NavigationBarView_elevation;
    if (paramAttributeSet.s(paramInt1)) {
      setElevation(paramAttributeSet.f(paramInt1, 0));
    }
    paramContext = o7.c.b(localContext, paramAttributeSet, R.styleable.NavigationBarView_backgroundTint);
    r0.a.o(getBackground().mutate(), paramContext);
    setLabelVisibilityMode(paramAttributeSet.l(R.styleable.NavigationBarView_labelVisibilityMode, -1));
    paramInt1 = paramAttributeSet.n(R.styleable.NavigationBarView_itemBackground, 0);
    if (paramInt1 != 0) {
      localc.setItemBackgroundRes(paramInt1);
    } else {
      setItemRippleColor(o7.c.b(localContext, paramAttributeSet, R.styleable.NavigationBarView_itemRippleColor));
    }
    paramInt1 = paramAttributeSet.n(R.styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
    if (paramInt1 != 0)
    {
      setItemActiveIndicatorEnabled(true);
      paramContext = localContext.obtainStyledAttributes(paramInt1, R.styleable.NavigationBarActiveIndicator);
      setItemActiveIndicatorWidth(paramContext.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_width, 0));
      setItemActiveIndicatorHeight(paramContext.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_height, 0));
      setItemActiveIndicatorMarginHorizontal(paramContext.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
      setItemActiveIndicatorColor(o7.c.a(localContext, paramContext, R.styleable.NavigationBarActiveIndicator_android_color));
      setItemActiveIndicatorShapeAppearance(m.b(localContext, paramContext.getResourceId(R.styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).m());
      paramContext.recycle();
    }
    paramInt1 = R.styleable.NavigationBarView_menu;
    if (paramAttributeSet.s(paramInt1)) {
      f(paramAttributeSet.n(paramInt1, 0));
    }
    paramAttributeSet.w();
    addView(localc);
    ((e)localObject).V(new a());
  }
  
  private h c(Context paramContext)
  {
    h localh = new h();
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof ColorDrawable)) {
      localh.b0(ColorStateList.valueOf(((ColorDrawable)localDrawable).getColor()));
    }
    localh.Q(paramContext);
    return localh;
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.e == null) {
      this.e = new g(getContext());
    }
    return this.e;
  }
  
  protected abstract c d(Context paramContext);
  
  public com.google.android.material.badge.a e(int paramInt)
  {
    return this.b.i(paramInt);
  }
  
  public void f(int paramInt)
  {
    this.c.h(true);
    getMenuInflater().inflate(paramInt, this.a);
    this.c.h(false);
    this.c.g(true);
  }
  
  public void g(int paramInt)
  {
    this.b.l(paramInt);
  }
  
  public ColorStateList getItemActiveIndicatorColor()
  {
    return this.b.getItemActiveIndicatorColor();
  }
  
  public int getItemActiveIndicatorHeight()
  {
    return this.b.getItemActiveIndicatorHeight();
  }
  
  public int getItemActiveIndicatorMarginHorizontal()
  {
    return this.b.getItemActiveIndicatorMarginHorizontal();
  }
  
  public m getItemActiveIndicatorShapeAppearance()
  {
    return this.b.getItemActiveIndicatorShapeAppearance();
  }
  
  public int getItemActiveIndicatorWidth()
  {
    return this.b.getItemActiveIndicatorWidth();
  }
  
  public Drawable getItemBackground()
  {
    return this.b.getItemBackground();
  }
  
  @Deprecated
  public int getItemBackgroundResource()
  {
    return this.b.getItemBackgroundRes();
  }
  
  public int getItemIconSize()
  {
    return this.b.getItemIconSize();
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.b.getIconTintList();
  }
  
  public int getItemPaddingBottom()
  {
    return this.b.getItemPaddingBottom();
  }
  
  public int getItemPaddingTop()
  {
    return this.b.getItemPaddingTop();
  }
  
  public ColorStateList getItemRippleColor()
  {
    return this.d;
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.b.getItemTextAppearanceActive();
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.b.getItemTextAppearanceInactive();
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.b.getItemTextColor();
  }
  
  public int getLabelVisibilityMode()
  {
    return this.b.getLabelVisibilityMode();
  }
  
  public abstract int getMaxItemCount();
  
  public Menu getMenu()
  {
    return this.a;
  }
  
  public k getMenuView()
  {
    return this.b;
  }
  
  public NavigationBarPresenter getPresenter()
  {
    return this.c;
  }
  
  public int getSelectedItemId()
  {
    return this.b.getSelectedItemId();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    i.e(this);
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
    this.a.S(paramParcelable.c);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Bundle localBundle = new Bundle();
    localSavedState.c = localBundle;
    this.a.U(localBundle);
    return localSavedState;
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    i.d(this, paramFloat);
  }
  
  public void setItemActiveIndicatorColor(ColorStateList paramColorStateList)
  {
    this.b.setItemActiveIndicatorColor(paramColorStateList);
  }
  
  public void setItemActiveIndicatorEnabled(boolean paramBoolean)
  {
    this.b.setItemActiveIndicatorEnabled(paramBoolean);
  }
  
  public void setItemActiveIndicatorHeight(int paramInt)
  {
    this.b.setItemActiveIndicatorHeight(paramInt);
  }
  
  public void setItemActiveIndicatorMarginHorizontal(int paramInt)
  {
    this.b.setItemActiveIndicatorMarginHorizontal(paramInt);
  }
  
  public void setItemActiveIndicatorShapeAppearance(m paramm)
  {
    this.b.setItemActiveIndicatorShapeAppearance(paramm);
  }
  
  public void setItemActiveIndicatorWidth(int paramInt)
  {
    this.b.setItemActiveIndicatorWidth(paramInt);
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.b.setItemBackground(paramDrawable);
    this.d = null;
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    this.b.setItemBackgroundRes(paramInt);
    this.d = null;
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.b.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.b.setIconTintList(paramColorStateList);
  }
  
  public void setItemPaddingBottom(int paramInt)
  {
    this.b.setItemPaddingBottom(paramInt);
  }
  
  public void setItemPaddingTop(int paramInt)
  {
    this.b.setItemPaddingTop(paramInt);
  }
  
  public void setItemRippleColor(ColorStateList paramColorStateList)
  {
    if (this.d == paramColorStateList)
    {
      if ((paramColorStateList == null) && (this.b.getItemBackground() != null)) {
        this.b.setItemBackground(null);
      }
      return;
    }
    this.d = paramColorStateList;
    if (paramColorStateList == null)
    {
      this.b.setItemBackground(null);
      return;
    }
    paramColorStateList = p7.b.a(paramColorStateList);
    this.b.setItemBackground(new RippleDrawable(paramColorStateList, null, null));
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    this.b.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.b.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.b.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.b.getLabelVisibilityMode() != paramInt)
    {
      this.b.setLabelVisibilityMode(paramInt);
      this.c.g(false);
    }
  }
  
  public void setOnItemReselectedListener(b paramb)
  {
    this.g = paramb;
  }
  
  public void setOnItemSelectedListener(c paramc)
  {
    this.f = paramc;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    MenuItem localMenuItem = this.a.findItem(paramInt);
    if ((localMenuItem != null) && (!this.a.O(localMenuItem, this.c, 0))) {
      localMenuItem.setChecked(true);
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    Bundle c;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      h(paramParcel, localClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    private void h(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      this.c = paramParcel.readBundle(paramClassLoader);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.c);
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<NavigationBarView.SavedState>
    {
      public NavigationBarView.SavedState a(Parcel paramParcel)
      {
        return new NavigationBarView.SavedState(paramParcel, null);
      }
      
      public NavigationBarView.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new NavigationBarView.SavedState(paramParcel, paramClassLoader);
      }
      
      public NavigationBarView.SavedState[] c(int paramInt)
      {
        return new NavigationBarView.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements e.a
  {
    a() {}
    
    public boolean a(e parame, MenuItem paramMenuItem)
    {
      if ((NavigationBarView.a(NavigationBarView.this) != null) && (paramMenuItem.getItemId() == NavigationBarView.this.getSelectedItemId()))
      {
        NavigationBarView.a(NavigationBarView.this).a(paramMenuItem);
        return true;
      }
      return (NavigationBarView.b(NavigationBarView.this) != null) && (!NavigationBarView.b(NavigationBarView.this).c(paramMenuItem));
    }
    
    public void b(e parame) {}
  }
  
  public static abstract interface b
  {
    public abstract void a(MenuItem paramMenuItem);
  }
  
  public static abstract interface c
  {
    public abstract boolean c(MenuItem paramMenuItem);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.navigation.NavigationBarView
 * JD-Core Version:    0.7.0.1
 */