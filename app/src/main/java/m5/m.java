package m5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.function.parser.MessageParser;
import com.farsunset.hoxin.message.function.parser.MessageParserFactory;
import j5.a;
import j5.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import o3.c;

public class m
  extends e
{
  private static final Map<String, c> b;
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    c localc = c.c;
    localHashMap.put("0", localc);
    localHashMap.put("2", localc);
    localHashMap.put("3", localc);
    localHashMap.put("101", localc);
    localHashMap.put("105", c.b);
    localHashMap.put("106", localc);
    localHashMap.put("200", localc);
    localHashMap.put("310", localc);
  }
  
  public void b(Message paramMessage, Bundle paramBundle)
  {
    Object localObject = b;
    if (!((Map)localObject).containsKey(paramMessage.action))
    {
      super.c(paramMessage, paramBundle);
      return;
    }
    MessageParser localMessageParser = MessageParserFactory.getMessageParser(paramMessage.action);
    if (localMessageParser == null)
    {
      super.c(paramMessage, paramBundle);
      return;
    }
    localObject = (c)((Map)localObject).get(paramMessage.action);
    localObject = a.n(localMessageParser.getSource(paramMessage), (c)localObject);
    paramBundle.putSerializable("ATTR_CHAT_SESSION", (Serializable)localObject);
    paramMessage.sessionId = Long.valueOf(((ChatSession)localObject).id);
    if ((paramMessage.state.byteValue() != 11) && (localMessageParser.isBadgeAddable())) {
      ((ChatSession)localObject).badge += 1;
    }
    ((ChatSession)localObject).timestamp = paramMessage.createTime.longValue();
    ((ChatSession)localObject).message = localMessageParser.getDescription(paramMessage);
    b.B(paramMessage.id, paramMessage.sessionId);
    a.x((ChatSession)localObject);
    super.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.m
 * JD-Core Version:    0.7.0.1
 */