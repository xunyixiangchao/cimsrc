package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NavigationMenuView
  extends RecyclerView
  implements k
{
  public NavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutManager(new LinearLayoutManager(paramContext, 1, false));
  }
  
  public void b(e parame) {}
  
  public int getWindowAnimations()
  {
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.NavigationMenuView
 * JD-Core Version:    0.7.0.1
 */