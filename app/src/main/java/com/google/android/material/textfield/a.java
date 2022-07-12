package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.google.android.material.R.drawable;
import com.google.android.material.R.string;

class a
  extends e
{
  private final TextWatcher e = new a();
  private final View.OnFocusChangeListener f = new b();
  private final TextInputLayout.f g = new c();
  private final TextInputLayout.g h = new d();
  private AnimatorSet i;
  private ValueAnimator j;
  
  a(TextInputLayout paramTextInputLayout, int paramInt)
  {
    super(paramTextInputLayout, paramInt);
  }
  
  private void i(boolean paramBoolean)
  {
    int k;
    if (this.a.K() == paramBoolean) {
      k = 1;
    } else {
      k = 0;
    }
    if ((paramBoolean) && (!this.i.isRunning()))
    {
      this.j.cancel();
      this.i.start();
      if (k != 0) {
        this.i.end();
      }
    }
    else if (!paramBoolean)
    {
      this.i.cancel();
      this.j.start();
      if (k != 0) {
        this.j.end();
      }
    }
  }
  
  private ValueAnimator j(float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(e7.a.a);
    paramVarArgs.setDuration(100L);
    paramVarArgs.addUpdateListener(new h());
    return paramVarArgs;
  }
  
  private ValueAnimator k()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.8F, 1.0F });
    localValueAnimator.setInterpolator(e7.a.d);
    localValueAnimator.setDuration(150L);
    localValueAnimator.addUpdateListener(new i());
    return localValueAnimator;
  }
  
  private void l()
  {
    ValueAnimator localValueAnimator1 = k();
    ValueAnimator localValueAnimator2 = j(new float[] { 0.0F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    this.i = localAnimatorSet;
    localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    this.i.addListener(new f());
    localValueAnimator1 = j(new float[] { 1.0F, 0.0F });
    this.j = localValueAnimator1;
    localValueAnimator1.addListener(new g());
  }
  
  private boolean m()
  {
    EditText localEditText = this.a.getEditText();
    return (localEditText != null) && ((localEditText.hasFocus()) || (this.c.hasFocus())) && (localEditText.getText().length() > 0);
  }
  
  void a()
  {
    TextInputLayout localTextInputLayout = this.a;
    int m = this.d;
    int k = m;
    if (m == 0) {
      k = R.drawable.mtrl_ic_cancel;
    }
    localTextInputLayout.setEndIconDrawable(k);
    localTextInputLayout = this.a;
    localTextInputLayout.setEndIconContentDescription(localTextInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
    this.a.setEndIconCheckable(false);
    this.a.setEndIconOnClickListener(new e());
    this.a.g(this.g);
    this.a.h(this.h);
    l();
  }
  
  void c(boolean paramBoolean)
  {
    if (this.a.getSuffixText() == null) {
      return;
    }
    i(paramBoolean);
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (a.this.a.getSuffixText() != null) {
        return;
      }
      paramEditable = a.this;
      a.f(paramEditable, a.e(paramEditable));
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class b
    implements View.OnFocusChangeListener
  {
    b() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      paramView = a.this;
      a.f(paramView, a.e(paramView));
    }
  }
  
  class c
    implements TextInputLayout.f
  {
    c() {}
    
    public void a(TextInputLayout paramTextInputLayout)
    {
      EditText localEditText = paramTextInputLayout.getEditText();
      paramTextInputLayout.setEndIconVisible(a.e(a.this));
      localEditText.setOnFocusChangeListener(a.g(a.this));
      paramTextInputLayout = a.this;
      paramTextInputLayout.c.setOnFocusChangeListener(a.g(paramTextInputLayout));
      localEditText.removeTextChangedListener(a.h(a.this));
      localEditText.addTextChangedListener(a.h(a.this));
    }
  }
  
  class d
    implements TextInputLayout.g
  {
    d() {}
    
    public void a(final TextInputLayout paramTextInputLayout, int paramInt)
    {
      paramTextInputLayout = paramTextInputLayout.getEditText();
      if ((paramTextInputLayout != null) && (paramInt == 2))
      {
        paramTextInputLayout.post(new a(paramTextInputLayout));
        if (paramTextInputLayout.getOnFocusChangeListener() == a.g(a.this)) {
          paramTextInputLayout.setOnFocusChangeListener(null);
        }
        if (a.this.c.getOnFocusChangeListener() == a.g(a.this)) {
          a.this.c.setOnFocusChangeListener(null);
        }
      }
    }
    
    class a
      implements Runnable
    {
      a(EditText paramEditText) {}
      
      public void run()
      {
        paramTextInputLayout.removeTextChangedListener(a.h(a.this));
        a.f(a.this, true);
      }
    }
  }
  
  class e
    implements View.OnClickListener
  {
    e() {}
    
    public void onClick(View paramView)
    {
      paramView = a.this.a.getEditText().getText();
      if (paramView != null) {
        paramView.clear();
      }
      a.this.a.U();
    }
  }
  
  class f
    extends AnimatorListenerAdapter
  {
    f() {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      a.this.a.setEndIconVisible(true);
    }
  }
  
  class g
    extends AnimatorListenerAdapter
  {
    g() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      a.this.a.setEndIconVisible(false);
    }
  }
  
  class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    h() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      a.this.c.setAlpha(f);
    }
  }
  
  class i
    implements ValueAnimator.AnimatorUpdateListener
  {
    i() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      a.this.c.setScaleX(f);
      a.this.c.setScaleY(f);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.a
 * JD-Core Version:    0.7.0.1
 */