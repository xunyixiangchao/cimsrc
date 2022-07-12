package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.x;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;

class k
  extends RecyclerView.h<b>
{
  private final CalendarConstraints d;
  private final DateSelector<?> e;
  private final f.l f;
  private final int g;
  
  k(Context paramContext, DateSelector<?> paramDateSelector, CalendarConstraints paramCalendarConstraints, f.l paraml)
  {
    Month localMonth1 = paramCalendarConstraints.s();
    Month localMonth2 = paramCalendarConstraints.p();
    Month localMonth3 = paramCalendarConstraints.r();
    if (localMonth1.g(localMonth3) <= 0)
    {
      if (localMonth3.g(localMonth2) <= 0)
      {
        int j = j.f;
        int k = f.z(paramContext);
        int i;
        if (g.O(paramContext)) {
          i = f.z(paramContext);
        } else {
          i = 0;
        }
        this.g = (j * k + i);
        this.d = paramCalendarConstraints;
        this.e = paramDateSelector;
        this.f = paraml;
        F(true);
        return;
      }
      throw new IllegalArgumentException("currentPage cannot be after lastPage");
    }
    throw new IllegalArgumentException("firstPage cannot be after currentPage");
  }
  
  Month J(int paramInt)
  {
    return this.d.s().s(paramInt);
  }
  
  CharSequence K(int paramInt)
  {
    return J(paramInt).q();
  }
  
  int L(Month paramMonth)
  {
    return this.d.s().t(paramMonth);
  }
  
  public void M(final b paramb, int paramInt)
  {
    Month localMonth = this.d.s().s(paramInt);
    paramb.u.setText(localMonth.q());
    paramb = (MaterialCalendarGridView)paramb.v.findViewById(R.id.month_grid);
    if ((paramb.b() != null) && (localMonth.equals(paramb.b().a)))
    {
      paramb.invalidate();
      paramb.b().m(paramb);
    }
    else
    {
      j localj = new j(localMonth, this.e, this.d);
      paramb.setNumColumns(localMonth.d);
      paramb.setAdapter(localj);
    }
    paramb.setOnItemClickListener(new a(paramb));
  }
  
  public b N(ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, paramViewGroup, false);
    if (g.O(paramViewGroup.getContext()))
    {
      localLinearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.g));
      return new b(localLinearLayout, true);
    }
    return new b(localLinearLayout, false);
  }
  
  public int d()
  {
    return this.d.q();
  }
  
  public long e(int paramInt)
  {
    return this.d.s().s(paramInt).r();
  }
  
  class a
    implements AdapterView.OnItemClickListener
  {
    a(MaterialCalendarGridView paramMaterialCalendarGridView) {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (paramb.b().n(paramInt)) {
        k.I(k.this).a(paramb.b().c(paramInt).longValue());
      }
    }
  }
  
  public static class b
    extends RecyclerView.c0
  {
    final TextView u;
    final MaterialCalendarGridView v;
    
    b(LinearLayout paramLinearLayout, boolean paramBoolean)
    {
      super();
      TextView localTextView = (TextView)paramLinearLayout.findViewById(R.id.month_title);
      this.u = localTextView;
      x.r0(localTextView, true);
      this.v = ((MaterialCalendarGridView)paramLinearLayout.findViewById(R.id.month_grid));
      if (!paramBoolean) {
        localTextView.setVisibility(8);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.k
 * JD-Core Version:    0.7.0.1
 */