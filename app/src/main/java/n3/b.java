package n3;

import android.net.NetworkInfo;
import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.SentBody;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import java.util.List;

public abstract interface b
{
  public abstract void H(ChatSession paramChatSession, Message paramMessage);
  
  public abstract void a();
  
  public abstract void b(SentBody paramSentBody);
  
  public abstract void f(NetworkInfo paramNetworkInfo);
  
  public abstract void g(ReplyBody paramReplyBody);
  
  public abstract void h(boolean paramBoolean);
  
  public abstract void i();
  
  public abstract List<String> r0();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n3.b
 * JD-Core Version:    0.7.0.1
 */