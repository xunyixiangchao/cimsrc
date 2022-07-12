package m5;

import android.os.Bundle;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.function.parser.MessageParser;
import com.farsunset.hoxin.message.function.parser.MessageParserFactory;
import i3.a;
import java.io.Serializable;
import u3.d;

public class i
  extends e
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("ATTR_FROM_OFFLINE", false);
    if ((!a.b()) && (bool1)) {
      return;
    }
    if (!d.j()) {
      return;
    }
    Object localObject = MessageParserFactory.getMessageParser(paramMessage.action);
    if (localObject == null) {
      return;
    }
    int i = ((MessageParser)localObject).getNotificationPriority(paramMessage);
    if ((!a.b()) && (i != 2)) {
      return;
    }
    bool1 = "3".equals(paramMessage.action);
    boolean bool2 = d.s(paramMessage.sender);
    boolean bool3 = d.p(paramMessage.id);
    if ((bool1) && (bool2) && (!bool3)) {
      return;
    }
    localObject = ((MessageParser)localObject).getSource(paramMessage);
    paramBundle.putSerializable(MessageSource.NAME, (Serializable)localObject);
    c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.i
 * JD-Core Version:    0.7.0.1
 */