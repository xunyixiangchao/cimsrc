package t3;

import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.SentBody;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import n3.b;
import n3.c;

public abstract class a
  extends Fragment
  implements b
{
  public void H(ChatSession paramChatSession, Message paramMessage)
  {
    if (paramChatSession == null) {
      j(paramMessage);
    }
  }
  
  public void a() {}
  
  public void b(SentBody paramSentBody) {}
  
  protected View e(int paramInt)
  {
    return getView().findViewById(paramInt);
  }
  
  public void f(NetworkInfo paramNetworkInfo) {}
  
  public void g(ReplyBody paramReplyBody) {}
  
  public void h(boolean paramBoolean) {}
  
  public void i() {}
  
  public void j(Message paramMessage) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c.h(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c.i(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t3.a
 * JD-Core Version:    0.7.0.1
 */