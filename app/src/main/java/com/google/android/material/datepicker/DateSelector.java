package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;
import x0.d;

public abstract interface DateSelector<S>
  extends Parcelable
{
  public abstract String a(Context paramContext);
  
  public abstract int b(Context paramContext);
  
  public abstract Collection<d<Long, Long>> d();
  
  public abstract boolean e();
  
  public abstract Collection<Long> f();
  
  public abstract S j();
  
  public abstract void k(long paramLong);
  
  public abstract View l(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, CalendarConstraints paramCalendarConstraints, l<S> paraml);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.DateSelector
 * JD-Core Version:    0.7.0.1
 */