package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import com.baidu.platform.comjni.engine.MessageProxy;

public class MessageCenter
{
  public static void registMessage(int paramInt, Handler paramHandler)
  {
    MessageProxy.registerMessageHandler(paramInt, paramHandler);
  }
  
  public static void unregistMessage(int paramInt, Handler paramHandler)
  {
    MessageProxy.unRegisterMessageHandler(paramInt, paramHandler);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.MessageCenter
 * JD-Core Version:    0.7.0.1
 */