package p5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import java.util.ArrayList;
import o5.g;
import o5.i;

public class b
{
  private static final b b = new b();
  private final i a;
  
  private b()
  {
    g localg = new g();
    this.a = localg;
    localg.e(new a());
  }
  
  public static void a(Message paramMessage, ArrayList<ChatSession> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("ATTR_LIST", paramArrayList);
    localBundle.putBoolean("ATTR_FROM_FORWARD", true);
    b.a.b(paramMessage, localBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p5.b
 * JD-Core Version:    0.7.0.1
 */