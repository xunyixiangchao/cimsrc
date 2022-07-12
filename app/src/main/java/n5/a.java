package n5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.function.parser.MessageParser;
import com.farsunset.hoxin.message.function.parser.MessageParserFactory;
import j5.b;
import m5.e;

public class a
  extends e
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (paramMessage.sessionId != null)
    {
      if (paramBundle.getInt("ATTR_ACTION", 0) != -1) {
        return;
      }
      Message localMessage = b.l(paramMessage.sessionId);
      if (localMessage == null)
      {
        j5.a.c(paramMessage.sessionId.longValue());
        return;
      }
      ChatSession localChatSession = j5.a.k(paramMessage.sessionId.longValue());
      MessageParser localMessageParser = MessageParserFactory.getMessageParser(localMessage.action);
      if (localMessageParser == null)
      {
        super.c(paramMessage, paramBundle);
        return;
      }
      localChatSession.message = localMessageParser.getDescription(localMessage);
      localChatSession.timestamp = localMessage.createTime.longValue();
      localChatSession.state = localMessage.state.byteValue();
      j5.a.x(localChatSession);
      super.c(paramMessage, paramBundle);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n5.a
 * JD-Core Version:    0.7.0.1
 */