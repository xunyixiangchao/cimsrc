package n5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import j5.b;
import m5.e;

public class d
  extends e
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (paramBundle.getInt("ATTR_ACTION", 0) == 1) {
      b.a(paramMessage);
    }
    if (paramBundle.getInt("ATTR_ACTION", 0) == 0) {
      b.E(paramMessage);
    }
    if (paramBundle.getInt("ATTR_ACTION", 0) == -1) {
      b.d(paramMessage.id);
    }
    super.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n5.d
 * JD-Core Version:    0.7.0.1
 */