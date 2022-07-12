package m5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import u3.m0;

public class b
  extends e
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    m0.b(new a((ChatSession)paramBundle.getSerializable("ATTR_CHAT_SESSION"), paramMessage));
    super.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.b
 * JD-Core Version:    0.7.0.1
 */