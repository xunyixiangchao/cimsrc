package com.farsunset.hoxin.common.model;

import java.io.Serializable;

public abstract class MessageSource
  implements Serializable
{
  public static final String NAME = MessageSource.class.getSimpleName();
  public static final String SOURCE_GROUP = "3";
  public static final String SOURCE_MICRO_SERVER = "200";
  public static final String SOURCE_SYSTEM = "2";
  public static final String SOURCE_USER = "0";
  private static final long serialVersionUID = 1L;
  
  public abstract String getAction();
  
  public abstract int getDefaultIconRID();
  
  public abstract Long getId();
  
  public abstract String getName();
  
  public int getNotifyIcon()
  {
    return getDefaultIconRID();
  }
  
  public abstract int getType();
  
  public abstract String getWebIcon();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.model.MessageSource
 * JD-Core Version:    0.7.0.1
 */