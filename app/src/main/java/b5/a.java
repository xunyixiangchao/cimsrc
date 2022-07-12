package b5;

import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a<T extends RecyclerView.c0>
  extends RecyclerView.h<T>
  implements r5.e
{
  final List<Object> d = new ArrayList();
  final User e = i3.e.g();
  final ChatSession f;
  
  a(ChatSession paramChatSession)
  {
    this.f = paramChatSession;
  }
  
  public void I(List<Message> paramList)
  {
    Collections.sort(paramList, new c5.a());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Message localMessage = (Message)localIterator.next();
      if (localArrayList.isEmpty()) {}
      long l2;
      for (paramList = localMessage.createTime;; paramList = Long.valueOf(l2))
      {
        localArrayList.add(paramList);
        long l1;
        do
        {
          localArrayList.add(localMessage);
          break;
          l1 = ((Message)localArrayList.get(localArrayList.size() - 1)).createTime.longValue();
          l2 = localMessage.createTime.longValue();
        } while (l2 - l1 < 120000L);
      }
    }
    this.d.addAll(0, localArrayList);
    s(0, localArrayList.size());
  }
  
  public void J(Message paramMessage)
  {
    if (this.d.isEmpty())
    {
      this.d.add(paramMessage.createTime);
      this.d.add(paramMessage);
      s(0, 2);
      return;
    }
    List localList = this.d;
    long l1 = ((Message)localList.get(localList.size() - 1)).createTime.longValue();
    long l2 = paramMessage.createTime.longValue();
    if (l2 - l1 >= 120000L)
    {
      this.d.add(Long.valueOf(l2));
      this.d.add(paramMessage);
      s(this.d.size() - 2, 2);
      return;
    }
    this.d.add(paramMessage);
    p(this.d.size() - 1);
  }
  
  public Object K(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public int L()
  {
    Iterator localIterator = this.d.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof Message)) {
        i += 1;
      }
    }
    return i;
  }
  
  public int M(Message paramMessage)
  {
    return this.d.indexOf(paramMessage);
  }
  
  protected abstract void N(T paramT, long paramLong);
  
  protected abstract void O(T paramT, Message paramMessage);
  
  public void P(long paramLong)
  {
    Message localMessage = new Message();
    localMessage.id = paramLong;
    int i = this.d.indexOf(localMessage);
    if (i < 0) {
      return;
    }
    localMessage = j5.b.o(paramLong);
    this.d.set(i, localMessage);
    k(i);
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public long e(int paramInt)
  {
    return K(paramInt).hashCode();
  }
  
  public void m(Message paramMessage)
  {
    n5.b.b(paramMessage);
    int i = this.d.indexOf(paramMessage);
    if (i > 0)
    {
      paramMessage = this.d;
      int j = i - 1;
      if ((paramMessage.get(j) instanceof Long))
      {
        this.d.remove(i);
        this.d.remove(j);
        u(i);
        u(j);
        break label92;
      }
    }
    this.d.remove(i);
    u(i);
    label92:
    if ((!this.d.isEmpty()) && ((this.d.get(0) instanceof Message)))
    {
      paramMessage = (Message)this.d.get(0);
      this.d.add(0, paramMessage.createTime);
      p(0);
    }
  }
  
  public void w(T paramT, int paramInt)
  {
    Object localObject = this.d.get(paramInt);
    if ((localObject instanceof Long))
    {
      N(paramT, ((Long)localObject).longValue());
      return;
    }
    O(paramT, (Message)localObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b5.a
 * JD-Core Version:    0.7.0.1
 */