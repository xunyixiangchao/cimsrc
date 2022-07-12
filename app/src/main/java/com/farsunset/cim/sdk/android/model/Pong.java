package com.farsunset.cim.sdk.android.model;

import java.io.Serializable;

public class Pong
  implements Serializable, BinaryBody
{
  private static final String CMD_PONG = "PONG";
  private static final String TAG = "PONG";
  private static final Pong object = new Pong();
  private static final long serialVersionUID = 1L;
  
  public static Pong getInstance()
  {
    return object;
  }
  
  public byte[] getByteArray()
  {
    return "PONG".getBytes();
  }
  
  public byte getType()
  {
    return 0;
  }
  
  public String toString()
  {
    return "PONG";
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.cim.sdk.android.model.Pong
 * JD-Core Version:    0.7.0.1
 */