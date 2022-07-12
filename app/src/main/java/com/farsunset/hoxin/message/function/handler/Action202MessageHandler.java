package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.micro.api.response.MicroServerResult;
import x5.a;

public class Action202MessageHandler
  implements MessageHandler, s3.e<MicroServerResult>
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    j5.b.d(paramMessage.id);
    v5.b.c(paramMessage.sender.longValue(), this);
  }
  
  public void onHttpException(Exception paramException) {}
  
  public void onHttpResponse(MicroServerResult paramMicroServerResult)
  {
    a.a(paramMicroServerResult.data);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action202MessageHandler
 * JD-Core Version:    0.7.0.1
 */