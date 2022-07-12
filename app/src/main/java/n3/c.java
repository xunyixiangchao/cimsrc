package n3;

import android.net.NetworkInfo;
import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.SentBody;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c
{
  private static final Set<b> a = new HashSet();
  
  public static void a()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a();
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).h(paramBoolean);
    }
  }
  
  public static void c()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).i();
    }
  }
  
  public static void d(ChatSession paramChatSession, Message paramMessage)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (!localb.r0().contains(paramMessage.action)) {
        localb.H(paramChatSession, paramMessage);
      }
    }
  }
  
  public static void e(NetworkInfo paramNetworkInfo)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).f(paramNetworkInfo);
    }
  }
  
  public static void f(ReplyBody paramReplyBody)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).g(paramReplyBody);
    }
  }
  
  public static void g(SentBody paramSentBody)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).b(paramSentBody);
    }
  }
  
  public static void h(b paramb)
  {
    a.add(paramb);
  }
  
  public static void i(b paramb)
  {
    a.remove(paramb);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n3.c
 * JD-Core Version:    0.7.0.1
 */