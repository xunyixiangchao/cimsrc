package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.moment.entity.Comment;
import j5.b;
import java.util.Objects;

public class Action502MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    long l1 = Long.parseLong(paramMessage.content);
    long l2 = Long.parseLong(paramMessage.extra);
    Comment localComment = d6.a.c(l1);
    if (localComment == null) {}
    do
    {
      b.d(paramMessage.id);
      return;
      g6.a.a(localComment);
    } while ((localComment.deleted) || ((i3.e.o().longValue() != l2) && (!Objects.equals(paramMessage.title, i3.e.o().toString()))));
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action502MessageHandler
 * JD-Core Version:    0.7.0.1
 */