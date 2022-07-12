package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class d
  extends BaseAdapter
{
  e a;
  private int b = -1;
  private boolean c;
  private final boolean d;
  private final LayoutInflater e;
  private final int f;
  
  public d(e parame, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    this.d = paramBoolean;
    this.e = paramLayoutInflater;
    this.a = parame;
    this.f = paramInt;
    a();
  }
  
  void a()
  {
    g localg = this.a.x();
    if (localg != null)
    {
      ArrayList localArrayList = this.a.B();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((g)localArrayList.get(i) == localg)
        {
          this.b = i;
          return;
        }
        i += 1;
      }
    }
    this.b = -1;
  }
  
  public e b()
  {
    return this.a;
  }
  
  public g c(int paramInt)
  {
    ArrayList localArrayList;
    if (this.d) {
      localArrayList = this.a.B();
    } else {
      localArrayList = this.a.G();
    }
    int j = this.b;
    int i = paramInt;
    if (j >= 0)
    {
      i = paramInt;
      if (paramInt >= j) {
        i = paramInt + 1;
      }
    }
    return (g)localArrayList.get(i);
  }
  
  public void d(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public int getCount()
  {
    ArrayList localArrayList;
    if (this.d) {
      localArrayList = this.a.B();
    } else {
      localArrayList = this.a.G();
    }
    int i = this.b;
    int j = localArrayList.size();
    if (i < 0) {
      return j;
    }
    return j - 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.e.inflate(this.f, paramViewGroup, false);
    }
    int j = c(paramInt).getGroupId();
    int i = paramInt - 1;
    if (i >= 0) {
      i = c(i).getGroupId();
    } else {
      i = j;
    }
    paramView = (ListMenuItemView)localView;
    boolean bool;
    if ((this.a.H()) && (j != i)) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.setGroupDividerEnabled(bool);
    paramViewGroup = (k.a)localView;
    if (this.c) {
      paramView.setForceShowIcon(true);
    }
    paramViewGroup.j(c(paramInt), 0);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.d
 * JD-Core Version:    0.7.0.1
 */