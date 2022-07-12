package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.micro.api.response.MicroServerMenuListResult;
import m5.e;
import s3.h0;

public class Action203MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    final long l = paramMessage.sender.longValue();
    v5.b.b(l, new h0()
    {
      public void onHttpResponse(MicroServerMenuListResult paramAnonymousMicroServerMenuListResult)
      {
        x5.b.b(Long.valueOf(l));
        x5.b.a(paramAnonymousMicroServerMenuListResult.data);
      }
    });
    j5.b.d(paramMessage.id);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action203MessageHandler
 * JD-Core Version:    0.7.0.1
 */