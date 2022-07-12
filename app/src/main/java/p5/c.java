package p5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import java.util.ArrayList;
import o5.b;
import o5.d;
import o5.g;
import o5.i;
import o5.n;

public class c
{
  private static final c b = new c();
  private final i a;
  
  private c()
  {
    g localg = new g();
    this.a = localg;
    d locald = new d();
    n localn = new n();
    b localb = new b();
    a locala = new a();
    localg.e(locald);
    locald.e(localn);
    localn.e(localb);
    localb.e(locala);
  }
  
  public static void a(Message paramMessage, ArrayList<ChatSession> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("ATTR_LIST", paramArrayList);
    b.a.b(paramMessage, localBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p5.c
 * JD-Core Version:    0.7.0.1
 */