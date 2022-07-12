package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.R.attr;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.k.a;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.appcompat.widget.n0;
import androidx.core.view.x;
import androidx.core.widget.l;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import p0.h;
import y0.d;

public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements k.a
{
  private static final int[] G = { 16842912 };
  private g A;
  private ColorStateList B;
  private boolean C;
  private Drawable E;
  private final androidx.core.view.a F;
  private int v;
  private boolean w;
  boolean x;
  private final CheckedTextView y;
  private FrameLayout z;
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new a();
    this.F = paramAttributeSet;
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(R.layout.design_navigation_menu_item, this, true);
    setIconSize(paramContext.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
    paramContext = (CheckedTextView)findViewById(R.id.design_menu_item_text);
    this.y = paramContext;
    paramContext.setDuplicateParentStateEnabled(true);
    x.q0(paramContext, paramAttributeSet);
  }
  
  private void B()
  {
    Object localObject;
    int i;
    if (E())
    {
      this.y.setVisibility(8);
      localObject = this.z;
      if (localObject == null) {
        return;
      }
      localObject = (LinearLayoutCompat.LayoutParams)((FrameLayout)localObject).getLayoutParams();
      i = -1;
    }
    else
    {
      this.y.setVisibility(0);
      localObject = this.z;
      if (localObject == null) {
        return;
      }
      localObject = (LinearLayoutCompat.LayoutParams)((FrameLayout)localObject).getLayoutParams();
      i = -2;
    }
    ((LinearLayout.LayoutParams)localObject).width = i;
    this.z.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private StateListDrawable C()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(G, new ColorDrawable(localTypedValue.data));
      localStateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
      return localStateListDrawable;
    }
    return null;
  }
  
  private boolean E()
  {
    return (this.A.getTitle() == null) && (this.A.getIcon() == null) && (this.A.getActionView() != null);
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.z == null) {
        this.z = ((FrameLayout)((ViewStub)findViewById(R.id.design_menu_item_action_area_stub)).inflate());
      }
      this.z.removeAllViews();
      this.z.addView(paramView);
    }
  }
  
  public void D()
  {
    FrameLayout localFrameLayout = this.z;
    if (localFrameLayout != null) {
      localFrameLayout.removeAllViews();
    }
    this.y.setCompoundDrawables(null, null, null, null);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public g getItemData()
  {
    return this.A;
  }
  
  public void j(g paramg, int paramInt)
  {
    this.A = paramg;
    if (paramg.getItemId() > 0) {
      setId(paramg.getItemId());
    }
    if (paramg.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    if (getBackground() == null) {
      x.u0(this, C());
    }
    setCheckable(paramg.isCheckable());
    setChecked(paramg.isChecked());
    setEnabled(paramg.isEnabled());
    setTitle(paramg.getTitle());
    setIcon(paramg.getIcon());
    setActionView(paramg.getActionView());
    setContentDescription(paramg.getContentDescription());
    n0.a(this, paramg.getTooltipText());
    B();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    g localg = this.A;
    if ((localg != null) && (localg.isCheckable()) && (this.A.isChecked())) {
      ViewGroup.mergeDrawableStates(arrayOfInt, G);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.x != paramBoolean)
    {
      this.x = paramBoolean;
      this.F.l(this.y, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.y.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    setPadding(paramInt, getPaddingTop(), paramInt, getPaddingBottom());
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if (paramDrawable != null)
    {
      Object localObject = paramDrawable;
      if (this.C)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject != null) {
          paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
        }
        localObject = r0.a.r(paramDrawable).mutate();
        r0.a.o((Drawable)localObject, this.B);
      }
      i = this.v;
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramDrawable = (Drawable)localObject;
    }
    else if (this.w)
    {
      if (this.E == null)
      {
        paramDrawable = h.e(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
        this.E = paramDrawable;
        if (paramDrawable != null)
        {
          i = this.v;
          paramDrawable.setBounds(0, 0, i, i);
        }
      }
      paramDrawable = this.E;
    }
    l.j(this.y, paramDrawable, null, null, null);
  }
  
  public void setIconPadding(int paramInt)
  {
    this.y.setCompoundDrawablePadding(paramInt);
  }
  
  public void setIconSize(int paramInt)
  {
    this.v = paramInt;
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.B = paramColorStateList;
    boolean bool;
    if (paramColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.C = bool;
    paramColorStateList = this.A;
    if (paramColorStateList != null) {
      setIcon(paramColorStateList.getIcon());
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    this.y.setMaxLines(paramInt);
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    l.o(this.y, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.y.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.y.setText(paramCharSequence);
  }
  
  class a
    extends androidx.core.view.a
  {
    a() {}
    
    public void g(View paramView, d paramd)
    {
      super.g(paramView, paramd);
      paramd.a0(NavigationMenuItemView.this.x);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */