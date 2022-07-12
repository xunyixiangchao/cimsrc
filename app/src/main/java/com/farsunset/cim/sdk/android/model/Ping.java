package com.farsunset.cim.sdk.android.model;

import java.io.Serializable;

public class Ping
  implements Serializable
{
  private static final String TAG = "PING";
  private static final Ping object = new Ping();
  private static final long serialVersionUID = 1L;
  
  public static Ping getInstance()
  {
    return object;
  }
  
  public String toString()
  {
    return "PING";
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.cim.sdk.android.model.Ping
 * JD-Core Version:    0.7.0.1
 */