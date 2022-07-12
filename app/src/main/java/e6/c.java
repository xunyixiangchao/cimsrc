package e6;

import android.os.Bundle;
import com.farsunset.hoxin.moment.entity.Moment;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class c
  extends d
{
  private static final Executor b = ;
  
  public void a(Moment paramMoment, Bundle paramBundle)
  {
    b.execute(new b(this, paramMoment, paramBundle));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e6.c
 * JD-Core Version:    0.7.0.1
 */