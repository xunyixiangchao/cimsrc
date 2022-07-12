package m5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import java.util.List;

public class l
  extends e
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    c(paramMessage, paramBundle);
    if (paramBundle.getBoolean("ATTR_FROM_OFFLINE", false)) {
      return;
    }
    if (i5.a.e.contains(paramMessage.action)) {
      return;
    }
    f5.a.e(paramMessage);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.l
 * JD-Core Version:    0.7.0.1
 */