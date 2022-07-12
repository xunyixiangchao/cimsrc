package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import java.util.Calendar;
import java.util.Locale;

class e
  extends BaseAdapter
{
  private static final int d;
  private final Calendar a;
  private final int b;
  private final int c;
  
  static
  {
    int i;
    if (Build.VERSION.SDK_INT >= 26) {
      i = 4;
    } else {
      i = 1;
    }
    d = i;
  }
  
  public e()
  {
    Calendar localCalendar = p.q();
    this.a = localCalendar;
    this.b = localCalendar.getMaximum(7);
    this.c = localCalendar.getFirstDayOfWeek();
  }
  
  private int b(int paramInt)
  {
    int i = paramInt + this.c;
    int j = this.b;
    paramInt = i;
    if (i > j) {
      paramInt = i - j;
    }
    return paramInt;
  }
  
  public Integer a(int paramInt)
  {
    if (paramInt >= this.b) {
      return null;
    }
    return Integer.valueOf(b(paramInt));
  }
  
  public int getCount()
  {
    return this.b;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @SuppressLint({"WrongConstant"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TextView localTextView = (TextView)paramView;
    if (paramView == null) {
      localTextView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, paramViewGroup, false);
    }
    this.a.set(7, b(paramInt));
    paramView = localTextView.getResources().getConfiguration().locale;
    localTextView.setText(this.a.getDisplayName(7, d, paramView));
    localTextView.setContentDescription(String.format(paramViewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), new Object[] { this.a.getDisplayName(7, 2, Locale.getDefault()) }));
    return localTextView;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.e
 * JD-Core Version:    0.7.0.1
 */