package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.google.android.material.R.layout;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

class j
  extends BaseAdapter
{
  static final int f = p.q().getMaximum(4);
  final Month a;
  final DateSelector<?> b;
  private Collection<Long> c;
  b d;
  final CalendarConstraints e;
  
  j(Month paramMonth, DateSelector<?> paramDateSelector, CalendarConstraints paramCalendarConstraints)
  {
    this.a = paramMonth;
    this.b = paramDateSelector;
    this.e = paramCalendarConstraints;
    this.c = paramDateSelector.f();
  }
  
  private void e(Context paramContext)
  {
    if (this.d == null) {
      this.d = new b(paramContext);
    }
  }
  
  private boolean h(long paramLong)
  {
    Iterator localIterator = this.b.f().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      if (p.a(paramLong) == p.a(l)) {
        return true;
      }
    }
    return false;
  }
  
  private void k(TextView paramTextView, long paramLong)
  {
    if (paramTextView == null) {
      return;
    }
    a locala;
    if (this.e.o().c(paramLong))
    {
      paramTextView.setEnabled(true);
      if (h(paramLong)) {
        locala = this.d.b;
      } else if (p.o().getTimeInMillis() == paramLong) {
        locala = this.d.c;
      } else {
        locala = this.d.a;
      }
    }
    else
    {
      paramTextView.setEnabled(false);
      locala = this.d.g;
    }
    locala.d(paramTextView);
  }
  
  private void l(MaterialCalendarGridView paramMaterialCalendarGridView, long paramLong)
  {
    if (Month.i(paramLong).equals(this.a))
    {
      int i = this.a.p(paramLong);
      k((TextView)paramMaterialCalendarGridView.getChildAt(paramMaterialCalendarGridView.b().a(i) - paramMaterialCalendarGridView.getFirstVisiblePosition()), paramLong);
    }
  }
  
  int a(int paramInt)
  {
    return b() + (paramInt - 1);
  }
  
  int b()
  {
    return this.a.n();
  }
  
  public Long c(int paramInt)
  {
    if ((paramInt >= this.a.n()) && (paramInt <= i())) {
      return Long.valueOf(this.a.o(j(paramInt)));
    }
    return null;
  }
  
  public TextView d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    e(paramViewGroup.getContext());
    TextView localTextView = (TextView)paramView;
    if (paramView == null) {
      localTextView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, paramViewGroup, false);
    }
    int i = paramInt - b();
    if (i >= 0)
    {
      paramView = this.a;
      if (i < paramView.e)
      {
        i += 1;
        localTextView.setTag(paramView);
        localTextView.setText(String.format(localTextView.getResources().getConfiguration().locale, "%d", new Object[] { Integer.valueOf(i) }));
        long l = this.a.o(i);
        if (this.a.c == Month.m().c) {
          paramView = d.g(l);
        } else {
          paramView = d.l(l);
        }
        localTextView.setContentDescription(paramView);
        localTextView.setVisibility(0);
        localTextView.setEnabled(true);
        break label189;
      }
    }
    localTextView.setVisibility(8);
    localTextView.setEnabled(false);
    label189:
    paramView = c(paramInt);
    if (paramView == null) {
      return localTextView;
    }
    k(localTextView, paramView.longValue());
    return localTextView;
  }
  
  boolean f(int paramInt)
  {
    return paramInt % this.a.d == 0;
  }
  
  boolean g(int paramInt)
  {
    return (paramInt + 1) % this.a.d == 0;
  }
  
  public int getCount()
  {
    return this.a.e + b();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt / this.a.d;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  int i()
  {
    return this.a.n() + this.a.e - 1;
  }
  
  int j(int paramInt)
  {
    return paramInt - this.a.n() + 1;
  }
  
  public void m(MaterialCalendarGridView paramMaterialCalendarGridView)
  {
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext()) {
      l(paramMaterialCalendarGridView, ((Long)((Iterator)localObject).next()).longValue());
    }
    localObject = this.b;
    if (localObject != null)
    {
      localObject = ((DateSelector)localObject).f().iterator();
      while (((Iterator)localObject).hasNext()) {
        l(paramMaterialCalendarGridView, ((Long)((Iterator)localObject).next()).longValue());
      }
      this.c = this.b.f();
    }
  }
  
  boolean n(int paramInt)
  {
    return (paramInt >= b()) && (paramInt <= i());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.j
 * JD-Core Version:    0.7.0.1
 */