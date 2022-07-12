package com.farsunset.hoxin.micro.model;

import java.io.Serializable;

public class MenuEvent
  implements Serializable
{
  public static final String ACTION_MENU = "menu";
  public static final String ACTION_SUBSCRIBE = "subscribe";
  public static final String ACTION_TEXT = "text";
  public static final String ACTION_UNSUBSCRIBE = "unsubscribe";
  public static final long serialVersionUID = 1L;
  public String action;
  public String content;
  public String uid;
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.model.MenuEvent
 * JD-Core Version:    0.7.0.1
 */