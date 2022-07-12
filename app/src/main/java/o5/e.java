package o5;

import android.os.Bundle;
import com.farsunset.hoxin.common.model.FileResource;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatMap;
import java.io.IOException;
import o3.b;
import u3.a0;
import u3.c0;
import u3.l;

public class e
  extends i
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (!paramMessage.isMapFormat())
    {
      super.d(paramMessage, paramBundle);
      return;
    }
    Object localObject2 = (ChatMap)l.s0(paramMessage.content, ChatMap.class);
    Object localObject1 = b.f;
    localObject2 = ((ChatMap)localObject2).image;
    localObject1 = FileResource.of((b)localObject1, (String)localObject2, a0.g((String)localObject2));
    try
    {
      c0.g((FileResource)localObject1, this.b);
    }
    catch (IOException localIOException)
    {
      label62:
      break label62;
    }
    paramBundle.putBoolean("ATTR_HANDLE_FAILURE", true);
    super.d(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.e
 * JD-Core Version:    0.7.0.1
 */