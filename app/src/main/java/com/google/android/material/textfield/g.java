package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.x;
import androidx.core.widget.l;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import e7.a;
import e7.b;
import java.util.ArrayList;
import java.util.List;
import o7.c;

final class g
{
  private final Context a;
  private final TextInputLayout b;
  private LinearLayout c;
  private int d;
  private FrameLayout e;
  private Animator f;
  private final float g;
  private int h;
  private int i;
  private CharSequence j;
  private boolean k;
  private TextView l;
  private CharSequence m;
  private int n;
  private ColorStateList o;
  private CharSequence p;
  private boolean q;
  private TextView r;
  private int s;
  private ColorStateList t;
  private Typeface u;
  
  public g(TextInputLayout paramTextInputLayout)
  {
    Context localContext = paramTextInputLayout.getContext();
    this.a = localContext;
    this.b = paramTextInputLayout;
    this.g = localContext.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
  }
  
  private void C(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    TextView localTextView;
    if (paramInt2 != 0)
    {
      localTextView = m(paramInt2);
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        localTextView.setAlpha(1.0F);
      }
    }
    if (paramInt1 != 0)
    {
      localTextView = m(paramInt1);
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        if (paramInt1 == 1) {
          localTextView.setText(null);
        }
      }
    }
    this.h = paramInt2;
  }
  
  private void K(TextView paramTextView, Typeface paramTypeface)
  {
    if (paramTextView != null) {
      paramTextView.setTypeface(paramTypeface);
    }
  }
  
  private void M(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      paramViewGroup.setVisibility(8);
    }
  }
  
  private boolean N(TextView paramTextView, CharSequence paramCharSequence)
  {
    return (x.U(this.b)) && (this.b.isEnabled()) && ((this.i != this.h) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence)));
  }
  
  private void Q(final int paramInt1, final int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.f = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      i(localArrayList, this.q, this.r, 2, paramInt1, paramInt2);
      i(localArrayList, this.k, this.l, 1, paramInt1, paramInt2);
      b.a(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new a(paramInt2, m(paramInt1), paramInt1, m(paramInt2)));
      localAnimatorSet.start();
    }
    else
    {
      C(paramInt1, paramInt2);
    }
    this.b.r0();
    this.b.w0(paramBoolean);
    this.b.E0();
  }
  
  private boolean g()
  {
    return (this.c != null) && (this.b.getEditText() != null);
  }
  
  private void i(List<Animator> paramList, boolean paramBoolean, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTextView != null)
    {
      if (!paramBoolean) {
        return;
      }
      if ((paramInt1 == paramInt3) || (paramInt1 == paramInt2))
      {
        if (paramInt3 == paramInt1) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramList.add(j(paramTextView, paramBoolean));
        if (paramInt3 == paramInt1) {
          paramList.add(k(paramTextView));
        }
      }
    }
  }
  
  private ObjectAnimator j(TextView paramTextView, boolean paramBoolean)
  {
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f1 });
    paramTextView.setDuration(167L);
    paramTextView.setInterpolator(a.a);
    return paramTextView;
  }
  
  private ObjectAnimator k(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.g, 0.0F });
    paramTextView.setDuration(217L);
    paramTextView.setInterpolator(a.d);
    return paramTextView;
  }
  
  private TextView m(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      return this.r;
    }
    return this.l;
  }
  
  private int u(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      paramInt2 = this.a.getResources().getDimensionPixelSize(paramInt1);
    }
    return paramInt2;
  }
  
  private boolean x(int paramInt)
  {
    return (paramInt == 1) && (this.l != null) && (!TextUtils.isEmpty(this.j));
  }
  
  boolean A()
  {
    return this.q;
  }
  
  void B(TextView paramTextView, int paramInt)
  {
    if (this.c == null) {
      return;
    }
    if (y(paramInt))
    {
      FrameLayout localFrameLayout = this.e;
      if (localFrameLayout != null)
      {
        localFrameLayout.removeView(paramTextView);
        break label41;
      }
    }
    this.c.removeView(paramTextView);
    label41:
    paramInt = this.d - 1;
    this.d = paramInt;
    M(this.c, paramInt);
  }
  
  void D(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
    TextView localTextView = this.l;
    if (localTextView != null) {
      localTextView.setContentDescription(paramCharSequence);
    }
  }
  
  void E(boolean paramBoolean)
  {
    if (this.k == paramBoolean) {
      return;
    }
    h();
    if (paramBoolean)
    {
      Object localObject = new AppCompatTextView(this.a);
      this.l = ((TextView)localObject);
      ((TextView)localObject).setId(R.id.textinput_error);
      this.l.setTextAlignment(5);
      localObject = this.u;
      if (localObject != null) {
        this.l.setTypeface((Typeface)localObject);
      }
      F(this.n);
      G(this.o);
      D(this.m);
      this.l.setVisibility(4);
      x.s0(this.l, 1);
      e(this.l, 0);
    }
    else
    {
      v();
      B(this.l, 0);
      this.l = null;
      this.b.r0();
      this.b.E0();
    }
    this.k = paramBoolean;
  }
  
  void F(int paramInt)
  {
    this.n = paramInt;
    TextView localTextView = this.l;
    if (localTextView != null) {
      this.b.d0(localTextView, paramInt);
    }
  }
  
  void G(ColorStateList paramColorStateList)
  {
    this.o = paramColorStateList;
    TextView localTextView = this.l;
    if ((localTextView != null) && (paramColorStateList != null)) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  void H(int paramInt)
  {
    this.s = paramInt;
    TextView localTextView = this.r;
    if (localTextView != null) {
      l.o(localTextView, paramInt);
    }
  }
  
  void I(boolean paramBoolean)
  {
    if (this.q == paramBoolean) {
      return;
    }
    h();
    if (paramBoolean)
    {
      Object localObject = new AppCompatTextView(this.a);
      this.r = ((TextView)localObject);
      ((TextView)localObject).setId(R.id.textinput_helper_text);
      this.r.setTextAlignment(5);
      localObject = this.u;
      if (localObject != null) {
        this.r.setTypeface((Typeface)localObject);
      }
      this.r.setVisibility(4);
      x.s0(this.r, 1);
      H(this.s);
      J(this.t);
      e(this.r, 1);
      this.r.setAccessibilityDelegate(new b());
    }
    else
    {
      w();
      B(this.r, 1);
      this.r = null;
      this.b.r0();
      this.b.E0();
    }
    this.q = paramBoolean;
  }
  
  void J(ColorStateList paramColorStateList)
  {
    this.t = paramColorStateList;
    TextView localTextView = this.r;
    if ((localTextView != null) && (paramColorStateList != null)) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  void L(Typeface paramTypeface)
  {
    if (paramTypeface != this.u)
    {
      this.u = paramTypeface;
      K(this.l, paramTypeface);
      K(this.r, paramTypeface);
    }
  }
  
  void O(CharSequence paramCharSequence)
  {
    h();
    this.j = paramCharSequence;
    this.l.setText(paramCharSequence);
    int i1 = this.h;
    if (i1 != 1) {
      this.i = 1;
    }
    Q(i1, this.i, N(this.l, paramCharSequence));
  }
  
  void P(CharSequence paramCharSequence)
  {
    h();
    this.p = paramCharSequence;
    this.r.setText(paramCharSequence);
    int i1 = this.h;
    if (i1 != 2) {
      this.i = 2;
    }
    Q(i1, this.i, N(this.r, paramCharSequence));
  }
  
  void e(TextView paramTextView, int paramInt)
  {
    Object localObject;
    if ((this.c == null) && (this.e == null))
    {
      localObject = new LinearLayout(this.a);
      this.c = ((LinearLayout)localObject);
      ((LinearLayout)localObject).setOrientation(0);
      this.b.addView(this.c, -1, -2);
      this.e = new FrameLayout(this.a);
      localObject = new LinearLayout.LayoutParams(0, -2, 1.0F);
      this.c.addView(this.e, (ViewGroup.LayoutParams)localObject);
      if (this.b.getEditText() != null) {
        f();
      }
    }
    if (y(paramInt))
    {
      this.e.setVisibility(0);
      this.e.addView(paramTextView);
    }
    else
    {
      localObject = new LinearLayout.LayoutParams(-2, -2);
      this.c.addView(paramTextView, (ViewGroup.LayoutParams)localObject);
    }
    this.c.setVisibility(0);
    this.d += 1;
  }
  
  void f()
  {
    if (g())
    {
      EditText localEditText = this.b.getEditText();
      boolean bool = c.i(this.a);
      LinearLayout localLinearLayout = this.c;
      int i1 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
      x.F0(localLinearLayout, u(bool, i1, x.G(localEditText)), u(bool, R.dimen.material_helper_text_font_1_3_padding_top, this.a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), u(bool, i1, x.F(localEditText)), 0);
    }
  }
  
  void h()
  {
    Animator localAnimator = this.f;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  boolean l()
  {
    return x(this.i);
  }
  
  CharSequence n()
  {
    return this.m;
  }
  
  CharSequence o()
  {
    return this.j;
  }
  
  int p()
  {
    TextView localTextView = this.l;
    if (localTextView != null) {
      return localTextView.getCurrentTextColor();
    }
    return -1;
  }
  
  ColorStateList q()
  {
    TextView localTextView = this.l;
    if (localTextView != null) {
      return localTextView.getTextColors();
    }
    return null;
  }
  
  CharSequence r()
  {
    return this.p;
  }
  
  View s()
  {
    return this.r;
  }
  
  int t()
  {
    TextView localTextView = this.r;
    if (localTextView != null) {
      return localTextView.getCurrentTextColor();
    }
    return -1;
  }
  
  void v()
  {
    this.j = null;
    h();
    if (this.h == 1)
    {
      int i1;
      if ((this.q) && (!TextUtils.isEmpty(this.p))) {
        i1 = 2;
      } else {
        i1 = 0;
      }
      this.i = i1;
    }
    Q(this.h, this.i, N(this.l, ""));
  }
  
  void w()
  {
    h();
    int i1 = this.h;
    if (i1 == 2) {
      this.i = 0;
    }
    Q(i1, this.i, N(this.r, ""));
  }
  
  boolean y(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  boolean z()
  {
    return this.k;
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a(int paramInt1, TextView paramTextView1, int paramInt2, TextView paramTextView2) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      g.a(g.this, paramInt2);
      g.b(g.this, null);
      paramAnimator = this.b;
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(4);
        if ((paramInt1 == 1) && (g.c(g.this) != null)) {
          g.c(g.this).setText(null);
        }
      }
      paramAnimator = this.d;
      if (paramAnimator != null)
      {
        paramAnimator.setTranslationY(0.0F);
        this.d.setAlpha(1.0F);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      paramAnimator = this.d;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
    }
  }
  
  class b
    extends View.AccessibilityDelegate
  {
    b() {}
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
      paramView = g.d(g.this).getEditText();
      if (paramView != null) {
        paramAccessibilityNodeInfo.setLabeledBy(paramView);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.g
 * JD-Core Version:    0.7.0.1
 */