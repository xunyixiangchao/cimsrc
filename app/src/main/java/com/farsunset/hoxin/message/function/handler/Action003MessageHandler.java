package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.group.entity.GroupMember;
import com.farsunset.hoxin.message.entity.Message;
import java.util.Set;
import l3.h;
import u3.d;

public class Action003MessageHandler
  extends Action000MessageHandler
{
  private void loadGroupMember(long paramLong1, long paramLong2)
  {
    if (p4.b.f(Long.valueOf(paramLong1), Long.valueOf(paramLong2))) {
      return;
    }
    Friend localFriend;
    if (i4.a.e(paramLong2)) {
      localFriend = i4.a.l(paramLong2);
    } else {
      localFriend = h.e(paramLong2);
    }
    GroupMember localGroupMember = new GroupMember();
    localGroupMember.groupId = paramLong1;
    localGroupMember.uid = paramLong2;
    localGroupMember.type = 0;
    localGroupMember.name = localFriend.name;
    p4.b.a(localGroupMember);
  }
  
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    long l1 = paramMessage.sender.longValue();
    long l2 = Long.parseLong(paramMessage.extra);
    if (!p4.a.e(l1))
    {
      j5.b.d(l1);
      return;
    }
    if (!p4.b.f(Long.valueOf(l1), Long.valueOf(l2)))
    {
      j5.b.d(l1);
      return;
    }
    loadGroupMember(l1, l2);
    super.loadResource(paramMessage);
    if (d.s(Long.valueOf(l1)))
    {
      paramMessage.state = Byte.valueOf((byte)11);
      j5.b.E(paramMessage);
      d.a(l1);
    }
    q5.a locala = q5.a.c(paramMessage.title);
    if ((locala.f()) && (locala.d().contains(i3.e.o())))
    {
      d.v(l1);
      d.u(paramMessage.id);
    }
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action003MessageHandler
 * JD-Core Version:    0.7.0.1
 */