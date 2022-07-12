package com.baidu.vi;

import android.net.NetworkInfo;

public class VNetworkInfo
{
  public int state;
  public int type;
  public String typename;
  
  public VNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    this.typename = paramNetworkInfo.getTypeName();
    this.type = paramNetworkInfo.getType();
    int i = a.a[paramNetworkInfo.getState().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        this.state = 0;
        return;
      }
      this.state = 1;
      return;
    }
    this.state = 2;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.vi.VNetworkInfo
 * JD-Core Version:    0.7.0.1
 */