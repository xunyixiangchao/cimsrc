package o5;

import android.os.Bundle;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatFile;
import u3.l;

public class c
  extends i
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    long l = paramBundle.getLong("ATTR_MESSAGE_ID", -1L);
    if (paramBundle.getBoolean("ATTR_HANDLE_FAILURE"))
    {
      super.d(paramMessage, paramBundle);
      return;
    }
    Object localObject;
    if (paramMessage.isImageFormat())
    {
      localObject = (CloudImage)l.s0(paramMessage.content, CloudImage.class);
      ((CloudImage)localObject).uri = paramBundle.getString("ATTR_URI");
      paramMessage.content = l.H0(localObject);
    }
    if (paramMessage.isFileFormat())
    {
      localObject = (ChatFile)l.s0(paramMessage.content, ChatFile.class);
      ((ChatFile)localObject).uri = paramBundle.getString("ATTR_URI");
      paramMessage.content = l.H0(localObject);
    }
    if (paramMessage.isVideoFormat())
    {
      localObject = (CloudVideo)l.s0(paramMessage.content, CloudVideo.class);
      ((CloudVideo)localObject).uri = paramBundle.getString("ATTR_URI");
      paramMessage.content = l.H0(localObject);
    }
    paramMessage.state = Byte.valueOf((byte)4);
    j5.b.d(paramMessage.id);
    paramMessage.id = l;
    paramMessage.createTime = Long.valueOf(paramBundle.getLong("ATTR_MESSAGE_TIMESTAMP", -1L));
    n5.b.a(paramMessage, false);
    super.d(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.c
 * JD-Core Version:    0.7.0.1
 */