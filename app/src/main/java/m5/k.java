package m5;

import android.os.Bundle;
import u3.l0;

public class k
{
  private static final k b = new k();
  private final e a;
  
  private k()
  {
    d locald = new d();
    this.a = locald;
    n localn = new n();
    l locall = new l();
    j localj = new j();
    f localf = new f();
    m localm = new m();
    b localb = new b();
    i locali = new i();
    g localg = new g();
    h localh = new h();
    locald.d(localn);
    localn.d(locall);
    locall.d(localj);
    localj.d(localf);
    localf.d(localm);
    localm.d(localb);
    localb.d(locali);
    locali.d(localg);
    localg.d(localh);
  }
  
  public static void a(Bundle paramBundle, com.farsunset.cim.sdk.android.model.Message paramMessage)
  {
    if (paramMessage.getReceiver() == null) {
      paramMessage.setReceiver(i3.e.o().toString());
    }
    b(paramBundle, l0.c(paramMessage));
  }
  
  public static void b(Bundle paramBundle, com.farsunset.hoxin.message.entity.Message paramMessage)
  {
    b.a.b(paramMessage, paramBundle);
  }
  
  public static void c(com.farsunset.hoxin.message.entity.Message paramMessage)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("ATTR_FROM_OFFLINE", true);
    b(localBundle, paramMessage);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.k
 * JD-Core Version:    0.7.0.1
 */