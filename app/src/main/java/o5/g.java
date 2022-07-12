package o5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class g
  extends i
{
  private static final Executor c = ;
  
  public void b(Message paramMessage, Bundle paramBundle)
  {
    c.execute(new f(this, paramMessage, paramBundle));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.g
 * JD-Core Version:    0.7.0.1
 */