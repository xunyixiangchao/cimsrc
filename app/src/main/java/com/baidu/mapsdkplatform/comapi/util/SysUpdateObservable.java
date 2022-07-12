package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

public class SysUpdateObservable
{
  private static volatile SysUpdateObservable b;
  private List<SysUpdateObserver> a = null;
  
  public static SysUpdateObservable getInstance()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new SysUpdateObservable();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void addObserver(SysUpdateObserver paramSysUpdateObserver)
  {
    this.a.add(paramSysUpdateObserver);
  }
  
  public void init(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SysUpdateObserver localSysUpdateObserver = (SysUpdateObserver)localIterator.next();
      if (localSysUpdateObserver != null) {
        localSysUpdateObserver.init(paramString);
      }
    }
  }
  
  public void updateNetworkInfo(Context paramContext)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SysUpdateObserver localSysUpdateObserver = (SysUpdateObserver)localIterator.next();
      if (localSysUpdateObserver != null) {
        localSysUpdateObserver.updateNetworkInfo(paramContext);
      }
    }
  }
  
  public void updateNetworkProxy(Context paramContext)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SysUpdateObserver localSysUpdateObserver = (SysUpdateObserver)localIterator.next();
      if (localSysUpdateObserver != null) {
        localSysUpdateObserver.updateNetworkProxy(paramContext);
      }
    }
  }
  
  public void updatePhoneInfo(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SysUpdateObserver localSysUpdateObserver = (SysUpdateObserver)localIterator.next();
      if (localSysUpdateObserver != null) {
        localSysUpdateObserver.updatePhoneInfo(paramString);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable
 * JD-Core Version:    0.7.0.1
 */