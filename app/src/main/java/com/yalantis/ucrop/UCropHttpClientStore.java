package com.yalantis.ucrop;

import l9.b0;

public class UCropHttpClientStore
{
  public static final UCropHttpClientStore INSTANCE = new UCropHttpClientStore();
  private b0 client;
  
  public b0 getClient()
  {
    if (this.client == null) {
      this.client = new b0();
    }
    return this.client;
  }
  
  public void setClient(b0 paramb0)
  {
    this.client = paramb0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.UCropHttpClientStore
 * JD-Core Version:    0.7.0.1
 */