package f5;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.message.api.request.MessageForwardRequest;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import ea.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l3.b.c;
import l3.b.d;
import m5.k;
import o5.l;
import s3.e;
import s3.h0;

public class a
  extends l3.b
{
  public static g5.a b(Message paramMessage, List<ChatSession> paramList)
  {
    paramMessage = new MessageForwardRequest(paramMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatSession localChatSession = (ChatSession)paramList.next();
      paramMessage.add(localChatSession.sourceId, localChatSession.action);
    }
    paramList = (h5.a)l3.b.a(h5.a.class);
    try
    {
      paramMessage = (g5.a)paramList.d(paramMessage).g().a();
      return paramMessage;
    }
    catch (IOException paramMessage)
    {
      label80:
      break label80;
    }
    return null;
  }
  
  public static void c()
  {
    h5.a locala = (h5.a)l3.b.a(h5.a.class);
    locala.h().B(new b.d(new a()));
  }
  
  public static void d(Message paramMessage)
  {
    if (!paramMessage.isNeedShowReadStatus()) {
      return;
    }
    ((h5.a)l3.b.a(h5.a.class)).g(Long.valueOf(paramMessage.id), paramMessage.sender).B(l3.b.a);
  }
  
  public static void e(Message paramMessage)
  {
    ((h5.a)l3.b.a(h5.a.class)).i(Long.valueOf(paramMessage.id), paramMessage.action).B(l3.b.a);
  }
  
  public static void f(Message paramMessage, e<BaseResult> parame)
  {
    ((h5.a)l3.b.a(h5.a.class)).c(paramMessage.id, paramMessage.action).B(new b.c(parame));
  }
  
  public static void g(Message paramMessage)
  {
    l.a(paramMessage);
  }
  
  public static void h(long paramLong)
  {
    ((h5.a)l3.b.a(h5.a.class)).b(Long.valueOf(paramLong)).B(l3.b.a);
  }
  
  class a
    extends h0<g5.b>
  {
    a() {}
    
    public void a(g5.b paramb)
    {
      if (!paramb.isNotEmpty()) {
        return;
      }
      HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RECENT_DISABLE_LISTENER"));
      int i = 0;
      while (i < paramb.a.size())
      {
        Message localMessage = (Message)paramb.a.get(i);
        Bundle localBundle = new Bundle();
        boolean bool = true;
        localBundle.putBoolean("ATTR_FROM_OFFLINE", true);
        if (i != paramb.a.size() - 1) {
          bool = false;
        }
        localBundle.putBoolean("ATTR_LAST_OFFLINE_MESSAGE", bool);
        k.b(localBundle, localMessage);
        i += 1;
      }
      a.this.e().B(l3.b.a);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f5.a
 * JD-Core Version:    0.7.0.1
 */