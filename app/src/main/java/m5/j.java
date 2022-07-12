package m5;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;

public class j
  extends e
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ATTR_LAST_OFFLINE_MESSAGE", false))
    {
      HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_LIST"));
      HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RECENT_ENABLE_LISTENER"));
    }
    super.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.j
 * JD-Core Version:    0.7.0.1
 */