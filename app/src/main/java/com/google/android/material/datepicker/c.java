package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.R.string;
import com.google.android.material.internal.o;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

abstract class c
  extends o
{
  private final TextInputLayout a;
  private final DateFormat b;
  private final CalendarConstraints c;
  private final String d;
  private final Runnable e;
  private Runnable f;
  
  c(final String paramString, DateFormat paramDateFormat, TextInputLayout paramTextInputLayout, CalendarConstraints paramCalendarConstraints)
  {
    this.b = paramDateFormat;
    this.a = paramTextInputLayout;
    this.c = paramCalendarConstraints;
    this.d = paramTextInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
    this.e = new a(paramString);
  }
  
  private Runnable d(final long paramLong)
  {
    return new b(paramLong);
  }
  
  abstract void e();
  
  abstract void f(Long paramLong);
  
  public void g(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, 1000L);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.removeCallbacks(this.e);
    this.a.removeCallbacks(this.f);
    this.a.setError(null);
    f(null);
    if (TextUtils.isEmpty(paramCharSequence)) {
      return;
    }
    try
    {
      paramCharSequence = this.b.parse(paramCharSequence.toString());
      this.a.setError(null);
      long l = paramCharSequence.getTime();
      if ((this.c.o().c(l)) && (this.c.u(l)))
      {
        f(Long.valueOf(paramCharSequence.getTime()));
        return;
      }
      paramCharSequence = d(l);
      this.f = paramCharSequence;
      g(this.a, paramCharSequence);
      return;
    }
    catch (ParseException paramCharSequence)
    {
      label136:
      break label136;
    }
    g(this.a, this.e);
  }
  
  class a
    implements Runnable
  {
    a(String paramString) {}
    
    public void run()
    {
      TextInputLayout localTextInputLayout = c.a(c.this);
      Object localObject1 = c.b(c.this);
      Object localObject2 = localTextInputLayout.getContext();
      String str1 = ((Context)localObject2).getString(R.string.mtrl_picker_invalid_format);
      String str2 = String.format(((Context)localObject2).getString(R.string.mtrl_picker_invalid_format_use), new Object[] { paramString });
      localObject1 = String.format(((Context)localObject2).getString(R.string.mtrl_picker_invalid_format_example), new Object[] { ((DateFormat)localObject1).format(new Date(p.o().getTimeInMillis())) });
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append((String)localObject1);
      localTextInputLayout.setError(((StringBuilder)localObject2).toString());
      c.this.e();
    }
  }
  
  class b
    implements Runnable
  {
    b(long paramLong) {}
    
    public void run()
    {
      c.a(c.this).setError(String.format(c.c(c.this), new Object[] { d.c(paramLong) }));
      c.this.e();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.c
 * JD-Core Version:    0.7.0.1
 */