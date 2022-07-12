package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.j.a;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.m;
import androidx.core.view.h0;
import androidx.core.view.x;
import androidx.core.widget.l;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.o;
import com.google.android.material.R.dimen;
import com.google.android.material.R.layout;
import java.util.ArrayList;
import y0.d;
import y0.d.b;

public class i
  implements j
{
  int A;
  private int B = -1;
  final View.OnClickListener C = new a();
  private NavigationMenuView a;
  LinearLayout b;
  private j.a c;
  e d;
  private int e;
  c f;
  LayoutInflater g;
  int h = 0;
  ColorStateList i;
  int j = 0;
  ColorStateList k;
  ColorStateList l;
  Drawable m;
  RippleDrawable n;
  int o;
  int p;
  int q;
  int r;
  int s;
  int t;
  int u;
  int v;
  boolean w;
  boolean x = true;
  private int y;
  private int z;
  
  private void W()
  {
    int i1;
    if ((this.b.getChildCount() == 0) && (this.x)) {
      i1 = this.z;
    } else {
      i1 = 0;
    }
    NavigationMenuView localNavigationMenuView = this.a;
    localNavigationMenuView.setPadding(0, i1, 0, localNavigationMenuView.getPaddingBottom());
  }
  
  public int A()
  {
    return this.u;
  }
  
  public View B(int paramInt)
  {
    View localView = this.g.inflate(paramInt, this.b, false);
    c(localView);
    return localView;
  }
  
  public void C(boolean paramBoolean)
  {
    if (this.x != paramBoolean)
    {
      this.x = paramBoolean;
      W();
    }
  }
  
  public void D(g paramg)
  {
    this.f.R(paramg);
  }
  
  public void E(int paramInt)
  {
    this.t = paramInt;
    g(false);
  }
  
  public void F(int paramInt)
  {
    this.s = paramInt;
    g(false);
  }
  
  public void G(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void H(Drawable paramDrawable)
  {
    this.m = paramDrawable;
    g(false);
  }
  
  public void I(RippleDrawable paramRippleDrawable)
  {
    this.n = paramRippleDrawable;
    g(false);
  }
  
  public void J(int paramInt)
  {
    this.o = paramInt;
    g(false);
  }
  
  public void K(int paramInt)
  {
    this.q = paramInt;
    g(false);
  }
  
  public void L(int paramInt)
  {
    if (this.r != paramInt)
    {
      this.r = paramInt;
      this.w = true;
      g(false);
    }
  }
  
  public void M(ColorStateList paramColorStateList)
  {
    this.l = paramColorStateList;
    g(false);
  }
  
  public void N(int paramInt)
  {
    this.y = paramInt;
    g(false);
  }
  
  public void O(int paramInt)
  {
    this.j = paramInt;
    g(false);
  }
  
  public void P(ColorStateList paramColorStateList)
  {
    this.k = paramColorStateList;
    g(false);
  }
  
  public void Q(int paramInt)
  {
    this.p = paramInt;
    g(false);
  }
  
  public void R(int paramInt)
  {
    this.B = paramInt;
    NavigationMenuView localNavigationMenuView = this.a;
    if (localNavigationMenuView != null) {
      localNavigationMenuView.setOverScrollMode(paramInt);
    }
  }
  
  public void S(ColorStateList paramColorStateList)
  {
    this.i = paramColorStateList;
    g(false);
  }
  
  public void T(int paramInt)
  {
    this.u = paramInt;
    g(false);
  }
  
  public void U(int paramInt)
  {
    this.h = paramInt;
    g(false);
  }
  
  public void V(boolean paramBoolean)
  {
    c localc = this.f;
    if (localc != null) {
      localc.S(paramBoolean);
    }
  }
  
  public void b(e parame, boolean paramBoolean)
  {
    j.a locala = this.c;
    if (locala != null) {
      locala.b(parame, paramBoolean);
    }
  }
  
  public void c(View paramView)
  {
    this.b.addView(paramView);
    paramView = this.a;
    paramView.setPadding(0, 0, 0, paramView.getPaddingBottom());
  }
  
  public void d(Context paramContext, e parame)
  {
    this.g = LayoutInflater.from(paramContext);
    this.d = parame;
    this.A = paramContext.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
  }
  
  public void e(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject = paramParcelable.getSparseParcelableArray("android:menu:list");
      if (localObject != null) {
        this.a.restoreHierarchyState((SparseArray)localObject);
      }
      localObject = paramParcelable.getBundle("android:menu:adapter");
      if (localObject != null) {
        this.f.Q((Bundle)localObject);
      }
      paramParcelable = paramParcelable.getSparseParcelableArray("android:menu:header");
      if (paramParcelable != null) {
        this.b.restoreHierarchyState(paramParcelable);
      }
    }
  }
  
  public boolean f(m paramm)
  {
    return false;
  }
  
  public void g(boolean paramBoolean)
  {
    c localc = this.f;
    if (localc != null) {
      localc.T();
    }
  }
  
  public int getId()
  {
    return this.e;
  }
  
  public void h(h0 paramh0)
  {
    int i1 = paramh0.l();
    if (this.z != i1)
    {
      this.z = i1;
      W();
    }
    NavigationMenuView localNavigationMenuView = this.a;
    localNavigationMenuView.setPadding(0, localNavigationMenuView.getPaddingTop(), 0, paramh0.i());
    x.g(this.b, paramh0);
  }
  
  public boolean i()
  {
    return false;
  }
  
  public Parcelable j()
  {
    Bundle localBundle = new Bundle();
    if (this.a != null)
    {
      localObject = new SparseArray();
      this.a.saveHierarchyState((SparseArray)localObject);
      localBundle.putSparseParcelableArray("android:menu:list", (SparseArray)localObject);
    }
    Object localObject = this.f;
    if (localObject != null) {
      localBundle.putBundle("android:menu:adapter", ((c)localObject).J());
    }
    if (this.b != null)
    {
      localObject = new SparseArray();
      this.b.saveHierarchyState((SparseArray)localObject);
      localBundle.putSparseParcelableArray("android:menu:header", (SparseArray)localObject);
    }
    return localBundle;
  }
  
  public boolean k(e parame, g paramg)
  {
    return false;
  }
  
  public boolean l(e parame, g paramg)
  {
    return false;
  }
  
  public g n()
  {
    return this.f.K();
  }
  
  public int o()
  {
    return this.t;
  }
  
  public int p()
  {
    return this.s;
  }
  
  public int q()
  {
    return this.b.getChildCount();
  }
  
  public Drawable r()
  {
    return this.m;
  }
  
  public int s()
  {
    return this.o;
  }
  
  public int t()
  {
    return this.q;
  }
  
  public int u()
  {
    return this.y;
  }
  
  public ColorStateList v()
  {
    return this.k;
  }
  
  public ColorStateList w()
  {
    return this.l;
  }
  
  public int x()
  {
    return this.p;
  }
  
  public k y(ViewGroup paramViewGroup)
  {
    if (this.a == null)
    {
      paramViewGroup = (NavigationMenuView)this.g.inflate(R.layout.design_navigation_menu, paramViewGroup, false);
      this.a = paramViewGroup;
      paramViewGroup.setAccessibilityDelegateCompat(new h(this.a));
      if (this.f == null) {
        this.f = new c();
      }
      int i1 = this.B;
      if (i1 != -1) {
        this.a.setOverScrollMode(i1);
      }
      this.b = ((LinearLayout)this.g.inflate(R.layout.design_navigation_item_header, this.a, false));
      this.a.setAdapter(this.f);
    }
    return this.a;
  }
  
  public int z()
  {
    return this.v;
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      paramView = (NavigationMenuItemView)paramView;
      i locali = i.this;
      int i = 1;
      locali.V(true);
      paramView = paramView.getItemData();
      locali = i.this;
      boolean bool = locali.d.O(paramView, locali, 0);
      if ((paramView != null) && (paramView.isCheckable()) && (bool)) {
        i.this.f.R(paramView);
      } else {
        i = 0;
      }
      i.this.V(false);
      if (i != 0) {
        i.this.g(false);
      }
    }
  }
  
  private static class b
    extends i.l
  {
    public b(View paramView)
    {
      super();
    }
  }
  
  private class c
    extends RecyclerView.h<i.l>
  {
    private final ArrayList<i.e> d = new ArrayList();
    private g e;
    private boolean f;
    
    c()
    {
      P();
    }
    
    private void I(int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        ((i.g)this.d.get(paramInt1)).b = true;
        paramInt1 += 1;
      }
    }
    
    private void P()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:296)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public Bundle J()
    {
      Bundle localBundle = new Bundle();
      Object localObject = this.e;
      if (localObject != null) {
        localBundle.putInt("android:menu:checked", ((g)localObject).getItemId());
      }
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      int j = this.d.size();
      while (i < j)
      {
        localObject = (i.e)this.d.get(i);
        if ((localObject instanceof i.g))
        {
          g localg = ((i.g)localObject).a();
          if (localg != null) {
            localObject = localg.getActionView();
          } else {
            localObject = null;
          }
          if (localObject != null)
          {
            ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
            ((View)localObject).saveHierarchyState(localParcelableSparseArray);
            localSparseArray.put(localg.getItemId(), localParcelableSparseArray);
          }
        }
        i += 1;
      }
      localBundle.putSparseParcelableArray("android:menu:action_views", localSparseArray);
      return localBundle;
    }
    
    public g K()
    {
      return this.e;
    }
    
    int L()
    {
      int i = i.this.b.getChildCount();
      int j = 0;
      if (i == 0) {
        i = 0;
      }
      int k;
      for (i = 1; j < i.this.f.d(); i = k)
      {
        k = i;
        if (i.this.f.f(j) == 0) {
          k = i + 1;
        }
        j += 1;
      }
      return i;
    }
    
    public void M(i.l paraml, int paramInt)
    {
      int i = f(paramInt);
      Object localObject;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          localObject = (i.f)this.d.get(paramInt);
          paraml.a.setPadding(i.this.s, ((i.f)localObject).b(), i.this.t, ((i.f)localObject).a());
          return;
        }
        paraml = (TextView)paraml.a;
        paraml.setText(((i.g)this.d.get(paramInt)).a().getTitle());
        paramInt = i.this.h;
        if (paramInt != 0) {
          l.o(paraml, paramInt);
        }
        paraml.setPadding(i.this.u, paraml.getPaddingTop(), i.this.v, paraml.getPaddingBottom());
        localObject = i.this.i;
        if (localObject != null) {
          paraml.setTextColor((ColorStateList)localObject);
        }
      }
      else
      {
        localObject = (NavigationMenuItemView)paraml.a;
        ((NavigationMenuItemView)localObject).setIconTintList(i.this.l);
        i = i.this.j;
        if (i != 0) {
          ((NavigationMenuItemView)localObject).setTextAppearance(i);
        }
        paraml = i.this.k;
        if (paraml != null) {
          ((NavigationMenuItemView)localObject).setTextColor(paraml);
        }
        paraml = i.this.m;
        if (paraml != null) {
          paraml = paraml.getConstantState().newDrawable();
        } else {
          paraml = null;
        }
        x.u0((View)localObject, paraml);
        paraml = i.this.n;
        if (paraml != null) {
          ((ForegroundLinearLayout)localObject).setForeground(paraml.getConstantState().newDrawable());
        }
        paraml = (i.g)this.d.get(paramInt);
        ((NavigationMenuItemView)localObject).setNeedsEmptyIcon(paraml.b);
        i locali = i.this;
        paramInt = locali.o;
        i = locali.p;
        ((ViewGroup)localObject).setPadding(paramInt, i, paramInt, i);
        ((NavigationMenuItemView)localObject).setIconPadding(i.this.q);
        locali = i.this;
        if (locali.w) {
          ((NavigationMenuItemView)localObject).setIconSize(locali.r);
        }
        ((NavigationMenuItemView)localObject).setMaxLines(i.a(i.this));
        ((NavigationMenuItemView)localObject).j(paraml.a(), 0);
      }
    }
    
    public i.l N(ViewGroup paramViewGroup, int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return null;
            }
            return new i.b(i.this.b);
          }
          return new i.j(i.this.g, paramViewGroup);
        }
        return new i.k(i.this.g, paramViewGroup);
      }
      i locali = i.this;
      return new i.i(locali.g, paramViewGroup, locali.C);
    }
    
    public void O(i.l paraml)
    {
      if ((paraml instanceof i.i)) {
        ((NavigationMenuItemView)paraml.a).D();
      }
    }
    
    public void Q(Bundle paramBundle)
    {
      int j = 0;
      int k = paramBundle.getInt("android:menu:checked", 0);
      int i;
      Object localObject1;
      if (k != 0)
      {
        this.f = true;
        int m = this.d.size();
        i = 0;
        while (i < m)
        {
          localObject1 = (i.e)this.d.get(i);
          if ((localObject1 instanceof i.g))
          {
            localObject1 = ((i.g)localObject1).a();
            if ((localObject1 != null) && (((g)localObject1).getItemId() == k))
            {
              R((g)localObject1);
              break;
            }
          }
          i += 1;
        }
        this.f = false;
        P();
      }
      paramBundle = paramBundle.getSparseParcelableArray("android:menu:action_views");
      if (paramBundle != null)
      {
        k = this.d.size();
        i = j;
        while (i < k)
        {
          localObject1 = (i.e)this.d.get(i);
          if ((localObject1 instanceof i.g))
          {
            Object localObject2 = ((i.g)localObject1).a();
            if (localObject2 != null)
            {
              localObject1 = ((g)localObject2).getActionView();
              if (localObject1 != null)
              {
                localObject2 = (ParcelableSparseArray)paramBundle.get(((g)localObject2).getItemId());
                if (localObject2 != null) {
                  ((View)localObject1).restoreHierarchyState((SparseArray)localObject2);
                }
              }
            }
          }
          i += 1;
        }
      }
    }
    
    public void R(g paramg)
    {
      if (this.e != paramg)
      {
        if (!paramg.isCheckable()) {
          return;
        }
        g localg = this.e;
        if (localg != null) {
          localg.setChecked(false);
        }
        this.e = paramg;
        paramg.setChecked(true);
      }
    }
    
    public void S(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }
    
    public void T()
    {
      P();
      j();
    }
    
    public int d()
    {
      return this.d.size();
    }
    
    public long e(int paramInt)
    {
      return paramInt;
    }
    
    public int f(int paramInt)
    {
      i.e locale = (i.e)this.d.get(paramInt);
      if ((locale instanceof i.f)) {
        return 2;
      }
      if ((locale instanceof i.d)) {
        return 3;
      }
      if ((locale instanceof i.g))
      {
        if (((i.g)locale).a().hasSubMenu()) {
          return 1;
        }
        return 0;
      }
      throw new RuntimeException("Unknown item type.");
    }
  }
  
  private static class d
    implements i.e
  {}
  
  private static abstract interface e {}
  
  private static class f
    implements i.e
  {
    private final int a;
    private final int b;
    
    public f(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
    
    public int a()
    {
      return this.b;
    }
    
    public int b()
    {
      return this.a;
    }
  }
  
  private static class g
    implements i.e
  {
    private final g a;
    boolean b;
    
    g(g paramg)
    {
      this.a = paramg;
    }
    
    public g a()
    {
      return this.a;
    }
  }
  
  private class h
    extends o
  {
    h(RecyclerView paramRecyclerView)
    {
      super();
    }
    
    public void g(View paramView, d paramd)
    {
      super.g(paramView, paramd);
      paramd.e0(d.b.a(i.this.f.L(), 0, false));
    }
  }
  
  private static class i
    extends i.l
  {
    public i(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      this.a.setOnClickListener(paramOnClickListener);
    }
  }
  
  private static class j
    extends i.l
  {
    public j(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static class k
    extends i.l
  {
    public k(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static abstract class l
    extends RecyclerView.c0
  {
    public l(View paramView)
    {
      super();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.i
 * JD-Core Version:    0.7.0.1
 */