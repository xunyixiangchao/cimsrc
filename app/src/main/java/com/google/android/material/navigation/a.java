package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.k.a;
import androidx.appcompat.widget.n0;
import androidx.core.view.v;
import androidx.core.view.x;
import androidx.core.widget.l;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.integer;
import com.google.android.material.R.string;
import o7.c;
import y0.d;
import y0.d.a;
import y0.d.c;

public abstract class a
  extends FrameLayout
  implements k.a
{
  private static final int[] C = { 16842912 };
  private static final d E = new d(null);
  private static final d F = new e(null);
  private int A = 0;
  private com.google.android.material.badge.a B;
  private boolean a = false;
  private int b;
  private int c;
  private float d;
  private float e;
  private float f;
  private int g;
  private boolean h;
  private final FrameLayout i;
  private final View j;
  private final ImageView k;
  private final ViewGroup l;
  private final TextView m;
  private final TextView n;
  private int o = -1;
  private g p;
  private ColorStateList q;
  private Drawable r;
  private Drawable s;
  private ValueAnimator t;
  private d u = E;
  private float v = 0.0F;
  private boolean w = false;
  private int x = 0;
  private int y = 0;
  private boolean z = false;
  
  public a(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(getItemLayoutResId(), this, true);
    this.i = ((FrameLayout)findViewById(R.id.navigation_bar_item_icon_container));
    this.j = findViewById(R.id.navigation_bar_item_active_indicator_view);
    paramContext = (ImageView)findViewById(R.id.navigation_bar_item_icon_view);
    this.k = paramContext;
    ViewGroup localViewGroup = (ViewGroup)findViewById(R.id.navigation_bar_item_labels_group);
    this.l = localViewGroup;
    TextView localTextView1 = (TextView)findViewById(R.id.navigation_bar_item_small_label_view);
    this.m = localTextView1;
    TextView localTextView2 = (TextView)findViewById(R.id.navigation_bar_item_large_label_view);
    this.n = localTextView2;
    setBackgroundResource(getItemBackgroundResId());
    this.b = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
    this.c = localViewGroup.getPaddingBottom();
    x.B0(localTextView1, 2);
    x.B0(localTextView2, 2);
    setFocusable(true);
    f(localTextView1.getTextSize(), localTextView2.getTextSize());
    if (paramContext != null) {
      paramContext.addOnLayoutChangeListener(new a());
    }
  }
  
  private void f(float paramFloat1, float paramFloat2)
  {
    this.d = (paramFloat1 - paramFloat2);
    this.e = (paramFloat2 * 1.0F / paramFloat1);
    this.f = (paramFloat1 * 1.0F / paramFloat2);
  }
  
  private View getIconOrContainer()
  {
    FrameLayout localFrameLayout = this.i;
    if (localFrameLayout != null) {
      return localFrameLayout;
    }
    return this.k;
  }
  
  private int getItemVisiblePosition()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    int i4 = localViewGroup.indexOfChild(this);
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      View localView = localViewGroup.getChildAt(i1);
      i3 = i2;
      if ((localView instanceof a))
      {
        i3 = i2;
        if (localView.getVisibility() == 0) {
          i3 = i2 + 1;
        }
      }
      i1 += 1;
    }
    return i2;
  }
  
  private int getSuggestedIconHeight()
  {
    com.google.android.material.badge.a locala = this.B;
    int i1;
    if (locala != null) {
      i1 = locala.getMinimumHeight() / 2;
    } else {
      i1 = 0;
    }
    return Math.max(i1, ((FrameLayout.LayoutParams)getIconOrContainer().getLayoutParams()).topMargin) + this.k.getMeasuredWidth() + i1;
  }
  
  private int getSuggestedIconWidth()
  {
    Object localObject = this.B;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((Drawable)localObject).getMinimumWidth() - this.B.i();
    }
    localObject = (FrameLayout.LayoutParams)getIconOrContainer().getLayoutParams();
    return Math.max(i1, ((FrameLayout.LayoutParams)localObject).leftMargin) + this.k.getMeasuredWidth() + Math.max(i1, ((FrameLayout.LayoutParams)localObject).rightMargin);
  }
  
  private FrameLayout h(View paramView)
  {
    ImageView localImageView = this.k;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView == localImageView)
    {
      localObject1 = localObject2;
      if (com.google.android.material.badge.b.a) {
        localObject1 = (FrameLayout)localImageView.getParent();
      }
    }
    return localObject1;
  }
  
  private boolean i()
  {
    return this.B != null;
  }
  
  private boolean k()
  {
    return (this.z) && (this.g == 2);
  }
  
  private void l(final float paramFloat)
  {
    if ((this.w) && (this.a) && (x.T(this)))
    {
      ValueAnimator localValueAnimator = this.t;
      if (localValueAnimator != null)
      {
        localValueAnimator.cancel();
        this.t = null;
      }
      localValueAnimator = ValueAnimator.ofFloat(new float[] { this.v, paramFloat });
      this.t = localValueAnimator;
      localValueAnimator.addUpdateListener(new c(paramFloat));
      this.t.setInterpolator(m7.a.e(getContext(), R.attr.motionEasingStandard, e7.a.b));
      this.t.setDuration(m7.a.d(getContext(), R.attr.motionDurationLong1, getResources().getInteger(R.integer.material_motion_duration_long_1)));
      this.t.start();
      return;
    }
    o(paramFloat, paramFloat);
  }
  
  private void m()
  {
    g localg = this.p;
    if (localg != null) {
      setChecked(localg.isChecked());
    }
  }
  
  private void o(float paramFloat1, float paramFloat2)
  {
    View localView = this.j;
    if (localView != null) {
      this.u.d(paramFloat1, paramFloat2, localView);
    }
    this.v = paramFloat1;
  }
  
  private static void p(TextView paramTextView, int paramInt)
  {
    l.o(paramTextView, paramInt);
    paramInt = c.h(paramTextView.getContext(), paramInt, 0);
    if (paramInt != 0) {
      paramTextView.setTextSize(0, paramInt);
    }
  }
  
  private static void q(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }
  
  private static void r(View paramView, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.bottomMargin = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void s(View paramView)
  {
    if (!i()) {
      return;
    }
    if (paramView != null)
    {
      setClipChildren(false);
      setClipToPadding(false);
      com.google.android.material.badge.b.a(this.B, paramView, h(paramView));
    }
  }
  
  private void t(View paramView)
  {
    if (!i()) {
      return;
    }
    if (paramView != null)
    {
      setClipChildren(true);
      setClipToPadding(true);
      com.google.android.material.badge.b.d(this.B, paramView);
    }
    this.B = null;
  }
  
  private void u(View paramView)
  {
    if (!i()) {
      return;
    }
    com.google.android.material.badge.b.e(this.B, paramView, h(paramView));
  }
  
  private void v(int paramInt)
  {
    if (this.j == null) {
      return;
    }
    int i1 = Math.min(this.x, paramInt - this.A * 2);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.j.getLayoutParams();
    if (k()) {
      paramInt = i1;
    } else {
      paramInt = this.y;
    }
    localLayoutParams.height = paramInt;
    localLayoutParams.width = i1;
    this.j.setLayoutParams(localLayoutParams);
  }
  
  private void w()
  {
    d locald;
    if (k()) {
      locald = F;
    } else {
      locald = E;
    }
    this.u = locald;
  }
  
  private static void x(View paramView, int paramInt)
  {
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramInt);
  }
  
  public boolean d()
  {
    return false;
  }
  
  void g()
  {
    n();
    this.p = null;
    this.v = 0.0F;
    this.a = false;
  }
  
  public Drawable getActiveIndicatorDrawable()
  {
    View localView = this.j;
    if (localView == null) {
      return null;
    }
    return localView.getBackground();
  }
  
  public com.google.android.material.badge.a getBadge()
  {
    return this.B;
  }
  
  protected int getItemBackgroundResId()
  {
    return R.drawable.mtrl_navigation_bar_item_background;
  }
  
  public g getItemData()
  {
    return this.p;
  }
  
  protected int getItemDefaultMarginResId()
  {
    return R.dimen.mtrl_navigation_bar_item_default_margin;
  }
  
  protected abstract int getItemLayoutResId();
  
  public int getItemPosition()
  {
    return this.o;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.l.getLayoutParams();
    return getSuggestedIconHeight() + localLayoutParams.topMargin + this.l.getMeasuredHeight() + localLayoutParams.bottomMargin;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.l.getLayoutParams();
    int i1 = localLayoutParams.leftMargin;
    int i2 = this.l.getMeasuredWidth();
    int i3 = localLayoutParams.rightMargin;
    return Math.max(getSuggestedIconWidth(), i1 + i2 + i3);
  }
  
  public void j(g paramg, int paramInt)
  {
    this.p = paramg;
    setCheckable(paramg.isCheckable());
    setChecked(paramg.isChecked());
    setEnabled(paramg.isEnabled());
    setIcon(paramg.getIcon());
    setTitle(paramg.getTitle());
    setId(paramg.getItemId());
    if (!TextUtils.isEmpty(paramg.getContentDescription())) {
      setContentDescription(paramg.getContentDescription());
    }
    CharSequence localCharSequence;
    if (!TextUtils.isEmpty(paramg.getTooltipText())) {
      localCharSequence = paramg.getTooltipText();
    } else {
      localCharSequence = paramg.getTitle();
    }
    if (Build.VERSION.SDK_INT > 23) {
      n0.a(this, localCharSequence);
    }
    if (paramg.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    this.a = true;
  }
  
  void n()
  {
    t(this.k);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    g localg = this.p;
    if ((localg != null) && (localg.isCheckable()) && (this.p.isChecked())) {
      FrameLayout.mergeDrawableStates(arrayOfInt, C);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject = this.B;
    if ((localObject != null) && (((Drawable)localObject).isVisible()))
    {
      localObject = this.p.getTitle();
      if (!TextUtils.isEmpty(this.p.getContentDescription())) {
        localObject = this.p.getContentDescription();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.B.g());
      paramAccessibilityNodeInfo.setContentDescription(localStringBuilder.toString());
    }
    paramAccessibilityNodeInfo = d.J0(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.f0(d.c.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
    if (isSelected())
    {
      paramAccessibilityNodeInfo.d0(false);
      paramAccessibilityNodeInfo.T(d.a.i);
    }
    paramAccessibilityNodeInfo.x0(getResources().getString(R.string.item_view_role_description));
  }
  
  protected void onSizeChanged(final int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    post(new b(paramInt1));
  }
  
  public void setActiveIndicatorDrawable(Drawable paramDrawable)
  {
    View localView = this.j;
    if (localView == null) {
      return;
    }
    localView.setBackgroundDrawable(paramDrawable);
  }
  
  public void setActiveIndicatorEnabled(boolean paramBoolean)
  {
    this.w = paramBoolean;
    View localView = this.j;
    if (localView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localView.setVisibility(i1);
      requestLayout();
    }
  }
  
  public void setActiveIndicatorHeight(int paramInt)
  {
    this.y = paramInt;
    v(getWidth());
  }
  
  public void setActiveIndicatorMarginHorizontal(int paramInt)
  {
    this.A = paramInt;
    v(getWidth());
  }
  
  public void setActiveIndicatorResizeable(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void setActiveIndicatorWidth(int paramInt)
  {
    this.x = paramInt;
    v(getWidth());
  }
  
  void setBadge(com.google.android.material.badge.a parama)
  {
    if (this.B == parama) {
      return;
    }
    if ((i()) && (this.k != null))
    {
      Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
      t(this.k);
    }
    this.B = parama;
    parama = this.k;
    if (parama != null) {
      s(parama);
    }
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject = this.n;
    ((TextView)localObject).setPivotX(((TextView)localObject).getWidth() / 2);
    localObject = this.n;
    ((TextView)localObject).setPivotY(((TextView)localObject).getBaseline());
    localObject = this.m;
    ((TextView)localObject).setPivotX(((TextView)localObject).getWidth() / 2);
    localObject = this.m;
    ((TextView)localObject).setPivotY(((TextView)localObject).getBaseline());
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    l(f1);
    int i1 = this.g;
    if (i1 != -1) {
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2) {
            break label401;
          }
          r(getIconOrContainer(), this.b, 17);
          this.n.setVisibility(8);
          this.m.setVisibility(8);
          break label401;
        }
        x(this.l, this.c);
        if (!paramBoolean) {}
      }
    }
    for (;;)
    {
      r(getIconOrContainer(), (int)(this.b + this.d), 49);
      q(this.n, 1.0F, 1.0F, 0);
      localObject = this.m;
      f1 = this.e;
      q((View)localObject, f1, f1, 4);
      break;
      do
      {
        r(getIconOrContainer(), this.b, 49);
        localObject = this.n;
        f1 = this.f;
        q((View)localObject, f1, f1, 4);
        q(this.m, 1.0F, 1.0F, 0);
        break;
        View localView = getIconOrContainer();
        int i2 = this.b;
        localObject = localView;
        i1 = i2;
        if (paramBoolean) {}
        for (;;)
        {
          r(localView, i2, 49);
          x(this.l, this.c);
          this.n.setVisibility(0);
          do
          {
            r((View)localObject, i1, 17);
            x(this.l, 0);
            this.n.setVisibility(4);
            this.m.setVisibility(4);
            break label401;
            if (!this.h) {
              break;
            }
            localView = getIconOrContainer();
            i2 = this.b;
            localObject = localView;
            i1 = i2;
          } while (!paramBoolean);
        }
        x(this.l, this.c);
      } while (!paramBoolean);
    }
    label401:
    refreshDrawableState();
    setSelected(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.m.setEnabled(paramBoolean);
    this.n.setEnabled(paramBoolean);
    this.k.setEnabled(paramBoolean);
    v localv;
    if (paramBoolean) {
      localv = v.b(getContext(), 1002);
    } else {
      localv = null;
    }
    x.G0(this, localv);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (paramDrawable == this.r) {
      return;
    }
    this.r = paramDrawable;
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      }
      paramDrawable = r0.a.r(paramDrawable).mutate();
      this.s = paramDrawable;
      ColorStateList localColorStateList = this.q;
      localObject = paramDrawable;
      if (localColorStateList != null)
      {
        r0.a.o(paramDrawable, localColorStateList);
        localObject = paramDrawable;
      }
    }
    this.k.setImageDrawable((Drawable)localObject);
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.k.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.k.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.q = paramColorStateList;
    if (this.p != null)
    {
      Drawable localDrawable = this.s;
      if (localDrawable != null)
      {
        r0.a.o(localDrawable, paramColorStateList);
        this.s.invalidateSelf();
      }
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 0) {
      localDrawable = null;
    } else {
      localDrawable = androidx.core.content.b.d(getContext(), paramInt);
    }
    setItemBackground(localDrawable);
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (paramDrawable.getConstantState() != null) {
        localDrawable = paramDrawable.getConstantState().newDrawable().mutate();
      }
    }
    x.u0(this, localDrawable);
  }
  
  public void setItemPaddingBottom(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      m();
    }
  }
  
  public void setItemPaddingTop(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      m();
    }
  }
  
  public void setItemPosition(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      w();
      v(getWidth());
      m();
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      m();
    }
  }
  
  public void setTextAppearanceActive(int paramInt)
  {
    p(this.n, paramInt);
    f(this.m.getTextSize(), this.n.getTextSize());
  }
  
  public void setTextAppearanceInactive(int paramInt)
  {
    p(this.m, paramInt);
    f(this.m.getTextSize(), this.n.getTextSize());
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.m.setTextColor(paramColorStateList);
      this.n.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.m.setText(paramCharSequence);
    this.n.setText(paramCharSequence);
    Object localObject = this.p;
    if ((localObject == null) || (TextUtils.isEmpty(((g)localObject).getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
    g localg = this.p;
    localObject = paramCharSequence;
    if (localg != null) {
      if (TextUtils.isEmpty(localg.getTooltipText())) {
        localObject = paramCharSequence;
      } else {
        localObject = this.p.getTooltipText();
      }
    }
    if (Build.VERSION.SDK_INT > 23) {
      n0.a(this, (CharSequence)localObject);
    }
  }
  
  class a
    implements View.OnLayoutChangeListener
  {
    a() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (a.a(a.this).getVisibility() == 0)
      {
        paramView = a.this;
        a.b(paramView, a.a(paramView));
      }
    }
  }
  
  class b
    implements Runnable
  {
    b(int paramInt) {}
    
    public void run()
    {
      a.c(a.this, paramInt1);
    }
  }
  
  class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(float paramFloat) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      a.e(a.this, f, paramFloat);
    }
  }
  
  private static class d
  {
    protected float a(float paramFloat1, float paramFloat2)
    {
      boolean bool = paramFloat2 < 0.0F;
      if (!bool) {
        paramFloat2 = 0.8F;
      } else {
        paramFloat2 = 0.0F;
      }
      float f;
      if (!bool) {
        f = 1.0F;
      } else {
        f = 0.2F;
      }
      return e7.a.b(0.0F, 1.0F, paramFloat2, f, paramFloat1);
    }
    
    protected float b(float paramFloat1, float paramFloat2)
    {
      return e7.a.a(0.4F, 1.0F, paramFloat1);
    }
    
    protected float c(float paramFloat1, float paramFloat2)
    {
      return 1.0F;
    }
    
    public void d(float paramFloat1, float paramFloat2, View paramView)
    {
      paramView.setScaleX(b(paramFloat1, paramFloat2));
      paramView.setScaleY(c(paramFloat1, paramFloat2));
      paramView.setAlpha(a(paramFloat1, paramFloat2));
    }
  }
  
  private static class e
    extends a.d
  {
    private e()
    {
      super();
    }
    
    protected float c(float paramFloat1, float paramFloat2)
    {
      return b(paramFloat1, paramFloat2);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.navigation.a
 * JD-Core Version:    0.7.0.1
 */