package o5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import s3.f0;

public abstract class i
{
  private i a;
  f0 b = h.a;
  
  public abstract void b(Message paramMessage, Bundle paramBundle);
  
  public void d(Message paramMessage, Bundle paramBundle)
  {
    i locali = this.a;
    if (locali != null) {
      locali.b(paramMessage, paramBundle);
    }
  }
  
  public void e(i parami)
  {
    this.a = parami;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.i
 * JD-Core Version:    0.7.0.1
 */