package n5;

import android.os.Bundle;
import android.util.ArrayMap;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.function.parser.MessageParser;
import com.farsunset.hoxin.message.function.parser.MessageParserFactory;
import j5.a;
import java.util.Map;
import m5.e;

public class c
  extends e
{
  private static final Map<String, Integer> b;
  
  static
  {
    ArrayMap localArrayMap = new ArrayMap();
    b = localArrayMap;
    localArrayMap.put("0", Integer.valueOf(1));
    localArrayMap.put("2", Integer.valueOf(3));
    localArrayMap.put("3", Integer.valueOf(2));
    localArrayMap.put("200", Integer.valueOf(4));
  }
  
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if ((b.containsKey(paramMessage.action)) && (paramBundle.getInt("ATTR_ACTION", 0) != -1))
    {
      MessageParser localMessageParser = MessageParserFactory.getMessageParser(paramMessage.action);
      if (localMessageParser == null)
      {
        super.c(paramMessage, paramBundle);
        return;
      }
      ChatSession localChatSession = a.m(localMessageParser.getSource(paramMessage));
      if (localChatSession == null) {
        return;
      }
      paramMessage.sessionId = Long.valueOf(localChatSession.id);
      localChatSession.message = localMessageParser.getDescription(paramMessage);
      localChatSession.timestamp = paramMessage.createTime.longValue();
      localChatSession.state = paramMessage.state.byteValue();
      if (paramMessage.state.byteValue() == 10) {
        localChatSession.badge += 1;
      }
      a.x(localChatSession);
      paramBundle.putSerializable("ATTR_CHAT_SESSION", localChatSession);
      super.c(paramMessage, paramBundle);
      return;
    }
    super.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n5.c
 * JD-Core Version:    0.7.0.1
 */