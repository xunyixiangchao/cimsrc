package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class g
  extends Handler
{
  public g(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public abstract void a(Message paramMessage);
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.copyFrom(paramMessage);
    a(localMessage);
    localMessage.recycle();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.g
 * JD-Core Version:    0.7.0.1
 */