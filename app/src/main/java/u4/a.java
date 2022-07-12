package u4;

import com.farsunset.hoxin.message.entity.ChatSession;
import java.util.Comparator;

public class a
  implements Comparator<ChatSession>
{
  public int a(ChatSession paramChatSession1, ChatSession paramChatSession2)
  {
    long l = paramChatSession1.priority;
    if ((l == 0L) && (paramChatSession2.priority == 0L)) {
      return Long.compare(paramChatSession2.timestamp, paramChatSession1.timestamp);
    }
    return Long.compare(paramChatSession2.priority, l);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u4.a
 * JD-Core Version:    0.7.0.1
 */