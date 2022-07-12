package com.google.android.material.internal;

import android.widget.Checkable;

public abstract interface g<T extends g<T>>
  extends Checkable
{
  public abstract int getId();
  
  public abstract void setInternalOnCheckedChangeListener(a<T> parama);
  
  public static abstract interface a<C>
  {
    public abstract void a(C paramC, boolean paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.g
 * JD-Core Version:    0.7.0.1
 */