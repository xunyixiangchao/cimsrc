package m5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import i5.a;
import java.util.List;
import u3.l;

public class n
  extends e
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ATTR_FROM_OFFLINE", false)) {
      paramMessage.state = Byte.valueOf((byte)10);
    }
    if ("3".equals(paramMessage.action))
    {
      long l = Long.parseLong(paramMessage.extra);
      if (!p4.b.f(Long.valueOf(paramMessage.sender.longValue()), Long.valueOf(l))) {
        return;
      }
    }
    if (paramMessage.format == 0) {
      paramMessage.content = l.W(paramMessage.content);
    }
    if (!a.e.contains(paramMessage.action)) {
      j5.b.a(paramMessage);
    }
    super.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.n
 * JD-Core Version:    0.7.0.1
 */