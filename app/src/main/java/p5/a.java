package p5;

import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatFile;
import com.farsunset.hoxin.message.model.ChatMap;
import com.farsunset.hoxin.message.model.ChatVoice;
import com.farsunset.hoxin.message.model.ForwardResult;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import l3.e;
import o5.i;
import u3.l;

public class a
  extends i
{
  private static final Map<Integer, String> c;
  
  static
  {
    ArrayMap localArrayMap = new ArrayMap();
    c = localArrayMap;
    localArrayMap.put(Integer.valueOf(2), "3");
    localArrayMap.put(Integer.valueOf(1), "0");
  }
  
  private void f(Message paramMessage, Bundle paramBundle)
  {
    if (!i5.b.e.contains(Byte.valueOf(paramMessage.format))) {
      return;
    }
    if (!paramBundle.getBoolean("ATTR_FROM_FORWARD")) {
      return;
    }
    int i = paramMessage.format;
    if (i == 3)
    {
      paramMessage = (CloudVideo)l.s0(paramMessage.content, CloudVideo.class);
      e.b(paramMessage.bucket, paramMessage.video);
      paramBundle = paramMessage.bucket;
      paramMessage = paramMessage.image;
    }
    for (;;)
    {
      e.b(paramBundle, paramMessage);
      return;
      if (i == 1)
      {
        paramMessage = (CloudImage)l.s0(paramMessage.content, CloudImage.class);
        e.b(paramMessage.bucket, paramMessage.image);
        if (!Objects.equals(paramMessage.image, paramMessage.thumb)) {
          e.b(paramMessage.bucket, paramMessage.thumb);
        }
        return;
      }
      if (i == 5)
      {
        paramMessage = (ChatMap)l.s0(paramMessage.content, ChatMap.class);
        paramBundle = o3.b.f.a();
        paramMessage = paramMessage.image;
      }
      else
      {
        if (i != 4) {
          break;
        }
        paramMessage = (ChatFile)l.s0(paramMessage.content, ChatFile.class);
        paramBundle = o3.b.f.a();
        paramMessage = paramMessage.file;
      }
    }
    if (i == 2)
    {
      paramMessage = (ChatVoice)l.s0(paramMessage.content, ChatVoice.class);
      e.b(o3.b.f.a(), paramMessage.file);
    }
  }
  
  private void g()
  {
    HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_MESSAGE_FORWARD_ERROR"));
  }
  
  private void h()
  {
    HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_LIST"));
    HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_MESSAGE_FORWARD_FINISH"));
  }
  
  private void i(Message paramMessage, Bundle paramBundle)
  {
    paramMessage.state = Byte.valueOf((byte)4);
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
  }
  
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ATTR_HANDLE_FAILURE"))
    {
      g();
      return;
    }
    Object localObject1 = (List)paramBundle.getSerializable("ATTR_LIST");
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ChatSession localChatSession = (ChatSession)((Iterator)localObject2).next();
      localChatSession.action = ((String)c.get(Integer.valueOf(localChatSession.sourceType)));
    }
    localObject1 = f5.a.b(paramMessage, (List)localObject1);
    if (localObject1 == null)
    {
      g();
      return;
    }
    i(paramMessage, paramBundle);
    localObject1 = ((g5.a)localObject1).a().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ForwardResult)((Iterator)localObject1).next();
      if (((ForwardResult)localObject2).getMid() != null)
      {
        paramMessage.receiver = Long.valueOf(((ForwardResult)localObject2).getId());
        paramMessage.id = ((ForwardResult)localObject2).getMid().longValue();
        paramMessage.action = ((ForwardResult)localObject2).getAction();
        paramMessage.createTime = Long.valueOf(((ForwardResult)localObject2).getTimestamp());
        n5.b.a(paramMessage, false);
      }
    }
    h();
    f(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p5.a
 * JD-Core Version:    0.7.0.1
 */