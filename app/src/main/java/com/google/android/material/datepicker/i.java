package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class i<S>
  extends m<S>
{
  private int b;
  private DateSelector<S> c;
  private CalendarConstraints d;
  
  static <T> i<T> l(DateSelector<T> paramDateSelector, int paramInt, CalendarConstraints paramCalendarConstraints)
  {
    i locali = new i();
    Bundle localBundle = new Bundle();
    localBundle.putInt("THEME_RES_ID_KEY", paramInt);
    localBundle.putParcelable("DATE_SELECTOR_KEY", paramDateSelector);
    localBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    locali.setArguments(localBundle);
    return locali;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    this.b = localBundle.getInt("THEME_RES_ID_KEY");
    this.c = ((DateSelector)localBundle.getParcelable("DATE_SELECTOR_KEY"));
    this.d = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.b));
    return this.c.l(paramLayoutInflater, paramViewGroup, paramBundle, this.d, new a());
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("THEME_RES_ID_KEY", this.b);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", this.c);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.d);
  }
  
  class a
    extends l<S>
  {
    a() {}
    
    public void a()
    {
      Iterator localIterator = i.this.a.iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).a();
      }
    }
    
    public void b(S paramS)
    {
      Iterator localIterator = i.this.a.iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).b(paramS);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.i
 * JD-Core Version:    0.7.0.1
 */