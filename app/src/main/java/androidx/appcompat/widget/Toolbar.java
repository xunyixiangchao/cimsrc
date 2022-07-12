package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.view.menu.e.a;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.j.a;
import androidx.appcompat.view.menu.m;
import androidx.core.view.h;
import androidx.core.view.i;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import c.a;
import g.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private ColorStateList A;
  private boolean B;
  private boolean C;
  private final ArrayList<View> E = new ArrayList();
  private final ArrayList<View> F = new ArrayList();
  private final int[] G = new int[2];
  final i H = new i(new l0(this));
  private ArrayList<MenuItem> I = new ArrayList();
  e J;
  private final ActionMenuView.d K = new a();
  private m0 L;
  private ActionMenuPresenter M;
  private d N;
  private j.a O;
  private e.a P;
  private boolean Q;
  private final Runnable R = new b();
  private ActionMenuView a;
  private TextView b;
  private TextView c;
  private ImageButton d;
  private ImageView e;
  private Drawable f;
  private CharSequence g;
  ImageButton h;
  View i;
  private Context j;
  private int k;
  private int l;
  private int m;
  int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private c0 t;
  private int u;
  private int v;
  private int w = 8388627;
  private CharSequence x;
  private CharSequence y;
  private ColorStateList z;
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getContext();
    int[] arrayOfInt = R.styleable.Toolbar;
    localObject = k0.v((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    x.o0(this, paramContext, arrayOfInt, paramAttributeSet, ((k0)localObject).r(), paramInt, 0);
    this.l = ((k0)localObject).n(R.styleable.Toolbar_titleTextAppearance, 0);
    this.m = ((k0)localObject).n(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.w = ((k0)localObject).l(R.styleable.Toolbar_android_gravity, this.w);
    this.n = ((k0)localObject).l(R.styleable.Toolbar_buttonGravity, 48);
    int i1 = ((k0)localObject).e(R.styleable.Toolbar_titleMargin, 0);
    int i2 = R.styleable.Toolbar_titleMargins;
    paramInt = i1;
    if (((k0)localObject).s(i2)) {
      paramInt = ((k0)localObject).e(i2, i1);
    }
    this.s = paramInt;
    this.r = paramInt;
    this.q = paramInt;
    this.p = paramInt;
    paramInt = ((k0)localObject).e(R.styleable.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.p = paramInt;
    }
    paramInt = ((k0)localObject).e(R.styleable.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.q = paramInt;
    }
    paramInt = ((k0)localObject).e(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.r = paramInt;
    }
    paramInt = ((k0)localObject).e(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.s = paramInt;
    }
    this.o = ((k0)localObject).f(R.styleable.Toolbar_maxButtonHeight, -1);
    paramInt = ((k0)localObject).e(R.styleable.Toolbar_contentInsetStart, -2147483648);
    i1 = ((k0)localObject).e(R.styleable.Toolbar_contentInsetEnd, -2147483648);
    i2 = ((k0)localObject).f(R.styleable.Toolbar_contentInsetLeft, 0);
    int i3 = ((k0)localObject).f(R.styleable.Toolbar_contentInsetRight, 0);
    h();
    this.t.e(i2, i3);
    if ((paramInt != -2147483648) || (i1 != -2147483648)) {
      this.t.g(paramInt, i1);
    }
    this.u = ((k0)localObject).e(R.styleable.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.v = ((k0)localObject).e(R.styleable.Toolbar_contentInsetEndWithActions, -2147483648);
    this.f = ((k0)localObject).g(R.styleable.Toolbar_collapseIcon);
    this.g = ((k0)localObject).p(R.styleable.Toolbar_collapseContentDescription);
    paramContext = ((k0)localObject).p(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(paramContext)) {
      setTitle(paramContext);
    }
    paramContext = ((k0)localObject).p(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramContext)) {
      setSubtitle(paramContext);
    }
    this.j = getContext();
    setPopupTheme(((k0)localObject).n(R.styleable.Toolbar_popupTheme, 0));
    paramContext = ((k0)localObject).g(R.styleable.Toolbar_navigationIcon);
    if (paramContext != null) {
      setNavigationIcon(paramContext);
    }
    paramContext = ((k0)localObject).p(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramContext)) {
      setNavigationContentDescription(paramContext);
    }
    paramContext = ((k0)localObject).g(R.styleable.Toolbar_logo);
    if (paramContext != null) {
      setLogo(paramContext);
    }
    paramContext = ((k0)localObject).p(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramContext)) {
      setLogoDescription(paramContext);
    }
    paramInt = R.styleable.Toolbar_titleTextColor;
    if (((k0)localObject).s(paramInt)) {
      setTitleTextColor(((k0)localObject).c(paramInt));
    }
    paramInt = R.styleable.Toolbar_subtitleTextColor;
    if (((k0)localObject).s(paramInt)) {
      setSubtitleTextColor(((k0)localObject).c(paramInt));
    }
    paramInt = R.styleable.Toolbar_menu;
    if (((k0)localObject).s(paramInt)) {
      x(((k0)localObject).n(paramInt, 0));
    }
    ((k0)localObject).w();
  }
  
  private int C(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i1 = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 += Math.max(0, i1);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramInt2 = q(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 + (i1 + localLayoutParams.rightMargin);
  }
  
  private int D(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i1 = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i1);
    paramArrayOfInt[1] = Math.max(0, -i1);
    paramInt2 = q(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i1, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (i1 + localLayoutParams.leftMargin);
  }
  
  private int E(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int i2 = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int i3 = Math.max(0, i1) + Math.max(0, i2);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramArrayOfInt[1] = Math.max(0, -i2);
    paramView.measure(ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + i3 + paramInt2, localMarginLayoutParams.width), ViewGroup.getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + i3;
  }
  
  private void F(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0)
      {
        paramInt1 = paramInt5;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i1, paramInt1);
  }
  
  private void G()
  {
    ArrayList localArrayList1 = getCurrentMenuItems();
    this.H.a(getMenu(), getMenuInflater());
    ArrayList localArrayList2 = getCurrentMenuItems();
    localArrayList2.removeAll(localArrayList1);
    this.I = localArrayList2;
  }
  
  private void H()
  {
    removeCallbacks(this.R);
    post(this.R);
  }
  
  private boolean O()
  {
    if (!this.Q) {
      return false;
    }
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((P(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0)) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private boolean P(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private void b(List<View> paramList, int paramInt)
  {
    int i1 = x.B(this);
    int i2 = 0;
    if (i1 == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i4 = getChildCount();
    int i3 = androidx.core.view.e.b(paramInt, x.B(this));
    paramList.clear();
    paramInt = i2;
    View localView;
    LayoutParams localLayoutParams;
    if (i1 != 0)
    {
      paramInt = i4 - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.b == 0) && (P(localView)) && (p(localLayoutParams.a) == i3)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
    }
    while (paramInt < i4)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.b == 0) && (P(localView)) && (p(localLayoutParams.a) == i3)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private void c(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = m();
    } else if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
      localObject = o((ViewGroup.LayoutParams)localObject);
    } else {
      localObject = (LayoutParams)localObject;
    }
    ((LayoutParams)localObject).b = 1;
    if ((paramBoolean) && (this.i != null))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.F.add(paramView);
      return;
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private ArrayList<MenuItem> getCurrentMenuItems()
  {
    ArrayList localArrayList = new ArrayList();
    Menu localMenu = getMenu();
    int i1 = 0;
    while (i1 < localMenu.size())
    {
      localArrayList.add(localMenu.getItem(i1));
      i1 += 1;
    }
    return localArrayList;
  }
  
  private MenuInflater getMenuInflater()
  {
    return new g.g(getContext());
  }
  
  private void h()
  {
    if (this.t == null) {
      this.t = new c0();
    }
  }
  
  private void i()
  {
    if (this.e == null) {
      this.e = new AppCompatImageView(getContext());
    }
  }
  
  private void j()
  {
    k();
    if (this.a.N() == null)
    {
      androidx.appcompat.view.menu.e locale = (androidx.appcompat.view.menu.e)this.a.getMenu();
      if (this.N == null) {
        this.N = new d();
      }
      this.a.setExpandedActionViewsExclusive(true);
      locale.c(this.N, this.j);
    }
  }
  
  private void k()
  {
    if (this.a == null)
    {
      Object localObject = new ActionMenuView(getContext());
      this.a = ((ActionMenuView)localObject);
      ((ActionMenuView)localObject).setPopupTheme(this.k);
      this.a.setOnMenuItemClickListener(this.K);
      this.a.O(this.O, this.P);
      localObject = m();
      ((ActionBar.LayoutParams)localObject).a = (0x800005 | this.n & 0x70);
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      c(this.a, false);
    }
  }
  
  private void l()
  {
    if (this.d == null)
    {
      this.d = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = m();
      localLayoutParams.a = (0x800003 | this.n & 0x70);
      this.d.setLayoutParams(localLayoutParams);
    }
  }
  
  private int p(int paramInt)
  {
    int i1 = x.B(this);
    int i2 = androidx.core.view.e.b(paramInt, i1) & 0x7;
    if (i2 != 1)
    {
      paramInt = 3;
      if ((i2 != 3) && (i2 != 5))
      {
        if (i1 == 1) {
          paramInt = 5;
        }
        return paramInt;
      }
    }
    return i2;
  }
  
  private int q(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i2 = paramView.getMeasuredHeight();
    if (paramInt > 0) {
      paramInt = (i2 - paramInt) / 2;
    } else {
      paramInt = 0;
    }
    int i1 = r(localLayoutParams.a);
    if (i1 != 48)
    {
      if (i1 != 80)
      {
        int i3 = getPaddingTop();
        int i4 = getPaddingBottom();
        int i5 = getHeight();
        i1 = (i5 - i3 - i4 - i2) / 2;
        paramInt = localLayoutParams.topMargin;
        if (i1 >= paramInt)
        {
          i2 = i5 - i4 - i2 - i1 - i3;
          i4 = localLayoutParams.bottomMargin;
          paramInt = i1;
          if (i2 < i4) {
            paramInt = Math.max(0, i1 - (i4 - i2));
          }
        }
        return i3 + paramInt;
      }
      return getHeight() - getPaddingBottom() - i2 - localLayoutParams.bottomMargin - paramInt;
    }
    return getPaddingTop() - paramInt;
  }
  
  private int r(int paramInt)
  {
    int i1 = paramInt & 0x70;
    paramInt = i1;
    if (i1 != 16)
    {
      paramInt = i1;
      if (i1 != 48)
      {
        paramInt = i1;
        if (i1 != 80) {
          paramInt = this.w & 0x70;
        }
      }
    }
    return paramInt;
  }
  
  private int s(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return h.b(paramView) + h.a(paramView);
  }
  
  private int t(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return paramView.topMargin + paramView.bottomMargin;
  }
  
  private int u(List<View> paramList, int[] paramArrayOfInt)
  {
    int i4 = paramArrayOfInt[0];
    int i3 = paramArrayOfInt[1];
    int i5 = paramList.size();
    int i1 = 0;
    int i2 = i1;
    while (i1 < i5)
    {
      paramArrayOfInt = (View)paramList.get(i1);
      LayoutParams localLayoutParams = (LayoutParams)paramArrayOfInt.getLayoutParams();
      i4 = localLayoutParams.leftMargin - i4;
      i3 = localLayoutParams.rightMargin - i3;
      int i6 = Math.max(0, i4);
      int i7 = Math.max(0, i3);
      i4 = Math.max(0, -i4);
      i3 = Math.max(0, -i3);
      i2 += i6 + paramArrayOfInt.getMeasuredWidth() + i7;
      i1 += 1;
    }
    return i2;
  }
  
  private boolean z(View paramView)
  {
    return (paramView.getParent() == this) || (this.F.contains(paramView));
  }
  
  public boolean A()
  {
    ActionMenuView localActionMenuView = this.a;
    return (localActionMenuView != null) && (localActionMenuView.I());
  }
  
  public boolean B()
  {
    ActionMenuView localActionMenuView = this.a;
    return (localActionMenuView != null) && (localActionMenuView.J());
  }
  
  void I()
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = getChildAt(i1);
      if ((((LayoutParams)localView.getLayoutParams()).b != 2) && (localView != this.a))
      {
        removeViewAt(i1);
        this.F.add(localView);
      }
      i1 -= 1;
    }
  }
  
  public void J(int paramInt1, int paramInt2)
  {
    h();
    this.t.g(paramInt1, paramInt2);
  }
  
  public void K(androidx.appcompat.view.menu.e parame, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((parame == null) && (this.a == null)) {
      return;
    }
    k();
    androidx.appcompat.view.menu.e locale = this.a.N();
    if (locale == parame) {
      return;
    }
    if (locale != null)
    {
      locale.Q(this.M);
      locale.Q(this.N);
    }
    if (this.N == null) {
      this.N = new d();
    }
    paramActionMenuPresenter.J(true);
    if (parame != null)
    {
      parame.c(paramActionMenuPresenter, this.j);
      parame.c(this.N, this.j);
    }
    else
    {
      paramActionMenuPresenter.d(this.j, null);
      this.N.d(this.j, null);
      paramActionMenuPresenter.g(true);
      this.N.g(true);
    }
    this.a.setPopupTheme(this.k);
    this.a.setPresenter(paramActionMenuPresenter);
    this.M = paramActionMenuPresenter;
  }
  
  public void L(j.a parama, e.a parama1)
  {
    this.O = parama;
    this.P = parama1;
    ActionMenuView localActionMenuView = this.a;
    if (localActionMenuView != null) {
      localActionMenuView.O(parama, parama1);
    }
  }
  
  public void M(Context paramContext, int paramInt)
  {
    this.m = paramInt;
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void N(Context paramContext, int paramInt)
  {
    this.l = paramInt;
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public boolean Q()
  {
    ActionMenuView localActionMenuView = this.a;
    return (localActionMenuView != null) && (localActionMenuView.P());
  }
  
  void a()
  {
    int i1 = this.F.size() - 1;
    while (i1 >= 0)
    {
      addView((View)this.F.get(i1));
      i1 -= 1;
    }
    this.F.clear();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public boolean d()
  {
    if (getVisibility() == 0)
    {
      ActionMenuView localActionMenuView = this.a;
      if ((localActionMenuView != null) && (localActionMenuView.K())) {
        return true;
      }
    }
    return false;
  }
  
  public void e()
  {
    Object localObject = this.N;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((d)localObject).b;
    }
    if (localObject != null) {
      ((androidx.appcompat.view.menu.g)localObject).collapseActionView();
    }
  }
  
  public void f()
  {
    ActionMenuView localActionMenuView = this.a;
    if (localActionMenuView != null) {
      localActionMenuView.B();
    }
  }
  
  void g()
  {
    if (this.h == null)
    {
      Object localObject = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      this.h = ((ImageButton)localObject);
      ((ImageButton)localObject).setImageDrawable(this.f);
      this.h.setContentDescription(this.g);
      localObject = m();
      ((ActionBar.LayoutParams)localObject).a = (0x800003 | this.n & 0x70);
      ((LayoutParams)localObject).b = 2;
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.h.setOnClickListener(new c());
    }
  }
  
  public CharSequence getCollapseContentDescription()
  {
    ImageButton localImageButton = this.h;
    if (localImageButton != null) {
      return localImageButton.getContentDescription();
    }
    return null;
  }
  
  public Drawable getCollapseIcon()
  {
    ImageButton localImageButton = this.h;
    if (localImageButton != null) {
      return localImageButton.getDrawable();
    }
    return null;
  }
  
  public int getContentInsetEnd()
  {
    c0 localc0 = this.t;
    if (localc0 != null) {
      return localc0.a();
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    int i1 = this.v;
    if (i1 != -2147483648) {
      return i1;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    c0 localc0 = this.t;
    if (localc0 != null) {
      return localc0.b();
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    c0 localc0 = this.t;
    if (localc0 != null) {
      return localc0.c();
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    c0 localc0 = this.t;
    if (localc0 != null) {
      return localc0.d();
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    int i1 = this.u;
    if (i1 != -2147483648) {
      return i1;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((ActionMenuView)localObject).N();
      if ((localObject != null) && (((androidx.appcompat.view.menu.e)localObject).hasVisibleItems()))
      {
        i1 = 1;
        break label32;
      }
    }
    int i1 = 0;
    label32:
    if (i1 != 0) {
      return Math.max(getContentInsetEnd(), Math.max(this.v, 0));
    }
    return getContentInsetEnd();
  }
  
  public int getCurrentContentInsetLeft()
  {
    if (x.B(this) == 1) {
      return getCurrentContentInsetEnd();
    }
    return getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight()
  {
    if (x.B(this) == 1) {
      return getCurrentContentInsetStart();
    }
    return getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null) {
      return Math.max(getContentInsetStart(), Math.max(this.u, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    ImageView localImageView = this.e;
    if (localImageView != null) {
      return localImageView.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    ImageView localImageView = this.e;
    if (localImageView != null) {
      return localImageView.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    j();
    return this.a.getMenu();
  }
  
  View getNavButtonView()
  {
    return this.d;
  }
  
  public CharSequence getNavigationContentDescription()
  {
    ImageButton localImageButton = this.d;
    if (localImageButton != null) {
      return localImageButton.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    ImageButton localImageButton = this.d;
    if (localImageButton != null) {
      return localImageButton.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.M;
  }
  
  public Drawable getOverflowIcon()
  {
    j();
    return this.a.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.j;
  }
  
  public int getPopupTheme()
  {
    return this.k;
  }
  
  public CharSequence getSubtitle()
  {
    return this.y;
  }
  
  final TextView getSubtitleTextView()
  {
    return this.c;
  }
  
  public CharSequence getTitle()
  {
    return this.x;
  }
  
  public int getTitleMarginBottom()
  {
    return this.s;
  }
  
  public int getTitleMarginEnd()
  {
    return this.q;
  }
  
  public int getTitleMarginStart()
  {
    return this.p;
  }
  
  public int getTitleMarginTop()
  {
    return this.r;
  }
  
  final TextView getTitleTextView()
  {
    return this.b;
  }
  
  public s getWrapper()
  {
    if (this.L == null) {
      this.L = new m0(this, true);
    }
    return this.L;
  }
  
  protected LayoutParams m()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams n(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams o(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.R);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 9) {
      this.C = false;
    }
    if (!this.C)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i1 == 9) && (!bool)) {
        this.C = true;
      }
    }
    if ((i1 == 10) || (i1 == 3)) {
      this.C = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (x.B(this) == 1) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i5 = getWidth();
    int i8 = getHeight();
    int i1 = getPaddingLeft();
    int i6 = getPaddingRight();
    int i7 = getPaddingTop();
    int i9 = getPaddingBottom();
    int i4 = i5 - i6;
    int[] arrayOfInt = this.G;
    arrayOfInt[1] = 0;
    arrayOfInt[0] = 0;
    paramInt1 = x.C(this);
    if (paramInt1 >= 0) {
      paramInt4 = Math.min(paramInt1, paramInt4 - paramInt2);
    } else {
      paramInt4 = 0;
    }
    Object localObject1;
    if (P(this.d))
    {
      localObject1 = this.d;
      if (i3 != 0)
      {
        i2 = D((View)localObject1, i4, arrayOfInt, paramInt4);
        paramInt3 = i1;
        break label169;
      }
      paramInt3 = C((View)localObject1, i1, arrayOfInt, paramInt4);
    }
    else
    {
      paramInt3 = i1;
    }
    int i2 = i4;
    label169:
    paramInt1 = paramInt3;
    paramInt2 = i2;
    if (P(this.h))
    {
      localObject1 = this.h;
      if (i3 != 0)
      {
        paramInt2 = D((View)localObject1, i2, arrayOfInt, paramInt4);
        paramInt1 = paramInt3;
      }
      else
      {
        paramInt1 = C((View)localObject1, paramInt3, arrayOfInt, paramInt4);
        paramInt2 = i2;
      }
    }
    i2 = paramInt1;
    paramInt3 = paramInt2;
    if (P(this.a))
    {
      localObject1 = this.a;
      if (i3 != 0)
      {
        i2 = C((View)localObject1, paramInt1, arrayOfInt, paramInt4);
        paramInt3 = paramInt2;
      }
      else
      {
        paramInt3 = D((View)localObject1, paramInt2, arrayOfInt, paramInt4);
        i2 = paramInt1;
      }
    }
    paramInt2 = getCurrentContentInsetLeft();
    paramInt1 = getCurrentContentInsetRight();
    arrayOfInt[0] = Math.max(0, paramInt2 - i2);
    arrayOfInt[1] = Math.max(0, paramInt1 - (i4 - paramInt3));
    paramInt2 = Math.max(i2, paramInt2);
    paramInt3 = Math.min(paramInt3, i4 - paramInt1);
    paramInt1 = paramInt2;
    i2 = paramInt3;
    if (P(this.i))
    {
      localObject1 = this.i;
      if (i3 != 0)
      {
        i2 = D((View)localObject1, paramInt3, arrayOfInt, paramInt4);
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = C((View)localObject1, paramInt2, arrayOfInt, paramInt4);
        i2 = paramInt3;
      }
    }
    paramInt3 = paramInt1;
    paramInt2 = i2;
    if (P(this.e))
    {
      localObject1 = this.e;
      if (i3 != 0)
      {
        paramInt2 = D((View)localObject1, i2, arrayOfInt, paramInt4);
        paramInt3 = paramInt1;
      }
      else
      {
        paramInt3 = C((View)localObject1, paramInt1, arrayOfInt, paramInt4);
        paramInt2 = i2;
      }
    }
    paramBoolean = P(this.b);
    boolean bool = P(this.c);
    if (paramBoolean)
    {
      localObject1 = (LayoutParams)this.b.getLayoutParams();
      paramInt1 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin + this.b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin + 0;
    }
    else
    {
      paramInt1 = 0;
    }
    if (bool)
    {
      localObject1 = (LayoutParams)this.c.getLayoutParams();
      paramInt1 += ((ViewGroup.MarginLayoutParams)localObject1).topMargin + this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
    }
    if ((!paramBoolean) && (!bool)) {}
    for (paramInt1 = paramInt3;; paramInt1 = paramInt3)
    {
      paramInt3 = paramInt2;
      break label1319;
      if (paramBoolean) {
        localObject1 = this.b;
      } else {
        localObject1 = this.c;
      }
      if (bool) {
        localObject2 = this.c;
      } else {
        localObject2 = this.b;
      }
      localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
      Object localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
      if (((paramBoolean) && (this.b.getMeasuredWidth() > 0)) || ((bool) && (this.c.getMeasuredWidth() > 0))) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      i4 = this.w & 0x70;
      if (i4 != 48)
      {
        if (i4 != 80)
        {
          i4 = (i8 - i7 - i9 - paramInt1) / 2;
          int i10 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
          int i11 = this.r;
          if (i4 < i10 + i11)
          {
            paramInt1 = i10 + i11;
          }
          else
          {
            i8 = i8 - i9 - paramInt1 - i4 - i7;
            i9 = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
            i10 = this.s;
            paramInt1 = i4;
            if (i8 < i9 + i10) {
              paramInt1 = Math.max(0, i4 - (((ViewGroup.MarginLayoutParams)localObject2).bottomMargin + i10 - i8));
            }
          }
          paramInt1 = i7 + paramInt1;
        }
        else
        {
          paramInt1 = i8 - i9 - ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin - this.s - paramInt1;
        }
      }
      else {
        paramInt1 = getPaddingTop() + ((ViewGroup.MarginLayoutParams)localObject1).topMargin + this.r;
      }
      if (i3 == 0) {
        break;
      }
      if (i2 != 0) {
        i3 = this.p;
      } else {
        i3 = 0;
      }
      i3 -= arrayOfInt[1];
      paramInt2 -= Math.max(0, i3);
      arrayOfInt[1] = Math.max(0, -i3);
      if (paramBoolean)
      {
        localObject1 = (LayoutParams)this.b.getLayoutParams();
        i4 = paramInt2 - this.b.getMeasuredWidth();
        i3 = this.b.getMeasuredHeight() + paramInt1;
        this.b.layout(i4, paramInt1, paramInt2, i3);
        paramInt1 = i4 - this.q;
        i4 = i3 + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
      }
      else
      {
        i3 = paramInt2;
        i4 = paramInt1;
        paramInt1 = i3;
      }
      if (bool)
      {
        i3 = i4 + ((LayoutParams)this.c.getLayoutParams()).topMargin;
        i4 = this.c.getMeasuredWidth();
        i7 = this.c.getMeasuredHeight();
        this.c.layout(paramInt2 - i4, i3, paramInt2, i7 + i3);
        i3 = paramInt2 - this.q;
      }
      else
      {
        i3 = paramInt2;
      }
      if (i2 != 0) {
        paramInt2 = Math.min(paramInt1, i3);
      }
    }
    if (i2 != 0) {
      i3 = this.p;
    } else {
      i3 = 0;
    }
    i3 -= arrayOfInt[0];
    paramInt3 += Math.max(0, i3);
    arrayOfInt[0] = Math.max(0, -i3);
    if (paramBoolean)
    {
      localObject1 = (LayoutParams)this.b.getLayoutParams();
      i3 = this.b.getMeasuredWidth() + paramInt3;
      i4 = this.b.getMeasuredHeight() + paramInt1;
      this.b.layout(paramInt3, paramInt1, i3, i4);
      i3 += this.q;
      paramInt1 = i4 + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
    }
    else
    {
      i3 = paramInt3;
    }
    if (bool)
    {
      paramInt1 += ((LayoutParams)this.c.getLayoutParams()).topMargin;
      i4 = this.c.getMeasuredWidth() + paramInt3;
      i7 = this.c.getMeasuredHeight();
      this.c.layout(paramInt3, paramInt1, i4, i7 + paramInt1);
      i4 += this.q;
    }
    else
    {
      i4 = paramInt3;
    }
    paramInt1 = paramInt3;
    paramInt3 = paramInt2;
    if (i2 != 0)
    {
      paramInt1 = Math.max(i3, i4);
      paramInt3 = paramInt2;
    }
    label1319:
    i2 = i1;
    i1 = 0;
    b(this.E, 3);
    int i3 = this.E.size();
    paramInt2 = 0;
    while (paramInt2 < i3)
    {
      paramInt1 = C((View)this.E.get(paramInt2), paramInt1, arrayOfInt, paramInt4);
      paramInt2 += 1;
    }
    b(this.E, 5);
    i3 = this.E.size();
    paramInt2 = 0;
    while (paramInt2 < i3)
    {
      paramInt3 = D((View)this.E.get(paramInt2), paramInt3, arrayOfInt, paramInt4);
      paramInt2 += 1;
    }
    b(this.E, 1);
    i3 = u(this.E, arrayOfInt);
    paramInt2 = i2 + (i5 - i2 - i6) / 2 - i3 / 2;
    i2 = i3 + paramInt2;
    if (paramInt2 >= paramInt1) {
      if (i2 > paramInt3) {
        paramInt1 = paramInt2 - (i2 - paramInt3);
      } else {
        paramInt1 = paramInt2;
      }
    }
    paramInt3 = this.E.size();
    paramInt2 = paramInt1;
    paramInt1 = i1;
    while (paramInt1 < paramInt3)
    {
      paramInt2 = C((View)this.E.get(paramInt1), paramInt2, arrayOfInt, paramInt4);
      paramInt1 += 1;
    }
    this.E.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.g());
    paramParcelable = this.a;
    if (paramParcelable != null) {
      paramParcelable = paramParcelable.N();
    } else {
      paramParcelable = null;
    }
    int i1 = localSavedState.c;
    if ((i1 != 0) && (this.N != null) && (paramParcelable != null))
    {
      paramParcelable = paramParcelable.findItem(i1);
      if (paramParcelable != null) {
        paramParcelable.expandActionView();
      }
    }
    if (localSavedState.d) {
      H();
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    h();
    c0 localc0 = this.t;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    localc0.f(bool);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Object localObject = this.N;
    if (localObject != null)
    {
      localObject = ((d)localObject).b;
      if (localObject != null) {
        localSavedState.c = ((androidx.appcompat.view.menu.g)localObject).getItemId();
      }
    }
    localSavedState.d = B();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0) {
      this.B = false;
    }
    if (!this.B)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i1 == 0) && (!bool)) {
        this.B = true;
      }
    }
    if ((i1 == 1) || (i1 == 3)) {
      this.B = false;
    }
    return true;
  }
  
  public void setCollapseContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setCollapseContentDescription(localCharSequence);
  }
  
  public void setCollapseContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      g();
    }
    ImageButton localImageButton = this.h;
    if (localImageButton != null) {
      localImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setCollapseIcon(int paramInt)
  {
    setCollapseIcon(a.b(getContext(), paramInt));
  }
  
  public void setCollapseIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      g();
      this.h.setImageDrawable(paramDrawable);
      return;
    }
    paramDrawable = this.h;
    if (paramDrawable != null) {
      paramDrawable.setImageDrawable(this.f);
    }
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.Q = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = -2147483648;
    }
    if (i1 != this.v)
    {
      this.v = i1;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = -2147483648;
    }
    if (i1 != this.u)
    {
      this.u = i1;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(a.b(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      i();
      if (!z(this.e)) {
        c(this.e, true);
      }
    }
    else
    {
      localImageView = this.e;
      if ((localImageView != null) && (z(localImageView)))
      {
        removeView(this.e);
        this.F.remove(this.e);
      }
    }
    ImageView localImageView = this.e;
    if (localImageView != null) {
      localImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      i();
    }
    ImageView localImageView = this.e;
    if (localImageView != null) {
      localImageView.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setNavigationContentDescription(localCharSequence);
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      l();
    }
    ImageButton localImageButton = this.d;
    if (localImageButton != null)
    {
      localImageButton.setContentDescription(paramCharSequence);
      n0.a(this.d, paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(a.b(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      l();
      if (!z(this.d)) {
        c(this.d, true);
      }
    }
    else
    {
      localImageButton = this.d;
      if ((localImageButton != null) && (z(localImageButton)))
      {
        removeView(this.d);
        this.F.remove(this.d);
      }
    }
    ImageButton localImageButton = this.d;
    if (localImageButton != null) {
      localImageButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    l();
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(e parame)
  {
    this.J = parame;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    j();
    this.a.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      if (paramInt == 0)
      {
        this.j = getContext();
        return;
      }
      this.j = new ContextThemeWrapper(getContext(), paramInt);
    }
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.c == null)
      {
        localObject = getContext();
        AppCompatTextView localAppCompatTextView = new AppCompatTextView((Context)localObject);
        this.c = localAppCompatTextView;
        localAppCompatTextView.setSingleLine();
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        int i1 = this.m;
        if (i1 != 0) {
          this.c.setTextAppearance((Context)localObject, i1);
        }
        localObject = this.A;
        if (localObject != null) {
          this.c.setTextColor((ColorStateList)localObject);
        }
      }
      if (!z(this.c)) {
        c(this.c, true);
      }
    }
    else
    {
      localObject = this.c;
      if ((localObject != null) && (z((View)localObject)))
      {
        removeView(this.c);
        this.F.remove(this.c);
      }
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    this.y = paramCharSequence;
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    setSubtitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setSubtitleTextColor(ColorStateList paramColorStateList)
  {
    this.A = paramColorStateList;
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.b == null)
      {
        localObject = getContext();
        AppCompatTextView localAppCompatTextView = new AppCompatTextView((Context)localObject);
        this.b = localAppCompatTextView;
        localAppCompatTextView.setSingleLine();
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        int i1 = this.l;
        if (i1 != 0) {
          this.b.setTextAppearance((Context)localObject, i1);
        }
        localObject = this.z;
        if (localObject != null) {
          this.b.setTextColor((ColorStateList)localObject);
        }
      }
      if (!z(this.b)) {
        c(this.b, true);
      }
    }
    else
    {
      localObject = this.b;
      if ((localObject != null) && (z((View)localObject)))
      {
        removeView(this.b);
        this.F.remove(this.b);
      }
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    this.x = paramCharSequence;
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.s = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.q = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.p = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.r = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt)
  {
    setTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setTitleTextColor(ColorStateList paramColorStateList)
  {
    this.z = paramColorStateList;
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public boolean v()
  {
    d locald = this.N;
    return (locald != null) && (locald.b != null);
  }
  
  public boolean w()
  {
    ActionMenuView localActionMenuView = this.a;
    return (localActionMenuView != null) && (localActionMenuView.H());
  }
  
  public void x(int paramInt)
  {
    getMenuInflater().inflate(paramInt, getMenu());
  }
  
  public void y()
  {
    Iterator localIterator = this.I.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      getMenu().removeItem(localMenuItem.getItemId());
    }
    G();
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int b = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.a = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      a(paramMarginLayoutParams);
    }
    
    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.b = paramLayoutParams.b;
    }
    
    void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int c;
    boolean d;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.c = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.d = bool;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<Toolbar.SavedState>
    {
      public Toolbar.SavedState a(Parcel paramParcel)
      {
        return new Toolbar.SavedState(paramParcel, null);
      }
      
      public Toolbar.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new Toolbar.SavedState(paramParcel, paramClassLoader);
      }
      
      public Toolbar.SavedState[] c(int paramInt)
      {
        return new Toolbar.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements ActionMenuView.d
  {
    a() {}
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      if (Toolbar.this.H.b(paramMenuItem)) {
        return true;
      }
      Toolbar.e locale = Toolbar.this.J;
      if (locale != null) {
        return locale.onMenuItemClick(paramMenuItem);
      }
      return false;
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      Toolbar.this.Q();
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      Toolbar.this.e();
    }
  }
  
  private class d
    implements j
  {
    androidx.appcompat.view.menu.e a;
    androidx.appcompat.view.menu.g b;
    
    d() {}
    
    public void b(androidx.appcompat.view.menu.e parame, boolean paramBoolean) {}
    
    public void d(Context paramContext, androidx.appcompat.view.menu.e parame)
    {
      paramContext = this.a;
      if (paramContext != null)
      {
        androidx.appcompat.view.menu.g localg = this.b;
        if (localg != null) {
          paramContext.f(localg);
        }
      }
      this.a = parame;
    }
    
    public void e(Parcelable paramParcelable) {}
    
    public boolean f(m paramm)
    {
      return false;
    }
    
    public void g(boolean paramBoolean)
    {
      if (this.b != null)
      {
        androidx.appcompat.view.menu.e locale = this.a;
        int k = 0;
        int j = k;
        if (locale != null)
        {
          int m = locale.size();
          int i = 0;
          for (;;)
          {
            j = k;
            if (i >= m) {
              break;
            }
            if (this.a.getItem(i) == this.b)
            {
              j = 1;
              break;
            }
            i += 1;
          }
        }
        if (j == 0) {
          k(this.a, this.b);
        }
      }
    }
    
    public int getId()
    {
      return 0;
    }
    
    public boolean i()
    {
      return false;
    }
    
    public Parcelable j()
    {
      return null;
    }
    
    public boolean k(androidx.appcompat.view.menu.e parame, androidx.appcompat.view.menu.g paramg)
    {
      parame = Toolbar.this.i;
      if ((parame instanceof c)) {
        ((c)parame).e();
      }
      parame = Toolbar.this;
      parame.removeView(parame.i);
      parame = Toolbar.this;
      parame.removeView(parame.h);
      parame = Toolbar.this;
      parame.i = null;
      parame.a();
      this.b = null;
      Toolbar.this.requestLayout();
      paramg.r(false);
      return true;
    }
    
    public boolean l(androidx.appcompat.view.menu.e parame, androidx.appcompat.view.menu.g paramg)
    {
      Toolbar.this.g();
      parame = Toolbar.this.h.getParent();
      Toolbar localToolbar = Toolbar.this;
      if (parame != localToolbar)
      {
        if ((parame instanceof ViewGroup)) {
          ((ViewGroup)parame).removeView(localToolbar.h);
        }
        parame = Toolbar.this;
        parame.addView(parame.h);
      }
      Toolbar.this.i = paramg.getActionView();
      this.b = paramg;
      parame = Toolbar.this.i.getParent();
      localToolbar = Toolbar.this;
      if (parame != localToolbar)
      {
        if ((parame instanceof ViewGroup)) {
          ((ViewGroup)parame).removeView(localToolbar.i);
        }
        parame = Toolbar.this.m();
        localToolbar = Toolbar.this;
        parame.a = (0x800003 | localToolbar.n & 0x70);
        parame.b = 2;
        localToolbar.i.setLayoutParams(parame);
        parame = Toolbar.this;
        parame.addView(parame.i);
      }
      Toolbar.this.I();
      Toolbar.this.requestLayout();
      paramg.r(true);
      parame = Toolbar.this.i;
      if ((parame instanceof c)) {
        ((c)parame).c();
      }
      return true;
    }
  }
  
  public static abstract interface e
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.Toolbar
 * JD-Core Version:    0.7.0.1
 */