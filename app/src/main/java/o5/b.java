package o5;

import android.net.Uri;
import android.os.Bundle;
import com.farsunset.hoxin.common.model.FileResource;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatFile;
import u3.c0;
import u3.l;

public class b
  extends i
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (!paramMessage.isFileFormat())
    {
      super.d(paramMessage, paramBundle);
      return;
    }
    ChatFile localChatFile = (ChatFile)l.s0(paramMessage.content, ChatFile.class);
    paramBundle.putString("ATTR_URI", localChatFile.uri);
    try
    {
      c0.g(FileResource.of(o3.b.f, localChatFile.file, Uri.parse(localChatFile.uri)), this.b);
      paramMessage.content = l.H0(localChatFile);
    }
    catch (Exception localException)
    {
      label72:
      break label72;
    }
    paramBundle.putBoolean("ATTR_HANDLE_FAILURE", true);
    super.d(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.b
 * JD-Core Version:    0.7.0.1
 */