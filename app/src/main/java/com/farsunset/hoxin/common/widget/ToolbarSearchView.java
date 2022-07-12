package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import s3.a0;
import s3.x;
import x1.c;

public class ToolbarSearchView
  extends RelativeLayout
  implements View.OnClickListener, TextView.OnEditorActionListener, TextWatcher
{
  private EditText a;
  private x b;
  private a0 c;
  
  public ToolbarSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.a.setText(null);
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void b()
  {
    c.h(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    this.a.removeTextChangedListener(this);
  }
  
  public void d()
  {
    this.a.requestFocus();
  }
  
  public void e()
  {
    this.a.removeTextChangedListener(this);
    this.a.addTextChangedListener(this);
  }
  
  public String getText()
  {
    return this.a.getText().toString().trim();
  }
  
  public void onClick(View paramView)
  {
    this.a.setText(null);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramTextView = this.b;
    if (paramTextView != null) {
      paramTextView.b0(getText());
    }
    return false;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    EditText localEditText = (EditText)findViewById(2131231120);
    this.a = localEditText;
    localEditText.setOnEditorActionListener(this);
    this.a.addTextChangedListener(this);
    this.a.setImeOptions(3);
    findViewById(2131230887).setOnClickListener(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if (paramInt1 != 0)
    {
      a0 locala0 = this.c;
      if (locala0 != null) {
        locala0.h0(paramCharSequence.toString().trim());
      }
    }
  }
  
  public void setBoldText(boolean paramBoolean)
  {
    this.a.getPaint().setFakeBoldText(paramBoolean);
  }
  
  public void setHint(int paramInt)
  {
    this.a.setHint(paramInt);
  }
  
  public void setHint(Spanned paramSpanned)
  {
    this.a.setHint(paramSpanned);
  }
  
  public void setInputType(int paramInt)
  {
    this.a.setInputType(paramInt);
  }
  
  public void setMaxLength(int paramInt)
  {
    this.a.setFilters(new InputFilter[] { new a(paramInt) });
  }
  
  public void setOnSearchActionListener(x paramx)
  {
    this.b = paramx;
  }
  
  public void setOnTextChangedListener(a0 parama0)
  {
    this.c = parama0;
  }
  
  public void setText(String paramString)
  {
    this.a.setText(paramString);
  }
  
  class a
    extends InputFilter.LengthFilter
  {
    a(int paramInt)
    {
      super();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.ToolbarSearchView
 * JD-Core Version:    0.7.0.1
 */