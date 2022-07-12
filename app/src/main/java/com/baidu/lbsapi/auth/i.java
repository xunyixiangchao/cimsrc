package com.baidu.lbsapi.auth;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Hashtable;

class i
  extends Handler
{
  i(LBSAuthManager paramLBSAuthManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    a.a("handleMessage !!");
    Object localObject = paramMessage.getData().getString("listenerKey");
    localObject = (LBSAuthManagerListener)LBSAuthManager.a().get(localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage listener = ");
    localStringBuilder.append(localObject);
    a.a(localStringBuilder.toString());
    if (localObject != null) {
      ((LBSAuthManagerListener)localObject).onAuthResult(paramMessage.what, paramMessage.obj.toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.i
 * JD-Core Version:    0.7.0.1
 */