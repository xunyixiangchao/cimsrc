package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class m<S>
  extends Fragment
{
  protected final LinkedHashSet<l<S>> a = new LinkedHashSet();
  
  boolean e(l<S> paraml)
  {
    return this.a.add(paraml);
  }
  
  void j()
  {
    this.a.clear();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.m
 * JD-Core Version:    0.7.0.1
 */