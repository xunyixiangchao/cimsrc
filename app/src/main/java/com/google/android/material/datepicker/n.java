package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.y;
import androidx.recyclerview.widget.RecyclerView.z;
import androidx.recyclerview.widget.j;

class n
  extends LinearLayoutManager
{
  n(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public void I1(RecyclerView paramRecyclerView, RecyclerView.z paramz, int paramInt)
  {
    paramRecyclerView = new a(paramRecyclerView.getContext());
    paramRecyclerView.p(paramInt);
    J1(paramRecyclerView);
  }
  
  class a
    extends j
  {
    a(Context paramContext)
    {
      super();
    }
    
    protected float v(DisplayMetrics paramDisplayMetrics)
    {
      return 100.0F / paramDisplayMetrics.densityDpi;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.n
 * JD-Core Version:    0.7.0.1
 */