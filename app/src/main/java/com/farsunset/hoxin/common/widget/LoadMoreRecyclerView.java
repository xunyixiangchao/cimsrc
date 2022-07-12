package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.t;
import androidx.recyclerview.widget.e;
import com.farsunset.hoxin.common.model.Page;
import s3.s;

public class LoadMoreRecyclerView
  extends RecyclerView
{
  private s M0;
  private Page N0;
  private ListFooterView O0;
  private boolean P0 = false;
  
  public LoadMoreRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setLayoutManager(new LinearLayoutManager(paramContext));
    setItemAnimator(new e());
    l(new a());
  }
  
  private boolean H1()
  {
    return computeVerticalScrollExtent() + computeVerticalScrollOffset() >= computeVerticalScrollRange();
  }
  
  public void G1()
  {
    this.O0.a();
  }
  
  public void I1(Page paramPage)
  {
    this.N0 = paramPage;
    this.P0 = false;
    this.O0.b();
    if ((paramPage == null) || (!paramPage.hasMore())) {
      this.O0.c();
    }
  }
  
  public void J1()
  {
    this.O0.d();
  }
  
  public void K1(RecyclerView.h<?> paramh)
  {
    if (paramh.d() == 0)
    {
      this.O0.a();
      return;
    }
    this.O0.c();
  }
  
  public void setFooterView(ListFooterView paramListFooterView)
  {
    this.O0 = paramListFooterView;
  }
  
  public void setOnLoadEventListener(s params)
  {
    this.M0 = params;
  }
  
  class a
    extends RecyclerView.t
  {
    a() {}
    
    public void a(RecyclerView paramRecyclerView, int paramInt)
    {
      super.a(paramRecyclerView, paramInt);
      if (paramInt == 1) {
        LoadMoreRecyclerView.A1(LoadMoreRecyclerView.this).y();
      }
      if ((paramInt == 0) && (LoadMoreRecyclerView.B1(LoadMoreRecyclerView.this)) && (LoadMoreRecyclerView.this.computeVerticalScrollOffset() > 0))
      {
        if ((LoadMoreRecyclerView.C1(LoadMoreRecyclerView.this) != null) && (!LoadMoreRecyclerView.C1(LoadMoreRecyclerView.this).hasMore()))
        {
          LoadMoreRecyclerView.F1(LoadMoreRecyclerView.this).b();
          LoadMoreRecyclerView.F1(LoadMoreRecyclerView.this).c();
          return;
        }
        if (LoadMoreRecyclerView.D1(LoadMoreRecyclerView.this)) {
          return;
        }
        LoadMoreRecyclerView.E1(LoadMoreRecyclerView.this, true);
        LoadMoreRecyclerView.F1(LoadMoreRecyclerView.this).d();
        LoadMoreRecyclerView.F1(LoadMoreRecyclerView.this).a();
        LoadMoreRecyclerView.A1(LoadMoreRecyclerView.this).e();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.LoadMoreRecyclerView
 * JD-Core Version:    0.7.0.1
 */