package o5;

import android.os.Bundle;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.group.api.request.GroupMessageRequest;
import com.farsunset.hoxin.message.api.request.MessageRequest;
import com.farsunset.hoxin.message.entity.Message;
import ea.t;
import h5.a;
import java.io.IOException;

public class k
  extends i
{
  private LongResult f(Message paramMessage)
  {
    a locala = (a)l3.b.a(a.class);
    Object localObject;
    if ("0".equals(paramMessage.action))
    {
      localObject = new MessageRequest();
      ((MessageRequest)localObject).setContent(paramMessage.content);
      ((MessageRequest)localObject).setExtra(paramMessage.extra);
      ((MessageRequest)localObject).setTitle(paramMessage.title);
      ((MessageRequest)localObject).setFormat(Byte.valueOf(paramMessage.format));
      ((MessageRequest)localObject).setUid(paramMessage.receiver);
    }
    for (paramMessage = locala.f((MessageRequest)localObject);; paramMessage = locala.a((GroupMessageRequest)localObject))
    {
      return (LongResult)paramMessage.g().a();
      localObject = new GroupMessageRequest();
      ((GroupMessageRequest)localObject).setContent(paramMessage.content);
      ((GroupMessageRequest)localObject).setExtra(paramMessage.extra);
      ((GroupMessageRequest)localObject).setTitle(paramMessage.title);
      ((GroupMessageRequest)localObject).setFormat(Byte.valueOf(paramMessage.format));
      ((GroupMessageRequest)localObject).setGroupId(paramMessage.receiver);
    }
  }
  
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ATTR_HANDLE_FAILURE"))
    {
      super.d(paramMessage, paramBundle);
      return;
    }
    try
    {
      LongResult localLongResult = f(paramMessage);
      if ((localLongResult != null) && (localLongResult.isSuccess()))
      {
        paramBundle.putInt("ATTR_CODE", localLongResult.code);
        paramBundle.putLong("ATTR_MESSAGE_ID", localLongResult.data.longValue());
        paramBundle.putLong("ATTR_MESSAGE_TIMESTAMP", localLongResult.timestamp);
      }
      else
      {
        paramBundle.putBoolean("ATTR_HANDLE_FAILURE", true);
      }
    }
    catch (IOException localIOException)
    {
      label82:
      break label82;
    }
    paramBundle.putBoolean("ATTR_HANDLE_FAILURE", true);
    super.d(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.k
 * JD-Core Version:    0.7.0.1
 */