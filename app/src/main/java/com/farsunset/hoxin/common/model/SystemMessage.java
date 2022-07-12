package com.farsunset.hoxin.common.model;

import android.app.Application;
import com.farsunset.hoxin.HoxinApplication;

public class SystemMessage
  extends MessageSource
{
  public static final long serialVersionUID = 4733464888738356502L;
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof SystemMessage;
  }
  
  public String getAction()
  {
    return "2";
  }
  
  public int getDefaultIconRID()
  {
    return 2131165653;
  }
  
  public Long getId()
  {
    return Long.valueOf(0L);
  }
  
  public String getName()
  {
    return HoxinApplication.h().getString(2131689557);
  }
  
  public int getNotifyIcon()
  {
    return 2131165653;
  }
  
  public int getType()
  {
    return 3;
  }
  
  public String getWebIcon()
  {
    return null;
  }
  
  public int hashCode()
  {
    return getClass().getName().hashCode();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.model.SystemMessage
 * JD-Core Version:    0.7.0.1
 */