package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.Message;
import i4.a;
import java.util.Iterator;
import java.util.List;
import l3.h;
import u3.l;

public class Action311MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    String str = a.k(Long.parseLong(paramMessage.extra));
    Object localObject1 = paramMessage.content.split(",");
    l.w0(paramMessage.sender.longValue());
    Object localObject2 = h.d((String[])localObject1);
    localObject1 = new StringBuilder();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Friend localFriend = (Friend)((Iterator)localObject2).next();
      a.a(localFriend, (byte)3);
      p4.b.b(paramMessage.sender, localFriend.id, localFriend.name);
      ((StringBuilder)localObject1).append(localFriend.name);
      ((StringBuilder)localObject1).append("、");
    }
    ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
    paramMessage.action = "3";
    paramMessage.format = 8;
    paramMessage.receiver = i3.e.o();
    paramMessage.state = Byte.valueOf((byte)11);
    paramMessage.content = HoxinApplication.h().getString(2131690059, new Object[] { str, ((StringBuilder)localObject1).toString() });
    n5.b.a(paramMessage, true);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action311MessageHandler
 * JD-Core Version:    0.7.0.1
 */