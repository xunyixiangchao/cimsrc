package o5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import n5.b;

public class a
  extends i
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ATTR_HANDLE_FAILURE"))
    {
      paramMessage.state = Byte.valueOf((byte)2);
      b.d(paramMessage);
    }
    super.d(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.a
 * JD-Core Version:    0.7.0.1
 */