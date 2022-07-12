package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.internal.f;
import com.google.android.material.internal.t;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import o7.b;

public class SingleDateSelector
  implements DateSelector<Long>
{
  public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();
  private Long a;
  
  private void i()
  {
    this.a = null;
  }
  
  public String a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    Object localObject = this.a;
    if (localObject == null) {
      return paramContext.getString(R.string.mtrl_picker_date_header_unselected);
    }
    localObject = d.j(((Long)localObject).longValue());
    return paramContext.getString(R.string.mtrl_picker_date_header_selected, new Object[] { localObject });
  }
  
  public int b(Context paramContext)
  {
    return b.d(paramContext, R.attr.materialCalendarTheme, g.class.getCanonicalName());
  }
  
  public Collection<x0.d<Long, Long>> d()
  {
    return new ArrayList();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.a != null;
  }
  
  public Collection<Long> f()
  {
    ArrayList localArrayList = new ArrayList();
    Long localLong = this.a;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    return localArrayList;
  }
  
  public void k(long paramLong)
  {
    this.a = Long.valueOf(paramLong);
  }
  
  public View l(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, CalendarConstraints paramCalendarConstraints, final l<Long> paraml)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.mtrl_picker_text_input_date, paramViewGroup, false);
    paramViewGroup = (TextInputLayout)paramLayoutInflater.findViewById(R.id.mtrl_picker_text_input_date);
    paramBundle = paramViewGroup.getEditText();
    if (f.a()) {
      paramBundle.setInputType(17);
    }
    SimpleDateFormat localSimpleDateFormat = p.k();
    String str = p.l(paramLayoutInflater.getResources(), localSimpleDateFormat);
    paramViewGroup.setPlaceholderText(str);
    Long localLong = this.a;
    if (localLong != null) {
      paramBundle.setText(localSimpleDateFormat.format(localLong));
    }
    paramBundle.addTextChangedListener(new a(str, localSimpleDateFormat, paramViewGroup, paramCalendarConstraints, paraml));
    t.l(paramBundle);
    return paramLayoutInflater;
  }
  
  public Long m()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.a);
  }
  
  class a
    extends c
  {
    a(String paramString, DateFormat paramDateFormat, TextInputLayout paramTextInputLayout, CalendarConstraints paramCalendarConstraints, l paraml)
    {
      super(paramDateFormat, paramTextInputLayout, paramCalendarConstraints);
    }
    
    void e()
    {
      paraml.a();
    }
    
    void f(Long paramLong)
    {
      if (paramLong == null) {
        SingleDateSelector.g(SingleDateSelector.this);
      } else {
        SingleDateSelector.this.k(paramLong.longValue());
      }
      paraml.b(SingleDateSelector.this.m());
    }
  }
  
  class b
    implements Parcelable.Creator<SingleDateSelector>
  {
    public SingleDateSelector a(Parcel paramParcel)
    {
      SingleDateSelector localSingleDateSelector = new SingleDateSelector();
      SingleDateSelector.h(localSingleDateSelector, (Long)paramParcel.readValue(Long.class.getClassLoader()));
      return localSingleDateSelector;
    }
    
    public SingleDateSelector[] b(int paramInt)
    {
      return new SingleDateSelector[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.SingleDateSelector
 * JD-Core Version:    0.7.0.1
 */