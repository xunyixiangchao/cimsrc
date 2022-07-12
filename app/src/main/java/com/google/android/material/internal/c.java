package com.google.android.material.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

public class c
{
  public static Activity a(Context paramContext)
  {
    while ((paramContext instanceof ContextWrapper))
    {
      if ((paramContext instanceof Activity)) {
        return (Activity)paramContext;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.c
 * JD-Core Version:    0.7.0.1
 */