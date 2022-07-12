package com.google.android.material.chip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.a.b;
import com.google.android.material.internal.p;
import java.util.List;
import java.util.Set;
import y0.d;
import y0.d.b;

public class ChipGroup
  extends FlowLayout
{
  private static final int k = R.style.Widget_MaterialComponents_ChipGroup;
  private int e;
  private int f;
  private d g;
  private final com.google.android.material.internal.a<Chip> h;
  private final int i;
  private final e j;
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.chipGroupStyle);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, m), paramAttributeSet, paramInt);
    paramContext = new com.google.android.material.internal.a();
    this.h = paramContext;
    e locale = new e(null);
    this.j = locale;
    paramAttributeSet = p.h(getContext(), paramAttributeSet, R.styleable.ChipGroup, paramInt, m, new int[0]);
    paramInt = paramAttributeSet.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
    setChipSpacingHorizontal(paramAttributeSet.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, paramInt));
    setChipSpacingVertical(paramAttributeSet.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, paramInt));
    setSingleLine(paramAttributeSet.getBoolean(R.styleable.ChipGroup_singleLine, false));
    setSingleSelection(paramAttributeSet.getBoolean(R.styleable.ChipGroup_singleSelection, false));
    setSelectionRequired(paramAttributeSet.getBoolean(R.styleable.ChipGroup_selectionRequired, false));
    this.i = paramAttributeSet.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
    paramAttributeSet.recycle();
    paramContext.o(new a());
    super.setOnHierarchyChangeListener(locale);
    x.B0(this, 1);
  }
  
  private int getChipCount()
  {
    int m = 0;
    int i1;
    for (int n = 0; m < getChildCount(); n = i1)
    {
      i1 = n;
      if ((getChildAt(m) instanceof Chip)) {
        i1 = n + 1;
      }
      m += 1;
    }
    return n;
  }
  
  public boolean c()
  {
    return super.c();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  int g(View paramView)
  {
    if (!(paramView instanceof Chip)) {
      return -1;
    }
    int m = 0;
    int i1;
    for (int n = 0; m < getChildCount(); n = i1)
    {
      i1 = n;
      if ((getChildAt(m) instanceof Chip))
      {
        if ((Chip)getChildAt(m) == paramView) {
          return n;
        }
        i1 = n + 1;
      }
      m += 1;
    }
    return -1;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCheckedChipId()
  {
    return this.h.k();
  }
  
  public List<Integer> getCheckedChipIds()
  {
    return this.h.j(this);
  }
  
  public int getChipSpacingHorizontal()
  {
    return this.e;
  }
  
  public int getChipSpacingVertical()
  {
    return this.f;
  }
  
  public boolean h()
  {
    return this.h.l();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int m = this.i;
    if (m != -1) {
      this.h.f(m);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo = d.J0(paramAccessibilityNodeInfo);
    int m;
    if (c()) {
      m = getChipCount();
    } else {
      m = -1;
    }
    int i1 = getRowCount();
    int n;
    if (h()) {
      n = 1;
    } else {
      n = 2;
    }
    paramAccessibilityNodeInfo.e0(d.b.b(i1, m, false, n));
  }
  
  public void setChipSpacing(int paramInt)
  {
    setChipSpacingHorizontal(paramInt);
    setChipSpacingVertical(paramInt);
  }
  
  public void setChipSpacingHorizontal(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      setItemSpacing(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingHorizontalResource(int paramInt)
  {
    setChipSpacingHorizontal(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingResource(int paramInt)
  {
    setChipSpacing(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingVertical(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      setLineSpacing(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingVerticalResource(int paramInt)
  {
    setChipSpacingVertical(getResources().getDimensionPixelOffset(paramInt));
  }
  
  @Deprecated
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setFlexWrap(int paramInt)
  {
    throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
  }
  
  @Deprecated
  public void setOnCheckedChangeListener(final c paramc)
  {
    if (paramc == null)
    {
      setOnCheckedStateChangeListener(null);
      return;
    }
    setOnCheckedStateChangeListener(new b(paramc));
  }
  
  public void setOnCheckedStateChangeListener(d paramd)
  {
    this.g = paramd;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    e.a(this.j, paramOnHierarchyChangeListener);
  }
  
  public void setSelectionRequired(boolean paramBoolean)
  {
    this.h.p(paramBoolean);
  }
  
  @Deprecated
  public void setShowDividerHorizontal(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setShowDividerVertical(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setSingleLine(int paramInt)
  {
    setSingleLine(getResources().getBoolean(paramInt));
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    super.setSingleLine(paramBoolean);
  }
  
  public void setSingleSelection(int paramInt)
  {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    this.h.q(paramBoolean);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  class a
    implements a.b
  {
    a() {}
    
    public void a(Set<Integer> paramSet)
    {
      if (ChipGroup.e(ChipGroup.this) != null)
      {
        paramSet = ChipGroup.e(ChipGroup.this);
        ChipGroup localChipGroup = ChipGroup.this;
        paramSet.a(localChipGroup, ChipGroup.f(localChipGroup).j(ChipGroup.this));
      }
    }
  }
  
  class b
    implements ChipGroup.d
  {
    b(ChipGroup.c paramc) {}
    
    public void a(ChipGroup paramChipGroup, List<Integer> paramList)
    {
      if (!ChipGroup.f(ChipGroup.this).l()) {
        return;
      }
      paramc.a(paramChipGroup, ChipGroup.this.getCheckedChipId());
    }
  }
  
  @Deprecated
  public static abstract interface c
  {
    public abstract void a(ChipGroup paramChipGroup, int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void a(ChipGroup paramChipGroup, List<Integer> paramList);
  }
  
  private class e
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener a;
    
    private e() {}
    
    public void onChildViewAdded(View paramView1, View paramView2)
    {
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip)))
      {
        if (paramView2.getId() == -1) {
          paramView2.setId(x.k());
        }
        ChipGroup.f(ChipGroup.this).e((Chip)paramView2);
      }
      ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = this.a;
      if (localOnHierarchyChangeListener != null) {
        localOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public void onChildViewRemoved(View paramView1, View paramView2)
    {
      Object localObject = ChipGroup.this;
      if ((paramView1 == localObject) && ((paramView2 instanceof Chip))) {
        ChipGroup.f((ChipGroup)localObject).n((Chip)paramView2);
      }
      localObject = this.a;
      if (localObject != null) {
        ((ViewGroup.OnHierarchyChangeListener)localObject).onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.chip.ChipGroup
 * JD-Core Version:    0.7.0.1
 */