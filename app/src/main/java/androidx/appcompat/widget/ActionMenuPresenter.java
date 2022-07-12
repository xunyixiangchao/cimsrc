package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ActionMenuItemView.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j.a;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.k.a;
import androidx.appcompat.view.menu.m;
import androidx.core.view.b;
import androidx.core.view.b.a;
import java.util.ArrayList;

class ActionMenuPresenter
  extends androidx.appcompat.view.menu.a
  implements b.a
{
  c A;
  private b B;
  final f C = new f();
  int E;
  d k;
  private Drawable l;
  private boolean m;
  private boolean n;
  private boolean o;
  private int p;
  private int q;
  private int r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private int w;
  private final SparseBooleanArray x = new SparseBooleanArray();
  e y;
  a z;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  private View C(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.i;
    if (localViewGroup == null) {
      return null;
    }
    int j = localViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localViewGroup.getChildAt(i);
      if (((localView instanceof k.a)) && (((k.a)localView).getItemData() == paramMenuItem)) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean B()
  {
    return E() | F();
  }
  
  public Drawable D()
  {
    d locald = this.k;
    if (locald != null) {
      return locald.getDrawable();
    }
    if (this.m) {
      return this.l;
    }
    return null;
  }
  
  public boolean E()
  {
    Object localObject = this.A;
    if (localObject != null)
    {
      k localk = this.i;
      if (localk != null)
      {
        ((View)localk).removeCallbacks((Runnable)localObject);
        this.A = null;
        return true;
      }
    }
    localObject = this.y;
    if (localObject != null)
    {
      ((i)localObject).b();
      return true;
    }
    return false;
  }
  
  public boolean F()
  {
    a locala = this.z;
    if (locala != null)
    {
      locala.b();
      return true;
    }
    return false;
  }
  
  public boolean G()
  {
    return (this.A != null) || (H());
  }
  
  public boolean H()
  {
    e locale = this.y;
    return (locale != null) && (locale.d());
  }
  
  public void I(Configuration paramConfiguration)
  {
    if (!this.s) {
      this.r = g.a.b(this.b).d();
    }
    paramConfiguration = this.c;
    if (paramConfiguration != null) {
      paramConfiguration.M(true);
    }
  }
  
  public void J(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void K(ActionMenuView paramActionMenuView)
  {
    this.i = paramActionMenuView;
    paramActionMenuView.b(this.c);
  }
  
  public void L(Drawable paramDrawable)
  {
    d locald = this.k;
    if (locald != null)
    {
      locald.setImageDrawable(paramDrawable);
      return;
    }
    this.m = true;
    this.l = paramDrawable;
  }
  
  public void M(boolean paramBoolean)
  {
    this.n = paramBoolean;
    this.o = true;
  }
  
  public boolean N()
  {
    if ((this.n) && (!H()))
    {
      Object localObject = this.c;
      if ((localObject != null) && (this.i != null) && (this.A == null) && (!((androidx.appcompat.view.menu.e)localObject).B().isEmpty()))
      {
        localObject = new c(new e(this.b, this.c, this.k, true));
        this.A = ((c)localObject);
        ((View)this.i).post((Runnable)localObject);
        return true;
      }
    }
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.f(null);
      return;
    }
    androidx.appcompat.view.menu.e locale = this.c;
    if (locale != null) {
      locale.e(false);
    }
  }
  
  public void b(androidx.appcompat.view.menu.e parame, boolean paramBoolean)
  {
    B();
    super.b(parame, paramBoolean);
  }
  
  public void d(Context paramContext, androidx.appcompat.view.menu.e parame)
  {
    super.d(paramContext, parame);
    parame = paramContext.getResources();
    paramContext = g.a.b(paramContext);
    if (!this.o) {
      this.n = paramContext.h();
    }
    if (!this.u) {
      this.p = paramContext.c();
    }
    if (!this.s) {
      this.r = paramContext.d();
    }
    int i = this.p;
    if (this.n)
    {
      if (this.k == null)
      {
        paramContext = new d(this.a);
        this.k = paramContext;
        if (this.m)
        {
          paramContext.setImageDrawable(this.l);
          this.l = null;
          this.m = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.k.measure(j, j);
      }
      i -= this.k.getMeasuredWidth();
    }
    else
    {
      this.k = null;
    }
    this.q = i;
    this.w = ((int)(parame.getDisplayMetrics().density * 56.0F));
  }
  
  public void e(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      return;
    }
    int i = ((SavedState)paramParcelable).a;
    if (i > 0)
    {
      paramParcelable = this.c.findItem(i);
      if (paramParcelable != null) {
        f((m)paramParcelable.getSubMenu());
      }
    }
  }
  
  public boolean f(m paramm)
  {
    boolean bool1 = paramm.hasVisibleItems();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    for (Object localObject = paramm; ((m)localObject).i0() != this.c; localObject = (m)((m)localObject).i0()) {}
    localObject = C(((m)localObject).getItem());
    if (localObject == null) {
      return false;
    }
    this.E = paramm.getItem().getItemId();
    int j = paramm.size();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      MenuItem localMenuItem = paramm.getItem(i);
      if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    localObject = new a(this.b, paramm, (View)localObject);
    this.z = ((a)localObject);
    ((i)localObject).g(bool1);
    this.z.k();
    super.f(paramm);
    return true;
  }
  
  public void g(boolean paramBoolean)
  {
    super.g(paramBoolean);
    ((View)this.i).requestLayout();
    Object localObject1 = this.c;
    int j = 0;
    int i1;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((androidx.appcompat.view.menu.e)localObject1).u();
      i1 = ((ArrayList)localObject1).size();
      i = 0;
      while (i < i1)
      {
        localObject2 = ((g)((ArrayList)localObject1).get(i)).b();
        if (localObject2 != null) {
          ((b)localObject2).j(this);
        }
        i += 1;
      }
    }
    localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = ((androidx.appcompat.view.menu.e)localObject1).B();
    } else {
      localObject1 = null;
    }
    int i = j;
    boolean bool;
    if (this.n)
    {
      i = j;
      if (localObject1 != null)
      {
        i1 = ((ArrayList)localObject1).size();
        if (i1 == 1)
        {
          bool = ((g)((ArrayList)localObject1).get(0)).isActionViewExpanded() ^ true;
        }
        else
        {
          bool = j;
          if (i1 > 0) {
            bool = true;
          }
        }
      }
    }
    localObject1 = this.k;
    if (bool)
    {
      if (localObject1 == null) {
        this.k = new d(this.a);
      }
      localObject1 = (ViewGroup)this.k.getParent();
      if (localObject1 != this.i)
      {
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView(this.k);
        }
        localObject1 = (ActionMenuView)this.i;
        ((ViewGroup)localObject1).addView(this.k, ((ActionMenuView)localObject1).F());
      }
    }
    else if (localObject1 != null)
    {
      localObject1 = ((ImageView)localObject1).getParent();
      localObject2 = this.i;
      if (localObject1 == localObject2) {
        ((ViewGroup)localObject2).removeView(this.k);
      }
    }
    ((ActionMenuView)this.i).setOverflowReserved(this.n);
  }
  
  public void h(g paramg, k.a parama)
  {
    parama.j(paramg, 0);
    paramg = (ActionMenuView)this.i;
    parama = (ActionMenuItemView)parama;
    parama.setItemInvoker(paramg);
    if (this.B == null) {
      this.B = new b();
    }
    parama.setPopupCallback(this.B);
  }
  
  public boolean i()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public Parcelable j()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.a = this.E;
    return localSavedState;
  }
  
  public boolean o(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.k) {
      return false;
    }
    return super.o(paramViewGroup, paramInt);
  }
  
  public View q(g paramg, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramg.getActionView();
    if ((localView == null) || (paramg.j())) {
      localView = super.q(paramg, paramView, paramViewGroup);
    }
    int i;
    if (paramg.isActionViewExpanded()) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
    paramg = (ActionMenuView)paramViewGroup;
    paramView = localView.getLayoutParams();
    if (!paramg.checkLayoutParams(paramView)) {
      localView.setLayoutParams(paramg.E(paramView));
    }
    return localView;
  }
  
  public k r(ViewGroup paramViewGroup)
  {
    k localk = this.i;
    paramViewGroup = super.r(paramViewGroup);
    if (localk != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public boolean t(int paramInt, g paramg)
  {
    return paramg.l();
  }
  
  @SuppressLint({"BanParcelableUsage"})
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    public int a;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
    }
    
    class a
      implements Parcelable.Creator<ActionMenuPresenter.SavedState>
    {
      public ActionMenuPresenter.SavedState a(Parcel paramParcel)
      {
        return new ActionMenuPresenter.SavedState(paramParcel);
      }
      
      public ActionMenuPresenter.SavedState[] b(int paramInt)
      {
        return new ActionMenuPresenter.SavedState[paramInt];
      }
    }
  }
  
  private class a
    extends i
  {
    public a(Context paramContext, m paramm, View paramView)
    {
      super(paramm, paramView, false, R.attr.actionOverflowMenuStyle);
      if (!((g)paramm.getItem()).l())
      {
        paramm = ActionMenuPresenter.this.k;
        paramContext = paramm;
        if (paramm == null) {
          paramContext = (View)ActionMenuPresenter.w(ActionMenuPresenter.this);
        }
        f(paramContext);
      }
      j(ActionMenuPresenter.this.C);
    }
    
    protected void e()
    {
      ActionMenuPresenter localActionMenuPresenter = ActionMenuPresenter.this;
      localActionMenuPresenter.z = null;
      localActionMenuPresenter.E = 0;
      super.e();
    }
  }
  
  private class b
    extends ActionMenuItemView.b
  {
    b() {}
    
    public h.e a()
    {
      ActionMenuPresenter.a locala = ActionMenuPresenter.this.z;
      if (locala != null) {
        return locala.c();
      }
      return null;
    }
  }
  
  private class c
    implements Runnable
  {
    private ActionMenuPresenter.e a;
    
    public c(ActionMenuPresenter.e parame)
    {
      this.a = parame;
    }
    
    public void run()
    {
      if (ActionMenuPresenter.y(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.z(ActionMenuPresenter.this).d();
      }
      View localView = (View)ActionMenuPresenter.A(ActionMenuPresenter.this);
      if ((localView != null) && (localView.getWindowToken() != null) && (this.a.m())) {
        ActionMenuPresenter.this.y = this.a;
      }
      ActionMenuPresenter.this.A = null;
    }
  }
  
  private class d
    extends AppCompatImageView
    implements ActionMenuView.a
  {
    public d(Context paramContext)
    {
      super(null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      n0.a(this, getContentDescription());
      setOnTouchListener(new a(this, ActionMenuPresenter.this));
    }
    
    public boolean c()
    {
      return false;
    }
    
    public boolean e()
    {
      return false;
    }
    
    public boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      ActionMenuPresenter.this.N();
      return true;
    }
    
    protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        paramInt2 = getHeight();
        paramInt1 = Math.max(i, paramInt2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        paramInt3 = getPaddingTop();
        paramInt4 = getPaddingBottom();
        i = (i + (j - k)) / 2;
        paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
        r0.a.l(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
    
    class a
      extends w
    {
      a(View paramView, ActionMenuPresenter paramActionMenuPresenter)
      {
        super();
      }
      
      public h.e b()
      {
        ActionMenuPresenter.e locale = ActionMenuPresenter.this.y;
        if (locale == null) {
          return null;
        }
        return locale.c();
      }
      
      public boolean c()
      {
        ActionMenuPresenter.this.N();
        return true;
      }
      
      public boolean d()
      {
        ActionMenuPresenter localActionMenuPresenter = ActionMenuPresenter.this;
        if (localActionMenuPresenter.A != null) {
          return false;
        }
        localActionMenuPresenter.E();
        return true;
      }
    }
  }
  
  private class e
    extends i
  {
    public e(Context paramContext, androidx.appcompat.view.menu.e parame, View paramView, boolean paramBoolean)
    {
      super(parame, paramView, paramBoolean, R.attr.actionOverflowMenuStyle);
      h(8388613);
      j(ActionMenuPresenter.this.C);
    }
    
    protected void e()
    {
      if (ActionMenuPresenter.u(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.v(ActionMenuPresenter.this).close();
      }
      ActionMenuPresenter.this.y = null;
      super.e();
    }
  }
  
  private class f
    implements j.a
  {
    f() {}
    
    public void b(androidx.appcompat.view.menu.e parame, boolean paramBoolean)
    {
      if ((parame instanceof m)) {
        parame.F().e(false);
      }
      j.a locala = ActionMenuPresenter.this.p();
      if (locala != null) {
        locala.b(parame, paramBoolean);
      }
    }
    
    public boolean c(androidx.appcompat.view.menu.e parame)
    {
      Object localObject = ActionMenuPresenter.x(ActionMenuPresenter.this);
      boolean bool = false;
      if (parame == localObject) {
        return false;
      }
      ActionMenuPresenter.this.E = ((m)parame).getItem().getItemId();
      localObject = ActionMenuPresenter.this.p();
      if (localObject != null) {
        bool = ((j.a)localObject).c(parame);
      }
      return bool;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter
 * JD-Core Version:    0.7.0.1
 */