package com.google.android.material.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.view.h;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import com.google.android.material.internal.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import r7.c;
import r7.m;
import r7.m.b;
import y0.d;
import y0.d.b;
import y0.d.c;

public class MaterialButtonToggleGroup
  extends LinearLayout
{
  private static final String k = MaterialButtonToggleGroup.class.getSimpleName();
  private static final int l = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
  private final List<c> a = new ArrayList();
  private final e b = new e(null);
  private final LinkedHashSet<d> c = new LinkedHashSet();
  private final Comparator<MaterialButton> d = new a();
  private Integer[] e;
  private boolean f = false;
  private boolean g;
  private boolean h;
  private final int i;
  private Set<Integer> j = new HashSet();
  
  public MaterialButtonToggleGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialButtonToggleGroupStyle);
  }
  
  public MaterialButtonToggleGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, m), paramAttributeSet, paramInt);
    paramContext = p.h(getContext(), paramAttributeSet, R.styleable.MaterialButtonToggleGroup, paramInt, m, new int[0]);
    setSingleSelection(paramContext.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
    this.i = paramContext.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
    this.h = paramContext.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
    setChildrenDrawingOrderEnabled(true);
    paramContext.recycle();
    x.B0(this, 1);
  }
  
  private void c()
  {
    int n = getFirstVisibleChildIndex();
    if (n == -1) {
      return;
    }
    int m = n + 1;
    while (m < getChildCount())
    {
      MaterialButton localMaterialButton = h(m);
      Object localObject = h(m - 1);
      int i1 = Math.min(localMaterialButton.getStrokeWidth(), ((MaterialButton)localObject).getStrokeWidth());
      localObject = d(localMaterialButton);
      if (getOrientation() == 0)
      {
        h.c((ViewGroup.MarginLayoutParams)localObject, 0);
        h.d((ViewGroup.MarginLayoutParams)localObject, -i1);
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      }
      else
      {
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = (-i1);
        h.d((ViewGroup.MarginLayoutParams)localObject, 0);
      }
      localMaterialButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      m += 1;
    }
    n(n);
  }
  
  private LinearLayout.LayoutParams d(View paramView)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof LinearLayout.LayoutParams)) {
      return (LinearLayout.LayoutParams)paramView;
    }
    return new LinearLayout.LayoutParams(paramView.width, paramView.height);
  }
  
  private void e(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1)
    {
      localObject = k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Button ID is not valid: ");
      localStringBuilder.append(paramInt);
      Log.e((String)localObject, localStringBuilder.toString());
      return;
    }
    Object localObject = new HashSet(this.j);
    if ((paramBoolean) && (!((Set)localObject).contains(Integer.valueOf(paramInt))))
    {
      if ((this.g) && (!((Set)localObject).isEmpty())) {
        ((Set)localObject).clear();
      }
      ((Set)localObject).add(Integer.valueOf(paramInt));
    }
    else
    {
      if ((paramBoolean) || (!((Set)localObject).contains(Integer.valueOf(paramInt)))) {
        return;
      }
      if ((!this.h) || (((Set)localObject).size() > 1)) {
        ((Set)localObject).remove(Integer.valueOf(paramInt));
      }
    }
    q((Set)localObject);
  }
  
  private void g(int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).a(this, paramInt, paramBoolean);
    }
  }
  
  private int getFirstVisibleChildIndex()
  {
    int n = getChildCount();
    int m = 0;
    while (m < n)
    {
      if (k(m)) {
        return m;
      }
      m += 1;
    }
    return -1;
  }
  
  private int getLastVisibleChildIndex()
  {
    int m = getChildCount() - 1;
    while (m >= 0)
    {
      if (k(m)) {
        return m;
      }
      m -= 1;
    }
    return -1;
  }
  
  private int getVisibleButtonCount()
  {
    int m = 0;
    int i1;
    for (int n = 0; m < getChildCount(); n = i1)
    {
      i1 = n;
      if ((getChildAt(m) instanceof MaterialButton))
      {
        i1 = n;
        if (k(m)) {
          i1 = n + 1;
        }
      }
      m += 1;
    }
    return n;
  }
  
  private MaterialButton h(int paramInt)
  {
    return (MaterialButton)getChildAt(paramInt);
  }
  
  private int i(View paramView)
  {
    if (!(paramView instanceof MaterialButton)) {
      return -1;
    }
    int m = 0;
    int i1;
    for (int n = 0; m < getChildCount(); n = i1)
    {
      if (getChildAt(m) == paramView) {
        return n;
      }
      i1 = n;
      if ((getChildAt(m) instanceof MaterialButton))
      {
        i1 = n;
        if (k(m)) {
          i1 = n + 1;
        }
      }
      m += 1;
    }
    return -1;
  }
  
  private c j(int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = (c)this.a.get(paramInt1);
    if (paramInt2 == paramInt3) {
      return localc;
    }
    int m;
    if (getOrientation() == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (paramInt1 == paramInt2)
    {
      if (m != 0) {
        return c.e(localc, this);
      }
      return c.f(localc);
    }
    if (paramInt1 == paramInt3)
    {
      if (m != 0) {
        return c.b(localc, this);
      }
      return c.a(localc);
    }
    return null;
  }
  
  private boolean k(int paramInt)
  {
    return getChildAt(paramInt).getVisibility() != 8;
  }
  
  private void n(int paramInt)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == -1) {
        return;
      }
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)h(paramInt).getLayoutParams();
      if (getOrientation() == 1)
      {
        localLayoutParams.topMargin = 0;
        localLayoutParams.bottomMargin = 0;
        return;
      }
      h.c(localLayoutParams, 0);
      h.d(localLayoutParams, 0);
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
    }
  }
  
  private void o(int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView instanceof MaterialButton))
    {
      this.f = true;
      ((MaterialButton)localView).setChecked(paramBoolean);
      this.f = false;
    }
  }
  
  private static void p(m.b paramb, c paramc)
  {
    if (paramc == null)
    {
      paramb.o(0.0F);
      return;
    }
    paramb.F(paramc.a).w(paramc.d).J(paramc.b).A(paramc.c);
  }
  
  private void q(Set<Integer> paramSet)
  {
    Set localSet = this.j;
    this.j = new HashSet(paramSet);
    int m = 0;
    while (m < getChildCount())
    {
      int n = h(m).getId();
      o(n, paramSet.contains(Integer.valueOf(n)));
      if (localSet.contains(Integer.valueOf(n)) != paramSet.contains(Integer.valueOf(n))) {
        g(n, paramSet.contains(Integer.valueOf(n)));
      }
      m += 1;
    }
    invalidate();
  }
  
  private void r()
  {
    TreeMap localTreeMap = new TreeMap(this.d);
    int n = getChildCount();
    int m = 0;
    while (m < n)
    {
      localTreeMap.put(h(m), Integer.valueOf(m));
      m += 1;
    }
    this.e = ((Integer[])localTreeMap.values().toArray(new Integer[0]));
  }
  
  private void setGeneratedIdIfNeeded(MaterialButton paramMaterialButton)
  {
    if (paramMaterialButton.getId() == -1) {
      paramMaterialButton.setId(x.k());
    }
  }
  
  private void setupButtonChild(MaterialButton paramMaterialButton)
  {
    paramMaterialButton.setMaxLines(1);
    paramMaterialButton.setEllipsize(TextUtils.TruncateAt.END);
    paramMaterialButton.setCheckable(true);
    paramMaterialButton.setOnPressedChangeListenerInternal(this.b);
    paramMaterialButton.setShouldDrawSurfaceColorStroke(true);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!(paramView instanceof MaterialButton))
    {
      Log.e(k, "Child views must be of type MaterialButton.");
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    paramView = (MaterialButton)paramView;
    setGeneratedIdIfNeeded(paramView);
    setupButtonChild(paramView);
    e(paramView.getId(), paramView.isChecked());
    paramLayoutParams = paramView.getShapeAppearanceModel();
    this.a.add(new c(paramLayoutParams.r(), paramLayoutParams.j(), paramLayoutParams.t(), paramLayoutParams.l()));
    x.q0(paramView, new b());
  }
  
  public void b(d paramd)
  {
    this.c.add(paramd);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    r();
    super.dispatchDraw(paramCanvas);
  }
  
  public void f()
  {
    q(new HashSet());
  }
  
  public int getCheckedButtonId()
  {
    if ((this.g) && (!this.j.isEmpty())) {
      return ((Integer)this.j.iterator().next()).intValue();
    }
    return -1;
  }
  
  public List<Integer> getCheckedButtonIds()
  {
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    while (m < getChildCount())
    {
      int n = h(m).getId();
      if (this.j.contains(Integer.valueOf(n))) {
        localArrayList.add(Integer.valueOf(n));
      }
      m += 1;
    }
    return localArrayList;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    Integer[] arrayOfInteger = this.e;
    if ((arrayOfInteger != null) && (paramInt2 < arrayOfInteger.length)) {
      return arrayOfInteger[paramInt2].intValue();
    }
    Log.w(k, "Child order wasn't updated");
    return paramInt2;
  }
  
  public boolean l()
  {
    return this.g;
  }
  
  void m(MaterialButton paramMaterialButton, boolean paramBoolean)
  {
    if (this.f) {
      return;
    }
    e(paramMaterialButton.getId(), paramBoolean);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int m = this.i;
    if (m != -1) {
      q(Collections.singleton(Integer.valueOf(m)));
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo = d.J0(paramAccessibilityNodeInfo);
    int n = getVisibleButtonCount();
    int m;
    if (l()) {
      m = 1;
    } else {
      m = 2;
    }
    paramAccessibilityNodeInfo.e0(d.b.b(1, n, false, m));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    s();
    c();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    if ((paramView instanceof MaterialButton)) {
      ((MaterialButton)paramView).setOnPressedChangeListenerInternal(null);
    }
    int m = indexOfChild(paramView);
    if (m >= 0) {
      this.a.remove(m);
    }
    s();
    c();
  }
  
  void s()
  {
    int n = getChildCount();
    int i1 = getFirstVisibleChildIndex();
    int i2 = getLastVisibleChildIndex();
    int m = 0;
    while (m < n)
    {
      MaterialButton localMaterialButton = h(m);
      if (localMaterialButton.getVisibility() != 8)
      {
        m.b localb = localMaterialButton.getShapeAppearanceModel().v();
        p(localb, j(m, i1, i2));
        localMaterialButton.setShapeAppearanceModel(localb.m());
      }
      m += 1;
    }
  }
  
  public void setSelectionRequired(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setSingleSelection(int paramInt)
  {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      f();
    }
  }
  
  class a
    implements Comparator<MaterialButton>
  {
    a() {}
    
    public int a(MaterialButton paramMaterialButton1, MaterialButton paramMaterialButton2)
    {
      int i = Boolean.valueOf(paramMaterialButton1.isChecked()).compareTo(Boolean.valueOf(paramMaterialButton2.isChecked()));
      if (i != 0) {
        return i;
      }
      i = Boolean.valueOf(paramMaterialButton1.isPressed()).compareTo(Boolean.valueOf(paramMaterialButton2.isPressed()));
      if (i != 0) {
        return i;
      }
      return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(paramMaterialButton1)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(paramMaterialButton2)));
    }
  }
  
  class b
    extends androidx.core.view.a
  {
    b() {}
    
    public void g(View paramView, d paramd)
    {
      super.g(paramView, paramd);
      paramd.f0(d.c.a(0, 1, MaterialButtonToggleGroup.a(MaterialButtonToggleGroup.this, paramView), 1, false, ((MaterialButton)paramView).isChecked()));
    }
  }
  
  private static class c
  {
    private static final c e = new r7.a(0.0F);
    c a;
    c b;
    c c;
    c d;
    
    c(c paramc1, c paramc2, c paramc3, c paramc4)
    {
      this.a = paramc1;
      this.b = paramc3;
      this.c = paramc4;
      this.d = paramc2;
    }
    
    public static c a(c paramc)
    {
      c localc = e;
      return new c(localc, paramc.d, localc, paramc.c);
    }
    
    public static c b(c paramc, View paramView)
    {
      if (t.i(paramView)) {
        return c(paramc);
      }
      return d(paramc);
    }
    
    public static c c(c paramc)
    {
      c localc1 = paramc.a;
      paramc = paramc.d;
      c localc2 = e;
      return new c(localc1, paramc, localc2, localc2);
    }
    
    public static c d(c paramc)
    {
      c localc = e;
      return new c(localc, localc, paramc.b, paramc.c);
    }
    
    public static c e(c paramc, View paramView)
    {
      if (t.i(paramView)) {
        return d(paramc);
      }
      return c(paramc);
    }
    
    public static c f(c paramc)
    {
      c localc1 = paramc.a;
      c localc2 = e;
      return new c(localc1, localc2, paramc.b, localc2);
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(MaterialButtonToggleGroup paramMaterialButtonToggleGroup, int paramInt, boolean paramBoolean);
  }
  
  private class e
    implements MaterialButton.b
  {
    private e() {}
    
    public void a(MaterialButton paramMaterialButton, boolean paramBoolean)
    {
      MaterialButtonToggleGroup.this.invalidate();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.button.MaterialButtonToggleGroup
 * JD-Core Version:    0.7.0.1
 */