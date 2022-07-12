package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.k0;
import androidx.core.view.h;
import androidx.core.view.x;
import androidx.core.widget.l;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.t;
import o7.c;
import y0.d;

@SuppressLint({"ViewConstructor"})
class j
  extends LinearLayout
{
  private final TextInputLayout a;
  private final TextView b;
  private CharSequence c;
  private final CheckableImageButton d;
  private ColorStateList e;
  private PorterDuff.Mode f;
  private View.OnLongClickListener g;
  private boolean h;
  
  j(TextInputLayout paramTextInputLayout, k0 paramk0)
  {
    super(paramTextInputLayout.getContext());
    this.a = paramTextInputLayout;
    setVisibility(8);
    setOrientation(0);
    setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
    paramTextInputLayout = (CheckableImageButton)LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, this, false);
    this.d = paramTextInputLayout;
    AppCompatTextView localAppCompatTextView = new AppCompatTextView(getContext());
    this.b = localAppCompatTextView;
    g(paramk0);
    f(paramk0);
    addView(paramTextInputLayout);
    addView(localAppCompatTextView);
  }
  
  private void f(k0 paramk0)
  {
    this.b.setVisibility(8);
    this.b.setId(R.id.textinput_prefix_text);
    this.b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    x.s0(this.b, 1);
    l(paramk0.n(R.styleable.TextInputLayout_prefixTextAppearance, 0));
    int i = R.styleable.TextInputLayout_prefixTextColor;
    if (paramk0.s(i)) {
      m(paramk0.c(i));
    }
    k(paramk0.p(R.styleable.TextInputLayout_prefixText));
  }
  
  private void g(k0 paramk0)
  {
    if (c.i(getContext())) {
      h.c((ViewGroup.MarginLayoutParams)this.d.getLayoutParams(), 0);
    }
    q(null);
    r(null);
    int i = R.styleable.TextInputLayout_startIconTint;
    if (paramk0.s(i)) {
      this.e = c.b(getContext(), paramk0, i);
    }
    i = R.styleable.TextInputLayout_startIconTintMode;
    if (paramk0.s(i)) {
      this.f = t.j(paramk0.k(i, -1), null);
    }
    i = R.styleable.TextInputLayout_startIconDrawable;
    if (paramk0.s(i))
    {
      p(paramk0.g(i));
      i = R.styleable.TextInputLayout_startIconContentDescription;
      if (paramk0.s(i)) {
        o(paramk0.p(i));
      }
      n(paramk0.a(R.styleable.TextInputLayout_startIconCheckable, true));
    }
  }
  
  private void x()
  {
    CharSequence localCharSequence = this.c;
    int k = 8;
    int i;
    if ((localCharSequence != null) && (!this.h)) {
      i = 0;
    } else {
      i = 8;
    }
    int j;
    if ((this.d.getVisibility() != 0) && (i != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      k = 0;
    }
    setVisibility(k);
    this.b.setVisibility(i);
    this.a.q0();
  }
  
  CharSequence a()
  {
    return this.c;
  }
  
  ColorStateList b()
  {
    return this.b.getTextColors();
  }
  
  TextView c()
  {
    return this.b;
  }
  
  CharSequence d()
  {
    return this.d.getContentDescription();
  }
  
  Drawable e()
  {
    return this.d.getDrawable();
  }
  
  boolean h()
  {
    return this.d.getVisibility() == 0;
  }
  
  void i(boolean paramBoolean)
  {
    this.h = paramBoolean;
    x();
  }
  
  void j()
  {
    f.c(this.a, this.d, this.e);
  }
  
  void k(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence;
    if (TextUtils.isEmpty(paramCharSequence)) {
      localCharSequence = null;
    } else {
      localCharSequence = paramCharSequence;
    }
    this.c = localCharSequence;
    this.b.setText(paramCharSequence);
    x();
  }
  
  void l(int paramInt)
  {
    l.o(this.b, paramInt);
  }
  
  void m(ColorStateList paramColorStateList)
  {
    this.b.setTextColor(paramColorStateList);
  }
  
  void n(boolean paramBoolean)
  {
    this.d.setCheckable(paramBoolean);
  }
  
  void o(CharSequence paramCharSequence)
  {
    if (d() != paramCharSequence) {
      this.d.setContentDescription(paramCharSequence);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    w();
  }
  
  void p(Drawable paramDrawable)
  {
    this.d.setImageDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      f.a(this.a, this.d, this.e, this.f);
      u(true);
      j();
      return;
    }
    u(false);
    q(null);
    r(null);
    o(null);
  }
  
  void q(View.OnClickListener paramOnClickListener)
  {
    f.e(this.d, paramOnClickListener, this.g);
  }
  
  void r(View.OnLongClickListener paramOnLongClickListener)
  {
    this.g = paramOnLongClickListener;
    f.f(this.d, paramOnLongClickListener);
  }
  
  void s(ColorStateList paramColorStateList)
  {
    if (this.e != paramColorStateList)
    {
      this.e = paramColorStateList;
      f.a(this.a, this.d, paramColorStateList, this.f);
    }
  }
  
  void t(PorterDuff.Mode paramMode)
  {
    if (this.f != paramMode)
    {
      this.f = paramMode;
      f.a(this.a, this.d, this.e, paramMode);
    }
  }
  
  void u(boolean paramBoolean)
  {
    if (h() != paramBoolean)
    {
      CheckableImageButton localCheckableImageButton = this.d;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localCheckableImageButton.setVisibility(i);
      w();
      x();
    }
  }
  
  void v(d paramd)
  {
    Object localObject;
    if (this.b.getVisibility() == 0)
    {
      paramd.o0(this.b);
      localObject = this.b;
    }
    else
    {
      localObject = this.d;
    }
    paramd.G0((View)localObject);
  }
  
  void w()
  {
    EditText localEditText = this.a.e;
    if (localEditText == null) {
      return;
    }
    int i;
    if (h()) {
      i = 0;
    } else {
      i = x.G(localEditText);
    }
    x.F0(this.b, i, localEditText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), localEditText.getCompoundPaddingBottom());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.j
 * JD-Core Version:    0.7.0.1
 */