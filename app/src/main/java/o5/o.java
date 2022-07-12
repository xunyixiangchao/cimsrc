package o5;

import android.os.Bundle;
import com.farsunset.hoxin.common.model.FileResource;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatVoice;
import o3.b;
import u3.a0;
import u3.c0;
import u3.l;

public class o
  extends i
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (!paramMessage.isVoiceFormat())
    {
      super.d(paramMessage, paramBundle);
      return;
    }
    Object localObject = (ChatVoice)l.s0(paramMessage.content, ChatVoice.class);
    try
    {
      b localb = b.f;
      localObject = ((ChatVoice)localObject).file;
      c0.g(FileResource.of(localb, (String)localObject, a0.g((String)localObject)), this.b);
    }
    catch (Exception localException)
    {
      label60:
      break label60;
    }
    paramBundle.putBoolean("ATTR_HANDLE_FAILURE", true);
    super.d(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.o
 * JD-Core Version:    0.7.0.1
 */