package c5;

import com.farsunset.hoxin.message.entity.Message;
import java.io.Serializable;
import java.util.Comparator;

public class a
  implements Comparator<Message>, Serializable
{
  public int a(Message paramMessage1, Message paramMessage2)
  {
    return Long.compare(paramMessage1.createTime.longValue(), paramMessage2.createTime.longValue());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c5.a
 * JD-Core Version:    0.7.0.1
 */