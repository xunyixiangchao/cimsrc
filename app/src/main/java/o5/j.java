package o5;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.function.parser.MessageParser;
import com.farsunset.hoxin.message.function.parser.MessageParserFactory;
import j5.a;
import j5.b;
import java.io.Serializable;

public class j
  extends i
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (!b.j(paramMessage.id)) {
      return;
    }
    Object localObject = MessageParserFactory.getMessageParser(paramMessage.action).getSource(paramMessage);
    localObject = a.l(((MessageSource)localObject).getId().longValue(), ((MessageSource)localObject).getType());
    Intent localIntent = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_CHAT");
    localIntent.putExtra("ATTR_CHAT_SESSION", (Serializable)localObject);
    HoxinApplication.t(localIntent);
    localObject = new Intent("com.farsunset.hoxin.ACTION_WINDOW_REFRESH_MESSAGE");
    ((Intent)localObject).putExtra(Message.NAME, paramMessage);
    ((Intent)localObject).putExtra("ATTR_CODE", paramBundle.getInt("ATTR_CODE", -1));
    HoxinApplication.t((Intent)localObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.j
 * JD-Core Version:    0.7.0.1
 */