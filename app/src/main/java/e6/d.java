package e6;

import android.os.Bundle;
import com.farsunset.hoxin.moment.entity.Moment;

abstract class d
{
  private d a;
  
  public abstract void a(Moment paramMoment, Bundle paramBundle);
  
  public void b(Moment paramMoment, Bundle paramBundle)
  {
    d locald = this.a;
    if (locald != null) {
      locald.a(paramMoment, paramBundle);
    }
  }
  
  void c(d paramd)
  {
    this.a = paramd;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e6.d
 * JD-Core Version:    0.7.0.1
 */