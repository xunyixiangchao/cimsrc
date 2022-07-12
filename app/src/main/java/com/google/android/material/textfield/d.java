package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.AutoCompleteTextView.OnDismissListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.string;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.o;
import r7.h;
import r7.m;
import r7.m.b;
import y0.c;
import y0.c.a;

class d
  extends e
{
  private static final boolean t = true;
  private final TextWatcher e = new a();
  private final View.OnFocusChangeListener f = new e();
  private final TextInputLayout.e g = new f(this.a);
  private final TextInputLayout.f h = new g();
  @SuppressLint({"ClickableViewAccessibility"})
  private final TextInputLayout.g i = new h();
  private final View.OnAttachStateChangeListener j = new i();
  private final c.a k = new j();
  private boolean l = false;
  private boolean m = false;
  private long n = 9223372036854775807L;
  private StateListDrawable o;
  private h p;
  private AccessibilityManager q;
  private ValueAnimator r;
  private ValueAnimator s;
  
  d(TextInputLayout paramTextInputLayout, int paramInt)
  {
    super(paramTextInputLayout, paramInt);
  }
  
  private void A(AutoCompleteTextView paramAutoCompleteTextView, int paramInt, int[][] paramArrayOfInt, h paramh)
  {
    int i1 = g7.a.d(paramAutoCompleteTextView, R.attr.colorSurface);
    h localh1 = new h(paramh.E());
    paramInt = g7.a.h(paramInt, i1, 0.1F);
    localh1.b0(new ColorStateList(paramArrayOfInt, new int[] { paramInt, 0 }));
    if (t)
    {
      localh1.setTint(i1);
      paramArrayOfInt = new ColorStateList(paramArrayOfInt, new int[] { paramInt, i1 });
      h localh2 = new h(paramh.E());
      localh2.setTint(-1);
      paramArrayOfInt = new LayerDrawable(new Drawable[] { new RippleDrawable(paramArrayOfInt, localh1, localh2), paramh });
    }
    else
    {
      paramArrayOfInt = new LayerDrawable(new Drawable[] { localh1, paramh });
    }
    x.u0(paramAutoCompleteTextView, paramArrayOfInt);
  }
  
  private void B()
  {
    if (this.q != null)
    {
      TextInputLayout localTextInputLayout = this.a;
      if ((localTextInputLayout != null) && (x.T(localTextInputLayout))) {
        c.a(this.q, this.k);
      }
    }
  }
  
  private static AutoCompleteTextView C(EditText paramEditText)
  {
    if ((paramEditText instanceof AutoCompleteTextView)) {
      return (AutoCompleteTextView)paramEditText;
    }
    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
  }
  
  private ValueAnimator D(int paramInt, float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(e7.a.a);
    paramVarArgs.setDuration(paramInt);
    paramVarArgs.addUpdateListener(new d());
    return paramVarArgs;
  }
  
  private h E(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    m localm = m.a().E(paramFloat1).I(paramFloat1).v(paramFloat2).z(paramFloat2).m();
    h localh = h.m(this.b, paramFloat3);
    localh.setShapeAppearanceModel(localm);
    localh.d0(0, paramInt, 0, paramInt);
    return localh;
  }
  
  private void F()
  {
    this.s = D(67, new float[] { 0.0F, 1.0F });
    ValueAnimator localValueAnimator = D(50, new float[] { 1.0F, 0.0F });
    this.r = localValueAnimator;
    localValueAnimator.addListener(new c());
  }
  
  private boolean G()
  {
    long l1 = System.currentTimeMillis() - this.n;
    return (l1 < 0L) || (l1 > 300L);
  }
  
  private static boolean H(EditText paramEditText)
  {
    return paramEditText.getKeyListener() != null;
  }
  
  private void I()
  {
    AccessibilityManager localAccessibilityManager = this.q;
    if (localAccessibilityManager != null) {
      c.b(localAccessibilityManager, this.k);
    }
  }
  
  private void J(boolean paramBoolean)
  {
    if (this.m != paramBoolean)
    {
      this.m = paramBoolean;
      this.s.cancel();
      this.r.start();
    }
  }
  
  private void K(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (t)
    {
      int i1 = this.a.getBoxBackgroundMode();
      if (i1 == 2) {}
      for (Object localObject = this.p;; localObject = this.o)
      {
        paramAutoCompleteTextView.setDropDownBackgroundDrawable((Drawable)localObject);
        return;
        if (i1 != 1) {
          break;
        }
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void L(final AutoCompleteTextView paramAutoCompleteTextView)
  {
    paramAutoCompleteTextView.setOnTouchListener(new l(paramAutoCompleteTextView));
    paramAutoCompleteTextView.setOnFocusChangeListener(this.f);
    if (t) {
      paramAutoCompleteTextView.setOnDismissListener(new b());
    }
  }
  
  private void M(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (paramAutoCompleteTextView == null) {
      return;
    }
    if (G()) {
      this.l = false;
    }
    if (!this.l)
    {
      if (t)
      {
        J(this.m ^ true);
      }
      else
      {
        this.m ^= true;
        this.c.toggle();
      }
      if (this.m)
      {
        paramAutoCompleteTextView.requestFocus();
        paramAutoCompleteTextView.showDropDown();
        return;
      }
      paramAutoCompleteTextView.dismissDropDown();
      return;
    }
    this.l = false;
  }
  
  private void N()
  {
    this.l = true;
    this.n = System.currentTimeMillis();
  }
  
  private void y(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (H(paramAutoCompleteTextView)) {
      return;
    }
    int i1 = this.a.getBoxBackgroundMode();
    h localh = this.a.getBoxBackground();
    int i2 = g7.a.d(paramAutoCompleteTextView, R.attr.colorControlHighlight);
    int[][] arrayOfInt = new int[2][];
    arrayOfInt[0] = { 16842919 };
    arrayOfInt[1] = new int[0];
    if (i1 == 2)
    {
      A(paramAutoCompleteTextView, i2, arrayOfInt, localh);
      return;
    }
    if (i1 == 1) {
      z(paramAutoCompleteTextView, i2, arrayOfInt, localh);
    }
  }
  
  private void z(AutoCompleteTextView paramAutoCompleteTextView, int paramInt, int[][] paramArrayOfInt, h paramh)
  {
    int i1 = this.a.getBoxBackgroundColor();
    paramInt = g7.a.h(paramInt, i1, 0.1F);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt;
    arrayOfInt[1] = i1;
    if (t)
    {
      x.u0(paramAutoCompleteTextView, new RippleDrawable(new ColorStateList(paramArrayOfInt, arrayOfInt), paramh, paramh));
      return;
    }
    h localh = new h(paramh.E());
    localh.b0(new ColorStateList(paramArrayOfInt, arrayOfInt));
    paramArrayOfInt = new LayerDrawable(new Drawable[] { paramh, localh });
    paramInt = x.G(paramAutoCompleteTextView);
    i1 = paramAutoCompleteTextView.getPaddingTop();
    int i2 = x.F(paramAutoCompleteTextView);
    int i3 = paramAutoCompleteTextView.getPaddingBottom();
    x.u0(paramAutoCompleteTextView, paramArrayOfInt);
    x.F0(paramAutoCompleteTextView, paramInt, i1, i2, i3);
  }
  
  void O(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if ((!H(paramAutoCompleteTextView)) && (this.a.getBoxBackgroundMode() == 2))
    {
      if (!(paramAutoCompleteTextView.getBackground() instanceof LayerDrawable)) {
        return;
      }
      y(paramAutoCompleteTextView);
    }
  }
  
  void a()
  {
    float f1 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
    float f2 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
    int i1 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
    Object localObject = E(f1, f1, f2, i1);
    h localh = E(0.0F, f1, f2, i1);
    this.p = ((h)localObject);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    this.o = localStateListDrawable;
    localStateListDrawable.addState(new int[] { 16842922 }, (Drawable)localObject);
    this.o.addState(new int[0], localh);
    int i2 = this.d;
    i1 = i2;
    if (i2 == 0) {
      if (t) {
        i1 = R.drawable.mtrl_dropdown_arrow;
      } else {
        i1 = R.drawable.mtrl_ic_arrow_drop_down;
      }
    }
    this.a.setEndIconDrawable(i1);
    localObject = this.a;
    ((TextInputLayout)localObject).setEndIconContentDescription(((LinearLayout)localObject).getResources().getText(R.string.exposed_dropdown_menu_content_description));
    this.a.setEndIconOnClickListener(new k());
    this.a.g(this.h);
    this.a.h(this.i);
    F();
    this.q = ((AccessibilityManager)this.b.getSystemService("accessibility"));
    this.a.addOnAttachStateChangeListener(this.j);
    B();
  }
  
  boolean b(int paramInt)
  {
    return paramInt != 0;
  }
  
  boolean d()
  {
    return true;
  }
  
  class a
    extends o
  {
    a() {}
    
    public void afterTextChanged(final Editable paramEditable)
    {
      paramEditable = d.e(d.this.a.getEditText());
      if ((d.f(d.this).isTouchExplorationEnabled()) && (d.q(paramEditable)) && (!d.this.c.hasFocus())) {
        paramEditable.dismissDropDown();
      }
      paramEditable.post(new a(paramEditable));
    }
    
    class a
      implements Runnable
    {
      a(AutoCompleteTextView paramAutoCompleteTextView) {}
      
      public void run()
      {
        boolean bool = paramEditable.isPopupShowing();
        d.r(d.this, bool);
        d.s(d.this, bool);
      }
    }
  }
  
  class b
    implements AutoCompleteTextView.OnDismissListener
  {
    b() {}
    
    public void onDismiss()
    {
      d.u(d.this);
      d.r(d.this, false);
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = d.this;
      paramAnimator.c.setChecked(d.o(paramAnimator));
      d.p(d.this).start();
    }
  }
  
  class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      d.this.c.setAlpha(f);
    }
  }
  
  class e
    implements View.OnFocusChangeListener
  {
    e() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      d.this.a.setEndIconActivated(paramBoolean);
      if (!paramBoolean)
      {
        d.r(d.this, false);
        d.s(d.this, false);
      }
    }
  }
  
  class f
    extends TextInputLayout.e
  {
    f(TextInputLayout paramTextInputLayout)
    {
      super();
    }
    
    public void g(View paramView, y0.d paramd)
    {
      super.g(paramView, paramd);
      if (!d.q(d.this.a.getEditText())) {
        paramd.c0(Spinner.class.getName());
      }
      if (paramd.M()) {
        paramd.n0(null);
      }
    }
    
    public void h(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.h(paramView, paramAccessibilityEvent);
      paramView = d.e(d.this.a.getEditText());
      if ((paramAccessibilityEvent.getEventType() == 1) && (d.f(d.this).isEnabled()) && (!d.q(d.this.a.getEditText())))
      {
        d.t(d.this, paramView);
        d.u(d.this);
      }
    }
  }
  
  class g
    implements TextInputLayout.f
  {
    g() {}
    
    public void a(TextInputLayout paramTextInputLayout)
    {
      AutoCompleteTextView localAutoCompleteTextView = d.e(paramTextInputLayout.getEditText());
      d.v(d.this, localAutoCompleteTextView);
      d.w(d.this, localAutoCompleteTextView);
      d.x(d.this, localAutoCompleteTextView);
      localAutoCompleteTextView.setThreshold(0);
      localAutoCompleteTextView.removeTextChangedListener(d.g(d.this));
      localAutoCompleteTextView.addTextChangedListener(d.g(d.this));
      paramTextInputLayout.setEndIconCheckable(true);
      paramTextInputLayout.setErrorIconDrawable(null);
      if ((!d.q(localAutoCompleteTextView)) && (d.f(d.this).isTouchExplorationEnabled())) {
        x.B0(d.this.c, 2);
      }
      paramTextInputLayout.setTextInputAccessibilityDelegate(d.h(d.this));
      paramTextInputLayout.setEndIconVisible(true);
    }
  }
  
  class h
    implements TextInputLayout.g
  {
    h() {}
    
    public void a(TextInputLayout paramTextInputLayout, int paramInt)
    {
      final AutoCompleteTextView localAutoCompleteTextView = (AutoCompleteTextView)paramTextInputLayout.getEditText();
      if ((localAutoCompleteTextView != null) && (paramInt == 3))
      {
        localAutoCompleteTextView.post(new a(localAutoCompleteTextView));
        if (localAutoCompleteTextView.getOnFocusChangeListener() == d.i(d.this)) {
          localAutoCompleteTextView.setOnFocusChangeListener(null);
        }
        localAutoCompleteTextView.setOnTouchListener(null);
        if (d.j()) {
          localAutoCompleteTextView.setOnDismissListener(null);
        }
      }
      if (paramInt == 3)
      {
        paramTextInputLayout.removeOnAttachStateChangeListener(d.k(d.this));
        d.l(d.this);
      }
    }
    
    class a
      implements Runnable
    {
      a(AutoCompleteTextView paramAutoCompleteTextView) {}
      
      public void run()
      {
        localAutoCompleteTextView.removeTextChangedListener(d.g(d.this));
      }
    }
  }
  
  class i
    implements View.OnAttachStateChangeListener
  {
    i() {}
    
    public void onViewAttachedToWindow(View paramView)
    {
      d.m(d.this);
    }
    
    public void onViewDetachedFromWindow(View paramView)
    {
      d.l(d.this);
    }
  }
  
  class j
    implements c.a
  {
    j() {}
    
    public void onTouchExplorationStateChanged(boolean paramBoolean)
    {
      Object localObject = d.this.a;
      if (localObject != null)
      {
        localObject = (AutoCompleteTextView)((TextInputLayout)localObject).getEditText();
        if ((localObject != null) && (!d.q((EditText)localObject)))
        {
          localObject = d.this.c;
          int i;
          if (paramBoolean) {
            i = 2;
          } else {
            i = 1;
          }
          x.B0((View)localObject, i);
        }
      }
    }
  }
  
  class k
    implements View.OnClickListener
  {
    k() {}
    
    public void onClick(View paramView)
    {
      paramView = (AutoCompleteTextView)d.this.a.getEditText();
      d.t(d.this, paramView);
    }
  }
  
  class l
    implements View.OnTouchListener
  {
    l(AutoCompleteTextView paramAutoCompleteTextView) {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 1)
      {
        if (d.n(d.this)) {
          d.s(d.this, false);
        }
        d.t(d.this, paramAutoCompleteTextView);
        d.u(d.this);
      }
      return false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.d
 * JD-Core Version:    0.7.0.1
 */