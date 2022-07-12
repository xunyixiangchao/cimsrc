package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

class q
  extends RecyclerView.h<b>
{
  private final f<?> d;
  
  q(f<?> paramf)
  {
    this.d = paramf;
  }
  
  private View.OnClickListener J(final int paramInt)
  {
    return new a(paramInt);
  }
  
  int K(int paramInt)
  {
    return paramInt - this.d.v().s().c;
  }
  
  int L(int paramInt)
  {
    return this.d.v().s().c + paramInt;
  }
  
  public void M(b paramb, int paramInt)
  {
    paramInt = L(paramInt);
    Object localObject = paramb.u.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
    paramb.u.setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(paramInt) }));
    paramb.u.setContentDescription(String.format((String)localObject, new Object[] { Integer.valueOf(paramInt) }));
    b localb = this.d.w();
    Calendar localCalendar = p.o();
    if (localCalendar.get(1) == paramInt) {
      localObject = localb.f;
    } else {
      localObject = localb.d;
    }
    Iterator localIterator = this.d.y().f().iterator();
    while (localIterator.hasNext())
    {
      localCalendar.setTimeInMillis(((Long)localIterator.next()).longValue());
      if (localCalendar.get(1) == paramInt) {
        localObject = localb.e;
      }
    }
    ((a)localObject).d(paramb.u);
    paramb.u.setOnClickListener(J(paramInt));
  }
  
  public b N(ViewGroup paramViewGroup, int paramInt)
  {
    return new b((TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, paramViewGroup, false));
  }
  
  public int d()
  {
    return this.d.v().t();
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      paramView = Month.h(paramInt, q.I(q.this).x().b);
      paramView = q.I(q.this).v().n(paramView);
      q.I(q.this).E(paramView);
      q.I(q.this).F(f.k.a);
    }
  }
  
  public static class b
    extends RecyclerView.c0
  {
    final TextView u;
    
    b(TextView paramTextView)
    {
      super();
      this.u = paramTextView;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.q
 * JD-Core Version:    0.7.0.1
 */