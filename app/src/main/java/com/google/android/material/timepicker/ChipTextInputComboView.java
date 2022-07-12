package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.o;
import com.google.android.material.internal.t;
import com.google.android.material.textfield.TextInputLayout;

class ChipTextInputComboView
  extends FrameLayout
  implements Checkable
{
  private final Chip a;
  private final TextInputLayout b;
  private final EditText c;
  private TextWatcher d;
  private TextView e;
  
  public ChipTextInputComboView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChipTextInputComboView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = LayoutInflater.from(paramContext);
    paramContext = (Chip)paramAttributeSet.inflate(R.layout.material_time_chip, this, false);
    this.a = paramContext;
    paramContext.setAccessibilityClassName("android.view.View");
    paramAttributeSet = (TextInputLayout)paramAttributeSet.inflate(R.layout.material_time_input, this, false);
    this.b = paramAttributeSet;
    EditText localEditText = paramAttributeSet.getEditText();
    this.c = localEditText;
    localEditText.setVisibility(4);
    b localb = new b(null);
    this.d = localb;
    localEditText.addTextChangedListener(localb);
    d();
    addView(paramContext);
    addView(paramAttributeSet);
    this.e = ((TextView)findViewById(R.id.material_label));
    localEditText.setSaveEnabled(false);
    localEditText.setLongClickable(false);
  }
  
  private String c(CharSequence paramCharSequence)
  {
    return TimeModel.g(getResources(), paramCharSequence);
  }
  
  private void d()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      LocaleList localLocaleList = getContext().getResources().getConfiguration().getLocales();
      this.c.setImeHintLocales(localLocaleList);
    }
  }
  
  public boolean isChecked()
  {
    return this.a.isChecked();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    d();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.a.setChecked(paramBoolean);
    Object localObject = this.c;
    int j = 0;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    ((EditText)localObject).setVisibility(i);
    localObject = this.a;
    int i = j;
    if (paramBoolean) {
      i = 8;
    }
    ((CheckBox)localObject).setVisibility(i);
    if (isChecked())
    {
      t.l(this.c);
      if (!TextUtils.isEmpty(this.c.getText()))
      {
        localObject = this.c;
        ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void setTag(int paramInt, Object paramObject)
  {
    this.a.setTag(paramInt, paramObject);
  }
  
  public void toggle()
  {
    this.a.toggle();
  }
  
  private class b
    extends o
  {
    private b() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (TextUtils.isEmpty(paramEditable))
      {
        ChipTextInputComboView.b(ChipTextInputComboView.this).setText(ChipTextInputComboView.a(ChipTextInputComboView.this, "00"));
        return;
      }
      ChipTextInputComboView.b(ChipTextInputComboView.this).setText(ChipTextInputComboView.a(ChipTextInputComboView.this, paramEditable));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.timepicker.ChipTextInputComboView
 * JD-Core Version:    0.7.0.1
 */