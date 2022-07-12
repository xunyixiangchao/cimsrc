package com.google.android.material.textfield;

import android.content.res.Resources;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.google.android.material.R.drawable;
import com.google.android.material.R.string;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.o;

class i
  extends e
{
  private final TextWatcher e = new a();
  private final TextInputLayout.f f = new b();
  private final TextInputLayout.g g = new c();
  
  i(TextInputLayout paramTextInputLayout, int paramInt)
  {
    super(paramTextInputLayout, paramInt);
  }
  
  private boolean g()
  {
    EditText localEditText = this.a.getEditText();
    return (localEditText != null) && ((localEditText.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private static boolean h(EditText paramEditText)
  {
    return (paramEditText != null) && ((paramEditText.getInputType() == 16) || (paramEditText.getInputType() == 128) || (paramEditText.getInputType() == 144) || (paramEditText.getInputType() == 224));
  }
  
  void a()
  {
    Object localObject = this.a;
    int j = this.d;
    int i = j;
    if (j == 0) {
      i = R.drawable.design_password_eye;
    }
    ((TextInputLayout)localObject).setEndIconDrawable(i);
    localObject = this.a;
    ((TextInputLayout)localObject).setEndIconContentDescription(((LinearLayout)localObject).getResources().getText(R.string.password_toggle_content_description));
    this.a.setEndIconVisible(true);
    this.a.setEndIconCheckable(true);
    this.a.setEndIconOnClickListener(new d());
    this.a.g(this.f);
    this.a.h(this.g);
    localObject = this.a.getEditText();
    if (h((EditText)localObject)) {
      ((EditText)localObject).setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  class a
    extends o
  {
    a() {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      paramCharSequence = i.this;
      paramCharSequence.c.setChecked(i.e(paramCharSequence) ^ true);
    }
  }
  
  class b
    implements TextInputLayout.f
  {
    b() {}
    
    public void a(TextInputLayout paramTextInputLayout)
    {
      paramTextInputLayout = paramTextInputLayout.getEditText();
      i locali = i.this;
      locali.c.setChecked(i.e(locali) ^ true);
      paramTextInputLayout.removeTextChangedListener(i.f(i.this));
      paramTextInputLayout.addTextChangedListener(i.f(i.this));
    }
  }
  
  class c
    implements TextInputLayout.g
  {
    c() {}
    
    public void a(final TextInputLayout paramTextInputLayout, int paramInt)
    {
      paramTextInputLayout = paramTextInputLayout.getEditText();
      if ((paramTextInputLayout != null) && (paramInt == 1))
      {
        paramTextInputLayout.setTransformationMethod(PasswordTransformationMethod.getInstance());
        paramTextInputLayout.post(new a(paramTextInputLayout));
      }
    }
    
    class a
      implements Runnable
    {
      a(EditText paramEditText) {}
      
      public void run()
      {
        paramTextInputLayout.removeTextChangedListener(i.f(i.this));
      }
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      EditText localEditText = i.this.a.getEditText();
      if (localEditText == null) {
        return;
      }
      int i = localEditText.getSelectionEnd();
      if (i.e(i.this)) {
        paramView = null;
      } else {
        paramView = PasswordTransformationMethod.getInstance();
      }
      localEditText.setTransformationMethod(paramView);
      if (i >= 0) {
        localEditText.setSelection(i);
      }
      i.this.a.U();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.i
 * JD-Core Version:    0.7.0.1
 */