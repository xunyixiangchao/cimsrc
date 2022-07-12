package com.farsunset.hoxin.common.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import cn.dreamtobe.kpswitch.widget.KPSwitchPanelLinearLayout;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import com.farsunset.hoxin.message.widget.EmoticonPanelView;
import d4.b;
import java.util.regex.Matcher;
import r5.d;
import s3.n;
import u3.l;
import v3.i;
import x1.a;
import x1.a.c;
import x1.a.d;
import x1.c;
import x1.c.b;

public class SimpleInputPanelView
  extends LinearLayout
  implements View.OnClickListener, TextWatcher, InputFilter, a.d, c.b, d
{
  private final DisplayMetrics a = Resources.getSystem().getDisplayMetrics();
  protected View b;
  protected View c;
  protected EditText d;
  protected EmoticonPanelView e;
  protected n f;
  protected KPSwitchPanelLinearLayout g;
  
  public SimpleInputPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private ImageSpan l(String paramString)
  {
    paramString = b.d().e(paramString);
    if (paramString == null) {
      return null;
    }
    int i = (int)TypedValue.applyDimension(1, 22.0F, this.a);
    paramString.setBounds(0, 0, i, i);
    return new ImageSpan(paramString, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f.q(paramBoolean);
    if (paramBoolean) {
      this.b.setSelected(false);
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void b()
  {
    KeyEvent localKeyEvent = new KeyEvent(0, 67);
    this.d.onKeyDown(67, localKeyEvent);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c(View paramView, boolean paramBoolean)
  {
    View localView = this.b;
    if (paramView == localView) {
      localView.setSelected(paramBoolean);
    }
  }
  
  public void e(CharSequence paramCharSequence)
  {
    this.d.getText().clear();
    this.d.getText().append(paramCharSequence);
    this.d.requestFocus();
  }
  
  public void f()
  {
    this.d.getText().clear();
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if ("@".equals(paramCharSequence.toString())) {
      this.f.j0();
    }
    return paramCharSequence;
  }
  
  public void g()
  {
    this.d.clearFocus();
    this.d.setHint(null);
    this.d.setText(null);
    this.b.setSelected(false);
    c.h(this.d);
    setVisibility(8);
  }
  
  public String getInputText()
  {
    return this.d.getText().toString();
  }
  
  public String getInputTextTrim()
  {
    return this.d.getText().toString().trim();
  }
  
  public int getPanelHeight()
  {
    return getMeasuredHeight() + c.c(getContext());
  }
  
  public void h()
  {
    this.b.setSelected(false);
    a.d(this.g);
  }
  
  protected void i()
  {
    c.b((Activity)getContext(), this.g, this);
    a.b(this.g, this.d, this, new a.c[] { new a.c(this.e, this.b) });
  }
  
  public void j(EmoticonItem paramEmoticonItem)
  {
    this.d.setCursorVisible(true);
    SpannableString localSpannableString = new SpannableString(paramEmoticonItem.name);
    localSpannableString.setSpan(l(paramEmoticonItem.name), 0, paramEmoticonItem.name.length(), 33);
    this.d.getEditableText().insert(this.d.getSelectionStart(), localSpannableString);
  }
  
  public void m()
  {
    this.b.setSelected(false);
    a.d(this.g);
    this.d.setText(null);
  }
  
  public void n()
  {
    setVisibility(0);
    this.d.postDelayed(new i(this), 50L);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    i();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131231432) && (l.c0(this.d.getText()))) {
      this.f.n0(this.d.getText().toString());
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    Object localObject = findViewById(2131231432);
    this.c = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.d = ((EditText)findViewById(2131231090));
    localObject = (EmoticonPanelView)findViewById(2131230979);
    this.e = ((EmoticonPanelView)localObject);
    ((EmoticonPanelView)localObject).setOnEmoticonEventListener(this);
    this.d.addTextChangedListener(this);
    this.d.setFilters(new InputFilter[] { this });
    this.b = findViewById(2131230873);
    this.g = ((KPSwitchPanelLinearLayout)findViewById(2131230733));
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f.q0(paramCharSequence.toString());
  }
  
  public void setContent(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void setHint(String paramString)
  {
    this.d.setHint(paramString);
  }
  
  public void setInputText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SpannableString localSpannableString = new SpannableString(paramString);
    paramString = b.d().i(paramString);
    while (paramString.find()) {
      localSpannableString.setSpan(l(paramString.group()), paramString.start(), paramString.end(), 33);
    }
    this.d.setText(localSpannableString);
    paramString = this.d;
    paramString.setSelection(paramString.getText().length());
    this.d.requestFocus();
  }
  
  public void setOnInputPanelEventListener(n paramn)
  {
    this.f = paramn;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.SimpleInputPanelView
 * JD-Core Version:    0.7.0.1
 */