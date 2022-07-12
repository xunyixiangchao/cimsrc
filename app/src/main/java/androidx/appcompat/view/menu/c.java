package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R.layout;
import java.util.ArrayList;

public class c
  implements j, AdapterView.OnItemClickListener
{
  Context a;
  LayoutInflater b;
  e c;
  ExpandedMenuView d;
  int e;
  int f;
  int g;
  private j.a h;
  a i;
  private int j;
  
  public c(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.f = paramInt2;
  }
  
  public c(Context paramContext, int paramInt)
  {
    this(paramInt, 0);
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
  }
  
  public ListAdapter a()
  {
    if (this.i == null) {
      this.i = new a();
    }
    return this.i;
  }
  
  public void b(e parame, boolean paramBoolean)
  {
    j.a locala = this.h;
    if (locala != null) {
      locala.b(parame, paramBoolean);
    }
  }
  
  public k c(ViewGroup paramViewGroup)
  {
    if (this.d == null)
    {
      this.d = ((ExpandedMenuView)this.b.inflate(R.layout.abc_expanded_menu_layout, paramViewGroup, false));
      if (this.i == null) {
        this.i = new a();
      }
      this.d.setAdapter(this.i);
      this.d.setOnItemClickListener(this);
    }
    return this.d;
  }
  
  public void d(Context paramContext, e parame)
  {
    if (this.f != 0)
    {
      paramContext = new ContextThemeWrapper(paramContext, this.f);
      this.a = paramContext;
    }
    for (paramContext = LayoutInflater.from(paramContext);; paramContext = LayoutInflater.from(paramContext))
    {
      this.b = paramContext;
      break;
      if (this.a == null) {
        break;
      }
      this.a = paramContext;
      if (this.b != null) {
        break;
      }
    }
    this.c = parame;
    paramContext = this.i;
    if (paramContext != null) {
      paramContext.notifyDataSetChanged();
    }
  }
  
  public void e(Parcelable paramParcelable)
  {
    h((Bundle)paramParcelable);
  }
  
  public boolean f(m paramm)
  {
    if (!paramm.hasVisibleItems()) {
      return false;
    }
    new f(paramm).d(null);
    j.a locala = this.h;
    if (locala != null) {
      locala.c(paramm);
    }
    return true;
  }
  
  public void g(boolean paramBoolean)
  {
    a locala = this.i;
    if (locala != null) {
      locala.notifyDataSetChanged();
    }
  }
  
  public int getId()
  {
    return this.j;
  }
  
  public void h(Bundle paramBundle)
  {
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:list");
    if (paramBundle != null) {
      this.d.restoreHierarchyState(paramBundle);
    }
  }
  
  public boolean i()
  {
    return false;
  }
  
  public Parcelable j()
  {
    if (this.d == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    n(localBundle);
    return localBundle;
  }
  
  public boolean k(e parame, g paramg)
  {
    return false;
  }
  
  public boolean l(e parame, g paramg)
  {
    return false;
  }
  
  public void m(j.a parama)
  {
    this.h = parama;
  }
  
  public void n(Bundle paramBundle)
  {
    SparseArray localSparseArray = new SparseArray();
    ExpandedMenuView localExpandedMenuView = this.d;
    if (localExpandedMenuView != null) {
      localExpandedMenuView.saveHierarchyState(localSparseArray);
    }
    paramBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.c.O(this.i.b(paramInt), this, 0);
  }
  
  private class a
    extends BaseAdapter
  {
    private int a = -1;
    
    public a()
    {
      a();
    }
    
    void a()
    {
      g localg = c.this.c.x();
      if (localg != null)
      {
        ArrayList localArrayList = c.this.c.B();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((g)localArrayList.get(i) == localg)
          {
            this.a = i;
            return;
          }
          i += 1;
        }
      }
      this.a = -1;
    }
    
    public g b(int paramInt)
    {
      ArrayList localArrayList = c.this.c.B();
      int i = paramInt + c.this.e;
      int j = this.a;
      paramInt = i;
      if (j >= 0)
      {
        paramInt = i;
        if (i >= j) {
          paramInt = i + 1;
        }
      }
      return (g)localArrayList.get(paramInt);
    }
    
    public int getCount()
    {
      int i = c.this.c.B().size() - c.this.e;
      if (this.a < 0) {
        return i;
      }
      return i - 1;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        paramView = c.this;
        localView = paramView.b.inflate(paramView.g, paramViewGroup, false);
      }
      ((k.a)localView).j(b(paramInt), 0);
      return localView;
    }
    
    public void notifyDataSetChanged()
    {
      a();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.c
 * JD-Core Version:    0.7.0.1
 */