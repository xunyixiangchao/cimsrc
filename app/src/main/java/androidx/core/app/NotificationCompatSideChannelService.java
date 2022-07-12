package androidx.core.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public abstract class NotificationCompatSideChannelService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL");
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.NotificationCompatSideChannelService
 * JD-Core Version:    0.7.0.1
 */