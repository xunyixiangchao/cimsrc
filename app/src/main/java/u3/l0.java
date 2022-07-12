package u3;

import android.app.Application;
import android.text.TextUtils;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MapAddress;
import com.farsunset.hoxin.message.model.ChatEmoticon;
import com.farsunset.hoxin.message.model.ChatFile;
import com.farsunset.hoxin.message.model.ChatLink;
import com.farsunset.hoxin.message.model.ChatMap;
import com.farsunset.hoxin.message.model.ChatProfile;
import i3.e;
import p4.b;

public class l0
{
  public static com.farsunset.hoxin.message.entity.Message a(com.farsunset.hoxin.message.entity.Message paramMessage)
  {
    com.farsunset.hoxin.message.entity.Message localMessage = new com.farsunset.hoxin.message.entity.Message();
    localMessage.content = paramMessage.content;
    localMessage.title = paramMessage.title;
    localMessage.format = paramMessage.format;
    localMessage.receiver = paramMessage.receiver;
    localMessage.sender = paramMessage.sender;
    localMessage.action = paramMessage.action;
    localMessage.id = paramMessage.id;
    localMessage.extra = paramMessage.extra;
    localMessage.createTime = paramMessage.createTime;
    localMessage.state = paramMessage.state;
    localMessage.sessionId = paramMessage.sessionId;
    return localMessage;
  }
  
  public static String b(com.farsunset.hoxin.message.entity.Message paramMessage)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramMessage.direction == 1) {}
    for (Object localObject = e.k(paramMessage.sender.longValue());; localObject = b.l(Long.valueOf(paramMessage.sender.longValue()), Long.valueOf(Long.parseLong(paramMessage.extra))))
    {
      localStringBuffer.append((String)localObject);
      localStringBuffer.append(":  ");
      break;
      if (!paramMessage.action.equals("3")) {
        break;
      }
    }
    if (1 == paramMessage.format) {
      localStringBuffer.append(HoxinApplication.h().getString(2131689762));
    }
    if (6 == paramMessage.format)
    {
      localObject = (ChatLink)l.s0(paramMessage.content, ChatLink.class);
      localStringBuffer.append(HoxinApplication.h().getString(2131689763, new Object[] { ((ChatLink)localObject).title }));
    }
    if (4 == paramMessage.format)
    {
      localObject = (ChatFile)l.s0(paramMessage.content, ChatFile.class);
      localStringBuffer.append(HoxinApplication.h().getString(2131689761, new Object[] { ((ChatFile)localObject).name }));
    }
    if (2 == paramMessage.format) {
      localStringBuffer.append(HoxinApplication.h().getString(2131689771));
    }
    if (5 == paramMessage.format)
    {
      localObject = (ChatMap)l.s0(paramMessage.content, ChatMap.class);
      localStringBuffer.append(HoxinApplication.h().getString(2131689764, new Object[] { ((MapAddress)localObject).name }));
    }
    if (3 == paramMessage.format) {
      localStringBuffer.append(HoxinApplication.h().getString(2131689770));
    }
    if (14 == paramMessage.format)
    {
      localObject = (ChatProfile)l.s0(paramMessage.content, ChatProfile.class);
      localStringBuffer.append(HoxinApplication.h().getString(2131689767, new Object[] { ((ChatProfile)localObject).name }));
    }
    if (18 == paramMessage.format)
    {
      localObject = (ChatProfile)l.s0(paramMessage.content, ChatProfile.class);
      localStringBuffer.append(HoxinApplication.h().getString(2131689765, new Object[] { ((ChatProfile)localObject).name }));
    }
    if (15 == paramMessage.format)
    {
      localObject = (ChatEmoticon)l.s0(paramMessage.content, ChatEmoticon.class);
      localStringBuffer.append(HoxinApplication.h().getString(2131689760, new Object[] { ((ChatEmoticon)localObject).name }));
    }
    if (paramMessage.format == 0) {
      localStringBuffer.append(paramMessage.content);
    }
    return localStringBuffer.toString();
  }
  
  public static com.farsunset.hoxin.message.entity.Message c(com.farsunset.cim.sdk.android.model.Message paramMessage)
  {
    com.farsunset.hoxin.message.entity.Message localMessage = new com.farsunset.hoxin.message.entity.Message();
    localMessage.content = paramMessage.getContent();
    localMessage.title = paramMessage.getTitle();
    byte b;
    if (TextUtils.isEmpty(paramMessage.getFormat())) {
      b = 0;
    } else {
      b = Byte.parseByte(paramMessage.getFormat());
    }
    localMessage.format = b;
    localMessage.receiver = Long.valueOf(Long.parseLong(paramMessage.getReceiver()));
    localMessage.sender = Long.valueOf(Long.parseLong(paramMessage.getSender()));
    localMessage.action = paramMessage.getAction();
    localMessage.extra = paramMessage.getExtra();
    localMessage.id = paramMessage.getId();
    localMessage.createTime = Long.valueOf(paramMessage.getTimestamp());
    localMessage.state = Byte.valueOf((byte)10);
    return localMessage;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.l0
 * JD-Core Version:    0.7.0.1
 */