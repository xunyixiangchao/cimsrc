package m5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;

public abstract class e
{
  private e a;
  
  public e a()
  {
    return this.a;
  }
  
  public abstract void b(Message paramMessage, Bundle paramBundle);
  
  public void c(Message paramMessage, Bundle paramBundle)
  {
    e locale = this.a;
    if (locale != null) {
      locale.b(paramMessage, paramBundle);
    }
  }
  
  public void d(e parame)
  {
    this.a = parame;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.e
 * JD-Core Version:    0.7.0.1
 */