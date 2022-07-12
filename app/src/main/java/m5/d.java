package m5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class d
  extends e
{
  private static final Executor b = ;
  
  public void b(Message paramMessage, Bundle paramBundle)
  {
    b.execute(new c(this, paramMessage, paramBundle));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.d
 * JD-Core Version:    0.7.0.1
 */