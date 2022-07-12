package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
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

public class RangeDateSelector
  implements DateSelector<x0.d<Long, Long>>
{
  public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();
  private String a;
  private final String b = " ";
  private Long c = null;
  private Long d = null;
  private Long e = null;
  private Long f = null;
  
  private void o(TextInputLayout paramTextInputLayout1, TextInputLayout paramTextInputLayout2)
  {
    if ((paramTextInputLayout1.getError() != null) && (this.a.contentEquals(paramTextInputLayout1.getError()))) {
      paramTextInputLayout1.setError(null);
    }
    if ((paramTextInputLayout2.getError() != null) && (" ".contentEquals(paramTextInputLayout2.getError()))) {
      paramTextInputLayout2.setError(null);
    }
  }
  
  private boolean q(long paramLong1, long paramLong2)
  {
    return paramLong1 <= paramLong2;
  }
  
  private void r(TextInputLayout paramTextInputLayout1, TextInputLayout paramTextInputLayout2)
  {
    paramTextInputLayout1.setError(this.a);
    paramTextInputLayout2.setError(" ");
  }
  
  private void s(TextInputLayout paramTextInputLayout1, TextInputLayout paramTextInputLayout2, l<x0.d<Long, Long>> paraml)
  {
    Long localLong = this.e;
    if ((localLong != null) && (this.f != null))
    {
      if (q(localLong.longValue(), this.f.longValue()))
      {
        this.c = this.e;
        this.d = this.f;
        paraml.b(p());
        return;
      }
      r(paramTextInputLayout1, paramTextInputLayout2);
      paraml.a();
      return;
    }
    o(paramTextInputLayout1, paramTextInputLayout2);
    paraml.a();
  }
  
  public String a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    Object localObject = this.c;
    if ((localObject == null) && (this.d == null)) {
      return paramContext.getString(R.string.mtrl_picker_range_header_unselected);
    }
    Long localLong = this.d;
    if (localLong == null) {
      return paramContext.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[] { d.c(((Long)localObject).longValue()) });
    }
    if (localObject == null) {
      return paramContext.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[] { d.c(localLong.longValue()) });
    }
    localObject = d.a((Long)localObject, localLong);
    return paramContext.getString(R.string.mtrl_picker_range_header_selected, new Object[] { ((x0.d)localObject).a, ((x0.d)localObject).b });
  }
  
  public int b(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    int i = localResources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis);
    if (Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) > i) {
      i = R.attr.materialCalendarTheme;
    } else {
      i = R.attr.materialCalendarFullscreenTheme;
    }
    return b.d(paramContext, i, g.class.getCanonicalName());
  }
  
  public Collection<x0.d<Long, Long>> d()
  {
    if ((this.c != null) && (this.d != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new x0.d(this.c, this.d));
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    Long localLong = this.c;
    return (localLong != null) && (this.d != null) && (q(localLong.longValue(), this.d.longValue()));
  }
  
  public Collection<Long> f()
  {
    ArrayList localArrayList = new ArrayList();
    Long localLong = this.c;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    localLong = this.d;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    return localArrayList;
  }
  
  public void k(long paramLong)
  {
    Long localLong = this.c;
    if (localLong == null) {}
    for (;;)
    {
      this.c = Long.valueOf(paramLong);
      return;
      if ((this.d == null) && (q(localLong.longValue(), paramLong)))
      {
        this.d = Long.valueOf(paramLong);
        return;
      }
      this.d = null;
    }
  }
  
  public View l(LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, final Bundle paramBundle, CalendarConstraints paramCalendarConstraints, final l<x0.d<Long, Long>> paraml)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, paramViewGroup, false);
    paramViewGroup = (TextInputLayout)paramLayoutInflater.findViewById(R.id.mtrl_picker_text_input_range_start);
    paramBundle = (TextInputLayout)paramLayoutInflater.findViewById(R.id.mtrl_picker_text_input_range_end);
    EditText localEditText1 = paramViewGroup.getEditText();
    EditText localEditText2 = paramBundle.getEditText();
    if (f.a())
    {
      localEditText1.setInputType(17);
      localEditText2.setInputType(17);
    }
    this.a = paramLayoutInflater.getResources().getString(R.string.mtrl_picker_invalid_range);
    SimpleDateFormat localSimpleDateFormat = p.k();
    Object localObject = this.c;
    if (localObject != null)
    {
      localEditText1.setText(localSimpleDateFormat.format(localObject));
      this.e = this.c;
    }
    localObject = this.d;
    if (localObject != null)
    {
      localEditText2.setText(localSimpleDateFormat.format(localObject));
      this.f = this.d;
    }
    localObject = p.l(paramLayoutInflater.getResources(), localSimpleDateFormat);
    paramViewGroup.setPlaceholderText((CharSequence)localObject);
    paramBundle.setPlaceholderText((CharSequence)localObject);
    localEditText1.addTextChangedListener(new a((String)localObject, localSimpleDateFormat, paramViewGroup, paramCalendarConstraints, paramViewGroup, paramBundle, paraml));
    localEditText2.addTextChangedListener(new b((String)localObject, localSimpleDateFormat, paramBundle, paramCalendarConstraints, paramViewGroup, paramBundle, paraml));
    t.l(localEditText1);
    return paramLayoutInflater;
  }
  
  public x0.d<Long, Long> p()
  {
    return new x0.d(this.c, this.d);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.c);
    paramParcel.writeValue(this.d);
  }
  
  class a
    extends c
  {
    a(String paramString, DateFormat paramDateFormat, TextInputLayout paramTextInputLayout1, CalendarConstraints paramCalendarConstraints, TextInputLayout paramTextInputLayout2, TextInputLayout paramTextInputLayout3, l paraml)
    {
      super(paramDateFormat, paramTextInputLayout1, paramCalendarConstraints);
    }
    
    void e()
    {
      RangeDateSelector.g(RangeDateSelector.this, null);
      RangeDateSelector.h(RangeDateSelector.this, paramViewGroup, paramBundle, paraml);
    }
    
    void f(Long paramLong)
    {
      RangeDateSelector.g(RangeDateSelector.this, paramLong);
      RangeDateSelector.h(RangeDateSelector.this, paramViewGroup, paramBundle, paraml);
    }
  }
  
  class b
    extends c
  {
    b(String paramString, DateFormat paramDateFormat, TextInputLayout paramTextInputLayout1, CalendarConstraints paramCalendarConstraints, TextInputLayout paramTextInputLayout2, TextInputLayout paramTextInputLayout3, l paraml)
    {
      super(paramDateFormat, paramTextInputLayout1, paramCalendarConstraints);
    }
    
    void e()
    {
      RangeDateSelector.i(RangeDateSelector.this, null);
      RangeDateSelector.h(RangeDateSelector.this, paramViewGroup, paramBundle, paraml);
    }
    
    void f(Long paramLong)
    {
      RangeDateSelector.i(RangeDateSelector.this, paramLong);
      RangeDateSelector.h(RangeDateSelector.this, paramViewGroup, paramBundle, paraml);
    }
  }
  
  class c
    implements Parcelable.Creator<RangeDateSelector>
  {
    public RangeDateSelector a(Parcel paramParcel)
    {
      RangeDateSelector localRangeDateSelector = new RangeDateSelector();
      RangeDateSelector.m(localRangeDateSelector, (Long)paramParcel.readValue(Long.class.getClassLoader()));
      RangeDateSelector.n(localRangeDateSelector, (Long)paramParcel.readValue(Long.class.getClassLoader()));
      return localRangeDateSelector;
    }
    
    public RangeDateSelector[] b(int paramInt)
    {
      return new RangeDateSelector[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.RangeDateSelector
 * JD-Core Version:    0.7.0.1
 */