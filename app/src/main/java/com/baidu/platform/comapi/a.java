package com.baidu.platform.comapi;

import android.content.Context;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.b;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.engine.NAEngine;

class a
{
  static boolean b = false;
  private NAEngine a;
  
  public void a()
  {
    if (b) {
      b();
    }
    MessageProxy.destroy();
    NAEngine.c();
    if (this.a != null) {
      this.a = null;
    }
  }
  
  public boolean a(Context paramContext)
  {
    b = false;
    this.a = new NAEngine();
    boolean bool = NAEngine.a(paramContext, null);
    if (OpenLogUtil.isMapLogEnable())
    {
      paramContext = b.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initEngine isEngineSuccess = ");
      localStringBuilder.append(bool);
      paramContext.a(localStringBuilder.toString());
    }
    if (!bool)
    {
      com.baidu.platform.comapi.e.a.a().a("engine_init_failed");
      return false;
    }
    return bool;
  }
  
  public boolean b()
  {
    b = false;
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.a
 * JD-Core Version:    0.7.0.1
 */