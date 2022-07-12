package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import m5.e;

public abstract interface MessageHandler
{
  public abstract void handle(Message paramMessage, Bundle paramBundle, e parame);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.MessageHandler
 * JD-Core Version:    0.7.0.1
 */