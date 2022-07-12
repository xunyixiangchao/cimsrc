package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;

public class h
  extends e
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (g)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    j localj = new j(w(), this, paramCharSequence);
    paramCharSequence.x(localj);
    return localj;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.h
 * JD-Core Version:    0.7.0.1
 */